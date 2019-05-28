package android.support.p069v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0470l;
import android.support.p057v4.view.C0471n;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.C25738R;

/* renamed from: android.support.v7.widget.ActionBarOverlayLayout */
public class ActionBarOverlayLayout extends ViewGroup implements C0470l, C0727w {
    /* renamed from: MT */
    static final int[] f1933MT = new int[]{C25738R.attr.f5618dx, 16842841};
    /* renamed from: Rk */
    private final C0471n f1934Rk;
    /* renamed from: Wk */
    private C0728x f1935Wk;
    /* renamed from: Xc */
    private boolean f1936Xc;
    private int acV;
    private int acW = 0;
    private ContentFrameLayout acX;
    ActionBarContainer acY;
    private Drawable acZ;
    private boolean ada;
    public boolean adb;
    private boolean adc;
    boolean add;
    private int ade;
    private int adf;
    private final Rect adg = new Rect();
    private final Rect adh = new Rect();
    private final Rect adi = new Rect();
    private final Rect adj = new Rect();
    private final Rect adk = new Rect();
    private final Rect adl = new Rect();
    private final Rect adm = new Rect();
    private C0639a adn;
    private final int ado = 600;
    private OverScroller adp;
    ViewPropertyAnimator adq;
    final AnimatorListenerAdapter adr = new C06361();
    private final Runnable ads = new C06372();
    private final Runnable adt = new C06383();

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$1 */
    class C06361 extends AnimatorListenerAdapter {
        C06361() {
        }

        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout.this.adq = null;
            ActionBarOverlayLayout.this.add = false;
        }

        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout.this.adq = null;
            ActionBarOverlayLayout.this.add = false;
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$2 */
    class C06372 implements Runnable {
        C06372() {
        }

        public final void run() {
            ActionBarOverlayLayout.this.mo14248gU();
            ActionBarOverlayLayout.this.adq = ActionBarOverlayLayout.this.acY.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.adr);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$3 */
    class C06383 implements Runnable {
        C06383() {
        }

