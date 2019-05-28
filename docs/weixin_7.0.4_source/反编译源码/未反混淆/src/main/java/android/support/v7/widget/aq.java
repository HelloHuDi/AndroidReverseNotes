package android.support.v7.widget;

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

final class aq extends Drawable {
    float aqc;
    private final RectF aqd;
    private final Rect aqe;
    float aqf;
    private boolean aqg = false;
    private boolean aqh = true;
    ColorStateList aqi;
    private final Paint mPaint;
    private PorterDuffColorFilter uM;
    private ColorStateList vH;
    private Mode vI = Mode.SRC_IN;

    aq(ColorStateList colorStateList, float f) {
        this.aqc = f;
        this.mPaint = new Paint(5);
        e(colorStateList);
        this.aqd = new RectF();
        this.aqe = new Rect();
    }

    /* Access modifiers changed, original: final */
    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.aqi = colorStateList;
        this.mPaint.setColor(this.aqi.getColorForState(getState(), this.aqi.getDefaultColor()));
    }

    /* Access modifiers changed, original: final */
    public final void a(float f, boolean z, boolean z2) {
        if (f != this.aqf || this.aqg != z || this.aqh != z2) {
            this.aqf = f;
            this.aqg = z;
            this.aqh = z2;
            h(null);
            invalidateSelf();
        }
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.mPaint;
        if (this.uM == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.uM);
            obj = 1;
        }
        canvas.drawRoundRect(this.aqd, this.aqc, this.aqc, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    /* Access modifiers changed, original: final */
    public final void h(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.aqd.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.aqe.set(rect);
        if (this.aqg) {
            float c = ar.c(this.aqf, this.aqc, this.aqh);
            this.aqe.inset((int) Math.ceil((double) ar.d(this.aqf, this.aqc, this.aqh)), (int) Math.ceil((double) c));
            this.aqd.set(this.aqe);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        h(rect);
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
        this.vH = colorStateList;
        this.uM = b(this.vH, this.vI);
        invalidateSelf();
    }

    public final void setTintMode(Mode mode) {
        this.vI = mode;
        this.uM = b(this.vH, this.vI);
        invalidateSelf();
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean onStateChange(int[] iArr) {
        int colorForState = this.aqi.getColorForState(iArr, this.aqi.getDefaultColor());
        boolean z = colorForState != this.mPaint.getColor();
        if (z) {
            this.mPaint.setColor(colorForState);
        }
        if (this.vH == null || this.vI == null) {
            return z;
        }
        this.uM = b(this.vH, this.vI);
        return true;
    }

    public final boolean isStateful() {
        return (this.vH != null && this.vH.isStateful()) || ((this.aqi != null && this.aqi.isStateful()) || super.isStateful());
    }

    private PorterDuffColorFilter b(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
