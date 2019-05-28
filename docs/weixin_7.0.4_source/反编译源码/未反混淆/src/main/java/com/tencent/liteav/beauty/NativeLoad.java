package com.tencent.liteav.beauty;

import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class NativeLoad {
    private static final String TAG = "NativeLoad";

    static class a {
        public static final NativeLoad a = new NativeLoad();

        static {
            AppMethodBeat.i(66828);
            b.e();
            AppMethodBeat.o(66828);
        }
    }

    public static native void OnLoadBeauty();

    public static native void nativeClearQueue();

    public static native void nativeDeleteYuv2Yuv();

    public static native void nativeGlMapBufferToQueue(int i, int i2, ByteBuffer byteBuffer);

    public static native void nativeGlReadPixs(int i, int i2, byte[] bArr);

    public static native boolean nativeGlReadPixsFromQueue(int i, int i2, byte[] bArr);

    public static native void nativeGlReadPixsToQueue(int i, int i2);

    public static native int nativeLoadGLProgram(int i);

    public static native void nativeglTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr, int i9);

    private NativeLoad() {
        AppMethodBeat.i(66824);
        OnLoadBeauty();
        AppMethodBeat.o(66824);
    }

    public static NativeLoad getInstance() {
        return a.a;
    }
}
