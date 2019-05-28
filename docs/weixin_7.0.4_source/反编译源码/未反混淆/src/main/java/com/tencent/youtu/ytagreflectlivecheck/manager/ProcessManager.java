package com.tencent.youtu.ytagreflectlivecheck.manager;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.controller.FinishController;
import com.tencent.youtu.ytagreflectlivecheck.controller.InitController;
import com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.DataWorker;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class ProcessManager {
    private static CameraWorker mCameraWorker;
    private static DataWorker mDataWorker;
    private static FinishController mFinishController;
    private static InitController mInitController;
    public static int mProcessState = 0;
    private static ReflectController mReflectController;
    private static int mRetainCount = 0;
    public static long[] t = new long[10];

    public interface ProcessResult {
        void onFailed(int i, String str, String str2);

        void onSuccess();
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(123193);
        ReflectStart();
        AppMethodBeat.o(123193);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(123194);
        FinishStart();
        AppMethodBeat.o(123194);
    }

    public static void initAll() {
        AppMethodBeat.i(123188);
        mInitController = new InitController();
        mReflectController = new ReflectController();
        mFinishController = new FinishController();
        mDataWorker = new DataWorker();
        mCameraWorker = new CameraWorker();
        mProcessState = 0;
        mRetainCount++;
        AppMethodBeat.o(123188);
    }

    public static void clearAll() {
        int i = mRetainCount - 1;
        mRetainCount = i;
        if (i == 0) {
            mInitController = null;
            mReflectController = null;
            mFinishController = null;
            mDataWorker = null;
            mCameraWorker = null;
            mProcessState = 0;
        }
    }

    public static DataWorker dataWorker() {
        return mDataWorker;
    }

    public static CameraWorker cameraWorker() {
        return mCameraWorker;
    }

    public static void start() {
        AppMethodBeat.i(123189);
        t[0] = System.currentTimeMillis();
        mProcessState = 1;
        mInitController.start(YTAGReflectLiveCheckInterface.mRgbConfigRequester, new ProcessResult() {
            public final void onSuccess() {
                AppMethodBeat.i(123182);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ProcessManager.access$000();
                    AppMethodBeat.o(123182);
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(123181);
                        ProcessManager.access$000();
                        AppMethodBeat.o(123181);
                    }
                });
                AppMethodBeat.o(123182);
            }

            public final void onFailed(int i, String str, String str2) {
                AppMethodBeat.i(123183);
                YTAGReflectLiveCheckInterface.noticeFailed(i + 100, str, str2);
                ProcessManager.mProcessState = 0;
                AppMethodBeat.o(123183);
            }
        });
        AppMethodBeat.o(123189);
    }

    private static void ReflectStart() {
        AppMethodBeat.i(123190);
        t[1] = System.currentTimeMillis();
        mProcessState = 2;
        mReflectController.start(YTAGReflectLiveCheckInterface.mReflectLayout, new ProcessResult() {
            public final void onSuccess() {
                AppMethodBeat.i(123184);
                ProcessManager.access$100();
                AppMethodBeat.o(123184);
            }

            public final void onFailed(int i, String str, String str2) {
                AppMethodBeat.i(123185);
                YTAGReflectLiveCheckInterface.noticeFailed(i + 200, str, str2);
                ProcessManager.mProcessState = 0;
                AppMethodBeat.o(123185);
            }
        });
        AppMethodBeat.o(123190);
    }

    private static void FinishStart() {
        AppMethodBeat.i(123191);
        t[2] = System.currentTimeMillis();
        YTLogger.i("mCountDownTimer", "[ProcessManager.FinishStart] start to reflect: " + (t[1] - t[0]));
        YTLogger.i("mCountDownTimer", "[ProcessManager.FinishStart] reflect to finish: " + (t[2] - t[1]));
        mProcessState = 3;
        mFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequester, new LightLiveCheckResult() {
            public final void onSuccess(boolean z, LightDiffResponse lightDiffResponse) {
                AppMethodBeat.i(123186);
                YTAGReflectLiveCheckInterface.noticeSuccess(z, lightDiffResponse);
                ProcessManager.mProcessState = 0;
                AppMethodBeat.o(123186);
            }

            public final void onFailed(int i, String str, String str2) {
                AppMethodBeat.i(123187);
                YTAGReflectLiveCheckInterface.noticeFailed(i + 300, str, str2);
                ProcessManager.mProcessState = 0;
                AppMethodBeat.o(123187);
            }
        });
        AppMethodBeat.o(123191);
    }

    public static void cancel() {
        AppMethodBeat.i(123192);
        if (mCameraWorker != null) {
            mCameraWorker.cleanup();
        }
        mProcessState = 0;
        AppMethodBeat.o(123192);
    }
}
