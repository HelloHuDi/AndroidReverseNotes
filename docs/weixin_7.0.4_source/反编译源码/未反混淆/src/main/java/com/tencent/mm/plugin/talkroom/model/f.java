package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {
    private long eDK;
    int nwu;
    long nwv;
    private int sxV;
    private long sxW;
    int sxX = 0;
    private int sxY;
    long sxZ;
    int sya;
    int syb;
    private int syc;
    private int syd;
    private int sye;
    int syf;
    int syg;
    public int syh = 0;
    private int syi;
    private int syj;
    private int syk;
    private int syl;
    private int sym;
    private int syn;
    private int syo;
    private int syp;
    private int syq;
    String syr;
    int sys;
    int syt;
    long syu;
    int syv;
    long syw;
    long syx;
    boolean syy;
    boolean syz;

    public final void Fs(int i) {
        AppMethodBeat.i(25795);
        if (this.syu == 0) {
            AppMethodBeat.o(25795);
            return;
        }
        this.sxV = i;
        this.sxW = bo.az(this.syu);
        AppMethodBeat.o(25795);
    }

    public final void cEp() {
        AppMethodBeat.i(25796);
        if (this.syu == 0) {
            AppMethodBeat.o(25796);
            return;
        }
        this.eDK = bo.az(this.syu);
        AppMethodBeat.o(25796);
    }

    public final void cEq() {
        AppMethodBeat.i(25797);
        if (this.syu == 0) {
            AppMethodBeat.o(25797);
            return;
        }
        this.sxY = (int) (bo.az(this.syu) / 1000);
        AppMethodBeat.o(25797);
    }

    public final void cEr() {
        this.sye++;
    }

    public final void cEs() {
        AppMethodBeat.i(25798);
        if (this.syx == 0) {
            AppMethodBeat.o(25798);
            return;
        }
        long az = bo.az(this.syx) / 1000;
        if (az < 2) {
            this.syi++;
        } else if (az < 6) {
            this.syj++;
        } else if (az < 11) {
            this.syk++;
        } else if (az < 21) {
            this.syl++;
        } else if (az < 31) {
            this.sym++;
        } else if (az < 41) {
            this.syn++;
        } else if (az < 51) {
            this.syo++;
        } else if (az < 61) {
            this.syp++;
        } else {
            this.syq++;
        }
        this.syx = 0;
        AppMethodBeat.o(25798);
    }

    public final String toString() {
        AppMethodBeat.i(25799);
        String str = this.sxV + "," + this.sxW + "," + this.eDK + "," + this.sxX + "," + this.sxY + "," + this.sxZ + "," + this.sya + "," + this.syb + "," + this.syc + "," + this.syd + "," + this.sye + "," + this.syf + "," + this.syg + "," + this.syh + "," + this.syi + "," + this.syj + "," + this.syk + "," + this.syl + "," + this.sym + "," + this.syn + "," + this.syo + "," + this.syp + "," + this.syq + "," + this.syr + "," + this.nwu + "," + this.nwv + "," + this.sys + "," + this.syt;
        AppMethodBeat.o(25799);
        return str;
    }
}
