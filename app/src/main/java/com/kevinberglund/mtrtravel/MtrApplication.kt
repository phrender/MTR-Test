package com.kevinberglund.mtrtravel

import android.app.Application
import com.kevinberglund.mtrtravel.data.MtrApi
import com.kevinberglund.mtrtravel.repository.RepositoryFactory
import com.kevinberglund.mtrtravel.usecase.UseCaseFactory

class MtrApplication: Application() {

    companion object {
        lateinit var INSTANCE: MtrApplication
            private set
    }

    private lateinit var mtrService: MtrService
    private lateinit var api: MtrApi
    private lateinit var repositoryFactory: RepositoryFactory
    lateinit var useCaseFactory: UseCaseFactory

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this

        createApiService()
        createRepositoryFactory()
        createUseCaseFactory()
    }

    private fun createApiService() {
        mtrService = MtrService(getString(R.string.base_url), cacheDir)
        api = mtrService.retrofit.create(MtrApi::class.java)
    }

    private fun createRepositoryFactory() {
        repositoryFactory = RepositoryFactory(api)
    }

    private fun createUseCaseFactory() {
        useCaseFactory = UseCaseFactory(repositoryFactory)
    }
}