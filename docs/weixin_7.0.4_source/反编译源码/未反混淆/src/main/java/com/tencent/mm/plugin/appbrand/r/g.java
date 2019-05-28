package com.tencent.mm.plugin.appbrand.r;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g {
    private static DisplayMetrics iQY = ah.getContext().getResources().getDisplayMetrics();

    static {
        AppMethodBeat.i(91161);
        AppMethodBeat.o(91161);
    }

    public static int n(JSONArray jSONArray) {
        int i = 0;
        AppMethodBeat.i(91144);
        if (jSONArray == null || jSONArray.length() < 3) {
            AppMethodBeat.o(91144);
        } else {
            if (jSONArray.length() == 3) {
                i = Color.rgb(jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
            } else {
                i = Color.argb(jSONArray.optInt(3) & 255, jSONArray.optInt(0) & 255, jSONArray.optInt(1) & 255, jSONArray.optInt(2) & 255);
            }
            AppMethodBeat.o(91144);
        }
        return i;
    }

    public static int by(String str, int i) {
        AppMethodBeat.i(91145);
        try {
            i = Ef(str);
            AppMethodBeat.o(91145);
        } catch (Exception e) {
            AppMethodBeat.o(91145);
        }
        return i;
    }

    public static int Ee(String str) {
        AppMethodBeat.i(91146);
        int by = by(str, 0);
        AppMethodBeat.o(91146);
        return by;
    }

    public static int Ef(String str) {
        AppMethodBeat.i(91147);
        IllegalArgumentException illegalArgumentException;
        int intValue;
        if (TextUtils.isEmpty(str)) {
            illegalArgumentException = new IllegalArgumentException("colorString isEmpty");
            AppMethodBeat.o(91147);
            throw illegalArgumentException;
        } else if (f.iQX.containsKey(str)) {
            intValue = ((Integer) f.iQX.get(str)).intValue();
            AppMethodBeat.o(91147);
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
                ab.c("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", str);
                illegalArgumentException = new IllegalArgumentException("Unknown color");
                AppMethodBeat.o(91147);
                throw illegalArgumentException;
            } else {
                parseLong = Long.parseLong(str.substring(1, 7), 16) | (Long.parseLong(str.substring(7, 9), 16) << 24);
            }
            intValue = (int) parseLong;
            AppMethodBeat.o(91147);
            return intValue;
        } else {
            intValue = Color.parseColor(str);
            AppMethodBeat.o(91147);
            return intValue;
        }
    }

    public static int pZ(int i) {
        AppMethodBeat.i(91148);
        if (iQY == null) {
            AppMethodBeat.o(91148);
            return i;
        }
        i = (int) Math.ceil((double) (((float) i) / iQY.density));
        AppMethodBeat.o(91148);
        return i;
    }

    public static int qa(int i) {
        return iQY == null ? i : (int) (((float) i) / iQY.density);
    }

    public static float au(float f) {
        return iQY == null ? f : f / iQY.density;
    }

    public static int qb(int i) {
        return iQY == null ? i : (int) (iQY.density * ((float) i));
    }

    public static float av(float f) {
        return iQY == null ? f : f * iQY.density;
    }

    public static int f(JSONObject jSONObject, String str) {
        AppMethodBeat.i(91149);
        int a = a(jSONObject, str, 0);
        AppMethodBeat.o(91149);
        return a;
    }

    public static int a(JSONObject jSONObject, String str, int i) {
        AppMethodBeat.i(91150);
        if (jSONObject == null) {
            AppMethodBeat.o(91150);
        } else {
            try {
                i = Math.round(av((float) jSONObject.getDouble(str)));
                AppMethodBeat.o(91150);
            } catch (Exception e) {
                AppMethodBeat.o(91150);
            }
        }
        return i;
    }

    public static int g(JSONObject jSONObject, String str) {
        AppMethodBeat.i(91151);
        int round = Math.round(av((float) jSONObject.getDouble(str)));
        AppMethodBeat.o(91151);
        return round;
    }

    public static float h(JSONObject jSONObject, String str) {
        AppMethodBeat.i(91152);
        float a = a(jSONObject, str, 0.0f);
        AppMethodBeat.o(91152);
        return a;
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        AppMethodBeat.i(91153);
        if (jSONObject == null) {
            AppMethodBeat.o(91153);
        } else {
            try {
                f = av((float) jSONObject.optDouble(str, (double) f));
                AppMethodBeat.o(91153);
            } catch (Exception e) {
                AppMethodBeat.o(91153);
            }
        }
        return f;
    }

    public static int a(JSONArray jSONArray, int i) {
        AppMethodBeat.i(91154);
        int b = b(jSONArray, i);
        AppMethodBeat.o(91154);
        return b;
    }

    private static int b(JSONArray jSONArray, int i) {
        int i2 = 0;
        AppMethodBeat.i(91155);
        if (jSONArray == null) {
            AppMethodBeat.o(91155);
        } else {
            try {
                i2 = Math.round(av((float) jSONArray.getDouble(i)));
                AppMethodBeat.o(91155);
            } catch (Exception e) {
                AppMethodBeat.o(91155);
            }
        }
        return i2;
    }

    public static int o(JSONArray jSONArray) {
        AppMethodBeat.i(91156);
        int round = Math.round(av((float) jSONArray.getDouble(0)));
        AppMethodBeat.o(91156);
        return round;
    }

    public static float i(JSONObject jSONObject, String str) {
        AppMethodBeat.i(91157);
        float av = av((float) jSONObject.getDouble(str));
        AppMethodBeat.o(91157);
        return av;
    }

    public static float c(JSONArray jSONArray, int i) {
        AppMethodBeat.i(91158);
        float av = av((float) jSONArray.getDouble(i));
        AppMethodBeat.o(91158);
        return av;
    }

    public static float d(JSONArray jSONArray, int i) {
        AppMethodBeat.i(91159);
        float e = e(jSONArray, i);
        AppMethodBeat.o(91159);
        return e;
    }

    private static float e(JSONArray jSONArray, int i) {
        float f = 0.0f;
        AppMethodBeat.i(91160);
        if (jSONArray == null) {
            AppMethodBeat.o(91160);
        } else {
            try {
                f = av((float) jSONArray.getDouble(i));
                AppMethodBeat.o(91160);
            } catch (Exception e) {
                AppMethodBeat.o(91160);
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
