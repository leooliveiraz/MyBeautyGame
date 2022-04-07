package br.com.leorocha.gameServer.handlers;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

import br.com.leorocha.gameServer.controller.SessionController;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


public class WebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
		String payload = message.getPayload();
//	    socketHandler.handler(session, payload);

    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        String payload = StandardCharsets.UTF_8.decode(message.getPayload()).toString();
//        socketHandler.handler(session, payload);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        SessionController.addSessionTCP(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        SessionController.removeSessionTCP(session);
    }

}

