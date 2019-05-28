package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a {
    public int bJt;
    public int czE;
    public double kCJ;
    private String pQe;
    public int pQf;
    public String pcl;
    public int status;
    public int tUy;
    public int tUz;

    public e(String str, String str2, int i) {
        this(str, str2, i, 0);
    }

    public e(String str, String str2, int i, int i2) {
        AppMethodBeat.i(48533);
        this.pQe = null;
        this.pQe = str;
        this.czE = 1;
        this.bJt = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("invalid_time", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(48533);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48534);
        ab.d("MicroMsg.NetScenePayURemittanceQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48534);
            return;
        }
        this.pQf = jSONObject.optInt("pay_time");
        this.kCJ = jSONObject.optDouble("total_fee") / 100.0d;
        this.pcl = jSONObject.optString("fee_type");
        this.status = jSONObject.optInt("pay_status");
        this.tUy = jSONObject.optInt("refund_time");
        this.tUz = jSONObject.optInt("receive_time");
        AppMethodBeat.o(48534);
    }

    public final int cOX() {
        return 25;
    }
}
