package com.example.guitarapplication.Logic

import android.media.MediaPlayer
import androidx.compose.ui.graphics.Color
import com.example.guitarapplication.R

public class Util{
    companion object{
        fun getSound(i: Int, j : Int) : Int {
            return when(i){
                0 -> getString6Sound(j)
                1 -> getString5Sound(j)
                2 -> getString4Sound(j)
                3 -> getString3Sound(j)
                4 -> getString2Sound(j)
                5 -> getString1Sound(j)
                else -> -1
            }
        }
        private fun getString1Sound(j : Int) : Int{//6
            return when(j){
                0 -> R.raw.c1
                1 -> R.raw.db1
                2 -> R.raw.d1
                3 -> R.raw.eb1
                4 -> R.raw.e1
                5 -> R.raw.f1
                6 -> R.raw.gb1
                7 -> R.raw.g1
                8 -> R.raw.ab1
                9 -> R.raw.a1
                10 -> R.raw.bb1
                11 -> R.raw.b1
                else -> -1
            }
        }
        private fun getString2Sound(j : Int): Int{
            return when(j){
                0 -> R.raw.c2
                1 -> R.raw.db2
                2 -> R.raw.d2
                3 -> R.raw.eb2
                4 -> R.raw.e2
                5 -> R.raw.f2
                6 -> R.raw.gb2
                7 -> R.raw.g2
                8 -> R.raw.ab2
                9 -> R.raw.a2
                10 -> R.raw.bb2
                11 -> R.raw.b2
                else -> -1
            }
        }
        private fun getString3Sound(j : Int): Int{
            return when(j){
                0 -> R.raw.c3
                1 -> R.raw.db3
                2 -> R.raw.d3
                3 -> R.raw.eb3
                4 -> R.raw.e3
                5 -> R.raw.f3
                6 -> R.raw.gb3
                7 -> R.raw.g3
                8 -> R.raw.ab3
                9 -> R.raw.a3
                10 -> R.raw.bb3
                11 -> R.raw.b3
                else -> -1
            }
        }
        private fun getString4Sound(j : Int): Int{
            return when(j){
                0 -> R.raw.c4
                1 -> R.raw.db4
                2 -> R.raw.d4
                3 -> R.raw.eb4
                4 -> R.raw.e4
                5 -> R.raw.f4
                6 -> R.raw.gb4
                7 -> R.raw.g4
                8 -> R.raw.ab4
                9 -> R.raw.a4
                10 -> R.raw.bb4
                11 -> R.raw.b4
                else -> -1
            }
        }
        private fun getString5Sound(j : Int): Int{
            return when(j){
                0 -> R.raw.c5
                1 -> R.raw.db5
                2 -> R.raw.d5
                3 -> R.raw.eb5
                4 -> R.raw.e5
                5 -> R.raw.f5
                6 -> R.raw.gb5
                7 -> R.raw.g5
                8 -> R.raw.ab5
                9 -> R.raw.a5
                10 -> R.raw.bb5
                11 -> R.raw.b5
                else -> -1
            }
        }
        private fun getString6Sound(j : Int): Int{
            return when(j){
                0 -> R.raw.c6
                1 -> R.raw.db6
                2 -> R.raw.d6
                3 -> R.raw.eb6
                4 -> R.raw.e6
                5 -> R.raw.f6
                6 -> R.raw.gb6
                7 -> R.raw.g6
                8 -> R.raw.ab6
                9 -> R.raw.a6
                10 -> R.raw.bb6
                11 -> R.raw.b6
                else -> -1
            }
        }
        fun getColorX(i: Int): Color {
            if(i == 0){
                return Color.Gray;
            }
            else if(i == 1){
                return Color.Red;
            }
            else if(i == 2){
                return Color.Yellow;
            }
            else if(i == 3){
                return Color.Cyan;
            }
            else if(i == 4){
                return Color.Green;
            }
            else if(i == 5){
                return Color.Magenta;
            }
            else if(i < 0){
                return getColorX(i + 6000)
            }
            else{
                return getColorX(i%6)
            }
        }
        fun initializeMediaPlayers(): ArrayList<MediaPlayer> {
            var mediaPlayers : ArrayList<MediaPlayer> = ArrayList()
            for(i in (0..5)){
                mediaPlayers.add(MediaPlayer())
            }
            return mediaPlayers
        }
    }
}