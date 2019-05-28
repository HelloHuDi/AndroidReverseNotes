package com.tencent.p177mm.wallet_core.p760d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.tenpay.model.C16087c;
import com.tencent.p177mm.wallet_core.tenpay.model.C16088d;
import com.tencent.p177mm.wallet_core.tenpay.model.C24161f;
import com.tencent.p177mm.wallet_core.tenpay.model.C30874e;
import com.tencent.p177mm.wallet_core.tenpay.model.C30875n;
import com.tencent.p177mm.wallet_core.tenpay.model.C36384g;
import com.tencent.p177mm.wallet_core.tenpay.model.C36885h;
import com.tencent.p177mm.wallet_core.tenpay.model.C36886i;
import com.tencent.p177mm.wallet_core.tenpay.model.C36887j;
import com.tencent.p177mm.wallet_core.tenpay.model.C36888k;
import com.tencent.p177mm.wallet_core.tenpay.model.C40943b;
import com.tencent.p177mm.wallet_core.tenpay.model.C5748l;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.d.a */
public final class C16082a implements C1202f {
    private C30875n Agh;
    private C36384g Agi;
    int Agj = 0;
    private C1202f Agk;

    public C16082a(C1202f c1202f) {
        this.Agk = c1202f;
    }

    /* renamed from: a */
    public final void mo28513a(C30875n c30875n) {
        AppMethodBeat.m2504i(49112);
        C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.Agj = 0;
        m24396b(c30875n);
        AppMethodBeat.m2505o(49112);
    }

