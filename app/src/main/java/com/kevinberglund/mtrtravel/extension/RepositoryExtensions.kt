package com.kevinberglund.mtrtravel.extension

import com.kevinberglund.mtrtravel.common.IMapper
import com.kevinberglund.mtrtravel.data.Result
import retrofit2.Call
import java.io.IOException
import java.lang.RuntimeException

inline fun <reified Success : Any, MappedResult : Any> apiCall(
    mapper: IMapper<MappedResult, Success>,
    block: () -> Call<Success>
): Result<MappedResult> {
    return try {
        val data = block().execute()
        if (data.isSuccessful) {
            data.body()?.let { response ->
                Result.Success(mapper.map(response))
            } ?: Result.Error("Successful call, empty response")
        } else {
            Result.Error(data.errorBody()?.string() ?: "Obtained ${data.code()} code from BE.", IOException(data.message()))
        }
    }
    catch (exception: IOException) {
        Result.Error(exception.localizedMessage ?: "IOException was thrown in apiCall", exception)
    } catch (exception: RuntimeException) {
        Result.Error("Something went wrong, look at the mapping", exception)
    }
}