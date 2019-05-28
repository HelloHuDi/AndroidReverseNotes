package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class g {
    private static g txQ;
    public String pbp;
    public int txR = 0;
    private JSONObject txS;

    public static g cPl() {
        AppMethodBeat.i(46726);
        if (txQ == null) {
            txQ = new g();
        }
        g gVar = txQ;
        AppMethodBeat.o(46726);
        return gVar;
    }

    public final void at(JSONObject jSONObject) {
        AppMethodBeat.i(46727);
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
            ab.printErrStackTrace("MicroMsg.BindQueryComplexSwitchInfo", e, "", new Object[0]);
        }
        ab.i("MicroMsg.BindQueryComplexSwitchInfo", "feed result %s forbid_bind_card %s forbid_word %s", this.txS, Integer.valueOf(this.txR), this.pbp);
        AppMethodBeat.o(46727);
    }

    public final boolean aFF() {
        AppMethodBeat.i(46728);
        if (this.txR != 1 || bo.isNullOrNil(this.pbp)) {
            AppMethodBeat.o(46728);
            return false;
        }
        AppMethodBeat.o(46728);
        return true;
    }
}
