package com.tencent.p177mm.plugin.p945e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.NotifyReceiver.NotifyService;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.model.C26412am;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C45140n;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C6300p.C1213a;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C45474a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.e.e */
public final class C11544e extends C42148a {
    private C26412am flA;

    /* renamed from: com.tencent.mm.plugin.e.e$1 */
    class C115421 implements C1213a {

        /* renamed from: com.tencent.mm.plugin.e.e$1$1 */
        class C115431 implements Runnable {
            C115431() {
            }

            public final void run() {
            }
        }

        C115421() {
        }

        /* renamed from: a */
        public final void mo4484a(C6300p c6300p, boolean z) {
            AppMethodBeat.m2504i(18525);
            if (z && !c6300p.foreground) {
                if (C11544e.aVI()) {
                    MMAppMgr.dyr();
                    C4990ab.m7412e("MicroMsg.MMCoreInitTask", "now killing the working process....");
                    if (C45474a.anD()) {
                        C4990ab.m7412e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
                        AppMethodBeat.m2505o(18525);
                        return;
                    }
                    C25985d.m41464aI(new Intent(C4996ah.getContext(), NotifyService.class));
                    C45140n.m83007x(new C115431());
                } else {
                    C4990ab.m7420w("MicroMsg.MMCoreInitTask", "can't kill the working process");
                    AppMethodBeat.m2505o(18525);
                    return;
                }
            }
            AppMethodBeat.m2505o(18525);
        }

        /* renamed from: a */
        public final void mo4483a(C6300p c6300p) {
        }
    }

    public C11544e(C26412am c26412am) {
        this.flA = c26412am;
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(18526);
        C9638aw.m17197a(this.flA, new C115421());
        AppMethodBeat.m2505o(18526);
    }

    static /* synthetic */ boolean aVI() {
        AppMethodBeat.m2504i(18527);
        if (C37494a.aie()) {
            AppMethodBeat.m2505o(18527);
            return false;
        }
        C42062sz c42062sz = new C42062sz();
        c42062sz.cPf.cPh = true;
        C4879a.xxA.mo10055m(c42062sz);
        if (C5046bo.isNullOrNil(c42062sz.cPg.cPj)) {
            AppMethodBeat.m2505o(18527);
            return true;
        }
        AppMethodBeat.m2505o(18527);
        return false;
    }
}
