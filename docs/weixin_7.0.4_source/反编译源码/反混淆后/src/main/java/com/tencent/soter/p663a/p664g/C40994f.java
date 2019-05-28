package com.tencent.soter.p663a.p664g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p1106b.C46744e;

/* renamed from: com.tencent.soter.a.g.f */
public class C40994f {
    private static volatile C40994f Awu = null;
    static volatile SparseArray<C44469d> Awv = null;
    final Object Aww = new Object();

    private C40994f() {
        AppMethodBeat.m2504i(10484);
        Awv = new SparseArray(5);
        AppMethodBeat.m2505o(10484);
    }

    public static C40994f dRn() {
        AppMethodBeat.m2504i(10485);
        C40994f c40994f;
        if (Awu == null) {
            synchronized (C40994f.class) {
                try {
                    if (Awu == null) {
                        Awu = new C40994f();
                    }
                    c40994f = Awu;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10485);
                }
            }
            return c40994f;
        }
        c40994f = Awu;
        AppMethodBeat.m2505o(10485);
        return c40994f;
    }

    /* renamed from: a */
    public final boolean mo64934a(final C44469d c44469d, C46744e c46744e) {
        AppMethodBeat.m2504i(10486);
        if (c44469d.dRl()) {
            C44476d.m80482d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
            AppMethodBeat.m2505o(10486);
            return false;
        }
        int hashCode = c44469d.hashCode();
        synchronized (this.Aww) {
            int i = 0;
            while (i < Awv.size()) {
                try {
                    int keyAt = Awv.keyAt(i);
                    if (Awv.get(keyAt) == null || !((C44469d) Awv.get(keyAt)).getClass().getName().equals(c44469d.getClass().getName())) {
                        i++;
                    } else {
                        C44476d.m80486w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                        c46744e.errCode = 26;
                        c46744e.aIm = "add SOTER task to queue failed. check the logcat for further information";
                        c44469d.mo70642b(c46744e);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10486);
                }
            }
            Awv.put(hashCode, c44469d);
            C44472g.dRq().mo70644R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10481);
                    c44469d.execute();
                    AppMethodBeat.m2505o(10481);
                }
            });
            AppMethodBeat.m2505o(10486);
            return true;
        }
        return false;
    }

    public final void dRo() {
        AppMethodBeat.m2504i(10487);
        synchronized (this.Aww) {
            try {
                C44476d.m80484i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
                if (Awv.size() != 0) {
                    for (int i = 0; i < Awv.size(); i++) {
                        final int keyAt = Awv.keyAt(i);
                        C44472g.dRq().mo70644R(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(10482);
                                synchronized (C40994f.this.Aww) {
                                    try {
                                        C44469d c44469d = (C44469d) C40994f.Awv.get(keyAt);
                                        if (c44469d != null) {
                                            c44469d.dRm();
                                        }
                                    } finally {
                                        while (true) {
                                        }
                                        AppMethodBeat.m2505o(10482);
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
                AppMethodBeat.m2505o(10487);
            }
        }
    }

    public final void dRp() {
        AppMethodBeat.m2504i(10488);
        synchronized (this.Aww) {
            try {
                C44476d.m80484i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
                if (Awv.size() != 0) {
                    for (int i = 0; i < Awv.size(); i++) {
                        final int keyAt = Awv.keyAt(i);
                        C44472g.dRq().mo70644R(new Runnable() {
                            public final void run() {
                                C44469d c44469d;
                                AppMethodBeat.m2504i(10483);
                                synchronized (C40994f.this.Aww) {
                                    try {
                                        c44469d = (C44469d) C40994f.Awv.get(keyAt);
                                    } catch (Throwable th) {
                                        while (true) {
                                            AppMethodBeat.m2505o(10483);
                                        }
                                    }
                                }
                                if (!(c44469d == null || !(c44469d instanceof C16169a) || ((C16169a) c44469d).isCancelled())) {
                                    ((C16169a) c44469d).dRk();
                                }
                                AppMethodBeat.m2505o(10483);
                            }
                        });
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(10488);
            }
        }
    }
}
