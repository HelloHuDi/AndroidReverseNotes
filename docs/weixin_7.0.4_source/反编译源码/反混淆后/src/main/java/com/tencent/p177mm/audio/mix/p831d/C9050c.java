package com.tencent.p177mm.audio.mix.p831d;

import android.text.TextUtils;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p1183c.C17956g;
import com.tencent.p177mm.audio.mix.p1458g.C32318b;
import com.tencent.p177mm.audio.mix.p196e.C17961c;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import com.tencent.p177mm.audio.mix.p832f.C25845f;
import com.tencent.p177mm.audio.mix.p832f.C45172d;
import com.tencent.p177mm.p1176ag.C17875b;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.audio.mix.d.c */
public abstract class C9050c implements C17959k, C25845f {
    protected int channels = 0;
    protected String ckD;
    protected C45172d clB;
    protected C32318b clK;
    protected C17875b clL;
    protected C17956g clM;
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

    /* renamed from: DG */
    public abstract void mo20507DG();

    protected C9050c(C45172d c45172d, C32318b c32318b) {
        this.clB = c45172d;
        this.clK = c32318b;
        this.clL = this.clK.mo53051Ev();
        this.ckD = this.clL.ckD;
        this.clO = this.clL.filePath;
        this.startTime = this.clL.startTime;
        this.clP = this.clL.clP;
    }

    public final void init() {
        this.startTime = this.clK.mo53051Ev().fqJ;
        this.clS.set(false);
        this.clT.set(false);
        mo20522gy(1);
    }

