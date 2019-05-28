package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bb */
public final class C45579bb extends C10296a {
    public static final int CTRL_INDEX = 618;
    public static final String NAME = "openWCPayLQTDepositPlan";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130521);
        final Context context = c2241c.getContext();
        if (context == null || !(context instanceof MMActivity)) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenWCPayLQTDepositPlan", "mmActivity is null, invoke fail!");
            AppMethodBeat.m2505o(130521);
            return;
        }
        ((MMActivity) context).ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130520);
                if (i != (C45579bb.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(130520);
                    return;
                }
                if (i2 == -1) {
                    new Intent().putExtra("key_mode", 1);
                    C25985d.m41448H(context, "wallet", ".balance.ui.lqt.WalletLqtPlanHomeUI");
                    c2241c.mo6107M(i, C45579bb.this.mo73394j("ok", null));
                } else {
                    c2241c.mo6107M(i, C45579bb.this.mo73394j("fail", null));
                    if (!C46512f.dlH()) {
                        C7060h.pYm.mo8381e(14954, C46512f.dlI(), "openWCPayLQTDepositPlan:fail");
                    }
                }
                if (!C46512f.dlH()) {
                    C46512f.dlJ();
                }
                AppMethodBeat.m2505o(130520);
            }
        };
        AppBrandSysConfigWC wJ = C10048a.m17636wJ(c2241c.getAppId());
        if (wJ == null) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenWCPayLQTDepositPlan", "sysConfig is null, invoke fail!");
            AppMethodBeat.m2505o(130521);
            return;
        }
        C41243o wI = C10048a.m17635wI(c2241c.getAppId());
        if (wI == null) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            C4990ab.m7412e("MicroMsg.JsApiOpenWCPayLQTDepositPlan", "runtime is null, invoke fail!");
            AppMethodBeat.m2505o(130521);
            return;
        }
        C4990ab.m7410d("MicroMsg.JsApiOpenWCPayLQTDepositPlan", "do openWCPayLQTDepositPlan");
        String currentUrl = wI.asV().getCurrentUrl();
        Intent intent = new Intent();
        intent.putExtra("appId", c2241c.getAppId());
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("pay_channel", jSONObject.optString("pay_channel"));
        intent.putExtra("wxapp_username", wJ.cwz);
        intent.putExtra("jsapi_scene", 21);
        intent.putExtra("command_word", NAME);
        intent.putExtra("wxapp_path", currentUrl);
        intent.putExtra("source_type", 2);
        C25985d.m41468b(context, "wallet", ".ui.WalletJsApiAdapterUI", intent, hashCode() & CdnLogic.kBizGeneric);
        AppMethodBeat.m2505o(130521);
    }
}
