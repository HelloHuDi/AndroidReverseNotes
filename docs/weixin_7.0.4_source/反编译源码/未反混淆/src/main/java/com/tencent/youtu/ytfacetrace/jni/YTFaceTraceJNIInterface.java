package com.tencent.youtu.ytfacetrace.jni;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTFaceTraceJNIInterface {
    private long nativePtr;

    public static class FaceStatus {
        public int blur_score;
        public int h;
        public int illumination_score;
        public PointF lefteye;
        public int liveness_eye;
        public int liveness_head;
        public int liveness_mouth;
        public float pitch;
        public PointF righteye;
        public float roll;
        public int save_photo;
        public int w;
        public int x;
        public float[] xys;
        public int y;
        public float yaw;
    }

    public static native boolean Init(byte[] bArr, byte[] bArr2);

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static native void Release();

    private static native boolean nativeInit();

    public native int DoDetectionInit();

    public native FaceStatus DoDetectionProcess(byte[] bArr, int i, int i2, boolean z);

    public native FaceStatus DoDetectionProcessRGBA(byte[] bArr, int i, int i2);

    public native FaceStatus DoDetectionProcessWithRotation(byte[] bArr, int i, int i2, boolean z, int i3);

    public native void EndLiveCheck();

    public native Bitmap GetResultImage();

    public native Bitmap GetResultLiveCheckImage();

    public native void StartLiveCheck();

    public YTFaceTraceJNIInterface() {
        AppMethodBeat.i(117804);
        NativeConstructor();
        AppMethodBeat.o(117804);
    }

    public void destroy() {
        AppMethodBeat.i(117805);
        NativeDestructor();
        AppMethodBeat.o(117805);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.i(117806);
        NativeDestructor();
        AppMethodBeat.o(117806);
    }

    static {
        AppMethodBeat.i(117807);
        nativeInit();
        AppMethodBeat.o(117807);
    }
}
