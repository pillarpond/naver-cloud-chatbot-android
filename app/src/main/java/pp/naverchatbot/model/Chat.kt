package pp.naverchatbot.model

import com.google.gson.annotations.SerializedName

class Chat(private val userId: String, private val version: String, private val event: String) {

    companion object {
        @Transient
        val TYPE_RECEIVED = 0
        @Transient
        val TYPE_SENT = 1
    }

    private val timestamp: Long

    @SerializedName("content")
    private lateinit var contents: MutableList<Content>

    @Transient
    val type: Int

    init {
        timestamp = System.currentTimeMillis() / 1000
        type = TYPE_SENT
    }

    constructor(userId: String, version: String, event: String, content: Content) : this(userId, version, event) {
        contents = ArrayList()
        contents.add(content)
    }

    fun getContents(): MutableList<Content> {
        return contents
    }
}