package com.tencent.p177mm.audio.mix.p832f.p833a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p832f.C25845f;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.audio.mix.f.a.b */
public final class C9054b extends C45170a {
    private static long cof = 0;
    private static long cog = 0;
    private Thread aAA;

    public C9054b(int i, int i2, C37484c c37484c, C25845f c25845f) {
        super(i, i2, c37484c, c25845f);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean createAudioTrack() {
        AppMethodBeat.m2504i(137196);
        if (this.cnZ > 1) {
            C45174b.m83207e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            AppMethodBeat.m2505o(137196);
            return false;
        }
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        if (this.cll != null && this.cll.size() > 0) {
            minBufferSize = this.cll.size() * 3536;
        }
        if (this.aQf == null) {
            C45174b.m83209i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 0);
            this.cnZ++;
            coe.incrementAndGet();
        }
        if (this.aQf == null || this.aQf.getState() != 2) {
            C45174b.m83207e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "audio track not initialized");
            cod.incrementAndGet();
            if (this.aQf != null) {
                C45174b.m83208e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.aQf.getState()));
                try {
                    this.aQf.release();
                    this.aQf = null;
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(137196);
            return false;
        }
        AppMethodBeat.m2505o(137196);
        return true;
    }

    /* renamed from: G */
    public final void mo20532G(byte[] bArr) {
        AppMethodBeat.m2504i(137197);
        if (this.aQf == null) {
            C45174b.m83209i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack before");
            if (createAudioTrack()) {
                try {
                    this.aQf.setStereoVolume(1.0f, 1.0f);
                } catch (IllegalStateException e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "setStereoVolume", new Object[0]);
                }
                C45174b.m83209i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack after and success!");
            } else {
                if (this.cob != null) {
                    this.cob.onError(707);
                }
                C45174b.m83207e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "create AudioTrack fail");
                AppMethodBeat.m2505o(137197);
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
        AppMethodBeat.m2505o(137197);
    }

    /* renamed from: Eu */
    public final void mo20531Eu() {
        AppMethodBeat.m2504i(137198);
        C45174b.m83210i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "playFlush play_count:%d, fail_count:%d", Integer.valueOf(coe.get()), Integer.valueOf(cod.get()));
        if (this.aQf != null) {
            if (this.cob != null) {
                this.cob.mo20509DI();
            }
            if (this.aQf.getState() == 2 && this.aQf.write(this.byteBuffer, 0, this.byteBuffer.length) <= 0) {
                C45174b.m83208e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "AudioTrack write fail, should write length:%d", Integer.valueOf(this.byteBuffer.length));
                this.cob.onError(708);
                AppMethodBeat.m2505o(137198);
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
                    AppMethodBeat.m2505o(137198);
                    return;
                } catch (Exception e) {
                    C45174b.m83207e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
                }
            }
        }
        AppMethodBeat.m2505o(137198);
    }

    public final void resume() {
        AppMethodBeat.m2504i(137199);
        if (this.aQf != null && this.aQf.getState() == 1) {
            C45174b.m83209i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "resume");
            if (this.cob != null) {
                this.cob.mo20509DI();
            }
            try {
                this.aQf.setStereoVolume(1.0f, 1.0f);
            } catch (IllegalStateException e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "setStereoVolume", new Object[0]);
            }
            C45174b.m83210i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play startPos:%d", Integer.valueOf(this.coc));
            this.aQf.setPlaybackHeadPosition(this.coc);
            this.aQf.play();
            try {
                long j = this.cll.duration;
                if (j <= 0) {
                    j = FaceGestureDetGLThread.BRIGHTNESS_DURATION;
                }
                Thread.sleep(j);
                AppMethodBeat.m2505o(137199);
                return;
            } catch (Exception e2) {
                C45174b.m83207e("MicroMsg.Mix.AudioPcmStaticPlayComponent", "play Thread.sleep");
            }
        }
        AppMethodBeat.m2505o(137199);
    }

    public final void pause() {
        AppMethodBeat.m2504i(137200);
        if (this.aQf != null) {
            int state = this.aQf.getState();
            int playState = this.aQf.getPlayState();
            if (state == 1 && playState == 3) {
                try {
                    this.aQf.pause();
                    this.coc = this.aQf.getPlaybackHeadPosition();
                    C45174b.m83210i("MicroMsg.Mix.AudioPcmStaticPlayComponent", "pause startPos :%d", Integer.valueOf(this.coc));
                    if (this.aAA != null) {
                        this.aAA.interrupt();
                    }
                    AppMethodBeat.m2505o(137200);
                    return;
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmStaticPlayComponent", e, "pause", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(137200);
    }

    public final void reset() {
        AppMethodBeat.m2504i(137201);
        super.reset();
        mo73140Er();
        this.aAA = null;
        AppMethodBeat.m2505o(137201);
    }
}
