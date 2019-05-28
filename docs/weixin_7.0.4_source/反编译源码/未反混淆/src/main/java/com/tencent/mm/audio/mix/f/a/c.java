package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.h.b;

public final class c extends a {
    private static long cof = 0;
    private static long cog = 0;

    public c(int i, int i2, com.tencent.mm.audio.mix.a.c cVar, f fVar) {
        super(i, i2, cVar, fVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean createAudioTrack() {
        AppMethodBeat.i(137202);
        b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack");
        if (this.cnZ > 1) {
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack fail count reach MAX COUNT");
            AppMethodBeat.o(137202);
            return false;
        }
        int i = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i, 2);
        if (minBufferSize <= 0) {
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "createAudioTrack miniBufferSize %d is illegal", Integer.valueOf(minBufferSize));
            AppMethodBeat.o(137202);
            return false;
        }
        if (this.aQf == null) {
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "new AudioTrack");
            System.currentTimeMillis();
            this.aQf = new AudioTrack(3, this.sampleRate, i, 2, minBufferSize, 1);
            this.cnZ++;
            coe.incrementAndGet();
        }
        if (this.aQf == null || this.aQf.getState() != 1) {
            cod.incrementAndGet();
            b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "play_count:%d, fail_count:%d", Integer.valueOf(coe.get()), Integer.valueOf(cod.get()));
            b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "audio track not initialized");
            if (this.aQf != null) {
                b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "AudioTrack getState:%d", Integer.valueOf(this.aQf.getState()));
                try {
                    this.aQf.release();
                    this.aQf = null;
                } catch (Exception e) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", e, "AudioTrack release", new Object[0]);
                }
            }
            AppMethodBeat.o(137202);
            return false;
        }
        AppMethodBeat.o(137202);
        return true;
    }

    public final void G(byte[] bArr) {
        AppMethodBeat.i(137203);
        if (this.aQf == null) {
            b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack before");
            if (createAudioTrack()) {
                b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack success");
                try {
                    this.aQf.play();
                    this.aQf.setStereoVolume(1.0f, 1.0f);
                } catch (IllegalStateException e) {
                    b.printErrStackTrace("MicroMsg.Mix.AudioPcmStreamPlayComponent", e, "setStereoVolume", new Object[0]);
                }
                b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack after");
            } else {
                if (this.cob != null) {
                    this.cob.onError(707);
                }
                b.e("MicroMsg.Mix.AudioPcmStreamPlayComponent", "create AudioTrack fail");
                AppMethodBeat.o(137203);
                return;
            }
        }
        if (this.cob != null) {
            this.cob.DI();
        }
        this.aQf.setStereoVolume(1.0f, 1.0f);
        this.aQf.write(bArr, 0, bArr.length);
        AppMethodBeat.o(137203);
    }

    public final void Eu() {
        AppMethodBeat.i(137204);
        super.Eu();
        b.i("MicroMsg.Mix.AudioPcmStreamPlayComponent", "playFlush");
        AppMethodBeat.o(137204);
    }
}
