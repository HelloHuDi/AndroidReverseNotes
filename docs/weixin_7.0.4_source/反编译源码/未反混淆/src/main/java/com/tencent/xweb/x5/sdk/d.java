package com.tencent.xweb.x5.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d {
    static a AQV;
    static boolean AQW = false;

    public interface a {
        void onViewInitFinished(boolean z);
    }

    static {
        AppMethodBeat.i(4149);
        x.initInterface();
        AppMethodBeat.o(4149);
    }

    public static void a(a aVar) {
        AQV = aVar;
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (d.class) {
            AppMethodBeat.i(4135);
            if (AQV != null) {
                AQV.a(context, aVar);
                AppMethodBeat.o(4135);
            } else {
                Log.e("TbsDownloader", "preInit: sImp is null");
                AppMethodBeat.o(4135);
            }
        }
    }

    public static void reset(Context context) {
        AppMethodBeat.i(4136);
        if (AQV != null) {
            AQV.reset(context);
            AppMethodBeat.o(4136);
            return;
        }
        Log.e("TbsDownloader", "reset: sImp is null");
        AppMethodBeat.o(4136);
    }

    public static boolean getTBSInstalling() {
        AppMethodBeat.i(4137);
        if (AQV != null) {
            boolean tBSInstalling = AQV.getTBSInstalling();
            AppMethodBeat.o(4137);
            return tBSInstalling;
        }
        Log.e("TbsDownloader", "getTBSInstalling: sImp is null");
        AppMethodBeat.o(4137);
        return false;
    }

    public static int getTbsVersion(Context context) {
        AppMethodBeat.i(4138);
        if (AQV != null) {
            int tbsVersion = AQV.getTbsVersion(context);
            AppMethodBeat.o(4138);
            return tbsVersion;
        }
        Log.e("TbsDownloader", "getTbsVersion: sImp is null");
        AppMethodBeat.o(4138);
        return 0;
    }

    public static void a(h hVar) {
        AppMethodBeat.i(4139);
        if (AQV != null) {
            AQV.a(hVar);
            AppMethodBeat.o(4139);
            return;
        }
        Log.e("TbsDownloader", "setTbsListener: sImp is null");
        AppMethodBeat.o(4139);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(4140);
        if (AQV != null) {
            int startMiniQBToLoadUrl = AQV.startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            AppMethodBeat.o(4140);
            return startMiniQBToLoadUrl;
        }
        Log.e("TbsDownloader", "startMiniQBToLoadUrl: sImp is null");
        AppMethodBeat.o(4140);
        return 0;
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(4141);
        if (AQV != null) {
            boolean a = AQV.a(context, str, hashMap, valueCallback);
            AppMethodBeat.o(4141);
            return a;
        }
        Log.e("TbsDownloader", "startQbOrMiniQBToLoadUrl: sImp is null");
        AppMethodBeat.o(4141);
        return false;
    }

    public static void a(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(4142);
        if (AQV != null) {
            AQV.a(context, str, valueCallback);
            AppMethodBeat.o(4142);
            return;
        }
        Log.e("TbsDownloader", "canOpenFile: sImp is null");
        AppMethodBeat.o(4142);
    }

    public static boolean isTbsCoreInited() {
        AppMethodBeat.i(4143);
        if (AQV != null) {
            boolean isTbsCoreInited = AQV.isTbsCoreInited();
            AppMethodBeat.o(4143);
            return isTbsCoreInited;
        }
        Log.e("TbsDownloader", "isTbsCoreInited: sImp is null");
        AppMethodBeat.o(4143);
        return false;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(4144);
        if (AQV != null) {
            AQV.initTbsSettings(map);
            AppMethodBeat.o(4144);
            return;
        }
        Log.e("TbsDownloader", "initTbsSettings: sImp is null");
        AppMethodBeat.o(4144);
    }

    public static boolean canOpenWebPlus(Context context) {
        AppMethodBeat.i(4145);
        if (AQV != null) {
            boolean canOpenWebPlus = AQV.canOpenWebPlus(context);
            AppMethodBeat.o(4145);
            return canOpenWebPlus;
        }
        Log.e("TbsDownloader", "canOpenWebPlus: sImp is null");
        AppMethodBeat.o(4145);
        return false;
    }

    public static void closeFileReader(Context context) {
        AppMethodBeat.i(4146);
        if (AQV != null) {
            AQV.closeFileReader(context);
            AppMethodBeat.o(4146);
            return;
        }
        Log.e("TbsDownloader", "closeFileReader: sImp is null");
        AppMethodBeat.o(4146);
    }

    public static void forceSysWebView() {
        AppMethodBeat.i(4147);
        AQW = true;
        if (AQV != null) {
            AQV.forceSysWebView();
            AppMethodBeat.o(4147);
            return;
        }
        Log.e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.o(4147);
    }

    public static void setUploadCode(Context context, int i) {
        AppMethodBeat.i(4148);
        if (AQV != null) {
            AQV.setUploadCode(context, i);
            AppMethodBeat.o(4148);
            return;
        }
        Log.e("TbsDownloader", "forceSysWebView: sImp is null");
        AppMethodBeat.o(4148);
    }
}
