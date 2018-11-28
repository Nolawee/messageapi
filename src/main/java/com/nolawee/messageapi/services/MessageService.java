package com.nolawee.messageapi.services;

import com.nolawee.messageapi.dto.MessageDto;
import com.nolawee.messageapi.model.ErrorMessage;
import com.nolawee.messageapi.model.Message;
import com.nolawee.messageapi.model.Hash;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    public Hash createNewMessage(String text, List<Message> messages) {

        Message message = new Message();
        Hash hash = new Hash(text);
        message.setText(text);
        hash.getDigest();


        message.setHash(hash);
        messages.add(message);

        return hash;
    }

    public String getMessage(String hash, List<Message> messages) {
        Message messageToTransform = messages.stream().filter(message -> message.getHash().getDigest().equals(hash)).findFirst().get();
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(messageToTransform.getText());
        return messageDto.getMessage();
    }

    public String errorMessage() {
        ErrorMessage errorMessage = new ErrorMessage();
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(errorMessage.getErr_msg());
        return messageDto.getMessage();
    }

    // Check Duplicates
    public boolean checkDuplicates(String text, List<Message> messages) {
        boolean check = messages.stream().anyMatch(message -> message.getText().equals(text));
        if (check)
            return true;
        else
            return false;

    }

}
