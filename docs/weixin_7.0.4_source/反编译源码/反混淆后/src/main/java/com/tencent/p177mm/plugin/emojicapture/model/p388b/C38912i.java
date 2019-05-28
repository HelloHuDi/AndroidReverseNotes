package com.tencent.p177mm.plugin.emojicapture.model.p388b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020#H\u0002R\u000e\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cXD¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixVideoDecoder;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/IEmojiMixDecoder;", "videoPath", "", "surface", "Landroid/view/Surface;", "(Ljava/lang/String;Landroid/view/Surface;)V", "TAG", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "setBufferInfo", "(Landroid/media/MediaCodec$BufferInfo;)V", "decoder", "Landroid/media/MediaCodec;", "extractor", "Landroid/media/MediaExtractor;", "mediaFormat", "Landroid/media/MediaFormat;", "mime", "pauseDecoderLock", "Ljava/lang/Object;", "getPauseDecoderLock", "()Ljava/lang/Object;", "waitInputQueueMaxCount", "", "waitInputQueueTimeout", "", "waitOutputQueueTimeout", "drainDecoder", "", "init", "inputDecoder", "processDecodeBuffer", "", "release", "sendDecoderEos", "setPauseDecode", "pause", "startDecode", "startDecodeImpl", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.b.i */
public final class C38912i extends C45868l {
    final String TAG = "MicroMsg.MixVideoDecoder";
    private final Surface aOO;
    MediaExtractor clX = new MediaExtractor();
    private String clY = "";
    MediaCodec eTq;
    private BufferInfo eTy = new BufferInfo();
    final long liN = 60000;
    private final long liO = 10000;
    final int liP = 10;
    private final Object liQ = new Object();
    private MediaFormat mediaFormat;
    private final String videoPath;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b.i$a */
    static final class C38911a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C38912i liR;

