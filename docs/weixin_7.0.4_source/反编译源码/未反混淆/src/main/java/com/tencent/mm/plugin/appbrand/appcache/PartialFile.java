package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PartialFile implements Parcelable {
    public static final Creator<PartialFile> CREATOR = new Creator<PartialFile>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PartialFile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105312);
            PartialFile partialFile = new PartialFile(parcel);
            AppMethodBeat.o(105312);
            return partialFile;
        }
    };
    public String bIy;
    public String cvZ;
    public String filePath;
    public String gSS;
    public int version;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(105313);
        parcel.writeString(this.bIy);
        parcel.writeInt(this.version);
        parcel.writeString(this.gSS);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.filePath);
        AppMethodBeat.o(105313);
    }

    protected PartialFile(Parcel parcel) {
        AppMethodBeat.i(105314);
        this.bIy = parcel.readString();
        this.version = parcel.readInt();
        this.gSS = parcel.readString();
        this.cvZ = parcel.readString();
        this.filePath = parcel.readString();
        AppMethodBeat.o(105314);
    }

    static {
        AppMethodBeat.i(105315);
        AppMethodBeat.o(105315);
    }
}
