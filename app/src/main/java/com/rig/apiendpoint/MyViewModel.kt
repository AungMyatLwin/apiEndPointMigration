package com.rig.apiendpoint

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(var repo:Repository):ViewModel() {

    var datas:MutableLiveData<Test> = MutableLiveData()
     fun getAllEntries(){
         viewModelScope.launch(Dispatchers.IO) {
             var elements = async{
                 repo.getAllEntries()
             }
             datas.postValue(elements.await())
             Log.d("Logs", "getAllEntries: ${elements.await()} ")
         }
     }
    var categories:MutableLiveData<Categories> =MutableLiveData()
    fun getCategories(){
        viewModelScope.launch {
            var elements = async{
                repo.getCategories()
            }
            categories.postValue(elements.await())
            Log.d("Logs", "getAllEntries: ${elements.await()} ")
        }
    }
    var random:MutableLiveData<Test> = MutableLiveData()
    fun getSurprise(){
        viewModelScope.launch {
            var elements = async{
                repo.getSurprise()
            }
            random.postValue(elements.await())
            Log.d("Logs", "getAllEntries: ${elements.await()} ")
        }
    }
}