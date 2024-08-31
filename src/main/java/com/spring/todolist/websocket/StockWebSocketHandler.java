package com.spring.todolist.websocket;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

@Component
public class StockWebSocketHandler extends TextWebSocketHandler {

//    @Autowired
    private StockService stockService = new StockService();

    private Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws JSONException {
        String payload = message.getPayload();
        // Assuming the payload contains the stock symbol
        String symbol = payload.trim();
        String stockData = stockService.getStockData(symbol).toString();

        try {
            sendStockUpdate(stockData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendStockUpdate(String stockData) throws Exception {
        for (WebSocketSession session : sessions) {
            if (session.isOpen()) {
                session.sendMessage(new TextMessage(stockData));
            }
        }
    }
}
