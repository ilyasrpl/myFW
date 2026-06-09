// for class MsgFromServer (er)

package com.myfw.patcher;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import com.myfw.AsmClass.AsmClass;

public class MsgFromServer {
    public static void main() throws Exception {
        String inputPath = PathConfig.init().getPathOri("er.class");
        String outputPath = PathConfig.init().getPathMod("er.class");

        AsmClass msgClass = new AsmClass(inputPath);

        msgClass.field("b").setToPublic();
        msgClass.field("c").setToPublic();

        msgClass.method("G", "(Lep;)V")
                .clear()
                .atStart(mv -> {
                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/api/MsgHandler",
                            "message",
                            "(Lep;)V",
                            false);
                    mv.visitInsn(Opcodes.RETURN);
                });

        msgClass.method("v", "(Lep;)V")
                .clear()
                .atStart(mv -> {
                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/api/MsgHandler",
                            "menuSpawn",
                            "(Lep;)V",
                            false);
                    mv.visitInsn(Opcodes.RETURN);
                });

        msgClass.method("P", "(Lep;)V")
                .atStart(mv -> {
                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/api/MsgHandler",
                            "diePlayer",
                            "(Lep;)Lep;",
                            false);
                    mv.visitVarInsn(Opcodes.ASTORE, 0);
                });

        msgClass.method("al", "(Lep;)V")
                .clear()
                .atStart(mv -> {
                    mv.visitVarInsn(Opcodes.ALOAD, 0);
                    mv.visitVarInsn(Opcodes.ALOAD, 1);
                    // is non static, so the first argument is the instance of the class, which is
                    // 'this' in this case
                    mv.visitMethodInsn(Opcodes.INVOKESTATIC,
                            "com/payload/api/MsgHandler",
                            "modalSpawn",
                            "(Ler;Lep;)V",
                            false);
                    mv.visitInsn(Opcodes.RETURN);
                });

        msgClass.save(outputPath, ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    }
}
