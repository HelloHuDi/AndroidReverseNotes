package com.tencent.youtu.ytposedetect;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;
import com.tencent.youtu.ytposedetect.manager.PoseDetectProcessManager;

public class YTPoseDetectInterface {
    private static final String TAG = "YoutuFaceDetect";
    public static final String VERSION = "3.0.2";
    private static PoseDetectResult mCheckResult;
    private static boolean mInitModel = false;
    public static int mModelRetainCount = 0;
    private static PoseDetectProcessManager mPoseDetectProcessManager;

    public interface PoseDetectLiveType {
        public static final int LIVETYPE_BLINK_EYE = 1;
        public static final int LIVETYPE_OPEN_MOUSE = 2;
        public static final int LIVETYPE_SHAKE_HEAD = 0;
    }

    public interface PoseDetectOnFrame {
        public static final int DETECT_AUTH_FAILED = 1;
        public static final int DETECT_NOT_INIT_MODEL = 2;
        public static final int DETECT_SUCCESS = 0;

        void onFailed(int i, String str, String str2);

        void onRecordingDone(byte[][] bArr, int i, int i2);

        void onSuccess(int i);
    }

    public interface PoseDetectGetBestImage {
        void onGetBestImage(byte[] bArr, int i, int i2);
    }

    public interface PoseDetectResult {
        public static final int ERROR_AUTH_FAILED = 1;
        public static final int ERROR_NOT_INIT_MODEL = 2;
        public static final int SUCCESS = 0;

        void onFailed(int i, String str, String str2);

        void onSuccess();
    }

    /* renamed from: com.tencent.youtu.ytposedetect.YTPoseDetectInterface$1 */
    static class C164341 implements PoseDetectResult {
        C164341() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(117767);
            YTPoseDetectInterface.access$000();
            AppMethodBeat.m2505o(117767);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(117768);
            YTPoseDetectInterface.access$100(i, str, str2);
            AppMethodBeat.m2505o(117768);
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(117779);
        noticeSuccess();
        AppMethodBeat.m2505o(117779);
    }

    static /* synthetic */ void access$100(int i, String str, String str2) {
        AppMethodBeat.m2504i(117780);
        noticeFailed(i, str, str2);
        AppMethodBeat.m2505o(117780);
    }

    public static int initModel(String str) {
        AppMethodBeat.m2504i(117769);
        try {
            YTLogger.m50246i(TAG, "[YTFacePreviewInterface.initModel] ---");
            if (mInitModel) {
                YTLogger.m50246i(TAG, "[YTFacePreviewInterface.initModel] has already inited.");
                AppMethodBeat.m2505o(117769);
                return 0;
            }
            int initModel = YTPoseDetectJNIInterface.initModel(str);
            if (initModel == 0) {
                PoseDetectProcessManager poseDetectProcessManager = new PoseDetectProcessManager();
                mPoseDetectProcessManager = poseDetectProcessManager;
                poseDetectProcessManager.initAll();
                mInitModel = true;
                AppMethodBeat.m2505o(117769);
                return 0;
            }
            AppMethodBeat.m2505o(117769);
            return initModel;
        } catch (Exception e) {
            YTLogger.m50248w(TAG, "initModel failed. message: " + e.getMessage());
            YTException.report(e);
            AppMethodBeat.m2505o(117769);
            return 10;
        }
    }

    public static void releaseModel() {
        AppMethodBeat.m2504i(117770);
        YTLogger.m50246i(TAG, "[YTFacePreviewInterface.finalize] ---");
        if (mInitModel) {
            mPoseDetectProcessManager.clearAll();
            YTPoseDetectJNIInterface.releaseAll();
            mInitModel = false;
        }
        AppMethodBeat.m2505o(117770);
    }

