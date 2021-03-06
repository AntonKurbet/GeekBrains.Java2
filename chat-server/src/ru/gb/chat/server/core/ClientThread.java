package ru.gb.chat.server.core;

import ru.gb.chat.common.Common;
import ru.gb.chat.network.SocketThread;
import ru.gb.chat.network.SocketThreadListener;

import java.net.Socket;

public class ClientThread extends SocketThread {

    private String nickname;
    private boolean isAuthorized;

    public ClientThread(SocketThreadListener listener, String name, Socket socket) {
        super(listener, name, socket);
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    void authAccept(String nickname) {
        isAuthorized = true;
        this.nickname = nickname;
        sendMessage(Common.getAuthAccept(nickname));
    }

    void authFail() {
        sendMessage(Common.getAuthDenied());
        close();
    }

    void msgFormatError(String msg) {
        sendMessage(Common.getMsgFormatError(msg));
        close();
    }

}
