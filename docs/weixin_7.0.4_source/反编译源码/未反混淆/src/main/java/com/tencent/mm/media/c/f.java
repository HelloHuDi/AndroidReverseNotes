package com.tencent.mm.media.c;

import a.f.a.b;
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
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0011\u0018\u00002\u00020\u0001BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
public final class f extends b {
    final String TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    volatile boolean eUb;
    private HandlerThread eUd = d.anM("MediaCodecTransDecoderAsync_decodeThread");
    private boolean eUe;
    private final a eUf;

    @l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class a extends Callback {
        final /* synthetic */ com.tencent.mm.media.e.a eUa;
        final /* synthetic */ f eUg;
        final /* synthetic */ Surface eUh;

        a(f fVar, Surface surface, com.tencent.mm.media.e.a aVar) {
            this.eUg = fVar;
            this.eUh = surface;
            this.eUa = aVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.i(12867);
            j.p(mediaCodec, "codec");
            j.p(bufferInfo, "bufferInfo");
            ab.i(this.eUg.TAG, "onOutputBufferAvailable, index:" + i + ", bufferInfo:" + bufferInfo + " size:" + bufferInfo.size);
            if (i >= 0) {
                try {
                    long j = bufferInfo.presentationTimeUs;
                    ab.i(this.eUg.TAG, "presentationTimeUs : ".concat(String.valueOf(j)));
                    if (j >= this.eUg.bqO * 1000 || (bufferInfo.flags & 4) != 0) {
                        this.eUg.a(bufferInfo);
                        this.eUg.Uy().releaseOutputBuffer(i, this.eUh != null);
                        if (this.eUg.eTA * 1000 == 1 || j < this.eUg.eTA * 1000) {
                            if ((bufferInfo.flags & 4) != 0 || this.eUg.eUb) {
                                ab.i(this.eUg.TAG, "receive eos!");
                                this.eUg.sI();
                                f.a(this.eUg);
                                AppMethodBeat.o(12867);
                                return;
                            }
                            AppMethodBeat.o(12867);
                            return;
                        }
                        ab.e(this.eUg.TAG, "exceed endTimeMs");
                        this.eUg.sI();
                        f.a(this.eUg);
                        AppMethodBeat.o(12867);
                        return;
                    }
                    this.eUg.Uy().releaseOutputBuffer(i, false);
                    ab.i(this.eUg.TAG, "decoder pts: " + j + ", not reach start: " + (this.eUg.bqO * 1000));
                    AppMethodBeat.o(12867);
                } catch (Exception e) {
                    ab.printErrStackTrace(this.eUg.TAG, e, "onOutputBufferAvailable error", new Object[0]);
                    if (this.eUg.eTO) {
                        c cVar = c.faj;
                        c.VV();
                    }
                }
            } else {
                this.eUg.Uy().releaseOutputBuffer(i, false);
                AppMethodBeat.o(12867);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.i(12868);
            j.p(mediaCodec, "codec");
            ab.i(this.eUg.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(i)));
            if (i >= 0) {
                try {
                    int i2;
                    this.eUg.eUb = false;
                    ByteBuffer inputBuffer = this.eUg.Uy().getInputBuffer(i);
                    inputBuffer.clear();
                    com.tencent.mm.media.e.a aVar = this.eUa;
                    j.o(inputBuffer, "inputBuffer");
                    if (!aVar.k(inputBuffer)) {
                        ab.i(this.eUg.TAG, "read sample end");
                        this.eUg.eUb = true;
                    }
                    long j = 0;
                    if (this.eUg.eUb) {
                        i2 = 0;
                    } else {
                        i2 = this.eUa.sampleSize;
                        inputBuffer.position(0);
                        j = this.eUa.getSampleTime();
                        ab.i(this.eUg.TAG, "sampleTime : " + j + ", sampleSize:" + i2);
                        if (i2 < 0 || j >= this.eUg.eTA * 1000) {
                            this.eUg.eUb = true;
                            ab.i(this.eUg.TAG, "sawInputEOS");
                        }
                    }
                    this.eUg.Uy().queueInputBuffer(i, 0, i2, j, this.eUg.eUb ? 4 : 0);
                    AppMethodBeat.o(12868);
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace(this.eUg.TAG, e, "onInputBufferAvailable error", new Object[0]);
                    if (this.eUg.eTO) {
                        c cVar = c.faj;
                        c.VV();
                    }
                }
            }
            AppMethodBeat.o(12868);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(12869);
            j.p(mediaCodec, "codec");
            j.p(mediaFormat, "format");
            this.eUg.mediaFormat = mediaFormat;
            ab.i(this.eUg.TAG, "decoder output format changed: " + this.eUg.mediaFormat);
            MediaFormat mediaFormat2 = this.eUg.mediaFormat;
            if (mediaFormat2 != null) {
                b bVar = this.eUg.eTI;
                if (bVar != null) {
                    bVar.am(mediaFormat2);
                    AppMethodBeat.o(12869);
                    return;
                }
                AppMethodBeat.o(12869);
                return;
            }
            AppMethodBeat.o(12869);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
            c cVar;
            AppMethodBeat.i(12870);
            j.p(mediaCodec, "codec");
            j.p(codecException, "e");
            ab.e(this.eUg.TAG, "onError, codec:" + mediaCodec + ", " + codecException.isRecoverable() + ' ' + codecException.isTransient() + ' ' + codecException.getDiagnosticInfo());
            if (this.eUg.eTO) {
                cVar = c.faj;
                c.VW();
            }
            if (!(codecException.isRecoverable() || codecException.isTransient())) {
                cVar = c.faj;
                c.yj();
                this.eUg.sI();
                f.a(this.eUg);
            }
            AppMethodBeat.o(12870);
        }
    }

