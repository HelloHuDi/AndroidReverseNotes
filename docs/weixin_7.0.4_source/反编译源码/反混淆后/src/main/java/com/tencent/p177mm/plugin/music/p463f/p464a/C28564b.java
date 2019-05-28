package com.tencent.p177mm.plugin.music.p463f.p464a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.music.f.a.b */
public abstract class C28564b {
    protected C9058e oLt;
    protected C46099f oNQ;
    public C34580g oNR = new C34580g();

    /* renamed from: com.tencent.mm.plugin.music.f.a.b$2 */
    class C126692 implements Runnable {
        C126692() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137650);
            C4990ab.m7417i("MicroMsg.Music.BasePlayer", "onStart %b", Boolean.valueOf(C28564b.this.isPlaying()));
            C28564b.this.oNQ.mo8044k(C28564b.this.oLt);
            AppMethodBeat.m2505o(137650);
        }
    }

    /* renamed from: Tr */
    public abstract void mo46681Tr(String str);

    public abstract int bUA();

    public abstract String bUB();

    public abstract boolean bUz();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    /* renamed from: a */
    public final void mo46682a(C46099f c46099f) {
        this.oNQ = c46099f;
    }

    /* renamed from: J */
    public final void mo46680J(C9058e c9058e) {
        this.oLt = c9058e;
    }

    /* renamed from: jy */
    public void mo46688jy(final boolean z) {
        if (this.oNQ != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(137649);
                    C4990ab.m7417i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", Boolean.valueOf(z));
                    C28564b.this.oNQ.mo8043c(C28564b.this.oLt, z);
                    AppMethodBeat.m2505o(137649);
                }
            });
        }
    }

    public final void onStart() {
        if (this.oNQ != null) {
            C5004al.m7441d(new C126692());
        }
    }

    /* renamed from: zR */
    public final void mo46695zR(final int i) {
        if (this.oNQ != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(137651);
                    if (C28564b.this.bUz()) {
                        C28564b.this.oNQ.mo8041I(C28564b.this.oLt);
                    }
                    AppMethodBeat.m2505o(137651);
                }
            });
        }
    }

    /* renamed from: jz */
    public void mo46689jz(final boolean z) {
        if (this.oNQ != null) {
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(137652);
                    C4990ab.m7417i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", Boolean.valueOf(z));
                    C28564b.this.oNQ.mo8042b(C28564b.this.oLt, z);
                    AppMethodBeat.m2505o(137652);
                }
            });
        }
    }
}
