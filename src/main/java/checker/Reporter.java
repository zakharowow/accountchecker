package checker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static checker.ExceptionAssistant.writeExceptionInLog;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Reporter {
    static void sendReport(Provider provider, String message) {
        ChatBot chatBot = new ChatBot();
        baseURI = "https://api.telegram.org/bot%s/sendMessage";
        baseURI = String.format(baseURI, chatBot.getToken());
        Map<String, String> body = new HashMap<>();
        body.put("chat_id", chatBot.getChatId());
        body.put("text", message);
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            json = "{\"chat_id\":" + chatBot.getChatId() + ", \"text\":\"Ошибка создания тела сообщения " + provider.getName() + ".\"}";
            writeExceptionInLog(e);
        }
        given().contentType("application/json; charset=utf-8").body(json).when().post();
    }
}
