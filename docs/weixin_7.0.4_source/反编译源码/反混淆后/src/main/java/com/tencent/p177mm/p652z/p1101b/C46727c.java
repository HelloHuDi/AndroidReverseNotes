package com.tencent.p177mm.p652z.p1101b;

import org.json.JSONObject;

/* renamed from: com.tencent.mm.z.b.c */
public abstract class C46727c implements C30908e {
    private int index;
    public String name;

    public abstract JSONObject toJSONObject();

    public C46727c(String str) {
        this.name = str;
    }

    public C46727c(String str, int i) {
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
