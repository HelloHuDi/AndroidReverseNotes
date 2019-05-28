package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.af */
public final class C19285af extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 286;
    public static final String NAME = "chooseInvoiceTitle";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130411);
        final C38492q c38492q = (C38492q) c2241c;
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_appbrand", true);
        Context context = (MMActivity) c38492q.mo61197ad(MMActivity.class);
        if (context == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130411);
            return;
        }
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130410);
                if (i != (C19285af.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(130410);
                } else if (i2 == -1 && intent != null) {
                    HashMap hashMap = new HashMap();
                    String bc = C5046bo.m7532bc(intent.getStringExtra("choose_invoice_title_info"), "");
                    C4990ab.m7416i("MicroMsg.JsApiChooseInvoiceTitle", "choose_invoice_title_info is : ".concat(String.valueOf(bc)));
                    hashMap.put("invoiceTitleInfo", bc);
                    c38492q.mo6107M(i, C19285af.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(130410);
                } else if (i2 == 0) {
                    c38492q.mo6107M(i, C19285af.this.mo73394j("cancel", null));
                    AppMethodBeat.m2505o(130410);
                } else {
                    c38492q.mo6107M(i, C19285af.this.mo73394j("fail", null));
                    AppMethodBeat.m2505o(130410);
                }
            }
        };
        C25985d.m41453a(context, "address", ".ui.InvoiceListUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.m2505o(130411);
    }
}
