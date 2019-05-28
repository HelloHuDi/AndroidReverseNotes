package com.tencent.mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgDownloadProcessTask> CREATOR = new Creator<WepkgDownloadProcessTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgDownloadProcessTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63539);
            WepkgDownloadProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask(parcel, (byte) 0);
            AppMethodBeat.o(63539);
            return wepkgDownloadProcessTask;
        }
    };
    public String cSY;
    public String cvZ;
    public String downloadUrl;
    public int fileType;
    public String gSP;
    public Runnable hww;
    public int uWQ;
    public String uXe;
    public long uXf;
    public RetCode uXg;
    public String version;

    /* synthetic */ WepkgDownloadProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    static /* synthetic */ void a(WepkgDownloadProcessTask wepkgDownloadProcessTask) {
        AppMethodBeat.i(63545);
        wepkgDownloadProcessTask.wM();
        AppMethodBeat.o(63545);
    }

    private WepkgDownloadProcessTask(Parcel parcel) {
        AppMethodBeat.i(63540);
        g(parcel);
        AppMethodBeat.o(63540);
    }

    public final void asP() {
        AppMethodBeat.i(63541);
        aBV();
        AnonymousClass1 anonymousClass1 = new IWepkgUpdateCallback() {
            public final void a(String str, String str2, RetCode retCode) {
                AppMethodBeat.i(63538);
                ab.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", retCode);
                WepkgDownloadProcessTask.this.cSY = str;
                WepkgDownloadProcessTask.this.gSP = str2;
                WepkgDownloadProcessTask.this.uXg = retCode;
                WepkgDownloadProcessTask.this.aBW();
                WepkgDownloadProcessTask.a(WepkgDownloadProcessTask.this);
                AppMethodBeat.o(63538);
            }
        };
        if (this.fileType == 1) {
            WePkgDownloader.dgx().a(this.cSY, anonymousClass1);
            AppMethodBeat.o(63541);
            return;
        }
        WePkgDownloader.dgx().a(this.fileType, bo.nullAsNil(this.cSY), "", bo.nullAsNil(this.uXe), bo.nullAsNil(this.downloadUrl), this.uXf, bo.nullAsNil(this.version), "", bo.nullAsNil(this.cvZ), this.uWQ, anonymousClass1);
        AppMethodBeat.o(63541);
    }

    public final void asQ() {
        AppMethodBeat.i(63542);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.o(63542);
    }

    public final void m(Parcel parcel) {
        AppMethodBeat.i(63543);
        this.fileType = parcel.readInt();
        this.cSY = parcel.readString();
        this.uXe = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.uXf = parcel.readLong();
        this.version = parcel.readString();
        this.cvZ = parcel.readString();
        this.uWQ = parcel.readInt();
        this.gSP = parcel.readString();
        this.uXg = (RetCode) parcel.readParcelable(RetCode.class.getClassLoader());
        AppMethodBeat.o(63543);
    }

    public final void a(Parcel parcel, int i) {
        AppMethodBeat.i(63544);
        parcel.writeInt(this.fileType);
        parcel.writeString(this.cSY);
        parcel.writeString(this.uXe);
        parcel.writeString(this.downloadUrl);
        parcel.writeLong(this.uXf);
        parcel.writeString(this.version);
        parcel.writeString(this.cvZ);
        parcel.writeInt(this.uWQ);
        parcel.writeString(this.gSP);
        parcel.writeParcelable(this.uXg, i);
        AppMethodBeat.o(63544);
    }

    static {
        AppMethodBeat.i(63546);
        AppMethodBeat.o(63546);
    }
}
