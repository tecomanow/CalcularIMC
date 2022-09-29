package br.com.matreis.calcularimc.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.matreis.calcularimc.data.model.Bmi

@Database(entities = [Bmi::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun BmiDao(): BmiDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            /*return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,
                "dbName").build()
                INSTANCE = instance
                instance
            }*/
            return if(INSTANCE == null){
                val instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,
                    "dbName").build()
                INSTANCE = instance
                instance
            }else{
                INSTANCE!!
            }
        }

    }

}