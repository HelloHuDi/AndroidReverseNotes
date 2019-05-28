package com.tencent.mm.plugin.game.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.game.report.api.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public final class a {
    private static String ndY = "";

    public static void a(int i, int i2, int i3, long j, String str, String str2, long j2, long j3) {
        AppMethodBeat.i(111685);
        c.eBG.a(d.b(14683, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str, null, str2, Long.valueOf(j2), Long.valueOf(j3), null));
        AppMethodBeat.o(111685);
    }

    public static void aL(int i, String str) {
        AppMethodBeat.i(111686);
        d dVar = new d();
        dVar.eBH = i;
        dVar.eBI = str;
        c.eBG.a(dVar);
        AppMethodBeat.o(111686);
    }

    public static String kY(String str) {
        AppMethodBeat.i(111687);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(111687);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Exception exception = e;
            str2 = "";
            ab.e("MicroMsg.GameReportUtil", exception.getMessage());
        }
        AppMethodBeat.o(111687);
        return str2;
    }

    public static String K(Map<String, String> map) {
        AppMethodBeat.i(111688);
        String str;
        if (map.size() == 0) {
            str = "";
            AppMethodBeat.o(111688);
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : map.entrySet()) {
            try {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Exception e) {
                ab.e("MicroMsg.GameReportUtil", e.getMessage());
                str = "";
                AppMethodBeat.o(111688);
                return str;
            }
        }
        try {
            str = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            AppMethodBeat.o(111688);
            return str;
        } catch (Exception e2) {
            ab.e("MicroMsg.GameReportUtil", e2.getMessage());
            str = "";
            AppMethodBeat.o(111688);
            return str;
        }
    }

    public static String T(String str, String str2, String str3) {
        AppMethodBeat.i(111689);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str2, str3);
        } catch (Exception e) {
            ab.e("MicroMsg.GameReportUtil", e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = ez(str, jSONObject.toString());
        }
        String kY = kY(str);
        AppMethodBeat.o(111689);
        return kY;
    }

    private static String ez(String str, String str2) {
        AppMethodBeat.i(111690);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111690);
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
                        AppMethodBeat.o(111690);
                        return str2;
                    }
                }
            }
            str2 = jSONObject2.toString();
            AppMethodBeat.o(111690);
            return str2;
        } catch (JSONException e3) {
            str2 = "";
            AppMethodBeat.o(111690);
            return str2;
        }
    }

    public static void Oh(String str) {
        ndY = str;
    }

    public static void a(Context context, int i, int i2, int i3, String str, int i4, String str2) {
        int i5;
        AppMethodBeat.i(111684);
        ab.i("MicroMsg.GameReportUtil", "reportExposureInfo : " + i + " , " + i2 + " , " + i3 + " , 1 , 0 , " + bo.nullAsNil(str) + " , " + i4 + " , 0 , " + bo.nullAsNil(null) + " , " + bo.nullAsNil(null) + " , " + bo.nullAsNil(str2));
        h hVar = h.pYm;
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
        objArr[9] = Integer.valueOf(bo.getInt(null, 0));
        if (!at.is3G(context)) {
            if (!at.is4G(context)) {
                switch (at.getNetType(context)) {
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
        hVar.e(13384, objArr);
        AppMethodBeat.o(111684);
    }
}
