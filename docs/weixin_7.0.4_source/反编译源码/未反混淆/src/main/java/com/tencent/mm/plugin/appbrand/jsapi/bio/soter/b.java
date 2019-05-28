package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 277;
    public static final String NAME = "startSoterAuthentication";
    private Class<?> hDo;
    private int scene;

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(73793);
        ab.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: JsApiStartSoterAuthentication");
        Activity activity = (Activity) cVar.getContext();
        if (activity == null) {
            ab.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication context is null, appId is %s", cVar.getAppId());
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(73793);
        } else if (this.hDo == null) {
            ab.e("MicroMsg.JsApiLuggageStartSoterAuthentication", "JsApiStartSoterAuthentication ui is null!");
            cVar.M(i, j("fail:JsApiStartSoterAuthentication UI is null!", null));
            AppMethodBeat.o(73793);
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("requestAuthModes");
            String optString = jSONObject.optString("challenge");
            String optString2 = jSONObject.optString("authContent");
            Intent intent = new Intent(activity, this.hDo);
            intent.putExtra("auth_mode", d.m(optJSONArray));
            intent.putExtra("challenge", optString);
            intent.putExtra("auth_content", optString2);
            intent.putExtra("key_soter_fp_luggage_fromscene", 1);
            try {
                this.scene = jSONObject.getInt("scene");
                intent.putExtra("key_soter_fp_luggage_scene", this.scene);
            } catch (JSONException e) {
                ab.i("MicroMsg.JsApiLuggageStartSoterAuthentication", "hy: soter authentication scene null");
            }
            intent.putExtra("Soter_Result_Receiver", new JsApiLuggageStartSoterAuthentication$1(this, new Handler(Looper.getMainLooper()), cVar, i));
            activity.startActivity(intent);
            AppMethodBeat.o(73793);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(b bVar, c cVar, int i, Bundle bundle, String str) {
        Object obj;
        Object obj2;
        JSONArray jSONArray;
        Object string;
        HashMap hashMap;
        HashMap hashMap2;
        AppMethodBeat.i(73794);
        int i2 = -1;
        String str2 = "not returned";
        Object obj3 = "";
        Object obj4 = "";
        int i3 = (byte) 0;
        Object obj5 = "";
        Object obj6 = "";
        String str3 = "";
        String str4 = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj3 = bundle.getString("result_json");
            obj4 = bundle.getString("result_json_signature");
            i3 = bundle.getByte("use_mode");
            str3 = bundle.getString("authkey_result_json");
            str4 = bundle.getString("authkey_result_json_signature");
            if (com.tencent.soter.core.a.dQS() != null && i2 == 0) {
                obj5 = com.tencent.soter.core.a.dQS().Avn;
                obj6 = com.tencent.soter.core.a.dQS().signature;
                obj = str4;
                obj2 = str3;
                if (i3 > 0) {
                    jSONArray = new JSONArray();
                } else {
                    ArrayList arrayList = new ArrayList(3);
                    if ((i3 & 1) == 1) {
                        arrayList.add("fingerPrint");
                    }
                    if ((i3 & 8) == 8) {
                        arrayList.add("facial");
                    }
                    if ((i3 & 2) == 2) {
                        arrayList.add("speech");
                    }
                    ab.i("MicroMsg.AppBrandSoterTranslateUtil", "hy: final string is: %s", arrayList.toString());
                    jSONArray = new JSONArray(arrayList);
                }
                str3 = "";
                if (jSONArray.length() > 0) {
                    try {
                        string = jSONArray.getString(0);
                    } catch (JSONException e) {
                        ab.printErrStackTrace("MicroMsg.JsApiLuggageStartSoterAuthentication", e, "hy: json error in callback", new Object[0]);
                    }
                    hashMap = new HashMap(6);
                    hashMap.put("authMode", string);
                    hashMap.put("errCode", Integer.valueOf(i2));
                    hashMap.put("resultJSON", obj3);
                    hashMap.put("resultJSONSignature", obj4);
                    hashMap2 = new HashMap(2);
                    hashMap2.put("resultJSON", obj5);
                    hashMap2.put("resultJSONSignature", obj6);
                    hashMap.put("ask", hashMap2);
                    hashMap2 = new HashMap(2);
                    hashMap2.put("resultJSON", obj2);
                    hashMap2.put("resultJSONSignature", obj);
                    hashMap.put("authKey", hashMap2);
                    if ("fail".equals(str)) {
                        str = str + " " + str2;
                    }
                    cVar.M(i, bVar.j(str, hashMap));
                    AppMethodBeat.o(73794);
                }
                str4 = str3;
                hashMap = new HashMap(6);
                hashMap.put("authMode", string);
                hashMap.put("errCode", Integer.valueOf(i2));
                hashMap.put("resultJSON", obj3);
                hashMap.put("resultJSONSignature", obj4);
                hashMap2 = new HashMap(2);
                hashMap2.put("resultJSON", obj5);
                hashMap2.put("resultJSONSignature", obj6);
                hashMap.put("ask", hashMap2);
                hashMap2 = new HashMap(2);
                hashMap2.put("resultJSON", obj2);
                hashMap2.put("resultJSONSignature", obj);
                hashMap.put("authKey", hashMap2);
                if ("fail".equals(str)) {
                }
                cVar.M(i, bVar.j(str, hashMap));
                AppMethodBeat.o(73794);
            }
        }
        String obj7 = str4;
        String obj22 = str3;
        if (i3 > 0) {
        }
        str3 = "";
        if (jSONArray.length() > 0) {
        }
        str4 = str3;
        hashMap = new HashMap(6);
        hashMap.put("authMode", string);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("resultJSON", obj3);
        hashMap.put("resultJSONSignature", obj4);
        hashMap2 = new HashMap(2);
        hashMap2.put("resultJSON", obj5);
        hashMap2.put("resultJSONSignature", obj6);
        hashMap.put("ask", hashMap2);
        hashMap2 = new HashMap(2);
        hashMap2.put("resultJSON", obj22);
        hashMap2.put("resultJSONSignature", obj7);
        hashMap.put("authKey", hashMap2);
        if ("fail".equals(str)) {
        }
        cVar.M(i, bVar.j(str, hashMap));
        AppMethodBeat.o(73794);
    }
}
