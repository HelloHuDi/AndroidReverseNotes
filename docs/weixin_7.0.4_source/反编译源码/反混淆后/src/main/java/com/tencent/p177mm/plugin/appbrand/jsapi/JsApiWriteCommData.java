package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData */
public final class JsApiWriteCommData extends C10296a {
    public static final int CTRL_INDEX = 445;
    public static final String NAME = "writeCommData";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData$WriteCommDataTask */
    static class WriteCommDataTask extends MainProcessTask {
        public static final Creator<WriteCommDataTask> CREATOR = new C102941();
        private int bOs;
        private C45608m hxE;
        private boolean hxM;
        private String hxN;
        private C2241c hzz;
        private String mData;
        private String mPackageName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData$WriteCommDataTask$1 */
        static class C102941 implements Creator<WriteCommDataTask> {
            C102941() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WriteCommDataTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(114332);
                WriteCommDataTask writeCommDataTask = new WriteCommDataTask(parcel);
                AppMethodBeat.m2505o(114332);
                return writeCommDataTask;
            }
        }

        public WriteCommDataTask(C45608m c45608m, C2241c c2241c, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(114333);
            this.hxE = c45608m;
            this.hzz = c2241c;
            this.bOs = i;
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.mData = jSONObject.optString("data");
            this.hxM = true;
            AppMethodBeat.m2505o(114333);
        }

        public WriteCommDataTask(Parcel parcel) {
            AppMethodBeat.m2504i(114334);
            mo6032g(parcel);
            AppMethodBeat.m2505o(114334);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(114336);
            if (this.hxM) {
                String str;
                if (C5046bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.hzz.mo6107M(this.bOs, this.hxE.mo73394j(str, null));
                AppMethodBeat.m2505o(114336);
                return;
            }
            this.hzz.mo6107M(this.bOs, this.hxE.mo73394j("ok", null));
            AppMethodBeat.m2505o(114336);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(114337);
            this.mPackageName = parcel.readString();
            this.mData = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            AppMethodBeat.m2505o(114337);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(114338);
            parcel.writeString(this.mPackageName);
            parcel.writeString(this.mData);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            AppMethodBeat.m2505o(114338);
        }

        static {
            AppMethodBeat.m2504i(114339);
            AppMethodBeat.m2505o(114339);
        }

        public final void asP() {
            boolean z = false;
            AppMethodBeat.m2504i(114335);
            if (C5046bo.isNullOrNil(this.mPackageName)) {
                C4990ab.m7412e("MicroMsg.JsApiWriteCommData", "packageName nil");
            } else {
                if (!C4996ah.getContext().getSharedPreferences(C4996ah.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
                    z = true;
                }
                this.hxM = z;
            }
            aCb();
            AppMethodBeat.m2505o(114335);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(114340);
        AppBrandMainProcessService.m54349a(new WriteCommDataTask(this, c2241c, i, jSONObject));
        AppMethodBeat.m2505o(114340);
    }
}