    /* renamed from: Dw */
    public final void mo20514Dw() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "preload");
        this.clQ.set(true);
        mo20522gy(10);
    }

    public final void resume() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "resume");
        mo20522gy(4);
        synchronized (this.lock) {
            if (this.clS.get()) {
                this.clS.set(false);
                try {
                    this.lock.notify();
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "resume", new Object[0]);
                }
            }
        }
    }

    public void pause() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "pause");
        mo20522gy(5);
        this.clS.set(true);
        this.clV.set(false);
    }

    /* renamed from: Dx */
    public void mo20515Dx() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "pauseOnBackground");
        pause();
    }

    public final void stop() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "stop");
        mo20512DL();
        mo20522gy(6);
        this.clT.set(true);
        this.clS.set(false);
        mo20505DE();
        this.clV.set(false);
        this.clW.set(false);
    }

    public void seek(int i) {
        int i2 = this.startTime;
        this.startTime = i;
        C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "seek preStartTime:%d, seek position:%d", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public final void release() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "release");
        C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "duration:%d", Long.valueOf(mo20503DC().duration));
        mo20516Dy();
        onRelease();
        if (this.clK != null) {
            this.clK.mo53051Ev().startTime = 0;
        }
        this.clQ.set(false);
        this.clT.set(true);
        this.clS.set(false);
        this.clU.set(false);
        this.clB = null;
    }

    /* renamed from: Dy */
    public void mo20516Dy() {
        C17961c c17961c = this.clB.cnB;
        String DN = m16396DN();
        if (c17961c.cmz.containsKey(DN)) {
            WeakReference weakReference = (WeakReference) c17961c.cmz.remove(DN);
            if (weakReference != null && weakReference.get() != null) {
                weakReference.clear();
            }
        }
    }

    /* renamed from: Dz */
    public final void mo20517Dz() {
        C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "onError needTry:%b", Boolean.TRUE);
        this.clT.set(true);
        mo20522gy(9);
        C37484c DC = mo20503DC();
        if (DC != null && !DC.cky) {
            DC.reset();
        }
    }

    /* renamed from: DA */
    public final boolean mo20501DA() {
        return this.clS.get();
    }

    /* renamed from: DB */
    public final boolean mo20502DB() {
        return this.clT.get();
    }

    private boolean isPlaying() {
        return this.clR.get() == 4;
    }

    private boolean isError() {
        return this.clR.get() == 9;
    }

    /* renamed from: DC */
    public final C37484c mo20503DC() {
        return C45166d.m83168Dm().mo73133dv(this.clO);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: DD */
    public final void mo20504DD() {
        synchronized (this.lock) {
            while (!this.clT.get() && this.clS.get()) {
                try {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "waitDecode");
                    this.lock.wait();
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "waitDecode", new Object[0]);
                }
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: DE */
    public final void mo20505DE() {
        synchronized (this.lock) {
            try {
                this.lock.notify();
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "notifyDecode", new Object[0]);
            }
        }
    }

    /* renamed from: DF */
    public final void mo20506DF() {
        if (this.clB.cnE != null) {
            this.clB.cnE.mo8009gD(mo20513DM().fromScene);
        }
        this.clO = mo20513DM().filePath;
        if (TextUtils.isEmpty(this.clO)) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecoderBase", "source path is null");
            this.clN = 712;
            onError(this.clN);
            return;
        }
        C17875b DM = mo20513DM();
        C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "decode sourcePath :%s, loop:%b", this.clO, Boolean.valueOf(DM.fqL));
        if (this.clQ.get()) {
            C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "do preload audio");
            if (DM.fqX) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "preload begin");
                if (C45166d.m83168Dm().mo73135dx(this.clO)) {
                    C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
                } else {
                    mo20507DG();
                }
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "preload end");
                return;
            }
            if (!isPlaying()) {
                mo20522gy(3);
            }
            if (C45166d.m83168Dm().mo73135dx(this.clO)) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "audio is loaded complete!");
            } else {
                mo20507DG();
            }
            C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "preload audio end");
            this.clQ.set(false);
            C37484c DC = mo20503DC();
            if (this.clT.get()) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "stopped, not to play");
                if (DC.cky) {
                    mo20522gy(2);
                    return;
                }
                return;
            } else if (isError()) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "occurs error, not to play");
                return;
            } else if (isPlaying() || DM.fqK) {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "to play");
                mo20522gy(2);
            } else {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "not to play");
                mo20522gy(2);
                return;
            }
        }
        mo20522gy(4);
        int i;
        do {
            if (C45166d.m83168Dm().mo73135dx(this.clO)) {
                mo20508DH();
            } else {
                mo20507DG();
            }
            if (!DM.fqL || this.clT.get()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "loop again for audioId:%s", m16396DN());
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    C45174b.m83207e("MicroMsg.Mix.AudioDecoderBase", "sleep exception");
                }
                this.startTime = 0;
                continue;
            }
        } while (i != 0);
        if (this.clT.get() || isError()) {
            C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "is stop or error, not set to play complete!");
            if (this.clK.equals(mo20513DM().filePath)) {
                this.clB.cnB.mo33512dK(m16396DN());
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "removeAudio");
            } else {
                C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "change src only, don't removeAudio");
            }
        } else if (this.clB.cnB.mo33514dM(m16396DN())) {
            mo20522gy(7);
            this.clB.cnB.mo33512dK(m16396DN());
        } else {
            C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "not mix end, not set to play complete!");
            this.clB.cnB.mo33516l(m16396DN(), true);
        }
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "task end");
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo20518a(C37484c c37484c) {
        if (this.clM == null) {
            C45174b.m83207e("MicroMsg.Mix.AudioDecoderBase", "process is null");
            return;
        }
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "writeCacheAndPlay");
        mo20510DJ();
        while (!this.clT.get()) {
            mo20504DD();
            C45164d Dt = this.clM.mo33488Dt();
            if (c37484c.size() <= 0 || Dt != null) {
                if (c37484c.size() != 0 || Dt != null) {
                    if (Dt != null) {
                        if (!c37484c.cky) {
                            c37484c.mo60396a(Dt);
                        }
                        mo20519a(Dt);
                        if (Dt == null) {
                            break;
                        }
                    }
                    break;
                }
                c37484c.reset();
                break;
            }
            c37484c.complete();
            break;
        }
        mo20511DK();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: DH */
    public final void mo20508DH() {
        C45174b.m83209i("MicroMsg.Mix.AudioDecoderBase", "readCacheAndPlay");
        C37484c DC = mo20503DC();
        if (DC != null) {
            mo20510DJ();
            int size = DC.size();
            for (int i = 0; i < size && !this.clT.get(); i++) {
                mo20504DD();
                C45164d gv = DC.mo60399gv(i);
                if (gv != null) {
                    mo20519a(gv);
                }
            }
            mo20511DK();
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo20519a(C45164d c45164d) {
        if (!this.clQ.get() && c45164d != null) {
            if ((c45164d.ckG <= 0 || this.startTime <= 0 || c45164d.ckG >= ((long) this.startTime)) && this.clB != null && this.clB.cnB != null && c45164d != null) {
                c45164d.ckD = m16396DN();
                mo20520c(c45164d);
            }
        }
    }

    /* renamed from: gx */
    public final void mo20521gx(int i) {
        if (i < 20 && this.clU.get() && !this.clS.get() && !this.clT.get()) {
            C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "unLockWrite, queueSize:%d", Integer.valueOf(i));
            mo20505DE();
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gy */
    public final void mo20522gy(int i) {
        m16397c(i, 0, "");
    }

    /* renamed from: c */
    private void m16397c(int i, int i2, String str) {
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
                DN = m16396DN();
                if (!TextUtils.isEmpty(DN) && i3 != -1) {
                    if (this.clB != null && i3 == 4) {
                        this.clB.mo73153a(i3, DN, i2, str);
                        return;
                    } else if (this.clB != null) {
                        this.clB.mo73158e(i3, DN, this.clP);
                        return;
                    } else {
                        return;
                    }
                }
            }
            i3 = -1;
            DN = m16396DN();
            if (!TextUtils.isEmpty(DN)) {
            }
        }
    }

    /* renamed from: DI */
    public final void mo20509DI() {
        if (!this.clV.get() && !this.clT.get()) {
            this.clV.set(true);
            mo20522gy(13);
        }
    }

    public final void onError(int i) {
        C45174b.m83208e("MicroMsg.Mix.AudioDecoderBase", "onError, errType:%d", Integer.valueOf(i));
        this.clN = i;
        this.clT.set(true);
        m16397c(9, i, "");
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: DJ */
    public void mo20510DJ() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo20520c(C45164d c45164d) {
        if (this.clK.mo53051Ev().ckA) {
            if (!this.clW.get()) {
                this.clW.set(true);
                mo20522gy(14);
            }
            if (this.clB.cnB.mo33506a(m16396DN(), c45164d, this) < 50) {
                this.clU.set(false);
                return;
            }
            C37484c DC = mo20503DC();
            if (DC == null || !DC.cky) {
                this.clU.set(false);
                return;
            }
            this.clU.set(true);
            synchronized (this.lock) {
                try {
                    C45174b.m83210i("MicroMsg.Mix.AudioDecoderBase", "lockWriteBuffer, writeSize:%d", Integer.valueOf(r0));
                    this.lock.wait();
                } catch (Exception e) {
                    C45174b.printErrStackTrace("MicroMsg.Mix.AudioDecoderBase", e, "lockWriteBuffer", new Object[0]);
                }
            }
            return;
        }
        return;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: DK */
    public void mo20511DK() {
    }

    /* renamed from: DL */
    public void mo20512DL() {
    }

    /* renamed from: DM */
    public final C17875b mo20513DM() {
        if (this.clK != null) {
            return this.clK.mo53051Ev();
        }
        return this.clL;
    }

    /* renamed from: DN */
    private String m16396DN() {
        C17875b DM = mo20513DM();
        if (DM != null) {
            return DM.ckD;
        }
        C45174b.m83207e("MicroMsg.Mix.AudioDecoderBase", "param is null");
        return this.ckD;
    }
}
