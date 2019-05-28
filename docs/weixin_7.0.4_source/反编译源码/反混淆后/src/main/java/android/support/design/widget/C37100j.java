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
import android.support.p057v4.content.C0380b;
import android.support.p069v7.p073d.p074a.C0591a;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.design.widget.j */
final class C37100j extends C0591a {
    /* renamed from: rb */
    static final double f15678rb = Math.cos(Math.toRadians(45.0d));
    /* renamed from: nR */
    float f15679nR;
    /* renamed from: rc */
    final Paint f15680rc;
    /* renamed from: rd */
    final Paint f15681rd;
    /* renamed from: re */
    final RectF f15682re;
    /* renamed from: rf */
    float f15683rf;
    /* renamed from: rg */
    Path f15684rg;
    /* renamed from: rh */
    float f15685rh;
    /* renamed from: ri */
    float f15686ri;
    /* renamed from: rj */
    float f15687rj;
    /* renamed from: rk */
    float f15688rk;
    /* renamed from: rl */
    private boolean f15689rl = true;
    /* renamed from: rm */
    private final int f15690rm;
    /* renamed from: rn */
    private final int f15691rn;
    /* renamed from: ro */
    private final int f15692ro;
    /* renamed from: rp */
    boolean f15693rp = true;
    /* renamed from: rq */
    private boolean f15694rq = false;

    public C37100j(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f15690rm = C0380b.m652i(context, C25738R.color.f11921lp);
        this.f15691rn = C0380b.m652i(context, C25738R.color.f11920lo);
        this.f15692ro = C0380b.m652i(context, C25738R.color.f11919ln);
        this.f15680rc = new Paint(5);
        this.f15680rc.setStyle(Style.FILL);
        this.f15683rf = (float) Math.round(f);
        this.f15682re = new RectF();
        this.f15681rd = new Paint(this.f15680rc);
        this.f15681rd.setAntiAlias(false);
        mo59138p(f2, f3);
    }

    /* renamed from: n */
    private static int m62064n(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.f15680rc.setAlpha(i);
        this.f15681rd.setAlpha(i);
    }

    public final void onBoundsChange(Rect rect) {
        this.f15689rl = true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: p */
    public final void mo59138p(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float n = (float) C37100j.m62064n(f);
        float n2 = (float) C37100j.m62064n(f2);
        if (n > n2) {
            if (!this.f15694rq) {
                this.f15694rq = true;
            }
            n = n2;
        }
        if (this.f15688rk != n || this.f15686ri != n2) {
            this.f15688rk = n;
            this.f15686ri = n2;
            this.f15687rj = (float) Math.round(n * 1.5f);
            this.f15685rh = n2;
            this.f15689rl = true;
            invalidateSelf();
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C37100j.m62062c(this.f15686ri, this.f15683rf, this.f15693rp));
        int ceil2 = (int) Math.ceil((double) C37100j.m62063d(this.f15686ri, this.f15683rf, this.f15693rp));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* renamed from: c */
    public static float m62062c(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f15678rb) * ((double) f2)));
        }
        return 1.5f * f;
    }

    /* renamed from: d */
    public static float m62063d(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f15678rb) * ((double) f2)));
        }
        return f;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        Object obj;
        if (this.f15689rl) {
            Rect bounds = getBounds();
            float f2 = this.f15686ri * 1.5f;
            this.f15682re.set(((float) bounds.left) + this.f15686ri, ((float) bounds.top) + f2, ((float) bounds.right) - this.f15686ri, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.f15682re.left, (int) this.f15682re.top, (int) this.f15682re.right, (int) this.f15682re.bottom);
            RectF rectF = new RectF(-this.f15683rf, -this.f15683rf, this.f15683rf, this.f15683rf);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.f15687rj, -this.f15687rj);
            if (this.f15684rg == null) {
                this.f15684rg = new Path();
            } else {
                this.f15684rg.reset();
            }
            this.f15684rg.setFillType(FillType.EVEN_ODD);
            this.f15684rg.moveTo(-this.f15683rf, 0.0f);
            this.f15684rg.rLineTo(-this.f15687rj, 0.0f);
            this.f15684rg.arcTo(rectF2, 180.0f, 90.0f, false);
            this.f15684rg.arcTo(rectF, 270.0f, -90.0f, false);
            this.f15684rg.close();
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.f15683rf / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.f15680rc.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.f15690rm, this.f15691rn, this.f15692ro}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.f15681rd.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f15690rm, this.f15691rn, this.f15692ro}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.f15681rd.setAntiAlias(false);
            this.f15689rl = false;
        }
        int save = canvas.save();
        canvas.rotate(this.f15679nR, this.f15682re.centerX(), this.f15682re.centerY());
        float f5 = (-this.f15683rf) - this.f15687rj;
        f = this.f15683rf;
        Object obj2 = this.f15682re.width() - (2.0f * f) > 0.0f ? 1 : null;
        if (this.f15682re.height() - (2.0f * f) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        float f6 = f / ((this.f15688rk - (this.f15688rk * 0.5f)) + f);
        float f7 = f / ((this.f15688rk - (this.f15688rk * 0.25f)) + f);
        float f8 = f / (f + (this.f15688rk - (this.f15688rk * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f15682re.left + f, this.f15682re.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.f15684rg, this.f15680rc);
        if (obj2 != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.f15682re.width() - (2.0f * f), -this.f15683rf, this.f15681rd);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f15682re.right - f, this.f15682re.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f15684rg, this.f15680rc);
        if (obj2 != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.f15682re.width() - (2.0f * f), this.f15687rj + (-this.f15683rf), this.f15681rd);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f15682re.left + f, this.f15682re.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f15684rg, this.f15680rc);
        if (obj != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.f15682re.height() - (2.0f * f), -this.f15683rf, this.f15681rd);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f15682re.right - f, this.f15682re.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f15684rg, this.f15680rc);
        if (obj != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.f15682re.height() - (2.0f * f), -this.f15683rf, this.f15681rd);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }

    /* renamed from: o */
    public final void mo59137o(float f) {
        mo59138p(f, this.f15686ri);
    }
}
