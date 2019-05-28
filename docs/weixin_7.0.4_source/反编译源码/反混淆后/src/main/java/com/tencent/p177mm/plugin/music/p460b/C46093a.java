package com.tencent.p177mm.plugin.music.p460b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.b.a */
public final class C46093a {
    /* renamed from: a */
    public static boolean m85964a(C42063t c42063t) {
        boolean z = true;
        AppMethodBeat.m2504i(137260);
        if (c42063t.csI.action != 6) {
            C4990ab.m7411d("MicroMsg.Audio.AudioActionListener", "callback, action:%d", Integer.valueOf(c42063t.csI.action));
        }
        switch (c42063t.csI.action) {
            case 0:
                z = C28543f.bSA().mo46592h(c42063t.csI.csL);
                c42063t.csJ.csN = z;
                break;
            case 1:
                z = C28543f.bSA().mo46581b(c42063t.csI.ckD, c42063t.csI.csL);
                c42063t.csJ.csN = z;
                break;
            case 2:
                z = C28543f.bSA().mo46573St(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 3:
                z = C28543f.bSA().mo46574Su(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 4:
                z = C28543f.bSA().mo46586cF(c42063t.csI.ckD, c42063t.csI.csK);
                c42063t.csJ.csN = z;
                break;
            case 5:
                z = C28543f.bSA().mo46576Sw(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 6:
                c42063t.csJ.csO = C28543f.bSA().mo46579Sz(c42063t.csI.ckD);
                break;
            case 7:
                z = C28543f.bSA().mo46593pN(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 8:
                z = C28543f.bSA().mo46577Sx(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 9:
                C28543f.bSA().mo46569SD(c42063t.csI.appId);
                break;
            case 10:
                c42063t.csI.ckD = C28543f.bSA().mo46590fk(c42063t.csI.appId, c42063t.csI.ckD);
                break;
            case 11:
                c42063t.csJ.count = C28543f.bSA().mo46566SA(c42063t.csI.appId);
                break;
            case 12:
                C28543f.bSA().mo46568SC(c42063t.csI.appId);
                break;
            case 13:
                z = C28543f.bSA().mo46578Sy(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 14:
                z = C28543f.bSA().mo46575Sv(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 15:
                C28543f.bSA().mo46570SK(c42063t.csI.processName);
                break;
            case 16:
                c42063t.csI.csL = C28543f.bSA().mo46594pO(c42063t.csI.ckD);
                break;
            case 17:
                z = C28543f.bSA().mo46587dZ(c42063t.csI.ckD);
                c42063t.csJ.csN = z;
                break;
            case 18:
                z = C28543f.bSA().mo46591g(c42063t.csI.csL);
                c42063t.csJ.csN = z;
                break;
            case 19:
                C28543f.bSA().csM = c42063t.csI.csM;
                c42063t.csJ.csN = true;
                break;
        }
        AppMethodBeat.m2505o(137260);
        return z;
    }
}
