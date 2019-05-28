package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fz */
public class C46786fz implements C5884gt, C36514gu {
    /* renamed from: a */
    private ArrayList<C31045fx> f18130a = new ArrayList();
    /* renamed from: b */
    private ArrayList<C31045fx> f18131b = new ArrayList();
    /* renamed from: c */
    private ArrayList<C31045fx> f18132c = new ArrayList();
    /* renamed from: d */
    private LinkedList<Object> f18133d;
    /* renamed from: e */
    private C5878b f18134e;
    /* renamed from: f */
    private int f18135f = 60;
    /* renamed from: g */
    private C36510a f18136g;
    /* renamed from: h */
    private long f18137h;
    /* renamed from: i */
    private boolean f18138i;
    /* renamed from: j */
    private C31044fv f18139j;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fz$b */
    class C5878b extends Thread {
        /* renamed from: b */
        private boolean f1599b;
        /* renamed from: c */
        private boolean f1600c;

        private C5878b() {
        }

        /* synthetic */ C5878b(C46786fz c46786fz, C162311 c162311) {
            this();
        }

        public synchronized void start() {
            AppMethodBeat.m2504i(98950);
            this.f1599b = true;
            super.start();
            AppMethodBeat.m2505o(98950);
        }

        /* renamed from: a */
        public synchronized void mo12449a() {
            this.f1600c = true;
        }

        /* renamed from: b */
        public synchronized void mo12450b() {
            this.f1600c = false;
        }

        public synchronized void destroy() {
            AppMethodBeat.m2504i(98951);
            this.f1599b = false;
            interrupt();
            AppMethodBeat.m2505o(98951);
        }

        public void run() {
            AppMethodBeat.m2504i(98952);
            while (this.f1599b) {
                if (!this.f1600c) {
                    if (C46786fz.this.f18136g != null) {
                        C46786fz.this.f18136g.mo57736a(C31045fx.f14122h);
                    }
                    if (C46786fz.this.f18138i && System.currentTimeMillis() - C46786fz.this.f18137h > 500) {
                        C46786fz.this.f18138i = false;
                        if (C46786fz.this.f18139j != null) {
                            C46786fz.this.f18139j.mo29059a();
                        }
                    }
                }
                try {
                    synchronized (this) {
                        wait(C46786fz.this.mo75379h());
                    }
                } catch (InterruptedException e) {
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(98952);
                }
            }
            AppMethodBeat.m2505o(98952);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.fz$a */
    public interface C36510a {
        /* renamed from: a */
        void mo57736a(C31045fx c31045fx);
    }

    public C46786fz(C36510a c36510a) {
        AppMethodBeat.m2504i(98953);
        this.f18136g = c36510a;
        this.f18133d = new LinkedList();
        C36506fj.m60388a(mo75379h());
        AppMethodBeat.m2505o(98953);
    }

    /* renamed from: a */
    public void mo75369a() {
        AppMethodBeat.m2504i(98954);
        if (this.f18134e != null) {
            this.f18134e.destroy();
        }
        this.f18134e = new C5878b(this, null);
        this.f18134e.start();
        AppMethodBeat.m2505o(98954);
    }

    /* renamed from: b */
    public void mo75373b() {
        AppMethodBeat.m2504i(98955);
        if (this.f18134e != null) {
            this.f18134e.destroy();
        }
        AppMethodBeat.m2505o(98955);
    }

    /* renamed from: c */
    public void mo75374c() {
        AppMethodBeat.m2504i(98956);
        if (this.f18134e != null) {
            this.f18134e.mo12449a();
        }
        mo75381j();
        AppMethodBeat.m2505o(98956);
    }

    /* renamed from: d */
    public void mo75375d() {
        AppMethodBeat.m2504i(98957);
        if (this.f18134e != null) {
            this.f18134e.mo12450b();
        }
        AppMethodBeat.m2505o(98957);
    }

    /* renamed from: a */
    public void mo75370a(int i) {
        if (i > 0) {
            this.f18135f = i;
        }
    }

    /* renamed from: e */
    public void mo75376e() {
        this.f18135f = 60;
    }

    /* renamed from: f */
    public int mo75377f() {
        return this.f18135f;
    }

    /* renamed from: g */
    public void mo75378g() {
        if (this.f18134e == null) {
        }
    }

    /* renamed from: h */
    public long mo75379h() {
        long j = 1000 / ((long) this.f18135f);
        if (j == 0) {
            return 1;
        }
        return j;
    }

    /* renamed from: a */
    public void mo75371a(C31044fv c31044fv) {
        this.f18139j = c31044fv;
    }

    /* renamed from: a */
    public void mo75372a(C31045fx c31045fx) {
        AppMethodBeat.m2504i(98958);
        synchronized (this.f18130a) {
            try {
                if (this.f18130a.size() > 200) {
                    this.f18130a.clear();
                }
                this.f18130a.add(c31045fx);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98958);
            }
        }
        mo75380i();
    }

