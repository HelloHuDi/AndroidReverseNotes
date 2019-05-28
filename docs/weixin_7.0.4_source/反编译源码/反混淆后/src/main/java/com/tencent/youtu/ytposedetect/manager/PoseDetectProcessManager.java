package com.tencent.youtu.ytposedetect.manager;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.youtu.ytcommon.tools.CameraSetting;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;
import com.tencent.youtu.ytposedetect.jni.YTPoseDetectJNIInterface;

public class PoseDetectProcessManager {
    private static final String TAG = "FaceDetectProcess";
    private Camera mCamera = null;
    private Parameters mCameraParameters = null;
    public int mCameraRotate;
    public int mDesiredPreviewHeight = 720;
    public int mDesiredPreviewWidth = ActUtil.HEIGHT;
    public boolean mIsDetecting = false;

    public void initAll() {
    }

    public void clearAll() {
        AppMethodBeat.m2504i(117781);
        restoreCamera();
        AppMethodBeat.m2505o(117781);
    }

    public void start(Context context, Camera camera, int i, PoseDetectResult poseDetectResult) {
        AppMethodBeat.m2504i(117782);
        if (this.mIsDetecting) {
            YTLogger.m50248w(TAG, "Restart FaceDetect process. YTPoseDetectInterface.stop() should be called before the next start, or maybe camera's parameter may be setting wrong.");
        }
        setCamera(context, camera, i);
        this.mCameraRotate = CameraSetting.getVideoRotate(context, i);
        this.mIsDetecting = true;
        poseDetectResult.onSuccess();
        AppMethodBeat.m2505o(117782);
    }

    public void stop() {
        AppMethodBeat.m2504i(117783);
        if (this.mIsDetecting) {
            this.mIsDetecting = false;
            restoreCamera();
        }
        AppMethodBeat.m2505o(117783);
    }

    public int poseDetect(float[] fArr, int i, byte[] bArr, float f, float f2, float f3) {
        AppMethodBeat.m2504i(117784);
        float[] fArr2 = fArr;
        int i2 = i;
        byte[] bArr2 = bArr;
        int poseDetect = YTPoseDetectJNIInterface.poseDetect(fArr2, i2, bArr2, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, CameraSetting.getRotateTag(this.mCameraRotate), f, f2, f3);
        AppMethodBeat.m2505o(117784);
        return poseDetect;
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(117785);
        super.finalize();
        AppMethodBeat.m2505o(117785);
    }

    private void setCamera(Context context, Camera camera, int i) {
        AppMethodBeat.m2504i(117786);
        this.mCamera = camera;
        this.mCameraParameters = camera.getParameters();
        this.mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
        this.mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
        AppMethodBeat.m2505o(117786);
    }

    public void restoreCamera() {
        AppMethodBeat.m2504i(117787);
        if (this.mCamera != null) {
            try {
                this.mCamera.setParameters(this.mCameraParameters);
            } catch (Exception e) {
                YTLogger.m50248w(TAG, "restoreCamera failed. ");
                YTException.report(e);
            } finally {
                this.mCamera = null;
                this.mCameraParameters = null;
                AppMethodBeat.m2505o(117787);
            }
            return;
        }
        AppMethodBeat.m2505o(117787);
    }
}
