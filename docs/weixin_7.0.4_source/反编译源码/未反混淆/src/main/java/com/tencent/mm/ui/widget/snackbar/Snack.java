package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

class Snack implements Parcelable {
    public static final Creator<Snack> CREATOR = new Creator<Snack>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Snack[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(112968);
            Snack snack = new Snack(parcel);
            AppMethodBeat.o(112968);
            return snack;
        }
    };
    final String nqb;
    final String zTI;
    final int zTJ;
    final Parcelable zTK;
    final short zTL;
    final int zTM;

    static {
        AppMethodBeat.i(112971);
        AppMethodBeat.o(112971);
    }

    Snack(String str, String str2, int i, Parcelable parcelable, short s, int i2) {
        this.nqb = str;
        this.zTI = str2;
        this.zTJ = i;
        this.zTK = parcelable;
        this.zTL = s;
        this.zTM = i2;
    }

    Snack(Parcel parcel) {
        AppMethodBeat.i(112969);
        this.nqb = parcel.readString();
        this.zTI = parcel.readString();
        this.zTJ = parcel.readInt();
        this.zTK = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.zTL = (short) parcel.readInt();
        this.zTM = parcel.readInt();
        AppMethodBeat.o(112969);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(112970);
        parcel.writeString(this.nqb);
        parcel.writeString(this.zTI);
        parcel.writeInt(this.zTJ);
        parcel.writeParcelable(this.zTK, 0);
        parcel.writeInt(this.zTL);
        parcel.writeInt(this.zTM);
        AppMethodBeat.o(112970);
    }

    public int describeContents() {
        return 0;
    }
}
