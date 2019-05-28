package com.tencent.p177mm.plugin.appbrand.compat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a.C10167a;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandNearbyWebViewUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandSearchUI;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.aqt;
import com.tencent.p177mm.protocal.protobuf.aqu;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.compat.a */
final class C10168a implements C42401a {
    C10168a() {
    }

    /* renamed from: T */
    public final void mo21551T(Context context, String str) {
        AppMethodBeat.m2504i(17016);
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("title", context.getString(C25738R.string.f8969l5));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 3);
            AppMethodBeat.m2505o(17016);
            return;
        }
        context.startActivity(putExtra);
        AppMethodBeat.m2505o(17016);
    }

    /* renamed from: U */
    public final void mo21552U(Context context, String str) {
        AppMethodBeat.m2504i(17017);
        Intent putExtra = new Intent(context, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", str);
        putExtra.putExtra("title", context.getString(C25738R.string.f8948kf));
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(putExtra, 4);
            AppMethodBeat.m2505o(17017);
            return;
        }
        context.startActivity(putExtra);
        AppMethodBeat.m2505o(17017);
    }

    /* renamed from: D */
    public final Intent mo21550D(Context context, int i) {
        String str;
        AppMethodBeat.m2504i(17018);
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        intent.setClass(context, AppBrandSearchUI.class);
        intent.putExtra("key_trust_url", true);
        intent.putExtra("title", context.getString(C25738R.string.f8900ir));
        intent.putExtra("searchbar_tips", context.getString(C25738R.string.f8900ir));
        intent.putExtra("KRightBtn", true);
        intent.putExtra("ftsneedkeyboard", true);
        intent.putExtra("ftsType", 64);
        intent.putExtra("ftsbizscene", i);
        Map d = C27278r.m43309d(i, true, 64);
        String abv = C45445b.abv();
        d.put("WASessionId", abv);
        d.put("sessionId", abv);
        d.put("subSessionId", abv);
        intent.putExtra("rawUrl", C27278r.m43306E(d));
        intent.putExtra("key_load_js_without_delay", true);
        intent.addFlags(67108864);
        intent.putExtra("key_session_id", abv);
        intent.putExtra("sessionId", abv);
        intent.putExtra("subSessionId", abv);
        abv = "key_search_input_hint";
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, null);
        if (obj == null || !(obj instanceof String)) {
            str = "";
        } else {
            str = (String) obj;
        }
        intent.putExtra(abv, str);
        intent.putExtra("key_alpha_in", !(context instanceof Activity));
        intent.putExtra("key_preload_biz", 5);
        AppMethodBeat.m2505o(17018);
        return intent;
    }

    /* renamed from: a */
    public final void mo21553a(C8910b c8910b, String str, String str2, String str3, byte[] bArr) {
        AppMethodBeat.m2504i(17019);
        C4733l.m7087a(c8910b, str, str2, str3, null, bArr);
        AppMethodBeat.m2505o(17019);
    }

    /* renamed from: a */
    public final void mo21554a(final C10167a c10167a) {
        AppMethodBeat.m2504i(17020);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aqt();
        c1196a.fsK = new aqu();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/getwerunuserstate";
        c1196a.fsI = 1926;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C1226w.m2655a(c1196a.acD(), new C1224a() {
            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                boolean z = true;
                AppMethodBeat.m2504i(17015);
                if (c1207m.getType() != 1926) {
                    AppMethodBeat.m2505o(17015);
                } else {
                    boolean z2;
                    if (i == 0 && i2 == 0) {
                        aqu aqu = (aqu) c7472b.fsH.fsP;
                        z2 = aqu != null && aqu.wuH;
                    } else {
                        z2 = false;
                        z = false;
                    }
                    if (c10167a != null) {
                        c10167a.mo21549q(z, z2);
                    }
                    AppMethodBeat.m2505o(17015);
                }
                return 0;
            }
        }, true);
        AppMethodBeat.m2505o(17020);
    }
}
