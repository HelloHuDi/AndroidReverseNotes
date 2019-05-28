package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18397sv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.by */
public final class C18620by {
    private C18621a fnD = null;
    private long fnE = 0;
    private long fnF = 0;
    private String fnG = "";
    private int fnH = 1;

    /* renamed from: com.tencent.mm.model.by$a */
    public interface C18621a {
        boolean aaC();
    }

    public C18620by(C18621a c18621a) {
        AppMethodBeat.m2504i(58130);
        Assert.assertTrue(true);
        this.fnD = c18621a;
        aav();
        AppMethodBeat.m2505o(58130);
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
            AppMethodBeat.m2504i(58131);
            long anU = C5046bo.anU();
            this.fnG = C5046bo.dpG().toString();
            if (this.fnH == 1) {
                this.fnF = anU;
                this.fnE = 1800000;
                C4990ab.m7417i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", Long.valueOf(1800000), this.fnG);
                this.fnH = 2;
                if (this.fnD.aaC()) {
                    aay();
                }
                AppMethodBeat.m2505o(58131);
            } else {
                long j = this.fnF + this.fnE;
                anU += 1800000;
                if (anU > j) {
                    this.fnE += anU - j;
                }
                C4990ab.m7417i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", Integer.valueOf(this.fnH), Long.valueOf(1800000), Long.valueOf(anU - j), Long.valueOf(this.fnE), this.fnG);
                AppMethodBeat.m2505o(58131);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void aax() {
        AppMethodBeat.m2504i(58132);
        C4990ab.m7411d("MicroMsg.SyncPauser", "restartSync currState:%d %s", Integer.valueOf(this.fnH), C5046bo.dpG());
        if (this.fnH == 1) {
            C4990ab.m7411d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", C5046bo.dpG());
            AppMethodBeat.m2505o(58132);
        } else {
            aav();
            C18397sv c18397sv = new C18397sv();
            c18397sv.cOX.status = 1;
            C4879a.xxA.mo10055m(c18397sv);
            AppMethodBeat.m2505o(58132);
        }
    }

    public final synchronized void aay() {
        AppMethodBeat.m2504i(58133);
        if (this.fnH != 2) {
            C4990ab.m7413e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", Integer.valueOf(this.fnH), C5046bo.dpG());
            AppMethodBeat.m2505o(58133);
        } else {
            C4990ab.m7411d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", Long.valueOf(C5046bo.m7566gb(this.fnF)), C5046bo.dpG());
            this.fnH = 3;
            C18397sv c18397sv = new C18397sv();
            c18397sv.cOX.status = 3;
            C4879a.xxA.mo10055m(c18397sv);
            AppMethodBeat.m2505o(58133);
        }
    }

    private synchronized void aaz() {
        AppMethodBeat.m2504i(58134);
        if (this.fnH != 1 && this.fnE + this.fnF < C5046bo.anU()) {
            aax();
        }
        AppMethodBeat.m2505o(58134);
    }

    public final synchronized boolean aaA() {
        boolean z;
        AppMethodBeat.m2504i(58135);
        aaz();
        if (this.fnH == 2) {
            z = true;
            AppMethodBeat.m2505o(58135);
        } else {
            z = false;
            AppMethodBeat.m2505o(58135);
        }
        return z;
    }

    public final synchronized boolean aaB() {
        boolean z;
        AppMethodBeat.m2504i(58136);
        aaz();
        if (this.fnH == 3) {
            z = true;
            AppMethodBeat.m2505o(58136);
        } else {
            z = false;
            AppMethodBeat.m2505o(58136);
        }
        return z;
    }
}