    /* renamed from: i */
    public void mo75380i() {
        AppMethodBeat.m2504i(98959);
        synchronized (this.f18133d) {
            try {
                this.f18133d.add(C31045fx.f14122h);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98959);
            }
        }
    }

    /* renamed from: j */
    public void mo75381j() {
        AppMethodBeat.m2504i(98960);
        synchronized (this.f18130a) {
            try {
                this.f18132c.clear();
                this.f18131b.clear();
                Iterator it = this.f18130a.iterator();
                Object obj = null;
                while (it.hasNext()) {
                    C31045fx c31045fx = (C31045fx) it.next();
                    if (c31045fx.f14128e) {
                        obj = 1;
                        this.f18131b.add(c31045fx);
                    } else {
                        this.f18132c.add(c31045fx);
                    }
                }
                this.f18130a.clear();
                if (obj != null) {
                    ArrayList arrayList = this.f18130a;
                    this.f18130a = this.f18131b;
                    this.f18131b = arrayList;
                }
                if (this.f18132c.size() > 0) {
                    Iterator it2 = this.f18132c.iterator();
                    while (it2.hasNext()) {
                        ((C31045fx) it2.next()).mo29422b();
                    }
                }
            } finally {
                AppMethodBeat.m2505o(98960);
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0022, code skipped:
            if (r0 == null) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:11:0x002a, code skipped:
            if (r0.mo50369a(r5.f18136g) == false) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:12:0x002c, code skipped:
            r0.mo50370c();
            r2 = r5.f18130a;
     */
    /* JADX WARNING: Missing block: B:13:0x0031, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r5.f18130a.remove(r0);
     */
    /* JADX WARNING: Missing block: B:16:0x0037, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:17:0x0038, code skipped:
            r2 = r5.f18130a;
     */
    /* JADX WARNING: Missing block: B:18:0x003a, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            r0 = r5.f18130a.isEmpty();
     */
    /* JADX WARNING: Missing block: B:21:0x0041, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:22:0x0042, code skipped:
            if (r0 != false) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:31:0x0051, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(98961);
     */
    /* JADX WARNING: Missing block: B:35:0x0057, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(98961);
     */
    /* JADX WARNING: Missing block: B:36:0x005b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(98961);
     */
    /* JADX WARNING: Missing block: B:48:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    public boolean mo75382k() {
        AppMethodBeat.m2504i(98961);
        synchronized (this.f18130a) {
            try {
                if (this.f18130a.isEmpty()) {
                } else {
                    C31045fx c31045fx = (C31045fx) this.f18130a.get(0);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(98961);
            }
        }
        return true;
        return false;
    }

    /* renamed from: a */
    public void mo12476a(C24382gs c24382gs) {
        AppMethodBeat.m2504i(98962);
        this.f18138i = true;
        this.f18137h = System.currentTimeMillis();
        AppMethodBeat.m2505o(98962);
    }
}
