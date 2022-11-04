package com.android.myfirstappincomopose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.myfirstappincomopose.ui.theme.MyFirstAppInComoposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // It is a composable function
            ErrorMessage("This is an error message")
        }
    }
}

//Naming : Name your composable functions with a capital letter(PascalCase)
//Public : Make your composable functions public
//To make compiler know that function will render ui on screen
@Composable //To use this function in the UI, we need to annotate it with @Composable
fun ErrorMessage(error: String) { //return type is not required
    Text(text = error)
}

//Declarative Paradigm : Describe UI in screen
//Imperative Paradigm : XML (views)
//Compose is declarative
//Compose is a declarative UI toolkit for building native Android UI
//There aren't getters and setters in Compose
//If data changes, UI will be updated automatically again (regenerate UI)
//There aren't any state in Compose
//We are Handling states in Compose in a different way
//In compose we don't use inheritance
//we follow composition