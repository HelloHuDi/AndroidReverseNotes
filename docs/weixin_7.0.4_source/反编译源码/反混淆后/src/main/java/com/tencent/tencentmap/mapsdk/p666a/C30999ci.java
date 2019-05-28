package com.tencent.tencentmap.mapsdk.p666a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ci */
public class C30999ci {
    /* renamed from: a */
    C30997bv f13969a = null;

    public C30999ci(C30997bv c30997bv) {
        this.f13969a = c30997bv;
    }

    /* renamed from: a */
    public void mo50185a() {
        if (this.f13969a != null) {
            this.f13969a = null;
        }
    }

    /* renamed from: b */
    public final Location mo50186b() {
        AppMethodBeat.m2504i(100937);
        if (this.f13969a != null) {
            Location d = this.f13969a.mo50184d();
            AppMethodBeat.m2505o(100937);
            return d;
        }
        AppMethodBeat.m2505o(100937);
        return null;
    }

    /* renamed from: c */
    public void mo50187c() {
        AppMethodBeat.m2504i(100938);
        if (this.f13969a != null) {
            this.f13969a.mo50181a();
        }
        AppMethodBeat.m2505o(100938);
    }

    /* renamed from: d */
    public void mo50188d() {
        AppMethodBeat.m2504i(100939);
        if (this.f13969a != null) {
            this.f13969a.mo50182b();
        }
        AppMethodBeat.m2505o(100939);
    }

    /* renamed from: e */
    public boolean mo50189e() {
        AppMethodBeat.m2504i(100940);
        if (this.f13969a != null) {
            boolean c = this.f13969a.mo50183c();
            AppMethodBeat.m2505o(100940);
            return c;
        }
        AppMethodBeat.m2505o(100940);
        return false;
    }
}
