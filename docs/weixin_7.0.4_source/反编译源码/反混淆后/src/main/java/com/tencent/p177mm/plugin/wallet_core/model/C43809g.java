package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.g */
public final class C43809g {
    private static C43809g txQ;
    public String pbp;
    public int txR = 0;
    private JSONObject txS;

    public static C43809g cPl() {
        AppMethodBeat.m2504i(46726);
        if (txQ == null) {
            txQ = new C43809g();
        }
        C43809g c43809g = txQ;
        AppMethodBeat.m2505o(46726);
        return c43809g;
    }

    /* renamed from: at */
    public final void mo69492at(JSONObject jSONObject) {
        AppMethodBeat.m2504i(46727);
        this.txS = jSONObject;
        try {
            if (this.txS != null) {
                JSONObject optJSONObject = this.txS.optJSONObject("bind_newcard_switch");
                this.txR = optJSONObject.optInt("forbid_bind_card");
                this.pbp = optJSONObject.optString("forbid_word");
            } else {
                this.txR = 0;
                this.pbp = "";
            }
        } catch (Exception e) {
            this.txR = 0;
            this.pbp = "";
            C4990ab.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", e, "", new Object[0]);
        }
        C4990ab.m7417i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", this.txS, Integer.valueOf(this.txR), this.pbp);
        AppMethodBeat.m2505o(46727);
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(46728);
        if (this.txR != 1 || C5046bo.isNullOrNil(this.pbp)) {
            AppMethodBeat.m2505o(46728);
            return false;
        }
        AppMethodBeat.m2505o(46728);
        return true;
    }
}
