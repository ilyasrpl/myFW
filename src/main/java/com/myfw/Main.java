package com.myfw;

public class Main {

    public static void main(String[] args) {
        try {
            com.myfw.patcher.MainCanvas.main();
            com.myfw.patcher.GameEngine.main();
            com.myfw.patcher.MyCharacter.main();
            com.myfw.patcher.ButtonMenu.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}