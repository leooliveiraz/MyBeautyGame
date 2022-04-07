package br.com.leorocha.gameServer.enums;

public enum MessageTypeENUM {
    CONNECTING_TCP(1),
    CONNECTING_UDP(2),
    ;

    public int id;

    MessageTypeENUM(Integer id) {
        this.id = id;
    }

    public static MessageTypeENUM getType(int id) {
        for (MessageTypeENUM e : values()) {
            if (e.id == (id)) {
                return e;
            }
        }
        return null;
    }



}
