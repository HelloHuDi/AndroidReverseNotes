package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n.C30044a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.q */
public final class C14856q {
    private volatile C5004al ftB;
    public final C7306ak handler;
    public final boolean hrm;
    public final C44050t vfx;
    public final C30043n vfy;
    public final C4723i vfz;

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.q$a */
    public static final class C14857a {
        private static final C14856q vfA = new C14856q();

        static {
            AppMethodBeat.m2504i(79613);
            AppMethodBeat.m2505o(79613);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.q$b */
    static class C14858b implements Runnable {
        private final Runnable fZM;

        /* synthetic */ C14858b(Runnable runnable, byte b) {
            this(runnable);
        }

        private C14858b(Runnable runnable) {
            this.fZM = runnable;
        }

        public final void run() {
            AppMethodBeat.m2504i(79614);
            if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.fZM != null) {
                this.fZM.run();
            }
            AppMethodBeat.m2505o(79614);
        }
    }

    /* synthetic */ C14856q(byte b) {
        this();
    }

    private C14856q() {
        AppMethodBeat.m2504i(79615);
        this.ftB = null;
        C46489r.init();
        this.vfx = C44050t.diA();
        if (this.vfx == null) {
            this.hrm = false;
            this.vfy = null;
            this.handler = null;
            this.vfz = null;
            AppMethodBeat.m2505o(79615);
            return;
        }
        this.hrm = true;
        C44051u c44051u = new C44051u();
        this.handler = new C5004al("ResDownloader-EventThread").doN();
        this.vfz = new C4723i(aNS().doN());
        this.vfy = new C30043n(c44051u, this.vfz);
        AppMethodBeat.m2505o(79615);
    }

    /* renamed from: R */
    public final void mo27173R(Runnable runnable) {
        AppMethodBeat.m2504i(79616);
        aNS().mo10302aa(new C14858b(runnable, (byte) 0));
        AppMethodBeat.m2505o(79616);
    }

    /* Access modifiers changed, original: final */
    public final C5004al aNS() {
        AppMethodBeat.m2504i(79617);
        if (this.ftB == null) {
            this.ftB = new C5004al("ResDownloader-WorkerThread");
        }
        C5004al c5004al = this.ftB;
        AppMethodBeat.m2505o(79617);
        return c5004al;
    }

    /* renamed from: b */
    public final void mo27177b(String str, C35790d c35790d) {
        AppMethodBeat.m2504i(79618);
        C4990ab.m7411d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", str, c35790d);
        if (this.hrm) {
            this.vfz.mo9859a(str, c35790d);
        }
        AppMethodBeat.m2505o(79618);
    }

    /* renamed from: c */
    static C30044a m23117c(C35792l c35792l) {
        AppMethodBeat.m2504i(79619);
        C4990ab.m7410d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = c35792l.awa().hashCode();
        for (C4721g c4721g : C46489r.diz()) {
            C4990ab.m7417i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", c4721g.getClass().getSimpleName(), c4721g.awa());
            if (c4721g.awa().hashCode() == hashCode) {
                C30044a c = c4721g.mo9622c(c35792l);
                AppMethodBeat.m2505o(79619);
                return c;
            }
        }
        AppMethodBeat.m2505o(79619);
        return null;
    }

    /* renamed from: h */
    public final void mo27179h(C44049s c44049s) {
        AppMethodBeat.m2504i(79620);
        if (this.hrm) {
            boolean z;
            long anU = C5046bo.anU();
            if (this.vfx.ajg(c44049s.field_urlKey) != null) {
                this.vfx.mo69738i(c44049s);
                z = false;
            } else {
                this.vfx.mo69739j(c44049s);
                z = true;
            }
            C4990ab.m7417i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", c44049s.field_urlKey, Boolean.valueOf(z), Long.valueOf(C5046bo.m7566gb(anU)));
        }
        AppMethodBeat.m2505o(79620);
    }

    public final C44049s ajg(String str) {
        AppMethodBeat.m2504i(79621);
        if (this.hrm) {
            long anU = C5046bo.anU();
            C44049s ajg = this.vfx.ajg(str);
            String str2 = "MicroMsg.ResDownloaderCore";
            String str3 = "doQuery: urlKey = %s, cost = %d";
            Object[] objArr = new Object[2];
            objArr[0] = ajg == null ? BuildConfig.COMMAND : ajg.field_urlKey;
            objArr[1] = Long.valueOf(C5046bo.m7566gb(anU));
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(79621);
            return ajg;
        }
        AppMethodBeat.m2505o(79621);
        return null;
    }

    /* renamed from: d */
    public final int mo27178d(C35792l c35792l) {
        AppMethodBeat.m2504i(79622);
        if (!this.hrm) {
            AppMethodBeat.m2505o(79622);
            return -1;
        } else if (C5046bo.isNullOrNil(c35792l.url)) {
            C4990ab.m7417i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", c35792l.vdC);
            AppMethodBeat.m2505o(79622);
            return 3;
        } else {
            C4990ab.m7417i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", c35792l.vdC);
            int b = this.vfy.mo21434b(c35792l);
            AppMethodBeat.m2505o(79622);
            return b;
        }
    }

    public final boolean ajh(String str) {
        AppMethodBeat.m2504i(79623);
        if (!this.hrm) {
            AppMethodBeat.m2505o(79623);
            return false;
        } else if (this.vfy.ajc(str) || this.vfy.ajd(str)) {
            AppMethodBeat.m2505o(79623);
            return true;
        } else {
            AppMethodBeat.m2505o(79623);
            return false;
        }
    }

    /* renamed from: AH */
    public final void mo27172AH(String str) {
        AppMethodBeat.m2504i(79624);
        if (this.hrm) {
            this.vfy.ajf(str);
        }
        AppMethodBeat.m2505o(79624);
    }
}
