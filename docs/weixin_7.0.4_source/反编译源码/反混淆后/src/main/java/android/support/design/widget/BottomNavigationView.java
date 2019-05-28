package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C37097a.C37096a;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.C31830a;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.C0611g;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.widget.C0699bc;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.p177mm.C25738R;

public class BottomNavigationView extends FrameLayout {
    /* renamed from: kO */
    private static final int[] f5066kO = new int[]{16842912};
    /* renamed from: mX */
    private static final int[] f5067mX = new int[]{-16842910};
    /* renamed from: ln */
    private final BottomNavigationPresenter f5068ln;
    /* renamed from: lo */
    private final C6236h f5069lo;
    /* renamed from: lq */
    private final BottomNavigationMenuView f5070lq;
    /* renamed from: mY */
    private MenuInflater f5071mY;
    /* renamed from: mZ */
    private C25303b f5072mZ;
    /* renamed from: na */
    private C25302a f5073na;

    /* renamed from: android.support.design.widget.BottomNavigationView$a */
    public interface C25302a {
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$b */
    public interface C25303b {
        /* renamed from: bK */
        boolean mo42172bK();
    }

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C173801();
        /* renamed from: nc */
        Bundle f5074nc;

        /* renamed from: android.support.design.widget.BottomNavigationView$SavedState$1 */
        static class C173801 implements ClassLoaderCreator<SavedState> {
            C173801() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5074nc = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f5074nc);
        }
    }

    /* renamed from: android.support.design.widget.BottomNavigationView$1 */
    class C253041 implements C0623a {
        C253041() {
        }

        /* renamed from: a */
        public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
            if (BottomNavigationView.this.f5073na != null && menuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()) {
                BottomNavigationView.this.f5073na;
                return true;
            } else if (BottomNavigationView.this.f5072mZ == null || BottomNavigationView.this.f5072mZ.mo42172bK()) {
                return false;
            } else {
                return true;
            }
        }

        /* renamed from: b */
        public final void mo1585b(C6236h c6236h) {
        }
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5068ln = new BottomNavigationPresenter();
        C41488o.m72457G(context);
        this.f5069lo = new C31830a(context);
        this.f5070lq = new BottomNavigationMenuView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f5070lq.setLayoutParams(layoutParams);
        this.f5068ln.f5057lq = this.f5070lq;
        this.f5068ln.mId = 1;
        this.f5070lq.setPresenter(this.f5068ln);
        this.f5069lo.mo14114a(this.f5068ln);
        this.f5068ln.mo1598a(getContext(), this.f5069lo);
        C0699bc a = C0699bc.m1555a(context, attributeSet, C37096a.BottomNavigationView, i, C25738R.style.f11377yl);
        if (a.hasValue(2)) {
            this.f5070lq.setIconTintList(a.getColorStateList(2));
        } else {
            this.f5070lq.setIconTintList(m39892bJ());
        }
        if (a.hasValue(3)) {
            this.f5070lq.setItemTextColor(a.getColorStateList(3));
        } else {
            this.f5070lq.setItemTextColor(m39892bJ());
        }
        if (a.hasValue(0)) {
            C0477s.m945h(this, (float) a.getDimensionPixelSize(0, 0));
        }
        this.f5070lq.setItemBackgroundRes(a.getResourceId(4, 0));
        if (a.hasValue(1)) {
            int resourceId = a.getResourceId(1, 0);
            this.f5068ln.f5058lr = true;
            getMenuInflater().inflate(resourceId, this.f5069lo);
            this.f5068ln.f5058lr = false;
            this.f5068ln.mo1606n(true);
        }
        a.atG.recycle();
        addView(this.f5070lq, layoutParams);
        if (VERSION.SDK_INT < 21) {
            View view = new View(context);
            view.setBackgroundColor(C0380b.m652i(context, C25738R.color.f11918lm));
            view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(C25738R.dimen.f10346yp)));
            addView(view);
        }
        this.f5069lo.mo14113a(new C253041());
    }

    public void setOnNavigationItemSelectedListener(C25303b c25303b) {
        this.f5072mZ = c25303b;
    }

    public void setOnNavigationItemReselectedListener(C25302a c25302a) {
        this.f5073na = c25302a;
    }

    public Menu getMenu() {
        return this.f5069lo;
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.f5070lq.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f5070lq.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f5070lq.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f5070lq.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.f5070lq.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.f5070lq.setItemBackgroundRes(i);
    }

    public int getSelectedItemId() {
        return this.f5070lq.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.f5069lo.findItem(i);
        if (findItem != null && !this.f5069lo.mo14116a(findItem, this.f5068ln, 0)) {
            findItem.setChecked(true);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.f5071mY == null) {
            this.f5071mY = new C0611g(getContext());
        }
        return this.f5071mY;
    }

    /* renamed from: bJ */
    private ColorStateList m39892bJ() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16842808, typedValue, true)) {
            return null;
        }
        ColorStateList h = C0589b.m1276h(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C25738R.attr.f5680fl, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = h.getDefaultColor();
        return new ColorStateList(new int[][]{f5067mX, f5066kO, EMPTY_STATE_SET}, new int[]{h.getColorForState(f5067mX, defaultColor), i, defaultColor});
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5074nc = new Bundle();
        this.f5069lo.mo14127c(savedState.f5074nc);
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            this.f5069lo.dispatchRestoreInstanceState(savedState.f5074nc);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
