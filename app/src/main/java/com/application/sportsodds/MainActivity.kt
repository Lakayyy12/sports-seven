package com.application.sportsodds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.sportsodds.Navigator.Companion.openPage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnContentCLickListener {

    private var layoutManager: RecyclerView.LayoutManager? = null

    private val onItemClicked by lazy { this }

    private var exit = 0

    private var btn01 : Button? = null
    private var btn02 : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initOnClicked()

        btn01 = findViewById(R.id.btn01)
        btn01?.setOnClickListener{
            val intent = Intent(this, SportsPage::class.java)
            startActivity(intent)
        }
        btn02 = findViewById(R.id.btn02)
        btn02?.setOnClickListener{
            val intent = Intent(this, AboutPage::class.java)
            startActivity(intent)
        }
    }
    private fun initRecyclerView(){
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = RecyclerAdapter(onItemClicked)
    }
    private fun initOnClicked(){
        cdView?.setOnClickListener {
            openPage(this, ContentInside::class.java)
        }
    }
    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this,"CLICK AGAIN TO EXIT", Toast.LENGTH_SHORT).show()
        }
        else {
            finish()
        }
    }
    override fun OnContentItemClicked(image: Int, content: Int) {
        openPage(this, ContentInside::class.java, image, content)
    }
}