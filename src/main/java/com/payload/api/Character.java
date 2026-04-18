package com.payload.api;

import com.stub.fa;

public class Character {
    private fa character;

    public Character(fa character) {
        this.character = character;
    }

    public Character() {
        this.character = new fa();
    }

    public int getId() {
        return character.ct;
    }

    public String getName() {
        return character.cB;
    }

    public int getLevel() {
        return character.by;
    }

    public int CurrentHP() {
        return character.br;
    }

    public int MaxHP() {
        return character.bs;
    }

    public int getX() {
        return this.character.aY / 24;
    }

    public int getY() {
        return this.character.aZ / 24;
    }

    public byte getRole() {
        // 3 = player, 0 nonplayer ?
        return this.character.bx;
    }

    // bug, idk why
    public static Character findCharacter(int id) {
        Character[] characters = Map.getAllCharacters();
        for (int i = 0; i < characters.length; i++) {
            if (characters[i].getId() == id) {
                return characters[i];
            }
        }
        return null;
    }
}
