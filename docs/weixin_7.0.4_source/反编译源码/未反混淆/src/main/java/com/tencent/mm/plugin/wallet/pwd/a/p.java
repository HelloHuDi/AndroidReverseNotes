package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends m {
    public p(String str) {
        AppMethodBeat.i(46199);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        M(hashMap);
        AppMethodBeat.o(46199);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/touchlockauthen";
    }

    public final int bgI() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46200);
        String str2 = "MicroMsg.NetSceneTouchLockVerifyByPwd";
        String str3 = "alvinluo errCode: %d, errMsg: %s, json: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        objArr[2] = jSONObject != null ? jSONObject.toString() : BuildConfig.COMMAND;
        ab.v(str2, str3, objArr);
        AppMethodBeat.o(46200);
    }

    public final int ZU() {
        return 1304;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46201);
        this.ehi = fVar;
        int a = super.a(eVar, fVar);
        AppMethodBeat.o(46201);
        return a;
    }
}
