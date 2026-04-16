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
}
