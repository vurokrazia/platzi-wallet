package com.cristianvillamil.platziwallet.ui.home.commands

import java.lang.RuntimeException

class FileCommandasManager {
    private val commands: HashMap<String, FileCommand> = HashMap()
    fun putComand(commandName: String, fileCommand: FileCommand){
        commands[commandName] = fileCommand
    }
    fun getCommand(commandName: String) : FileCommand {
        if( commands.containsKey(commandName))
            return commands[commandName]!!
        else
            throw RuntimeException("command $commandName no esta register")
    }
}