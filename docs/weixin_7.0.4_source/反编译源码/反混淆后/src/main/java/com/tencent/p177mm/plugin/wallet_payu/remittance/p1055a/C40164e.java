package com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1512e.p1513a.C36383a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_payu.remittance.a.e */
public final class C40164e extends C36383a {
    public int bJt;
    public int czE;
    public double kCJ;
    private String pQe;
    public int pQf;
    public String pcl;
    public int status;
    public int tUy;
    public int tUz;

    public C40164e(String str, String str2, int i) {
        this(str, str2, i, 0);
    }

    public C40164e(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(48533);
        this.pQe = null;
        this.pQe = str;
        this.czE = 1;
        this.bJt = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48533);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48534);
        C4990ab.m7410d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48534);
            return;
        }
        this.pQf = jSONObject.optInt("pay_time");
        this.kCJ = jSONObject.optDouble("total_fee") / 100.0d;
        this.pcl = jSONObject.optString("fee_type");
        this.status = jSONObject.optInt("pay_status");
        this.tUy = jSONObject.optInt("refund_time");
        this.tUz = jSONObject.optInt("receive_time");
        AppMethodBeat.m2505o(48534);
    }

    public final int cOX() {
        return 25;
    }
}
