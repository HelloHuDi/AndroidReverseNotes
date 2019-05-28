package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r {
    public long cKK;
    public long cvx;
    public String cwG;
    public String cwT;
    public int fgc = 0;
    public int fjQ;
    public String fjR;
    public String fjS;
    public p fjT = new p();
    public int type = 0;
    public String userName;

    public r() {
        AppMethodBeat.i(105480);
        AppMethodBeat.o(105480);
    }

    public static boolean ks(int i) {
        return (i & 1) != 0;
    }

    public final String HE() {
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
