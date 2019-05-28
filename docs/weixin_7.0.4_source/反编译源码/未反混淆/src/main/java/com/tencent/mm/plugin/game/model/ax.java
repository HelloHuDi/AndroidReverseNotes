package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class ax {
    private static ax mYV;
    private static TMQQDownloaderOpenSDK mYW;

    public static final class a {
        public String SNGAppId;
        public String actionFlag;
        public String mYX;
        public String taskApkId;
        public String taskAppId;
        public String taskPackageName;
        public int taskVersion;
        public String uin;
        public String uinType;
        public String via;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        private void NX(String str) {
            AppMethodBeat.i(111487);
            ab.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", str);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
                AppMethodBeat.o(111487);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.taskApkId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                this.via = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_VIA);
                this.taskVersion = jSONObject.optInt(OpenSDKTool4Assistant.EXTRA_TASK_VERSION);
                this.mYX = jSONObject.optString("channelID");
                this.uin = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UIN);
                this.SNGAppId = jSONObject.optString("SNGAppId");
                this.taskAppId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                this.uinType = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                this.taskPackageName = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                this.actionFlag = jSONObject.optString("actionFlag");
                AppMethodBeat.o(111487);
            } catch (Exception e) {
                ab.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", e.getMessage());
                AppMethodBeat.o(111487);
            }
        }

        public final TMQQDownloaderOpenSDKParam NY(String str) {
            AppMethodBeat.i(111488);
            NX(str);
            TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.mYX, this.actionFlag);
            AppMethodBeat.o(111488);
            return tMQQDownloaderOpenSDKParam;
        }
    }

    private ax() {
    }

    public static ax bEU() {
        AppMethodBeat.i(111489);
        if (mYV == null) {
            synchronized (ax.class) {
                try {
                    if (mYV == null) {
                        mYV = new ax();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(111489);
                    }
                }
            }
        }
        ax axVar = mYV;
        AppMethodBeat.o(111489);
        return axVar;
    }

    private static TMQQDownloaderOpenSDK bEV() {
        TMQQDownloaderOpenSDK instance;
        AppMethodBeat.i(111490);
        if (mYW == null) {
            instance = TMQQDownloaderOpenSDK.getInstance();
            mYW = instance;
            instance.initQQDownloaderOpenSDK(ah.getContext());
        }
        instance = mYW;
        AppMethodBeat.o(111490);
        return instance;
    }

    public static void bEW() {
        boolean z = false;
        AppMethodBeat.i(111491);
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(mYW == null);
        if (mYV == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        ab.i(str, str2, objArr);
        if (mYW != null) {
            mYW.destroyQQDownloaderOpenSDK();
        }
        mYW = null;
        mYV = null;
        AppMethodBeat.o(111491);
    }

    public static void aw(Context context, String str) {
        AppMethodBeat.i(111492);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
            AppMethodBeat.o(111492);
        } else if (context == null) {
            ab.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
            AppMethodBeat.o(111492);
        } else {
            ab.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", str);
            TMQQDownloaderOpenSDKParam NY = new a().NY(str);
            try {
                bEU();
                bEV().startToDownloadTaskList(context, NY, true, true);
                AppMethodBeat.o(111492);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
                AppMethodBeat.o(111492);
            }
        }
    }

    public static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.i(111493);
        try {
            bEU();
            TMAssistantDownloadTaskInfo downloadTaskState = bEV().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                int i = downloadTaskState.mState;
                AppMethodBeat.o(111493);
                return i;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", e.getMessage());
        }
        AppMethodBeat.o(111493);
        return -1;
    }

    public static int k(Context context, String str, int i) {
        int i2 = -1;
        AppMethodBeat.i(111494);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
            AppMethodBeat.o(111494);
        } else {
            try {
                PackageInfo packageInfo = b.getPackageInfo(context, str);
                if (packageInfo == null) {
                    i2 = 1;
                } else {
                    ab.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", Integer.valueOf(packageInfo.versionCode));
                    i2 = packageInfo.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", e.getMessage());
            }
            ab.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", Integer.valueOf(i2));
            AppMethodBeat.o(111494);
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        AppMethodBeat.i(111495);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            AppMethodBeat.o(111495);
            return;
        }
        TMQQDownloaderOpenSDKParam NY = new a().NY(str);
        try {
            bEU();
            bEV().startToAuthorized(context, NY, "1");
            AppMethodBeat.o(111495);
        } catch (Exception e) {
            ab.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", e.getMessage());
            AppMethodBeat.o(111495);
        }
    }
}
