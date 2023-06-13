package org.example;

import jdk.dynalink.linker.LinkerServices;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.swing.text.html.HTML;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "javaIq300bot";
    }

    @Override
    public String getBotToken() {
        return "5834114064:AAEwoigPGl2gPOtrDWt1ePLV4vEFC7IyhPQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            Message message = update.getMessage();
            User user = message.getFrom();

            SendMessage sendMessage = new SendMessage();
            Long chatId1 = message.getChatId();
            sendMessage.setChatId(String.valueOf(chatId1));

            String firstName = user.getFirstName();
            sendMessage.setText(" Assalomu Alaykum " + firstName + " \n Java dasturlash tilidan interwiev question \n savollariga tayyormisiz?");
            sendMessage.enableHtml(true);
            sendMessage.setParseMode(ParseMode.MARKDOWN);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);

            List<KeyboardRow> keyboardRowList = new ArrayList<>();

            KeyboardRow uzbekKeyboard = new KeyboardRow();
            uzbekKeyboard.add(new KeyboardButton("Ha"));
            keyboardRowList.add(uzbekKeyboard);

            KeyboardRow englishKeyboard = new KeyboardRow();
            englishKeyboard.add(new KeyboardButton("Yo'q"));
            keyboardRowList.add(englishKeyboard);

            replyKeyboardMarkup.setKeyboard(keyboardRowList);
            sendMessage.setReplyMarkup(replyKeyboardMarkup);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            if (update.hasMessage() && update.getMessage().hasText()) {
                String text = update.getMessage().getText();
                Long chatId = update.getMessage().getChatId();
                if (text.equals("Yo'q")) {

                    SendDocument sendDocument = new SendDocument();
                    sendDocument.setChatId(String.valueOf(chatId));
                    sendDocument.setDocument(new InputFile(new File("docs/interviewquestion.txt")));
                    try {
                        execute(sendDocument);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Ha")) {

                    List<KeyboardRow> keyboardRowList1 = new ArrayList<>();
                    KeyboardRow buttons1 = new KeyboardRow();
                    buttons1.add(new KeyboardButton("Darsdagi intervyu savollar"));
                    keyboardRowList1.add(buttons1);

                    KeyboardRow buttons2 = new KeyboardRow();
                    buttons2.add(new KeyboardButton("Interviewbitdag savollar"));
                    keyboardRowList1.add(buttons2);

                    replyKeyboardMarkup.setKeyboard(keyboardRowList1);
                    sendMessage.setReplyMarkup(replyKeyboardMarkup);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
