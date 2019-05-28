package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.p069v7.widget.C41537ar.C8471a;

/* renamed from: android.support.v7.widget.s */
class C6261s implements C0726u {
    final RectF agY = new RectF();

    /* renamed from: android.support.v7.widget.s$1 */
    class C62621 implements C8471a {
        C62621() {
        }

        /* renamed from: a */
        public final void mo14403a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                C6261s.this.agY.set(-f3, -f3, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(C6261s.this.agY, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(C6261s.this.agY, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(C6261s.this.agY, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(C6261s.this.agY, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
        }
    }

    C6261s() {
    }

    /* renamed from: hT */
    public void mo2129hT() {
        C41537ar.aqk = new C62621();
    }

    /* renamed from: f */
    private static void m10216f(C8473t c8473t) {
        Rect rect = new Rect();
        C6261s.m10217k(c8473t).getPadding(rect);
        c8473t.mo1684S((int) Math.ceil((double) C6261s.m10217k(c8473t).mo66545ky()), (int) Math.ceil((double) C6261s.m10217k(c8473t).mo66546kz()));
        c8473t.mo1685e(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: g */
    public final void mo2127g(C8473t c8473t) {
    }

    /* renamed from: h */
    public final void mo2128h(C8473t c8473t) {
        C6261s.m10217k(c8473t).mo66539ap(c8473t.getPreventCornerOverlap());
        C6261s.m10216f(c8473t);
    }

    /* renamed from: a */
    public final void mo2120a(C8473t c8473t, ColorStateList colorStateList) {
        C41537ar k = C6261s.m10217k(c8473t);
        k.mo66541e(colorStateList);
        k.invalidateSelf();
    }

    /* renamed from: i */
    public final ColorStateList mo2130i(C8473t c8473t) {
        return C6261s.m10217k(c8473t).aqi;
    }

    /* renamed from: a */
    public final void mo2118a(C8473t c8473t, float f) {
        C41537ar k = C6261s.m10217k(c8473t);
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (k.f16861rf != f2) {
            k.f16861rf = f2;
            k.f16866rl = true;
            k.invalidateSelf();
        }
        C6261s.m10216f(c8473t);
    }

    /* renamed from: d */
    public final float mo2125d(C8473t c8473t) {
        return C6261s.m10217k(c8473t).f16861rf;
    }

    /* renamed from: c */
    public final void mo2124c(C8473t c8473t, float f) {
        C41537ar k = C6261s.m10217k(c8473t);
        k.mo66549p(f, k.f16863ri);
    }

    /* renamed from: e */
    public final float mo2126e(C8473t c8473t) {
        return C6261s.m10217k(c8473t).f16865rk;
    }

    /* renamed from: b */
    public final void mo2122b(C8473t c8473t, float f) {
        C41537ar k = C6261s.m10217k(c8473t);
        k.mo66549p(k.f16865rk, f);
        C6261s.m10216f(c8473t);
    }

    /* renamed from: a */
    public final float mo2117a(C8473t c8473t) {
        return C6261s.m10217k(c8473t).f16863ri;
    }

    /* renamed from: b */
    public final float mo2121b(C8473t c8473t) {
        return C6261s.m10217k(c8473t).mo66545ky();
    }

    /* renamed from: c */
    public final float mo2123c(C8473t c8473t) {
        return C6261s.m10217k(c8473t).mo66546kz();
    }

    /* renamed from: k */
    private static C41537ar m10217k(C8473t c8473t) {
        return (C41537ar) c8473t.mo1688hR();
    }

    /* renamed from: a */
    public final void mo2119a(C8473t c8473t, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C41537ar c41537ar = new C41537ar(context.getResources(), colorStateList, f, f2, f3);
        c41537ar.mo66539ap(c8473t.getPreventCornerOverlap());
        c8473t.mo1690l(c41537ar);
        C6261s.m10216f(c8473t);
    }
}
