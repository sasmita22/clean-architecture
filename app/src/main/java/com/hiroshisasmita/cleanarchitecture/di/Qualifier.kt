package com.hiroshisasmita.cleanarchitecture.di

import javax.inject.Qualifier

@Qualifier
annotation class QualifierDefaultInterceptor

@Qualifier
annotation class QualifierBodyLoggingInterceptor

@Qualifier
annotation class QualifierHeaderLoggingInterceptor