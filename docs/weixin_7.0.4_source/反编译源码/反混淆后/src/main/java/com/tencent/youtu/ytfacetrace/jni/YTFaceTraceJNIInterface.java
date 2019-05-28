package com.tencent.youtu.ytfacetrace.jni;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTFaceTraceJNIInterface {
    private long nativePtr;

    public static class FaceStatus {
        public int blur_score;
        /* renamed from: h */
        public int f16573h;
        public int illumination_score;
        public PointF lefteye;
        public int liveness_eye;
        public int liveness_head;
        public int liveness_mouth;
        public float pitch;
        public PointF righteye;
        public float roll;
        public int save_photo;
        /* renamed from: w */
        public int f16574w;
        /* renamed from: x */
        public int f16575x;
        public float[] xys;
        /* renamed from: y */
        public int f16576y;
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
        AppMethodBeat.m2504i(117804);
        NativeConstructor();
        AppMethodBeat.m2505o(117804);
    }

    public void destroy() {
        AppMethodBeat.m2504i(117805);
        NativeDestructor();
        AppMethodBeat.m2505o(117805);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(117806);
        NativeDestructor();
        AppMethodBeat.m2505o(117806);
    }

    static {
        AppMethodBeat.m2504i(117807);
        nativeInit();
        AppMethodBeat.m2505o(117807);
    }
}
