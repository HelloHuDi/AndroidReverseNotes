package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ai */
public final class C3383ai extends C34442ak {
    public C21205q nYQ;
    public List<String> nYR;
    public String nYS;
    public String nYT = null;
    public String nYz;

    public C3383ai(int i, int i2, int i3, String str, String str2, String str3) {
        AppMethodBeat.m2504i(42405);
        HashMap hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put("type", String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42405);
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

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42406);
        try {
            int i2;
            C21205q c21205q = new C21205q();
            c21205q.nXH = jSONObject.optInt("recTotalNum");
            c21205q.nXI = jSONObject.optLong("recTotalAmount");
            c21205q.nXJ = jSONObject.optInt("sendTotalNum");
            c21205q.nXK = jSONObject.optLong("sendTotalAmount");
            c21205q.nXa = jSONObject.optInt("isContinue");
            c21205q.mLA = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    C21206r c21206r = new C21206r();
                    c21206r.nXL = jSONObject2.optString("sendName");
                    c21206r.nWR = jSONObject2.optString("sendHeadImg");
                    c21206r.nXM = jSONObject2.optLong("receiveAmount");
                    c21206r.nXN = jSONObject2.optString("receiveTime");
                    c21206r.cRT = jSONObject2.optInt("hbType");
                    c21206r.nXO = jSONObject2.optString("sendTitle");
                    c21206r.nXP = jSONObject2.optString("sendTime");
                    c21206r.nWW = jSONObject2.optLong("totalAmount");
                    c21206r.nXQ = jSONObject2.optLong("totalNum");
                    c21206r.nWU = jSONObject2.optLong("recNum");
                    c21206r.status = jSONObject2.optInt("status");
                    c21206r.nXR = jSONObject2.optInt("thxCount");
                    c21206r.nWX = jSONObject2.optString("receiveId");
                    c21206r.nSX = jSONObject2.optString("sendId");
                    c21206r.nXi = jSONObject2.optInt("hbKind");
                    linkedList.add(c21206r);
                }
            }
            c21205q.nXj = linkedList;
            this.nYQ = c21205q;
            this.nYR = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!C5046bo.isNullOrNil(optString)) {
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
            AppMethodBeat.m2505o(42406);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
            AppMethodBeat.m2505o(42406);
        }
    }
}
