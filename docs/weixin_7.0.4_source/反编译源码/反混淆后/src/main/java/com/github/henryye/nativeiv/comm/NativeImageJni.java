package com.github.henryye.nativeiv.comm;

import android.support.annotation.Keep;
import java.nio.ByteBuffer;

public class NativeImageJni {
    long mNativeInst = 0;

    @Keep
    public native CommNativeBitmapStruct nativeDecodeNative(long j, ByteBuffer byteBuffer, int i);

    @Keep
    public native void nativeDestroy(long j);

    @Keep
    public native long nativeInit();

    @Keep
    public native void nativeRecycleNative(long j, long j2);
}
