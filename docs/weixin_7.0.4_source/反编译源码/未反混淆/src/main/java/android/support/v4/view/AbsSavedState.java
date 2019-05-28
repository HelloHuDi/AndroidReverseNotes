package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class AbsSavedState implements Parcelable {
    public static final Creator<AbsSavedState> CREATOR = new ClassLoaderCreator<AbsSavedState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return AnonymousClass2.a(parcel, classLoader);
        }

        private static AbsSavedState a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.LB;
            }
            throw new IllegalStateException("superState must be null");
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AbsSavedState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return AnonymousClass2.a(parcel, null);
        }
    };
    public static final AbsSavedState LB = new AbsSavedState() {
    };
    public final Parcelable LC;

    private AbsSavedState() {
        this.LC = null;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == LB) {
            parcelable = null;
        }
        this.LC = parcelable;
    }

    protected AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = LB;
        }
        this.LC = readParcelable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.LC, i);
    }
}
