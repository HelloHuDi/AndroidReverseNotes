package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.am */
public final class C36785am extends C34442ak {
    public String nSd;
    public String nWX;

    public C36785am(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(42412);
        this.nWX = str3;
        this.nSd = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", str);
        hashMap.put("receiveId", str3);
        hashMap.put("wishing", URLEncoder.encode(C5046bo.nullAsNil(str2)));
        hashMap.put("ver", str4);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42412);
    }

    public final int getType() {
        return 1682;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/wishwxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
    }
}
