package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.collect.model.p */
public final class C33861p extends C5749m {
    public String kBD;
    public long kCc;
    public int kCd;
    public int kCe;
    public int type;

    public C33861p(String str, int i, long j) {
        AppMethodBeat.m2504i(40989);
        this.kBD = str;
        HashMap hashMap = new HashMap();
        hashMap.put("bill_id", str);
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(40989);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1964;
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(40990);
        this.kCd = jSONObject.optInt("total_num", 0);
        this.kCe = jSONObject.optInt("total_amt", 0);
        this.type = jSONObject.optInt("type", 0);
        this.kCc = jSONObject.optLong("from_timestamp", 0);
        AppMethodBeat.m2505o(40990);
    }
}
