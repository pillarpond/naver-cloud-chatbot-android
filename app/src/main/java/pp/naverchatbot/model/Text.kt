package pp.naverchatbot.model

class Text(details: String) : Content() {
    private val data: Data

    val details: String
        get() = data.details

    init {
        type = Content.TYPE_TEXT
        data = Data(details)
    }

    private inner class Data constructor(val details: String)
}
