package com.myfw.AsmClass;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public class FieldEditor {
    private final FieldNode node;

    public FieldEditor(FieldNode node) {
        this.node = node;
    }

    public FieldEditor setToPublic() {
        int accessMask = Opcodes.ACC_PUBLIC | Opcodes.ACC_PRIVATE | Opcodes.ACC_PROTECTED;
        node.access = (node.access & ~accessMask) | Opcodes.ACC_PUBLIC;
        return this;
    }
}