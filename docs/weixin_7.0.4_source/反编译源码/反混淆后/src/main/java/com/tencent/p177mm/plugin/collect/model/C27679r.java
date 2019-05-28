package com.tencent.p177mm.plugin.collect.model;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.collect.model.r */
public final class C27679r extends C5749m {
    public boolean foa = false;
    public List<C20263a> kCH = new ArrayList();
    public long kCc;
    public int kCd;
    public int kCe;
    private int limit;
    public int type;

    public C27679r(int i, long j, String str, int i2) {
        AppMethodBeat.m2504i(40994);
        this.limit = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("last_bill_id", str);
        hashMap.put("num", String.valueOf(i2));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(40994);
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlist";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1963;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(40995);
        this.kCd = jSONObject.optInt("total_num");
        this.kCe = jSONObject.optInt("total_amt");
        this.kCc = jSONObject.optLong("from_timestamp", 0);
        this.type = jSONObject.optInt("type", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    C20263a c20263a = new C20263a();
                    c20263a.kBD = jSONObject2.optString("bill_id");
                    c20263a.kBE = jSONObject2.optString("trans_id");
                    c20263a.timestamp = jSONObject2.optLong(Param.TIMESTAMP, 0);
                    c20263a.desc = jSONObject2.optString("desc");
                    c20263a.cuY = jSONObject2.optInt("fee", 0);
                    this.kCH.add(c20263a);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.kCH.size() < this.limit) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
            this.foa = true;
        }
        AppMethodBeat.m2505o(40995);
    }
}
