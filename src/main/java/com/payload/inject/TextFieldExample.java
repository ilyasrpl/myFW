package com.payload.inject;

import com.payload.api.BaseTextField;
import com.payload.api.Notification;

public class TextFieldExample extends BaseTextField {

    public TextFieldExample() {
        super("Example Field");
    }

    @Override
    public void onAction() {
        Notification.alert("Action performed " + getInput());
    }

}
