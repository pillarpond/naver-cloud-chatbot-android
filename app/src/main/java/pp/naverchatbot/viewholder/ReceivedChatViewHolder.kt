package pp.naverchatbot.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import pp.naverchatbot.ContentAdapter
import pp.naverchatbot.databinding.ItemReceivedChatBinding
import pp.naverchatbot.model.Chat

class ReceivedChatViewHolder internal constructor(binding: ViewDataBinding, recycledViewPool: RecyclerView.RecycledViewPool) : ChatViewHolder(binding.root) {
    private val contentAdapter: ContentAdapter

    init {

        val recyclerView = (binding as ItemReceivedChatBinding).contentList
        contentAdapter = ContentAdapter()
        recyclerView.adapter = contentAdapter
        recyclerView.setRecycledViewPool(recycledViewPool)
    }

    override fun bind(obj: Any) {
        val contents = (obj as Chat).getContents()
        contentAdapter.setContents(contents)
    }
}
