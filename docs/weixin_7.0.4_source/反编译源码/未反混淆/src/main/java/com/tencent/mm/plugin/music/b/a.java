package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static boolean a(t tVar) {
        boolean z = true;
        AppMethodBeat.i(137260);
        if (tVar.csI.action != 6) {
            ab.d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", Integer.valueOf(tVar.csI.action));
        }
        switch (tVar.csI.action) {
            case 0:
                z = f.bSA().h(tVar.csI.csL);
                tVar.csJ.csN = z;
                break;
            case 1:
                z = f.bSA().b(tVar.csI.ckD, tVar.csI.csL);
                tVar.csJ.csN = z;
                break;
            case 2:
                z = f.bSA().St(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 3:
                z = f.bSA().Su(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 4:
                z = f.bSA().cF(tVar.csI.ckD, tVar.csI.csK);
                tVar.csJ.csN = z;
                break;
            case 5:
                z = f.bSA().Sw(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 6:
                tVar.csJ.csO = f.bSA().Sz(tVar.csI.ckD);
                break;
            case 7:
                z = f.bSA().pN(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 8:
                z = f.bSA().Sx(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 9:
                f.bSA().SD(tVar.csI.appId);
                break;
            case 10:
                tVar.csI.ckD = f.bSA().fk(tVar.csI.appId, tVar.csI.ckD);
                break;
            case 11:
                tVar.csJ.count = f.bSA().SA(tVar.csI.appId);
                break;
            case 12:
                f.bSA().SC(tVar.csI.appId);
                break;
            case 13:
                z = f.bSA().Sy(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 14:
                z = f.bSA().Sv(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 15:
                f.bSA().SK(tVar.csI.processName);
                break;
            case 16:
                tVar.csI.csL = f.bSA().pO(tVar.csI.ckD);
                break;
            case 17:
                z = f.bSA().dZ(tVar.csI.ckD);
                tVar.csJ.csN = z;
                break;
            case 18:
                z = f.bSA().g(tVar.csI.csL);
                tVar.csJ.csN = z;
                break;
            case 19:
                f.bSA().csM = tVar.csI.csM;
                tVar.csJ.csN = true;
                break;
        }
        AppMethodBeat.o(137260);
        return z;
    }
}
