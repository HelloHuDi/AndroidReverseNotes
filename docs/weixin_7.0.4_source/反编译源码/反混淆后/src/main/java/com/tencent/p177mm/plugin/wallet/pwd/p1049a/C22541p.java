package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.p */
public final class C22541p extends C5749m {
    public C22541p(String str) {
        AppMethodBeat.m2504i(46199);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46199);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/touchlockauthen";
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46200);
        String str2 = "MicroMsg.NetSceneTouchLockVerifyByPwd";
        String str3 = "alvinluo errCode: %d, errMsg: %s, json: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = jSONObject != null ? jSONObject.toString() : BuildConfig.COMMAND;
        C4990ab.m7419v(str2, str3, objArr);
        AppMethodBeat.m2505o(46200);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1304;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46201);
        this.ehi = c1202f;
        int a = super.mo4456a(c1902e, c1202f);
        AppMethodBeat.m2505o(46201);
        return a;
    }
}
