package com.myfw.AsmClass;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class MethodEditor {
    private final MethodNode node;

    public MethodEditor(MethodNode node) {
        this.node = node;
    }

    public MethodEditor setToPublic() {
        node.access = (node.access & ~Opcodes.ACC_PRIVATE & ~Opcodes.ACC_PROTECTED) | Opcodes.ACC_PUBLIC;
        return this;
    }

    public MethodEditor afterCall(String owner, String name, Consumer<MethodVisitor> generator) {
        InsnList instructions = node.instructions;
        for (AbstractInsnNode insn : instructions.toArray()) {
            if (insn instanceof MethodInsnNode) {
                MethodInsnNode min = (MethodInsnNode) insn;
                if (min.owner.equals(owner) && min.name.equals(name)) {
                    MethodNode temp = new MethodNode();
                    generator.accept(temp);
                    instructions.insert(insn, temp.instructions);
                }
            }
        }
        return this;
    }

    public MethodEditor deleteFinal() {
        node.access &= ~Opcodes.ACC_FINAL;
        return this;
    }

    public MethodEditor atStart(Consumer<MethodVisitor> generator) {
        MethodNode buffer = new MethodNode();
        generator.accept(buffer);
        node.instructions.insert(buffer.instructions);
        return this;
    }

    public MethodEditor atEnd(Consumer<MethodVisitor> generator) {
        MethodNode buffer = new MethodNode();
        generator.accept(buffer);
        AbstractInsnNode[] insns = node.instructions.toArray();
        for (AbstractInsnNode insn : insns) {
            int opcode = insn.getOpcode();
            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
                node.instructions.insertBefore(insn, cloneInsnList(buffer.instructions));
            }
        }
        return this;
    }

    private InsnList cloneInsnList(InsnList insns) {
        InsnList clone = new InsnList();
        Map<LabelNode, LabelNode> labelMap = new HashMap<>();
        for (AbstractInsnNode insn = insns.getFirst(); insn != null; insn = insn.getNext()) {
            if (insn instanceof LabelNode) {
                labelMap.put((LabelNode) insn, new LabelNode());
            }
        }
        for (AbstractInsnNode insn = insns.getFirst(); insn != null; insn = insn.getNext()) {
            clone.add(insn.clone(labelMap));
        }
        return clone;
    }

}
