package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.support.v4.f.i;
import android.support.v4.view.aa;
import android.support.v4.view.o;
import android.support.v4.view.s;
import android.support.v4.widget.u;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import java.util.ArrayList;

public class CollapsingToolbarLayout extends FrameLayout {
    aa mp;
    private boolean oK;
    private int oL;
    private Toolbar oM;
    private View oN;
    private View oO;
    private int oP;
    private int oQ;
    private int oR;
    private int oS;
    private final Rect oT;
    final f oU;
    private boolean oV;
    private boolean oW;
    private Drawable oX;
    Drawable oY;
    private int oZ;
    private boolean pa;
    private ValueAnimator pb;
    private long pc;
    private int pd;
    private android.support.design.widget.AppBarLayout.a pe;
    int pg;

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int pi = 0;
        float pj = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.CollapsingToolbarLayout_Layout);
            this.pi = obtainStyledAttributes.getInt(0, 0);
            this.pj = obtainStyledAttributes.getFloat(1, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class a implements android.support.design.widget.AppBarLayout.a {
        a() {
        }

        public final void H(int i) {
            int systemWindowInsetTop;
            CollapsingToolbarLayout.this.pg = i;
            if (CollapsingToolbarLayout.this.mp != null) {
                systemWindowInsetTop = CollapsingToolbarLayout.this.mp.getSystemWindowInsetTop();
            } else {
                systemWindowInsetTop = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                p m = CollapsingToolbarLayout.m(childAt);
                switch (layoutParams.pi) {
                    case 1:
                        m.G(android.support.v4.c.a.clamp(-i, 0, CollapsingToolbarLayout.this.n(childAt)));
                        break;
                    case 2:
                        m.G(Math.round(layoutParams.pj * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            CollapsingToolbarLayout.this.bX();
            if (CollapsingToolbarLayout.this.oY != null && systemWindowInsetTop > 0) {
                s.R(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.oU.i(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - s.aa(CollapsingToolbarLayout.this)) - systemWindowInsetTop)));
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oK = true;
        this.oT = new Rect();
        this.pd = -1;
        o.G(context);
        this.oU = new f(this);
        this.oU.b(a.mj);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.CollapsingToolbarLayout, i, R.style.yn);
        this.oU.P(obtainStyledAttributes.getInt(14, 8388691));
        this.oU.Q(obtainStyledAttributes.getInt(13, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.oS = dimensionPixelSize;
        this.oR = dimensionPixelSize;
        this.oQ = dimensionPixelSize;
        this.oP = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(2)) {
            this.oP = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.oR = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.oQ = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.oS = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        }
        this.oV = obtainStyledAttributes.getBoolean(15, true);
        setTitle(obtainStyledAttributes.getText(0));
        this.oU.S(R.style.to);
        this.oU.R(R.style.t7);
        if (obtainStyledAttributes.hasValue(6)) {
            this.oU.S(obtainStyledAttributes.getResourceId(6, 0));
        }
        if (obtainStyledAttributes.hasValue(7)) {
            this.oU.R(obtainStyledAttributes.getResourceId(7, 0));
        }
        this.pd = obtainStyledAttributes.getDimensionPixelSize(11, -1);
        this.pc = (long) obtainStyledAttributes.getInt(12, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(8));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(9));
        this.oL = obtainStyledAttributes.getResourceId(10, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        s.a((View) this, new o() {
            public final aa a(View view, aa aaVar) {
                CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
                Object obj = null;
                if (s.al(collapsingToolbarLayout)) {
                    obj = aaVar;
                }
                if (!i.equals(collapsingToolbarLayout.mp, obj)) {
                    collapsingToolbarLayout.mp = obj;
                    collapsingToolbarLayout.requestLayout();
                }
                return aaVar.et();
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            s.e((View) this, s.al((View) parent));
            if (this.pe == null) {
                this.pe = new a();
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            android.support.design.widget.AppBarLayout.a aVar = this.pe;
            if (appBarLayout.mq == null) {
                appBarLayout.mq = new ArrayList();
            }
            if (!(aVar == null || appBarLayout.mq.contains(aVar))) {
                appBarLayout.mq.add(aVar);
            }
            s.ak(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.pe != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            android.support.design.widget.AppBarLayout.a aVar = this.pe;
            if (!(appBarLayout.mq == null || aVar == null)) {
                appBarLayout.mq.remove(aVar);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        bV();
        if (this.oM == null && this.oX != null && this.oZ > 0) {
            this.oX.mutate().setAlpha(this.oZ);
            this.oX.draw(canvas);
        }
        if (this.oV && this.oW) {
            this.oU.draw(canvas);
        }
        if (this.oY != null && this.oZ > 0) {
            int systemWindowInsetTop = this.mp != null ? this.mp.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.oY.setBounds(0, -this.pg, getWidth(), systemWindowInsetTop - this.pg);
                this.oY.mutate().setAlpha(this.oZ);
                this.oY.draw(canvas);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.oX != null && this.oZ > 0) {
            z = (this.oN == null || this.oN == this) ? view == this.oM : view == this.oN;
            if (z) {
                this.oX.mutate().setAlpha(this.oZ);
                this.oX.draw(canvas);
                z = true;
                if (!super.drawChild(canvas, view, j) || r0) {
                    return true;
                }
                return false;
            }
        }
        z = false;
        if (!super.drawChild(canvas, view, j)) {
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.oX != null) {
            this.oX.setBounds(0, 0, i, i2);
        }
    }

    private void bV() {
        if (this.oK) {
            this.oM = null;
            this.oN = null;
            if (this.oL != -1) {
                this.oM = (Toolbar) findViewById(this.oL);
                if (this.oM != null) {
                    this.oN = k(this.oM);
                }
            }
            if (this.oM == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                toolbar = null;
                this.oM = toolbar;
            }
            bW();
            this.oK = false;
        }
    }

    private View k(View view) {
        CollapsingToolbarLayout parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    private void bW() {
        if (!(this.oV || this.oO == null)) {
            ViewParent parent = this.oO.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.oO);
            }
        }
        if (this.oV && this.oM != null) {
            if (this.oO == null) {
                this.oO = new View(getContext());
            }
            if (this.oO.getParent() == null) {
                this.oM.addView(this.oO, -1, -1);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        bV();
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i2);
        int systemWindowInsetTop = this.mp != null ? this.mp.getSystemWindowInsetTop() : 0;
        if (mode == 0 && systemWindowInsetTop > 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(systemWindowInsetTop + getMeasuredHeight(), ErrorDialogData.SUPPRESSED));
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int systemWindowInsetTop;
        int childCount;
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.mp != null) {
            systemWindowInsetTop = this.mp.getSystemWindowInsetTop();
            childCount = getChildCount();
            for (i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!s.al(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    s.q(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.oV && this.oO != null) {
            boolean z2 = s.av(this.oO) && this.oO.getVisibility() == 0;
            this.oW = z2;
            if (this.oW) {
                if (s.T(this) != 1) {
                    i6 = 0;
                }
                systemWindowInsetTop = n(this.oN != null ? this.oN : this.oM);
                u.a((ViewGroup) this, this.oO, this.oT);
                f fVar = this.oU;
                int i8 = this.oT.left;
                if (i6 != 0) {
                    i5 = this.oM.getTitleMarginEnd();
                } else {
                    i5 = this.oM.getTitleMarginStart();
                }
                i8 += i5;
                int titleMarginTop = this.oM.getTitleMarginTop() + (this.oT.top + systemWindowInsetTop);
                int i9 = this.oT.right;
                if (i6 != 0) {
                    i5 = this.oM.getTitleMarginStart();
                } else {
                    i5 = this.oM.getTitleMarginEnd();
                }
                fVar.d(i8, titleMarginTop, i5 + i9, (systemWindowInsetTop + this.oT.bottom) - this.oM.getTitleMarginBottom());
                f fVar2 = this.oU;
                i5 = i6 != 0 ? this.oR : this.oP;
                childCount = this.oT.top + this.oQ;
                i8 = i3 - i;
                if (i6 != 0) {
                    i6 = this.oP;
                } else {
                    i6 = this.oR;
                }
                fVar2.c(i5, childCount, i8 - i6, (i4 - i2) - this.oS);
                this.oU.bT();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            m(getChildAt(i7)).cD();
            i7++;
        }
        if (this.oM != null) {
            if (this.oV && TextUtils.isEmpty(this.oU.mText)) {
                this.oU.setText(this.oM.getTitle());
            }
            if (this.oN == null || this.oN == this) {
                setMinimumHeight(l(this.oM));
            } else {
                setMinimumHeight(l(this.oN));
            }
        }
        bX();
    }

    private static int l(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    static p m(View view) {
        p pVar = (p) view.getTag(R.id.d5);
        if (pVar != null) {
            return pVar;
        }
        pVar = new p(view);
        view.setTag(R.id.d5, pVar);
        return pVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.oU.setText(charSequence);
    }

    public CharSequence getTitle() {
        if (this.oV) {
            return this.oU.mText;
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.oV) {
            this.oV = z;
            bW();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        int i;
        int i2 = 255;
        if (!s.as(this) || isInEditMode()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.pa != z) {
            if (i != 0) {
                i = z ? 255 : 0;
                bV();
                if (this.pb == null) {
                    this.pb = new ValueAnimator();
                    this.pb.setDuration(this.pc);
                    this.pb.setInterpolator(i > this.oZ ? a.mh : a.mi);
                    this.pb.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                } else if (this.pb.isRunning()) {
                    this.pb.cancel();
                }
                this.pb.setIntValues(new int[]{this.oZ, i});
                this.pb.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.pa = z;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrimAlpha(int i) {
        if (i != this.oZ) {
            if (!(this.oX == null || this.oM == null)) {
                s.R(this.oM);
            }
            this.oZ = i;
            s.R(this);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int getScrimAlpha() {
        return this.oZ;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.oX != drawable) {
            if (this.oX != null) {
                this.oX.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.oX = drawable2;
            if (this.oX != null) {
                this.oX.setBounds(0, 0, getWidth(), getHeight());
                this.oX.setCallback(this);
                this.oX.setAlpha(this.oZ);
            }
            s.R(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(b.g(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.oX;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.oY != drawable) {
            if (this.oY != null) {
                this.oY.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.oY = drawable2;
            if (this.oY != null) {
                if (this.oY.isStateful()) {
                    this.oY.setState(getDrawableState());
                }
                android.support.v4.a.a.a.b(this.oY, s.T(this));
                this.oY.setVisible(getVisibility() == 0, false);
                this.oY.setCallback(this);
                this.oY.setAlpha(this.oZ);
            }
            s.R(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.oY;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.oX;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (this.oU != null) {
            i |= this.oU.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.oX || drawable == this.oY;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.oY == null || this.oY.isVisible() == z)) {
            this.oY.setVisible(z, false);
        }
        if (this.oX != null && this.oX.isVisible() != z) {
            this.oX.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(b.g(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.oY;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.oU.R(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.oU.b(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.oU.Q(i);
    }

    public int getCollapsedTitleGravity() {
        return this.oU.oa;
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.oU.S(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.oU.c(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.oU.P(i);
    }

    public int getExpandedTitleGravity() {
        return this.oU.nZ;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        f fVar = this.oU;
        if (f.a(fVar.ol, typeface)) {
            fVar.ol = typeface;
            fVar.bT();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.oU.bN();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        f fVar = this.oU;
        if (f.a(fVar.om, typeface)) {
            fVar.om = typeface;
            fVar.bT();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        f fVar = this.oU;
        return fVar.om != null ? fVar.om : Typeface.DEFAULT;
    }

    public int getExpandedTitleMarginStart() {
        return this.oP;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.oP = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.oQ;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.oQ = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.oR;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.oR = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.oS;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.oS = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.pd != i) {
            this.pd = i;
            bX();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.pd >= 0) {
            return this.pd;
        }
        int systemWindowInsetTop = this.mp != null ? this.mp.getSystemWindowInsetTop() : 0;
        int aa = s.aa(this);
        if (aa > 0) {
            return Math.min(systemWindowInsetTop + (aa * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.pc = j;
    }

    public long getScrimAnimationDuration() {
        return this.pc;
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: final */
    public final void bX() {
        if (this.oX != null || this.oY != null) {
            setScrimsShown(getHeight() + this.pg < getScrimVisibleHeightTrigger());
        }
    }

    /* Access modifiers changed, original: final */
    public final int n(View view) {
        return ((getHeight() - m(view).ua) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }
}
