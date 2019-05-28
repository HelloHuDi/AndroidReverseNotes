package com.tencent.mm.plugin.offline.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m {
    public String oXV;
    public int oXW;
    public String oXX;

    public d() {
        AppMethodBeat.i(43388);
        HashMap hashMap = new HashMap();
        g.RQ();
        Object obj = g.RP().Ry().get(a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put(Param.TIMESTAMP, System.currentTimeMillis());
        M(hashMap);
        AppMethodBeat.o(43388);
    }

    public final int bgI() {
        return 1981;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43389);
        if (i == 0) {
            h.pYm.a(135, 56, 1, true);
            this.oXV = jSONObject.optString("appmsg");
            this.oXW = jSONObject.optInt("poll_time") * 1000;
            this.oXX = jSONObject.optString("ack_key");
            if (this.oXW > 0) {
                g.RQ();
                g.RP().Ry().set(a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(this.oXW));
            }
            g.RQ();
            g.RP().Ry().set(a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, this.oXX);
            AppMethodBeat.o(43389);
            return;
        }
        h.pYm.a(135, 57, 1, true);
        AppMethodBeat.o(43389);
    }

    public final boolean bXl() {
        return false;
    }
}
