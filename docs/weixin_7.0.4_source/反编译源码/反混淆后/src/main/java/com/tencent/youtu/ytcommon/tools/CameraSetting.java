package com.tencent.youtu.ytcommon.tools;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.util.List;

public class CameraSetting {
    private static final String TAG = "CameraSetting";
    static int mDesiredPreviewHeight = 720;
    static int mDesiredPreviewWidth = ActUtil.HEIGHT;

    public static int getDesiredPreviewWidth() {
        return mDesiredPreviewWidth;
    }

    public static int getDesiredPreviewHeight() {
        return mDesiredPreviewHeight;
    }

    public static int getRotateTag(int i) {
        AppMethodBeat.m2504i(118078);
        int i2 = 1;
        if (i == 90) {
            i2 = 7;
        } else if (i == 270) {
            i2 = 5;
        } else {
            YTLogger.m50248w(TAG, "获取摄像头转向结果的时候值不为90或者180");
        }
        AppMethodBeat.m2505o(118078);
        return i2;
    }

    public static int getVideoRotate(Context context, int i) {
        int i2;
        int i3;
        AppMethodBeat.m2504i(118079);
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                i2 = 0;
                break;
            case 1:
                i2 = 90;
                break;
            case 2:
                i2 = 180;
                break;
            case 3:
                i2 = 270;
                break;
            default:
                i2 = 0;
                break;
        }
        if (cameraInfo.facing == 1) {
            i3 = (360 - ((cameraInfo.orientation + i2) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
        } else {
            i3 = ((cameraInfo.orientation - i2) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        YTLogger.m50244d(TAG, "debug camera orientation is " + cameraInfo.orientation + " ui degrees is " + i2);
        AppMethodBeat.m2505o(118079);
        return i3;
    }

    public static int initCamera(Context context, Camera camera, int i) {
        AppMethodBeat.m2504i(118080);
        try {
            int i2;
            Parameters parameters;
            CamcorderProfile camcorderProfile;
            Parameters parameters2 = camera.getParameters();
            List supportedFocusModes = parameters2.getSupportedFocusModes();
            for (i2 = 0; i2 < supportedFocusModes.size(); i2++) {
                YTLogger.m50247v(TAG, "suporrtedFocusModes " + i2 + " :" + ((String) supportedFocusModes.get(i2)));
            }
            if (supportedFocusModes != null && supportedFocusModes.indexOf("continuous-video") >= 0) {
                parameters2.setFocusMode("continuous-video");
                YTLogger.m50244d(TAG, "set camera focus mode continuous video");
            } else if (supportedFocusModes == null || supportedFocusModes.indexOf("auto") < 0) {
                YTLogger.m50244d(TAG, "NOT set camera focus mode");
            } else {
                parameters2.setFocusMode("auto");
                YTLogger.m50244d(TAG, "set camera focus mode auto");
            }
            try {
                camera.setParameters(parameters2);
                parameters = camera.getParameters();
            } catch (Exception e) {
                YTLogger.m50248w(TAG, "Camera.setParameters.setPreviewSize failed!!: " + e.getLocalizedMessage());
                YTException.report(e);
                parameters = camera.getParameters();
            } catch (Throwable th) {
                camera.getParameters();
                AppMethodBeat.m2505o(118080);
            }
            i2 = getVideoRotate(context, i);
            camera.setDisplayOrientation(i2);
            YTLogger.m50244d(TAG, "videoOrietation is".concat(String.valueOf(i2)));
            if (CamcorderProfile.hasProfile(i, 4)) {
                camcorderProfile = CamcorderProfile.get(i, 4);
                YTLogger.m50244d(TAG, "480P camcorderProfile:" + camcorderProfile.videoFrameWidth + VideoMaterialUtil.CRAZYFACE_X + camcorderProfile.videoFrameHeight);
            } else if (CamcorderProfile.hasProfile(i, 5)) {
                camcorderProfile = CamcorderProfile.get(i, 5);
                YTLogger.m50244d(TAG, "720P camcorderProfile:" + camcorderProfile.videoFrameWidth + VideoMaterialUtil.CRAZYFACE_X + camcorderProfile.videoFrameHeight);
            } else {
                camcorderProfile = CamcorderProfile.get(i, 1);
                YTLogger.m50244d(TAG, "High camcorderProfile:" + camcorderProfile.videoFrameWidth + VideoMaterialUtil.CRAZYFACE_X + camcorderProfile.videoFrameHeight);
            }
            setVideoSize(parameters, camcorderProfile);
            parameters.setPreviewSize(mDesiredPreviewWidth, mDesiredPreviewHeight);
            parameters.setPreviewFormat(17);
            try {
                camera.setParameters(parameters);
            } catch (Exception e2) {
                YTLogger.m50248w(TAG, "Camera.setParameters.setPreviewSize failed!!: " + e2.getLocalizedMessage());
                YTException.report(e2);
            }
            parameters = camera.getParameters();
            YTLogger.m50244d(TAG, "choose camera fps is : ".concat(String.valueOf(chooseFixedPreviewFps(parameters, 30000))));
            try {
                camera.setParameters(parameters);
            } catch (Exception e22) {
                YTLogger.m50248w(TAG, "Camera.setParameters.preview fps failed!!: " + e22.getLocalizedMessage());
                YTException.report(e22);
            }
            parameters = camera.getParameters();
            int[] iArr = new int[2];
            parameters.getPreviewFpsRange(iArr);
            YTLogger.m50244d(TAG, "after set parameters getPreviewFpsRange=" + iArr[0] + "-" + iArr[1] + " ;after set parameter fps=" + parameters.getPreviewFrameRate());
            Size previewSize = parameters.getPreviewSize();
            YTLogger.m50244d(TAG, "camera preview size is " + previewSize.width + " " + previewSize.height);
            AppMethodBeat.m2505o(118080);
            return 0;
        } catch (Exception e222) {
            YTLogger.m50248w(TAG, "get camera parameters failed. 1. Check Camera.getParameters() interface. 2. Get logs for more detail.");
            YTException.report(e222);
            AppMethodBeat.m2505o(118080);
            return 1;
        }
    }

    public static void setVideoSize(Parameters parameters, CamcorderProfile camcorderProfile) {
        AppMethodBeat.m2504i(118081);
        List supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (parameters.getSupportedVideoSizes() == null) {
            YTLogger.m50244d(TAG, "video size from profile is : " + camcorderProfile.videoFrameWidth + " " + camcorderProfile.videoFrameHeight);
            if (getOptimalPreviewSize(supportedPreviewSizes, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) == null) {
                YTLogger.m50244d(TAG, "do not find proper preview size, use default");
                camcorderProfile.videoFrameWidth = 640;
                camcorderProfile.videoFrameHeight = 480;
            }
        }
        List supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            Object obj = null;
            for (int i = 0; i < supportedVideoSizes.size(); i++) {
                Size size = (Size) supportedVideoSizes.get(i);
                if (size.width == camcorderProfile.videoFrameWidth && size.height == camcorderProfile.videoFrameHeight) {
                    obj = 1;
                }
            }
            if (obj == null) {
                camcorderProfile.videoFrameWidth = 640;
                camcorderProfile.videoFrameHeight = 480;
            }
        }
        YTLogger.m50244d(TAG, "select video size camcorderProfile:" + camcorderProfile.videoFrameWidth + VideoMaterialUtil.CRAZYFACE_X + camcorderProfile.videoFrameHeight);
        AppMethodBeat.m2505o(118081);
    }

    private static Size getOptimalPreviewSize(List<Size> list, int i, int i2) {
        AppMethodBeat.m2504i(118082);
        if (list == null) {
            AppMethodBeat.m2505o(118082);
            return null;
        }
        Size size;
        Size size2 = null;
        double d = Double.MAX_VALUE;
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        double d2 = ((double) max) / ((double) min);
        YTLogger.m50244d(TAG, "sizes size=" + list.size());
        for (Size size3 : list) {
            if (Math.abs((((double) size3.width) / ((double) size3.height)) - d2) <= 0.001d) {
                if (((double) Math.abs(size3.height - min)) < d) {
                    d = (double) Math.abs(size3.height - min);
                } else {
                    size3 = size2;
                }
                size2 = size3;
            }
        }
        if (size2 == null) {
            YTLogger.m50244d(TAG, "No preview size match the aspect ratio");
            d = Double.MAX_VALUE;
            for (Size size32 : list) {
                if (((double) Math.abs(size32.height - min)) < d) {
                    d = (double) Math.abs(size32.height - min);
                    size2 = size32;
                }
            }
        }
        AppMethodBeat.m2505o(118082);
        return size2;
    }

    private static int chooseFixedPreviewFps(Parameters parameters, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(118083);
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            YTLogger.m50244d(TAG, "entry: " + iArr[0] + " - " + iArr[1]);
            if (iArr[0] == iArr[1] && iArr[0] == i) {
                parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                YTLogger.m50244d(TAG, "use preview fps range: " + iArr[0] + " " + iArr[1]);
                i = iArr[0];
                AppMethodBeat.m2505o(118083);
                return i;
            }
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (iArr2[0] == iArr2[1]) {
            i = iArr2[0];
        } else {
            if (i > iArr2[1]) {
                i = iArr2[1];
            }
            if (i < iArr2[0]) {
                i = iArr2[0];
            }
        }
        String str = parameters.get("preview-frame-rate-values");
        if (!(TextUtils.isEmpty(str) || str.contains((i / 1000)))) {
            int parseInt;
            String[] split = str.split(",");
            int length = split.length;
            while (i2 < length) {
                parseInt = Integer.parseInt(split[i2]) * 1000;
                if (i < parseInt) {
                    parameters.setPreviewFrameRate(parseInt / 1000);
                    AppMethodBeat.m2505o(118083);
                    return parseInt;
                }
                i2++;
            }
            if (split.length > 0) {
                parseInt = Integer.parseInt(split[split.length - 1]) * 1000;
                if (i > parseInt) {
                    i = parseInt;
                }
            }
        }
        parameters.setPreviewFrameRate(i / 1000);
        AppMethodBeat.m2505o(118083);
        return i;
    }
}
