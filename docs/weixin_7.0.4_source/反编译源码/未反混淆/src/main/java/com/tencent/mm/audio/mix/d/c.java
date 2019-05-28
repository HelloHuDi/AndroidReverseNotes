package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.audio.mix.f.d;
import com.tencent.mm.audio.mix.f.f;
import com.tencent.mm.audio.mix.g.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class c implements k, f {
    protected int channels = 0;
    protected String ckD;
    protected d clB;
    protected b clK;
    protected com.tencent.mm.ag.b clL;
    protected g clM;
    protected int clN = 0;
    protected String clO;
    public String clP;
    protected AtomicBoolean clQ = new AtomicBoolean(false);
    protected AtomicInteger clR = new AtomicInteger(0);
    protected AtomicBoolean clS = new AtomicBoolean(false);
    protected AtomicBoolean clT = new AtomicBoolean(false);
    protected AtomicBoolean clU = new AtomicBoolean(false);
    protected AtomicBoolean clV = new AtomicBoolean(false);
    protected AtomicBoolean clW = new AtomicBoolean(false);
    protected Object lock = new Object();
    protected int sampleRate = 0;
    protected int startTime;

    public abstract void DG();

    protected c(d dVar, b bVar) {
        this.clB = dVar;
        this.clK = bVar;
        this.clL = this.clK.Ev();
        this.ckD = this.clL.ckD;
        this.clO = this.clL.filePath;
        this.startTime = this.clL.startTime;
        this.clP = this.clL.clP;
    }

    public final void init() {
        this.startTime = this.clK.Ev().fqJ;
        this.clS.set(false);
        this.clT.set(false);
        gy(1);
    }

    public final void Dw() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload");
        this.clQ.set(true);
        gy(10);
    }

    public final void resume() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "resume");
        gy(4);
        synchronized (this.lock) {
            if (this.clS.get()) {
                this.clS.set(false);
                try {
                    this.lock.notify();
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "resume", new Object[0]);
                }
            }
        }
    }

    public void pause() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pause");
        gy(5);
        this.clS.set(true);
        this.clV.set(false);
    }

    public void Dx() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
        pause();
    }

    public final void stop() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stop");
        DL();
        gy(6);
        this.clT.set(true);
        this.clS.set(false);
        DE();
        this.clV.set(false);
        this.clW.set(false);
    }

    public void seek(int i) {
        int i2 = this.startTime;
        this.startTime = i;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public final void release() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "release");
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", Long.valueOf(DC().duration));
        Dy();
        onRelease();
        if (this.clK != null) {
            this.clK.Ev().startTime = 0;
        }
        this.clQ.set(false);
        this.clT.set(true);
        this.clS.set(false);
        this.clU.set(false);
        this.clB = null;
    }

    public void Dy() {
        com.tencent.mm.audio.mix.e.c cVar = this.clB.cnB;
        String DN = DN();
        if (cVar.cmz.containsKey(DN)) {
            WeakReference weakReference = (WeakReference) cVar.cmz.remove(DN);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.clear();
            }
        }
    }

    public final void Dz() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", Boolean.TRUE);
        this.clT.set(true);
        gy(9);
        com.tencent.mm.audio.mix.a.c DC = DC();
        if (DC != null && !DC.cky) {
            DC.reset();
        }
    }

    public final boolean DA() {
        return this.clS.get();
    }

    public final boolean DB() {
        return this.clT.get();
    }

    private boolean isPlaying() {
        return this.clR.get() == 4;
    }

    private boolean isError() {
        return this.clR.get() == 9;
    }

    public final com.tencent.mm.audio.mix.a.c DC() {
        return com.tencent.mm.audio.mix.b.d.Dm().dv(this.clO);
    }

    /* Access modifiers changed, original: protected|final */
    public final void DD() {
        synchronized (this.lock) {
            while (!this.clT.get() && this.clS.get()) {
                try {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
                    this.lock.wait();
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "waitDecode", new Object[0]);
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void DE() {
        synchronized (this.lock) {
            try {
                this.lock.notify();
            } catch (Exception e) {
                com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "notifyDecode", new Object[0]);
            }
        }
    }

    public final void DF() {
        if (this.clB.cnE != null) {
            this.clB.cnE.gD(DM().fromScene);
        }
        this.clO = DM().filePath;
        if (TextUtils.isEmpty(this.clO)) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
            this.clN = 712;
            onError(this.clN);
            return;
        }
        com.tencent.mm.ag.b DM = DM();
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", this.clO, Boolean.valueOf(DM.fqL));
        if (this.clQ.get()) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
            if (DM.fqX) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
                if (com.tencent.mm.audio.mix.b.d.Dm().dx(this.clO)) {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
                } else {
                    DG();
                }
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload end");
                return;
            }
            if (!isPlaying()) {
                gy(3);
            }
            if (com.tencent.mm.audio.mix.b.d.Dm().dx(this.clO)) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
            } else {
                DG();
            }
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
            this.clQ.set(false);
            com.tencent.mm.audio.mix.a.c DC = DC();
            if (this.clT.get()) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
                if (DC.cky) {
                    gy(2);
                    return;
                }
                return;
            } else if (isError()) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
                return;
            } else if (isPlaying() || DM.fqK) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "to play");
                gy(2);
            } else {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not to play");
                gy(2);
                return;
            }
        }
        gy(4);
        int i;
        do {
            if (com.tencent.mm.audio.mix.b.d.Dm().dx(this.clO)) {
                DH();
            } else {
                DG();
            }
            if (!DM.fqL || this.clT.get()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", DN());
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
                }
                this.startTime = 0;
                continue;
            }
        } while (i != 0);
        if (this.clT.get() || isError()) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
            if (this.clK.equals(DM().filePath)) {
                this.clB.cnB.dK(DN());
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            } else {
                com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
            }
        } else if (this.clB.cnB.dM(DN())) {
            gy(7);
            this.clB.cnB.dK(DN());
        } else {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.clB.cnB.l(DN(), true);
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "task end");
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.mm.audio.mix.a.c cVar) {
        if (this.clM == null) {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "process is null");
            return;
        }
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
        DJ();
        while (!this.clT.get()) {
            DD();
            com.tencent.mm.audio.mix.a.d Dt = this.clM.Dt();
            if (cVar.size() <= 0 || Dt != null) {
                if (cVar.size() != 0 || Dt != null) {
                    if (Dt != null) {
                        if (!cVar.cky) {
                            cVar.a(Dt);
                        }
                        a(Dt);
                        if (Dt == null) {
                            break;
                        }
                    }
                    break;
                }
                cVar.reset();
                break;
            }
            cVar.complete();
            break;
        }
        DK();
    }

    /* Access modifiers changed, original: protected|final */
    public final void DH() {
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
        com.tencent.mm.audio.mix.a.c DC = DC();
        if (DC != null) {
            DJ();
            int size = DC.size();
            for (int i = 0; i < size && !this.clT.get(); i++) {
                DD();
                com.tencent.mm.audio.mix.a.d gv = DC.gv(i);
                if (gv != null) {
                    a(gv);
                }
            }
            DK();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.mm.audio.mix.a.d dVar) {
        if (!this.clQ.get() && dVar != null) {
            if ((dVar.ckG <= 0 || this.startTime <= 0 || dVar.ckG >= ((long) this.startTime)) && this.clB != null && this.clB.cnB != null && dVar != null) {
                dVar.ckD = DN();
                c(dVar);
            }
        }
    }

    public final void gx(int i) {
        if (i < 20 && this.clU.get() && !this.clS.get() && !this.clT.get()) {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", Integer.valueOf(i));
            DE();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void gy(int i) {
        c(i, 0, "");
    }

    private void c(int i, int i2, String str) {
        int i3 = 2;
        if (this.clB != null) {
            String DN;
            this.clR.set(i);
            if (!(i == 0 || i == 1)) {
                if (i == 3) {
                    i3 = 9;
                } else if (i == 2) {
                    i3 = 7;
                } else if (i == 4) {
                    i3 = 0;
                } else if (i != 5) {
                    if (i == 6) {
                        i3 = 3;
                    } else if (i == 7) {
                        i3 = 5;
                    } else if (i == 9) {
                        i3 = 4;
                    } else if (i == 11) {
                        i3 = 6;
                    } else if (i == 12) {
                        i3 = 10;
                    } else if (i == 13) {
                        i3 = 11;
                    } else if (i == 14) {
                        i3 = 12;
                    }
                }
                DN = DN();
                if (!TextUtils.isEmpty(DN) && i3 != -1) {
                    if (this.clB != null && i3 == 4) {
                        this.clB.a(i3, DN, i2, str);
                        return;
                    } else if (this.clB != null) {
                        this.clB.e(i3, DN, this.clP);
                        return;
                    } else {
                        return;
                    }
                }
            }
            i3 = -1;
            DN = DN();
            if (!TextUtils.isEmpty(DN)) {
            }
        }
    }

    public final void DI() {
        if (!this.clV.get() && !this.clT.get()) {
            this.clV.set(true);
            gy(13);
        }
    }

    public final void onError(int i) {
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", Integer.valueOf(i));
        this.clN = i;
        this.clT.set(true);
        c(9, i, "");
    }

    /* Access modifiers changed, original: protected */
    public void DJ() {
    }

    /* Access modifiers changed, original: protected */
    public void c(com.tencent.mm.audio.mix.a.d dVar) {
        if (this.clK.Ev().ckA) {
            if (!this.clW.get()) {
                this.clW.set(true);
                gy(14);
            }
            if (this.clB.cnB.a(DN(), dVar, this) < 50) {
                this.clU.set(false);
                return;
            }
            com.tencent.mm.audio.mix.a.c DC = DC();
            if (DC == null || !DC.cky) {
                this.clU.set(false);
                return;
            }
            this.clU.set(true);
            synchronized (this.lock) {
                try {
                    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", Integer.valueOf(r0));
                    this.lock.wait();
                } catch (Exception e) {
                    com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "lockWriteBuffer", new Object[0]);
                }
            }
            return;
        }
        return;
    }

    /* Access modifiers changed, original: protected */
    public void DK() {
    }

    public void DL() {
    }

    public final com.tencent.mm.ag.b DM() {
        if (this.clK != null) {
            return this.clK.Ev();
        }
        return this.clL;
    }

    private String DN() {
        com.tencent.mm.ag.b DM = DM();
        if (DM != null) {
            return DM.ckD;
        }
        com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecoderBase", "param is null");
        return this.ckD;
    }
}
