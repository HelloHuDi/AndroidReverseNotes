package com.tencent.ttpic.manager;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.io.FileInputStream;
import java.io.InputStream;

public class FeatureManager {
    public static final int INIT_FAIL = -1;
    public static final int INIT_NOFILE = -2;
    public static final int INIT_SUCC = 1;
    private static final String TAG = FeatureManager.class.getSimpleName();
    private static final String[] bodyDetectionResNms = new String[]{"model6", "so6", "so7"};
    private static final String[] filterResNms = new String[]{"so9"};
    private static final String[] gameplayResNms = new String[]{"so5"};
    private static final String[] gestureDetectionResNms = new String[]{"model1", "so1", "so2"};
    private static boolean isBodyDetectionReady = false;
    private static boolean isFilterReady = false;
    private static boolean isGameplayReady = false;
    private static boolean isGestureDetectionReady = false;
    private static boolean isLipsLutReady = false;
    private static boolean isSegmentationReady = false;
    private static final String[] lipslutResNms = new String[]{"so8"};
    private static final String[] segmentationResNms = new String[]{"model5", "so3", "so4"};

    static {
        AppMethodBeat.i(83432);
        checkFeaturesReady();
        AppMethodBeat.o(83432);
    }

    public static void checkFeaturesReady() {
        String resPath;
        AppMethodBeat.i(83425);
        String[] strArr = segmentationResNms;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            resPath = ResourcePathMapper.getResPath(strArr[i]);
            if (resPath == null || resPath.equals("")) {
                setIsSegmentationReady(false);
                break;
            } else {
                setIsSegmentationReady(true);
                i++;
            }
        }
        strArr = gestureDetectionResNms;
        length = strArr.length;
        i = 0;
        while (i < length) {
            resPath = ResourcePathMapper.getResPath(strArr[i]);
            if (resPath == null || resPath.equals("")) {
                setIsGestureDetectionReady(false);
                break;
            } else {
                setIsGestureDetectionReady(true);
                i++;
            }
        }
        strArr = gameplayResNms;
        length = strArr.length;
        i = 0;
        while (i < length) {
            resPath = ResourcePathMapper.getResPath(strArr[i]);
            if (resPath == null || resPath.equals("")) {
                setIsGameplayReady(false);
                break;
            } else {
                setIsGameplayReady(true);
                i++;
            }
        }
        strArr = bodyDetectionResNms;
        length = strArr.length;
        i = 0;
        while (i < length) {
            resPath = ResourcePathMapper.getResPath(strArr[i]);
            if (resPath == null || resPath.equals("")) {
                setIsBodyDetectionReady(false);
                break;
            } else {
                setIsBodyDetectionReady(true);
                i++;
            }
        }
        strArr = lipslutResNms;
        length = strArr.length;
        i = 0;
        while (i < length) {
            resPath = ResourcePathMapper.getResPath(strArr[i]);
            if (resPath == null || resPath.equals("")) {
                setisLutLipsReady(false);
                break;
            } else {
                setisLutLipsReady(true);
                i++;
            }
        }
        for (String resPath2 : filterResNms) {
            resPath2 = ResourcePathMapper.getResPath(resPath2);
            if (resPath2 == null || resPath2.equals("")) {
                setisFilterReady(false);
                AppMethodBeat.o(83425);
                return;
            }
            setisFilterReady(true);
        }
        AppMethodBeat.o(83425);
    }

    private static void setIsSegmentationReady(boolean z) {
        isSegmentationReady = z;
    }

    public static boolean isSegmentationReady() {
        return isSegmentationReady;
    }

    private static void setIsGestureDetectionReady(boolean z) {
        isGestureDetectionReady = z;
    }

    public static boolean isGestureDetectionReady() {
        return isGestureDetectionReady;
    }

    private static void setIsGameplayReady(boolean z) {
        isGameplayReady = z;
    }

    public static boolean isGameplayReady() {
        return isGameplayReady;
    }

    private static void setIsBodyDetectionReady(boolean z) {
        isBodyDetectionReady = z;
    }

    public static boolean isBodyDetectionReady() {
        return isBodyDetectionReady;
    }

    private static void setisLutLipsReady(boolean z) {
        isLipsLutReady = z;
    }

    public static boolean isLutLipsReady() {
        return isLipsLutReady;
    }

    private static void setisFilterReady(boolean z) {
        isFilterReady = z;
    }

    public static boolean isFilterReady() {
        return isFilterReady;
    }

    public static int initGestureDetection() {
        AppMethodBeat.i(83426);
        int i = 0;
        String modelResPath = ResourcePathMapper.getModelResPath("libXGestureSDK.so");
        String modelResPath2 = ResourcePathMapper.getModelResPath("libpt_handdetector.so");
        if (modelResPath == null || modelResPath.equals("") || modelResPath2 == null || modelResPath2.equals("")) {
            AppMethodBeat.o(83426);
            return -2;
        }
        try {
            loadLibrary("XGestureSDK");
            loadLibrary("pt_handdetector");
            i = 1;
        } catch (Exception | UnsatisfiedLinkError e) {
        }
        if (i == 0) {
            AppMethodBeat.o(83426);
            return -1;
        }
        GestureDetector.getInstance();
        setIsGestureDetectionReady(true);
        AppMethodBeat.o(83426);
        return 1;
    }

    public static int initSegmentation() {
        int i;
        AppMethodBeat.i(83427);
        try {
            System.loadLibrary("YTCommon");
            System.loadLibrary("nnpack");
            loadLibrary("segmentern");
            i = 1;
        } catch (Exception e) {
            LogUtils.e(e);
            try {
                loadLibrary("segmentern");
                i = 1;
            } catch (Exception e2) {
                i = 0;
            }
        } catch (UnsatisfiedLinkError e3) {
            LogUtils.e(e3);
            try {
                loadLibrary("segmentern");
                i = 1;
            } catch (Exception e4) {
                i = 0;
            }
        } catch (Throwable th) {
            try {
                loadLibrary("segmentern");
            } catch (Exception e5) {
            }
            AppMethodBeat.o(83427);
        }
        if (i == 0) {
            AppMethodBeat.o(83427);
            return -1;
        }
        FabbyManager.init();
        setIsSegmentationReady(true);
        AppMethodBeat.o(83427);
        return 1;
    }

    public static int init3DGameplay() {
        AppMethodBeat.i(83428);
        try {
            loadLibrary("gameplay");
            setIsGameplayReady(true);
            AppMethodBeat.o(83428);
            return 1;
        } catch (UnsatisfiedLinkError e) {
            AppMethodBeat.o(83428);
            return -1;
        } catch (Exception e2) {
            AppMethodBeat.o(83428);
            return -1;
        }
    }

    public static int initBodyDetection() {
        AppMethodBeat.i(83429);
        try {
            new StringBuilder("android.os.Build.VERSION.SDK_INT = ").append(VERSION.SDK_INT);
            if (VERSION.SDK_INT <= 17) {
                System.load("/data/data/com.tencent.xnet/lib/libxnet.so");
            } else {
                loadLibrary("xnet");
            }
            loadLibrary("bodydetector");
            setIsBodyDetectionReady(true);
            AppMethodBeat.o(83429);
            return 1;
        } catch (UnsatisfiedLinkError e) {
            AppMethodBeat.o(83429);
            return -1;
        } catch (Exception e2) {
            AppMethodBeat.o(83429);
            return -1;
        }
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(83430);
        String str2 = "lib" + str + ".so";
        String modelResPath = ResourcePathMapper.getModelResPath(str2);
        if (modelResPath == null || modelResPath.equals("")) {
            Exception exception = new Exception("Load Library " + str2 + "failed.");
            AppMethodBeat.o(83430);
            throw exception;
        } else if (modelResPath.startsWith("assets://")) {
            System.loadLibrary(str);
            AppMethodBeat.o(83430);
        } else {
            System.load(modelResPath + str2);
            AppMethodBeat.o(83430);
        }
    }

    public static InputStream getModelStream(String str) {
        AppMethodBeat.i(83431);
        String modelResPath = ResourcePathMapper.getModelResPath(str);
        if (modelResPath != null) {
            try {
                if (!modelResPath.equals("")) {
                    InputStream open;
                    if (modelResPath.startsWith("assets://")) {
                        open = VideoGlobalContext.getContext().getAssets().open(modelResPath.substring(9) + str);
                        AppMethodBeat.o(83431);
                        return open;
                    }
                    open = new FileInputStream(modelResPath + str);
                    AppMethodBeat.o(83431);
                    return open;
                }
            } catch (Exception e) {
                AppMethodBeat.o(83431);
                return null;
            }
        }
        AppMethodBeat.o(83431);
        return null;
    }
}
