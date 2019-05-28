package com.tencent.mm.plugin.honey_pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asj;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public class HoneyPayCardType implements Parcelable {
    public static final Creator<HoneyPayCardType> CREATOR = new Creator<HoneyPayCardType>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new HoneyPayCardType[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(41745);
            HoneyPayCardType honeyPayCardType = new HoneyPayCardType(parcel);
            AppMethodBeat.o(41745);
            return honeyPayCardType;
        }
    };
    public byte[] wR;

    public HoneyPayCardType(asj asj) {
        AppMethodBeat.i(41746);
        try {
            this.wR = asj.toByteArray();
            AppMethodBeat.o(41746);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.HoneyPayCardType", e, "", new Object[0]);
            AppMethodBeat.o(41746);
        }
    }

    protected HoneyPayCardType(Parcel parcel) {
        AppMethodBeat.i(41747);
        this.wR = new byte[parcel.readInt()];
        parcel.readByteArray(this.wR);
        AppMethodBeat.o(41747);
    }

    static {
        AppMethodBeat.i(41749);
        AppMethodBeat.o(41749);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(41748);
        parcel.writeInt(this.wR.length);
        parcel.writeByteArray(this.wR);
        AppMethodBeat.o(41748);
    }
}
