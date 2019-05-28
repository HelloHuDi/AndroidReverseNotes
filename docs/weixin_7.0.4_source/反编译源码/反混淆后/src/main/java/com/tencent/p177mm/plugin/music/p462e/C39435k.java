package com.tencent.p177mm.plugin.music.p462e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.p463f.p464a.C34578d;
import com.tencent.p177mm.plugin.music.p997h.C28567a;
import com.tencent.p177mm.plugin.music.p997h.C39438d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.music.e.k */
public final class C39435k extends C28562h {
    static C39435k oLY;
    public C46096a oLX = null;
    private C28567a oLZ;

    private C39435k(C46096a c46096a) {
        this.oLX = c46096a;
    }

    /* renamed from: a */
    public static synchronized void m67367a(C46096a c46096a) {
        synchronized (C39435k.class) {
            AppMethodBeat.m2504i(137534);
            if (oLY != null) {
                C4990ab.m7412e("MicroMsg.Music.MusicPlayerManager", "music player mgr is init, don't it again");
                oLY.oLX = c46096a;
                c46096a.mo46655a(oLY);
                c46096a.init();
                AppMethodBeat.m2505o(137534);
            } else {
                oLY = new C39435k(c46096a);
                c46096a.mo46655a(oLY);
                c46096a.init();
                AppMethodBeat.m2505o(137534);
            }
        }
    }

    public static C39435k bUf() {
        AppMethodBeat.m2504i(137535);
        if (oLY == null) {
            NullPointerException nullPointerException = new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
            AppMethodBeat.m2505o(137535);
            throw nullPointerException;
        }
        if (oLY.oLX == null) {
            oLY.oLX = new C12663i();
        }
        C39435k c39435k = oLY;
        AppMethodBeat.m2505o(137535);
        return c39435k;
    }

    public static synchronized void bUg() {
        synchronized (C39435k.class) {
            AppMethodBeat.m2504i(137536);
            if (oLY != null) {
                oLY.finish();
            }
            AppMethodBeat.m2505o(137536);
        }
    }

    /* renamed from: p */
    public final void mo62388p(C9058e c9058e) {
        AppMethodBeat.m2504i(137537);
        if (c9058e != null) {
            C4990ab.m7417i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", Integer.valueOf(c9058e.fJS));
        }
        C4990ab.m7416i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
        mo62389t(this.oLX.mo46660i(c9058e));
        AppMethodBeat.m2505o(137537);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: t */
    public final void mo62389t(C9058e c9058e) {
        AppMethodBeat.m2504i(137538);
        C39438d.m67374M(c9058e);
        if (this.oLX.mo46658g(c9058e)) {
            mo46675q(c9058e);
            AppMethodBeat.m2505o(137538);
            return;
        }
        C4990ab.m7412e("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
        AppMethodBeat.m2505o(137538);
    }

    public final C34578d bTS() {
        AppMethodBeat.m2504i(137539);
        C34578d bTS = super.bTS();
        AppMethodBeat.m2505o(137539);
        return bTS;
    }

    public final void aic() {
        AppMethodBeat.m2504i(137540);
        super.aic();
        AppMethodBeat.m2505o(137540);
    }

    public final void release() {
        AppMethodBeat.m2504i(137541);
        C4990ab.m7416i("MicroMsg.Music.MusicPlayerManager", "release");
        super.release();
        AppMethodBeat.m2505o(137541);
    }

    public final void finish() {
        AppMethodBeat.m2504i(137542);
        super.finish();
        this.oLX.release();
        this.oLZ = null;
        AppMethodBeat.m2505o(137542);
    }

    /* renamed from: ju */
    public final void mo46674ju(boolean z) {
        AppMethodBeat.m2504i(137543);
        super.mo46674ju(z);
        AppMethodBeat.m2505o(137543);
    }

    /* renamed from: zI */
    public final void mo46678zI(int i) {
        AppMethodBeat.m2504i(137544);
        super.mo46678zI(i);
        AppMethodBeat.m2505o(137544);
    }

    public final C9058e bTQ() {
        AppMethodBeat.m2504i(137545);
        C9058e bTQ = this.oLX.bTQ();
        AppMethodBeat.m2505o(137545);
        return bTQ;
    }

    public static C28567a bUh() {
        AppMethodBeat.m2504i(137546);
        if (C39435k.bUf().oLZ == null) {
            C39435k.bUf().oLZ = new C28567a();
        }
        C28567a c28567a = C39435k.bUf().oLZ;
        AppMethodBeat.m2505o(137546);
        return c28567a;
    }
}
