package com.payload.api;

import com.payload.inject.onMessage;
import com.stub.*;

public class MsgHandler {

    public static void message(ep msg) {
        try {
            String var1 = msg.b().readUTF();
            String var3;
            if ((var3 = msg.b().readUTF()) != null && var3.trim().length() != 0) {
                if (var1.compareTo(df.cA) == 0) {
                    fu.g.a(var1, df.ex + ": ", var3, (byte) 1, false);
                } else if (var1.compareTo(df.eV) == 0) {
                    fu.g.a(var1, "", var3, (byte) 1, false);
                } else if (var1.compareTo(df.eW) == 0) {
                    fu.g.a(var1, "", var3, (byte) 0, false);
                } else if (var1.compareTo(df.aT) == 0) {
                    fu.g.a(var1, "", var3, (byte) 0, false);
                } else {
                    onMessage.msg(var1, var3);
                    fu.g.a(var1, var1 + ": ", var3, (byte) 0, false);
                }
            }
        } catch (Exception var2) {
        }
    }

    public static void menuSpawn(ep var0) {
        try {
            ActiveMenu.menus.d();
            short var1 = var0.b().readShort();
            byte var2 = var0.b().readByte();
            byte var3 = var0.b().readByte();
            et var4 = new et("ReadMessenge cmd");
            for (int var5 = 0; var5 < var3; ++var5) {
                String menu = var0.b().readUTF();
                ActiveMenu.menus.add(menu);
                bt var6 = new bt(menu, (dl) null);
                var4.a(var6);
            }
            String var8 = var0.b().readUTF();
            fu.p.a(ActiveMenu.menus, 2, var2, var1, var8);
        } catch (Exception var7) {
            Notification.alert(var7.getMessage());
        }
    }

    public static void modalSpawn(er var0, ep var1) {
        try {
            fu.j();
            var0.b = var1.b().readShort();
            var0.c = var1.b().readByte();
            String var4 = var1.b().readUTF();

            // for revive response
            if (MyCharacter.isWaitingForResponse) {
                MyCharacter.isWaitingForResponse = false;
                q.a().c(var0.b, var0.c, (byte) 1);
                return;
            }

            et var2 = new et("ReadMessenge vec4");
            var2.a((Object) new bt("Ok", 2, 1, var0));
            var2.a(new bt("Batal", 2, 0, var0));
            fu.a(var4, var2);
        } catch (Exception var5) {
            Notification.alert(var5.getMessage());
        }
    }

    public static void send(String nickname, String msg) {
        q.a().a(nickname, msg);
    }
}
