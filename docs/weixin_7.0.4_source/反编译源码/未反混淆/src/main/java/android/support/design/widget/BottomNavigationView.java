package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.s;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.widget.bc;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;

public class BottomNavigationView extends FrameLayout {
    private static final int[] kO = new int[]{16842912};
    private static final int[] mX = new int[]{-16842910};
    private final BottomNavigationPresenter ln;
    private final h lo;
    private final BottomNavigationMenuView lq;
    private MenuInflater mY;
    private b mZ;
    private a na;

    public interface a {
    }

    public interface b {
        boolean bK();
    }

    static class SavedState extends AbsSavedState {
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
        Bundle nc;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.nc = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.nc);
        }
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ln = new BottomNavigationPresenter();
        o.G(context);
        this.lo = new android.support.design.internal.a(context);
        this.lq = new BottomNavigationMenuView(context);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.lq.setLayoutParams(layoutParams);
        this.ln.lq = this.lq;
        this.ln.mId = 1;
        this.lq.setPresenter(this.ln);
        this.lo.a(this.ln);
        this.ln.a(getContext(), this.lo);
        bc a = bc.a(context, attributeSet, android.support.design.a.a.BottomNavigationView, i, R.style.yl);
        if (a.hasValue(2)) {
            this.lq.setIconTintList(a.getColorStateList(2));
        } else {
            this.lq.setIconTintList(bJ());
        }
        if (a.hasValue(3)) {
            this.lq.setItemTextColor(a.getColorStateList(3));
        } else {
            this.lq.setItemTextColor(bJ());
        }
        if (a.hasValue(0)) {
            s.h(this, (float) a.getDimensionPixelSize(0, 0));
        }
        this.lq.setItemBackgroundRes(a.getResourceId(4, 0));
        if (a.hasValue(1)) {
            int resourceId = a.getResourceId(1, 0);
            this.ln.lr = true;
            getMenuInflater().inflate(resourceId, this.lo);
            this.ln.lr = false;
            this.ln.n(true);
        }
        a.atG.recycle();
        addView(this.lq, layoutParams);
        if (VERSION.SDK_INT < 21) {
            View view = new View(context);
            view.setBackgroundColor(android.support.v4.content.b.i(context, R.color.lm));
            view.setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.yp)));
            addView(view);
        }
        this.lo.a(new android.support.v7.view.menu.h.a() {
            public final boolean a(h hVar, MenuItem menuItem) {
                if (BottomNavigationView.this.na != null && menuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()) {
                    BottomNavigationView.this.na;
                    return true;
                } else if (BottomNavigationView.this.mZ == null || BottomNavigationView.this.mZ.bK()) {
                    return false;
                } else {
                    return true;
                }
            }

            public final void b(h hVar) {
            }
        });
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.mZ = bVar;
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.na = aVar;
    }

    public Menu getMenu() {
        return this.lo;
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.lq.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.lq.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.lq.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.lq.setItemTextColor(colorStateList);
    }

    public int getItemBackgroundResource() {
        return this.lq.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.lq.setItemBackgroundRes(i);
    }

    public int getSelectedItemId() {
        return this.lq.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.lo.findItem(i);
        if (findItem != null && !this.lo.a(findItem, this.ln, 0)) {
            findItem.setChecked(true);
        }
    }

    private MenuInflater getMenuInflater() {
        if (this.mY == null) {
            this.mY = new g(getContext());
        }
        return this.mY;
    }

    private ColorStateList bJ() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(16842808, typedValue, true)) {
            return null;
        }
        ColorStateList h = android.support.v7.c.a.b.h(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.fl, typedValue, true)) {
            return null;
        }
        int i = typedValue.data;
        int defaultColor = h.getDefaultColor();
        return new ColorStateList(new int[][]{mX, kO, EMPTY_STATE_SET}, new int[]{h.getColorForState(mX, defaultColor), i, defaultColor});
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.nc = new Bundle();
        this.lo.c(savedState.nc);
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.LC);
            this.lo.dispatchRestoreInstanceState(savedState.nc);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
