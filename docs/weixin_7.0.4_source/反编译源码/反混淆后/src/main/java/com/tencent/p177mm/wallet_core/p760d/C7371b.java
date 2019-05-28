package com.tencent.p177mm.wallet_core.p760d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.d.b */
public final class C7371b implements C1202f {
    static RetryPayInfo tfe;
    private C30875n Agh;
    private int Agj = 0;
    private C1202f Agk;

    private boolean dOi() {
        AppMethodBeat.m2504i(49118);
        if (this.Agj >= C7371b.dOj()) {
            AppMethodBeat.m2505o(49118);
            return false;
        }
        AppMethodBeat.m2505o(49118);
        return true;
    }

    private static int dOj() {
        AppMethodBeat.m2504i(49119);
        if (tfe == null || !tfe.bVy()) {
            AppMethodBeat.m2505o(49119);
            return 0;
        }
        int i = tfe.Agv;
        AppMethodBeat.m2505o(49119);
        return i;
    }

    public C7371b(C1202f c1202f) {
        this.Agk = c1202f;
    }

    public final void destory() {
        AppMethodBeat.m2504i(49121);
        this.Agk = null;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(49121);
    }

    /* renamed from: a */
    private void m12585a(int i, int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(49122);
        C4990ab.m7416i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.Agh != null && jSONObject != null && i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
            this.Agh.mo9383a(i2, str, jSONObject);
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
        } else if (this.Agk != null) {
            C4990ab.m7416i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
        }
        C4990ab.m7416i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
        this.Agj = 0;
        AppMethodBeat.m2505o(49122);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(49123);
        C4990ab.m7411d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (c1207m instanceof C30875n) {
            if (c1207m instanceof ITenpaySave) {
                RetryPayInfo cMC = ((ITenpaySave) c1207m).cMC();
                if (cMC.bVy()) {
                    tfe = cMC;
                }
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            if (((C30875n) c1207m).AgP) {
                if (this.Agh.tpw) {
                    C4990ab.m7416i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
                    m12585a(i, i2, str, ((C30875n) c1207m).AgK);
                    AppMethodBeat.m2505o(49123);
                    return;
                } else if (this.Agh.AgQ && dOi()) {
                    C4990ab.m7417i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", Boolean.valueOf(this.Agh.AgQ), Boolean.valueOf(dOi()));
                    if (!mo15901c(this.Agh)) {
                        m12586c(i, i2, c1207m);
                        AppMethodBeat.m2505o(49123);
                        return;
                    }
                } else if (((C30875n) c1207m).AfM) {
                    C4990ab.m7416i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
                    if (!mo15901c(this.Agh)) {
                        m12586c(i, i2, c1207m);
                        AppMethodBeat.m2505o(49123);
                        return;
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", tfe.Agw);
                    m12585a(i, i2, r0, ((C30875n) c1207m).AgK);
                }
            }
        }
        AppMethodBeat.m2505o(49123);
    }

    /* renamed from: c */
    private void m12586c(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(49124);
        m12585a(i, i2, tfe.Agw, ((C30875n) c1207m).AgK);
        AppMethodBeat.m2505o(49124);
    }

    /* renamed from: c */
    public final boolean mo15901c(C30875n c30875n) {
        int i;
        AppMethodBeat.m2504i(49120);
        if (tfe == null || !tfe.bVy()) {
            i = 0;
        } else {
            i = tfe.Agu;
        }
        int dOj = C7371b.dOj();
        this.Agj++;
        if (this.Agj > dOj) {
            AppMethodBeat.m2505o(49120);
            return false;
        }
        int i2;
        this.Agh = c30875n;
        this.Agh.pOZ = true;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
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
        c30875n.mo70326aZ(hashMap);
        C4990ab.m7417i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(i), Integer.valueOf(dOj));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a((C1207m) c30875n, i * 1000);
        AppMethodBeat.m2505o(49120);
        return true;
    }
}
