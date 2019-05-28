package com.tencent.p177mm.ipcinvoker.wx_extension.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18509c;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42143a;
import com.tencent.p177mm.p183ai.C7472b;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper */
public class IPCRunCgiRespWrapper implements Parcelable {
    public static final Creator<IPCRunCgiRespWrapper> CREATOR = new C95611();
    public String aIm;
    public C7472b ehh;
    public int errCode;
    public int errType;

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper$1 */
    static class C95611 implements Creator<IPCRunCgiRespWrapper> {
        C95611() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCRunCgiRespWrapper[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(126221);
            IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper(parcel);
            AppMethodBeat.m2505o(126221);
            return iPCRunCgiRespWrapper;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(126222);
        parcel.writeInt(this.errType);
        parcel.writeInt(this.errCode);
        parcel.writeString(this.aIm);
        C18509c.m28814a(this.ehh, parcel);
        AppMethodBeat.m2505o(126222);
    }

    IPCRunCgiRespWrapper(Parcel parcel) {
        AppMethodBeat.m2504i(126223);
        this.errType = parcel.readInt();
        this.errCode = parcel.readInt();
        this.aIm = parcel.readString();
        this.ehh = (C7472b) C18509c.m28812a(C42143a.class.getName(), parcel);
        AppMethodBeat.m2505o(126223);
    }

    static {
        AppMethodBeat.m2504i(126225);
        AppMethodBeat.m2505o(126225);
    }

    /* renamed from: Qa */
    public static IPCRunCgiRespWrapper m17025Qa() {
        AppMethodBeat.m2504i(126224);
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
        iPCRunCgiRespWrapper.ehh = null;
        iPCRunCgiRespWrapper.aIm = null;
        iPCRunCgiRespWrapper.errType = 3;
        iPCRunCgiRespWrapper.errCode = -2;
        AppMethodBeat.m2505o(126224);
        return iPCRunCgiRespWrapper;
    }
}
