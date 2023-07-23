package com.example.loginscreen1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreen1.ui.theme.Green100
import com.example.loginscreen1.ui.theme.LoginScreen1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen1Theme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen(){

    var userName = remember { mutableStateOf("")}
    var password = remember { mutableStateOf("")}

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        //special textfield to input username
        SpecialTextField("Kullanıcı Adı", userName.value){
            userName.value = it
        }

        Spacer(modifier = Modifier.padding(5.dp))

        //special textfield to input password
        SpecialTextField("Şifre", password.value){
            password.value = it
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Row {
            //special button to sign in
            SpecialButtonSignIn()

            Spacer(modifier = Modifier.padding(15.dp))

            //special button to sign up
            SpecialButtonSignUp()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpecialTextField(specialPlaceholder: String, myString: String,
                     function: (String) -> Unit){
    Surface(color = Color.White) {
        TextField(
            value = myString,
            onValueChange = function,
            modifier = Modifier.padding(5.dp),
            label = { Text(text = specialPlaceholder)}
        )
    }
}

@Composable
fun SpecialButtonSignIn(){
    Button(
        onClick = {
            println("clicked button: sign in")},
        shape = ButtonDefaults.shape,
    ) {
        Text(text = "Giriş Yap")
    }
}

@Composable
fun SpecialButtonSignUp(){
    Button(
        onClick = {
            println("clicked button: sign up")},
        shape = ButtonDefaults.shape,
    ) {
        Text(text = "Üye Ol")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginScreen1Theme {
        LoginScreen()
    }
}