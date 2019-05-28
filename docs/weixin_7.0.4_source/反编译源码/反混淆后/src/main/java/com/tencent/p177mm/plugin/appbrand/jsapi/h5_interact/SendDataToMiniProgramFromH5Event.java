package com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event */
public class SendDataToMiniProgramFromH5Event implements Parcelable {
    public static final Creator<SendDataToMiniProgramFromH5Event> CREATOR = new C104311();
    public String data;
    public String hJW;
    public int hJX;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToMiniProgramFromH5Event$1 */
    static class C104311 implements Creator<SendDataToMiniProgramFromH5Event> {
        C104311() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendDataToMiniProgramFromH5Event[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131090);
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = new SendDataToMiniProgramFromH5Event(parcel);
            AppMethodBeat.m2505o(131090);
            return sendDataToMiniProgramFromH5Event;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131091);
        parcel.writeString(this.hJW);
        parcel.writeString(this.data);
        parcel.writeInt(this.hJX);
        AppMethodBeat.m2505o(131091);
    }

    protected SendDataToMiniProgramFromH5Event(Parcel parcel) {
        AppMethodBeat.m2504i(131092);
        this.hJW = parcel.readString();
        this.data = parcel.readString();
        this.hJX = parcel.readInt();
        AppMethodBeat.m2505o(131092);
    }

    static {
        AppMethodBeat.m2504i(131093);
        AppMethodBeat.m2505o(131093);
    }
}
