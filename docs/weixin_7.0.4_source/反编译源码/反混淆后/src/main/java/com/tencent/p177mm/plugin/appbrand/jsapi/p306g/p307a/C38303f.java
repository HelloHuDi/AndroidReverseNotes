package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.wxmm.v2helper;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.f */
public final class C38303f {
    private static double hOA = -85.0d;
    private static double hOB = -1000.0d;
    private static double hOC = -85.0d;
    private static double hOD = -1000.0d;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.f$a */
    enum C38302a {
        GPS,
        NETWORK;

        static {
            AppMethodBeat.m2505o(93888);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x0027, code skipped:
            if (r23 > 0.0d) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m64814a(double d, double d2, double d3, double d4, String str, double d5) {
        AppMethodBeat.m2504i(93889);
        boolean z = false;
        if (C38302a.GPS.name().equalsIgnoreCase(str)) {
            if (d5 == 0.0d) {
                z = false;
            }
        } else if (C38302a.NETWORK.name().equalsIgnoreCase(str)) {
            Object obj;
            if (d2 == -85.0d || d == -1000.0d) {
                obj = null;
            } else if (d3 == -1000.0d || d4 == -85.0d) {
                obj = null;
            } else {
                double d6 = (3.141592653589793d * d2) / 180.0d;
                double d7 = (3.141592653589793d * d4) / 180.0d;
                double d8 = ((d - d3) * 3.141592653589793d) / 180.0d;
                if (((double) (Math.round(((Math.asin(Math.sqrt(((Math.cos(d6) * Math.cos(d7)) * Math.pow(Math.sin(d8 / 2.0d), 2.0d)) + Math.pow(Math.sin((d6 - d7) / 2.0d), 2.0d))) * 2.0d) * 6378137.0d) * 10000.0d) / 10000)) >= 5.0d) {
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                z = false;
            }
            z = true;
        }
        AppMethodBeat.m2505o(93889);
        return z;
    }

    /* renamed from: h */
    public static double m64818h(double d, double d2) {
        double d3;
        AppMethodBeat.m2504i(93890);
        hOC = d;
        hOD = d2;
        if (hOA == -85.0d || hOB == -1000.0d) {
            d3 = 0.0d;
        } else {
            d3 = (Math.atan2(hOD - hOB, hOC - hOA) * 180.0d) / 3.141592d;
        }
        hOA = hOC;
        hOB = hOD;
        AppMethodBeat.m2505o(93890);
        return d3;
    }

    /* renamed from: ap */
    public static float m64815ap(float f) {
        if (f > 0.0f) {
            return f % 360.0f;
        }
        return (((float) ((((((int) f) * -1) / v2helper.VOIP_ENC_HEIGHT_LV1) + 1) * v2helper.VOIP_ENC_HEIGHT_LV1)) + f) % 360.0f;
    }

    /* renamed from: g */
    public static String m64817g(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(93891);
        int B = C38303f.m64811B(jSONObject);
        String str;
        if (B == -1) {
            str = "invalid_map_id";
            AppMethodBeat.m2505o(93891);
            return str;
        }
        str = c2241c.aBw() + "&" + B;
        AppMethodBeat.m2505o(93891);
        return str;
    }

    /* renamed from: B */
    public static int m64811B(JSONObject jSONObject) {
        AppMethodBeat.m2504i(93892);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.m2505o(93892);
            return optInt;
        } catch (Exception e) {
            AppMethodBeat.m2505o(93892);
            return -1;
        }
    }

    /* renamed from: a */
    public static String m64813a(Map<String, Object> map, String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(93893);
        Object obj = map.get(str);
        if (obj instanceof String) {
            str3 = (String) obj;
        } else if (obj != null) {
            str3 = String.valueOf(obj);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            AppMethodBeat.m2505o(93893);
            return str3;
        }
        AppMethodBeat.m2505o(93893);
        return str2;
    }

    /* renamed from: a */
    public static int m64812a(Map<String, Object> map, String str, int i) {
        AppMethodBeat.m2504i(93894);
        Integer bv = C38303f.m64816bv(map.get(str));
        if (bv != null) {
            i = bv.intValue();
            AppMethodBeat.m2505o(93894);
            return i;
        }
        AppMethodBeat.m2505o(93894);
        return i;
    }

    /* renamed from: bv */
    private static Integer m64816bv(Object obj) {
        AppMethodBeat.m2504i(93895);
        Integer num;
        if (obj instanceof Integer) {
            num = (Integer) obj;
            AppMethodBeat.m2505o(93895);
            return num;
        } else if (obj instanceof Number) {
            num = Integer.valueOf(((Number) obj).intValue());
            AppMethodBeat.m2505o(93895);
            return num;
        } else {
            if (obj instanceof String) {
                try {
                    num = Integer.valueOf((int) Double.parseDouble((String) obj));
                    AppMethodBeat.m2505o(93895);
                    return num;
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.m2505o(93895);
            return null;
        }
    }
}
