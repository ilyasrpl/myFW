// for class com.silverknight.a (MainCanvas)

package com.myfw.patcher;

import com.myfw.AsmClass.AsmClass;
import org.objectweb.asm.Opcodes;

public class MainCanvas {
    public static void main() throws Exception {
        String inputPath = PathConfig.init().getPathOri("com/silverknight/a.class");
        String outputPath = PathConfig.init().getPathMod("com/silverknight/a.class");

        AsmClass canvasClass = new AsmClass(inputPath);

        // @/com/payload/inject/onButtonClick.onClick(I)V
        canvasClass
                .method("keyPressed", "(I)V")
                .atStart(mv -> {
                    mv.visitVarInsn(Opcodes.ILOAD, 1);
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/inject/OnButtonClick",
                            "onClick",
                            "(I)V",
                            false);
                });

        // for keypad control
        canvasClass.field("c").setToPublic();

        canvasClass.save(outputPath);
    }
}
