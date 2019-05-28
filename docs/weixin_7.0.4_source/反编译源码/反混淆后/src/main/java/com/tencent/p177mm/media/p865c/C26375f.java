package com.tencent.p177mm.media.p865c;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0011\u0018\u00002\u00020\u0001BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Lcom/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "isInvokeDecodeEnd", "", "sawInputEOS", "onDecodeEnd", "releaseDecoder", "startDecode", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.c.f */
public final class C26375f extends C45425b {
    final String TAG = "MicroMsg.MediaCodecTransDecoderAsync";
    volatile boolean eUb;
    private HandlerThread eUd = C7305d.anM("MediaCodecTransDecoderAsync_decodeThread");
    private boolean eUe;
    private final C26376a eUf;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/media/decoder/MediaCodecTransDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "decoderOutputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.c.f$a */
    public static final class C26376a extends Callback {
        final /* synthetic */ C32742a eUa;
        final /* synthetic */ C26375f eUg;
        final /* synthetic */ Surface eUh;

        C26376a(C26375f c26375f, Surface surface, C32742a c32742a) {
            this.eUg = c26375f;
            this.eUh = surface;
            this.eUa = c32742a;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.m2504i(12867);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C4990ab.m7416i(this.eUg.TAG, "onOutputBufferAvailable, index:" + i + ", bufferInfo:" + bufferInfo + " size:" + bufferInfo.size);
            if (i >= 0) {
                try {
                    long j = bufferInfo.presentationTimeUs;
                    C4990ab.m7416i(this.eUg.TAG, "presentationTimeUs : ".concat(String.valueOf(j)));
                    if (j >= this.eUg.bqO * 1000 || (bufferInfo.flags & 4) != 0) {
                        this.eUg.mo73217a(bufferInfo);
                        this.eUg.mo73216Uy().releaseOutputBuffer(i, this.eUh != null);
                        if (this.eUg.eTA * 1000 == 1 || j < this.eUg.eTA * 1000) {
                            if ((bufferInfo.flags & 4) != 0 || this.eUg.eUb) {
                                C4990ab.m7416i(this.eUg.TAG, "receive eos!");
                                this.eUg.mo44164sI();
                                C26375f.m41966a(this.eUg);
                                AppMethodBeat.m2505o(12867);
                                return;
                            }
                            AppMethodBeat.m2505o(12867);
                            return;
                        }
                        C4990ab.m7412e(this.eUg.TAG, "exceed endTimeMs");
                        this.eUg.mo44164sI();
                        C26375f.m41966a(this.eUg);
                        AppMethodBeat.m2505o(12867);
                        return;
                    }
                    this.eUg.mo73216Uy().releaseOutputBuffer(i, false);
                    C4990ab.m7416i(this.eUg.TAG, "decoder pts: " + j + ", not reach start: " + (this.eUg.bqO * 1000));
                    AppMethodBeat.m2505o(12867);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(this.eUg.TAG, e, "onOutputBufferAvailable error", new Object[0]);
                    if (this.eUg.eTO) {
                        C18594c c18594c = C18594c.faj;
                        C18594c.m28964VV();
                    }
                }
            } else {
                this.eUg.mo73216Uy().releaseOutputBuffer(i, false);
                AppMethodBeat.m2505o(12867);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.m2504i(12868);
            C25052j.m39376p(mediaCodec, "codec");
            C4990ab.m7416i(this.eUg.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(i)));
            if (i >= 0) {
                try {
                    int i2;
                    this.eUg.eUb = false;
                    ByteBuffer inputBuffer = this.eUg.mo73216Uy().getInputBuffer(i);
                    inputBuffer.clear();
                    C32742a c32742a = this.eUa;
                    C25052j.m39375o(inputBuffer, "inputBuffer");
                    if (!c32742a.mo53296k(inputBuffer)) {
                        C4990ab.m7416i(this.eUg.TAG, "read sample end");
                        this.eUg.eUb = true;
                    }
                    long j = 0;
                    if (this.eUg.eUb) {
                        i2 = 0;
                    } else {
                        i2 = this.eUa.sampleSize;
                        inputBuffer.position(0);
                        j = this.eUa.getSampleTime();
                        C4990ab.m7416i(this.eUg.TAG, "sampleTime : " + j + ", sampleSize:" + i2);
                        if (i2 < 0 || j >= this.eUg.eTA * 1000) {
                            this.eUg.eUb = true;
                            C4990ab.m7416i(this.eUg.TAG, "sawInputEOS");
                        }
                    }
                    this.eUg.mo73216Uy().queueInputBuffer(i, 0, i2, j, this.eUg.eUb ? 4 : 0);
                    AppMethodBeat.m2505o(12868);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(this.eUg.TAG, e, "onInputBufferAvailable error", new Object[0]);
                    if (this.eUg.eTO) {
                        C18594c c18594c = C18594c.faj;
                        C18594c.m28964VV();
                    }
                }
            }
            AppMethodBeat.m2505o(12868);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.m2504i(12869);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(mediaFormat, "format");
            this.eUg.mediaFormat = mediaFormat;
            C4990ab.m7416i(this.eUg.TAG, "decoder output format changed: " + this.eUg.mediaFormat);
            MediaFormat mediaFormat2 = this.eUg.mediaFormat;
            if (mediaFormat2 != null) {
                C17126b c17126b = this.eUg.eTI;
                if (c17126b != null) {
                    c17126b.mo50am(mediaFormat2);
                    AppMethodBeat.m2505o(12869);
                    return;
                }
                AppMethodBeat.m2505o(12869);
                return;
            }
            AppMethodBeat.m2505o(12869);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
            C18594c c18594c;
            AppMethodBeat.m2504i(12870);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(codecException, "e");
            C4990ab.m7412e(this.eUg.TAG, "onError, codec:" + mediaCodec + ", " + codecException.isRecoverable() + ' ' + codecException.isTransient() + ' ' + codecException.getDiagnosticInfo());
            if (this.eUg.eTO) {
                c18594c = C18594c.faj;
                C18594c.m28965VW();
            }
            if (!(codecException.isRecoverable() || codecException.isTransient())) {
                c18594c = C18594c.faj;
                C18594c.m28997yj();
                this.eUg.mo44164sI();
                C26375f.m41966a(this.eUg);
            }
            AppMethodBeat.m2505o(12870);
        }
    }

