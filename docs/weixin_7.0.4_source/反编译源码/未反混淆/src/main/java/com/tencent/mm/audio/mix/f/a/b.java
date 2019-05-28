package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class b extends a {
    private static long cof = 0;
    private static long cog = 0;
    private Thread aAA;

    public b(int i, int i2, c cVar, f fVar) {
        super(i, i2, cVar, fVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean createAudioTrack() {
        AppMethodBeat.i(137196);
        if (this.cnZ > 1) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            AppMethodBeat.o(137196);
            return false;
        }
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        if (this.cll != null && this.cll.size() > 0) {
            minBufferSize = this.cll.size() * 3536;
        }
        if (this.aQf == null) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 0);
            this.cnZ++;
            coe.incrementAndGet();
        }
        if (this.aQf == null || this.aQf.getState() != 2) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
            cod.incrementAndGet();
            if (this.aQf != null) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.aQf.getState()));
                try {
                    this.aQf.release();
                    this.aQf = null;
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.o(137196);
            return false;
        }
        AppMethodBeat.o(137196);
        return true;
    }

    public final void G(byte[] bArr) {
        AppMethodBeat.i(137197);
        if (this.aQf == null) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
            if (createAudioTrack()) {
                try {
                    this.aQf.setStereoVolume(1.0f, 1.0f);
                } catch (IllegalStateException e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "setStereoVolume", new Object[0]);
                }
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
            } else {
                if (this.cob != null) {
                    this.cob.onError(707);
                }
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
                AppMethodBeat.o(137197);
                return;
            }
        }
        if (this.byteBuffer == null) {
            int size;
            if (this.cll != null) {
                size = this.cll.size() * 3536;
            } else {
                size = 3536;
            }
            if (size == 0) {
                size = 3536;
            }
            if (bArr.length == 3536) {
                size++;
            }
            this.byteBuffer = new byte[size];
        }
        if (this.coa + bArr.length <= this.byteBuffer.length) {
            System.arraycopy(bArr, 0, this.byteBuffer, this.coa, bArr.length);
            this.coa += bArr.length;
        }
        AppMethodBeat.o(137197);
    }

    public final void Eu() {
        AppMethodBeat.i(137198);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", Integer.valueOf(coe.get()), Integer.valueOf(cod.get()));
        if (this.aQf != null) {
            if (this.cob != null) {
                this.cob.DI();
            }
            if (this.aQf.getState() == 2 && this.aQf.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", Integer.valueOf(this.byteBuffer.length));
                this.cob.onError(708);
                AppMethodBeat.o(137198);
                return;
            } else if (this.aQf.getState() == 1) {
                this.aQf.reloadStaticData();
                this.aQf.play();
                this.aAA = Thread.currentThread();
                try {
                    long j = this.cll.duration;
                    if (j <= 0) {
                        j = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                    }
                    Thread.sleep(j);
                    AppMethodBeat.o(137198);
                    return;
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
                }
            }
        }
        AppMethodBeat.o(137198);
    }

    public final void resume() {
        AppMethodBeat.i(137199);
        if (this.aQf != null && this.aQf.getState() == 1) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
            if (this.cob != null) {
                this.cob.DI();
            }
            try {
                this.aQf.setStereoVolume(1.0f, 1.0f);
            } catch (IllegalStateException e) {
                com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "setStereoVolume", new Object[0]);
            }
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", Integer.valueOf(this.coc));
            this.aQf.setPlaybackHeadPosition(this.coc);
            this.aQf.play();
            try {
                long j = this.cll.duration;
                if (j <= 0) {
                    j = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                }
                Thread.sleep(j);
                AppMethodBeat.o(137199);
                return;
            } catch (Exception e2) {
                com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
            }
        }
        AppMethodBeat.o(137199);
    }

    public final void pause() {
        AppMethodBeat.i(137200);
        if (this.aQf != null) {
            int state = this.aQf.getState();
            int playState = this.aQf.getPlayState();
            if (state == 1 && playState == 3) {
                try {
                    this.aQf.pause();
                    this.coc = this.aQf.getPlaybackHeadPosition();
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", Integer.valueOf(this.coc));
                    if (this.aAA != null) {
                        this.aAA.interrupt();
                    }
                    AppMethodBeat.o(137200);
                    return;
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "pause", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(137200);
    }

    public final void reset() {
        AppMethodBeat.i(137201);
        super.reset();
        Er();
        this.aAA = null;
        AppMethodBeat.o(137201);
    }
}
