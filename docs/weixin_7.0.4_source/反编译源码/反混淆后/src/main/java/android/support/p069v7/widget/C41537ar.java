package android.support.p069v7.widget;

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
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.ar */
final class C41537ar extends Drawable {
    static C8471a aqk;
    /* renamed from: rb */
    private static final double f16858rb = Math.cos(Math.toRadians(45.0d));
    ColorStateList aqi;
    private final int aqj;
    private final RectF aql;
    private Paint mPaint;
    /* renamed from: rc */
    private Paint f16859rc;
    /* renamed from: rd */
    private Paint f16860rd;
    /* renamed from: rf */
    float f16861rf;
    /* renamed from: rg */
    private Path f16862rg;
    /* renamed from: ri */
    float f16863ri;
    /* renamed from: rj */
    private float f16864rj;
    /* renamed from: rk */
    float f16865rk;
    /* renamed from: rl */
    boolean f16866rl = true;
    /* renamed from: rm */
    private final int f16867rm;
    /* renamed from: ro */
    private final int f16868ro;
    /* renamed from: rp */
    private boolean f16869rp = true;
    /* renamed from: rq */
    private boolean f16870rq = false;

    /* renamed from: android.support.v7.widget.ar$a */
    interface C8471a {
        /* renamed from: a */
        void mo14403a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    C41537ar(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f16867rm = resources.getColor(C25738R.color.f11862jq);
        this.f16868ro = resources.getColor(C25738R.color.f11861jp);
        this.aqj = resources.getDimensionPixelSize(C25738R.dimen.f10275wj);
        this.mPaint = new Paint(5);
        mo66541e(colorStateList);
        this.f16859rc = new Paint(5);
        this.f16859rc.setStyle(Style.FILL);
        this.f16861rf = (float) ((int) (0.5f + f));
        this.aql = new RectF();
        this.f16860rd = new Paint(this.f16859rc);
        this.f16860rd.setAntiAlias(false);
        mo66549p(f2, f3);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo66541e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.aqi = colorStateList;
        this.mPaint.setColor(this.aqi.getColorForState(getState(), this.aqi.getDefaultColor()));
    }

    /* renamed from: n */
    private static int m72687n(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ap */
    public final void mo66539ap(boolean z) {
        this.f16869rp = z;
        invalidateSelf();
    }

    public final void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.f16859rc.setAlpha(i);
        this.f16860rd.setAlpha(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f16866rl = true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: p */
    public final void mo66549p(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float n = (float) C41537ar.m72687n(f);
            float n2 = (float) C41537ar.m72687n(f2);
            if (n > n2) {
                if (!this.f16870rq) {
                    this.f16870rq = true;
                }
                n = n2;
            }
            if (this.f16865rk != n || this.f16863ri != n2) {
                this.f16865rk = n;
                this.f16863ri = n2;
                this.f16864rj = (float) ((int) (((n * 1.5f) + ((float) this.aqj)) + 0.5f));
                this.f16866rl = true;
                invalidateSelf();
            }
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C41537ar.m72685c(this.f16863ri, this.f16861rf, this.f16869rp));
        int ceil2 = (int) Math.ceil((double) C41537ar.m72686d(this.f16863ri, this.f16861rf, this.f16869rp));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* renamed from: c */
    static float m72685c(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f16858rb) * ((double) f2)));
        }
        return 1.5f * f;
    }

    /* renamed from: d */
    static float m72686d(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f16858rb) * ((double) f2)));
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
        this.f16866rl = true;
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
        if (this.f16866rl) {
            Rect bounds = getBounds();
            f = this.f16863ri * 1.5f;
            this.aql.set(((float) bounds.left) + this.f16863ri, ((float) bounds.top) + f, ((float) bounds.right) - this.f16863ri, ((float) bounds.bottom) - f);
            RectF rectF = new RectF(-this.f16861rf, -this.f16861rf, this.f16861rf, this.f16861rf);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.f16864rj, -this.f16864rj);
            if (this.f16862rg == null) {
                this.f16862rg = new Path();
            } else {
                this.f16862rg.reset();
            }
            this.f16862rg.setFillType(FillType.EVEN_ODD);
            this.f16862rg.moveTo(-this.f16861rf, 0.0f);
            this.f16862rg.rLineTo(-this.f16864rj, 0.0f);
            this.f16862rg.arcTo(rectF2, 180.0f, 90.0f, false);
            this.f16862rg.arcTo(rectF, 270.0f, -90.0f, false);
            this.f16862rg.close();
            f = this.f16861rf / (this.f16861rf + this.f16864rj);
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.f16859rc.setShader(new RadialGradient(0.0f, f, this.f16861rf + this.f16864rj, new int[]{this.f16867rm, this.f16867rm, this.f16868ro}, fArr, TileMode.CLAMP));
            float f2 = 0.0f;
            this.f16860rd.setShader(new LinearGradient(0.0f, (-this.f16861rf) + this.f16864rj, f2, (-this.f16861rf) - this.f16864rj, new int[]{this.f16867rm, this.f16867rm, this.f16868ro}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.f16860rd.setAntiAlias(false);
            this.f16866rl = false;
        }
        canvas.translate(0.0f, this.f16865rk / 2.0f);
        f = (-this.f16861rf) - this.f16864rj;
        float f3 = (this.f16861rf + ((float) this.aqj)) + (this.f16865rk / 2.0f);
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
        canvas.drawPath(this.f16862rg, this.f16859rc);
        if (i3 != 0) {
            canvas.drawRect(0.0f, f, this.aql.width() - (2.0f * f3), -this.f16861rf, this.f16860rd);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.aql.right - f3, this.aql.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f16862rg, this.f16859rc);
        if (i3 != 0) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, f, this.aql.width() - (2.0f * f3), this.f16864rj + (-this.f16861rf), this.f16860rd);
        }
        canvas.restoreToCount(save);
        i3 = canvas.save();
        canvas.translate(this.aql.left + f3, this.aql.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f16862rg, this.f16859rc);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.aql.height() - (2.0f * f3), -this.f16861rf, this.f16860rd);
        }
        canvas.restoreToCount(i3);
        i3 = canvas.save();
        canvas.translate(this.aql.right - f3, this.aql.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f16862rg, this.f16859rc);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.aql.height() - (2.0f * f3), -this.f16861rf, this.f16860rd);
        }
        canvas.restoreToCount(i3);
        canvas.translate(0.0f, (-this.f16865rk) / 2.0f);
        aqk.mo14403a(canvas, this.aql, this.f16861rf, this.mPaint);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ky */
    public final float mo66545ky() {
        return (Math.max(this.f16863ri, (this.f16861rf + ((float) this.aqj)) + (this.f16863ri / 2.0f)) * 2.0f) + ((this.f16863ri + ((float) this.aqj)) * 2.0f);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: kz */
    public final float mo66546kz() {
        return (Math.max(this.f16863ri, (this.f16861rf + ((float) this.aqj)) + ((this.f16863ri * 1.5f) / 2.0f)) * 2.0f) + (((this.f16863ri * 1.5f) + ((float) this.aqj)) * 2.0f);
    }
}
