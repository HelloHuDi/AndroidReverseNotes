package com.tencent.mm.media.d;

import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0005\b&\u0018\u0000 E2\u00020\u0001:\u0001EBW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e¢\u0006\u0002\u0010\u000fJ\u0006\u0010;\u001a\u00020\fJ\u0006\u0010<\u001a\u00020*J\u0018\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010?\u001a\u00020\fH\u0004J \u0010@\u001a\u00020\f2\u0006\u0010\t\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020*H&J\u0006\u0010D\u001a\u00020\fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RL\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0018\"\u0004\b:\u0010\u001a¨\u0006F"}, dWq = {"Lcom/tencent/mm/media/encoder/IAudioEncoder;", "", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "dstMediaFormat", "getDstMediaFormat", "()Landroid/media/MediaFormat;", "setDstMediaFormat", "(Landroid/media/MediaFormat;)V", "encodeStartTick", "", "getEncodeStartTick", "()J", "setEncodeStartTick", "(J)V", "encoder", "Landroid/media/MediaCodec;", "getEncoder", "()Landroid/media/MediaCodec;", "setEncoder", "(Landroid/media/MediaCodec;)V", "getFrameEncodeCallback", "()Lkotlin/jvm/functions/Function2;", "setFrameEncodeCallback", "(Lkotlin/jvm/functions/Function2;)V", "getFrameEncodeEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameEncodeEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "isEnd", "", "()Z", "setEnd", "(Z)V", "mMimeType", "", "getMMimeType", "()Ljava/lang/String;", "setMMimeType", "(Ljava/lang/String;)V", "stopLock", "Ljava/lang/Object;", "getStopLock", "()Ljava/lang/Object;", "totalEncodeTime", "getTotalEncodeTime", "setTotalEncodeTime", "finishEncode", "isIgnoreCodecConfig", "processEncodeBuffer", "buffer", "releaseEncoder", "startEncoder", "", "pts", "isLast", "stopEncoder", "Companion", "plugin-mediaeditor_release"})
public abstract class a {
    public static final a eVw = new a();
    volatile boolean eTf;
    final Object eTu = new Object();
    MediaCodec eVq;
    MediaFormat eVr;
    long eVs;
    private long eVt;
    private m<? super ByteBuffer, ? super BufferInfo, y> eVu;
    private a.f.a.a<y> eVv;
    private String mMimeType;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/media/encoder/IAudioEncoder$Companion;", "", "()V", "AAC_MIME_TYPE", "", "TAG", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public abstract void b(byte[] bArr, long j, boolean z);

    public a(MediaFormat mediaFormat, m<? super ByteBuffer, ? super BufferInfo, y> mVar, a.f.a.a<y> aVar) {
        j.p(mediaFormat, "mediaFormat");
        j.p(mVar, "frameEncodeCallback");
        j.p(aVar, "frameEncodeEndCallback");
        this.eVu = mVar;
        this.eVv = aVar;
        ab.i("MicroMsg.IAudioEncoder", "init audio encoder");
        this.mMimeType = mediaFormat.getString("mime");
        try {
            this.eVr = new MediaFormat();
            this.eVr.setString("mime", "audio/mp4a-latm");
            this.eVr.setInteger("aac-profile", 2);
            this.eVr.setInteger("sample-rate", TXRecordCommon.AUDIO_SAMPLERATE_44100);
            this.eVr.setInteger("channel-count", 1);
            this.eVr.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, mediaFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE));
            this.eVr.setInteger("max-input-size", 2048);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            j.o(createEncoderByType, "MediaCodec.createEncoderByType(AAC_MIME_TYPE)");
            this.eVq = createEncoderByType;
            this.eVq.configure(this.eVr, null, null, 1);
        } catch (Exception e) {
            throw new IllegalStateException("init encoder error");
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(MediaFormat mediaFormat) {
        j.p(mediaFormat, "<set-?>");
        this.eVr = mediaFormat;
    }

    public final void stopEncoder() {
        releaseEncoder();
    }

    public final void UO() {
        releaseEncoder();
    }

    public final void f(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        j.p(bufferInfo, "bufferInfo");
        if (byteBuffer == null) {
            ab.e("MicroMsg.IAudioEncoder", "ERROR, retrieve encoderOutputBuffer is null!!");
        } else if (bufferInfo.size > 0) {
            ab.i("MicroMsg.IAudioEncoder", "encoder output buffer:" + bufferInfo.size + ", pts:" + bufferInfo.presentationTimeUs);
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            long az = bo.az(this.eVs);
            this.eVt += az;
            ab.i("MicroMsg.IAudioEncoder", hashCode() + " encode frame used " + az);
            this.eVu.m(byteBuffer, bufferInfo);
        }
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void releaseEncoder() {
        try {
            synchronized (this.eTu) {
                if (!this.eTf) {
                    this.eTf = true;
                    ab.i("MicroMsg.IAudioEncoder", "releaseEncoder");
                    this.eVq.stop();
                    this.eVq.release();
                    this.eVv.invoke();
                }
                ab.i("MicroMsg.IAudioEncoder", "total encode used " + this.eVt);
                y yVar = y.AUy;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.IAudioEncoder", "releaseEncoder error: %s", e.getMessage());
        }
        return;
    }
}
