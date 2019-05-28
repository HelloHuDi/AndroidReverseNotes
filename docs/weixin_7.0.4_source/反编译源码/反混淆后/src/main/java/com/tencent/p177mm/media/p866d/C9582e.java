package com.tencent.p177mm.media.p866d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p251b.C24670c;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u00020\u0001:\u0001$B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eXD¢\u0006\u0004\n\u0002\b\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Landroid/media/MediaCodec;", "encoderLock", "Ljava/lang/Object;", "hasFinished", "isEnd", "startTime", "drainEncoder", "encodeFrame", "pts", "finishEncode", "finishWithEncodeLastFrame", "getRecordTimes", "release", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.d.e */
public final class C9582e extends C45426b {
    public static final C9581a eVM = new C9581a();
    private final String TAG;
    private HandlerThread eSP;
    private C7306ak eSQ;
    private boolean eTf;
    private final BufferInfo eTy;
    private final long eVJ;
    private boolean eVK;
    private final Object eVL;
    private MediaCodec eVq;
    private long startTime;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder$Companion;", "", "()V", "TIMEOUT", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.d.e$a */
    public static final class C9581a {
        private C9581a() {
        }

        public /* synthetic */ C9581a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.media.d.e$b */
    static final class C9583b implements Runnable {
        final /* synthetic */ C9582e eVN;

        C9583b(C9582e c9582e) {
            this.eVN = c9582e;
        }

        public final void run() {
            AppMethodBeat.m2504i(12943);
            long yz = C5046bo.m7588yz();
            synchronized (this.eVN.eVL) {
                try {
                    if (this.eVN.eVK) {
                        C4990ab.m7416i(this.eVN.TAG, "post encode frame, already finish");
                    } else {
                        C37091y c37091y = C37091y.AUy;
                        C9582e.m17065d(this.eVN);
                        C4990ab.m7410d(this.eVN.TAG, "drainEncoder cost " + C5046bo.m7525az(yz));
                        AppMethodBeat.m2505o(12943);
                    }
                } finally {
                    AppMethodBeat.m2505o(12943);
                }
            }
        }
    }

    static {
        AppMethodBeat.m2504i(12951);
        AppMethodBeat.m2505o(12951);
    }

    public /* synthetic */ C9582e(C24670c c24670c, C17126b c17126b) {
        this(c24670c, false, c17126b);
    }

