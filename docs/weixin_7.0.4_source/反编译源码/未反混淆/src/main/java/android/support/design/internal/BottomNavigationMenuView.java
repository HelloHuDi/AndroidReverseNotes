package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v4.f.k.a;
import android.support.v4.f.k.c;
import android.support.v4.view.b.b;
import android.support.v4.view.s;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;

public class BottomNavigationMenuView extends ViewGroup implements p {
    private boolean kT;
    final TransitionSet la;
    private final int lb;
    private final int lc;
    private final int ld;
    private final int le;
    private final a<BottomNavigationItemView> lf;
    BottomNavigationItemView[] lg;
    int lh;
    int li;
    private ColorStateList lj;
    private ColorStateList lk;
    private int ll;
    private int[] lm;
    BottomNavigationPresenter ln;
    h lo;
    private final OnClickListener mOnClickListener;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lf = new c(5);
        this.kT = true;
        this.lh = 0;
        this.li = 0;
        Resources resources = getResources();
        this.lb = resources.getDimensionPixelSize(R.dimen.ym);
        this.lc = resources.getDimensionPixelSize(R.dimen.yn);
        this.ld = resources.getDimensionPixelSize(R.dimen.yi);
        this.le = resources.getDimensionPixelSize(R.dimen.yl);
        this.la = new AutoTransition();
        this.la.ao(0);
        this.la.g(115);
        this.la.a(new b());
        this.la.d(new e());
        this.mOnClickListener = new OnClickListener() {
            public final void onClick(View view) {
                MenuItem itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.lo.a(itemData, BottomNavigationMenuView.this.ln, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.lm = new int[5];
    }

    public final void a(h hVar) {
        this.lo = hVar;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int min;
        int size = MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.le, ErrorDialogData.SUPPRESSED);
        int min2;
        if (this.kT) {
            i3 = childCount - 1;
            min = Math.min(size - (this.lc * i3), this.ld);
            min2 = Math.min((size - min) / i3, this.lb);
            size = (size - min) - (i3 * min2);
            int i4 = 0;
            while (i4 < childCount) {
                int[] iArr = this.lm;
                if (i4 == this.li) {
                    i3 = min;
                } else {
                    i3 = min2;
                }
                iArr[i4] = i3;
                if (size > 0) {
                    int[] iArr2 = this.lm;
                    iArr2[i4] = iArr2[i4] + 1;
                    i3 = size - 1;
                } else {
                    i3 = size;
                }
                i4++;
                size = i3;
            }
        } else {
            if (childCount == 0) {
                i3 = 1;
            } else {
                i3 = childCount;
            }
            min2 = Math.min(size / i3, this.ld);
            i3 = size - (min2 * childCount);
            for (min = 0; min < childCount; min++) {
                this.lm[min] = min2;
                if (i3 > 0) {
                    int[] iArr3 = this.lm;
                    iArr3[min] = iArr3[min] + 1;
                    i3--;
                }
            }
        }
        i3 = 0;
        for (min = 0; min < childCount; min++) {
            View childAt = getChildAt(min);
            if (childAt.getVisibility() != 8) {
                childAt.measure(MeasureSpec.makeMeasureSpec(this.lm[min], ErrorDialogData.SUPPRESSED), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i3 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i3, MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED), 0), View.resolveSizeAndState(this.le, makeMeasureSpec, 0));
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (s.T(this) == 1) {
                    childAt.layout((i5 - i7) - childAt.getMeasuredWidth(), 0, i5 - i7, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.lj = colorStateList;
        if (this.lg != null) {
            for (BottomNavigationItemView iconTintList : this.lg) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.lj;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.lk = colorStateList;
        if (this.lg != null) {
            for (BottomNavigationItemView textColor : this.lg) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.lk;
    }

    public void setItemBackgroundRes(int i) {
        this.ll = i;
        if (this.lg != null) {
            for (BottomNavigationItemView itemBackground : this.lg) {
                itemBackground.setItemBackground(i);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.ll;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.ln = bottomNavigationPresenter;
    }

    public final void bs() {
        removeAllViews();
        if (this.lg != null) {
            for (Object release : this.lg) {
                this.lf.release(release);
            }
        }
        if (this.lo.size() == 0) {
            this.lh = 0;
            this.li = 0;
            this.lg = null;
            return;
        }
        boolean z;
        this.lg = new BottomNavigationItemView[this.lo.size()];
        if (this.lo.size() > 3) {
            z = true;
        } else {
            z = false;
        }
        this.kT = z;
        for (int i = 0; i < this.lo.size(); i++) {
            this.ln.lr = true;
            this.lo.getItem(i).setCheckable(true);
            this.ln.lr = false;
            BottomNavigationItemView newItem = getNewItem();
            this.lg[i] = newItem;
            newItem.setIconTintList(this.lj);
            newItem.setTextColor(this.lk);
            newItem.setItemBackground(this.ll);
            newItem.setShiftingMode(this.kT);
            newItem.a((j) this.lo.getItem(i));
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.mOnClickListener);
            addView(newItem);
        }
        this.li = Math.min(this.lo.size() - 1, this.li);
        this.lo.getItem(this.li).setChecked(true);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) this.lf.aA();
        if (bottomNavigationItemView == null) {
            return new BottomNavigationItemView(getContext());
        }
        return bottomNavigationItemView;
    }

    public int getSelectedItemId() {
        return this.lh;
    }
}
