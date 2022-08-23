package com.example.guitarapplication

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.guitarapplication.ui.theme.GuitarApplicationTheme
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.*
import com.example.guitarapplication.Logic.Util

class MainActivity : ComponentActivity() {
    var mediaPlayerList = Util.initializeMediaPlayers()
    override fun onCreate(savedInstanceState: Bundle?) {
        hideSystemUI(window)
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
    // 1. Plays the sound
    private fun playSound(i : Int, j : Int) {
        if (mediaPlayerList[i].isPlaying) {
            mediaPlayerList[i].stop()
            mediaPlayerList[i].release()
        }
        mediaPlayerList[i] = MediaPlayer.create(this, Util.getSound(i, j))
        mediaPlayerList[i].isLooping = false
        mediaPlayerList[i].start()
    }
   /* // 4. Destroys the MediaPlayer instance when the app is closed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }*/
    private fun hideSystemUI(window : Window){
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
    @Composable
    fun MyApp(){
        GuitarApplicationTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Content()
            }
        }
    }
    @Composable
    fun Content(){
        var i = 0;
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)){
            Column {
                GuitarString(
                    Modifier
                        .weight(1f)
                        .background(Util.getColorX(i)),i++)
                GuitarString(
                    Modifier
                        .weight(1f)
                        .background(Util.getColorX(i)),i++)
                GuitarString(
                    Modifier
                        .weight(1f)
                        .background(Util.getColorX(i)),i++)
                GuitarString(
                    Modifier
                        .weight(1f)
                        .background(Util.getColorX(i)),i++)
                GuitarString(
                    Modifier
                        .weight(1f)
                        .background(Util.getColorX(i)),i++)
                GuitarString(
                    Modifier
                        .weight(1f)
                        .background(Util.getColorX(i)),i++)
            }
        }
    }
    @Composable
    fun GuitarString(modifier: Modifier, i: Int){
        Box(modifier.fillMaxWidth()){
            Row{
                for(j in (0..11)){
                    NoteButton(Modifier.weight(1f),i,j)
                }
            }
        }
    }
    @Composable
    fun NoteButton(modifier: Modifier,i : Int, j : Int){
        Box(modifier.fillMaxHeight()){
            Button(onClick = { playSound(i,j)},
                Modifier.fillMaxSize(),colors = ButtonDefaults.buttonColors(Color.Transparent)) {
                Text(j.toString(),fontSize = 10.sp)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp()
    }
}