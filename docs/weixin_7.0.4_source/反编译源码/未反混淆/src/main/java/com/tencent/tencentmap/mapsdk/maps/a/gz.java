package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import navsns.RttRequest;
import navsns.user_login_t;

public class gz extends Thread {
    private gm a = null;
    private hf b = null;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private List<Object> f;

    class a {
        public int a;
        public int b;

        private a() {
        }
    }

    public gz(gm gmVar, hf hfVar) {
        AppMethodBeat.i(99503);
        this.a = gmVar;
        this.b = hfVar;
        this.f = new ArrayList();
        AppMethodBeat.o(99503);
    }

    public void run() {
        AppMethodBeat.i(99504);
        super.run();
        while (!this.e) {
            if (!this.d) {
                if (this.a == null) {
                    AppMethodBeat.o(99504);
                    return;
                } else {
                    d();
                    this.a.w();
                }
            }
            try {
                synchronized (this) {
                    if (this.c) {
                        wait(500);
                        this.c = false;
                    } else {
                        wait(30000);
                    }
                }
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                AppMethodBeat.o(99504);
            }
        }
        AppMethodBeat.o(99504);
    }

    public void a() {
        AppMethodBeat.i(99505);
        this.d = true;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99505);
            }
        }
    }

    public void b() {
        AppMethodBeat.i(99506);
        this.d = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99506);
            }
        }
    }

    public void c() {
        AppMethodBeat.i(99507);
        this.e = true;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(99507);
            }
        }
        interrupt();
    }

    private void d() {
        AppMethodBeat.i(99508);
        if (this.a == null) {
            AppMethodBeat.o(99508);
            return;
        }
        e();
        byte[] f = f();
        if (f != null && f.length > 0) {
            this.a.i().a(f, f.length, true, false);
        }
        AppMethodBeat.o(99508);
    }

    private void e() {
        AppMethodBeat.i(99509);
        int m = this.a.a().m();
        Rect y = this.a.a().y();
        double d = (double) (((float) y.right) / 1000000.0f);
        double d2 = (double) (((float) y.top) / 1000000.0f);
        a a = a((double) (((float) y.left) / 1000000.0f), (double) (((float) y.bottom) / 1000000.0f));
        a a2 = a(d, d2);
        this.a.i().a(m, Math.min(a.a, a2.a), Math.min(a.b, a2.b), Math.max(a2.a, a.a), Math.max(a2.b, a.b));
        AppMethodBeat.o(99509);
    }

    private byte[] f() {
        AppMethodBeat.i(99510);
        if (this.a == null) {
            AppMethodBeat.o(99510);
            return null;
        }
        RttRequest g = g();
        if (g == null) {
            AppMethodBeat.o(99510);
            return null;
        }
        byte[] a = this.b.a(a(g));
        AppMethodBeat.o(99510);
        return a;
    }

    private byte[] a(RttRequest rttRequest) {
        AppMethodBeat.i(99511);
        user_login_t user_login_t = new user_login_t();
        user_login_t.pf = "android_sdk";
        user_login_t.is_login = false;
        user_login_t.channel = "";
        user_login_t.imei = ic.a();
        e eVar = new e();
        eVar.c("rttserverex");
        eVar.d("getRtt");
        eVar.a("info", user_login_t);
        eVar.a("req", rttRequest);
        byte[] a = eVar.a();
        AppMethodBeat.o(99511);
        return a;
    }

    private RttRequest g() {
        RttRequest rttRequest = null;
        AppMethodBeat.i(99512);
        if (this.a == null) {
            AppMethodBeat.o(99512);
        } else {
            TrafficRequestItem[] h = this.a.i().h();
            if (h == null || h.length == 0) {
                AppMethodBeat.o(99512);
            } else {
                rttRequest = new RttRequest();
                ArrayList arrayList = new ArrayList();
                for (TrafficRequestItem trafficRequestItem : h) {
                    arrayList.add(Integer.valueOf(trafficRequestItem.left));
                    arrayList.add(Integer.valueOf(trafficRequestItem.top));
                    arrayList.add(Integer.valueOf(trafficRequestItem.right));
                    arrayList.add(Integer.valueOf(trafficRequestItem.bottom));
                    arrayList.add(Integer.valueOf(trafficRequestItem.timestamp));
                }
                rttRequest.bounds = arrayList;
                rttRequest.zip = (short) 1;
                rttRequest.zoom = (short) h[0].level;
                AppMethodBeat.o(99512);
            }
        }
        return rttRequest;
    }

    private a a(double d, double d2) {
        AppMethodBeat.i(99513);
        double d3 = ((180.0d + d) / 360.0d) * 2.68435456E8d;
        double sin = Math.sin((3.1415926d * d2) / 180.0d);
        sin = ((180.0d - ((Math.log((1.0d + sin) / (1.0d - sin)) * 180.0d) / 6.2831852d)) / 360.0d) * 2.68435456E8d;
        a aVar = new a();
        aVar.a = (int) (d3 + 0.5d);
        aVar.b = (int) (0.5d + sin);
        AppMethodBeat.o(99513);
        return aVar;
    }
}
