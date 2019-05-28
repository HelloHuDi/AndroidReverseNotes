package android.support.p069v7.p073d.p074a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.p059a.C0280a;

/* renamed from: android.support.v7.d.a.b */
public final class C0592b extends Drawable {
    /* renamed from: Yg */
    private static final float f909Yg = ((float) Math.toRadians(45.0d));
    /* renamed from: Yh */
    private float f910Yh;
    /* renamed from: Yi */
    private float f911Yi;
    /* renamed from: Yj */
    private float f912Yj;
    /* renamed from: Yk */
    private float f913Yk;
    /* renamed from: Yl */
    private boolean f914Yl;
    /* renamed from: Ym */
    private boolean f915Ym;
    /* renamed from: Yn */
    private float f916Yn;
    /* renamed from: Yo */
    private float f917Yo;
    /* renamed from: Yp */
    private int f918Yp;
    private final Paint mPaint;
    private final int mSize;
    /* renamed from: vr */
    private final Path f919vr;

    /* renamed from: T */
    public final void mo1460T(boolean z) {
        if (this.f915Ym != z) {
            this.f915Ym = z;
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        switch (this.f918Yp) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 3:
                if (C0280a.m468g(this) != 0) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
            default:
                if (C0280a.m468g(this) != 1) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
        }
        float sqrt = (float) Math.sqrt((double) ((this.f910Yh * this.f910Yh) * 2.0f));
        float f = this.f911Yi;
        float f2 = f + ((sqrt - f) * this.f916Yn);
        sqrt = this.f911Yi;
        float f3 = sqrt + ((this.f912Yj - sqrt) * this.f916Yn);
        float round = (float) Math.round(0.0f + ((this.f917Yo - 0.0f) * this.f916Yn));
        float f4 = 0.0f + ((f909Yg - 0.0f) * this.f916Yn);
        if (i != 0) {
            f = 0.0f;
        } else {
            f = -180.0f;
        }
        if (i != 0) {
            sqrt = 180.0f;
        } else {
            sqrt = 0.0f;
        }
        sqrt = ((sqrt - f) * this.f916Yn) + f;
        f = (float) Math.round(((double) f2) * Math.cos((double) f4));
        f2 = (float) Math.round(((double) f2) * Math.sin((double) f4));
        this.f919vr.rewind();
        f4 = this.f913Yk + this.mPaint.getStrokeWidth();
        f4 += ((-this.f917Yo) - f4) * this.f916Yn;
        float f5 = (-f3) / 2.0f;
        this.f919vr.moveTo(f5 + round, 0.0f);
        this.f919vr.rLineTo(f3 - (round * 2.0f), 0.0f);
        this.f919vr.moveTo(f5, f4);
        this.f919vr.rLineTo(f, f2);
        this.f919vr.moveTo(f5, -f4);
        this.f919vr.rLineTo(f, -f2);
        this.f919vr.close();
        canvas.save();
        f = this.mPaint.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), ((f * 1.5f) + this.f913Yk) + ((float) ((((int) ((((float) bounds.height()) - (3.0f * f)) - (this.f913Yk * 2.0f))) / 4) * 2)));
        if (this.f914Yl) {
            canvas.rotate(((float) ((i ^ this.f915Ym) != 0 ? -1 : 1)) * sqrt);
        } else if (i != 0) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f919vr, this.mPaint);
        canvas.restore();
    }

    public final void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getIntrinsicHeight() {
        return this.mSize;
    }

    public final int getIntrinsicWidth() {
        return this.mSize;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setProgress(float f) {
        if (this.f916Yn != f) {
            this.f916Yn = f;
            invalidateSelf();
        }
    }
}
