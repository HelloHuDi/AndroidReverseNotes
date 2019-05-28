package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.xweb.x5.a.d;
import java.util.HashMap;
import java.util.Map;

public final class e implements a {

    static class b implements PreInitCallback {
        com.tencent.xweb.x5.sdk.d.a AQY;

        public b(com.tencent.xweb.x5.sdk.d.a aVar) {
            this.AQY = aVar;
        }

        public final void onCoreInitFinished() {
        }

        public final void onViewInitFinished(boolean z) {
            AppMethodBeat.i(85094);
            if (this.AQY != null) {
                this.AQY.onViewInitFinished(z);
            }
            AppMethodBeat.o(85094);
        }
    }

    static class a implements TbsListener {
        h AQX;

        public a(h hVar) {
            this.AQX = hVar;
        }

        public final void onDownloadFinish(int i) {
            AppMethodBeat.i(85091);
            if (this.AQX != null) {
                this.AQX.onDownloadFinish(i);
            }
            AppMethodBeat.o(85091);
        }

        public final void onInstallFinish(int i) {
            AppMethodBeat.i(85092);
            if (this.AQX != null) {
                this.AQX.onInstallFinish(i);
            }
            AppMethodBeat.o(85092);
        }

        public final void onDownloadProgress(int i) {
            AppMethodBeat.i(85093);
            if (this.AQX != null) {
                this.AQX.onDownloadProgress(i);
            }
            AppMethodBeat.o(85093);
        }
    }

    public final void a(Context context, com.tencent.xweb.x5.sdk.d.a aVar) {
        AppMethodBeat.i(85095);
        QbSdk.preInit(context, new b(aVar));
        AppMethodBeat.o(85095);
    }

    public final void reset(Context context) {
        AppMethodBeat.i(85096);
        QbSdk.reset(context);
        AppMethodBeat.o(85096);
    }

    public final boolean getTBSInstalling() {
        AppMethodBeat.i(85097);
        boolean tBSInstalling = QbSdk.getTBSInstalling();
        AppMethodBeat.o(85097);
        return tBSInstalling;
    }

    public final int getTbsVersion(Context context) {
        AppMethodBeat.i(85098);
        int tbsVersion = QbSdk.getTbsVersion(context);
        AppMethodBeat.o(85098);
        return tbsVersion;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(85099);
        QbSdk.setTbsListener(new a(hVar));
        AppMethodBeat.o(85099);
    }

    public final int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(85100);
        int startMiniQBToLoadUrl = QbSdk.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
        AppMethodBeat.o(85100);
        return startMiniQBToLoadUrl;
    }

    public final boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(85101);
        boolean startQbOrMiniQBToLoadUrl = QbSdk.startQbOrMiniQBToLoadUrl(context, str, hashMap, new d(valueCallback));
        AppMethodBeat.o(85101);
        return startQbOrMiniQBToLoadUrl;
    }

    public final void a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(85102);
        QbSdk.canOpenFile(context, str, new d(valueCallback));
        AppMethodBeat.o(85102);
    }

    public final boolean isTbsCoreInited() {
        AppMethodBeat.i(85103);
        boolean isTbsCoreInited = QbSdk.isTbsCoreInited();
        AppMethodBeat.o(85103);
        return isTbsCoreInited;
    }

    public final void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(85104);
        QbSdk.initTbsSettings(map);
        AppMethodBeat.o(85104);
    }

    public final boolean canOpenWebPlus(Context context) {
        AppMethodBeat.i(85105);
        boolean canOpenWebPlus = QbSdk.canOpenWebPlus(context);
        AppMethodBeat.o(85105);
        return canOpenWebPlus;
    }

    public final void closeFileReader(Context context) {
        AppMethodBeat.i(85106);
        QbSdk.closeFileReader(context);
        AppMethodBeat.o(85106);
    }

    public final void forceSysWebView() {
        AppMethodBeat.i(85107);
        QbSdk.forceSysWebView();
        AppMethodBeat.o(85107);
    }

    public final void setUploadCode(Context context, int i) {
        AppMethodBeat.i(85108);
        QbSdk.setUploadCode(context, i);
        AppMethodBeat.o(85108);
    }
}
