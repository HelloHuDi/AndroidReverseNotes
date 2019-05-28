package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCVideoFfmpegDecoder implements C25680a {
    private boolean mFirstDec;
    private C37377d mListener;
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

    public void setListener(C37377d c37377d) {
        this.mListener = c37377d;
    }

    public void setNotifyListener(WeakReference<C0946a> weakReference) {
    }

    public int config(Surface surface) {
        return 0;
    }

    public void decode(C25649b c25649b) {
        AppMethodBeat.m2504i(67797);
        if (this.mFirstDec) {
            if (!(this.mSps == null || this.mPps == null)) {
                byte[] array = this.mSps.array();
                byte[] array2 = this.mPps.array();
                byte[] bArr = new byte[(array.length + array2.length)];
                System.arraycopy(array, 0, bArr, 0, array.length);
                System.arraycopy(array2, 0, bArr, array.length, array2.length);
                nativeDecode(bArr, c25649b.f5257g - 1, c25649b.f5258h - 1);
            }
            this.mFirstDec = false;
        }
        nativeDecode(c25649b.f5251a, c25649b.f5257g, c25649b.f5258h);
        AppMethodBeat.m2505o(67797);
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(67798);
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mFirstDec = true;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        nativeInit(new WeakReference(this), z);
        AppMethodBeat.m2505o(67798);
        return 0;
    }

    public void stop() {
        AppMethodBeat.m2504i(67799);
        nativeRelease();
        AppMethodBeat.m2505o(67799);
    }

    public boolean isHevc() {
        return false;
    }

    private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> weakReference, long j, int i, int i2, long j2, long j3) {
        AppMethodBeat.m2504i(67800);
        TXCVideoFfmpegDecoder tXCVideoFfmpegDecoder = (TXCVideoFfmpegDecoder) weakReference.get();
        if (tXCVideoFfmpegDecoder != null) {
            C37377d c37377d = tXCVideoFfmpegDecoder.mListener;
            if (c37377d != null) {
                c37377d.mo20007a(j, i, i2, j2, j3);
                if (!(tXCVideoFfmpegDecoder.mVideoWidth == i && tXCVideoFfmpegDecoder.mVideoHeight == i2)) {
                    tXCVideoFfmpegDecoder.mVideoWidth = i;
                    tXCVideoFfmpegDecoder.mVideoHeight = i2;
                    c37377d.mo20005a(tXCVideoFfmpegDecoder.mVideoWidth, tXCVideoFfmpegDecoder.mVideoHeight);
                }
            }
        }
        AppMethodBeat.m2505o(67800);
    }

    public void loadNativeData(byte[] bArr, long j, int i) {
        AppMethodBeat.m2504i(67801);
        nativeLoadRawData(bArr, j, i);
        AppMethodBeat.m2505o(67801);
    }

    static {
        AppMethodBeat.m2504i(67802);
        C17778b.m27756e();
        nativeClassInit();
        AppMethodBeat.m2505o(67802);
    }
}
