package com.tencent.p177mm.pluginsdk.p1078e;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.pluginsdk.e.a */
public final class C14826a {
    public static Bundle aiw(String str) {
        AppMethodBeat.m2504i(27232);
        Bundle bundle = new Bundle();
        bundle.putInt("key_scene", 1);
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            C4990ab.m7412e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
            AppMethodBeat.m2505o(27232);
            return bundle;
        }
        HashMap hashMap = new HashMap();
        for (CharSequence charSequence : split) {
            if (!TextUtils.isEmpty(charSequence)) {
                String[] split2 = charSequence.split("=");
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        bundle.putString("_wxapi_payreq_appid", C14826a.m23064c("appid", hashMap));
        bundle.putString("_wxapi_payreq_partnerid", C14826a.m23064c("partnerid", hashMap));
        bundle.putString("_wxapi_payreq_prepayid", C14826a.m23064c("prepayid", hashMap));
        bundle.putString("_wxapi_payreq_noncestr", C14826a.m23064c("noncestr", hashMap));
        bundle.putString("_wxapi_payreq_timestamp", C14826a.m23064c(Param.TIMESTAMP, hashMap));
        bundle.putString("_wxapi_payreq_packagevalue", C14826a.m23064c("package", hashMap));
        bundle.putString("_wxapi_payreq_sign", C14826a.m23064c("sign", hashMap));
        bundle.putString("_wxapi_payreq_sign_type", C14826a.m23064c("signtype", hashMap));
        bundle.putString("_wxapi_payreq_extdata", C14826a.m23064c("extdata", hashMap));
        bundle.putString("_wxapi_payoptions_callback_classname", "");
        bundle.putInt("_wxapi_payoptions_callback_flags", -1);
        AppMethodBeat.m2505o(27232);
        return bundle;
    }

    /* renamed from: c */
    private static String m23064c(String str, HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(27233);
        String str2 = (String) hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            C4990ab.m7412e("MicroMsg.MallManager", "getWapPayKey key: " + str + " value is empty");
            str2 = "";
            AppMethodBeat.m2505o(27233);
            return str2;
        }
        AppMethodBeat.m2505o(27233);
        return str2;
    }
}
