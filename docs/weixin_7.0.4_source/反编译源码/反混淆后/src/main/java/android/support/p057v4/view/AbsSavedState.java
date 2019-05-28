package android.support.p057v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.view.AbsSavedState */
public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = new C04322();
    /* renamed from: LB */
    public static final AbsSavedState f506LB = new C04331();
    /* renamed from: LC */
    public final Parcelable f507LC;

    /* renamed from: android.support.v4.view.AbsSavedState$2 */
    static class C04322 implements ClassLoaderCreator<AbsSavedState> {
        C04322() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return C04322.m763a(parcel, classLoader);
        }

        /* renamed from: a */
        private static AbsSavedState m763a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f506LB;
            }
            throw new IllegalStateException("superState must be null");
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AbsSavedState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return C04322.m763a(parcel, null);
        }
    }

    /* renamed from: android.support.v4.view.AbsSavedState$1 */
    static class C04331 extends AbsSavedState {
        C04331() {
            super();
        }
    }

    private AbsSavedState() {
        this.f507LC = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == f506LB) {
            parcelable = null;
        }
        this.f507LC = parcelable;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f506LB;
        }
        this.f507LC = readParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f507LC, i);
    }
}
