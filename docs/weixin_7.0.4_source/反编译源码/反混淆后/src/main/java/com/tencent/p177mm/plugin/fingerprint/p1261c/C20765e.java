package com.tencent.p177mm.plugin.fingerprint.p1261c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fingerprint.c.e */
public final class C20765e extends C5749m implements C1918k {
    public String cBV = "";
    public String mrK = "";
    public String msr = "";

    public C20765e(String str) {
        AppMethodBeat.m2504i(41587);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
        }
        hashMap.put("encrypted_cert_info", URLEncoder.encode(str));
        hashMap.put("ver", "0x1.0");
        mo70323M(hashMap);
        AppMethodBeat.m2505o(41587);
    }

    public final int bgI() {
        return 118;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(41588);
        if (jSONObject != null) {
            this.mrK = jSONObject.optString("encrypted_device_info");
            this.cBV = jSONObject.optString("encrypted_rsa_sign");
            this.msr = jSONObject.optString("cert");
            if (TextUtils.isEmpty(this.mrK)) {
                C4990ab.m7412e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
            }
            if (TextUtils.isEmpty(this.cBV)) {
                C4990ab.m7412e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
            } else {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
            }
            if (TextUtils.isEmpty(this.msr)) {
                C4990ab.m7412e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
                AppMethodBeat.m2505o(41588);
                return;
            }
            C4990ab.m7416i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
        }
        AppMethodBeat.m2505o(41588);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1598;
    }
}
