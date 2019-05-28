package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask */
public final class JsApiCancelDownloadTask extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 475;
    public static final String NAME = "cancelDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask$CancelDownloadTask */
    static class CancelDownloadTask extends MainProcessTask {
        public static Creator<CancelDownloadTask> CREATOR = new C22031();
        private C38492q hwf;
        private int hwi;
        private JSONArray hzI;
        private C10296a hzJ;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask$CancelDownloadTask$1 */
        static class C22031 implements Creator<CancelDownloadTask> {
            C22031() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CancelDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130669);
                CancelDownloadTask cancelDownloadTask = new CancelDownloadTask(parcel, (byte) 0);
                AppMethodBeat.m2505o(130669);
                return cancelDownloadTask;
            }
        }

        /* synthetic */ CancelDownloadTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130670);
            if (this.hzI != null && this.hzI.length() > 0) {
                for (int i = 0; i < this.hzI.length(); i++) {
                    long optLong = this.hzI.optLong(i);
                    C42911a hv = C2895c.m5147hv(optLong);
                    if (hv == null || hv.field_status != 3) {
                        C2896d.bij().mo7047hl(optLong);
                    } else {
                        C4990ab.m7417i("MicroMsg.JsApiCancelDownloadTask", "canceldownloadtask, path: %s", hv.field_filePath);
                        C5730e.deleteFile(hv.field_filePath);
                        C2895c.m5141Io(hv.field_downloadUrl);
                    }
                }
            }
            aCb();
            AppMethodBeat.m2505o(130670);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130671);
            aBW();
            this.hwf.mo6107M(this.hwi, this.hzJ.mo73394j("ok", null));
            AppMethodBeat.m2505o(130671);
        }

        public CancelDownloadTask(JSONArray jSONArray, C10296a c10296a, C38492q c38492q, int i) {
            AppMethodBeat.m2504i(130672);
            aBV();
            this.hzI = jSONArray;
            this.hzJ = c10296a;
            this.hwf = c38492q;
            this.hwi = i;
            AppMethodBeat.m2505o(130672);
        }

        private CancelDownloadTask(Parcel parcel) {
            AppMethodBeat.m2504i(130673);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130673);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130674);
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.hzI = new JSONArray(readString);
                    AppMethodBeat.m2505o(130674);
                    return;
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.JsApiCancelDownloadTask", "parseFromParcel: " + e.getMessage());
                }
            }
            AppMethodBeat.m2505o(130674);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130675);
            parcel.writeString(this.hzI != null ? this.hzI.toString() : null);
            AppMethodBeat.m2505o(130675);
        }

        static {
            AppMethodBeat.m2504i(130676);
            AppMethodBeat.m2505o(130676);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130677);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7410d("MicroMsg.JsApiCancelDownloadTask", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("downloadIdArray");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiCancelDownloadTask", "doCancelDownloadTask fail, invalid downloadIdArray");
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130677);
            return;
        }
        AppBrandMainProcessService.m54349a(new CancelDownloadTask(optJSONArray, this, c38492q, i));
        AppMethodBeat.m2505o(130677);
    }
}
