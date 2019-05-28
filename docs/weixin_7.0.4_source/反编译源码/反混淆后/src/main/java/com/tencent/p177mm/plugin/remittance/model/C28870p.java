package com.tencent.p177mm.plugin.remittance.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p1629b.p1630a.C44420a;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.remittance.model.p */
public final class C28870p extends C44420a {
    public C28870p(String str, String str2, int i, long j, int i2) {
        AppMethodBeat.m2504i(44758);
        HashMap hashMap = new HashMap();
        hashMap.put("recv_username", str);
        hashMap.put("qrcodeid", str2);
        hashMap.put(C8741b.CURRENCY, String.valueOf(i));
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("set_amount", String.valueOf(i2));
        mo70315M(hashMap);
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferCancelPay", "qrcodeId: %s, currency: %s", str2, Integer.valueOf(i));
        AppMethodBeat.m2505o(44758);
    }

    /* renamed from: a */
    public final void mo6950a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(44759);
        C4990ab.m7411d("MicroMsg.NetSceneH5F2fTransferCancelPay", "json: %s", jSONObject.toString());
        C4990ab.m7417i("MicroMsg.NetSceneH5F2fTransferCancelPay", "errCode: %s, errMsg: %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(44759);
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/h5f2ftransfercancelpay";
    }

    public final int getType() {
        return 1257;
    }

    public final int bgG() {
        return 1257;
    }
}
