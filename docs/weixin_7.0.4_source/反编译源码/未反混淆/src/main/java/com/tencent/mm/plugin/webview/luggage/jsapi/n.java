package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class n extends bd<d> {
    public final String name() {
        return "getBrandWCPayRequest";
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(6309);
        ab.i("MicroMsg.JsApiGetBrandWCPayRequest", "invokeInOwn");
        h.a((MMActivity) ((d) aVar.bOZ).mContext, new g(aVar.bPa.bOf), hashCode() & CdnLogic.kBizGeneric, new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(6308);
                if (i != (n.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(6308);
                } else if (i2 == -1) {
                    aVar.a("", null);
                    AppMethodBeat.o(6308);
                } else if (i2 == 5) {
                    HashMap hashMap = new HashMap();
                    int intExtra = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                    String nullAsNil = bo.nullAsNil(intent.getStringExtra("key_jsapi_pay_err_msg"));
                    hashMap.put("err_code", Integer.valueOf(intExtra));
                    hashMap.put("err_desc", nullAsNil);
                    ab.e("MicroMsg.JsApiGetBrandWCPayRequest", "errCode: %d, errMsg: %s", Integer.valueOf(intExtra), nullAsNil);
                    aVar.c("fail", hashMap);
                    AppMethodBeat.o(6308);
                } else {
                    aVar.a("cancel", null);
                    AppMethodBeat.o(6308);
                }
            }
        });
        AppMethodBeat.o(6309);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
