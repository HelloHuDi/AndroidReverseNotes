package com.tencent.mm.plugin.collect.model;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r extends m {
    public boolean foa = false;
    public List<a> kCH = new ArrayList();
    public long kCc;
    public int kCd;
    public int kCe;
    private int limit;
    public int type;

    public r(int i, long j, String str, int i2) {
        AppMethodBeat.i(40994);
        this.limit = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("last_bill_id", str);
        hashMap.put("num", String.valueOf(i2));
        M(hashMap);
        AppMethodBeat.o(40994);
    }

    public final int bgI() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlist";
    }

    public final int ZU() {
        return 1963;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(40995);
        this.kCd = jSONObject.optInt("total_num");
        this.kCe = jSONObject.optInt("total_amt");
        this.kCc = jSONObject.optLong("from_timestamp", 0);
        this.type = jSONObject.optInt("type", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            ab.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.kBD = jSONObject2.optString("bill_id");
                    aVar.kBE = jSONObject2.optString("trans_id");
                    aVar.timestamp = jSONObject2.optLong(Param.TIMESTAMP, 0);
                    aVar.desc = jSONObject2.optString("desc");
                    aVar.cuY = jSONObject2.optInt("fee", 0);
                    this.kCH.add(aVar);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.kCH.size() < this.limit) {
            ab.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
            this.foa = true;
        }
        AppMethodBeat.o(40995);
    }
}
