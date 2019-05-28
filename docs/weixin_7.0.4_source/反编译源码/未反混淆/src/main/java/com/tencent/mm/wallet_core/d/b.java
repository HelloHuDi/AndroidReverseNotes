package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.HashMap;
import org.json.JSONObject;

public final class b implements f {
    static RetryPayInfo tfe;
    private n Agh;
    private int Agj = 0;
    private f Agk;

    private boolean dOi() {
        AppMethodBeat.i(49118);
        if (this.Agj >= dOj()) {
            AppMethodBeat.o(49118);
            return false;
        }
        AppMethodBeat.o(49118);
        return true;
    }

    private static int dOj() {
        AppMethodBeat.i(49119);
        if (tfe == null || !tfe.bVy()) {
            AppMethodBeat.o(49119);
            return 0;
        }
        int i = tfe.Agv;
        AppMethodBeat.o(49119);
        return i;
    }

    public b(f fVar) {
        this.Agk = fVar;
    }

    public final void destory() {
        AppMethodBeat.i(49121);
        this.Agk = null;
        g.RQ();
        g.RO().eJo.b(385, (f) this);
        AppMethodBeat.o(49121);
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(49122);
        ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.Agh != null && jSONObject != null && i == 0 && i2 == 0) {
            ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
            this.Agh.a(i2, str, jSONObject);
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
        } else if (this.Agk != null) {
            ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
        }
        ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
        this.Agj = 0;
        AppMethodBeat.o(49122);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(49123);
        ab.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (mVar instanceof n) {
            if (mVar instanceof ITenpaySave) {
                RetryPayInfo cMC = ((ITenpaySave) mVar).cMC();
                if (cMC.bVy()) {
                    tfe = cMC;
                }
            }
            g.RQ();
            g.RO().eJo.b(385, (f) this);
            if (((n) mVar).AgP) {
                if (this.Agh.tpw) {
                    ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
                    a(i, i2, str, ((n) mVar).AgK);
                    AppMethodBeat.o(49123);
                    return;
                } else if (this.Agh.AgQ && dOi()) {
                    ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", Boolean.valueOf(this.Agh.AgQ), Boolean.valueOf(dOi()));
                    if (!c(this.Agh)) {
                        c(i, i2, mVar);
                        AppMethodBeat.o(49123);
                        return;
                    }
                } else if (((n) mVar).AfM) {
                    ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
                    if (!c(this.Agh)) {
                        c(i, i2, mVar);
                        AppMethodBeat.o(49123);
                        return;
                    }
                } else {
                    ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", tfe.Agw);
                    a(i, i2, r0, ((n) mVar).AgK);
                }
            }
        }
        AppMethodBeat.o(49123);
    }

    private void c(int i, int i2, m mVar) {
        AppMethodBeat.i(49124);
        a(i, i2, tfe.Agw, ((n) mVar).AgK);
        AppMethodBeat.o(49124);
    }

    public final boolean c(n nVar) {
        int i;
        AppMethodBeat.i(49120);
        if (tfe == null || !tfe.bVy()) {
            i = 0;
        } else {
            i = tfe.Agu;
        }
        int dOj = dOj();
        this.Agj++;
        if (this.Agj > dOj) {
            AppMethodBeat.o(49120);
            return false;
        }
        int i2;
        this.Agh = nVar;
        this.Agh.pOZ = true;
        g.RQ();
        g.RO().eJo.a(385, (f) this);
        this.Agh.dOt();
        int i3 = this.Agj;
        if (this.Agj >= dOj) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("retry_count", String.valueOf(i3));
        hashMap.put("is_last_retry", String.valueOf(i2));
        nVar.aZ(hashMap);
        ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(i), Integer.valueOf(dOj));
        g.RQ();
        g.RO().eJo.a((m) nVar, i * 1000);
        AppMethodBeat.o(49120);
        return true;
    }
}
