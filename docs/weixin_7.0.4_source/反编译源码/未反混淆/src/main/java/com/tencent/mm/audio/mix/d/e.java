package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.f.a.a;
import com.tencent.mm.audio.mix.f.d;
import com.tencent.mm.audio.mix.g.b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;

public final class e extends d {
    private Object cli = new Object();
    private a cmd;

    public e(d dVar, b bVar) {
        super(dVar, bVar);
        AppMethodBeat.i(137062);
        AppMethodBeat.o(137062);
    }

    public final void onRelease() {
        AppMethodBeat.i(137063);
        super.onRelease();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.release();
                    this.cmd = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137063);
            }
        }
    }

    public final void Dy() {
    }

    public final void pause() {
        AppMethodBeat.i(137064);
        super.pause();
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.pause();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137064);
            }
        }
    }

    public final void Dx() {
        AppMethodBeat.i(137065);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
        gy(5);
        this.clT.set(true);
        this.clV.set(false);
        DE();
        AppMethodBeat.o(137065);
    }

    public final void seek(int i) {
        AppMethodBeat.i(137066);
        super.seek(i);
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.seek(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137066);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void DJ() {
        AppMethodBeat.i(137067);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
        super.DJ();
        if (this.cmd != null) {
            this.cmd.reset();
        }
        AppMethodBeat.o(137067);
    }

    /* Access modifiers changed, original: protected|final */
    public final void c(com.tencent.mm.audio.mix.a.d dVar) {
        AppMethodBeat.i(137068);
        if (DC().ckA) {
            this.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
            this.channels = 2;
        } else {
            this.sampleRate = dVar.sampleRate;
            this.channels = dVar.channels;
        }
        byte[] bArr = dVar.ckv;
        if (!this.clQ.get()) {
            if (this.cmd == null) {
                c DC = DC();
                if (!DC.cky || DC.duration > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    this.cmd = new com.tencent.mm.audio.mix.f.a.c(this.sampleRate, this.channels, DC, this);
                } else {
                    this.cmd = new com.tencent.mm.audio.mix.f.a.b(this.sampleRate, this.channels, DC, this);
                }
            }
            this.cmd.G(bArr);
        }
        if (dVar.ckH) {
            com.tencent.mm.audio.mix.b.b.Di().b(dVar);
        }
        AppMethodBeat.o(137068);
    }

    /* Access modifiers changed, original: protected|final */
    public final void DK() {
        AppMethodBeat.i(137069);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
        super.DK();
        if (this.cmd != null) {
            this.cmd.Eu();
            if (this.cmd instanceof com.tencent.mm.audio.mix.f.a.b) {
                do {
                    boolean z = this.clS.get();
                    DD();
                    if (!this.clT.get()) {
                        if (z) {
                            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
                            this.cmd.resume();
                        }
                        if (this.clT.get()) {
                            break;
                        }
                    } else {
                        break;
                    }
                } while (this.clS.get());
            }
        }
        AppMethodBeat.o(137069);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(c cVar, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.i(137070);
        b(cVar, byteBuffer, i);
        AppMethodBeat.o(137070);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(c cVar) {
        AppMethodBeat.i(137071);
        if (this.clM != null) {
            this.clM.Ds();
        }
        c(cVar);
        cVar.complete();
        AppMethodBeat.o(137071);
    }

    public final void DL() {
        AppMethodBeat.i(137072);
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.DL();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137072);
            }
        }
    }
}
