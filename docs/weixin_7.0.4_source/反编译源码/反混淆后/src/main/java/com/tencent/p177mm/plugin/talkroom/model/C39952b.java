package com.tencent.p177mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.talkroom.model.b */
public final class C39952b implements C1816at {
    private C1923n qbK = new C294171();
    C43683g sxI;
    private C13933d sxJ = new C13933d();
    public C36823c sxK = new C36823c();
    private C29419e sxL;
    C22391f sxM;

    /* renamed from: com.tencent.mm.plugin.talkroom.model.b$1 */
    class C294171 extends C1924a {

        /* renamed from: com.tencent.mm.plugin.talkroom.model.b$1$1 */
        class C294181 implements Runnable {
            C294181() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25755);
                if (C39952b.this.sxI != null) {
                    C39952b.this.sxI.mo69327mb(false);
                }
                AppMethodBeat.m2505o(25755);
            }
        }

        C294171() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(25756);
            if (i != 4) {
                AppMethodBeat.m2505o(25756);
                return;
            }
            new C7306ak(Looper.getMainLooper()).post(new C294181());
            AppMethodBeat.m2505o(25756);
        }
    }

    public C39952b() {
        AppMethodBeat.m2504i(25757);
        AppMethodBeat.m2505o(25757);
    }

    public static C39952b cEg() {
        AppMethodBeat.m2504i(25758);
        C9638aw.m17184ZE();
        C39952b c39952b = (C39952b) C45439bw.m83697oJ("plugin.talkroom");
        if (c39952b == null) {
            c39952b = new C39952b();
            C9638aw.m17184ZE().mo73244a("plugin.talkroom", c39952b);
        }
        AppMethodBeat.m2505o(25758);
        return c39952b;
    }

    public static C43683g cEh() {
        AppMethodBeat.m2504i(25759);
        if (C39952b.cEg().sxI == null) {
            C39952b.cEg().sxI = new C43683g();
        }
        C43683g c43683g = C39952b.cEg().sxI;
        AppMethodBeat.m2505o(25759);
        return c43683g;
    }

    public static C29419e cEi() {
        AppMethodBeat.m2504i(25760);
        if (C39952b.cEg().sxL == null) {
            C39952b.cEg().sxL = new C29419e();
        }
        C29419e c29419e = C39952b.cEg().sxL;
        AppMethodBeat.m2505o(25760);
        return c29419e;
    }

    public static String cEj() {
        AppMethodBeat.m2504i(25761);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29068Rt()).append("talkroom/").toString();
        AppMethodBeat.m2505o(25761);
        return stringBuilder2;
    }

    public static C22391f cEk() {
        AppMethodBeat.m2504i(25762);
        if (C39952b.cEg().sxM == null) {
            C39952b.cEg().sxM = new C22391f();
        }
        C22391f c22391f = C39952b.cEg().sxM;
        AppMethodBeat.m2505o(25762);
        return c22391f;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(25763);
        C1200d.m2636a(Integer.valueOf(56), this.sxJ);
        C9638aw.m17198a(this.qbK);
        C32337g.fUs = C39952b.cEi();
        C32337g.fUt = C39952b.cEh();
        AppMethodBeat.m2505o(25763);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(25764);
        C1200d.m2637b(Integer.valueOf(56), this.sxJ);
        C9638aw.m17200b(this.qbK);
        C32337g.fUs = null;
        C32337g.fUt = null;
        if (this.sxI != null) {
            this.sxI.cEw();
            this.sxI = null;
        }
        AppMethodBeat.m2505o(25764);
    }
}
