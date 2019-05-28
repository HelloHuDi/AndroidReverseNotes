package com.tencent.mm.audio.mix.f.a;

import android.media.AudioTrack;
import com.tencent.mm.audio.mix.a.c;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.q.l;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {
    protected static volatile AtomicInteger cod = new AtomicInteger(0);
    protected static volatile AtomicInteger coe = new AtomicInteger(0);
    protected AudioTrack aQf;
    protected byte[] byteBuffer;
    protected int channels = 0;
    protected c cll;
    protected int cnZ = 0;
    protected int coa = 0;
    protected f cob;
    protected int coc = 0;
    protected int sampleRate = 0;

    public abstract boolean createAudioTrack();

    public a(int i, int i2, c cVar, f fVar) {
        this.sampleRate = i;
        this.channels = i2;
        this.cll = cVar;
        this.cob = fVar;
    }

    public void G(byte[] bArr) {
    }

    public void Eu() {
    }

    public void resume() {
    }

    public void pause() {
    }

    public final void seek(int i) {
        b.i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", Integer.valueOf(this.coc));
        this.coc = i;
    }

    public final void DL() {
        try {
            if (this.aQf == null) {
                return;
            }
            if (this.aQf.getState() == 1 || this.aQf.getState() == 2) {
                this.aQf.setStereoVolume(0.0f, 0.0f);
            }
        } catch (IllegalStateException e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e, l.NAME, new Object[0]);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e2, l.NAME, new Object[0]);
        }
    }

    public final void release() {
        Er();
        this.cob = null;
        this.cll = null;
        this.byteBuffer = null;
        this.cnZ = 0;
        this.coa = 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Er() {
        try {
            if (!(this.aQf == null || this.aQf.getState() == 0)) {
                this.aQf.stop();
                this.aQf.flush();
            }
            if (this.aQf != null) {
                this.aQf.release();
                this.aQf = null;
            }
        } catch (Exception e) {
            b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e, "releaseAudioTrack", new Object[0]);
        }
    }

    public void reset() {
        this.cnZ = 0;
        this.coa = 0;
        if (this.byteBuffer != null) {
            Arrays.fill(this.byteBuffer, 0, this.byteBuffer.length, (byte) 0);
        }
    }
}
