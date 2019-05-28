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
    private static HttpResponseListener mListener = new HttpResponseListener() {
        public final void onSuccess(String str) {
            AppMethodBeat.i(3);
            try {
                Log.d(Auth.TAG, "response: ".concat(String.valueOf(str)));
                Log.d(Auth.TAG, "handle: " + Auth.handle);
                Auth.access$300(Auth.handle, str);
                AppMethodBeat.o(3);
            } catch (Exception e) {
                AppMethodBeat.o(3);
            }
        }

        public final void onFail(int i) {
            AppMethodBeat.i(4);
            try {
                Log.d(Auth.TAG, "http request error : ".concat(String.valueOf(i)));
                Log.d(Auth.TAG, "handle: " + Auth.handle);
                Auth.access$300(Auth.handle, null);
                AppMethodBeat.o(4);
            } catch (Exception e) {
                AppMethodBeat.o(4);
            }
        }
    };
    private static Timer timerFlush;
    private static Timer timerReport;
    private long nativePtr;

    private static native int getCurrentAuthStatus(long j);

    private static native int getIsNeedReport(long j);

    private static native String getReportContent();

    private static native boolean nativeCheck(long j);

    private static native long nativeFlush();

    private static native long nativeInitN(Context context, int i, String str, AssetManager assetManager, String str2);

    private static native int nativePreInitAndCheck(byte[] bArr, int i, String str, String str2, String str3);

    private static native long nativeUpdateFromServer(long j, String str);

    static /* synthetic */ String access$000() {
        AppMethodBeat.i(12);
        String reportContent = getReportContent();
        AppMethodBeat.o(12);
        return reportContent;
    }

    static /* synthetic */ long access$100() {
        AppMethodBeat.i(13);
        long nativeFlush = nativeFlush();
        AppMethodBeat.o(13);
        return nativeFlush;
    }

    static /* synthetic */ long access$300(long j, String str) {
        AppMethodBeat.i(14);
        long nativeUpdateFromServer = nativeUpdateFromServer(j, str);
        AppMethodBeat.o(14);
        return nativeUpdateFromServer;
    }

    static {
        AppMethodBeat.i(15);
        AppMethodBeat.o(15);
    }

    public static int preCheckAndInitWithLicenceStr(Context context, String str) {
        AppMethodBeat.i(6);
        licenceStr = str;
        int i = -1;
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length <= 0) {
                IOException iOException = new IOException("licence error");
                AppMethodBeat.o(6);
                throw iOException;
            }
            String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
            String packageName = context.getPackageName();
            String deviceUid = StatisticsUtils.getDeviceUid(context);
            Log.d(TAG, "Package name: ".concat(String.valueOf(packageName)));
            Log.d(TAG, "Device id: ".concat(String.valueOf(deviceUid)));
            i = nativePreInitAndCheck(bytes, length, packageName, deviceUid, str2);
            AppMethodBeat.o(6);
            return i;
        } catch (IOException e) {
        }
    }

    private static void startTimer() {
        AppMethodBeat.i(7);
        Log.d(TAG, "start timer");
        if (isReportStarted) {
            AppMethodBeat.o(7);
            return;
        }
        AnonymousClass1 anonymousClass1 = new TimerTask() {
            public final void run() {
                AppMethodBeat.i(1);
                String access$000 = Auth.access$000();
                if (access$000 != "") {
                    Auth.report(access$000);
                }
                AppMethodBeat.o(1);
            }
        };
        Timer timer = new Timer(true);
        timerReport = timer;
        timer.schedule(anonymousClass1, 600000, 600000);
        AnonymousClass2 anonymousClass2 = new TimerTask() {
            public final void run() {
                AppMethodBeat.i(2);
                Log.d(Auth.TAG, "flush in java ");
                Auth.access$100();
                AppMethodBeat.o(2);
            }
        };
        timer = new Timer(true);
        timerFlush = timer;
        timer.schedule(anonymousClass2, 600000, 600000);
        isReportStarted = true;
        AppMethodBeat.o(7);
    }

    public static int init(Context context, String str, int i, boolean z) {
        AppMethodBeat.i(8);
        Log.d(TAG, "start init");
        String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
        Log.d(TAG, "path: ".concat(String.valueOf(str2)));
        handle = nativeInitN(context, i, str, context.getAssets(), str2);
        Log.d(TAG, "handleinit: " + handle);
        if (getIsNeedReport(handle) == 0) {
            Log.d(TAG, "no need to report");
        } else {
            Log.d(TAG, "need report");
            startTimer();
        }
        int currentAuthStatus = getCurrentAuthStatus(handle);
        AppMethodBeat.o(8);
        return currentAuthStatus;
    }

    public static long getHandle() {
        return handle;
    }

    public static boolean check() {
        AppMethodBeat.i(9);
        boolean nativeCheck = nativeCheck(handle);
        AppMethodBeat.o(9);
        return nativeCheck;
    }

    private static boolean isInMainThread() {
        AppMethodBeat.i(10);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(10);
            return true;
        }
        AppMethodBeat.o(10);
        return false;
    }

    public static void report(final String str) {
        AppMethodBeat.i(11);
        if (isInMainThread()) {
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(5);
                    try {
                        HttpUtil.post("https://api.youtu.qq.com/auth/report", str, Auth.mListener);
                        AppMethodBeat.o(5);
                    } catch (IOException e) {
                        AppMethodBeat.o(5);
                    }
                }
            }).start();
            AppMethodBeat.o(11);
            return;
        }
        try {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", str, mListener);
            AppMethodBeat.o(11);
        } catch (IOException e) {
            AppMethodBeat.o(11);
        }
    }
}
