package com.tencent.youtu.ytfacetrace.manager;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytcommon.tools.YTThreadOperate;
import com.tencent.youtu.ytcommon.tools.YTThreadOperate.UiThreadCallback;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceDetectResult;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import java.util.concurrent.Callable;

public class FaceTraceProcessManager {
    private static final String TAG = "FaceDetectProcess";
    private static int mCurrentCheckingState;
    private volatile boolean isProcessing = false;
    private Camera mCamera = null;
    private Parameters mCameraParameters = null;
    public Context mContext;
    public int mDesiredPreviewHeight = 720;
    public int mDesiredPreviewWidth = ActUtil.HEIGHT;
    private YTFaceTraceJNIInterface mFaceCheck = new YTFaceTraceJNIInterface();
    private FaceTraceingNotice mFaceTraceNotice;
    public boolean mIsTracing = false;
    private FaceStatus status = null;
    long time_now = 0;
    long time_pre = 0;

    public interface FaceDetectProcessResult {
        void onFailed(int i, String str, String str2);

        void onSuccess();
    }

    public FaceTraceProcessManager() {
        AppMethodBeat.m2504i(117812);
        AppMethodBeat.m2505o(117812);
    }

    static /* synthetic */ FaceStatus access$000(FaceTraceProcessManager faceTraceProcessManager, byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(117824);
        FaceStatus faceStatus = faceTraceProcessManager.getFaceStatus(bArr, i, i2);
        AppMethodBeat.m2505o(117824);
        return faceStatus;
    }

    static /* synthetic */ void access$100(FaceTraceProcessManager faceTraceProcessManager, byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(117825);
        faceTraceProcessManager.processFaceDetect(bArr, camera);
        AppMethodBeat.m2505o(117825);
    }

    public void initAll() {
    }

    public void clearAll() {
        AppMethodBeat.m2504i(117813);
        restoreCamera();
        AppMethodBeat.m2505o(117813);
    }

    public void start(Context context, Camera camera, int i, FaceDetectResult faceDetectResult, FaceTraceingNotice faceTraceingNotice) {
        AppMethodBeat.m2504i(117814);
        if (this.mIsTracing) {
            YTLogger.m50248w(TAG, "Restart FaceDetect process. YTFaceTraceInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        setCamera(context, camera, i);
        this.mIsTracing = true;
        this.mContext = context;
        this.mFaceTraceNotice = faceTraceingNotice;
        faceDetectResult.onSuccess();
        noticeOnPreviewing(0, null, null, null, null);
        AppMethodBeat.m2505o(117814);
    }

    public void stop() {
        AppMethodBeat.m2504i(117815);
        if (this.mIsTracing) {
            this.mIsTracing = false;
            noticeOnPreviewing(2, null, null, null, null);
            restoreCamera();
        }
        AppMethodBeat.m2505o(117815);
    }

    public void onPreviewFrame(final byte[] bArr, final Camera camera) {
        AppMethodBeat.m2504i(117816);
        if (this.mIsTracing) {
            YTThreadOperate.runOnSubThread(new Callable<FaceStatus>() {
                public FaceStatus call() {
                    AppMethodBeat.m2504i(117808);
                    FaceStatus access$000 = FaceTraceProcessManager.access$000(FaceTraceProcessManager.this, bArr, FaceTraceProcessManager.this.mDesiredPreviewWidth, FaceTraceProcessManager.this.mDesiredPreviewHeight);
                    AppMethodBeat.m2505o(117808);
                    return access$000;
                }
            }, new UiThreadCallback<FaceStatus>() {
                public void callback(FaceStatus faceStatus) {
                    AppMethodBeat.m2504i(117810);
                    FaceTraceProcessManager.access$100(FaceTraceProcessManager.this, bArr, camera);
                    AppMethodBeat.m2505o(117810);
                }
            });
        }
        AppMethodBeat.m2505o(117816);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(117817);
        restoreCamera();
        if (this.mFaceCheck != null) {
            this.mFaceCheck.destroy();
        }
        super.finalize();
        AppMethodBeat.m2505o(117817);
    }

    private void setCamera(Context context, Camera camera, int i) {
        AppMethodBeat.m2504i(117818);
        this.mCamera = camera;
        this.mCameraParameters = camera.getParameters();
        this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
        this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
        AppMethodBeat.m2505o(117818);
    }

    public void restoreCamera() {
        AppMethodBeat.m2504i(117819);
        if (this.mCamera != null) {
            try {
                this.mCamera.setParameters(this.mCameraParameters);
            } catch (Exception e) {
                YTLogger.m50248w(TAG, "restoreCamera failed. ");
                YTException.report(e);
            } finally {
                this.mCamera = null;
                this.mCameraParameters = null;
                this.mFaceTraceNotice = null;
                this.mContext = null;
                AppMethodBeat.m2505o(117819);
            }
            return;
        }
        AppMethodBeat.m2505o(117819);
    }

    private FaceStatus getFaceStatus(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(117820);
        if (this.isProcessing) {
            AppMethodBeat.m2505o(117820);
            return null;
        }
        this.isProcessing = true;
        if (bArr == null) {
            YTLogger.m50248w(TAG, "FrameData is null!");
            this.isProcessing = false;
            AppMethodBeat.m2505o(117820);
            return null;
        }
        this.status = this.mFaceCheck.DoDetectionProcess(bArr, i, i2, false);
        this.isProcessing = false;
        FaceStatus faceStatus = this.status;
        AppMethodBeat.m2505o(117820);
        return faceStatus;
    }

    private Rect getFaceScreen() {
        int i = 0;
        AppMethodBeat.m2504i(117821);
        float f = this.status.xys[0];
        float f2 = this.status.xys[0];
        float f3 = this.status.xys[1];
        float f4 = this.status.xys[1];
        while (i < 180) {
            if (f >= this.status.xys[i]) {
                f = this.status.xys[i];
            }
            if (f2 <= this.status.xys[i]) {
                f2 = this.status.xys[i];
            }
            i++;
            if (f3 >= this.status.xys[i]) {
                f3 = this.status.xys[i];
            }
            if (f4 <= this.status.xys[i]) {
                f4 = this.status.xys[i];
            }
            i++;
        }
        Rect rect = new Rect((int) f, (int) f3, (int) f2, (int) f4);
        AppMethodBeat.m2505o(117821);
        return rect;
    }

    private void processFaceDetect(byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(117822);
        if (this.status == null) {
            noticeOnPreviewing(1, null, null, bArr, camera);
            AppMethodBeat.m2505o(117822);
            return;
        }
        noticeOnPreviewing(1, this.status, getFaceScreen(), bArr, camera);
        AppMethodBeat.m2505o(117822);
    }

    private void noticeOnPreviewing(int i, FaceStatus faceStatus, Rect rect, byte[] bArr, Camera camera) {
        AppMethodBeat.m2504i(117823);
        if (this.mFaceTraceNotice != null) {
            this.mFaceTraceNotice.onTracing(i, faceStatus, rect, bArr, camera);
        }
        AppMethodBeat.m2505o(117823);
    }
}
