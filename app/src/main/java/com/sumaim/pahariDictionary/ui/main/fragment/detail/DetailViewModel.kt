package com.sumaim.pahariDictionary.ui.main.fragment.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sumaim.pahariDictionary.data.Repository
import com.sumaim.pahariDictionary.data.db.entity.Word
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application){

    val repo: Repository = Repository.getInstance(application, viewModelScope)

    fun update(word: Word){
        viewModelScope.launch {
            repo.update(word)
        }
    }

}