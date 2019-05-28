package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask */
public final class JsApiQueryDownloadTask extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 441;
    public static final String NAME = "queryDownloadTask";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask$QueryDownloadTask */
    static class QueryDownloadTask extends MainProcessTask {
        public static final Creator<QueryDownloadTask> CREATOR = new C22051();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
        private boolean hxM;
        private String hxN;
        private long hxO;
        private JSONArray hzO;
        private JSONArray hzP;
        private JSONArray hzQ;
        private String hzR;
        private long hzS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask$QueryDownloadTask$1 */
        static class C22051 implements Creator<QueryDownloadTask> {
            C22051() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueryDownloadTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130699);
                QueryDownloadTask queryDownloadTask = new QueryDownloadTask(parcel);
                AppMethodBeat.m2505o(130699);
                return queryDownloadTask;
            }
        }

        public QueryDownloadTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(130700);
            aBV();
            this.hxE = c45608m;
            this.gNC = c38492q;
            this.bOs = i;
            this.hxO = jSONObject.optLong("downloadId");
            this.hzO = jSONObject.optJSONArray("downloadIdArray");
            this.hzP = jSONObject.optJSONArray("appIdArray");
            this.hxM = true;
            AppMethodBeat.m2505o(130700);
        }

        public QueryDownloadTask(Parcel parcel) {
            AppMethodBeat.m2504i(130701);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130701);
        }

        /* renamed from: a */
        private JSONObject m54373a(long j, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.m2504i(130703);
            JSONObject a = m54374a(fileDownloadTaskInfo);
            if (fileDownloadTaskInfo != null) {
                try {
                    a.put("downloadId", j);
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(130703);
            return a;
        }

        /* renamed from: a */
        private JSONObject m54375a(String str, FileDownloadTaskInfo fileDownloadTaskInfo) {
            AppMethodBeat.m2504i(130704);
            JSONObject a = m54374a(fileDownloadTaskInfo);
            try {
                a.put("appId", str);
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
            AppMethodBeat.m2505o(130704);
            return a;
        }

        /* renamed from: a */
        private JSONObject m54374a(FileDownloadTaskInfo fileDownloadTaskInfo) {
            String str;
            long j = 0;
            AppMethodBeat.m2504i(130705);
            JSONObject jSONObject = new JSONObject();
            switch (fileDownloadTaskInfo.status) {
                case -1:
                    this.hxN = "fail_apilevel_too_low";
                    AppMethodBeat.m2505o(130705);
                    return jSONObject;
                case 1:
                    str = "downloading";
                    break;
                case 2:
                    str = "download_pause";
                    break;
                case 3:
                    if (!C1173e.m2561ct(fileDownloadTaskInfo.path)) {
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
            C4990ab.m7417i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", str);
            if (!(!fileDownloadTaskInfo.kNt || C5023at.isWifi(C4996ah.getContext()) || fileDownloadTaskInfo.status == 3 || fileDownloadTaskInfo.status == 1)) {
                str = "download_wait_wifi";
            }
            if ((str == "downloading" || str == "download_pause") && fileDownloadTaskInfo.jrb != 0) {
                j = (long) ((((float) fileDownloadTaskInfo.kNr) / ((float) fileDownloadTaskInfo.jrb)) * 100.0f);
            }
            try {
                jSONObject.put("appId", fileDownloadTaskInfo.appId);
                jSONObject.put("downloadId", fileDownloadTaskInfo.f16167id);
                jSONObject.put("state", str);
                jSONObject.put("progress", j);
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.JsApiQueryDownloadTask", e.getMessage());
            }
            AppMethodBeat.m2505o(130705);
            return jSONObject;
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130706);
            aBW();
            String str = "MicroMsg.JsApiQueryDownloadTask";
            String str2 = "callback, service is null: %b";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.gNC == null);
            C4990ab.m7411d(str, str2, objArr);
            if (this.hxM) {
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j(C5046bo.isNullOrNil(this.hxN) ? "fail" : String.format("fail:%s", new Object[]{this.hxN}), null));
                AppMethodBeat.m2505o(130706);
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
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(130706);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(130707);
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
                    C4990ab.printErrStackTrace("MicroMsg.JsApiQueryDownloadTask", e, "", new Object[0]);
                    AppMethodBeat.m2505o(130707);
                    return;
                }
            }
            if (readString2 != null) {
                this.hzP = new JSONArray(readString2);
            }
            if (readString3 != null) {
                this.hzQ = new JSONArray(readString3);
            }
            AppMethodBeat.m2505o(130707);
        }

        public void writeToParcel(Parcel parcel, int i) {
            String jSONArray;
            String str = null;
            AppMethodBeat.m2504i(130708);
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
            AppMethodBeat.m2505o(130708);
        }

        static {
            AppMethodBeat.m2504i(130709);
            AppMethodBeat.m2505o(130709);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130702);
            C4990ab.m7417i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", Long.valueOf(this.hxO));
            int i;
            if (this.hzO != null && this.hzO.length() > 0) {
                this.hzQ = new JSONArray();
                for (i = 0; i < this.hzO.length(); i++) {
                    long optLong = this.hzO.optLong(i);
                    this.hzQ.put(m54373a(optLong, C2896d.bij().mo7048hm(optLong)));
                }
                this.hxM = false;
            } else if (this.hzP != null && this.hzP.length() > 0) {
                this.hzQ = new JSONArray();
                for (i = 0; i < this.hzP.length(); i++) {
                    String optString = this.hzP.optString(i);
                    this.hzQ.put(m54375a(optString, C2896d.bij().mo7040Ir(optString)));
                }
                this.hxM = false;
            } else if (this.hxO <= 0) {
                this.hxN = "downloadId invalid";
            } else {
                FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(this.hxO);
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
                        if (!C1173e.m2561ct(hm.path)) {
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
                C4990ab.m7417i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", this.hzR);
                if ((this.hzR == "downloading" || this.hzR == "download_pause") && hm.jrb != 0) {
                    this.hzS = (long) ((((float) hm.kNr) / ((float) hm.jrb)) * 100.0f);
                }
                if (!(!hm.kNt || C5023at.isWifi(C4996ah.getContext()) || hm.status == 3 || hm.status == 1)) {
                    this.hzR = "download_wait_wifi";
                }
                this.hxM = false;
            }
            aCb();
            AppMethodBeat.m2505o(130702);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130710);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7410d("MicroMsg.JsApiQueryDownloadTask", "invoke");
        AppBrandMainProcessService.m54349a(new QueryDownloadTask(this, c38492q, i, jSONObject));
        C42469b.m75232e(c38492q);
        AppMethodBeat.m2505o(130710);
    }
}
