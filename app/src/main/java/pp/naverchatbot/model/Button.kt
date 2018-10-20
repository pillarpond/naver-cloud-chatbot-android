package pp.naverchatbot.model

import android.content.Intent
import android.net.Uri
import android.text.Html
import android.text.Spanned
import android.view.View

class Button : Content() {
    private lateinit var data: Data

    val url: Spanned
        get() {
            val url = "<u>" + data.url + "</u>"
            return Html.fromHtml(url, Html.FROM_HTML_MODE_COMPACT)
        }

    fun onClick(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
        view.context.startActivity(intent)
    }

    private inner class Data {
        lateinit var type: String
        val code: String? = null
        val url: String? = null
    }
}