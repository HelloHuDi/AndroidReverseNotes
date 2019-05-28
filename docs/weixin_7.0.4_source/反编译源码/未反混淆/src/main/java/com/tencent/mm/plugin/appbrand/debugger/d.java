package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.se;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.av.c;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements c, a {
    public final void u(Map<String, String> map) {
        AppMethodBeat.i(129943);
        if (DebuggerShell.ayT()) {
            String str = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
            String str2 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
            int i = bo.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
            int i2 = bo.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
            String str3 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
            String str4 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
            String str5 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
            String str6 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
            String str7 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
            String str8 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutCodeLibUrls");
            if (i < 0) {
                AppMethodBeat.o(129943);
                return;
            }
            if (i != 0) {
                if (f.auV() == null) {
                    AppMethodBeat.o(129943);
                    return;
                } else if (bo.isNullOrNil(str4) || bo.isNullOrNil(str5)) {
                    AppMethodBeat.o(129943);
                    return;
                } else if (f.auV().a(str, i, str4, str5, bo.anT(), bo.anT() + 432000)) {
                    h.bt(str, i);
                }
            }
            ab.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", str2, str, Integer.valueOf(i));
            se seVar = new se();
            seVar.cOf.appId = str;
            seVar.cOf.userName = str2;
            seVar.cOf.cOi = i;
            seVar.cOf.cOh = str3;
            seVar.cOf.axy = i2;
            seVar.cOf.cOj = str4;
            seVar.cOf.cOk = str5;
            seVar.cOf.cOl = false;
            seVar.cOf.scene = 1030;
            seVar.cOf.cOn.fpI = str6;
            final String str9 = str;
            final String str10 = str7;
            final int i3 = i;
            final String str11 = str8;
            seVar.cOf.cOp = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(129942);
                    String str = str9;
                    String str2 = str10;
                    int i = i3;
                    if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        try {
                            JSONObject lw = com.tencent.mm.aa.h.lw(str2);
                            Iterator keys = lw.keys();
                            while (keys.hasNext()) {
                                String str3 = (String) keys.next();
                                at a = f.auV().a(new y(str, str3).toString(), 0, i, new String[0]);
                                if (a != null) {
                                    a.field_downloadURL = lw.optString(str3);
                                    f.auV().c(a);
                                }
                            }
                        } catch (Throwable th) {
                            ab.printErrStackTrace("MicroMsg.AppBrand.ForceOpenAppNotify", th, "processSubUrlsAndSave appId[%s], json[%s]", str, str2);
                        }
                    }
                    str2 = str9;
                    String str4 = str11;
                    int i2 = i3;
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4)) {
                        AppMethodBeat.o(129942);
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(str4);
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            int optInt = jSONObject.optInt("pkgType");
                            String optString = jSONObject.optString("url");
                            y yVar = null;
                            if (optInt == 12) {
                                yVar = new y(str2, "__WITHOUT_CODELIB__", optInt);
                            } else if (optInt == 13) {
                                yVar = new y(str2, jSONObject.getString("moduleName"), optInt);
                            }
                            at a2 = f.auV().a(yVar.toString(), 0, i2, new String[0]);
                            if (a2 != null) {
                                a2.field_downloadURL = optString;
                                f.auV().c(a2);
                            }
                        }
                        AppMethodBeat.o(129942);
                    } catch (Throwable th2) {
                        ab.printErrStackTrace("MicroMsg.AppBrand.ForceOpenAppNotify", th2, "processWithoutCodeLibUrlsAndSave withoutCodeLibUrls[%s]", str4);
                        AppMethodBeat.o(129942);
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xxA.m(seVar);
        }
        AppMethodBeat.o(129943);
    }

    public final String name() {
        return "ForceOpenAppNotify";
    }

    public final void A(Intent intent) {
        AppMethodBeat.i(129944);
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra("versionType", 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1030;
        ((e) g.K(e.class)).a(null, null, stringExtra, intExtra, 0, null, appBrandStatObject);
        AppMethodBeat.o(129944);
    }
}
