package com.rasitesdmr.springbootwebsocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker      // Bu Açıklama Projemizde websocket'i etkinleştirmemize izin verir
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
/*
    WebSocketMessageBrokerConfigurer : WebSocket istemcilerinden gelen basit mesajlaşma protokolleri
    ile mesaj işlemeyi yapılandırma yöntemlerini tanımlar.
*/

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS();
    /*
         registerStompEndpoints : Websocket uç nokta bağlantısını WebSocket'e ayarlamak için kullanacağımız yöntemdir.

         uç noktalar : Uç nokta bir ağa bağlanan veya bir ağ üzerinden iletişim kurulan her türlü cihaza denir.
                       Diğer bilişim cihazlarının bir ağa bağlanmasını sağlayan
                       anahtarlar ve yönlendiriciler de uç noktalar olarak nitelendirilir.

         addEndpoint("/chat") : chat adında endpoint pathm olsum,

         setAllowedOriginPatterns("*") : Nerden bu endpointi çağırılırsa çağrılsın buna cevap verilsin gibi izin veriyoruz.
                                         Kim gelirse gelsin bağlanabilsin.

         withSockJS() : buna bağlanırken sockjs kullansın.
    */
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
/*
 chat' e mesajı gönderecem . sunucum dinliyor.
 topic mesajı alacam. client dinliyor.
*/