package com.tencent.p177mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C33076av.C33079c;
import com.tencent.p177mm.plugin.appbrand.debugger.DebuggerShell.C38172a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.debugger.d */
public final class C46890d implements C33079c, C38172a {
    /* renamed from: u */
    public final void mo5821u(Map<String, String> map) {
        AppMethodBeat.m2504i(129943);
        if (DebuggerShell.ayT()) {
            String str = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
            String str2 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
            int i = C5046bo.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
            int i2 = C5046bo.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
            String str3 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
            String str4 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
            String str5 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
            String str6 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
            String str7 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
            String str8 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutCodeLibUrls");
            if (i < 0) {
                AppMethodBeat.m2505o(129943);
                return;
            }
            if (i != 0) {
                if (C42340f.auV() == null) {
                    AppMethodBeat.m2505o(129943);
                    return;
                } else if (C5046bo.isNullOrNil(str4) || C5046bo.isNullOrNil(str5)) {
                    AppMethodBeat.m2505o(129943);
                    return;
                } else if (C42340f.auV().mo60848a(str, i, str4, str5, C5046bo.anT(), C5046bo.anT() + 432000)) {
                    C45694h.m84422bt(str, i);
                }
            }
            C4990ab.m7417i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", str2, str, Integer.valueOf(i));
            C32628se c32628se = new C32628se();
            c32628se.cOf.appId = str;
            c32628se.cOf.userName = str2;
            c32628se.cOf.cOi = i;
            c32628se.cOf.cOh = str3;
            c32628se.cOf.axy = i2;
            c32628se.cOf.cOj = str4;
            c32628se.cOf.cOk = str5;
            c32628se.cOf.cOl = false;
            c32628se.cOf.scene = 1030;
            c32628se.cOf.cOn.fpI = str6;
            final String str9 = str;
            final String str10 = str7;
            final int i3 = i;
            final String str11 = str8;
            c32628se.cOf.cOp = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(129942);
                    String str = str9;
                    String str2 = str10;
                    int i = i3;
                    if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        try {
                            JSONObject lw = C41725h.m73457lw(str2);
                            Iterator keys = lw.keys();
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                C31281at a = C42340f.auV().mo60841a(new C10100y(str, str3).toString(), 0, i, new String[0]);
                                if (a != null) {
                                    a.field_downloadURL = lw.optString(str3);
                                    C42340f.auV().mo60861c(a);
                                }
                            }
                        } catch (Throwable th) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrand.ForceOpenAppNotify", th, "processSubUrlsAndSave appId[%s], json[%s]", str, str2);
                        }
                    }
                    str2 = str9;
                    String str4 = str11;
                    int i2 = i3;
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
                        AppMethodBeat.m2505o(129942);
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(str4);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            int optInt = jSONObject.optInt("pkgType");
                            String optString = jSONObject.optString("url");
                            C10100y c10100y = null;
                            if (optInt == 12) {
                                c10100y = new C10100y(str2, "__WITHOUT_CODELIB__", optInt);
                            } else if (optInt == 13) {
                                c10100y = new C10100y(str2, jSONObject.getString("moduleName"), optInt);
                            }
                            C31281at a2 = C42340f.auV().mo60841a(c10100y.toString(), 0, i2, new String[0]);
                            if (a2 != null) {
                                a2.field_downloadURL = optString;
                                C42340f.auV().mo60861c(a2);
                            }
                        }
                        AppMethodBeat.m2505o(129942);
                    } catch (Throwable th2) {
                        C4990ab.printErrStackTrace("MicroMsg.AppBrand.ForceOpenAppNotify", th2, "processWithoutCodeLibUrlsAndSave withoutCodeLibUrls[%s]", str4);
                        AppMethodBeat.m2505o(129942);
                    }
                }
            };
            C4879a.xxA.mo10055m(c32628se);
        }
        AppMethodBeat.m2505o(129943);
    }

    public final String name() {
        return "ForceOpenAppNotify";
    }

    /* renamed from: A */
    public final void mo21580A(Intent intent) {
        AppMethodBeat.m2504i(129944);
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra("versionType", 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1030;
        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(null, null, stringExtra, intExtra, 0, null, appBrandStatObject);
        AppMethodBeat.m2505o(129944);
    }
}
