package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.n */
public class C43903n extends C46419bd<C24905d> {
    public final String name() {
        return "getBrandWCPayRequest";
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6309);
        C4990ab.m7416i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
        C35899h.m58859a((MMActivity) ((C24905d) c32183a.bOZ).mContext, new C40493g(c32183a.bPa.bOf), hashCode() & CdnLogic.kBizGeneric, new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6308);
                if (i != (C43903n.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(6308);
                } else if (i2 == -1) {
                    c32183a.mo52824a("", null);
                    AppMethodBeat.m2505o(6308);
                } else if (i2 == 5) {
                    HashMap hashMap = new HashMap();
                    int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                    String nullAsNil = C5046bo.nullAsNil(intent.getStringExtra("key_jsapi_pay_err_msg"));
                    hashMap.put("err_code", Integer.valueOf(intExtra));
                    hashMap.put("err_desc", nullAsNil);
                    C4990ab.m7413e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), nullAsNil);
                    c32183a.mo52825c("fail", hashMap);
                    AppMethodBeat.m2505o(6308);
                } else {
                    c32183a.mo52824a("cancel", null);
                    AppMethodBeat.m2505o(6308);
                }
            }
        });
        AppMethodBeat.m2505o(6309);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
