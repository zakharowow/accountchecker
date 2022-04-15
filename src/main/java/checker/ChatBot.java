package checker;

import io.restassured.path.json.JsonPath;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static checker.GetDataAssistant.getData;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ChatBot {
    @NonNull
    @Getter
    String token, chatId;

    ChatBot() {
        JsonPath botData = JsonPath.from(getData("botData"));
        this.token = botData.getString("botToken");
        this.chatId = botData.getString("chatId");
    }
}
