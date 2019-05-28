package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai extends ak {
    public q nYQ;
    public List<String> nYR;
    public String nYS;
    public String nYT = null;
    public String nYz;

    public ai(int i, int i2, int i3, String str, String str2, String str3) {
        AppMethodBeat.i(42405);
        HashMap hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put("type", String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        M(hashMap);
        AppMethodBeat.o(42405);
    }

    public final int getType() {
        return 1514;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final boolean bLF() {
        if (this.nYQ == null || this.nYQ.nXa == 1) {
            return true;
        }
        return false;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42406);
        try {
            int i2;
            q qVar = new q();
            qVar.nXH = jSONObject.optInt("recTotalNum");
            qVar.nXI = jSONObject.optLong("recTotalAmount");
            qVar.nXJ = jSONObject.optInt("sendTotalNum");
            qVar.nXK = jSONObject.optLong("sendTotalAmount");
            qVar.nXa = jSONObject.optInt("isContinue");
            qVar.mLA = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    r rVar = new r();
                    rVar.nXL = jSONObject2.optString("sendName");
                    rVar.nWR = jSONObject2.optString("sendHeadImg");
                    rVar.nXM = jSONObject2.optLong("receiveAmount");
                    rVar.nXN = jSONObject2.optString("receiveTime");
                    rVar.cRT = jSONObject2.optInt("hbType");
                    rVar.nXO = jSONObject2.optString("sendTitle");
                    rVar.nXP = jSONObject2.optString("sendTime");
                    rVar.nWW = jSONObject2.optLong("totalAmount");
                    rVar.nXQ = jSONObject2.optLong("totalNum");
                    rVar.nWU = jSONObject2.optLong("recNum");
                    rVar.status = jSONObject2.optInt("status");
                    rVar.nXR = jSONObject2.optInt("thxCount");
                    rVar.nWX = jSONObject2.optString("receiveId");
                    rVar.nSX = jSONObject2.optString("sendId");
                    rVar.nXi = jSONObject2.optInt("hbKind");
                    linkedList.add(rVar);
                }
            }
            qVar.nXj = linkedList;
            this.nYQ = qVar;
            this.nYR = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!bo.isNullOrNil(optString)) {
                String[] split = optString.split("\\|");
                if (split != null) {
                    for (Object add : split) {
                        this.nYR.add(add);
                    }
                }
            }
            this.nYS = jSONObject.optString("recordYear");
            this.nYT = jSONObject.optString("clickedUrl");
            this.nYz = jSONObject.optString("processContent");
            AppMethodBeat.o(42406);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
            AppMethodBeat.o(42406);
        }
    }
}
