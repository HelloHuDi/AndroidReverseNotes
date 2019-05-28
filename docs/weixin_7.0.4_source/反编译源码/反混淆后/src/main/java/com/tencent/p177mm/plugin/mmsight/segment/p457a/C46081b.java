package com.tencent.p177mm.plugin.mmsight.segment.p457a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C21307a;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C28510b;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39398c;
import com.tencent.p177mm.plugin.mmsight.segment.p457a.C39397a.C39399d;
import com.tencent.p177mm.plugin.p468n.C34602i;
import com.tencent.p177mm.plugin.p468n.C34603j;
import com.tencent.p177mm.plugin.p468n.C39453c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.a.b */
public final class C46081b implements C39397a {
    /* renamed from: VN */
    boolean f17900VN = false;
    boolean cFy = false;
    boolean fqL = false;
    C34602i oAb = new C34602i(Looper.getMainLooper());
    int oAc;
    int oAd = 0;
    private int oAe = 0;
    C21307a oAf;
    C39399d oAg;
    C28510b oAh;
    C39398c oAi;

    /* renamed from: com.tencent.mm.plugin.mmsight.segment.a.b$1 */
    class C345571 implements C39453c {
        C345571() {
        }

        /* renamed from: pL */
        public final void mo39086pL() {
            AppMethodBeat.m2504i(3708);
            if (C46081b.this.oAh != null) {
                C46081b.this.oAh.mo17631ce(C46081b.this.oAb);
            }
            if (C46081b.this.cFy) {
                C46081b.this.oAb.start();
            }
            C46081b.this.f17900VN = true;
            AppMethodBeat.m2505o(3708);
        }

        /* renamed from: EA */
        public final void mo39082EA() {
            AppMethodBeat.m2504i(3709);
            if (C46081b.this.fqL) {
                C46081b.this.oAb.mo55186yI(C46081b.this.oAd);
            }
            AppMethodBeat.m2505o(3709);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(3710);
            if (C46081b.this.oAf != null) {
                C46081b.this.oAf.mo17632ey(i, i2);
            }
            AppMethodBeat.m2505o(3710);
        }

        public final void bnT() {
            AppMethodBeat.m2504i(3711);
            C4990ab.m7417i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", C46081b.this.oAi);
            if (C46081b.this.oAi != null) {
                C46081b.this.oAi.mo7952cf(C46081b.this.oAb);
                AppMethodBeat.m2505o(3711);
                return;
            }
            if (C46081b.this.cFy) {
                C46081b.this.oAb.start();
            }
            AppMethodBeat.m2505o(3711);
        }

        /* renamed from: S */
        public final void mo39083S(int i, int i2, int i3) {
            AppMethodBeat.m2504i(3712);
            C46081b.this.oAc = i3;
            if (C46081b.this.oAg != null) {
                C46081b.this.oAg.mo17622aa(i, i2, i3);
            }
            AppMethodBeat.m2505o(3712);
        }
    }

    public C46081b() {
        AppMethodBeat.m2504i(3713);
        C34602i c34602i = this.oAb;
        if (c34602i.orX != null) {
            C34603j c34603j = c34602i.orX;
            if (c34603j.orH != null) {
                c34603j.orH.orD = false;
            }
        }
        this.oAb.setNeedResetExtractor(false);
        this.oAb.orY = new C345571();
        AppMethodBeat.m2505o(3713);
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.m2504i(3714);
        this.oAb.setSurface(surface);
        AppMethodBeat.m2505o(3714);
    }

    public final void setDataSource(String str) {
        AppMethodBeat.m2504i(3715);
        this.oAb.setPath(str);
        AppMethodBeat.m2505o(3715);
    }

    public final void prepareAsync() {
        AppMethodBeat.m2504i(3716);
        this.oAb.prepare();
        AppMethodBeat.m2505o(3716);
    }

    public final void start() {
        AppMethodBeat.m2504i(3717);
        if (this.f17900VN) {
            this.oAb.start();
        }
        this.cFy = true;
        AppMethodBeat.m2505o(3717);
    }

    public final void stop() {
        AppMethodBeat.m2504i(3718);
        this.oAb.orX.stop();
        this.cFy = false;
        AppMethodBeat.m2505o(3718);
    }

    public final void pause() {
        AppMethodBeat.m2504i(3719);
        this.oAb.pause();
        AppMethodBeat.m2505o(3719);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(3720);
        boolean isPlaying = this.oAb.isPlaying();
        AppMethodBeat.m2505o(3720);
        return isPlaying;
    }

    public final void seekTo(int i) {
        AppMethodBeat.m2504i(3721);
        if (this.oAb != null) {
            C4990ab.m7417i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", Integer.valueOf(i));
            this.oAb.mo55186yI(i);
        }
        AppMethodBeat.m2505o(3721);
    }

    public final int getCurrentPosition() {
        AppMethodBeat.m2504i(3722);
        int bPb = this.oAb.bPb();
        AppMethodBeat.m2505o(3722);
        return bPb;
    }

    public final int getDuration() {
        return (int) this.oAb.orX.bfi;
    }

    public final void release() {
        AppMethodBeat.m2504i(3723);
        this.oAb.release();
        AppMethodBeat.m2505o(3723);
    }

    public final void setAudioStreamType(int i) {
    }

    public final void setLooping(boolean z) {
        this.fqL = z;
    }

    public final void setLoop(int i, int i2) {
        this.oAd = i;
        this.oAe = i2;
    }

    /* renamed from: a */
    public final void mo46477a(C28510b c28510b) {
        this.oAh = c28510b;
    }

    /* renamed from: a */
    public final void mo46478a(C39398c c39398c) {
        this.oAi = c39398c;
    }

    /* renamed from: a */
    public final void mo46479a(C39399d c39399d) {
        this.oAg = c39399d;
    }

    /* renamed from: a */
    public final void mo46476a(C21307a c21307a) {
        this.oAf = c21307a;
    }
}
