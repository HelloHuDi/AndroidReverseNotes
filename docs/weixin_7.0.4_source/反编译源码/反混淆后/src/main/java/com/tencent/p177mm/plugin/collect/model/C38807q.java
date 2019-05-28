package com.tencent.p177mm.plugin.collect.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.collect.model.q */
public final class C38807q extends C5749m {
    public boolean foa;
    public String hwA;
    public boolean isRetry;
    public int kCD;
    public int kCE;
    public int kCF;
    public int kCG;
    public List<C38805h> kCH;
    public long kCc;
    private int limit;

    public C38807q(int i, long j, int i2, int i3) {
        AppMethodBeat.m2504i(40991);
        this.foa = false;
        this.isRetry = false;
        this.kCH = new ArrayList();
        this.limit = i2;
        this.kCE = 0;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("num", String.valueOf(i2));
        hashMap.put("choose_flag", String.valueOf(i3));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(40991);
    }

    public C38807q(int i, long j, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(40992);
        this.foa = false;
        this.isRetry = false;
        this.kCH = new ArrayList();
        this.isRetry = true;
        this.limit = i3;
        this.kCE = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", String.valueOf(i2));
        hashMap.put("num", String.valueOf(i3));
        hashMap.put("choose_flag", String.valueOf(i4));
        hashMap.put("try_num", String.valueOf(i5));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(40992);
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1993;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(40993);
        C4990ab.m7411d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", jSONObject.toString());
        this.kCD = jSONObject.optInt("choose_flag", 0);
        this.kCc = jSONObject.optLong("from_timestamp", -1);
        this.kCF = jSONObject.optInt("finish_flag", 0);
        this.kCG = jSONObject.optInt("try_num", 0);
        this.hwA = jSONObject.optString("retmsg", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    C38805h c38805h = new C38805h();
                    c38805h.type = jSONObject2.optInt("type", 0);
                    c38805h.kCc = jSONObject2.optLong("from_timestamp", 0);
                    c38805h.kCd = jSONObject2.optInt("total_num", 0);
                    c38805h.kCe = jSONObject2.optInt("total_amt", 0);
                    this.kCH.add(c38805h);
                } catch (JSONException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.kCF == 1) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
            this.foa = true;
        }
        AppMethodBeat.m2505o(40993);
    }
}
