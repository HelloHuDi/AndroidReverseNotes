package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.aj */
public final class C46058aj extends C34442ak {
    public C46058aj(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.m2504i(42407);
        HashMap hashMap = new HashMap();
        hashMap.put("sendId", String.valueOf(str));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put("type", String.valueOf(i));
        hashMap.put("receiveId", str2);
        hashMap.put("ver", str3);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42407);
    }

    public final int getType() {
        return 1612;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/deletelistwxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42408);
        C4990ab.m7416i("NetSceneLuckyMoneyMyRecordDelete", "onGYNetEnd");
        AppMethodBeat.m2505o(42408);
    }
}
