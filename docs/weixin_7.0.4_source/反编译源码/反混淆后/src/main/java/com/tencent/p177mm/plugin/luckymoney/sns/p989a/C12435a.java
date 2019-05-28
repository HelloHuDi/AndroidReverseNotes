package com.tencent.p177mm.plugin.luckymoney.sns.p989a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.luckymoney.sns.p1487b.C34458a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.sns.a.a */
public final class C12435a extends C5749m {
    public int obS = 0;

    public C12435a(int i, String str, String str2) {
        AppMethodBeat.m2504i(42549);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", String.valueOf(str2));
        this.obS = i;
        mo70323M(hashMap);
        AppMethodBeat.m2505o(42549);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snspaymanage";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1697;
    }

    public final int bgI() {
        return 1697;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42550);
        C4990ab.m7416i("MicroMsg.NetSceneSnsPayManage", " errCode: " + i + " errMsg :" + str);
        if (i != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() NetSceneSnsPayManage is false!");
            AppMethodBeat.m2505o(42550);
        } else if (this.obS == 1) {
            C34458a.m56484xV(1);
            C4990ab.m7416i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 1");
            AppMethodBeat.m2505o(42550);
        } else {
            C34458a.m56484xV(0);
            C4990ab.m7416i("MicroMsg.NetSceneSnsPayManage", "onGYNetEnd() setIsOpenSnsPay with 0");
            AppMethodBeat.m2505o(42550);
        }
    }
}
