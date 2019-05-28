package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.e;
import java.util.ArrayList;
import java.util.List;

public final class ao implements au {
    private Context a;
    private boolean b = false;
    private Object c = new Object();
    private Object d = new Object();
    private Object e = new Object();
    private List<av> f;
    private long g = 60000;
    private Runnable h = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98484);
            ao.this.a();
            AppMethodBeat.o(98484);
        }
    };
    private Runnable i = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98485);
            ao.a(ao.this);
            AppMethodBeat.o(98485);
        }
    };
    private Runnable j = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98486);
            ag.f(" db events to up", new Object[0]);
            try {
                ax.a(false);
                AppMethodBeat.o(98486);
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(98486);
            }
        }
    };

    public ao(Context context) {
        AppMethodBeat.i(98487);
        this.a = context;
        this.f = new ArrayList(25);
        AppMethodBeat.o(98487);
    }

    private synchronized List<av> b() {
        List<av> list;
        AppMethodBeat.i(98488);
        if (this.f == null || this.f.size() <= 0 || !d()) {
            list = null;
            AppMethodBeat.o(98488);
        } else {
            list = new ArrayList();
            list.addAll(this.f);
            this.f.clear();
            ag.b(" get MN:" + list.size(), new Object[0]);
            AppMethodBeat.o(98488);
        }
        return list;
    }

    public final boolean a(av avVar) {
        AppMethodBeat.i(98489);
        synchronized (this.c) {
            try {
                String str = " BF eN:%s   isRT:%b ";
                Object[] objArr = new Object[2];
                objArr[0] = avVar == null ? BuildConfig.COMMAND : avVar.d();
                objArr[1] = Boolean.FALSE;
                ag.f(str, objArr);
                if (this.a == null || avVar == null || !this.b) {
                    ag.d(" err BF 1R", new Object[0]);
                } else if (d()) {
                    as g = ax.d().g();
                    int c = g.c();
                    this.g = (long) (g.d() * 1000);
                    int size = this.f.size();
                    if (size >= c) {
                        ag.f(" BF mN!", new Object[0]);
                        b.a().a(this.h);
                        b.a().a(102, this.h, this.g, this.g);
                    }
                    this.f.add(avVar);
                    if (this.f.size() >= c) {
                        ag.c(" err BF 3R! list size:".concat(String.valueOf(size)), new Object[0]);
                    }
                    ag.a("CommonprocessUA:true!", new Object[0]);
                    AppMethodBeat.o(98489);
                    return true;
                } else {
                    ag.d(" CommonProcess processUA return false, isEnable is false !", new Object[0]);
                    AppMethodBeat.o(98489);
                    return false;
                }
            } finally {
                AppMethodBeat.o(98489);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:27:0x009b, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(98490);
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        boolean z = false;
        AppMethodBeat.i(98490);
        synchronized (this.d) {
            try {
                if (d()) {
                    List b = b();
                    if (b == null || b.size() <= 0) {
                        as g = ax.d().g();
                        if (g != null) {
                            z = g.g();
                        }
                        if (z) {
                            this.j.run();
                            ag.e(" common polling up", new Object[0]);
                        }
                    } else {
                        Long[] a = e.a(this.a, b);
                        bf a2 = bf.a(this.a);
                        if (a != null) {
                            long e = (long) ax.d().g().e();
                            if (e.l(this.a)) {
                                ag.e(" onwifi, so half mSZ ".concat(String.valueOf(e)), new Object[0]);
                                e /= 2;
                            }
                            int j = e.j(this.a);
                            ag.b("countCommomRecordNum: ".concat(String.valueOf(j)), new Object[0]);
                            if (((long) j) >= e) {
                                z = true;
                            }
                            if (z && a2.a() && a2.b()) {
                                this.j.run();
                                ag.e(" common max up", new Object[0]);
                            }
                        }
                    }
                } else {
                    ag.c(" err su 1R", new Object[0]);
                }
            } finally {
                AppMethodBeat.o(98490);
            }
        }
    }

    /* JADX WARNING: Missing block: B:14:0x002f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(98491);
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        AppMethodBeat.i(98491);
        synchronized (this.e) {
            try {
                if (d()) {
                    List b = b();
                    if (b != null && b.size() > 0) {
                        e.a(this.a, b);
                    }
                } else {
                    ag.c(" err su 1R", new Object[0]);
                }
            } finally {
                AppMethodBeat.o(98491);
            }
        }
    }

    private synchronized boolean d() {
        return this.b;
    }

    public final synchronized void a(boolean z) {
        AppMethodBeat.i(98492);
        if (this.b != z) {
            if (z) {
                this.b = z;
                this.g = (long) (ax.d().g().d() * 1000);
                b.a().a(102, this.h, this.g, this.g);
                AppMethodBeat.o(98492);
            } else {
                b.a().a(102);
                b.a().a(112);
                b(true);
                this.b = z;
            }
        }
        AppMethodBeat.o(98492);
    }

    public final synchronized void b(boolean z) {
        AppMethodBeat.i(98493);
        ag.e("common process flush memory objects to db.", new Object[0]);
        if (z) {
            c();
            AppMethodBeat.o(98493);
        } else {
            b.a().a(this.i);
            AppMethodBeat.o(98493);
        }
    }
}
