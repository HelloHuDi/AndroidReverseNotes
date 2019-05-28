package com.tencent.mm.z.b;

import org.json.JSONObject;

public abstract class c implements e {
    private int index;
    public String name;

    public abstract JSONObject toJSONObject();

    public c(String str) {
        this.name = str;
    }

    public c(String str, int i) {
        this.name = str;
        this.index = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getIndex() {
        return this.index;
    }
}
