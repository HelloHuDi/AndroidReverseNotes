package com.tencent.p177mm.plugin.remittance.model;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p1629b.p1630a.C44420a;
import com.tencent.p177mm.wallet_core.p649c.C44426i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.q */
public final class C13049q extends C44420a implements C44426i {
    public String pPf;

    public C13049q(long j, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        AppMethodBeat.m2504i(44760);
        HashMap hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("recv_username", str);
        hashMap.put("recv_nickname", str2);
        hashMap.put("qrcodeid", str5);
        try {
            if (!C5046bo.isNullOrNil(str3)) {
                hashMap.put("desc", URLEncoder.encode(str3, "UTF-8"));
            }
            if (!C5046bo.isNullOrNil(str4)) {
                hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, URLEncoder.encode(str4, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", e, "", new Object[0]);
        }
        hashMap.put(C8741b.CURRENCY, String.valueOf(i));
        hashMap.put("set_amount", String.valueOf(i2));
        mo70315M(hashMap);
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", str, str2, Long.valueOf(j), str3, str4, Integer.valueOf(i));
        AppMethodBeat.m2505o(44760);
    }

    /* renamed from: a */
    public final void mo6950a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44761);
        this.pPf = jSONObject.optString("payurl", "");
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", this.pPf);
        AppMethodBeat.m2505o(44761);
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
