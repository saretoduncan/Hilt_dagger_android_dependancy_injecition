package com.example.unsplashapi.viewModel

import android.util.Log
import androidx.lifecycle.*
import com.example.unsplashapi.models.ImageItem
import com.example.unsplashapi.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel
@Inject
constructor(private val repository: ImageRepository):ViewModel(){
    private val _reponse=MutableLiveData<List<ImageItem>>()
    val responseImages:LiveData<List<ImageItem>>
         get()=_reponse
    init{
        getAllImages()
    }

    private fun getAllImages() = viewModelScope.launch {
        repository.getAllImages().let{response->
            if(response.isSuccessful){
                _reponse.postValue(response.body())
            }else{
                Log.d("imageviewModel", "getAllImage Error:" +
                        "${response.errorBody()}")
            }
        }
    }



}