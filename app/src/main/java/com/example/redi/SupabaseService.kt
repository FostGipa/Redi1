package com.example.redi

import android.content.Context
import android.content.SharedPreferences
import android.net.Credentials
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.serializer.KotlinXSerializer
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class SupabaseService : ViewModel() {

    private val supabase = createSupabaseClient(
        supabaseUrl = "https://hdtvshzthjumolpznmnn.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImhkdHZzaHp0aGp1bW9scHpubW5uIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDY2MzA3NTYsImV4cCI6MjAyMjIwNjc1Nn0.eOQTPc1CS_kiUXZ2ctksBm2gBS9cA7ob8eRaLOldv1E"
    ) {
        install(Auth) {
            alwaysAutoRefresh = false
        }
        install(Postgrest)
        defaultSerializer = KotlinXSerializer(Json)
    }

    fun signup(context: Context, userEmail : String, userPassword: String, first_name : String, last_name : String, phone : String, image : String) {
        viewModelScope.launch {

            try {
                val sharedPref : SharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)
                sharedPref.edit().putString("email", userEmail).apply()

                supabase.auth.signUpWith(Email) {
                    email = userEmail
                    password = userPassword
                }

                val user = mapOf(
                    "first_name" to first_name,
                    "last_name" to last_name,
                    "phone" to phone,
                    "email" to userEmail,
                    "image" to image
                )
                supabase.from("users").insert(user)
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }

        }
    }

    fun signin(userEmail : String, userPassword: String) {
        viewModelScope.launch {
            supabase.auth.signInWith(Email) {
                email = userEmail
                password = userPassword
            }
        }
    }

    @Serializable
    data class UserTable (
        @SerialName("id")
        val id : Int,
        @SerialName("first_name")
        val first_name : String,
        @SerialName("last_name")
        val last_name : String,
        @SerialName("phone")
        val phone : String,
        @SerialName("email")
        val email : String,
        @SerialName("image")
        val image : String
    )

    fun getName(context : Context) {
        viewModelScope.launch {
            val sharedPref : SharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)
            val email = sharedPref.getString("email", "").toString()
            val users = supabase.from("users").select(columns = Columns.list("first_name")) {
                filter {
                    eq("email", email)
                }
            }.decodeList<UserTable>()
        }
    }
}
