package android.support.p069v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.aq */
final class C41536aq extends Drawable {
    float aqc;
    private final RectF aqd;
    private final Rect aqe;
    float aqf;
    private boolean aqg = false;
    private boolean aqh = true;
    ColorStateList aqi;
    private final Paint mPaint;
    /* renamed from: uM */
    private PorterDuffColorFilter f16855uM;
    /* renamed from: vH */
    private ColorStateList f16856vH;
    /* renamed from: vI */
    private Mode f16857vI = Mode.SRC_IN;

    C41536aq(ColorStateList colorStateList, float f) {
        this.aqc = f;
        this.mPaint = new Paint(5);
        mo66528e(colorStateList);
        this.aqd = new RectF();
        this.aqe = new Rect();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo66528e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.aqi = colorStateList;
        this.mPaint.setColor(this.aqi.getColorForState(getState(), this.aqi.getDefaultColor()));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo66526a(float f, boolean z, boolean z2) {
        if (f != this.aqf || this.aqg != z || this.aqh != z2) {
            this.aqf = f;
            this.aqg = z;
            this.aqh = z2;
            mo66531h(null);
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.mPaint;
        if (this.f16855uM == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f16855uM);
            obj = 1;
        }
        canvas.drawRoundRect(this.aqd, this.aqc, this.aqc, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final void mo66531h(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.aqd.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.aqe.set(rect);
        if (this.aqg) {
            float c = C41537ar.m72685c(this.aqf, this.aqc, this.aqh);
            this.aqe.inset((int) Math.ceil((double) C41537ar.m72686d(this.aqf, this.aqc, this.aqh)), (int) Math.ceil((double) c));
            this.aqd.set(this.aqe);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        mo66531h(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.aqe, this.aqc);
    }

    public final void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.f16856vH = colorStateList;
        this.f16855uM = m72681b(this.f16856vH, this.f16857vI);
        invalidateSelf();
    }

    public final void setTintMode(Mode mode) {
        this.f16857vI = mode;
        this.f16855uM = m72681b(this.f16856vH, this.f16857vI);
        invalidateSelf();
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.aqi.getColorForState(iArr, this.aqi.getDefaultColor());
        boolean z = colorForState != this.mPaint.getColor();
        if (z) {
            this.mPaint.setColor(colorForState);
        }
        if (this.f16856vH == null || this.f16857vI == null) {
            return z;
        }
        this.f16855uM = m72681b(this.f16856vH, this.f16857vI);
        return true;
    }

    public final boolean isStateful() {
        return (this.f16856vH != null && this.f16856vH.isStateful()) || ((this.aqi != null && this.aqi.isStateful()) || super.isStateful());
    }

    /* renamed from: b */
    private PorterDuffColorFilter m72681b(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
