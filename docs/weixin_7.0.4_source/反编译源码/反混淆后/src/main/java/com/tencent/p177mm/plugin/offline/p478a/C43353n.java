package com.tencent.p177mm.plugin.offline.p478a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.n */
public final class C43353n extends C5749m {
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

    public C43353n(String str, int i) {
        AppMethodBeat.m2504i(43411);
        this.oYG.put("device_id", C1427q.m3028LM());
        this.oYG.put(Param.TIMESTAMP, str);
        this.oYG.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C1427q.m3028LM());
        stringBuilder.append("&");
        stringBuilder.append(str);
        this.oYG.put("sign", C4995ag.m7428ck(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        C1720g.m3537RQ();
        this.oYG.put("code_ver", stringBuilder2.append(C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, (Object) "")).toString());
        mo70323M(this.oYG);
        AppMethodBeat.m2505o(43411);
    }

    public final int bgI() {
        return 49;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43412);
        if (jSONObject != null) {
            oYj = jSONObject.optString("limit_fee");
            oYC = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            C7007k.bXg();
            C7007k.m11711aT(196629, oYj);
            C7007k.bXg();
            C7007k.m11711aT(196641, oYC);
            C7007k.bXg();
            C7007k.m11711aT(196645, optString);
            C7007k.bXg();
            C7007k.m11711aT(196646, optString2);
            C28630a.m45501Ui(optString3);
            this.kCl = jSONObject.optInt("retcode");
            this.kCm = jSONObject.optString("retmsg");
            this.oXZ = jSONObject.optInt("wx_error_type");
            this.oYa = jSONObject.optString("wx_error_msg");
            this.oYD = jSONObject.optString("get_code_flag");
            this.oYE = jSONObject.optString("micropay_pause_flag");
            this.oYF = jSONObject.optString("micropay_pause_word");
        }
        AppMethodBeat.m2505o(43412);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
