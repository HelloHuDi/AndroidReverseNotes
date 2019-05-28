package com.tencent.mm.media.c;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u001b\b\u0002\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\u0010\rJ\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;Lkotlin/jvm/functions/Function1;)V", "TAG", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "sawInputEOS", "", "drainDecoder", "inputDecoder", "sendDecoderEOS", "startDecode", "Companion", "plugin-mediaeditor_release"})
public final class e extends b {
    public static final a eUc = new a();
    private final String TAG = "MicroMsg.MediaCodecTransDecoder";
    private BufferInfo eTy = new BufferInfo();
    private volatile boolean eUb;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecTransDecoder$Companion;", "", "()V", "DECODE_TIMEOUT", "", "TIMEOUT", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(12866);
        AppMethodBeat.o(12866);
    }

    public e(long j, long j2, com.tencent.mm.media.e.a aVar, Surface surface, b<? super b, y> bVar) {
        j.p(aVar, "mediaExtractorWrapper");
        super(j, j2, aVar, surface);
        AppMethodBeat.i(12865);
        try {
            this.mediaFormat = aVar.eWe;
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(aVar.UV());
            j.o(createDecoderByType, "MediaCodec.createDecoder…orWrapper.getVideoMIME())");
            a(createDecoderByType);
            Uy().configure(this.mediaFormat, surface, null, 0);
            Uy().start();
            bVar.am(this);
            AppMethodBeat.o(12865);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "create decoder error:" + e.getMessage(), new Object[0]);
            Throwable illegalStateException = new IllegalStateException("init decoder error");
            AppMethodBeat.o(12865);
            throw illegalStateException;
        }
    }

    public final void UB() {
        AppMethodBeat.i(12862);
        do {
        } while (!UE());
        ab.i(this.TAG, "inputDecoder end");
        try {
            synchronized (this.eTL) {
                if (this.eTM) {
                    ab.i(this.TAG, "drainDecoder already finished");
                }
                y yVar = y.AUy;
            }
            ab.i(this.TAG, "sendDecoderEOS");
            ByteBuffer[] inputBuffers = Uy().getInputBuffers();
            int dequeueInputBuffer = Uy().dequeueInputBuffer(60000);
            while (dequeueInputBuffer < 0) {
                if (UF()) {
                    break;
                }
                dequeueInputBuffer = Uy().dequeueInputBuffer(60000);
            }
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                com.tencent.mm.media.e.a aVar = this.eTz;
                j.o(byteBuffer, "inputBuffer");
                aVar.k(byteBuffer);
                byteBuffer.position(0);
                long sampleTime = this.eTz.getSampleTime();
                if (dequeueInputBuffer >= 0) {
                    Uy().queueInputBuffer(dequeueInputBuffer, 0, 0, sampleTime, 4);
                }
            }
            UF();
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "sendDecoderEOS error", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.o(12862);
        }
        sI();
        a.f.a.a aVar2 = this.eTH;
        if (aVar2 != null) {
            aVar2.invoke();
            AppMethodBeat.o(12862);
            return;
        }
        AppMethodBeat.o(12862);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i(r12.TAG, "decoder output buffers changed");
     */
    /* JADX WARNING: Missing block: B:45:0x0110, code skipped:
            a(r12.eTy);
            r6 = Uy();
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
            com.tencent.mm.sdk.platformtools.ab.e(r12.TAG, "exceed endTimeMs");
            com.tencent.matrix.trace.core.AppMethodBeat.o(12864);
     */
    /* JADX WARNING: Missing block: B:53:0x0140, code skipped:
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:56:0x0148, code skipped:
            if ((r12.eTy.flags & 4) == 0) goto L_0x015f;
     */
    /* JADX WARNING: Missing block: B:58:?, code skipped:
            Uy().stop();
            Uy().release();
     */
    /* JADX WARNING: Missing block: B:62:0x015f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(12864);
     */
    /* JADX WARNING: Missing block: B:76:?, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:78:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean UF() {
        AppMethodBeat.i(12864);
        try {
            ab.i(this.TAG, "drainDecoder");
            synchronized (this.eTL) {
                if (this.eTM) {
                    ab.i(this.TAG, "drainDecoder already finished");
                }
                y yVar = y.AUy;
            }
            int dequeueOutputBuffer = Uy().dequeueOutputBuffer(this.eTy, 100);
            while (true) {
                int i = dequeueOutputBuffer;
                if (i == -1) {
                    ab.i(this.TAG, "no output from decoder available, break");
                    break;
                } else if (i == -3) {
                    break;
                } else if (i == -2) {
                    this.mediaFormat = Uy().getOutputFormat();
                    ab.i(this.TAG, "decoder output format changed: " + this.mediaFormat);
                    MediaFormat mediaFormat = this.mediaFormat;
                    if (mediaFormat != null) {
                        b bVar = this.eTI;
                        if (bVar != null) {
                            bVar.am(mediaFormat);
                        }
                    }
                } else if (i < 0) {
                    ab.w(this.TAG, "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
                    break;
                } else {
                    long j = this.eTy.presentationTimeUs;
                    ab.i(this.TAG, "presentationTimeUs : ".concat(String.valueOf(j)));
                    if (j >= this.bqO * 1000 || (this.eTy.flags & 4) != 0) {
                        if (this.eTy.size == 0) {
                            Uy().releaseOutputBuffer(i, false);
                            dequeueOutputBuffer = Uy().dequeueOutputBuffer(this.eTy, 100);
                            if (dequeueOutputBuffer < 0) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    Uy().releaseOutputBuffer(i, false);
                    ab.i(this.TAG, "decoder pts: " + j + ", not reach start: " + (this.bqO * 1000));
                    AppMethodBeat.o(12864);
                    return false;
                }
            }
            AppMethodBeat.o(12864);
            return false;
            AppMethodBeat.o(12864);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "drainDecoder error", new Object[0]);
            if (this.eTO) {
                c cVar = c.faj;
                c.VV();
            }
            AppMethodBeat.o(12864);
            return false;
        } catch (Throwable th) {
            AppMethodBeat.o(12864);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean UE() {
        AppMethodBeat.i(12863);
        try {
            synchronized (this.eTL) {
                if (this.eTM) {
                    ab.i(this.TAG, "inputDecoder already finished");
                }
                y yVar = y.AUy;
            }
            ab.i(this.TAG, "inputDecoder");
            long yz = bo.yz();
            ByteBuffer[] inputBuffers = Uy().getInputBuffers();
            if (inputBuffers == null) {
                AppMethodBeat.o(12863);
                return false;
            }
            int i = 0;
            int dequeueInputBuffer = Uy().dequeueInputBuffer(60000);
            while (dequeueInputBuffer < 0 && i < 15) {
                if (UF()) {
                    AppMethodBeat.o(12863);
                    return true;
                }
                dequeueInputBuffer = Uy().dequeueInputBuffer(60000);
                i++;
            }
            this.eUb = false;
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                com.tencent.mm.media.e.a aVar = this.eTz;
                j.o(byteBuffer, "inputBuffer");
                if (aVar.k(byteBuffer)) {
                    int i2 = this.eTz.sampleSize;
                    byteBuffer.position(0);
                    long sampleTime = this.eTz.getSampleTime();
                    ab.i(this.TAG, "sampleTime : " + sampleTime + " us");
                    if (i2 < 0 || sampleTime >= this.eTA * 1000) {
                        this.eUb = true;
                        ab.i(this.TAG, "sawInputEOS");
                    }
                    Uy().queueInputBuffer(dequeueInputBuffer, 0, i2, sampleTime, this.eUb ? 4 : 0);
                } else {
                    ab.i(this.TAG, "read sample end");
                    AppMethodBeat.o(12863);
                    return true;
                }
            }
            ab.w(this.TAG, "input buffer not available");
            boolean UF = UF();
            ab.i(this.TAG, "inputDecoder cost " + bo.az(yz));
            if (UF) {
                ab.i(this.TAG, "drainDecoder eos");
                AppMethodBeat.o(12863);
                return true;
            }
            UF = this.eUb;
            AppMethodBeat.o(12863);
            return UF;
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "inputDecoder error", new Object[0]);
            if (this.eTO) {
                c cVar = c.faj;
                c.VV();
            }
            AppMethodBeat.o(12863);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.o(12863);
            throw th;
        }
    }
}