    public f(long j, long j2, com.tencent.mm.media.e.a aVar, Surface surface, b<? super b, y> bVar) {
        j.p(aVar, "mediaExtractorWrapper");
        super(j, j2, aVar, surface);
        AppMethodBeat.i(12873);
        this.eUf = new a(this, surface, aVar);
        try {
            this.mediaFormat = aVar.eWe;
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(aVar.UV());
            j.o(createDecoderByType, "MediaCodec.createDecoder…orWrapper.getVideoMIME())");
            a(createDecoderByType);
            Uy().configure(this.mediaFormat, surface, null, 0);
            if (com.tencent.mm.compatible.util.d.iW(23)) {
                this.eUd.start();
                HandlerThread handlerThread = this.eUd;
                j.o(handlerThread, "decoderThread");
                Uy().setCallback(this.eUf, new Handler(handlerThread.getLooper()));
            } else {
                Uy().setCallback(this.eUf);
            }
            bVar.am(this);
            AppMethodBeat.o(12873);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "create decoder error:" + e.getMessage(), new Object[0]);
            Throwable illegalStateException = new IllegalStateException("init decoder error");
            AppMethodBeat.o(12873);
            throw illegalStateException;
        }
    }

    public final void UB() {
        AppMethodBeat.i(12871);
        try {
            Uy().start();
            AppMethodBeat.o(12871);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "startDecode error", new Object[0]);
            AppMethodBeat.o(12871);
        }
    }

    public final void sI() {
        AppMethodBeat.i(12872);
        super.sI();
        try {
            this.eUd.quit();
            AppMethodBeat.o(12872);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "releaseDecoder error:" + e.getMessage(), new Object[0]);
            AppMethodBeat.o(12872);
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(12874);
        if (!fVar.eUe) {
            a.f.a.a aVar = fVar.eTH;
            if (aVar != null) {
                aVar.invoke();
            }
            fVar.eUe = true;
        }
        AppMethodBeat.o(12874);
    }
}
