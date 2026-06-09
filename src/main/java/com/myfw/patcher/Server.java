package com.myfw.patcher;

import org.objectweb.asm.Opcodes;
import com.myfw.AsmClass.AsmClass;

public class Server {
    public static void main() throws Exception {
        String inputPath = PathConfig.init().getPathOri("f.class");
        String outputPath = PathConfig.init().getPathMod("f.class");

        AsmClass serverClass = new AsmClass(inputPath);

        serverClass.method("a", "()V")
                .clear()
                .atStart(mv -> {
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/api/ServerHandler",
                            "start",
                            "()V",
                            false);
                    mv.visitInsn(Opcodes.RETURN);
                });

        serverClass.save(outputPath);
    }
}