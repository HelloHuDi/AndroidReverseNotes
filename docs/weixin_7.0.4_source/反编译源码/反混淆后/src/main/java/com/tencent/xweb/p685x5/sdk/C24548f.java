package com.tencent.xweb.p685x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C46838x;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.sdk.f */
public final class C24548f {
    static C24543b AQZ;

    /* renamed from: com.tencent.xweb.x5.sdk.f$a */
    public interface C24549a {
        void onNeedDownloadFinish(boolean z, int i);
    }

    static {
        AppMethodBeat.m2504i(4158);
        C46838x.initInterface();
        AppMethodBeat.m2505o(4158);
    }

    /* renamed from: a */
    public static void m38204a(C24543b c24543b) {
        AQZ = c24543b;
    }

    /* renamed from: jA */
    public static boolean m38206jA(Context context) {
        AppMethodBeat.m2504i(4150);
        if (AQZ != null) {
            boolean jA = AQZ.mo41290jA(context);
            AppMethodBeat.m2505o(4150);
            return jA;
        }
        Log.m81046e("TbsDownloader", "needSendRequest: sImp is null");
        AppMethodBeat.m2505o(4150);
        return false;
    }

    public static boolean needDownload(Context context, boolean z) {
        AppMethodBeat.m2504i(4151);
        boolean a = C24548f.m38205a(context, z, false, null);
        AppMethodBeat.m2505o(4151);
        return a;
    }

    /* renamed from: a */
    public static boolean m38205a(Context context, boolean z, boolean z2, C24549a c24549a) {
        AppMethodBeat.m2504i(4152);
        if (AQZ != null) {
            boolean a = AQZ.mo41287a(context, z, z2, c24549a);
            AppMethodBeat.m2505o(4152);
            return a;
        }
        Log.m81046e("TbsDownloader", "needDownload: sImp is null");
        AppMethodBeat.m2505o(4152);
        return false;
    }

    public static void startDownload(Context context) {
        AppMethodBeat.m2504i(4153);
        C24548f.startDownload(context, false);
        AppMethodBeat.m2505o(4153);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (C24548f.class) {
            AppMethodBeat.m2504i(4154);
            if (AQZ != null) {
                AQZ.startDownload(context, z);
                AppMethodBeat.m2505o(4154);
            } else {
                Log.m81046e("TbsDownloader", "startDownload: sImp is null");
                AppMethodBeat.m2505o(4154);
            }
        }
    }

    public static void stopDownload() {
        AppMethodBeat.m2504i(4155);
        if (AQZ != null) {
            AQZ.stopDownload();
            AppMethodBeat.m2505o(4155);
            return;
        }
        Log.m81046e("TbsDownloader", "stopDownload: sImp is null");
        AppMethodBeat.m2505o(4155);
    }

    public static synchronized boolean isDownloading() {
        boolean isDownloading;
        synchronized (C24548f.class) {
            AppMethodBeat.m2504i(4156);
            if (AQZ != null) {
                isDownloading = AQZ.isDownloading();
                AppMethodBeat.m2505o(4156);
            } else {
                Log.m81046e("TbsDownloader", "isDownloading: sImp is null");
                isDownloading = false;
                AppMethodBeat.m2505o(4156);
            }
        }
        return isDownloading;
    }

    public static boolean isDownloadForeground() {
        AppMethodBeat.m2504i(4157);
        if (AQZ != null) {
            boolean isDownloadForeground = AQZ.isDownloadForeground();
            AppMethodBeat.m2505o(4157);
            return isDownloadForeground;
        }
        Log.m81046e("TbsDownloader", "isDownloadForeground: sImp is null");
        AppMethodBeat.m2505o(4157);
        return false;
    }
}
