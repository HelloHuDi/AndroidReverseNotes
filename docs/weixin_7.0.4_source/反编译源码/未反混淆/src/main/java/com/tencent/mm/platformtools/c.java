package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    private n ggR;
    private o ggS;
    private p ggT;
    private l ggU;
    private m ggV;
    private k ggW;

    public final boolean a(Activity activity, ag agVar) {
        AppMethodBeat.i(124515);
        if (agVar.type == 0 || agVar.action == 0) {
            AppMethodBeat.o(124515);
            return false;
        }
        if (this.ggW == null) {
            this.ggW = new k(activity);
        }
        if (this.ggW.a(agVar)) {
            AppMethodBeat.o(124515);
            return true;
        }
        switch (agVar.type) {
            case 1:
                if (this.ggR == null) {
                    this.ggR = new n(activity);
                }
                this.ggR.a(agVar);
                break;
            case 2:
                if (this.ggS == null) {
                    this.ggS = new o(activity);
                }
                this.ggS.a(agVar);
                break;
            case 3:
                if (this.ggT == null) {
                    this.ggT = new p(activity);
                }
                this.ggT.a(agVar);
                break;
            case 4:
                if (this.ggU == null) {
                    this.ggU = new l(activity);
                }
                this.ggU.a(agVar);
                break;
            case 5:
                if (this.ggV == null) {
                    this.ggV = new m(activity);
                }
                this.ggV.a(agVar);
                break;
            case 6:
                if (this.ggW == null) {
                    this.ggW = new k(activity);
                }
                this.ggW.a(agVar);
                break;
            default:
                ab.e("MicroMsg.BaseErrorHelper", "Unkown error type");
                break;
        }
        AppMethodBeat.o(124515);
        return false;
    }

    private static void a(d dVar) {
        AppMethodBeat.i(124516);
        if (dVar != null) {
            for (Integer intValue : dVar.ggX) {
                g.Rg().b(intValue.intValue(), (f) dVar);
            }
            dVar.activity = null;
        }
        AppMethodBeat.o(124516);
    }

    public final void close() {
        AppMethodBeat.i(124517);
        a(this.ggR);
        a(this.ggS);
        a(this.ggT);
        a(this.ggU);
        a(this.ggV);
        a(this.ggW);
        AppMethodBeat.o(124517);
    }
}
