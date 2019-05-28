package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import navsns.RttRequest;
import navsns.user_login_t;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gz */
public class C16269gz extends Thread {
    /* renamed from: a */
    private C46789gm f3361a = null;
    /* renamed from: b */
    private C24386hf f3362b = null;
    /* renamed from: c */
    private boolean f3363c = true;
    /* renamed from: d */
    private boolean f3364d = false;
    /* renamed from: e */
    private boolean f3365e = false;
    /* renamed from: f */
    private List<Object> f3366f;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gz$a */
    class C16271a {
        /* renamed from: a */
        public int f3367a;
        /* renamed from: b */
        public int f3368b;

        private C16271a() {
        }
    }

    public C16269gz(C46789gm c46789gm, C24386hf c24386hf) {
        AppMethodBeat.m2504i(99503);
        this.f3361a = c46789gm;
        this.f3362b = c24386hf;
        this.f3366f = new ArrayList();
        AppMethodBeat.m2505o(99503);
    }

    public void run() {
        AppMethodBeat.m2504i(99504);
        super.run();
        while (!this.f3365e) {
            if (!this.f3364d) {
                if (this.f3361a == null) {
                    AppMethodBeat.m2505o(99504);
                    return;
                } else {
                    m24949d();
                    this.f3361a.mo75472w();
                }
            }
            try {
                synchronized (this) {
                    if (this.f3363c) {
                        wait(500);
                        this.f3363c = false;
                    } else {
                        wait(30000);
                    }
                }
            } catch (InterruptedException e) {
            } catch (Throwable th) {
                AppMethodBeat.m2505o(99504);
            }
        }
        AppMethodBeat.m2505o(99504);
    }

    /* renamed from: a */
    public void mo29433a() {
        AppMethodBeat.m2504i(99505);
        this.f3364d = true;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99505);
            }
        }
    }

    /* renamed from: b */
    public void mo29434b() {
        AppMethodBeat.m2504i(99506);
        this.f3364d = false;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99506);
            }
        }
    }

    /* renamed from: c */
    public void mo29435c() {
        AppMethodBeat.m2504i(99507);
        this.f3365e = true;
        synchronized (this) {
            try {
                notify();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99507);
            }
        }
        interrupt();
    }

    /* renamed from: d */
    private void m24949d() {
        AppMethodBeat.m2504i(99508);
        if (this.f3361a == null) {
            AppMethodBeat.m2505o(99508);
            return;
        }
        m24950e();
        byte[] f = m24951f();
        if (f != null && f.length > 0) {
            this.f3361a.mo75454i().mo29311a(f, f.length, true, false);
        }
        AppMethodBeat.m2505o(99508);
    }

    /* renamed from: e */
    private void m24950e() {
        AppMethodBeat.m2504i(99509);
        int m = this.f3361a.mo12440a().mo58849m();
        Rect y = this.f3361a.mo12440a().mo58861y();
        double d = (double) (((float) y.right) / 1000000.0f);
        double d2 = (double) (((float) y.top) / 1000000.0f);
        C16271a a = m24947a((double) (((float) y.left) / 1000000.0f), (double) (((float) y.bottom) / 1000000.0f));
        C16271a a2 = m24947a(d, d2);
        this.f3361a.mo75454i().mo29326a(m, Math.min(a.f3367a, a2.f3367a), Math.min(a.f3368b, a2.f3368b), Math.max(a2.f3367a, a.f3367a), Math.max(a2.f3368b, a.f3368b));
        AppMethodBeat.m2505o(99509);
    }

    /* renamed from: f */
    private byte[] m24951f() {
        AppMethodBeat.m2504i(99510);
        if (this.f3361a == null) {
            AppMethodBeat.m2505o(99510);
            return null;
        }
        RttRequest g = m24952g();
        if (g == null) {
            AppMethodBeat.m2505o(99510);
            return null;
        }
        byte[] a = this.f3362b.mo40647a(m24948a(g));
        AppMethodBeat.m2505o(99510);
        return a;
    }

    /* renamed from: a */
    private byte[] m24948a(RttRequest rttRequest) {
        AppMethodBeat.m2504i(99511);
        user_login_t user_login_t = new user_login_t();
        user_login_t.f1692pf = "android_sdk";
        user_login_t.is_login = false;
        user_login_t.channel = "";
        user_login_t.imei = C36520ic.m60473a();
        C36893e c36893e = new C36893e();
        c36893e.mo58776c("rttserverex");
        c36893e.mo58777d("getRtt");
        c36893e.mo40542a("info", user_login_t);
        c36893e.mo40542a("req", rttRequest);
        byte[] a = c36893e.mo40544a();
        AppMethodBeat.m2505o(99511);
        return a;
    }

    /* renamed from: g */
    private RttRequest m24952g() {
        RttRequest rttRequest = null;
        AppMethodBeat.m2504i(99512);
        if (this.f3361a == null) {
            AppMethodBeat.m2505o(99512);
        } else {
            TrafficRequestItem[] h = this.f3361a.mo75454i().mo29394h();
            if (h == null || h.length == 0) {
                AppMethodBeat.m2505o(99512);
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
                AppMethodBeat.m2505o(99512);
            }
        }
        return rttRequest;
    }

    /* renamed from: a */
    private C16271a m24947a(double d, double d2) {
        AppMethodBeat.m2504i(99513);
        double d3 = ((180.0d + d) / 360.0d) * 2.68435456E8d;
        double sin = Math.sin((3.1415926d * d2) / 180.0d);
        sin = ((180.0d - ((Math.log((1.0d + sin) / (1.0d - sin)) * 180.0d) / 6.2831852d)) / 360.0d) * 2.68435456E8d;
        C16271a c16271a = new C16271a();
        c16271a.f3367a = (int) (d3 + 0.5d);
        c16271a.f3368b = (int) (0.5d + sin);
        AppMethodBeat.m2505o(99513);
        return c16271a;
    }
}
