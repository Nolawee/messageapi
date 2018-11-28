package com.nolawee.messageapi.controllers;

import com.nolawee.messageapi.dto.MessageDto;
import com.nolawee.messageapi.model.Hash;
import com.nolawee.messageapi.model.Message;
import com.nolawee.messageapi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    private MessageService messageService;

    private List<Message> messages = new ArrayList<>();

    @PostMapping("/messages")
    public ResponseEntity<Hash> createNewMessage(@RequestBody String text) {
        Hash hash = messageService.createNewMessage(text, messages);
        return new ResponseEntity<Hash>(hash, HttpStatus.OK);
    }

    @GetMapping("/messages/{hash}")
    public ResponseEntity<String> getMessage(@PathVariable("hash") String hash) {


        String message = messageService.getMessage(hash, messages);
        if (message.isEmpty() || message == null) {
            String errorMessage = messageService.errorMessage();
            return new ResponseEntity<String>(errorMessage, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>(message,HttpStatus.OK);
    }


    // Create Exception Handle
    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "Hash not found not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }
}
