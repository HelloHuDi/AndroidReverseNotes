package com.tencent.p177mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.model.n */
public final class C44064n {
    public String cwg;
    private int vbp;
    public String vbq;
    public String vbr;
    public String vbs;
    public int vbt;

    C44064n(int i, String str, String str2, String str3, String str4, int i2) {
        this.vbp = i;
        this.cwg = str;
        this.vbq = str2;
        this.vbt = i2;
        this.vbr = str3;
        this.vbs = str4;
    }

    public final String toString() {
        AppMethodBeat.m2504i(79224);
        String str = "id:" + this.vbp + ";productId:" + this.cwg + ";full:" + this.vbq + ";productState:" + this.vbt + ";priceCurrencyCode:" + this.vbr + ";priceAmountMicros:" + this.vbs;
        AppMethodBeat.m2505o(79224);
        return str;
    }
}
