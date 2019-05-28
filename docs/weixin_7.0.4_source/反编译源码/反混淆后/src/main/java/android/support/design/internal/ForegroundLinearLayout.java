package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C37097a.C37096a;
import android.support.p069v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.view.C31128d;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    /* renamed from: lt */
    private Drawable f3728lt;
    /* renamed from: lu */
    private final Rect f3729lu;
    /* renamed from: lv */
    private final Rect f3730lv;
    /* renamed from: lw */
    private int f3731lw;
    /* renamed from: lx */
    protected boolean f3732lx;
    /* renamed from: ly */
    boolean f3733ly;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3729lu = new Rect();
        this.f3730lv = new Rect();
        this.f3731lw = C31128d.MIC_AVROUND_BLUR;
        this.f3732lx = true;
        this.f3733ly = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.ForegroundLinearLayout, i, 0);
        this.f3731lw = obtainStyledAttributes.getInt(1, this.f3731lw);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f3732lx = obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.f3731lw;
    }

    public void setForegroundGravity(int i) {
        if (this.f3731lw != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f3731lw = i2;
            if (this.f3731lw == C31128d.MIC_AVROUND_BLUR && this.f3728lt != null) {
                this.f3728lt.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3728lt;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f3728lt != null) {
            this.f3728lt.jumpToCurrentState();
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3728lt != null && this.f3728lt.isStateful()) {
            this.f3728lt.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.f3728lt != drawable) {
            if (this.f3728lt != null) {
                this.f3728lt.setCallback(null);
                unscheduleDrawable(this.f3728lt);
            }
            this.f3728lt = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f3731lw == C31128d.MIC_AVROUND_BLUR) {
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
        return this.f3728lt;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f3733ly |= z;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3733ly = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3728lt != null) {
            Drawable drawable = this.f3728lt;
            if (this.f3733ly) {
                this.f3733ly = false;
                Rect rect = this.f3729lu;
                Rect rect2 = this.f3730lv;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f3732lx) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f3731lw, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f3728lt != null) {
            this.f3728lt.setHotspot(f, f2);
        }
    }
}
