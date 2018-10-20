package pp.naverchatbot

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import pp.naverchatbot.model.Chat
import pp.naverchatbot.model.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class ChatViewModel : ViewModel() {

    companion object {
        //todo
        private val URL = "ENTER HERE"
        //todo
        private val USER_ID = "ENTER HERE"

        private val VERSION = "v1"

        private val EVENT_OPEN = "open"
        private val EVENT_SEND = "send"
    }

    private val mutableLiveData = MutableLiveData<Chat>()
    private val service: NaverCloudService

    private val callback = object : Callback<Chat> {
        override fun onResponse(call: Call<Chat>, response: Response<Chat>) {
            if (response.isSuccessful)
                mutableLiveData.value = response.body()
        }

        override fun onFailure(call: Call<Chat>, t: Throwable) {
            Log.e(this.javaClass.name, call.toString(), t)
        }
    }

    val chat: LiveData<Chat>
        get() = mutableLiveData

    init {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Chat::class.java, NaverCloudDeserializer())
        val gson = gsonBuilder.create()

        val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        service = retrofit.create(NaverCloudService::class.java)
    }

    fun open() {
        val chat = Chat(USER_ID, VERSION, EVENT_OPEN)
        val request = service.postMessage(chat)

        request.enqueue(callback)
    }

    fun send(msg: String) {
        val text = Text(msg)
        val chat = Chat(USER_ID, VERSION, EVENT_SEND, text)
        mutableLiveData.value = chat

        val request = service.postMessage(chat)
        request.enqueue(callback)
    }
}