        C38911a(C38912i c38912i) {
            this.liR = c38912i;
            super(0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A:{LOOP_END, LOOP:0: B:1:0x001b->B:51:0x0104} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0098 A:{SYNTHETIC, EDGE_INSN: B:55:0x0098->B:23:0x0098 ?: BREAK  } */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0098 A:{SYNTHETIC, EDGE_INSN: B:55:0x0098->B:23:0x0098 ?: BREAK  } */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0104 A:{LOOP_END, LOOP:0: B:1:0x001b->B:51:0x0104} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object invoke() {
            MediaCodec mediaCodec;
            AppMethodBeat.m2504i(2682);
            C38912i c38912i = this.liR;
            C4990ab.m7416i(c38912i.TAG, "startDecode");
            c38912i.clX.seekTo(0, 2);
            while (true) {
                mediaCodec = c38912i.eTq;
                if (mediaCodec == null) {
                    C25052j.avw("decoder");
                }
                int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(c38912i.liN);
                int i = 0;
                while (dequeueInputBuffer < 0 && i < c38912i.liP) {
                    boolean UF = c38912i.mo61800UF();
                    C4990ab.m7416i(c38912i.TAG, "inputDecoder " + dequeueInputBuffer + ' ' + i + ' ' + UF);
                    if (!UF) {
                        break;
                    }
                    MediaCodec mediaCodec2 = c38912i.eTq;
                    if (mediaCodec2 == null) {
                        C25052j.avw("decoder");
                    }
                    dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(c38912i.liN);
                    i++;
                }
                int i2;
                if (dequeueInputBuffer >= 0) {
                    mediaCodec = c38912i.eTq;
                    if (mediaCodec == null) {
                        C25052j.avw("decoder");
                    }
                    ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
                    byteBuffer.clear();
                    int readSampleData = c38912i.clX.readSampleData(byteBuffer, 0);
                    if (readSampleData < 0) {
                        C4990ab.m7416i(c38912i.TAG, "read sample end");
                        i = 0;
                        if (i == 0) {
                            break;
                        }
                        c38912i.clX.advance();
                    } else {
                        byteBuffer.position(0);
                        long sampleTime = c38912i.clX.getSampleTime();
                        if (sampleTime < 0) {
                            C4990ab.m7416i(c38912i.TAG, "read sample end, saw eos");
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        mediaCodec = c38912i.eTq;
                        if (mediaCodec == null) {
                            C25052j.avw("decoder");
                        }
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, i2 != 0 ? 4 : 0);
                    }
                } else {
                    i2 = 0;
                }
                if (!c38912i.mo61800UF() && r7 == 0) {
                    i = 1;
                    if (i == 0) {
                    }
                }
                i = 0;
                if (i == 0) {
                }
            }
            C4990ab.m7416i(c38912i.TAG, "input end");
            c38912i.bnI();
            C4990ab.m7416i(c38912i.TAG, "release");
            try {
                mediaCodec = c38912i.eTq;
                if (mediaCodec == null) {
                    C25052j.avw("decoder");
                }
                mediaCodec.stop();
                mediaCodec = c38912i.eTq;
                if (mediaCodec == null) {
                    C25052j.avw("decoder");
                }
                mediaCodec.release();
            } catch (Exception e) {
            }
            C31214a c31214a = c38912i.ljm;
            if (c31214a != null) {
                c31214a.invoke();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2682);
            return c37091y;
        }
    }

    public C38912i(String str, Surface surface) {
        C25052j.m39376p(str, "videoPath");
        C25052j.m39376p(surface, "surface");
        AppMethodBeat.m2504i(2688);
        this.videoPath = str;
        this.aOO = surface;
        try {
            C4990ab.m7416i(this.TAG, "create decoder with path: " + this.videoPath);
            this.clX.setDataSource(this.videoPath);
            int trackCount = this.clX.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.clX.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                C25052j.m39375o(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                if (C31820v.m51540d((CharSequence) string, (CharSequence) "video")) {
                    string = trackFormat.getString("mime");
                    C25052j.m39375o(string, "trackFormat.getString(MediaFormat.KEY_MIME)");
                    this.clY = string;
                    C25052j.m39375o(trackFormat, "trackFormat");
                    this.mediaFormat = trackFormat;
                    string = this.TAG;
                    StringBuilder stringBuilder = new StringBuilder("find video format ");
                    MediaFormat mediaFormat = this.mediaFormat;
                    if (mediaFormat == null) {
                        C25052j.avw("mediaFormat");
                    }
                    C4990ab.m7416i(string, stringBuilder.append(mediaFormat).append(", mime: ").append(this.clY).toString());
                    this.clX.selectTrack(i);
                    AppMethodBeat.m2505o(2688);
                    return;
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace(this.TAG, e, "init create extractor error", new Object[0]);
        }
        AppMethodBeat.m2505o(2688);
    }

    public final int init() {
        AppMethodBeat.m2504i(2683);
        if (this.mediaFormat == null || C5046bo.isNullOrNil(this.clY)) {
            AppMethodBeat.m2505o(2683);
            return -1;
        }
        try {
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.clY);
            C25052j.m39375o(createDecoderByType, "MediaCodec.createDecoderByType(mime)");
            this.eTq = createDecoderByType;
            createDecoderByType = this.eTq;
            if (createDecoderByType == null) {
                C25052j.avw("decoder");
            }
            MediaFormat mediaFormat = this.mediaFormat;
            if (mediaFormat == null) {
                C25052j.avw("mediaFormat");
            }
            createDecoderByType.configure(mediaFormat, this.aOO, null, 0);
            createDecoderByType = this.eTq;
            if (createDecoderByType == null) {
                C25052j.avw("decoder");
            }
            createDecoderByType.start();
            AppMethodBeat.m2505o(2683);
            return 0;
        } catch (Exception e) {
            C4990ab.m7412e(this.TAG, "init decoder error " + e.getMessage());
            AppMethodBeat.m2505o(2683);
            return -1;
        }
    }

    /* renamed from: UB */
    public final void mo61799UB() {
        AppMethodBeat.m2504i(2684);
        C8902b.m16043a((C31214a) new C38911a(this), "EmojiMixVideoDecoder_decodeThread");
        AppMethodBeat.m2505o(2684);
    }

    public final void bnH() {
        AppMethodBeat.m2504i(2685);
        synchronized (this.liQ) {
            try {
                this.liQ.notifyAll();
            } catch (Exception e) {
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(2685);
            }
            C37091y c37091y = C37091y.AUy;
        }
        AppMethodBeat.m2505o(2685);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: UF */
    public final boolean mo61800UF() {
        AppMethodBeat.m2504i(2686);
        MediaCodec mediaCodec = this.eTq;
        if (mediaCodec == null) {
            C25052j.avw("decoder");
        }
        int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.eTy, this.liO);
        MediaCodec mediaCodec2 = this.eTq;
        if (mediaCodec2 == null) {
            C25052j.avw("decoder");
        }
        ByteBuffer[] outputBuffers = mediaCodec2.getOutputBuffers();
        int i = dequeueOutputBuffer;
        while (i != -1) {
            if (i != -2) {
                ByteBuffer[] outputBuffers2;
                if (i == -3) {
                    mediaCodec = this.eTq;
                    if (mediaCodec == null) {
                        C25052j.avw("decoder");
                    }
                    if (mediaCodec.getOutputBuffers() != null) {
                        mediaCodec = this.eTq;
                        if (mediaCodec == null) {
                            C25052j.avw("decoder");
                        }
                        outputBuffers2 = mediaCodec.getOutputBuffers();
                    }
                    outputBuffers2 = outputBuffers;
                } else if (i < 0) {
                    C4990ab.m7416i(this.TAG, "drainDecoder loop outputBufferIndex:" + i + ", break");
                    break;
                } else {
                    ByteBuffer byteBuffer = outputBuffers[i];
                    long j = this.eTy.presentationTimeUs;
                    if ((this.eTy.flags & 4) != 0) {
                        C4990ab.m7416i(this.TAG, "drainDecoder loop reach eof");
                        mediaCodec = this.eTq;
                        if (mediaCodec == null) {
                            C25052j.avw("decoder");
                        }
                        mediaCodec.releaseOutputBuffer(i, true);
                        AppMethodBeat.m2505o(2686);
                        return true;
                    } else if (byteBuffer == null || this.eTy.size == 0) {
                        mediaCodec = this.eTq;
                        if (mediaCodec == null) {
                            C25052j.avw("decoder");
                        }
                        mediaCodec.releaseOutputBuffer(i, true);
                        outputBuffers2 = outputBuffers;
                    } else {
                        byteBuffer.position(this.eTy.offset);
                        byteBuffer.limit(this.eTy.offset + this.eTy.size);
                        mediaCodec = this.eTq;
                        if (mediaCodec == null) {
                            C25052j.avw("decoder");
                        }
                        mediaCodec.releaseOutputBuffer(i, true);
                        BufferInfo bufferInfo = this.eTy;
                        C4990ab.m7416i(this.TAG, "processDecodeBuffer pts: " + bufferInfo.presentationTimeUs + ", size: " + bufferInfo.size);
                        C17126b c17126b = this.ljl;
                        if (c17126b != null) {
                            c17126b.mo50am(Long.valueOf(bufferInfo.presentationTimeUs * 1000));
                        }
                        synchronized (this.liQ) {
                            try {
                                this.liQ.wait(50);
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(2686);
                            }
                            C37091y c37091y = C37091y.AUy;
                        }
                        if ((this.eTy.flags & 4) != 0) {
                            try {
                                mediaCodec = this.eTq;
                                if (mediaCodec == null) {
                                    C25052j.avw("decoder");
                                }
                                mediaCodec.stop();
                                mediaCodec = this.eTq;
                                if (mediaCodec == null) {
                                    C25052j.avw("decoder");
                                }
                                mediaCodec.release();
                            } catch (Exception e2) {
                            }
                            AppMethodBeat.m2505o(2686);
                            return true;
                        }
                        outputBuffers2 = outputBuffers;
                    }
                }
                mediaCodec2 = this.eTq;
                if (mediaCodec2 == null) {
                    C25052j.avw("decoder");
                }
                i = mediaCodec2.dequeueOutputBuffer(this.eTy, this.liO);
                if (i < 0) {
                    break;
                }
                outputBuffers = outputBuffers2;
            } else {
                String str = this.TAG;
                StringBuilder stringBuilder = new StringBuilder("drainDecoder output format change: ");
                MediaCodec mediaCodec3 = this.eTq;
                if (mediaCodec3 == null) {
                    C25052j.avw("decoder");
                }
                C4990ab.m7416i(str, stringBuilder.append(mediaCodec3.getOutputFormat()).toString());
                mediaCodec = this.eTq;
                if (mediaCodec == null) {
                    C25052j.avw("decoder");
                }
                MediaFormat outputFormat = mediaCodec.getOutputFormat();
                C25052j.m39375o(outputFormat, "decoder.outputFormat");
                this.mediaFormat = outputFormat;
            }
        }
        C4990ab.m7416i(this.TAG, "drainDecoder try again later");
        AppMethodBeat.m2505o(2686);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bnI() {
        AppMethodBeat.m2504i(2687);
        C4990ab.m7416i(this.TAG, "sendDecoderEos");
        MediaCodec mediaCodec = this.eTq;
        if (mediaCodec == null) {
            C25052j.avw("decoder");
        }
        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(this.liN);
        int i = 0;
        while (dequeueInputBuffer < 0 && i < this.liP) {
            if (mo61800UF()) {
                MediaCodec mediaCodec2 = this.eTq;
                if (mediaCodec2 == null) {
                    C25052j.avw("decoder");
                }
                dequeueInputBuffer = mediaCodec2.dequeueInputBuffer(this.liN);
                i++;
            } else {
                AppMethodBeat.m2505o(2687);
                return;
            }
        }
        if (dequeueInputBuffer >= 0) {
            mediaCodec = this.eTq;
            if (mediaCodec == null) {
                C25052j.avw("decoder");
            }
            ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
            byteBuffer.clear();
            this.clX.readSampleData(byteBuffer, 0);
            byteBuffer.position(0);
            mediaCodec = this.eTq;
            if (mediaCodec == null) {
                C25052j.avw("decoder");
            }
            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
        }
        mo61800UF();
        AppMethodBeat.m2505o(2687);
    }
}
