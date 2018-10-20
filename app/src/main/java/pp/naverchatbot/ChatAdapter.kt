package pp.naverchatbot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import pp.naverchatbot.model.Chat
import pp.naverchatbot.viewholder.ChatViewHolder
import pp.naverchatbot.viewholder.ChatViewHolderFactory

class ChatAdapter internal constructor() : RecyclerView.Adapter<ChatViewHolder>() {
    private val chats = ArrayList<Chat>()
    private val recycledViewPool: RecyclerView.RecycledViewPool

    init {
        recycledViewPool = RecyclerView.RecycledViewPool()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val resId = ChatViewHolderFactory.getItemLayoutId(viewType)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context), resId, parent, false)
        return ChatViewHolderFactory.getViewHolder(viewType, binding, recycledViewPool)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chats[position]
        holder.bind(chat)
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    override fun getItemViewType(position: Int): Int {
        val chat = chats[position]
        return chat.type
    }

    fun add(chat: Chat): Int {
        chats.add(chat)
        notifyItemInserted(chats.size - 1)

        return chats.size - 1
    }
}
