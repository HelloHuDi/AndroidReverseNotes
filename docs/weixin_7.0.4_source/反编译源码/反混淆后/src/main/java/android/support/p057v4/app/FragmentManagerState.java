package android.support.p057v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.app.FragmentManagerState */
final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new C03111();
    /* renamed from: Dq */
    FragmentState[] f259Dq;
    /* renamed from: Dr */
    int[] f260Dr;
    /* renamed from: Ds */
    BackStackState[] f261Ds;
    /* renamed from: Dt */
    int f262Dt = -1;
    int mNextFragmentIndex;

    /* renamed from: android.support.v4.app.FragmentManagerState$1 */
    static class C03111 implements Creator<FragmentManagerState> {
        C03111() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }
    }

    public FragmentManagerState(Parcel parcel) {
        this.f259Dq = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f260Dr = parcel.createIntArray();
        this.f261Ds = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.f262Dt = parcel.readInt();
        this.mNextFragmentIndex = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f259Dq, i);
        parcel.writeIntArray(this.f260Dr);
        parcel.writeTypedArray(this.f261Ds, i);
        parcel.writeInt(this.f262Dt);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
