package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SendDataToMiniProgramFromH5Event implements Parcelable {
    public static final Creator<SendDataToMiniProgramFromH5Event> CREATOR = new Creator<SendDataToMiniProgramFromH5Event>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendDataToMiniProgramFromH5Event[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(131090);
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event(parcel);
            AppMethodBeat.o(131090);
            return sendDataToMiniProgramFromH5Event;
        }
    };
    public String data;
    public String hJW;
    public int hJX;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(131091);
        parcel.writeString(this.hJW);
        parcel.writeString(this.data);
        parcel.writeInt(this.hJX);
        AppMethodBeat.o(131091);
    }

    protected SendDataToMiniProgramFromH5Event(Parcel parcel) {
        AppMethodBeat.i(131092);
        this.hJW = parcel.readString();
        this.data = parcel.readString();
        this.hJX = parcel.readInt();
        AppMethodBeat.o(131092);
    }

    static {
        AppMethodBeat.i(131093);
        AppMethodBeat.o(131093);
    }
}
