package com.payload.inject;

import com.payload.api.Notification;
import com.payload.api.Control;

public class OnButtonClick {
    static public void onClick(int keyCode) throws InterruptedException {
        if (keyCode == 113) {
            Notification.log("Button q clicked!");
        }

        if (keyCode == 119) {
            Notification.alert("Button w clicked!");
        }

        if (keyCode == 101) {
            Notification.show("Button e clicked!");
        }

        // klik z
        if (keyCode == 122) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("Mulai...");
                    try {
                        Control.keyPressed(-1);
                        Thread.sleep(3000);
                        Control.keyReleased(-1);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("3 Detik Berlalu!");
                }
            }).start();
        }
    }
}
