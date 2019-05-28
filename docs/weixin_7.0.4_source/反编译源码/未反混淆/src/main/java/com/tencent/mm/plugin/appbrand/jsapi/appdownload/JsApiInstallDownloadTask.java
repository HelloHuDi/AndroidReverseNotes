package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask extends a<c> {
    public static final int CTRL_INDEX = 442;
    public static final String NAME = "installDownloadTask";

    static class InstallDownloadTask extends MainProcessTask {
        public static final Creator<InstallDownloadTask> CREATOR = new Creator<InstallDownloadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new InstallDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130681);
                InstallDownloadTask installDownloadTask = new InstallDownloadTask(parcel);
                AppMethodBeat.o(130681);
                return installDownloadTask;
            }
        };
        private int bOs;
        private m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private c hzz;
        private String mAppId;

        public InstallDownloadTask(m mVar, c cVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(130682);
            this.hxE = mVar;
            this.hzz = cVar;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.mAppId = jSONObject.optString("appId");
            this.hxM = true;
            AppMethodBeat.o(130682);
        }

        public InstallDownloadTask(Parcel parcel) {
            AppMethodBeat.i(130683);
            g(parcel);
            AppMethodBeat.o(130683);
        }

        public final void asQ() {
            AppMethodBeat.i(130685);
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.hzz.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(130685);
                return;
            }
            this.hzz.M(this.bOs, this.hxE.j("ok", null));
            AppMethodBeat.o(130685);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130686);
            this.hxO = parcel.readLong();
            this.mAppId = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            AppMethodBeat.o(130686);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130687);
            parcel.writeLong(this.hxO);
            parcel.writeString(this.mAppId);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            AppMethodBeat.o(130687);
        }

        static {
            AppMethodBeat.i(130688);
            AppMethodBeat.o(130688);
        }

        public final void asP() {
            AppMethodBeat.i(130684);
            ab.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            com.tencent.mm.plugin.downloader.f.a hv;
            if (bo.isNullOrNil(this.mAppId)) {
                hv = com.tencent.mm.plugin.downloader.model.c.hv(this.hxO);
                if (hv != null && hv.field_status == 3 && e.ct(hv.field_filePath)) {
                    com.tencent.mm.plugin.downloader.h.a.a(hv.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                        public final void dT(boolean z) {
                            AppMethodBeat.i(130680);
                            InstallDownloadTask.this.hxM = !z;
                            AppMethodBeat.o(130680);
                        }
                    });
                }
            } else {
                hv = com.tencent.mm.plugin.downloader.model.c.In(this.mAppId);
                if (hv != null && hv.field_status == 3 && e.ct(hv.field_filePath)) {
                    com.tencent.mm.plugin.downloader.h.a.a(hv.field_downloadId, false, new com.tencent.mm.pluginsdk.permission.a() {
                        public final void dT(boolean z) {
                            AppMethodBeat.i(130679);
                            InstallDownloadTask.this.hxM = !z;
                            AppMethodBeat.o(130679);
                        }
                    });
                }
            }
            aCb();
            AppMethodBeat.o(130684);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130689);
        AppBrandMainProcessService.a(new InstallDownloadTask(this, cVar, i, jSONObject));
        AppMethodBeat.o(130689);
    }
}
