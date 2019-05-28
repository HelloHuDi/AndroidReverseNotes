package com.tencent.mm.media.d;

import a.a.t;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0011\u0018\u0000 !2\u00020\u0001:\u0002!\"BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\u0002\u0010\u000fJ\"\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u0010\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R2\u0010\u0013\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
public final class d extends a {
    public static final a eVG = new a();
    private List<b> eVD = Collections.synchronizedList(new ArrayList());
    private boolean eVE;
    private c eVF = new c(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, dWq = {"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    public static final class c extends Callback {
        final /* synthetic */ d eVI;

        c(d dVar) {
            this.eVI = dVar;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.i(12938);
            try {
                ab.d("MicroMsg.MediaCodecAACEncoder", "encoderOutputBufferIndex: %s", Integer.valueOf(i));
                if (i == -1) {
                    ab.d("MicroMsg.MediaCodecAACEncoder", "no output available, break");
                    AppMethodBeat.o(12938);
                } else if (i == -2) {
                    d dVar = this.eVI;
                    MediaFormat outputFormat = this.eVI.eVq.getOutputFormat();
                    j.o(outputFormat, "encoder.outputFormat");
                    dVar.c(outputFormat);
                    ab.i("MicroMsg.MediaCodecAACEncoder", "dstMediaFormat change: %s", this.eVI.eVr);
                    AppMethodBeat.o(12938);
                } else if (i < 0) {
                    ab.e("MicroMsg.MediaCodecAACEncoder", "unexpected encoderOutputBufferIndex: %s", Integer.valueOf(i));
                    AppMethodBeat.o(12938);
                } else {
                    if (bufferInfo == null) {
                        j.dWJ();
                    }
                    if ((bufferInfo.flags & 2) != 0) {
                        ab.v("MicroMsg.MediaCodecAACEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(bufferInfo.size), Boolean.TRUE);
                        bufferInfo.size = 0;
                    }
                    ab.v("MicroMsg.MediaCodecAACEncoder", "perform encoding");
                    this.eVI.f(this.eVI.eVq.getOutputBuffer(i), bufferInfo);
                    this.eVI.eVq.releaseOutputBuffer(i, false);
                    if ((bufferInfo.flags & 4) != 0 || this.eVI.eVE) {
                        ab.i("MicroMsg.MediaCodecAACEncoder", "receive EOS!");
                        this.eVI.releaseEncoder();
                        AppMethodBeat.o(12938);
                        return;
                    }
                    AppMethodBeat.o(12938);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", e, "drainEncoder error: %s", e.getMessage());
                AppMethodBeat.o(12938);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.i(12939);
            try {
                ab.i("MicroMsg.MediaCodecAACEncoder", "has input buffer ".concat(String.valueOf(i)));
                if (this.eVI.eVD.size() == 0) {
                    ab.i("MicroMsg.MediaCodecAACEncoder", "current data is null");
                    this.eVI.eVq.queueInputBuffer(i, 0, 0, 0, 0);
                    AppMethodBeat.o(12939);
                    return;
                }
                ab.i("MicroMsg.MediaCodecAACEncoder", "has input buffer avaiable".concat(String.valueOf(i)));
                if (this.eVI.eTf) {
                    ab.i("MicroMsg.MediaCodecAACEncoder", "sendDataToEncoder end now");
                    AppMethodBeat.o(12939);
                    return;
                }
                this.eVI.eVs = bo.yz();
                if (i < 0) {
                    ab.d("MicroMsg.MediaCodecAACEncoder", "encoder no input buffer available, drain first");
                    AppMethodBeat.o(12939);
                    return;
                }
                List c = this.eVI.eVD;
                j.o(c, "inputDataSource");
                b bVar = (b) t.fJ(c);
                byte[] bArr = bVar.ckv;
                long j = bVar.eTe;
                boolean z = bVar.eVH;
                if (bArr == null) {
                    AppMethodBeat.o(12939);
                    return;
                }
                if (i >= 0) {
                    int i2;
                    ByteBuffer inputBuffer = this.eVI.eVq.getInputBuffer(i);
                    if (inputBuffer != null) {
                        inputBuffer.clear();
                    }
                    if (inputBuffer != null) {
                        inputBuffer.position(0);
                    }
                    if (inputBuffer != null) {
                        inputBuffer.put(bArr);
                    }
                    if (z) {
                        ab.i("MicroMsg.MediaCodecAACEncoder", "last, send EOS and try delay stop encoder");
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        this.eVI.eVE = true;
                        ab.i("MicroMsg.MediaCodecAACEncoder", "EOS received in sendAudioToEncoder");
                        this.eVI.eVq.queueInputBuffer(i, 0, bArr.length, j, 4);
                    } else {
                        this.eVI.eVq.queueInputBuffer(i, 0, bArr.length, j, 0);
                    }
                    this.eVI.eVD.remove(bVar);
                    AppMethodBeat.o(12939);
                    return;
                }
                AppMethodBeat.o(12939);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", e, "onInputBufferAvailable error", new Object[0]);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "", "pcmData", "", "pts", "", "isLast", "", "([BJZ)V", "()Z", "setLast", "(Z)V", "getPcmData", "()[B", "setPcmData", "([B)V", "getPts", "()J", "setPts", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
    public static final class b {
        byte[] ckv;
        long eTe;
        boolean eVH;

        /* JADX WARNING: Missing block: B:13:0x002b, code skipped:
            if ((r7.eVH == r8.eVH) != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(12937);
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (j.j(this.ckv, bVar.ckv)) {
                        if (this.eTe == bVar.eTe) {
                        }
                    }
                }
                AppMethodBeat.o(12937);
                return false;
            }
            AppMethodBeat.o(12937);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(12936);
            byte[] bArr = this.ckv;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            long j = this.eTe;
            int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
            hashCode = this.eVH;
            if (hashCode != 0) {
                hashCode = 1;
            }
            hashCode += i;
            AppMethodBeat.o(12936);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(12935);
            String str = "EncoderData(pcmData=" + Arrays.toString(this.ckv) + ", pts=" + this.eTe + ", isLast=" + this.eVH + ")";
            AppMethodBeat.o(12935);
            return str;
        }

        public b(byte[] bArr, long j, boolean z) {
            this.ckv = bArr;
            this.eTe = j;
            this.eVH = z;
        }
    }

    static {
        AppMethodBeat.i(12942);
        AppMethodBeat.o(12942);
    }

    public d(MediaFormat mediaFormat, m<? super ByteBuffer, ? super BufferInfo, y> mVar, a.f.a.a<y> aVar) {
        j.p(mediaFormat, "mediaFormat");
        j.p(mVar, "frameEncodeCallback");
        j.p(aVar, "frameEncodeEndCallback");
        super(mediaFormat, mVar, aVar);
        AppMethodBeat.i(12941);
        try {
            this.eVq.setCallback(this.eVF);
            this.eVq.start();
            AppMethodBeat.o(12941);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", e, "", new Object[0]);
            AppMethodBeat.o(12941);
        }
    }

    public final void b(byte[] bArr, long j, boolean z) {
        AppMethodBeat.i(12940);
        j.p(bArr, "data");
        if (bArr != null) {
            this.eVD.add(new b(bArr, j, z));
        }
        AppMethodBeat.o(12940);
    }
}
