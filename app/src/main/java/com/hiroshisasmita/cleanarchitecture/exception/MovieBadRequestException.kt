package com.hiroshisasmita.cleanarchitecture.exception

import com.hiroshisasmita.android_core.exception.BadRequestException

class MovieBadRequestException(override val message: String?): BadRequestException()