package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.game.report.api.b;
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

public final class JsApiAddDownloadTask extends a<q> {
    public static final int CTRL_INDEX = 474;
    public static final String NAME = "addDownloadTask";

    static class AddDownloadTask extends MainProcessTask {
        public static final Creator<AddDownloadTask> CREATOR = new Creator<AddDownloadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130651);
                AddDownloadTask addDownloadTask = new AddDownloadTask(parcel);
                AppMethodBeat.o(130651);
                return addDownloadTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
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

        public AddDownloadTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(130652);
            aBV();
            this.hxE = mVar;
            this.gNC = qVar;
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
            AppMethodBeat.o(130652);
        }

        public AddDownloadTask(Parcel parcel) {
            AppMethodBeat.i(130653);
            g(parcel);
            AppMethodBeat.o(130653);
        }

        public final void asQ() {
            AppMethodBeat.i(130655);
            aBW();
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(130655);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.hxO));
            this.gNC.M(this.bOs, this.hxE.j("ok", hashMap));
            AppMethodBeat.o(130655);
        }

        public final void g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(130656);
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
            AppMethodBeat.o(130656);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            int i2 = 1;
            AppMethodBeat.i(130657);
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
            AppMethodBeat.o(130657);
        }

        static {
            AppMethodBeat.i(130658);
            AppMethodBeat.o(130658);
        }

        public final void asP() {
            AppMethodBeat.i(130654);
            g.RQ();
            if (!g.RP().isSDCardAvailable()) {
                this.hxN = "fail_sdcard_not_ready";
            } else if (this.hxJ > 0 && !f.eW(this.hxJ)) {
                this.hxN = "fail_sdcard_has_not_enough_space";
            } else if (bo.isNullOrNil(this.hxG)) {
                this.hxN = "fail_invalid_url";
            } else {
                long b;
                ab.i("MicroMsg.JsApiAddDownloadTask", "runInMainProcess taskUrl:%s md5:%s", this.hxG, this.hxH);
                e.a aVar = new e.a();
                aVar.It(this.hxG);
                aVar.hA(this.hxJ);
                aVar.Iv(this.hxF);
                aVar.Iw(this.hxH);
                aVar.setAppId(this.mAppId);
                aVar.cY(this.mPackageName);
                aVar.ga(true);
                aVar.tN(bo.getInt(this.hxL, 1));
                aVar.setScene(6001);
                aVar.Ix(this.hxK);
                aVar.gb(this.hzG);
                aVar.gc(this.hyG);
                aVar.ga(false);
                aVar.kNl.kNh = true;
                e eVar = aVar.kNl;
                if (this.hzH == 1) {
                    b = d.bij().b(eVar);
                } else {
                    b = d.bij().a(eVar);
                }
                ab.i("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(b)));
                if (b <= 0) {
                    ab.e("MicroMsg.JsApiAddDownloadTask", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(b)));
                    this.hxN = "";
                } else {
                    this.hxM = false;
                    this.hxO = b;
                    if (this.hyG) {
                        b.eBF.a(this.mAppId, 6001, 11, b, "", this.hxK);
                    }
                }
            }
            aCb();
            AppMethodBeat.o(130654);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130659);
        q qVar = (q) cVar;
        AppBrandMainProcessService.a(new AddDownloadTask(this, qVar, i, jSONObject));
        b.e(qVar);
        AppMethodBeat.o(130659);
    }
}
