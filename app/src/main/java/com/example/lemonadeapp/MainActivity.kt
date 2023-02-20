package com.example.lemonadeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.R.drawable
import com.example.lemonadeapp.R.string
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeAppButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeAppButtonAndImage(
    modifier: Modifier = Modifier

) {
    var step by remember {
        mutableStateOf(1)
    }
    var stepCurrent by remember {
        mutableStateOf(0)
    }

    when (step) {
        1 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = string.der),
                fontSize = 16.sp,

                )
            Spacer(modifier = Modifier.height(24.dp))
            Image(painter = painterResource(drawable.lemon_tree),
                contentDescription = step.toString(),
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        step = 2
                        stepCurrent = (2..5).random()
                    })

        }
        2 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = string.lemon))
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(drawable.lemon_squeeze),
                contentDescription = step.toString(),
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        stepCurrent--
                        if (stepCurrent == 0) {
                            step = 3
                            Log.d("1", "Кол-во нажатия: $step")
                        }

                    })


        }
        3 -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = string.stl))
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(drawable.lemon_drink),
                contentDescription = step.toString(),
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { step = 4 })


        }
        else -> Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = string.pust))
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(drawable.lemon_restart),
                contentDescription = step.toString(),
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { step = 1 })


        }
    }


}

