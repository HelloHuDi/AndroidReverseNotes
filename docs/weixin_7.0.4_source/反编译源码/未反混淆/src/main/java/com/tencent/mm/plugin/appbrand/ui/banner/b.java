package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;

final class b {

    enum a {
        appId,
        versionType,
        appName,
        iconURL,
        customText;
        
        static final int iKx = 0;

        static {
            iKx = values().length;
            AppMethodBeat.o(133268);
        }

        public final String wP() {
            AppMethodBeat.i(133267);
            String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
            AppMethodBeat.o(133267);
            return str;
        }
    }

    b() {
    }

    static boolean L(Intent intent) {
        AppMethodBeat.i(133269);
        if (intent == null) {
            AppMethodBeat.o(133269);
            return false;
        }
        String stringExtra = intent.getStringExtra(a.appId.wP());
        int intExtra = intent.getIntExtra(a.versionType.wP(), 0);
        String stringExtra2 = intent.getStringExtra(a.appName.wP());
        String stringExtra3 = intent.getStringExtra(a.iconURL.wP());
        String stringExtra4 = intent.getStringExtra(a.customText.wP());
        for (a wP : a.values()) {
            intent.removeExtra(wP.wP());
        }
        if (bo.isNullOrNil(stringExtra) || bo.isNullOrNil(stringExtra2)) {
            AppMethodBeat.o(133269);
            return false;
        }
        a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4);
        AppMethodBeat.o(133269);
        return true;
    }

    static boolean a(OperateTask operateTask) {
        AppMethodBeat.i(133270);
        if (operateTask == null || !g.RK()) {
            AppMethodBeat.o(133270);
            return false;
        }
        BannerModel aMT = BannerModel.aMT();
        if (aMT == null) {
            AppMethodBeat.o(133270);
            return false;
        } else if (aMT.appId.equals(operateTask.hQL) && aMT.har == operateTask.iKO) {
            a(aMT.appId, aMT.har, aMT.appName, aMT.haO, operateTask.iKP);
            AppMethodBeat.o(133270);
            return true;
        } else {
            AppMethodBeat.o(133270);
            return false;
        }
    }

    static void a(Intent intent, String str, int i, String str2, String str3, String str4) {
        AppMethodBeat.i(133271);
        if (intent == null) {
            AppMethodBeat.o(133271);
            return;
        }
        intent.putExtra(a.appId.wP(), str);
        intent.putExtra(a.versionType.wP(), i);
        intent.putExtra(a.appName.wP(), str2);
        intent.putExtra(a.iconURL.wP(), str3);
        intent.putExtra(a.customText.wP(), str4);
        AppMethodBeat.o(133271);
    }

    private static void a(String str, int i, String str2, String str3, String str4) {
        AppMethodBeat.i(133272);
        if (g.RK()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONArray.put(String.valueOf(i));
            jSONArray.put(str2);
            jSONArray.put(str3);
            jSONArray.put(bo.nullAsNil(str4));
            Object jSONArray2 = jSONArray.toString();
            synchronized (b.class) {
                try {
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC, jSONArray2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133272);
                }
            }
            return;
        }
        AppMethodBeat.o(133272);
    }

    private static Object[] aML() {
        AppMethodBeat.i(133273);
        if (g.RK()) {
            String str;
            synchronized (b.class) {
                try {
                    str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC, (Object) "");
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133273);
                }
            }
            if (bo.isNullOrNil(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != a.iKx) {
                    AppMethodBeat.o(133273);
                    return null;
                }
                Object[] objArr = new Object[a.iKx];
                for (int i = 0; i < a.iKx; i++) {
                    objArr[i] = jSONArray.optString(i, "");
                }
                objArr[a.versionType.ordinal()] = Integer.valueOf(bo.getInt((String) objArr[a.versionType.ordinal()], 0));
                AppMethodBeat.o(133273);
                return objArr;
            } catch (JSONException e) {
                AppMethodBeat.o(133273);
                return null;
            }
        }
        AppMethodBeat.o(133273);
        return null;
    }

    static BannerModel aMM() {
        AppMethodBeat.i(133274);
        Object[] aML = aML();
        if (aML == null) {
            AppMethodBeat.o(133274);
            return null;
        }
        BannerModel bannerModel = new BannerModel();
        bannerModel.appId = (String) aML[a.appId.ordinal()];
        bannerModel.har = ((Integer) aML[a.versionType.ordinal()]).intValue();
        bannerModel.appName = (String) aML[a.appName.ordinal()];
        bannerModel.haO = (String) aML[a.iconURL.ordinal()];
        bannerModel.iKV = (String) aML[a.customText.ordinal()];
        AppMethodBeat.o(133274);
        return bannerModel;
    }
}
