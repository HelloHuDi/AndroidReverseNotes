package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.C37097a.C37096a;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0472o;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.tencent.p177mm.C25738R;

public class ScrimInsetsFrameLayout extends FrameLayout {
    /* renamed from: lX */
    Drawable f2160lX;
    /* renamed from: lY */
    Rect f2161lY;
    private Rect mTempRect;

    /* renamed from: android.support.design.internal.ScrimInsetsFrameLayout$1 */
    class C61681 implements C0472o {
        C61681() {
        }

        /* renamed from: a */
        public final C0451aa mo1083a(View view, C0451aa c0451aa) {
            boolean hasSystemWindowInsets;
            if (ScrimInsetsFrameLayout.this.f2161lY == null) {
                ScrimInsetsFrameLayout.this.f2161lY = new Rect();
            }
            ScrimInsetsFrameLayout.this.f2161lY.set(c0451aa.getSystemWindowInsetLeft(), c0451aa.getSystemWindowInsetTop(), c0451aa.getSystemWindowInsetRight(), c0451aa.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.mo18111a(c0451aa);
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (VERSION.SDK_INT >= 20) {
                hasSystemWindowInsets = ((WindowInsets) c0451aa.f550NF).hasSystemWindowInsets();
            } else {
                hasSystemWindowInsets = false;
            }
            hasSystemWindowInsets = !hasSystemWindowInsets || ScrimInsetsFrameLayout.this.f2160lX == null;
            scrimInsetsFrameLayout.setWillNotDraw(hasSystemWindowInsets);
            C0477s.m891R(ScrimInsetsFrameLayout.this);
            return c0451aa.mo1033et();
        }
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.ScrimInsetsFrameLayout, i, C25738R.style.f11383yr);
        this.f2160lX = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        C0477s.m906a((View) this, new C61681());
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2161lY != null && this.f2160lX != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.mTempRect.set(0, 0, width, this.f2161lY.top);
            this.f2160lX.setBounds(this.mTempRect);
            this.f2160lX.draw(canvas);
            this.mTempRect.set(0, height - this.f2161lY.bottom, width, height);
            this.f2160lX.setBounds(this.mTempRect);
            this.f2160lX.draw(canvas);
            this.mTempRect.set(0, this.f2161lY.top, this.f2161lY.left, height - this.f2161lY.bottom);
            this.f2160lX.setBounds(this.mTempRect);
            this.f2160lX.draw(canvas);
            this.mTempRect.set(width - this.f2161lY.right, this.f2161lY.top, width, height - this.f2161lY.bottom);
            this.f2160lX.setBounds(this.mTempRect);
            this.f2160lX.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2160lX != null) {
            this.f2160lX.setCallback(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2160lX != null) {
            this.f2160lX.setCallback(null);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo18111a(C0451aa c0451aa) {
    }
}
