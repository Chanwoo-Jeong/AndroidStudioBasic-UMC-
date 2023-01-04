package com.example.umc4

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoomDbViewModel(application: Application):ViewModel() {
    private val repository = MemoRepository(application)

    fun getAll(): LiveData<List<Memo>> {
        return repository.getAll()
    }

    fun insert(memo: Memo){
        repository.insert(memo)
    }
    fun delete(memo: Memo){
        repository.delete(memo)
    }

    override fun onCleared() {
        super.onCleared()
    }

}