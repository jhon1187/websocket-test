package org.jva.websocket.servlet;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.jva.websocket.socket.ChatWebSocket;

@WebServlet("/webSocketChat")
public class WebSocketChatServlet extends WebSocketServlet {

	private static final long serialVersionUID = -1776044269459026130L;
	
	public final Set<ChatWebSocket> users = new CopyOnWriteArraySet<ChatWebSocket>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getNamedDispatcher("default").forward(request, response);
	}

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
		return new ChatWebSocket(users);
	}

}
