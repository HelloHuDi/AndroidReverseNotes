package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.PartialFile */
public final class PartialFile implements Parcelable {
    public static final Creator<PartialFile> CREATOR = new C20481();
    public String bIy;
    public String cvZ;
    public String filePath;
    public String gSS;
    public int version;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.PartialFile$1 */
    static class C20481 implements Creator<PartialFile> {
        C20481() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PartialFile[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(105312);
            PartialFile partialFile = new PartialFile(parcel);
            AppMethodBeat.m2505o(105312);
            return partialFile;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(105313);
        parcel.writeString(this.bIy);
        parcel.writeInt(this.version);
        parcel.writeString(this.gSS);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.filePath);
        AppMethodBeat.m2505o(105313);
    }

    protected PartialFile(Parcel parcel) {
        AppMethodBeat.m2504i(105314);
        this.bIy = parcel.readString();
        this.version = parcel.readInt();
        this.gSS = parcel.readString();
        this.cvZ = parcel.readString();
        this.filePath = parcel.readString();
        AppMethodBeat.m2505o(105314);
    }

    static {
        AppMethodBeat.m2504i(105315);
        AppMethodBeat.m2505o(105315);
    }
}
