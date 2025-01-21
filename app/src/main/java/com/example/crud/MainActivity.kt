package com.example.crud

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crud.ui.theme.CrudTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppContent()
        }
    }
}

@Preview
@Composable
fun AppContent() {
    CrudTheme {
        Scaffold(
            topBar ={ToolBar()},
            floatingActionButton = { FAB() },
            floatingActionButtonPosition = FabPosition.End,
            modifier = Modifier.fillMaxSize()) { innerPadding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                item {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "logo cabecera"
                    )

                    Text(
                        text = "Bienvenido!",
                        fontSize = 30.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                }

                // Muestra la lista de nombres dentro de este LazyColumn
                item {
                    NameList()
                }

                // Evitar la repetición innecesaria de Greeting
                items(3) {
                    Greeting(name = "Android", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(){
    TopAppBar(
        title = { Text(text = "Bienvenido")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.background),
            titleContentColor = Color.White
        ),
    )

}

@Composable
fun FAB(){
    val context = LocalContext.current

    FloatingActionButton(onClick = {

        Toast.makeText(context, "Hola!", Toast.LENGTH_SHORT).show()

    }) {
        Text(text = "x")
    }
}

@Composable
fun NameList() {
    val names = listOf("Carlos", "Ana", "Juan", "Maria", "Pedro")
    names.forEach { name ->
        Text(
            text = name,
            fontSize = 30.sp,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun GreetingPreview() {
    CrudTheme {
        Greeting("Android")
    }
}