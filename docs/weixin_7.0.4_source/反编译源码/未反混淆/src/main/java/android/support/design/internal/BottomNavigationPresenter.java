package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.transition.ae;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.o.a;
import android.support.v7.view.menu.u;
import android.view.MenuItem;

public final class BottomNavigationPresenter implements o {
    private h lo;
    public BottomNavigationMenuView lq;
    public boolean lr = false;
    public int mId;

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        int ls;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.ls = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ls);
        }
    }

    public final void a(Context context, h hVar) {
        this.lq.lo = this.lo;
        this.lo = hVar;
    }

    public final void n(boolean z) {
        if (!this.lr) {
            if (z) {
                this.lq.bs();
                return;
            }
            BottomNavigationMenuView bottomNavigationMenuView = this.lq;
            int size = bottomNavigationMenuView.lo.size();
            if (size != bottomNavigationMenuView.lg.length) {
                bottomNavigationMenuView.bs();
                return;
            }
            int i = bottomNavigationMenuView.lh;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = bottomNavigationMenuView.lo.getItem(i2);
                if (item.isChecked()) {
                    bottomNavigationMenuView.lh = item.getItemId();
                    bottomNavigationMenuView.li = i2;
                }
            }
            if (i != bottomNavigationMenuView.lh) {
                ae.a(bottomNavigationMenuView, bottomNavigationMenuView.la);
            }
            for (i = 0; i < size; i++) {
                bottomNavigationMenuView.ln.lr = true;
                bottomNavigationMenuView.lg[i].a((j) bottomNavigationMenuView.lo.getItem(i));
                bottomNavigationMenuView.ln.lr = false;
            }
        }
    }

    public final void a(a aVar) {
    }

    public final boolean a(u uVar) {
        return false;
    }

    public final void a(h hVar, boolean z) {
    }

    public final boolean bt() {
        return false;
    }

    public final boolean b(j jVar) {
        return false;
    }

    public final boolean c(j jVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.ls = this.lq.getSelectedItemId();
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            BottomNavigationMenuView bottomNavigationMenuView = this.lq;
            int i = ((SavedState) parcelable).ls;
            int size = bottomNavigationMenuView.lo.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = bottomNavigationMenuView.lo.getItem(i2);
                if (i == item.getItemId()) {
                    bottomNavigationMenuView.lh = i;
                    bottomNavigationMenuView.li = i2;
                    item.setChecked(true);
                    return;
                }
            }
        }
    }
}
