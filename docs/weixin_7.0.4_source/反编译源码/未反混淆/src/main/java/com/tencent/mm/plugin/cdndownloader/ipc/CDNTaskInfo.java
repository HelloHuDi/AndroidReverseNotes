package com.tencent.mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CDNTaskInfo implements Parcelable {
    public static final Creator<CDNTaskInfo> CREATOR = new Creator<CDNTaskInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CDNTaskInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(923);
            CDNTaskInfo cDNTaskInfo = new CDNTaskInfo(parcel, (byte) 0);
            AppMethodBeat.o(923);
            return cDNTaskInfo;
        }
    };
    public String cHr;
    public String downloadUrl;
    public boolean egs;
    public String filePath;
    public String ktq;
    public String ktr;
    public int kts;
    public int ktt;
    public boolean ktu;
    public boolean ktv;
    public boolean ktw;

    /* synthetic */ CDNTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.i(924);
        parcel.writeByte(this.egs ? (byte) 1 : (byte) 0);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.cHr);
        parcel.writeString(this.filePath);
        parcel.writeString(this.ktq);
        parcel.writeString(this.ktr);
        parcel.writeInt(this.kts);
        parcel.writeInt(this.ktt);
        if (this.ktu) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.ktw) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        AppMethodBeat.o(924);
    }

    private CDNTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(925);
        this.egs = parcel.readByte() == (byte) 1;
        this.downloadUrl = parcel.readString();
        this.cHr = parcel.readString();
        this.filePath = parcel.readString();
        this.ktq = parcel.readString();
        this.ktr = parcel.readString();
        this.kts = parcel.readInt();
        this.ktt = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ktu = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.ktw = z2;
        AppMethodBeat.o(925);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(926);
        if (obj == this || (obj != null && (obj instanceof CDNTaskInfo) && ((CDNTaskInfo) obj).downloadUrl.equals(this.downloadUrl))) {
            AppMethodBeat.o(926);
            return true;
        }
        AppMethodBeat.o(926);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(927);
        int hashCode = this.downloadUrl.hashCode();
        AppMethodBeat.o(927);
        return hashCode;
    }

    public CDNTaskInfo(String str) {
        this.downloadUrl = str;
    }

    static {
        AppMethodBeat.i(928);
        AppMethodBeat.o(928);
    }
}
