package com.payload.inject;

import com.payload.api.Notification;
import com.payload.api.UiButton;
import com.payload.api.MyCharacter;
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

        // klik x
        if (keyCode == 120) {
            UiButton.openAutoFungsi();
        }

        // klik c
        if (keyCode == 99) {
            UiButton.openKuda();
        }

        // klik v
        if (keyCode == 118) {
            new MenuExample().render();
        }

        // klik b
        if (keyCode == 98) {
            Notification.alert(
                    String.valueOf(MyCharacter.getLocationX()) + ", " + String.valueOf(MyCharacter.getLocationY()));
        }

        // klik n
        if (keyCode == 110) {
            MyCharacter.changeFocus();
        }

        // klik m
        if (keyCode == 109) {
            // contoh, di map tepi hutan menuju gua api
            MyCharacter.moveTo(9, 31);
        }

        // klik a
        if (keyCode == 97) {
            MyCharacter.useSkill(0);
        }

        // klik s
        if (keyCode == 115) {
            MyCharacter.useSkill(1);
        }

        // klik d
        if (keyCode == 100) {
            MyCharacter.useSkill(2);
        }

    }
}
