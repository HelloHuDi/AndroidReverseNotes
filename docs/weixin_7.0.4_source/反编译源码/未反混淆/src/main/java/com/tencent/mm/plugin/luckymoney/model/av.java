package com.tencent.mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;

public final class av implements f {
    boolean nZr;
    public aq nZs;
    public an nZt;
    private af nZu;
    public c nZv = new c<vg>() {
        {
            AppMethodBeat.i(42425);
            this.xxI = vg.class.getName().hashCode();
            AppMethodBeat.o(42425);
        }

        private boolean a(vg vgVar) {
            AppMethodBeat.i(42426);
            if (vgVar instanceof vg) {
                switch (vgVar.cSe.action) {
                    case 1:
                        f fVar = av.this;
                        long j = vgVar.cSe.cuQ;
                        if (!fVar.nZr) {
                            b X;
                            fVar.nZr = true;
                            bi jf = ((j) g.K(j.class)).bOr().jf(j);
                            String str = jf.field_content;
                            if (str != null) {
                                X = b.X(str, jf.field_reserved);
                            } else {
                                X = null;
                            }
                            if (X != null) {
                                String nullAsNil = bo.nullAsNil(X.fhZ);
                                Uri parse = Uri.parse(nullAsNil);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i = bo.getInt(parse.getQueryParameter("channelid"), 1);
                                if (fVar.nZs != null) {
                                    g.RQ();
                                    g.RO().eJo.c(fVar.nZs);
                                    fVar.nZs = null;
                                }
                                g.RQ();
                                g.RO().eJo.a(1581, fVar);
                                fVar.nZs = new aq(i, queryParameter, nullAsNil, 3, "v1.0");
                                fVar.nZs.talker = jf.field_talker;
                                fVar.nZs.cvx = j;
                                g.RQ();
                                g.RO().eJo.a(fVar.nZs, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(42426);
            return false;
        }
    };

    public av() {
        AppMethodBeat.i(42428);
        a.xxA.c(this.nZv);
        AppMethodBeat.o(42428);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42429);
        g.RQ();
        g.RO().eJo.b(1581, (f) this);
        g.RQ();
        g.RO().eJo.b(1685, (f) this);
        g.RQ();
        g.RO().eJo.b(1585, (f) this);
        if (mVar instanceof aq) {
            aq aqVar = (aq) mVar;
            if (i != 0 || i2 != 0) {
                this.nZr = false;
                jd(aqVar.cvx);
                AppMethodBeat.o(42429);
            } else if (aqVar.cRU == 4) {
                if (this.nZu != null) {
                    g.RQ();
                    g.RO().eJo.c(this.nZu);
                    this.nZu = null;
                }
                g.RQ();
                g.RO().eJo.a(1585, (f) this);
                this.nZu = new af(aqVar.nSX, 11, 0, aqVar.cRS, "v1.0");
                this.nZu.talker = aqVar.talker;
                this.nZu.cvx = aqVar.cvx;
                g.RQ();
                g.RO().eJo.a(this.nZu, 0);
                ab.i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
                AppMethodBeat.o(42429);
            } else if (aqVar.cRV == 1 || aqVar.cRU == 5 || aqVar.cRU == 1) {
                this.nZr = false;
                ab.i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                jd(aqVar.cvx);
                AppMethodBeat.o(42429);
            } else {
                if (this.nZt != null) {
                    g.RQ();
                    g.RO().eJo.c(this.nZt);
                    this.nZt = null;
                }
                g.RQ();
                g.RO().eJo.a(1685, (f) this);
                this.nZt = new an(aqVar.msgType, aqVar.cdf, aqVar.nSX, aqVar.cRS, x.bLC(), r.YB(), aqVar.talker, "v1.0", aqVar.nZl);
                this.nZt.cvx = aqVar.cvx;
                g.RQ();
                g.RO().eJo.a(this.nZt, 0);
                ab.i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
                AppMethodBeat.o(42429);
            }
        } else if (mVar instanceof an) {
            this.nZr = false;
            an anVar = (an) mVar;
            if (i == 0 && i2 == 0) {
                k kVar = anVar.nYn;
                if (kVar.cRV == 2) {
                    a(kVar, anVar.cvx, anVar.talker);
                    AppMethodBeat.o(42429);
                    return;
                }
                jd(anVar.cvx);
                AppMethodBeat.o(42429);
                return;
            }
            jd(anVar.cvx);
            AppMethodBeat.o(42429);
        } else {
            if (mVar instanceof af) {
                this.nZr = false;
                af afVar = (af) mVar;
                if (i == 0 && i2 == 0) {
                    a(afVar.nYn, afVar.cvx, afVar.talker);
                } else {
                    jd(afVar.cvx);
                    AppMethodBeat.o(42429);
                    return;
                }
            }
            AppMethodBeat.o(42429);
        }
    }

    private static void jd(long j) {
        AppMethodBeat.i(42430);
        com.tencent.mm.sdk.b.b vgVar = new vg();
        vgVar.cSe.action = 2;
        vgVar.cSf.cuQ = j;
        vgVar.cSf.cSh = 0;
        vgVar.cSf.cSi = "";
        a.xxA.a(vgVar, Looper.getMainLooper());
        AppMethodBeat.o(42430);
    }

    private static void a(k kVar, long j, String str) {
        AppMethodBeat.i(42431);
        com.tencent.mm.sdk.b.b vgVar = new vg();
        vgVar.cSe.action = 2;
        vgVar.cSf.cuQ = j;
        vgVar.cSf.cSh = kVar.cSh;
        vgVar.cSf.cSi = kVar.nXb;
        vgVar.cSf.cSj = new ArrayList();
        if (t.kH(str)) {
            Iterator it = kVar.nXj.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                vgVar.cSf.cSj.add(o.acv().qc(wVar.nYa) + "=" + wVar.nXZ + "=" + wVar.nXM);
            }
        }
        a.xxA.a(vgVar, Looper.getMainLooper());
        AppMethodBeat.o(42431);
    }
}
