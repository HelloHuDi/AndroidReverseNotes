package com.tencent.p177mm.media.p865c;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.view.Surface;
import com.tencent.p177mm.media.p1464e.C32742a;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u0010X\u001a\u00020\u001dJ\b\u0010Y\u001a\u00020\u001dH\u0002J\b\u0010Z\u001a\u0004\u0018\u00010/J\b\u0010[\u001a\u00020&H\u0004JD\u0010\\\u001a\u00020;2<\u0010]\u001a8\u0012\u0015\u0012\u0013\u0018\u000106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(:\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u000105J\u0016\u0010@\u001a\u00020;2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010AJ+\u0010F\u001a\u00020;2#\u0010]\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020;\u0018\u00010GJ\u001a\u0010^\u001a\u00020;2\b\u0010_\u001a\u0004\u0018\u0001062\u0006\u0010`\u001a\u00020aH\u0004J\b\u0010b\u001a\u00020;H\u0016J\u000e\u0010c\u001a\u00020;2\u0006\u0010d\u001a\u00020\u001dJ\u000e\u0010e\u001a\u00020;2\u0006\u0010f\u001a\u00020&J\b\u0010g\u001a\u00020;H&J\u000e\u0010h\u001a\u00020;2\u0006\u0010h\u001a\u00020&R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103RP\u00104\u001a8\u0012\u0015\u0012\u0013\u0018\u000106¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(:\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER7\u0010F\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020;\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0019\"\u0004\bO\u0010\u001bR\u001a\u0010P\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010'\"\u0004\bR\u0010)R\u001a\u0010S\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006i"}, dWq = {"Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "decodeSurface", "Landroid/view/Surface;", "(JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;)V", "TAG", "", "getDecodeSurface", "()Landroid/view/Surface;", "decoder", "Landroid/media/MediaCodec;", "getDecoder", "()Landroid/media/MediaCodec;", "setDecoder", "(Landroid/media/MediaCodec;)V", "decoderLock", "Ljava/lang/Object;", "getDecoderLock", "()Ljava/lang/Object;", "getEndTimeMs", "()J", "setEndTimeMs", "(J)V", "frameCount", "", "frameDropInterval", "frameDuration", "", "getFrameDuration", "()F", "setFrameDuration", "(F)V", "isFinished", "", "()Z", "setFinished", "(Z)V", "isPause", "setPause", "getMediaExtractorWrapper", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getMediaFormat", "()Landroid/media/MediaFormat;", "setMediaFormat", "(Landroid/media/MediaFormat;)V", "onDecodeDataCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "decodeData", "pts", "", "getOnDecodeDataCallback", "()Lkotlin/jvm/functions/Function2;", "setOnDecodeDataCallback", "(Lkotlin/jvm/functions/Function2;)V", "onDecodeEnd", "Lkotlin/Function0;", "getOnDecodeEnd", "()Lkotlin/jvm/functions/Function0;", "setOnDecodeEnd", "(Lkotlin/jvm/functions/Function0;)V", "onFormatChanged", "Lkotlin/Function1;", "getOnFormatChanged", "()Lkotlin/jvm/functions/Function1;", "setOnFormatChanged", "(Lkotlin/jvm/functions/Function1;)V", "pauseSemaphore", "Ljava/util/concurrent/Semaphore;", "getStartTimeMs", "setStartTimeMs", "useInRemuxer", "getUseInRemuxer", "setUseInRemuxer", "videoFps", "getVideoFps", "()I", "setVideoFps", "(I)V", "getFrameCount", "getFrameDropInterval", "getVideoFormat", "isDecoderPause", "onDecode", "callback", "processDecodeOutputBuffer", "byteBuffer", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "releaseDecoder", "setFrameDropInterval", "interval", "setPauseDecoder", "pause", "startDecode", "useInRemux", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.c.b */
public abstract class C45425b {
    public final String TAG = "MicroMsg.IMediaCodecTransDecoder";
    long bqO;
    private volatile boolean cAY;
    long eTA;
    public C31591m<? super ByteBuffer, ? super Long, C37091y> eTG;
    public C31214a<C37091y> eTH;
    public C17126b<? super MediaFormat, C37091y> eTI;
    public int eTJ;
    private final Semaphore eTK = new Semaphore(1);
    final Object eTL = new Object();
    boolean eTM;
    private float eTN;
    public boolean eTO;
    final Surface eTP;
    protected MediaCodec eTq;
    final C32742a eTz;
    private int frameCount;
    public MediaFormat mediaFormat;
    private int videoFps;

    /* renamed from: UB */
    public abstract void mo44163UB();

    public C45425b(long j, long j2, C32742a c32742a, Surface surface) {
        C25052j.m39376p(c32742a, "mediaExtractorWrapper");
        this.bqO = j;
        this.eTA = j2;
        this.eTz = c32742a;
        this.eTP = surface;
        C4990ab.m7416i(this.TAG, "create IMediaCodecTransDecoder, startTimeMs:" + this.bqO + ", endTimeMs:" + this.eTA);
        this.eTz.mo53290UT();
        if (this.bqO >= 0) {
            this.eTz.seek(this.bqO * 1000);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Uy */
    public final MediaCodec mo73216Uy() {
        MediaCodec mediaCodec = this.eTq;
        if (mediaCodec == null) {
            C25052j.avw("decoder");
        }
        return mediaCodec;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo73218a(MediaCodec mediaCodec) {
        C25052j.m39376p(mediaCodec, "<set-?>");
        this.eTq = mediaCodec;
    }

    /* renamed from: cp */
    public final void mo73219cp(boolean z) {
        long yz = C5046bo.m7588yz();
        this.cAY = z;
        C4990ab.m7410d(this.TAG, "setPauseDecoder:" + z + ", remain:" + this.eTK.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + yz);
        if (z) {
            C4990ab.m7410d(this.TAG, "try acquire, thread:" + Thread.currentThread() + ' ' + yz);
            this.eTK.acquire();
        } else {
            C4990ab.m7410d(this.TAG, "release, thread:" + Thread.currentThread() + ' ' + yz);
            this.eTK.release();
        }
        C4990ab.m7410d(this.TAG, "after setPauseDecoder:" + z + ", remain:" + this.eTK.availablePermits() + ", thread:" + Thread.currentThread() + ' ' + yz);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo73217a(BufferInfo bufferInfo) {
        Object obj = null;
        C25052j.m39376p(bufferInfo, "bufferInfo");
        if (this.videoFps <= 0) {
            MediaFormat mediaFormat = this.mediaFormat;
            if (!(mediaFormat == null || mediaFormat.containsKey("frame-rate"))) {
                mediaFormat = this.eTz.eWe;
            }
            if (mediaFormat == null || mediaFormat.containsKey("frame-rate")) {
                this.videoFps = mediaFormat != null ? mediaFormat.getInteger("frame-rate") : 0;
            } else {
                C43528a WR = C21846d.m33388WR(this.eTz.filePath);
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
        C4990ab.m7416i(this.TAG, "processDecodeOutputBuffer, byteBuffer: " + null + ", pts: " + bufferInfo.presentationTimeUs + ", calcPts:" + j + ", frameDuration:" + this.eTN + ", frameCount:" + this.frameCount + ", startTimeMs:" + this.bqO + ", size: " + bufferInfo.size + ", isMain:" + C25052j.m39373j(Looper.myLooper(), Looper.getMainLooper()));
        C4990ab.m7410d(this.TAG, "jump one frame: " + this.frameCount);
        if (this.eTJ > 1 && this.frameCount % this.eTJ == 0) {
            return;
        }
        C31591m c31591m;
        if (obj2 != null) {
            c31591m = this.eTG;
            if (c31591m != null) {
                c31591m.mo212m(null, Long.valueOf(j));
                return;
            }
            return;
        }
        c31591m = this.eTG;
        if (c31591m != null) {
            c31591m.mo212m(null, Long.valueOf(bufferInfo.presentationTimeUs));
        }
    }

    /* renamed from: sI */
    public void mo44164sI() {
        C4990ab.m7416i(this.TAG, "releaseDecoder");
        synchronized (this.eTL) {
            try {
                MediaCodec mediaCodec = this.eTq;
                if (mediaCodec == null) {
                    C25052j.avw("decoder");
                }
                mediaCodec.stop();
                mediaCodec = this.eTq;
                if (mediaCodec == null) {
                    C25052j.avw("decoder");
                }
                mediaCodec.release();
                this.eTM = true;
            } catch (Exception e) {
            }
            C37091y c37091y = C37091y.AUy;
        }
    }
}
