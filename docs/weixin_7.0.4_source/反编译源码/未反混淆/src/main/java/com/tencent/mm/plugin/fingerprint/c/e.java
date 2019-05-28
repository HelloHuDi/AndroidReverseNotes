package com.tencent.mm.plugin.fingerprint.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m implements k {
    public String cBV = "";
    public String mrK = "";
    public String msr = "";

    public e(String str) {
        AppMethodBeat.i(41587);
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is empty");
        } else {
            ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_cert_info is not empty");
        }
        hashMap.put("encrypted_cert_info", URLEncoder.encode(str));
        hashMap.put("ver", "0x1.0");
        M(hashMap);
        AppMethodBeat.o(41587);
    }

    public final int bgI() {
        return 118;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(41588);
        if (jSONObject != null) {
            this.mrK = jSONObject.optString("encrypted_device_info");
            this.cBV = jSONObject.optString("encrypted_rsa_sign");
            this.msr = jSONObject.optString("cert");
            if (TextUtils.isEmpty(this.mrK)) {
                ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is empty");
            } else {
                ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_device_info is not empty");
            }
            if (TextUtils.isEmpty(this.cBV)) {
                ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is empty");
            } else {
                ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "encrypted_rsa_sign is not empty");
            }
            if (TextUtils.isEmpty(this.msr)) {
                ab.e("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is empty");
                AppMethodBeat.o(41588);
                return;
            }
            ab.i("MicroMsg.NetSceneTenpayGetOpenTouchCert", "cert is not empty");
        }
        AppMethodBeat.o(41588);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getopentouchcert";
    }

    public final int ZU() {
        return 1598;
    }
}
