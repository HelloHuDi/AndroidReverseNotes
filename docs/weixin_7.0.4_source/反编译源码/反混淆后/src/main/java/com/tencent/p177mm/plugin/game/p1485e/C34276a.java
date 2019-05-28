package com.tencent.p177mm.plugin.game.p1485e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* renamed from: com.tencent.mm.plugin.game.e.a */
public final class C34276a {
    private static String ndY = "";

    /* renamed from: a */
    public static void m56204a(int i, int i2, int i3, long j, String str, String str2, long j2, long j3) {
        AppMethodBeat.m2504i(111685);
        C37860c.eBG.mo60578a(C45406d.m83611b(14683, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str, null, str2, Long.valueOf(j2), Long.valueOf(j3), null));
        AppMethodBeat.m2505o(111685);
    }

    /* renamed from: aL */
    public static void m56206aL(int i, String str) {
        AppMethodBeat.m2504i(111686);
        C45406d c45406d = new C45406d();
        c45406d.eBH = i;
        c45406d.eBI = str;
        C37860c.eBG.mo60578a(c45406d);
        AppMethodBeat.m2505o(111686);
    }

    /* renamed from: kY */
    public static String m56208kY(String str) {
        AppMethodBeat.m2504i(111687);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(111687);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            str2 = "";
            C4990ab.m7412e("MicroMsg.GameReportUtil", exception.getMessage());
        }
        AppMethodBeat.m2505o(111687);
        return str2;
    }

    /* renamed from: K */
    public static String m56201K(Map<String, String> map) {
        AppMethodBeat.m2504i(111688);
        String str;
        if (map.size() == 0) {
            str = "";
            AppMethodBeat.m2505o(111688);
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.GameReportUtil", e.getMessage());
                str = "";
                AppMethodBeat.m2505o(111688);
                return str;
            }
        }
        try {
            str = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            AppMethodBeat.m2505o(111688);
            return str;
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.GameReportUtil", e2.getMessage());
            str = "";
            AppMethodBeat.m2505o(111688);
            return str;
        }
    }

    /* renamed from: T */
    public static String m56203T(String str, String str2, String str3) {
        AppMethodBeat.m2504i(111689);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.GameReportUtil", e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = C34276a.m56207ez(str, jSONObject.toString());
        }
        String kY = C34276a.m56208kY(str);
        AppMethodBeat.m2505o(111689);
        return kY;
    }

    /* renamed from: ez */
    private static String m56207ez(String str, String str2) {
        AppMethodBeat.m2504i(111690);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111690);
            return str2;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str3 = (String) keys.next();
                        jSONObject2.put(str3, jSONObject.opt(str3));
                    } catch (Exception e2) {
                        str2 = "";
                        AppMethodBeat.m2505o(111690);
                        return str2;
                    }
                }
            }
            str2 = jSONObject2.toString();
            AppMethodBeat.m2505o(111690);
            return str2;
        } catch (JSONException e3) {
            str2 = "";
            AppMethodBeat.m2505o(111690);
            return str2;
        }
    }

    /* renamed from: Oh */
    public static void m56202Oh(String str) {
        ndY = str;
    }

    /* renamed from: a */
    public static void m56205a(Context context, int i, int i2, int i3, String str, int i4, String str2) {
        int i5;
        AppMethodBeat.m2504i(111684);
        C4990ab.m7416i("MicroMsg.GameReportUtil", "reportExposureInfo : " + i + " , " + i2 + " , " + i3 + " , 1 , 0 , " + C5046bo.nullAsNil(str) + " , " + i4 + " , 0 , " + C5046bo.nullAsNil(null) + " , " + C5046bo.nullAsNil(null) + " , " + C5046bo.nullAsNil(str2));
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[12];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = str;
        objArr[6] = Integer.valueOf(i4);
        objArr[7] = Integer.valueOf(0);
        objArr[8] = null;
        objArr[9] = Integer.valueOf(C5046bo.getInt(null, 0));
        if (!C5023at.is3G(context)) {
            if (!C5023at.is4G(context)) {
                switch (C5023at.getNetType(context)) {
                    case -1:
                        i5 = 255;
                        break;
                    case 0:
                        i5 = 1;
                        break;
                    case 5:
                        i5 = 2;
                        break;
                    case 6:
                        i5 = 3;
                        break;
                    default:
                        i5 = 6;
                        break;
                }
            }
            i5 = 5;
        } else {
            i5 = 4;
        }
        objArr[10] = Integer.valueOf(i5);
        objArr[11] = str2;
        c7060h.mo8381e(13384, objArr);
        AppMethodBeat.m2505o(111684);
    }
}
