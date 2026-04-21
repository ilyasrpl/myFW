package com.payload.inject;

import com.payload.api.MyCharacter;
import com.payload.api.Notification;
import com.payload.api.ActiveMenu;
import com.payload.api.MsgHandler;

public class onMessage {
    public static String session;

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

        if ("tele".equals(parts[0])) {
            MyCharacter.talkTo((byte) 246);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        int timeout = 0;
                        // Tunggu sampai menu terbuka DAN berisi data
                        while (timeout < 50) { // Timeout 5 detik (50 * 100ms)
                            if (ActiveMenu.isOpen() && ActiveMenu.menus.length() > 0) {
                                break;
                            }
                            Thread.sleep(100);
                            timeout++;
                        }

                        int len = ActiveMenu.menus.length();
                        if (len == 0) {
                            MsgHandler.send(nick, "Menu tidak ditemukan atau kosong.");
                            return;
                        }

                        for (int i = 0; i < len; i++) {
                            String label = ActiveMenu.menus.getMenuLabel(i);
                            MsgHandler.send(nick, i + ": " + label);
                        }
                        MsgHandler.send(nick, "Selesai memuat menu.");
                        session = "tele";
                    } catch (Exception ex) {
                        Notification.alert("Error: " + ex.getMessage());
                    }
                }
            }).start();
            return;
        }

        if (session.equals("tele")) {
            byte idNPCteleport = (byte) 246;
            MyCharacter.talkTo((short) idNPCteleport, (byte) 0, Byte.parseByte(parts[0]));
            session = null;
        }
    }
}
