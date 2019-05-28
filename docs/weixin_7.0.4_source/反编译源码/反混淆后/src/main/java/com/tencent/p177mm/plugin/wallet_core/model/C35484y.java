package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.y */
public final class C35484y extends C4884c<C18416uq> implements C1202f {
    private boolean cQR;
    private boolean cQS;
    private boolean mru;
    private C18416uq tCt;

    public C35484y() {
        AppMethodBeat.m2504i(46904);
        this.mru = false;
        this.cQR = false;
        this.cQS = false;
        this.xxI = C18416uq.class.getName().hashCode();
        AppMethodBeat.m2505o(46904);
    }

    /* renamed from: a */
    private boolean m58242a(C18416uq c18416uq) {
        AppMethodBeat.m2504i(46905);
        if (c18416uq instanceof C18416uq) {
            this.mru = false;
            this.tCt = c18416uq;
            this.cQR = c18416uq.cQP.cQR;
            this.cQS = c18416uq.cQP.cQS;
            C4990ab.m7417i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", Boolean.valueOf(this.cQS));
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(1518, (C1202f) this);
            C6300p c6300p;
            int i;
            C22587ak cPI;
            boolean z;
            if (C14241r.cPI().cQl()) {
                C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (C1853r.m3831YM()) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C46358a(), 0);
                } else {
                    C1720g.m3537RQ();
                    c6300p = C1720g.m3535RO().eJo;
                    if (C35484y.m58240Hq(c18416uq.cQP.scene)) {
                        i = c18416uq.cQP.scene;
                    } else {
                        i = 0;
                    }
                    c6300p.mo14541a(new C35475y(null, i), 0);
                }
            } else if (c18416uq.cQP.cQR) {
                C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
                cPI = C14241r.cPI();
                C4990ab.m7417i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", Long.valueOf(C5046bo.anT()), Long.valueOf(cPI.tDb));
                if (cPI.tDb <= 0 || r4 > cPI.tDb) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
                    if (C1853r.m3831YM()) {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C46358a(), 0);
                    } else {
                        C1720g.m3537RQ();
                        c6300p = C1720g.m3535RO().eJo;
                        if (C35484y.m58240Hq(c18416uq.cQP.scene)) {
                            i = c18416uq.cQP.scene;
                        } else {
                            i = 0;
                        }
                        c6300p.mo14541a(new C35475y(null, i), 0);
                    }
                } else {
                    if (!this.cQS) {
                        this.mru = true;
                    }
                    C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
                    m58241a(0, "", null, false);
                    if (C1853r.m3831YM()) {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C46358a(), 0);
                    } else {
                        C1720g.m3537RQ();
                        c6300p = C1720g.m3535RO().eJo;
                        if (C35484y.m58240Hq(c18416uq.cQP.scene)) {
                            i = c18416uq.cQP.scene;
                        } else {
                            i = 0;
                        }
                        c6300p.mo14541a(new C35475y(null, i), 0);
                    }
                }
            } else {
                long fp = C5046bo.m7549fp(C14241r.cPI().tDa);
                C4990ab.m7417i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(fp)), Long.valueOf(cPI.tDa), Long.valueOf(System.currentTimeMillis() / 1000));
                if (fp > 0) {
                    i = 1;
                } else {
                    z = false;
                }
                if (i != 0) {
                    C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (C1853r.m3831YM()) {
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(new C46358a(), 0);
                    } else {
                        C1720g.m3537RQ();
                        c6300p = C1720g.m3535RO().eJo;
                        if (C35484y.m58240Hq(c18416uq.cQP.scene)) {
                            i = c18416uq.cQP.scene;
                        } else {
                            i = 0;
                        }
                        c6300p.mo14541a(new C35475y(null, i), 0);
                    }
                } else {
                    this.mru = true;
                    C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                    m58241a(0, "", null, false);
                }
            }
            AppMethodBeat.m2505o(46905);
            return true;
        }
        C4990ab.m7414f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        AppMethodBeat.m2505o(46905);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46906);
        C4990ab.m7417i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), c1207m);
        if ((c1207m instanceof C35475y) || (c1207m instanceof C46358a)) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(1518, (C1202f) this);
            if (!this.cQS && this.cQR && this.mru) {
                C4990ab.m7416i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
                AppMethodBeat.m2505o(46906);
                return;
            }
            this.mru = true;
            m58241a(i2, str, c1207m, true);
        }
        AppMethodBeat.m2505o(46906);
    }

    /* renamed from: a */
    private void m58241a(int i, String str, C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(46907);
        if (this.tCt != null) {
            this.tCt.cQQ.errCode = i;
            this.tCt.cQQ.aIm = str;
            this.tCt.cQQ.cRu = c1207m;
            this.tCt.cQQ.cQT = C14241r.cPI().cQg();
            this.tCt.cQQ.cQU = C14241r.cPI().cQG();
            this.tCt.cQQ.cQV = C14241r.cPI().cQI();
            this.tCt.cQQ.cQW = C14241r.cPI().cQo().cPW();
            this.tCt.cQQ.cQX = C14241r.cPI().cQn();
            this.tCt.cQQ.cQY = C14241r.cPI().bhp();
            this.tCt.cQQ.cQZ = C14241r.cPI().cQh();
            this.tCt.cQQ.cRa = C14241r.cPI().cQo().cQa();
            this.tCt.cQQ.cRb = "";
            this.tCt.cQQ.cRo = C14241r.cPI().cQA();
            if (c1207m != null && (c1207m instanceof C35475y)) {
                this.tCt.cQQ.cRb = ((C35475y) c1207m).cRb;
                this.tCt.cQQ.cRc = ((C35475y) c1207m).cRc;
                this.tCt.cQQ.cRd = ((C35475y) c1207m).cRd;
                this.tCt.cQQ.cRe = ((C35475y) c1207m).cRe;
                this.tCt.cQQ.cRf = ((C35475y) c1207m).cRf;
                this.tCt.cQQ.scene = ((C35475y) c1207m).scene;
                this.tCt.cQQ.cRg = ((C35475y) c1207m).cRg;
                this.tCt.cQQ.cRh = ((C35475y) c1207m).cRh;
                this.tCt.cQQ.cRi = ((C35475y) c1207m).cRi;
                this.tCt.cQQ.cRj = ((C35475y) c1207m).cRj;
                this.tCt.cQQ.cRk = ((C35475y) c1207m).cRk;
                this.tCt.cQQ.cRl = ((C35475y) c1207m).cRl;
                this.tCt.cQQ.subtitle = ((C35475y) c1207m).subtitle;
                this.tCt.cQQ.title = ((C35475y) c1207m).title;
                this.tCt.cQQ.cRm = ((C35475y) c1207m).cRm;
                this.tCt.cQQ.cRn = ((C35475y) c1207m).cRn;
            }
            this.tCt.cQQ.cRp = C14241r.cPI().cQw() ? 1 : 0;
            this.tCt.cQQ.cRq = C14241r.cPI().cQx();
            this.tCt.cQQ.cRr = C14241r.cPI().cQy();
            this.tCt.cQQ.cRs = C14241r.cPI().cQz();
            this.tCt.cQQ.cRt = z;
            C4990ab.m7410d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.tCt.cQQ.cQU + " hasNewTips : " + this.tCt.cQQ.cQV + " swipeOn : " + this.tCt.cQQ.cQW);
            if (this.tCt.callback != null) {
                this.tCt.callback.run();
            }
            if (this.tCt.cQQ.cQH != null) {
                this.tCt.cQQ.cQH.run();
            }
        }
        if (this.mru) {
            this.tCt = null;
        }
        AppMethodBeat.m2505o(46907);
    }

    /* renamed from: Hq */
    private static boolean m58240Hq(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }
}
