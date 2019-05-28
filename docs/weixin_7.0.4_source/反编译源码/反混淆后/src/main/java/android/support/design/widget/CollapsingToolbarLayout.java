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
import android.support.design.C37097a.C37096a;
import android.support.design.widget.AppBarLayout.C8325a;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.p065f.C37121i;
import android.support.p057v4.p1154c.C17435a;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0472o;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C31872u;
import android.support.p069v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;

public class CollapsingToolbarLayout extends FrameLayout {
    /* renamed from: mp */
    C0451aa f5077mp;
    /* renamed from: oK */
    private boolean f5078oK;
    /* renamed from: oL */
    private int f5079oL;
    /* renamed from: oM */
    private Toolbar f5080oM;
    /* renamed from: oN */
    private View f5081oN;
    /* renamed from: oO */
    private View f5082oO;
    /* renamed from: oP */
    private int f5083oP;
    /* renamed from: oQ */
    private int f5084oQ;
    /* renamed from: oR */
    private int f5085oR;
    /* renamed from: oS */
    private int f5086oS;
    /* renamed from: oT */
    private final Rect f5087oT;
    /* renamed from: oU */
    final C44944f f5088oU;
    /* renamed from: oV */
    private boolean f5089oV;
    /* renamed from: oW */
    private boolean f5090oW;
    /* renamed from: oX */
    private Drawable f5091oX;
    /* renamed from: oY */
    Drawable f5092oY;
    /* renamed from: oZ */
    private int f5093oZ;
    /* renamed from: pa */
    private boolean f5094pa;
    /* renamed from: pb */
    private ValueAnimator f5095pb;
    /* renamed from: pc */
    private long f5096pc;
    /* renamed from: pd */
    private int f5097pd;
    /* renamed from: pe */
    private C8325a f5098pe;
    /* renamed from: pg */
    int f5099pg;

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$1 */
    class C173831 implements C0472o {
        C173831() {
        }

