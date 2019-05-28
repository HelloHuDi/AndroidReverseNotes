package com.tencent.p177mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest */
public class IPCAudioParamRequest implements Parcelable {
    public static final Creator<IPCAudioParamRequest> CREATOR = new C35241();
    public String cFI = "";
    public byte[] fKv;
    public String mimeType = "";
    public int oLm = 0;

    /* renamed from: com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest$1 */
    static class C35241 implements Creator<IPCAudioParamRequest> {
        C35241() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCAudioParamRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(137457);
            IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest(parcel);
            AppMethodBeat.m2505o(137457);
            return iPCAudioParamRequest;
        }
    }

    public IPCAudioParamRequest(Parcel parcel) {
        AppMethodBeat.m2504i(137458);
        this.cFI = parcel.readString();
        this.oLm = parcel.readInt();
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.fKv = new byte[readInt];
            parcel.readByteArray(this.fKv);
        }
        AppMethodBeat.m2505o(137458);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(137459);
        parcel.writeString(this.cFI);
        parcel.writeInt(this.oLm);
        parcel.writeString(this.mimeType);
        if (this.fKv != null) {
            parcel.writeInt(this.fKv.length);
            parcel.writeByteArray(this.fKv);
            AppMethodBeat.m2505o(137459);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(137459);
    }

    static {
        AppMethodBeat.m2504i(137460);
        AppMethodBeat.m2505o(137460);
    }
}
