package com.tencent.mm.media.d;

import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.b.c;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u00020\u0001:\u0001$B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\b\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eXD¢\u0006\u0004\n\u0002\b\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder;", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "videoCodecConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "highPriority", "", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lcom/tencent/mm/media/config/VideoCodecConfig;ZLkotlin/jvm/functions/Function1;)V", "TAG", "", "TIMEOUT", "", "TIMEOUT$1", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "encodeHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "encodeThread", "Landroid/os/HandlerThread;", "encoder", "Landroid/media/MediaCodec;", "encoderLock", "Ljava/lang/Object;", "hasFinished", "isEnd", "startTime", "drainEncoder", "encodeFrame", "pts", "finishEncode", "finishWithEncodeLastFrame", "getRecordTimes", "release", "Companion", "plugin-mediaeditor_release"})
public final class e extends b {
    public static final a eVM = new a();
    private final String TAG;
    private HandlerThread eSP;
    private ak eSQ;
    private boolean eTf;
    private final BufferInfo eTy;
    private final long eVJ;
    private boolean eVK;
    private final Object eVL;
    private MediaCodec eVq;
    private long startTime;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecTransEncoder$Companion;", "", "()V", "TIMEOUT", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ e eVN;

        b(e eVar) {
            this.eVN = eVar;
        }

