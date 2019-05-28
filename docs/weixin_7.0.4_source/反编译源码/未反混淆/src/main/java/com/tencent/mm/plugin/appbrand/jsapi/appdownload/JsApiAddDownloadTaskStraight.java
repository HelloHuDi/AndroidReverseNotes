package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight extends a<q> {
    public static final int CTRL_INDEX = 440;
    public static final String NAME = "addDownloadTaskStraight";

    static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Creator<AddDownloadTaskStraightTask> CREATOR = new Creator<AddDownloadTaskStraightTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTaskStraightTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130660);
                AddDownloadTaskStraightTask addDownloadTaskStraightTask = new AddDownloadTaskStraightTask(parcel);
                AppMethodBeat.o(130660);
                return addDownloadTaskStraightTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
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

        public AddDownloadTaskStraightTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(130661);
            this.hxE = mVar;
            this.gNC = qVar;
            this.bOs = i;
            this.hxF = jSONObject.optString("taskName");
            this.hxG = jSONObject.optString("taskUrl");
            this.hxH = jSONObject.optString("fileMd5");
            this.hxI = jSONObject.optString("alternativeUrl");
            this.hxJ = (long) jSONObject.optInt("taskSize", 0);
            this.hxK = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.hxL = jSONObject.optString("fileType");
            this.mAppId = qVar.getAppId();
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.hxM = true;
            AppMethodBeat.o(130661);
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            AppMethodBeat.i(130662);
            g(parcel);
            AppMethodBeat.o(130662);
        }

        public final void asQ() {
            AppMethodBeat.i(130664);
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(130664);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.hxO));
            this.gNC.M(this.bOs, this.hxE.j("ok", hashMap));
            AppMethodBeat.o(130664);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130665);
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
            AppMethodBeat.o(130665);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130666);
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
            AppMethodBeat.o(130666);
        }

        static {
            AppMethodBeat.i(130667);
            AppMethodBeat.o(130667);
        }

        public final void asP() {
            AppMethodBeat.i(130663);
            g.RQ();
            if (!g.RP().isSDCardAvailable()) {
                this.hxN = "fail_sdcard_not_ready";
            } else if (this.hxJ > 0 && !f.eW(this.hxJ)) {
                this.hxN = "fail_sdcard_has_not_enough_space";
            } else if (bo.isNullOrNil(this.hxG)) {
                this.hxN = "fail_invalid_url";
            } else {
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", this.hxG, this.hxH);
                e.a aVar = new e.a();
                aVar.It(this.hxG);
                aVar.Iu(this.hxI);
                aVar.hA(this.hxJ);
                aVar.Iv(this.hxF);
                aVar.Iw(this.hxH);
                aVar.setAppId(this.mAppId);
                aVar.cY(this.mPackageName);
                aVar.ga(true);
                aVar.tN(bo.getInt(this.hxL, 1));
                aVar.setScene(6001);
                aVar.Ix(this.hxK);
                long a = d.bij().a(aVar.kNl);
                ab.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a)));
                if (a <= 0) {
                    ab.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a)));
                    this.hxN = "";
                } else {
                    this.hxM = false;
                    this.hxO = a;
                }
            }
            aCb();
            AppMethodBeat.o(130663);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130668);
        q qVar = (q) cVar;
        AppBrandMainProcessService.a(new AddDownloadTaskStraightTask(this, qVar, i, jSONObject));
        b.e(qVar);
        AppMethodBeat.o(130668);
    }
}
