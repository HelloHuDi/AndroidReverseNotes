package com.tencent.mm.plugin.remittance.model;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.b.a.a;
import com.tencent.mm.wallet_core.c.i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends a implements i {
    public String pPf;

    public q(long j, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        AppMethodBeat.i(44760);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("recv_username", str);
        hashMap.put("recv_nickname", str2);
        hashMap.put("qrcodeid", str5);
        try {
            if (!bo.isNullOrNil(str3)) {
                hashMap.put("desc", URLEncoder.encode(str3, "UTF-8"));
            }
            if (!bo.isNullOrNil(str4)) {
                hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, URLEncoder.encode(str4, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", e, "", new Object[0]);
        }
        hashMap.put(b.CURRENCY, String.valueOf(i));
        hashMap.put("set_amount", String.valueOf(i2));
        M(hashMap);
        ab.i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", str, str2, Long.valueOf(j), str3, str4, Integer.valueOf(i));
        AppMethodBeat.o(44760);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(44761);
        this.pPf = jSONObject.optString("payurl", "");
        ab.i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", this.pPf);
        AppMethodBeat.o(44761);
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferpay";
    }

    public final int getType() {
        return 1529;
    }

    public final int bgG() {
        return 1529;
    }
}
