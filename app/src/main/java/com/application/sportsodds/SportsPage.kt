package com.application.sportsodds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SportsPage : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Details>

    private lateinit var imageId : Array<Int>
    private lateinit var heading : Array<String>
    private lateinit var briefNews : Array<String>

    private var btnS : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sports_page)

        imageId = arrayOf(R.drawable.ic_sports, R.drawable.ic_sports, R.drawable.ic_sports,
                R.drawable.ic_sports, R.drawable.ic_sports
        )

        heading = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title3),
            getString(R.string.title4),
            getString(R.string.title5)
        )

        briefNews = arrayOf(
            getString(R.string.tit1),
            getString(R.string.tit2),
            getString(R.string.tit3),
            getString(R.string.tit4),
            getString(R.string.tit5),
            )

        newRecyclerView = findViewById(R.id.recyclerItems)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Details>()
        getUserdata()

        btnS = findViewById(R.id.btnS)
        btnS?.setOnClickListener{
            onBackPressed()
        }
    }
    private fun getUserdata() {

        for(i in imageId.indices){

            val news = Details(imageId[i], heading[i],briefNews[i])
            newArrayList.add(news)
        }
        val adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
    }
}
