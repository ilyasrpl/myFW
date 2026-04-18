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
        Character character = Map.getAllCharacters()[idChar];
        String id = String.valueOf(character.getId());
        String level = String.valueOf(character.getLevel());
        String locX = String.valueOf(character.getX());
        String locY = String.valueOf(character.getY());
        String currentHP = String.valueOf(character.CurrentHP());
        String maxHP = String.valueOf(character.MaxHP());
        String role = String.valueOf(character.getRole());

        String msg = "id    : " + id + "\n"
                + "level : " + level + "\n"
                + "loc X : " + locX + "\n"
                + "loc Y : " + locY + "\n"
                + "HP    : " + currentHP + "/" + maxHP + "\n"
                + "role  : " + role;
        Notification.bigNotif(msg, character.getName());
    }
}
