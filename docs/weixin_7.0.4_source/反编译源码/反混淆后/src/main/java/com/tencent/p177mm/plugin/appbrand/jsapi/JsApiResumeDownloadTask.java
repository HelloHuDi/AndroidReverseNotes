package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask */
public final class JsApiResumeDownloadTask extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 444;
    public static final String NAME = "resumeDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask$ResumeDownloadTask */
    static class ResumeDownloadTask extends MainProcessTask {
        public static final Creator<ResumeDownloadTask> CREATOR = new C332251();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private boolean hyG;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask$ResumeDownloadTask$1 */
        static class C332251 implements Creator<ResumeDownloadTask> {
            C332251() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResumeDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(73172);
                ResumeDownloadTask resumeDownloadTask = new ResumeDownloadTask(parcel);
                AppMethodBeat.m2505o(73172);
                return resumeDownloadTask;
            }
        }

        public ResumeDownloadTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(73173);
            this.hxE = c45608m;
            this.gNC = c38492q;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.hyG = jSONObject.optBoolean("downloadInWifi", false);
            this.hxM = true;
            AppMethodBeat.m2505o(73173);
        }

        public ResumeDownloadTask(Parcel parcel) {
            AppMethodBeat.m2504i(73174);
            mo6032g(parcel);
            AppMethodBeat.m2505o(73174);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(73176);
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(73176);
                return;
            }
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", null));
            AppMethodBeat.m2505o(73176);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(73177);
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
            AppMethodBeat.m2505o(73177);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            int i2 = 1;
            AppMethodBeat.m2504i(73178);
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
            AppMethodBeat.m2505o(73178);
        }

        static {
            AppMethodBeat.m2504i(73179);
            AppMethodBeat.m2505o(73179);
        }

        public final void asP() {
            boolean z = true;
            AppMethodBeat.m2504i(73175);
            C4990ab.m7417i("MicroMsg.JsApiResumeDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            if (this.hxO <= 0) {
                this.hxN = "downloadId invalid";
            } else {
                C42911a hv = C2895c.m5147hv(this.hxO);
                if (!(hv == null || hv.field_downloadInWifi == this.hyG)) {
                    hv.field_downloadInWifi = this.hyG;
                    C2895c.m5146e(hv);
                }
                if (C2896d.bij().mo7050ho(this.hxO)) {
                    z = false;
                }
                this.hxM = z;
            }
            aCb();
            AppMethodBeat.m2505o(73175);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(73180);
        AppBrandMainProcessService.m54349a(new ResumeDownloadTask(this, (C38492q) c2241c, i, jSONObject));
        AppMethodBeat.m2505o(73180);
    }
}
