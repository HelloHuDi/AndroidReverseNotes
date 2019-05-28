package com.tencent.mm.media.c;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 b2\u00020\u0001:\u0001bBq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\n\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0006\u0010[\u001a\u00020\u0015J\u0006\u0010\\\u001a\u00020\u0015J\u001a\u0010]\u001a\u00020\u00102\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010!\u001a\u00020\"H\u0004J\b\u0010`\u001a\u00020\u0010H&J\b\u0010a\u001a\u00020\u0010H\u0016R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010/\"\u0004\b<\u00101RN\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001e\"\u0004\bQ\u0010 R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010/\"\u0004\bS\u00101R\u0014\u0010T\u001a\u00020UX\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010/\"\u0004\bZ\u00101¨\u0006c"}, dWq = {"Lcom/tencent/mm/media/decoder/IAudioDecoder;", "", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "audioId", "", "startTimeMs", "", "endTimeMs", "frameDecodeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pcmData", "pts", "", "frameDecodeEndCallback", "Lkotlin/Function0;", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;Ljava/lang/String;JJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "aacSampleRate", "", "getAacSampleRate", "()I", "setAacSampleRate", "(I)V", "audioChannelCount", "getAudioChannelCount", "setAudioChannelCount", "getAudioId", "()Ljava/lang/String;", "setAudioId", "(Ljava/lang/String;)V", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decodeFrame", "", "getDecodeFrame", "()Z", "setDecodeFrame", "(Z)V", "decodeStartTick", "getDecodeStartTick", "()J", "setDecodeStartTick", "(J)V", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "decoderStop", "getDecoderStop", "setDecoderStop", "getEndTimeMs", "setEndTimeMs", "getFrameDecodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameDecodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameDecodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDecodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "mMediaFormat", "Landroid/media/MediaFormat;", "getMMediaFormat", "()Landroid/media/MediaFormat;", "setMMediaFormat", "(Landroid/media/MediaFormat;)V", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "setMediaExtractorWrapper", "(Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;)V", "mime", "getMime", "setMime", "getStartTimeMs", "setStartTimeMs", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalDecodeTime", "getTotalDecodeTime", "setTotalDecodeTime", "getChannelCount", "getSampleRate", "processDecodeBuffer", "byteBuffer", "Ljava/nio/ByteBuffer;", "startDecoder", "stopDecoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a {
    private static final int eTD = 2048;
    private static final int eTE = 4096;
    public static final a eTF = new a();
    long bqO;
    String ckD;
    private String clY = "";
    long eTA;
    private m<? super byte[], ? super Long, y> eTB;
    private a.f.a.a<y> eTC;
    protected MediaCodec eTq;
    volatile boolean eTr;
    public int eTs;
    public int eTt;
    final Object eTu = new Object();
    long eTv;
    private long eTw;
    private boolean eTx;
    BufferInfo eTy = new BufferInfo();
    com.tencent.mm.media.e.a eTz;
    MediaFormat mMediaFormat = this.eTz.eWf;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, dWq = {"Lcom/tencent/mm/media/decoder/IAudioDecoder$Companion;", "", "()V", "MONO_CHANNEL_BUF_SIZE", "", "STEREO_CHANNLE_BUF_SIZE", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public abstract void Uz();

    public a(com.tencent.mm.media.e.a aVar, String str, long j, long j2, m<? super byte[], ? super Long, y> mVar, a.f.a.a<y> aVar2) {
        j.p(aVar, "mediaExtractorWrapper");
        j.p(str, "audioId");
        j.p(mVar, "frameDecodeCallback");
        j.p(aVar2, "frameDecodeEndCallback");
        this.eTz = aVar;
        this.ckD = str;
        this.bqO = j;
        this.eTA = j2;
        this.eTB = mVar;
        this.eTC = aVar2;
        ab.i("MicroMsg.IAudioDecoder", "create MediaCodecAACDecoder, audioId:" + this.ckD + ", startTimeMs:" + this.bqO + ", endTimeMs:" + this.eTA + ", mediaFormat:" + this.mMediaFormat);
        if (this.mMediaFormat != null) {
            MediaFormat mediaFormat = this.mMediaFormat;
            if (mediaFormat != null) {
                mediaFormat.setInteger("max-input-size", 16384);
            }
            mediaFormat = this.mMediaFormat;
            if (mediaFormat == null) {
                j.dWJ();
            }
            this.eTs = mediaFormat.getInteger("channel-count");
            mediaFormat = this.mMediaFormat;
            if (mediaFormat == null) {
                j.dWJ();
            }
            this.eTt = mediaFormat.getInteger("sample-rate");
            mediaFormat = this.mMediaFormat;
            if (mediaFormat == null) {
                j.dWJ();
            }
            String string = mediaFormat.getString("mime");
            j.o(string, "mMediaFormat!!.getString(MediaFormat.KEY_MIME)");
            this.clY = string;
            mediaFormat = this.mMediaFormat;
            if (mediaFormat != null && mediaFormat.containsKey("encoder-delay")) {
                mediaFormat = this.mMediaFormat;
                if (mediaFormat != null) {
                    mediaFormat.setInteger("encoder-delay", 0);
                }
            }
            mediaFormat = this.mMediaFormat;
            if (mediaFormat != null && mediaFormat.containsKey("encoder-padding")) {
                mediaFormat = this.mMediaFormat;
                if (mediaFormat != null) {
                    mediaFormat.setInteger("encoder-padding", 0);
                }
            }
            this.eTz.UU();
            if (this.bqO >= 0) {
                this.eTz.seek(this.bqO * 1000);
            }
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.clY);
            j.o(createDecoderByType, "MediaCodec.createDecoderByType(mime)");
            this.eTq = createDecoderByType;
            createDecoderByType = this.eTq;
            if (createDecoderByType == null) {
                j.avw("decoder");
            }
            createDecoderByType.configure(this.mMediaFormat, null, null, 0);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final MediaCodec Uy() {
        MediaCodec mediaCodec = this.eTq;
        if (mediaCodec == null) {
            j.avw("decoder");
        }
        return mediaCodec;
    }

    public final void UA() {
        ab.b("MicroMsg.IAudioDecoder", "stop decoder", new Object[0]);
        synchronized (this.eTu) {
            ab.i("MicroMsg.IAudioDecoder", "stopDecoder in lock");
            try {
                if (!this.eTr) {
                    this.eTr = true;
                    MediaCodec mediaCodec = this.eTq;
                    if (mediaCodec == null) {
                        j.avw("decoder");
                    }
                    mediaCodec.stop();
                    mediaCodec = this.eTq;
                    if (mediaCodec == null) {
                        j.avw("decoder");
                    }
                    mediaCodec.release();
                    this.eTC.invoke();
                    ab.i("MicroMsg.IAudioDecoder", hashCode() + " total decode used " + this.eTw);
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.IAudioDecoder", e, "stopDecoder error", new Object[0]);
            }
            y yVar = y.AUy;
        }
        return;
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        j.p(bufferInfo, "bufferInfo");
        if (byteBuffer != null) {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.position(0);
            byteBuffer.get(bArr);
            if (!(bArr.length == 0)) {
                ab.i("MicroMsg.IAudioDecoder", "decoder pcmData size:" + bArr.length + ", pts:" + bufferInfo.presentationTimeUs + ", audioId:" + this.ckD);
                long az = bo.az(this.eTv);
                this.eTw += az;
                ab.i("MicroMsg.IAudioDecoder", hashCode() + " decode frame cost " + az);
                this.eTx = true;
                int i = this.eTs == 1 ? eTD : eTE;
                if (bArr.length > i) {
                    int length = bArr.length;
                    int i2 = 0;
                    while (length > 0) {
                        int i3;
                        if (length > i) {
                            i3 = i;
                        } else {
                            i3 = length;
                        }
                        byte[] bArr2 = new byte[i3];
                        System.arraycopy(bArr, i2, bArr2, 0, i3);
                        length -= i3;
                        i2 += i3;
                        ab.i("MicroMsg.IAudioDecoder", "split ret pcmData, leftSize:" + length + ", sizeOffset:" + i2 + ", maxBufferSize:" + i + ", copySize:" + i3 + ", data.size:" + bArr2.length);
                        this.eTB.m(bArr2, Long.valueOf(bufferInfo.presentationTimeUs));
                    }
                    return;
                }
                this.eTB.m(bArr, Long.valueOf(bufferInfo.presentationTimeUs));
            }
        }
    }
}
