package com.tencent.youtu.ytagreflectlivecheck.worker;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;

public class CameraWorker {
    private static final String TAG = "YoutuLightLiveCheck";
    private static int mDesiredPreviewHeight = 720;
    private static int mDesiredPreviewWidth = ActUtil.HEIGHT;
    private int GET_CAMERA_PARAMETERS_FAILED = 0;
    public Camera mCamera;
    private Parameters mCameraParameters;
    private boolean mIsCameraOpened = false;
    private PreviewCallback mPreviewCallback;

    public void setCamera(Camera camera) {
        AppMethodBeat.i(123198);
        this.mCamera = camera;
        this.mCameraParameters = camera.getParameters();
        mDesiredPreviewHeight = this.mCameraParameters.getPreviewSize().height;
        mDesiredPreviewWidth = this.mCameraParameters.getPreviewSize().width;
        this.mIsCameraOpened = true;
        AppMethodBeat.o(123198);
    }

    public void setCameraPreviewCallback(PreviewCallback previewCallback) {
        this.mPreviewCallback = previewCallback;
    }

    public int getDesiredPreviewWidth() {
        return mDesiredPreviewWidth;
    }

    public int getDesiredPreviewHeight() {
        return mDesiredPreviewHeight;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(123199);
        if (this.mPreviewCallback == null || !this.mIsCameraOpened) {
            YTLogger.w(TAG, "[YTAGReflectLiveCheckInterface.onPreviewFrame] ---callback is nil, or mIsCameraOpened: " + this.mIsCameraOpened);
            AppMethodBeat.o(123199);
            return;
        }
        try {
            this.mPreviewCallback.onPreviewFrame(bArr, camera);
            AppMethodBeat.o(123199);
        } catch (Exception e) {
            YTException.report(e);
            AppMethodBeat.o(123199);
        }
    }

    public void cleanup() {
        AppMethodBeat.i(123200);
        if (this.mCamera != null) {
            try {
                this.mCamera.setParameters(this.mCameraParameters);
            } catch (Exception e) {
                YTLogger.d(TAG, "[CameraWorker.cleanup] camera is already released.");
            }
            this.mCamera = null;
            this.mIsCameraOpened = false;
        }
        AppMethodBeat.o(123200);
    }
}
