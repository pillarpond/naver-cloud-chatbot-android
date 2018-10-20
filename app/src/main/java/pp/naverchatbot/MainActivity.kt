package pp.naverchatbot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import pp.naverchatbot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val chatAdapter = ChatAdapter()
        binding.chatList.adapter = chatAdapter

        val model = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        model.chat.observe(this, Observer { chat ->
            val position = chatAdapter.add(chat)
            binding.chatList.scrollToPosition(position)
         })

        binding.btnSend.setOnClickListener { view ->
            val editable = binding.editText.text
            binding.editText.setText(null)
            model.send(editable.toString())
        }

        model.open()
    }
}
