package com.tencent.p177mm.audio.mix.p832f.p833a;

import android.media.AudioTrack;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p832f.C25845f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C27067l;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.audio.mix.f.a.a */
public abstract class C45170a {
    protected static volatile AtomicInteger cod = new AtomicInteger(0);
    protected static volatile AtomicInteger coe = new AtomicInteger(0);
    protected AudioTrack aQf;
    protected byte[] byteBuffer;
    protected int channels = 0;
    protected C37484c cll;
    protected int cnZ = 0;
    protected int coa = 0;
    protected C25845f cob;
    protected int coc = 0;
    protected int sampleRate = 0;

    public abstract boolean createAudioTrack();

    public C45170a(int i, int i2, C37484c c37484c, C25845f c25845f) {
        this.sampleRate = i;
        this.channels = i2;
        this.cll = c37484c;
        this.cob = c25845f;
    }

    /* renamed from: G */
    public void mo20532G(byte[] bArr) {
    }

    /* renamed from: Eu */
    public void mo20531Eu() {
    }

    public void resume() {
    }

    public void pause() {
    }

    public final void seek(int i) {
        C45174b.m83210i("MicroMsg.Mix.AudioPcmBasePlayComponent", "seek startPos:%d", Integer.valueOf(this.coc));
        this.coc = i;
    }

    /* renamed from: DL */
    public final void mo73139DL() {
        try {
            if (this.aQf == null) {
                return;
            }
            if (this.aQf.getState() == 1 || this.aQf.getState() == 2) {
                this.aQf.setStereoVolume(0.0f, 0.0f);
            }
        } catch (IllegalStateException e) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e, C27067l.NAME, new Object[0]);
        } catch (Exception e2) {
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e2, C27067l.NAME, new Object[0]);
        }
    }

    public final void release() {
        mo73140Er();
        this.cob = null;
        this.cll = null;
        this.byteBuffer = null;
        this.cnZ = 0;
        this.coa = 0;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Er */
    public final void mo73140Er() {
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
            C45174b.printErrStackTrace("MicroMsg.Mix.AudioPcmBasePlayComponent", e, "releaseAudioTrack", new Object[0]);
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
