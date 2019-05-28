package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class t {
    private static t c = null;
    protected v a = null;
    protected Context b = null;
    private boolean d = false;
    private int e = 0;
    private bd f = null;
    private Runnable g = null;
    private List<s> h = new ArrayList(5);
    private SparseArray<be> i = new SparseArray(5);
    private List<w> j = new ArrayList(5);
    private SparseArray<x> k = new SparseArray(2);
    private boolean l = false;
    private Runnable m = new Runnable() {
        public final void run() {
            AppMethodBeat.i(100542);
            if (!(t.this.b == null || t.this.a == null)) {
                t.this.a.a(t.this.b);
            }
            AppMethodBeat.o(100542);
        }
    };

    public static synchronized t a(Context context) {
        t tVar;
        synchronized (t.class) {
            AppMethodBeat.i(100545);
            if (c == null && context != null) {
                c = new t(context);
            }
            tVar = c;
            AppMethodBeat.o(100545);
        }
        return tVar;
    }

    public final synchronized boolean a() {
        return this.l;
    }

    public final synchronized void b() {
        this.l = true;
    }

    public static synchronized be c() {
        be k;
        synchronized (t.class) {
            AppMethodBeat.i(100546);
            if (c != null) {
                k = c.k();
                AppMethodBeat.o(100546);
            } else {
                k = null;
                AppMethodBeat.o(100546);
            }
        }
        return k;
    }

    private t(Context context) {
        AppMethodBeat.i(100547);
        this.b = context;
        this.a = v.a();
        b.a().a(this.m);
        this.f = new bd(context);
        this.g = new u(context);
        b.a().a(this.g);
        AppMethodBeat.o(100547);
    }

    public final synchronized Runnable d() {
        return this.g;
    }

    public final synchronized v e() {
        return this.a;
    }

    private synchronized be k() {
        be beVar;
        AppMethodBeat.i(100548);
        if (this.i == null || this.i.size() <= 0) {
            beVar = null;
            AppMethodBeat.o(100548);
        } else {
            beVar = (be) this.i.get(0);
            AppMethodBeat.o(100548);
        }
        return beVar;
    }

    public final synchronized void a(int i, be beVar) {
        AppMethodBeat.i(100549);
        if (this.i != null) {
            if (beVar == null) {
                this.i.remove(i);
                AppMethodBeat.o(100549);
            } else {
                this.i.put(i, beVar);
                beVar.a(f());
            }
        }
        AppMethodBeat.o(100549);
    }

    public final synchronized bd f() {
        return this.f;
    }

    public final synchronized boolean g() {
        return this.d;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void h() {
        AppMethodBeat.i(100550);
        this.d = true;
        ag.f("isFirst }%b", Boolean.TRUE);
        AppMethodBeat.o(100550);
    }

    public final synchronized s[] i() {
        s[] sVarArr;
        AppMethodBeat.i(100551);
        if (this.h == null || this.h.size() <= 0) {
            sVarArr = null;
            AppMethodBeat.o(100551);
        } else {
            sVarArr = (s[]) this.h.toArray(new s[0]);
            AppMethodBeat.o(100551);
        }
        return sVarArr;
    }

    private synchronized w[] l() {
        w[] wVarArr;
        AppMethodBeat.i(100552);
        if (this.j == null || this.j.size() <= 0) {
            wVarArr = null;
            AppMethodBeat.o(100552);
        } else {
            wVarArr = (w[]) this.j.toArray(new w[0]);
            AppMethodBeat.o(100552);
        }
        return wVarArr;
    }

    public final synchronized int j() {
        return this.e;
    }

    public final synchronized void a(int i) {
        AppMethodBeat.i(100553);
        this.e = i;
        ag.f("step:%d", Integer.valueOf(i));
        AppMethodBeat.o(100553);
    }

    public final synchronized void a(final s sVar) {
        AppMethodBeat.i(100554);
        if (sVar == null) {
            AppMethodBeat.o(100554);
        } else {
            if (this.h == null) {
                this.h = new ArrayList();
            }
            if (!this.h.contains(sVar)) {
                this.h.add(sVar);
                final int j = j();
                if (g()) {
                    ag.e("add listener should notify app first run! %s", sVar.toString());
                    b.a().a(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(100543);
                            sVar.c();
                            AppMethodBeat.o(100543);
                        }
                    });
                }
                if (j >= 2) {
                    ag.e("add listener should notify app start query! %s", sVar.toString());
                    b.a().a(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(100544);
                            sVar.a();
                            if (j >= 3) {
                                ag.e("query finished should notify", new Object[0]);
                                sVar.b();
                            }
                            AppMethodBeat.o(100544);
                        }
                    });
                }
            }
            AppMethodBeat.o(100554);
        }
    }

    public final synchronized void a(w wVar) {
        AppMethodBeat.i(100555);
        if (!(wVar == null || this.j == null || this.j.contains(wVar))) {
            this.j.add(wVar);
        }
        AppMethodBeat.o(100555);
    }

    public final synchronized void a(x xVar) {
        AppMethodBeat.i(100556);
        if (!(xVar == null || this.k == null)) {
            this.k.put(1, xVar);
        }
        AppMethodBeat.o(100556);
    }

    private synchronized SparseArray<x> m() {
        return this.k;
    }

    public final void a(v vVar) {
        AppMethodBeat.i(100557);
        w[] l = l();
        if (l != null) {
            for (w a : l) {
                try {
                    a.a(vVar);
                } catch (Throwable th) {
                    ag.a(th);
                    ag.d("com strategy changed error %s", th.toString());
                }
            }
        }
        AppMethodBeat.o(100557);
    }

    public final void a(int i, Map<String, String> map) {
        AppMethodBeat.i(100558);
        SparseArray m = m();
        if (m != null) {
            x xVar = (x) m.get(i);
            if (xVar != null) {
                xVar.a(map);
            }
        }
        AppMethodBeat.o(100558);
    }
}
