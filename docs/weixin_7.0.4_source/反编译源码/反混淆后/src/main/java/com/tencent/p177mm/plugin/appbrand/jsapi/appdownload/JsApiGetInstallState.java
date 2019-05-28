package com.tencent.p177mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState */
public final class JsApiGetInstallState extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 439;
    public static final String NAME = "getInstallState";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState$GetInstallStateTask */
    static class GetInstallStateTask extends MainProcessTask {
        public static final Creator<GetInstallStateTask> CREATOR = new C22041();
        private int bOs;
        private C38492q gNC;
        private C45608m hxE;
        private boolean hxM;
        private String hzK;
        private JSONArray hzL;
        private boolean hzM;
        private String mPackageName;
        private String mVersionName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState$GetInstallStateTask$1 */
        static class C22041 implements Creator<GetInstallStateTask> {
            C22041() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetInstallStateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(114341);
                GetInstallStateTask getInstallStateTask = new GetInstallStateTask(parcel);
                AppMethodBeat.m2505o(114341);
                return getInstallStateTask;
            }
        }

        public GetInstallStateTask(C45608m c45608m, C38492q c38492q, int i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(114342);
            aBV();
            this.hxE = c45608m;
            this.gNC = c38492q;
            this.bOs = i;
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("packageNameArray");
            if (optJSONArray != null) {
                this.hzK = optJSONArray.toString();
            }
            this.hxM = true;
            AppMethodBeat.m2505o(114342);
        }

        public GetInstallStateTask(Parcel parcel) {
            AppMethodBeat.m2504i(114343);
            mo6032g(parcel);
            AppMethodBeat.m2505o(114343);
        }

        public final void asQ() {
            boolean z = true;
            AppMethodBeat.m2504i(114345);
            String str = "MicroMsg.JsApiGetInstallState";
            String str2 = "callback, service is null: %b";
            Object[] objArr = new Object[1];
            if (this.gNC != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7411d(str, str2, objArr);
            aBW();
            if (this.hxM) {
                this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("fail", null));
                AppMethodBeat.m2505o(114345);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.hzL != null) {
                hashMap.put("result", this.hzL);
            } else {
                hashMap.put("versionName", this.mVersionName);
                hashMap.put("isInstalled", Boolean.valueOf(this.hzM));
            }
            this.gNC.mo6107M(this.bOs, this.hxE.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(114345);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(114346);
            this.mPackageName = parcel.readString();
            this.hzK = parcel.readString();
            this.hxM = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hzM = z;
            this.mVersionName = parcel.readString();
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.hzL = new JSONArray(readString);
                    AppMethodBeat.m2505o(114346);
                    return;
                } catch (JSONException e) {
                    C4990ab.m7412e("MicroMsg.JsApiGetInstallState", "parseFromParcel: " + e.getMessage());
                }
            }
            AppMethodBeat.m2505o(114346);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(114347);
            parcel.writeString(this.mPackageName);
            parcel.writeString(this.hzK);
            if (this.hxM) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (!this.hzM) {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.mVersionName);
            parcel.writeString(this.hzL != null ? this.hzL.toString() : null);
            AppMethodBeat.m2505o(114347);
        }

        static {
            AppMethodBeat.m2504i(114348);
            AppMethodBeat.m2505o(114348);
        }

        public final void asP() {
            AppMethodBeat.m2504i(114344);
            if (C5046bo.isNullOrNil(this.hzK)) {
                PackageInfo packageInfo = C19679b.getPackageInfo(C4996ah.getContext(), this.mPackageName);
                int i = packageInfo == null ? 0 : packageInfo.versionCode;
                String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                C4990ab.m7416i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + packageInfo + ", version = " + i + ", versionName = " + str);
                if (packageInfo == null) {
                    this.hzM = false;
                } else {
                    this.mVersionName = str;
                    this.hzM = true;
                }
                this.hxM = false;
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(this.hzK);
                    this.hzL = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        boolean z;
                        String optString = jSONArray.optString(i2);
                        PackageInfo packageInfo2 = C19679b.getPackageInfo(C4996ah.getContext(), optString);
                        int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
                        String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
                        C4990ab.m7416i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", packageInfo = " + packageInfo2 + ", version = " + i3 + ", versionName = " + str2);
                        if (packageInfo2 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(DownloadInfoColumns.PACKAGENAME, optString);
                            jSONObject.put("isInstalled", z);
                            if (z) {
                                jSONObject.put(DownloadInfoColumns.VERSIONCODE, i3);
                                jSONObject.put("versionName", str2);
                            }
                            this.hzL.put(jSONObject);
                        } catch (JSONException e) {
                            C4990ab.m7416i("MicroMsg.JsApiGetInstallState", e.getMessage());
                        }
                    }
                    this.hxM = false;
                } catch (JSONException e2) {
                    C4990ab.m7412e("MicroMsg.JsApiGetInstallState", e2.getMessage());
                    this.hxM = true;
                }
            }
            aCb();
            AppMethodBeat.m2505o(114344);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(114349);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7410d("MicroMsg.JsApiGetInstallState", "invoke");
        AppBrandMainProcessService.m54349a(new GetInstallStateTask(this, c38492q, i, jSONObject));
        AppMethodBeat.m2505o(114349);
    }
}
