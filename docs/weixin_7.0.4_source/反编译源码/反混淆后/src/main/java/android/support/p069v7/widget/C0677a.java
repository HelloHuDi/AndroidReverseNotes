package android.support.p069v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C0499x;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.a */
abstract class C0677a extends ViewGroup {
    private boolean acA;
    private boolean acB;
    protected final C0678a acu = new C0678a();
    protected final Context acv;
    protected ActionMenuView acw;
    protected ActionMenuPresenter acx;
    protected int acy;
    protected C0497w acz;

    /* renamed from: android.support.v7.widget.a$a */
    protected class C0678a implements C0499x {
        /* renamed from: BD */
        int f1006BD;
        /* renamed from: xH */
        private boolean f1007xH = false;

        protected C0678a() {
        }

        /* renamed from: a */
        public final C0678a mo1929a(C0497w c0497w, int i) {
            C0677a.this.acz = c0497w;
            this.f1006BD = i;
            return this;
        }

        /* renamed from: az */
        public final void mo1166az(View view) {
            super.setVisibility(0);
            this.f1007xH = false;
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            if (!this.f1007xH) {
                C0677a.this.acz = null;
                super.setVisibility(this.f1006BD);
            }
        }

        /* renamed from: aB */
        public final void mo1165aB(View view) {
            this.f1007xH = true;
        }
    }

    C0677a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C25738R.attr.f5613ds, typedValue, true) || typedValue.resourceId == 0) {
            this.acv = context;
        } else {
            this.acv = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0554a.ActionBar, C25738R.attr.f5614dt, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(0, 0));
        obtainStyledAttributes.recycle();
        if (this.acx != null) {
            this.acx.mo16477gY();
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
            return this.acu.f1006BD;
        }
        return getVisibility();
    }

    /* renamed from: c */
    public C0497w mo1920c(int i, long j) {
        if (this.acz != null) {
            this.acz.cancel();
        }
        C0497w t;
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            t = C0477s.m910ab(this).mo1161t(1.0f);
            t.mo1158l(j);
            t.mo1153a(this.acu.mo1929a(t, i));
            return t;
        }
        t = C0477s.m910ab(this).mo1161t(0.0f);
        t.mo1158l(j);
        t.mo1153a(this.acu.mo1929a(t, i));
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

    /* renamed from: j */
    protected static int m1522j(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, C8415j.INVALID_ID), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    /* renamed from: c */
    protected static int m1521c(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* renamed from: a */
    protected static int m1518a(View view, int i, int i2, int i3, boolean z) {
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
