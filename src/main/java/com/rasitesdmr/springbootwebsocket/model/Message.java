package com.rasitesdmr.springbootwebsocket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
    private String sender; // Kimden geldiği.
    private String message; // mesajımızın kendisi olsun.

    /*
     Websocket yapılandırmasını tamamladıktan sonra,
     WebSocket'ten payload için bir model oluşturmalıyız.
*/
}
