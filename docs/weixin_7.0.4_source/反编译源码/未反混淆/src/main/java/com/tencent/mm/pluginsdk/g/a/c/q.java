package com.tencent.mm.pluginsdk.g.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class q {
    private volatile al ftB;
    public final ak handler;
    public final boolean hrm;
    public final t vfx;
    public final n vfy;
    public final i vfz;

    public static final class a {
        private static final q vfA = new q();

        static {
            AppMethodBeat.i(79613);
            AppMethodBeat.o(79613);
        }
    }

    static class b implements Runnable {
        private final Runnable fZM;

        /* synthetic */ b(Runnable runnable, byte b) {
            this(runnable);
        }

        private b(Runnable runnable) {
            this.fZM = runnable;
        }

        public final void run() {
            AppMethodBeat.i(79614);
            if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
            if (this.fZM != null) {
                this.fZM.run();
            }
            AppMethodBeat.o(79614);
        }
    }

    /* synthetic */ q(byte b) {
        this();
    }

    private q() {
        AppMethodBeat.i(79615);
        this.ftB = null;
        r.init();
        this.vfx = t.diA();
        if (this.vfx == null) {
            this.hrm = false;
            this.vfy = null;
            this.handler = null;
            this.vfz = null;
            AppMethodBeat.o(79615);
            return;
        }
        this.hrm = true;
        u uVar = new u();
        this.handler = new al("ResDownloader-EventThread").doN();
        this.vfz = new i(aNS().doN());
        this.vfy = new n(uVar, this.vfz);
        AppMethodBeat.o(79615);
    }

    public final void R(Runnable runnable) {
        AppMethodBeat.i(79616);
        aNS().aa(new b(runnable, (byte) 0));
        AppMethodBeat.o(79616);
    }

    /* Access modifiers changed, original: final */
    public final al aNS() {
        AppMethodBeat.i(79617);
        if (this.ftB == null) {
            this.ftB = new al("ResDownloader-WorkerThread");
        }
        al alVar = this.ftB;
        AppMethodBeat.o(79617);
        return alVar;
    }

    public final void b(String str, d dVar) {
        AppMethodBeat.i(79618);
        ab.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", str, dVar);
        if (this.hrm) {
            this.vfz.a(str, dVar);
        }
        AppMethodBeat.o(79618);
    }

    static com.tencent.mm.pluginsdk.g.a.c.n.a c(l lVar) {
        AppMethodBeat.i(79619);
        ab.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
        int hashCode = lVar.awa().hashCode();
        for (g gVar : r.diz()) {
            ab.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", gVar.getClass().getSimpleName(), gVar.awa());
            if (gVar.awa().hashCode() == hashCode) {
                com.tencent.mm.pluginsdk.g.a.c.n.a c = gVar.c(lVar);
                AppMethodBeat.o(79619);
                return c;
            }
        }
        AppMethodBeat.o(79619);
        return null;
    }

    public final void h(s sVar) {
        AppMethodBeat.i(79620);
        if (this.hrm) {
            boolean z;
            long anU = bo.anU();
            if (this.vfx.ajg(sVar.field_urlKey) != null) {
                this.vfx.i(sVar);
                z = false;
            } else {
                this.vfx.j(sVar);
                z = true;
            }
            ab.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", sVar.field_urlKey, Boolean.valueOf(z), Long.valueOf(bo.gb(anU)));
        }
        AppMethodBeat.o(79620);
    }

    public final s ajg(String str) {
        AppMethodBeat.i(79621);
        if (this.hrm) {
            long anU = bo.anU();
            s ajg = this.vfx.ajg(str);
            String str2 = "MicroMsg.ResDownloaderCore";
            String str3 = "doQuery: urlKey = %s, cost = %d";
            Object[] objArr = new Object[2];
            objArr[0] = ajg == null ? BuildConfig.COMMAND : ajg.field_urlKey;
            objArr[1] = Long.valueOf(bo.gb(anU));
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(79621);
            return ajg;
        }
        AppMethodBeat.o(79621);
        return null;
    }

    public final int d(l lVar) {
        AppMethodBeat.i(79622);
        if (!this.hrm) {
            AppMethodBeat.o(79622);
            return -1;
        } else if (bo.isNullOrNil(lVar.url)) {
            ab.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", lVar.vdC);
            AppMethodBeat.o(79622);
            return 3;
        } else {
            ab.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", lVar.vdC);
            int b = this.vfy.b(lVar);
            AppMethodBeat.o(79622);
            return b;
        }
    }

    public final boolean ajh(String str) {
        AppMethodBeat.i(79623);
        if (!this.hrm) {
            AppMethodBeat.o(79623);
            return false;
        } else if (this.vfy.ajc(str) || this.vfy.ajd(str)) {
            AppMethodBeat.o(79623);
            return true;
        } else {
            AppMethodBeat.o(79623);
            return false;
        }
    }

    public final void AH(String str) {
        AppMethodBeat.i(79624);
        if (this.hrm) {
            this.vfy.ajf(str);
        }
        AppMethodBeat.o(79624);
    }
}
