package com.eclipsesource.v8.utils;

public abstract class SingleTypeAdapter implements TypeAdapter {
    private int typeToAdapt;

    public abstract Object adapt(Object obj);

    public SingleTypeAdapter(int i) {
        this.typeToAdapt = i;
    }

    public Object adapt(int i, Object obj) {
        if (i == this.typeToAdapt) {
            return adapt(obj);
        }
        return TypeAdapter.DEFAULT;
    }
}
