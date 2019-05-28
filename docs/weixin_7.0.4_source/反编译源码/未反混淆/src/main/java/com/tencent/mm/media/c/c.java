package com.tencent.mm.media.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\n\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\u0016\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "codeOver", "", "drainDecoder", "readNextSample", "startDecoder", "Companion", "plugin-mediaeditor_release"})
public final class c extends a {
    private static final String TAG = TAG;
    private static final long eTR = eTR;
    public static final a eTS = new a();
    private boolean eTQ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/media/decoder/MediaCodecAACDecoder$Companion;", "", "()V", "TAG", "", "TIMEOUT", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public c(com.tencent.mm.media.e.a aVar, String str, long j, long j2, m<? super byte[], ? super Long, y> mVar, a.f.a.a<y> aVar2) {
        j.p(aVar, "mediaExtractorWrapper");
        j.p(str, "audioId");
        j.p(mVar, "frameDecodeCallback");
        j.p(aVar2, "frameDecodeEndCallback");
        super(aVar, str, j, j2, mVar, aVar2);
        AppMethodBeat.i(12854);
        Uy().start();
        AppMethodBeat.o(12854);
    }

    public final void Uz() {
        AppMethodBeat.i(12853);
        while (!this.eTQ && !this.eTr) {
            UC();
        }
        UA();
        AppMethodBeat.o(12853);
    }

    static {
        AppMethodBeat.i(12855);
        AppMethodBeat.o(12855);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean UC() {
        AppMethodBeat.i(12851);
        try {
            synchronized (this.eTu) {
                if (this.eTr) {
                    ab.i(TAG, "readNextSample decoder stop");
                }
                y yVar = y.AUy;
            }
            this.eTv = bo.yz();
            int dequeueInputBuffer = Uy().dequeueInputBuffer(100);
            if (dequeueInputBuffer < 0) {
                UD();
            }
            if (dequeueInputBuffer < 0) {
                AppMethodBeat.o(12851);
                return false;
            }
            int i;
            int i2;
            int i3;
            ab.i(TAG, "inputIndex: ".concat(String.valueOf(dequeueInputBuffer)));
            this.eTv = bo.yz();
            ByteBuffer byteBuffer = Uy().getInputBuffers()[dequeueInputBuffer];
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
            com.tencent.mm.media.e.a aVar = this.eTz;
            j.o(byteBuffer, "inputBuffer");
            if (aVar.k(byteBuffer)) {
                i = 0;
            } else {
                ab.i(TAG, "read sample end");
                i = 1;
            }
            long j = 0;
            if (i == 0) {
                i2 = this.eTz.sampleSize;
                byteBuffer.position(0);
                j = this.eTz.getSampleTime();
                ab.i(TAG, "sampleTime : " + j + ", sampleSize:" + i2);
                if (i2 < 0 || j >= this.eTA * 1000) {
                    ab.i(TAG, "sawInputEOS");
                    i3 = 1;
                } else {
                    i3 = i;
                }
            } else {
                i2 = 0;
                i3 = i;
            }
            Uy().queueInputBuffer(dequeueInputBuffer, 0, i2, j, i3 != 0 ? 4 : 0);
            if (i3 != 0) {
                UA();
            }
            UD();
            AppMethodBeat.o(12851);
            return true;
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.o(12851);
        }
    }

    /* JADX WARNING: Missing block: B:15:0x0021, code skipped:
            r0 = new android.media.MediaCodec.BufferInfo();
            a.f.b.j.p(r0, "<set-?>");
            r11.eTy = r0;
            r0 = Uy().dequeueOutputBuffer(r11.eTy, eTR);
     */
    /* JADX WARNING: Missing block: B:16:0x003a, code skipped:
            if (r0 < 0) goto L_0x0066;
     */
    /* JADX WARNING: Missing block: B:17:0x003c, code skipped:
            r1 = Uy().getOutputBuffers()[r0];
     */
    /* JADX WARNING: Missing block: B:18:0x0046, code skipped:
            if (r1 != null) goto L_0x0072;
     */
    /* JADX WARNING: Missing block: B:19:0x0048, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e(TAG, "ERROR, retrieve decoderOutputBuffer is null!!");
            com.tencent.matrix.trace.core.AppMethodBeat.o(12852);
     */
    /* JADX WARNING: Missing block: B:28:0x0072, code skipped:
            r2 = r11.eTy.presentationTimeUs;
            com.tencent.mm.sdk.platformtools.ab.i(TAG, "presentationTimeUs : ".concat(java.lang.String.valueOf(r2)));
     */
    /* JADX WARNING: Missing block: B:29:0x008b, code skipped:
            if (r2 >= (r11.bqO * 1000)) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:31:0x0093, code skipped:
            if ((r11.eTy.flags & 4) != 0) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:32:0x0095, code skipped:
            Uy().releaseOutputBuffer(r0, false);
            com.tencent.mm.sdk.platformtools.ab.i(TAG, "decoder pts: " + r2 + ", not reach start: " + (r11.bqO * 1000));
            com.tencent.matrix.trace.core.AppMethodBeat.o(12852);
     */
    /* JADX WARNING: Missing block: B:34:0x00cb, code skipped:
            if (r11.eTy.size <= 0) goto L_0x00d2;
     */
    /* JADX WARNING: Missing block: B:35:0x00cd, code skipped:
            e(r1, r11.eTy);
     */
    /* JADX WARNING: Missing block: B:36:0x00d2, code skipped:
            Uy().releaseOutputBuffer(r0, false);
     */
    /* JADX WARNING: Missing block: B:37:0x00e1, code skipped:
            if ((r11.eTA * 1000) == 1) goto L_0x00fc;
     */
    /* JADX WARNING: Missing block: B:39:0x00e8, code skipped:
            if (r2 < (r11.eTA * 1000)) goto L_0x00fc;
     */
    /* JADX WARNING: Missing block: B:40:0x00ea, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e(TAG, "exceed endTimeMs");
            UA();
            com.tencent.matrix.trace.core.AppMethodBeat.o(12852);
     */
    /* JADX WARNING: Missing block: B:42:0x0102, code skipped:
            if ((r11.eTy.flags & 4) == 0) goto L_0x0116;
     */
    /* JADX WARNING: Missing block: B:43:0x0104, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i(TAG, "receive EOS!");
            UA();
            com.tencent.matrix.trace.core.AppMethodBeat.o(12852);
     */
    /* JADX WARNING: Missing block: B:44:0x0116, code skipped:
            r0 = Uy().dequeueOutputBuffer(r11.eTy, eTR);
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:54:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void UD() {
        AppMethodBeat.i(12852);
        try {
            synchronized (this.eTu) {
                if (this.eTr) {
                    ab.i(TAG, "drainDecoder, decoder is stop");
                    AppMethodBeat.o(12852);
                    return;
                }
                y yVar = y.AUy;
            }
        } catch (Exception e) {
            this.eTQ = true;
            ab.printErrStackTrace(TAG, e, "", new Object[0]);
        } catch (Throwable th) {
            AppMethodBeat.o(12852);
        }
        AppMethodBeat.o(12852);
    }
}
