package com.tencent.mm.pluginsdk.g.a.c;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class i implements c {
    private final ak vfc;
    public final SparseArray<List<d>> vfd = new SparseArray();
    public final Object vfe = new Object();

    i(ak akVar) {
        AppMethodBeat.i(79574);
        this.vfc = akVar;
        AppMethodBeat.o(79574);
    }

    public final void a(e eVar, final m mVar) {
        AppMethodBeat.i(79575);
        ab.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = ".concat(String.valueOf(mVar)));
        s ajg;
        final List aje;
        final String dib;
        switch (mVar.status) {
            case 2:
                ajg = a.vfA.ajg(mVar.vdC);
                if (ajg != null) {
                    ajg.field_status = 2;
                    a.vfA.h(ajg);
                }
                ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + eVar.awa());
                aje = aje(eVar.awa());
                if (bo.ek(aje)) {
                    ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    AppMethodBeat.o(79575);
                    return;
                }
                ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + aje.size());
                dib = eVar.dib();
                this.vfc.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(79572);
                        for (d dVar : aje) {
                            if (bo.nullAsNil(dVar.awa()).equals(mVar.groupId)) {
                                dVar.a(dib, mVar);
                            }
                        }
                        AppMethodBeat.o(79572);
                    }
                });
                AppMethodBeat.o(79575);
                return;
            case 3:
                ajg = a.vfA.ajg(mVar.vdC);
                if (ajg != null) {
                    ajg.field_status = 3;
                    a.vfA.h(ajg);
                }
                aje = aje(eVar.awa());
                if (!bo.ek(aje)) {
                    dib = eVar.dib();
                    this.vfc.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(79571);
                            for (d dVar : aje) {
                                if (bo.nullAsNil(dVar.awa()).equals(mVar.groupId)) {
                                    dVar.b(dib, mVar);
                                }
                            }
                            AppMethodBeat.o(79571);
                        }
                    });
                    break;
                }
                break;
            case 4:
                ajg = a.vfA.ajg(mVar.vdC);
                if (ajg != null) {
                    ajg.field_status = 4;
                    a.vfA.h(ajg);
                }
                aje = aje(eVar.awa());
                if (!bo.ek(aje)) {
                    dib = eVar.dib();
                    this.vfc.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(79573);
                            for (d dVar : aje) {
                                if (bo.nullAsNil(dVar.awa()).equals(mVar.groupId)) {
                                    dVar.aeQ(dib);
                                }
                            }
                            AppMethodBeat.o(79573);
                        }
                    });
                }
                AppMethodBeat.o(79575);
                return;
        }
        AppMethodBeat.o(79575);
    }

    public final void u(String str, int i, int i2) {
        AppMethodBeat.i(79576);
        ab.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        s ajg = a.vfA.ajg(str);
        if (ajg != null) {
            ajg.field_maxRetryTimes = i;
            ajg.field_retryTimes = i2;
            a.vfA.h(ajg);
        }
        AppMethodBeat.o(79576);
    }

    public final void a(String str, k kVar) {
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, d dVar) {
        AppMethodBeat.i(79578);
        ab.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(dVar)));
        if (dVar == null) {
            AppMethodBeat.o(79578);
            return;
        }
        int hashCode = str.hashCode();
        synchronized (this.vfe) {
            try {
                List list = (List) this.vfd.get(hashCode);
                if (list == null) {
                    list = new LinkedList();
                }
                list.add(dVar);
                this.vfd.put(hashCode, list);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79578);
            }
        }
    }

    private List<d> aje(String str) {
        List<d> list;
        AppMethodBeat.i(79579);
        int hashCode = str.hashCode();
        synchronized (this.vfe) {
            try {
                list = (List) this.vfd.get(hashCode);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(79579);
            }
        }
        return list;
    }

    public final void w(String str, long j) {
        AppMethodBeat.i(79577);
        s ajg = a.vfA.ajg(str);
        if (ajg != null) {
            ajg.field_contentLength = j;
            a.vfA.h(ajg);
        }
        AppMethodBeat.o(79577);
    }
}
