package com.example.umc4

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Update
    fun update(memo: Memo)

    @Query("SELECT * FROM Memo")
    //LiveData로 설정
    fun getAll():LiveData<List<Memo>>

    @Query("SELECT * FROM Memo WHERE memoId = :memoId")
    fun selectByUserID(memoId: Int):Memo

    @Query("SELECT * FROM Memo WHERE title = :title")
    fun selectByUserName(title:String): List<Memo>

    @Query("UPDATE Memo SET title = :title WHERE memoId =:memoId")
    fun updateNameByUserId(memoId: Int, title: String)

}