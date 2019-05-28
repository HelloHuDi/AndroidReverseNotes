package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p.C19093a;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject */
public class AppBrandLocalMediaObject implements Parcelable, C19093a {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new C101011();
    public String czD;
    public String eov;
    public String fnQ;
    public boolean gXl;
    public long gXm;
    public long gjQ;
    public String mimeType;

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject$1 */
    static class C101011 implements Creator<AppBrandLocalMediaObject> {
        C101011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalMediaObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(105337);
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject(parcel);
            AppMethodBeat.m2505o(105337);
            return appBrandLocalMediaObject;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(105338);
        String str = "AppBrandLocalMediaObject{localId='" + this.czD + '\'' + ", fileFullPath='" + this.fnQ + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.eov + '\'' + '}';
        AppMethodBeat.m2505o(105338);
        return str;
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(105339);
        parcel.writeString(this.czD);
        parcel.writeString(this.fnQ);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.eov);
        parcel.writeByte(this.gXl ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.gjQ);
        parcel.writeLong(this.gXm);
        AppMethodBeat.m2505o(105339);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        AppMethodBeat.m2504i(105340);
        this.czD = parcel.readString();
        this.fnQ = parcel.readString();
        this.mimeType = parcel.readString();
        this.eov = parcel.readString();
        this.gXl = parcel.readByte() != (byte) 0;
        this.gjQ = parcel.readLong();
        this.gXm = parcel.readLong();
        AppMethodBeat.m2505o(105340);
    }

    static {
        AppMethodBeat.m2504i(105341);
        AppMethodBeat.m2505o(105341);
    }

    public final String getFileName() {
        return this.czD;
    }

    public final long awL() {
        return this.gjQ;
    }

    public final long lastModified() {
        return this.gXm;
    }
}
