package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public final class bc extends a {
    public static final int CTRL_INDEX = 619;
    public static final String NAME = "openWCPayLQTDepositPlanAdd";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130523);
        final Context context = cVar.getContext();
        if (context == null || !(context instanceof MMActivity)) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130523);
            return;
        }
        ((MMActivity) context).ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130522);
                if (i != (bc.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(130522);
                    return;
                }
                if (i2 == -1) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_mode", 1);
                    d.b(context, "wallet", ".balance.ui.lqt.WalletLqtPlanAddUI", intent2);
                    cVar.M(i, bc.this.j("ok", null));
                } else {
                    cVar.M(i, bc.this.j("fail", null));
                    if (!f.dlH()) {
                        h.pYm.e(14954, f.dlI(), "openWCPayLQTDepositPlanAdd:fail");
                    }
                }
                if (!f.dlH()) {
                    f.dlJ();
                }
                AppMethodBeat.o(130522);
            }
        };
        AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(cVar.getAppId());
        if (wJ == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(130523);
            return;
        }
        o wI = com.tencent.mm.plugin.appbrand.a.wI(cVar.getAppId());
        if (wI == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "runtime is null, invoke fail!");
            AppMethodBeat.o(130523);
            return;
        }
        ab.d("MicroMsg.JsApiOpenWCPayLQTDepositPlanAdd", "do openWCPayLQTDepositPlan");
        String currentUrl = wI.asV().getCurrentUrl();
        Intent intent = new Intent();
        intent.putExtra("appId", cVar.getAppId());
        intent.putExtra("timeStamp", jSONObject.optString("timeStamp"));
        intent.putExtra("nonceStr", jSONObject.optString("nonceStr"));
        intent.putExtra("packageExt", jSONObject.optString("package"));
        intent.putExtra("signtype", jSONObject.optString("signType"));
        intent.putExtra("paySignature", jSONObject.optString("paySign"));
        intent.putExtra("pay_channel", jSONObject.optString("pay_channel"));
        intent.putExtra("wxapp_username", wJ.cwz);
        intent.putExtra("jsapi_scene", 22);
        intent.putExtra("command_word", NAME);
        intent.putExtra("wxapp_path", currentUrl);
        intent.putExtra("source_type", 2);
        d.b(context, "wallet", ".ui.WalletJsApiAdapterUI", intent, hashCode() & CdnLogic.kBizGeneric);
        AppMethodBeat.o(130523);
    }
}
