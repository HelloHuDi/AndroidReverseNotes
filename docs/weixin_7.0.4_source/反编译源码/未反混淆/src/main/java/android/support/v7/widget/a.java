package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v4.view.x;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.mm.R;

abstract class a extends ViewGroup {
    private boolean acA;
    private boolean acB;
    protected final a acu = new a();
    protected final Context acv;
    protected ActionMenuView acw;
    protected ActionMenuPresenter acx;
    protected int acy;
    protected w acz;

    protected class a implements x {
        int BD;
        private boolean xH = false;

        protected a() {
        }

        public final a a(w wVar, int i) {
            a.this.acz = wVar;
            this.BD = i;
            return this;
        }

        public final void az(View view) {
            super.setVisibility(0);
            this.xH = false;
        }

        public final void aA(View view) {
            if (!this.xH) {
                a.this.acz = null;
                super.setVisibility(this.BD);
            }
        }

        public final void aB(View view) {
            this.xH = true;
        }
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.ds, typedValue, true) || typedValue.resourceId == 0) {
            this.acv = context;
        } else {
            this.acv = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, android.support.v7.a.a.a.ActionBar, R.attr.dt, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(0, 0));
        obtainStyledAttributes.recycle();
        if (this.acx != null) {
            this.acx.gY();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.acA = false;
        }
        if (!this.acA) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.acA = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.acA = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.acB = false;
        }
        if (!this.acB) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.acB = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.acB = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.acy = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.acy;
    }

    public int getAnimatedVisibility() {
        if (this.acz != null) {
            return this.acu.BD;
        }
        return getVisibility();
    }

    public w c(int i, long j) {
        if (this.acz != null) {
            this.acz.cancel();
        }
        w t;
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            t = s.ab(this).t(1.0f);
            t.l(j);
            t.a(this.acu.a(t, i));
            return t;
        }
        t = s.ab(this).t(0.0f);
        t.l(j);
        t.a(this.acu.a(t, i));
        return t;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.acz != null) {
                this.acz.cancel();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        if (this.acx != null) {
            return this.acx.showOverflowMenu();
        }
        return false;
    }

    protected static int j(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, j.INVALID_ID), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int c(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
