package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
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
import android.support.v4.content.b;
import android.support.v7.d.a.a;
import com.tencent.mm.R;

final class j extends a {
    static final double rb = Math.cos(Math.toRadians(45.0d));
    float nR;
    final Paint rc;
    final Paint rd;
    final RectF re;
    float rf;
    Path rg;
    float rh;
    float ri;
    float rj;
    float rk;
    private boolean rl = true;
    private final int rm;
    private final int rn;
    private final int ro;
    boolean rp = true;
    private boolean rq = false;

    public j(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.rm = b.i(context, R.color.lp);
        this.rn = b.i(context, R.color.lo);
        this.ro = b.i(context, R.color.ln);
        this.rc = new Paint(5);
        this.rc.setStyle(Style.FILL);
        this.rf = (float) Math.round(f);
        this.re = new RectF();
        this.rd = new Paint(this.rc);
        this.rd.setAntiAlias(false);
        p(f2, f3);
    }

    private static int n(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.rc.setAlpha(i);
        this.rd.setAlpha(i);
    }

    public final void onBoundsChange(Rect rect) {
        this.rl = true;
    }

    /* Access modifiers changed, original: final */
    public final void p(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
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
            this.rj = (float) Math.round(n * 1.5f);
            this.rh = n2;
            this.rl = true;
            invalidateSelf();
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) c(this.ri, this.rf, this.rp));
        int ceil2 = (int) Math.ceil((double) d(this.ri, this.rf, this.rp));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float c(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - rb) * ((double) f2)));
        }
        return 1.5f * f;
    }

    public static float d(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - rb) * ((double) f2)));
        }
        return f;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        Object obj;
        if (this.rl) {
            Rect bounds = getBounds();
            float f2 = this.ri * 1.5f;
            this.re.set(((float) bounds.left) + this.ri, ((float) bounds.top) + f2, ((float) bounds.right) - this.ri, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.re.left, (int) this.re.top, (int) this.re.right, (int) this.re.bottom);
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
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.rf / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.rc.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.rm, this.rn, this.ro}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.rd.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.rm, this.rn, this.ro}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.rd.setAntiAlias(false);
            this.rl = false;
        }
        int save = canvas.save();
        canvas.rotate(this.nR, this.re.centerX(), this.re.centerY());
        float f5 = (-this.rf) - this.rj;
        f = this.rf;
        Object obj2 = this.re.width() - (2.0f * f) > 0.0f ? 1 : null;
        if (this.re.height() - (2.0f * f) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        float f6 = f / ((this.rk - (this.rk * 0.5f)) + f);
        float f7 = f / ((this.rk - (this.rk * 0.25f)) + f);
        float f8 = f / (f + (this.rk - (this.rk * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.re.left + f, this.re.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.rg, this.rc);
        if (obj2 != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.re.width() - (2.0f * f), -this.rf, this.rd);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.re.right - f, this.re.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.rg, this.rc);
        if (obj2 != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.re.width() - (2.0f * f), this.rj + (-this.rf), this.rd);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.re.left + f, this.re.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.rg, this.rc);
        if (obj != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.re.height() - (2.0f * f), -this.rf, this.rd);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.re.right - f, this.re.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.rg, this.rc);
        if (obj != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.re.height() - (2.0f * f), -this.rf, this.rd);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }

    public final void o(float f) {
        p(f, this.ri);
    }
}
