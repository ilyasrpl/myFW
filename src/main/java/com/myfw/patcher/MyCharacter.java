package com.myfw.patcher;

import com.myfw.AsmClass.AsmClass;

public class MyCharacter {
    public static void main() throws Exception {
        System.err.println("myCharacter patching started...");
        String inputPath = PathConfig.init().getPathOri("cn.class");
        String outputPath = PathConfig.init().getPathMod("cn.class");

        AsmClass myCharacterClass = new AsmClass(inputPath);

        myCharacterClass.deleteFinal();
        myCharacterClass.method("a", "(Lbx;)V").deleteFinal();
        myCharacterClass.method("a", "(II)V").deleteFinal();

        myCharacterClass.save(outputPath);
    }
}