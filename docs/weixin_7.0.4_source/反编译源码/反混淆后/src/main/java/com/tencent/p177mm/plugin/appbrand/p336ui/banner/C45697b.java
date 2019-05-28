package com.tencent.p177mm.plugin.appbrand.p336ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.OperateTask;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.b */
final class C45697b {

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.b$a */
    enum C19774a {
        appId,
        versionType,
        appName,
        iconURL,
        customText;
        
        static final int iKx = 0;

        static {
            iKx = C19774a.values().length;
            AppMethodBeat.m2505o(133268);
        }

        /* renamed from: wP */
        public final String mo35001wP() {
            AppMethodBeat.m2504i(133267);
            String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
            AppMethodBeat.m2505o(133267);
            return str;
        }
    }

    C45697b() {
    }

    /* renamed from: L */
    static boolean m84445L(Intent intent) {
        AppMethodBeat.m2504i(133269);
        if (intent == null) {
            AppMethodBeat.m2505o(133269);
            return false;
        }
        String stringExtra = intent.getStringExtra(C19774a.appId.mo35001wP());
        int intExtra = intent.getIntExtra(C19774a.versionType.mo35001wP(), 0);
        String stringExtra2 = intent.getStringExtra(C19774a.appName.mo35001wP());
        String stringExtra3 = intent.getStringExtra(C19774a.iconURL.mo35001wP());
        String stringExtra4 = intent.getStringExtra(C19774a.customText.mo35001wP());
        for (C19774a wP : C19774a.values()) {
            intent.removeExtra(wP.mo35001wP());
        }
        if (C5046bo.isNullOrNil(stringExtra) || C5046bo.isNullOrNil(stringExtra2)) {
            AppMethodBeat.m2505o(133269);
            return false;
        }
        C45697b.m84447a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4);
        AppMethodBeat.m2505o(133269);
        return true;
    }

    /* renamed from: a */
    static boolean m84448a(OperateTask operateTask) {
        AppMethodBeat.m2504i(133270);
        if (operateTask == null || !C1720g.m3531RK()) {
            AppMethodBeat.m2505o(133270);
            return false;
        }
        BannerModel aMT = BannerModel.aMT();
        if (aMT == null) {
            AppMethodBeat.m2505o(133270);
            return false;
        } else if (aMT.appId.equals(operateTask.hQL) && aMT.har == operateTask.iKO) {
            C45697b.m84447a(aMT.appId, aMT.har, aMT.appName, aMT.haO, operateTask.iKP);
            AppMethodBeat.m2505o(133270);
            return true;
        } else {
            AppMethodBeat.m2505o(133270);
            return false;
        }
    }

    /* renamed from: a */
    static void m84446a(Intent intent, String str, int i, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(133271);
        if (intent == null) {
            AppMethodBeat.m2505o(133271);
            return;
        }
        intent.putExtra(C19774a.appId.mo35001wP(), str);
        intent.putExtra(C19774a.versionType.mo35001wP(), i);
        intent.putExtra(C19774a.appName.mo35001wP(), str2);
        intent.putExtra(C19774a.iconURL.mo35001wP(), str3);
        intent.putExtra(C19774a.customText.mo35001wP(), str4);
        AppMethodBeat.m2505o(133271);
    }

    /* renamed from: a */
    private static void m84447a(String str, int i, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(133272);
        if (C1720g.m3531RK()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONArray.put(String.valueOf(i));
            jSONArray.put(str2);
            jSONArray.put(str3);
            jSONArray.put(C5046bo.nullAsNil(str4));
            Object jSONArray2 = jSONArray.toString();
            synchronized (C45697b.class) {
                try {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC, jSONArray2);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133272);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(133272);
    }

    private static Object[] aML() {
        AppMethodBeat.m2504i(133273);
        if (C1720g.m3531RK()) {
            String str;
            synchronized (C45697b.class) {
                try {
                    str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC, (Object) "");
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133273);
                }
            }
            if (C5046bo.isNullOrNil(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != C19774a.iKx) {
                    AppMethodBeat.m2505o(133273);
                    return null;
                }
                Object[] objArr = new Object[C19774a.iKx];
                for (int i = 0; i < C19774a.iKx; i++) {
                    objArr[i] = jSONArray.optString(i, "");
                }
                objArr[C19774a.versionType.ordinal()] = Integer.valueOf(C5046bo.getInt((String) objArr[C19774a.versionType.ordinal()], 0));
                AppMethodBeat.m2505o(133273);
                return objArr;
            } catch (JSONException e) {
                AppMethodBeat.m2505o(133273);
                return null;
            }
        }
        AppMethodBeat.m2505o(133273);
        return null;
    }

    static BannerModel aMM() {
        AppMethodBeat.m2504i(133274);
        Object[] aML = C45697b.aML();
        if (aML == null) {
            AppMethodBeat.m2505o(133274);
            return null;
        }
        BannerModel bannerModel = new BannerModel();
        bannerModel.appId = (String) aML[C19774a.appId.ordinal()];
        bannerModel.har = ((Integer) aML[C19774a.versionType.ordinal()]).intValue();
        bannerModel.appName = (String) aML[C19774a.appName.ordinal()];
        bannerModel.haO = (String) aML[C19774a.iconURL.ordinal()];
        bannerModel.iKV = (String) aML[C19774a.customText.ordinal()];
        AppMethodBeat.m2505o(133274);
        return bannerModel;
    }
}
