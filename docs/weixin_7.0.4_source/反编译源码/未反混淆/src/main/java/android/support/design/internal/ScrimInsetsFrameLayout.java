package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.v4.view.aa;
import android.support.v4.view.o;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class ScrimInsetsFrameLayout extends FrameLayout {
    Drawable lX;
    Rect lY;
    private Rect mTempRect;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.ScrimInsetsFrameLayout, i, R.style.yr);
        this.lX = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        s.a((View) this, new o() {
            public final aa a(View view, aa aaVar) {
                boolean hasSystemWindowInsets;
                if (ScrimInsetsFrameLayout.this.lY == null) {
                    ScrimInsetsFrameLayout.this.lY = new Rect();
                }
                ScrimInsetsFrameLayout.this.lY.set(aaVar.getSystemWindowInsetLeft(), aaVar.getSystemWindowInsetTop(), aaVar.getSystemWindowInsetRight(), aaVar.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.a(aaVar);
                ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
                if (VERSION.SDK_INT >= 20) {
                    hasSystemWindowInsets = ((WindowInsets) aaVar.NF).hasSystemWindowInsets();
                } else {
                    hasSystemWindowInsets = false;
                }
                hasSystemWindowInsets = !hasSystemWindowInsets || ScrimInsetsFrameLayout.this.lX == null;
                scrimInsetsFrameLayout.setWillNotDraw(hasSystemWindowInsets);
                s.R(ScrimInsetsFrameLayout.this);
                return aaVar.et();
            }
        });
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.lY != null && this.lX != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.mTempRect.set(0, 0, width, this.lY.top);
            this.lX.setBounds(this.mTempRect);
            this.lX.draw(canvas);
            this.mTempRect.set(0, height - this.lY.bottom, width, height);
            this.lX.setBounds(this.mTempRect);
            this.lX.draw(canvas);
            this.mTempRect.set(0, this.lY.top, this.lY.left, height - this.lY.bottom);
            this.lX.setBounds(this.mTempRect);
            this.lX.draw(canvas);
            this.mTempRect.set(width - this.lY.right, this.lY.top, width, height - this.lY.bottom);
            this.lX.setBounds(this.mTempRect);
            this.lX.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.lX != null) {
            this.lX.setCallback(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.lX != null) {
            this.lX.setCallback(null);
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(aa aaVar) {
    }
}
