package com.livinglifetechway.k4kotlinsample.RetrofitApi

import retrofit2.Call
import retrofit2.http.GET

/**
 */
interface ApiInterface {
    @GET("posts/1")
    fun getPost(): Call<Post>

    @GET("users")
    fun getUserDetails(): Call<UserResp>

    @GET("aaaa/bbbb")
    fun getUserDetailsError(): Call<UserResp>

}


data class Post(
        val userId: Int, //1
        val id: Int, //1
        val title: String, //sunt aut facere repellat provident occaecati excepturi optio reprehenderit
        val body: String //quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto
)

data class UserResp(
        val page: Int, //2
        val per_page: Int, //3
        val total: Int, //12
        val total_pages: Int, //4
        val data: List<Data>
)

data class Data(
        val id: Int, //4
        val first_name: String, //Eve
        val last_name: String, //Holt
        val avatar: String //https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg
)