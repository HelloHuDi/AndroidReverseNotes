package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.pluginsdk.permission.C14900a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask */
public final class JsApiInstallDownloadTask extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 442;
    public static final String NAME = "installDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask$InstallDownloadTask */
    static class InstallDownloadTask extends MainProcessTask {
        public static final Creator<InstallDownloadTask> CREATOR = new C332343();
        private int bOs;
        private C45608m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private C2241c hzz;
        private String mAppId;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask$InstallDownloadTask$1 */
        class C332321 implements C14900a {
            C332321() {
            }

            /* renamed from: dT */
            public final void mo9734dT(boolean z) {
                AppMethodBeat.m2504i(130679);
                InstallDownloadTask.this.hxM = !z;
                AppMethodBeat.m2505o(130679);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask$InstallDownloadTask$2 */
        class C332332 implements C14900a {
            C332332() {
            }

            /* renamed from: dT */
            public final void mo9734dT(boolean z) {
                AppMethodBeat.m2504i(130680);
                InstallDownloadTask.this.hxM = !z;
                AppMethodBeat.m2505o(130680);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask$InstallDownloadTask$3 */
        static class C332343 implements Creator<InstallDownloadTask> {
            C332343() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new InstallDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130681);
                InstallDownloadTask installDownloadTask = new InstallDownloadTask(parcel);
                AppMethodBeat.m2505o(130681);
                return installDownloadTask;
            }
        }

        public InstallDownloadTask(C45608m c45608m, C2241c c2241c, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(130682);
            this.hxE = c45608m;
            this.hzz = c2241c;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.mAppId = jSONObject.optString("appId");
            this.hxM = true;
            AppMethodBeat.m2505o(130682);
        }

        public InstallDownloadTask(Parcel parcel) {
            AppMethodBeat.m2504i(130683);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130683);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130685);
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.hzz.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(130685);
                return;
            }
            this.hzz.mo6107M(this.bOs, this.hxE.mo73394j("ok", null));
            AppMethodBeat.m2505o(130685);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130686);
            this.hxO = parcel.readLong();
            this.mAppId = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            AppMethodBeat.m2505o(130686);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130687);
            parcel.writeLong(this.hxO);
            parcel.writeString(this.mAppId);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            AppMethodBeat.m2505o(130687);
        }

        static {
            AppMethodBeat.m2504i(130688);
            AppMethodBeat.m2505o(130688);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130684);
            C4990ab.m7417i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            C42911a hv;
            if (C5046bo.isNullOrNil(this.mAppId)) {
                hv = C2895c.m5147hv(this.hxO);
                if (hv != null && hv.field_status == 3 && C1173e.m2561ct(hv.field_filePath)) {
                    C33913a.m55499a(hv.field_downloadId, false, new C332332());
                }
            } else {
                hv = C2895c.m5140In(this.mAppId);
                if (hv != null && hv.field_status == 3 && C1173e.m2561ct(hv.field_filePath)) {
                    C33913a.m55499a(hv.field_downloadId, false, new C332321());
                }
            }
            aCb();
            AppMethodBeat.m2505o(130684);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130689);
        AppBrandMainProcessService.m54349a(new InstallDownloadTask(this, c2241c, i, jSONObject));
        AppMethodBeat.m2505o(130689);
    }
}
