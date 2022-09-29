package br.com.matreis.calcularimc

import android.app.Application
import br.com.matreis.calcularimc.data.db.AppDatabase

class App : Application() {

    private val database by lazy { AppDatabase.getInstance(this) }
    val bmiDao by lazy { database.BmiDao() }

}