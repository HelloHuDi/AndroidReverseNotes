package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask */
public final class JsApiPauseDownloadTask extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 443;
    public static final String NAME = "pauseDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask$PauseDownloadTask */
    static class PauseDownloadTask extends MainProcessTask {
        public static final Creator<PauseDownloadTask> CREATOR = new C192891();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask$PauseDownloadTask$1 */
        static class C192891 implements Creator<PauseDownloadTask> {
            C192891() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new PauseDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130690);
                PauseDownloadTask pauseDownloadTask = new PauseDownloadTask(parcel);
                AppMethodBeat.m2505o(130690);
                return pauseDownloadTask;
            }
        }

        public PauseDownloadTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(130691);
            this.hxE = c45608m;
            this.gNC = c38492q;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.hxM = true;
            AppMethodBeat.m2505o(130691);
        }

        public PauseDownloadTask(Parcel parcel) {
            AppMethodBeat.m2504i(130692);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130692);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130694);
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(130694);
                return;
            }
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", null));
            AppMethodBeat.m2505o(130694);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130695);
            this.hxO = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            AppMethodBeat.m2505o(130695);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130696);
            parcel.writeLong(this.hxO);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            AppMethodBeat.m2505o(130696);
        }

        static {
            AppMethodBeat.m2504i(130697);
            AppMethodBeat.m2505o(130697);
        }

        public final void asP() {
            boolean z = true;
            AppMethodBeat.m2504i(130693);
            C4990ab.m7417i("MicroMsg.JsApiPauseDownloadTask", "doPauseDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            if (this.hxO <= 0) {
                this.hxN = "downloadId invalid";
            } else {
                C42911a hv = C2895c.m5147hv(this.hxO);
                if (hv == null) {
                    this.hxN = "downloadId invalid";
                } else {
                    if (hv.field_downloadInWifi) {
                        hv.field_downloadInWifi = false;
                        C2895c.m5146e(hv);
                    }
                    if (C2896d.bij().mo7049hn(this.hxO)) {
                        z = false;
                    }
                    this.hxM = z;
                }
            }
            aCb();
            AppMethodBeat.m2505o(130693);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130698);
        AppBrandMainProcessService.m54349a(new PauseDownloadTask(this, (C19722s) c2241c, i, jSONObject));
        AppMethodBeat.m2505o(130698);
    }
}
