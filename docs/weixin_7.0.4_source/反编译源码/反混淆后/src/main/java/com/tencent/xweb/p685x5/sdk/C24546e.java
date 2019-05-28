package com.tencent.xweb.p685x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.xweb.p685x5.C24535a.C24538d;
import com.tencent.xweb.p685x5.sdk.C24544d.C24545a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.xweb.x5.sdk.e */
public final class C24546e implements C44593a {

    /* renamed from: com.tencent.xweb.x5.sdk.e$b */
    static class C17084b implements PreInitCallback {
        C24545a AQY;

        public C17084b(C24545a c24545a) {
            this.AQY = c24545a;
        }

        public final void onCoreInitFinished() {
        }

        public final void onViewInitFinished(boolean z) {
            AppMethodBeat.m2504i(85094);
            if (this.AQY != null) {
                this.AQY.onViewInitFinished(z);
            }
            AppMethodBeat.m2505o(85094);
        }
    }

    /* renamed from: com.tencent.xweb.x5.sdk.e$a */
    static class C24547a implements TbsListener {
        C46837h AQX;

        public C24547a(C46837h c46837h) {
            this.AQX = c46837h;
        }

        public final void onDownloadFinish(int i) {
            AppMethodBeat.m2504i(85091);
            if (this.AQX != null) {
                this.AQX.onDownloadFinish(i);
            }
            AppMethodBeat.m2505o(85091);
        }

        public final void onInstallFinish(int i) {
            AppMethodBeat.m2504i(85092);
            if (this.AQX != null) {
                this.AQX.onInstallFinish(i);
            }
            AppMethodBeat.m2505o(85092);
        }

        public final void onDownloadProgress(int i) {
            AppMethodBeat.m2504i(85093);
            if (this.AQX != null) {
                this.AQX.onDownloadProgress(i);
            }
            AppMethodBeat.m2505o(85093);
        }
    }

    /* renamed from: a */
    public final void mo41293a(Context context, C24545a c24545a) {
        AppMethodBeat.m2504i(85095);
        QbSdk.preInit(context, new C17084b(c24545a));
        AppMethodBeat.m2505o(85095);
    }

    public final void reset(Context context) {
        AppMethodBeat.m2504i(85096);
        QbSdk.reset(context);
        AppMethodBeat.m2505o(85096);
    }

    public final boolean getTBSInstalling() {
        AppMethodBeat.m2504i(85097);
        boolean tBSInstalling = QbSdk.getTBSInstalling();
        AppMethodBeat.m2505o(85097);
        return tBSInstalling;
    }

    public final int getTbsVersion(Context context) {
        AppMethodBeat.m2504i(85098);
        int tbsVersion = QbSdk.getTbsVersion(context);
        AppMethodBeat.m2505o(85098);
        return tbsVersion;
    }

    /* renamed from: a */
    public final void mo41295a(C46837h c46837h) {
        AppMethodBeat.m2504i(85099);
        QbSdk.setTbsListener(new C24547a(c46837h));
        AppMethodBeat.m2505o(85099);
    }

    public final int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(85100);
        int startMiniQBToLoadUrl = QbSdk.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
        AppMethodBeat.m2505o(85100);
        return startMiniQBToLoadUrl;
    }

    /* renamed from: a */
    public final boolean mo41296a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(85101);
        boolean startQbOrMiniQBToLoadUrl = QbSdk.startQbOrMiniQBToLoadUrl(context, str, hashMap, new C24538d(valueCallback));
        AppMethodBeat.m2505o(85101);
        return startQbOrMiniQBToLoadUrl;
    }

    /* renamed from: a */
    public final void mo41294a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(85102);
        QbSdk.canOpenFile(context, str, new C24538d(valueCallback));
        AppMethodBeat.m2505o(85102);
    }

    public final boolean isTbsCoreInited() {
        AppMethodBeat.m2504i(85103);
        boolean isTbsCoreInited = QbSdk.isTbsCoreInited();
        AppMethodBeat.m2505o(85103);
        return isTbsCoreInited;
    }

    public final void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.m2504i(85104);
        QbSdk.initTbsSettings(map);
        AppMethodBeat.m2505o(85104);
    }

    public final boolean canOpenWebPlus(Context context) {
        AppMethodBeat.m2504i(85105);
        boolean canOpenWebPlus = QbSdk.canOpenWebPlus(context);
        AppMethodBeat.m2505o(85105);
        return canOpenWebPlus;
    }

    public final void closeFileReader(Context context) {
        AppMethodBeat.m2504i(85106);
        QbSdk.closeFileReader(context);
        AppMethodBeat.m2505o(85106);
    }

    public final void forceSysWebView() {
        AppMethodBeat.m2504i(85107);
        QbSdk.forceSysWebView();
        AppMethodBeat.m2505o(85107);
    }

    public final void setUploadCode(Context context, int i) {
        AppMethodBeat.m2504i(85108);
        QbSdk.setUploadCode(context, i);
        AppMethodBeat.m2505o(85108);
    }
}
