package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MainActivity : AppCompatActivity() {

    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(applicationContext,
        AppDatabase::class.java,
        "shopping-items")
            .fallbackToDestructiveMigration()
            .build()

        val item1 = Item(0, "banan", false,"frukt")
        val item2 = Item(0, "appelsin", false,"frukt")
        val item3 = Item(0, "egg", false,"kylvara")

//        saveItem(item1)
//        saveItem(item2)
//        saveItem(item3)

    }

    fun saveItem( item: Item) {

        GlobalScope.async {
            db.itemDao().insert(item)
        }


    }
}