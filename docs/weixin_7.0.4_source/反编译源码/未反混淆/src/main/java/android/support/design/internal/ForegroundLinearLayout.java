package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.a;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.view.d;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable lt;
    private final Rect lu;
    private final Rect lv;
    private int lw;
    protected boolean lx;
    boolean ly;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lu = new Rect();
        this.lv = new Rect();
        this.lw = d.MIC_AVROUND_BLUR;
        this.lx = true;
        this.ly = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ForegroundLinearLayout, i, 0);
        this.lw = obtainStyledAttributes.getInt(1, this.lw);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.lx = obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.lw;
    }

    public void setForegroundGravity(int i) {
        if (this.lw != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.lw = i2;
            if (this.lw == d.MIC_AVROUND_BLUR && this.lt != null) {
                this.lt.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.lt;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.lt != null) {
            this.lt.jumpToCurrentState();
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.lt != null && this.lt.isStateful()) {
            this.lt.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.lt != drawable) {
            if (this.lt != null) {
                this.lt.setCallback(null);
                unscheduleDrawable(this.lt);
            }
            this.lt = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.lw == d.MIC_AVROUND_BLUR) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.lt;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.ly |= z;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ly = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.lt != null) {
            Drawable drawable = this.lt;
            if (this.ly) {
                this.ly = false;
                Rect rect = this.lu;
                Rect rect2 = this.lv;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.lx) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.lw, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.lt != null) {
            this.lt.setHotspot(f, f2);
        }
    }
}
