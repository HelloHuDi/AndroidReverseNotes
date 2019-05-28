package com.tencent.p177mm.plugin.cdndownloader.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo */
public class CDNTaskInfo implements Parcelable {
    public static final Creator<CDNTaskInfo> CREATOR = new C202061();
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

    /* renamed from: com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo$1 */
    static class C202061 implements Creator<CDNTaskInfo> {
        C202061() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CDNTaskInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(923);
            CDNTaskInfo cDNTaskInfo = new CDNTaskInfo(parcel, (byte) 0);
            AppMethodBeat.m2505o(923);
            return cDNTaskInfo;
        }
    }

    /* synthetic */ CDNTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.m2504i(924);
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
        AppMethodBeat.m2505o(924);
    }

    private CDNTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(925);
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
        AppMethodBeat.m2505o(925);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(926);
        if (obj == this || (obj != null && (obj instanceof CDNTaskInfo) && ((CDNTaskInfo) obj).downloadUrl.equals(this.downloadUrl))) {
            AppMethodBeat.m2505o(926);
            return true;
        }
        AppMethodBeat.m2505o(926);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(927);
        int hashCode = this.downloadUrl.hashCode();
        AppMethodBeat.m2505o(927);
        return hashCode;
    }

    public CDNTaskInfo(String str) {
        this.downloadUrl = str;
    }

    static {
        AppMethodBeat.m2504i(928);
        AppMethodBeat.m2505o(928);
    }
}
