package com.example.codelab_diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.codelab_diceroller.ui.theme.CodeLabDiceRollerTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeLabDiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DiceRollerApp(){
         DiceWithButtonAndImage(modifier = Modifier
             .fillMaxSize()
             .wrapContentSize(Alignment.Center)

         )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(1) }
    val imageresorce = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val diceNumber = when(result){
        1 -> R.string.one
        2 -> R.string.two
        3 -> R.string.three
        4 -> R.string.four
        5 -> R.string.five
        else -> R.string.six
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = imageresorce),
            "1")
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = stringResource(id = diceNumber))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random()}) {
            Text(stringResource(R.string.Roll))
        }
      }
}