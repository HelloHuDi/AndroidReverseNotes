package com.tencent.youtu.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.auth.HttpUtil.HttpResponseListener;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class YTAuthJNIInterface {
    private static final String DAT_SUFFIX = "SDK.dat";
    private static final String LICENCE_SUFFIX = "SDK.licence";
    private static final String SDK_NAME = "YoutuFaceTrack";
    private static final String SDK_PREFIX = "YT";
    private static final String TAG = "log_print_java";
    private static String VERSION = "1.2";
    private static long handle = 0;
    private static boolean isReportStarted = false;
    private static String licenceStr = "";
    private static HttpResponseListener mListener = new HttpResponseListener() {
        public final void onSuccess(String str) {
            AppMethodBeat.i(118065);
            try {
                YTLogger.d(YTAuthJNIInterface.TAG, "response: ".concat(String.valueOf(str)));
                YTLogger.d(YTAuthJNIInterface.TAG, "handle: " + YTAuthJNIInterface.handle);
                YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, str);
                AppMethodBeat.o(118065);
            } catch (Exception e) {
                AppMethodBeat.o(118065);
            }
        }

        public final void onFail(int i) {
            AppMethodBeat.i(118066);
            try {
                YTLogger.d(YTAuthJNIInterface.TAG, "http request error : ".concat(String.valueOf(i)));
                YTLogger.d(YTAuthJNIInterface.TAG, "handle: " + YTAuthJNIInterface.handle);
                YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, null);
                AppMethodBeat.o(118066);
            } catch (Exception e) {
                AppMethodBeat.o(118066);
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
        AppMethodBeat.i(118074);
        String reportContent = getReportContent();
        AppMethodBeat.o(118074);
        return reportContent;
    }

    static /* synthetic */ long access$100() {
        AppMethodBeat.i(118075);
        long nativeFlush = nativeFlush();
        AppMethodBeat.o(118075);
        return nativeFlush;
    }

    static /* synthetic */ long access$300(long j, String str) {
        AppMethodBeat.i(118076);
        long nativeUpdateFromServer = nativeUpdateFromServer(j, str);
        AppMethodBeat.o(118076);
        return nativeUpdateFromServer;
    }

    static {
        AppMethodBeat.i(118077);
        AppMethodBeat.o(118077);
    }

    public static int preCheckAndInitWithLicenceStr(Context context, String str) {
        AppMethodBeat.i(118068);
        licenceStr = str;
        int i = -1;
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length <= 0) {
                IOException iOException = new IOException("licence error");
                AppMethodBeat.o(118068);
                throw iOException;
            }
            String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
            String packageName = context.getPackageName();
            String deviceUid = StatisticsUtils.getDeviceUid(context);
            YTLogger.d(TAG, "Package name: ".concat(String.valueOf(packageName)));
            YTLogger.d(TAG, "Device id: ".concat(String.valueOf(deviceUid)));
            i = nativePreInitAndCheck(bytes, length, packageName, deviceUid, str2);
            AppMethodBeat.o(118068);
            return i;
        } catch (IOException e) {
        }
    }

    private static void startTimer() {
        AppMethodBeat.i(118069);
        YTLogger.d(TAG, "start timer");
        if (isReportStarted) {
            AppMethodBeat.o(118069);
            return;
        }
        AnonymousClass1 anonymousClass1 = new TimerTask() {
            public final void run() {
                AppMethodBeat.i(118063);
                String access$000 = YTAuthJNIInterface.access$000();
                if (access$000 != "") {
                    YTAuthJNIInterface.report(access$000);
                }
                AppMethodBeat.o(118063);
            }
        };
        Timer timer = new Timer(true);
        timerReport = timer;
        timer.schedule(anonymousClass1, 600000, 600000);
        AnonymousClass2 anonymousClass2 = new TimerTask() {
            public final void run() {
                AppMethodBeat.i(118064);
                YTLogger.d(YTAuthJNIInterface.TAG, "flush in java ");
                YTAuthJNIInterface.access$100();
                AppMethodBeat.o(118064);
            }
        };
        timer = new Timer(true);
        timerFlush = timer;
        timer.schedule(anonymousClass2, 600000, 600000);
        isReportStarted = true;
        AppMethodBeat.o(118069);
    }

    public static int init(Context context, String str, int i, boolean z) {
        AppMethodBeat.i(118070);
        YTLogger.d(TAG, "start init");
        String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
        YTLogger.d(TAG, "path: ".concat(String.valueOf(str2)));
        handle = nativeInitN(context, i, str, context.getAssets(), str2);
        YTLogger.d(TAG, "handleinit: " + handle);
        if (getIsNeedReport(handle) == 0) {
            YTLogger.d(TAG, "no need to report");
        } else {
            YTLogger.d(TAG, "need report");
            startTimer();
        }
        int currentAuthStatus = getCurrentAuthStatus(handle);
        AppMethodBeat.o(118070);
        return currentAuthStatus;
    }

    public static long getHandle() {
        return handle;
    }

    public static boolean check() {
        AppMethodBeat.i(118071);
        boolean nativeCheck = nativeCheck(handle);
        YTLogger.d(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "--------------check");
        AppMethodBeat.o(118071);
        return nativeCheck;
    }

    private static boolean isInMainThread() {
        AppMethodBeat.i(118072);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(118072);
            return true;
        }
        AppMethodBeat.o(118072);
        return false;
    }

    public static void report(final String str) {
        AppMethodBeat.i(118073);
        if (isInMainThread()) {
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(118067);
                    try {
                        HttpUtil.post("https://api.youtu.qq.com/auth/report", str, YTAuthJNIInterface.mListener);
                        AppMethodBeat.o(118067);
                    } catch (IOException e) {
                        AppMethodBeat.o(118067);
                    }
                }
            }).start();
            AppMethodBeat.o(118073);
            return;
        }
        try {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", str, mListener);
            AppMethodBeat.o(118073);
        } catch (IOException e) {
            AppMethodBeat.o(118073);
        }
    }
}
