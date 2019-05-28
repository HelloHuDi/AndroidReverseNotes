package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.l;
import android.support.v4.view.n;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.R;

public class ActionBarOverlayLayout extends ViewGroup implements l, w {
    static final int[] MT = new int[]{R.attr.dx, 16842841};
    private final n Rk;
    private x Wk;
    private boolean Xc;
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
    private a adn;
    private final int ado = 600;
    private OverScroller adp;
    ViewPropertyAnimator adq;
    final AnimatorListenerAdapter adr = new AnimatorListenerAdapter() {
        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout.this.adq = null;
            ActionBarOverlayLayout.this.add = false;
        }

        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout.this.adq = null;
            ActionBarOverlayLayout.this.add = false;
        }
    };
    private final Runnable ads = new Runnable() {
        public final void run() {
            ActionBarOverlayLayout.this.gU();
            ActionBarOverlayLayout.this.adq = ActionBarOverlayLayout.this.acY.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.adr);
        }
    };
    private final Runnable adt = new Runnable() {
        public final void run() {
            ActionBarOverlayLayout.this.gU();
            ActionBarOverlayLayout.this.adq = ActionBarOverlayLayout.this.acY.animate().translationY((float) (-ActionBarOverlayLayout.this.acY.getHeight())).setListener(ActionBarOverlayLayout.this.adr);
        }
    };

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

    public interface a {
        void O(boolean z);

        void fG();

        void fI();

        void fJ();

        void onWindowVisibilityChanged(int i);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
        this.Rk = new n(this);
    }

    private void init(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(MT);
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
        gU();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.adn = aVar;
        if (getWindowToken() != null) {
            this.adn.onWindowVisibilityChanged(this.acW);
            if (this.adf != 0) {
                onWindowSystemUiVisibilityChanged(this.adf);
                s.ak(this);
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
        s.ak(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        gT();
        int i2 = this.adf ^ i;
        this.adf = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.adn != null) {
            a aVar = this.adn;
            if (z) {
                z2 = false;
            }
            aVar.O(z2);
            if (z3 || !z) {
                this.adn.fG();
            } else {
                this.adn.fI();
            }
        }
        if ((i2 & 256) != 0 && this.adn != null) {
            s.ak(this);
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

    private static boolean c(View view, Rect rect, boolean z) {
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
        gT();
        s.aj(this);
        boolean c = c(this.acY, rect, false);
        this.adj.set(rect);
        bk.a(this, this.adj, this.adg);
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
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        gT();
        measureChildWithMargins(this.acY, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.acY.getLayoutParams();
        int max = Math.max(0, (this.acY.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.acY.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = View.combineMeasuredStates(0, this.acY.getMeasuredState());
        boolean z = (s.aj(this) & 256) != 0;
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
        c(this.acX, this.adi, true);
        if (!this.adm.equals(this.adl)) {
            this.adm.set(this.adl);
            this.acX.g(this.adl);
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
        return this.Xc;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.Rk.Ms = i;
        this.ade = getActionBarHideOffset();
        gU();
        if (this.adn != null) {
            this.adn.fJ();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.ade += i2;
        setActionBarHideOffset(this.ade);
    }

    public void onStopNestedScroll(View view) {
        if (this.Xc && !this.add) {
            if (this.ade <= this.acY.getHeight()) {
                gU();
                postDelayed(this.ads, 600);
                return;
            }
            gU();
            postDelayed(this.adt, 600);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.Xc || !z) {
            return false;
        }
        this.adp.fling(0, 0, 0, (int) f2, 0, 0, j.INVALID_ID, BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.adp.getFinalY() > this.acY.getHeight()) {
            z2 = true;
        }
        if (z2) {
            gU();
            this.adt.run();
        } else {
            gU();
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
        return this.Rk.Ms;
    }

    private void gT() {
        if (this.acX == null) {
            this.acX = (ContentFrameLayout) findViewById(R.id.a);
            this.acY = (ActionBarContainer) findViewById(R.id.k0);
            this.Wk = aS(findViewById(R.id.k1));
        }
    }

    private static x aS(View view) {
        if (view instanceof x) {
            return (x) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.Xc) {
            this.Xc = z;
            if (!z) {
                gU();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.acY != null ? -((int) this.acY.getTranslationY()) : 0;
    }

    public void setActionBarHideOffset(int i) {
        gU();
        this.acY.setTranslationY((float) (-Math.max(0, Math.min(i, this.acY.getHeight()))));
    }

    /* Access modifiers changed, original: final */
    public final void gU() {
        removeCallbacks(this.ads);
        removeCallbacks(this.adt);
        if (this.adq != null) {
            this.adq.cancel();
        }
    }

    public void setWindowCallback(Callback callback) {
        gT();
        this.Wk.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        gT();
        this.Wk.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        gT();
        return this.Wk.getTitle();
    }

    public final void bs(int i) {
        gT();
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
        gT();
        this.Wk.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        gT();
        this.Wk.setIcon(drawable);
    }

    public void setLogo(int i) {
        gT();
        this.Wk.setLogo(i);
    }

    public final boolean gV() {
        gT();
        return this.Wk.gV();
    }

    public final boolean isOverflowMenuShowing() {
        gT();
        return this.Wk.isOverflowMenuShowing();
    }

    public final boolean gW() {
        gT();
        return this.Wk.gW();
    }

    public final boolean showOverflowMenu() {
        gT();
        return this.Wk.showOverflowMenu();
    }

    public final boolean hideOverflowMenu() {
        gT();
        return this.Wk.hideOverflowMenu();
    }

    public final void gX() {
        gT();
        this.Wk.gX();
    }

    public final void a(Menu menu, android.support.v7.view.menu.o.a aVar) {
        gT();
        this.Wk.a(menu, aVar);
    }

    public final void fy() {
        gT();
        this.Wk.dismissPopupMenus();
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }
}
