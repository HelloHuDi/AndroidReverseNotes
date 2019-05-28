package com.tencent.p177mm.plugin.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo */
public class FileDownloadTaskInfo implements Parcelable {
    public static Creator<FileDownloadTaskInfo> CREATOR = new C28851();
    public String appId;
    public int cBA;
    public String cvZ;
    /* renamed from: id */
    public long f16167id;
    public long jrb;
    public long kNr;
    public boolean kNs;
    public boolean kNt;
    public boolean kNu;
    public String path;
    public int status;
    public String url;

    /* renamed from: com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo$1 */
    static class C28851 implements Creator<FileDownloadTaskInfo> {
        C28851() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FileDownloadTaskInfo[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(2446);
            FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo(parcel, (byte) 0);
            AppMethodBeat.m2505o(2446);
            return fileDownloadTaskInfo;
        }
    }

    /* synthetic */ FileDownloadTaskInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(2447);
        parcel.writeLong(this.f16167id);
        parcel.writeString(this.url);
        parcel.writeInt(this.status);
        parcel.writeString(this.path);
        parcel.writeString(this.cvZ);
        parcel.writeString(this.appId);
        parcel.writeLong(this.kNr);
        parcel.writeLong(this.jrb);
        if (this.kNs) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.cBA);
        if (this.kNt) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.kNu) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        AppMethodBeat.m2505o(2447);
    }

    public FileDownloadTaskInfo() {
        this.f16167id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.cvZ = "";
        this.appId = "";
        this.kNr = 0;
        this.jrb = 0;
        this.kNs = false;
        this.cBA = 2;
        this.kNt = false;
        this.kNu = false;
    }

    private FileDownloadTaskInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(2448);
        this.f16167id = -1;
        this.url = "";
        this.status = 0;
        this.path = "";
        this.cvZ = "";
        this.appId = "";
        this.kNr = 0;
        this.jrb = 0;
        this.kNs = false;
        this.cBA = 2;
        this.kNt = false;
        this.kNu = false;
        this.f16167id = parcel.readLong();
        this.url = parcel.readString();
        this.status = parcel.readInt();
        this.path = parcel.readString();
        this.cvZ = parcel.readString();
        this.appId = parcel.readString();
        this.kNr = parcel.readLong();
        this.jrb = parcel.readLong();
        this.kNs = parcel.readByte() == (byte) 1;
        this.cBA = parcel.readInt();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.kNt = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.kNu = z2;
        AppMethodBeat.m2505o(2448);
    }

    static {
        AppMethodBeat.m2504i(2449);
        AppMethodBeat.m2505o(2449);
    }
}
