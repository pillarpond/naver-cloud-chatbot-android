package pp.naverchatbot.model

open class Content {

    lateinit var type: String
    val title: String? = null

    companion object {
        @Transient
        val TYPE_TEXT = "text"
        @Transient
        val TYPE_LINK = "link"
        @Transient
        val TYPE_IMAGE = "image"
        @Transient
        val TYPE_BUTTON = "button"
        @Transient
        val TYPE_GROUP = "group"
    }
}
