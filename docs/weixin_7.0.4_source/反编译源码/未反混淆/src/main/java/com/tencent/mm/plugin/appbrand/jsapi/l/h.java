package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.game.page.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.l.a.AnonymousClass4;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a<s> {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131422);
        final s sVar = (s) cVar;
        Context context = (MMActivity) sVar.ad(MMActivity.class);
        if (context == null) {
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131422);
            return;
        }
        try {
            jSONObject.put("appId", sVar.getAppId());
            w aun = sVar.aun();
            if (aun != null && (aun instanceof f)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("needPortraitSnapshot", true);
                aun.a(2, bundle, new Object[0]);
            }
            a aVar = a.hTJ;
            AnonymousClass1 anonymousClass1 = new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.i(131421);
                    switch (i) {
                        case 1:
                            sVar.M(i, h.this.j("ok", null));
                            AppMethodBeat.o(131421);
                            return;
                        case 2:
                            if (bo.isNullOrNil(str)) {
                                sVar.M(i, h.this.j("fail", null));
                                AppMethodBeat.o(131421);
                                return;
                            }
                            sVar.M(i, h.this.j(String.format("fail %s", new Object[]{str}), null));
                            AppMethodBeat.o(131421);
                            return;
                        default:
                            sVar.M(i, h.this.j("cancel", null));
                            AppMethodBeat.o(131421);
                            return;
                    }
                }
            };
            g gVar = new g(jSONObject);
            gVar.cvS = 16;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(anonymousClass1);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.cId);
            intent.putExtra("key_static_from_scene", 100004);
            intent.putExtra("url", gVar.url);
            context.ifE = anonymousClass4;
            d.a(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, aVar.hashCode() & CdnLogic.kBizGeneric, false);
            AppMethodBeat.o(131422);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiSendBizRedPacket", e.getMessage());
            sVar.M(i, j("fail", null));
            AppMethodBeat.o(131422);
        }
    }
}
