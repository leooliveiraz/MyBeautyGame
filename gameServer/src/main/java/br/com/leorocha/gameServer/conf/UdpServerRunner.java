package br.com.leorocha.gameServer.conf;


import br.com.leorocha.gameServer.controller.SessionController;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.DatagramPacket;
import java.time.LocalTime;

public class UdpServerRunner implements Runnable{
    private Thread thread;
    private boolean isRunning;
    private int i = 0;
    DatagramPacket DpReceive = null;

    @SneakyThrows
    @Override
    public void run() {
        this.loopingMensagens();
    }

    public void loopingMensagens() throws IOException {
        UdpServer.initialize();
        System.out.println("Aguardando mensagens UDP...");
        while (true)
        {

            // Step 2 : create a DatgramPacket to receive the data.
            DpReceive = new DatagramPacket(UdpServer.receive, UdpServer.receive.length);
            // Step 3 : revieve the data in byte buffer.
            UdpServer.socket.receive(DpReceive);
            String idConn = DpReceive.getAddress().getHostName()+":"+DpReceive.getPort();
            SessionController.addSessionUDP(idConn);

            String receivedData = data(UdpServer.receive).toString();

            UdpServer.cleanReceiveData();
        }

    }

    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
    public synchronized void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

}

