package com.tencent.mm.plugin.fingerprint.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.view.d;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m implements k {
    public f(String str, String str2, String str3, int i) {
        AppMethodBeat.i(41589);
        HashMap hashMap = new HashMap();
        hashMap.put("encrypted_open_info", URLEncoder.encode(str));
        hashMap.put("encrypted_rsa_sign", URLEncoder.encode(str2));
        hashMap.put("passwd", str3);
        M(hashMap);
        hashMap = new HashMap();
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("open_scene", String.valueOf(i));
        ba(hashMap);
        AppMethodBeat.o(41589);
    }

    public final int bgI() {
        return d.MIC_AVROUND_BLUR;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(41590);
        super.a(i, i2, i3, str, qVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
            e.hs(true);
            AppMethodBeat.o(41590);
            return;
        }
        ab.e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
        AppMethodBeat.o(41590);
    }

    public final int ZU() {
        return 1599;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
    }
}
