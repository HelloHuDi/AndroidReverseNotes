package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask extends a<s> {
    public static final int CTRL_INDEX = 443;
    public static final String NAME = "pauseDownloadTask";

    static class PauseDownloadTask extends MainProcessTask {
        public static final Creator<PauseDownloadTask> CREATOR = new Creator<PauseDownloadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PauseDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130690);
                PauseDownloadTask pauseDownloadTask = new PauseDownloadTask(parcel);
                AppMethodBeat.o(130690);
                return pauseDownloadTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;

        public PauseDownloadTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(130691);
            this.hxE = mVar;
            this.gNC = qVar;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.hxM = true;
            AppMethodBeat.o(130691);
        }

        public PauseDownloadTask(Parcel parcel) {
            AppMethodBeat.i(130692);
            g(parcel);
            AppMethodBeat.o(130692);
        }

        public final void asQ() {
            AppMethodBeat.i(130694);
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(130694);
                return;
            }
            this.gNC.M(this.bOs, this.hxE.j("ok", null));
            AppMethodBeat.o(130694);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130695);
            this.hxO = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            AppMethodBeat.o(130695);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130696);
            parcel.writeLong(this.hxO);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            AppMethodBeat.o(130696);
        }

        static {
            AppMethodBeat.i(130697);
            AppMethodBeat.o(130697);
        }

        public final void asP() {
            boolean z = true;
            AppMethodBeat.i(130693);
            ab.i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            if (this.hxO <= 0) {
                this.hxN = "downloadId invalid";
            } else {
                com.tencent.mm.plugin.downloader.f.a hv = c.hv(this.hxO);
                if (hv == null) {
                    this.hxN = "downloadId invalid";
                } else {
                    if (hv.field_downloadInWifi) {
                        hv.field_downloadInWifi = false;
                        c.e(hv);
                    }
                    if (d.bij().hn(this.hxO)) {
                        z = false;
                    }
                    this.hxM = z;
                }
            }
            aCb();
            AppMethodBeat.o(130693);
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130698);
        AppBrandMainProcessService.a(new PauseDownloadTask(this, (s) cVar, i, jSONObject));
        AppMethodBeat.o(130698);
    }
}
