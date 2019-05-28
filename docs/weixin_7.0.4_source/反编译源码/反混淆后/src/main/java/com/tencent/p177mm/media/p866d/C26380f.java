package com.tencent.p177mm.media.p866d;

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
import com.tencent.p177mm.media.p251b.C24670c;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\f\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "codecCallback", "com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1;", "encodeHandler", "Landroid/os/Handler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Landroid/media/MediaCodec;", "isEnd", "", "startTime", "", "encodeFrame", "pts", "finishEncode", "getRecordTimes", "release", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.d.f */
public final class C26380f extends C45426b {
    final String TAG = "MicroMsg.MediaCodecTransEncoderAsync";
    HandlerThread eSP;
    volatile boolean eTf;
    private Handler eVO;
    private C18583a eVP;
    MediaCodec eVq;
    private long startTime;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, dWq = {"com/tencent/mm/media/encoder/MediaCodecTransEncoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "outputBufferIndex", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.d.f$a */
    public static final class C18583a extends Callback {
        final /* synthetic */ C26380f eVQ;

        C18583a(C26380f c26380f) {
            this.eVQ = c26380f;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.m2504i(12953);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(bufferInfo, "bufferInfo");
            C4990ab.m7410d(this.eVQ.TAG, "onOutputBufferAvailable index:" + i + ", info: " + bufferInfo);
            if (i >= 0) {
                try {
                    ByteBuffer outputBuffer = this.eVQ.eVq.getOutputBuffer(i);
                    if ((bufferInfo.flags & 2) != 0) {
                        C4990ab.m7416i(this.eVQ.TAG, "codec config!");
                    }
                    if ((bufferInfo.flags & 4) != 0 || this.eVQ.eTf) {
                        C4990ab.m7416i(this.eVQ.TAG, "encode end of stream");
                        try {
                            this.eVQ.eVq.stop();
                            this.eVQ.eVq.release();
                            this.eVQ.eTf = true;
                        } catch (Exception e) {
                            C4990ab.m7412e(this.eVQ.TAG, "release encoder error " + e.getMessage());
                        }
                        this.eVQ.release();
                        C31214a c31214a = this.eVQ.eVz;
                        if (c31214a != null) {
                            c31214a.invoke();
                            AppMethodBeat.m2505o(12953);
                            return;
                        }
                        AppMethodBeat.m2505o(12953);
                        return;
                    }
                    if (bufferInfo.size != 0) {
                        outputBuffer.position(bufferInfo.offset);
                        outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        C26380f c26380f = this.eVQ;
                        C25052j.m39375o(outputBuffer, "outputBuffer");
                        c26380f.mo73221f(outputBuffer, bufferInfo);
                        this.eVQ.eVq.releaseOutputBuffer(i, bufferInfo.presentationTimeUs);
                    }
                    AppMethodBeat.m2505o(12953);
                    return;
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace(this.eVQ.TAG, e2, "onOutputBufferAvailable error", new Object[0]);
                    if (this.eVQ.eTO) {
                        C18594c c18594c = C18594c.faj;
                        C18594c.m28966VX();
                    }
                    AppMethodBeat.m2505o(12953);
                    return;
                }
            }
            this.eVQ.eVq.releaseOutputBuffer(i, false);
            AppMethodBeat.m2505o(12953);
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.m2504i(12954);
            C25052j.m39376p(mediaCodec, "codec");
            C4990ab.m7416i(this.eVQ.TAG, "onInputBufferAvailable, index:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(12954);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.m2504i(12955);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(mediaFormat, "format");
            C4990ab.m7416i(this.eVQ.TAG, "encoder output format changed " + this.eVQ.eVq.getOutputFormat());
            AppMethodBeat.m2505o(12955);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
            AppMethodBeat.m2504i(12956);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(codecException, "e");
            C4990ab.m7412e(this.eVQ.TAG, "codec Error, e:".concat(String.valueOf(codecException)));
            if (this.eVQ.eTO) {
                C18594c c18594c = C18594c.faj;
                C18594c.m28967VY();
            }
            AppMethodBeat.m2505o(12956);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.d.f$c */
    static final class C18584c implements Runnable {
        final /* synthetic */ C26380f eVQ;

        C18584c(C26380f c26380f) {
            this.eVQ = c26380f;
        }

        public final void run() {
            AppMethodBeat.m2504i(12958);
            try {
                this.eVQ.eSP.quitSafely();
                AppMethodBeat.m2505o(12958);
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.eVQ.TAG, e, "release error:" + e.getMessage(), new Object[0]);
                AppMethodBeat.m2505o(12958);
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.d.f$b */
    static final class C26381b implements Runnable {
        final /* synthetic */ C26380f eVQ;

        C26381b(C26380f c26380f) {
            this.eVQ = c26380f;
        }

        public final void run() {
            AppMethodBeat.m2504i(12957);
            try {
                C4990ab.m7416i(this.eVQ.TAG, "finishEncode, isEnd:" + this.eVQ.eTf);
                if (this.eVQ.eTf) {
                    AppMethodBeat.m2505o(12957);
                    return;
                }
                this.eVQ.eTf = true;
                this.eVQ.eVq.signalEndOfInputStream();
                AppMethodBeat.m2505o(12957);
            } catch (Exception e) {
                C4990ab.m7412e(this.eVQ.TAG, "release encoder error " + e.getMessage());
                AppMethodBeat.m2505o(12957);
            }
        }
    }

    public C26380f(C24670c c24670c, C17126b<? super C45426b, C37091y> c17126b) {
        C25052j.m39376p(c24670c, "videoCodecConfig");
        super(c24670c, c17126b);
        AppMethodBeat.m2504i(12963);
        MediaCodec createByCodecName = MediaCodec.createByCodecName(c24670c.name);
        C25052j.m39375o(createByCodecName, "MediaCodec.createByCodec…me(videoCodecConfig.name)");
        this.eVq = createByCodecName;
        HandlerThread anM = C7305d.anM("MediaCodecTransEncoder_encodeThread");
        C25052j.m39375o(anM, "ThreadPool.newFreeHandle…ansEncoder_encodeThread\")");
        this.eSP = anM;
        this.eVP = new C18583a(this);
        this.eVq.configure(c24670c.mo41565Ux(), null, null, 1);
        if (C1443d.m3068iW(23)) {
            this.eSP.start();
            this.eVO = new Handler(this.eSP.getLooper());
            MediaCodec mediaCodec = this.eVq;
            Callback callback = this.eVP;
            Handler handler = this.eVO;
            if (handler == null) {
                C25052j.avw("encodeHandler");
            }
            mediaCodec.setCallback(callback, handler);
        } else {
            this.eVq.setCallback(this.eVP);
        }
        Surface createInputSurface = this.eVq.createInputSurface();
        C25052j.m39375o(createInputSurface, "encoder.createInputSurface()");
        mo73220e(createInputSurface);
        this.eVq.start();
        c17126b.mo50am(this);
        AppMethodBeat.m2505o(12963);
    }

    /* renamed from: UP */
    public final void mo20900UP() {
        AppMethodBeat.m2504i(12959);
        if (0 == this.startTime) {
            this.startTime = C5046bo.m7588yz();
        }
        AppMethodBeat.m2505o(12959);
    }

    /* renamed from: UO */
    public final void mo20899UO() {
        AppMethodBeat.m2504i(12960);
        Handler handler = this.eVO;
        if (handler == null) {
            C25052j.avw("encodeHandler");
        }
        handler.post(new C26381b(this));
        AppMethodBeat.m2505o(12960);
    }

    public final void release() {
        AppMethodBeat.m2504i(12961);
        C4990ab.m7416i(this.TAG, "release");
        Handler handler = this.eVO;
        if (handler == null) {
            C25052j.avw("encodeHandler");
        }
        handler.post(new C18584c(this));
        AppMethodBeat.m2505o(12961);
    }

    /* renamed from: UQ */
    public final long mo20901UQ() {
        AppMethodBeat.m2504i(12962);
        long yz = C5046bo.m7588yz() - this.startTime;
        AppMethodBeat.m2505o(12962);
        return yz;
    }
}
