package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONArray;

public final class f implements d {
    public final BaseDrawActionArg ayf() {
        AppMethodBeat.i(103188);
        DrawImageActionArg drawImageActionArg = new DrawImageActionArg();
        AppMethodBeat.o(103188);
        return drawImageActionArg;
    }

    public final String getMethod() {
        return "drawImage";
    }

    public final boolean a(d dVar, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103189);
        int length = jSONArray.length();
        if (length < 3) {
            AppMethodBeat.o(103189);
            return false;
        }
        boolean a = a(dVar, canvas, length, jSONArray.optString(0), g.d(jSONArray, 1), g.d(jSONArray, 2), g.d(jSONArray, 3), g.d(jSONArray, 4), jSONArray.optInt(5), jSONArray.optInt(6), jSONArray.optInt(7), jSONArray.optInt(8));
        AppMethodBeat.o(103189);
        return a;
    }

    public final boolean a(d dVar, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.i(103190);
        DrawImageActionArg drawImageActionArg = (DrawImageActionArg) drawActionArg;
        if (drawImageActionArg == null) {
            AppMethodBeat.o(103190);
            return false;
        }
        boolean a = a(dVar, canvas, drawImageActionArg.hcT, drawImageActionArg.url, drawImageActionArg.x, drawImageActionArg.y, drawImageActionArg.width, drawImageActionArg.height, drawImageActionArg.hcU, drawImageActionArg.hcV, drawImageActionArg.aIJ, drawImageActionArg.aIK);
        AppMethodBeat.o(103190);
        return a;
    }

    private boolean a(d dVar, Canvas canvas, int i, String str, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(103191);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(103191);
            return false;
        }
        float f5;
        float f6;
        Bitmap a;
        if (i < 5) {
            f5 = f2;
            f6 = f;
        } else if (f3 == 0.0f || f4 == 0.0f) {
            AppMethodBeat.o(103191);
            return true;
        } else {
            if (f3 < 0.0f) {
                f6 = f + f3;
                f3 = -f3;
            } else {
                f6 = f;
            }
            if (f4 < 0.0f) {
                f2 += f4;
                f4 = -f4;
                f5 = f2;
            } else {
                f5 = f2;
            }
        }
        float f7 = f6 + f3;
        float f8 = f5 + f4;
        if (i < 9) {
            a = dVar.hcK.a(dVar, str, new a() {
                public final void a(d dVar) {
                    AppMethodBeat.i(103187);
                    dVar.invalidate();
                    AppMethodBeat.o(103187);
                }
            });
            if (a == null || a.isRecycled()) {
                AppMethodBeat.o(103191);
                return false;
            }
            if (f3 == 0.0f) {
                f7 = ((float) g.qb(a.getWidth())) + f6;
            }
            if (f4 == 0.0f) {
                f8 = ((float) g.qb(a.getHeight())) + f5;
            }
        } else if (i4 == 0 || i5 == 0) {
            AppMethodBeat.o(103191);
            return true;
        } else {
            int i6;
            int i7;
            if (i4 < 0) {
                i6 = i2 + i4;
                i4 = -i4;
            } else {
                i6 = i2;
            }
            if (i5 < 0) {
                i7 = i3 + i5;
                i5 = -i5;
            } else {
                i7 = i3;
            }
            if (i6 + i4 <= 0 || i7 + i5 <= 0) {
                AppMethodBeat.o(103191);
                return true;
            }
            int i8 = i6 > 0 ? i6 : 0;
            int i9 = i7 > 0 ? i7 : 0;
            a = dVar.hcK.a(dVar, str, new Rect(i8, i9, i6 + i4, i7 + i5), new a() {
                public final void a(d dVar) {
                    AppMethodBeat.i(103186);
                    dVar.invalidate();
                    AppMethodBeat.o(103186);
                }
            });
            if (a == null || a.isRecycled()) {
                AppMethodBeat.o(103191);
                return false;
            }
            i6 = g.qb(i6);
            i7 = g.qb(i7);
            int qb = g.qb(i4);
            int qb2 = g.qb(i5);
            float f9 = f3 / ((float) qb);
            float f10 = f4 / ((float) qb2);
            f6 += ((float) (g.qb(i8) - i6)) * f9;
            f5 += ((float) (g.qb(i9) - i7)) * f10;
            f7 = f6 + (((float) g.qb(a.getWidth())) * f9);
            f8 = (((float) g.qb(a.getHeight())) * f10) + f5;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(f6, f5, f7, f8), dVar.hcF);
        AppMethodBeat.o(103191);
        return true;
    }
}
