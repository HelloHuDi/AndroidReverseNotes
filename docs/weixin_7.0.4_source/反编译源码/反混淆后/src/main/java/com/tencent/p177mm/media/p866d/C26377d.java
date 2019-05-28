package com.tencent.p177mm.media.p866d;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0011\u0018\u0000 !2\u00020\u0001:\u0002!\"BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\u0002\u0010\u000fJ\"\u0010\u001a\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u0010\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R2\u0010\u0013\u001a&\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015 \u0016*\u0012\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u0015\u0018\u00010\u00170\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacCallback", "com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1;", "inputDataSource", "", "Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "kotlin.jvm.PlatformType", "", "isInputEnd", "", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "startEncoder", "Companion", "EncoderData", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.d.d */
public final class C26377d extends C37887a {
    public static final C26378a eVG = new C26378a();
    private List<C26379b> eVD = Collections.synchronizedList(new ArrayList());
    private boolean eVE;
    private C9580c eVF = new C9580c(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, dWq = {"com/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$aacCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.d.d$c */
    public static final class C9580c extends Callback {
        final /* synthetic */ C26377d eVI;

        C9580c(C26377d c26377d) {
            this.eVI = c26377d;
        }

        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.m2504i(12938);
            try {
                C4990ab.m7411d("MicroMsg.MediaCodecAACEncoder", "encoderOutputBufferIndex: %s", Integer.valueOf(i));
                if (i == -1) {
                    C4990ab.m7410d("MicroMsg.MediaCodecAACEncoder", "no output available, break");
                    AppMethodBeat.m2505o(12938);
                } else if (i == -2) {
                    C26377d c26377d = this.eVI;
                    MediaFormat outputFormat = this.eVI.eVq.getOutputFormat();
                    C25052j.m39375o(outputFormat, "encoder.outputFormat");
                    c26377d.mo60635c(outputFormat);
                    C4990ab.m7417i("MicroMsg.MediaCodecAACEncoder", "dstMediaFormat change: %s", this.eVI.eVr);
                    AppMethodBeat.m2505o(12938);
                } else if (i < 0) {
                    C4990ab.m7413e("MicroMsg.MediaCodecAACEncoder", "unexpected encoderOutputBufferIndex: %s", Integer.valueOf(i));
                    AppMethodBeat.m2505o(12938);
                } else {
                    if (bufferInfo == null) {
                        C25052j.dWJ();
                    }
                    if ((bufferInfo.flags & 2) != 0) {
                        C4990ab.m7419v("MicroMsg.MediaCodecAACEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", Integer.valueOf(bufferInfo.size), Boolean.TRUE);
                        bufferInfo.size = 0;
                    }
                    C4990ab.m7418v("MicroMsg.MediaCodecAACEncoder", "perform encoding");
                    this.eVI.mo60636f(this.eVI.eVq.getOutputBuffer(i), bufferInfo);
                    this.eVI.eVq.releaseOutputBuffer(i, false);
                    if ((bufferInfo.flags & 4) != 0 || this.eVI.eVE) {
                        C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "receive EOS!");
                        this.eVI.releaseEncoder();
                        AppMethodBeat.m2505o(12938);
                        return;
                    }
                    AppMethodBeat.m2505o(12938);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", e, "drainEncoder error: %s", e.getMessage());
                AppMethodBeat.m2505o(12938);
            }
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.m2504i(12939);
            try {
                C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "has input buffer ".concat(String.valueOf(i)));
                if (this.eVI.eVD.size() == 0) {
                    C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "current data is null");
                    this.eVI.eVq.queueInputBuffer(i, 0, 0, 0, 0);
                    AppMethodBeat.m2505o(12939);
                    return;
                }
                C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "has input buffer avaiable".concat(String.valueOf(i)));
                if (this.eVI.eTf) {
                    C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "sendDataToEncoder end now");
                    AppMethodBeat.m2505o(12939);
                    return;
                }
                this.eVI.eVs = C5046bo.m7588yz();
                if (i < 0) {
                    C4990ab.m7410d("MicroMsg.MediaCodecAACEncoder", "encoder no input buffer available, drain first");
                    AppMethodBeat.m2505o(12939);
                    return;
                }
                List c = this.eVI.eVD;
                C25052j.m39375o(c, "inputDataSource");
                C26379b c26379b = (C26379b) C25035t.m39337fJ(c);
                byte[] bArr = c26379b.ckv;
                long j = c26379b.eTe;
                boolean z = c26379b.eVH;
                if (bArr == null) {
                    AppMethodBeat.m2505o(12939);
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
                        C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "last, send EOS and try delay stop encoder");
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        this.eVI.eVE = true;
                        C4990ab.m7416i("MicroMsg.MediaCodecAACEncoder", "EOS received in sendAudioToEncoder");
                        this.eVI.eVq.queueInputBuffer(i, 0, bArr.length, j, 4);
                    } else {
                        this.eVI.eVq.queueInputBuffer(i, 0, bArr.length, j, 0);
                    }
                    this.eVI.eVD.remove(c26379b);
                    AppMethodBeat.m2505o(12939);
                    return;
                }
                AppMethodBeat.m2505o(12939);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", e, "onInputBufferAvailable error", new Object[0]);
            }
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.d.d$a */
    public static final class C26378a {
        private C26378a() {
        }

        public /* synthetic */ C26378a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoderAsync$EncoderData;", "", "pcmData", "", "pts", "", "isLast", "", "([BJZ)V", "()Z", "setLast", "(Z)V", "getPcmData", "()[B", "setPcmData", "([B)V", "getPts", "()J", "setPts", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.d.d$b */
    public static final class C26379b {
        byte[] ckv;
        long eTe;
        boolean eVH;

        /* JADX WARNING: Missing block: B:13:0x002b, code skipped:
            if ((r7.eVH == r8.eVH) != false) goto L_0x002d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(12937);
            if (this != obj) {
                if (obj instanceof C26379b) {
                    C26379b c26379b = (C26379b) obj;
                    if (C25052j.m39373j(this.ckv, c26379b.ckv)) {
                        if (this.eTe == c26379b.eTe) {
                        }
                    }
                }
                AppMethodBeat.m2505o(12937);
                return false;
            }
            AppMethodBeat.m2505o(12937);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(12936);
            byte[] bArr = this.ckv;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            long j = this.eTe;
            int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
            hashCode = this.eVH;
            if (hashCode != 0) {
                hashCode = 1;
            }
            hashCode += i;
            AppMethodBeat.m2505o(12936);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(12935);
            String str = "EncoderData(pcmData=" + Arrays.toString(this.ckv) + ", pts=" + this.eTe + ", isLast=" + this.eVH + ")";
            AppMethodBeat.m2505o(12935);
            return str;
        }

        public C26379b(byte[] bArr, long j, boolean z) {
            this.ckv = bArr;
            this.eTe = j;
            this.eVH = z;
        }
    }

    static {
        AppMethodBeat.m2504i(12942);
        AppMethodBeat.m2505o(12942);
    }

    public C26377d(MediaFormat mediaFormat, C31591m<? super ByteBuffer, ? super BufferInfo, C37091y> c31591m, C31214a<C37091y> c31214a) {
        C25052j.m39376p(mediaFormat, "mediaFormat");
        C25052j.m39376p(c31591m, "frameEncodeCallback");
        C25052j.m39376p(c31214a, "frameEncodeEndCallback");
        super(mediaFormat, c31591m, c31214a);
        AppMethodBeat.m2504i(12941);
        try {
            this.eVq.setCallback(this.eVF);
            this.eVq.start();
            AppMethodBeat.m2505o(12941);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaCodecAACEncoder", e, "", new Object[0]);
            AppMethodBeat.m2505o(12941);
        }
    }

    /* renamed from: b */
    public final void mo44169b(byte[] bArr, long j, boolean z) {
        AppMethodBeat.m2504i(12940);
        C25052j.m39376p(bArr, "data");
        if (bArr != null) {
            this.eVD.add(new C26379b(bArr, j, z));
        }
        AppMethodBeat.m2505o(12940);
    }
}
