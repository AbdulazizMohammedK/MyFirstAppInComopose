package com.android.myfirstappincomopose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    // AppCompactActivity extends ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContent that renders the UI
        //instead of setContentView
        //setContent is a function that takes composable function as a parameter
        setContent { // It is a composable function

        }
    }
}


/* Compose Building Blocks
*
* */
//@Preview(showBackground = true)
@Composable
fun MyText(text: String) {
    Text(text = text, textAlign = TextAlign.Start,
        // I can use all the properties of Text without style
        style = TextStyle(fontSize = 20.sp,
            color = Red,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center),
        maxLines = 2
    )
}

@Composable
fun MyTitle() {
    Text(text = "Aziz",
        style = TextStyle(fontSize = 30.sp,
            color = Red,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            ),
        maxLines = 2,
    )
}

//@Preview("MyText", showBackground = true, showSystemUi = true,
//backgroundColor = 0xFF00FF00)
@Composable
fun MyButton() {
    //we should make values observable to be able to change ui
    //remember that allow compiler observe mutableStateOf
    // we use by to access value without using .value
    var isClicked by remember { mutableStateOf(false) }
    Button(onClick = { isClicked = false },
        colors = ButtonDefaults.buttonColors(backgroundColor = Red,
            contentColor = White,
            disabledBackgroundColor = LightGray),
        enabled = isClicked) {
        Text(text = if (isClicked) "Click Me" else "Clicked")
    }
}

@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var searchText by remember { mutableStateOf("") }
    TextField(value = searchText, onValueChange = {
        searchText = it
    }, label = { Text(text = searchText) })
}

//@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "This is an image")
}


@Composable
fun MyColumn() {
    Column {

    }
}

@Preview(showBackground = true)
@Composable
fun ChatItem() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        MyImage()
        Column(horizontalAlignment = Alignment.Start) {
            MyTitle()
            MyText(text = "Where are you today? Are you good?")
        }
    }
}
//https://github.com/Felix-Kariuki/Yummy.git

//life cycle of composable function
//Recomposition happens data changes
//A composable leave the composition when it's no longer on the screen
@Composable
fun ScoreSection(
    score: Int,
    countCallBack: () -> Unit,
) {
    Column {
        Text("Score: $score")
        Button(onClick = countCallBack) {
            Text("Increase Score")
        }
    }
}

//Naming : Name your composable functions with a capital letter(PascalCase)
//Public : Make your composable functions public
//To make compiler know that function will render ui on screen
@Composable //To use this function in the UI, we need to annotate it with @Composable
fun ErrorMessage(error: String = "Error") { //return type is not required
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