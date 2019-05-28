package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class y extends c<uq> implements f {
    private boolean cQR;
    private boolean cQS;
    private boolean mru;
    private uq tCt;

    public y() {
        AppMethodBeat.i(46904);
        this.mru = false;
        this.cQR = false;
        this.cQS = false;
        this.xxI = uq.class.getName().hashCode();
        AppMethodBeat.o(46904);
    }

    private boolean a(uq uqVar) {
        AppMethodBeat.i(46905);
        if (uqVar instanceof uq) {
            this.mru = false;
            this.tCt = uqVar;
            this.cQR = uqVar.cQP.cQR;
            this.cQS = uqVar.cQP.cQS;
            ab.i("MicroMsg.WalletGetUserInfoEventListener", "mustNotifyAfterNetEnd: %s", Boolean.valueOf(this.cQS));
            g.RQ();
            g.RO().eJo.a(385, (f) this);
            g.RQ();
            g.RO().eJo.a(1518, (f) this);
            p pVar;
            int i;
            ak cPI;
            boolean z;
            if (r.cPI().cQl()) {
                ab.i("MicroMsg.WalletGetUserInfoEventListener", "data is invalid. doScene");
                if (r.YM()) {
                    g.RQ();
                    g.RO().eJo.a(new a(), 0);
                } else {
                    g.RQ();
                    pVar = g.RO().eJo;
                    if (Hq(uqVar.cQP.scene)) {
                        i = uqVar.cQP.scene;
                    } else {
                        i = 0;
                    }
                    pVar.a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
                }
            } else if (uqVar.cQP.cQR) {
                ab.i("MicroMsg.WalletGetUserInfoEventListener", "use cache");
                cPI = r.cPI();
                ab.i("MicroMsg.WalletUserInfoManger", "checkCacheTimeout, nowSecs: %s, cacheDeadTime: %s", Long.valueOf(bo.anT()), Long.valueOf(cPI.tDb));
                if (cPI.tDb <= 0 || r4 > cPI.tDb) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ab.i("MicroMsg.WalletGetUserInfoEventListener", "cache timeout, do NetSceneTenpayQueryBoundBankcard");
                    if (r.YM()) {
                        g.RQ();
                        g.RO().eJo.a(new a(), 0);
                    } else {
                        g.RQ();
                        pVar = g.RO().eJo;
                        if (Hq(uqVar.cQP.scene)) {
                            i = uqVar.cQP.scene;
                        } else {
                            i = 0;
                        }
                        pVar.a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
                    }
                } else {
                    if (!this.cQS) {
                        this.mru = true;
                    }
                    ab.i("MicroMsg.WalletGetUserInfoEventListener", "cache data is ok. doCallback");
                    a(0, "", null, false);
                    if (r.YM()) {
                        g.RQ();
                        g.RO().eJo.a(new a(), 0);
                    } else {
                        g.RQ();
                        pVar = g.RO().eJo;
                        if (Hq(uqVar.cQP.scene)) {
                            i = uqVar.cQP.scene;
                        } else {
                            i = 0;
                        }
                        pVar.a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
                    }
                }
            } else {
                long fp = bo.fp(r.cPI().tDa);
                ab.i("MicroMsg.WalletUserInfoManger", "dead time : %d, nowSec: %d, pass time ".concat(String.valueOf(fp)), Long.valueOf(cPI.tDa), Long.valueOf(System.currentTimeMillis() / 1000));
                if (fp > 0) {
                    i = 1;
                } else {
                    z = false;
                }
                if (i != 0) {
                    ab.i("MicroMsg.WalletGetUserInfoEventListener", "data is checkTimeOut, do NetSceneTenpayQueryBoundBankcard");
                    if (r.YM()) {
                        g.RQ();
                        g.RO().eJo.a(new a(), 0);
                    } else {
                        g.RQ();
                        pVar = g.RO().eJo;
                        if (Hq(uqVar.cQP.scene)) {
                            i = uqVar.cQP.scene;
                        } else {
                            i = 0;
                        }
                        pVar.a(new com.tencent.mm.plugin.wallet_core.c.y(null, i), 0);
                    }
                } else {
                    this.mru = true;
                    ab.i("MicroMsg.WalletGetUserInfoEventListener", "data is ok. doCallback");
                    a(0, "", null, false);
                }
            }
            AppMethodBeat.o(46905);
            return true;
        }
        ab.f("MicroMsg.WalletGetUserInfoEventListener", "mismatched event");
        AppMethodBeat.o(46905);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46906);
        ab.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, errType: %s, errCode: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), mVar);
        if ((mVar instanceof com.tencent.mm.plugin.wallet_core.c.y) || (mVar instanceof a)) {
            g.RQ();
            g.RO().eJo.b(385, (f) this);
            g.RQ();
            g.RO().eJo.b(1518, (f) this);
            if (!this.cQS && this.cQR && this.mru) {
                ab.i("MicroMsg.WalletGetUserInfoEventListener", "onSceneEnd, useCache and event end");
                AppMethodBeat.o(46906);
                return;
            }
            this.mru = true;
            a(i2, str, mVar, true);
        }
        AppMethodBeat.o(46906);
    }

    private void a(int i, String str, m mVar, boolean z) {
        AppMethodBeat.i(46907);
        if (this.tCt != null) {
            this.tCt.cQQ.errCode = i;
            this.tCt.cQQ.aIm = str;
            this.tCt.cQQ.cRu = mVar;
            this.tCt.cQQ.cQT = r.cPI().cQg();
            this.tCt.cQQ.cQU = r.cPI().cQG();
            this.tCt.cQQ.cQV = r.cPI().cQI();
            this.tCt.cQQ.cQW = r.cPI().cQo().cPW();
            this.tCt.cQQ.cQX = r.cPI().cQn();
            this.tCt.cQQ.cQY = r.cPI().bhp();
            this.tCt.cQQ.cQZ = r.cPI().cQh();
            this.tCt.cQQ.cRa = r.cPI().cQo().cQa();
            this.tCt.cQQ.cRb = "";
            this.tCt.cQQ.cRo = r.cPI().cQA();
            if (mVar != null && (mVar instanceof com.tencent.mm.plugin.wallet_core.c.y)) {
                this.tCt.cQQ.cRb = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRb;
                this.tCt.cQQ.cRc = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRc;
                this.tCt.cQQ.cRd = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRd;
                this.tCt.cQQ.cRe = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRe;
                this.tCt.cQQ.cRf = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRf;
                this.tCt.cQQ.scene = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).scene;
                this.tCt.cQQ.cRg = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRg;
                this.tCt.cQQ.cRh = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRh;
                this.tCt.cQQ.cRi = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRi;
                this.tCt.cQQ.cRj = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRj;
                this.tCt.cQQ.cRk = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRk;
                this.tCt.cQQ.cRl = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRl;
                this.tCt.cQQ.subtitle = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).subtitle;
                this.tCt.cQQ.title = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).title;
                this.tCt.cQQ.cRm = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRm;
                this.tCt.cQQ.cRn = ((com.tencent.mm.plugin.wallet_core.c.y) mVar).cRn;
            }
            this.tCt.cQQ.cRp = r.cPI().cQw() ? 1 : 0;
            this.tCt.cQQ.cRq = r.cPI().cQx();
            this.tCt.cQQ.cRr = r.cPI().cQy();
            this.tCt.cQQ.cRs = r.cPI().cQz();
            this.tCt.cQQ.cRt = z;
            ab.d("MicroMsg.WalletGetUserInfoEventListener", "mUserInfo needBind : " + this.tCt.cQQ.cQU + " hasNewTips : " + this.tCt.cQQ.cQV + " swipeOn : " + this.tCt.cQQ.cQW);
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
        AppMethodBeat.o(46907);
    }

    private static boolean Hq(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
            return true;
        }
        return false;
    }
}
