package com.tencent.p177mm.model;

/* renamed from: com.tencent.mm.model.y */
public class C26432y {
    private final String cIR;
    private final String ema;
    public final boolean enable;
    private boolean flq;
    private final String name;
    private final String type;

    public C26432y() {
        this.type = "";
        this.name = "";
        this.cIR = "";
        this.ema = "";
        this.enable = true;
    }

    public C26432y(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.type = str;
        this.name = str2;
        this.cIR = str3;
        this.ema = str4;
        this.enable = z;
        this.flq = z2;
    }

    public final String getType() {
        return this.type == null ? "" : this.type;
    }

    /* renamed from: Oi */
    public final String mo44195Oi() {
        return this.cIR == null ? "" : this.cIR;
    }

    /* renamed from: Zq */
    public final String mo44196Zq() {
        return this.ema == null ? "" : this.ema;
    }
}
