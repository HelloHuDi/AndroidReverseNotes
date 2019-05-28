package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCVideoFfmpegDecoder implements a {
    private boolean mFirstDec;
    private d mListener;
    private long mNativeDecoder;
    private long mNativeNotify;
    private ByteBuffer mPps;
    private byte[] mRawData;
    private ByteBuffer mSps;
    private int mVideoHeight;
    private int mVideoWidth;

    private static native void nativeClassInit();

    private native boolean nativeDecode(byte[] bArr, long j, long j2);

    private native void nativeInit(WeakReference<TXCVideoFfmpegDecoder> weakReference, boolean z);

    private native void nativeLoadRawData(byte[] bArr, long j, int i);

    private native void nativeRelease();

    public void setListener(d dVar) {
        this.mListener = dVar;
    }

    public void setNotifyListener(WeakReference<a> weakReference) {
    }

    public int config(Surface surface) {
        return 0;
    }

    public void decode(b bVar) {
        AppMethodBeat.i(67797);
        if (this.mFirstDec) {
            if (!(this.mSps == null || this.mPps == null)) {
                byte[] array = this.mSps.array();
                byte[] array2 = this.mPps.array();
                byte[] bArr = new byte[(array.length + array2.length)];
                System.arraycopy(array, 0, bArr, 0, array.length);
                System.arraycopy(array2, 0, bArr, array.length, array2.length);
                nativeDecode(bArr, bVar.g - 1, bVar.h - 1);
            }
            this.mFirstDec = false;
        }
        nativeDecode(bVar.a, bVar.g, bVar.h);
        AppMethodBeat.o(67797);
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        AppMethodBeat.i(67798);
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mFirstDec = true;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        nativeInit(new WeakReference(this), z);
        AppMethodBeat.o(67798);
        return 0;
    }

    public void stop() {
        AppMethodBeat.i(67799);
        nativeRelease();
        AppMethodBeat.o(67799);
    }

    public boolean isHevc() {
        return false;
    }

    private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> weakReference, long j, int i, int i2, long j2, long j3) {
        AppMethodBeat.i(67800);
        TXCVideoFfmpegDecoder tXCVideoFfmpegDecoder = (TXCVideoFfmpegDecoder) weakReference.get();
        if (tXCVideoFfmpegDecoder != null) {
            d dVar = tXCVideoFfmpegDecoder.mListener;
            if (dVar != null) {
                dVar.a(j, i, i2, j2, j3);
                if (!(tXCVideoFfmpegDecoder.mVideoWidth == i && tXCVideoFfmpegDecoder.mVideoHeight == i2)) {
                    tXCVideoFfmpegDecoder.mVideoWidth = i;
                    tXCVideoFfmpegDecoder.mVideoHeight = i2;
                    dVar.a(tXCVideoFfmpegDecoder.mVideoWidth, tXCVideoFfmpegDecoder.mVideoHeight);
                }
            }
        }
        AppMethodBeat.o(67800);
    }

    public void loadNativeData(byte[] bArr, long j, int i) {
        AppMethodBeat.i(67801);
        nativeLoadRawData(bArr, j, i);
        AppMethodBeat.o(67801);
    }

    static {
        AppMethodBeat.i(67802);
        com.tencent.liteav.basic.util.b.e();
        nativeClassInit();
        AppMethodBeat.o(67802);
    }
}
