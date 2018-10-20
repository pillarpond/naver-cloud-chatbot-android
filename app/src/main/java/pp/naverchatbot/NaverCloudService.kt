package pp.naverchatbot

import pp.naverchatbot.model.Chat
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NaverCloudService {
    @GET("./")
    fun root(): Call<Chat>

    @GET("keyboard")
    fun keyboard(): Call<Chat>

    @Headers("accept: application/json", "Content-Type: application/json;charset=UTF-8")
    @POST("./")
    fun postRoot(@Body chat: Chat): Call<Chat>

    @Headers("accept: application/json")
    @POST("keyboard")
    fun postKeyboard(): Call<Chat>

    @Headers("accept: application/json", "Content-Type: application/json;charset=UTF-8")
    @POST("message")
    fun postMessage(@Body chat: Chat): Call<Chat>
}
