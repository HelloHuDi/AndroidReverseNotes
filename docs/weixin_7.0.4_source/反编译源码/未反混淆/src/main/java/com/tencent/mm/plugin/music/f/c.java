package com.tencent.mm.plugin.music.f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.music.f.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c extends b {
    AudioTrack aQf;
    MediaCodec bek;
    int channels = 0;
    int clN = 0;
    String clO;
    MediaExtractor clX;
    String clY = null;
    long duration = 0;
    private Runnable oNy = new Runnable() {
        public final void run() {
            AppMethodBeat.i(137562);
            ab.i("MicroMsg.Music.MMPlayer", "starting...");
            Process.setThreadPriority(-19);
            if (bo.isNullOrNil(c.this.clO)) {
                ab.e("MicroMsg.Music.MMPlayer", "source path is null");
                c.this.jy(false);
                AppMethodBeat.o(137562);
                return;
            }
            c.this.clX = new MediaExtractor();
            try {
                c.this.clX.setDataSource(c.this.clO);
                MediaFormat mediaFormat = null;
                try {
                    int readSampleData;
                    MediaFormat trackFormat;
                    ab.e("MicroMsg.Music.MMPlayer", "tractCount is %d", Integer.valueOf(c.this.clX.getTrackCount()));
                    for (int i = 0; i < readSampleData; i++) {
                        trackFormat = c.this.clX.getTrackFormat(i);
                        c.this.clY = trackFormat.getString("mime");
                        if (!bo.isNullOrNil(c.this.clY) && c.this.clY.startsWith("audio/")) {
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    if (mediaFormat == null) {
                        ab.e("MicroMsg.Music.MMPlayer", "format is null");
                        c.this.clN = 703;
                        c.this.jy(true);
                        c.a(c.this);
                        AppMethodBeat.o(137562);
                        return;
                    }
                    ab.i("MicroMsg.Music.MMPlayer", "format:%s", mediaFormat);
                    c.this.sampleRate = mediaFormat.getInteger("sample-rate");
                    c.this.channels = mediaFormat.getInteger("channel-count");
                    c.this.duration = mediaFormat.getLong("durationUs");
                    try {
                        if (d.iW(21)) {
                            String findDecoderForFormat = new MediaCodecList(1).findDecoderForFormat(mediaFormat);
                            if (findDecoderForFormat != null) {
                                c.this.clY = findDecoderForFormat;
                            }
                        }
                        c.this.bek = MediaCodec.createDecoderByType(c.this.clY);
                        c.this.bek.configure(mediaFormat, null, null, 0);
                        c.this.bek.start();
                        ByteBuffer[] inputBuffers = c.this.bek.getInputBuffers();
                        ByteBuffer[] outputBuffers = c.this.bek.getOutputBuffers();
                        ab.i("MicroMsg.Music.MMPlayer", "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", mediaFormat, c.this.clY, Integer.valueOf(c.this.sampleRate), Integer.valueOf(c.this.channels), Long.valueOf(c.this.duration));
                        c.this.clX.selectTrack(0);
                        BufferInfo bufferInfo = new BufferInfo();
                        Object obj = null;
                        Object obj2 = null;
                        int i2 = 0;
                        c.this.oNR.oNV = 3;
                        c.this.onStart();
                        ByteBuffer[] byteBufferArr = outputBuffers;
                        while (obj2 == null && i2 < 50) {
                            try {
                                c.this.bUC();
                                if (!c.this.bUz()) {
                                    break;
                                }
                                int dequeueInputBuffer;
                                i2++;
                                if (obj == null) {
                                    dequeueInputBuffer = c.this.bek.dequeueInputBuffer(1000);
                                    if (dequeueInputBuffer >= 0) {
                                        Object obj3;
                                        readSampleData = c.this.clX.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                        if (readSampleData < 0) {
                                            ab.e("MicroMsg.Music.MMPlayer", "saw input EOS. Stopping playback");
                                            obj3 = 1;
                                            readSampleData = 0;
                                        } else {
                                            c.this.presentationTimeUs = c.this.clX.getSampleTime();
                                            c.this.zR(c.this.duration == 0 ? 0 : (int) ((100 * c.this.presentationTimeUs) / c.this.duration));
                                            obj3 = obj;
                                        }
                                        c.this.bek.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, c.this.presentationTimeUs, obj3 != null ? 4 : 0);
                                        if (obj3 == null) {
                                            c.this.clX.advance();
                                        }
                                        obj = obj3;
                                    } else {
                                        ab.e("MicroMsg.Music.MMPlayer", "inputBufIndex ".concat(String.valueOf(dequeueInputBuffer)));
                                    }
                                }
                                readSampleData = c.this.bek.dequeueOutputBuffer(bufferInfo, 1000);
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
                                        if (c.this.aQf == null) {
                                            if (c.this.createAudioTrack()) {
                                                c.this.aQf.play();
                                            } else {
                                                ab.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                c.this.clN = 707;
                                                c.this.jy(true);
                                                c.a(c.this);
                                                c.b(c.this);
                                                c.c(c.this);
                                                c.this.clO = null;
                                                c.this.clY = null;
                                                c.this.sampleRate = 0;
                                                c.this.channels = 0;
                                                c.this.presentationTimeUs = 0;
                                                c.this.duration = 0;
                                                AppMethodBeat.o(137562);
                                                return;
                                            }
                                        }
                                        c.this.aQf.write(bArr, 0, bArr.length);
                                    }
                                    c.this.bek.releaseOutputBuffer(readSampleData, false);
                                    if ((bufferInfo.flags & 4) != 0) {
                                        ab.e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                        obj4 = 1;
                                    } else {
                                        obj4 = obj2;
                                    }
                                    i2 = dequeueInputBuffer;
                                    obj2 = obj4;
                                } else if (readSampleData == -3) {
                                    outputBuffers = c.this.bek.getOutputBuffers();
                                    ab.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                    byteBufferArr = outputBuffers;
                                } else if (readSampleData == -2) {
                                    trackFormat = c.this.bek.getOutputFormat();
                                    ab.i("MicroMsg.Music.MMPlayer", "output format has changed to ".concat(String.valueOf(trackFormat)));
                                    c.this.sampleRate = trackFormat.getInteger("sample-rate");
                                    c.this.channels = trackFormat.getInteger("channel-count");
                                    c.c(c.this);
                                } else {
                                    ab.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned ".concat(String.valueOf(readSampleData)));
                                }
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "error", new Object[0]);
                                c.this.clN = 706;
                                c.this.jy(true);
                                c.a(c.this);
                                c.b(c.this);
                                c.c(c.this);
                                c.this.clO = null;
                                c.this.clY = null;
                                c.this.sampleRate = 0;
                                c.this.channels = 0;
                                c.this.presentationTimeUs = 0;
                                c.this.duration = 0;
                            } catch (Throwable th) {
                                c.a(c.this);
                                c.b(c.this);
                                c.c(c.this);
                                c.this.clO = null;
                                c.this.clY = null;
                                c.this.sampleRate = 0;
                                c.this.channels = 0;
                                c.this.presentationTimeUs = 0;
                                c.this.duration = 0;
                                AppMethodBeat.o(137562);
                            }
                        }
                        boolean z = (c.this.duration / 1000) - (c.this.presentationTimeUs / 1000) < FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                        if (i2 >= 50) {
                            ab.e("MicroMsg.Music.MMPlayer", "onError, noOutputCounter:%d", Integer.valueOf(i2));
                            c.this.clN = 706;
                            c.this.jy(true);
                        } else {
                            ab.i("MicroMsg.Music.MMPlayer", "onStop, isComplete:%b", Boolean.valueOf(z));
                            c.this.jz(z);
                        }
                        c.a(c.this);
                        c.b(c.this);
                        c.c(c.this);
                        c.this.clO = null;
                        c.this.clY = null;
                        c.this.sampleRate = 0;
                        c.this.channels = 0;
                        c.this.presentationTimeUs = 0;
                        c.this.duration = 0;
                        ab.i("MicroMsg.Music.MMPlayer", "stopping...");
                        AppMethodBeat.o(137562);
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "createDecoderByType", new Object[0]);
                        c.this.clN = 704;
                        c.this.jy(true);
                        c.a(c.this);
                        c.b(c.this);
                        AppMethodBeat.o(137562);
                    }
                } catch (Exception e22) {
                    ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e22, "get media format from media extractor", new Object[0]);
                    c.this.clN = 705;
                }
            } catch (Exception e222) {
                ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e222, "set extractor data source", new Object[0]);
                c.this.clN = 702;
                c.this.jy(true);
                AppMethodBeat.o(137562);
            }
        }
    };
    private boolean ovl = true;
    long presentationTimeUs = 0;
    int sampleRate = 0;

    public c() {
        AppMethodBeat.i(137563);
        AppMethodBeat.o(137563);
    }

    public final void Tr(String str) {
        this.clO = str;
    }

    /* Access modifiers changed, original: final */
    public final boolean createAudioTrack() {
        AppMethodBeat.i(137564);
        ab.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        com.tencent.mm.plugin.music.e.b bVar = (com.tencent.mm.plugin.music.e.b) com.tencent.mm.plugin.music.f.c.b.ar(com.tencent.mm.plugin.music.e.b.class);
        if (bVar != null) {
            this.aQf = bVar.ac(this.sampleRate, i, minBufferSize);
        } else {
            ab.e("MicroMsg.Music.MMPlayer", "mediaResService null");
        }
        if (this.aQf == null) {
            ab.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
            this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 1);
        }
        if (this.aQf == null || this.aQf.getState() != 1) {
            ab.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
            if (this.aQf != null) {
                try {
                    this.aQf.release();
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(137564);
            return false;
        }
        AppMethodBeat.o(137564);
        return true;
    }

    public final int bUA() {
        return (int) (this.presentationTimeUs / 1000);
    }

    public final int getDuration() {
        return (int) (this.duration / 1000);
    }

    public final void play() {
        AppMethodBeat.i(137565);
        ab.i("MicroMsg.Music.MMPlayer", "play");
        if (bUz()) {
            if (bUz() && this.oNR.bUH()) {
                this.oNR.oNV = 3;
                Eq();
            }
            AppMethodBeat.o(137565);
            return;
        }
        this.ovl = false;
        com.tencent.mm.sdk.g.d.post(this.oNy, "music_player");
        AppMethodBeat.o(137565);
    }

    private synchronized void Eq() {
        AppMethodBeat.i(137566);
        ab.i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
            AppMethodBeat.o(137566);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "syncNotify", new Object[0]);
            AppMethodBeat.o(137566);
        }
        return;
    }

    public final void stop() {
        AppMethodBeat.i(137567);
        ab.i("MicroMsg.Music.MMPlayer", "stop");
        this.ovl = true;
        if (this.oNR.bUH()) {
            Eq();
        }
        AppMethodBeat.o(137567);
    }

    public final void pause() {
        AppMethodBeat.i(137568);
        ab.i("MicroMsg.Music.MMPlayer", "pause");
        if (bUz()) {
            this.oNR.oNV = 2;
            AppMethodBeat.o(137568);
            return;
        }
        AppMethodBeat.o(137568);
    }

    public final void seek(long j) {
        AppMethodBeat.i(137569);
        this.clX.seekTo(1000 * j, 2);
        AppMethodBeat.o(137569);
    }

    public final synchronized void bUC() {
        AppMethodBeat.i(137570);
        while (bUz() && this.oNR.bUH()) {
            try {
                ab.i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "waitPlay", new Object[0]);
            }
        }
        AppMethodBeat.o(137570);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(137571);
        boolean isPlaying = this.oNR.isPlaying();
        AppMethodBeat.o(137571);
        return isPlaying;
    }

    public final boolean bUz() {
        return !this.ovl;
    }

    public final void jy(boolean z) {
        AppMethodBeat.i(137572);
        this.oNR.oNV = 4;
        this.ovl = true;
        super.jy(z);
        AppMethodBeat.o(137572);
    }

    public final void jz(boolean z) {
        AppMethodBeat.i(137573);
        this.oNR.oNV = 4;
        this.ovl = true;
        super.jz(z);
        AppMethodBeat.o(137573);
    }

    public final String bUB() {
        return this.clY;
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(137574);
        try {
            if (cVar.clX != null) {
                cVar.clX.release();
                cVar.clX = null;
            }
            AppMethodBeat.o(137574);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaExtractor", new Object[0]);
            AppMethodBeat.o(137574);
        }
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(137575);
        try {
            if (cVar.bek != null) {
                cVar.bek.stop();
                cVar.bek.release();
                cVar.bek = null;
            }
            AppMethodBeat.o(137575);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaCodec", new Object[0]);
            AppMethodBeat.o(137575);
        }
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(137576);
        try {
            if (cVar.aQf != null) {
                cVar.aQf.flush();
                cVar.aQf.release();
                cVar.aQf = null;
            }
            AppMethodBeat.o(137576);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseAudioTrack", new Object[0]);
            AppMethodBeat.o(137576);
        }
    }
}
