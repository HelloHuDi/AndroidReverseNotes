package com.tencent.p177mm.plugin.luckymoney.appbrand.p988a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.a.g */
public enum C43248g {
    ;
    
    public int nRO;
    public double nRP;
    public double nRQ;
    public double nRR;
    public double nRS;
    public String nRT;
    public String nRU;
    private List<Object> nRV;

    private C43248g(String str) {
        AppMethodBeat.m2504i(41996);
        this.nRO = 100;
        this.nRP = 200.0d;
        this.nRQ = 0.01d;
        this.nRR = 2000.0d;
        this.nRS = 200.0d;
        this.nRT = "¥";
        this.nRU = C4996ah.getContext().getString(C25738R.string.cq3);
        this.nRV = new LinkedList();
        AppMethodBeat.m2505o(41996);
    }

    static {
        AppMethodBeat.m2505o(41998);
    }

    public final String toString() {
        AppMethodBeat.m2504i(41997);
        String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.nRO + ", perPersonMaxValue=" + this.nRP + ", perMinValue=" + this.nRQ + ", maxTotalAmount=" + this.nRR + ", mListener=" + this.nRV + '}';
        AppMethodBeat.m2505o(41997);
        return str;
    }
}
