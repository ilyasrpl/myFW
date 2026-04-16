package com.payload.inject;

import com.payload.api.*;
import com.payload.api.Character;

public class CharacterList extends BaseMenu {
    public CharacterList() {
        listMenu = new ListMenu();
        Character[] characters = Map.getAllCharacters();
        for (int i = 0; i < characters.length; i++) {
            listMenu.add(characters[i].getName(), i);
        }
    }

    @Override
    public String getTitle() {
        return "Character List";
    }

    @Override
    public int getMenuType() {
        return 2;
    }

    public void onMenuSelected(int idChar) {
        Character[] characters = Map.getAllCharacters();
        Character character = characters[idChar];
        String msg = "level : " + String.valueOf(character.getLevel()) + "\n"
                + "loc X : " + String.valueOf(character.getX()) + "\n"
                + "loc Y : " + String.valueOf(character.getY()) + "\n"
                + "HP    : " + String.valueOf(character.CurrentHP()) + "/" + String.valueOf(character.MaxHP());
        Notification.bigNotif(msg, character.getName());
    }
}
