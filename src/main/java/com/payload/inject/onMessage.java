package com.payload.inject;

import com.payload.api.MyCharacter;
import com.payload.api.Notification;
import com.payload.api.MsgHandler;

public class onMessage {
    public static void msg(String nick, String msg) {

        String[] parts = msg.trim().split("\\s+");

        if ("gold".equals(parts[0])) {
            Notification.alert(parts[0]);
            MsgHandler.send(nick, Long.toString(MyCharacter.getGold()));
        }

        if ("move".equals(parts[0])) {
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            MyCharacter.moveTo(x, y);
        }

        if ("talk".equals(parts[0])) {
            byte idNpc = Byte.parseByte(parts[1]);
            MyCharacter.talkTo(idNpc);
        }

        if ("zone".equals(parts[0])) {
            byte zone = Byte.parseByte(parts[1]);
            MyCharacter.changeZone(zone);
        }
    }
}
