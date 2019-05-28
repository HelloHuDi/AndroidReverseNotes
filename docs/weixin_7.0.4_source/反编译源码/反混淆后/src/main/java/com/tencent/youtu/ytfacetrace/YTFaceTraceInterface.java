package com.tencent.youtu.ytfacetrace;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytfacetrace.manager.FaceTraceProcessManager;

public class YTFaceTraceInterface {
    private static final String TAG = "YoutuFaceDetect";
    public static final String VERSION = "3.0.1";
    private static FaceDetectResult mCheckResult;
    private static FaceTraceProcessManager mFaceTraceProcessManager;
    private static FaceTraceingNotice mFaceTraceingNotice;
    private static boolean mInitModel = false;
    public static int mModelRetainCount = 0;

    public interface FaceDetectResult {
        public static final int ERROR_AUTH_FAILED = 1;
        public static final int ERROR_NOT_INIT_MODEL = 2;
        public static final int SUCCESS = 0;

        void onFailed(int i, String str, String str2);

        void onSuccess();
    }

    public interface FaceTraceingNotice {
        public static final int PREVIEWING_ONPREVIEW = 1;
        public static final int PREVIEWING_START = 0;
        public static final int PREVIEWING_STOP = 2;

        void onTracing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera);
    }

    /* renamed from: com.tencent.youtu.ytfacetrace.YTFaceTraceInterface$2 */
    static class C164312 implements FaceTraceingNotice {
        C164312() {
        }

        public final void onTracing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
            AppMethodBeat.m2504i(117790);
            YTFaceTraceInterface.access$300(i, faceStatus, rect, bArr, camera);
            AppMethodBeat.m2505o(117790);
        }
    }

    public interface FaceTraceState {
        public static final Rect faceScreenRect = null;
        public static final float pitch = 0.0f;
        public static final float roll = 0.0f;
        public static final float yaw = 0.0f;
    }

    /* renamed from: com.tencent.youtu.ytfacetrace.YTFaceTraceInterface$3 */
    static class C164333 implements Runnable {
        C164333() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117791);
            YTFaceTraceInterface.mCheckResult.onSuccess();
            YTFaceTraceInterface.mCheckResult = null;
            AppMethodBeat.m2505o(117791);
        }
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(117801);
        noticeSuccess();
        AppMethodBeat.m2505o(117801);
    }

    static /* synthetic */ void access$200(int i, String str, String str2) {
        AppMethodBeat.m2504i(117802);
        noticeFailed(i, str, str2);
        AppMethodBeat.m2505o(117802);
    }

    static /* synthetic */ void access$300(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(117803);
        noticePreviewing(i, faceStatus, rect, bArr, camera);
        AppMethodBeat.m2505o(117803);
    }

    public static int initModel(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(117793);
        try {
            YTLogger.m50246i(TAG, "[YTFaceTraceInterface.initModel] ---");
            if (mInitModel) {
                YTLogger.m50246i(TAG, "[YTFaceTraceInterface.initModel] has already inited.");
                AppMethodBeat.m2505o(117793);
                return 0;
            } else if (YTFaceTraceJNIInterface.Init(bArr, bArr2)) {
                FaceTraceProcessManager faceTraceProcessManager = new FaceTraceProcessManager();
                mFaceTraceProcessManager = faceTraceProcessManager;
                faceTraceProcessManager.initAll();
                mInitModel = true;
                AppMethodBeat.m2505o(117793);
                return 0;
            } else {
                AppMethodBeat.m2505o(117793);
                return 1;
            }
        } catch (Exception e) {
            YTLogger.m50248w(TAG, "initModel failed. message: " + e.getMessage());
            YTException.report(e);
            AppMethodBeat.m2505o(117793);
            return 10;
        }
    }

    public static void releaseModel() {
        AppMethodBeat.m2504i(117794);
        YTLogger.m50246i(TAG, "[YTFaceTraceInterface.finalize] ---");
        if (mInitModel) {
            mFaceTraceProcessManager.clearAll();
            YTFaceTraceJNIInterface.Release();
            mInitModel = false;
        }
        AppMethodBeat.m2505o(117794);
    }

    public static void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(117795);
        if (mFaceTraceProcessManager != null) {
            mFaceTraceProcessManager.onPreviewFrame(bArr, camera);
        }
        AppMethodBeat.m2505o(117795);
    }

    public static void start(Context context, Camera camera, int i, FaceDetectResult faceDetectResult, final FaceTraceingNotice faceTraceingNotice) {
        AppMethodBeat.m2504i(117796);
        YTLogger.m50246i(TAG, "[YTFaceTraceInterface.start] ---");
        mCheckResult = faceDetectResult;
        if (!YTCommonExInterface.isAuthSuccess()) {
            noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTFaceTraceInterface.initAuth() before.");
            AppMethodBeat.m2505o(117796);
        } else if (mInitModel) {
            mFaceTraceProcessManager.start(context, camera, i, new FaceDetectResult() {
                public final void onSuccess() {
                    AppMethodBeat.m2504i(117788);
                    YTFaceTraceInterface.mFaceTraceingNotice = faceTraceingNotice;
                    YTFaceTraceInterface.access$100();
                    AppMethodBeat.m2505o(117788);
                }

                public final void onFailed(int i, String str, String str2) {
                    AppMethodBeat.m2504i(117789);
                    YTFaceTraceInterface.access$200(i, str, str2);
                    AppMethodBeat.m2505o(117789);
                }
            }, new C164312());
            AppMethodBeat.m2505o(117796);
        } else {
            noticeFailed(2, "Not init model.", "Call YTFaceTraceInterface.initModel() before.");
            AppMethodBeat.m2505o(117796);
        }
    }

    public static void stop() {
        AppMethodBeat.m2504i(117797);
        YTLogger.m50246i(TAG, "[YTFaceTraceInterface.stop] ---");
        if (mFaceTraceProcessManager != null) {
            mFaceTraceProcessManager.stop();
        }
        AppMethodBeat.m2505o(117797);
    }

    public static boolean isTracing() {
        return mFaceTraceProcessManager != null && mFaceTraceProcessManager.mIsTracing;
    }

    private static void noticeSuccess() {
        AppMethodBeat.m2504i(117798);
        YTLogger.m50246i(TAG, "[YTFaceTraceInterface.noticeSuccess] ---");
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mCheckResult.onSuccess();
            mCheckResult = null;
            AppMethodBeat.m2505o(117798);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new C164333());
        AppMethodBeat.m2505o(117798);
    }

    private static void noticeFailed(final int i, final String str, final String str2) {
        AppMethodBeat.m2504i(117799);
        YTLogger.m50246i(TAG, "[YTFaceTraceInterface.noticeFailed] resultCode: " + i + " \r\nmessage: " + str + " \r\ntips: " + str2);
        if (mFaceTraceProcessManager != null) {
            mFaceTraceProcessManager.restoreCamera();
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mCheckResult.onFailed(i, str, str2);
            mCheckResult = null;
            AppMethodBeat.m2505o(117799);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(117792);
                YTFaceTraceInterface.mCheckResult.onFailed(i, str, str2);
                YTFaceTraceInterface.mCheckResult = null;
                AppMethodBeat.m2505o(117792);
            }
        });
        AppMethodBeat.m2505o(117799);
    }

    private static void noticePreviewing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(117800);
        mFaceTraceingNotice.onTracing(i, faceStatus, rect, bArr, camera);
        AppMethodBeat.m2505o(117800);
    }
}