        /* renamed from: a */
        public final C0451aa mo1083a(View view, C0451aa c0451aa) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            Object obj = null;
            if (C0477s.m920al(collapsingToolbarLayout)) {
                obj = c0451aa;
            }
            if (!C37121i.equals(collapsingToolbarLayout.f5077mp, obj)) {
                collapsingToolbarLayout.f5077mp = obj;
                collapsingToolbarLayout.requestLayout();
            }
            return c0451aa.mo1033et();
        }
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        /* renamed from: pi */
        int f3740pi = 0;
        /* renamed from: pj */
        float f3741pj = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.CollapsingToolbarLayout_Layout);
            this.f3740pi = obtainStyledAttributes.getInt(0, 0);
            this.f3741pj = obtainStyledAttributes.getFloat(1, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$2 */
    class C253052 implements AnimatorUpdateListener {
        C253052() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: android.support.design.widget.CollapsingToolbarLayout$a */
    class C25306a implements C8325a {
        C25306a() {
        }

        /* renamed from: H */
        public final void mo18157H(int i) {
            int systemWindowInsetTop;
            CollapsingToolbarLayout.this.f5099pg = i;
            if (CollapsingToolbarLayout.this.f5077mp != null) {
                systemWindowInsetTop = CollapsingToolbarLayout.this.f5077mp.getSystemWindowInsetTop();
            } else {
                systemWindowInsetTop = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                C41489p m = CollapsingToolbarLayout.m39899m(childAt);
                switch (layoutParams.f3740pi) {
                    case 1:
                        m.mo66228G(C17435a.clamp(-i, 0, CollapsingToolbarLayout.this.mo42210n(childAt)));
                        break;
                    case 2:
                        m.mo66228G(Math.round(layoutParams.f3741pj * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            CollapsingToolbarLayout.this.mo42188bX();
            if (CollapsingToolbarLayout.this.f5092oY != null && systemWindowInsetTop > 0) {
                C0477s.m891R(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.f5088oU.mo72158i(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - C0477s.m909aa(CollapsingToolbarLayout.this)) - systemWindowInsetTop)));
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5078oK = true;
        this.f5087oT = new Rect();
        this.f5097pd = -1;
        C41488o.m72457G(context);
        this.f5088oU = new C44944f(this);
        this.f5088oU.mo72151b(C31841a.f14583mj);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.CollapsingToolbarLayout, i, C25738R.style.f11379yn);
        this.f5088oU.mo72145P(obtainStyledAttributes.getInt(14, 8388691));
        this.f5088oU.mo72146Q(obtainStyledAttributes.getInt(13, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f5086oS = dimensionPixelSize;
        this.f5085oR = dimensionPixelSize;
        this.f5084oQ = dimensionPixelSize;
        this.f5083oP = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(2)) {
            this.f5083oP = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f5085oR = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f5084oQ = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        }
        if (obtainStyledAttributes.hasValue(5)) {
            this.f5086oS = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        }
        this.f5089oV = obtainStyledAttributes.getBoolean(15, true);
        setTitle(obtainStyledAttributes.getText(0));
        this.f5088oU.mo72148S(C25738R.style.f11230to);
        this.f5088oU.mo72147R(C25738R.style.f11218t7);
        if (obtainStyledAttributes.hasValue(6)) {
            this.f5088oU.mo72148S(obtainStyledAttributes.getResourceId(6, 0));
        }
        if (obtainStyledAttributes.hasValue(7)) {
            this.f5088oU.mo72147R(obtainStyledAttributes.getResourceId(7, 0));
        }
        this.f5097pd = obtainStyledAttributes.getDimensionPixelSize(11, -1);
        this.f5096pc = (long) obtainStyledAttributes.getInt(12, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(8));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(9));
        this.f5079oL = obtainStyledAttributes.getResourceId(10, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        C0477s.m906a((View) this, new C173831());
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            C0477s.m942e((View) this, C0477s.m920al((View) parent));
            if (this.f5098pe == null) {
                this.f5098pe = new C25306a();
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            C8325a c8325a = this.f5098pe;
            if (appBarLayout.f2183mq == null) {
                appBarLayout.f2183mq = new ArrayList();
            }
            if (!(c8325a == null || appBarLayout.f2183mq.contains(c8325a))) {
                appBarLayout.f2183mq.add(c8325a);
            }
            C0477s.m919ak(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f5098pe != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            C8325a c8325a = this.f5098pe;
            if (!(appBarLayout.f2183mq == null || c8325a == null)) {
                appBarLayout.f2183mq.remove(c8325a);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m39895bV();
        if (this.f5080oM == null && this.f5091oX != null && this.f5093oZ > 0) {
            this.f5091oX.mutate().setAlpha(this.f5093oZ);
            this.f5091oX.draw(canvas);
        }
        if (this.f5089oV && this.f5090oW) {
            this.f5088oU.draw(canvas);
        }
        if (this.f5092oY != null && this.f5093oZ > 0) {
            int systemWindowInsetTop = this.f5077mp != null ? this.f5077mp.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.f5092oY.setBounds(0, -this.f5099pg, getWidth(), systemWindowInsetTop - this.f5099pg);
                this.f5092oY.mutate().setAlpha(this.f5093oZ);
                this.f5092oY.draw(canvas);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.f5091oX != null && this.f5093oZ > 0) {
            z = (this.f5081oN == null || this.f5081oN == this) ? view == this.f5080oM : view == this.f5081oN;
            if (z) {
                this.f5091oX.mutate().setAlpha(this.f5093oZ);
                this.f5091oX.draw(canvas);
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
        if (this.f5091oX != null) {
            this.f5091oX.setBounds(0, 0, i, i2);
        }
    }

    /* renamed from: bV */
    private void m39895bV() {
        if (this.f5078oK) {
            this.f5080oM = null;
            this.f5081oN = null;
            if (this.f5079oL != -1) {
                this.f5080oM = (Toolbar) findViewById(this.f5079oL);
                if (this.f5080oM != null) {
                    this.f5081oN = m39897k(this.f5080oM);
                }
            }
            if (this.f5080oM == null) {
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
                this.f5080oM = toolbar;
            }
            m39896bW();
            this.f5078oK = false;
        }
    }

    /* renamed from: k */
    private View m39897k(View view) {
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

    /* renamed from: bW */
    private void m39896bW() {
        if (!(this.f5089oV || this.f5082oO == null)) {
            ViewParent parent = this.f5082oO.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f5082oO);
            }
        }
        if (this.f5089oV && this.f5080oM != null) {
            if (this.f5082oO == null) {
                this.f5082oO = new View(getContext());
            }
            if (this.f5082oO.getParent() == null) {
                this.f5080oM.addView(this.f5082oO, -1, -1);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        m39895bV();
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i2);
        int systemWindowInsetTop = this.f5077mp != null ? this.f5077mp.getSystemWindowInsetTop() : 0;
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
        if (this.f5077mp != null) {
            systemWindowInsetTop = this.f5077mp.getSystemWindowInsetTop();
            childCount = getChildCount();
            for (i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!C0477s.m920al(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    C0477s.m951q(childAt, systemWindowInsetTop);
                }
            }
        }
        if (this.f5089oV && this.f5082oO != null) {
            boolean z2 = C0477s.m930av(this.f5082oO) && this.f5082oO.getVisibility() == 0;
            this.f5090oW = z2;
            if (this.f5090oW) {
                if (C0477s.m893T(this) != 1) {
                    i6 = 0;
                }
                systemWindowInsetTop = mo42210n(this.f5081oN != null ? this.f5081oN : this.f5080oM);
                C31872u.m51651a((ViewGroup) this, this.f5082oO, this.f5087oT);
                C44944f c44944f = this.f5088oU;
                int i8 = this.f5087oT.left;
                if (i6 != 0) {
                    i5 = this.f5080oM.getTitleMarginEnd();
                } else {
                    i5 = this.f5080oM.getTitleMarginStart();
                }
                i8 += i5;
                int titleMarginTop = this.f5080oM.getTitleMarginTop() + (this.f5087oT.top + systemWindowInsetTop);
                int i9 = this.f5087oT.right;
                if (i6 != 0) {
                    i5 = this.f5080oM.getTitleMarginStart();
                } else {
                    i5 = this.f5080oM.getTitleMarginEnd();
                }
                c44944f.mo72156d(i8, titleMarginTop, i5 + i9, (systemWindowInsetTop + this.f5087oT.bottom) - this.f5080oM.getTitleMarginBottom());
                C44944f c44944f2 = this.f5088oU;
                i5 = i6 != 0 ? this.f5085oR : this.f5083oP;
                childCount = this.f5087oT.top + this.f5084oQ;
                i8 = i3 - i;
                if (i6 != 0) {
                    i6 = this.f5083oP;
                } else {
                    i6 = this.f5085oR;
                }
                c44944f2.mo72154c(i5, childCount, i8 - i6, (i4 - i2) - this.f5086oS);
                this.f5088oU.mo72153bT();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            m39899m(getChildAt(i7)).mo66229cD();
            i7++;
        }
        if (this.f5080oM != null) {
            if (this.f5089oV && TextUtils.isEmpty(this.f5088oU.mText)) {
                this.f5088oU.setText(this.f5080oM.getTitle());
            }
            if (this.f5081oN == null || this.f5081oN == this) {
                setMinimumHeight(m39898l(this.f5080oM));
            } else {
                setMinimumHeight(m39898l(this.f5081oN));
            }
        }
        mo42188bX();
    }

    /* renamed from: l */
    private static int m39898l(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    /* renamed from: m */
    static C41489p m39899m(View view) {
        C41489p c41489p = (C41489p) view.getTag(2131820686);
        if (c41489p != null) {
            return c41489p;
        }
        c41489p = new C41489p(view);
        view.setTag(2131820686, c41489p);
        return c41489p;
    }

    public void setTitle(CharSequence charSequence) {
        this.f5088oU.setText(charSequence);
    }

    public CharSequence getTitle() {
        if (this.f5089oV) {
            return this.f5088oU.mText;
        }
        return null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f5089oV) {
            this.f5089oV = z;
            m39896bW();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        int i;
        int i2 = 255;
        if (!C0477s.m927as(this) || isInEditMode()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.f5094pa != z) {
            if (i != 0) {
                i = z ? 255 : 0;
                m39895bV();
                if (this.f5095pb == null) {
                    this.f5095pb = new ValueAnimator();
                    this.f5095pb.setDuration(this.f5096pc);
                    this.f5095pb.setInterpolator(i > this.f5093oZ ? C31841a.f14581mh : C31841a.f14582mi);
                    this.f5095pb.addUpdateListener(new C253052());
                } else if (this.f5095pb.isRunning()) {
                    this.f5095pb.cancel();
                }
                this.f5095pb.setIntValues(new int[]{this.f5093oZ, i});
                this.f5095pb.start();
            } else {
                if (!z) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.f5094pa = z;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrimAlpha(int i) {
        if (i != this.f5093oZ) {
            if (!(this.f5091oX == null || this.f5080oM == null)) {
                C0477s.m891R(this.f5080oM);
            }
            this.f5093oZ = i;
            C0477s.m891R(this);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int getScrimAlpha() {
        return this.f5093oZ;
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f5091oX != drawable) {
            if (this.f5091oX != null) {
                this.f5091oX.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f5091oX = drawable2;
            if (this.f5091oX != null) {
                this.f5091oX.setBounds(0, 0, getWidth(), getHeight());
                this.f5091oX.setCallback(this);
                this.f5091oX.setAlpha(this.f5093oZ);
            }
            C0477s.m891R(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(C0380b.m649g(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f5091oX;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f5092oY != drawable) {
            if (this.f5092oY != null) {
                this.f5092oY.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f5092oY = drawable2;
            if (this.f5092oY != null) {
                if (this.f5092oY.isStateful()) {
                    this.f5092oY.setState(getDrawableState());
                }
                C0280a.m463b(this.f5092oY, C0477s.m893T(this));
                this.f5092oY.setVisible(getVisibility() == 0, false);
                this.f5092oY.setCallback(this);
                this.f5092oY.setAlpha(this.f5093oZ);
            }
            C0477s.m891R(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f5092oY;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.f5091oX;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (this.f5088oU != null) {
            i |= this.f5088oU.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f5091oX || drawable == this.f5092oY;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.f5092oY == null || this.f5092oY.isVisible() == z)) {
            this.f5092oY.setVisible(z, false);
        }
        if (this.f5091oX != null && this.f5091oX.isVisible() != z) {
            this.f5091oX.setVisible(z, false);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(C0380b.m649g(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f5092oY;
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f5088oU.mo72147R(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f5088oU.mo72150b(colorStateList);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f5088oU.mo72146Q(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f5088oU.f17634oa;
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f5088oU.mo72148S(i);
    }

    public void setExpandedTitleColor(int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f5088oU.mo72155c(colorStateList);
    }

    public void setExpandedTitleGravity(int i) {
        this.f5088oU.mo72145P(i);
    }

    public int getExpandedTitleGravity() {
        return this.f5088oU.f17623nZ;
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        C44944f c44944f = this.f5088oU;
        if (C44944f.m82182a(c44944f.f17645ol, typeface)) {
            c44944f.f17645ol = typeface;
            c44944f.mo72153bT();
        }
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f5088oU.mo72152bN();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        C44944f c44944f = this.f5088oU;
        if (C44944f.m82182a(c44944f.f17646om, typeface)) {
            c44944f.f17646om = typeface;
            c44944f.mo72153bT();
        }
    }

    public Typeface getExpandedTitleTypeface() {
        C44944f c44944f = this.f5088oU;
        return c44944f.f17646om != null ? c44944f.f17646om : Typeface.DEFAULT;
    }

    public int getExpandedTitleMarginStart() {
        return this.f5083oP;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f5083oP = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f5084oQ;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f5084oQ = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f5085oR;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f5085oR = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f5086oS;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f5086oS = i;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int i) {
        if (this.f5097pd != i) {
            this.f5097pd = i;
            mo42188bX();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.f5097pd >= 0) {
            return this.f5097pd;
        }
        int systemWindowInsetTop = this.f5077mp != null ? this.f5077mp.getSystemWindowInsetTop() : 0;
        int aa = C0477s.m909aa(this);
        if (aa > 0) {
            return Math.min(systemWindowInsetTop + (aa * 2), getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long j) {
        this.f5096pc = j;
    }

    public long getScrimAnimationDuration() {
        return this.f5096pc;
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bX */
    public final void mo42188bX() {
        if (this.f5091oX != null || this.f5092oY != null) {
            setScrimsShown(getHeight() + this.f5099pg < getScrimVisibleHeightTrigger());
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: n */
    public final int mo42210n(View view) {
        return ((getHeight() - m39899m(view).f16758ua) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }
}
