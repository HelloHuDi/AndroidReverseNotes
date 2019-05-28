package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.c */
public final class C46365c extends C5749m {
    public C46365c(String str, String str2, int i) {
        this(str, str2, i, (byte) 0);
    }

    private C46365c(String str, String str2, int i, byte b) {
        AppMethodBeat.m2504i(46639);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("realname_scene", String.valueOf(i));
        C4990ab.m7417i("MicroMsg.NetSceneRealNameReg", "realname_scene=%d", Integer.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46639);
    }

    public final int bgI() {
        return 1648;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46640);
        C4990ab.m7416i("MicroMsg.NetSceneRealNameReg", "errCode=" + str + ";errMsg=" + str);
        AppMethodBeat.m2505o(46640);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamereg";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1648;
    }
}
