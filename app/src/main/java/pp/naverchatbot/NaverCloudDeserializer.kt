package pp.naverchatbot

import com.google.gson.*
import pp.naverchatbot.model.*
import java.lang.reflect.Type

class NaverCloudDeserializer : JsonDeserializer<Chat> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Chat {
        val gson = Gson()
        val chat = gson.fromJson(json, Chat::class.java)

        val contents = chat.getContents()
        contents.clear()

        getContents(gson, contents, json)
        return chat
    }

    private fun getContents(gson: Gson, contents: MutableList<Content>, json: JsonElement) {
        val jsonObject = json.asJsonObject
        val jsonArray = jsonObject.get("content").asJsonArray

        for (jsonElement in jsonArray) {
            val type = jsonElement.asJsonObject.get("type").asString

            when (type) {
                Content.TYPE_TEXT -> {
                    val text = gson.fromJson(jsonElement, Text::class.java)
                    contents.add(text)
                }

                Content.TYPE_LINK -> {
                    val link = gson.fromJson(jsonElement, Link::class.java)
                    contents.add(link)
                }

                Content.TYPE_IMAGE -> {
                    val image = gson.fromJson(jsonElement, Image::class.java)
                    contents.add(image)
                }

                Content.TYPE_BUTTON -> {
                    val button = gson.fromJson(jsonElement, Button::class.java)
                    contents.add(button)
                }

                Content.TYPE_GROUP -> {
                    val content = gson.fromJson(jsonElement, Content::class.java)
                    contents.add(content)

                    val data = jsonElement.asJsonObject.get("data")
                    getContents(gson, contents, data)
                }
            }
        }
    }
}