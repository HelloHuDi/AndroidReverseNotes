package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR = new Creator<FragmentManagerState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentManagerState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }
    };
    FragmentState[] Dq;
    int[] Dr;
    BackStackState[] Ds;
    int Dt = -1;
    int mNextFragmentIndex;

    public FragmentManagerState(Parcel parcel) {
        this.Dq = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.Dr = parcel.createIntArray();
        this.Ds = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.Dt = parcel.readInt();
        this.mNextFragmentIndex = parcel.readInt();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.Dq, i);
        parcel.writeIntArray(this.Dr);
        parcel.writeTypedArray(this.Ds, i);
        parcel.writeInt(this.Dt);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
