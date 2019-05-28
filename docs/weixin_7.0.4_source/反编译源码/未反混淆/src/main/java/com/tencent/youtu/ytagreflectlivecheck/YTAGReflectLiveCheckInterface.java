package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class YTAGReflectLiveCheckInterface {
    private static final String TAG = "YoutuLightLiveCheck";
    public static final String VERSION = "3.1.0";
    private static LightLiveCheckResult mCheckResult;
    private static boolean mInitModel = false;
    public static YTReflectLayout mReflectLayout;
    public static RGBConfigRequester mRgbConfigRequester;
    public static UploadVideoRequester mUploadVideoRequester;
    private static boolean mUserCanceled = false;

    public interface LightLiveCheckResult {
        public static final int AUTH_FAILED = 1;
        public static final int FINISH_ERRORBASE = 300;
        public static final int INIT_ERRORBASE = 100;
        public static final int NOT_INIT_MODEL = 2;
        public static final int REFLECT_ERRORBASE = 200;
        public static final int SUCCESS = 0;
        public static final int USER_CANCEL = 3;

        void onFailed(int i, String str, String str2);

        void onSuccess(boolean z, LightDiffResponse lightDiffResponse);
    }

    public interface LightLiveProcessState {
        public static final int GET_RGBCONFIG = 1;
        public static final int HANGUP = 0;
        public static final int REFLECTING = 2;
        public static final int UPLOAD = 3;
    }

    public static int initModel(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(123135);
        try {
            YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.initModel] ---");
            if (mInitModel) {
                YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.initModel] has already inited.");
                AppMethodBeat.o(123135);
                return 0;
            }
            boolean FRInitFaceSDK = YTAGReflectLiveCheckJNIInterface.FRInitFaceSDK(bArr, bArr2);
            YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.initModel] -=-=-=-=reflect init");
            if (FRInitFaceSDK) {
                mInitModel = true;
                ProcessManager.initAll();
                AppMethodBeat.o(123135);
                return 0;
            }
            AppMethodBeat.o(123135);
            return 1;
        } catch (Exception e) {
            YTLogger.w(TAG, "initModel failed. message: " + e.getMessage());
            YTException.report(e);
            AppMethodBeat.o(123135);
            return 10;
        }
    }

    public static void releaseModel() {
        AppMethodBeat.i(123136);
        if (ProcessManager.mProcessState != 0) {
            YTLogger.w(TAG, "[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: " + ProcessManager.mProcessState);
            YTException.report(new Exception("\"[YTAGReflectLiveCheckInterface.releaseModel] release model be called when processing. processState: \" + ProcessManager.mProcessState"));
        }
        ProcessManager.clearAll();
        if (mInitModel) {
            YTAGReflectLiveCheckJNIInterface.FRReleaseFaceSDK();
            YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.initModel] -=-=-=-=reflect releae");
            mInitModel = false;
        }
        AppMethodBeat.o(123136);
    }

    public static void setRGBConfigRequest(RGBConfigRequester rGBConfigRequester) {
        AppMethodBeat.i(123137);
        YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.setRGBConfigRequest] ---");
        mRgbConfigRequester = rGBConfigRequester;
        AppMethodBeat.o(123137);
    }

    public static void setUploadVideoRequester(UploadVideoRequester uploadVideoRequester) {
        AppMethodBeat.i(123138);
        YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.setUploadVideoRequester] ---");
        mUploadVideoRequester = uploadVideoRequester;
        AppMethodBeat.o(123138);
    }

    public static void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(123139);
        if (ProcessManager.cameraWorker() != null) {
            ProcessManager.cameraWorker().onPreviewFrame(bArr, camera);
        }
        AppMethodBeat.o(123139);
    }

    public static void start(Context context, Camera camera, int i, YTReflectLayout yTReflectLayout, LightLiveCheckResult lightLiveCheckResult) {
        AppMethodBeat.i(123140);
        YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.start] ---");
        mCheckResult = lightLiveCheckResult;
        mReflectLayout = yTReflectLayout;
        ProcessManager.dataWorker().mCameraRotate = CameraSetting.getVideoRotate(context, i);
        mUserCanceled = false;
        if (!YTCommonExInterface.isAuthSuccess()) {
            noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTCommonExInterface.initAuth() before.");
            AppMethodBeat.o(123140);
        } else if (mInitModel) {
            ProcessManager.cameraWorker().setCamera(camera);
            ProcessManager.start();
            AppMethodBeat.o(123140);
        } else {
            noticeFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
            AppMethodBeat.o(123140);
        }
    }

    public static void cancel() {
        AppMethodBeat.i(123141);
        YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.cancel] ---");
        ProcessManager.cancel();
        noticeFailed(3, "user canceled", "YTAGReflectLiveCheckInterface.cancel() be called.");
        mUserCanceled = true;
        AppMethodBeat.o(123141);
    }

    public static int getProcessState() {
        return ProcessManager.mProcessState;
    }

    public static void noticeSuccess(final boolean z, final LightDiffResponse lightDiffResponse) {
        AppMethodBeat.i(123142);
        YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.noticeSuccess] ---isAlive: ".concat(String.valueOf(z)));
        if (mUserCanceled) {
            YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice success");
            AppMethodBeat.o(123142);
            return;
        }
        if (mInitModel) {
            ProcessManager.dataWorker().cleanup();
            ProcessManager.cameraWorker().cleanup();
        } else {
            YTLogger.w(TAG, "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice success");
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mCheckResult.onSuccess(z, lightDiffResponse);
            mCheckResult = null;
            AppMethodBeat.o(123142);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123133);
                YTAGReflectLiveCheckInterface.mCheckResult.onSuccess(z, lightDiffResponse);
                YTAGReflectLiveCheckInterface.mCheckResult = null;
                AppMethodBeat.o(123133);
            }
        });
        AppMethodBeat.o(123142);
    }

    public static void noticeFailed(final int i, final String str, final String str2) {
        AppMethodBeat.i(123143);
        YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.noticeFailed] resultCode: " + i + " \r\nmessage: " + str + " \r\ntips: " + str2);
        if (mUserCanceled) {
            YTLogger.i(TAG, "[YTAGReflectLiveCheckInterface.noticeSuccess] user canceled before notice failed");
            AppMethodBeat.o(123143);
            return;
        }
        if (mInitModel) {
            ProcessManager.dataWorker().cleanup();
            ProcessManager.cameraWorker().cleanup();
        } else {
            YTLogger.w(TAG, "[YTAGReflectLiveCheckInterface.noticeSuccess] releaseModel be called before notice failed");
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            mCheckResult.onFailed(i, str, str2);
            mCheckResult = null;
            AppMethodBeat.o(123143);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123134);
                YTAGReflectLiveCheckInterface.mCheckResult.onFailed(i, str, str2);
                YTAGReflectLiveCheckInterface.mCheckResult = null;
                AppMethodBeat.o(123134);
            }
        });
        AppMethodBeat.o(123143);
    }
}
