package com.tencent.p177mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C45445b;
import com.tencent.p177mm.p230g.p231a.C26190ll;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.p1663a.C46398a;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.a */
public final class C46399a implements C22757j {
    static /* synthetic */ String adB(String str) {
        AppMethodBeat.m2504i(91341);
        Map bA = C46398a.m87287bA(22, "");
        bA.put("sessionId", str);
        String E = C46398a.m87285E(bA);
        AppMethodBeat.m2505o(91341);
        return E;
    }

    /* renamed from: z */
    public final void mo38340z(Context context, String str, String str2) {
        AppMethodBeat.m2504i(91331);
        mo38334a(context, 16, str, str2, null);
        AppMethodBeat.m2505o(91331);
    }

    /* renamed from: a */
    public final void mo38334a(Context context, int i, String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(91332);
        mo38339b(context, i, str, str2, map, "");
        AppMethodBeat.m2505o(91332);
    }

    /* renamed from: a */
    public final void mo38336a(Context context, int i, String str, String str2, Map<String, String> map, String str3, int i2) {
        AppMethodBeat.m2504i(91333);
        m87290a(context, i, str, str2, true, map, false, i2, str3, 0, true);
        AppMethodBeat.m2505o(91333);
    }

    /* renamed from: a */
    public final void mo38335a(Context context, int i, String str, String str2, Map<String, String> map, int i2) {
        AppMethodBeat.m2504i(91334);
        m87290a(context, i, str, str2, true, map, false, BaseClientBuilder.API_PRIORITY_OTHER, "", i2, true);
        AppMethodBeat.m2505o(91334);
    }

    /* renamed from: a */
    private void m87288a(Context context, int i, String str, String str2, Map<String, String> map, String str3) {
        AppMethodBeat.m2504i(91335);
        m87289a(context, i, str, str2, true, map, false, BaseClientBuilder.API_PRIORITY_OTHER, str3);
        AppMethodBeat.m2505o(91335);
    }

    /* renamed from: b */
    public final void mo38339b(Context context, int i, String str, String str2, Map<String, String> map, String str3) {
        AppMethodBeat.m2504i(91336);
        m87288a(context, i, str, str2, (Map) map, str3);
        AppMethodBeat.m2505o(91336);
    }

    /* renamed from: a */
    public final void mo38337a(Context context, String str, String str2, Map<String, String> map) {
        AppMethodBeat.m2504i(91337);
        m87289a(context, 3, str, str2, true, map, true, -1, "");
        AppMethodBeat.m2505o(91337);
    }

    /* renamed from: a */
    private void m87289a(Context context, int i, String str, String str2, boolean z, Map<String, String> map, boolean z2, int i2, String str3) {
        AppMethodBeat.m2504i(91338);
        m87290a(context, i, str, str2, true, map, z2, i2, str3, 0, false);
        AppMethodBeat.m2505o(91338);
    }

    /* renamed from: aa */
    public final void mo38338aa(Context context, int i) {
        AppMethodBeat.m2504i(91339);
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("key_trust_url", true);
        intent.putExtra("KRightBtn", true);
        intent.putExtra("ftsneedkeyboard", true);
        intent.putExtra("ftsType", 64);
        intent.putExtra("ftsbizscene", i);
        Map bA = C46398a.m87287bA(i, "");
        String abv = C45445b.abv();
        bA.put("WASessionId", abv);
        bA.put("sessionId", abv);
        bA.put("subSessionId", abv);
        intent.putExtra("rawUrl", C46398a.m87285E(bA));
        intent.putExtra("key_load_js_without_delay", true);
        intent.addFlags(67108864);
        intent.putExtra("key_session_id", abv);
        intent.putExtra("sessionId", abv);
        intent.putExtra("subSessionId", abv);
        Object obj = C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_STRING_SYNC, null);
        if (obj != null && (obj instanceof String)) {
            intent.putExtra("key_search_input_hint", (String) obj);
        }
        C25985d.m41467b(context, "appbrand", ".ui.AppBrandSearchUI", intent);
        AppMethodBeat.m2505o(91339);
    }

    /* renamed from: a */
    private void m87290a(Context context, int i, String str, String str2, boolean z, Map<String, String> map, boolean z2, int i2, String str3, int i3, boolean z3) {
        AppMethodBeat.m2504i(91340);
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
        ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(context, new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(91330);
                if (C46400aa.m87304HU(0)) {
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
                            C4990ab.m7408b("StartWebSearchService", "", e);
                        }
                        str = (String) map2.get("sugId");
                        i = C5046bo.ank((String) map2.get("sceneActionType"));
                        str2 = str;
                    }
                    str = String.valueOf(System.currentTimeMillis());
                    String HP = C46400aa.m87299HP(i4);
                    C46400aa.m87328a(str, str5, HP, str4, i4, str2, i, str3);
                    C26190ll c26190ll = new C26190ll();
                    c26190ll.cHk.scene = 0;
                    C4879a.xxA.mo10055m(c26190ll);
                    Map a = C46400aa.m87321a(i4, z4, 0, Uri.encode(jSONObject.toString()), "", str5, str4, "", HP, "", str);
                    if (map2 != null) {
                        a.putAll(map2);
                    }
                    try {
                        a.put(SearchIntents.EXTRA_QUERY, C18178q.encode(str4, "UTF-8"));
                    } catch (Exception e2) {
                        a.put(SearchIntents.EXTRA_QUERY, str4);
                    }
                    a.put("sessionId", str5);
                    String E = C46400aa.m87298E(a);
                    Intent cVd = C46400aa.cVd();
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
                    cVd.putExtra("key_weapp_url", C46399a.adB(str5));
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
                    C25985d.m41467b(context2, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", cVd);
                    C46399a.cUH();
                    AppMethodBeat.m2505o(91330);
                    return;
                }
                C4990ab.m7412e("StartWebSearchService", "fts h5 template not avail");
                AppMethodBeat.m2505o(91330);
            }
        });
        AppMethodBeat.m2505o(91340);
    }

    static /* synthetic */ void cUH() {
        AppMethodBeat.m2504i(91342);
        C46400aa.m87339lL(1000);
        AppMethodBeat.m2505o(91342);
    }
}
