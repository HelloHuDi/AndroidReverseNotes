package com.tencent.p177mm.plugin.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.p177mm.plugin.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask */
public class WepkgDownloadProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgDownloadProcessTask> CREATOR = new C148042();
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

    /* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask$1 */
    class C148031 implements IWepkgUpdateCallback {
        C148031() {
        }

        /* renamed from: a */
        public final void mo9816a(String str, String str2, RetCode retCode) {
            AppMethodBeat.m2504i(63538);
            C4990ab.m7417i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", retCode);
            WepkgDownloadProcessTask.this.cSY = str;
            WepkgDownloadProcessTask.this.gSP = str2;
            WepkgDownloadProcessTask.this.uXg = retCode;
            WepkgDownloadProcessTask.this.aBW();
            WepkgDownloadProcessTask.m23029a(WepkgDownloadProcessTask.this);
            AppMethodBeat.m2505o(63538);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.model.WepkgDownloadProcessTask$2 */
    static class C148042 implements Creator<WepkgDownloadProcessTask> {
        C148042() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgDownloadProcessTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63539);
            WepkgDownloadProcessTask wepkgDownloadProcessTask = new WepkgDownloadProcessTask(parcel, (byte) 0);
            AppMethodBeat.m2505o(63539);
            return wepkgDownloadProcessTask;
        }
    }

    /* synthetic */ WepkgDownloadProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    static /* synthetic */ void m23029a(WepkgDownloadProcessTask wepkgDownloadProcessTask) {
        AppMethodBeat.m2504i(63545);
        wepkgDownloadProcessTask.mo63809wM();
        AppMethodBeat.m2505o(63545);
    }

    private WepkgDownloadProcessTask(Parcel parcel) {
        AppMethodBeat.m2504i(63540);
        mo48259g(parcel);
        AppMethodBeat.m2505o(63540);
    }

    public final void asP() {
        AppMethodBeat.m2504i(63541);
        aBV();
        C148031 c148031 = new C148031();
        if (this.fileType == 1) {
            WePkgDownloader.dgx().mo56537a(this.cSY, c148031);
            AppMethodBeat.m2505o(63541);
            return;
        }
        WePkgDownloader.dgx().mo56536a(this.fileType, C5046bo.nullAsNil(this.cSY), "", C5046bo.nullAsNil(this.uXe), C5046bo.nullAsNil(this.downloadUrl), this.uXf, C5046bo.nullAsNil(this.version), "", C5046bo.nullAsNil(this.cvZ), this.uWQ, c148031);
        AppMethodBeat.m2505o(63541);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(63542);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(63542);
    }

    /* renamed from: m */
    public final void mo27112m(Parcel parcel) {
        AppMethodBeat.m2504i(63543);
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
        AppMethodBeat.m2505o(63543);
    }

    /* renamed from: a */
    public final void mo27109a(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63544);
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
        AppMethodBeat.m2505o(63544);
    }

    static {
        AppMethodBeat.m2504i(63546);
        AppMethodBeat.m2505o(63546);
    }
}
