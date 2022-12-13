package com.ali.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.ali.recyclerview.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dt:Data
        dt=intent.getSerializableExtra("key") as Data
        binding.detailsTeam1.text=dt.team1
        binding.detailsTeam2.text=dt.team2
        binding.detailsScore1.text=dt.score1.toString()
        binding.detailsScore2.text=dt.score2.toString()
    }

}