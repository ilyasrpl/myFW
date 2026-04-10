package com.payload.inject;

import com.payload.api.BaseMenu;
import com.payload.api.ListMenu;
import com.payload.api.Notification;

public class MenuExample extends BaseMenu {
    public MenuExample() {
        listMenu = new ListMenu();
        listMenu.add("Option 1", 1);
        listMenu.add("Option 2", 2);
    }

    @Override
    public String getTitle() {
        return "Example Menu";
    }

    @Override
    public int getMenuType() {
        return 2;
    }

    public void onMenuSelected(int action) {
        super.onMenuSelected(action);
        if (action == 1) {
            Notification.alert("option 1 selected");
        }
        if (action == 2) {
            Notification.show("option 2 selected");
        }
    }
}
