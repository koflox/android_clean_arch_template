package com.koflox.cleanarch.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.koflox.cleanarch.data.entities.Entity
import com.koflox.cleanarch.data.entities.StringEntity
import com.koflox.cleanarch.data.source.Error
import com.koflox.cleanarch.data.source.Result
import com.koflox.cleanarch.ui.base.BaseViewModel
import com.koflox.cleanarch.use_cases.MainUseCase
import com.koflox.cleanarch.util.mergeChannels
import kotlinx.coroutines.channels.ReceiveChannel

class MainViewModel(
    private val app: Application,
    private val mainUseCase: MainUseCase
) : BaseViewModel(app) {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    init {
        mainUseCase.invoke(Unit, isSync = false)
    }

    override val receiveChannel: ReceiveChannel<Result<Entity, Error>>
        get() = mergeChannels(mainUseCase.receiveChannel)

    override fun handleResult(result: Result<Entity, Error>) {
        result.handle(::handleSuccess, ::handleFailure, ::handleState)
    }

    private fun handleSuccess(data: Entity) {
        when (data) {
            is StringEntity -> _text.value = data.value
        }
    }

    private fun handleFailure(error: Error) {

    }

    private fun handleState(state: Result.State<Entity>) {

    }

}