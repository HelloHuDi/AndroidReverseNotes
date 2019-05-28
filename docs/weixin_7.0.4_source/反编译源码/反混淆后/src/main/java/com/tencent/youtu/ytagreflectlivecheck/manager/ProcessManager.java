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
    /* renamed from: t */
    public static long[] f3501t = new long[10];

    public interface ProcessResult {
        void onFailed(int i, String str, String str2);

        void onSuccess();
    }

    /* renamed from: com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager$2 */
    static class C164262 implements ProcessResult {
        C164262() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(123184);
            ProcessManager.access$100();
            AppMethodBeat.m2505o(123184);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(123185);
            YTAGReflectLiveCheckInterface.noticeFailed(i + 200, str, str2);
            ProcessManager.mProcessState = 0;
            AppMethodBeat.m2505o(123185);
        }
    }

    /* renamed from: com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager$1 */
    static class C164271 implements ProcessResult {

        /* renamed from: com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager$1$1 */
        class C164251 implements Runnable {
            C164251() {
            }

            public void run() {
                AppMethodBeat.m2504i(123181);
                ProcessManager.access$000();
                AppMethodBeat.m2505o(123181);
            }
        }

        C164271() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(123182);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ProcessManager.access$000();
                AppMethodBeat.m2505o(123182);
                return;
            }
            new Handler(Looper.getMainLooper()).post(new C164251());
            AppMethodBeat.m2505o(123182);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(123183);
            YTAGReflectLiveCheckInterface.noticeFailed(i + 100, str, str2);
            ProcessManager.mProcessState = 0;
            AppMethodBeat.m2505o(123183);
        }
    }

    /* renamed from: com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager$3 */
    static class C164283 implements LightLiveCheckResult {
        C164283() {
        }

        public final void onSuccess(boolean z, LightDiffResponse lightDiffResponse) {
            AppMethodBeat.m2504i(123186);
            YTAGReflectLiveCheckInterface.noticeSuccess(z, lightDiffResponse);
            ProcessManager.mProcessState = 0;
            AppMethodBeat.m2505o(123186);
        }

        public final void onFailed(int i, String str, String str2) {
            AppMethodBeat.m2504i(123187);
            YTAGReflectLiveCheckInterface.noticeFailed(i + 300, str, str2);
            ProcessManager.mProcessState = 0;
            AppMethodBeat.m2505o(123187);
        }
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.m2504i(123193);
        ReflectStart();
        AppMethodBeat.m2505o(123193);
    }

    static /* synthetic */ void access$100() {
        AppMethodBeat.m2504i(123194);
        FinishStart();
        AppMethodBeat.m2505o(123194);
    }

    public static void initAll() {
        AppMethodBeat.m2504i(123188);
        mInitController = new InitController();
        mReflectController = new ReflectController();
        mFinishController = new FinishController();
        mDataWorker = new DataWorker();
        mCameraWorker = new CameraWorker();
        mProcessState = 0;
        mRetainCount++;
        AppMethodBeat.m2505o(123188);
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
        AppMethodBeat.m2504i(123189);
        f3501t[0] = System.currentTimeMillis();
        mProcessState = 1;
        mInitController.start(YTAGReflectLiveCheckInterface.mRgbConfigRequester, new C164271());
        AppMethodBeat.m2505o(123189);
    }

    private static void ReflectStart() {
        AppMethodBeat.m2504i(123190);
        f3501t[1] = System.currentTimeMillis();
        mProcessState = 2;
        mReflectController.start(YTAGReflectLiveCheckInterface.mReflectLayout, new C164262());
        AppMethodBeat.m2505o(123190);
    }

    private static void FinishStart() {
        AppMethodBeat.m2504i(123191);
        f3501t[2] = System.currentTimeMillis();
        YTLogger.m50246i("mCountDownTimer", "[ProcessManager.FinishStart] start to reflect: " + (f3501t[1] - f3501t[0]));
        YTLogger.m50246i("mCountDownTimer", "[ProcessManager.FinishStart] reflect to finish: " + (f3501t[2] - f3501t[1]));
        mProcessState = 3;
        mFinishController.start(YTAGReflectLiveCheckInterface.mUploadVideoRequester, new C164283());
        AppMethodBeat.m2505o(123191);
    }

    public static void cancel() {
        AppMethodBeat.m2504i(123192);
        if (mCameraWorker != null) {
            mCameraWorker.cleanup();
        }
        mProcessState = 0;
        AppMethodBeat.m2505o(123192);
    }
}
