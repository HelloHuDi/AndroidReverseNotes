package com.tencent.p177mm.media.p865c;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.media.p867i.C18594c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.c.e */
public final class C42168e extends C45425b {
    public static final C42167a eUc = new C42167a();
    private final String TAG = "MicroMsg.MediaCodecTransDecoder";
    private BufferInfo eTy = new BufferInfo();
    private volatile boolean eUb;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder$Companion;", "", "()V", "DECODE_TIMEOUT", "", "TIMEOUT", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.c.e$a */
    public static final class C42167a {
        private C42167a() {
        }

        public /* synthetic */ C42167a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(12866);
        AppMethodBeat.m2505o(12866);
    }

    public C42168e(long j, long j2, C32742a c32742a, Surface surface, C17126b<? super C45425b, C37091y> c17126b) {
        C25052j.m39376p(c32742a, "mediaExtractorWrapper");
        super(j, j2, c32742a, surface);
        AppMethodBeat.m2504i(12865);
        try {
            this.mediaFormat = c32742a.eWe;
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(c32742a.mo53292UV());
            C25052j.m39375o(createDecoderByType, "MediaCodec.createDecoder…orWrapper.getVideoMIME())");
            mo73218a(createDecoderByType);
            mo73216Uy().configure(this.mediaFormat, surface, null, 0);
            mo73216Uy().start();
            c17126b.mo50am(this);
            AppMethodBeat.m2505o(12865);
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "create decoder error:" + e.getMessage(), new Object[0]);
            Throwable illegalStateException = new IllegalStateException("init decoder error");
            AppMethodBeat.m2505o(12865);
            throw illegalStateException;
        }
    }

    /* renamed from: UB */
    public final void mo44163UB() {
        AppMethodBeat.m2504i(12862);
        do {
        } while (!m74348UE());
        C4990ab.m7416i(this.TAG, "inputDecoder end");
        try {
            synchronized (this.eTL) {
                if (this.eTM) {
                    C4990ab.m7416i(this.TAG, "drainDecoder already finished");
                }
                C37091y c37091y = C37091y.AUy;
            }
            C4990ab.m7416i(this.TAG, "sendDecoderEOS");
            ByteBuffer[] inputBuffers = mo73216Uy().getInputBuffers();
            int dequeueInputBuffer = mo73216Uy().dequeueInputBuffer(60000);
            while (dequeueInputBuffer < 0) {
                if (m74349UF()) {
                    break;
                }
                dequeueInputBuffer = mo73216Uy().dequeueInputBuffer(60000);
            }
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                C32742a c32742a = this.eTz;
                C25052j.m39375o(byteBuffer, "inputBuffer");
                c32742a.mo53296k(byteBuffer);
                byteBuffer.position(0);
                long sampleTime = this.eTz.getSampleTime();
                if (dequeueInputBuffer >= 0) {
                    mo73216Uy().queueInputBuffer(dequeueInputBuffer, 0, 0, sampleTime, 4);
                }
            }
            m74349UF();
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "sendDecoderEOS error", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(12862);
        }
        mo44164sI();
        C31214a c31214a = this.eTH;
        if (c31214a != null) {
            c31214a.invoke();
            AppMethodBeat.m2505o(12862);
            return;
        }
        AppMethodBeat.m2505o(12862);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i(r12.TAG, "decoder output buffers changed");
     */
    /* JADX WARNING: Missing block: B:45:0x0110, code skipped:
            mo73217a(r12.eTy);
            r6 = mo73216Uy();
     */
    /* JADX WARNING: Missing block: B:46:0x011b, code skipped:
            if (r12.eTP == null) goto L_0x0140;
     */
    /* JADX WARNING: Missing block: B:47:0x011d, code skipped:
            r2 = true;
     */
    /* JADX WARNING: Missing block: B:48:0x011e, code skipped:
            r6.releaseOutputBuffer(r3, r2);
     */
    /* JADX WARNING: Missing block: B:49:0x0128, code skipped:
            if ((r12.eTA * 1000) == 1) goto L_0x0142;
     */
    /* JADX WARNING: Missing block: B:51:0x012f, code skipped:
            if (r4 < (r12.eTA * 1000)) goto L_0x0142;
     */
    /* JADX WARNING: Missing block: B:52:0x0131, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e(r12.TAG, "exceed endTimeMs");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12864);
     */
    /* JADX WARNING: Missing block: B:53:0x0140, code skipped:
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:56:0x0148, code skipped:
            if ((r12.eTy.flags & 4) == 0) goto L_0x015f;
     */
    /* JADX WARNING: Missing block: B:58:?, code skipped:
            mo73216Uy().stop();
            mo73216Uy().release();
     */
    /* JADX WARNING: Missing block: B:62:0x015f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(12864);
     */
    /* JADX WARNING: Missing block: B:76:?, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:78:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: UF */
    private final boolean m74349UF() {
        AppMethodBeat.m2504i(12864);
        try {
            C4990ab.m7416i(this.TAG, "drainDecoder");
            synchronized (this.eTL) {
                if (this.eTM) {
                    C4990ab.m7416i(this.TAG, "drainDecoder already finished");
                }
                C37091y c37091y = C37091y.AUy;
            }
            int dequeueOutputBuffer = mo73216Uy().dequeueOutputBuffer(this.eTy, 100);
            while (true) {
                int i = dequeueOutputBuffer;
                if (i == -1) {
                    C4990ab.m7416i(this.TAG, "no output from decoder available, break");
                    break;
                } else if (i == -3) {
                    break;
                } else if (i == -2) {
                    this.mediaFormat = mo73216Uy().getOutputFormat();
                    C4990ab.m7416i(this.TAG, "decoder output format changed: " + this.mediaFormat);
                    MediaFormat mediaFormat = this.mediaFormat;
                    if (mediaFormat != null) {
                        C17126b c17126b = this.eTI;
                        if (c17126b != null) {
                            c17126b.mo50am(mediaFormat);
                        }
                    }
                } else if (i < 0) {
                    C4990ab.m7420w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
                    break;
                } else {
                    long j = this.eTy.presentationTimeUs;
                    C4990ab.m7416i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(j)));
                    if (j >= this.bqO * 1000 || (this.eTy.flags & 4) != 0) {
                        if (this.eTy.size == 0) {
                            mo73216Uy().releaseOutputBuffer(i, false);
                            dequeueOutputBuffer = mo73216Uy().dequeueOutputBuffer(this.eTy, 100);
                            if (dequeueOutputBuffer < 0) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    mo73216Uy().releaseOutputBuffer(i, false);
                    C4990ab.m7416i(this.TAG, "decoder pts: " + j + ", not reach start: " + (this.bqO * 1000));
                    AppMethodBeat.m2505o(12864);
                    return false;
                }
            }
            AppMethodBeat.m2505o(12864);
            return false;
            AppMethodBeat.m2505o(12864);
            return true;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "drainDecoder error", new Object[0]);
            if (this.eTO) {
                C18594c c18594c = C18594c.faj;
                C18594c.m28964VV();
            }
            AppMethodBeat.m2505o(12864);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(12864);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: UE */
    private final boolean m74348UE() {
        AppMethodBeat.m2504i(12863);
        try {
            synchronized (this.eTL) {
                if (this.eTM) {
                    C4990ab.m7416i(this.TAG, "inputDecoder already finished");
                }
                C37091y c37091y = C37091y.AUy;
            }
            C4990ab.m7416i(this.TAG, "inputDecoder");
            long yz = C5046bo.m7588yz();
            ByteBuffer[] inputBuffers = mo73216Uy().getInputBuffers();
            if (inputBuffers == null) {
                AppMethodBeat.m2505o(12863);
                return false;
            }
            int i = 0;
            int dequeueInputBuffer = mo73216Uy().dequeueInputBuffer(60000);
            while (dequeueInputBuffer < 0 && i < 15) {
                if (m74349UF()) {
                    AppMethodBeat.m2505o(12863);
                    return true;
                }
                dequeueInputBuffer = mo73216Uy().dequeueInputBuffer(60000);
                i++;
            }
            this.eUb = false;
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                C32742a c32742a = this.eTz;
                C25052j.m39375o(byteBuffer, "inputBuffer");
                if (c32742a.mo53296k(byteBuffer)) {
                    int i2 = this.eTz.sampleSize;
                    byteBuffer.position(0);
                    long sampleTime = this.eTz.getSampleTime();
                    C4990ab.m7416i(this.TAG, "sampleTime : " + sampleTime + " us");
                    if (i2 < 0 || sampleTime >= this.eTA * 1000) {
                        this.eUb = true;
                        C4990ab.m7416i(this.TAG, "sawInputEOS");
                    }
                    mo73216Uy().queueInputBuffer(dequeueInputBuffer, 0, i2, sampleTime, this.eUb ? 4 : 0);
                } else {
                    C4990ab.m7416i(this.TAG, "read sample end");
                    AppMethodBeat.m2505o(12863);
                    return true;
                }
            }
            C4990ab.m7420w(this.TAG, "input buffer not available");
            boolean UF = m74349UF();
            C4990ab.m7416i(this.TAG, "inputDecoder cost " + C5046bo.m7525az(yz));
            if (UF) {
                C4990ab.m7416i(this.TAG, "drainDecoder eos");
                AppMethodBeat.m2505o(12863);
                return true;
            }
            UF = this.eUb;
            AppMethodBeat.m2505o(12863);
            return UF;
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "inputDecoder error", new Object[0]);
            if (this.eTO) {
                C18594c c18594c = C18594c.faj;
                C18594c.m28964VV();
            }
            AppMethodBeat.m2505o(12863);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(12863);
            throw th;
        }
    }
}
