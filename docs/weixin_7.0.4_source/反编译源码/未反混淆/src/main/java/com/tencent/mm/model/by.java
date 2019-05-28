package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class by {
    private a fnD = null;
    private long fnE = 0;
    private long fnF = 0;
    private String fnG = "";
    private int fnH = 1;

    public interface a {
        boolean aaC();
    }

    public by(a aVar) {
        AppMethodBeat.i(58130);
        Assert.assertTrue(true);
        this.fnD = aVar;
        aav();
        AppMethodBeat.o(58130);
    }

    private void aav() {
        this.fnH = 1;
        this.fnE = 0;
        this.fnF = 0;
        this.fnG = "";
    }

    public final synchronized boolean aaw() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(58131);
            long anU = bo.anU();
            this.fnG = bo.dpG().toString();
            if (this.fnH == 1) {
                this.fnF = anU;
                this.fnE = 1800000;
                ab.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", Long.valueOf(1800000), this.fnG);
                this.fnH = 2;
                if (this.fnD.aaC()) {
                    aay();
                }
                AppMethodBeat.o(58131);
            } else {
                long j = this.fnF + this.fnE;
                anU += 1800000;
                if (anU > j) {
                    this.fnE += anU - j;
                }
                ab.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", Integer.valueOf(this.fnH), Long.valueOf(1800000), Long.valueOf(anU - j), Long.valueOf(this.fnE), this.fnG);
                AppMethodBeat.o(58131);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void aax() {
        AppMethodBeat.i(58132);
        ab.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", Integer.valueOf(this.fnH), bo.dpG());
        if (this.fnH == 1) {
            ab.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", bo.dpG());
            AppMethodBeat.o(58132);
        } else {
            aav();
            sv svVar = new sv();
            svVar.cOX.status = 1;
            com.tencent.mm.sdk.b.a.xxA.m(svVar);
            AppMethodBeat.o(58132);
        }
    }

    public final synchronized void aay() {
        AppMethodBeat.i(58133);
        if (this.fnH != 2) {
            ab.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", Integer.valueOf(this.fnH), bo.dpG());
            AppMethodBeat.o(58133);
        } else {
            ab.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", Long.valueOf(bo.gb(this.fnF)), bo.dpG());
            this.fnH = 3;
            sv svVar = new sv();
            svVar.cOX.status = 3;
            com.tencent.mm.sdk.b.a.xxA.m(svVar);
            AppMethodBeat.o(58133);
        }
    }

    private synchronized void aaz() {
        AppMethodBeat.i(58134);
        if (this.fnH != 1 && this.fnE + this.fnF < bo.anU()) {
            aax();
        }
        AppMethodBeat.o(58134);
    }

    public final synchronized boolean aaA() {
        boolean z;
        AppMethodBeat.i(58135);
        aaz();
        if (this.fnH == 2) {
            z = true;
            AppMethodBeat.o(58135);
        } else {
            z = false;
            AppMethodBeat.o(58135);
        }
        return z;
    }

    public final synchronized boolean aaB() {
        boolean z;
        AppMethodBeat.i(58136);
        aaz();
        if (this.fnH == 3) {
            z = true;
            AppMethodBeat.o(58136);
        } else {
            z = false;
            AppMethodBeat.o(58136);
        }
        return z;
    }
}
