package com.payload.api;

import com.stub.bt;
import com.stub.cn;
import com.stub.fu;

public abstract class BaseMenu extends cn {
    public ListMenu listMenu;

    public abstract String getTitle();

    public abstract int getMenuType();

    public BaseMenu() {
        listMenu = new ListMenu();
    }

    public void onMenuSelected(int action) {
    }

    public void a(int a, int b) {
        onMenuSelected(a);
    }

    public void render() {
        int menuLength = listMenu.c();
        for (int i = 0; i < menuLength; i++) {
            ((bt) listMenu.a(i)).d = this;
        }
        fu.p.a(listMenu, getMenuType(), getTitle(), false, null);
    }
}
