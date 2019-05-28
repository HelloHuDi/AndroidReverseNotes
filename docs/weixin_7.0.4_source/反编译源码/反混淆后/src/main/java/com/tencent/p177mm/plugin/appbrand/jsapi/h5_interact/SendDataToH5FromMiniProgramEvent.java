package com.tencent.p177mm.plugin.appbrand.jsapi.h5_interact;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p600b.C4883b;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent */
public class SendDataToH5FromMiniProgramEvent extends C4883b implements Parcelable {
    public static final Creator<SendDataToH5FromMiniProgramEvent> CREATOR = new C269991();
    public String data;
    public String hJU;
    public int hJV;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h5_interact.SendDataToH5FromMiniProgramEvent$1 */
    static class C269991 implements Creator<SendDataToH5FromMiniProgramEvent> {
        C269991() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SendDataToH5FromMiniProgramEvent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(93751);
            SendDataToH5FromMiniProgramEvent sendDataToH5FromMiniProgramEvent = new SendDataToH5FromMiniProgramEvent(parcel);
            AppMethodBeat.m2505o(93751);
            return sendDataToH5FromMiniProgramEvent;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(93752);
        parcel.writeString(this.hJU);
        parcel.writeString(this.data);
        parcel.writeInt(this.hJV);
        AppMethodBeat.m2505o(93752);
    }

    protected SendDataToH5FromMiniProgramEvent(Parcel parcel) {
        AppMethodBeat.m2504i(93753);
        this.hJU = parcel.readString();
        this.data = parcel.readString();
        this.hJV = parcel.readInt();
        AppMethodBeat.m2505o(93753);
    }

    static {
        AppMethodBeat.m2504i(93754);
        AppMethodBeat.m2505o(93754);
    }
}
