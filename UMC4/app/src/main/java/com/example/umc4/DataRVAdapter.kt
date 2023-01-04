package com.example.umc4

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc4.DataRVAdapter.DataViewHolder
import com.example.umc4.databinding.ItemDataBinding


//class DataRVAdapter(private val dataList: ArrayList<Data>):RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {
class DataRVAdapter(private val memoViewModel: RoomDbViewModel,context: Context):RecyclerView.Adapter<DataViewHolder>() {

    private var memoList:List<Memo> = listOf()

    val sharedPrefs = context.getSharedPreferences("star2",Context.MODE_PRIVATE)
    val editor = sharedPrefs.edit()


    inner class DataViewHolder(private val viewBinding: ItemDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(memo: Memo) {

            viewBinding.tvTitle.text = memo.title
            viewBinding.tvDesc.text = memo.description

//            viewBinding.tvTitle.text = data.title
//            viewBinding.tvDesc.text = data.description

            //삭제 코드 adapterposition을 통해 해당 datalist를 삭제한다
//            viewBinding.Rmbutton.setOnClickListener {
//                dataList.removeAt(adapterPosition)
//                notifyDataSetChanged()
//            }

            viewBinding.Rmbutton.setOnClickListener {
                memoViewModel.delete(memo)
                notifyDataSetChanged()
            }

            viewBinding.StarBt.setOnClickListener {
                val save_form = "{\"title\":\"" + memo.title + "\",\"content\":\"" + memo.description + "\"}"
                editor.putString(memo.title,save_form)
                editor.apply()
                editor.commit()
                notifyDataSetChanged()
                var memos =sharedPrefs.getString(memo.title,null)
                if (memos != null) {
                    Log.d(memo.title, memos )
                }
            }
        }
    }
    fun setMemoItemList(memo:List<Memo>){
        this.memoList = memo
        notifyDataSetChanged()
    }

    //viewholder 만들어질때 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder((viewBinding))
    }
    //데이터표시
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
//        holder.bind(dataList[position])
        holder.bind((memoList[position]))
    }
    //표현할 item 의 갯수
//    override fun getItemCount(): Int = dataList.size
    override fun getItemCount(): Int = memoList.size
}