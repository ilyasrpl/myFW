package com.payload.api;

import com.stub.*;

public class ServerHandler {
    private static boolean isRun = false;
    public static boolean isWaitingPetResponse = false;

    public static void start() {
        if (f.a) {
            new t();
            fu.P = "http://knightageonline.com/srvip/indo.php";
            dx.b = new String[][] { { "Indo Naga", "hsindo.teamobi.com" },
                    { "Indo Garuda(new)", "hsindo20.teamobi.com" },
                    { "proxy", "127.0.0.1" },
            };
        }

        new Thread(new Runnable() {
            public void run() {
                if (isRun)
                    return;

                isRun = true;
                while (true) {
                    try {
                        Thread.sleep(5000);
                        if (Screen.kondisi1() == 0) {
                            continue;
                        }
                        Item[] items = Inventory.getMyItems();
                        for (int i = 0; i < items.length; i++) {
                            if (items[i].getType() == 3 &&
                                    (items[i].getColor() == 1 || items[i].getColor() == 2) &&
                                    items[i].getUpLevel() == 0) {
                                MyCharacter.feedingPetWithEquip(items[i].getId());
                                isWaitingPetResponse = true;
                                break;
                            }
                        }
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
    }
}
