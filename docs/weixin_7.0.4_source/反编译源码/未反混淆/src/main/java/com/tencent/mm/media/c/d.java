package com.tencent.mm.media.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\n\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "zeroCount", "", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class d extends a {
    private static final String TAG = TAG;
    public static final a eTW = new a();
    private int eTT;
    private long eTU;
    private Callback eTV;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$Companion;", "", "()V", "DecodePadingMs", "", "TAG", "", "ZeroCountUpperBound", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class b extends Callback {
        final /* synthetic */ d eTX;
        final /* synthetic */ String eTY;
        final /* synthetic */ long eTZ;
        final /* synthetic */ com.tencent.mm.media.e.a eUa;

        b(d dVar, String str, long j, com.tencent.mm.media.e.a aVar) {
            this.eTX = dVar;
            this.eTY = str;
            this.eTZ = j;
            this.eUa = aVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.i(12856);
            j.p(bufferInfo, "bufferInfo");
            try {
                ab.i(d.TAG, "onOutputBufferAvailable, index:" + i + ", bufferInfo:" + bufferInfo + " size:" + bufferInfo.size + this.eTY);
                if (i >= 0) {
                    long j = bufferInfo.presentationTimeUs;
                    ab.i(d.TAG, "presentationTimeUs : ".concat(String.valueOf(j)));
                    if (j < this.eTZ * 1000 && (bufferInfo.flags & 4) == 0) {
                        this.eTX.Uy().releaseOutputBuffer(i, false);
                        ab.i(d.TAG, "decoder pts: " + j + ", not reach start: " + (this.eTZ * 1000) + ", audioId:" + this.eTY);
                        AppMethodBeat.o(12856);
                        return;
                    } else if (bufferInfo.size == 0) {
                        ab.i(d.TAG, "decode zero size:" + this.eTY + ", zeroCount:" + this.eTX.eTT);
                        d dVar = this.eTX;
                        dVar.eTT = dVar.eTT + 1;
                        this.eTX.Uy().releaseOutputBuffer(i, false);
                        AppMethodBeat.o(12856);
                        return;
                    } else {
                        this.eTX.e(this.eTX.Uy().getOutputBuffer(i), bufferInfo);
                        this.eTX.Uy().releaseOutputBuffer(i, false);
                        if (this.eTX.eTU * 1000 == 1 || j < this.eTX.eTU * 1000) {
                            if ((bufferInfo.flags & 4) != 0) {
                                ab.i(d.TAG, "receive eos! audioId:" + this.eTY);
                                this.eTX.UA();
                                AppMethodBeat.o(12856);
                                return;
                            }
                            AppMethodBeat.o(12856);
                            return;
                        }
                        ab.e(d.TAG, "exceed endTimeMs, audioId:" + this.eTY);
                        this.eTX.UA();
                        AppMethodBeat.o(12856);
                        return;
                    }
                }
                this.eTX.Uy().releaseOutputBuffer(i, false);
                AppMethodBeat.o(12856);
            } catch (Exception e) {
                ab.printErrStackTrace(d.TAG, e, "", new Object[0]);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.i(12857);
            try {
                ab.i(d.TAG, "onInputBufferAvailable, index:" + i + ", audioId:" + this.eTY);
                this.eTX.eTv = bo.yz();
                if (i < 0) {
                    AppMethodBeat.o(12857);
                    return;
                }
                int i2;
                int i3;
                int i4;
                int i5;
                ByteBuffer inputBuffer = this.eTX.Uy().getInputBuffer(i);
                if (inputBuffer != null) {
                    inputBuffer.clear();
                }
                com.tencent.mm.media.e.a aVar = this.eUa;
                j.o(inputBuffer, "inputBuffer");
                if (aVar.k(inputBuffer)) {
                    i2 = 0;
                } else {
                    ab.i(d.TAG, "read sample end");
                    i2 = 1;
                }
                long j = 0;
                if (i2 == 0) {
                    i3 = this.eUa.sampleSize;
                    inputBuffer.position(0);
                    j = this.eUa.getSampleTime();
                    ab.i(d.TAG, "sampleTime : " + j + ", sampleSize:" + i3 + ", audioId:" + this.eTY);
                    if (i3 < 0 || j >= this.eTX.eTU * 1000) {
                        ab.i(d.TAG, "sawInputEOS, audioId:" + this.eTY);
                        i4 = 1;
                    } else {
                        i4 = i2;
                    }
                } else {
                    i3 = 0;
                    i4 = i2;
                }
                MediaCodec Uy = this.eTX.Uy();
                if (i4 != 0) {
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                Uy.queueInputBuffer(i, 0, i3, j, i5);
                if (i4 != 0) {
                    this.eTX.UA();
                    AppMethodBeat.o(12857);
                    return;
                }
                AppMethodBeat.o(12857);
            } catch (Exception e) {
                ab.printErrStackTrace(d.TAG, e, "", new Object[0]);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(12858);
            this.eTX.mMediaFormat = mediaFormat;
            ab.i(d.TAG, "onOutputFormatChanged:" + this.eTX.mMediaFormat + ", audioId:" + this.eTY);
            AppMethodBeat.o(12858);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
        }
    }

    public d(com.tencent.mm.media.e.a aVar, String str, long j, long j2, m<? super byte[], ? super Long, y> mVar, a.f.a.a<y> aVar2) {
        j.p(aVar, "mediaExtractorWrapper");
        j.p(str, "audioId");
        j.p(mVar, "frameDecodeCallback");
        j.p(aVar2, "frameDecodeEndCallback");
        super(aVar, str, j, j2, mVar, aVar2);
        AppMethodBeat.i(12860);
        this.eTU = j2;
        this.eTV = new b(this, str, j, aVar);
        Uy().setCallback(this.eTV);
        AppMethodBeat.o(12860);
    }

    public final void Uz() {
        AppMethodBeat.i(12859);
        try {
            Uy().start();
            ab.i(TAG, "startDecoder " + this.ckD);
            AppMethodBeat.o(12859);
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "startDecoder error", new Object[0]);
            AppMethodBeat.o(12859);
        }
    }

    static {
        AppMethodBeat.i(12861);
        AppMethodBeat.o(12861);
    }
}
