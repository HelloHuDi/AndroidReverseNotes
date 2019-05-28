package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements j {
    static /* synthetic */ String adB(String str) {
        AppMethodBeat.i(91341);
        Map bA = com.tencent.mm.plugin.websearch.a.a.bA(22, "");
        bA.put("sessionId", str);
        String E = com.tencent.mm.plugin.websearch.a.a.E(bA);
        AppMethodBeat.o(91341);
        return E;
    }

    public final void z(Context context, String str, String str2) {
        AppMethodBeat.i(91331);
        a(context, 16, str, str2, null);
        AppMethodBeat.o(91331);
    }

    public final void a(Context context, int i, String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(91332);
        b(context, i, str, str2, map, "");
        AppMethodBeat.o(91332);
    }

    public final void a(Context context, int i, String str, String str2, Map<String, String> map, String str3, int i2) {
        AppMethodBeat.i(91333);
        a(context, i, str, str2, true, map, false, i2, str3, 0, true);
        AppMethodBeat.o(91333);
    }

    public final void a(Context context, int i, String str, String str2, Map<String, String> map, int i2) {
        AppMethodBeat.i(91334);
        a(context, i, str, str2, true, map, false, BaseClientBuilder.API_PRIORITY_OTHER, "", i2, true);
        AppMethodBeat.o(91334);
    }

    private void a(Context context, int i, String str, String str2, Map<String, String> map, String str3) {
        AppMethodBeat.i(91335);
        a(context, i, str, str2, true, map, false, BaseClientBuilder.API_PRIORITY_OTHER, str3);
        AppMethodBeat.o(91335);
    }

    public final void b(Context context, int i, String str, String str2, Map<String, String> map, String str3) {
        AppMethodBeat.i(91336);
        a(context, i, str, str2, (Map) map, str3);
        AppMethodBeat.o(91336);
    }

    public final void a(Context context, String str, String str2, Map<String, String> map) {
        AppMethodBeat.i(91337);
        a(context, 3, str, str2, true, map, true, -1, "");
        AppMethodBeat.o(91337);
    }

    private void a(Context context, int i, String str, String str2, boolean z, Map<String, String> map, boolean z2, int i2, String str3) {
        AppMethodBeat.i(91338);
        a(context, i, str, str2, true, map, z2, i2, str3, 0, false);
        AppMethodBeat.o(91338);
    }

    public final void aa(Context context, int i) {
        AppMethodBeat.i(91339);
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("key_trust_url", true);
        intent.putExtra("KRightBtn", true);
        intent.putExtra("ftsneedkeyboard", true);
        intent.putExtra("ftsType", 64);
        intent.putExtra("ftsbizscene", i);
        Map bA = com.tencent.mm.plugin.websearch.a.a.bA(i, "");
        String abv = b.abv();
        bA.put("WASessionId", abv);
        bA.put("sessionId", abv);
        bA.put("subSessionId", abv);
        intent.putExtra("rawUrl", com.tencent.mm.plugin.websearch.a.a.E(bA));
        intent.putExtra("key_load_js_without_delay", true);
        intent.addFlags(67108864);
        intent.putExtra("key_session_id", abv);
        intent.putExtra("sessionId", abv);
        intent.putExtra("subSessionId", abv);
        Object obj = g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            intent.putExtra("key_search_input_hint", (String) obj);
        }
        d.b(context, "appbrand", ".ui.AppBrandSearchUI", intent);
        AppMethodBeat.o(91339);
    }

    private void a(Context context, int i, String str, String str2, boolean z, Map<String, String> map, boolean z2, int i2, String str3, int i3, boolean z3) {
        AppMethodBeat.i(91340);
        final Map<String, String> map2 = map;
        final String str4 = str;
        final int i4 = i;
        final String str5 = str2;
        final boolean z4 = z;
        final int i5 = i3;
        final String str6 = str3;
        final boolean z5 = z3;
        final boolean z6 = z2;
        final int i6 = i2;
        final Context context2 = context;
        ((m) g.K(m.class)).a(context, new Runnable() {
            public final void run() {
                AppMethodBeat.i(91330);
                if (aa.HU(0)) {
                    String str;
                    String str2 = "";
                    int i = -1;
                    JSONObject jSONObject = new JSONObject();
                    String str3 = "";
                    if (map2 != null) {
                        str = (String) map2.get("sugId");
                        if (map2.containsKey("parentSearchID")) {
                            str3 = (String) map2.get("parentSearchID");
                        } else {
                            str3 = (map2.containsKey("clickType") ? ((String) map2.get("clickType")) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D : "0:") + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str4 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                        }
                        try {
                            jSONObject.put("parentSearchID", str3);
                        } catch (JSONException e) {
                            ab.b("StartWebSearchService", "", e);
                        }
                        str = (String) map2.get("sugId");
                        i = bo.ank((String) map2.get("sceneActionType"));
                        str2 = str;
                    }
                    str = String.valueOf(System.currentTimeMillis());
                    String HP = aa.HP(i4);
                    aa.a(str, str5, HP, str4, i4, str2, i, str3);
                    ll llVar = new ll();
                    llVar.cHk.scene = 0;
                    com.tencent.mm.sdk.b.a.xxA.m(llVar);
                    Map a = aa.a(i4, z4, 0, Uri.encode(jSONObject.toString()), "", str5, str4, "", HP, "", str);
                    if (map2 != null) {
                        a.putAll(map2);
                    }
                    try {
                        a.put(SearchIntents.EXTRA_QUERY, q.encode(str4, "UTF-8"));
                    } catch (Exception e2) {
                        a.put(SearchIntents.EXTRA_QUERY, str4);
                    }
                    a.put("sessionId", str5);
                    String E = aa.E(a);
                    Intent cVd = aa.cVd();
                    cVd.putExtra("ftsType", i5);
                    cVd.putExtra("title", str6);
                    cVd.putExtra("ftsbizscene", i4);
                    cVd.putExtra("ftsQuery", str4);
                    String str4 = "ftsInitToSearch";
                    boolean z = !TextUtils.isEmpty(str4) || z5;
                    cVd.putExtra(str4, z);
                    cVd.putExtra("sessionId", str5);
                    cVd.putExtra("subSessionId", HP);
                    cVd.putExtra("rawUrl", E);
                    cVd.putExtra("key_preload_biz", 4);
                    cVd.putExtra("key_weapp_url", a.adB(str5));
                    if (z6) {
                        cVd.putExtra("status_bar_style", "black");
                    }
                    if (i6 != BaseClientBuilder.API_PRIORITY_OTHER) {
                        cVd.putExtra("customize_status_bar_color", i6);
                    }
                    cVd.putExtra("key_load_js_without_delay", true);
                    if (i4 == 56) {
                        cVd.putExtra("ftsneedkeyboard", true);
                    }
                    d.b(context2, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", cVd);
                    a.cUH();
                    AppMethodBeat.o(91330);
                    return;
                }
                ab.e("StartWebSearchService", "fts h5 template not avail");
                AppMethodBeat.o(91330);
            }
        });
        AppMethodBeat.o(91340);
    }

    static /* synthetic */ void cUH() {
        AppMethodBeat.i(91342);
        aa.lL(1000);
        AppMethodBeat.o(91342);
    }
}
