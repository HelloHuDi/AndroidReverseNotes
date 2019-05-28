package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.o;
import com.tencent.tencentmap.mapsdk.a.s;
import com.tencent.tencentmap.mapsdk.a.u;
import com.tencent.tencentmap.mapsdk.a.w;
import org.json.JSONArray;

public class jj {
    public static int a = 0;
    public static int b = 1;
    public static int c = 0;
    public static int d = 1;
    private s e;
    private o f;
    private f g;
    private boolean h;

    public jj(Context context, f fVar, String str) {
        AppMethodBeat.i(100042);
        if (str == null) {
            this.e = w.a(context);
        } else {
            this.e = u.a(context, str);
        }
        this.g = fVar;
        c();
        this.h = false;
        a(this.h);
        AppMethodBeat.o(100042);
    }

    private void c() {
        JSONArray jSONArray;
        AppMethodBeat.i(100043);
        int b = this.e.b("AIEnabled");
        int b2 = this.e.b("AIType");
        try {
            jSONArray = new JSONArray(this.e.a("AIBuildingList"));
        } catch (Exception e) {
            d.b(Log.getStackTraceString(e));
            jSONArray = null;
        }
        if (!(b == -1 || b2 == -1 || jSONArray == null)) {
            this.f = new o(b, b2, jSONArray);
        }
        if (this.g != null && b2 == d) {
            this.g.a(b());
        }
        AppMethodBeat.o(100043);
    }

    public void a(o oVar) {
        AppMethodBeat.i(100044);
        this.f = oVar;
        if (this.f == null) {
            this.e.a(new String[]{"AIEnabled", "AIType", "AIBuildingList"});
        } else {
            this.e.a("AIEnabled", this.f.a());
            this.e.a("AIType", this.f.b());
            if (this.f.c() != null) {
                this.e.a("AIBuildingList", this.f.c().toString());
            }
            if (this.g != null && a() == d) {
                this.g.a(b());
            }
        }
        a(this.h);
        AppMethodBeat.o(100044);
    }

    public void a(boolean z) {
        AppMethodBeat.i(100045);
        this.h = z;
        if (this.g == null) {
            AppMethodBeat.o(100045);
        } else if (d()) {
            this.g.d(z);
            AppMethodBeat.o(100045);
        } else {
            this.g.d(false);
            AppMethodBeat.o(100045);
        }
    }

    private boolean d() {
        AppMethodBeat.i(100046);
        if (this.f == null || this.f.a() != b) {
            AppMethodBeat.o(100046);
            return false;
        }
        AppMethodBeat.o(100046);
        return true;
    }

    public int a() {
        AppMethodBeat.i(100047);
        int i;
        if (this.f == null || this.f.a() != b) {
            i = c;
            AppMethodBeat.o(100047);
            return i;
        }
        i = d;
        AppMethodBeat.o(100047);
        return i;
    }

    public String[] b() {
        AppMethodBeat.i(100048);
        if (this.f != null) {
            String[] d = this.f.d();
            AppMethodBeat.o(100048);
            return d;
        }
        AppMethodBeat.o(100048);
        return null;
    }
}
