package com.cristianvillamil.platziwallet.ui.home.commands

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

class ReadCommand : FileCommand {
    override fun execute(context: Context, filename: String, vararg arguments: String) {
        try{
            var fileString = ""
            val inputStream = context.openFileInput(filename)
            val stringBuilder = StringBuilder()
            val inputStreamReader = InputStreamReader(inputStream)
            val  bufferedReader = BufferedReader(inputStreamReader)
            bufferedReader.forEachLine { stringBuilder.append("\n").append(it) }
            fileString = stringBuilder.toString()
            Log.e("ReadFile",fileString)
        } catch (exception: IOException){
            Log.e("SaveCommand","File write failed: $exception")
        }
    }
}