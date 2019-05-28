package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.model.ax */
public class C39214ax {
    private static C39214ax mYV;
    private static TMQQDownloaderOpenSDK mYW;

    /* renamed from: com.tencent.mm.plugin.game.model.ax$a */
    public static final class C34300a {
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

        private C34300a() {
        }

        public /* synthetic */ C34300a(byte b) {
            this();
        }

        /* renamed from: NX */
        private void m56235NX(String str) {
            AppMethodBeat.m2504i(111487);
            C4990ab.m7417i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", str);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
                AppMethodBeat.m2505o(111487);
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
                AppMethodBeat.m2505o(111487);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", e.getMessage());
                AppMethodBeat.m2505o(111487);
            }
        }

        /* renamed from: NY */
        public final TMQQDownloaderOpenSDKParam mo54824NY(String str) {
            AppMethodBeat.m2504i(111488);
            m56235NX(str);
            TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam = new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.mYX, this.actionFlag);
            AppMethodBeat.m2505o(111488);
            return tMQQDownloaderOpenSDKParam;
        }
    }

    private C39214ax() {
    }

    public static C39214ax bEU() {
        AppMethodBeat.m2504i(111489);
        if (mYV == null) {
            synchronized (C39214ax.class) {
                try {
                    if (mYV == null) {
                        mYV = new C39214ax();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(111489);
                    }
                }
            }
        }
        C39214ax c39214ax = mYV;
        AppMethodBeat.m2505o(111489);
        return c39214ax;
    }

    private static TMQQDownloaderOpenSDK bEV() {
        TMQQDownloaderOpenSDK instance;
        AppMethodBeat.m2504i(111490);
        if (mYW == null) {
            instance = TMQQDownloaderOpenSDK.getInstance();
            mYW = instance;
            instance.initQQDownloaderOpenSDK(C4996ah.getContext());
        }
        instance = mYW;
        AppMethodBeat.m2505o(111490);
        return instance;
    }

    public static void bEW() {
        boolean z = false;
        AppMethodBeat.m2504i(111491);
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(mYW == null);
        if (mYV == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        C4990ab.m7417i(str, str2, objArr);
        if (mYW != null) {
            mYW.destroyQQDownloaderOpenSDK();
        }
        mYW = null;
        mYV = null;
        AppMethodBeat.m2505o(111491);
    }

    /* renamed from: aw */
    public static void m66819aw(Context context, String str) {
        AppMethodBeat.m2504i(111492);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
            AppMethodBeat.m2505o(111492);
        } else if (context == null) {
            C4990ab.m7412e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
            AppMethodBeat.m2505o(111492);
        } else {
            C4990ab.m7417i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", str);
            TMQQDownloaderOpenSDKParam NY = new C34300a().mo54824NY(str);
            try {
                C39214ax.bEU();
                C39214ax.bEV().startToDownloadTaskList(context, NY, true, true);
                AppMethodBeat.m2505o(111492);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
                AppMethodBeat.m2505o(111492);
            }
        }
    }

    /* renamed from: a */
    public static int m66818a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        AppMethodBeat.m2504i(111493);
        try {
            C39214ax.bEU();
            TMAssistantDownloadTaskInfo downloadTaskState = C39214ax.bEV().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                int i = downloadTaskState.mState;
                AppMethodBeat.m2505o(111493);
                return i;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", e.getMessage());
        }
        AppMethodBeat.m2505o(111493);
        return -1;
    }

    /* renamed from: k */
    public static int m66820k(Context context, String str, int i) {
        int i2 = -1;
        AppMethodBeat.m2504i(111494);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
            AppMethodBeat.m2505o(111494);
        } else {
            try {
                PackageInfo packageInfo = C19679b.getPackageInfo(context, str);
                if (packageInfo == null) {
                    i2 = 1;
                } else {
                    C4990ab.m7411d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", Integer.valueOf(packageInfo.versionCode));
                    i2 = packageInfo.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", e.getMessage());
            }
            C4990ab.m7411d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", Integer.valueOf(i2));
            AppMethodBeat.m2505o(111494);
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        AppMethodBeat.m2504i(111495);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            AppMethodBeat.m2505o(111495);
            return;
        }
        TMQQDownloaderOpenSDKParam NY = new C34300a().mo54824NY(str);
        try {
            C39214ax.bEU();
            C39214ax.bEV().startToAuthorized(context, NY, "1");
            AppMethodBeat.m2505o(111495);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(111495);
        }
    }
}
