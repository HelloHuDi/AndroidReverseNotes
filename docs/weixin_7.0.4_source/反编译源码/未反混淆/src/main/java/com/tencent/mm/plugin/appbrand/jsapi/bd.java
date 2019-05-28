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

public final class bd extends a {
    public static final int CTRL_INDEX = 616;
    public static final String NAME = "openWCPayLQTDetail";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130525);
        final Context context = cVar.getContext();
        if (context == null || !(context instanceof MMActivity)) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTDetail", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130525);
            return;
        }
        ((MMActivity) context).ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130524);
                if (i != (bd.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(130524);
                    return;
                }
                if (i2 == -1) {
                    new Intent().putExtra("key_account_type", 1);
                    d.H(context, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    cVar.M(i, bd.this.j("ok", null));
                } else {
                    cVar.M(i, bd.this.j("fail", null));
                    if (!f.dlH()) {
                        h.pYm.e(14954, f.dlI(), "JsApiOpenWCPayLQTDetail:fail");
                    }
                }
                if (!f.dlH()) {
                    f.dlJ();
                }
                AppMethodBeat.o(130524);
            }
        };
        AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(cVar.getAppId());
        if (wJ == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTDetail", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(130525);
            return;
        }
        o wI = com.tencent.mm.plugin.appbrand.a.wI(cVar.getAppId());
        if (wI == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTDetail", "runtime is null, invoke fail!");
            AppMethodBeat.o(130525);
            return;
        }
        ab.d("MicroMsg.JsApiOpenWCPayLQTDetail", "do openWCPayLQTDepositPlan");
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
        intent.putExtra("jsapi_scene", 19);
        intent.putExtra("command_word", NAME);
        intent.putExtra("wxapp_path", currentUrl);
        intent.putExtra("source_type", 2);
        d.b(context, "wallet", ".ui.WalletJsApiAdapterUI", intent, hashCode() & CdnLogic.kBizGeneric);
        AppMethodBeat.o(130525);
    }
}
