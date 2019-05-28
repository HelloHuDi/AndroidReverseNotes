package com.tencent.p177mm.p612ui.chatting.p616c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C30719l;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7336g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.chatting.c.h */
public final class C36144h implements C7336g, C30719l {
    private HashSet<C30719l> yOL = new HashSet();

    public C36144h() {
        AppMethodBeat.m2504i(31289);
        AppMethodBeat.m2505o(31289);
    }

    /* renamed from: a */
    public final void mo15845a(C30719l c30719l) {
        AppMethodBeat.m2504i(31290);
        if (!this.yOL.contains(c30719l)) {
            this.yOL.add(c30719l);
        }
        AppMethodBeat.m2505o(31290);
    }

    /* renamed from: b */
    public final void mo15846b(C30719l c30719l) {
        AppMethodBeat.m2504i(31291);
        this.yOL.remove(c30719l);
        AppMethodBeat.m2505o(31291);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31292);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxx();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31292);
    }

    public final void dxy() {
        AppMethodBeat.m2504i(31293);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxy();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31293);
    }

    public final void dxz() {
        AppMethodBeat.m2504i(31294);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxz();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31294);
    }

    public final void dxA() {
        AppMethodBeat.m2504i(31295);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxA();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31295);
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31296);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxB();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31296);
    }

    public final void dxC() {
        AppMethodBeat.m2504i(31297);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxC();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31297);
    }

    public final void dxD() {
        AppMethodBeat.m2504i(31298);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            C30719l c30719l = (C30719l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            c30719l.dxD();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (C4990ab.getLogLevel() == 0) {
                C4990ab.m7419v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", c30719l.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        C4990ab.m7417i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(31298);
    }
}
