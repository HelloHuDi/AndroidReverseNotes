package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.da;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tencentmap.mapsdk.a.w;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ls {
    private iz a = null;
    private lo b = null;
    private lt c = new lt();
    private int d;
    private volatile boolean e = false;

    public ls(iz izVar) {
        AppMethodBeat.i(100469);
        this.a = izVar;
        f();
        AppMethodBeat.o(100469);
    }

    public iz a() {
        return this.a;
    }

    public void b() {
        AppMethodBeat.i(100470);
        a(this.d, w.a(this.a.i()));
        this.a = null;
        this.d = 0;
        AppMethodBeat.o(100470);
    }

    public lo a(lt ltVar) {
        AppMethodBeat.i(100471);
        if (this.a == null) {
            AppMethodBeat.o(100471);
            return null;
        }
        hz loVar = new lo(this, ltVar);
        this.a.a(loVar);
        this.a.b().a();
        this.d = 0;
        AppMethodBeat.o(100471);
        return loVar;
    }

    public boolean c() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(String str) {
        AppMethodBeat.i(100472);
        if (this.a == null) {
            AppMethodBeat.o(100472);
            return;
        }
        this.a.b(str, true);
        this.a.b().a();
        AppMethodBeat.o(100472);
    }

    private void f() {
        AppMethodBeat.i(100473);
        v.c(r.b(this.a.i()) + "/tencentmapsdk/rastermap/unmainland");
        v.c(r.a(this.a.i()).a().getPath() + "/rastermap/taiwan");
        AppMethodBeat.o(100473);
    }

    public void d() {
        AppMethodBeat.i(100474);
        if (this.b != null) {
            this.b.e();
        }
        AppMethodBeat.o(100474);
    }

    public void a(int i) {
        synchronized (ls.class) {
            this.d += i;
        }
    }

    public static void a(final int i, final w wVar) {
        AppMethodBeat.i(100475);
        new Thread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(100468);
                int i = -1;
                if (wVar != null) {
                    i = wVar.b("worldTileCount");
                }
                if (i > 0 || i > 0) {
                    int i2;
                    if (i > 0) {
                        i2 = i + i;
                    } else {
                        i2 = i;
                    }
                    try {
                        i = ((HttpURLConnection) new URL("https://pr.map.qq.com/pingd?" + ic.a(i2)).openConnection()).getResponseCode();
                        if (wVar == null) {
                            AppMethodBeat.o(100468);
                            return;
                        } else if (i == 200) {
                            wVar.a(new String[]{"worldTileCount"});
                            AppMethodBeat.o(100468);
                            return;
                        } else {
                            wVar.a("worldTileCount", i2);
                            AppMethodBeat.o(100468);
                            return;
                        }
                    } catch (IOException e) {
                        if (wVar != null) {
                            wVar.a("worldTileCount", i2);
                        }
                        AppMethodBeat.o(100468);
                        return;
                    }
                }
                AppMethodBeat.o(100468);
            }
        }).start();
        AppMethodBeat.o(100475);
    }

    public void e() {
        AppMethodBeat.i(100476);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100476);
        } else if (this.a.b().h() < 7) {
            g();
            AppMethodBeat.o(100476);
        } else if (!lq.d()) {
            if (this.b != null) {
                g();
            }
            AppMethodBeat.o(100476);
        } else if (a(ln.a().c("china"))) {
            if (this.b != null) {
                g();
            }
            AppMethodBeat.o(100476);
        } else {
            if (this.b == null) {
                h();
            }
            AppMethodBeat.o(100476);
        }
    }

    public void a(da daVar) {
        AppMethodBeat.i(100477);
        this.c.a(daVar);
        AppMethodBeat.o(100477);
    }

    private void g() {
        AppMethodBeat.i(100478);
        if (this.a == null || this.a.b() == null || this.b == null) {
            AppMethodBeat.o(100478);
            return;
        }
        f b = this.a.b();
        a(this.b.A());
        b.g(true);
        b.h(true);
        this.b = null;
        AppMethodBeat.o(100478);
    }

    private void h() {
        AppMethodBeat.i(100479);
        if (this.a == null || this.a.b() == null) {
            AppMethodBeat.o(100479);
            return;
        }
        f b = this.a.b();
        b.g(false);
        b.h(false);
        this.b = a(this.c);
        AppMethodBeat.o(100479);
    }

    private boolean a(b[] bVarArr) {
        AppMethodBeat.i(100480);
        if (this.a == null) {
            AppMethodBeat.o(100480);
            return true;
        }
        b[] R = this.a.R();
        if (R == null || bVarArr == null) {
            AppMethodBeat.o(100480);
            return true;
        }
        boolean a = ln.a(R, bVarArr);
        AppMethodBeat.o(100480);
        return a;
    }
}
