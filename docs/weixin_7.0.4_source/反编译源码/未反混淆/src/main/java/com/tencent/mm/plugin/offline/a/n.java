package com.tencent.mm.plugin.offline.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends m {
    public static String oYC = "";
    public static String oYj = "";
    private int kCl = -1;
    private String kCm = "";
    public int oXZ = -1;
    public String oYD = "";
    public String oYE = "";
    public String oYF = "";
    final Map<String, String> oYG = new HashMap();
    public String oYa = "";

    public n(String str, int i) {
        AppMethodBeat.i(43411);
        this.oYG.put("device_id", q.LM());
        this.oYG.put(Param.TIMESTAMP, str);
        this.oYG.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.LM());
        stringBuilder.append("&");
        stringBuilder.append(str);
        this.oYG.put("sign", ag.ck(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        g.RQ();
        this.oYG.put("code_ver", stringBuilder2.append(g.RP().Ry().get(a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, (Object) "")).toString());
        M(this.oYG);
        AppMethodBeat.o(43411);
    }

    public final int bgI() {
        return 49;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43412);
        if (jSONObject != null) {
            oYj = jSONObject.optString("limit_fee");
            oYC = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            k.bXg();
            k.aT(196629, oYj);
            k.bXg();
            k.aT(196641, oYC);
            k.bXg();
            k.aT(196645, optString);
            k.bXg();
            k.aT(196646, optString2);
            com.tencent.mm.plugin.offline.c.a.Ui(optString3);
            this.kCl = jSONObject.optInt("retcode");
            this.kCm = jSONObject.optString("retmsg");
            this.oXZ = jSONObject.optInt("wx_error_type");
            this.oYa = jSONObject.optString("wx_error_msg");
            this.oYD = jSONObject.optString("get_code_flag");
            this.oYE = jSONObject.optString("micropay_pause_flag");
            this.oYF = jSONObject.optString("micropay_pause_word");
        }
        AppMethodBeat.o(43412);
    }

    public final int ZU() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
