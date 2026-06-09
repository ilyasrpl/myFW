package com.myfw;

public class Main {

    public static void main(String[] args) {
        try {
            com.myfw.patcher.MainCanvas.main();
            com.myfw.patcher.GameEngine.main();
            com.myfw.patcher.MyCharacter.main();
            com.myfw.patcher.ButtonMenu.main();
            com.myfw.patcher.MsgFromServer.main();
            com.myfw.patcher.Server.main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}