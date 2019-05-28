package com.tencent.p177mm.plugin.luckymoney.model;

import android.net.Uri;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42073vg;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.av */
public final class C43257av implements C1202f {
    boolean nZr;
    public C36787aq nZs;
    public C36786an nZt;
    private C12425af nZu;
    public C4884c nZv = new C344441();

    /* renamed from: com.tencent.mm.plugin.luckymoney.model.av$1 */
    class C344441 extends C4884c<C42073vg> {
        C344441() {
            AppMethodBeat.m2504i(42425);
            this.xxI = C42073vg.class.getName().hashCode();
            AppMethodBeat.m2505o(42425);
        }

        /* renamed from: a */
        private boolean m56440a(C42073vg c42073vg) {
            AppMethodBeat.m2504i(42426);
            if (c42073vg instanceof C42073vg) {
                switch (c42073vg.cSe.action) {
                    case 1:
                        C1202f c1202f = C43257av.this;
                        long j = c42073vg.cSe.cuQ;
                        if (!c1202f.nZr) {
                            C8910b X;
                            c1202f.nZr = true;
                            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                            String str = jf.field_content;
                            if (str != null) {
                                X = C8910b.m16058X(str, jf.field_reserved);
                            } else {
                                X = null;
                            }
                            if (X != null) {
                                String nullAsNil = C5046bo.nullAsNil(X.fhZ);
                                Uri parse = Uri.parse(nullAsNil);
                                String queryParameter = parse.getQueryParameter("sendid");
                                int i = C5046bo.getInt(parse.getQueryParameter("channelid"), 1);
                                if (c1202f.nZs != null) {
                                    C1720g.m3537RQ();
                                    C1720g.m3535RO().eJo.mo14547c(c1202f.nZs);
                                    c1202f.nZs = null;
                                }
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14539a(1581, c1202f);
                                c1202f.nZs = new C36787aq(i, queryParameter, nullAsNil, 3, "v1.0");
                                c1202f.nZs.talker = jf.field_talker;
                                c1202f.nZs.cvx = j;
                                C1720g.m3537RQ();
                                C1720g.m3535RO().eJo.mo14541a(c1202f.nZs, 0);
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(42426);
            return false;
        }
    }

    public C43257av() {
        AppMethodBeat.m2504i(42428);
        C4879a.xxA.mo10052c(this.nZv);
        AppMethodBeat.m2505o(42428);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42429);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1581, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1685, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1585, (C1202f) this);
        if (c1207m instanceof C36787aq) {
            C36787aq c36787aq = (C36787aq) c1207m;
            if (i != 0 || i2 != 0) {
                this.nZr = false;
                C43257av.m76991jd(c36787aq.cvx);
                AppMethodBeat.m2505o(42429);
            } else if (c36787aq.cRU == 4) {
                if (this.nZu != null) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(this.nZu);
                    this.nZu = null;
                }
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(1585, (C1202f) this);
                this.nZu = new C12425af(c36787aq.nSX, 11, 0, c36787aq.cRS, "v1.0");
                this.nZu.talker = c36787aq.talker;
                this.nZu.cvx = c36787aq.cvx;
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(this.nZu, 0);
                C4990ab.m7416i("MicroMsg.Wear.WearLuckyLogic", "start to get detail");
                AppMethodBeat.m2505o(42429);
            } else if (c36787aq.cRV == 1 || c36787aq.cRU == 5 || c36787aq.cRU == 1) {
                this.nZr = false;
                C4990ab.m7416i("MicroMsg.Wear.WearLuckyLogic", "receive lucky already");
                C43257av.m76991jd(c36787aq.cvx);
                AppMethodBeat.m2505o(42429);
            } else {
                if (this.nZt != null) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c(this.nZt);
                    this.nZt = null;
                }
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(1685, (C1202f) this);
                this.nZt = new C36786an(c36787aq.msgType, c36787aq.cdf, c36787aq.nSX, c36787aq.cRS, C46063x.bLC(), C1853r.m3820YB(), c36787aq.talker, "v1.0", c36787aq.nZl);
                this.nZt.cvx = c36787aq.cvx;
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(this.nZt, 0);
                C4990ab.m7416i("MicroMsg.Wear.WearLuckyLogic", "start to open lucky");
                AppMethodBeat.m2505o(42429);
            }
        } else if (c1207m instanceof C36786an) {
            this.nZr = false;
            C36786an c36786an = (C36786an) c1207m;
            if (i == 0 && i2 == 0) {
                C12428k c12428k = c36786an.nYn;
                if (c12428k.cRV == 2) {
                    C43257av.m76990a(c12428k, c36786an.cvx, c36786an.talker);
                    AppMethodBeat.m2505o(42429);
                    return;
                }
                C43257av.m76991jd(c36786an.cvx);
                AppMethodBeat.m2505o(42429);
                return;
            }
            C43257av.m76991jd(c36786an.cvx);
            AppMethodBeat.m2505o(42429);
        } else {
            if (c1207m instanceof C12425af) {
                this.nZr = false;
                C12425af c12425af = (C12425af) c1207m;
                if (i == 0 && i2 == 0) {
                    C43257av.m76990a(c12425af.nYn, c12425af.cvx, c12425af.talker);
                } else {
                    C43257av.m76991jd(c12425af.cvx);
                    AppMethodBeat.m2505o(42429);
                    return;
                }
            }
            AppMethodBeat.m2505o(42429);
        }
    }

    /* renamed from: jd */
    private static void m76991jd(long j) {
        AppMethodBeat.m2504i(42430);
        C4883b c42073vg = new C42073vg();
        c42073vg.cSe.action = 2;
        c42073vg.cSf.cuQ = j;
        c42073vg.cSf.cSh = 0;
        c42073vg.cSf.cSi = "";
        C4879a.xxA.mo10048a(c42073vg, Looper.getMainLooper());
        AppMethodBeat.m2505o(42430);
    }

    /* renamed from: a */
    private static void m76990a(C12428k c12428k, long j, String str) {
        AppMethodBeat.m2504i(42431);
        C4883b c42073vg = new C42073vg();
        c42073vg.cSe.action = 2;
        c42073vg.cSf.cuQ = j;
        c42073vg.cSf.cSh = c12428k.cSh;
        c42073vg.cSf.cSi = c12428k.nXb;
        c42073vg.cSf.cSj = new ArrayList();
        if (C1855t.m3896kH(str)) {
            Iterator it = c12428k.nXj.iterator();
            while (it.hasNext()) {
                C39323w c39323w = (C39323w) it.next();
                c42073vg.cSf.cSj.add(C17884o.acv().mo67497qc(c39323w.nYa) + "=" + c39323w.nXZ + "=" + c39323w.nXM);
            }
        }
        C4879a.xxA.mo10048a(c42073vg, Looper.getMainLooper());
        AppMethodBeat.m2505o(42431);
    }
}
