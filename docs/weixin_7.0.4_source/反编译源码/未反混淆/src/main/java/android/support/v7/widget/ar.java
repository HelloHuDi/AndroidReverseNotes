package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.tencent.mm.R;

final class ar extends Drawable {
    static a aqk;
    private static final double rb = Math.cos(Math.toRadians(45.0d));
    ColorStateList aqi;
    private final int aqj;
    private final RectF aql;
    private Paint mPaint;
    private Paint rc;
    private Paint rd;
    float rf;
    private Path rg;
    float ri;
    private float rj;
    float rk;
    boolean rl = true;
    private final int rm;
    private final int ro;
    private boolean rp = true;
    private boolean rq = false;

    interface a {
        void a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    ar(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.rm = resources.getColor(R.color.jq);
        this.ro = resources.getColor(R.color.jp);
        this.aqj = resources.getDimensionPixelSize(R.dimen.wj);
        this.mPaint = new Paint(5);
        e(colorStateList);
        this.rc = new Paint(5);
        this.rc.setStyle(Style.FILL);
        this.rf = (float) ((int) (0.5f + f));
        this.aql = new RectF();
        this.rd = new Paint(this.rc);
        this.rd.setAntiAlias(false);
        p(f2, f3);
    }

    /* Access modifiers changed, original: final */
    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.aqi = colorStateList;
        this.mPaint.setColor(this.aqi.getColorForState(getState(), this.aqi.getDefaultColor()));
    }

    private static int n(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void ap(boolean z) {
        this.rp = z;
        invalidateSelf();
    }

    public final void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.rc.setAlpha(i);
        this.rd.setAlpha(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.rl = true;
    }

    /* Access modifiers changed, original: final */
    public final void p(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float n = (float) n(f);
            float n2 = (float) n(f2);
            if (n > n2) {
                if (!this.rq) {
                    this.rq = true;
                }
                n = n2;
            }
            if (this.rk != n || this.ri != n2) {
                this.rk = n;
                this.ri = n2;
                this.rj = (float) ((int) (((n * 1.5f) + ((float) this.aqj)) + 0.5f));
                this.rl = true;
                invalidateSelf();
            }
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) c(this.ri, this.rf, this.rp));
        int ceil2 = (int) Math.ceil((double) d(this.ri, this.rf, this.rp));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float c(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - rb) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float d(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - rb) * ((double) f2)));
        }
        return f;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.aqi.getColorForState(iArr, this.aqi.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.rl = true;
        invalidateSelf();
        return true;
    }

    public final boolean isStateful() {
        return (this.aqi != null && this.aqi.isStateful()) || super.isStateful();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        int i;
        int i2 = 1;
        if (this.rl) {
            Rect bounds = getBounds();
            f = this.ri * 1.5f;
            this.aql.set(((float) bounds.left) + this.ri, ((float) bounds.top) + f, ((float) bounds.right) - this.ri, ((float) bounds.bottom) - f);
            RectF rectF = new RectF(-this.rf, -this.rf, this.rf, this.rf);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.rj, -this.rj);
            if (this.rg == null) {
                this.rg = new Path();
            } else {
                this.rg.reset();
            }
            this.rg.setFillType(FillType.EVEN_ODD);
            this.rg.moveTo(-this.rf, 0.0f);
            this.rg.rLineTo(-this.rj, 0.0f);
            this.rg.arcTo(rectF2, 180.0f, 90.0f, false);
            this.rg.arcTo(rectF, 270.0f, -90.0f, false);
            this.rg.close();
            f = this.rf / (this.rf + this.rj);
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.rc.setShader(new RadialGradient(0.0f, f, this.rf + this.rj, new int[]{this.rm, this.rm, this.ro}, fArr, TileMode.CLAMP));
            float f2 = 0.0f;
            this.rd.setShader(new LinearGradient(0.0f, (-this.rf) + this.rj, f2, (-this.rf) - this.rj, new int[]{this.rm, this.rm, this.ro}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.rd.setAntiAlias(false);
            this.rl = false;
        }
        canvas.translate(0.0f, this.rk / 2.0f);
        f = (-this.rf) - this.rj;
        float f3 = (this.rf + ((float) this.aqj)) + (this.rk / 2.0f);
        if (this.aql.width() - (2.0f * f3) > 0.0f) {
            i = 1;
        } else {
            boolean i3 = false;
        }
        if (this.aql.height() - (2.0f * f3) <= 0.0f) {
            i2 = 0;
        }
        int save = canvas.save();
        canvas.translate(this.aql.left + f3, this.aql.top + f3);
        canvas.drawPath(this.rg, this.rc);
        if (i3 != 0) {
            canvas.drawRect(0.0f, f, this.aql.width() - (2.0f * f3), -this.rf, this.rd);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.aql.right - f3, this.aql.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.rg, this.rc);
        if (i3 != 0) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, f, this.aql.width() - (2.0f * f3), this.rj + (-this.rf), this.rd);
        }
        canvas.restoreToCount(save);
        i3 = canvas.save();
        canvas.translate(this.aql.left + f3, this.aql.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.rg, this.rc);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.aql.height() - (2.0f * f3), -this.rf, this.rd);
        }
        canvas.restoreToCount(i3);
        i3 = canvas.save();
        canvas.translate(this.aql.right - f3, this.aql.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.rg, this.rc);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.aql.height() - (2.0f * f3), -this.rf, this.rd);
        }
        canvas.restoreToCount(i3);
        canvas.translate(0.0f, (-this.rk) / 2.0f);
        aqk.a(canvas, this.aql, this.rf, this.mPaint);
    }

    /* Access modifiers changed, original: final */
    public final float ky() {
        return (Math.max(this.ri, (this.rf + ((float) this.aqj)) + (this.ri / 2.0f)) * 2.0f) + ((this.ri + ((float) this.aqj)) * 2.0f);
    }

    /* Access modifiers changed, original: final */
    public final float kz() {
        return (Math.max(this.ri, (this.rf + ((float) this.aqj)) + ((this.ri * 1.5f) / 2.0f)) * 2.0f) + (((this.ri * 1.5f) + ((float) this.aqj)) * 2.0f);
    }
}
