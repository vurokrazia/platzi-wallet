package com.cristianvillamil.platziwallet

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cristianvillamil.platziwallet.ui.home.commands.FileCommandsManager
import com.cristianvillamil.platziwallet.ui.home.commands.ReadCommand
import com.cristianvillamil.platziwallet.ui.home.commands.SaveCommand

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val commandasManager = FileCommandsManager()
        val saveCommand = SaveCommand()
        commandasManager.putCommand("SaveCommand", saveCommand)
        commandasManager.putCommand("ReadCommand", ReadCommand())
        commandasManager.getCommand("SaveCommand")
            .execute(this, "exampleFile", "hello world", "Platzi Wallet")
        commandasManager.getCommand("ReadCommand")
            .execute(this,"exampleFile")
    }
}
