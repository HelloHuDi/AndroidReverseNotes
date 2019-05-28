package com.tencent.liteav.videoencoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.liteav.videoencoder.c */
public class C0981c extends C32147a {
    protected C8796g mEncodeFilter;
    private boolean mEncodeFirstGOP = false;
    protected Object mGLContextExternal = null;
    protected boolean mInit;
    protected C8796g mInputFilter;
    protected int mInputHeight = 0;
    protected int mInputTextureID = -1;
    protected int mInputWidth = 0;
    protected C0982d mListener = null;
    protected int mOutputHeight = 0;
    protected int mOutputWidth = 0;
    private long mVideoGOPEncode = 0;

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        if (tXSVideoEncoderParam != null) {
            this.mOutputWidth = tXSVideoEncoderParam.width;
            this.mOutputHeight = tXSVideoEncoderParam.height;
            this.mInputWidth = tXSVideoEncoderParam.width;
            this.mInputHeight = tXSVideoEncoderParam.height;
            this.mGLContextExternal = tXSVideoEncoderParam.glContext;
        }
        this.mVideoGOPEncode = 0;
        this.mEncodeFirstGOP = false;
        return 10000002;
    }

    public void stop() {
    }

    public void setListener(C0982d c0982d) {
        this.mListener = c0982d;
    }

    public void setFPS(int i) {
    }

    public void setBitrate(int i) {
    }

    public long getRealFPS() {
        return 0;
    }

    public long getRealBitrate() {
        return 0;
    }

    public int getVideoWidth() {
        return this.mOutputWidth;
    }

    public int getVideoHeight() {
        return this.mOutputHeight;
    }

    public long pushVideoFrame(int i, int i2, int i3, long j) {
        return 10000002;
    }

    public long pushVideoFrameSync(int i, int i2, int i3, long j) {
        return 10000002;
    }

    public void signalEOSAndFlush() {
    }

    /* Access modifiers changed, original: protected */
    public void callDelegate(int i) {
        AppMethodBeat.m2504i(67442);
        callDelegate(null, 0, 0, 0, 0, 0, 0, 0, i, null, null);
        AppMethodBeat.m2505o(67442);
    }

    /* Access modifiers changed, original: protected */
    public void callDelegate(byte[] bArr, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        BufferInfo bufferInfo2;
        AppMethodBeat.m2504i(67443);
        ByteBuffer asReadOnlyBuffer = byteBuffer == null ? null : byteBuffer.asReadOnlyBuffer();
        if (bufferInfo == null) {
            bufferInfo2 = null;
        } else {
            bufferInfo2 = new BufferInfo();
        }
        if (bufferInfo2 != null) {
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
        }
        C0982d c0982d = this.mListener;
        if (c0982d != null) {
            C25649b c25649b = new C25649b();
            c25649b.f5251a = bArr;
            c25649b.f5252b = i;
            c25649b.f5253c = j;
            c25649b.f5254d = j2;
            c25649b.f5255e = j3;
            c25649b.f5256f = j4;
            c25649b.f5257g = j5;
            c25649b.f5258h = j6;
            c25649b.f5260j = asReadOnlyBuffer;
            if (bufferInfo2 != null) {
                c25649b.f5261k = bufferInfo2;
            }
            c0982d.mo3950a(c25649b, i2);
            setStatusValue(WearableStatusCodes.UNKNOWN_LISTENER, Long.valueOf(getRealBitrate()));
            setStatusValue(WearableStatusCodes.DUPLICATE_LISTENER, Double.valueOf((double) getRealFPS()));
            if (i == 0) {
                if (this.mVideoGOPEncode != 0) {
                    this.mEncodeFirstGOP = true;
                    setStatusValue(WearableStatusCodes.DATA_ITEM_TOO_LARGE, Long.valueOf(this.mVideoGOPEncode));
                }
                this.mVideoGOPEncode = 1;
                AppMethodBeat.m2505o(67443);
                return;
            }
            this.mVideoGOPEncode++;
            if (!this.mEncodeFirstGOP) {
                setStatusValue(WearableStatusCodes.DATA_ITEM_TOO_LARGE, Long.valueOf(this.mVideoGOPEncode));
            }
        }
        AppMethodBeat.m2505o(67443);
    }

    /* Access modifiers changed, original: protected */
    public void callDelegate(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(67444);
        if (this.mListener != null) {
            this.mListener.mo3949a(mediaFormat);
        }
        AppMethodBeat.m2505o(67444);
    }
}
