package com.myfw;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;

public class StubRemover {

    public static byte[] removeStubPackage(byte[] classBytes) {
        ClassReader cr = new ClassReader(classBytes);
        ClassWriter cw = new ClassWriter(cr, 0);

        Remapper remapper = new Remapper() {
            @Override
            public String map(String internalName) {
                if (internalName.startsWith("com/stub/")) {
                    return internalName.substring(9);
                }
                return super.map(internalName);
            }
        };

        // Tambahkan Opcodes.ASM9 dan kurung kurawal {} di akhir
        // Ini membuat anonymous class yang bisa mengakses protected constructor
        ClassRemapper adapter = new ClassRemapper(Opcodes.ASM9, cw, remapper) {
        };

        cr.accept(adapter, 0);
        return cw.toByteArray();
    }

    public static void main(String[] args) {
        String currentPath = new java.io.File("").getAbsolutePath();
        String dirPath = currentPath + "/tmp/mod/com/payload/api";
        java.io.File dir = new java.io.File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            java.io.File[] files = dir.listFiles((d, name) -> name.endsWith(".class"));
            if (files != null) {
                for (java.io.File file : files) {
                    try {
                        String inputPath = file.getAbsolutePath();
                        byte[] originalBytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(inputPath));
                        byte[] modifiedBytes = removeStubPackage(originalBytes);
                        String outputPath = inputPath; // Tulis kembali ke file yang sama
                        java.nio.file.Files.write(java.nio.file.Paths.get(outputPath), modifiedBytes);
                        System.out.println("Stub package removed and class saved to: " + outputPath);
                    } catch (Exception e) {
                        System.err.println("Error processing file: " + file.getName());
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No .class files found in directory: " + dirPath);
            }
        } else {
            System.out.println("Directory does not exist: " + dirPath);
        }
    }
}