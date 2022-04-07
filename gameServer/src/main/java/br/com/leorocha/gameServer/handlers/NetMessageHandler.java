package br.com.leorocha.gameServer.handlers;

import br.com.leorocha.gameServer.enums.MessageTypeENUM;

import java.util.ArrayList;
import java.util.List;

public class NetMessageHandler {
    public static void readCommand(String receivedData, int idPlayer) {
        List<String> commands = commandBreaker(receivedData);
        MessageTypeENUM msg = MessageTypeENUM.getType(Integer.parseInt(commands.get(0)));
        System.out.println(commands.toString());
        try{
            switch (msg){
                case CONNECTING_UDP: {
                    System.out.println("lalala");
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> commandBreaker(String receivedData) {
        List<String> commands = new ArrayList<>();
        commands = List.of(receivedData.split(";"));
        return commands;
    }
}
