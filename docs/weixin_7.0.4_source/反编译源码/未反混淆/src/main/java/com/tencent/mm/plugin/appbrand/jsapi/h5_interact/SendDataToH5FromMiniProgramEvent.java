package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public class SendDataToH5FromMiniProgramEvent extends b implements Parcelable {
    public static final Creator<SendDataToH5FromMiniProgramEvent> CREATOR = new Creator<SendDataToH5FromMiniProgramEvent>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendDataToH5FromMiniProgramEvent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(93751);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent(parcel);
            AppMethodBeat.o(93751);
            return sendDataToH5FromMiniProgramEvent;
        }
    };
    public String data;
    public String hJU;
    public int hJV;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(93752);
        parcel.writeString(this.hJU);
        parcel.writeString(this.data);
        parcel.writeInt(this.hJV);
        AppMethodBeat.o(93752);
    }

    protected SendDataToH5FromMiniProgramEvent(Parcel parcel) {
        AppMethodBeat.i(93753);
        this.hJU = parcel.readString();
        this.data = parcel.readString();
        this.hJV = parcel.readInt();
        AppMethodBeat.o(93753);
    }

    static {
        AppMethodBeat.i(93754);
        AppMethodBeat.o(93754);
    }
}
