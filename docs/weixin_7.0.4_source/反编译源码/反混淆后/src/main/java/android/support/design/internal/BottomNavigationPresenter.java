package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p069v7.view.menu.C0628o;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C6236h;
import android.support.p069v7.view.menu.C6239j;
import android.support.p069v7.view.menu.C7459u;
import android.support.transition.C44947ae;
import android.view.MenuItem;

public final class BottomNavigationPresenter implements C0628o {
    /* renamed from: lo */
    private C6236h f5056lo;
    /* renamed from: lq */
    public BottomNavigationMenuView f5057lq;
    /* renamed from: lr */
    public boolean f5058lr = false;
    public int mId;

    static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C252991();
        /* renamed from: ls */
        int f5059ls;

        /* renamed from: android.support.design.internal.BottomNavigationPresenter$SavedState$1 */
        static class C252991 implements Creator<SavedState> {
            C252991() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f5059ls = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5059ls);
        }
    }

    /* renamed from: a */
    public final void mo1598a(Context context, C6236h c6236h) {
        this.f5057lq.f15674lo = this.f5056lo;
        this.f5056lo = c6236h;
    }

    /* renamed from: n */
    public final void mo1606n(boolean z) {
        if (!this.f5058lr) {
            if (z) {
                this.f5057lq.mo59124bs();
                return;
            }
            BottomNavigationMenuView bottomNavigationMenuView = this.f5057lq;
            int size = bottomNavigationMenuView.f15674lo.size();
            if (size != bottomNavigationMenuView.f15666lg.length) {
                bottomNavigationMenuView.mo59124bs();
                return;
            }
            int i = bottomNavigationMenuView.f15667lh;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = bottomNavigationMenuView.f15674lo.getItem(i2);
                if (item.isChecked()) {
                    bottomNavigationMenuView.f15667lh = item.getItemId();
                    bottomNavigationMenuView.f15668li = i2;
                }
            }
            if (i != bottomNavigationMenuView.f15667lh) {
                C44947ae.m82221a(bottomNavigationMenuView, bottomNavigationMenuView.f15660la);
            }
            for (i = 0; i < size; i++) {
                bottomNavigationMenuView.f15673ln.f5058lr = true;
                bottomNavigationMenuView.f15666lg[i].mo1609a((C6239j) bottomNavigationMenuView.f15674lo.getItem(i));
                bottomNavigationMenuView.f15673ln.f5058lr = false;
            }
        }
    }

    /* renamed from: a */
    public final void mo1600a(C0627a c0627a) {
    }

    /* renamed from: a */
    public final boolean mo1601a(C7459u c7459u) {
        return false;
    }

    /* renamed from: a */
    public final void mo1599a(C6236h c6236h, boolean z) {
    }

    /* renamed from: bt */
    public final boolean mo1603bt() {
        return false;
    }

    /* renamed from: b */
    public final boolean mo1602b(C6239j c6239j) {
        return false;
    }

    /* renamed from: c */
    public final boolean mo1604c(C6239j c6239j) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f5059ls = this.f5057lq.getSelectedItemId();
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            BottomNavigationMenuView bottomNavigationMenuView = this.f5057lq;
            int i = ((SavedState) parcelable).f5059ls;
            int size = bottomNavigationMenuView.f15674lo.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = bottomNavigationMenuView.f15674lo.getItem(i2);
                if (i == item.getItemId()) {
                    bottomNavigationMenuView.f15667lh = i;
                    bottomNavigationMenuView.f15668li = i2;
                    item.setChecked(true);
                    return;
                }
            }
        }
    }
}
