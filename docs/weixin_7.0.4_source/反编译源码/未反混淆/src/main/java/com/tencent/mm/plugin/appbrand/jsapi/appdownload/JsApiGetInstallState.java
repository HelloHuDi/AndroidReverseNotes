package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiGetInstallState extends a<q> {
    public static final int CTRL_INDEX = 439;
    public static final String NAME = "getInstallState";

    static class GetInstallStateTask extends MainProcessTask {
        public static final Creator<GetInstallStateTask> CREATOR = new Creator<GetInstallStateTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetInstallStateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(114341);
                GetInstallStateTask getInstallStateTask = new GetInstallStateTask(parcel);
                AppMethodBeat.o(114341);
                return getInstallStateTask;
            }
        };
        private int bOs;
        private q gNC;
        private m hxE;
        private boolean hxM;
        private String hzK;
        private JSONArray hzL;
        private boolean hzM;
        private String mPackageName;
        private String mVersionName;

        public GetInstallStateTask(m mVar, q qVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(114342);
            aBV();
            this.hxE = mVar;
            this.gNC = qVar;
            this.bOs = i;
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            JSONArray optJSONArray = jSONObject.optJSONArray("packageNameArray");
            if (optJSONArray != null) {
                this.hzK = optJSONArray.toString();
            }
            this.hxM = true;
            AppMethodBeat.o(114342);
        }

        public GetInstallStateTask(Parcel parcel) {
            AppMethodBeat.i(114343);
            g(parcel);
            AppMethodBeat.o(114343);
        }

        public final void asQ() {
            boolean z = true;
            AppMethodBeat.i(114345);
            String str = "MicroMsg.JsApiGetInstallState";
            String str2 = "callback, service is null: %b";
            Object[] objArr = new Object[1];
            if (this.gNC != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            ab.d(str, str2, objArr);
            aBW();
            if (this.hxM) {
                this.gNC.M(this.bOs, this.hxE.j("fail", null));
                AppMethodBeat.o(114345);
                return;
            }
            HashMap hashMap = new HashMap();
            if (this.hzL != null) {
                hashMap.put("result", this.hzL);
            } else {
                hashMap.put("versionName", this.mVersionName);
                hashMap.put("isInstalled", Boolean.valueOf(this.hzM));
            }
            this.gNC.M(this.bOs, this.hxE.j("ok", hashMap));
            AppMethodBeat.o(114345);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(114346);
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
                    AppMethodBeat.o(114346);
                    return;
                } catch (JSONException e) {
                    ab.e("MicroMsg.JsApiGetInstallState", "parseFromParcel: " + e.getMessage());
                }
            }
            AppMethodBeat.o(114346);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.i(114347);
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
            AppMethodBeat.o(114347);
        }

        static {
            AppMethodBeat.i(114348);
            AppMethodBeat.o(114348);
        }

        public final void asP() {
            AppMethodBeat.i(114344);
            if (bo.isNullOrNil(this.hzK)) {
                PackageInfo packageInfo = b.getPackageInfo(ah.getContext(), this.mPackageName);
                int i = packageInfo == null ? 0 : packageInfo.versionCode;
                String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                ab.i("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.mPackageName + ", packageInfo = " + packageInfo + ", version = " + i + ", versionName = " + str);
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
                        PackageInfo packageInfo2 = b.getPackageInfo(ah.getContext(), optString);
                        int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
                        String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
                        ab.i("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", packageInfo = " + packageInfo2 + ", version = " + i3 + ", versionName = " + str2);
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
                            ab.i("MicroMsg.JsApiGetInstallState", e.getMessage());
                        }
                    }
                    this.hxM = false;
                } catch (JSONException e2) {
                    ab.e("MicroMsg.JsApiGetInstallState", e2.getMessage());
                    this.hxM = true;
                }
            }
            aCb();
            AppMethodBeat.o(114344);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(114349);
        q qVar = (q) cVar;
        ab.d("MicroMsg.JsApiGetInstallState", "invoke");
        AppBrandMainProcessService.a(new GetInstallStateTask(this, qVar, i, jSONObject));
        AppMethodBeat.o(114349);
    }
}
