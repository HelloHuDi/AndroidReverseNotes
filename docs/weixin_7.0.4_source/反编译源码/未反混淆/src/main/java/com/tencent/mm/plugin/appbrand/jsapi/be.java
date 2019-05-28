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
import com.tencent.ttpic.baseutils.BitUtils;
import org.json.JSONObject;

public final class be extends a {
    public static final int CTRL_INDEX = 617;
    public static final String NAME = "openWCPayLQTSave";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130527);
        final Context context = cVar.getContext();
        if (context == null || !(context instanceof MMActivity)) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTSave", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(130527);
            return;
        }
        ((MMActivity) context).ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130526);
                ab.d("MicroMsg.JsApiOpenWCPayLQTSave", "activity result: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == (be.this.hashCode() & CdnLogic.kBizGeneric)) {
                    if (i2 == -1) {
                        d.b(context, "wallet", ".balance.ui.lqt.WalletLqtBeforeSaveUI", new Intent(), be.this.hashCode() & BitUtils.BIT_TURN_ZERO_1);
                        cVar.M(i, be.this.j("ok", null));
                    } else {
                        cVar.M(i, be.this.j("fail", null));
                        if (!f.dlH()) {
                            h.pYm.e(14954, f.dlI(), "JsApiOpenWCPayLQTSave:fail");
                        }
                    }
                    if (!f.dlH()) {
                        f.dlJ();
                        AppMethodBeat.o(130526);
                        return;
                    }
                } else if (i != (be.this.hashCode() & BitUtils.BIT_TURN_ZERO_1)) {
                    ab.d("MicroMsg.JsApiOpenWCPayLQTSave", "beforeSave callback");
                    if (i2 == -1) {
                        cVar.M(i, be.this.j("ok", null));
                        AppMethodBeat.o(130526);
                        return;
                    }
                    cVar.M(i, be.this.j("fail", null));
                }
                AppMethodBeat.o(130526);
            }
        };
        AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(cVar.getAppId());
        if (wJ == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTSave", "sysConfig is null, invoke fail!");
            AppMethodBeat.o(130527);
            return;
        }
        o wI = com.tencent.mm.plugin.appbrand.a.wI(cVar.getAppId());
        if (wI == null) {
            cVar.M(i, j("fail", null));
            ab.e("MicroMsg.JsApiOpenWCPayLQTSave", "runtime is null, invoke fail!");
            AppMethodBeat.o(130527);
            return;
        }
        ab.d("MicroMsg.JsApiOpenWCPayLQTSave", "do openWCPayLQTDepositPlan");
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
        intent.putExtra("jsapi_scene", 20);
        intent.putExtra("command_word", NAME);
        intent.putExtra("wxapp_path", currentUrl);
        intent.putExtra("source_type", 2);
        d.b(context, "wallet", ".ui.WalletJsApiAdapterUI", intent, hashCode() & CdnLogic.kBizGeneric);
        AppMethodBeat.o(130527);
    }
}
