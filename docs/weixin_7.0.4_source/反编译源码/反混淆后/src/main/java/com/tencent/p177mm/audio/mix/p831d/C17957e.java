package com.tencent.p177mm.audio.mix.p831d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C41772b;
import com.tencent.p177mm.audio.mix.p1458g.C32318b;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.p177mm.audio.mix.p832f.C45172d;
import com.tencent.p177mm.audio.mix.p832f.p833a.C25844c;
import com.tencent.p177mm.audio.mix.p832f.p833a.C45170a;
import com.tencent.p177mm.audio.mix.p832f.p833a.C9054b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ugc.TXRecordCommon;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.audio.mix.d.e */
public final class C17957e extends C32315d {
    private Object cli = new Object();
    private C45170a cmd;

    public C17957e(C45172d c45172d, C32318b c32318b) {
        super(c45172d, c32318b);
        AppMethodBeat.m2504i(137062);
        AppMethodBeat.m2505o(137062);
    }

    public final void onRelease() {
        AppMethodBeat.m2504i(137063);
        super.onRelease();
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "releasePlayComponent");
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.release();
                    this.cmd = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137063);
            }
        }
    }

    /* renamed from: Dy */
    public final void mo20516Dy() {
    }

    public final void pause() {
        AppMethodBeat.m2504i(137064);
        super.pause();
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.pause();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137064);
            }
        }
    }

    /* renamed from: Dx */
    public final void mo20515Dx() {
        AppMethodBeat.m2504i(137065);
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "pauseOnBackground");
        mo20522gy(5);
        this.clT.set(true);
        this.clV.set(false);
        mo20505DE();
        AppMethodBeat.m2505o(137065);
    }

    public final void seek(int i) {
        AppMethodBeat.m2504i(137066);
        super.seek(i);
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.seek(i);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137066);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: DJ */
    public final void mo20510DJ() {
        AppMethodBeat.m2504i(137067);
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playBefore");
        super.mo20510DJ();
        if (this.cmd != null) {
            this.cmd.reset();
        }
        AppMethodBeat.m2505o(137067);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final void mo20520c(C45164d c45164d) {
        AppMethodBeat.m2504i(137068);
        if (mo20503DC().ckA) {
            this.sampleRate = TXRecordCommon.AUDIO_SAMPLERATE_44100;
            this.channels = 2;
        } else {
            this.sampleRate = c45164d.sampleRate;
            this.channels = c45164d.channels;
        }
        byte[] bArr = c45164d.ckv;
        if (!this.clQ.get()) {
            if (this.cmd == null) {
                C37484c DC = mo20503DC();
                if (!DC.cky || DC.duration > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    this.cmd = new C25844c(this.sampleRate, this.channels, DC, this);
                } else {
                    this.cmd = new C9054b(this.sampleRate, this.channels, DC, this);
                }
            }
            this.cmd.mo20532G(bArr);
        }
        if (c45164d.ckH) {
            C41772b.m73733Di().mo67527b(c45164d);
        }
        AppMethodBeat.m2505o(137068);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: DK */
    public final void mo20511DK() {
        AppMethodBeat.m2504i(137069);
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "playAfter");
        super.mo20511DK();
        if (this.cmd != null) {
            this.cmd.mo20531Eu();
            if (this.cmd instanceof C9054b) {
                do {
                    boolean z = this.clS.get();
                    mo20504DD();
                    if (!this.clT.get()) {
                        if (z) {
                            C45174b.m83209i("MicroMsg.Mix.AudioDecoderMediaCodecPlay", "need resume if not stop");
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
        AppMethodBeat.m2505o(137069);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo33492a(C37484c c37484c, ByteBuffer byteBuffer, int i) {
        AppMethodBeat.m2504i(137070);
        mo53020b(c37484c, byteBuffer, i);
        AppMethodBeat.m2505o(137070);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo33493b(C37484c c37484c) {
        AppMethodBeat.m2504i(137071);
        if (this.clM != null) {
            this.clM.mo33487Ds();
        }
        mo53021c(c37484c);
        c37484c.complete();
        AppMethodBeat.m2505o(137071);
    }

    /* renamed from: DL */
    public final void mo20512DL() {
        AppMethodBeat.m2504i(137072);
        synchronized (this.cli) {
            try {
                if (this.cmd != null) {
                    this.cmd.mo73139DL();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137072);
            }
        }
    }
}