    /* renamed from: b */
    private void m24396b(C30875n c30875n) {
        AppMethodBeat.m2504i(49113);
        this.Agh = c30875n;
        this.Agh.pOZ = true;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        int cQJ = C14241r.cPI().cQJ();
        this.Agj++;
        this.Agi = C16082a.m24397bb(this.Agh.dOr());
        this.Agi.AgA = true;
        this.Agi.mo57302K(this.Agj >= C14241r.cPI().mRetryCount, this.Agj);
        C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(cQJ), Integer.valueOf(r4));
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(this.Agi, cQJ);
        AppMethodBeat.m2505o(49113);
    }

    /* renamed from: bb */
    private static C36384g m24397bb(Map<String, String> map) {
        AppMethodBeat.m2504i(49114);
        String str = (String) map.get("req_key");
        C36384g c36384g;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            c36384g = new C36384g(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        }
        C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", str);
        C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
        if (str.startsWith("sns_aa_")) {
            c36384g = new C40943b(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("sns_tf_")) {
            c36384g = new C36888k(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("sns_ff_")) {
            c36384g = new C16088d(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("ts_")) {
            c36384g = new C30874e(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("sns_")) {
            c36384g = new C36886i(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("offline_")) {
            c36384g = new C24161f(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("up_")) {
            c36384g = new C5748l(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("seb_ff_")) {
            c36384g = new C36885h(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("tax_")) {
            c36384g = new C36887j(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else if (str.startsWith("dc_")) {
            c36384g = new C16087c(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        } else {
            c36384g = new C36384g(map);
            AppMethodBeat.m2505o(49114);
            return c36384g;
        }
    }

    public final void destory() {
        AppMethodBeat.m2504i(49115);
        this.Agk = null;
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
        AppMethodBeat.m2505o(49115);
    }

    /* renamed from: a */
    private void m24395a(int i, int i2, String str, JSONObject jSONObject, C36384g c36384g) {
        AppMethodBeat.m2504i(49116);
        C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.Agh != null && jSONObject != null && i == 0 && i2 == 0) {
            C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.Agh.mo9383a(i2, str, jSONObject);
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
            if (this.Agj == 1) {
                C7060h.pYm.mo15419k(965, 4, 1);
            } else if (this.Agj == 2) {
                C7060h.pYm.mo15419k(965, 5, 1);
            } else if (this.Agj == 3) {
                C7060h.pYm.mo15419k(965, 6, 1);
            }
        } else if (this.Agk != null) {
            C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.Agk.onSceneEnd(i, i2, str, this.Agh);
            if (this.Agj == 1) {
                C7060h.pYm.mo15419k(965, 7, 1);
            } else if (this.Agj == 2) {
                C7060h.pYm.mo15419k(965, 8, 1);
            } else if (this.Agj == 3) {
                C7060h.pYm.mo15419k(965, 9, 1);
            }
            if (!c36384g.AfM) {
                if (this.Agj == 1) {
                    C7060h.pYm.mo15419k(965, 15, 1);
                } else if (this.Agj == 2) {
                    C7060h.pYm.mo15419k(965, 16, 1);
                } else if (this.Agj == 3) {
                    C7060h.pYm.mo15419k(965, 17, 1);
                }
            }
        }
        C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.Agj = 0;
        AppMethodBeat.m2505o(49116);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(49117);
        C4990ab.m7411d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        String str2;
        if ((c1207m instanceof C36384g) && this.Agi.equals(c1207m)) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            C36384g c36384g = (C36384g) c1207m;
            C4990ab.m7411d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", Integer.valueOf(i), Integer.valueOf(i2), str, c36384g, Integer.valueOf(c36384g.Agz));
            if (c36384g.Agz == 1) {
                C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
                m24395a(i, i2, str, c36384g.dOp(), c36384g);
                AppMethodBeat.m2505o(49117);
                return;
            } else if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
                if (c36384g.Agz == 2) {
                    m24395a(this.Agh.AgH, this.Agh.AgI, this.Agh.AgJ, this.Agh.AgK, c36384g);
                    AppMethodBeat.m2505o(49117);
                    return;
                }
                m24395a(i, i2, str, c36384g.dOp(), c36384g);
                AppMethodBeat.m2505o(49117);
                return;
            } else if (c36384g.AfM || this.Agj >= C14241r.cPI().mRetryCount) {
                int i3;
                C30875n c30875n = this.Agh;
                int i4 = C14241r.cPI().mRetryCount;
                C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(c30875n.dOs()), Integer.valueOf(this.Agj));
                if (this.Agj < i4) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                    m24396b(this.Agh);
                    AppMethodBeat.m2505o(49117);
                    return;
                }
                C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", Integer.valueOf(c36384g.Agz));
                if (c36384g.Agz == 1) {
                    m24395a(i, i2, str, c36384g.dOp(), c36384g);
                    AppMethodBeat.m2505o(49117);
                    return;
                } else if (c36384g.Agz == 2) {
                    m24395a(this.Agh.AgH, this.Agh.AgI, this.Agh.AgJ, this.Agh.AgK, c36384g);
                    AppMethodBeat.m2505o(49117);
                    return;
                } else {
                    str2 = C14241r.cPI().tDf;
                    if (!C5046bo.isNullOrNil(this.Agh.AgJ)) {
                        str2 = this.Agh.AgJ;
                    }
                    C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", str2);
                    m24395a(this.Agh.AgH, this.Agh.AgI, str2, this.Agh.AgK, c36384g);
                    AppMethodBeat.m2505o(49117);
                    return;
                }
            } else {
                C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
                C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", C14241r.cPI().tDf);
                C7060h.pYm.mo15419k(965, 0, 1);
                m24396b(this.Agh);
                AppMethodBeat.m2505o(49117);
                return;
            }
        }
        if ((c1207m instanceof C30875n) && this.Agh.equals(c1207m)) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(385, (C1202f) this);
            if (((C30875n) c1207m).AgP) {
                if (this.Agh.tpw) {
                    C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                    m24395a(i, i2, str, ((C30875n) c1207m).AgK, this.Agi);
                    AppMethodBeat.m2505o(49117);
                    return;
                } else if (this.Agh.dOs()) {
                    C4990ab.m7416i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                    m24396b(this.Agh);
                    AppMethodBeat.m2505o(49117);
                    return;
                } else {
                    C4990ab.m7417i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", C14241r.cPI().tDf);
                    m24395a(i, i2, str2, ((C30875n) c1207m).AgK, this.Agi);
                }
            }
        }
        AppMethodBeat.m2505o(49117);
    }
}
