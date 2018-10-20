package pp.naverchatbot.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import pp.naverchatbot.R

import pp.naverchatbot.model.Chat

object ChatViewHolderFactory {
    fun getItemLayoutId(type: Int): Int {
        when (type) {
            Chat.TYPE_RECEIVED -> return R.layout.item_received_chat
            else -> return R.layout.item_sent_chat
        }
    }

    fun getViewHolder(type: Int, binding: ViewDataBinding, pool: RecyclerView.RecycledViewPool): ChatViewHolder {
        when (type) {
            Chat.TYPE_RECEIVED -> return ReceivedChatViewHolder(binding, pool)
            else -> return SentChatViewHolder(binding)
        }
    }
}
