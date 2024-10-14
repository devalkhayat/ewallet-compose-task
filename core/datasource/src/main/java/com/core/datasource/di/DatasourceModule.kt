package com.core.datasource.di

import android.content.Context
import com.core.datasource.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DatasourceModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context):AppDatabase{
        return AppDatabase.getDatabase(appContext)
    }
}