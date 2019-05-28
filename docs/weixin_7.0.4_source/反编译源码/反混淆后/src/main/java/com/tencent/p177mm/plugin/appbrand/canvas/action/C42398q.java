package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.SetFillStyleActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.q */
public final class C42398q implements C10155d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103231);
        SetFillStyleActionArg setFillStyleActionArg = new SetFillStyleActionArg();
        AppMethodBeat.m2505o(103231);
        return setFillStyleActionArg;
    }

    public final String getMethod() {
        return "setFillStyle";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103232);
        if (jSONArray.length() < 2) {
            AppMethodBeat.m2505o(103232);
            return false;
        }
        String optString = jSONArray.optString(0);
        C10148a c10148a = c2102d.hcF;
        JSONArray optJSONArray;
        float d;
        float d2;
        float d3;
        JSONArray optJSONArray2;
        int i;
        if ("linear".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.m2505o(103232);
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                AppMethodBeat.m2505o(103232);
                return false;
            }
            d = C42668g.m75561d(optJSONArray, 0);
            d2 = C42668g.m75561d(optJSONArray, 1);
            d3 = C42668g.m75561d(optJSONArray, 2);
            float d4 = C42668g.m75561d(optJSONArray, 3);
            optJSONArray2 = jSONArray.optJSONArray(2);
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                AppMethodBeat.m2505o(103232);
                return false;
            }
            int[] iArr = new int[optJSONArray2.length()];
            float[] fArr = new float[optJSONArray2.length()];
            for (i = 0; i < optJSONArray2.length(); i++) {
                JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
                if (optJSONArray3.length() >= 2) {
                    fArr[i] = (float) optJSONArray3.optDouble(0);
                    iArr[i] = C42668g.m75567n(optJSONArray3.optJSONArray(1));
                }
            }
            c10148a.setShader(new LinearGradient(d, d2, d3, d4, iArr, fArr, TileMode.CLAMP));
        } else if ("radial".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                AppMethodBeat.m2505o(103232);
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 3) {
                AppMethodBeat.m2505o(103232);
                return false;
            }
            d = C42668g.m75561d(optJSONArray, 0);
            d2 = C42668g.m75561d(optJSONArray, 1);
            d3 = C42668g.m75561d(optJSONArray, 2);
            if (d3 <= 0.0f) {
                C45124d.m82930i("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", Float.valueOf(d3));
                AppMethodBeat.m2505o(103232);
                return false;
            }
            JSONArray optJSONArray4 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray4.length()];
            float[] fArr2 = new float[optJSONArray4.length()];
            for (i = 0; i < optJSONArray4.length(); i++) {
                optJSONArray2 = optJSONArray4.optJSONArray(i);
                if (optJSONArray2.length() >= 2) {
                    fArr2[i] = (float) optJSONArray2.optDouble(0);
                    iArr2[i] = C42668g.m75567n(optJSONArray2.optJSONArray(1));
                }
            }
            c10148a.setShader(new RadialGradient(d, d2, d3, iArr2, fArr2, TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                AppMethodBeat.m2505o(103232);
                return false;
            }
            c10148a.setShader(null);
            c10148a.setColor(C42668g.m75567n(optJSONArray));
        } else if ("pattern".equalsIgnoreCase(optString)) {
            optString = jSONArray.optString(1);
            String optString2 = jSONArray.optString(2);
            if (C5046bo.isNullOrNil(optString)) {
                C45124d.m82933w("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
                AppMethodBeat.m2505o(103232);
                return false;
            }
            Bitmap a = c2102d.hcK.mo5910a(c2102d, optString);
            if (!(a == null || a.isRecycled())) {
                Shader bitmapShader;
                int qb = C42668g.m75571qb(a.getWidth());
                int qb2 = C42668g.m75571qb(a.getHeight());
                Object obj = -1;
                switch (optString2.hashCode()) {
                    case -934531685:
                        if (optString2.equals("repeat")) {
                            obj = null;
                            break;
                        }
                        break;
                    case -724648153:
                        if (optString2.equals("no-repeat")) {
                            obj = 3;
                            break;
                        }
                        break;
                    case -436782906:
                        if (optString2.equals("repeat-x")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -436782905:
                        if (optString2.equals("repeat-y")) {
                            obj = 2;
                            break;
                        }
                        break;
                }
                Bitmap createScaledBitmap;
                TileMode tileMode;
                switch (obj) {
                    case null:
                        createScaledBitmap = Bitmap.createScaledBitmap(a, qb, qb2, false);
                        tileMode = TileMode.REPEAT;
                        bitmapShader = new BitmapShader(createScaledBitmap, tileMode, tileMode);
                        break;
                    case 1:
                        createScaledBitmap = Bitmap.createBitmap(qb, qb2 + 1, Config.ARGB_8888);
                        new Canvas(createScaledBitmap).drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, (float) qb, (float) qb2), null);
                        bitmapShader = new BitmapShader(createScaledBitmap, TileMode.REPEAT, TileMode.CLAMP);
                        break;
                    case 2:
                        createScaledBitmap = Bitmap.createBitmap(qb + 1, qb2, Config.ARGB_8888);
                        new Canvas(createScaledBitmap).drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, (float) qb, (float) qb2), null);
                        bitmapShader = new BitmapShader(createScaledBitmap, TileMode.CLAMP, TileMode.REPEAT);
                        break;
                    case 3:
                        createScaledBitmap = Bitmap.createBitmap(qb + 1, qb2 + 1, Config.ARGB_8888);
                        new Canvas(createScaledBitmap).drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(0.0f, 0.0f, (float) qb, (float) qb2), null);
                        tileMode = TileMode.CLAMP;
                        bitmapShader = new BitmapShader(createScaledBitmap, tileMode, tileMode);
                        break;
                    default:
                        bitmapShader = null;
                        break;
                }
                c10148a.setShader(bitmapShader);
            }
        }
        AppMethodBeat.m2505o(103232);
        return true;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103233);
        SetFillStyleActionArg setFillStyleActionArg = (SetFillStyleActionArg) drawActionArg;
        if (setFillStyleActionArg == null) {
            AppMethodBeat.m2505o(103233);
            return false;
        }
        boolean a = setFillStyleActionArg.mo21512a(c2102d, canvas);
        AppMethodBeat.m2505o(103233);
        return a;
    }
}