    public C9582e(C24670c c24670c, boolean z, C17126b<? super C45426b, C37091y> c17126b) {
        C25052j.m39376p(c24670c, "videoCodecConfig");
        super(c24670c, c17126b);
        AppMethodBeat.m2504i(12950);
        this.TAG = "MicroMsg.MediaCodecTransEncoder";
        this.eVJ = 10000;
        this.eTy = new BufferInfo();
        HandlerThread ek = C7305d.m12297ek("MediaCodecTransEncoder_encodeThread", z ? -2 : 0);
        C25052j.m39375o(ek, "ThreadPool.newFreeHandle….THREAD_PRIORITY_DEFAULT)");
        this.eSP = ek;
        this.eVL = new Object();
        MediaCodec createByCodecName = MediaCodec.createByCodecName(c24670c.name);
        C25052j.m39375o(createByCodecName, "MediaCodec.createByCodec…me(videoCodecConfig.name)");
        this.eVq = createByCodecName;
        this.eVq.configure(c24670c.mo41565Ux(), null, null, 1);
        Surface createInputSurface = this.eVq.createInputSurface();
        C25052j.m39375o(createInputSurface, "encoder.createInputSurface()");
        mo73220e(createInputSurface);
        this.eVq.start();
        this.eSP.start();
        this.eSQ = new C7306ak(this.eSP.getLooper());
        if (c17126b != null) {
            c17126b.mo50am(this);
            AppMethodBeat.m2505o(12950);
            return;
        }
        AppMethodBeat.m2505o(12950);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m17065d(C9582e c9582e) {
        AppMethodBeat.m2504i(12952);
        c9582e.m17060UR();
        AppMethodBeat.m2505o(12952);
    }

    /* renamed from: UP */
    public final void mo20900UP() {
        AppMethodBeat.m2504i(12944);
        if (0 == this.startTime) {
            this.startTime = C5046bo.m7588yz();
        }
        this.eSQ.post(new C9583b(this));
        AppMethodBeat.m2505o(12944);
    }

    /* JADX WARNING: Missing block: B:11:0x0021, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12945);
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: UO */
    public final void mo20899UO() {
        AppMethodBeat.m2504i(12945);
        C4990ab.m7416i(this.TAG, "finishEncode ");
        synchronized (this.eVL) {
            try {
                if (this.eTf || this.eVK || 0 == this.startTime) {
                } else {
                    this.eTf = true;
                    this.eVq.signalEndOfInputStream();
                    m17060UR();
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(12945);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "finishEncode signalEndOfInputStream error:" + e.getMessage(), new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(12945);
            }
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0044, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12946);
     */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: US */
    private final void m17061US() {
        AppMethodBeat.m2504i(12946);
        C4990ab.m7410d(this.TAG, "finishWithEncodeLastFrame  ,isEnd:" + this.eTf + "   ,hasFinished: " + this.eVK);
        synchronized (this.eVL) {
            try {
                if (!this.eTf || this.eVK) {
                } else {
                    release();
                    C31214a c31214a = this.eVz;
                    if (c31214a != null) {
                        c31214a.invoke();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(12946);
            }
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(12947);
        synchronized (this.eVL) {
            try {
                if (this.eVK) {
                    C4990ab.m7416i(this.TAG, "release, already finished");
                    AppMethodBeat.m2505o(12947);
                    return;
                }
                this.eVK = true;
                this.eVq.stop();
                this.eVq.release();
                this.eSQ.removeCallbacksAndMessages(null);
                this.eSP.quitSafely();
                AppMethodBeat.m2505o(12947);
            } catch (Exception e) {
                C4990ab.m7412e(this.TAG, "release encoder error " + e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(12947);
            }
        }
    }

    /* renamed from: UR */
    private final void m17060UR() {
        AppMethodBeat.m2504i(12948);
        try {
            C4990ab.m7416i(this.TAG, "drainEncoder");
            int dequeueOutputBuffer = this.eVq.dequeueOutputBuffer(this.eTy, this.eVJ);
            while (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    C4990ab.m7410d(this.TAG, "encoder output format changed " + this.eVq.getOutputFormat());
                } else if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer < 0) {
                        C4990ab.m7412e(this.TAG, "outputBufferIndex " + dequeueOutputBuffer + ", ignore");
                    } else {
                        C4990ab.m7410d(this.TAG, "outputBuffer index: ".concat(String.valueOf(dequeueOutputBuffer)));
                        ByteBuffer[] outputBuffers = this.eVq.getOutputBuffers();
                        C4990ab.m7410d(this.TAG, "getOutputBuffers");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            Throwable runtimeException = new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            AppMethodBeat.m2505o(12948);
                            throw runtimeException;
                        }
                        C4990ab.m7410d(this.TAG, "outputBuffers[outputBufferIndex]");
                        if ((this.eTy.flags & 2) != 0) {
                            C4990ab.m7416i(this.TAG, "codec config!");
                        }
                        C4990ab.m7416i(this.TAG, "bufferInfo.flags : " + (this.eTy.flags & 4));
                        if (this.eTy.size != 0) {
                            byteBuffer.position(this.eTy.offset);
                            byteBuffer.limit(this.eTy.offset + this.eTy.size);
                            mo73221f(byteBuffer, this.eTy);
                            this.eVq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else if ((this.eTy.flags & 4) != 0) {
                            C4990ab.m7416i(this.TAG, "encode end of stream");
                            m17061US();
                            break;
                        } else {
                            C4990ab.m7410d(this.TAG, "bufferInfo.size == 0");
                        }
                    }
                }
                C4990ab.m7410d(this.TAG, "dequeueOutputBuffer start");
                int dequeueOutputBuffer2 = this.eVq.dequeueOutputBuffer(this.eTy, this.eVJ);
                if (dequeueOutputBuffer2 < 0) {
                    break;
                }
                dequeueOutputBuffer = dequeueOutputBuffer2;
            }
            C4990ab.m7410d(this.TAG, "outputBuffer try again later");
        } catch (Exception e) {
            C4990ab.m7412e(this.TAG, "drainEncoder error");
            if (this.eTO) {
                C18594c c18594c = C18594c.faj;
                C18594c.m28966VX();
            }
        }
        m17061US();
        AppMethodBeat.m2505o(12948);
    }

    /* renamed from: UQ */
    public final long mo20901UQ() {
        AppMethodBeat.m2504i(12949);
        long yz = C5046bo.m7588yz() - this.startTime;
        AppMethodBeat.m2505o(12949);
        return yz;
    }
}
