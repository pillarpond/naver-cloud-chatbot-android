package pp.naverchatbot.model

import android.content.Intent
import android.net.Uri
import android.text.Html
import android.text.Spanned
import android.view.View

class Link : Content() {
    private lateinit var data: Data

    val href: Spanned
        get() {
            val url = if (title != null) {"<u>" + title + "</u>"} else {"<u>" + data.url + "</u>"}
            return Html.fromHtml(url, Html.FROM_HTML_MODE_COMPACT)
        }

    fun onClick(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
        view.context.startActivity(intent)
    }

    private inner class Data {
        lateinit var type: String
        val url: String? = null
    }
}