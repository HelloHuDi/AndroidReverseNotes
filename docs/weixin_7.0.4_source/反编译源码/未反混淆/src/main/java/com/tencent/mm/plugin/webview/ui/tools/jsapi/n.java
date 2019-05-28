package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class n {
    public static void a(e eVar, String str, i iVar) {
        AppMethodBeat.i(9855);
        if (eVar == null) {
            AppMethodBeat.o(9855);
            return;
        }
        try {
            Bundle g = eVar.g(145, null);
            if (g == null) {
                AppMethodBeat.o(9855);
                return;
            }
            String[] stringArray = g.getStringArray("key_webview_apbrand_jsapi_report_args");
            if (stringArray == null || stringArray.length != 19) {
                AppMethodBeat.o(9855);
                return;
            }
            stringArray[10] = str;
            stringArray[11] = b(str, iVar);
            stringArray[12] = "true".equals(a(iVar, "isSuccess")) ? "1" : "2";
            stringArray[13] = a(iVar, "permissionValue");
            stringArray[14] = a(iVar, "jsapiErrorCode");
            h.pYm.e(14993, k(stringArray));
            AppMethodBeat.o(9855);
        } catch (Exception e) {
            ab.e("kv_14993", String.valueOf(e));
            AppMethodBeat.o(9855);
        }
    }

    private static String b(String str, i iVar) {
        AppMethodBeat.i(9856);
        Object obj = -1;
        switch (str.hashCode()) {
            case -1008737020:
                if (str.equals("getBrandWCPayRequest")) {
                    obj = null;
                    break;
                }
                break;
        }
        String obj2;
        switch (obj) {
            case null:
                obj2 = iVar.puc.get("package").toString();
                AppMethodBeat.o(9856);
                return obj2;
            default:
                obj2 = "";
                AppMethodBeat.o(9856);
                return obj2;
        }
    }

    private static String DA(String str) {
        AppMethodBeat.i(9858);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(9858);
            return str2;
        }
        try {
            str2 = bo.nullAsNil(q.encode(str));
            AppMethodBeat.o(9858);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.o(9858);
            return str2;
        }
    }

    private static Object[] k(Object[] objArr) {
        AppMethodBeat.i(9859);
        if (objArr == null || objArr.length <= 0) {
            Object[] objArr2 = new Object[0];
            AppMethodBeat.o(9859);
            return objArr2;
        }
        Object[] objArr3 = new Object[objArr.length];
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj == null) {
                obj = "";
            } else if ((obj instanceof String) && (((String) obj).contains(",") || ((String) obj).contains("/"))) {
                obj = DA((String) obj);
            }
            int i3 = i2 + 1;
            objArr3[i2] = String.valueOf(obj);
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(9859);
        return objArr3;
    }

    private static String a(i iVar, String str) {
        AppMethodBeat.i(9857);
        String str2;
        if (iVar.uII == null || !iVar.uII.containsKey(str)) {
            str2 = "";
            AppMethodBeat.o(9857);
            return str2;
        }
        str2 = String.valueOf(iVar.uII.get(str));
        AppMethodBeat.o(9857);
        return str2;
    }
}
