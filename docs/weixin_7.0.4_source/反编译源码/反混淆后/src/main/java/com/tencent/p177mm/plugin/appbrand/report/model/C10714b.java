package com.tencent.p177mm.plugin.appbrand.report.model;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.page.C2412aq;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.b */
public final class C10714b implements C38497g {
    private final C41243o gOq;
    private Intent iAH;
    private boolean iAI = false;
    C2450k iAJ = null;
    private C45675m iAK = null;
    C38499p iAL = null;
    private volatile C2440i iAM = null;
    private boolean irv = false;
    private final String mAppId;

    public C10714b(C41243o c41243o) {
        AppMethodBeat.m2504i(132582);
        this.mAppId = c41243o.mAppId;
        this.gOq = c41243o;
        resetSession();
        AppMethodBeat.m2505o(132582);
    }

    public final C2440i aHX() {
        return this.iAM;
    }

    /* renamed from: F */
    public final void mo22127F(Intent intent) {
        this.iAH = intent;
    }

    public final Intent aHY() {
        return this.iAH;
    }

    public final void resetSession() {
        AppMethodBeat.m2504i(132583);
        if (C5046bo.isNullOrNil(this.mAppId)) {
            C4990ab.m7413e("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", C5046bo.m7574l(new Throwable()));
            this.iAM = C2440i.iBj;
            this.iAK = C45675m.aLw();
            this.iAJ = C2450k.aLv();
            this.iAL = C38499p.aLy();
            AppMethodBeat.m2505o(132583);
            return;
        }
        String xz = this.gOq.atI().mo32993xz();
        String d = C27283a.m43315d(this.gOq.atI().hgF);
        this.iAM = new C33514d(d);
        this.iAJ = C2450k.m4688a(this.gOq, xz, this.iAM);
        LinkedList linkedList = new LinkedList();
        linkedList.push(C5046bo.nullAsNil(d));
        this.iAL = C38499p.m65156a(this.gOq, xz, linkedList);
        this.iAK = C45675m.m84376b(this.gOq, xz, this.iAM);
        AppMethodBeat.m2505o(132583);
    }

    public final C38499p aHZ() {
        return this.iAL;
    }

    public final void aIa() {
        this.iAI = true;
    }

    /* renamed from: a */
    public final void mo6358a(final C27242w c27242w, final C27242w c27242w2, C2412aq c2412aq) {
        C27242w c27242w3;
        AppMethodBeat.m2504i(132584);
        if (C2412aq.AUTO_RE_LAUNCH == c2412aq) {
            resetSession();
        }
        Object obj = (C2412aq.AUTO_RE_LAUNCH == c2412aq || c27242w2 == null || C5046bo.isNullOrNil(c27242w2.aBm()) || c27242w2 == c27242w) ? 1 : null;
        C2440i c2440i = this.iAM;
        if (obj != null) {
            c27242w3 = null;
        } else {
            c27242w3 = c27242w2;
        }
        c2440i.mo6358a(c27242w, c27242w3, c2412aq);
        if (obj == null) {
            c27242w2.ito.mo22265M(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(132579);
                    C10714b.this.mo22261a(c27242w, c27242w2);
                    AppMethodBeat.m2505o(132579);
                }
            });
            AppMethodBeat.m2505o(132584);
            return;
        }
        mo22261a(c27242w, null);
        AppMethodBeat.m2505o(132584);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo22261a(C27242w c27242w, C27242w c27242w2) {
        AppMethodBeat.m2504i(132585);
        if (c27242w2 != null) {
            this.iAJ.mo6369n(c27242w2);
            this.iAL.mo61209a(c27242w2, c27242w.aBm());
        }
        this.iAK.mo73470p(c27242w);
        AppMethodBeat.m2505o(132585);
    }

    /* renamed from: b */
    public final void mo6359b(final C27242w c27242w) {
        AppMethodBeat.m2504i(132586);
        this.irv = true;
        this.iAM.mo6359b(c27242w);
        c27242w.ito.mo22265M(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132580);
                C2450k c2450k = C10714b.this.iAJ;
                C27242w c27242w = c27242w;
                Activity cY = C42696n.m75621cY(c27242w.mContext);
                if (cY != null && cY.isFinishing()) {
                    c2450k.iBy = true;
                }
                c2450k.mo6370o(c27242w);
                c2450k.mo6368IF();
                C38499p c38499p = C10714b.this.iAL;
                C27242w c27242w2 = c27242w;
                c38499p.iBB = (String) c38499p.iCy.peekFirst();
                c38499p.iBD = null;
                switch (C33183g.m54286wV(c38499p.appId)) {
                    case CLOSE:
                        c38499p.iBC = 3;
                        break;
                    case HANG:
                        c38499p.iBC = 6;
                        break;
                    case LAUNCH_MINI_PROGRAM:
                        break;
                    default:
                        Intent aHY = c38499p.gOq.atJ().getReporter().aHY();
                        if (aHY == null) {
                            c38499p.iBC = 7;
                            break;
                        }
                        String str;
                        if (aHY.getComponent() == null) {
                            str = "";
                            C4990ab.m7413e("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", aHY);
                        } else {
                            str = aHY.getComponent().getClassName();
                        }
                        c38499p.iBC = 8;
                        c38499p.iBD = C5046bo.m7532bc(aHY.getStringExtra(AppBrandProcessProxyUI.huZ), str);
                        str = c38499p.iBD;
                        c38499p.iCy.pollFirst();
                        c38499p.iCy.push(C5046bo.nullAsNil(str));
                        break;
                }
                Activity cY2 = C42696n.m75621cY(c27242w2.mContext);
                if (cY2 != null && cY2.isFinishing()) {
                    c38499p.iBy = true;
                }
                c38499p.mo61211q(c27242w2);
                AppMethodBeat.m2505o(132580);
            }
        });
        AppMethodBeat.m2505o(132586);
    }

    public final void aHW() {
        AppMethodBeat.m2504i(132587);
        m18384h(0, 4);
        AppMethodBeat.m2505o(132587);
    }

    /* renamed from: a */
    public final void mo22129a(C27242w c27242w) {
        AppMethodBeat.m2504i(132588);
        if (c27242w == null || this.irv) {
            AppMethodBeat.m2505o(132588);
            return;
        }
        mo6359b(c27242w);
        AppMethodBeat.m2505o(132588);
    }

    /* renamed from: c */
    public final void mo6360c(C27242w c27242w) {
        AppMethodBeat.m2504i(132589);
        this.iAH = null;
        if (this.iAI) {
            this.iAI = false;
            AppMethodBeat.m2505o(132589);
            return;
        }
        this.iAM.mo6360c(c27242w);
        this.iAK.mo73470p(c27242w);
        AppMethodBeat.m2505o(132589);
    }

    /* renamed from: a */
    public final void mo22128a(long j, C2412aq c2412aq) {
        int i;
        AppMethodBeat.m2504i(132590);
        switch (c2412aq) {
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
        m18384h(j, i);
        C7060h.pYm.mo8378a(390, 0, 1, false);
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
        C7060h.pYm.mo8378a(390, (long) i, 1, false);
        AppMethodBeat.m2505o(132590);
    }

    /* renamed from: h */
    private void m18384h(long j, int i) {
        AppMethodBeat.m2504i(132591);
        int i2 = this.gOq.atH().hhd.gVu;
        C7060h.pYm.mo8381e(13543, this.mAppId, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.m2505o(132591);
    }
}