        public final void run() {
            AppMethodBeat.i(12943);
            long yz = bo.yz();
            synchronized (this.eVN.eVL) {
                try {
                    if (this.eVN.eVK) {
                        ab.i(this.eVN.TAG, "post encode frame, already finish");
                    } else {
                        y yVar = y.AUy;
                        e.d(this.eVN);
                        ab.d(this.eVN.TAG, "drainEncoder cost " + bo.az(yz));
                        AppMethodBeat.o(12943);
                    }
                } finally {
                    AppMethodBeat.o(12943);
                }
            }
        }
    }

    static {
        AppMethodBeat.i(12951);
        AppMethodBeat.o(12951);
    }

    public /* synthetic */ e(c cVar, a.f.a.b bVar) {
        this(cVar, false, bVar);
    }

    public e(c cVar, boolean z, a.f.a.b<? super b, y> bVar) {
        j.p(cVar, "videoCodecConfig");
        super(cVar, bVar);
        AppMethodBeat.i(12950);
        this.TAG = "MicroMsg.MediaCodecTransEncoder";
        this.eVJ = 10000;
        this.eTy = new BufferInfo();
        HandlerThread ek = d.ek("MediaCodecTransEncoder_encodeThread", z ? -2 : 0);
        j.o(ek, "ThreadPool.newFreeHandle….THREAD_PRIORITY_DEFAULT)");
        this.eSP = ek;
        this.eVL = new Object();
        MediaCodec createByCodecName = MediaCodec.createByCodecName(cVar.name);
        j.o(createByCodecName, "MediaCodec.createByCodec…me(videoCodecConfig.name)");
        this.eVq = createByCodecName;
        this.eVq.configure(cVar.Ux(), null, null, 1);
        Surface createInputSurface = this.eVq.createInputSurface();
        j.o(createInputSurface, "encoder.createInputSurface()");
        e(createInputSurface);
        this.eVq.start();
        this.eSP.start();
        this.eSQ = new ak(this.eSP.getLooper());
        if (bVar != null) {
            bVar.am(this);
            AppMethodBeat.o(12950);
            return;
        }
        AppMethodBeat.o(12950);
    }

    public static final /* synthetic */ void d(e eVar) {
        AppMethodBeat.i(12952);
        eVar.UR();
        AppMethodBeat.o(12952);
    }

    public final void UP() {
        AppMethodBeat.i(12944);
        if (0 == this.startTime) {
            this.startTime = bo.yz();
        }
        this.eSQ.post(new b(this));
        AppMethodBeat.o(12944);
    }

    /* JADX WARNING: Missing block: B:11:0x0021, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12945);
     */
    /* JADX WARNING: Missing block: B:26:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void UO() {
        AppMethodBeat.i(12945);
        ab.i(this.TAG, "finishEncode ");
        synchronized (this.eVL) {
            try {
                if (this.eTf || this.eVK || 0 == this.startTime) {
                } else {
                    this.eTf = true;
                    this.eVq.signalEndOfInputStream();
                    UR();
                    y yVar = y.AUy;
                    AppMethodBeat.o(12945);
                }
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "finishEncode signalEndOfInputStream error:" + e.getMessage(), new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(12945);
            }
        }
    }

    /* JADX WARNING: Missing block: B:13:0x0044, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12946);
     */
    /* JADX WARNING: Missing block: B:17:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void US() {
        AppMethodBeat.i(12946);
        ab.d(this.TAG, "finishWithEncodeLastFrame  ,isEnd:" + this.eTf + "   ,hasFinished: " + this.eVK);
        synchronized (this.eVL) {
            try {
                if (!this.eTf || this.eVK) {
                } else {
                    release();
                    a.f.a.a aVar = this.eVz;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                }
            } finally {
                AppMethodBeat.o(12946);
            }
        }
    }

    public final void release() {
        AppMethodBeat.i(12947);
        synchronized (this.eVL) {
            try {
                if (this.eVK) {
                    ab.i(this.TAG, "release, already finished");
                    AppMethodBeat.o(12947);
                    return;
                }
                this.eVK = true;
                this.eVq.stop();
                this.eVq.release();
                this.eSQ.removeCallbacksAndMessages(null);
                this.eSP.quitSafely();
                AppMethodBeat.o(12947);
            } catch (Exception e) {
                ab.e(this.TAG, "release encoder error " + e.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.o(12947);
            }
        }
    }

    private final void UR() {
        AppMethodBeat.i(12948);
        try {
            ab.i(this.TAG, "drainEncoder");
            int dequeueOutputBuffer = this.eVq.dequeueOutputBuffer(this.eTy, this.eVJ);
            while (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    ab.d(this.TAG, "encoder output format changed " + this.eVq.getOutputFormat());
                } else if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer < 0) {
                        ab.e(this.TAG, "outputBufferIndex " + dequeueOutputBuffer + ", ignore");
                    } else {
                        ab.d(this.TAG, "outputBuffer index: ".concat(String.valueOf(dequeueOutputBuffer)));
                        ByteBuffer[] outputBuffers = this.eVq.getOutputBuffers();
                        ab.d(this.TAG, "getOutputBuffers");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            Throwable runtimeException = new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                            AppMethodBeat.o(12948);
                            throw runtimeException;
                        }
                        ab.d(this.TAG, "outputBuffers[outputBufferIndex]");
                        if ((this.eTy.flags & 2) != 0) {
                            ab.i(this.TAG, "codec config!");
                        }
                        ab.i(this.TAG, "bufferInfo.flags : " + (this.eTy.flags & 4));
                        if (this.eTy.size != 0) {
                            byteBuffer.position(this.eTy.offset);
                            byteBuffer.limit(this.eTy.offset + this.eTy.size);
                            f(byteBuffer, this.eTy);
                            this.eVq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        } else if ((this.eTy.flags & 4) != 0) {
                            ab.i(this.TAG, "encode end of stream");
                            US();
                            break;
                        } else {
                            ab.d(this.TAG, "bufferInfo.size == 0");
                        }
                    }
                }
                ab.d(this.TAG, "dequeueOutputBuffer start");
                int dequeueOutputBuffer2 = this.eVq.dequeueOutputBuffer(this.eTy, this.eVJ);
                if (dequeueOutputBuffer2 < 0) {
                    break;
                }
                dequeueOutputBuffer = dequeueOutputBuffer2;
            }
            ab.d(this.TAG, "outputBuffer try again later");
        } catch (Exception e) {
            ab.e(this.TAG, "drainEncoder error");
            if (this.eTO) {
                com.tencent.mm.media.i.c cVar = com.tencent.mm.media.i.c.faj;
                com.tencent.mm.media.i.c.VX();
            }
        }
        US();
        AppMethodBeat.o(12948);
    }

    public final long UQ() {
        AppMethodBeat.i(12949);
        long yz = bo.yz() - this.startTime;
        AppMethodBeat.o(12949);
        return yz;
    }
}
