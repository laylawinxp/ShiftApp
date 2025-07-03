package com.laylawinxp.shiftapp.di

import android.content.Context
import androidx.room.Room
import com.laylawinxp.shiftapp.data.local.UserDao
import com.laylawinxp.shiftapp.data.local.UserDatabase
import com.laylawinxp.shiftapp.data.preferences.ThemePreference
import com.laylawinxp.shiftapp.data.remote.RandomUserApi
import com.laylawinxp.shiftapp.data.repository.UserRepositoryImpl
import com.laylawinxp.shiftapp.domain.repository.UserRepository
import com.laylawinxp.shiftapp.domain.usecase.GetUserByIdUseCase
import com.laylawinxp.shiftapp.domain.usecase.GetUsersUseCase
import com.laylawinxp.shiftapp.domain.usecase.OpenEmailUseCase
import com.laylawinxp.shiftapp.domain.usecase.OpenMapUseCase
import com.laylawinxp.shiftapp.domain.usecase.OpenPhoneUseCase
import com.laylawinxp.shiftapp.domain.usecase.ShareUserUseCase
import com.laylawinxp.shiftapp.domain.usecase.ToggleThemeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApi(): RandomUserApi = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RandomUserApi::class.java)

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "users.db"
        )
            .build()

    @Provides
    fun provideUserDao(db: UserDatabase) = db.userDao()

    @Provides
    fun provideRepository(api: RandomUserApi, dao: UserDao): UserRepository =
        UserRepositoryImpl(api, dao)

    @Provides
    fun provideThemePreference(@ApplicationContext context: Context): ThemePreference {
        return ThemePreference(context)
    }

    @Provides
    fun provideGetUsersUseCase(repository: UserRepository): GetUsersUseCase {
        return GetUsersUseCase(repository)
    }

    @Provides
    fun provideGetUserByIdUseCase(repository: UserRepository): GetUserByIdUseCase {
        return GetUserByIdUseCase(repository)
    }

    @Provides
    fun provideToggleThemeUseCase(themePreference: ThemePreference): ToggleThemeUseCase {
        return ToggleThemeUseCase(themePreference)
    }

    @Provides
    fun provideShareUserUseCase(): ShareUserUseCase {
        return ShareUserUseCase()
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideOpenEmailUseCase(context: Context): OpenEmailUseCase {
        return OpenEmailUseCase(context)
    }

    @Provides
    fun provideOpenPhoneUseCase(context: Context): OpenPhoneUseCase {
        return OpenPhoneUseCase(context)
    }

    @Provides
    fun provideOpenMapUseCase(context: Context): OpenMapUseCase {
        return OpenMapUseCase(context)
    }
}