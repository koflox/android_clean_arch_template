package com.koflox.cleanarch.use_cases

import com.koflox.cleanarch.data.entities.StringEntity
import com.koflox.cleanarch.data.source.Result

class MainUseCase : BaseUseCase<Unit>() {

    override suspend fun run(data: Unit) {
        resultChannel.send(Result.Success(StringEntity("Hello Clean Architecture")))
    }

}