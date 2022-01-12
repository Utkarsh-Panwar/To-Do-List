package com.example.todolist

import android.content.Context
import java.io.*

class FileHelper {

    private val fileName = "ListInfo.dat"

    fun writeData(item:ArrayList<String>,context: Context){

        val fileOutputStream:FileOutputStream = context.openFileOutput(fileName,Context.MODE_PRIVATE)
        val objectOutputStream=ObjectOutputStream(fileOutputStream)
        objectOutputStream.writeObject(item)
        objectOutputStream.close()
    }

    fun readData(context: Context):ArrayList<String>{

        var itemList:ArrayList<String>

        try {
            val fileInputStream: FileInputStream = context.openFileInput(fileName)
            val objectInputStream = ObjectInputStream(fileInputStream)
            itemList = objectInputStream.readObject() as ArrayList<String>
        }

        catch(e:FileNotFoundException){
            itemList=ArrayList()
        }

        return itemList
    }

}