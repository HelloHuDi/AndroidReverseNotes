package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.en */
public final class C46780en implements C44505dj, C31037dq {
    /* renamed from: a */
    private static C46780en f18122a = new C46780en();
    /* renamed from: b */
    private Map<String, C44506dk> f18123b = new ConcurrentHashMap();
    /* renamed from: c */
    private C31040ek f18124c;
    /* renamed from: d */
    private Runnable f18125d = new C46781ep(this);
    /* renamed from: e */
    private Runnable f18126e = new C41046eq(this);

    static {
        AppMethodBeat.m2504i(98808);
        AppMethodBeat.m2505o(98808);
    }

    /* renamed from: d */
    public static C46780en m88752d() {
        return f18122a;
    }

    /* renamed from: a */
    public final void mo12414a() {
        AppMethodBeat.m2504i(98802);
        this.f18124c.mo12414a();
        AppMethodBeat.m2505o(98802);
    }

    /* renamed from: a */
    public final void mo12419a(int i) {
        AppMethodBeat.m2504i(98804);
        C46772bt.m88746j().post(new C41045eo(this, i));
        AppMethodBeat.m2505o(98804);
    }

    /* renamed from: b */
    public final void mo12421b() {
        AppMethodBeat.m2504i(98803);
        this.f18124c.mo12421b();
        AppMethodBeat.m2505o(98803);
    }

    /* renamed from: c */
    public final void mo29273c() {
        AppMethodBeat.m2504i(98805);
        for (C44506dk c : this.f18123b.values()) {
            c.mo29273c();
        }
        AppMethodBeat.m2505o(98805);
    }

    /* renamed from: e */
    public final C31041el mo75364e() {
        AppMethodBeat.m2504i(98799);
        C31041el c31041el = (C31041el) this.f18123b.get("settings");
        AppMethodBeat.m2505o(98799);
        return c31041el;
    }

    /* renamed from: f */
    public final C24361cd mo75365f() {
        AppMethodBeat.m2504i(98800);
        C24361cd c24361cd = (C24361cd) this.f18123b.get("accessscheduler");
        AppMethodBeat.m2505o(98800);
        return c24361cd;
    }

    /* renamed from: g */
    public final void mo75366g() {
        AppMethodBeat.m2504i(98801);
        if (C46772bt.m88743g()) {
            this.f18124c = C44509em.m80723d();
        }
        this.f18124c.mo12420a(this);
        this.f18124c.mo12423e();
        AppMethodBeat.m2505o(98801);
    }

    private C46780en() {
        AppMethodBeat.m2504i(98798);
        C16218dp c16218dp = new C16218dp();
        this.f18123b.put(c16218dp.mo29272b(), c16218dp);
        C24365dn c24365dn = new C24365dn();
        this.f18123b.put(c24365dn.mo29272b(), c24365dn);
        C44827dl c44827dl = new C44827dl();
        this.f18123b.put(c44827dl.mo29272b(), c44827dl);
        Runnable runnable = this.f18125d;
        if (!C46772bt.m88743g() && C46772bt.f18097f) {
            C16215cm.m24715a().mo29267a(runnable);
            C16215cm.m24715a().mo29268b(runnable, 30000);
        }
        runnable = this.f18126e;
        if (!C46772bt.m88743g() && C46772bt.f18097f) {
            C16215cm.m24715a().mo29267a(runnable);
            C16215cm.m24715a().mo29268b(runnable, 30000);
        }
        AppMethodBeat.m2505o(98798);
    }

    /* renamed from: a */
    public final void mo50366a(String str, byte[] bArr, String str2) {
        AppMethodBeat.m2504i(98806);
        Runnable runnable = this.f18126e;
        long a = (long) C24362a.m37665a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!C46772bt.m88743g() && C46772bt.f18097f) {
            C16215cm.m24715a().mo29267a(runnable);
            C16215cm.m24715a().mo29268b(runnable, a);
        }
        for (C44506dk a2 : this.f18123b.values()) {
            a2.mo50366a(str, bArr, str2);
        }
        AppMethodBeat.m2505o(98806);
    }

    /* renamed from: a */
    public final void mo40564a(String str, String str2) {
        AppMethodBeat.m2504i(98807);
        Runnable runnable = this.f18125d;
        long a = (long) C24362a.m37665a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!C46772bt.m88743g() && C46772bt.f18097f) {
            C16215cm.m24715a().mo29267a(runnable);
            C16215cm.m24715a().mo29268b(runnable, a);
        }
        for (C44506dk a2 : this.f18123b.values()) {
            a2.mo40564a(str, str2);
        }
        AppMethodBeat.m2505o(98807);
    }
}
