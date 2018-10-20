package pp.naverchatbot

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("image_url")
    fun setImageViewResource(imageView: ImageView, url: String) {
        Picasso.get().load(url).into(imageView)
    }
}
