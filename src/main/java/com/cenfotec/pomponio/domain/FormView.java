package com.cenfotec.pomponio.domain;

import java.util.ArrayList;

public class FormView {
    public String values;

    public FormView(String values) {
        this.values = values;
    }

    public FormView() {
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
