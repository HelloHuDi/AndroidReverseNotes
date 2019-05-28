package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }
    };
    final int Ca;
    final int Cb;
    final int Cf;
    final CharSequence Cg;
    final int Ch;
    final CharSequence Ci;
    final ArrayList<String> Cj;
    final ArrayList<String> Ck;
    final boolean Cl;
    final int[] Cs;
    final int mIndex;
    final String mName;

    public BackStackState(b bVar) {
        int size = bVar.BV.size();
        this.Cs = new int[(size * 6)];
        if (bVar.Cc) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) bVar.BV.get(i2);
                int i3 = i + 1;
                this.Cs[i] = aVar.Cn;
                int i4 = i3 + 1;
                this.Cs[i3] = aVar.fragment != null ? aVar.fragment.mIndex : -1;
                int i5 = i4 + 1;
                this.Cs[i4] = aVar.Co;
                i3 = i5 + 1;
                this.Cs[i5] = aVar.Cp;
                i5 = i3 + 1;
                this.Cs[i3] = aVar.Cq;
                i = i5 + 1;
                this.Cs[i5] = aVar.Cr;
            }
            this.Ca = bVar.Ca;
            this.Cb = bVar.Cb;
            this.mName = bVar.mName;
            this.mIndex = bVar.mIndex;
            this.Cf = bVar.Cf;
            this.Cg = bVar.Cg;
            this.Ch = bVar.Ch;
            this.Ci = bVar.Ci;
            this.Cj = bVar.Cj;
            this.Ck = bVar.Ck;
            this.Cl = bVar.Cl;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.Cs = parcel.createIntArray();
        this.Ca = parcel.readInt();
        this.Cb = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.Cf = parcel.readInt();
        this.Cg = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Ch = parcel.readInt();
        this.Ci = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Cj = parcel.createStringArrayList();
        this.Ck = parcel.createStringArrayList();
        this.Cl = parcel.readInt() != 0;
    }

    public final b a(FragmentManagerImpl fragmentManagerImpl) {
        b bVar = new b(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.Cs.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.Cn = this.Cs[i2];
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Instantiate ").append(bVar).append(" op #").append(i).append(" base fragment #").append(this.Cs[i3]);
            }
            i2 = i3 + 1;
            int i4 = this.Cs[i3];
            if (i4 >= 0) {
                aVar.fragment = (Fragment) fragmentManagerImpl.mActive.get(i4);
            } else {
                aVar.fragment = null;
            }
            i3 = i2 + 1;
            aVar.Co = this.Cs[i2];
            i2 = i3 + 1;
            aVar.Cp = this.Cs[i3];
            i3 = i2 + 1;
            aVar.Cq = this.Cs[i2];
            i2 = i3 + 1;
            aVar.Cr = this.Cs[i3];
            bVar.BW = aVar.Co;
            bVar.BX = aVar.Cp;
            bVar.BY = aVar.Cq;
            bVar.BZ = aVar.Cr;
            bVar.a(aVar);
            i++;
        }
        bVar.Ca = this.Ca;
        bVar.Cb = this.Cb;
        bVar.mName = this.mName;
        bVar.mIndex = this.mIndex;
        bVar.Cc = true;
        bVar.Cf = this.Cf;
        bVar.Cg = this.Cg;
        bVar.Ch = this.Ch;
        bVar.Ci = this.Ci;
        bVar.Cj = this.Cj;
        bVar.Ck = this.Ck;
        bVar.Cl = this.Cl;
        bVar.aq(1);
        return bVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.Cs);
        parcel.writeInt(this.Ca);
        parcel.writeInt(this.Cb);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.Cf);
        TextUtils.writeToParcel(this.Cg, parcel, 0);
        parcel.writeInt(this.Ch);
        TextUtils.writeToParcel(this.Ci, parcel, 0);
        parcel.writeStringList(this.Cj);
        parcel.writeStringList(this.Ck);
        if (this.Cl) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
