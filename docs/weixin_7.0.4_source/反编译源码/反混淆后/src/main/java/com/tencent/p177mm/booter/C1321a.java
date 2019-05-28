package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C26411af;
import com.tencent.p177mm.model.C9634ae;
import com.tencent.p177mm.p230g.p231a.C26208nu;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C5031ax.C5030a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.booter.a */
public class C1321a implements C9634ae {
    private static volatile C1321a ebw;
    private List<C26411af> callbacks = new ArrayList();
    private C5031ax ebu = new C5031ax();
    private C5030a ebv = new C13221();
    private C4884c ebx;

    /* renamed from: com.tencent.mm.booter.a$1 */
    class C13221 implements C5030a {
        C13221() {
        }

        /* renamed from: ih */
        public final void mo4652ih(int i) {
            AppMethodBeat.m2504i(77618);
            switch (i) {
                case 0:
                    C4990ab.m7418v("MicroMsg.BackgroundPlayer", "call end");
                    C1321a.this.mo4648Ic();
                    AppMethodBeat.m2505o(77618);
                    return;
                case 1:
                case 2:
                    C4990ab.m7418v("MicroMsg.BackgroundPlayer", "call start");
                    C1321a.this.mo4649Id();
                    break;
            }
            AppMethodBeat.m2505o(77618);
        }
    }

    /* renamed from: com.tencent.mm.booter.a$2 */
    class C13232 extends C4884c<C26208nu> {
        C13232() {
            AppMethodBeat.m2504i(77619);
            this.xxI = C26208nu.class.getName().hashCode();
            AppMethodBeat.m2505o(77619);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(77620);
            switch (((C26208nu) c4883b).cKl.state) {
                case 0:
                    C4990ab.m7410d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                    C1321a.this.mo4649Id();
                    break;
                case 1:
                    C4990ab.m7410d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                    C1321a.this.mo4648Ic();
                    break;
            }
            AppMethodBeat.m2505o(77620);
            return false;
        }
    }

    private C1321a() {
        AppMethodBeat.m2504i(77621);
        this.ebu.mo10365a(this.ebv);
        this.ebu.mo10368gK(C4996ah.getContext());
        if (this.ebx == null) {
            this.ebx = new C13232();
        }
        C4879a.xxA.mo10052c(this.ebx);
        AppMethodBeat.m2505o(77621);
    }

    /* renamed from: Ib */
    public static C1321a m2829Ib() {
        AppMethodBeat.m2504i(77622);
        if (ebw == null) {
            synchronized (C1321a.class) {
                try {
                    if (ebw == null) {
                        ebw = new C1321a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(77622);
                    }
                }
            }
        }
        C1321a c1321a = ebw;
        AppMethodBeat.m2505o(77622);
        return c1321a;
    }

    /* renamed from: a */
    public final void mo4650a(C26411af c26411af) {
        AppMethodBeat.m2504i(77623);
        C4990ab.m7411d("MicroMsg.BackgroundPlayer", "add callback : %s", c26411af.toString());
        this.callbacks.add(c26411af);
        AppMethodBeat.m2505o(77623);
    }

    /* renamed from: b */
    public final void mo4651b(C26411af c26411af) {
        AppMethodBeat.m2504i(77624);
        this.callbacks.remove(c26411af);
        AppMethodBeat.m2505o(77624);
    }

    /* renamed from: Ic */
    public final void mo4648Ic() {
        AppMethodBeat.m2504i(77625);
        if (this.callbacks == null) {
            AppMethodBeat.m2505o(77625);
            return;
        }
        for (C26411af Zs : this.callbacks) {
            Zs.mo44182Zs();
        }
        AppMethodBeat.m2505o(77625);
    }

    /* renamed from: Id */
    public final void mo4649Id() {
        AppMethodBeat.m2504i(77626);
        if (this.callbacks == null) {
            AppMethodBeat.m2505o(77626);
            return;
        }
        for (C26411af Zt : this.callbacks) {
            Zt.mo44183Zt();
        }
        AppMethodBeat.m2505o(77626);
    }
}
