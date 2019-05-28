package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

class s implements u {
    final RectF agY = new RectF();

    s() {
    }

    public void hT() {
        ar.aqk = new a() {
            public final void a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    s.this.agY.set(-f3, -f3, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(s.this.agY, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(s.this.agY, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(s.this.agY, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(s.this.agY, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, 1.0f + (rectF.right - f3), rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    private static void f(t tVar) {
        Rect rect = new Rect();
        k(tVar).getPadding(rect);
        tVar.S((int) Math.ceil((double) k(tVar).ky()), (int) Math.ceil((double) k(tVar).kz()));
        tVar.e(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void g(t tVar) {
    }

    public final void h(t tVar) {
        k(tVar).ap(tVar.getPreventCornerOverlap());
        f(tVar);
    }

    public final void a(t tVar, ColorStateList colorStateList) {
        ar k = k(tVar);
        k.e(colorStateList);
        k.invalidateSelf();
    }

    public final ColorStateList i(t tVar) {
        return k(tVar).aqi;
    }

    public final void a(t tVar, float f) {
        ar k = k(tVar);
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (k.rf != f2) {
            k.rf = f2;
            k.rl = true;
            k.invalidateSelf();
        }
        f(tVar);
    }

    public final float d(t tVar) {
        return k(tVar).rf;
    }

    public final void c(t tVar, float f) {
        ar k = k(tVar);
        k.p(f, k.ri);
    }

    public final float e(t tVar) {
        return k(tVar).rk;
    }

    public final void b(t tVar, float f) {
        ar k = k(tVar);
        k.p(k.rk, f);
        f(tVar);
    }

    public final float a(t tVar) {
        return k(tVar).ri;
    }

    public final float b(t tVar) {
        return k(tVar).ky();
    }

    public final float c(t tVar) {
        return k(tVar).kz();
    }

    private static ar k(t tVar) {
        return (ar) tVar.hR();
    }

    public final void a(t tVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        ar arVar = new ar(context.getResources(), colorStateList, f, f2, f3);
        arVar.ap(tVar.getPreventCornerOverlap());
        tVar.l(arVar);
        f(tVar);
    }
}
