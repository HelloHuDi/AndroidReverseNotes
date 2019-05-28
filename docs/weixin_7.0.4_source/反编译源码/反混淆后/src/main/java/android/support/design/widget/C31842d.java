package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.p057v4.p058a.C0284b;

/* renamed from: android.support.design.widget.d */
class C31842d extends Drawable {
    final Paint mPaint = new Paint(1);
    final Rect mRect = new Rect();
    /* renamed from: nI */
    final RectF f14584nI = new RectF();
    /* renamed from: nJ */
    float f14585nJ;
    /* renamed from: nK */
    private int f14586nK;
    /* renamed from: nL */
    private int f14587nL;
    /* renamed from: nM */
    private int f14588nM;
    /* renamed from: nN */
    private int f14589nN;
    /* renamed from: nO */
    private ColorStateList f14590nO;
    /* renamed from: nP */
    private int f14591nP;
    /* renamed from: nQ */
    private boolean f14592nQ = true;
    /* renamed from: nR */
    float f14593nR;

    public C31842d() {
        this.mPaint.setStyle(Style.STROKE);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo51809b(int i, int i2, int i3, int i4) {
        this.f14586nK = i;
        this.f14587nL = i2;
        this.f14588nM = i3;
        this.f14589nN = i4;
    }

    /* Access modifiers changed, original: final */
    public final void setBorderWidth(float f) {
        if (this.f14585nJ != f) {
            this.f14585nJ = f;
            this.mPaint.setStrokeWidth(1.3333f * f);
            this.f14592nQ = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        float height;
        if (this.f14592nQ) {
            Paint paint = this.mPaint;
            Rect rect = this.mRect;
            copyBounds(rect);
            height = this.f14585nJ / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{C0284b.m477s(this.f14586nK, this.f14591nP), C0284b.m477s(this.f14587nL, this.f14591nP), C0284b.m477s(C0284b.m479u(this.f14587nL, 0), this.f14591nP), C0284b.m477s(C0284b.m479u(this.f14589nN, 0), this.f14591nP), C0284b.m477s(this.f14589nN, this.f14591nP), C0284b.m477s(this.f14588nM, this.f14591nP)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.f14592nQ = false;
        }
        height = this.mPaint.getStrokeWidth() / 2.0f;
        RectF rectF = this.f14584nI;
        copyBounds(this.mRect);
        rectF.set(this.mRect);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.f14593nR, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.mPaint);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f14585nJ);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        invalidateSelf();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo51808a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f14591nP = colorStateList.getColorForState(getState(), this.f14591nP);
        }
        this.f14590nO = colorStateList;
        this.f14592nQ = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.f14585nJ > 0.0f ? -3 : -2;
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        this.f14592nQ = true;
    }

    public boolean isStateful() {
        return (this.f14590nO != null && this.f14590nO.isStateful()) || super.isStateful();
    }

    /* Access modifiers changed, original: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f14590nO != null) {
            int colorForState = this.f14590nO.getColorForState(iArr, this.f14591nP);
            if (colorForState != this.f14591nP) {
                this.f14592nQ = true;
                this.f14591nP = colorForState;
            }
        }
        if (this.f14592nQ) {
            invalidateSelf();
        }
        return this.f14592nQ;
    }
}
