package com.tencent.p177mm.p184aj;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.C44168sm;
import com.tencent.p177mm.protocal.protobuf.bxk;
import com.tencent.p177mm.protocal.protobuf.byj;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.aj.k */
public final class C25767k {
    private C42206a ecy;
    int fwt;
    private C26443d fwu;
    private int fwv;
    int fww;
    boolean fwx;
    C4937b fwy;
    public bxk fwz;
    String userName;

    /* renamed from: com.tencent.mm.aj.k$1 */
    class C257681 implements C4937b {
        C257681() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(11401);
            if (obj == null || !(obj instanceof String)) {
                C4990ab.m7417i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
                AppMethodBeat.m2505o(11401);
                return;
            }
            if (C25767k.this.userName.equals((String) obj) && C25767k.this.fwt == 1) {
                C4990ab.m7417i("MicroMsg.ReportLocation", "contactStgUpdate, %s", C25767k.this.userName);
                C25767k.this.mo43734rj(C25767k.this.userName);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(C25767k.this.fwy);
            }
            AppMethodBeat.m2505o(11401);
        }
    }

    /* renamed from: com.tencent.mm.aj.k$2 */
    class C257692 implements C42206a {
        long lastReportTime = 0;

        C257692() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(11402);
            if (z) {
                C4990ab.m7417i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", Float.valueOf(f2), Float.valueOf(f));
                if (C5046bo.anT() >= this.lastReportTime + ((long) C25767k.this.fww)) {
                    C25767k.m40969a(C25767k.this.userName, 0, f2, f, (int) d2);
                    this.lastReportTime = C5046bo.anT();
                }
                if (C25767k.this.fwt == 2) {
                    C25767k.this.aeJ();
                }
                if (!C25767k.this.fwx) {
                    C25767k.this.fwx = true;
                    C18698o.m29222a(2013, f, f2, (int) d2);
                }
                AppMethodBeat.m2505o(11402);
                return true;
            }
            AppMethodBeat.m2505o(11402);
            return true;
        }
    }

    protected C25767k() {
        AppMethodBeat.m2504i(11405);
        this.userName = null;
        this.fwt = 0;
        this.fwv = 2;
        this.fww = 10;
        this.fwx = false;
        this.fwy = new C257681();
        this.ecy = new C257692();
        this.fww = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15609Nv().mo5301O("BrandService", "continueLocationReportInterval"), 5);
        if (this.fww < this.fwv) {
            this.fww = this.fwv;
        }
        C4990ab.m7417i("MicroMsg.ReportLocation", "reportLocation interval %d", Integer.valueOf(this.fww));
        AppMethodBeat.m2505o(11405);
    }

    /* renamed from: a */
    public final void mo43732a(String str, C7620bi c7620bi, int i, bxk bxk) {
        AppMethodBeat.m2504i(11406);
        final bxk bxk2 = bxk;
        final String str2 = str;
        final C7620bi c7620bi2 = c7620bi;
        final int i2 = i;
        C7305d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(11403);
                C25767k.m40968a(bxk2, str2);
                if (c7620bi2 == null || !c7620bi2.drC()) {
                    C25767k.m40971a(str2, 10, null, i2, bxk2);
                    AppMethodBeat.m2505o(11403);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi2.field_msgId, c7620bi2.field_content);
                if (b == null || C5046bo.m7548ek(b.fjr)) {
                    C25767k.m40971a(str2, 10, null, i2, bxk2);
                    AppMethodBeat.m2505o(11403);
                    return;
                }
                Iterator it = b.fjr.iterator();
                while (it.hasNext()) {
                    C32224p c32224p = (C32224p) it.next();
                    String str = c32224p.url;
                    if (!C5046bo.isNullOrNil(str)) {
                        Uri parse = Uri.parse(str);
                        try {
                            String queryParameter = parse.getQueryParameter("mid");
                            str = parse.getQueryParameter("idx");
                            C44168sm c44168sm = new C44168sm();
                            c44168sm.jVD = C5046bo.getLong(queryParameter, 0);
                            c44168sm.jVE = C5046bo.getInt(str, 0);
                            c44168sm.csB = c32224p.fjG;
                            c44168sm.path = c32224p.fjD;
                            linkedList.add(c44168sm);
                        } catch (UnsupportedOperationException e) {
                            C4990ab.m7421w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", e.getMessage());
                        }
                    }
                }
                C25767k.m40971a(str2, 10, linkedList, i2, bxk2);
                AppMethodBeat.m2505o(11403);
            }
        });
        AppMethodBeat.m2505o(11406);
    }

    /* renamed from: a */
    public final void mo43731a(final String str, final bxk bxk) {
        AppMethodBeat.m2504i(11407);
        C7305d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(11404);
                C25767k.m40968a(bxk, str);
                C25767k.m40971a(str, 12, null, 0, bxk);
                AppMethodBeat.m2505o(11404);
            }
        });
        AppMethodBeat.m2505o(11407);
    }

    /* renamed from: a */
    public static void m40968a(bxk bxk, String str) {
        AppMethodBeat.m2504i(11408);
        if (bxk == null || bxk.wXt <= 0) {
            AppMethodBeat.m2505o(11408);
            return;
        }
        int min = Math.min(bxk.wXt, 30);
        bxk.wXw = 0;
        bxk.wXx = 0;
        Cursor i = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15339i(str, min, 0);
        while (i.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(i);
            if (c7620bi.field_isSend != 1) {
                if (c7620bi.dtu()) {
                    bxk.wXx++;
                } else {
                    C1828b oE = C1829bf.m3758oE(c7620bi.dqJ);
                    if (oE != null && oE.fmq == 3) {
                        bxk.wXw++;
                    }
                }
            }
        }
        i.close();
        AppMethodBeat.m2505o(11408);
    }

    /* renamed from: a */
    public static void m40972a(String str, byj byj, int i) {
        AppMethodBeat.m2504i(11409);
        C25767k.m40970a(str, i, 0, 0.0f, 0.0f, 0, null, 0, null, byj);
        AppMethodBeat.m2505o(11409);
    }

    /* renamed from: rj */
    public final void mo43734rj(String str) {
        AppMethodBeat.m2504i(11410);
        C4990ab.m7416i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        C16527d qX = C17903f.m28104qX(str);
        if (qX == null) {
            AppMethodBeat.m2505o(11410);
            return;
        }
        if (this.fwt != 0) {
            aeJ();
        }
        this.fwt = 0;
        if (qX.adJ()) {
            C4990ab.m7417i("MicroMsg.ReportLocation", "need update contact %s", str);
            C41730b.m73506pY(str);
        }
        C16529b cJ = qX.mo30481cJ(false);
        if (cJ == null) {
            AppMethodBeat.m2505o(11410);
        } else if (cJ.adL() && qX.adI()) {
            this.fwu = C26443d.agz();
            cJ = qX.mo30481cJ(false);
            if (cJ.fvc != null) {
                cJ.fvp = C5046bo.getInt(cJ.fvc.optString("ReportLocationType"), 0) == 2;
            }
            this.fwt = cJ.fvp ? 3 : 2;
            if (C26443d.agA() || C26443d.agB()) {
                this.fwu.mo44204a(this.ecy, true);
                AppMethodBeat.m2505o(11410);
                return;
            }
            C25767k.m40969a(str, 2, 0.0f, 0.0f, 0);
            AppMethodBeat.m2505o(11410);
        } else {
            if (cJ.adL() && !qX.adI()) {
                C25767k.m40969a(str, 1, 0.0f, 0.0f, 0);
            }
            AppMethodBeat.m2505o(11410);
        }
    }

    public final void aeJ() {
        AppMethodBeat.m2504i(11411);
        C4990ab.m7416i("MicroMsg.ReportLocation", "Stop report");
        this.fwt = 0;
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        if (C1720g.m3534RN().mo5161QY()) {
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo10121b(this.fwy);
        }
        AppMethodBeat.m2505o(11411);
    }

    /* renamed from: a */
    static void m40969a(String str, int i, float f, float f2, int i2) {
        AppMethodBeat.m2504i(11412);
        C25767k.m40973b(str, i, f, f2, i2);
        AppMethodBeat.m2505o(11412);
    }

    /* renamed from: b */
    private static void m40973b(String str, int i, float f, float f2, int i2) {
        AppMethodBeat.m2504i(11413);
        C25767k.m40970a(str, 11, i, f, f2, i2, null, 0, null, null);
        AppMethodBeat.m2505o(11413);
    }

    /* renamed from: a */
    public static void m40970a(String str, int i, int i2, float f, float f2, int i3, LinkedList<C44168sm> linkedList, int i4, bxk bxk, byj byj) {
        String str2;
        AppMethodBeat.m2504i(11414);
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        C4990ab.m7417i("MicroMsg.ReportLocation", "doScene, info: %s", str2);
        C1720g.m3535RO().eJo.mo14541a(new C41744q(str, i, str2, linkedList, i4, bxk, byj), 0);
        AppMethodBeat.m2505o(11414);
    }
}
