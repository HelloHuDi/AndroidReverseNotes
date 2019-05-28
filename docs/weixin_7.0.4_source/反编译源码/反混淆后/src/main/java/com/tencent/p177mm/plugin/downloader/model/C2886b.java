package com.tencent.p177mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p939a.C38842c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.downloader.model.b */
public final class C2886b {
    private static Vector<C11511k> kMI = new Vector();
    private static C11511k kMJ;

    static {
        AppMethodBeat.m2504i(2395);
        AppMethodBeat.m2505o(2395);
    }

    /* renamed from: a */
    public static void m5129a(C11511k c11511k) {
        AppMethodBeat.m2504i(2384);
        if (!(c11511k == null || kMI.contains(c11511k))) {
            kMI.add(c11511k);
        }
        AppMethodBeat.m2505o(2384);
    }

    /* renamed from: b */
    public static void m5130b(C11511k c11511k) {
        AppMethodBeat.m2504i(2385);
        if (c11511k != null) {
            kMI.remove(c11511k);
        }
        AppMethodBeat.m2505o(2385);
    }

    /* renamed from: c */
    public static void m5131c(C11511k c11511k) {
        kMJ = c11511k;
    }

    public static void bif() {
        kMJ = null;
    }

    /* renamed from: j */
    public final void mo7030j(final long j, final String str) {
        AppMethodBeat.m2504i(2386);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2376);
                for (C11511k onTaskStarted : C2886b.big()) {
                    onTaskStarted.onTaskStarted(j, str);
                }
                if (C2886b.kMJ != null) {
                    C2886b.kMJ.onTaskStarted(j, str);
                }
                AppMethodBeat.m2505o(2376);
            }
        });
        AppMethodBeat.m2505o(2386);
    }

    /* renamed from: k */
    public final void mo7031k(final long j, final String str) {
        AppMethodBeat.m2504i(2387);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", Long.valueOf(j), str);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2377);
                for (C11511k i : C2886b.big()) {
                    i.mo7669i(j, str);
                }
                if (C2886b.kMJ != null) {
                    C2886b.kMJ.mo7669i(j, str);
                }
                AppMethodBeat.m2505o(2377);
            }
        });
        AppMethodBeat.m2505o(2387);
    }

    /* renamed from: hr */
    public final void mo7026hr(final long j) {
        AppMethodBeat.m2504i(2388);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        if (C2895c.m5147hv(j) != null) {
            C38842c.m65897o(C2895c.m5147hv(j).field_downloadUrl, C2895c.m5147hv(j).field_secondaryUrl);
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2378);
                for (C11511k onTaskRemoved : C2886b.big()) {
                    onTaskRemoved.onTaskRemoved(j);
                }
                if (C2886b.kMJ != null) {
                    C2886b.kMJ.onTaskRemoved(j);
                }
                AppMethodBeat.m2505o(2378);
            }
        });
        AppMethodBeat.m2505o(2388);
    }

    /* renamed from: c */
    public final void mo7024c(long j, String str, boolean z) {
        AppMethodBeat.m2504i(2389);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        if (C2895c.m5147hv(j) != null) {
            C38842c.m65897o(C2895c.m5147hv(j).field_downloadUrl, C2895c.m5147hv(j).field_secondaryUrl);
        }
        final long j2 = j;
        final String str2 = str;
        final boolean z2 = z;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2379);
                for (C11511k b : C2886b.big()) {
                    b.mo7665b(j2, str2, z2);
                }
                if (C2886b.kMJ != null) {
                    C2886b.kMJ.mo7665b(j2, str2, z2);
                }
                AppMethodBeat.m2505o(2379);
            }
        });
        AppMethodBeat.m2505o(2389);
    }

    /* renamed from: d */
    public final void mo7025d(long j, int i, boolean z) {
        AppMethodBeat.m2504i(2390);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j), Integer.valueOf(i));
        if (C2895c.m5147hv(j) != null) {
            C38842c.m65897o(C2895c.m5147hv(j).field_downloadUrl, C2895c.m5147hv(j).field_secondaryUrl);
        }
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2380);
                for (C11511k b : C2886b.big()) {
                    b.mo7664b(j2, i2, z2);
                }
                if (C2886b.kMJ != null) {
                    C2886b.kMJ.mo7664b(j2, i2, z2);
                }
                AppMethodBeat.m2505o(2380);
            }
        });
        AppMethodBeat.m2505o(2390);
    }

    /* renamed from: hs */
    public final void mo7027hs(final long j) {
        AppMethodBeat.m2504i(2391);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        if (C2895c.m5147hv(j) != null) {
            C38842c.m65897o(C2895c.m5147hv(j).field_downloadUrl, C2895c.m5147hv(j).field_secondaryUrl);
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2381);
                for (C11511k onTaskPaused : C2886b.big()) {
                    onTaskPaused.onTaskPaused(j);
                }
                if (C2886b.kMJ != null) {
                    C2886b.kMJ.onTaskPaused(j);
                }
                AppMethodBeat.m2505o(2381);
            }
        });
        AppMethodBeat.m2505o(2391);
    }

    /* renamed from: ht */
    public final void mo7028ht(final long j) {
        AppMethodBeat.m2504i(2392);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2382);
                for (C11511k gm : C2886b.big()) {
                    gm.mo7667gm(j);
                }
                AppMethodBeat.m2505o(2382);
            }
        });
        AppMethodBeat.m2505o(2392);
    }

    /* renamed from: hu */
    public final void mo7029hu(final long j) {
        AppMethodBeat.m2504i(2393);
        C4990ab.m7417i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", Long.valueOf(j));
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(2383);
                for (C11511k gn : C2886b.big()) {
                    gn.mo7668gn(j);
                }
                AppMethodBeat.m2505o(2383);
            }
        });
        AppMethodBeat.m2505o(2393);
    }

    static /* synthetic */ C11511k[] big() {
        AppMethodBeat.m2504i(2394);
        C11511k[] c11511kArr = (C11511k[]) kMI.toArray(new C11511k[kMI.size()]);
        AppMethodBeat.m2505o(2394);
        return c11511kArr;
    }
}
