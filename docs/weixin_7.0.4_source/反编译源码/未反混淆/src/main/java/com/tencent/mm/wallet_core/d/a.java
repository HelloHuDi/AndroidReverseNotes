package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.g;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.Map;
import org.json.JSONObject;

public final class a implements f {
    private n Agh;
    private g Agi;
    int Agj = 0;
    private f Agk;

    public a(f fVar) {
        this.Agk = fVar;
    }

    public final void a(n nVar) {
        AppMethodBeat.i(49112);
        ab.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.Agj = 0;
        b(nVar);
        AppMethodBeat.o(49112);
    }

    private void b(n nVar) {
        AppMethodBeat.i(49113);
        this.Agh = nVar;
        this.Agh.pOZ = true;
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(385, (f) this);
        int cQJ = r.cPI().cQJ();
        this.Agj++;
        this.Agi = bb(this.Agh.dOr());
        this.Agi.AgA = true;
        this.Agi.K(this.Agj >= r.cPI().mRetryCount, this.Agj);
        ab.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(cQJ), Integer.valueOf(r4));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(this.Agi, cQJ);
        AppMethodBeat.o(49113);
    }

    private static g bb(Map<String, String> map) {
        AppMethodBeat.i(49114);
        String str = (String) map.get("req_key");
        g gVar;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            gVar = new g(map);
            AppMethodBeat.o(49114);
            return gVar;
        }
        ab.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", str);
        ab.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
        if (str.startsWith("sns_aa_")) {
            gVar = new b(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("sns_tf_")) {
            gVar = new k(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("sns_ff_")) {
            gVar = new d(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("ts_")) {
            gVar = new e(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("sns_")) {
            gVar = new i(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("offline_")) {
            gVar = new com.tencent.mm.wallet_core.tenpay.model.f(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("up_")) {
            gVar = new l(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("seb_ff_")) {
            gVar = new h(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("tax_")) {
            gVar = new j(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else if (str.startsWith("dc_")) {
            gVar = new c(map);
            AppMethodBeat.o(49114);
            return gVar;
        } else {
            gVar = new g(map);
            AppMethodBeat.o(49114);
            return gVar;
        }
    }

    public final void destory() {
        AppMethodBeat.i(49115);
        this.Agk = null;
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(385, (f) this);
        AppMethodBeat.o(49115);
    }

    private void a(int i, int i2, String str, JSONObject jSONObject, g gVar) {
        AppMethodBeat.i(49116);
        ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.Agh != null && jSONObject != null && i == 0 && i2 == 0) {
            ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.Agh.a(i2, str, jSONObject);
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
            if (this.Agj == 1) {
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 4, 1);
            } else if (this.Agj == 2) {
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 5, 1);
            } else if (this.Agj == 3) {
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 6, 1);
            }
        } else if (this.Agk != null) {
            ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
            if (this.Agj == 1) {
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 7, 1);
            } else if (this.Agj == 2) {
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 8, 1);
            } else if (this.Agj == 3) {
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 9, 1);
            }
            if (!gVar.AfM) {
                if (this.Agj == 1) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(965, 15, 1);
                } else if (this.Agj == 2) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(965, 16, 1);
                } else if (this.Agj == 3) {
                    com.tencent.mm.plugin.report.service.h.pYm.k(965, 17, 1);
                }
            }
        }
        ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.Agj = 0;
        AppMethodBeat.o(49116);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(49117);
        ab.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        String str2;
        if ((mVar instanceof g) && this.Agi.equals(mVar)) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(385, (f) this);
            g gVar = (g) mVar;
            ab.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", Integer.valueOf(i), Integer.valueOf(i2), str, gVar, Integer.valueOf(gVar.Agz));
            if (gVar.Agz == 1) {
                ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
                a(i, i2, str, gVar.dOp(), gVar);
                AppMethodBeat.o(49117);
                return;
            } else if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
                if (gVar.Agz == 2) {
                    a(this.Agh.AgH, this.Agh.AgI, this.Agh.AgJ, this.Agh.AgK, gVar);
                    AppMethodBeat.o(49117);
                    return;
                }
                a(i, i2, str, gVar.dOp(), gVar);
                AppMethodBeat.o(49117);
                return;
            } else if (gVar.AfM || this.Agj >= r.cPI().mRetryCount) {
                int i3;
                n nVar = this.Agh;
                int i4 = r.cPI().mRetryCount;
                ab.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(nVar.dOs()), Integer.valueOf(this.Agj));
                if (this.Agj < i4) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                    b(this.Agh);
                    AppMethodBeat.o(49117);
                    return;
                }
                ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", Integer.valueOf(gVar.Agz));
                if (gVar.Agz == 1) {
                    a(i, i2, str, gVar.dOp(), gVar);
                    AppMethodBeat.o(49117);
                    return;
                } else if (gVar.Agz == 2) {
                    a(this.Agh.AgH, this.Agh.AgI, this.Agh.AgJ, this.Agh.AgK, gVar);
                    AppMethodBeat.o(49117);
                    return;
                } else {
                    str2 = r.cPI().tDf;
                    if (!bo.isNullOrNil(this.Agh.AgJ)) {
                        str2 = this.Agh.AgJ;
                    }
                    ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", str2);
                    a(this.Agh.AgH, this.Agh.AgI, str2, this.Agh.AgK, gVar);
                    AppMethodBeat.o(49117);
                    return;
                }
            } else {
                ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
                ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", r.cPI().tDf);
                com.tencent.mm.plugin.report.service.h.pYm.k(965, 0, 1);
                b(this.Agh);
                AppMethodBeat.o(49117);
                return;
            }
        }
        if ((mVar instanceof n) && this.Agh.equals(mVar)) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(385, (f) this);
            if (((n) mVar).AgP) {
                if (this.Agh.tpw) {
                    ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                    a(i, i2, str, ((n) mVar).AgK, this.Agi);
                    AppMethodBeat.o(49117);
                    return;
                } else if (this.Agh.dOs()) {
                    ab.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                    b(this.Agh);
                    AppMethodBeat.o(49117);
                    return;
                } else {
                    ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", r.cPI().tDf);
                    a(i, i2, str2, ((n) mVar).AgK, this.Agi);
                }
            }
        }
        AppMethodBeat.o(49117);
    }
}
