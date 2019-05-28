package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ytcommon.auth.HttpUtil.HttpResponseListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Auth {
    private static final String DAT_SUFFIX = "SDK.dat";
    private static final String LICENCE_SUFFIX = "SDK.licence";
    private static final String SDK_NAME = "YoutuFaceTrack";
    private static final String SDK_PREFIX = "YT";
    private static final String TAG = "log_print_java";
    private static long handle = 0;
    private static boolean isReportStarted = false;
    private static String licenceStr = "";
    private static HttpResponseListener mListener = new C311723();
    private static Timer timerFlush;
    private static Timer timerReport;
    private long nativePtr;

    /* renamed from: com.tencent.ytcommon.auth.Auth$2 */
    static class C311692 extends TimerTask {
        C311692() {
        }

        public final void run() {
            AppMethodBeat.m2504i(2);
            Log.m38225d(Auth.TAG, "flush in java ");
            Auth.access$100();
            AppMethodBeat.m2505o(2);
        }
    }

    /* renamed from: com.tencent.ytcommon.auth.Auth$1 */
    static class C311711 extends TimerTask {
        C311711() {
        }

        public final void run() {
            AppMethodBeat.m2504i(1);
            String access$000 = Auth.access$000();
            if (access$000 != "") {
                Auth.report(access$000);
            }
            AppMethodBeat.m2505o(1);
        }
    }

    /* renamed from: com.tencent.ytcommon.auth.Auth$3 */
    static class C311723 implements HttpResponseListener {
        C311723() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(3);
            try {
                Log.m38225d(Auth.TAG, "response: ".concat(String.valueOf(str)));
                Log.m38225d(Auth.TAG, "handle: " + Auth.handle);
                Auth.access$300(Auth.handle, str);
                AppMethodBeat.m2505o(3);
            } catch (Exception e) {
                AppMethodBeat.m2505o(3);
            }
        }

        public final void onFail(int i) {
            AppMethodBeat.m2504i(4);
            try {
                Log.m38225d(Auth.TAG, "http request error : ".concat(String.valueOf(i)));
                Log.m38225d(Auth.TAG, "handle: " + Auth.handle);
                Auth.access$300(Auth.handle, null);
                AppMethodBeat.m2505o(4);
            } catch (Exception e) {
                AppMethodBeat.m2505o(4);
            }
        }
    }

    private static native int getCurrentAuthStatus(long j);

    private static native int getIsNeedReport(long j);

    private static native String getReportContent();

    private static native boolean nativeCheck(long j);

    private static native long nativeFlush();

    private static native long nativeInitN(Context context, int i, String str, AssetManager assetManager, String str2);

    private static native int nativePreInitAndCheck(byte[] bArr, int i, String str, String str2, String str3);

    private static native long nativeUpdateFromServer(long j, String str);

    static /* synthetic */ String access$000() {
        AppMethodBeat.m2504i(12);
        String reportContent = getReportContent();
        AppMethodBeat.m2505o(12);
        return reportContent;
    }

    static /* synthetic */ long access$100() {
        AppMethodBeat.m2504i(13);
        long nativeFlush = nativeFlush();
        AppMethodBeat.m2505o(13);
        return nativeFlush;
    }

    static /* synthetic */ long access$300(long j, String str) {
        AppMethodBeat.m2504i(14);
        long nativeUpdateFromServer = nativeUpdateFromServer(j, str);
        AppMethodBeat.m2505o(14);
        return nativeUpdateFromServer;
    }

    static {
        AppMethodBeat.m2504i(15);
        AppMethodBeat.m2505o(15);
    }

    public static int preCheckAndInitWithLicenceStr(Context context, String str) {
        AppMethodBeat.m2504i(6);
        licenceStr = str;
        int i = -1;
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length <= 0) {
                IOException iOException = new IOException("licence error");
                AppMethodBeat.m2505o(6);
                throw iOException;
            }
            String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
            String packageName = context.getPackageName();
            String deviceUid = StatisticsUtils.getDeviceUid(context);
            Log.m38225d(TAG, "Package name: ".concat(String.valueOf(packageName)));
            Log.m38225d(TAG, "Device id: ".concat(String.valueOf(deviceUid)));
            i = nativePreInitAndCheck(bytes, length, packageName, deviceUid, str2);
            AppMethodBeat.m2505o(6);
            return i;
        } catch (IOException e) {
        }
    }

    private static void startTimer() {
        AppMethodBeat.m2504i(7);
        Log.m38225d(TAG, "start timer");
        if (isReportStarted) {
            AppMethodBeat.m2505o(7);
            return;
        }
        C311711 c311711 = new C311711();
        Timer timer = new Timer(true);
        timerReport = timer;
        timer.schedule(c311711, 600000, 600000);
        C311692 c311692 = new C311692();
        timer = new Timer(true);
        timerFlush = timer;
        timer.schedule(c311692, 600000, 600000);
        isReportStarted = true;
        AppMethodBeat.m2505o(7);
    }

    public static int init(Context context, String str, int i, boolean z) {
        AppMethodBeat.m2504i(8);
        Log.m38225d(TAG, "start init");
        String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
        Log.m38225d(TAG, "path: ".concat(String.valueOf(str2)));
        handle = nativeInitN(context, i, str, context.getAssets(), str2);
        Log.m38225d(TAG, "handleinit: " + handle);
        if (getIsNeedReport(handle) == 0) {
            Log.m38225d(TAG, "no need to report");
        } else {
            Log.m38225d(TAG, "need report");
            startTimer();
        }
        int currentAuthStatus = getCurrentAuthStatus(handle);
        AppMethodBeat.m2505o(8);
        return currentAuthStatus;
    }

    public static long getHandle() {
        return handle;
    }

    public static boolean check() {
        AppMethodBeat.m2504i(9);
        boolean nativeCheck = nativeCheck(handle);
        AppMethodBeat.m2505o(9);
        return nativeCheck;
    }

    private static boolean isInMainThread() {
        AppMethodBeat.m2504i(10);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.m2505o(10);
            return true;
        }
        AppMethodBeat.m2505o(10);
        return false;
    }

    public static void report(final String str) {
        AppMethodBeat.m2504i(11);
        if (isInMainThread()) {
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(5);
                    try {
                        HttpUtil.post("https://api.youtu.qq.com/auth/report", str, Auth.mListener);
                        AppMethodBeat.m2505o(5);
                    } catch (IOException e) {
                        AppMethodBeat.m2505o(5);
                    }
                }
            }).start();
            AppMethodBeat.m2505o(11);
            return;
        }
        try {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", str, mListener);
            AppMethodBeat.m2505o(11);
        } catch (IOException e) {
            AppMethodBeat.m2505o(11);
        }
    }
}
