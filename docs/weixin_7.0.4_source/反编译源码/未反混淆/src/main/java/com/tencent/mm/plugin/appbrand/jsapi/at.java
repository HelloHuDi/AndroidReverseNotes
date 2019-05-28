package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
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

public final class at extends a {
    public static final int CTRL_INDEX = 62;
    public static final String NAME = "openAddress";

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        Activity ad;
        Context context;
        AppMethodBeat.i(130513);
        Intent intent = new Intent();
        intent.putExtra("req_app_id", cVar.getAppId());
        intent.putExtra("launch_from_appbrand", true);
        if (cVar instanceof q) {
            ad = ((q) cVar).ad(Activity.class);
        } else {
            ad = cVar.getContext();
        }
        if (ad == null || !(ad instanceof MMActivity)) {
            context = null;
        } else {
            MMActivity context2 = (MMActivity) ad;
        }
        if (context2 == null) {
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(130513);
            return;
        }
        context2.ifE = new a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130512);
                if (i != (at.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.o(130512);
                    return;
                }
                if (i2 == -1 && intent != null) {
                    String bc = bo.bc(intent.getStringExtra("nationalCode"), "");
                    String bc2 = bo.bc(intent.getStringExtra("userName"), "");
                    String bc3 = bo.bc(intent.getStringExtra("telNumber"), "");
                    String bc4 = bo.bc(intent.getStringExtra("addressPostalCode"), "");
                    String bc5 = bo.bc(intent.getStringExtra("proviceFirstStageName"), "");
                    String bc6 = bo.bc(intent.getStringExtra("addressCitySecondStageName"), "");
                    String bc7 = bo.bc(intent.getStringExtra("addressCountiesThirdStageName"), "");
                    String bc8 = bo.bc(intent.getStringExtra("addressDetailInfo"), "");
                    ab.i("MicroMsg.JsApiOpenAddress", "first =  " + bc5 + " ; detail =" + bc8 + "; second = " + bc6 + " ; tel = " + bc3 + "; third = " + bc7);
                    if (!bo.isNullOrNil(bc2)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("nationalCode", bc);
                        hashMap.put("userName", bc2);
                        hashMap.put("telNumber", bc3);
                        hashMap.put("addressPostalCode", bc4);
                        hashMap.put("proviceFirstStageName", bc5);
                        hashMap.put("addressCitySecondStageName", bc6);
                        hashMap.put("addressCountiesThirdStageName", bc7);
                        hashMap.put("addressDetailInfo", bc8);
                        cVar.M(i, at.this.j("ok", hashMap));
                        AppMethodBeat.o(130512);
                        return;
                    }
                }
                if (i2 == 0) {
                    cVar.M(i, at.this.j("cancel", null));
                    AppMethodBeat.o(130512);
                    return;
                }
                cVar.M(i, at.this.j("fail", null));
                AppMethodBeat.o(130512);
            }
        };
        d.a(context2, "address", ".ui.WalletSelectAddrUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.o(130513);
    }
}
