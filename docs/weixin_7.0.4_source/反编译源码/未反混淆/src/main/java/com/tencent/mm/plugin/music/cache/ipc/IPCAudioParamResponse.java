package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.h;

public class IPCAudioParamResponse implements Parcelable {
    public static final Creator<IPCAudioParamResponse> CREATOR = new Creator<IPCAudioParamResponse>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCAudioParamResponse[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(137461);
            IPCAudioParamResponse iPCAudioParamResponse = new IPCAudioParamResponse(parcel);
            AppMethodBeat.o(137461);
            return iPCAudioParamResponse;
        }
    };
    public String cFI;
    public byte[] fKv;
    public int fKw;
    public String fKx;
    public int fKy;
    public String fileName;
    public String musicUrl;

    public IPCAudioParamResponse(h hVar) {
        this.cFI = hVar.cFI;
        this.musicUrl = hVar.musicUrl;
        this.fileName = hVar.fileName;
        this.fKw = hVar.fKw;
        this.fKx = hVar.fKx;
        this.fKv = hVar.fKv;
        this.fKy = hVar.fKy;
    }

    public IPCAudioParamResponse(Parcel parcel) {
        AppMethodBeat.i(137462);
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
        AppMethodBeat.o(137462);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(137463);
        parcel.writeString(this.cFI);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.fileName);
        parcel.writeString(this.fKx);
        parcel.writeInt(this.fKw);
        parcel.writeInt(this.fKy);
        if (this.fKv != null) {
            parcel.writeInt(this.fKv.length);
            parcel.writeByteArray(this.fKv);
            AppMethodBeat.o(137463);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(137463);
    }

    static {
        AppMethodBeat.i(137464);
        AppMethodBeat.o(137464);
    }
}
