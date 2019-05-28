package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.wxmm.v2helper;
import java.util.Map;
import org.json.JSONObject;

public final class f {
    private static double hOA = -85.0d;
    private static double hOB = -1000.0d;
    private static double hOC = -85.0d;
    private static double hOD = -1000.0d;

    enum a {
        GPS,
        NETWORK;

        static {
            AppMethodBeat.o(93888);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x0027, code skipped:
            if (r23 > 0.0d) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(double d, double d2, double d3, double d4, String str, double d5) {
        AppMethodBeat.i(93889);
        boolean z = false;
        if (a.GPS.name().equalsIgnoreCase(str)) {
            if (d5 == 0.0d) {
                z = false;
            }
        } else if (a.NETWORK.name().equalsIgnoreCase(str)) {
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
        AppMethodBeat.o(93889);
        return z;
    }

    public static double h(double d, double d2) {
        double d3;
        AppMethodBeat.i(93890);
        hOC = d;
        hOD = d2;
        if (hOA == -85.0d || hOB == -1000.0d) {
            d3 = 0.0d;
        } else {
            d3 = (Math.atan2(hOD - hOB, hOC - hOA) * 180.0d) / 3.141592d;
        }
        hOA = hOC;
        hOB = hOD;
        AppMethodBeat.o(93890);
        return d3;
    }

    public static float ap(float f) {
        if (f > 0.0f) {
            return f % 360.0f;
        }
        return (((float) ((((((int) f) * -1) / v2helper.VOIP_ENC_HEIGHT_LV1) + 1) * v2helper.VOIP_ENC_HEIGHT_LV1)) + f) % 360.0f;
    }

    public static String g(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(93891);
        int B = B(jSONObject);
        String str;
        if (B == -1) {
            str = "invalid_map_id";
            AppMethodBeat.o(93891);
            return str;
        }
        str = cVar.aBw() + "&" + B;
        AppMethodBeat.o(93891);
        return str;
    }

    public static int B(JSONObject jSONObject) {
        AppMethodBeat.i(93892);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.o(93892);
            return optInt;
        } catch (Exception e) {
            AppMethodBeat.o(93892);
            return -1;
        }
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        String str3;
        AppMethodBeat.i(93893);
        Object obj = map.get(str);
        if (obj instanceof String) {
            str3 = (String) obj;
        } else if (obj != null) {
            str3 = String.valueOf(obj);
        } else {
            str3 = null;
        }
        if (str3 != null) {
            AppMethodBeat.o(93893);
            return str3;
        }
        AppMethodBeat.o(93893);
        return str2;
    }

    public static int a(Map<String, Object> map, String str, int i) {
        AppMethodBeat.i(93894);
        Integer bv = bv(map.get(str));
        if (bv != null) {
            i = bv.intValue();
            AppMethodBeat.o(93894);
            return i;
        }
        AppMethodBeat.o(93894);
        return i;
    }

    private static Integer bv(Object obj) {
        AppMethodBeat.i(93895);
        Integer num;
        if (obj instanceof Integer) {
            num = (Integer) obj;
            AppMethodBeat.o(93895);
            return num;
        } else if (obj instanceof Number) {
            num = Integer.valueOf(((Number) obj).intValue());
            AppMethodBeat.o(93895);
            return num;
        } else {
            if (obj instanceof String) {
                try {
                    num = Integer.valueOf((int) Double.parseDouble((String) obj));
                    AppMethodBeat.o(93895);
                    return num;
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.o(93895);
            return null;
        }
    }
}
