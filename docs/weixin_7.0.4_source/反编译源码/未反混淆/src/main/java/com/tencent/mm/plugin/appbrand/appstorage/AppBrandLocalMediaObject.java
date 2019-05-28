package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p.a;

@Deprecated
public class AppBrandLocalMediaObject implements Parcelable, a {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new Creator<AppBrandLocalMediaObject>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalMediaObject[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105337);
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject(parcel);
            AppMethodBeat.o(105337);
            return appBrandLocalMediaObject;
        }
    };
    public String czD;
    public String eov;
    public String fnQ;
    public boolean gXl;
    public long gXm;
    public long gjQ;
    public String mimeType;

    public String toString() {
        AppMethodBeat.i(105338);
        String str = "AppBrandLocalMediaObject{localId='" + this.czD + '\'' + ", fileFullPath='" + this.fnQ + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.eov + '\'' + '}';
        AppMethodBeat.o(105338);
        return str;
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(105339);
        parcel.writeString(this.czD);
        parcel.writeString(this.fnQ);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.eov);
        parcel.writeByte(this.gXl ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.gjQ);
        parcel.writeLong(this.gXm);
        AppMethodBeat.o(105339);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        AppMethodBeat.i(105340);
        this.czD = parcel.readString();
        this.fnQ = parcel.readString();
        this.mimeType = parcel.readString();
        this.eov = parcel.readString();
        this.gXl = parcel.readByte() != (byte) 0;
        this.gjQ = parcel.readLong();
        this.gXm = parcel.readLong();
        AppMethodBeat.o(105340);
    }

    static {
        AppMethodBeat.i(105341);
        AppMethodBeat.o(105341);
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
