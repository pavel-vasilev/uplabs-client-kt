package com.pvasilev.uplabs.network.services

import com.pvasilev.uplabs.models.Post
import com.pvasilev.uplabs.models.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {
    @GET("users/{nickname}.json")
    fun getPosts(@Path("nickname") nickname: String, @Query("page") page: Int): Observable<List<Post>>

    @GET("users/{nickname}/followers.json")
    fun getFollowers(@Path("nickname") nickname: String, @Query("page") page: Int): Observable<List<User>>

    @GET("users/{nickname}/followings.json")
    fun getFollowing(@Path("nickname") nickname: String, @Query("page") page: Int): Observable<List<User>>
}