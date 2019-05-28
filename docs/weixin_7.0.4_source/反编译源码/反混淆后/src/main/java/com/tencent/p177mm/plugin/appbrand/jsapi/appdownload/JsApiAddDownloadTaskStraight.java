package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight */
public final class JsApiAddDownloadTaskStraight extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 440;
    public static final String NAME = "addDownloadTaskStraight";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask */
    static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Creator<AddDownloadTaskStraightTask> CREATOR = new C332311();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
        private String hxF;
        private String hxG;
        private String hxH;
        private String hxI;
        private long hxJ;
        private String hxK;
        private String hxL;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private String mAppId;
        private String mPackageName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight$AddDownloadTaskStraightTask$1 */
        static class C332311 implements Creator<AddDownloadTaskStraightTask> {
            C332311() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTaskStraightTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130660);
                AddDownloadTaskStraightTask addDownloadTaskStraightTask = new AddDownloadTaskStraightTask(parcel);
                AppMethodBeat.m2505o(130660);
                return addDownloadTaskStraightTask;
            }
        }

        public AddDownloadTaskStraightTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(130661);
            this.hxE = c45608m;
            this.gNC = c38492q;
            this.bOs = i;
            this.hxF = jSONObject.optString("taskName");
            this.hxG = jSONObject.optString("taskUrl");
            this.hxH = jSONObject.optString("fileMd5");
            this.hxI = jSONObject.optString("alternativeUrl");
            this.hxJ = (long) jSONObject.optInt("taskSize", 0);
            this.hxK = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.hxL = jSONObject.optString("fileType");
            this.mAppId = c38492q.getAppId();
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.hxM = true;
            AppMethodBeat.m2505o(130661);
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            AppMethodBeat.m2504i(130662);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130662);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130664);
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(130664);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.hxO));
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(130664);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130665);
            this.hxF = parcel.readString();
            this.hxG = parcel.readString();
            this.hxH = parcel.readString();
            this.hxI = parcel.readString();
            this.hxJ = parcel.readLong();
            this.hxK = parcel.readString();
            this.hxL = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            this.hxO = parcel.readLong();
            AppMethodBeat.m2505o(130665);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130666);
            parcel.writeString(this.hxF);
            parcel.writeString(this.hxG);
            parcel.writeString(this.hxH);
            parcel.writeString(this.hxI);
            parcel.writeLong(this.hxJ);
            parcel.writeString(this.hxK);
            parcel.writeString(this.hxL);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            parcel.writeLong(this.hxO);
            AppMethodBeat.m2505o(130666);
        }

        static {
            AppMethodBeat.m2504i(130667);
            AppMethodBeat.m2505o(130667);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130663);
            C1720g.m3537RQ();
            if (!C1720g.m3536RP().isSDCardAvailable()) {
                this.hxN = "fail_sdcard_not_ready";
            } else if (this.hxJ > 0 && !C1445f.m3072eW(this.hxJ)) {
                this.hxN = "fail_sdcard_has_not_enough_space";
            } else if (C5046bo.isNullOrNil(this.hxG)) {
                this.hxN = "fail_invalid_url";
            } else {
                C4990ab.m7417i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", this.hxG, this.hxH);
                C2901a c2901a = new C2901a();
                c2901a.mo7055It(this.hxG);
                c2901a.mo7056Iu(this.hxI);
                c2901a.mo7066hA(this.hxJ);
                c2901a.mo7057Iv(this.hxF);
                c2901a.mo7058Iw(this.hxH);
                c2901a.setAppId(this.mAppId);
                c2901a.mo7062cY(this.mPackageName);
                c2901a.mo7063ga(true);
                c2901a.mo7069tN(C5046bo.getInt(this.hxL, 1));
                c2901a.setScene(6001);
                c2901a.mo7059Ix(this.hxK);
                long a = C2896d.bij().mo7042a(c2901a.kNl);
                C4990ab.m7416i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a)));
                if (a <= 0) {
                    C4990ab.m7412e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a)));
                    this.hxN = "";
                } else {
                    this.hxM = false;
                    this.hxO = a;
                }
            }
            aCb();
            AppMethodBeat.m2505o(130663);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130668);
        C38492q c38492q = (C38492q) c2241c;
        AppBrandMainProcessService.m54349a(new AddDownloadTaskStraightTask(this, c38492q, i, jSONObject));
        C42469b.m75232e(c38492q);
        AppMethodBeat.m2505o(130668);
    }
}
