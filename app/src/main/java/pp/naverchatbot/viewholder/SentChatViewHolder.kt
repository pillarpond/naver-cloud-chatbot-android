package pp.naverchatbot.viewholder

import androidx.databinding.ViewDataBinding
import pp.naverchatbot.BR
import pp.naverchatbot.model.Chat

class SentChatViewHolder internal constructor(private val binding: ViewDataBinding) : ChatViewHolder(binding.root) {

    override fun bind(obj: Any) {
        val content = (obj as Chat).getContents()[0]

        binding.setVariable(BR.obj, content)
        binding.executePendingBindings()
    }
}