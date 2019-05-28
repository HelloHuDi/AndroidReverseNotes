package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.basic.p141e.C8796g.C8799a;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.beauty.p144b.C45106n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder extends C0981c {
    private static final boolean DEBUG = false;
    private static final String TAG = TXCSWVideoEncoder.class.getSimpleName();
    private int mBitrate = 0;
    private long mNativeX264Encoder = 0;
    private long mPTS = 0;
    private int mPopIdx = 0;
    private int mPushIdx = 0;
    private C8796g mRawFrameFilter;
    private int mRendIdx = 0;
    private C8796g mResizeFilter;

    private static native void nativeClassInit();

    private native int nativeEncode(long j, int i, int i2, int i3, long j2);

    private native int nativeEncodeSync(long j, int i, int i2, int i3, long j2);

    private native long nativeGetRealFPS(long j);

    private native long nativeInit(WeakReference<TXCSWVideoEncoder> weakReference);

    private native void nativeRelease(long j);

    private native void nativeSetBitrate(long j, int i);

    private native void nativeSignalEOSAndFlush(long j);

    private native int nativeStart(long j, TXSVideoEncoderParam tXSVideoEncoderParam);

    private native void nativeStop(long j);

    private native long nativegetRealBitrate(long j);

    static /* synthetic */ int access$200(TXCSWVideoEncoder tXCSWVideoEncoder, long j, int i, int i2, int i3, long j2) {
        AppMethodBeat.m2504i(67407);
        int nativeEncodeSync = tXCSWVideoEncoder.nativeEncodeSync(j, i, i2, i3, j2);
        AppMethodBeat.m2505o(67407);
        return nativeEncodeSync;
    }

    static /* synthetic */ int access$300(TXCSWVideoEncoder tXCSWVideoEncoder, long j, int i, int i2, int i3, long j2) {
        AppMethodBeat.m2504i(67408);
        int nativeEncode = tXCSWVideoEncoder.nativeEncode(j, i, i2, i3, j2);
        AppMethodBeat.m2505o(67408);
        return nativeEncode;
    }

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        AppMethodBeat.m2504i(67397);
        super.start(tXSVideoEncoderParam);
        int i = ((tXSVideoEncoderParam.width + 7) / 8) * 8;
        int i2 = ((tXSVideoEncoderParam.height + 1) / 2) * 2;
        if (!(i == tXSVideoEncoderParam.width && i2 == tXSVideoEncoderParam.height)) {
            TXCLog.m15679w(TAG, "Encode Resolution not supportted, transforming...");
            TXCLog.m15679w(TAG, tXSVideoEncoderParam.width + VideoMaterialUtil.CRAZYFACE_X + tXSVideoEncoderParam.height + "-> " + i + VideoMaterialUtil.CRAZYFACE_X + i2);
        }
        tXSVideoEncoderParam.width = i;
        tXSVideoEncoderParam.height = i2;
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
        this.mInputWidth = i;
        this.mInputHeight = i2;
        this.mNativeX264Encoder = nativeInit(new WeakReference(this));
        nativeSetBitrate(this.mNativeX264Encoder, this.mBitrate);
        nativeStart(this.mNativeX264Encoder, tXSVideoEncoderParam);
        AppMethodBeat.m2505o(67397);
        return 0;
    }

    public void stop() {
        AppMethodBeat.m2504i(67398);
        this.mGLContextExternal = null;
        nativeStop(this.mNativeX264Encoder);
        nativeRelease(this.mNativeX264Encoder);
        this.mNativeX264Encoder = 0;
        if (this.mRawFrameFilter != null) {
            this.mRawFrameFilter.mo19883d();
            this.mRawFrameFilter = null;
        }
        if (this.mResizeFilter != null) {
            this.mResizeFilter.mo19883d();
            this.mResizeFilter = null;
        }
        super.stop();
        AppMethodBeat.m2505o(67398);
    }

    public void setFPS(int i) {
    }

    public void setBitrate(int i) {
        AppMethodBeat.m2504i(67399);
        this.mBitrate = i;
        nativeSetBitrate(this.mNativeX264Encoder, i);
        AppMethodBeat.m2505o(67399);
    }

    public long getRealFPS() {
        AppMethodBeat.m2504i(67400);
        long nativeGetRealFPS = nativeGetRealFPS(this.mNativeX264Encoder);
        AppMethodBeat.m2505o(67400);
        return nativeGetRealFPS;
    }

    public long getRealBitrate() {
        AppMethodBeat.m2504i(67401);
        long nativegetRealBitrate = nativegetRealBitrate(this.mNativeX264Encoder);
        AppMethodBeat.m2505o(67401);
        return nativegetRealBitrate;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67402);
        long pushVideoFrameInternal = pushVideoFrameInternal(i, i2, i3, j, false);
        AppMethodBeat.m2505o(67402);
        return pushVideoFrameInternal;
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67403);
        long pushVideoFrameInternal = pushVideoFrameInternal(i, i2, i3, j, true);
        AppMethodBeat.m2505o(67403);
        return pushVideoFrameInternal;
    }

    public void signalEOSAndFlush() {
        AppMethodBeat.m2504i(67404);
        nativeSignalEOSAndFlush(this.mNativeX264Encoder);
        AppMethodBeat.m2505o(67404);
    }

    private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> weakReference, byte[] bArr, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2) {
        AppMethodBeat.m2504i(67405);
        TXCSWVideoEncoder tXCSWVideoEncoder = (TXCSWVideoEncoder) weakReference.get();
        if (tXCSWVideoEncoder != null) {
            tXCSWVideoEncoder.callDelegate(bArr, i, j, j2, j3, j4, j5, j6, i2, null, null);
        }
        AppMethodBeat.m2505o(67405);
    }

    private long pushVideoFrameInternal(int i, int i2, int i3, long j, final boolean z) {
        AppMethodBeat.m2504i(67406);
        if (this.mGLContextExternal != null) {
            if (!(this.mInputWidth == i2 && this.mInputHeight == i3)) {
                this.mInputWidth = i2;
                this.mInputHeight = i3;
                if (this.mResizeFilter == null) {
                    this.mResizeFilter = new C8796g();
                    this.mResizeFilter.mo19876a();
                    this.mResizeFilter.mo19873a(true);
                }
                this.mResizeFilter.mo3839a(this.mOutputWidth, this.mOutputHeight);
            }
            GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
            if (this.mResizeFilter != null) {
                this.mResizeFilter.mo3840b(i);
            }
            if (this.mResizeFilter != null) {
                i = this.mResizeFilter.mo19890l();
            }
            int[] iArr = new int[1];
            this.mPTS = j;
            if (this.mRawFrameFilter == null) {
                this.mRawFrameFilter = new C45106n(1);
                this.mRawFrameFilter.mo19873a(true);
                if (this.mRawFrameFilter.mo19876a()) {
                    this.mRawFrameFilter.mo3839a(this.mOutputWidth, this.mOutputHeight);
                    this.mRawFrameFilter.mo19871a(new C8799a() {
                        /* renamed from: a */
                        public void mo19897a(int i) {
                            AppMethodBeat.m2504i(67412);
                            if (z) {
                                TXCSWVideoEncoder.access$200(TXCSWVideoEncoder.this, TXCSWVideoEncoder.this.mNativeX264Encoder, i, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
                                AppMethodBeat.m2505o(67412);
                                return;
                            }
                            TXCSWVideoEncoder.access$300(TXCSWVideoEncoder.this, TXCSWVideoEncoder.this.mNativeX264Encoder, i, TXCSWVideoEncoder.this.mOutputWidth, TXCSWVideoEncoder.this.mOutputHeight, TXCSWVideoEncoder.this.mPTS);
                            AppMethodBeat.m2505o(67412);
                        }
                    });
                } else {
                    this.mRawFrameFilter = null;
                    AppMethodBeat.m2505o(67406);
                    return 10000004;
                }
            }
            if (this.mRawFrameFilter == null) {
                AppMethodBeat.m2505o(67406);
                return 10000004;
            }
            GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
            this.mRawFrameFilter.mo3840b(i);
            int i4 = iArr[0];
            if (i4 != 0) {
                callDelegate(i4);
            }
        }
        AppMethodBeat.m2505o(67406);
        return 0;
    }

    static {
        AppMethodBeat.m2504i(67409);
        C17778b.m27756e();
        nativeClassInit();
        AppMethodBeat.m2505o(67409);
    }
}
