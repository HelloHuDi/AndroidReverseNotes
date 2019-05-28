package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dp */
public class C41020dp implements C44494dn {
    /* renamed from: a */
    private ArrayList<C44494dn> f16410a = new ArrayList();

    public C41020dp() {
        AppMethodBeat.m2504i(101092);
        AppMethodBeat.m2505o(101092);
    }

    /* renamed from: a */
    public synchronized void mo65069a(C44494dn c44494dn) {
        AppMethodBeat.m2504i(101093);
        if (!(c44494dn == null || this.f16410a.contains(c44494dn))) {
            this.f16410a.add(c44494dn);
        }
        AppMethodBeat.m2505o(101093);
    }

    /* renamed from: b */
    public synchronized void mo65070b(C44494dn c44494dn) {
        AppMethodBeat.m2504i(101094);
        this.f16410a.remove(c44494dn);
        AppMethodBeat.m2505o(101094);
    }

    /* renamed from: a */
    public synchronized boolean mo29185a(float f, float f2) {
        AppMethodBeat.m2504i(101095);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29185a(f, f2);
        }
        AppMethodBeat.m2505o(101095);
        return false;
    }

    /* renamed from: b */
    public synchronized boolean mo29186b(float f, float f2) {
        AppMethodBeat.m2504i(101096);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29186b(f, f2);
        }
        AppMethodBeat.m2505o(101096);
        return false;
    }

    /* renamed from: c */
    public synchronized boolean mo29187c(float f, float f2) {
        AppMethodBeat.m2504i(101097);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29187c(f, f2);
        }
        AppMethodBeat.m2505o(101097);
        return false;
    }

    /* renamed from: d */
    public synchronized boolean mo29188d(float f, float f2) {
        AppMethodBeat.m2504i(101098);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29188d(f, f2);
        }
        AppMethodBeat.m2505o(101098);
        return false;
    }

    /* renamed from: e */
    public synchronized boolean mo29189e(float f, float f2) {
        AppMethodBeat.m2504i(101099);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29189e(f, f2);
        }
        AppMethodBeat.m2505o(101099);
        return false;
    }

    /* renamed from: f */
    public synchronized boolean mo29190f(float f, float f2) {
        AppMethodBeat.m2504i(101100);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29190f(f, f2);
        }
        AppMethodBeat.m2505o(101100);
        return false;
    }

    /* renamed from: g */
    public synchronized boolean mo29191g(float f, float f2) {
        AppMethodBeat.m2504i(101101);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29191g(f, f2);
        }
        AppMethodBeat.m2505o(101101);
        return false;
    }

    /* renamed from: a */
    public synchronized void mo29184a() {
        AppMethodBeat.m2504i(101102);
        for (int size = this.f16410a.size() - 1; size >= 0; size--) {
            ((C44494dn) this.f16410a.get(size)).mo29184a();
        }
        AppMethodBeat.m2505o(101102);
    }
}
