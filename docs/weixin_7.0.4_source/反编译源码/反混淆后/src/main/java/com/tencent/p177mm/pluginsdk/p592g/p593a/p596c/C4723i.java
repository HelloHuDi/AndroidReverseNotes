package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.i */
public final class C4723i implements C40430c {
    private final C7306ak vfc;
    public final SparseArray<List<C35790d>> vfd = new SparseArray();
    public final Object vfe = new Object();

    C4723i(C7306ak c7306ak) {
        AppMethodBeat.m2504i(79574);
        this.vfc = c7306ak;
        AppMethodBeat.m2505o(79574);
    }

    /* renamed from: a */
    public final void mo9858a(C4715e c4715e, final C40432m c40432m) {
        AppMethodBeat.m2504i(79575);
        C4990ab.m7416i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(c40432m)));
        C44049s ajg;
        final List aje;
        final String dib;
        switch (c40432m.status) {
            case 2:
                ajg = C14857a.vfA.ajg(c40432m.vdC);
                if (ajg != null) {
                    ajg.field_status = 2;
                    C14857a.vfA.mo27179h(ajg);
                }
                C4990ab.m7410d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + c4715e.awa());
                aje = aje(c4715e.awa());
                if (C5046bo.m7548ek(aje)) {
                    C4990ab.m7410d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    AppMethodBeat.m2505o(79575);
                    return;
                }
                C4990ab.m7410d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + aje.size());
                dib = c4715e.dib();
                this.vfc.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(79572);
                        for (C35790d c35790d : aje) {
                            if (C5046bo.nullAsNil(c35790d.awa()).equals(c40432m.groupId)) {
                                c35790d.mo9626a(dib, c40432m);
                            }
                        }
                        AppMethodBeat.m2505o(79572);
                    }
                });
                AppMethodBeat.m2505o(79575);
                return;
            case 3:
                ajg = C14857a.vfA.ajg(c40432m.vdC);
                if (ajg != null) {
                    ajg.field_status = 3;
                    C14857a.vfA.mo27179h(ajg);
                }
                aje = aje(c4715e.awa());
                if (!C5046bo.m7548ek(aje)) {
                    dib = c4715e.dib();
                    this.vfc.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(79571);
                            for (C35790d c35790d : aje) {
                                if (C5046bo.nullAsNil(c35790d.awa()).equals(c40432m.groupId)) {
                                    c35790d.mo9629b(dib, c40432m);
                                }
                            }
                            AppMethodBeat.m2505o(79571);
                        }
                    });
                    break;
                }
                break;
            case 4:
                ajg = C14857a.vfA.ajg(c40432m.vdC);
                if (ajg != null) {
                    ajg.field_status = 4;
                    C14857a.vfA.mo27179h(ajg);
                }
                aje = aje(c4715e.awa());
                if (!C5046bo.m7548ek(aje)) {
                    dib = c4715e.dib();
                    this.vfc.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(79573);
                            for (C35790d c35790d : aje) {
                                if (C5046bo.nullAsNil(c35790d.awa()).equals(c40432m.groupId)) {
                                    c35790d.aeQ(dib);
                                }
                            }
                            AppMethodBeat.m2505o(79573);
                        }
                    });
                }
                AppMethodBeat.m2505o(79575);
                return;
        }
        AppMethodBeat.m2505o(79575);
    }

    /* renamed from: u */
    public final void mo9861u(String str, int i, int i2) {
        AppMethodBeat.m2504i(79576);
        C4990ab.m7417i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        C44049s ajg = C14857a.vfA.ajg(str);
        if (ajg != null) {
            ajg.field_maxRetryTimes = i;
            ajg.field_retryTimes = i2;
            C14857a.vfA.mo27179h(ajg);
        }
        AppMethodBeat.m2505o(79576);
    }

    /* renamed from: a */
    public final void mo9860a(String str, C40431k c40431k) {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo9859a(String str, C35790d c35790d) {
        AppMethodBeat.m2504i(79578);
        C4990ab.m7410d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(c35790d)));
        if (c35790d == null) {
            AppMethodBeat.m2505o(79578);
            return;
        }
        int hashCode = str.hashCode();
        synchronized (this.vfe) {
            try {
                List list = (List) this.vfd.get(hashCode);
                if (list == null) {
                    list = new LinkedList();
                }
                list.add(c35790d);
                this.vfd.put(hashCode, list);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79578);
            }
        }
    }

    private List<C35790d> aje(String str) {
        List<C35790d> list;
        AppMethodBeat.m2504i(79579);
        int hashCode = str.hashCode();
        synchronized (this.vfe) {
            try {
                list = (List) this.vfd.get(hashCode);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(79579);
            }
        }
        return list;
    }

    /* renamed from: w */
    public final void mo9862w(String str, long j) {
        AppMethodBeat.m2504i(79577);
        C44049s ajg = C14857a.vfA.ajg(str);
        if (ajg != null) {
            ajg.field_contentLength = j;
            C14857a.vfA.mo27179h(ajg);
        }
        AppMethodBeat.m2505o(79577);
    }
}
