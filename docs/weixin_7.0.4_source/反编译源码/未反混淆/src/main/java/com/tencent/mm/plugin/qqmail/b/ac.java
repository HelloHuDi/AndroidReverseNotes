package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class ac implements at {
    private ab puY;
    private v pvA;
    private b pvB = new b();

    public ac() {
        AppMethodBeat.i(68060);
        AppMethodBeat.o(68060);
    }

    private static ac ccB() {
        AppMethodBeat.i(68061);
        ac acVar = (ac) q.Y(ac.class);
        AppMethodBeat.o(68061);
        return acVar;
    }

    public static v ccC() {
        AppMethodBeat.i(68062);
        g.RN().QU();
        if (ccB().pvA == null) {
            ccB().pvA = new v(d.vxo, d.eSg);
        }
        v vVar = ccB().pvA;
        AppMethodBeat.o(68062);
        return vVar;
    }

    public static ab ccD() {
        AppMethodBeat.i(68063);
        g.RN().QU();
        if (ccB().puY == null) {
            ccB().puY = new ab();
        }
        ab abVar = ccB().puY;
        AppMethodBeat.o(68063);
        return abVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(68064);
        v vVar = ccB().pvA;
        if (vVar != null) {
            vVar.reset();
        }
        a.xxA.d(this.pvB);
        AppMethodBeat.o(68064);
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
        AppMethodBeat.i(68065);
        if ((i & 1) != 0) {
            ccE();
        }
        AppMethodBeat.o(68065);
    }

    public static void ccE() {
        AppMethodBeat.i(68066);
        bf.oD("qqmail");
        ((j) g.K(j.class)).XR().aoX("qqmail");
        ccC().clearData();
        AppMethodBeat.o(68066);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(68067);
        a.xxA.c(this.pvB);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(68059);
                if (g.RK()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    y yVar = new y();
                    if (yVar.puW.oof.size() > 0) {
                        for (int i = 0; i < yVar.puW.oof.size(); i++) {
                            y.Vm(((w) yVar.puW.oof.get(i)).ptN);
                        }
                        yVar.puW.oof.clear();
                        yVar.save();
                    }
                    ab.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(68059);
                    return;
                }
                AppMethodBeat.o(68059);
            }
        });
        AppMethodBeat.o(68067);
    }

    public final void bA(boolean z) {
    }
}
