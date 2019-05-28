package com.tencent.p177mm.plugin.appbrand.p328r;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.r.g */
public final class C42668g {
    private static DisplayMetrics iQY = C4996ah.getContext().getResources().getDisplayMetrics();

    static {
        AppMethodBeat.m2504i(91161);
        AppMethodBeat.m2505o(91161);
    }

    /* renamed from: n */
    public static int m75567n(JSONArray jSONArray) {
        int i = 0;
        AppMethodBeat.m2504i(91144);
        if (jSONArray == null || jSONArray.length() < 3) {
            AppMethodBeat.m2505o(91144);
        } else {
            if (jSONArray.length() == 3) {
                i = Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
            } else {
                i = Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
            }
            AppMethodBeat.m2505o(91144);
        }
        return i;
    }

    /* renamed from: by */
    public static int m75559by(String str, int i) {
        AppMethodBeat.m2504i(91145);
        try {
            i = C42668g.m75552Ef(str);
            AppMethodBeat.m2505o(91145);
        } catch (Exception e) {
            AppMethodBeat.m2505o(91145);
        }
        return i;
    }

    /* renamed from: Ee */
    public static int m75551Ee(String str) {
        AppMethodBeat.m2504i(91146);
        int by = C42668g.m75559by(str, 0);
        AppMethodBeat.m2505o(91146);
        return by;
    }

    /* renamed from: Ef */
    public static int m75552Ef(String str) {
        AppMethodBeat.m2504i(91147);
        IllegalArgumentException illegalArgumentException;
        int intValue;
        if (TextUtils.isEmpty(str)) {
            illegalArgumentException = new IllegalArgumentException("colorString isEmpty");
            AppMethodBeat.m2505o(91147);
            throw illegalArgumentException;
        } else if (C42667f.iQX.containsKey(str)) {
            intValue = ((Integer) C42667f.iQX.get(str)).intValue();
            AppMethodBeat.m2505o(91147);
            return intValue;
        } else if (str.charAt(0) == '#') {
            long parseLong;
            if (str.length() == 4) {
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.insert(2, str.charAt(1));
                stringBuilder.insert(4, str.charAt(2));
                stringBuilder.insert(6, str.charAt(3));
                str = stringBuilder.toString();
            }
            if (str.length() == 7) {
                parseLong = Long.parseLong(str.substring(1), 16) | -16777216;
            } else if (str.length() != 9) {
                C4990ab.m7409c("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", str);
                illegalArgumentException = new IllegalArgumentException("Unknown color");
                AppMethodBeat.m2505o(91147);
                throw illegalArgumentException;
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            intValue = (int) parseLong;
            AppMethodBeat.m2505o(91147);
            return intValue;
        } else {
            intValue = Color.parseColor(str);
            AppMethodBeat.m2505o(91147);
            return intValue;
        }
    }

    /* renamed from: pZ */
    public static int m75569pZ(int i) {
        AppMethodBeat.m2504i(91148);
        if (iQY == null) {
            AppMethodBeat.m2505o(91148);
            return i;
        }
        i = (int) Math.ceil((double) (((float) i) / iQY.density));
        AppMethodBeat.m2505o(91148);
        return i;
    }

    /* renamed from: qa */
    public static int m75570qa(int i) {
        return iQY == null ? i : (int) (((float) i) / iQY.density);
    }

    /* renamed from: au */
    public static float m75556au(float f) {
        return iQY == null ? f : f / iQY.density;
    }

    /* renamed from: qb */
    public static int m75571qb(int i) {
        return iQY == null ? i : (int) (iQY.density * ((float) i));
    }

    /* renamed from: av */
    public static float m75557av(float f) {
        return iQY == null ? f : f * iQY.density;
    }

    /* renamed from: f */
    public static int m75563f(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(91149);
        int a = C42668g.m75555a(jSONObject, str, 0);
        AppMethodBeat.m2505o(91149);
        return a;
    }

    /* renamed from: a */
    public static int m75555a(JSONObject jSONObject, String str, int i) {
        AppMethodBeat.m2504i(91150);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(91150);
        } else {
            try {
                i = Math.round(C42668g.m75557av((float) jSONObject.getDouble(str)));
                AppMethodBeat.m2505o(91150);
            } catch (Exception e) {
                AppMethodBeat.m2505o(91150);
            }
        }
        return i;
    }

    /* renamed from: g */
    public static int m75564g(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(91151);
        int round = Math.round(C42668g.m75557av((float) jSONObject.getDouble(str)));
        AppMethodBeat.m2505o(91151);
        return round;
    }

    /* renamed from: h */
    public static float m75565h(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(91152);
        float a = C42668g.m75553a(jSONObject, str, 0.0f);
        AppMethodBeat.m2505o(91152);
        return a;
    }

    /* renamed from: a */
    public static float m75553a(JSONObject jSONObject, String str, float f) {
        AppMethodBeat.m2504i(91153);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(91153);
        } else {
            try {
                f = C42668g.m75557av((float) jSONObject.optDouble(str, (double) f));
                AppMethodBeat.m2505o(91153);
            } catch (Exception e) {
                AppMethodBeat.m2505o(91153);
            }
        }
        return f;
    }

    /* renamed from: a */
    public static int m75554a(JSONArray jSONArray, int i) {
        AppMethodBeat.m2504i(91154);
        int b = C42668g.m75558b(jSONArray, i);
        AppMethodBeat.m2505o(91154);
        return b;
    }

    /* renamed from: b */
    private static int m75558b(JSONArray jSONArray, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(91155);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(91155);
        } else {
            try {
                i2 = Math.round(C42668g.m75557av((float) jSONArray.getDouble(i)));
                AppMethodBeat.m2505o(91155);
            } catch (Exception e) {
                AppMethodBeat.m2505o(91155);
            }
        }
        return i2;
    }

    /* renamed from: o */
    public static int m75568o(JSONArray jSONArray) {
        AppMethodBeat.m2504i(91156);
        int round = Math.round(C42668g.m75557av((float) jSONArray.getDouble(0)));
        AppMethodBeat.m2505o(91156);
        return round;
    }

    /* renamed from: i */
    public static float m75566i(JSONObject jSONObject, String str) {
        AppMethodBeat.m2504i(91157);
        float av = C42668g.m75557av((float) jSONObject.getDouble(str));
        AppMethodBeat.m2505o(91157);
        return av;
    }

    /* renamed from: c */
    public static float m75560c(JSONArray jSONArray, int i) {
        AppMethodBeat.m2504i(91158);
        float av = C42668g.m75557av((float) jSONArray.getDouble(i));
        AppMethodBeat.m2505o(91158);
        return av;
    }

    /* renamed from: d */
    public static float m75561d(JSONArray jSONArray, int i) {
        AppMethodBeat.m2504i(91159);
        float e = C42668g.m75562e(jSONArray, i);
        AppMethodBeat.m2505o(91159);
        return e;
    }

    /* renamed from: e */
    private static float m75562e(JSONArray jSONArray, int i) {
        float f = 0.0f;
        AppMethodBeat.m2504i(91160);
        if (jSONArray == null) {
            AppMethodBeat.m2505o(91160);
        } else {
            try {
                f = C42668g.m75557av((float) jSONArray.getDouble(i));
                AppMethodBeat.m2505o(91160);
            } catch (Exception e) {
                AppMethodBeat.m2505o(91160);
            }
        }
        return f;
    }

    public static float aNQ() {
        if (iQY == null) {
            return 1.0f;
        }
        return iQY.density;
    }
}
