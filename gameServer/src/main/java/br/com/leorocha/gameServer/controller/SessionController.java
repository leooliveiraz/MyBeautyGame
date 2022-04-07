package br.com.leorocha.gameServer.controller;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.HashSet;

@Data
public class SessionController {
    private static Logger logger = LoggerFactory.getLogger(SessionController.class);

    private static HashSet<String> udpSession = new HashSet<>();
    private static HashMap<String, WebSocketSession> tcpSessions = new HashMap<>();


    public static void addSessionUDP(String idConnection){
        if(!udpSession.contains(idConnection)){
            udpSession.add(idConnection);
        }
    }

    public static void addSessionTCP(WebSocketSession session){
        if(!tcpSessions.containsKey(session.getId())){
            tcpSessions.put(session.getId(), session);
        }
    }

    public static void removeSessionUDP(String idConnection){
        if(udpSession.contains(idConnection)){
            udpSession.remove(idConnection);
        }
    }

    public static void removeSessionTCP(WebSocketSession session){
        if(tcpSessions.containsKey(session.getId())){
            tcpSessions.remove(session.getId());
        }
    }

}
