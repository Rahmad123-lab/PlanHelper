package com.android.myapplication.todo.ui

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.myapplication.todo.R
import com.android.myapplication.todo.data.Notes
import com.android.myapplication.todo.getStarted
import com.android.myapplication.todo.repositories.Repository
import com.android.myapplication.todo.util.Event
import kotlinx.android.synthetic.main.fragment_home_view_pager.*
import kotlinx.coroutines.launch

class HomeViewPagerViewModel(private val repository: Repository) : ViewModel() {

    private val _fabNavListenner= MutableLiveData<Event<Unit>>()
    val fabNavListenner:LiveData<Event<Unit>>
    get() = _fabNavListenner


    fun fabNavTriggered(){
        _fabNavListenner.value = Event(Unit)
    }

     fun insert(note: Notes){
        viewModelScope.launch {
            repository.insert(note)
        }
    }





}