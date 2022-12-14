package br.com.matreis.calcularimc.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import br.com.matreis.calcularimc.data.model.Bmi

@Dao
interface BmiDao {

    @Insert(onConflict = IGNORE)
    fun insert(bmi: Bmi)

    @Query("SELECT * FROM bmi")
    fun getAll(): LiveData<List<Bmi>>

}