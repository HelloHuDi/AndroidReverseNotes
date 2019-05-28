package com.tencent.qqvideo.proxy.p1103pi;

/* renamed from: com.tencent.qqvideo.proxy.pi.IRefObject */
public class IRefObject {
    private long mNativePtr;

    private static native void freeNativePtr(long j);

    public native void finalize();

    public native synchronized void release();

    public native synchronized void retain();

    public IRefObject(long j) {
        this.mNativePtr = j;
    }

    private synchronized long getNativePtr() {
        return this.mNativePtr;
    }
}
