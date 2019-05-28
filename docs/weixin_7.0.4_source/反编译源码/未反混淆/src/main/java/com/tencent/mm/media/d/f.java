package com.tencent.mm.media.d;

import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\f\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Landroid/media/MediaCodec;", "isEnd", "", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "release", "plugin-mediaeditor_release"})
public final class f extends b {
    final String TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    HandlerThread eSP;
    volatile boolean eTf;
    private Handler eVO;
    private a eVP;
    MediaCodec eVq;
    private long startTime;

    @l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class a extends Callback {
        final /* synthetic */ f eVQ;

        a(f fVar) {
            this.eVQ = fVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.i(12953);
            j.p(mediaCodec, "codec");
            j.p(bufferInfo, "bufferInfo");
            ab.d(this.eVQ.TAG, "onOutputBufferAvailable index:" + i + ", info: " + bufferInfo);
            if (i >= 0) {
                try {
                    ByteBuffer outputBuffer = this.eVQ.eVq.getOutputBuffer(i);
                    if ((bufferInfo.flags & 2) != 0) {
                        ab.i(this.eVQ.TAG, "codec config!");
                    }
                    if ((bufferInfo.flags & 4) != 0 || this.eVQ.eTf) {
                        ab.i(this.eVQ.TAG, "encode end of stream");
                        try {
                            this.eVQ.eVq.stop();
                            this.eVQ.eVq.release();
                            this.eVQ.eTf = true;
                        } catch (Exception e) {
                            ab.e(this.eVQ.TAG, "release encoder error " + e.getMessage());
                        }
                        this.eVQ.release();
                        a.f.a.a aVar = this.eVQ.eVz;
                        if (aVar != null) {
                            aVar.invoke();
                            AppMethodBeat.o(12953);
                            return;
                        }
                        AppMethodBeat.o(12953);
                        return;
                    }
                    if (bufferInfo.size != 0) {
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        f fVar = this.eVQ;
                        j.o(outputBuffer, "outputBuffer");
                        fVar.f(outputBuffer, bufferInfo);
                        this.eVQ.eVq.releaseOutputBuffer(i, bufferInfo.presentationTimeUs);
                    }
                    AppMethodBeat.o(12953);
                    return;
                } catch (Exception e2) {
                    ab.printErrStackTrace(this.eVQ.TAG, e2, "onOutputBufferAvailable error", new Object[0]);
                    if (this.eVQ.eTO) {
                        com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                        com.tencent.mm.media.i.c.VX();
                    }
                    AppMethodBeat.o(12953);
                    return;
                }
            }
            this.eVQ.eVq.releaseOutputBuffer(i, false);
            AppMethodBeat.o(12953);
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.i(12954);
            j.p(mediaCodec, "codec");
            ab.i(this.eVQ.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(i)));
            AppMethodBeat.o(12954);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(12955);
            j.p(mediaCodec, "codec");
            j.p(mediaFormat, "format");
            ab.i(this.eVQ.TAG, "encoder output format changed " + this.eVQ.eVq.getOutputFormat());
            AppMethodBeat.o(12955);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
            AppMethodBeat.i(12956);
            j.p(mediaCodec, "codec");
            j.p(codecException, "e");
            ab.e(this.eVQ.TAG, "codec Error, e:".concat(String.valueOf(codecException)));
            if (this.eVQ.eTO) {
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VY();
            }
            AppMethodBeat.o(12956);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ f eVQ;

        c(f fVar) {
            this.eVQ = fVar;
        }

        public final void run() {
            AppMethodBeat.i(12958);
            try {
                this.eVQ.eSP.quitSafely();
                AppMethodBeat.o(12958);
            } catch (Exception e) {
                ab.printErrStackTrace(this.eVQ.TAG, e, "release error:" + e.getMessage(), new Object[0]);
                AppMethodBeat.o(12958);
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ f eVQ;

        b(f fVar) {
            this.eVQ = fVar;
        }

        public final void run() {
            AppMethodBeat.i(12957);
            try {
                ab.i(this.eVQ.TAG, "finishEncode, isEnd:" + this.eVQ.eTf);
                if (this.eVQ.eTf) {
                    AppMethodBeat.o(12957);
                    return;
                }
                this.eVQ.eTf = true;
                this.eVQ.eVq.signalEndOfInputStream();
                AppMethodBeat.o(12957);
            } catch (Exception e) {
                ab.e(this.eVQ.TAG, "release encoder error " + e.getMessage());
                AppMethodBeat.o(12957);
            }
        }
    }

    public f(com.tencent.mm.media.b.c cVar, a.f.a.b<? super b, y> bVar) {
        j.p(cVar, "videoCodecConfig");
        super(cVar, bVar);
        AppMethodBeat.i(12963);
        MediaCodec createByCodecName = MediaCodec.createByCodecName(cVar.name);
        j.o(createByCodecName, "MediaCodec.createByCodec…me(videoCodecConfig.name)");
        this.eVq = createByCodecName;
        HandlerThread anM = d.anM("MediaCodecTransEncoder_encodeThread");
        j.o(anM, "ThreadPool.newFreeHandle…ansEncoder_encodeThread\")");
        this.eSP = anM;
        this.eVP = new a(this);
        this.eVq.configure(cVar.Ux(), null, null, 1);
        if (com.tencent.mm.compatible.util.d.iW(23)) {
            this.eSP.start();
            this.eVO = new Handler(this.eSP.getLooper());
            MediaCodec mediaCodec = this.eVq;
            Callback callback = this.eVP;
            Handler handler = this.eVO;
            if (handler == null) {
                j.avw("encodeHandler");
            }
            mediaCodec.setCallback(callback, handler);
        } else {
            this.eVq.setCallback(this.eVP);
        }
        Surface createInputSurface = this.eVq.createInputSurface();
        j.o(createInputSurface, "encoder.createInputSurface()");
        e(createInputSurface);
        this.eVq.start();
        bVar.am(this);
        AppMethodBeat.o(12963);
    }

    public final void UP() {
        AppMethodBeat.i(12959);
        if (0 == this.startTime) {
            this.startTime = bo.yz();
        }
        AppMethodBeat.o(12959);
    }

    public final void UO() {
        AppMethodBeat.i(12960);
        Handler handler = this.eVO;
        if (handler == null) {
            j.avw("encodeHandler");
        }
        handler.post(new b(this));
        AppMethodBeat.o(12960);
    }

    public final void release() {
        AppMethodBeat.i(12961);
        ab.i(this.TAG, "release");
        Handler handler = this.eVO;
        if (handler == null) {
            j.avw("encodeHandler");
        }
        handler.post(new c(this));
        AppMethodBeat.o(12961);
    }

    public final long UQ() {
        AppMethodBeat.i(12962);
        long yz = bo.yz() - this.startTime;
        AppMethodBeat.o(12962);
        return yz;
    }
}
