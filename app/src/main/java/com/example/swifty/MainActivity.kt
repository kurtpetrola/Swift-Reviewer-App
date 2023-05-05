package com.example.swifty

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView : RecyclerView
    private lateinit var newArrayList : ArrayList<Infos>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var infos : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quizActButton = findViewById<FloatingActionButton>(R.id.quizFloatingActionButton)
        quizActButton.setOnClickListener {
            val Intent = Intent(this,QuizActivity::class.java)
            startActivity(Intent)
        }

        imageId = arrayOf(

            R.drawable.swift_1,
            R.drawable.swift_2,
            R.drawable.swift_3,
            R.drawable.swift_4,
            R.drawable.swift_5,
            R.drawable.swift_6,
            R.drawable.swift_7,
            R.drawable.swift_8,
            R.drawable.swift_9,
            R.drawable.swift_10,
            R.drawable.swift_11,
            R.drawable.swift_12,
            R.drawable.swift_13,
            R.drawable.swift_14,
            R.drawable.swift_15,
            R.drawable.swift_16,
            R.drawable.swift_17,
            R.drawable.swift_18,
            R.drawable.swift_19,
            R.drawable.swift_20,
            R.drawable.swift_21,
            R.drawable.swift_22,
            R.drawable.swift_23,
            R.drawable.swift_24,
            R.drawable.swift_25,

            )

        heading = arrayOf(

            "Swift Introduction",
            "Swift Hello World",
            "Swift Constant & Variable",
            "Swift Basic Operator",
            "Swift String & Characters",
            "Swift Collection Types",
            "Swift Control Flow",
            "Swift Functions",
            "Swift Closures",
            "Swift Enumeration",
            "Swift Classes",
            "Swift Properties",
            "Swift Methods",
            "Swift Subscripts",
            "Swift Inheritance",
            "Swift Initialization",
            "Swift Advanced Operators",
            "Swift Optional Chaining",
            "Swift Error Handling",
            "Swift Type Casting",
            "Swift Nested Types",
            "Swift Extensions",
            "Swift Protocols",
            "Swift Generics",
            "Swift Access Control"

        )

        infos = arrayOf(

            getString(R.string.sf_1),
            getString(R.string.sf_2),
            getString(R.string.sf_3),
            getString(R.string.sf_4),
            getString(R.string.sf_5),
            getString(R.string.sf_6),
            getString(R.string.sf_7),
            getString(R.string.sf_8),
            getString(R.string.sf_9),
            getString(R.string.sf_10),
            getString(R.string.sf_11),
            getString(R.string.sf_12),
            getString(R.string.sf_13),
            getString(R.string.sf_14),
            getString(R.string.sf_15),
            getString(R.string.sf_16),
            getString(R.string.sf_17),
            getString(R.string.sf_18),
            getString(R.string.sf_19),
            getString(R.string.sf_20),
            getString(R.string.sf_21),
            getString(R.string.sf_22),
            getString(R.string.sf_23),
            getString(R.string.sf_24),
            getString(R.string.sf_25),

        )

        newRecyclerView= findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Infos>()
        getUserdata()

    }

    private fun getUserdata() {

        for(i in imageId.indices){

            val infos = Infos(imageId[i], heading[i])
            newArrayList.add(infos)
        }

        val adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, InfosActivity::class.java)
                intent.putExtra("heading",newArrayList[position].heading)
                intent.putExtra("imageId",newArrayList[position].titleImage)
                intent.putExtra("infos",infos[position])
                startActivity(intent)

            }

        })

    }

}