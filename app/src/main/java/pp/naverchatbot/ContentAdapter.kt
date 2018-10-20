package pp.naverchatbot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import pp.naverchatbot.model.Content
import pp.naverchatbot.viewholder.ContentViewHolder

class ContentAdapter : RecyclerView.Adapter<ContentViewHolder>() {
    private var contents: List<Content> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context), viewType, parent, false)
        return ContentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val content = contents[position]
        holder.binding.setVariable(BR.obj, content)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    override fun getItemViewType(position: Int): Int {
        val content = contents[position]

        when (content.type) {
            Content.TYPE_TEXT -> return R.layout.item_text
            Content.TYPE_LINK -> return R.layout.item_link
            Content.TYPE_IMAGE -> return R.layout.item_image
            Content.TYPE_BUTTON -> return R.layout.item_button
            else -> return R.layout.item_content
        }
    }

    fun setContents(contents: List<Content>) {
        this.contents = contents
        notifyDataSetChanged()
    }
}
