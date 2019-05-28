package com.tencent.p177mm.plugin.emojicapture.model.p388b;

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
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020!H\u0016R\u000e\u0010\t\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "videoDuration", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;ILandroid/view/Surface;)V", "TAG", "codecCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1;", "decoder", "Landroid/media/MediaCodec;", "decoderThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "extractor", "Landroid/media/MediaExtractor;", "inputEos", "", "inputSampleTime", "", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "init", "processDecodeBuffer", "", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.j */
public final class C42973j extends C45868l {
    final String TAG = "MicroMsg.EmojiMixVideoDecoderAsync";
    private final Surface aOO;
    MediaExtractor clX = new MediaExtractor();
    private String clY = "";
    MediaCodec eTq;
    HandlerThread eUd = C7305d.anM("EmojiMixVideoDecoderAsync_decodeThread");
    private final int eWK;
    final Object liQ = new Object();
    boolean liS;
    long liT;
    private final C38913a liU = new C38913a(this);
    MediaFormat mediaFormat;
    private final String videoPath;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, dWq = {"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoderAsync$codecCallback$1", "Landroid/media/MediaCodec$Callback;", "onError", "", "codec", "Landroid/media/MediaCodec;", "e", "Landroid/media/MediaCodec$CodecException;", "onInputBufferAvailable", "index", "", "onOutputBufferAvailable", "info", "Landroid/media/MediaCodec$BufferInfo;", "onOutputFormatChanged", "format", "Landroid/media/MediaFormat;", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.j$a */
    public static final class C38913a extends Callback {
        final /* synthetic */ C42973j liV;

        C38913a(C42973j c42973j) {
            this.liV = c42973j;
        }

        /* JADX WARNING: Missing block: B:40:0x0116, code skipped:
            if (r0 <= r2) goto L_0x00c1;
     */
        /* JADX WARNING: Missing block: B:42:0x011c, code skipped:
            if ((r12.flags & 4) == 0) goto L_0x011e;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo) {
            AppMethodBeat.m2504i(2689);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(bufferInfo, "info");
            C4990ab.m7416i(this.liV.TAG, "onOutputBufferAvailable " + i + ", flags " + bufferInfo.flags);
            MediaCodec mediaCodec2;
            if (i < 0 || bufferInfo.size == 0) {
                mediaCodec2 = this.liV.eTq;
                if (mediaCodec2 != null) {
                    mediaCodec2.releaseOutputBuffer(i, false);
                    AppMethodBeat.m2505o(2689);
                    return;
                }
            }
            long j = bufferInfo.presentationTimeUs;
            C4990ab.m7416i(this.liV.TAG, "presentationTimeUs: " + j + ", inputSampleTime: " + this.liV.liT);
            mediaCodec2 = this.liV.eTq;
            if (mediaCodec2 != null) {
                mediaCodec2.releaseOutputBuffer(i, true);
            }
            C42973j c42973j = this.liV;
            C4990ab.m7416i(c42973j.TAG, "processDecodeBuffer pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size);
            C17126b c17126b = c42973j.ljl;
            if (c17126b != null) {
                c17126b.mo50am(Long.valueOf(bufferInfo.presentationTimeUs * 1000));
            }
            synchronized (c42973j.liQ) {
                try {
                    c42973j.liQ.wait(50);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(c42973j.TAG, e, "", new Object[0]);
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(2689);
                }
                C37091y c37091y = C37091y.AUy;
            }
            if (this.liV.liS) {
                long j2 = this.liV.liT;
                if (0 <= j) {
                }
                C4990ab.m7416i(this.liV.TAG, "receive eos!");
                C4990ab.m7416i(this.liV.TAG, "sendDecoderEos");
                C42973j c42973j2 = this.liV;
                C4990ab.m7416i(c42973j2.TAG, "release");
                try {
                    c42973j2.eUd.quit();
                    MediaCodec mediaCodec3 = c42973j2.eTq;
                    if (mediaCodec3 != null) {
                        mediaCodec3.stop();
                    }
                    mediaCodec2 = c42973j2.eTq;
                    if (mediaCodec2 != null) {
                        mediaCodec2.release();
                    }
                } catch (Exception e2) {
                }
                C31214a c31214a = this.liV.ljm;
                if (c31214a != null) {
                    c31214a.invoke();
                    AppMethodBeat.m2505o(2689);
                    return;
                }
                AppMethodBeat.m2505o(2689);
                return;
            }
            AppMethodBeat.m2505o(2689);
        }

        public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            AppMethodBeat.m2504i(2690);
            C25052j.m39376p(mediaCodec, "codec");
            C4990ab.m7416i(this.liV.TAG, "onInputBufferAvailable ".concat(String.valueOf(i)));
            if (i >= 0 && !this.liV.liS) {
                MediaCodec mediaCodec2 = this.liV.eTq;
                ByteBuffer inputBuffer = mediaCodec2 != null ? mediaCodec2.getInputBuffer(i) : null;
                if (inputBuffer == null) {
                    C4990ab.m7420w(this.liV.TAG, "inputBuffer is null");
                    AppMethodBeat.m2505o(2690);
                    return;
                }
                boolean z;
                inputBuffer.clear();
                int readSampleData = this.liV.clX.readSampleData(inputBuffer, 0);
                this.liV.clX.advance();
                inputBuffer.position(0);
                long sampleTime = this.liV.clX.getSampleTime();
                C4990ab.m7416i(this.liV.TAG, "sampleTime: " + sampleTime + ", sampleSize: " + readSampleData);
                if (sampleTime > this.liV.liT) {
                    this.liV.liT = sampleTime;
                }
                if (readSampleData < 0 || sampleTime < 0) {
                    C4990ab.m7416i(this.liV.TAG, "read sample end");
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
                    AppMethodBeat.m2505o(2690);
                    return;
                }
            }
            AppMethodBeat.m2505o(2690);
        }

        public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            AppMethodBeat.m2504i(2691);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(mediaFormat, "format");
            C4990ab.m7416i(this.liV.TAG, "onOutputFormatChanged ".concat(String.valueOf(mediaFormat)));
            this.liV.mediaFormat = mediaFormat;
            AppMethodBeat.m2505o(2691);
        }

        public final void onError(MediaCodec mediaCodec, CodecException codecException) {
            AppMethodBeat.m2504i(2692);
            C25052j.m39376p(mediaCodec, "codec");
            C25052j.m39376p(codecException, "e");
            C4990ab.printErrStackTrace(this.liV.TAG, codecException, "onError", new Object[0]);
            AppMethodBeat.m2505o(2692);
        }
    }

    public C42973j(String str, int i, Surface surface) {
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(surface, "surface");
        AppMethodBeat.m2504i(2696);
        this.videoPath = str;
        this.eWK = i;
        this.aOO = surface;
        try {
            C4990ab.m7416i(this.TAG, "create decoder with path: " + this.videoPath);
            this.clX.setDataSource(this.videoPath);
            int trackCount = this.clX.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i2);
                String string = trackFormat.getString("mime");
                C25052j.m39375o(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                if (C31820v.m51540d((CharSequence) string, (CharSequence) "video")) {
                    string = trackFormat.getString("mime");
                    C25052j.m39375o(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                    this.clY = string;
                    this.mediaFormat = trackFormat;
                    C4990ab.m7416i(this.TAG, "find video format " + this.mediaFormat + ", mime: " + this.clY);
                    this.clX.selectTrack(i2);
                    AppMethodBeat.m2505o(2696);
                    return;
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "init create extractor error", new Object[0]);
        }
        AppMethodBeat.m2505o(2696);
    }

    public final int init() {
        AppMethodBeat.m2504i(2693);
        if (this.mediaFormat == null || C5046bo.isNullOrNil(this.clY)) {
            AppMethodBeat.m2505o(2693);
            return -1;
        }
        try {
            this.eTq = MediaCodec.createDecoderByType(this.clY);
            MediaCodec mediaCodec = this.eTq;
            if (mediaCodec != null) {
                mediaCodec.configure(this.mediaFormat, this.aOO, null, 0);
            }
            if (C1443d.m3068iW(23)) {
                this.eUd.start();
                HandlerThread handlerThread = this.eUd;
                C25052j.m39375o(handlerThread, "decoderThread");
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
            AppMethodBeat.m2505o(2693);
            return 0;
        } catch (Exception e) {
            C4990ab.m7412e(this.TAG, "init decoder error " + e.getMessage());
            AppMethodBeat.m2505o(2693);
            return -1;
        }
    }

    /* renamed from: UB */
    public final void mo61799UB() {
        AppMethodBeat.m2504i(2694);
        if (this.eTq == null) {
            C31214a c31214a = this.ljm;
            if (c31214a != null) {
                c31214a.invoke();
                AppMethodBeat.m2505o(2694);
                return;
            }
            AppMethodBeat.m2505o(2694);
            return;
        }
        MediaCodec mediaCodec = this.eTq;
        if (mediaCodec != null) {
            mediaCodec.start();
            AppMethodBeat.m2505o(2694);
            return;
        }
        AppMethodBeat.m2505o(2694);
    }

    public final void bnH() {
        AppMethodBeat.m2504i(2695);
        synchronized (this.liQ) {
            try {
                this.liQ.notifyAll();
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(2695);
            }
            C37091y c37091y = C37091y.AUy;
        }
        AppMethodBeat.m2505o(2695);
    }
}
