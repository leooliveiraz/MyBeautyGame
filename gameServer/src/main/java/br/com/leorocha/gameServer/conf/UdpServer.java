package br.com.leorocha.gameServer.conf;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

    public static DatagramSocket socket;
    public static byte[] receive = new byte[65535];
    public static byte[] sendData = new byte[65535];

    public static void initialize() throws SocketException {
        System.out.println("Initializating UDP Server.");
        socket = new DatagramSocket(1234);
        System.out.println("UDP Server has started.");
    }

    public static void cleanReceiveData(){
        receive = new byte[65535];
    }
    public static void cleanSendData(){
        receive = new byte[65535];
    }
}