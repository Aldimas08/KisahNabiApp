package com.aldimas.kisahnabiapp.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldimas.kisahnabiapp.data.KisahResponse
import com.aldimas.kisahnabiapp.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    val kisahResponse = MutableLiveData<List<KisahResponse>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

   private fun getKisahNabi(responHandler: (List<KisahResponse>) -> Unit, errorHandler: (Throwable) -> Unit) {
    ApiClient.getApiService().getKisahNabi()
        .subscribeOn(Schedulers.io())//bekerja untuk menampilkan sesuatu pada tmptnya
        .observeOn(AndroidSchedulers.mainThread())//observe ngeget data terus menerus
        .subscribe({
            responHandler(it)
        }, {
            errorHandler(it)
        })
    }

    fun getDataForView() {
        isLoading.value = true
        getKisahNabi({
            isLoading.value = false
            kisahResponse.value = it
        }, {
            isLoading.value = true
            isError.value = it
        })
    }
}