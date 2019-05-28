package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class fz implements gt, gu {
    private ArrayList<fx> a = new ArrayList();
    private ArrayList<fx> b = new ArrayList();
    private ArrayList<fx> c = new ArrayList();
    private LinkedList<Object> d;
    private b e;
    private int f = 60;
    private a g;
    private long h;
    private boolean i;
    private fv j;

    class b extends Thread {
        private boolean b;
        private boolean c;

        private b() {
        }

        /* synthetic */ b(fz fzVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public synchronized void start() {
            AppMethodBeat.i(98950);
            this.b = true;
            super.start();
            AppMethodBeat.o(98950);
        }

        public synchronized void a() {
            this.c = true;
        }

        public synchronized void b() {
            this.c = false;
        }

        public synchronized void destroy() {
            AppMethodBeat.i(98951);
            this.b = false;
            interrupt();
            AppMethodBeat.o(98951);
        }

        public void run() {
            AppMethodBeat.i(98952);
            while (this.b) {
                if (!this.c) {
                    if (fz.this.g != null) {
                        fz.this.g.a(fx.h);
                    }
                    if (fz.this.i && System.currentTimeMillis() - fz.this.h > 500) {
                        fz.this.i = false;
                        if (fz.this.j != null) {
                            fz.this.j.a();
                        }
                    }
                }
                try {
                    synchronized (this) {
                        wait(fz.this.h());
                    }
                } catch (InterruptedException e) {
                } catch (Throwable th) {
                    AppMethodBeat.o(98952);
                }
            }
            AppMethodBeat.o(98952);
        }
    }

    public interface a {
        void a(fx fxVar);
    }

    public fz(a aVar) {
        AppMethodBeat.i(98953);
        this.g = aVar;
        this.d = new LinkedList();
        fj.a(h());
        AppMethodBeat.o(98953);
    }

    public void a() {
        AppMethodBeat.i(98954);
        if (this.e != null) {
            this.e.destroy();
        }
        this.e = new b(this, null);
        this.e.start();
        AppMethodBeat.o(98954);
    }

    public void b() {
        AppMethodBeat.i(98955);
        if (this.e != null) {
            this.e.destroy();
        }
        AppMethodBeat.o(98955);
    }

    public void c() {
        AppMethodBeat.i(98956);
        if (this.e != null) {
            this.e.a();
        }
        j();
        AppMethodBeat.o(98956);
    }

    public void d() {
        AppMethodBeat.i(98957);
        if (this.e != null) {
            this.e.b();
        }
        AppMethodBeat.o(98957);
    }

    public void a(int i) {
        if (i > 0) {
            this.f = i;
        }
    }

    public void e() {
        this.f = 60;
    }

    public int f() {
        return this.f;
    }

    public void g() {
        if (this.e == null) {
        }
    }

    public long h() {
        long j = 1000 / ((long) this.f);
        if (j == 0) {
            return 1;
        }
        return j;
    }

    public void a(fv fvVar) {
        this.j = fvVar;
    }

    public void a(fx fxVar) {
        AppMethodBeat.i(98958);
        synchronized (this.a) {
            try {
                if (this.a.size() > 200) {
                    this.a.clear();
                }
                this.a.add(fxVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98958);
            }
        }
        i();
    }

    public void i() {
        AppMethodBeat.i(98959);
        synchronized (this.d) {
            try {
                this.d.add(fx.h);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98959);
            }
        }
    }

    public void j() {
        AppMethodBeat.i(98960);
        synchronized (this.a) {
            try {
                this.c.clear();
                this.b.clear();
                Iterator it = this.a.iterator();
                Object obj = null;
                while (it.hasNext()) {
                    fx fxVar = (fx) it.next();
                    if (fxVar.e) {
                        obj = 1;
                        this.b.add(fxVar);
                    } else {
                        this.c.add(fxVar);
                    }
                }
                this.a.clear();
                if (obj != null) {
                    ArrayList arrayList = this.a;
                    this.a = this.b;
                    this.b = arrayList;
                }
                if (this.c.size() > 0) {
                    Iterator it2 = this.c.iterator();
                    while (it2.hasNext()) {
                        ((fx) it2.next()).b();
                    }
                }
            } finally {
                AppMethodBeat.o(98960);
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0022, code skipped:
            if (r0 == null) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:11:0x002a, code skipped:
            if (r0.a(r5.g) == false) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:12:0x002c, code skipped:
            r0.c();
            r2 = r5.a;
     */
    /* JADX WARNING: Missing block: B:13:0x0031, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r5.a.remove(r0);
     */
    /* JADX WARNING: Missing block: B:16:0x0037, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:17:0x0038, code skipped:
            r2 = r5.a;
     */
    /* JADX WARNING: Missing block: B:18:0x003a, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            r0 = r5.a.isEmpty();
     */
    /* JADX WARNING: Missing block: B:21:0x0041, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:22:0x0042, code skipped:
            if (r0 != false) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:31:0x0051, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(98961);
     */
    /* JADX WARNING: Missing block: B:35:0x0057, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(98961);
     */
    /* JADX WARNING: Missing block: B:36:0x005b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(98961);
     */
    /* JADX WARNING: Missing block: B:48:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean k() {
        AppMethodBeat.i(98961);
        synchronized (this.a) {
            try {
                if (this.a.isEmpty()) {
                } else {
                    fx fxVar = (fx) this.a.get(0);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(98961);
            }
        }
        return true;
        return false;
    }

    public void a(gs gsVar) {
        AppMethodBeat.i(98962);
        this.i = true;
        this.h = System.currentTimeMillis();
        AppMethodBeat.o(98962);
    }
}
