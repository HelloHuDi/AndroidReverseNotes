package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.b;
import android.support.design.internal.c;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.aa;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.o;
import android.support.v7.widget.bc;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;

public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] kO = new int[]{16842912};
    private static final int[] mX = new int[]{-16842910};
    private int di;
    private MenuInflater mY;
    private final b qW;
    private final c qX;
    a qY;

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Bundle ra;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.ra = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.ra);
        }
    }

    public interface a {
        boolean bK();
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
        this.qX = new c();
        o.G(context);
        this.qW = new b(context);
        bc a = bc.a(context, attributeSet, android.support.design.a.a.NavigationView, i, R.style.yq);
        s.a((View) this, a.getDrawable(0));
        if (a.hasValue(3)) {
            s.h(this, (float) a.getDimensionPixelSize(3, 0));
        }
        s.e((View) this, a.getBoolean(1, false));
        this.di = a.getDimensionPixelSize(2, 0);
        if (a.hasValue(5)) {
            colorStateList = a.getColorStateList(5);
        } else {
            colorStateList = ab(16842808);
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
            colorStateList2 = ab(16842806);
        }
        Drawable drawable = a.getDrawable(7);
        this.qW.a((android.support.v7.view.menu.h.a) new android.support.v7.view.menu.h.a() {
            public final boolean a(h hVar, MenuItem menuItem) {
                return NavigationView.this.qY != null && NavigationView.this.qY.bK();
            }

            public final void b(h hVar) {
            }
        });
        this.qX.mId = 1;
        this.qX.a(context, this.qW);
        this.qX.setItemIconTintList(colorStateList);
        if (i2 != 0) {
            this.qX.setItemTextAppearance(resourceId);
        }
        this.qX.setItemTextColor(colorStateList2);
        this.qX.setItemBackground(drawable);
        this.qW.a((o) this.qX);
        c cVar = this.qX;
        if (cVar.lJ == null) {
            cVar.lJ = (NavigationMenuView) cVar.mLayoutInflater.inflate(R.layout.sb, this, false);
            if (cVar.lM == null) {
                cVar.lM = new c.b();
            }
            cVar.lK = (LinearLayout) cVar.mLayoutInflater.inflate(R.layout.s9, cVar.lJ, false);
            cVar.lJ.setAdapter(cVar.lM);
        }
        addView(cVar.lJ);
        if (a.hasValue(4)) {
            resourceId2 = a.getResourceId(4, 0);
            this.qX.o(true);
            getMenuInflater().inflate(resourceId2, this.qW);
            this.qX.o(false);
            this.qX.n(false);
        }
        if (a.hasValue(9)) {
            resourceId2 = a.getResourceId(9, 0);
            cVar = this.qX;
            cVar.lK.addView(cVar.mLayoutInflater.inflate(resourceId2, cVar.lK, false));
            cVar.lJ.setPadding(0, 0, 0, cVar.lJ.getPaddingBottom());
        }
        a.atG.recycle();
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.ra = new Bundle();
        this.qW.c(savedState.ra);
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.LC);
            this.qW.dispatchRestoreInstanceState(savedState.ra);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.qY = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        switch (MeasureSpec.getMode(i)) {
            case j.INVALID_ID /*-2147483648*/:
                i = MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), this.di), ErrorDialogData.SUPPRESSED);
                break;
            case 0:
                i = MeasureSpec.makeMeasureSpec(this.di, ErrorDialogData.SUPPRESSED);
                break;
        }
        super.onMeasure(i, i2);
    }

    public final void a(aa aaVar) {
        c cVar = this.qX;
        int systemWindowInsetTop = aaVar.getSystemWindowInsetTop();
        if (cVar.lR != systemWindowInsetTop) {
            cVar.lR = systemWindowInsetTop;
            if (cVar.lK.getChildCount() == 0) {
                cVar.lJ.setPadding(0, cVar.lR, 0, cVar.lJ.getPaddingBottom());
            }
        }
        s.b(cVar.lK, aaVar);
    }

    public Menu getMenu() {
        return this.qW;
    }

    public int getHeaderCount() {
        return this.qX.lK.getChildCount();
    }

    public ColorStateList getItemIconTintList() {
        return this.qX.lE;
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.qX.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.qX.lP;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.qX.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.qX.lQ;
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(android.support.v4.content.b.g(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.qX.setItemBackground(drawable);
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.qW.findItem(i);
        if (findItem != null) {
            this.qX.lM.d((android.support.v7.view.menu.j) findItem);
        }
    }

    public void setItemTextAppearance(int i) {
        this.qX.setItemTextAppearance(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.mY == null) {
            this.mY = new g(getContext());
        }
        return this.mY;
    }

    private ColorStateList ab(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList h = android.support.v7.c.a.b.h(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.fl, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = h.getDefaultColor();
        return new ColorStateList(new int[][]{mX, kO, EMPTY_STATE_SET}, new int[]{h.getColorForState(mX, defaultColor), i2, defaultColor});
    }
}
