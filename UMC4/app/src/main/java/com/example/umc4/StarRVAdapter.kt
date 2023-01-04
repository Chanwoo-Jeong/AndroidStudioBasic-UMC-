package com.example.umc4

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.icu.text.CaseMap
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc4.DataRVAdapter.DataViewHolder
import com.example.umc4.databinding.ItemDataBinding


//class DataRVAdapter(private val dataList: ArrayList<Data>):RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
class StarRVAdapter(private val dataList: ArrayList<Data> = ArrayList(),context: Context):RecyclerView.Adapter<StarRVAdapter.DataViewHolder>() {

//    val mPref: SharedPreferences = context.getSharedPreferences("star", MODE_PRIVATE)

    inner class DataViewHolder(private val viewBinding: ItemDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: Data) {
              viewBinding.tvTitle.text = data.title
                viewBinding.tvDesc.text = data.description
        }
    }


    //viewholder 만들어질때 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder((viewBinding))
    }
    //데이터표시
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
//        holder.bind((memoList[position]))
//        holder.bind(mPreferences[position])
    }
    //표현할 item 의 갯수
//    override fun getItemCount(): Int = dataList.size
    override fun getItemCount(): Int = dataList.size
}