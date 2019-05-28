package com.tencent.mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b implements g {
    private final o gOq;
    private Intent iAH;
    private boolean iAI = false;
    k iAJ = null;
    private m iAK = null;
    p iAL = null;
    private volatile i iAM = null;
    private boolean irv = false;
    private final String mAppId;

    public b(o oVar) {
        AppMethodBeat.i(132582);
        this.mAppId = oVar.mAppId;
        this.gOq = oVar;
        resetSession();
        AppMethodBeat.o(132582);
    }

    public final i aHX() {
        return this.iAM;
    }

    public final void F(Intent intent) {
        this.iAH = intent;
    }

    public final Intent aHY() {
        return this.iAH;
    }

    public final void resetSession() {
        AppMethodBeat.i(132583);
        if (bo.isNullOrNil(this.mAppId)) {
            ab.e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", bo.l(new Throwable()));
            this.iAM = i.iBj;
            this.iAK = m.aLw();
            this.iAJ = k.aLv();
            this.iAL = p.aLy();
            AppMethodBeat.o(132583);
            return;
        }
        String xz = this.gOq.atI().xz();
        String d = a.d(this.gOq.atI().hgF);
        this.iAM = new d(d);
        this.iAJ = k.a(this.gOq, xz, this.iAM);
        LinkedList linkedList = new LinkedList();
        linkedList.push(bo.nullAsNil(d));
        this.iAL = p.a(this.gOq, xz, linkedList);
        this.iAK = m.b(this.gOq, xz, this.iAM);
        AppMethodBeat.o(132583);
    }

    public final p aHZ() {
        return this.iAL;
    }

    public final void aIa() {
        this.iAI = true;
    }

    public final void a(final w wVar, final w wVar2, aq aqVar) {
        w wVar3;
        AppMethodBeat.i(132584);
        if (aq.AUTO_RE_LAUNCH == aqVar) {
            resetSession();
        }
        Object obj = (aq.AUTO_RE_LAUNCH == aqVar || wVar2 == null || bo.isNullOrNil(wVar2.aBm()) || wVar2 == wVar) ? 1 : null;
        i iVar = this.iAM;
        if (obj != null) {
            wVar3 = null;
        } else {
            wVar3 = wVar2;
        }
        iVar.a(wVar, wVar3, aqVar);
        if (obj == null) {
            wVar2.ito.M(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(132579);
                    b.this.a(wVar, wVar2);
                    AppMethodBeat.o(132579);
                }
            });
            AppMethodBeat.o(132584);
            return;
        }
        a(wVar, null);
        AppMethodBeat.o(132584);
    }

    /* Access modifiers changed, original: final */
    public final void a(w wVar, w wVar2) {
        AppMethodBeat.i(132585);
        if (wVar2 != null) {
            this.iAJ.n(wVar2);
            this.iAL.a(wVar2, wVar.aBm());
        }
        this.iAK.p(wVar);
        AppMethodBeat.o(132585);
    }

    public final void b(final w wVar) {
        AppMethodBeat.i(132586);
        this.irv = true;
        this.iAM.b(wVar);
        wVar.ito.M(new Runnable() {
            public final void run() {
                AppMethodBeat.i(132580);
                k kVar = b.this.iAJ;
                w wVar = wVar;
                Activity cY = n.cY(wVar.mContext);
                if (cY != null && cY.isFinishing()) {
                    kVar.iBy = true;
                }
                kVar.o(wVar);
                kVar.IF();
                p pVar = b.this.iAL;
                w wVar2 = wVar;
                pVar.iBB = (String) pVar.iCy.peekFirst();
                pVar.iBD = null;
                switch (g.wV(pVar.appId)) {
                    case CLOSE:
                        pVar.iBC = 3;
                        break;
                    case HANG:
                        pVar.iBC = 6;
                        break;
                    case LAUNCH_MINI_PROGRAM:
                        break;
                    default:
                        Intent aHY = pVar.gOq.atJ().getReporter().aHY();
                        if (aHY == null) {
                            pVar.iBC = 7;
                            break;
                        }
                        String str;
                        if (aHY.getComponent() == null) {
                            str = "";
                            ab.e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", aHY);
                        } else {
                            str = aHY.getComponent().getClassName();
                        }
                        pVar.iBC = 8;
                        pVar.iBD = bo.bc(aHY.getStringExtra(AppBrandProcessProxyUI.huZ), str);
                        str = pVar.iBD;
                        pVar.iCy.pollFirst();
                        pVar.iCy.push(bo.nullAsNil(str));
                        break;
                }
                Activity cY2 = n.cY(wVar2.mContext);
                if (cY2 != null && cY2.isFinishing()) {
                    pVar.iBy = true;
                }
                pVar.q(wVar2);
                AppMethodBeat.o(132580);
            }
        });
        AppMethodBeat.o(132586);
    }

    public final void aHW() {
        AppMethodBeat.i(132587);
        h(0, 4);
        AppMethodBeat.o(132587);
    }

    public final void a(w wVar) {
        AppMethodBeat.i(132588);
        if (wVar == null || this.irv) {
            AppMethodBeat.o(132588);
            return;
        }
        b(wVar);
        AppMethodBeat.o(132588);
    }

    public final void c(w wVar) {
        AppMethodBeat.i(132589);
        this.iAH = null;
        if (this.iAI) {
            this.iAI = false;
            AppMethodBeat.o(132589);
            return;
        }
        this.iAM.c(wVar);
        this.iAK.p(wVar);
        AppMethodBeat.o(132589);
    }

    public final void a(long j, aq aqVar) {
        int i;
        AppMethodBeat.i(132590);
        switch (aqVar) {
            case APP_LAUNCH:
                i = 1;
                break;
            case REDIRECT_TO:
            case RE_LAUNCH:
            case AUTO_RE_LAUNCH:
                i = 3;
                break;
            default:
                i = 2;
                break;
        }
        h(j, i);
        h.pYm.a(390, 0, 1, false);
        switch (((int) j) / 250) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
            case 5:
                i = 5;
                break;
            case 6:
            case 7:
                i = 6;
                break;
            default:
                i = 7;
                break;
        }
        h.pYm.a(390, (long) i, 1, false);
        AppMethodBeat.o(132590);
    }

    private void h(long j, int i) {
        AppMethodBeat.i(132591);
        int i2 = this.gOq.atH().hhd.gVu;
        h.pYm.e(13543, this.mAppId, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.o(132591);
    }
}
