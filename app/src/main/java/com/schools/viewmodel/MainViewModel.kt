package com.schools.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schools.data.GsonSATResponse
import com.schools.data.GsonSchoolsResponse
import com.schools.data.SatScores
import kotlinx.coroutines.launch
import com.schools.repository.MainRepository
import com.schools.repository.remote.retrofitgson.RetrofitGsonSchoolsService
import com.schools.data.Schools
import com.schools.data.asSatScores
import com.schools.data.asSchools

//All this class should be testeable
class MainViewModel : ViewModel() {

    // this creates an observable
    var schoolsList: List<Schools>? by mutableStateOf(null)
        private set
    // this creates an observable
    var satScoresList: List<SatScores>? by mutableStateOf(null)
        private set

    //init the retrofit repo.
    private val repository = MainRepository(
        RetrofitGsonSchoolsService()
    )

    //launching a coroutine, fetching the school list
    fun updateSchoolsWithRetrofitGson() = viewModelScope.launch {
        val response = repository.getRetrofitGsonSchools()
        schoolsList = parseGsonSchoolToSchool(response)
    }

    //launching a coroutine, fetching the sat scores list.
    //also didnt see if this api had a way to send a request object to filter the response and just get the object need it.
    //that should be a easier backend solution.
    fun updateSatScores() = viewModelScope.launch {
        val response = repository.getRetrofitGsonSatScores()
        satScoresList = parseGsonSatToSat(response)
    }


    //this two functions probably are redundant as i might be able to do it the moment i am parsing the JSON
    //but i wanted to separate network objects(called GsonXXXX) to data class objects i can use on the UI.
    private fun parseGsonSchoolToSchool(list: List<GsonSchoolsResponse>) : List<Schools>? {
        var fullList : MutableList<Schools>? = ArrayList()
        list.forEach() {
            fullList?.add(it.asSchools())
        }
        return fullList
    }

    private fun parseGsonSatToSat(list: List<GsonSATResponse>) : List<SatScores>? {
        var fullList : MutableList<SatScores>? = ArrayList()
        list.forEach() {
            fullList?.add(it.asSatScores())
        }
        return fullList
    }
}