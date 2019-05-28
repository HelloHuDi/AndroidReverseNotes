package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WePkgDiffInfo implements Parcelable {
    public static final Creator<WePkgDiffInfo> CREATOR = new Creator<WePkgDiffInfo>() {
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return null;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WePkgDiffInfo[i];
        }
    };
    public String cvZ;
    public String downloadUrl;
    public String eBS;
    public int fileSize;
    public String uWO;
    public String uWP;
    public int uWQ;
    public String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(63523);
        parcel.writeString(this.eBS);
        parcel.writeString(this.uWO);
        parcel.writeString(this.uWP);
        parcel.writeString(this.version);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.cvZ);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.uWQ);
        AppMethodBeat.o(63523);
    }

    static {
        AppMethodBeat.i(63524);
        AppMethodBeat.o(63524);
    }
}
