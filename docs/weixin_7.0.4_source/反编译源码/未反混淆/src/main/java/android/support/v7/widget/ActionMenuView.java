package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.j;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;

public class ActionMenuView extends LinearLayoutCompat implements android.support.v7.view.menu.h.b, p {
    private Context acv;
    private int adH;
    private int adW;
    ActionMenuPresenter adX;
    private android.support.v7.view.menu.o.a adY;
    android.support.v7.view.menu.h.a adZ;
    boolean ady;
    private boolean aea;
    private int aeb;
    private int aec;
    d aed;
    h lo;

    public interface a {
        boolean gk();

        boolean gl();
    }

    public interface d {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public boolean aee;
        @ExportedProperty
        public int aef;
        @ExportedProperty
        public int aeg;
        @ExportedProperty
        public boolean aeh;
        @ExportedProperty
        public boolean aei;
        boolean aej;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.aee = layoutParams.aee;
        }

        public LayoutParams() {
            super(-2, -2);
            this.aee = false;
        }
    }

    static class b implements android.support.v7.view.menu.o.a {
        b() {
        }

        public final void a(h hVar, boolean z) {
        }

        public final boolean d(h hVar) {
            return false;
        }
    }

    class c implements android.support.v7.view.menu.h.a {
        c() {
        }

        public final boolean a(h hVar, MenuItem menuItem) {
            return ActionMenuView.this.aed != null && ActionMenuView.this.aed.onMenuItemClick(menuItem);
        }

        public final void b(h hVar) {
            if (ActionMenuView.this.adZ != null) {
                ActionMenuView.this.adZ.b(hVar);
            }
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams c(android.view.ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams g(AttributeSet attributeSet) {
        return f(attributeSet);
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return hd();
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ android.support.v7.widget.LinearLayoutCompat.LayoutParams hf() {
        return hd();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.adH = (int) (56.0f * f);
        this.aec = (int) (f * 4.0f);
        this.acv = context;
        this.adW = 0;
    }

    public void setPopupTheme(int i) {
        if (this.adW != i) {
            this.adW = i;
            if (i == 0) {
                this.acv = getContext();
            } else {
                this.acv = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.adW;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.adX = actionMenuPresenter;
        this.adX.a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.adX != null) {
            this.adX.n(false);
            if (this.adX.isOverflowMenuShowing()) {
                this.adX.hideOverflowMenu();
                this.adX.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.aed = dVar;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0295  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int i, int i2) {
        boolean z = this.aea;
        this.aea = MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED;
        if (z != this.aea) {
            this.aeb = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.aea || this.lo == null || size == this.aeb)) {
            this.aeb = size;
            this.lo.p(true);
        }
        int childCount = getChildCount();
        int i3;
        LayoutParams layoutParams;
        if (!this.aea || childCount <= 0) {
            for (i3 = 0; i3 < childCount; i3++) {
                layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i2);
        size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        i3 = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i4 = size - i3;
        int i5 = i4 / this.adH;
        size = i4 % this.adH;
        if (i5 == 0) {
            setMeasuredDimension(i4, 0);
            return;
        }
        View childAt;
        int i6;
        int f;
        Object obj;
        int i7;
        Object obj2;
        int i8 = this.adH + (size / i5);
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        i3 = 0;
        Object obj3 = null;
        long j = 0;
        int childCount2 = getChildCount();
        int i12 = 0;
        while (i12 < childCount2) {
            childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                boolean z2 = childAt instanceof ActionMenuItemView;
                i6 = i3 + 1;
                if (z2) {
                    childAt.setPadding(this.aec, 0, this.aec, 0);
                }
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.aej = false;
                layoutParams.aeg = 0;
                layoutParams.aef = 0;
                layoutParams.aeh = false;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                z = z2 && ((ActionMenuItemView) childAt).hasText();
                layoutParams.aei = z;
                if (layoutParams.aee) {
                    i3 = 1;
                } else {
                    i3 = i5;
                }
                f = f(childAt, i8, i3, childMeasureSpec, paddingTop);
                i10 = Math.max(i10, f);
                if (layoutParams.aeh) {
                    i3 = i11 + 1;
                } else {
                    i3 = i11;
                }
                if (layoutParams.aee) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                i7 = i5 - f;
                int max = Math.max(i9, childAt.getMeasuredHeight());
                if (f == 1) {
                    j = ((long) (1 << i12)) | j;
                    i11 = i3;
                    i9 = max;
                } else {
                    i11 = i3;
                    i9 = max;
                }
            } else {
                obj = obj3;
                i6 = i3;
                i7 = i5;
            }
            i12++;
            obj3 = obj;
            i3 = i6;
            i5 = i7;
        }
        if (obj3 == null || i3 != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j2 = j;
        f = i5;
        while (i11 > 0 && f > 0) {
            i6 = BaseClientBuilder.API_PRIORITY_OTHER;
            j = 0;
            i5 = 0;
            int i13 = 0;
            while (i13 < childCount2) {
                layoutParams = (LayoutParams) getChildAt(i13).getLayoutParams();
                if (layoutParams.aeh) {
                    if (layoutParams.aef < i6) {
                        i5 = layoutParams.aef;
                        j = 1 << i13;
                        size = 1;
                        i6 = i5;
                    } else if (layoutParams.aef == i6) {
                        j |= 1 << i13;
                        size = i5 + 1;
                    }
                    i13++;
                    i5 = size;
                }
                size = i5;
                i13++;
                i5 = size;
            }
            j2 |= j;
            if (i5 > f) {
                break;
            }
            i7 = i6 + 1;
            i6 = 0;
            i5 = f;
            while (i6 < childCount2) {
                View childAt2 = getChildAt(i6);
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((((long) (1 << i6)) & j) != 0) {
                    if (obj2 != null && layoutParams.aei && i5 == 1) {
                        childAt2.setPadding(this.aec + i8, 0, this.aec, 0);
                    }
                    layoutParams.aef++;
                    layoutParams.aej = true;
                    size = i5 - 1;
                } else if (layoutParams.aef == i7) {
                    j2 |= (long) (1 << i6);
                    size = i5;
                } else {
                    size = i5;
                }
                i6++;
                i5 = size;
            }
            obj4 = 1;
            f = i5;
        }
        j = j2;
        obj = (obj3 == null && i3 == 1) ? 1 : null;
        if (f <= 0 || j == 0 || (f >= i3 - 1 && obj == null && i10 <= 1)) {
            obj2 = obj4;
        } else {
            float f2;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((LayoutParams) getChildAt(0).getLayoutParams()).aei)) {
                    bitCount -= 0.5f;
                }
                if ((((long) (1 << (childCount2 - 1))) & j) != 0) {
                    if (!((LayoutParams) getChildAt(childCount2 - 1).getLayoutParams()).aei) {
                        f2 = bitCount - 0.5f;
                        if (f2 <= 0.0f) {
                            i3 = (int) (((float) (f * i8)) / f2);
                        } else {
                            i3 = 0;
                        }
                        i5 = 0;
                        obj2 = obj4;
                        while (i5 < childCount2) {
                            if ((((long) (1 << i5)) & j) != 0) {
                                View childAt3 = getChildAt(i5);
                                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                                if (childAt3 instanceof ActionMenuItemView) {
                                    layoutParams.aeg = i3;
                                    layoutParams.aej = true;
                                    if (i5 == 0 && !layoutParams.aei) {
                                        layoutParams.leftMargin = (-i3) / 2;
                                    }
                                    obj = 1;
                                } else if (layoutParams.aee) {
                                    layoutParams.aeg = i3;
                                    layoutParams.aej = true;
                                    layoutParams.rightMargin = (-i3) / 2;
                                    obj = 1;
                                } else {
                                    if (i5 != 0) {
                                        layoutParams.leftMargin = i3 / 2;
                                    }
                                    if (i5 != childCount2 - 1) {
                                        layoutParams.rightMargin = i3 / 2;
                                    }
                                }
                                i5++;
                                obj2 = obj;
                            }
                            obj = obj2;
                            i5++;
                            obj2 = obj;
                        }
                    }
                }
            }
            f2 = bitCount;
            if (f2 <= 0.0f) {
            }
            i5 = 0;
            obj2 = obj4;
            while (i5 < childCount2) {
            }
        }
        if (obj2 != null) {
            size = 0;
            while (true) {
                i3 = size;
                if (i3 >= childCount2) {
                    break;
                }
                childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.aej) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.aeg + (layoutParams.aef * i8), ErrorDialogData.SUPPRESSED), childMeasureSpec);
                }
                size = i3 + 1;
            }
        }
        if (mode == 1073741824) {
            i9 = size2;
        }
        setMeasuredDimension(i4, i9);
    }

    static int f(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.hasText()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, j.INVALID_ID), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && i5 < 2) {
                i5 = 2;
            }
        }
        if (!layoutParams.aee && z) {
            z2 = true;
        }
        layoutParams.aeh = z2;
        layoutParams.aef = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, ErrorDialogData.SUPPRESSED), makeMeasureSpec);
        return i5;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.aea) {
            LayoutParams layoutParams;
            int measuredWidth;
            int paddingLeft;
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean bW = bk.bW(this);
            int i8 = 0;
            while (i8 < childCount) {
                Object obj2;
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.aee) {
                        measuredWidth = childAt.getMeasuredWidth();
                        if (bt(i8)) {
                            measuredWidth += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (bW) {
                            paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                            i5 = paddingLeft + measuredWidth;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i5 - measuredWidth;
                        }
                        int i9 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i9, i5, measuredHeight + i9);
                        obj2 = 1;
                        paddingLeft = paddingRight - measuredWidth;
                    } else {
                        paddingLeft = paddingRight - (layoutParams.rightMargin + (childAt.getMeasuredWidth() + layoutParams.leftMargin));
                        bt(i8);
                        obj2 = obj;
                        i7++;
                    }
                } else {
                    obj2 = obj;
                    paddingLeft = paddingRight;
                }
                i8++;
                obj = obj2;
                paddingRight = paddingLeft;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                measuredWidth = childAt2.getMeasuredWidth();
                paddingLeft = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (measuredWidth / 2);
                i7 = i6 - (paddingLeft / 2);
                childAt2.layout(paddingRight, i7, measuredWidth + paddingRight, paddingLeft + i7);
                return;
            }
            i5 = i7 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, i5 > 0 ? paddingRight / i5 : 0);
            View childAt3;
            int i10;
            if (bW) {
                measuredWidth = getWidth() - getPaddingRight();
                paddingLeft = 0;
                while (paddingLeft < childCount) {
                    childAt3 = getChildAt(paddingLeft);
                    layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8 || layoutParams.aee) {
                        i5 = measuredWidth;
                    } else {
                        measuredWidth -= layoutParams.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        dividerWidth = childAt3.getMeasuredHeight();
                        i10 = i6 - (dividerWidth / 2);
                        childAt3.layout(measuredWidth - i8, i10, measuredWidth, dividerWidth + i10);
                        i5 = measuredWidth - ((layoutParams.leftMargin + i8) + paddingRight);
                    }
                    paddingLeft++;
                    measuredWidth = i5;
                }
                return;
            }
            measuredWidth = getPaddingLeft();
            paddingLeft = 0;
            while (paddingLeft < childCount) {
                childAt3 = getChildAt(paddingLeft);
                layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8 || layoutParams.aee) {
                    i5 = measuredWidth;
                } else {
                    measuredWidth += layoutParams.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    dividerWidth = childAt3.getMeasuredHeight();
                    i10 = i6 - (dividerWidth / 2);
                    childAt3.layout(measuredWidth, i10, measuredWidth + i8, dividerWidth + i10);
                    i5 = ((layoutParams.rightMargin + i8) + paddingRight) + measuredWidth;
                }
                paddingLeft++;
                measuredWidth = i5;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.adX;
        if (actionMenuPresenter.adv != null) {
            actionMenuPresenter.adv.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.adx = true;
        actionMenuPresenter.adw = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.adX;
        if (actionMenuPresenter.adv != null) {
            return actionMenuPresenter.adv.getDrawable();
        }
        if (actionMenuPresenter.adx) {
            return actionMenuPresenter.adw;
        }
        return null;
    }

    public void setOverflowReserved(boolean z) {
        this.ady = z;
    }

    private static LayoutParams hd() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    private LayoutParams f(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected static LayoutParams b(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return hd();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity > 0) {
            return layoutParams2;
        }
        layoutParams2.gravity = 16;
        return layoutParams2;
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public static LayoutParams he() {
        LayoutParams hd = hd();
        hd.aee = true;
        return hd;
    }

    public final boolean f(android.support.v7.view.menu.j jVar) {
        return this.lo.a((MenuItem) jVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void a(h hVar) {
        this.lo = hVar;
    }

    public Menu getMenu() {
        if (this.lo == null) {
            android.support.v7.view.menu.o.a aVar;
            Context context = getContext();
            this.lo = new h(context);
            this.lo.a(new c());
            this.adX = new ActionMenuPresenter(context);
            this.adX.gZ();
            ActionMenuPresenter actionMenuPresenter = this.adX;
            if (this.adY != null) {
                aVar = this.adY;
            } else {
                aVar = new b();
            }
            actionMenuPresenter.lL = aVar;
            this.lo.a(this.adX, this.acv);
            this.adX.a(this);
        }
        return this.lo;
    }

    public final void a(android.support.v7.view.menu.o.a aVar, android.support.v7.view.menu.h.a aVar2) {
        this.adY = aVar;
        this.adZ = aVar2;
    }

    public final void dismissPopupMenus() {
        if (this.adX != null) {
            this.adX.ha();
        }
    }

    private boolean bt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z = ((a) childAt).gl() | 0;
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z : ((a) childAt2).gk() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.adX.adG = z;
    }
}
