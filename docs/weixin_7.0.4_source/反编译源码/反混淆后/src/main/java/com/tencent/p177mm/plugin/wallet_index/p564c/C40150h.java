package com.tencent.p177mm.plugin.wallet_index.p564c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_index.c.h */
public final class C40150h extends C5749m {
    public C40150h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.m2504i(48190);
        HashMap hashMap = new HashMap();
        hashMap.put("toUser", str);
        hashMap.put("receiverTitle", str2);
        hashMap.put("senderTitle", str3);
        hashMap.put("tempId", str4);
        hashMap.put("receiverdes", str6);
        hashMap.put("senderdes", str5);
        hashMap.put("Url", str7);
        hashMap.put("Scene", str8);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(48190);
    }

    public final int bgI() {
        return 0;
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1962;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(48191);
        C4990ab.m7410d("Micromsg.NetSceneSendC2CMsg", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.m2505o(48191);
        } else {
            AppMethodBeat.m2505o(48191);
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/h5sendc2cmsg";
    }
}
