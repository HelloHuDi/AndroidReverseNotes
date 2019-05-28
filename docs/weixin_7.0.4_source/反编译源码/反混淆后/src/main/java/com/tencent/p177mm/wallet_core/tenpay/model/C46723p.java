package com.tencent.p177mm.wallet_core.tenpay.model;

import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.p */
public abstract class C46723p extends C5749m implements C40942a {
    private boolean AgO = false;
    public boolean AgP = false;
    public boolean AgQ;
    private String aIm = "";
    private int errCode = 0;
    public boolean pOZ = false;
    private RetryPayInfo tfe;
    public boolean tpw = false;

    /* renamed from: U */
    public final void mo11719U(boolean z, boolean z2) {
        super.mo11719U(z, z2);
    }

    /* renamed from: a */
    public void mo9383a(int i, String str, JSONObject jSONObject) {
        this.errCode = i;
        this.aIm = str;
    }

    public boolean dOi() {
        return false;
    }

    /* renamed from: a */
    public void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        boolean z = true;
        super.mo26460a(c24144d, jSONObject);
        if (jSONObject == null || jSONObject.optInt("can_pay_retry") != 1) {
            z = false;
        }
        this.AgQ = z;
        this.tfe = new RetryPayInfo();
        this.tfe.mo39956aA(jSONObject);
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
