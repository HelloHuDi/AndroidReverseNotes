package com.tencent.mm.model;

public class y {
    private final String cIR;
    private final String ema;
    public final boolean enable;
    private boolean flq;
    private final String name;
    private final String type;

    public y() {
        this.type = "";
        this.name = "";
        this.cIR = "";
        this.ema = "";
        this.enable = true;
    }

    public y(String str, String str2, String str3, String str4, boolean z, boolean z2) {
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

    public final String Oi() {
        return this.cIR == null ? "" : this.cIR;
    }

    public final String Zq() {
        return this.ema == null ? "" : this.ema;
    }
}
