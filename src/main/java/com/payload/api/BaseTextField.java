package com.payload.api;

import com.stub.bt;
import com.stub.da;
import com.stub.dz;
import com.stub.fu;

public abstract class BaseTextField extends da {
    private dz dialog;
    private String title;

    public abstract void onAction();

    public BaseTextField(String title) {
        this.title = title;
        this.dialog = new dz();
    }

    public void render(String msg) {
        bt okCommand = new bt("ok", 1, this);
        this.dialog.a(msg, okCommand, false, this.title);
        fu.s = this.dialog;
    }

    public void a(int a, int b) {
        if (a == 1) {
            onAction();
        }
    }

    public String getInput() {
        return dialog.a.j();
    }

}