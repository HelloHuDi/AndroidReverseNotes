package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiCancelDownloadTask extends a<q> {
    public static final int CTRL_INDEX = 475;
    public static final String NAME = "cancelDownloadTask";

    static class CancelDownloadTask extends MainProcessTask {
        public static Creator<CancelDownloadTask> CREATOR = new Creator<CancelDownloadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CancelDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130669);
                CancelDownloadTask cancelDownloadTask = new CancelDownloadTask(parcel, (byte) 0);
                AppMethodBeat.o(130669);
                return cancelDownloadTask;
            }
        };
        private q hwf;
        private int hwi;
        private JSONArray hzI;
        private a hzJ;

        /* synthetic */ CancelDownloadTask(Parcel parcel, byte b) {
            this(parcel);
        }

        public final void asP() {
            AppMethodBeat.i(130670);
            if (this.hzI != null && this.hzI.length() > 0) {
                for (int i = 0; i < this.hzI.length(); i++) {
                    long optLong = this.hzI.optLong(i);
                    com.tencent.mm.plugin.downloader.f.a hv = c.hv(optLong);
                    if (hv == null || hv.field_status != 3) {
                        d.bij().hl(optLong);
                    } else {
                        ab.i("MicroMsg.JsApiCancelDownloadTask", "canceldownloadtask, path: %s", hv.field_filePath);
                        e.deleteFile(hv.field_filePath);
                        c.Io(hv.field_downloadUrl);
                    }
                }
            }
            aCb();
            AppMethodBeat.o(130670);
        }

        public final void asQ() {
            AppMethodBeat.i(130671);
            aBW();
            this.hwf.M(this.hwi, this.hzJ.j("ok", null));
            AppMethodBeat.o(130671);
        }

        public CancelDownloadTask(JSONArray jSONArray, a aVar, q qVar, int i) {
            AppMethodBeat.i(130672);
            aBV();
            this.hzI = jSONArray;
            this.hzJ = aVar;
            this.hwf = qVar;
            this.hwi = i;
            AppMethodBeat.o(130672);
        }

        private CancelDownloadTask(Parcel parcel) {
            AppMethodBeat.i(130673);
            g(parcel);
            AppMethodBeat.o(130673);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130674);
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.hzI = new JSONArray(readString);
                    AppMethodBeat.o(130674);
                    return;
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiCancelDownloadTask", "parseFromParcel: " + e.getMessage());
                }
            }
            AppMethodBeat.o(130674);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130675);
            parcel.writeString(this.hzI != null ? this.hzI.toString() : null);
            AppMethodBeat.o(130675);
        }

        static {
            AppMethodBeat.i(130676);
            AppMethodBeat.o(130676);
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130677);
        q qVar = (q) cVar;
        ab.d("MicroMsg.JsApiCancelDownloadTask", "invoke");
        JSONArray optJSONArray = jSONObject.optJSONArray("downloadIdArray");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            ab.e("MicroMsg.JsApiCancelDownloadTask", "doCancelDownloadTask fail, invalid downloadIdArray");
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(130677);
            return;
        }
        AppBrandMainProcessService.a(new CancelDownloadTask(optJSONArray, this, qVar, i));
        AppMethodBeat.o(130677);
    }
}
