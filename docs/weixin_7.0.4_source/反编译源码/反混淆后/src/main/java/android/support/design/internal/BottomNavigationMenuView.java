package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.p057v4.p065f.C37122k.C25335c;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p068b.C6199b;
import android.support.p069v7.view.menu.C0630p;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6239j;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;

public class BottomNavigationMenuView extends ViewGroup implements C0630p {
    /* renamed from: kT */
    private boolean f15659kT;
    /* renamed from: la */
    final TransitionSet f15660la;
    /* renamed from: lb */
    private final int f15661lb;
    /* renamed from: lc */
    private final int f15662lc;
    /* renamed from: ld */
    private final int f15663ld;
    /* renamed from: le */
    private final int f15664le;
    /* renamed from: lf */
    private final C8387a<BottomNavigationItemView> f15665lf;
    /* renamed from: lg */
    BottomNavigationItemView[] f15666lg;
    /* renamed from: lh */
    int f15667lh;
    /* renamed from: li */
    int f15668li;
    /* renamed from: lj */
    private ColorStateList f15669lj;
    /* renamed from: lk */
    private ColorStateList f15670lk;
    /* renamed from: ll */
    private int f15671ll;
    /* renamed from: lm */
    private int[] f15672lm;
    /* renamed from: ln */
    BottomNavigationPresenter f15673ln;
    /* renamed from: lo */
    C6236h f15674lo;
    private final OnClickListener mOnClickListener;

    /* renamed from: android.support.design.internal.BottomNavigationMenuView$1 */
    class C252981 implements OnClickListener {
        C252981() {
        }

        public final void onClick(View view) {
            MenuItem itemData = ((BottomNavigationItemView) view).getItemData();
            if (!BottomNavigationMenuView.this.f15674lo.mo14116a(itemData, BottomNavigationMenuView.this.f15673ln, 0)) {
                itemData.setChecked(true);
            }
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15665lf = new C25335c(5);
        this.f15659kT = true;
        this.f15667lh = 0;
        this.f15668li = 0;
        Resources resources = getResources();
        this.f15661lb = resources.getDimensionPixelSize(C25738R.dimen.f10343ym);
        this.f15662lc = resources.getDimensionPixelSize(C25738R.dimen.f10344yn);
        this.f15663ld = resources.getDimensionPixelSize(C25738R.dimen.f10339yi);
        this.f15664le = resources.getDimensionPixelSize(C25738R.dimen.f10342yl);
        this.f15660la = new AutoTransition();
        this.f15660la.mo42275ao(0);
        this.f15660la.mo42284g(115);
        this.f15660la.mo42270a(new C6199b());
        this.f15660la.mo42282d(new C0253e());
        this.mOnClickListener = new C252981();
        this.f15672lm = new int[5];
    }

    /* renamed from: a */
    public final void mo1612a(C6236h c6236h) {
        this.f15674lo = c6236h;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int min;
        int size = MeasureSpec.getSize(i);
        int childCount = getChildCount();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f15664le, ErrorDialogData.SUPPRESSED);
        int min2;
        if (this.f15659kT) {
            i3 = childCount - 1;
            min = Math.min(size - (this.f15662lc * i3), this.f15663ld);
            min2 = Math.min((size - min) / i3, this.f15661lb);
            size = (size - min) - (i3 * min2);
            int i4 = 0;
            while (i4 < childCount) {
                int[] iArr = this.f15672lm;
                if (i4 == this.f15668li) {
                    i3 = min;
                } else {
                    i3 = min2;
                }
                iArr[i4] = i3;
                if (size > 0) {
                    int[] iArr2 = this.f15672lm;
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
            min2 = Math.min(size / i3, this.f15663ld);
            i3 = size - (min2 * childCount);
            for (min = 0; min < childCount; min++) {
                this.f15672lm[min] = min2;
                if (i3 > 0) {
                    int[] iArr3 = this.f15672lm;
                    iArr3[min] = iArr3[min] + 1;
                    i3--;
                }
            }
        }
        i3 = 0;
        for (min = 0; min < childCount; min++) {
            View childAt = getChildAt(min);
            if (childAt.getVisibility() != 8) {
                childAt.measure(MeasureSpec.makeMeasureSpec(this.f15672lm[min], ErrorDialogData.SUPPRESSED), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i3 += childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i3, MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED), 0), View.resolveSizeAndState(this.f15664le, makeMeasureSpec, 0));
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
                if (C0477s.m893T(this) == 1) {
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
        this.f15669lj = colorStateList;
        if (this.f15666lg != null) {
            for (BottomNavigationItemView iconTintList : this.f15666lg) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.f15669lj;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f15670lk = colorStateList;
        if (this.f15666lg != null) {
            for (BottomNavigationItemView textColor : this.f15666lg) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.f15670lk;
    }

    public void setItemBackgroundRes(int i) {
        this.f15671ll = i;
        if (this.f15666lg != null) {
            for (BottomNavigationItemView itemBackground : this.f15666lg) {
                itemBackground.setItemBackground(i);
            }
        }
    }

    public int getItemBackgroundRes() {
        return this.f15671ll;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.f15673ln = bottomNavigationPresenter;
    }

    /* renamed from: bs */
    public final void mo59124bs() {
        removeAllViews();
        if (this.f15666lg != null) {
            for (Object release : this.f15666lg) {
                this.f15665lf.release(release);
            }
        }
        if (this.f15674lo.size() == 0) {
            this.f15667lh = 0;
            this.f15668li = 0;
            this.f15666lg = null;
            return;
        }
        boolean z;
        this.f15666lg = new BottomNavigationItemView[this.f15674lo.size()];
        if (this.f15674lo.size() > 3) {
            z = true;
        } else {
            z = false;
        }
        this.f15659kT = z;
        for (int i = 0; i < this.f15674lo.size(); i++) {
            this.f15673ln.f5058lr = true;
            this.f15674lo.getItem(i).setCheckable(true);
            this.f15673ln.f5058lr = false;
            BottomNavigationItemView newItem = getNewItem();
            this.f15666lg[i] = newItem;
            newItem.setIconTintList(this.f15669lj);
            newItem.setTextColor(this.f15670lk);
            newItem.setItemBackground(this.f15671ll);
            newItem.setShiftingMode(this.f15659kT);
            newItem.mo1609a((C6239j) this.f15674lo.getItem(i));
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.mOnClickListener);
            addView(newItem);
        }
        this.f15668li = Math.min(this.f15674lo.size() - 1, this.f15668li);
        this.f15674lo.getItem(this.f15668li).setChecked(true);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) this.f15665lf.mo6364aA();
        if (bottomNavigationItemView == null) {
            return new BottomNavigationItemView(getContext());
        }
        return bottomNavigationItemView;
    }

    public int getSelectedItemId() {
        return this.f15667lh;
    }
}
