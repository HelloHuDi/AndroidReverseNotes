package com.tencent.p177mm.plugin.music.p463f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.music.p462e.C44752b;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C28564b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.nio.ByteBuffer;

@TargetApi(16)
/* renamed from: com.tencent.mm.plugin.music.f.c */
public final class C31375c extends C28564b {
    AudioTrack aQf;
    MediaCodec bek;
    int channels = 0;
    int clN = 0;
    String clO;
    MediaExtractor clX;
    String clY = null;
    long duration = 0;
    private Runnable oNy = new C313761();
    private boolean ovl = true;
    long presentationTimeUs = 0;
    int sampleRate = 0;

    /* renamed from: com.tencent.mm.plugin.music.f.c$1 */
    class C313761 implements Runnable {
        C313761() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137562);
            C4990ab.m7416i("MicroMsg.Music.MMPlayer", "starting...");
            Process.setThreadPriority(-19);
            if (C5046bo.isNullOrNil(C31375c.this.clO)) {
                C4990ab.m7412e("MicroMsg.Music.MMPlayer", "source path is null");
                C31375c.this.mo46688jy(false);
                AppMethodBeat.m2505o(137562);
                return;
            }
            C31375c.this.clX = new MediaExtractor();
            try {
                C31375c.this.clX.setDataSource(C31375c.this.clO);
                MediaFormat mediaFormat = null;
                try {
                    int readSampleData;
                    MediaFormat trackFormat;
                    C4990ab.m7413e("MicroMsg.Music.MMPlayer", "tractCount is %d", Integer.valueOf(C31375c.this.clX.getTrackCount()));
                    for (int i = 0; i < readSampleData; i++) {
                        trackFormat = C31375c.this.clX.getTrackFormat(i);
                        C31375c.this.clY = trackFormat.getString("mime");
                        if (!C5046bo.isNullOrNil(C31375c.this.clY) && C31375c.this.clY.startsWith("audio/")) {
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    if (mediaFormat == null) {
                        C4990ab.m7412e("MicroMsg.Music.MMPlayer", "format is null");
                        C31375c.this.clN = 703;
                        C31375c.this.mo46688jy(true);
                        C31375c.m50706a(C31375c.this);
                        AppMethodBeat.m2505o(137562);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.Music.MMPlayer", "format:%s", mediaFormat);
                    C31375c.this.sampleRate = mediaFormat.getInteger("sample-rate");
                    C31375c.this.channels = mediaFormat.getInteger("channel-count");
                    C31375c.this.duration = mediaFormat.getLong("durationUs");
                    try {
                        if (C1443d.m3068iW(21)) {
                            String findDecoderForFormat = new MediaCodecList(1).findDecoderForFormat(mediaFormat);
                            if (findDecoderForFormat != null) {
                                C31375c.this.clY = findDecoderForFormat;
                            }
                        }
                        C31375c.this.bek = MediaCodec.createDecoderByType(C31375c.this.clY);
                        C31375c.this.bek.configure(mediaFormat, null, null, 0);
                        C31375c.this.bek.start();
                        ByteBuffer[] inputBuffers = C31375c.this.bek.getInputBuffers();
                        ByteBuffer[] outputBuffers = C31375c.this.bek.getOutputBuffers();
                        C4990ab.m7417i("MicroMsg.Music.MMPlayer", "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", mediaFormat, C31375c.this.clY, Integer.valueOf(C31375c.this.sampleRate), Integer.valueOf(C31375c.this.channels), Long.valueOf(C31375c.this.duration));
                        C31375c.this.clX.selectTrack(0);
                        BufferInfo bufferInfo = new BufferInfo();
                        Object obj = null;
                        Object obj2 = null;
                        int i2 = 0;
                        C31375c.this.oNR.oNV = 3;
                        C31375c.this.onStart();
                        ByteBuffer[] byteBufferArr = outputBuffers;
                        while (obj2 == null && i2 < 50) {
                            try {
                                C31375c.this.bUC();
                                if (!C31375c.this.bUz()) {
                                    break;
                                }
                                int dequeueInputBuffer;
                                i2++;
                                if (obj == null) {
                                    dequeueInputBuffer = C31375c.this.bek.dequeueInputBuffer(1000);
                                    if (dequeueInputBuffer >= 0) {
                                        Object obj3;
                                        readSampleData = C31375c.this.clX.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                        if (readSampleData < 0) {
                                            C4990ab.m7412e("MicroMsg.Music.MMPlayer", "saw input EOS. Stopping playback");
                                            obj3 = 1;
                                            readSampleData = 0;
                                        } else {
                                            C31375c.this.presentationTimeUs = C31375c.this.clX.getSampleTime();
                                            C31375c.this.mo46695zR(C31375c.this.duration == 0 ? 0 : (int) ((100 * C31375c.this.presentationTimeUs) / C31375c.this.duration));
                                            obj3 = obj;
                                        }
                                        C31375c.this.bek.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, C31375c.this.presentationTimeUs, obj3 != null ? 4 : 0);
                                        if (obj3 == null) {
                                            C31375c.this.clX.advance();
                                        }
                                        obj = obj3;
                                    } else {
                                        C4990ab.m7412e("MicroMsg.Music.MMPlayer", "inputBufIndex ".concat(String.valueOf(dequeueInputBuffer)));
                                    }
                                }
                                readSampleData = C31375c.this.bek.dequeueOutputBuffer(bufferInfo, 1000);
                                if (readSampleData >= 0) {
                                    Object obj4;
                                    if (bufferInfo.size > 0) {
                                        dequeueInputBuffer = 0;
                                    } else {
                                        dequeueInputBuffer = i2;
                                    }
                                    ByteBuffer byteBuffer = byteBufferArr[readSampleData];
                                    byte[] bArr = new byte[bufferInfo.size];
                                    byteBuffer.get(bArr);
                                    byteBuffer.clear();
                                    if (bArr.length > 0) {
                                        if (C31375c.this.aQf == null) {
                                            if (C31375c.this.createAudioTrack()) {
                                                C31375c.this.aQf.play();
                                            } else {
                                                C4990ab.m7412e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                C31375c.this.clN = 707;
                                                C31375c.this.mo46688jy(true);
                                                C31375c.m50706a(C31375c.this);
                                                C31375c.m50707b(C31375c.this);
                                                C31375c.m50708c(C31375c.this);
                                                C31375c.this.clO = null;
                                                C31375c.this.clY = null;
                                                C31375c.this.sampleRate = 0;
                                                C31375c.this.channels = 0;
                                                C31375c.this.presentationTimeUs = 0;
                                                C31375c.this.duration = 0;
                                                AppMethodBeat.m2505o(137562);
                                                return;
                                            }
                                        }
                                        C31375c.this.aQf.write(bArr, 0, bArr.length);
                                    }
                                    C31375c.this.bek.releaseOutputBuffer(readSampleData, false);
                                    if ((bufferInfo.flags & 4) != 0) {
                                        C4990ab.m7412e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                        obj4 = 1;
                                    } else {
                                        obj4 = obj2;
                                    }
                                    i2 = dequeueInputBuffer;
                                    obj2 = obj4;
                                } else if (readSampleData == -3) {
                                    outputBuffers = C31375c.this.bek.getOutputBuffers();
                                    C4990ab.m7416i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                    byteBufferArr = outputBuffers;
                                } else if (readSampleData == -2) {
                                    trackFormat = C31375c.this.bek.getOutputFormat();
                                    C4990ab.m7416i("MicroMsg.Music.MMPlayer", "output format has changed to ".concat(String.valueOf(trackFormat)));
                                    C31375c.this.sampleRate = trackFormat.getInteger("sample-rate");
                                    C31375c.this.channels = trackFormat.getInteger("channel-count");
                                    C31375c.m50708c(C31375c.this);
                                } else {
                                    C4990ab.m7416i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned ".concat(String.valueOf(readSampleData)));
                                }
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "error", new Object[0]);
                                C31375c.this.clN = 706;
                                C31375c.this.mo46688jy(true);
                                C31375c.m50706a(C31375c.this);
                                C31375c.m50707b(C31375c.this);
                                C31375c.m50708c(C31375c.this);
                                C31375c.this.clO = null;
                                C31375c.this.clY = null;
                                C31375c.this.sampleRate = 0;
                                C31375c.this.channels = 0;
                                C31375c.this.presentationTimeUs = 0;
                                C31375c.this.duration = 0;
                            } catch (Throwable th) {
                                C31375c.m50706a(C31375c.this);
                                C31375c.m50707b(C31375c.this);
                                C31375c.m50708c(C31375c.this);
                                C31375c.this.clO = null;
                                C31375c.this.clY = null;
                                C31375c.this.sampleRate = 0;
                                C31375c.this.channels = 0;
                                C31375c.this.presentationTimeUs = 0;
                                C31375c.this.duration = 0;
                                AppMethodBeat.m2505o(137562);
                            }
                        }
                        boolean z = (C31375c.this.duration / 1000) - (C31375c.this.presentationTimeUs / 1000) < FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                        if (i2 >= 50) {
                            C4990ab.m7413e("MicroMsg.Music.MMPlayer", "onError, noOutputCounter:%d", Integer.valueOf(i2));
                            C31375c.this.clN = 706;
                            C31375c.this.mo46688jy(true);
                        } else {
                            C4990ab.m7417i("MicroMsg.Music.MMPlayer", "onStop, isComplete:%b", Boolean.valueOf(z));
                            C31375c.this.mo46689jz(z);
                        }
                        C31375c.m50706a(C31375c.this);
                        C31375c.m50707b(C31375c.this);
                        C31375c.m50708c(C31375c.this);
                        C31375c.this.clO = null;
                        C31375c.this.clY = null;
                        C31375c.this.sampleRate = 0;
                        C31375c.this.channels = 0;
                        C31375c.this.presentationTimeUs = 0;
                        C31375c.this.duration = 0;
                        C4990ab.m7416i("MicroMsg.Music.MMPlayer", "stopping...");
                        AppMethodBeat.m2505o(137562);
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "createDecoderByType", new Object[0]);
                        C31375c.this.clN = 704;
                        C31375c.this.mo46688jy(true);
                        C31375c.m50706a(C31375c.this);
                        C31375c.m50707b(C31375c.this);
                        AppMethodBeat.m2505o(137562);
                    }
                } catch (Exception e22) {
                    C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e22, "get media format from media extractor", new Object[0]);
                    C31375c.this.clN = 705;
                }
            } catch (Exception e222) {
                C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e222, "set extractor data source", new Object[0]);
                C31375c.this.clN = 702;
                C31375c.this.mo46688jy(true);
                AppMethodBeat.m2505o(137562);
            }
        }
    }

    public C31375c() {
        AppMethodBeat.m2504i(137563);
        AppMethodBeat.m2505o(137563);
    }

    /* renamed from: Tr */
    public final void mo46681Tr(String str) {
        this.clO = str;
    }

    /* Access modifiers changed, original: final */
    public final boolean createAudioTrack() {
        AppMethodBeat.m2504i(137564);
        C4990ab.m7416i("MicroMsg.Music.MMPlayer", "createAudioTrack");
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        C44752b c44752b = (C44752b) C43329b.m77295ar(C44752b.class);
        if (c44752b != null) {
            this.aQf = c44752b.mo68876ac(this.sampleRate, i, minBufferSize);
        } else {
            C4990ab.m7412e("MicroMsg.Music.MMPlayer", "mediaResService null");
        }
        if (this.aQf == null) {
            C4990ab.m7412e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
            this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 1);
        }
        if (this.aQf == null || this.aQf.getState() != 1) {
            C4990ab.m7412e("MicroMsg.Music.MMPlayer", "audio track not initialized");
            if (this.aQf != null) {
                try {
                    this.aQf.release();
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(137564);
            return false;
        }
        AppMethodBeat.m2505o(137564);
        return true;
    }

    public final int bUA() {
        return (int) (this.presentationTimeUs / 1000);
    }

    public final int getDuration() {
        return (int) (this.duration / 1000);
    }

    public final void play() {
        AppMethodBeat.m2504i(137565);
        C4990ab.m7416i("MicroMsg.Music.MMPlayer", "play");
        if (bUz()) {
            if (bUz() && this.oNR.bUH()) {
                this.oNR.oNV = 3;
                m50705Eq();
            }
            AppMethodBeat.m2505o(137565);
            return;
        }
        this.ovl = false;
        C7305d.post(this.oNy, "music_player");
        AppMethodBeat.m2505o(137565);
    }

    /* renamed from: Eq */
    private synchronized void m50705Eq() {
        AppMethodBeat.m2504i(137566);
        C4990ab.m7416i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
            AppMethodBeat.m2505o(137566);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "syncNotify", new Object[0]);
            AppMethodBeat.m2505o(137566);
        }
        return;
    }

    public final void stop() {
        AppMethodBeat.m2504i(137567);
        C4990ab.m7416i("MicroMsg.Music.MMPlayer", "stop");
        this.ovl = true;
        if (this.oNR.bUH()) {
            m50705Eq();
        }
        AppMethodBeat.m2505o(137567);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137568);
        C4990ab.m7416i("MicroMsg.Music.MMPlayer", "pause");
        if (bUz()) {
            this.oNR.oNV = 2;
            AppMethodBeat.m2505o(137568);
            return;
        }
        AppMethodBeat.m2505o(137568);
    }

    public final void seek(long j) {
        AppMethodBeat.m2504i(137569);
        this.clX.seekTo(1000 * j, 2);
        AppMethodBeat.m2505o(137569);
    }

    public final synchronized void bUC() {
        AppMethodBeat.m2504i(137570);
        while (bUz() && this.oNR.bUH()) {
            try {
                C4990ab.m7416i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "waitPlay", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(137570);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(137571);
        boolean isPlaying = this.oNR.isPlaying();
        AppMethodBeat.m2505o(137571);
        return isPlaying;
    }

    public final boolean bUz() {
        return !this.ovl;
    }

    /* renamed from: jy */
    public final void mo46688jy(boolean z) {
        AppMethodBeat.m2504i(137572);
        this.oNR.oNV = 4;
        this.ovl = true;
        super.mo46688jy(z);
        AppMethodBeat.m2505o(137572);
    }

    /* renamed from: jz */
    public final void mo46689jz(boolean z) {
        AppMethodBeat.m2504i(137573);
        this.oNR.oNV = 4;
        this.ovl = true;
        super.mo46689jz(z);
        AppMethodBeat.m2505o(137573);
    }

    public final String bUB() {
        return this.clY;
    }

    /* renamed from: a */
    static /* synthetic */ void m50706a(C31375c c31375c) {
        AppMethodBeat.m2504i(137574);
        try {
            if (c31375c.clX != null) {
                c31375c.clX.release();
                c31375c.clX = null;
            }
            AppMethodBeat.m2505o(137574);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaExtractor", new Object[0]);
            AppMethodBeat.m2505o(137574);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m50707b(C31375c c31375c) {
        AppMethodBeat.m2504i(137575);
        try {
            if (c31375c.bek != null) {
                c31375c.bek.stop();
                c31375c.bek.release();
                c31375c.bek = null;
            }
            AppMethodBeat.m2505o(137575);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaCodec", new Object[0]);
            AppMethodBeat.m2505o(137575);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m50708c(C31375c c31375c) {
        AppMethodBeat.m2504i(137576);
        try {
            if (c31375c.aQf != null) {
                c31375c.aQf.flush();
                c31375c.aQf.release();
                c31375c.aQf = null;
            }
            AppMethodBeat.m2505o(137576);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseAudioTrack", new Object[0]);
            AppMethodBeat.m2505o(137576);
        }
    }
}
