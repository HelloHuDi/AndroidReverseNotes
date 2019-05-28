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
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiQueryDownloadTask extends a<q> {
    public static final int CTRL_INDEX = 441;
    public static final String NAME = "queryDownloadTask";

    static class QueryDownloadTask extends MainProcessTask {
        public static final Creator<QueryDownloadTask> CREATOR = new Creator<QueryDownloadTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueryDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130699);
                QueryDownloadTask queryDownloadTask = new QueryDownloadTask(parcel);
                AppMethodBeat.o(130699);
                return queryDownloadTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private JSONArray hzO;
        private JSONArray hzP;
        private JSONArray hzQ;
        private String hzR;
        private long hzS;

        public QueryDownloadTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(130700);
            aBV();
            this.hxE = mVar;
            this.gNC = qVar;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.hzO = jSONObject.optJSONArray("downloadIdArray");
            this.hzP = jSONObject.optJSONArray("appIdArray");
            this.hxM = true;
            AppMethodBeat.o(130700);
        }

        public QueryDownloadTask(Parcel parcel) {
            AppMethodBeat.i(130701);
            g(parcel);
            AppMethodBeat.o(130701);
        }

        private JSONObject a(long j, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.i(130703);
            JSONObject a = a(fileDownloadTaskInfo);
            if (fileDownloadTaskInfo != null) {
                try {
                    a.put("downloadId", j);
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
                }
            }
            AppMethodBeat.o(130703);
            return a;
        }

        private JSONObject a(String str, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.i(130704);
            JSONObject a = a(fileDownloadTaskInfo);
            try {
                a.put("appId", str);
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
            AppMethodBeat.o(130704);
            return a;
        }

        private JSONObject a(FileDownloadTaskInfo fileDownloadTaskInfo) {
            String str;
            long j = 0;
            AppMethodBeat.i(130705);
            JSONObject jSONObject = new JSONObject();
            switch (fileDownloadTaskInfo.status) {
                case -1:
                    this.hxN = "fail_apilevel_too_low";
                    AppMethodBeat.o(130705);
                    return jSONObject;
                case 1:
                    str = "downloading";
                    break;
                case 2:
                    str = "download_pause";
                    break;
                case 3:
                    if (!e.ct(fileDownloadTaskInfo.path)) {
                        str = "default";
                        break;
                    }
                    str = "download_succ";
                    break;
                case 4:
                    str = "download_fail";
                    break;
                default:
                    str = "default";
                    break;
            }
            ab.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", str);
            if (!(!fileDownloadTaskInfo.kNt || at.isWifi(ah.getContext()) || fileDownloadTaskInfo.status == 3 || fileDownloadTaskInfo.status == 1)) {
                str = "download_wait_wifi";
            }
            if ((str == "downloading" || str == "download_pause") && fileDownloadTaskInfo.jrb != 0) {
                j = (long) ((((float) fileDownloadTaskInfo.kNr) / ((float) fileDownloadTaskInfo.jrb)) * 100.0f);
            }
            try {
                jSONObject.put("appId", fileDownloadTaskInfo.appId);
                jSONObject.put("downloadId", fileDownloadTaskInfo.id);
                jSONObject.put("state", str);
                jSONObject.put("progress", j);
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
            AppMethodBeat.o(130705);
            return jSONObject;
        }

        public final void asQ() {
            AppMethodBeat.i(130706);
            aBW();
            String str = "MicroMsg.JsApiQueryDownloadTask";
            String str2 = "callback, service is null: %b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.gNC == null);
            ab.d(str, str2, objArr);
            if (this.hxM) {
                this.gNC.M(this.bOs, this.hxE.j(bo.isNullOrNil(this.hxN) ? "fail" : String.format("fail:%s", new Object[]{this.hxN}), null));
                AppMethodBeat.o(130706);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.hzQ != null) {
                hashMap.put("result", this.hzQ);
            } else {
                hashMap.put("downloadId", Long.valueOf(this.hxO));
                hashMap.put("state", this.hzR);
                hashMap.put("progress", Long.valueOf(this.hzS));
            }
            this.gNC.M(this.bOs, this.hxE.j("ok", hashMap));
            AppMethodBeat.o(130706);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(130707);
            this.hxO = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            this.hzR = parcel.readString();
            this.hzS = parcel.readLong();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (readString != null) {
                try {
                    this.hzO = new JSONArray(readString);
                } catch (JSONException e) {
                    ab.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", e, "", new Object[0]);
                    AppMethodBeat.o(130707);
                    return;
                }
            }
            if (readString2 != null) {
                this.hzP = new JSONArray(readString2);
            }
            if (readString3 != null) {
                this.hzQ = new JSONArray(readString3);
            }
            AppMethodBeat.o(130707);
        }

        public void writeToParcel(Parcel parcel, int i) {
            String jSONArray;
            String str = null;
            AppMethodBeat.i(130708);
            parcel.writeLong(this.hxO);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            parcel.writeString(this.hzR);
            parcel.writeLong(this.hzS);
            if (this.hzO != null) {
                jSONArray = this.hzO.toString();
            } else {
                jSONArray = null;
            }
            parcel.writeString(jSONArray);
            if (this.hzP != null) {
                jSONArray = this.hzP.toString();
            } else {
                jSONArray = null;
            }
            parcel.writeString(jSONArray);
            if (this.hzQ != null) {
                str = this.hzQ.toString();
            }
            parcel.writeString(str);
            AppMethodBeat.o(130708);
        }

        static {
            AppMethodBeat.i(130709);
            AppMethodBeat.o(130709);
        }

        public final void asP() {
            AppMethodBeat.i(130702);
            ab.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            int i;
            if (this.hzO != null && this.hzO.length() > 0) {
                this.hzQ = new JSONArray();
                for (i = 0; i < this.hzO.length(); i++) {
                    long optLong = this.hzO.optLong(i);
                    this.hzQ.put(a(optLong, d.bij().hm(optLong)));
                }
                this.hxM = false;
            } else if (this.hzP != null && this.hzP.length() > 0) {
                this.hzQ = new JSONArray();
                for (i = 0; i < this.hzP.length(); i++) {
                    String optString = this.hzP.optString(i);
                    this.hzQ.put(a(optString, d.bij().Ir(optString)));
                }
                this.hxM = false;
            } else if (this.hxO <= 0) {
                this.hxN = "downloadId invalid";
            } else {
                FileDownloadTaskInfo hm = d.bij().hm(this.hxO);
                if (!(!hm.kNt || hm.status == 1 || hm.status == 3)) {
                    this.hzR = "download_wait_wifi";
                }
                switch (hm.status) {
                    case -1:
                        this.hxN = "fail_apilevel_too_low";
                        break;
                    case 1:
                        this.hzR = "downloading";
                        break;
                    case 2:
                        this.hzR = "download_pause";
                        break;
                    case 3:
                        if (!e.ct(hm.path)) {
                            this.hzR = "default";
                            break;
                        } else {
                            this.hzR = "download_succ";
                            break;
                        }
                    case 4:
                        this.hzR = "download_fail";
                        break;
                    default:
                        this.hzR = "default";
                        break;
                }
                ab.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.hzR);
                if ((this.hzR == "downloading" || this.hzR == "download_pause") && hm.jrb != 0) {
                    this.hzS = (long) ((((float) hm.kNr) / ((float) hm.jrb)) * 100.0f);
                }
                if (!(!hm.kNt || at.isWifi(ah.getContext()) || hm.status == 3 || hm.status == 1)) {
                    this.hzR = "download_wait_wifi";
                }
                this.hxM = false;
            }
            aCb();
            AppMethodBeat.o(130702);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130710);
        q qVar = (q) cVar;
        ab.d("MicroMsg.JsApiQueryDownloadTask", "invoke");
        AppBrandMainProcessService.a(new QueryDownloadTask(this, qVar, i, jSONObject));
        b.e(qVar);
        AppMethodBeat.o(130710);
    }
}
