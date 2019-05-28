package com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.a.a */
public final class C14370a extends C36383a {
    public String cMr;
    public String cuZ;
    public String czZ;
    public double pTN;
    public String pin;
    public int tSw;
    public int tUv;
    public double tUw;
    public String tUx;
    public String tlg;

    public C14370a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(48525);
        this.czZ = str;
        this.pin = str2;
        this.pTN = d;
        this.cuZ = str3;
        this.tUv = i == 2 ? 0 : i;
        this.cMr = str4;
        this.tlg = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48525);
    }

    public final int cOX() {
        return 14;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48526);
        this.tSw = jSONObject.optInt("response_result");
        this.tUw = C5046bo.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.tUx = jSONObject.optString("fee_type");
        AppMethodBeat.m2505o(48526);
    }
}
