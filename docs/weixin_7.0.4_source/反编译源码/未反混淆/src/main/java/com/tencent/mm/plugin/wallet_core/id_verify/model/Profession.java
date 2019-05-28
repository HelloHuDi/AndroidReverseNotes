package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Profession implements Parcelable {
    public static final Creator<Profession> CREATOR = new Creator<Profession>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Profession[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46654);
            Profession profession = new Profession(parcel);
            AppMethodBeat.o(46654);
            return profession;
        }
    };
    public String tvN;
    public int tvO;

    public Profession(String str, int i) {
        this.tvN = str;
        this.tvO = i;
    }

    protected Profession(Parcel parcel) {
        AppMethodBeat.i(46655);
        this.tvN = parcel.readString();
        this.tvO = parcel.readInt();
        AppMethodBeat.o(46655);
    }

    static {
        AppMethodBeat.i(46657);
        AppMethodBeat.o(46657);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46656);
        parcel.writeString(this.tvN);
        parcel.writeInt(this.tvO);
        AppMethodBeat.o(46656);
    }
}
