package com.tencent.mm.plugin.offline.a;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends m {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public b(boolean z) {
        AppMethodBeat.i(43384);
        HashMap hashMap = new HashMap();
        hashMap.put("ack_key", a.bYA());
        hashMap.put("req_key", a.bYB());
        hashMap.put("paymsg_type", a.bYC());
        hashMap.put("transactionid", a.bYD());
        hashMap.put(TencentLocation.NETWORK_PROVIDER, a.getNetworkType(ah.getContext()));
        hashMap.put("processed", k.oXK ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_pos_enabled", a.bYE() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("channel", z ? "pull" : "push");
        hashMap.put(Param.TIMESTAMP, (System.currentTimeMillis() / 1000));
        M(hashMap);
        AppMethodBeat.o(43384);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43385);
        if (i == 0) {
            ab.v(this.TAG, "response ok");
            h.pYm.a(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                g.RQ();
                g.RP().Ry().set(ac.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(optInt));
            }
            AppMethodBeat.o(43385);
            return;
        }
        ab.v(this.TAG, "response fail");
        h.pYm.a(135, 69, 1, true);
        AppMethodBeat.o(43385);
    }

    public final int bgI() {
        return 1230;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}
