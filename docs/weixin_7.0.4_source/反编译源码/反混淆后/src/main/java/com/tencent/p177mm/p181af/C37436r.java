package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.af.r */
public final class C37436r {
    public long cKK;
    public long cvx;
    public String cwG;
    public String cwT;
    public int fgc = 0;
    public int fjQ;
    public String fjR;
    public String fjS;
    public C32224p fjT = new C32224p();
    public int type = 0;
    public String userName;

    public C37436r() {
        AppMethodBeat.m2504i(105480);
        AppMethodBeat.m2505o(105480);
    }

    /* renamed from: ks */
    public static boolean m63099ks(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: HE */
    public final String mo60325HE() {
        Object obj;
        if (this.type == 285212721) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return this.userName;
        }
        return this.cwG;
    }
}
