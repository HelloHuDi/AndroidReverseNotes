package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C8872a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag */
public final class C42466ag extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 627;
    public static final String NAME = "chooseShareGroup";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130413);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            c19722s.mo6107M(i, mo73394j("fail jsondata null", null));
            AppMethodBeat.m2505o(130413);
            return;
        }
        Context context = c19722s.getContext() instanceof MMActivity ? (MMActivity) c19722s.getContext() : null;
        if (context == null) {
            c19722s.mo6107M(i, mo73394j("fail service context null", null));
            AppMethodBeat.m2505o(130413);
            return;
        }
        try {
            Object[] objArr;
            int i2;
            String string = jSONObject.getString("title");
            boolean optBoolean = jSONObject.has("public") ? jSONObject.optBoolean("public") : true;
            boolean optBoolean2 = jSONObject.has("private") ? jSONObject.optBoolean("private") : true;
            boolean optBoolean3 = jSONObject.has("visible") ? jSONObject.optBoolean("visible") : true;
            boolean optBoolean4 = jSONObject.has("invisible") ? jSONObject.optBoolean("invisible") : true;
            JSONArray optJSONArray = jSONObject.optJSONArray("labelList");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                objArr = null;
            } else {
                String[] strArr = new String[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    strArr[i2] = optJSONArray.getString(i2);
                }
                objArr = strArr;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("userList");
            Object[] objArr2 = null;
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                objArr2 = new String[optJSONArray2.length()];
                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    objArr2[i2] = optJSONArray2.getString(i2);
                }
            }
            String optString = jSONObject.optString("group");
            Intent intent = new Intent();
            intent.putExtra("k_select_group", optString);
            intent.putExtra("k_title", string);
            intent.putExtra("k_show_public", optBoolean);
            intent.putExtra("k_show_private", optBoolean2);
            intent.putExtra("k_show_include", optBoolean3);
            intent.putExtra("k_show_exclude", optBoolean4);
            if (objArr != null) {
                intent.putExtra("Klabel_name_list", C5046bo.m7536c(Arrays.asList(objArr), ","));
            }
            if (objArr2 != null) {
                intent.putExtra("Kother_user_name_list", C5046bo.m7536c(Arrays.asList(objArr2), ","));
            }
            intent.setClassName(C4996ah.getPackageName(), C4996ah.doz() + ".plugin.sns.ui.jsapi.JsapiSnsLabelUI");
            try {
                C8870e.m15839ax(context).mo20068a(intent, new C8872a() {
                    /* renamed from: b */
                    public final void mo15055b(int i, Intent intent) {
                        int i2 = -1;
                        AppMethodBeat.m2504i(130412);
                        if (i == -1) {
                            String stringExtra = intent.getStringExtra("k_select_group");
                            HashMap hashMap = new HashMap();
                            if (TextUtils.isEmpty(stringExtra)) {
                                c19722s.mo6107M(i, C42466ag.this.mo73394j("cancel", null));
                                AppMethodBeat.m2505o(130412);
                                return;
                            }
                            switch (stringExtra.hashCode()) {
                                case -1901805651:
                                    if (stringExtra.equals("invisible")) {
                                        i2 = 3;
                                        break;
                                    }
                                    break;
                                case -977423767:
                                    if (stringExtra.equals("public")) {
                                        i2 = 1;
                                        break;
                                    }
                                    break;
                                case -314497661:
                                    if (stringExtra.equals("private")) {
                                        i2 = 0;
                                        break;
                                    }
                                    break;
                                case 466743410:
                                    if (stringExtra.equals("visible")) {
                                        i2 = 2;
                                        break;
                                    }
                                    break;
                            }
                            switch (i2) {
                                case 0:
                                case 1:
                                    hashMap.put("group", stringExtra);
                                    c19722s.mo6107M(i, C42466ag.this.mo73394j("ok", hashMap));
                                    AppMethodBeat.m2505o(130412);
                                    return;
                                case 2:
                                case 3:
                                    String stringExtra2 = intent.getStringExtra("Klabel_name_list");
                                    String stringExtra3 = intent.getStringExtra("Kother_user_name_list");
                                    hashMap.put("group", stringExtra);
                                    try {
                                        if (!TextUtils.isEmpty(stringExtra2)) {
                                            hashMap.put("labels", new JSONObject(stringExtra2));
                                        }
                                        if (!TextUtils.isEmpty(stringExtra3)) {
                                            hashMap.put("userList", new JSONArray(stringExtra3));
                                        }
                                        c19722s.mo6107M(i, C42466ag.this.mo73394j("ok", hashMap));
                                        AppMethodBeat.m2505o(130412);
                                        return;
                                    } catch (JSONException e) {
                                        C4990ab.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", e, "", new Object[0]);
                                        break;
                                    }
                            }
                            c19722s.mo6107M(i, C42466ag.this.mo73394j("cancel", null));
                            AppMethodBeat.m2505o(130412);
                            return;
                        }
                        c19722s.mo6107M(i, C42466ag.this.mo73394j("fail", null));
                        AppMethodBeat.m2505o(130412);
                    }
                });
                AppMethodBeat.m2505o(130413);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", e, "", new Object[0]);
                c19722s.mo6107M(i, mo73394j("fail", null));
                AppMethodBeat.m2505o(130413);
            }
        } catch (JSONException e2) {
            c19722s.mo6107M(i, mo73394j("fail parse json error", null));
            AppMethodBeat.m2505o(130413);
        }
    }
}
