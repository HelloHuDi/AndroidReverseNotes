package com.tencent.p177mm.plugin.gif;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.gif.MMWXGFJNI */
public class MMWXGFJNI {
    public static final int PIC_TYPE_JPG = 0;
    public static final int PIC_TYPE_PNG = 1;
    private static final String TAG = "MicroMsg.JNI.MMWXGF";
    static int mECode;
    static boolean mIsInit;

    public static native int nativeAV2Gif(String str, String str2);

    public static native int nativeAV2Gif(byte[] bArr, byte[] bArr2);

    public static native int nativeAddGifEncodeRgbaFrame(long j, int i, int i2, byte[] bArr, long j2);

    public static native int nativeAddWxAMEncodeRgbaFrame(long j, int i, int i2, byte[] bArr, long j2);

    public static native int nativeDecodeBufferFrame(long j, byte[] bArr, int i, Bitmap bitmap, int[] iArr);

    public static native int nativeDecodeBufferHeader(long j, byte[] bArr, int i);

    public static native byte[] nativeFinishGifEncode(long j);

    public static native byte[] nativeFinishWxAMEncode(long j);

    public static native int nativeGetOption(long j, byte[] bArr, int i, int[] iArr);

    public static native int nativeInit(String str);

    public static native long nativeInitGifEncode(int i, int i2, long j);

    public static native long nativeInitWxAMDecoder();

    public static native long nativeInitWxAMEncoder(int i, int i2, long j, int i3);

    public static native boolean nativeIsWXGF(byte[] bArr, int i);

    public static native int nativePic2Wxam(String str, String str2, int i, int i2);

    public static native int nativeRewindBuffer(long j);

    public static native int nativeUninit(long j);

    public static native int nativeWxam2Pic(String str, String str2);

    public static native byte[] nativeWxam2PicBuf(byte[] bArr);

    public static native byte[] nativeWxamToGif(byte[] bArr);

    static {
        AppMethodBeat.m2504i(62446);
        mIsInit = false;
        mECode = -1;
        C4990ab.m7416i(TAG, "static MMWXGFJNI");
        if (mIsInit) {
            C4990ab.m7410d(TAG, "MMWXGF has init.");
            AppMethodBeat.m2505o(62446);
            return;
        }
        int nativeInit = MMWXGFJNI.nativeInit(C6457e.eSi + "lib/libvoipCodec.so");
        mECode = nativeInit;
        mIsInit = nativeInit >= 0;
        C4990ab.m7417i(TAG, "native init MMWXGF mECode:%d result:%b :%s", Integer.valueOf(mECode), Boolean.valueOf(mIsInit), r3);
        AppMethodBeat.m2505o(62446);
    }

    public static int getErrorCode() {
        return mECode;
    }
}
