package com.rasitesdmr.springbootwebsocket.controller;

import com.rasitesdmr.springbootwebsocket.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    // Mesajı kendimiz özelleştirip gönderebiliyoruz. Aslında bu annotation @SendTo, @SendToUser arka planda bunu göndererek yapıyor
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/chat") // Dışarıdan gelen mesajları bu şekilde map ederiz.
    //@SendTo("/topic") // Mesajları herkese gönder.
    //@SendToUser // Bir tane user' a gönder
    public void chatEndpoint(@Payload Message message) {
        System.out.println(message);
        simpMessagingTemplate.convertAndSend("/topic", message);
    /*
        convertAndSend("/topic" ,message) : Ben bu mesajlarımı topic adreslerine göndericem, Neyi gönderecem : message
        Arayüzden biri bu endpointe mesaj gönderdimi ilk başta konsola yazdırıyorum sonra tüm client'lara yolluyorum.
    */

    }

}
