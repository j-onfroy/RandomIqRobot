package org.example;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class Translator {
    private final static String API_KEY = "AIzaSyDjyh5Mw0XSDZDEajVdHGeKucBL6uVJtuY";
    private final static String TARGET_LANGUAGE = "en";

    public static String translateToEnglish(String textToTranslate) {

        Translate translate = TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
        Translation translation = translate.translate(textToTranslate, Translate.TranslateOption.targetLanguage(TARGET_LANGUAGE));

        return translation.getTranslatedText();
    }

    public static String translateToUzbek(String chosenAnswer) {
        Translate translate = TranslateOptions.newBuilder().setApiKey(API_KEY).build().getService();
        Translation translation = translate.translate(chosenAnswer,Translate.TranslateOption.targetLanguage("uz"));
        return translation.getTranslatedText();
    }
}
