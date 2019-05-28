package android.support.v7.d.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;

public final class b extends Drawable {
    private static final float Yg = ((float) Math.toRadians(45.0d));
    private float Yh;
    private float Yi;
    private float Yj;
    private float Yk;
    private boolean Yl;
    private boolean Ym;
    private float Yn;
    private float Yo;
    private int Yp;
    private final Paint mPaint;
    private final int mSize;
    private final Path vr;

    public final void T(boolean z) {
        if (this.Ym != z) {
            this.Ym = z;
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        switch (this.Yp) {
            case 0:
                i = 0;
                break;
            case 1:
                i = 1;
                break;
            case 3:
                if (a.g(this) != 0) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
            default:
                if (a.g(this) != 1) {
                    i = 0;
                    break;
                } else {
                    i = 1;
                    break;
                }
        }
        float sqrt = (float) Math.sqrt((double) ((this.Yh * this.Yh) * 2.0f));
        float f = this.Yi;
        float f2 = f + ((sqrt - f) * this.Yn);
        sqrt = this.Yi;
        float f3 = sqrt + ((this.Yj - sqrt) * this.Yn);
        float round = (float) Math.round(0.0f + ((this.Yo - 0.0f) * this.Yn));
        float f4 = 0.0f + ((Yg - 0.0f) * this.Yn);
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
        sqrt = ((sqrt - f) * this.Yn) + f;
        f = (float) Math.round(((double) f2) * Math.cos((double) f4));
        f2 = (float) Math.round(((double) f2) * Math.sin((double) f4));
        this.vr.rewind();
        f4 = this.Yk + this.mPaint.getStrokeWidth();
        f4 += ((-this.Yo) - f4) * this.Yn;
        float f5 = (-f3) / 2.0f;
        this.vr.moveTo(f5 + round, 0.0f);
        this.vr.rLineTo(f3 - (round * 2.0f), 0.0f);
        this.vr.moveTo(f5, f4);
        this.vr.rLineTo(f, f2);
        this.vr.moveTo(f5, -f4);
        this.vr.rLineTo(f, -f2);
        this.vr.close();
        canvas.save();
        f = this.mPaint.getStrokeWidth();
        canvas.translate((float) bounds.centerX(), ((f * 1.5f) + this.Yk) + ((float) ((((int) ((((float) bounds.height()) - (3.0f * f)) - (this.Yk * 2.0f))) / 4) * 2)));
        if (this.Yl) {
            canvas.rotate(((float) ((i ^ this.Ym) != 0 ? -1 : 1)) * sqrt);
        } else if (i != 0) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.vr, this.mPaint);
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
        if (this.Yn != f) {
            this.Yn = f;
            invalidateSelf();
        }
    }
}
