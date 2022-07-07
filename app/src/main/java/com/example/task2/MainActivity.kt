package com.example.task2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rec: RecyclerView
    private lateinit var myadapter: Adapter
    private lateinit var modelist: ArrayList<Model>
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var text: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rec = findViewById(R.id.recycler)
        btn1 = findViewById(R.id.finds)
        btn2 = findViewById(R.id.get)
        btn3 = findViewById(R.id.okay)
        text = findViewById(R.id.edit)

        modelist = ArrayList()
        modelist.add(Model(0, R.color.red,"red"))
        modelist.add(Model(1, R.color.green,"green"))
        modelist.add(Model(2, R.color.blue,"blue"))
        modelist.add(Model(3, R.color.grey,"grey"))

        myadapter = Adapter(baseContext, modelist)
        rec.adapter = myadapter
        rec.layoutManager = GridLayoutManager(this, 2)

        btn1.setOnClickListener {
            btn1.visibility = View.INVISIBLE
            btn2.visibility = View.VISIBLE
            text.visibility = View.VISIBLE
        }

        btn2.setOnClickListener {
            btn3.visibility = View.VISIBLE
            btn2.visibility = View.INVISIBLE
            text.visibility = View.INVISIBLE
            val title: String = text.text.toString().lowercase()
           for (i in 0 until modelist.size){
               if (modelist[i].colorName ==title){
                   Toast.makeText(this, "$title is at the position $i", Toast.LENGTH_SHORT).show()
               }
           }
        }
            btn3.setOnClickListener {
                btn1.visibility = View.VISIBLE
                btn3.visibility = View.INVISIBLE
            }
        }



}
