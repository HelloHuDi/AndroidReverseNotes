package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.C2103e.C2104a;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawImageActionArg;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.f */
public final class C38147f implements C10155d {

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.f$1 */
    class C191471 implements C2104a {
        C191471() {
        }

        /* renamed from: a */
        public final void mo5913a(C2102d c2102d) {
            AppMethodBeat.m2504i(103186);
            c2102d.invalidate();
            AppMethodBeat.m2505o(103186);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.f$2 */
    class C381462 implements C2104a {
        C381462() {
        }

        /* renamed from: a */
        public final void mo5913a(C2102d c2102d) {
            AppMethodBeat.m2504i(103187);
            c2102d.invalidate();
            AppMethodBeat.m2505o(103187);
        }
    }

    public final BaseDrawActionArg ayf() {
        AppMethodBeat.m2504i(103188);
        DrawImageActionArg drawImageActionArg = new DrawImageActionArg();
        AppMethodBeat.m2505o(103188);
        return drawImageActionArg;
    }

    public final String getMethod() {
        return "drawImage";
    }

    /* renamed from: a */
    public final boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103189);
        int length = jSONArray.length();
        if (length < 3) {
            AppMethodBeat.m2505o(103189);
            return false;
        }
        boolean a = m64548a(c2102d, canvas, length, jSONArray.optString(0), C42668g.m75561d(jSONArray, 1), C42668g.m75561d(jSONArray, 2), C42668g.m75561d(jSONArray, 3), C42668g.m75561d(jSONArray, 4), jSONArray.optInt(5), jSONArray.optInt(6), jSONArray.optInt(7), jSONArray.optInt(8));
        AppMethodBeat.m2505o(103189);
        return a;
    }

    /* renamed from: a */
    public final boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg) {
        AppMethodBeat.m2504i(103190);
        DrawImageActionArg drawImageActionArg = (DrawImageActionArg) drawActionArg;
        if (drawImageActionArg == null) {
            AppMethodBeat.m2505o(103190);
            return false;
        }
        boolean a = m64548a(c2102d, canvas, drawImageActionArg.hcT, drawImageActionArg.url, drawImageActionArg.f13669x, drawImageActionArg.f13670y, drawImageActionArg.width, drawImageActionArg.height, drawImageActionArg.hcU, drawImageActionArg.hcV, drawImageActionArg.aIJ, drawImageActionArg.aIK);
        AppMethodBeat.m2505o(103190);
        return a;
    }

    /* renamed from: a */
    private boolean m64548a(C2102d c2102d, Canvas canvas, int i, String str, float f, float f2, float f3, float f4, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(103191);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(103191);
            return false;
        }
        float f5;
        float f6;
        Bitmap a;
        if (i < 5) {
            f5 = f2;
            f6 = f;
        } else if (f3 == 0.0f || f4 == 0.0f) {
            AppMethodBeat.m2505o(103191);
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
            a = c2102d.hcK.mo5912a(c2102d, str, new C381462());
            if (a == null || a.isRecycled()) {
                AppMethodBeat.m2505o(103191);
                return false;
            }
            if (f3 == 0.0f) {
                f7 = ((float) C42668g.m75571qb(a.getWidth())) + f6;
            }
            if (f4 == 0.0f) {
                f8 = ((float) C42668g.m75571qb(a.getHeight())) + f5;
            }
        } else if (i4 == 0 || i5 == 0) {
            AppMethodBeat.m2505o(103191);
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
                AppMethodBeat.m2505o(103191);
                return true;
            }
            int i8 = i6 > 0 ? i6 : 0;
            int i9 = i7 > 0 ? i7 : 0;
            a = c2102d.hcK.mo5911a(c2102d, str, new Rect(i8, i9, i6 + i4, i7 + i5), new C191471());
            if (a == null || a.isRecycled()) {
                AppMethodBeat.m2505o(103191);
                return false;
            }
            i6 = C42668g.m75571qb(i6);
            i7 = C42668g.m75571qb(i7);
            int qb = C42668g.m75571qb(i4);
            int qb2 = C42668g.m75571qb(i5);
            float f9 = f3 / ((float) qb);
            float f10 = f4 / ((float) qb2);
            f6 += ((float) (C42668g.m75571qb(i8) - i6)) * f9;
            f5 += ((float) (C42668g.m75571qb(i9) - i7)) * f10;
            f7 = f6 + (((float) C42668g.m75571qb(a.getWidth())) * f9);
            f8 = (((float) C42668g.m75571qb(a.getHeight())) * f10) + f5;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawBitmap(a, new Rect(0, 0, a.getWidth(), a.getHeight()), new RectF(f6, f5, f7, f8), c2102d.hcF);
        AppMethodBeat.m2505o(103191);
        return true;
    }
}
