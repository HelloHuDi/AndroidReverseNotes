package com.tencent.mm.aj;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.byj;
import com.tencent.mm.protocal.protobuf.sm;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;

public final class k {
    private a ecy;
    int fwt;
    private d fwu;
    private int fwv;
    int fww;
    boolean fwx;
    b fwy;
    public bxk fwz;
    String userName;

    protected k() {
        AppMethodBeat.i(11405);
        this.userName = null;
        this.fwt = 0;
        this.fwv = 2;
        this.fww = 10;
        this.fwx = false;
        this.fwy = new b() {
            public final void a(int i, n nVar, Object obj) {
                AppMethodBeat.i(11401);
                if (obj == null || !(obj instanceof String)) {
                    ab.i("MicroMsg.ReportLocation", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
                    AppMethodBeat.o(11401);
                    return;
                }
                if (k.this.userName.equals((String) obj) && k.this.fwt == 1) {
                    ab.i("MicroMsg.ReportLocation", "contactStgUpdate, %s", k.this.userName);
                    k.this.rj(k.this.userName);
                    ((j) g.K(j.class)).XM().b(k.this.fwy);
                }
                AppMethodBeat.o(11401);
            }
        };
        this.ecy = new a() {
            long lastReportTime = 0;

            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                AppMethodBeat.i(11402);
                if (z) {
                    ab.i("MicroMsg.ReportLocation", "LBSManager notify. lat:%f, lng:%f", Float.valueOf(f2), Float.valueOf(f));
                    if (bo.anT() >= this.lastReportTime + ((long) k.this.fww)) {
                        k.a(k.this.userName, 0, f2, f, (int) d2);
                        this.lastReportTime = bo.anT();
                    }
                    if (k.this.fwt == 2) {
                        k.this.aeJ();
                    }
                    if (!k.this.fwx) {
                        k.this.fwx = true;
                        o.a(2013, f, f2, (int) d2);
                    }
                    AppMethodBeat.o(11402);
                    return true;
                }
                AppMethodBeat.o(11402);
                return true;
            }
        };
        this.fww = bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nv().O("BrandService", "continueLocationReportInterval"), 5);
        if (this.fww < this.fwv) {
            this.fww = this.fwv;
        }
        ab.i("MicroMsg.ReportLocation", "reportLocation interval %d", Integer.valueOf(this.fww));
        AppMethodBeat.o(11405);
    }

    public final void a(String str, bi biVar, int i, bxk bxk) {
        AppMethodBeat.i(11406);
        final bxk bxk2 = bxk;
        final String str2 = str;
        final bi biVar2 = biVar;
        final int i2 = i;
        com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11403);
                k.a(bxk2, str2);
                if (biVar2 == null || !biVar2.drC()) {
                    k.a(str2, 10, null, i2, bxk2);
                    AppMethodBeat.o(11403);
                    return;
                }
                LinkedList linkedList = new LinkedList();
                com.tencent.mm.af.o b = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar2.field_msgId, biVar2.field_content);
                if (b == null || bo.ek(b.fjr)) {
                    k.a(str2, 10, null, i2, bxk2);
                    AppMethodBeat.o(11403);
                    return;
                }
                Iterator it = b.fjr.iterator();
                while (it.hasNext()) {
                    p pVar = (p) it.next();
                    String str = pVar.url;
                    if (!bo.isNullOrNil(str)) {
                        Uri parse = Uri.parse(str);
                        try {
                            String queryParameter = parse.getQueryParameter("mid");
                            str = parse.getQueryParameter("idx");
                            sm smVar = new sm();
                            smVar.jVD = bo.getLong(queryParameter, 0);
                            smVar.jVE = bo.getInt(str, 0);
                            smVar.csB = pVar.fjG;
                            smVar.path = pVar.fjD;
                            linkedList.add(smVar);
                        } catch (UnsupportedOperationException e) {
                            ab.w("MicroMsg.ReportLocation", "UnsupportedOperationException %s", e.getMessage());
                        }
                    }
                }
                k.a(str2, 10, linkedList, i2, bxk2);
                AppMethodBeat.o(11403);
            }
        });
        AppMethodBeat.o(11406);
    }

    public final void a(final String str, final bxk bxk) {
        AppMethodBeat.i(11407);
        com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(11404);
                k.a(bxk, str);
                k.a(str, 12, null, 0, bxk);
                AppMethodBeat.o(11404);
            }
        });
        AppMethodBeat.o(11407);
    }

    public static void a(bxk bxk, String str) {
        AppMethodBeat.i(11408);
        if (bxk == null || bxk.wXt <= 0) {
            AppMethodBeat.o(11408);
            return;
        }
        int min = Math.min(bxk.wXt, 30);
        bxk.wXw = 0;
        bxk.wXx = 0;
        Cursor i = ((j) g.K(j.class)).bOr().i(str, min, 0);
        while (i.moveToNext()) {
            bi biVar = new bi();
            biVar.d(i);
            if (biVar.field_isSend != 1) {
                if (biVar.dtu()) {
                    bxk.wXx++;
                } else {
                    bf.b oE = bf.oE(biVar.dqJ);
                    if (oE != null && oE.fmq == 3) {
                        bxk.wXw++;
                    }
                }
            }
        }
        i.close();
        AppMethodBeat.o(11408);
    }

    public static void a(String str, byj byj, int i) {
        AppMethodBeat.i(11409);
        a(str, i, 0, 0.0f, 0.0f, 0, null, 0, null, byj);
        AppMethodBeat.o(11409);
    }

    public final void rj(String str) {
        AppMethodBeat.i(11410);
        ab.i("MicroMsg.ReportLocation", "Start report");
        this.userName = str;
        d qX = f.qX(str);
        if (qX == null) {
            AppMethodBeat.o(11410);
            return;
        }
        if (this.fwt != 0) {
            aeJ();
        }
        this.fwt = 0;
        if (qX.adJ()) {
            ab.i("MicroMsg.ReportLocation", "need update contact %s", str);
            com.tencent.mm.ah.b.pY(str);
        }
        d.b cJ = qX.cJ(false);
        if (cJ == null) {
            AppMethodBeat.o(11410);
        } else if (cJ.adL() && qX.adI()) {
            this.fwu = d.agz();
            cJ = qX.cJ(false);
            if (cJ.fvc != null) {
                cJ.fvp = bo.getInt(cJ.fvc.optString("ReportLocationType"), 0) == 2;
            }
            this.fwt = cJ.fvp ? 3 : 2;
            if (d.agA() || d.agB()) {
                this.fwu.a(this.ecy, true);
                AppMethodBeat.o(11410);
                return;
            }
            a(str, 2, 0.0f, 0.0f, 0);
            AppMethodBeat.o(11410);
        } else {
            if (cJ.adL() && !qX.adI()) {
                a(str, 1, 0.0f, 0.0f, 0);
            }
            AppMethodBeat.o(11410);
        }
    }

    public final void aeJ() {
        AppMethodBeat.i(11411);
        ab.i("MicroMsg.ReportLocation", "Stop report");
        this.fwt = 0;
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        if (g.RN().QY()) {
            ((j) g.K(j.class)).XM().b(this.fwy);
        }
        AppMethodBeat.o(11411);
    }

    static void a(String str, int i, float f, float f2, int i2) {
        AppMethodBeat.i(11412);
        b(str, i, f, f2, i2);
        AppMethodBeat.o(11412);
    }

    private static void b(String str, int i, float f, float f2, int i2) {
        AppMethodBeat.i(11413);
        a(str, 11, i, f, f2, i2, null, 0, null, null);
        AppMethodBeat.o(11413);
    }

    public static void a(String str, int i, int i2, float f, float f2, int i3, LinkedList<sm> linkedList, int i4, bxk bxk, byj byj) {
        String str2;
        AppMethodBeat.i(11414);
        if (i2 == 3) {
            str2 = "<event></event>";
        } else {
            str2 = String.format("<event><location><errcode>%d</errcode><data><latitude>%f</latitude><longitude>%f</longitude><precision>%d</precision></data></location></event>", new Object[]{Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3)});
        }
        ab.i("MicroMsg.ReportLocation", "doScene, info: %s", str2);
        g.RO().eJo.a(new q(str, i, str2, linkedList, i4, bxk, byj), 0);
        AppMethodBeat.o(11414);
    }
}
