package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class JsApiResumeDownloadTask extends a<q> {
    public static final int CTRL_INDEX = 444;
    public static final String NAME = "resumeDownloadTask";

    static class ResumeDownloadTask extends MainProcessTask {
        public static final Creator<ResumeDownloadTask> CREATOR = new Creator<ResumeDownloadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResumeDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(73172);
                ResumeDownloadTask resumeDownloadTask = new ResumeDownloadTask(parcel);
                AppMethodBeat.o(73172);
                return resumeDownloadTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private boolean hyG;

        public ResumeDownloadTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(73173);
            this.hxE = mVar;
            this.gNC = qVar;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.hyG = jSONObject.optBoolean("downloadInWifi", false);
            this.hxM = true;
            AppMethodBeat.o(73173);
        }

        public ResumeDownloadTask(Parcel parcel) {
            AppMethodBeat.i(73174);
            g(parcel);
            AppMethodBeat.o(73174);
        }

        public final void asQ() {
            AppMethodBeat.i(73176);
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(73176);
                return;
            }
            this.gNC.M(this.bOs, this.hxE.j("ok", null));
            AppMethodBeat.o(73176);
        }

        public final void g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(73177);
            this.hxO = parcel.readLong();
            if (parcel.readByte() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            this.hyG = z;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.hxM = z2;
            this.hxN = parcel.readString();
            AppMethodBeat.o(73177);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            int i2 = 1;
            AppMethodBeat.i(73178);
            parcel.writeLong(this.hxO);
            if (this.hyG) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.hxM) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.hxN);
            AppMethodBeat.o(73178);
        }

        static {
            AppMethodBeat.i(73179);
            AppMethodBeat.o(73179);
        }

        public final void asP() {
            boolean z = true;
            AppMethodBeat.i(73175);
            ab.i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            if (this.hxO <= 0) {
                this.hxN = "downloadId invalid";
            } else {
                a hv = c.hv(this.hxO);
                if (!(hv == null || hv.field_downloadInWifi == this.hyG)) {
                    hv.field_downloadInWifi = this.hyG;
                    c.e(hv);
                }
                if (d.bij().ho(this.hxO)) {
                    z = false;
                }
                this.hxM = z;
            }
            aCb();
            AppMethodBeat.o(73175);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(73180);
        AppBrandMainProcessService.a(new ResumeDownloadTask(this, (q) cVar, i, jSONObject));
        AppMethodBeat.o(73180);
    }
}
