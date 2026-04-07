// for class fu (GameEngine)

package com.myfw.patcher;

import org.objectweb.asm.Opcodes;

import com.myfw.AsmClass.AsmClass;

public class GameEngine {
    public static void main() throws Exception {
        String inputPath = PathConfig.init().getPathOri("fu.class");
        String outputPath = PathConfig.init().getPathMod("fu.class");

        AsmClass GameEngineClass = new AsmClass(inputPath);

        GameEngineClass
                .method("a", "(Lbl;)V")
                .atEnd(mv -> {
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/inject/Render",
                            "render",
                            "()V",
                            false);
                });

        GameEngineClass.field("ao").setToPublic();
        GameEngineClass.save(outputPath);
    }
}
