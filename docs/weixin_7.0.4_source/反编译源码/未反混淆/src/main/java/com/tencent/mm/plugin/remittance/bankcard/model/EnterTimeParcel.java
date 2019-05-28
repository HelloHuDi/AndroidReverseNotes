package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.yq;

public class EnterTimeParcel implements Parcelable {
    public static final Creator<EnterTimeParcel> CREATOR = new Creator<EnterTimeParcel>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EnterTimeParcel[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(44496);
            EnterTimeParcel enterTimeParcel = new EnterTimeParcel(parcel);
            AppMethodBeat.o(44496);
            return enterTimeParcel;
        }
    };
    public String color;
    public int pLQ;
    public String pLR;
    public String pLS;
    public int pLT;

    public EnterTimeParcel(yq yqVar) {
        this.pLQ = yqVar.pLQ;
        this.pLR = yqVar.pLR;
        this.pLS = yqVar.pLS;
        this.pLT = yqVar.pLT;
        this.color = yqVar.color;
    }

    public EnterTimeParcel(Parcel parcel) {
        AppMethodBeat.i(44497);
        this.pLQ = parcel.readInt();
        this.pLR = parcel.readString();
        this.pLS = parcel.readString();
        this.pLT = parcel.readInt();
        this.color = parcel.readString();
        AppMethodBeat.o(44497);
    }

    static {
        AppMethodBeat.i(44499);
        AppMethodBeat.o(44499);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(44498);
        parcel.writeInt(this.pLQ);
        parcel.writeString(this.pLR);
        parcel.writeString(this.pLS);
        parcel.writeInt(this.pLT);
        parcel.writeString(this.color);
        AppMethodBeat.o(44498);
    }
}
