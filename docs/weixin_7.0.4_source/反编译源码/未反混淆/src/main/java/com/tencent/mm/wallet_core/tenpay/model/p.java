package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public abstract class p extends m implements a {
    private boolean AgO = false;
    public boolean AgP = false;
    public boolean AgQ;
    private String aIm = "";
    private int errCode = 0;
    public boolean pOZ = false;
    private RetryPayInfo tfe;
    public boolean tpw = false;

    public final void U(boolean z, boolean z2) {
        super.U(z, z2);
    }

    public void a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.aIm = str;
    }

    public boolean dOi() {
        return false;
    }

    public void a(d dVar, JSONObject jSONObject) {
        boolean z = true;
        super.a(dVar, jSONObject);
        if (jSONObject == null || jSONObject.optInt("can_pay_retry") != 1) {
            z = false;
        }
        this.AgQ = z;
        this.tfe = new RetryPayInfo();
        this.tfe.aA(jSONObject);
    }

    public final void dOt() {
        reset();
        this.AgP = true;
        this.AgB = false;
    }

    public final boolean cfq() {
        return !this.pOZ;
    }
}
