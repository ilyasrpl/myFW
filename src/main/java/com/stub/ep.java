package com.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * Stub untuk class 'ep' (Network Packet)
 */
public final class ep {
    // Header atau ID dari paket/pesan
    public byte a;

    // Constructor untuk menulis/mengirim data (Write Mode)
    public ep(byte commandId) {
        // Implementasi asli menginisialisasi DataOutputStream
    }

    // Constructor untuk membaca data (Read Mode)
    public ep(byte commandId, byte[] data) {
        // Implementasi asli menginisialisasi DataInputStream
    }

    // Mengambil hasil byte array (biasanya untuk dikirim ke server)
    public final byte[] a() {
        return null; // stub
    }

    // Mengambil DataInputStream (untuk membaca data seperti readUTF, readByte)
    public final DataInputStream b() {
        return null; // stub
    }

    // Mengambil DataOutputStream (untuk menulis data seperti writeUTF, writeByte)
    public final DataOutputStream c() {
        return null; // stub
    }
}