package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.List;

public enum g {
    ;
    
    public int nRO;
    public double nRP;
    public double nRQ;
    public double nRR;
    public double nRS;
    public String nRT;
    public String nRU;
    private List<Object> nRV;

    private g(String str) {
        AppMethodBeat.i(41996);
        this.nRO = 100;
        this.nRP = 200.0d;
        this.nRQ = 0.01d;
        this.nRR = 2000.0d;
        this.nRS = 200.0d;
        this.nRT = "¥";
        this.nRU = ah.getContext().getString(R.string.cq3);
        this.nRV = new LinkedList();
        AppMethodBeat.o(41996);
    }

    static {
        AppMethodBeat.o(41998);
    }

    public final String toString() {
        AppMethodBeat.i(41997);
        String str = "WxaLuckyMoneyConfig{maxTotalNum=" + this.nRO + ", perPersonMaxValue=" + this.nRP + ", perMinValue=" + this.nRQ + ", maxTotalAmount=" + this.nRR + ", mListener=" + this.nRV + '}';
        AppMethodBeat.o(41997);
        return str;
    }
}
