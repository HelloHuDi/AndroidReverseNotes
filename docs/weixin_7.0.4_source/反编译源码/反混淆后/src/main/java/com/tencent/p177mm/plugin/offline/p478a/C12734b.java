package com.tencent.p177mm.plugin.offline.p478a;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.b */
public final class C12734b extends C5749m {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public C12734b(boolean z) {
        AppMethodBeat.m2504i(43384);
        HashMap hashMap = new HashMap();
        hashMap.put("ack_key", C28630a.bYA());
        hashMap.put("req_key", C28630a.bYB());
        hashMap.put("paymsg_type", C28630a.bYC());
        hashMap.put("transactionid", C28630a.bYD());
        hashMap.put(TencentLocation.NETWORK_PROVIDER, C28630a.getNetworkType(C4996ah.getContext()));
        hashMap.put("processed", C7007k.oXK ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_pos_enabled", C28630a.bYE() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("channel", z ? "pull" : "push");
        hashMap.put(Param.TIMESTAMP, (System.currentTimeMillis() / 1000));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43384);
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43385);
        if (i == 0) {
            C4990ab.m7418v(this.TAG, "response ok");
            C7060h.pYm.mo8378a(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(C5127a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(optInt));
            }
            AppMethodBeat.m2505o(43385);
            return;
        }
        C4990ab.m7418v(this.TAG, "response fail");
        C7060h.pYm.mo8378a(135, 69, 1, true);
        AppMethodBeat.m2505o(43385);
    }

    public final int bgI() {
        return 1230;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}
