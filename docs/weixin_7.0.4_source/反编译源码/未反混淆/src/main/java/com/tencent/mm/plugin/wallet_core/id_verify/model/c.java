package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends m {
    public c(String str, String str2, int i) {
        this(str, str2, i, (byte) 0);
    }

    private c(String str, String str2, int i, byte b) {
        AppMethodBeat.i(46639);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("realname_scene", String.valueOf(i));
        ab.i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", Integer.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(46639);
    }

    public final int bgI() {
        return 1648;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46640);
        ab.i("MicroMsg.NetSceneRealNameReg", "errCode=" + str + ";errMsg=" + str);
        AppMethodBeat.o(46640);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
    }

    public final int ZU() {
        return 1648;
    }
}
