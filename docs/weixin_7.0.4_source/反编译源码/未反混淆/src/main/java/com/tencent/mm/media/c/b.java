package com.tencent.mm.media.c;

import a.f.a.a;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010X\u001a\u00020\u001dJ\b\u0010Y\u001a\u00020\u001dH\u0002J\b\u0010Z\u001a\u0004\u0018\u00010/J\b\u0010[\u001a\u00020&H\u0004JD\u0010\\\u001a\u00020;2<\u0010]\u001a8\u0012\u0015\u0012\u0013\u0018\u000106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(:\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u000105J\u0016\u0010@\u001a\u00020;2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010AJ+\u0010F\u001a\u00020;2#\u0010]\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020;\u0018\u00010GJ\u001a\u0010^\u001a\u00020;2\b\u0010_\u001a\u0004\u0018\u0001062\u0006\u0010`\u001a\u00020aH\u0004J\b\u0010b\u001a\u00020;H\u0016J\u000e\u0010c\u001a\u00020;2\u0006\u0010d\u001a\u00020\u001dJ\u000e\u0010e\u001a\u00020;2\u0006\u0010f\u001a\u00020&J\b\u0010g\u001a\u00020;H&J\u000e\u0010h\u001a\u00020;2\u0006\u0010h\u001a\u00020&R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103RP\u00104\u001a8\u0012\u0015\u0012\u0013\u0018\u000106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(:\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER7\u0010F\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020;\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0019\"\u0004\bO\u0010\u001bR\u001a\u0010P\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010'\"\u0004\bR\u0010)R\u001a\u0010S\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006i"}, dWq = {"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;)V", "TAG", "", "getDecodeSurface", "()Landroid/view/Surface;", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "byteBuffer", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
public abstract class b {
    public final String TAG = "MicroMsg.IMediaCodecTransDecoder";
    long bqO;
    private volatile boolean cAY;
    long eTA;
    public m<? super ByteBuffer, ? super Long, y> eTG;
    public a<y> eTH;
    public a.f.a.b<? super MediaFormat, y> eTI;
    public int eTJ;
    private final Semaphore eTK = new Semaphore(1);
    final Object eTL = new Object();
    boolean eTM;
    private float eTN;
    public boolean eTO;
    final Surface eTP;
    protected MediaCodec eTq;
    final com.tencent.mm.media.e.a eTz;
    private int frameCount;
    public MediaFormat mediaFormat;
    private int videoFps;

    public abstract void UB();

    public b(long j, long j2, com.tencent.mm.media.e.a aVar, Surface surface) {
        j.p(aVar, "mediaExtractorWrapper");
        this.bqO = j;
        this.eTA = j2;
        this.eTz = aVar;
        this.eTP = surface;
        ab.i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.bqO + ", endTimeMs:" + this.eTA);
        this.eTz.UT();
        if (this.bqO >= 0) {
            this.eTz.seek(this.bqO * 1000);
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

    /* Access modifiers changed, original: protected|final */
    public final void a(MediaCodec mediaCodec) {
        j.p(mediaCodec, "<set-?>");
        this.eTq = mediaCodec;
    }

    public final void cp(boolean z) {
        long yz = bo.yz();
        this.cAY = z;
        ab.d(this.TAG, "setPauseDecoder:" + z + ", remain:" + this.eTK.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + yz);
        if (z) {
            ab.d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + yz);
            this.eTK.acquire();
        } else {
            ab.d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + yz);
            this.eTK.release();
        }
        ab.d(this.TAG, "after setPauseDecoder:" + z + ", remain:" + this.eTK.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + yz);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(BufferInfo bufferInfo) {
        Object obj = null;
        j.p(bufferInfo, "bufferInfo");
        if (this.videoFps <= 0) {
            MediaFormat mediaFormat = this.mediaFormat;
            if (!(mediaFormat == null || mediaFormat.containsKey("frame-rate"))) {
                mediaFormat = this.eTz.eWe;
            }
            if (mediaFormat == null || mediaFormat.containsKey("frame-rate")) {
                this.videoFps = mediaFormat != null ? mediaFormat.getInteger("frame-rate") : 0;
            } else {
                com.tencent.mm.plugin.sight.base.a WR = d.WR(this.eTz.filePath);
                this.videoFps = WR != null ? WR.eTk : 0;
            }
            if (this.videoFps > 0) {
                this.eTN = 1000.0f / ((float) this.videoFps);
            }
        }
        if (this.videoFps > 0) {
            int obj2 = 1;
        }
        this.frameCount++;
        long j = (long) ((((float) this.bqO) + (((float) this.frameCount) * this.eTN)) * 1000.0f);
        ab.i(this.TAG, "processDecodeOutputBuffer, byteBuffer: " + null + ", pts: " + bufferInfo.presentationTimeUs + ", calcPts:" + j + ", frameDuration:" + this.eTN + ", frameCount:" + this.frameCount + ", startTimeMs:" + this.bqO + ", size: " + bufferInfo.size + ", isMain:" + j.j(Looper.myLooper(), Looper.getMainLooper()));
        ab.d(this.TAG, "jump one frame: " + this.frameCount);
        if (this.eTJ > 1 && this.frameCount % this.eTJ == 0) {
            return;
        }
        m mVar;
        if (obj2 != null) {
            mVar = this.eTG;
            if (mVar != null) {
                mVar.m(null, Long.valueOf(j));
                return;
            }
            return;
        }
        mVar = this.eTG;
        if (mVar != null) {
            mVar.m(null, Long.valueOf(bufferInfo.presentationTimeUs));
        }
    }

    public void sI() {
        ab.i(this.TAG, "releaseDecoder");
        synchronized (this.eTL) {
            try {
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
                this.eTM = true;
            } catch (Exception e) {
            }
            y yVar = y.AUy;
        }
    }
}
