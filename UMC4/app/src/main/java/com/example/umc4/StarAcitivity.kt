package com.example.umc4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc4.databinding.ActivityStarBinding
import org.json.JSONObject


class StarAcitivity :AppCompatActivity() {
    private lateinit var viewbinding: ActivityStarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityStarBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

        val dataList: ArrayList<Data> = arrayListOf()
        val StarRVAdapter = StarRVAdapter(dataList,this)

        val prefb = getSharedPreferences("star2", MODE_PRIVATE)
        val col_val: Collection<*> = prefb.all.values
        val it_val = col_val.iterator()
        val col_key: Collection<*> = prefb.all.keys
        val it_key = col_key.iterator()

        while(it_val.hasNext() && it_key.hasNext()) {
            val key = it_key.next() as String
            val value = it_val.next() as String
            System.out.println(value)
            val jsonObject = JSONObject(value)
            val title = jsonObject.getString("title") as String
            val content = jsonObject.getString("content") as String
            viewbinding.MainStarBt.setOnClickListener {
                Log.d("t,c", col_key.toString())
            }
            dataList.apply {
                add(Data(title.toString(), content.toString()))
            }
            StarRVAdapter.notifyDataSetChanged()
        }

        viewbinding.rvData.adapter = StarRVAdapter
        viewbinding.rvData.layoutManager = LinearLayoutManager(this)
        }


}