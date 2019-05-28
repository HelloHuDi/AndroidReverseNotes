package com.tencent.mm.pluginsdk.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a {
    public static Bundle aiw(String str) {
        AppMethodBeat.i(27232);
        Bundle bundle = new Bundle();
        bundle.putInt("key_scene", 1);
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            ab.e("MicroMsg.MallManager", "getWapPayBundle arrKeys == null || arrKeys.length == 0");
            AppMethodBeat.o(27232);
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
        bundle.putString("_wxapi_payreq_appid", c("appid", hashMap));
        bundle.putString("_wxapi_payreq_partnerid", c("partnerid", hashMap));
        bundle.putString("_wxapi_payreq_prepayid", c("prepayid", hashMap));
        bundle.putString("_wxapi_payreq_noncestr", c("noncestr", hashMap));
        bundle.putString("_wxapi_payreq_timestamp", c(Param.TIMESTAMP, hashMap));
        bundle.putString("_wxapi_payreq_packagevalue", c("package", hashMap));
        bundle.putString("_wxapi_payreq_sign", c("sign", hashMap));
        bundle.putString("_wxapi_payreq_sign_type", c("signtype", hashMap));
        bundle.putString("_wxapi_payreq_extdata", c("extdata", hashMap));
        bundle.putString("_wxapi_payoptions_callback_classname", "");
        bundle.putInt("_wxapi_payoptions_callback_flags", -1);
        AppMethodBeat.o(27232);
        return bundle;
    }

    private static String c(String str, HashMap<String, String> hashMap) {
        AppMethodBeat.i(27233);
        String str2 = (String) hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            ab.e("MicroMsg.MallManager", "getWapPayKey key: " + str + " value is empty");
            str2 = "";
            AppMethodBeat.o(27233);
            return str2;
        }
        AppMethodBeat.o(27233);
        return str2;
    }
}
