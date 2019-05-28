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
    private static HttpResponseListener mListener = new C411433();
    private static Timer timerFlush;
    private static Timer timerReport;
    private long nativePtr;

    /* renamed from: com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface$1 */
    static class C60791 extends TimerTask {
        C60791() {
        }

        public final void run() {
            AppMethodBeat.m2504i(118063);
            String access$000 = YTAuthJNIInterface.access$000();
            if (access$000 != "") {
                YTAuthJNIInterface.report(access$000);
            }
            AppMethodBeat.m2505o(118063);
        }
    }

    /* renamed from: com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface$3 */
    static class C411433 implements HttpResponseListener {
        C411433() {
        }

        public final void onSuccess(String str) {
            AppMethodBeat.m2504i(118065);
            try {
                YTLogger.m50244d(YTAuthJNIInterface.TAG, "response: ".concat(String.valueOf(str)));
                YTLogger.m50244d(YTAuthJNIInterface.TAG, "handle: " + YTAuthJNIInterface.handle);
                YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, str);
                AppMethodBeat.m2505o(118065);
            } catch (Exception e) {
                AppMethodBeat.m2505o(118065);
            }
        }

        public final void onFail(int i) {
            AppMethodBeat.m2504i(118066);
            try {
                YTLogger.m50244d(YTAuthJNIInterface.TAG, "http request error : ".concat(String.valueOf(i)));
                YTLogger.m50244d(YTAuthJNIInterface.TAG, "handle: " + YTAuthJNIInterface.handle);
                YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, null);
                AppMethodBeat.m2505o(118066);
            } catch (Exception e) {
                AppMethodBeat.m2505o(118066);
            }
        }
    }

    /* renamed from: com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface$2 */
    static class C468392 extends TimerTask {
        C468392() {
        }

        public final void run() {
            AppMethodBeat.m2504i(118064);
            YTLogger.m50244d(YTAuthJNIInterface.TAG, "flush in java ");
            YTAuthJNIInterface.access$100();
            AppMethodBeat.m2505o(118064);
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
        AppMethodBeat.m2504i(118074);
        String reportContent = getReportContent();
        AppMethodBeat.m2505o(118074);
        return reportContent;
    }

    static /* synthetic */ long access$100() {
        AppMethodBeat.m2504i(118075);
        long nativeFlush = nativeFlush();
        AppMethodBeat.m2505o(118075);
        return nativeFlush;
    }

    static /* synthetic */ long access$300(long j, String str) {
        AppMethodBeat.m2504i(118076);
        long nativeUpdateFromServer = nativeUpdateFromServer(j, str);
        AppMethodBeat.m2505o(118076);
        return nativeUpdateFromServer;
    }

    static {
        AppMethodBeat.m2504i(118077);
        AppMethodBeat.m2505o(118077);
    }

    public static int preCheckAndInitWithLicenceStr(Context context, String str) {
        AppMethodBeat.m2504i(118068);
        licenceStr = str;
        int i = -1;
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length <= 0) {
                IOException iOException = new IOException("licence error");
                AppMethodBeat.m2505o(118068);
                throw iOException;
            }
            String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
            String packageName = context.getPackageName();
            String deviceUid = StatisticsUtils.getDeviceUid(context);
            YTLogger.m50244d(TAG, "Package name: ".concat(String.valueOf(packageName)));
            YTLogger.m50244d(TAG, "Device id: ".concat(String.valueOf(deviceUid)));
            i = nativePreInitAndCheck(bytes, length, packageName, deviceUid, str2);
            AppMethodBeat.m2505o(118068);
            return i;
        } catch (IOException e) {
        }
    }

    private static void startTimer() {
        AppMethodBeat.m2504i(118069);
        YTLogger.m50244d(TAG, "start timer");
        if (isReportStarted) {
            AppMethodBeat.m2505o(118069);
            return;
        }
        C60791 c60791 = new C60791();
        Timer timer = new Timer(true);
        timerReport = timer;
        timer.schedule(c60791, 600000, 600000);
        C468392 c468392 = new C468392();
        timer = new Timer(true);
        timerFlush = timer;
        timer.schedule(c468392, 600000, 600000);
        isReportStarted = true;
        AppMethodBeat.m2505o(118069);
    }

    public static int init(Context context, String str, int i, boolean z) {
        AppMethodBeat.m2504i(118070);
        YTLogger.m50244d(TAG, "start init");
        String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
        YTLogger.m50244d(TAG, "path: ".concat(String.valueOf(str2)));
        handle = nativeInitN(context, i, str, context.getAssets(), str2);
        YTLogger.m50244d(TAG, "handleinit: " + handle);
        if (getIsNeedReport(handle) == 0) {
            YTLogger.m50244d(TAG, "no need to report");
        } else {
            YTLogger.m50244d(TAG, "need report");
            startTimer();
        }
        int currentAuthStatus = getCurrentAuthStatus(handle);
        AppMethodBeat.m2505o(118070);
        return currentAuthStatus;
    }

    public static long getHandle() {
        return handle;
    }

    public static boolean check() {
        AppMethodBeat.m2504i(118071);
        boolean nativeCheck = nativeCheck(handle);
        YTLogger.m50244d(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "--------------check");
        AppMethodBeat.m2505o(118071);
        return nativeCheck;
    }

    private static boolean isInMainThread() {
        AppMethodBeat.m2504i(118072);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.m2505o(118072);
            return true;
        }
        AppMethodBeat.m2505o(118072);
        return false;
    }

    public static void report(final String str) {
        AppMethodBeat.m2504i(118073);
        if (isInMainThread()) {
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(118067);
                    try {
                        HttpUtil.post("https://api.youtu.qq.com/auth/report", str, YTAuthJNIInterface.mListener);
                        AppMethodBeat.m2505o(118067);
                    } catch (IOException e) {
                        AppMethodBeat.m2505o(118067);
                    }
                }
            }).start();
            AppMethodBeat.m2505o(118073);
            return;
        }
        try {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", str, mListener);
            AppMethodBeat.m2505o(118073);
        } catch (IOException e) {
            AppMethodBeat.m2505o(118073);
        }
    }
}
