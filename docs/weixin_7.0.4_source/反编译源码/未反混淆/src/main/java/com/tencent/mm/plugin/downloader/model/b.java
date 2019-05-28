package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Vector;

public final class b {
    private static Vector<k> kMI = new Vector();
    private static k kMJ;

    static {
        AppMethodBeat.i(2395);
        AppMethodBeat.o(2395);
    }

    public static void a(k kVar) {
        AppMethodBeat.i(2384);
        if (!(kVar == null || kMI.contains(kVar))) {
            kMI.add(kVar);
        }
        AppMethodBeat.o(2384);
    }

    public static void b(k kVar) {
        AppMethodBeat.i(2385);
        if (kVar != null) {
            kMI.remove(kVar);
        }
        AppMethodBeat.o(2385);
    }

    public static void c(k kVar) {
        kMJ = kVar;
    }

    public static void bif() {
        kMJ = null;
    }

    public final void j(final long j, final String str) {
        AppMethodBeat.i(2386);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2376);
                for (k onTaskStarted : b.big()) {
                    onTaskStarted.onTaskStarted(j, str);
                }
                if (b.kMJ != null) {
                    b.kMJ.onTaskStarted(j, str);
                }
                AppMethodBeat.o(2376);
            }
        });
        AppMethodBeat.o(2386);
    }

    public final void k(final long j, final String str) {
        AppMethodBeat.i(2387);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", Long.valueOf(j), str);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2377);
                for (k i : b.big()) {
                    i.i(j, str);
                }
                if (b.kMJ != null) {
                    b.kMJ.i(j, str);
                }
                AppMethodBeat.o(2377);
            }
        });
        AppMethodBeat.o(2387);
    }

    public final void hr(final long j) {
        AppMethodBeat.i(2388);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        if (c.hv(j) != null) {
            c.o(c.hv(j).field_downloadUrl, c.hv(j).field_secondaryUrl);
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2378);
                for (k onTaskRemoved : b.big()) {
                    onTaskRemoved.onTaskRemoved(j);
                }
                if (b.kMJ != null) {
                    b.kMJ.onTaskRemoved(j);
                }
                AppMethodBeat.o(2378);
            }
        });
        AppMethodBeat.o(2388);
    }

    public final void c(long j, String str, boolean z) {
        AppMethodBeat.i(2389);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        if (c.hv(j) != null) {
            c.o(c.hv(j).field_downloadUrl, c.hv(j).field_secondaryUrl);
        }
        final long j2 = j;
        final String str2 = str;
        final boolean z2 = z;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2379);
                for (k b : b.big()) {
                    b.b(j2, str2, z2);
                }
                if (b.kMJ != null) {
                    b.kMJ.b(j2, str2, z2);
                }
                AppMethodBeat.o(2379);
            }
        });
        AppMethodBeat.o(2389);
    }

    public final void d(long j, int i, boolean z) {
        AppMethodBeat.i(2390);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j), Integer.valueOf(i));
        if (c.hv(j) != null) {
            c.o(c.hv(j).field_downloadUrl, c.hv(j).field_secondaryUrl);
        }
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2380);
                for (k b : b.big()) {
                    b.b(j2, i2, z2);
                }
                if (b.kMJ != null) {
                    b.kMJ.b(j2, i2, z2);
                }
                AppMethodBeat.o(2380);
            }
        });
        AppMethodBeat.o(2390);
    }

    public final void hs(final long j) {
        AppMethodBeat.i(2391);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        if (c.hv(j) != null) {
            c.o(c.hv(j).field_downloadUrl, c.hv(j).field_secondaryUrl);
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2381);
                for (k onTaskPaused : b.big()) {
                    onTaskPaused.onTaskPaused(j);
                }
                if (b.kMJ != null) {
                    b.kMJ.onTaskPaused(j);
                }
                AppMethodBeat.o(2381);
            }
        });
        AppMethodBeat.o(2391);
    }

    public final void ht(final long j) {
        AppMethodBeat.i(2392);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2382);
                for (k gm : b.big()) {
                    gm.gm(j);
                }
                AppMethodBeat.o(2382);
            }
        });
        AppMethodBeat.o(2392);
    }

    public final void hu(final long j) {
        AppMethodBeat.i(2393);
        ab.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", Long.valueOf(j));
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(2383);
                for (k gn : b.big()) {
                    gn.gn(j);
                }
                AppMethodBeat.o(2383);
            }
        });
        AppMethodBeat.o(2393);
    }

    static /* synthetic */ k[] big() {
        AppMethodBeat.i(2394);
        k[] kVarArr = (k[]) kMI.toArray(new k[kMI.size()]);
        AppMethodBeat.o(2394);
        return kVarArr;
    }
}
