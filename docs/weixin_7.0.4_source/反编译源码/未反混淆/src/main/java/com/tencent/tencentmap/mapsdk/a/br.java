package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aj.a;
import com.tencent.tencentmap.mapsdk.a.aj.c;
import com.tencent.tencentmap.mapsdk.a.aj.f;
import com.tencent.tencentmap.mapsdk.a.aj.g;
import com.tencent.tencentmap.mapsdk.a.aj.h;
import com.tencent.tencentmap.mapsdk.a.aj.i;
import com.tencent.tencentmap.mapsdk.a.aj.k;
import com.tencent.tencentmap.mapsdk.a.aj.l;
import com.tencent.tencentmap.mapsdk.a.aj.p;

public class br {
    private bw a = null;
    private p b = null;
    private Handler c = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            AppMethodBeat.i(100884);
            if (message != null && message.what == 0) {
                if (br.this.b != null) {
                    br.this.b.a((Bitmap) message.obj);
                }
                br.this.b = null;
            }
            AppMethodBeat.o(100884);
        }
    };

    public br(bw bwVar) {
        AppMethodBeat.i(100885);
        this.a = bwVar;
        c(false);
        AppMethodBeat.o(100885);
    }

    public void a() {
        if (this.a != null) {
            this.a = null;
        }
    }

    public cp b() {
        AppMethodBeat.i(100886);
        if (this.a == null) {
            AppMethodBeat.o(100886);
            return null;
        }
        cp g = this.a.g();
        AppMethodBeat.o(100886);
        return g;
    }

    public final float c() {
        AppMethodBeat.i(100887);
        if (this.a == null) {
            AppMethodBeat.o(100887);
            return -1.0f;
        }
        float h = this.a.h();
        AppMethodBeat.o(100887);
        return h;
    }

    public final float d() {
        AppMethodBeat.i(100888);
        if (this.a == null) {
            AppMethodBeat.o(100888);
            return -1.0f;
        }
        float i = this.a.i();
        AppMethodBeat.o(100888);
        return i;
    }

    public final int a(ad adVar) {
        AppMethodBeat.i(100889);
        if (this.a == null) {
            AppMethodBeat.o(100889);
            return j.INVALID_ID;
        }
        int a = this.a.a(adVar);
        AppMethodBeat.o(100889);
        return a;
    }

    public final int a(ad adVar, long j, a aVar) {
        AppMethodBeat.i(100890);
        if (this.a == null) {
            AppMethodBeat.o(100890);
            return j.INVALID_ID;
        }
        int a = this.a.a(adVar, j, aVar);
        AppMethodBeat.o(100890);
        return a;
    }

    public final void e() {
        AppMethodBeat.i(100891);
        if (this.a == null) {
            AppMethodBeat.o(100891);
            return;
        }
        this.a.j();
        AppMethodBeat.o(100891);
    }

    public final void a(int i) {
        AppMethodBeat.i(100892);
        if (this.a == null) {
            AppMethodBeat.o(100892);
            return;
        }
        this.a.a(i);
        AppMethodBeat.o(100892);
    }

    public final void a(boolean z) {
        AppMethodBeat.i(100893);
        if (this.a == null) {
            AppMethodBeat.o(100893);
            return;
        }
        this.a.a(z);
        AppMethodBeat.o(100893);
    }

    public final void b(boolean z) {
        AppMethodBeat.i(100894);
        if (this.a == null) {
            AppMethodBeat.o(100894);
            return;
        }
        this.a.b(z);
        AppMethodBeat.o(100894);
    }

    public final boolean f() {
        AppMethodBeat.i(100895);
        if (this.a == null) {
            AppMethodBeat.o(100895);
            return false;
        }
        boolean k = this.a.k();
        AppMethodBeat.o(100895);
        return k;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(100896);
        if (this.a == null) {
            AppMethodBeat.o(100896);
            return;
        }
        this.a.a(hVar);
        AppMethodBeat.o(100896);
    }

    public final void a(aj.j jVar) {
        AppMethodBeat.i(100897);
        if (this.a == null) {
            AppMethodBeat.o(100897);
            return;
        }
        this.a.a(jVar);
        AppMethodBeat.o(100897);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(100898);
        if (this.a == null) {
            AppMethodBeat.o(100898);
            return;
        }
        this.a.a(cVar);
        AppMethodBeat.o(100898);
    }

    public void g() {
        AppMethodBeat.i(100899);
        if (this.a == null) {
            AppMethodBeat.o(100899);
            return;
        }
        this.a.n();
        AppMethodBeat.o(100899);
    }

    public void h() {
        AppMethodBeat.i(100900);
        if (this.a == null) {
            AppMethodBeat.o(100900);
            return;
        }
        this.a.o();
        AppMethodBeat.o(100900);
    }

    public void i() {
        AppMethodBeat.i(100901);
        if (this.a == null) {
            AppMethodBeat.o(100901);
            return;
        }
        this.a.t();
        AppMethodBeat.o(100901);
    }

    public void j() {
        AppMethodBeat.i(100902);
        if (this.a == null) {
            AppMethodBeat.o(100902);
            return;
        }
        this.a.u();
        AppMethodBeat.o(100902);
    }

    public void k() {
        AppMethodBeat.i(100903);
        if (this.a == null) {
            AppMethodBeat.o(100903);
            return;
        }
        this.a.p();
        AppMethodBeat.o(100903);
    }

    public void l() {
        AppMethodBeat.i(100904);
        if (this.a == null) {
            AppMethodBeat.o(100904);
            return;
        }
        this.a.q();
        AppMethodBeat.o(100904);
    }

    private void a(Handler handler, Config config) {
        AppMethodBeat.i(100905);
        if (this.a == null) {
            AppMethodBeat.o(100905);
            return;
        }
        this.a.a(handler, config);
        AppMethodBeat.o(100905);
    }

    public void a(p pVar, Config config) {
        AppMethodBeat.i(100906);
        if (this.a == null || pVar == null) {
            AppMethodBeat.o(100906);
            return;
        }
        this.b = pVar;
        a(this.c, config);
        AppMethodBeat.o(100906);
    }

    public final void a(dn dnVar) {
        AppMethodBeat.i(100907);
        if (this.a == null) {
            AppMethodBeat.o(100907);
            return;
        }
        this.a.a(dnVar);
        AppMethodBeat.o(100907);
    }

    public final void b(dn dnVar) {
        AppMethodBeat.i(100908);
        if (this.a == null) {
            AppMethodBeat.o(100908);
            return;
        }
        this.a.b(dnVar);
        AppMethodBeat.o(100908);
    }

    public void a(float f, float f2, boolean z) {
        AppMethodBeat.i(100909);
        if (this.a == null) {
            AppMethodBeat.o(100909);
            return;
        }
        this.a.a(f, f2, z);
        AppMethodBeat.o(100909);
    }

    public String m() {
        AppMethodBeat.i(100910);
        String str;
        if (this.a == null) {
            str = "";
            AppMethodBeat.o(100910);
            return str;
        }
        str = this.a.r();
        AppMethodBeat.o(100910);
        return str;
    }

    public void a(i iVar) {
        AppMethodBeat.i(100911);
        if (this.a != null) {
            this.a.a(iVar);
        }
        AppMethodBeat.o(100911);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(100912);
        if (this.a == null) {
            AppMethodBeat.o(100912);
            return;
        }
        this.a.a(lVar);
        AppMethodBeat.o(100912);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(100913);
        if (this.a == null) {
            AppMethodBeat.o(100913);
            return;
        }
        this.a.a(gVar);
        AppMethodBeat.o(100913);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(100914);
        if (this.a == null) {
            AppMethodBeat.o(100914);
            return;
        }
        this.a.a(fVar);
        AppMethodBeat.o(100914);
    }

    public void c(boolean z) {
        AppMethodBeat.i(100915);
        if (this.a != null) {
            this.a.d(z);
        }
        AppMethodBeat.o(100915);
    }

    public void b(int i) {
        AppMethodBeat.i(100916);
        if (this.a != null) {
            this.a.b(i);
        }
        AppMethodBeat.o(100916);
    }

    public int n() {
        AppMethodBeat.i(100917);
        if (this.a != null) {
            int v = this.a.v();
            AppMethodBeat.o(100917);
            return v;
        }
        AppMethodBeat.o(100917);
        return -1;
    }

    public String[] o() {
        AppMethodBeat.i(100918);
        if (this.a != null) {
            String[] w = this.a.w();
            AppMethodBeat.o(100918);
            return w;
        }
        AppMethodBeat.o(100918);
        return null;
    }

    public String a(db dbVar) {
        AppMethodBeat.i(100919);
        if (this.a != null) {
            String b = this.a.b(dbVar);
            AppMethodBeat.o(100919);
            return b;
        }
        AppMethodBeat.o(100919);
        return null;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(100920);
        if (this.a == null) {
            AppMethodBeat.o(100920);
            return;
        }
        this.a.a(kVar);
        AppMethodBeat.o(100920);
    }

    public void d(boolean z) {
        AppMethodBeat.i(100921);
        if (this.a == null) {
            AppMethodBeat.o(100921);
            return;
        }
        this.a.e(z);
        AppMethodBeat.o(100921);
    }

    public boolean p() {
        AppMethodBeat.i(100922);
        if (this.a == null) {
            AppMethodBeat.o(100922);
            return false;
        }
        boolean x = this.a.x();
        AppMethodBeat.o(100922);
        return x;
    }

    public void a(String str, String str2) {
        AppMethodBeat.i(100923);
        if (a(str) || a(str2)) {
            AppMethodBeat.o(100923);
            return;
        }
        this.a.a(str, str2);
        AppMethodBeat.o(100923);
    }

    private boolean a(String str) {
        AppMethodBeat.i(100924);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.o(100924);
            return true;
        }
        AppMethodBeat.o(100924);
        return false;
    }

    public void e(boolean z) {
        AppMethodBeat.i(100925);
        if (this.a == null) {
            AppMethodBeat.o(100925);
            return;
        }
        this.a.f(z);
        AppMethodBeat.o(100925);
    }

    public boolean q() {
        AppMethodBeat.i(100926);
        if (this.a != null) {
            boolean y = this.a.y();
            AppMethodBeat.o(100926);
            return y;
        }
        AppMethodBeat.o(100926);
        return false;
    }

    public void a(da daVar) {
        AppMethodBeat.i(100927);
        if (this.a != null) {
            this.a.a(daVar);
        }
        AppMethodBeat.o(100927);
    }

    public String r() {
        AppMethodBeat.i(100928);
        if (this.a == null) {
            AppMethodBeat.o(100928);
            return null;
        }
        String z = this.a.z();
        AppMethodBeat.o(100928);
        return z;
    }
}
