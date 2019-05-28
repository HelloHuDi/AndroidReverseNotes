package com.tencent.mm.plugin.emojicapture.model.b;

import a.f.a.b;
import a.k.v;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

@l(dWo = {1, 1, 13}, dWp = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020!H\u0016R\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Landroid/media/MediaCodec;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Landroid/media/MediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
public final class j extends l {
    final String TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    private final Surface aOO;
    MediaExtractor clX = new MediaExtractor();
    private String clY = "";
    MediaCodec eTq;
    HandlerThread eUd = d.anM("EmojiMixVideoDecoderAsync_decodeThread");
    private final int eWK;
    final Object liQ = new Object();
    boolean liS;
    long liT;
    private final a liU = new a(this);
    MediaFormat mediaFormat;
    private final String videoPath;

    @l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, dWq = {"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
    public static final class a extends Callback {
        final /* synthetic */ j liV;

        a(j jVar) {
            this.liV = jVar;
        }

        /* JADX WARNING: Missing block: B:40:0x0116, code skipped:
            if (r0 <= r2) goto L_0x00c1;
     */
        /* JADX WARNING: Missing block: B:42:0x011c, code skipped:
            if ((r12.flags & 4) == 0) goto L_0x011e;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.i(2689);
            a.f.b.j.p(mediaCodec, "codec");
            a.f.b.j.p(bufferInfo, "info");
            ab.i(this.liV.TAG, "onOutputBufferAvailable " + i + ", flags " + bufferInfo.flags);
            MediaCodec mediaCodec2;
            if (i < 0 || bufferInfo.size == 0) {
                mediaCodec2 = this.liV.eTq;
                if (mediaCodec2 != null) {
                    mediaCodec2.releaseOutputBuffer(i, false);
                    AppMethodBeat.o(2689);
                    return;
                }
            }
            long j = bufferInfo.presentationTimeUs;
            ab.i(this.liV.TAG, "presentationTimeUs: " + j + ", inputSampleTime: " + this.liV.liT);
            mediaCodec2 = this.liV.eTq;
            if (mediaCodec2 != null) {
                mediaCodec2.releaseOutputBuffer(i, true);
            }
            j jVar = this.liV;
            ab.i(jVar.TAG, "processDecodeBuffer pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size);
            b bVar = jVar.ljl;
            if (bVar != null) {
                bVar.am(Long.valueOf(bufferInfo.presentationTimeUs * 1000));
            }
            synchronized (jVar.liQ) {
                try {
                    jVar.liQ.wait(50);
                } catch (Exception e) {
                    ab.printErrStackTrace(jVar.TAG, e, "", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.o(2689);
                }
                y yVar = y.AUy;
            }
            if (this.liV.liS) {
                long j2 = this.liV.liT;
                if (0 <= j) {
                }
                ab.i(this.liV.TAG, "receive eos!");
                ab.i(this.liV.TAG, "sendDecoderEos");
                j jVar2 = this.liV;
                ab.i(jVar2.TAG, "release");
                try {
                    jVar2.eUd.quit();
                    MediaCodec mediaCodec3 = jVar2.eTq;
                    if (mediaCodec3 != null) {
                        mediaCodec3.stop();
                    }
                    mediaCodec2 = jVar2.eTq;
                    if (mediaCodec2 != null) {
                        mediaCodec2.release();
                    }
                } catch (Exception e2) {
                }
                a.f.a.a aVar = this.liV.ljm;
                if (aVar != null) {
                    aVar.invoke();
                    AppMethodBeat.o(2689);
                    return;
                }
                AppMethodBeat.o(2689);
                return;
            }
            AppMethodBeat.o(2689);
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.i(2690);
            a.f.b.j.p(mediaCodec, "codec");
            ab.i(this.liV.TAG, "onInputBufferAvailable ".concat(String.valueOf(i)));
            if (i >= 0 && !this.liV.liS) {
                MediaCodec mediaCodec2 = this.liV.eTq;
                ByteBuffer inputBuffer = mediaCodec2 != null ? mediaCodec2.getInputBuffer(i) : null;
                if (inputBuffer == null) {
                    ab.w(this.liV.TAG, "inputBuffer is null");
                    AppMethodBeat.o(2690);
                    return;
                }
                boolean z;
                inputBuffer.clear();
                int readSampleData = this.liV.clX.readSampleData(inputBuffer, 0);
                this.liV.clX.advance();
                inputBuffer.position(0);
                long sampleTime = this.liV.clX.getSampleTime();
                ab.i(this.liV.TAG, "sampleTime: " + sampleTime + ", sampleSize: " + readSampleData);
                if (sampleTime > this.liV.liT) {
                    this.liV.liT = sampleTime;
                }
                if (readSampleData < 0 || sampleTime < 0) {
                    ab.i(this.liV.TAG, "read sample end");
                    z = true;
                } else {
                    z = false;
                }
                this.liV.liS = z;
                mediaCodec2 = this.liV.eTq;
                if (mediaCodec2 != null) {
                    int i2;
                    if (this.liV.liS) {
                        i2 = 4;
                    } else {
                        i2 = 0;
                    }
                    mediaCodec2.queueInputBuffer(i, 0, readSampleData, sampleTime, i2);
                    AppMethodBeat.o(2690);
                    return;
                }
            }
            AppMethodBeat.o(2690);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.i(2691);
            a.f.b.j.p(mediaCodec, "codec");
            a.f.b.j.p(mediaFormat, "format");
            ab.i(this.liV.TAG, "onOutputFormatChanged ".concat(String.valueOf(mediaFormat)));
            this.liV.mediaFormat = mediaFormat;
            AppMethodBeat.o(2691);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
            AppMethodBeat.i(2692);
            a.f.b.j.p(mediaCodec, "codec");
            a.f.b.j.p(codecException, "e");
            ab.printErrStackTrace(this.liV.TAG, codecException, "onError", new Object[0]);
            AppMethodBeat.o(2692);
        }
    }

    public j(String str, int i, Surface surface) {
        a.f.b.j.p(str, "videoPath");
        a.f.b.j.p(surface, "surface");
        AppMethodBeat.i(2696);
        this.videoPath = str;
        this.eWK = i;
        this.aOO = surface;
        try {
            ab.i(this.TAG, "create decoder with path: " + this.videoPath);
            this.clX.setDataSource(this.videoPath);
            int trackCount = this.clX.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                a.f.b.j.o(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                if (v.d((CharSequence) string, (CharSequence) "video")) {
                    string = trackFormat.getString("mime");
                    a.f.b.j.o(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                    this.clY = string;
                    this.mediaFormat = trackFormat;
                    ab.i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.clY);
                    this.clX.selectTrack(i2);
                    AppMethodBeat.o(2696);
                    return;
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "init create extractor error", new Object[0]);
        }
        AppMethodBeat.o(2696);
    }

    public final int init() {
        AppMethodBeat.i(2693);
        if (this.mediaFormat == null || bo.isNullOrNil(this.clY)) {
            AppMethodBeat.o(2693);
            return -1;
        }
        try {
            this.eTq = MediaCodec.createDecoderByType(this.clY);
            MediaCodec mediaCodec = this.eTq;
            if (mediaCodec != null) {
                mediaCodec.configure(this.mediaFormat, this.aOO, null, 0);
            }
            if (com.tencent.mm.compatible.util.d.iW(23)) {
                this.eUd.start();
                HandlerThread handlerThread = this.eUd;
                a.f.b.j.o(handlerThread, "decoderThread");
                Handler handler = new Handler(handlerThread.getLooper());
                MediaCodec mediaCodec2 = this.eTq;
                if (mediaCodec2 != null) {
                    mediaCodec2.setCallback(this.liU, handler);
                }
            } else {
                MediaCodec mediaCodec3 = this.eTq;
                if (mediaCodec3 != null) {
                    mediaCodec3.setCallback(this.liU);
                }
            }
            AppMethodBeat.o(2693);
            return 0;
        } catch (Exception e) {
            ab.e(this.TAG, "init decoder error " + e.getMessage());
            AppMethodBeat.o(2693);
            return -1;
        }
    }

    public final void UB() {
        AppMethodBeat.i(2694);
        if (this.eTq == null) {
            a.f.a.a aVar = this.ljm;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(2694);
                return;
            }
            AppMethodBeat.o(2694);
            return;
        }
        MediaCodec mediaCodec = this.eTq;
        if (mediaCodec != null) {
            mediaCodec.start();
            AppMethodBeat.o(2694);
            return;
        }
        AppMethodBeat.o(2694);
    }

    public final void bnH() {
        AppMethodBeat.i(2695);
        synchronized (this.liQ) {
            try {
                this.liQ.notifyAll();
            } catch (Exception e) {
                ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(2695);
            }
            y yVar = y.AUy;
        }
        AppMethodBeat.o(2695);
    }
}
