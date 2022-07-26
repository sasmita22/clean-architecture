package com.hiroshisasmita.cleanarchitecture.data.network.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("status_message") var statusMessage: String? = null,
    @SerializedName("status_code") var statusCode: Int? = null
)