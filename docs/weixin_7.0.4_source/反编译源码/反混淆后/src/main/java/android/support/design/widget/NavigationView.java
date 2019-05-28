package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C37097a.C37096a;
import android.support.design.internal.C31831b;
import android.support.design.internal.C31832c;
import android.support.design.internal.C31832c.C31833b;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0451aa;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.view.C0611g;
import android.support.p069v7.view.menu.C0628o;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6236h.C0623a;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.widget.C0699bc;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.p177mm.C25738R;

public class NavigationView extends ScrimInsetsFrameLayout {
    /* renamed from: kO */
    private static final int[] f5106kO = new int[]{16842912};
    /* renamed from: mX */
    private static final int[] f5107mX = new int[]{-16842910};
    /* renamed from: di */
    private int f5108di;
    /* renamed from: mY */
    private MenuInflater f5109mY;
    /* renamed from: qW */
    private final C31831b f5110qW;
    /* renamed from: qX */
    private final C31832c f5111qX;
    /* renamed from: qY */
    C25309a f5112qY;

    /* renamed from: android.support.design.widget.NavigationView$1 */
    class C253071 implements C0623a {
        C253071() {
        }

        /* renamed from: a */
        public final boolean mo1584a(C6236h c6236h, MenuItem menuItem) {
            return NavigationView.this.f5112qY != null && NavigationView.this.f5112qY.mo42263bK();
        }

        /* renamed from: b */
        public final void mo1585b(C6236h c6236h) {
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C253081();
        /* renamed from: ra */
        public Bundle f5113ra;

        /* renamed from: android.support.design.widget.NavigationView$SavedState$1 */
        static class C253081 implements ClassLoaderCreator<SavedState> {
            C253081() {
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f5113ra = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.f5113ra);
        }
    }

    /* renamed from: android.support.design.widget.NavigationView$a */
    public interface C25309a {
        /* renamed from: bK */
        boolean mo42263bK();
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        int resourceId;
        int i2;
        int resourceId2;
        super(context, attributeSet, i);
        this.f5111qX = new C31832c();
        C41488o.m72457G(context);
        this.f5110qW = new C31831b(context);
        C0699bc a = C0699bc.m1555a(context, attributeSet, C37096a.NavigationView, i, C25738R.style.f11382yq);
        C0477s.m904a((View) this, a.getDrawable(0));
        if (a.hasValue(3)) {
            C0477s.m945h(this, (float) a.getDimensionPixelSize(3, 0));
        }
        C0477s.m942e((View) this, a.getBoolean(1, false));
        this.f5108di = a.getDimensionPixelSize(2, 0);
        if (a.hasValue(5)) {
            colorStateList = a.getColorStateList(5);
        } else {
            colorStateList = m39911ab(16842808);
        }
        if (a.hasValue(8)) {
            resourceId = a.getResourceId(8, 0);
            i2 = 1;
        } else {
            resourceId = 0;
            i2 = 0;
        }
        ColorStateList colorStateList2 = null;
        if (a.hasValue(6)) {
            colorStateList2 = a.getColorStateList(6);
        }
        if (i2 == 0 && r5 == null) {
            colorStateList2 = m39911ab(16842806);
        }
        Drawable drawable = a.getDrawable(7);
        this.f5110qW.mo14113a((C0623a) new C253071());
        this.f5111qX.mId = 1;
        this.f5111qX.mo1598a(context, this.f5110qW);
        this.f5111qX.setItemIconTintList(colorStateList);
        if (i2 != 0) {
            this.f5111qX.setItemTextAppearance(resourceId);
        }
        this.f5111qX.setItemTextColor(colorStateList2);
        this.f5111qX.setItemBackground(drawable);
        this.f5110qW.mo14114a((C0628o) this.f5111qX);
        C31832c c31832c = this.f5111qX;
        if (c31832c.f14545lJ == null) {
            c31832c.f14545lJ = (NavigationMenuView) c31832c.mLayoutInflater.inflate(2130969282, this, false);
            if (c31832c.f14548lM == null) {
                c31832c.f14548lM = new C31833b();
            }
            c31832c.f14546lK = (LinearLayout) c31832c.mLayoutInflater.inflate(2130969279, c31832c.f14545lJ, false);
            c31832c.f14545lJ.setAdapter(c31832c.f14548lM);
        }
        addView(c31832c.f14545lJ);
        if (a.hasValue(4)) {
            resourceId2 = a.getResourceId(4, 0);
            this.f5111qX.mo51789o(true);
            getMenuInflater().inflate(resourceId2, this.f5110qW);
            this.f5111qX.mo51789o(false);
            this.f5111qX.mo1606n(false);
        }
        if (a.hasValue(9)) {
            resourceId2 = a.getResourceId(9, 0);
            c31832c = this.f5111qX;
            c31832c.f14546lK.addView(c31832c.mLayoutInflater.inflate(resourceId2, c31832c.f14546lK, false));
            c31832c.f14545lJ.setPadding(0, 0, 0, c31832c.f14545lJ.getPaddingBottom());
        }
        a.atG.recycle();
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5113ra = new Bundle();
        this.f5110qW.mo14127c(savedState.f5113ra);
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            this.f5110qW.dispatchRestoreInstanceState(savedState.f5113ra);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setNavigationItemSelectedListener(C25309a c25309a) {
        this.f5112qY = c25309a;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case C8415j.INVALID_ID /*-2147483648*/:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.f5108di), ErrorDialogData.SUPPRESSED);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.f5108di, ErrorDialogData.SUPPRESSED);
                break;
        }
        super.onMeasure(i, i2);
    }

    /* renamed from: a */
    public final void mo18111a(C0451aa c0451aa) {
        C31832c c31832c = this.f5111qX;
        int systemWindowInsetTop = c0451aa.getSystemWindowInsetTop();
        if (c31832c.f14553lR != systemWindowInsetTop) {
            c31832c.f14553lR = systemWindowInsetTop;
            if (c31832c.f14546lK.getChildCount() == 0) {
                c31832c.f14545lJ.setPadding(0, c31832c.f14553lR, 0, c31832c.f14545lJ.getPaddingBottom());
            }
        }
        C0477s.m933b(c31832c.f14546lK, c0451aa);
    }

    public Menu getMenu() {
        return this.f5110qW;
    }

    public int getHeaderCount() {
        return this.f5111qX.f14546lK.getChildCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.f5111qX.f14544lE;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f5111qX.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f5111qX.f14551lP;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f5111qX.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.f5111qX.f14552lQ;
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(C0380b.m649g(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.f5111qX.setItemBackground(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f5110qW.findItem(i);
        if (findItem != null) {
            this.f5111qX.f14548lM.mo51797d((C6239j) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.f5111qX.setItemTextAppearance(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.f5109mY == null) {
            this.f5109mY = new C0611g(getContext());
        }
        return this.f5109mY;
    }

    /* renamed from: ab */
    private ColorStateList m39911ab(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList h = C0589b.m1276h(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C25738R.attr.f5680fl, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = h.getDefaultColor();
        return new ColorStateList(new int[][]{f5107mX, f5106kO, EMPTY_STATE_SET}, new int[]{h.getColorForState(f5107mX, defaultColor), i2, defaultColor});
    }
}
