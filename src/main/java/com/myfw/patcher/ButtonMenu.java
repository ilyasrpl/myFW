// for class cf (ButtonMenu)

package com.myfw.patcher;

import com.myfw.AsmClass.AsmClass;

public class ButtonMenu {
    public static void main() throws Exception {
        String inputPath = PathConfig.init().getPathOri("cf.class");
        String outputPath = PathConfig.init().getPathMod("cf.class");

        AsmClass buttonMenuClass = new AsmClass(inputPath);

        buttonMenuClass.method("f", "(I)V").setToPublic();
        buttonMenuClass.field("aN").setToPublic();

        buttonMenuClass.save(outputPath);
    }
}
