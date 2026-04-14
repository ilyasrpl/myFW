package com.myfw.AsmClass;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AsmClass {
    private final ClassNode classNode;

    public AsmClass(String classPath) throws IOException {
        this.classNode = new ClassNode();
        try (FileInputStream is = new FileInputStream(classPath)) {
            ClassReader cr = new ClassReader(is);
            cr.accept(classNode, 0);
        }
    }

    public MethodEditor method(String name, String desc) {
        MethodNode target = classNode.methods.stream()
                .filter(m -> m.name.equals(name) && m.desc.equals(desc))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Method not found: " + name + desc));
        return new MethodEditor(target);
    }

    public FieldEditor field(String name) {
        FieldNode target = null;
        for (FieldNode fn : classNode.fields) {
            if (fn.name.equals(name)) {
                target = fn;
                break;
            }
        }
        if (target == null)
            throw new RuntimeException("Field not found: " + name);
        return new FieldEditor(target);
    }

    public void save(String outputPath) throws IOException {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classNode.accept(cw);
        try (FileOutputStream os = new FileOutputStream(outputPath)) {
            os.write(cw.toByteArray());
        }
    }

    public void save(String outputPath, int flags) throws IOException {
        ClassWriter cw = new ClassWriter(flags) {
            @Override
            protected String getCommonSuperClass(String type1, String type2) {
                try {
                    return super.getCommonSuperClass(type1, type2);
                } catch (Exception e) {
                    return "java/lang/Object";
                }
            }
        };
        classNode.accept(cw);
        try (FileOutputStream os = new FileOutputStream(outputPath)) {
            os.write(cw.toByteArray());
        }
    }

    public void deleteFinal() {
        classNode.access &= ~Opcodes.ACC_FINAL;
    }

}