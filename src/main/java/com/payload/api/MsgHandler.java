package com.payload.api;

import com.payload.inject.onMessage;
import com.stub.df;
import com.stub.ep;
import com.stub.fu;
import com.stub.q;

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

    public static void send(String nickname, String msg) {
        q.a().a(nickname, msg);
    }
}
