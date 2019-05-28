package com.tencent.p177mm.plugin.offline.p478a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.d */
public final class C12735d extends C5749m {
    public String oXV;
    public int oXW;
    public String oXX;

    public C12735d() {
        AppMethodBeat.m2504i(43388);
        HashMap hashMap = new HashMap();
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put(Param.TIMESTAMP, System.currentTimeMillis());
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43388);
    }

    public final int bgI() {
        return 1981;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43389);
        if (i == 0) {
            C7060h.pYm.mo8378a(135, 56, 1, true);
            this.oXV = jSONObject.optString("appmsg");
            this.oXW = jSONObject.optInt("poll_time") * 1000;
            this.oXX = jSONObject.optString("ack_key");
            if (this.oXW > 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(this.oXW));
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, this.oXX);
            AppMethodBeat.m2505o(43389);
            return;
        }
        C7060h.pYm.mo8378a(135, 57, 1, true);
        AppMethodBeat.m2505o(43389);
    }

    public final boolean bXl() {
        return false;
    }
}
