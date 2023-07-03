package org.example;

import com.pkslow.ai.AIClient;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.ai.domain.Answer;

public class BardAiApiConnect {
    private static final AIClient aiClient = new GoogleBardClient("XQg3EgT6L3GODPHgYeWNQ6PxyiUJDIWu-zodGIyJpo9dkYPyttO3S_P-avFW1igWIl8MUw.");
    public static String getAnswerFromBard(String message) {
        String question = Translator.translateToEnglish(message);
        Answer answer = aiClient.ask(question);
        return answer.getChosenAnswer();
    }


}

