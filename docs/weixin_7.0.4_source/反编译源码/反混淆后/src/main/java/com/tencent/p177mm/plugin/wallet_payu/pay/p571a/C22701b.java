package com.tencent.p177mm.plugin.wallet_payu.pay.p571a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.a.b */
public final class C22701b extends C36383a {
    public String czZ;
    public String kBE;
    public String pin;
    public String tDT;
    public String tSB;
    public String tSs;
    public String tSy;
    public String tSz;
    public double tTQ;
    public String tTR;
    public double tTS;
    public String tTT;
    public boolean tTU;
    public boolean tTV;
    public String tTW;
    public String tTX;
    public String tTY;
    public int timestamp;
    public String tlg;

    public C22701b(String str, double d, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(48440);
        this.czZ = str;
        this.tTQ = d;
        this.tTR = str2;
        this.tDT = str3;
        this.tlg = str4;
        this.tSs = str5;
        this.pin = str6;
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", String.valueOf(str3));
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", String.valueOf(str5));
        }
        hashMap.put("pin", String.valueOf(str6));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48440);
    }

    public final int cOX() {
        return 9;
    }

    public final boolean isSuccess() {
        AppMethodBeat.m2504i(48441);
        boolean equals = this.tTW.equals("1");
        AppMethodBeat.m2505o(48441);
        return equals;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48442);
        if (jSONObject != null) {
            this.kBE = jSONObject.optString("trans_id");
            this.tTS = jSONObject.optDouble("total_fee") / 100.0d;
            this.tTT = jSONObject.optString("fee_type");
            this.tTU = jSONObject.optBoolean("redirect");
            this.tSy = jSONObject.optString("gateway_reference");
            this.tSz = jSONObject.optString("gateway_code");
            this.tTW = jSONObject.optString("pay_status");
            this.timestamp = jSONObject.optInt(Param.TIMESTAMP);
            this.tTX = jSONObject.optString("pay_status_name");
            this.tTY = jSONObject.optString("bank_type");
            this.tTV = jSONObject.optBoolean("is_force_adjust");
            this.tSB = jSONObject.optString("force_adjust_code");
        }
        AppMethodBeat.m2505o(48442);
    }
}
