package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag extends a<s> {
    public static final int CTRL_INDEX = 627;
    public static final String NAME = "chooseShareGroup";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130413);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            sVar.M(i, j("fail jsondata null", null));
            AppMethodBeat.o(130413);
            return;
        }
        Context context = sVar.getContext() instanceof MMActivity ? (MMActivity) sVar.getContext() : null;
        if (context == null) {
            sVar.M(i, j("fail service context null", null));
            AppMethodBeat.o(130413);
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
                intent.putExtra("Klabel_name_list", bo.c(Arrays.asList(objArr), ","));
            }
            if (objArr2 != null) {
                intent.putExtra("Kother_user_name_list", bo.c(Arrays.asList(objArr2), ","));
            }
            intent.setClassName(ah.getPackageName(), ah.doz() + ".plugin.sns.ui.jsapi.JsapiSnsLabelUI");
            try {
                e.ax(context).a(intent, new a() {
                    public final void b(int i, Intent intent) {
                        int i2 = -1;
                        AppMethodBeat.i(130412);
                        if (i == -1) {
                            String stringExtra = intent.getStringExtra("k_select_group");
                            HashMap hashMap = new HashMap();
                            if (TextUtils.isEmpty(stringExtra)) {
                                sVar.M(i, ag.this.j("cancel", null));
                                AppMethodBeat.o(130412);
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
                                    sVar.M(i, ag.this.j("ok", hashMap));
                                    AppMethodBeat.o(130412);
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
                                        sVar.M(i, ag.this.j("ok", hashMap));
                                        AppMethodBeat.o(130412);
                                        return;
                                    } catch (JSONException e) {
                                        ab.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", e, "", new Object[0]);
                                        break;
                                    }
                            }
                            sVar.M(i, ag.this.j("cancel", null));
                            AppMethodBeat.o(130412);
                            return;
                        }
                        sVar.M(i, ag.this.j("fail", null));
                        AppMethodBeat.o(130412);
                    }
                });
                AppMethodBeat.o(130413);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.JsApiChooseShareGroup", e, "", new Object[0]);
                sVar.M(i, j("fail", null));
                AppMethodBeat.o(130413);
            }
        } catch (JSONException e2) {
            sVar.M(i, j("fail parse json error", null));
            AppMethodBeat.o(130413);
        }
    }
}
