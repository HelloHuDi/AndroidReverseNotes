package com.tencent.p177mm.audio.mix.p832f.p833a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p832f.C25845f;

/* renamed from: com.tencent.mm.audio.mix.f.a.c */
public final class C25844c extends C45170a {
    private static long cof = 0;
    private static long cog = 0;

    public C25844c(int i, int i2, C37484c c37484c, C25845f c25845f) {
        super(i, i2, c37484c, c25845f);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean createAudioTrack() {
        AppMethodBeat.m2504i(137202);
        C45174b.m83209i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
        if (this.cnZ > 1) {
            C45174b.m83207e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            AppMethodBeat.m2505o(137202);
            return false;
        }
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        if (minBufferSize <= 0) {
            C45174b.m83208e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", Integer.valueOf(minBufferSize));
            AppMethodBeat.m2505o(137202);
            return false;
        }
        if (this.aQf == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 1);
            this.cnZ++;
            coe.incrementAndGet();
        }
        if (this.aQf == null || this.aQf.getState() != 1) {
            cod.incrementAndGet();
            C45174b.m83210i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", Integer.valueOf(coe.get()), Integer.valueOf(cod.get()));
            C45174b.m83207e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
            if (this.aQf != null) {
                C45174b.m83208e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.aQf.getState()));
                try {
                    this.aQf.release();
                    this.aQf = null;
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", e, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(137202);
            return false;
        }
        AppMethodBeat.m2505o(137202);
        return true;
    }

    /* renamed from: G */
    public final void mo20532G(byte[] bArr) {
        AppMethodBeat.m2504i(137203);
        if (this.aQf == null) {
            C45174b.m83209i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
            if (createAudioTrack()) {
                C45174b.m83209i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
                try {
                    this.aQf.play();
                    this.aQf.setStereoVolume(1.0f, 1.0f);
                } catch (IllegalStateException e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", e, "setStereoVolume", new Object[0]);
                }
                C45174b.m83209i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
            } else {
                if (this.cob != null) {
                    this.cob.onError(707);
                }
                C45174b.m83207e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
                AppMethodBeat.m2505o(137203);
                return;
            }
        }
        if (this.cob != null) {
            this.cob.mo20509DI();
        }
        this.aQf.setStereoVolume(1.0f, 1.0f);
        this.aQf.write(bArr, 0, bArr.length);
        AppMethodBeat.m2505o(137203);
    }

    /* renamed from: Eu */
    public final void mo20531Eu() {
        AppMethodBeat.m2504i(137204);
        super.mo20531Eu();
        C45174b.m83209i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
        AppMethodBeat.m2505o(137204);
    }
}