    public C26375f(long j, long j2, C32742a c32742a, Surface surface, C17126b<? super C45425b, C37091y> c17126b) {
        C25052j.m39376p(c32742a, "mediaExtractorWrapper");
        super(j, j2, c32742a, surface);
        AppMethodBeat.m2504i(12873);
        this.eUf = new C26376a(this, surface, c32742a);
        try {
            this.mediaFormat = c32742a.eWe;
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(c32742a.mo53292UV());
            C25052j.m39375o(createDecoderByType, "MediaCodec.createDecoder…orWrapper.getVideoMIME())");
            mo73218a(createDecoderByType);
            mo73216Uy().configure(this.mediaFormat, surface, null, 0);
            if (C1443d.m3068iW(23)) {
                this.eUd.start();
                HandlerThread handlerThread = this.eUd;
                C25052j.m39375o(handlerThread, "decoderThread");
                mo73216Uy().setCallback(this.eUf, new Handler(handlerThread.getLooper()));
            } else {
                mo73216Uy().setCallback(this.eUf);
            }
            c17126b.mo50am(this);
            AppMethodBeat.m2505o(12873);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "create decoder error:" + e.getMessage(), new Object[0]);
            Throwable illegalStateException = new IllegalStateException("init decoder error");
            AppMethodBeat.m2505o(12873);
            throw illegalStateException;
        }
    }

    /* renamed from: UB */
    public final void mo44163UB() {
        AppMethodBeat.m2504i(12871);
        try {
            mo73216Uy().start();
            AppMethodBeat.m2505o(12871);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "startDecode error", new Object[0]);
            AppMethodBeat.m2505o(12871);
        }
    }

    /* renamed from: sI */
    public final void mo44164sI() {
        AppMethodBeat.m2504i(12872);
        super.mo44164sI();
        try {
            this.eUd.quit();
            AppMethodBeat.m2505o(12872);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "releaseDecoder error:" + e.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(12872);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m41966a(C26375f c26375f) {
        AppMethodBeat.m2504i(12874);
        if (!c26375f.eUe) {
            C31214a c31214a = c26375f.eTH;
            if (c31214a != null) {
                c31214a.invoke();
            }
            c26375f.eUe = true;
        }
        AppMethodBeat.m2505o(12874);
    }
}
