package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class af extends a<q> {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130411);
        final q qVar = (q) cVar;
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        Context context = (MMActivity) qVar.ad(MMActivity.class);
        if (context == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(130411);
            return;
        }
        context.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130410);
                if (i != (af.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(130410);
                } else if (i2 == -1 && intent != null) {
                    HashMap hashMap = new HashMap();
                    String bc = bo.bc(intent.getStringExtra("choose_invoice_title_info"), "");
                    ab.i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : ".concat(String.valueOf(bc)));
                    hashMap.put("invoiceTitleInfo", bc);
                    qVar.M(i, af.this.j("ok", hashMap));
                    AppMethodBeat.o(130410);
                } else if (i2 == 0) {
                    qVar.M(i, af.this.j("cancel", null));
                    AppMethodBeat.o(130410);
                } else {
                    qVar.M(i, af.this.j("fail", null));
                    AppMethodBeat.o(130410);
                }
            }
        };
        d.a(context, "address", ".ui.InvoiceListUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.o(130411);
    }
}
