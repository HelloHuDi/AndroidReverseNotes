package com.tencent.p177mm.plugin.fingerprint.p1261c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.plugin.fingerprint.p413b.C39088e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import com.tencent.view.C31128d;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.fingerprint.c.f */
public final class C20766f extends C5749m implements C1918k {
    public C20766f(String str, String str2, String str3, int i) {
        AppMethodBeat.m2504i(41589);
        HashMap hashMap = new HashMap();
        hashMap.put("encrypted_open_info", URLEncoder.encode(str));
        hashMap.put("encrypted_rsa_sign", URLEncoder.encode(str2));
        hashMap.put("passwd", str3);
        mo70323M(hashMap);
        hashMap = new HashMap();
        hashMap.put("device_type", Build.MODEL);
        hashMap.put("open_scene", String.valueOf(i));
        mo70328ba(hashMap);
        AppMethodBeat.m2505o(41589);
    }

    public final int bgI() {
        return C31128d.MIC_AVROUND_BLUR;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(41590);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay success");
            C39088e.m66514hs(true);
            AppMethodBeat.m2505o(41590);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneTenpayOpenTouch", "open fingerprintpay failed");
        AppMethodBeat.m2505o(41590);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1599;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/androidopentouch";
    }
}
