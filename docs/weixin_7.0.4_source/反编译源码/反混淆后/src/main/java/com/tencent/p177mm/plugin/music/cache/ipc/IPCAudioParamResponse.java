package com.tencent.p177mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9060h;

/* renamed from: com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse */
public class IPCAudioParamResponse implements Parcelable {
    public static final Creator<IPCAudioParamResponse> CREATOR = new C285531();
    public String cFI;
    public byte[] fKv;
    public int fKw;
    public String fKx;
    public int fKy;
    public String fileName;
    public String musicUrl;

    /* renamed from: com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse$1 */
    static class C285531 implements Creator<IPCAudioParamResponse> {
        C285531() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCAudioParamResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(137461);
            IPCAudioParamResponse iPCAudioParamResponse = new IPCAudioParamResponse(parcel);
            AppMethodBeat.m2505o(137461);
            return iPCAudioParamResponse;
        }
    }

    public IPCAudioParamResponse(C9060h c9060h) {
        this.cFI = c9060h.cFI;
        this.musicUrl = c9060h.musicUrl;
        this.fileName = c9060h.fileName;
        this.fKw = c9060h.fKw;
        this.fKx = c9060h.fKx;
        this.fKv = c9060h.fKv;
        this.fKy = c9060h.fKy;
    }

    public IPCAudioParamResponse(Parcel parcel) {
        AppMethodBeat.m2504i(137462);
        this.cFI = parcel.readString();
        this.musicUrl = parcel.readString();
        this.fileName = parcel.readString();
        this.fKx = parcel.readString();
        this.fKw = parcel.readInt();
        this.fKy = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.fKv = new byte[readInt];
            parcel.readByteArray(this.fKv);
        }
        AppMethodBeat.m2505o(137462);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(137463);
        parcel.writeString(this.cFI);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.fileName);
        parcel.writeString(this.fKx);
        parcel.writeInt(this.fKw);
        parcel.writeInt(this.fKy);
        if (this.fKv != null) {
            parcel.writeInt(this.fKv.length);
            parcel.writeByteArray(this.fKv);
            AppMethodBeat.m2505o(137463);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.m2505o(137463);
    }

    static {
        AppMethodBeat.m2504i(137464);
        AppMethodBeat.m2505o(137464);
    }
}
