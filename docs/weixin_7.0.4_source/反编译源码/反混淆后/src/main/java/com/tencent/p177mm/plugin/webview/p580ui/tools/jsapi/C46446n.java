package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.n */
public final class C46446n {
    /* renamed from: a */
    public static void m87601a(C40281e c40281e, String str, C29945i c29945i) {
        AppMethodBeat.m2504i(9855);
        if (c40281e == null) {
            AppMethodBeat.m2505o(9855);
            return;
        }
        try {
            Bundle g = c40281e.mo6226g(145, null);
            if (g == null) {
                AppMethodBeat.m2505o(9855);
                return;
            }
            String[] stringArray = g.getStringArray("key_webview_apbrand_jsapi_report_args");
            if (stringArray == null || stringArray.length != 19) {
                AppMethodBeat.m2505o(9855);
                return;
            }
            stringArray[10] = str;
            stringArray[11] = C46446n.m87602b(str, c29945i);
            stringArray[12] = "true".equals(C46446n.m87600a(c29945i, "isSuccess")) ? "1" : "2";
            stringArray[13] = C46446n.m87600a(c29945i, "permissionValue");
            stringArray[14] = C46446n.m87600a(c29945i, "jsapiErrorCode");
            C7060h.pYm.mo8381e(14993, C46446n.m87603k(stringArray));
            AppMethodBeat.m2505o(9855);
        } catch (Exception e) {
            C4990ab.m7412e("kv_14993", String.valueOf(e));
            AppMethodBeat.m2505o(9855);
        }
    }

    /* renamed from: b */
    private static String m87602b(String str, C29945i c29945i) {
        AppMethodBeat.m2504i(9856);
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
                obj2 = c29945i.puc.get("package").toString();
                AppMethodBeat.m2505o(9856);
                return obj2;
            default:
                obj2 = "";
                AppMethodBeat.m2505o(9856);
                return obj2;
        }
    }

    /* renamed from: DA */
    private static String m87599DA(String str) {
        AppMethodBeat.m2504i(9858);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(9858);
            return str2;
        }
        try {
            str2 = C5046bo.nullAsNil(C18178q.encode(str));
            AppMethodBeat.m2505o(9858);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.m2505o(9858);
            return str2;
        }
    }

    /* renamed from: k */
    private static Object[] m87603k(Object[] objArr) {
        AppMethodBeat.m2504i(9859);
        if (objArr == null || objArr.length <= 0) {
            Object[] objArr2 = new Object[0];
            AppMethodBeat.m2505o(9859);
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
                obj = C46446n.m87599DA((String) obj);
            }
            int i3 = i2 + 1;
            objArr3[i2] = String.valueOf(obj);
            i++;
            i2 = i3;
        }
        AppMethodBeat.m2505o(9859);
        return objArr3;
    }

    /* renamed from: a */
    private static String m87600a(C29945i c29945i, String str) {
        AppMethodBeat.m2504i(9857);
        String str2;
        if (c29945i.uII == null || !c29945i.uII.containsKey(str)) {
            str2 = "";
            AppMethodBeat.m2505o(9857);
            return str2;
        }
        str2 = String.valueOf(c29945i.uII.get(str));
        AppMethodBeat.m2505o(9857);
        return str2;
    }
}
