package br.com.matreis.calcularimc.presentation.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import br.com.matreis.calcularimc.App
import br.com.matreis.calcularimc.R
import br.com.matreis.calcularimc.data.db.AppDatabase
import br.com.matreis.calcularimc.data.db.BmiDao
import br.com.matreis.calcularimc.data.model.Bmi
import br.com.matreis.calcularimc.databinding.ActivityMainBinding
import br.com.matreis.calcularimc.helper.getBmiFormatted
import br.com.matreis.calcularimc.helper.getDateFormatted
import br.com.matreis.calcularimc.helper.getInputValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    //private lateinit var dao: BmiDao

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        //dao = (application as App).bmiDao

        initObserver()
        initListeners()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun initObserver() {
        mainViewModel.bmi.observe(this) {
            if(it > 0){
                binding.tvResult.text = it.getBmiFormatted()
            }
        }
        mainViewModel.bmiDetail.observe(this){
            binding.tvResultDetail.text = it
        }
    }

    private fun initListeners() {
        binding.btnCalculateBMI.setOnClickListener {
            mainViewModel.calculateBMI(binding.etWeight.getInputValue(), binding.etHeight.getInputValue()/100)
            /*CoroutineScope(Dispatchers.IO).launch {
                dao.insert(
                    Bmi(
                        0,
                        binding.etWeight.getInputValue(),
                        binding.etHeight.getInputValue()/100,
                        System.currentTimeMillis().getDateFormatted()
                    )
                )
            }*/
        }

    }
}