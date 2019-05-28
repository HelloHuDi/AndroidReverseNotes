package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VError;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.i;
import java.io.File;

public enum YTFaceDetectorBase {
    INSTANCE;
    
    private static final String TAG = null;
    public static String YT_MODEL_DIR;
    public static String YT_MODEL_DIR_BACKUP;
    private volatile boolean faceTrackInited;
    private volatile boolean picFaceDetectInited;

    private native void nativeDestructor();

    public final native int nativeInit(String str);

    public final native int nativeInitFaceTrack(String str);

    public final native int nativeInitPicFaceDetect(String str);

    public final native void nativeSetRefine(boolean z);

    static {
        TAG = YTFaceDetectorBase.class.getSimpleName();
        YT_MODEL_DIR = null;
        YT_MODEL_DIR_BACKUP = null;
        AppMethodBeat.o(84406);
    }

    public static YTFaceDetectorBase getInstance() {
        return INSTANCE;
    }

    public final int initFaceTrack() {
        AppMethodBeat.i(84400);
        if (this.faceTrackInited) {
            AppMethodBeat.o(84400);
            return 0;
        }
        int i;
        Object obj;
        String str = YT_MODEL_DIR;
        if (!DeviceUtils.canWriteFile(str)) {
            str = YT_MODEL_DIR_BACKUP;
        }
        DeviceUtils.canWriteFile(str);
        String[] strArr = new String[]{"net_1_bin.rpnproto", "net_1.rpnmodel", "net_2_bin.rpnproto", "net_2.rpnmodel", "net_3_bin.rpnproto", "net_3.rpnmodel"};
        int i2 = 1;
        for (i = 0; i < 6; i++) {
            obj = strArr[i];
            if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "detector/".concat(String.valueOf(obj)), str + File.separator + obj)) {
                i2 = 0;
            }
        }
        strArr = new String[]{"align.stb", "align583.rpdm", "align583_bin.rpdc", "eye.rpdm", "eye_bin.rpdc", "eyebrow.rpdm", "eyebrow_bin.rpdc", "mouth.rpdm", "mouth_bin.rpdc", "refine1.rmd", "refine2.rmd"};
        for (i = 0; i < 11; i++) {
            obj = strArr[i];
            if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "align/".concat(String.valueOf(obj)), str + File.separator + obj)) {
                i2 = 0;
            }
        }
        strArr = new String[]{"meshBasis.bin", "rotBasis.bin"};
        for (i = 0; i < 2; i++) {
            obj = strArr[i];
            if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "poseest/".concat(String.valueOf(obj)), str + File.separator + obj)) {
                i2 = 0;
            }
        }
        if (i2 == 0) {
            AppMethodBeat.o(84400);
            return -1000;
        } else if (initFaceTrackModel(str + File.separator) != 0) {
            i.m(TAG, "nativeInit failed");
            AppMethodBeat.o(84400);
            return VError.ERROR_FACE_MODEL_INIT;
        } else {
            nativeSetRefine(false);
            this.faceTrackInited = true;
            AppMethodBeat.o(84400);
            return 0;
        }
    }

    public final int initPicFaceDetect() {
        AppMethodBeat.i(84401);
        if (this.picFaceDetectInited) {
            AppMethodBeat.o(84401);
            return 0;
        }
        String str = YT_MODEL_DIR;
        if (!DeviceUtils.canWriteFile(str)) {
            str = YT_MODEL_DIR_BACKUP;
        }
        String[] strArr = new String[]{"pictrack_align521_16.rpdm", "pictrack_align521_bin.rpdc", "pictrack_contour_16.rpdm", "pictrack_contour_bin.rpdc", "pictrack_eye_16.rpdm", "pictrack_eye_bin.rpdc", "pictrack_eyebrow_16.rpdm", "pictrack_eyebrow_bin.rpdc", "pictrack_FacePicAlignRunner_bin.md5", "pictrack_mouth_16.rpdm", "pictrack_mouth_bin.rpdc", "pictrack_nose_16.rpdm", "pictrack_nose_bin.rpdc"};
        int i = 1;
        for (int i2 = 0; i2 < 13; i2++) {
            String str2 = strArr[i2];
            String modelResPath = ResourcePathMapper.getModelResPath(str2);
            LogUtils.e(TAG, "resPath = ".concat(String.valueOf(modelResPath)));
            if (modelResPath == null || modelResPath.startsWith("assets://")) {
                if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "ufa/".concat(String.valueOf(str2)), str + File.separator + str2)) {
                    LogUtils.e(TAG, "copyAssets failed");
                    i = 0;
                }
            } else if (!FileUtils.copyFile(modelResPath + str2, str + File.separator + str2)) {
                LogUtils.e(TAG, "copyFile failed");
                i = 0;
            }
        }
        if (i == 0) {
            LogUtils.e(TAG, "copy pic face align model failed!");
        }
        if (initPicFaceDetectModel(str + File.separator) != 0) {
            i.m(TAG, "nativeInit failed");
            AppMethodBeat.o(84401);
            return VError.ERROR_FACE_MODEL_INIT;
        }
        nativeSetRefine(false);
        this.picFaceDetectInited = true;
        AppMethodBeat.o(84401);
        return 0;
    }

    private int initModel(String str) {
        AppMethodBeat.i(84402);
        int nativeInit = nativeInit(str);
        AppMethodBeat.o(84402);
        return nativeInit;
    }

    private int initFaceTrackModel(String str) {
        AppMethodBeat.i(84403);
        int nativeInitFaceTrack = nativeInitFaceTrack(str);
        AppMethodBeat.o(84403);
        return nativeInitFaceTrack;
    }

    private int initPicFaceDetectModel(String str) {
        AppMethodBeat.i(84404);
        int nativeInitPicFaceDetect = nativeInitPicFaceDetect(str);
        AppMethodBeat.o(84404);
        return nativeInitPicFaceDetect;
    }

    public final void destroy() {
        AppMethodBeat.i(84405);
        nativeDestructor();
        this.faceTrackInited = false;
        this.picFaceDetectInited = false;
        AppMethodBeat.o(84405);
    }
}
