package com.tencent.mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.wx_extension.a;

public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Creator<IPCRunCgiRespWrapper> CREATOR = new Creator<IPCRunCgiRespWrapper>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCRunCgiRespWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(126221);
            IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper(parcel);
            AppMethodBeat.o(126221);
            return iPCRunCgiRespWrapper;
        }
    };
    public String aIm;
    public b ehh;
    public int errCode;
    public int errType;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(126222);
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.aIm);
        c.a(this.ehh, parcel);
        AppMethodBeat.o(126222);
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        AppMethodBeat.i(126223);
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.aIm = parcel.readString();
        this.ehh = (b) c.a(a.class.getName(), parcel);
        AppMethodBeat.o(126223);
    }

    static {
        AppMethodBeat.i(126225);
        AppMethodBeat.o(126225);
    }

    public static IPCRunCgiRespWrapper Qa() {
        AppMethodBeat.i(126224);
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.ehh = null;
        iPCRunCgiRespWrapper.aIm = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        AppMethodBeat.o(126224);
        return iPCRunCgiRespWrapper;
    }
}
