package com.tencent.liteav.videoencoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.basic.g.b;
import com.tencent.liteav.basic.module.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class c extends a {
    protected g mEncodeFilter;
    private boolean mEncodeFirstGOP = false;
    protected Object mGLContextExternal = null;
    protected boolean mInit;
    protected g mInputFilter;
    protected int mInputHeight = 0;
    protected int mInputTextureID = -1;
    protected int mInputWidth = 0;
    protected d mListener = null;
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

    public void setListener(d dVar) {
        this.mListener = dVar;
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
        AppMethodBeat.i(67442);
        callDelegate(null, 0, 0, 0, 0, 0, 0, 0, i, null, null);
        AppMethodBeat.o(67442);
    }

    /* Access modifiers changed, original: protected */
    public void callDelegate(byte[] bArr, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        BufferInfo bufferInfo2;
        AppMethodBeat.i(67443);
        ByteBuffer asReadOnlyBuffer = byteBuffer == null ? null : byteBuffer.asReadOnlyBuffer();
        if (bufferInfo == null) {
            bufferInfo2 = null;
        } else {
            bufferInfo2 = new BufferInfo();
        }
        if (bufferInfo2 != null) {
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
        }
        d dVar = this.mListener;
        if (dVar != null) {
            b bVar = new b();
            bVar.a = bArr;
            bVar.b = i;
            bVar.c = j;
            bVar.d = j2;
            bVar.e = j3;
            bVar.f = j4;
            bVar.g = j5;
            bVar.h = j6;
            bVar.j = asReadOnlyBuffer;
            if (bufferInfo2 != null) {
                bVar.k = bufferInfo2;
            }
            dVar.a(bVar, i2);
            setStatusValue(WearableStatusCodes.UNKNOWN_LISTENER, Long.valueOf(getRealBitrate()));
            setStatusValue(WearableStatusCodes.DUPLICATE_LISTENER, Double.valueOf((double) getRealFPS()));
            if (i == 0) {
                if (this.mVideoGOPEncode != 0) {
                    this.mEncodeFirstGOP = true;
                    setStatusValue(WearableStatusCodes.DATA_ITEM_TOO_LARGE, Long.valueOf(this.mVideoGOPEncode));
                }
                this.mVideoGOPEncode = 1;
                AppMethodBeat.o(67443);
                return;
            }
            this.mVideoGOPEncode++;
            if (!this.mEncodeFirstGOP) {
                setStatusValue(WearableStatusCodes.DATA_ITEM_TOO_LARGE, Long.valueOf(this.mVideoGOPEncode));
            }
        }
        AppMethodBeat.o(67443);
    }

    /* Access modifiers changed, original: protected */
    public void callDelegate(MediaFormat mediaFormat) {
        AppMethodBeat.i(67444);
        if (this.mListener != null) {
            this.mListener.a(mediaFormat);
        }
        AppMethodBeat.o(67444);
    }
}