    public static void poseDetect(float[] fArr, int i, byte[] bArr, Camera camera, float f, float f2, float f3, PoseDetectOnFrame poseDetectOnFrame) {
        AppMethodBeat.m2504i(117771);
        if (!YTCommonExInterface.isAuthSuccess()) {
            poseDetectOnFrame.onFailed(1, "Auth check failed on poseDetect.", "1. Check your lisence. 2. Call YTPoseDetectInterface.initAuth() before.");
            AppMethodBeat.m2505o(117771);
        } else if (mInitModel) {
            poseDetectOnFrame.onSuccess(mPoseDetectProcessManager.poseDetect(fArr, i, bArr, f, f2, f3));
            if (YTPoseDetectJNIInterface.isRecordingDone()) {
                byte[][] frameList = YTPoseDetectJNIInterface.getFrameList();
                YTLogger.m50246i(TAG, "[YTPoseDetectInterface.poseDetect] list num: " + frameList.length);
                poseDetectOnFrame.onRecordingDone(frameList, mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
            }
            AppMethodBeat.m2505o(117771);
        } else {
            poseDetectOnFrame.onFailed(2, "Not init model on poseDetect.", "Call YTPoseDetectInterface.initModel() before.");
            AppMethodBeat.m2505o(117771);
        }
    }

    public static void getBestImage(PoseDetectGetBestImage poseDetectGetBestImage) {
        AppMethodBeat.m2504i(117772);
        poseDetectGetBestImage.onGetBestImage(YTPoseDetectJNIInterface.getBestImage(), mPoseDetectProcessManager.mDesiredPreviewWidth, mPoseDetectProcessManager.mDesiredPreviewHeight);
        AppMethodBeat.m2505o(117772);
    }

    public static void start(Context context, Camera camera, int i, PoseDetectResult poseDetectResult) {
        AppMethodBeat.m2504i(117773);
        YTLogger.m50246i(TAG, "[YTPoseDetectInterface.start] ---");
        if (!YTCommonExInterface.isAuthSuccess()) {
            noticeFailed(1, "Auth check failed.", "1. Check your lisence. 2. Call YTPoseDetectInterface.initAuth() before.");
            AppMethodBeat.m2505o(117773);
        } else if (mInitModel) {
            mCheckResult = poseDetectResult;
            mPoseDetectProcessManager.start(context, camera, i, new C164341());
            AppMethodBeat.m2505o(117773);
        } else {
            noticeFailed(2, "Not init model.", "Call YTPoseDetectInterface.initModel() before.");
            AppMethodBeat.m2505o(117773);
        }
    }

    public static void stop() {
        AppMethodBeat.m2504i(117774);
        YTLogger.m50246i(TAG, "[YTPoseDetectInterface.stop] ---");
        if (mPoseDetectProcessManager != null) {
            mPoseDetectProcessManager.stop();
        }
        AppMethodBeat.m2505o(117774);
    }

    public static void setFrameNum(int i) {
        AppMethodBeat.m2504i(117775);
        YTPoseDetectJNIInterface.setFrameNum(i);
        AppMethodBeat.m2505o(117775);
    }

    public static int getFrameNum() {
        AppMethodBeat.m2504i(117776);
        int frameNum = YTPoseDetectJNIInterface.getFrameNum();
        AppMethodBeat.m2505o(117776);
        return frameNum;
    }

    public static boolean isDetecting() {
        return mPoseDetectProcessManager != null && mPoseDetectProcessManager.mIsDetecting;
    }

    private static void noticeSuccess() {
        AppMethodBeat.m2504i(117777);
        YTLogger.m50246i(TAG, "[YTPoseDetectInterface.noticeSuccess] ---");
        mCheckResult.onSuccess();
        mCheckResult = null;
        AppMethodBeat.m2505o(117777);
    }

    private static void noticeFailed(int i, String str, String str2) {
        AppMethodBeat.m2504i(117778);
        YTLogger.m50246i(TAG, "[YTPoseDetectInterface.noticeFailed] resultCode: " + i + " \r\nmessage: " + str + " \r\ntips: " + str2);
        mPoseDetectProcessManager.restoreCamera();
        mCheckResult.onFailed(i, str, str2);
        mCheckResult = null;
        AppMethodBeat.m2505o(117778);
    }
}
