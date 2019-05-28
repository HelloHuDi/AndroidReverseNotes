package com.tencent.soter.a.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.b.e;
import com.tencent.soter.core.c.d;

public class f {
    private static volatile f Awu = null;
    static volatile SparseArray<d> Awv = null;
    final Object Aww = new Object();

    private f() {
        AppMethodBeat.i(10484);
        Awv = new SparseArray(5);
        AppMethodBeat.o(10484);
    }

    public static f dRn() {
        AppMethodBeat.i(10485);
        f fVar;
        if (Awu == null) {
            synchronized (f.class) {
                try {
                    if (Awu == null) {
                        Awu = new f();
                    }
                    fVar = Awu;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10485);
                }
            }
            return fVar;
        }
        fVar = Awu;
        AppMethodBeat.o(10485);
        return fVar;
    }

    public final boolean a(final d dVar, e eVar) {
        AppMethodBeat.i(10486);
        if (dVar.dRl()) {
            d.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
            AppMethodBeat.o(10486);
            return false;
        }
        int hashCode = dVar.hashCode();
        synchronized (this.Aww) {
            int i = 0;
            while (i < Awv.size()) {
                try {
                    int keyAt = Awv.keyAt(i);
                    if (Awv.get(keyAt) == null || !((d) Awv.get(keyAt)).getClass().getName().equals(dVar.getClass().getName())) {
                        i++;
                    } else {
                        d.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                        eVar.errCode = 26;
                        eVar.aIm = "add SOTER task to queue failed. check the logcat for further information";
                        dVar.b(eVar);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10486);
                }
            }
            Awv.put(hashCode, dVar);
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10481);
                    dVar.execute();
                    AppMethodBeat.o(10481);
                }
            });
            AppMethodBeat.o(10486);
            return true;
        }
        return false;
    }

    public final void dRo() {
        AppMethodBeat.i(10487);
        synchronized (this.Aww) {
            try {
                d.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
                if (Awv.size() != 0) {
                    for (int i = 0; i < Awv.size(); i++) {
                        final int keyAt = Awv.keyAt(i);
                        g.dRq().R(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(10482);
                                synchronized (f.this.Aww) {
                                    try {
                                        d dVar = (d) f.Awv.get(keyAt);
                                        if (dVar != null) {
                                            dVar.dRm();
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.o(10482);
                                    }
                                }
                            }
                        });
                    }
                }
                Awv.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(10487);
            }
        }
    }

    public final void dRp() {
        AppMethodBeat.i(10488);
        synchronized (this.Aww) {
            try {
                d.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
                if (Awv.size() != 0) {
                    for (int i = 0; i < Awv.size(); i++) {
                        final int keyAt = Awv.keyAt(i);
                        g.dRq().R(new Runnable() {
                            public final void run() {
                                d dVar;
                                AppMethodBeat.i(10483);
                                synchronized (f.this.Aww) {
                                    try {
                                        dVar = (d) f.Awv.get(keyAt);
                                    } catch (Throwable th) {
                                        while (true) {
                                            AppMethodBeat.o(10483);
                                        }
                                    }
                                }
                                if (!(dVar == null || !(dVar instanceof a) || ((a) dVar).isCancelled())) {
                                    ((a) dVar).dRk();
                                }
                                AppMethodBeat.o(10483);
                            }
                        });
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(10488);
            }
        }
    }
}
