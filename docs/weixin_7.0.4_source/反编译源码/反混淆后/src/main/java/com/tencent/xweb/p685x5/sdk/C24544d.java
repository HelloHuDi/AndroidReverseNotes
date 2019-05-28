package com.tencent.xweb.p685x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C46838x;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.sdk.d */
public final class C24544d {
    static C44593a AQV;
    static boolean AQW = false;

    /* renamed from: com.tencent.xweb.x5.sdk.d$a */
    public interface C24545a {
        void onViewInitFinished(boolean z);
    }

    static {
        AppMethodBeat.m2504i(4149);
        C46838x.initInterface();
        AppMethodBeat.m2505o(4149);
    }

    /* renamed from: a */
    public static void m38197a(C44593a c44593a) {
        AQV = c44593a;
    }

    /* renamed from: a */
    public static synchronized void m38195a(Context context, C24545a c24545a) {
        synchronized (C24544d.class) {
            AppMethodBeat.m2504i(4135);
            if (AQV != null) {
                AQV.mo41293a(context, c24545a);
                AppMethodBeat.m2505o(4135);
            } else {
                Log.m81046e("TbsDownloader", "preInit: sImp is null");
                AppMethodBeat.m2505o(4135);
            }
        }
    }

    public static void reset(Context context) {
        AppMethodBeat.m2504i(4136);
        if (AQV != null) {
            AQV.reset(context);
            AppMethodBeat.m2505o(4136);
            return;
        }
        Log.m81046e("TbsDownloader", "reset: sImp is null");
        AppMethodBeat.m2505o(4136);
    }

    public static boolean getTBSInstalling() {
        AppMethodBeat.m2504i(4137);
        if (AQV != null) {
            boolean tBSInstalling = AQV.getTBSInstalling();
            AppMethodBeat.m2505o(4137);
            return tBSInstalling;
        }
        Log.m81046e("TbsDownloader", "getTBSInstalling: sImp is null");
        AppMethodBeat.m2505o(4137);
        return false;
    }

    public static int getTbsVersion(Context context) {
        AppMethodBeat.m2504i(4138);
        if (AQV != null) {
            int tbsVersion = AQV.getTbsVersion(context);
            AppMethodBeat.m2505o(4138);
            return tbsVersion;
        }
        Log.m81046e("TbsDownloader", "getTbsVersion: sImp is null");
        AppMethodBeat.m2505o(4138);
        return 0;
    }

    /* renamed from: a */
    public static void m38198a(C46837h c46837h) {
        AppMethodBeat.m2504i(4139);
        if (AQV != null) {
            AQV.mo41295a(c46837h);
            AppMethodBeat.m2505o(4139);
            return;
        }
        Log.m81046e("TbsDownloader", "setTbsListener: sImp is null");
        AppMethodBeat.m2505o(4139);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(4140);
        if (AQV != null) {
            int startMiniQBToLoadUrl = AQV.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            AppMethodBeat.m2505o(4140);
            return startMiniQBToLoadUrl;
        }
        Log.m81046e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
        AppMethodBeat.m2505o(4140);
        return 0;
    }

    /* renamed from: a */
    public static boolean m38199a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(4141);
        if (AQV != null) {
            boolean a = AQV.mo41296a(context, str, hashMap, valueCallback);
            AppMethodBeat.m2505o(4141);
            return a;
        }
        Log.m81046e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
        AppMethodBeat.m2505o(4141);
        return false;
    }

    /* renamed from: a */
    public static void m38196a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(4142);
        if (AQV != null) {
            AQV.mo41294a(context, str, valueCallback);
            AppMethodBeat.m2505o(4142);
            return;
        }
        Log.m81046e("TbsDownloader", "canOpenFile: sImp is null");
        AppMethodBeat.m2505o(4142);
    }

    public static boolean isTbsCoreInited() {
        AppMethodBeat.m2504i(4143);
        if (AQV != null) {
            boolean isTbsCoreInited = AQV.isTbsCoreInited();
            AppMethodBeat.m2505o(4143);
            return isTbsCoreInited;
        }
        Log.m81046e("TbsDownloader", "isTbsCoreInited: sImp is null");
        AppMethodBeat.m2505o(4143);
        return false;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.m2504i(4144);
        if (AQV != null) {
            AQV.initTbsSettings(map);
            AppMethodBeat.m2505o(4144);
            return;
        }
        Log.m81046e("TbsDownloader", "initTbsSettings: sImp is null");
        AppMethodBeat.m2505o(4144);
    }

    public static boolean canOpenWebPlus(Context context) {
        AppMethodBeat.m2504i(4145);
        if (AQV != null) {
            boolean canOpenWebPlus = AQV.canOpenWebPlus(context);
            AppMethodBeat.m2505o(4145);
            return canOpenWebPlus;
        }
        Log.m81046e("TbsDownloader", "canOpenWebPlus: sImp is null");
        AppMethodBeat.m2505o(4145);
        return false;
    }

    public static void closeFileReader(Context context) {
        AppMethodBeat.m2504i(4146);
        if (AQV != null) {
            AQV.closeFileReader(context);
            AppMethodBeat.m2505o(4146);
            return;
        }
        Log.m81046e("TbsDownloader", "closeFileReader: sImp is null");
        AppMethodBeat.m2505o(4146);
    }

    public static void forceSysWebView() {
        AppMethodBeat.m2504i(4147);
        AQW = true;
        if (AQV != null) {
            AQV.forceSysWebView();
            AppMethodBeat.m2505o(4147);
            return;
        }
        Log.m81046e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.m2505o(4147);
    }

    public static void setUploadCode(Context context, int i) {
        AppMethodBeat.m2504i(4148);
        if (AQV != null) {
            AQV.setUploadCode(context, i);
            AppMethodBeat.m2505o(4148);
            return;
        }
        Log.m81046e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.m2505o(4148);
    }
}
