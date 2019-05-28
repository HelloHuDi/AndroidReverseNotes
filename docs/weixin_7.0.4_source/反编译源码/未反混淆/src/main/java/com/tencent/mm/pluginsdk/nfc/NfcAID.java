package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NfcAID implements Parcelable {
    public static final Creator<NfcAID> CREATOR = new Creator<NfcAID>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NfcAID[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(27433);
            NfcAID nfcAID = new NfcAID(parcel);
            AppMethodBeat.o(27433);
            return nfcAID;
        }
    };
    public String mURL = null;
    public String vdi = null;

    public int describeContents() {
        return 0;
    }

    public NfcAID(Parcel parcel) {
        AppMethodBeat.i(27434);
        this.vdi = parcel.readString();
        this.mURL = parcel.readString();
        AppMethodBeat.o(27434);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(27435);
        parcel.writeString(this.vdi);
        parcel.writeString(this.mURL);
        AppMethodBeat.o(27435);
    }

    static {
        AppMethodBeat.i(27436);
        AppMethodBeat.o(27436);
    }
}
