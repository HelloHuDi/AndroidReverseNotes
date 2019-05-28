package com.tencent.mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import java.util.Map;

final class a implements com.tencent.mm.plugin.appbrand.compat.a.a {
    a() {
    }

    public final void T(Context context, String str) {
        AppMethodBeat.i(17016);
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("title", context.getString(R.string.l5));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 3);
            AppMethodBeat.o(17016);
            return;
        }
        context.startActivity(putExtra);
        AppMethodBeat.o(17016);
    }

    public final void U(Context context, String str) {
        AppMethodBeat.i(17017);
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("title", context.getString(R.string.kf));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 4);
            AppMethodBeat.o(17017);
            return;
        }
        context.startActivity(putExtra);
        AppMethodBeat.o(17017);
    }

    public final Intent D(Context context, int i) {
        String str;
        AppMethodBeat.i(17018);
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        intent.setClass(context, AppBrandSearchUI.class);
        intent.putExtra("key_trust_url", true);
        intent.putExtra("title", context.getString(R.string.ir));
        intent.putExtra("searchbar_tips", context.getString(R.string.ir));
        intent.putExtra("KRightBtn", true);
        intent.putExtra("ftsneedkeyboard", true);
        intent.putExtra("ftsType", 64);
        intent.putExtra("ftsbizscene", i);
        Map d = r.d(i, true, 64);
        String abv = b.abv();
        d.put("WASessionId", abv);
        d.put("sessionId", abv);
        d.put("subSessionId", abv);
        intent.putExtra("rawUrl", r.E(d));
        intent.putExtra("key_load_js_without_delay", true);
        intent.addFlags(67108864);
        intent.putExtra("key_session_id", abv);
        intent.putExtra("sessionId", abv);
        intent.putExtra("subSessionId", abv);
        abv = "key_search_input_hint";
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, null);
        if (obj == null || !(obj instanceof String)) {
            str = "";
        } else {
            str = (String) obj;
        }
        intent.putExtra(abv, str);
        intent.putExtra("key_alpha_in", !(context instanceof Activity));
        intent.putExtra("key_preload_biz", 5);
        AppMethodBeat.o(17018);
        return intent;
    }

    public final void a(j.b bVar, String str, String str2, String str3, byte[] bArr) {
        AppMethodBeat.i(17019);
        l.a(bVar, str, str2, str3, null, bArr);
        AppMethodBeat.o(17019);
    }

    public final void a(final com.tencent.mm.plugin.appbrand.compat.a.a.a aVar) {
        AppMethodBeat.i(17020);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new aqt();
        aVar2.fsK = new aqu();
        aVar2.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
        aVar2.fsI = 1926;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        w.a(aVar2.acD(), new com.tencent.mm.ai.w.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                boolean z = true;
                AppMethodBeat.i(17015);
                if (mVar.getType() != 1926) {
                    AppMethodBeat.o(17015);
                } else {
                    boolean z2;
                    if (i == 0 && i2 == 0) {
                        aqu aqu = (aqu) bVar.fsH.fsP;
                        z2 = aqu != null && aqu.wuH;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    if (aVar != null) {
                        aVar.q(z, z2);
                    }
                    AppMethodBeat.o(17015);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.o(17020);
    }
}
