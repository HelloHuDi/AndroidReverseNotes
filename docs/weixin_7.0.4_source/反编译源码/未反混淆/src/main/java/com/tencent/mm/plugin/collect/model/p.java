package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends m {
    public String kBD;
    public long kCc;
    public int kCd;
    public int kCe;
    public int type;

    public p(String str, int i, long j) {
        AppMethodBeat.i(40989);
        this.kBD = str;
        HashMap hashMap = new HashMap();
        hashMap.put("bill_id", str);
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        M(hashMap);
        AppMethodBeat.o(40989);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
    }

    public final int ZU() {
        return 1964;
    }

    public final int bgI() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(40990);
        this.kCd = jSONObject.optInt("total_num", 0);
        this.kCe = jSONObject.optInt("total_amt", 0);
        this.type = jSONObject.optInt("type", 0);
        this.kCc = jSONObject.optLong("from_timestamp", 0);
        AppMethodBeat.o(40990);
    }
}
