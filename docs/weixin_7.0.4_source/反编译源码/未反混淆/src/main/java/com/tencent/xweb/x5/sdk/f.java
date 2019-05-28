package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x;
import org.xwalk.core.Log;

public final class f {
    static b AQZ;

    public interface a {
        void onNeedDownloadFinish(boolean z, int i);
    }

    static {
        AppMethodBeat.i(4158);
        x.initInterface();
        AppMethodBeat.o(4158);
    }

    public static void a(b bVar) {
        AQZ = bVar;
    }

    public static boolean jA(Context context) {
        AppMethodBeat.i(4150);
        if (AQZ != null) {
            boolean jA = AQZ.jA(context);
            AppMethodBeat.o(4150);
            return jA;
        }
        Log.e("TbsDownloader", "needSendRequest: sImp is null");
        AppMethodBeat.o(4150);
        return false;
    }

    public static boolean needDownload(Context context, boolean z) {
        AppMethodBeat.i(4151);
        boolean a = a(context, z, false, null);
        AppMethodBeat.o(4151);
        return a;
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        AppMethodBeat.i(4152);
        if (AQZ != null) {
            boolean a = AQZ.a(context, z, z2, aVar);
            AppMethodBeat.o(4152);
            return a;
        }
        Log.e("TbsDownloader", "needDownload: sImp is null");
        AppMethodBeat.o(4152);
        return false;
    }

    public static void startDownload(Context context) {
        AppMethodBeat.i(4153);
        startDownload(context, false);
        AppMethodBeat.o(4153);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (f.class) {
            AppMethodBeat.i(4154);
            if (AQZ != null) {
                AQZ.startDownload(context, z);
                AppMethodBeat.o(4154);
            } else {
                Log.e("TbsDownloader", "startDownload: sImp is null");
                AppMethodBeat.o(4154);
            }
        }
    }

    public static void stopDownload() {
        AppMethodBeat.i(4155);
        if (AQZ != null) {
            AQZ.stopDownload();
            AppMethodBeat.o(4155);
            return;
        }
        Log.e("TbsDownloader", "stopDownload: sImp is null");
        AppMethodBeat.o(4155);
    }

    public static synchronized boolean isDownloading() {
        boolean isDownloading;
        synchronized (f.class) {
            AppMethodBeat.i(4156);
            if (AQZ != null) {
                isDownloading = AQZ.isDownloading();
                AppMethodBeat.o(4156);
            } else {
                Log.e("TbsDownloader", "isDownloading: sImp is null");
                isDownloading = false;
                AppMethodBeat.o(4156);
            }
        }
        return isDownloading;
    }

    public static boolean isDownloadForeground() {
        AppMethodBeat.i(4157);
        if (AQZ != null) {
            boolean isDownloadForeground = AQZ.isDownloadForeground();
            AppMethodBeat.o(4157);
            return isDownloadForeground;
        }
        Log.e("TbsDownloader", "isDownloadForeground: sImp is null");
        AppMethodBeat.o(4157);
        return false;
    }
}
