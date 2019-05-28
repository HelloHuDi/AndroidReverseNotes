package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tencentmap.mapsdk.a.b;
import com.tencent.tencentmap.mapsdk.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class aw implements au {
    private boolean a = false;
    private List<av> b;
    private Context c;
    private Runnable d = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98510);
            try {
                aw.this.a();
                AppMethodBeat.o(98510);
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(98510);
            }
        }
    };
    private Runnable e = new Runnable() {
        public final void run() {
            AppMethodBeat.i(98511);
            aw.a(aw.this);
            AppMethodBeat.o(98511);
        }
    };

    static class a extends az {
        private List<av> e = null;
        private Context f;
        private Long[] g = null;
        private boolean h = false;

        public a(Context context, List<av> list) {
            super(context, 1, 2);
            AppMethodBeat.i(98512);
            this.e = list;
            this.f = context;
            this.e.size();
            if (this.e.size() == 1 && "rqd_heartbeat".equals(((av) this.e.get(0)).d())) {
                this.h = true;
            }
            this.d = e.b(context, 2);
            ag.a("real rid:%s", this.d);
            AppMethodBeat.o(98512);
        }

        public final synchronized aa a() {
            aa aaVar;
            AppMethodBeat.i(98513);
            ag.b(" TUUD.GetUD start", new Object[0]);
            if (this.e == null || this.e.size() <= 0) {
                AppMethodBeat.o(98513);
                aaVar = null;
            } else {
                try {
                    aaVar = a(this.a, this.e);
                    if (aaVar != null) {
                        AppMethodBeat.o(98513);
                    }
                } catch (Throwable th) {
                    ag.a(th);
                    ag.d(" TUUD.GetUD start error", new Object[0]);
                }
                AppMethodBeat.o(98513);
                aaVar = null;
            }
            return aaVar;
        }

        private static aa a(int i, List<av> list) {
            aa aaVar = null;
            AppMethodBeat.i(98514);
            if (list == null || list.size() <= 0) {
                AppMethodBeat.o(98514);
            } else {
                try {
                    ag.b(" current size:" + list.size(), new Object[0]);
                    ad a = a(list);
                    if (a == null) {
                        AppMethodBeat.o(98514);
                    } else {
                        byte[] a2 = a.a();
                        if (a2 == null) {
                            AppMethodBeat.o(98514);
                        } else {
                            aaVar = az.a(i, a2);
                            AppMethodBeat.o(98514);
                        }
                    }
                } catch (Throwable th) {
                    ag.a(th);
                    ag.d(" RealTimeRecordUploadDatas.encode2EventRecordPackage error}", new Object[0]);
                    AppMethodBeat.o(98514);
                }
            }
            return aaVar;
        }

        private static ad a(List<av> list) {
            AppMethodBeat.i(98515);
            if (list == null || list.size() <= 0) {
                AppMethodBeat.o(98515);
                return null;
            }
            try {
                ad adVar = new ad();
                ArrayList arrayList = new ArrayList();
                for (av a : list) {
                    ac a2 = e.a(a);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                adVar.a = arrayList;
                ag.b(" RealTimeRecordUploadDatas.encode2EventRecordPackage() end}", new Object[0]);
                AppMethodBeat.o(98515);
                return adVar;
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(98515);
                return null;
            }
        }

        public final synchronized void b(boolean z) {
            AppMethodBeat.i(98516);
            ag.b(" TimeUpUploadDatas.done(), result:%b", Boolean.valueOf(z));
            if (!(this.e == null || z)) {
                ag.f(" upload failed, save to db", new Object[0]);
                if (!this.h) {
                    this.g = e.a(this.f, this.e);
                    this.e = null;
                }
            }
            if (z && this.h) {
                Context context = this.f;
                b.a().a(108);
                com.tencent.tencentmap.mapsdk.a.a.a(context, "HEART_DENGTA", e.g());
                ag.a("heartbeat uploaded sucess!", new Object[0]);
            }
            if (z && this.g != null) {
                e.a(this.f, this.g);
            }
            if (z && this.g == null && this.e != null) {
                this.e = null;
            }
            AppMethodBeat.o(98516);
        }
    }

    public aw(Context context) {
        AppMethodBeat.i(98517);
        this.c = context;
        this.b = Collections.synchronizedList(new ArrayList(25));
        AppMethodBeat.o(98517);
    }

    public final synchronized boolean a(av avVar) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(98518);
            String str = " BF eN:%s   isRT:%b";
            Object[] objArr = new Object[2];
            objArr[0] = avVar == null ? BuildConfig.COMMAND : avVar.d();
            objArr[1] = Boolean.TRUE;
            ag.f(str, objArr);
            if (this.c == null || avVar == null) {
                ag.c("processUA return false, context is null or bean is null !", new Object[0]);
                AppMethodBeat.o(98518);
            } else if (c()) {
                as g = ax.d().g();
                int a = g.a();
                long b = (long) (g.b() * 1000);
                if (this.b.size() >= a || avVar.f()) {
                    ag.f(" BF mN!", new Object[0]);
                    b.a().a(this.d);
                    b.a().a(103, this.d, b, b);
                }
                this.b.add(avVar);
                if (this.b.size() >= a) {
                    ag.c(" err BF 3R! num:" + this.b.size(), new Object[0]);
                }
                if ("rqd_applaunched".equals(avVar.d())) {
                    b.a().a(this.d);
                }
                ag.a("processUA:true!", new Object[0]);
                AppMethodBeat.o(98518);
                z = true;
            } else {
                ag.c("processUA return false, isEnable is false !", new Object[0]);
                AppMethodBeat.o(98518);
            }
        }
        return z;
    }

    private synchronized List<av> b() {
        List<av> list;
        AppMethodBeat.i(98519);
        if (this.b == null || this.b.size() <= 0 || !c()) {
            list = null;
            AppMethodBeat.o(98519);
        } else {
            list = new ArrayList();
            list.addAll(this.b);
            this.b.clear();
            ag.b(" get realEventCnt in Mem:" + list.size(), new Object[0]);
            AppMethodBeat.o(98519);
        }
        return list;
    }

    private synchronized boolean c() {
        return this.a;
    }

    public final synchronized void a(boolean z) {
        AppMethodBeat.i(98520);
        if (this.a != z) {
            if (z) {
                this.a = z;
                b.a().a(103, this.d, 5000, (long) (ax.d().g().b() * 1000));
                AppMethodBeat.o(98520);
            } else {
                b.a().a(103);
                b(true);
                this.a = z;
            }
        }
        AppMethodBeat.o(98520);
    }

    public final synchronized void b(boolean z) {
        AppMethodBeat.i(98521);
        ag.e("realtime process flush memory objects to db.", new Object[0]);
        if (z) {
            d();
            AppMethodBeat.o(98521);
        } else {
            b.a().a(this.e);
            AppMethodBeat.o(98521);
        }
    }

    private void d() {
        AppMethodBeat.i(98522);
        List b = b();
        if (b != null && b.size() > 0) {
            ag.f(" dsb real events 2 db" + b.size(), new Object[0]);
            e.a(this.c, b);
        }
        AppMethodBeat.o(98522);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        AppMethodBeat.i(98523);
        if (c()) {
            List b = b();
            if (b != null && b.size() > 0) {
                be f = ax.d().f();
                if (!e.m(this.c) || f == null) {
                    ag.f(" dsu real events 2 db" + b.size(), new Object[0]);
                    e.a(this.c, b);
                    AppMethodBeat.o(98523);
                    return;
                }
                ag.f(" dsu real events 2 up " + b.size(), new Object[0]);
                f.a(new a(this.c, b));
            }
            AppMethodBeat.o(98523);
            return;
        }
        ag.c(" err su 1R", new Object[0]);
        AppMethodBeat.o(98523);
    }
}
