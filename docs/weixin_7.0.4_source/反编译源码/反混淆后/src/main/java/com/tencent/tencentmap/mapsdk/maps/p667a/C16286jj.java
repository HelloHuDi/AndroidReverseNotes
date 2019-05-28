package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.util.Log;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.C8889f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C16201o;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;
import com.tencent.tencentmap.mapsdk.p666a.C41027s;
import com.tencent.tencentmap.mapsdk.p666a.C41355u;
import org.json.JSONArray;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jj */
public class C16286jj {
    /* renamed from: a */
    public static int f3438a = 0;
    /* renamed from: b */
    public static int f3439b = 1;
    /* renamed from: c */
    public static int f3440c = 0;
    /* renamed from: d */
    public static int f3441d = 1;
    /* renamed from: e */
    private C41027s f3442e;
    /* renamed from: f */
    private C16201o f3443f;
    /* renamed from: g */
    private C8889f f3444g;
    /* renamed from: h */
    private boolean f3445h;

    public C16286jj(Context context, C8889f c8889f, String str) {
        AppMethodBeat.m2504i(100042);
        if (str == null) {
            this.f3442e = C31016w.m49806a(context);
        } else {
            this.f3442e = C41355u.m72123a(context, str);
        }
        this.f3444g = c8889f;
        m25076c();
        this.f3445h = false;
        mo29528a(this.f3445h);
        AppMethodBeat.m2505o(100042);
    }

    /* renamed from: c */
    private void m25076c() {
        JSONArray jSONArray;
        AppMethodBeat.m2504i(100043);
        int b = this.f3442e.mo65087b("AIEnabled");
        int b2 = this.f3442e.mo65087b("AIType");
        try {
            jSONArray = new JSONArray(this.f3442e.mo65080a("AIBuildingList"));
        } catch (Exception e) {
            C1015d.m2290b(Log.getStackTraceString(e));
            jSONArray = null;
        }
        if (!(b == -1 || b2 == -1 || jSONArray == null)) {
            this.f3443f = new C16201o(b, b2, jSONArray);
        }
        if (this.f3444g != null && b2 == f3441d) {
            this.f3444g.mo20184a(mo29529b());
        }
        AppMethodBeat.m2505o(100043);
    }

    /* renamed from: a */
    public void mo29527a(C16201o c16201o) {
        AppMethodBeat.m2504i(100044);
        this.f3443f = c16201o;
        if (this.f3443f == null) {
            this.f3442e.mo65086a(new String[]{"AIEnabled", "AIType", "AIBuildingList"});
        } else {
            this.f3442e.mo65082a("AIEnabled", this.f3443f.mo29193a());
            this.f3442e.mo65082a("AIType", this.f3443f.mo29194b());
            if (this.f3443f.mo29195c() != null) {
                this.f3442e.mo65084a("AIBuildingList", this.f3443f.mo29195c().toString());
            }
            if (this.f3444g != null && mo29526a() == f3441d) {
                this.f3444g.mo20184a(mo29529b());
            }
        }
        mo29528a(this.f3445h);
        AppMethodBeat.m2505o(100044);
    }

    /* renamed from: a */
    public void mo29528a(boolean z) {
        AppMethodBeat.m2504i(100045);
        this.f3445h = z;
        if (this.f3444g == null) {
            AppMethodBeat.m2505o(100045);
        } else if (m25077d()) {
            this.f3444g.mo20214d(z);
            AppMethodBeat.m2505o(100045);
        } else {
            this.f3444g.mo20214d(false);
            AppMethodBeat.m2505o(100045);
        }
    }

    /* renamed from: d */
    private boolean m25077d() {
        AppMethodBeat.m2504i(100046);
        if (this.f3443f == null || this.f3443f.mo29193a() != f3439b) {
            AppMethodBeat.m2505o(100046);
            return false;
        }
        AppMethodBeat.m2505o(100046);
        return true;
    }

    /* renamed from: a */
    public int mo29526a() {
        AppMethodBeat.m2504i(100047);
        int i;
        if (this.f3443f == null || this.f3443f.mo29193a() != f3439b) {
            i = f3440c;
            AppMethodBeat.m2505o(100047);
            return i;
        }
        i = f3441d;
        AppMethodBeat.m2505o(100047);
        return i;
    }

    /* renamed from: b */
    public String[] mo29529b() {
        AppMethodBeat.m2504i(100048);
        if (this.f3443f != null) {
            String[] d = this.f3443f.mo29196d();
            AppMethodBeat.m2505o(100048);
            return d;
        }
        AppMethodBeat.m2505o(100048);
        return null;
    }
}
