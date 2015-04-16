package org.jva.websocket.servlet;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.jva.websocket.socket.ChatWebSocket;

@WebServlet(urlPatterns = "/initServlet", loadOnStartup = 1)
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 4282441926033579905L;

	@Override
	public void init() throws ServletException {
		//TODO Descomentar para testar
		//(new DateSendThreadExemplo()).start();
	}

	public class DateSendThreadExemplo extends Thread {
		//Batch apenas fica enviando uma mensagem para o websocket de tempo em tempo
		public void run() {
			while (true) {
				try {
					sleep(10000);
					ChatWebSocket.sendMessage(new Date().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
