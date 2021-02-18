package com.kevinberglund.mtrtravel.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.kevinberglund.mtrtravel.data.Result
import com.kevinberglund.mtrtravel.models.StationModel
import com.kevinberglund.mtrtravel.usecase.UseCaseFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Suppress("EXPERIMENTAL_API_USAGE")
class StationViewModel(
    private val useCaseFactory: UseCaseFactory
) : BaseLifecycleViewModel()  {

    private val stationLiveData = MutableLiveData<StationModel>()
    private val stationUseCase = useCaseFactory.getStationUseCase()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(context = Dispatchers.IO) {
            stationUseCase.perform().collect { result ->
                when (result) {
                    is Result.Success -> {
                        stationLiveData.value = result.value
                    }
                    is Result.Error -> {
                        Log.e(StationViewModel::class.simpleName, "Failed to load station data.")
                    }
                }
            }
        }
    }
}