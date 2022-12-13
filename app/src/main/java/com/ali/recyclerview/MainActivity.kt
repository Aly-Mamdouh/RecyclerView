package com.ali.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity(),MatchInteraction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv=findViewById<RecyclerView>(R.id.main_rv)
        rv.layoutManager=LinearLayoutManager(this)
        val dt=ArrayList<Data>()
        for(i in 0..15){
            dt.add(Data("Brazil",2,"France",1))
        }
        val adapter=MatchAdapter(dt,this)
        rv.adapter=adapter
    }

    override fun onItemClickListener(data: Data) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("key", data)
        startActivity(intent)
    }

    override fun onClickTeamName(name: String) {
        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
    }
}