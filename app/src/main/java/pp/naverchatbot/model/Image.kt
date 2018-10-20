package pp.naverchatbot.model

class Image : Content() {
    private lateinit var data: Data

    val url: String
        get() = data.url
    val desc: String?
        get() = data.description

    private inner class Data {
        lateinit var url: String
        val description: String? = null
    }
}
