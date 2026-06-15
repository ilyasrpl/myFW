package com.payload.inject;

import com.payload.api.Notification;
import com.payload.api.UiButton;
import com.payload.api.MyCharacter;
import com.payload.api.Control;
import com.payload.api.Inventory;
import com.payload.api.Item;
import com.payload.api.Character;

public class OnButtonClick {
    static public void onClick(int keyCode) throws InterruptedException {
        if (keyCode == 113) {
            Notification.log("Button q clicked!");
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
            // contoh, pakai skill di slot 0, slot arg 0-4
            MyCharacter.useSkill(0);
        }

        // klik s
        if (keyCode == 115) {
            Character character = MyCharacter.getFocus();
            Notification.bigNotif("Focus: " + character.getName() +
                    "\nLevel: " + character.getLevel() +
                    "\nCurrent HP: " + character.CurrentHP() +
                    "\nMax HP: " + character.MaxHP() +
                    "\nRole: " + character.getRole(), "focus");
        }

        // klik d
        if (keyCode == 100) {
            Notification.alert("Can Talk: " + MyCharacter.canTalk());
        }

        // klik f
        if (keyCode == 102) {
            new TextFieldExample().render("Masukkan sesuatu:");
        }

        // klik g
        if (keyCode == 103) {
            new CharacterList().render();
        }

        // klik h
        if (keyCode == 104) {
            MyCharacter.attackMonster();
        }

        // klik j
        if (keyCode == 106) {
            Character character = MyCharacter.getMe();
            Notification.bigNotif("Focus: " + character.getName() +
                    "\nLevel: " + character.getLevel() +
                    "\nCurrent HP: " + character.CurrentHP() +
                    "\nMax HP: " + character.MaxHP() +
                    "\nRole: " + character.getRole(), "focus");
        }

        // klik k
        if (keyCode == 107) {
            MyCharacter.openPetInfo();
        }

        // klik l
        if (keyCode == 108) {
            Item[] items = Inventory.getMyItems();
            StringBuilder itemList = new StringBuilder();
            for (int i = 0; i < items.length; i++) {
                itemList
                        .append(items[i].getName()).append("\n")
                        .append("keyCode: ").append(items[i].getId()).append("\n")
                        .append("Type: ").append(items[i].getType()).append("\n")
                        .append("Color: ").append(items[i].getColor()).append("\n")
                        .append("Upgrade Level: ").append(items[i].getUpLevel()).append("\n\n");
            }
            Notification.bigNotif(itemList.toString(), "Item List");
        }

        // klik w
        if (keyCode == 119) {

        }

    }
}
