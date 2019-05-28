package com.tencent.mm.plugin.collect.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class q extends m {
    public boolean foa;
    public String hwA;
    public boolean isRetry;
    public int kCD;
    public int kCE;
    public int kCF;
    public int kCG;
    public List<h> kCH;
    public long kCc;
    private int limit;

    public q(int i, long j, int i2, int i3) {
        AppMethodBeat.i(40991);
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
        M(hashMap);
        AppMethodBeat.o(40991);
    }

    public q(int i, long j, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(40992);
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
        M(hashMap);
        AppMethodBeat.o(40992);
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
    }

    public final int ZU() {
        return 1993;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(40993);
        ab.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", jSONObject.toString());
        this.kCD = jSONObject.optInt("choose_flag", 0);
        this.kCc = jSONObject.optLong("from_timestamp", -1);
        this.kCF = jSONObject.optInt("finish_flag", 0);
        this.kCG = jSONObject.optInt("try_num", 0);
        this.hwA = jSONObject.optString("retmsg", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.type = jSONObject2.optInt("type", 0);
                    hVar.kCc = jSONObject2.optLong("from_timestamp", 0);
                    hVar.kCd = jSONObject2.optInt("total_num", 0);
                    hVar.kCe = jSONObject2.optInt("total_amt", 0);
                    this.kCH.add(hVar);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.kCF == 1) {
            ab.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
            this.foa = true;
        }
        AppMethodBeat.o(40993);
    }
}
