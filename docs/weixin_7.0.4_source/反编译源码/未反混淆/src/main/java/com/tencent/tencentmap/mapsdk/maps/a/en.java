package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ce.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class en implements dj, dq {
    private static en a = new en();
    private Map<String, dk> b = new ConcurrentHashMap();
    private ek c;
    private Runnable d = new ep(this);
    private Runnable e = new eq(this);

    static {
        AppMethodBeat.i(98808);
        AppMethodBeat.o(98808);
    }

    public static en d() {
        return a;
    }

    public final void a() {
        AppMethodBeat.i(98802);
        this.c.a();
        AppMethodBeat.o(98802);
    }

    public final void a(int i) {
        AppMethodBeat.i(98804);
        bt.j().post(new eo(this, i));
        AppMethodBeat.o(98804);
    }

    public final void b() {
        AppMethodBeat.i(98803);
        this.c.b();
        AppMethodBeat.o(98803);
    }

    public final void c() {
        AppMethodBeat.i(98805);
        for (dk c : this.b.values()) {
            c.c();
        }
        AppMethodBeat.o(98805);
    }

    public final el e() {
        AppMethodBeat.i(98799);
        el elVar = (el) this.b.get("settings");
        AppMethodBeat.o(98799);
        return elVar;
    }

    public final cd f() {
        AppMethodBeat.i(98800);
        cd cdVar = (cd) this.b.get("accessscheduler");
        AppMethodBeat.o(98800);
        return cdVar;
    }

    public final void g() {
        AppMethodBeat.i(98801);
        if (bt.g()) {
            this.c = em.d();
        }
        this.c.a(this);
        this.c.e();
        AppMethodBeat.o(98801);
    }

    private en() {
        AppMethodBeat.i(98798);
        dp dpVar = new dp();
        this.b.put(dpVar.b(), dpVar);
        dn dnVar = new dn();
        this.b.put(dnVar.b(), dnVar);
        dl dlVar = new dl();
        this.b.put(dlVar.b(), dlVar);
        Runnable runnable = this.d;
        if (!bt.g() && bt.f) {
            cm.a().a(runnable);
            cm.a().b(runnable, 30000);
        }
        runnable = this.e;
        if (!bt.g() && bt.f) {
            cm.a().a(runnable);
            cm.a().b(runnable, 30000);
        }
        AppMethodBeat.o(98798);
    }

    public final void a(String str, byte[] bArr, String str2) {
        AppMethodBeat.i(98806);
        Runnable runnable = this.e;
        long a = (long) a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!bt.g() && bt.f) {
            cm.a().a(runnable);
            cm.a().b(runnable, a);
        }
        for (dk a2 : this.b.values()) {
            a2.a(str, bArr, str2);
        }
        AppMethodBeat.o(98806);
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(98807);
        Runnable runnable = this.d;
        long a = (long) a.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!bt.g() && bt.f) {
            cm.a().a(runnable);
            cm.a().b(runnable, a);
        }
        for (dk a2 : this.b.values()) {
            a2.a(str, str2);
        }
        AppMethodBeat.o(98807);
    }
}
