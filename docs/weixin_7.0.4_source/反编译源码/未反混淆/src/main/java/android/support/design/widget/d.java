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
import android.support.v4.a.b;

class d extends Drawable {
    final Paint mPaint = new Paint(1);
    final Rect mRect = new Rect();
    final RectF nI = new RectF();
    float nJ;
    private int nK;
    private int nL;
    private int nM;
    private int nN;
    private ColorStateList nO;
    private int nP;
    private boolean nQ = true;
    float nR;

    public d() {
        this.mPaint.setStyle(Style.STROKE);
    }

    /* Access modifiers changed, original: final */
    public final void b(int i, int i2, int i3, int i4) {
        this.nK = i;
        this.nL = i2;
        this.nM = i3;
        this.nN = i4;
    }

    /* Access modifiers changed, original: final */
    public final void setBorderWidth(float f) {
        if (this.nJ != f) {
            this.nJ = f;
            this.mPaint.setStrokeWidth(1.3333f * f);
            this.nQ = true;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        float height;
        if (this.nQ) {
            Paint paint = this.mPaint;
            Rect rect = this.mRect;
            copyBounds(rect);
            height = this.nJ / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{b.s(this.nK, this.nP), b.s(this.nL, this.nP), b.s(b.u(this.nL, 0), this.nP), b.s(b.u(this.nN, 0), this.nP), b.s(this.nN, this.nP), b.s(this.nM, this.nP)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.nQ = false;
        }
        height = this.mPaint.getStrokeWidth() / 2.0f;
        RectF rectF = this.nI;
        copyBounds(this.mRect);
        rectF.set(this.mRect);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.nR, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.mPaint);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.nJ);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        invalidateSelf();
    }

    /* Access modifiers changed, original: final */
    public final void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.nP = colorStateList.getColorForState(getState(), this.nP);
        }
        this.nO = colorStateList;
        this.nQ = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.nJ > 0.0f ? -3 : -2;
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        this.nQ = true;
    }

    public boolean isStateful() {
        return (this.nO != null && this.nO.isStateful()) || super.isStateful();
    }

    /* Access modifiers changed, original: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.nO != null) {
            int colorForState = this.nO.getColorForState(iArr, this.nP);
            if (colorForState != this.nP) {
                this.nQ = true;
                this.nP = colorForState;
            }
        }
        if (this.nQ) {
            invalidateSelf();
        }
        return this.nQ;
    }
}
