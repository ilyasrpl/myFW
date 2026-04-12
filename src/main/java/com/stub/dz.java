package com.stub;

public class dz extends da {
    public fj a; // TextField Tunggal
    private fj[] c; // Multi TextField
    private bt b; // Internal button (biasanya 'Back')
    private boolean d, e, f;
    private long g;
    private String h, i, j, x;
    private int y;
    private static int s, t, u;

    public dz() {
        this.b = new bt("Back", -1);
    }

    // Overload 1: Input Teks Tunggal
    public void a(String title, bt okCmd, boolean isPassword, String footer) {
    }

    // Overload 2: Multi Input
    public void a(String[] labels, bt okCmd, short k, short r, String title) {
    }

    // Overload 3: Multi Input Lengkap
    public void a(String[] labels, bt okCmd, short k, short r, String title, String[] initialVals, byte type) {
    }

    // Overload 4: Input Angka/Transaksi
    public void a(String msg, bt okCmd, boolean isPass, int val, long price, String currency) {
    }

    public void a(String msg, bt okCmd, boolean isPass, int val, long price, String footer, String currency) {
    }

    public void a(Object graphics) {
    }

    public void a() {
    }

    public void b(int var1, int var2) {
    }

    public String[] b() {
        return new String[0];
    } // Ambil semua hasil input multi-field
}