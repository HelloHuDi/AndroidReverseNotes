package com.tencent.p177mm.media.p865c;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\n\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "Landroid/media/MediaCodec$Callback;", "endTimeMsChanged", "zeroCount", "", "startDecoder", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.c.d */
public final class C42166d extends C18580a {
    private static final String TAG = TAG;
    public static final C26374a eTW = new C26374a();
    private int eTT;
    private long eTU;
    private Callback eTV;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$Companion;", "", "()V", "DecodePadingMs", "", "TAG", "", "ZeroCountUpperBound", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.c.d$a */
    public static final class C26374a {
        private C26374a() {
        }

        public /* synthetic */ C26374a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/media/decoder/MediaCodecAACDecoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.c.d$b */
    public static final class C42165b extends Callback {
        final /* synthetic */ C42166d eTX;
        final /* synthetic */ String eTY;
        final /* synthetic */ long eTZ;
        final /* synthetic */ C32742a eUa;

        C42165b(C42166d c42166d, String str, long j, C32742a c32742a) {
            this.eTX = c42166d;
            this.eTY = str;
            this.eTZ = j;
            this.eUa = c32742a;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.m2504i(12856);
            C25052j.m39376p(bufferInfo, "bufferInfo");
            try {
                C4990ab.m7416i(C42166d.TAG, "onOutputBufferAvailable, index:" + i + ", bufferInfo:" + bufferInfo + " size:" + bufferInfo.size + this.eTY);
                if (i >= 0) {
                    long j = bufferInfo.presentationTimeUs;
                    C4990ab.m7416i(C42166d.TAG, "presentationTimeUs : ".concat(String.valueOf(j)));
                    if (j < this.eTZ * 1000 && (bufferInfo.flags & 4) == 0) {
                        this.eTX.mo33815Uy().releaseOutputBuffer(i, false);
                        C4990ab.m7416i(C42166d.TAG, "decoder pts: " + j + ", not reach start: " + (this.eTZ * 1000) + ", audioId:" + this.eTY);
                        AppMethodBeat.m2505o(12856);
                        return;
                    } else if (bufferInfo.size == 0) {
                        C4990ab.m7416i(C42166d.TAG, "decode zero size:" + this.eTY + ", zeroCount:" + this.eTX.eTT);
                        C42166d c42166d = this.eTX;
                        c42166d.eTT = c42166d.eTT + 1;
                        this.eTX.mo33815Uy().releaseOutputBuffer(i, false);
                        AppMethodBeat.m2505o(12856);
                        return;
                    } else {
                        this.eTX.mo33817e(this.eTX.mo33815Uy().getOutputBuffer(i), bufferInfo);
                        this.eTX.mo33815Uy().releaseOutputBuffer(i, false);
                        if (this.eTX.eTU * 1000 == 1 || j < this.eTX.eTU * 1000) {
                            if ((bufferInfo.flags & 4) != 0) {
                                C4990ab.m7416i(C42166d.TAG, "receive eos! audioId:" + this.eTY);
                                this.eTX.mo33814UA();
                                AppMethodBeat.m2505o(12856);
                                return;
                            }
                            AppMethodBeat.m2505o(12856);
                            return;
                        }
                        C4990ab.m7412e(C42166d.TAG, "exceed endTimeMs, audioId:" + this.eTY);
                        this.eTX.mo33814UA();
                        AppMethodBeat.m2505o(12856);
                        return;
                    }
                }
                this.eTX.mo33815Uy().releaseOutputBuffer(i, false);
                AppMethodBeat.m2505o(12856);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(C42166d.TAG, e, "", new Object[0]);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.m2504i(12857);
            try {
                C4990ab.m7416i(C42166d.TAG, "onInputBufferAvailable, index:" + i + ", audioId:" + this.eTY);
                this.eTX.eTv = C5046bo.m7588yz();
                if (i < 0) {
                    AppMethodBeat.m2505o(12857);
                    return;
                }
                int i2;
                int i3;
                int i4;
                int i5;
                ByteBuffer inputBuffer = this.eTX.mo33815Uy().getInputBuffer(i);
                if (inputBuffer != null) {
                    inputBuffer.clear();
                }
                C32742a c32742a = this.eUa;
                C25052j.m39375o(inputBuffer, "inputBuffer");
                if (c32742a.mo53296k(inputBuffer)) {
                    i2 = 0;
                } else {
                    C4990ab.m7416i(C42166d.TAG, "read sample end");
                    i2 = 1;
                }
                long j = 0;
                if (i2 == 0) {
                    i3 = this.eUa.sampleSize;
                    inputBuffer.position(0);
                    j = this.eUa.getSampleTime();
                    C4990ab.m7416i(C42166d.TAG, "sampleTime : " + j + ", sampleSize:" + i3 + ", audioId:" + this.eTY);
                    if (i3 < 0 || j >= this.eTX.eTU * 1000) {
                        C4990ab.m7416i(C42166d.TAG, "sawInputEOS, audioId:" + this.eTY);
                        i4 = 1;
                    } else {
                        i4 = i2;
                    }
                } else {
                    i3 = 0;
                    i4 = i2;
                }
                MediaCodec Uy = this.eTX.mo33815Uy();
                if (i4 != 0) {
                    i5 = 4;
                } else {
                    i5 = 0;
                }
                Uy.queueInputBuffer(i, 0, i3, j, i5);
                if (i4 != 0) {
                    this.eTX.mo33814UA();
                    AppMethodBeat.m2505o(12857);
                    return;
                }
                AppMethodBeat.m2505o(12857);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(C42166d.TAG, e, "", new Object[0]);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.m2504i(12858);
            this.eTX.mMediaFormat = mediaFormat;
            C4990ab.m7416i(C42166d.TAG, "onOutputFormatChanged:" + this.eTX.mMediaFormat + ", audioId:" + this.eTY);
            AppMethodBeat.m2505o(12858);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
        }
    }

    public C42166d(C32742a c32742a, String str, long j, long j2, C31591m<? super byte[], ? super Long, C37091y> c31591m, C31214a<C37091y> c31214a) {
        C25052j.m39376p(c32742a, "mediaExtractorWrapper");
        C25052j.m39376p(str, "audioId");
        C25052j.m39376p(c31591m, "frameDecodeCallback");
        C25052j.m39376p(c31214a, "frameDecodeEndCallback");
        super(c32742a, str, j, j2, c31591m, c31214a);
        AppMethodBeat.m2504i(12860);
        this.eTU = j2;
        this.eTV = new C42165b(this, str, j, c32742a);
        mo33815Uy().setCallback(this.eTV);
        AppMethodBeat.m2505o(12860);
    }

    /* renamed from: Uz */
    public final void mo33816Uz() {
        AppMethodBeat.m2504i(12859);
        try {
            mo33815Uy().start();
            C4990ab.m7416i(TAG, "startDecoder " + this.ckD);
            AppMethodBeat.m2505o(12859);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "startDecoder error", new Object[0]);
            AppMethodBeat.m2505o(12859);
        }
    }

    static {
        AppMethodBeat.m2504i(12861);
        AppMethodBeat.m2505o(12861);
    }
}
