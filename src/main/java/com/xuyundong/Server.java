package com.xuyundong;

interface HTTP {
    String get(String req);
}

public class Server {
    public void service(HTTP xff) {
        String resp = xff.get("");
    }
}
