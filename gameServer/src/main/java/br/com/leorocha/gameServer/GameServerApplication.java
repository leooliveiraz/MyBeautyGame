package br.com.leorocha.gameServer;

import br.com.leorocha.gameServer.conf.UdpServerRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameServerApplication.class, args);
		System.out.println("Server has started!");
		UdpServerRunner udpServerRunner = new UdpServerRunner();
		udpServerRunner.start();
	}

}