        public final void run() {
            ActionBarOverlayLayout.this.mo14248gU();
            ActionBarOverlayLayout.this.adq = ActionBarOverlayLayout.this.acY.animate().translationY((float) (-ActionBarOverlayLayout.this.acY.getHeight())).setListener(ActionBarOverlayLayout.this.adr);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$LayoutParams */
    public static class LayoutParams extends MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: android.support.v7.widget.ActionBarOverlayLayout$a */
    public interface C0639a {
        /* renamed from: O */
        void mo1643O(boolean z);

        /* renamed from: fG */
        void mo1644fG();

        /* renamed from: fI */
        void mo1645fI();

        /* renamed from: fJ */
        void mo1646fJ();

        void onWindowVisibilityChanged(int i);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.f1934Rk = new C0471n(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1933MT);
        this.acV = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.acZ = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.acZ == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.ada = z;
        this.adp = new OverScroller(context);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo14248gU();
    }

    public void setActionBarVisibilityCallback(C0639a c0639a) {
        this.adn = c0639a;
        if (getWindowToken() != null) {
            this.adn.onWindowVisibilityChanged(this.acW);
            if (this.adf != 0) {
                onWindowSystemUiVisibilityChanged(this.adf);
                C0477s.m919ak(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.adb = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.ada = z2;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.adc = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        C0477s.m919ak(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m10153gT();
        int i2 = this.adf ^ i;
        this.adf = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.adn != null) {
            C0639a c0639a = this.adn;
            if (z) {
                z2 = false;
            }
            c0639a.mo1643O(z2);
            if (z3 || !z) {
                this.adn.mo1644fG();
            } else {
                this.adn.mo1645fI();
            }
        }
        if ((i2 & 256) != 0 && this.adn != null) {
            C0477s.m919ak(this);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.acW = i;
        if (this.adn != null) {
            this.adn.onWindowVisibilityChanged(i);
        }
    }

    /* renamed from: c */
    private static boolean m10152c(View view, Rect rect, boolean z) {
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z2 = true;
        }
        if (layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z2 = true;
        }
        if (layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == rect.bottom) {
            return z2;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean fitSystemWindows(Rect rect) {
        m10153gT();
        C0477s.m918aj(this);
        boolean c = ActionBarOverlayLayout.m10152c(this.acY, rect, false);
        this.adj.set(rect);
        C0709bk.m1575a(this, this.adj, this.adg);
        if (!this.adk.equals(this.adj)) {
            this.adk.set(this.adj);
            c = true;
        }
        if (!this.adh.equals(this.adg)) {
            this.adh.set(this.adg);
            c = true;
        }
        if (c) {
            requestLayout();
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        m10153gT();
        measureChildWithMargins(this.acY, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.acY.getLayoutParams();
        int max = Math.max(0, (this.acY.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.acY.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = View.combineMeasuredStates(0, this.acY.getMeasuredState());
        boolean z = (C0477s.m918aj(this) & 256) != 0;
        if (z) {
            i3 = this.acV;
            if (this.adc && this.acY.getTabContainer() != null) {
                i3 += this.acV;
            }
        } else {
            i3 = this.acY.getVisibility() != 8 ? this.acY.getMeasuredHeight() : 0;
        }
        this.adi.set(this.adg);
        this.adl.set(this.adj);
        Rect rect;
        Rect rect2;
        if (this.adb || z) {
            rect = this.adl;
            rect.top = i3 + rect.top;
            rect2 = this.adl;
            rect2.bottom += 0;
        } else {
            rect = this.adi;
            rect.top = i3 + rect.top;
            rect2 = this.adi;
            rect2.bottom += 0;
        }
        ActionBarOverlayLayout.m10152c(this.acX, this.adi, true);
        if (!this.adm.equals(this.adl)) {
            this.adm.set(this.adl);
            this.acX.mo1692g(this.adl);
        }
        measureChildWithMargins(this.acX, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.acX.getLayoutParams();
        int max3 = Math.max(max, (this.acX.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.acX.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.acX.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i7);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.acZ != null && !this.ada) {
            int bottom = this.acY.getVisibility() == 0 ? (int) ((((float) this.acY.getBottom()) + this.acY.getTranslationY()) + 0.5f) : 0;
            this.acZ.setBounds(0, bottom, getWidth(), this.acZ.getIntrinsicHeight() + bottom);
            this.acZ.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.acY.getVisibility() != 0) {
            return false;
        }
        return this.f1936Xc;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1934Rk.f565Ms = i;
        this.ade = getActionBarHideOffset();
        mo14248gU();
        if (this.adn != null) {
            this.adn.mo1646fJ();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.ade += i2;
        setActionBarHideOffset(this.ade);
    }

    public void onStopNestedScroll(View view) {
        if (this.f1936Xc && !this.add) {
            if (this.ade <= this.acY.getHeight()) {
                mo14248gU();
                postDelayed(this.ads, 600);
                return;
            }
            mo14248gU();
            postDelayed(this.adt, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.f1936Xc || !z) {
            return false;
        }
        this.adp.fling(0, 0, 0, (int) f2, 0, 0, C8415j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.adp.getFinalY() > this.acY.getHeight()) {
            z2 = true;
        }
        if (z2) {
            mo14248gU();
            this.adt.run();
        } else {
            mo14248gU();
            this.ads.run();
        }
        this.add = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1934Rk.f565Ms;
    }

    /* renamed from: gT */
    private void m10153gT() {
        if (this.acX == null) {
            this.acX = (ContentFrameLayout) findViewById(2131820544);
            this.acY = (ActionBarContainer) findViewById(2131820940);
            this.f1935Wk = ActionBarOverlayLayout.m10151aS(findViewById(2131820941));
        }
    }

    /* renamed from: aS */
    private static C0728x m10151aS(View view) {
        if (view instanceof C0728x) {
            return (C0728x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1936Xc) {
            this.f1936Xc = z;
            if (!z) {
                mo14248gU();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.acY != null ? -((int) this.acY.getTranslationY()) : 0;
    }

    public void setActionBarHideOffset(int i) {
        mo14248gU();
        this.acY.setTranslationY((float) (-Math.max(0, Math.min(i, this.acY.getHeight()))));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: gU */
    public final void mo14248gU() {
        removeCallbacks(this.ads);
        removeCallbacks(this.adt);
        if (this.adq != null) {
            this.adq.cancel();
        }
    }

    public void setWindowCallback(Callback callback) {
        m10153gT();
        this.f1935Wk.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m10153gT();
        this.f1935Wk.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        m10153gT();
        return this.f1935Wk.getTitle();
    }

    /* renamed from: bs */
    public final void mo2132bs(int i) {
        m10153gT();
        switch (i) {
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m10153gT();
        this.f1935Wk.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        m10153gT();
        this.f1935Wk.setIcon(drawable);
    }

    public void setLogo(int i) {
        m10153gT();
        this.f1935Wk.setLogo(i);
    }

    /* renamed from: gV */
    public final boolean mo2134gV() {
        m10153gT();
        return this.f1935Wk.mo2148gV();
    }

    public final boolean isOverflowMenuShowing() {
        m10153gT();
        return this.f1935Wk.isOverflowMenuShowing();
    }

    /* renamed from: gW */
    public final boolean mo2135gW() {
        m10153gT();
        return this.f1935Wk.mo2149gW();
    }

    public final boolean showOverflowMenu() {
        m10153gT();
        return this.f1935Wk.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        m10153gT();
        return this.f1935Wk.hideOverflowMenu();
    }

    /* renamed from: gX */
    public final void mo2136gX() {
        m10153gT();
        this.f1935Wk.mo2150gX();
    }

    /* renamed from: a */
    public final void mo2131a(Menu menu, C0627a c0627a) {
        m10153gT();
        this.f1935Wk.mo2144a(menu, c0627a);
    }

    /* renamed from: fy */
    public final void mo2133fy() {
        m10153gT();
        this.f1935Wk.dismissPopupMenus();
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
