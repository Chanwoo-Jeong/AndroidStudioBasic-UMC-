package com.example.umc4

import android.app.Application
import androidx.lifecycle.LiveData

class MemoRepository(application: Application) {
    private val appDatabase: AppDatabase = AppDatabase.getInstance(application)!!
    private val memoDao: MemoDao = appDatabase.memoDao()

    fun getAll(): LiveData<List<Memo>> {
        return memoDao.getAll()
    }
    fun insert(memo: Memo){
        memoDao.insert(memo)
    }
    fun delete(memo:Memo){
        memoDao.delete(memo)
    }

    fun update(memo: Memo){
        memoDao.update(memo)
    }
}