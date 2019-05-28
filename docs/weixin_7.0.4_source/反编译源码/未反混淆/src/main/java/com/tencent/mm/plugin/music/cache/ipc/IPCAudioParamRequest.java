package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCAudioParamRequest implements Parcelable {
    public static final Creator<IPCAudioParamRequest> CREATOR = new Creator<IPCAudioParamRequest>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCAudioParamRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(137457);
            IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest(parcel);
            AppMethodBeat.o(137457);
            return iPCAudioParamRequest;
        }
    };
    public String cFI = "";
    public byte[] fKv;
    public String mimeType = "";
    public int oLm = 0;

    public IPCAudioParamRequest(Parcel parcel) {
        AppMethodBeat.i(137458);
        this.cFI = parcel.readString();
        this.oLm = parcel.readInt();
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.fKv = new byte[readInt];
            parcel.readByteArray(this.fKv);
        }
        AppMethodBeat.o(137458);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(137459);
        parcel.writeString(this.cFI);
        parcel.writeInt(this.oLm);
        parcel.writeString(this.mimeType);
        if (this.fKv != null) {
            parcel.writeInt(this.fKv.length);
            parcel.writeByteArray(this.fKv);
            AppMethodBeat.o(137459);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(137459);
    }

    static {
        AppMethodBeat.i(137460);
        AppMethodBeat.o(137460);
    }
}
