package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44540v.C44541a;
import com.tencent.tencentmap.mapsdk.p666a.C16199g;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41003a;
import com.tencent.tencentmap.mapsdk.p666a.C41014c;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;
import com.tencent.tencentmap.mapsdk.p666a.C46758d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ax */
public final class C25011ax extends Observable implements C24421s, C44542w, C44543x {
    /* renamed from: a */
    private static C25011ax f5006a = null;
    /* renamed from: b */
    private C46769as f5007b = null;
    /* renamed from: c */
    private C24355au f5008c = null;
    /* renamed from: d */
    private C24355au f5009d = null;
    /* renamed from: e */
    private boolean f5010e = true;
    /* renamed from: f */
    private boolean f5011f = false;
    /* renamed from: g */
    private Context f5012g;
    /* renamed from: h */
    private C41033be f5013h;
    /* renamed from: i */
    private boolean f5014i;
    /* renamed from: j */
    private int f5015j = 0;
    /* renamed from: k */
    private List<C41030ar> f5016k = null;
    /* renamed from: l */
    private Object f5017l = new Object();
    /* renamed from: m */
    private C16199g f5018m = null;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ax$1 */
    class C243571 implements Runnable {
        C243571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98525);
            C25011ax.this.mo41923b(true);
            AppMethodBeat.m2505o(98525);
        }
    }

    /* renamed from: a */
    public static synchronized C25011ax m39269a(Context context, C41033be c41033be, C44498ay c44498ay) {
        C25011ax c25011ax;
        synchronized (C25011ax.class) {
            AppMethodBeat.m2504i(98526);
            if (f5006a == null) {
                C16205ag.m24688e(" create ua instance ", new Object[0]);
                f5006a = new C25011ax(context, c41033be, c44498ay);
            }
            C16205ag.m24688e(" return ua instance ", new Object[0]);
            c25011ax = f5006a;
            AppMethodBeat.m2505o(98526);
        }
        return c25011ax;
    }

    /* renamed from: d */
    public static synchronized C25011ax m39275d() {
        C25011ax c25011ax;
        synchronized (C25011ax.class) {
            c25011ax = f5006a;
        }
        return c25011ax;
    }

    /* renamed from: a */
    public static synchronized C41033be m39270a(Context context, boolean z) {
        C46771bf a;
        synchronized (C25011ax.class) {
            AppMethodBeat.m2504i(98527);
            a = C46771bf.m88723a(context, z);
            AppMethodBeat.m2505o(98527);
        }
        return a;
    }

    /* renamed from: a */
    public static boolean m39272a(String str, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(98528);
        C16205ag.m24688e(" onUA: %s,%b,%d,%d,%b,%b", str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z2), Boolean.valueOf(z3));
        C25011ax d = C25011ax.m39275d();
        if (d != null && !d.m39280m()) {
            d.f5016k.add(new C41030ar(str, z, j, j2, map, z2));
            AppMethodBeat.m2505o(98528);
            return true;
        } else if (!C25011ax.m39276i()) {
            AppMethodBeat.m2505o(98528);
            return false;
        } else if (d.f5007b.mo75345a(str)) {
            C16205ag.m24686c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", str);
            AppMethodBeat.m2505o(98528);
            return false;
        } else if (!z || (z && d.f5007b.mo75348b(str))) {
            C24355au k = z2 ? d.m39278k() : d.m39277j();
            if (k != null) {
                C24356av a = C24349e.m37576a(d.f5012g, str, z, j, j2, map, z3);
                if (a == null) {
                    C16205ag.m24686c("createdRecordBean bean is null, return false!", new Object[0]);
                    AppMethodBeat.m2505o(98528);
                    return false;
                }
                boolean a2 = k.mo40526a(a);
                AppMethodBeat.m2505o(98528);
                return a2;
            }
            AppMethodBeat.m2505o(98528);
            return false;
        } else {
            C16205ag.m24686c("onUserAction return false, because eventName:[%s] is sampled by svr rate!", str);
            AppMethodBeat.m2505o(98528);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m39273a(boolean z) {
        AppMethodBeat.m2504i(98529);
        C25011ax d = C25011ax.m39275d();
        if (d == null) {
            C16205ag.m24686c(" ua module not ready!", new Object[0]);
            AppMethodBeat.m2505o(98529);
            return false;
        } else if (C25011ax.m39276i()) {
            boolean b = d.mo41923b(z);
            AppMethodBeat.m2505o(98529);
            return b;
        } else {
            AppMethodBeat.m2505o(98529);
            return false;
        }
    }

    /* renamed from: i */
    private static boolean m39276i() {
        boolean z = false;
        AppMethodBeat.m2504i(98530);
        C25011ax d = C25011ax.m39275d();
        if (d == null) {
            C16205ag.m24687d("isModuleAble:not init ua", new Object[0]);
            AppMethodBeat.m2505o(98530);
        } else {
            z = d.mo41924e();
            if (z && d.m39279l()) {
                z = d.m39280m();
            }
            AppMethodBeat.m2505o(98530);
        }
        return z;
    }

    /* renamed from: e */
    public final synchronized boolean mo41924e() {
        return this.f5014i;
    }

    private C25011ax(Context context, C41033be c41033be, C44498ay c44498ay) {
        AppMethodBeat.m2504i(98531);
        if (context == null) {
            C16205ag.m24686c(" the context is null! init UserActionRecord failed!", new Object[0]);
            this.f5012g = null;
            AppMethodBeat.m2505o(98531);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f5012g = applicationContext;
        } else {
            this.f5012g = context;
        }
        if (C41014c.m71224m() == null) {
            C41014c.m71218a(this.f5012g);
        }
        if (this.f5016k == null) {
            this.f5016k = Collections.synchronizedList(new ArrayList(5));
        }
        this.f5013h = c41033be;
        if (c41033be != null) {
            c41033be.mo65114a(c44498ay);
        }
        C36541t a = C36541t.m60530a(this.f5012g);
        a.mo57782a((C24421s) this);
        a.mo57784a((C44542w) this);
        a.mo57785a((C44543x) this);
        a.mo57780a(0, c41033be);
        a.mo57780a(1, c41033be);
        this.f5007b = new C46769as();
        this.f5008c = new C31021ao(context);
        this.f5009d = new C25008aw(context);
        this.f5010e = true;
        new C46758d().mo75309a(this.f5012g);
        this.f5018m = new C16199g();
        AppMethodBeat.m2505o(98531);
    }

    /* renamed from: j */
    private synchronized C24355au m39277j() {
        return this.f5008c;
    }

    /* renamed from: k */
    private synchronized C24355au m39278k() {
        return this.f5009d;
    }

    /* renamed from: l */
    private synchronized boolean m39279l() {
        return this.f5010e;
    }

    /* renamed from: m */
    private synchronized boolean m39280m() {
        return this.f5011f;
    }

    /* renamed from: n */
    private synchronized void m39281n() {
        this.f5011f = true;
    }

    /* renamed from: b */
    public final boolean mo41923b(boolean z) {
        AppMethodBeat.m2504i(98532);
        synchronized (this.f5017l) {
            try {
                if ((mo41924e() ? C24349e.m37618j(this.f5012g) : -1) > 0) {
                    if (this.f5013h != null) {
                        C44499az c44826ap = new C44826ap(this.f5012g);
                        c44826ap.mo72028a(z);
                        this.f5013h.mo65113a(c44826ap);
                    }
                    AppMethodBeat.m2505o(98532);
                    return true;
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(98532);
            }
        }
        AppMethodBeat.m2505o(98532);
        return false;
    }

    /* renamed from: c */
    public final void mo40751c() {
        AppMethodBeat.m2504i(98533);
        Context context = this.f5012g;
        C16205ag.m24683a(" RecordDAO.deleteRecords() start", new Object[0]);
        int a = C44539p.m80849a(context, new int[]{1});
        C16205ag.m24688e(" ua first clean :%d", Integer.valueOf(a));
        C16205ag.m24688e(" ua remove strategy :%d", Integer.valueOf(C24349e.m37617i(this.f5012g)));
        AppMethodBeat.m2505o(98533);
    }

    /* renamed from: c */
    private synchronized void m39274c(boolean z) {
        AppMethodBeat.m2504i(98534);
        if (z != mo41924e()) {
            C24355au j = m39277j();
            if (j != null) {
                j.mo40525a(z);
            }
            j = m39278k();
            if (j != null) {
                j.mo40525a(z);
            }
            this.f5014i = z;
        }
        AppMethodBeat.m2505o(98534);
    }

    /* renamed from: f */
    public final C41033be mo41925f() {
        return this.f5013h;
    }

    /* renamed from: g */
    public final C46769as mo41926g() {
        return this.f5007b;
    }

    /* renamed from: b */
    public final void mo40750b() {
        AppMethodBeat.m2504i(98535);
        m39281n();
        try {
            C44540v e = C36541t.m60530a(this.f5012g).mo57789e();
            if (e != null) {
                C44541a b = e.mo70938b(1);
                if (!(b == null || this.f5007b == null)) {
                    Set d = b.mo70958d();
                    if (d != null && d.size() > 0) {
                        this.f5007b.mo75344a(d);
                    }
                    d = b.mo70960f();
                    if (d != null && d.size() > 0) {
                        this.f5007b.mo75347b(d);
                    }
                }
                if (!mo41924e() || b == null) {
                    C16205ag.m24685b("event module is disable", new Object[0]);
                } else {
                    if (((mo41924e() ? C24349e.m37618j(this.f5012g) : -1) > 0 ? 1 : 0) != 0) {
                        C16205ag.m24688e(" asyn up module %d", Integer.valueOf(1));
                        C46752b.m88622a().mo12298a(new C243571());
                    }
                }
            }
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            C16205ag.m24687d(" common query end error %s", th.toString());
        }
        m39282o();
        if (mo41927h() < 2) {
            C46771bf a = C46771bf.m88722a(this.f5012g);
            if (a.mo75358a() && a.mo75359b()) {
                m39283p();
                m39284q();
                if (this.f5007b.mo75356j()) {
                    this.f5018m.setChanged();
                    this.f5018m.notifyObservers(this.f5012g);
                }
            }
        }
        AppMethodBeat.m2505o(98535);
    }

    /* renamed from: o */
    private synchronized void m39282o() {
        AppMethodBeat.m2504i(98536);
        if (this.f5016k != null && this.f5016k.size() > 0) {
            for (C41030ar c41030ar : this.f5016k) {
                C25011ax.m39272a(c41030ar.f16429a, c41030ar.f16430b, c41030ar.f16431c, c41030ar.f16432d, c41030ar.f16433e, c41030ar.f16434f, false);
            }
            this.f5016k.clear();
        }
        AppMethodBeat.m2505o(98536);
    }

    /* renamed from: p */
    private void m39283p() {
        AppMethodBeat.m2504i(98537);
        try {
            if (mo41924e() || this.f5007b.mo75352f()) {
                C36541t a = C36541t.m60530a(this.f5012g);
                if (a != null) {
                    C44541a b = a.mo57789e().mo70938b(1);
                    if (b != null) {
                        String b2 = b.mo70955b();
                        if (!(b2 == null || "".equals(b2.trim()))) {
                            new C41031at(this.f5012g).mo65112b();
                        }
                    }
                }
                AppMethodBeat.m2505o(98537);
                return;
            }
            AppMethodBeat.m2505o(98537);
        } catch (Exception e) {
            C16205ag.m24686c(" startHeart failed! " + e.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(98537);
        }
    }

    /* renamed from: q */
    private void m39284q() {
        boolean z;
        AppMethodBeat.m2504i(98538);
        if (this.f5007b.mo75355i()) {
            if ("".equals(C41003a.m71119b(this.f5012g, "LAUEVE_DENGTA", ""))) {
                z = true;
            } else {
                C16205ag.m24683a("AppLaunchedEvent has been uploaded!", new Object[0]);
                AppMethodBeat.m2505o(98538);
                return;
            }
        }
        z = false;
        if (C24349e.m37573a(this.f5012g) == null) {
            C16205ag.m24686c(" DeviceInfo == null?,return", new Object[0]);
            AppMethodBeat.m2505o(98538);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("A33", C24349e.m37614g(this.f5012g));
        hashMap.put("A63", "Y");
        if (C41003a.m71121b(this.f5012g)) {
            hashMap.put("A21", "Y");
        } else {
            hashMap.put("A21", "N");
        }
        if (C36541t.m60530a(this.f5012g).mo57791g()) {
            hashMap.put("A45", "Y");
        } else {
            hashMap.put("A45", "N");
        }
        if (C41003a.m71129g(this.f5012g)) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        hashMap.put("A68", C41003a.m71130h(this.f5012g));
        hashMap.put("A85", C41003a.f16326b ? "Y" : "N");
        hashMap.put("A9", C24349e.m37604d());
        hashMap.put("A14", C24349e.m37607e());
        boolean a = C25011ax.m39272a("rqd_applaunched", true, 0, 0, hashMap, true, false);
        if (z && a) {
            C41003a.m71118a(this.f5012g, "LAUEVE_DENGTA", C24349e.m37613g());
        }
        AppMethodBeat.m2505o(98538);
    }

    /* renamed from: a */
    public final void mo41921a(C44540v c44540v) {
        AppMethodBeat.m2504i(98539);
        if (c44540v != null) {
            C44541a b = c44540v.mo70938b(1);
            if (b != null) {
                boolean a = b.mo70954a();
                if (mo41924e() != a) {
                    C16205ag.m24689f("UAR onCommonStrategyChange setUsable:%b ", Boolean.valueOf(a));
                    m39274c(a);
                }
            }
        }
        AppMethodBeat.m2505o(98539);
    }

    /* renamed from: a */
    public final void mo40749a() {
        AppMethodBeat.m2504i(98540);
        m39271a(mo41927h() + 1);
        AppMethodBeat.m2505o(98540);
    }

    /* renamed from: h */
    public final synchronized int mo41927h() {
        return this.f5015j;
    }

    /* renamed from: a */
    private synchronized void m39271a(int i) {
        this.f5015j = i;
    }

    /* renamed from: a */
    public final void mo41922a(Map<String, String> map) {
        AppMethodBeat.m2504i(98541);
        if (!(map == null || map.size() <= 0 || this.f5007b == null)) {
            this.f5007b.mo75343a((Map) map);
        }
        AppMethodBeat.m2505o(98541);
    }
}
