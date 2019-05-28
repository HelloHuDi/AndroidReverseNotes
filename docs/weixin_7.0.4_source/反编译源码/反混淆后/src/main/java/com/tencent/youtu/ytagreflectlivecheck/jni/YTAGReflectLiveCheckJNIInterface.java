package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class YTAGReflectLiveCheckJNIInterface {
    public static int TIME_REGULATION_LOOSE = 1;
    public static int TIME_REGULATION_STRICT = 0;
    private static YTAGReflectLiveCheckJNIInterface instance = null;
    private long FRnativePtr;
    public Context context = null;
    private long nativePtr;

    public static native boolean FRInitFaceSDK(byte[] bArr, byte[] bArr2);

    public static native boolean FRReleaseFaceSDK();

    public native void ConfigNativeLog(boolean z);

    public native void FRClearRAW();

    public native void FRDoDetectionImages(byte[] bArr, int i, int i2);

    public native int FRDoDetectionYuvs(boolean z, int i);

    public native FullPack FRGetAGin();

    public native Bitmap FRGetBestImg();

    public native int FRGetChangePoint();

    public native int FRGetChannel();

    public native int FRGetConfigBegin();

    public native int FRGetConfigEnd();

    public native boolean FRGetDoingDelayCalc();

    public native int FRGetISOImgVecSize();

    public native double FRGetISObackup();

    public native int FRGetISOchangeFrame();

    public native double FRGetISOmin();

    public native int FRGetLabelShowing();

    public native int FRGetSeqBeginInd();

    public native int FRGetSeqEndInd();

    public native String FRInit(boolean z, String str);

    public native void FRNativeConstructor();

    public native void FRNativeDestructor();

    public native void FRPushCaptureTime(Timeval timeval);

    public native void FRPushISOCaptureTime(Timeval timeval);

    public native void FRPushISOImg(byte[] bArr, int i, int i2);

    public native void FRPushISOImgYuv(byte[] bArr, int i, int i2);

    public native void FRPushRawImg(byte[] bArr, int i, int i2);

    public native void FRPushRawImgYuv(byte[] bArr, int i, int i2, boolean z);

    public native void FRPushRawImgYuvDebug(byte[] bArr, int i, int i2, Bitmap bitmap);

    public native void FRPushYuv(byte[] bArr, int i, int i2);

    public native void FRSetBegin(Timeval timeval);

    public native void FRSetChangePointTime(Timeval timeval);

    public native void FRSetDoingDelayCalc(boolean z);

    public native void FRSetEnd(Timeval timeval);

    public native void FRSetISObackup(double d);

    public native void FRSetISOchangeFrame(int i);

    public native void FRSetISOchangeTime(Timeval timeval);

    public native void FRSetISOmin(double d);

    public native void FRSetLabelShowing(int i);

    public native void FRSetLandmarks(ArrayList<ArrayList<ArrayList<Integer>>> arrayList);

    public static synchronized YTAGReflectLiveCheckJNIInterface getInstance() {
        YTAGReflectLiveCheckJNIInterface yTAGReflectLiveCheckJNIInterface;
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            AppMethodBeat.m2504i(123175);
            if (instance == null) {
                instance = new YTAGReflectLiveCheckJNIInterface();
            }
            yTAGReflectLiveCheckJNIInterface = instance;
            AppMethodBeat.m2505o(123175);
        }
        return yTAGReflectLiveCheckJNIInterface;
    }

    private YTAGReflectLiveCheckJNIInterface() {
        AppMethodBeat.m2504i(123176);
        FRNativeConstructor();
        AppMethodBeat.m2505o(123176);
    }

    public void destroy() {
        AppMethodBeat.m2504i(123177);
        FRNativeDestructor();
        AppMethodBeat.m2505o(123177);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(123178);
        FRNativeDestructor();
        AppMethodBeat.m2505o(123178);
    }

    public static byte[] encodeJpeg(Bitmap bitmap) {
        AppMethodBeat.m2504i(123179);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 99, byteArrayOutputStream);
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(123179);
        return toByteArray;
    }

    public static String sdkVersion() {
        return "0.0.1_20180605";
    }

    public static String modelVersion() {
        return "0.0.1_20180605";
    }

    public static void NativeLog(int i, String str) {
        AppMethodBeat.m2504i(123180);
        if (YTLogger.isEnableNativeLog()) {
            switch (i) {
                case 2:
                    YTLogger.m50247v("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(123180);
                    return;
                case 3:
                    YTLogger.m50244d("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(123180);
                    return;
                case 4:
                    YTLogger.m50246i("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(123180);
                    return;
                case 5:
                    YTLogger.m50248w("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(123180);
                    return;
                case 6:
                case 7:
                    YTLogger.m50245e("NativeLog", "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(123180);
                    return;
                default:
                    YTLogger.m50244d("NativeLog-".concat(String.valueOf(i)), "[YTAGReflectLiveCheckJNIInterface.NativeLog] ".concat(String.valueOf(str)));
                    AppMethodBeat.m2505o(123180);
                    return;
            }
        }
        AppMethodBeat.m2505o(123180);
    }
}
