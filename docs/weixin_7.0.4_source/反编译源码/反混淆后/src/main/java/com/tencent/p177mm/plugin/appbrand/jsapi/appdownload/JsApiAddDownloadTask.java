package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask */
public final class JsApiAddDownloadTask extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 474;
    public static final String NAME = "addDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask$AddDownloadTask */
    static class AddDownloadTask extends MainProcessTask {
        public static final Creator<AddDownloadTask> CREATOR = new C22021();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
        private String hxF;
        private String hxG;
        private String hxH;
        private long hxJ;
        private String hxK;
        private String hxL;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private boolean hyG;
        private boolean hzG;
        private int hzH;
        private String mAppId;
        private String mPackageName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask$AddDownloadTask$1 */
        static class C22021 implements Creator<AddDownloadTask> {
            C22021() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130651);
                AddDownloadTask addDownloadTask = new AddDownloadTask(parcel);
                AppMethodBeat.m2505o(130651);
                return addDownloadTask;
            }
        }

        public AddDownloadTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(130652);
            aBV();
            this.hxE = c45608m;
            this.gNC = c38492q;
            this.bOs = i;
            this.hxF = jSONObject.optString("taskName");
            this.hxG = jSONObject.optString("taskUrl");
            this.hxH = jSONObject.optString("fileMd5");
            this.hxJ = (long) jSONObject.optInt("taskSize", 0);
            this.hxK = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.hxL = jSONObject.optString("fileType");
            this.mAppId = jSONObject.optString("appId");
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.hyG = jSONObject.optBoolean("downloadInWifi", false);
            this.hzG = jSONObject.optBoolean("showNotification", false);
            this.hzH = jSONObject.optInt("downloaderType", 0);
            this.hxM = true;
            AppMethodBeat.m2505o(130652);
        }

        public AddDownloadTask(Parcel parcel) {
            AppMethodBeat.m2504i(130653);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130653);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130655);
            aBW();
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(130655);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.hxO));
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(130655);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(130656);
            this.hxF = parcel.readString();
            this.hxG = parcel.readString();
            this.hxH = parcel.readString();
            this.hxJ = parcel.readLong();
            this.hxK = parcel.readString();
            this.hxL = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            this.hyG = parcel.readByte() == (byte) 1;
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.hzG = z;
            this.hzH = parcel.readInt();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.hxM = z2;
            this.hxN = parcel.readString();
            this.hxO = parcel.readLong();
            AppMethodBeat.m2505o(130656);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            int i2 = 1;
            AppMethodBeat.m2504i(130657);
            parcel.writeString(this.hxF);
            parcel.writeString(this.hxG);
            parcel.writeString(this.hxH);
            parcel.writeLong(this.hxJ);
            parcel.writeString(this.hxK);
            parcel.writeString(this.hxL);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeByte(this.hyG ? (byte) 1 : (byte) 0);
            if (this.hzG) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            parcel.writeInt(this.hzH);
            if (!this.hxM) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.hxN);
            parcel.writeLong(this.hxO);
            AppMethodBeat.m2505o(130657);
        }

        static {
            AppMethodBeat.m2504i(130658);
            AppMethodBeat.m2505o(130658);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130654);
            C1720g.m3537RQ();
            if (!C1720g.m3536RP().isSDCardAvailable()) {
                this.hxN = "fail_sdcard_not_ready";
            } else if (this.hxJ > 0 && !C1445f.m3072eW(this.hxJ)) {
                this.hxN = "fail_sdcard_has_not_enough_space";
            } else if (C5046bo.isNullOrNil(this.hxG)) {
                this.hxN = "fail_invalid_url";
            } else {
                long b;
                C4990ab.m7417i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", this.hxG, this.hxH);
                C2901a c2901a = new C2901a();
                c2901a.mo7055It(this.hxG);
                c2901a.mo7066hA(this.hxJ);
                c2901a.mo7057Iv(this.hxF);
                c2901a.mo7058Iw(this.hxH);
                c2901a.setAppId(this.mAppId);
                c2901a.mo7062cY(this.mPackageName);
                c2901a.mo7063ga(true);
                c2901a.mo7069tN(C5046bo.getInt(this.hxL, 1));
                c2901a.setScene(6001);
                c2901a.mo7059Ix(this.hxK);
                c2901a.mo7064gb(this.hzG);
                c2901a.mo7065gc(this.hyG);
                c2901a.mo7063ga(false);
                c2901a.kNl.kNh = true;
                C2900e c2900e = c2901a.kNl;
                if (this.hzH == 1) {
                    b = C2896d.bij().mo7043b(c2900e);
                } else {
                    b = C2896d.bij().mo7042a(c2900e);
                }
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(b)));
                if (b <= 0) {
                    C4990ab.m7412e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(b)));
                    this.hxN = "";
                } else {
                    this.hxM = false;
                    this.hxO = b;
                    if (this.hyG) {
                        C45405b.eBF.mo73200a(this.mAppId, 6001, 11, b, "", this.hxK);
                    }
                }
            }
            aCb();
            AppMethodBeat.m2505o(130654);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130659);
        C38492q c38492q = (C38492q) c2241c;
        AppBrandMainProcessService.m54349a(new AddDownloadTask(this, c38492q, i, jSONObject));
        C42469b.m75232e(c38492q);
        AppMethodBeat.m2505o(130659);
    }
}
