package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.b.g;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.Iterator;

public final class h implements g, l {
    private HashSet<l> yOL = new HashSet();

    public h() {
        AppMethodBeat.i(31289);
        AppMethodBeat.o(31289);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(31290);
        if (!this.yOL.contains(lVar)) {
            this.yOL.add(lVar);
        }
        AppMethodBeat.o(31290);
    }

    public final void b(l lVar) {
        AppMethodBeat.i(31291);
        this.yOL.remove(lVar);
        AppMethodBeat.o(31291);
    }

    public final void dxx() {
        AppMethodBeat.i(31292);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxx();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31292);
    }

    public final void dxy() {
        AppMethodBeat.i(31293);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxy();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31293);
    }

    public final void dxz() {
        AppMethodBeat.i(31294);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxz();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31294);
    }

    public final void dxA() {
        AppMethodBeat.i(31295);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxA();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31295);
    }

    public final void dxB() {
        AppMethodBeat.i(31296);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxB();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31296);
    }

    public final void dxC() {
        AppMethodBeat.i(31297);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxC();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31297);
    }

    public final void dxD() {
        AppMethodBeat.i(31298);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.yOL).iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            lVar.dxD();
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            if (ab.getLogLevel() == 0) {
                ab.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", lVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis2));
            }
        }
        ab.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(31298);
    }
}
