package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.location.Location;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ic;
import com.tencent.tencentmap.mapsdk.maps.a.jk;
import com.tencent.tencentmap.mapsdk.maps.a.ln;
import com.tencent.tencentmap.mapsdk.maps.a.lq;
import com.tencent.tencentmap.mapsdk.maps.a.ls;

public final class aj {
    private static int J = 1;
    public static final int a = (q.a + 0);
    public static final int b = (q.a + 9);
    public static final int c = (q.a + 10);
    @Deprecated
    public static final int d = (q.a + 11);
    public static final int e = (q.a + 13);
    public static final int f = (q.a + 12);
    @Deprecated
    public static final int g = b;
    @Deprecated
    public static final int h = e;
    private au A;
    private ci B;
    private bh C;
    private bm D;
    private ax E;
    private boolean F;
    private ap G;
    private am H;
    private ac I;
    private final com.tencent.tencentmap.mapsdk.a.bi.a K;
    private ar i;
    private jk j;
    private bs k;
    private bq l;
    private bd m;
    private bb n;
    private aw o;
    private av p;
    private cj q;
    private bn r;
    private ay s;
    private bk t;
    private ai u;
    private br v;
    private bp w;
    private bc x;
    private ba y;
    private at z;

    public interface p {
        void a(Bitmap bitmap);
    }

    public interface d {
        void a();
    }

    public interface m {
        void a(de deVar);

        void b(de deVar);

        void c(de deVar);
    }

    public interface f {
        boolean onIndoorBuildingDeactivated();

        boolean onIndoorBuildingFocused();

        boolean onIndoorLevelActivated(cw cwVar);
    }

    public interface o {
        void a(dl dlVar, db dbVar);
    }

    public interface g {
        void a(int i, int i2, int i3, int i4);

        void a(de deVar);
    }

    public interface e {
    }

    public interface n {
    }

    public interface h {
        void a(db dbVar);
    }

    public interface j {
        void a(db dbVar);
    }

    public interface k {
        void a(dd ddVar);
    }

    public interface a {
        void a();

        void b();
    }

    public interface b {
        View a(de deVar);

        View b(de deVar);
    }

    public interface c {
        void onCameraChange(cp cpVar);

        void onCameraChangeFinished(cp cpVar);
    }

    public interface i {
        void a();
    }

    public interface l {
        boolean a(de deVar);
    }

    protected aj(ac acVar, Context context, ak akVar) {
        AppMethodBeat.i(98312);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = false;
        this.G = null;
        this.I = null;
        this.K = new com.tencent.tencentmap.mapsdk.a.bi.a() {
            public void a() {
                AppMethodBeat.i(98311);
                aj.this.c(true);
                Location k = aj.this.k();
                if (k != null) {
                    aj.this.b(ae.a(new db(k.getLatitude(), k.getLongitude())));
                }
                AppMethodBeat.o(98311);
            }
        };
        ic.b(context);
        ic.a(context);
        this.I = acVar;
        ln.a().a(context);
        lq.a(context);
        this.i = new ar(acVar.getMapViewType(), acVar, akVar);
        this.t = new bk(this.i);
        this.G = new ap(this.i, b());
        this.v = new br(this.i);
        this.o = new aw(this.I, this.t.b());
        this.z = new at(this.o);
        this.m = new bd(this.t.b());
        this.x = new bc(this.m);
        this.n = new bb(this.t.b());
        this.y = new ba(this.n);
        this.l = new bq(this.t.b());
        this.w = new bp(this.l);
        this.C = new bh(this.i.a());
        this.i.a(this.K);
        this.i.a(this.z, akVar);
        this.j = new jk(this.i, akVar);
        this.j.a(this.z, akVar);
        this.j.a();
        ls.a(0, w.a(context));
        AppMethodBeat.o(98312);
    }

    protected aj() {
        AppMethodBeat.i(98313);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.F = false;
        this.G = null;
        this.I = null;
        this.K = /* anonymous class already generated */;
        this.i = new ar(0, null, null);
        this.G = new ap(this.i, b());
        AppMethodBeat.o(98313);
    }

    public static int a() {
        return J;
    }

    /* Access modifiers changed, original: final */
    public final bk b() {
        return this.t;
    }

    public final ar c() {
        return this.i;
    }

    public final cp d() {
        AppMethodBeat.i(98314);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98314);
            return null;
        }
        cp b = this.v.b();
        AppMethodBeat.o(98314);
        return b;
    }

    public final float e() {
        AppMethodBeat.i(98315);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98315);
            return 0.0f;
        }
        float c = this.v.c();
        AppMethodBeat.o(98315);
        return c;
    }

    public final float f() {
        AppMethodBeat.i(98316);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98316);
            return 0.0f;
        }
        float d = this.v.d();
        AppMethodBeat.o(98316);
        return d;
    }

    public final void a(ad adVar) {
        AppMethodBeat.i(98317);
        if (this.F || this.v == null || this.v.q()) {
            AppMethodBeat.o(98317);
            return;
        }
        this.v.a(adVar);
        AppMethodBeat.o(98317);
    }

    public final void b(ad adVar) {
        AppMethodBeat.i(98318);
        if (this.F || this.v == null || this.v.q()) {
            AppMethodBeat.o(98318);
            return;
        }
        this.v.a(adVar, 500, null);
        AppMethodBeat.o(98318);
    }

    public final void a(ad adVar, a aVar) {
        AppMethodBeat.i(98319);
        if (this.F || this.v == null || this.v.q()) {
            AppMethodBeat.o(98319);
            return;
        }
        this.v.a(adVar, 500, aVar);
        AppMethodBeat.o(98319);
    }

    public final void a(ad adVar, long j, a aVar) {
        AppMethodBeat.i(98320);
        if (this.F || this.v == null || this.v.q()) {
            AppMethodBeat.o(98320);
            return;
        }
        this.v.a(adVar, j, aVar);
        AppMethodBeat.o(98320);
    }

    public final void g() {
        AppMethodBeat.i(98321);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98321);
            return;
        }
        this.v.e();
        AppMethodBeat.o(98321);
    }

    public final dl a(dm dmVar) {
        AppMethodBeat.i(98322);
        if (this.F || this.x == null || dmVar == null) {
            AppMethodBeat.o(98322);
            return null;
        }
        dl a = this.x.a(dmVar);
        AppMethodBeat.o(98322);
        return a;
    }

    public final dj a(dk dkVar) {
        AppMethodBeat.i(98323);
        if (this.F || this.y == null || dkVar == null) {
            AppMethodBeat.o(98323);
            return null;
        }
        dj a = this.y.a(dkVar);
        AppMethodBeat.o(98323);
        return a;
    }

    public final cq a(cr crVar) {
        AppMethodBeat.i(98324);
        if (this.F || this.w == null || crVar == null) {
            AppMethodBeat.o(98324);
            return null;
        }
        cq a = this.w.a(crVar);
        AppMethodBeat.o(98324);
        return a;
    }

    public final de a(df dfVar) {
        AppMethodBeat.i(98325);
        if (this.F || this.z == null || dfVar == null) {
            AppMethodBeat.o(98325);
            return null;
        }
        de a = this.z.a(dfVar, this.z);
        AppMethodBeat.o(98325);
        return a;
    }

    public final void h() {
        AppMethodBeat.i(98326);
        if (this.x != null) {
            this.x.b();
        }
        if (this.y != null) {
            this.y.b();
        }
        if (this.w != null) {
            this.w.b();
        }
        if (this.z != null) {
            this.z.b();
        }
        if (this.D != null) {
            this.D.b();
        }
        AppMethodBeat.o(98326);
    }

    @Deprecated
    public final void a(int i) {
        AppMethodBeat.i(98327);
        b(i);
        AppMethodBeat.o(98327);
    }

    public final void b(int i) {
        AppMethodBeat.i(98328);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98328);
            return;
        }
        this.v.a(i);
        AppMethodBeat.o(98328);
    }

    public final boolean i() {
        AppMethodBeat.i(98329);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98329);
            return false;
        }
        boolean f = this.v.f();
        AppMethodBeat.o(98329);
        return f;
    }

    public final void a(boolean z) {
        AppMethodBeat.i(98330);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98330);
            return;
        }
        this.v.a(z);
        AppMethodBeat.o(98330);
    }

    public final void b(boolean z) {
        AppMethodBeat.i(98331);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98331);
            return;
        }
        this.v.b(z);
        AppMethodBeat.o(98331);
    }

    public final boolean j() {
        AppMethodBeat.i(98332);
        if (this.F) {
            AppMethodBeat.o(98332);
            return false;
        }
        A();
        boolean e = this.B.e();
        AppMethodBeat.o(98332);
        return e;
    }

    private void A() {
        AppMethodBeat.i(98333);
        if (this.q == null) {
            this.q = new cj(this.z, this.w, this.v);
        }
        if (this.B == null) {
            this.B = new ci(this.q);
        }
        AppMethodBeat.o(98333);
    }

    public final void c(boolean z) {
        AppMethodBeat.i(98334);
        if (this.F) {
            AppMethodBeat.o(98334);
            return;
        }
        A();
        if (!z) {
            this.B.d();
            AppMethodBeat.o(98334);
        } else if (j()) {
            AppMethodBeat.o(98334);
        } else {
            this.B.c();
            AppMethodBeat.o(98334);
        }
    }

    public final Location k() {
        AppMethodBeat.i(98335);
        if (this.F) {
            AppMethodBeat.o(98335);
            return null;
        }
        A();
        Location b = this.B.b();
        AppMethodBeat.o(98335);
        return b;
    }

    public final am l() {
        AppMethodBeat.i(98336);
        if (this.F) {
            AppMethodBeat.o(98336);
            return null;
        }
        if (this.H == null) {
            this.H = new am(this.C);
        }
        am amVar = this.H;
        AppMethodBeat.o(98336);
        return amVar;
    }

    public final ai m() {
        AppMethodBeat.i(98337);
        if (this.F || this.i == null) {
            AppMethodBeat.o(98337);
            return null;
        }
        if (this.u == null) {
            this.u = new ai(this.i);
        }
        ai aiVar = this.u;
        AppMethodBeat.o(98337);
        return aiVar;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(98338);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98338);
            return;
        }
        this.v.a(cVar);
        AppMethodBeat.o(98338);
    }

    public final void a(h hVar) {
        AppMethodBeat.i(98339);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98339);
            return;
        }
        this.v.a(hVar);
        AppMethodBeat.o(98339);
    }

    public final void a(j jVar) {
        AppMethodBeat.i(98340);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98340);
            return;
        }
        this.v.a(jVar);
        AppMethodBeat.o(98340);
    }

    public final void a(i iVar) {
        AppMethodBeat.i(98341);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98341);
            return;
        }
        this.v.a(iVar);
        AppMethodBeat.o(98341);
    }

    /* Access modifiers changed, original: final */
    public final void n() {
        AppMethodBeat.i(98342);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98342);
            return;
        }
        this.v.g();
        AppMethodBeat.o(98342);
    }

    /* Access modifiers changed, original: final */
    public final void o() {
        AppMethodBeat.i(98343);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98343);
            return;
        }
        this.v.h();
        AppMethodBeat.o(98343);
    }

    /* Access modifiers changed, original: final */
    public final void p() {
        AppMethodBeat.i(98344);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98344);
            return;
        }
        this.v.i();
        AppMethodBeat.o(98344);
    }

    /* Access modifiers changed, original: final */
    public final void q() {
        AppMethodBeat.i(98345);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98345);
            return;
        }
        this.v.j();
        AppMethodBeat.o(98345);
    }

    /* Access modifiers changed, original: final */
    public final void r() {
        AppMethodBeat.i(98346);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98346);
            return;
        }
        this.v.k();
        AppMethodBeat.o(98346);
    }

    /* Access modifiers changed, original: final */
    public final void s() {
        AppMethodBeat.i(98347);
        if (this.F) {
            AppMethodBeat.o(98347);
            return;
        }
        if (this.v != null) {
            this.v.l();
        }
        if (this.j != null) {
            this.j.b();
        }
        C();
        B();
        this.F = true;
        AppMethodBeat.o(98347);
    }

    private void B() {
        AppMethodBeat.i(98348);
        if (this.q != null) {
            this.q.e();
            this.q = null;
        }
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.n != null) {
            this.n.a();
            this.n = null;
        }
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        if (this.l != null) {
            this.l.a();
            this.l = null;
        }
        if (this.i != null) {
            this.i.d();
            this.i = null;
        }
        if (this.r != null) {
            this.r.a();
            this.r = null;
        }
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
        if (this.s != null) {
            this.s.a();
        }
        AppMethodBeat.o(98348);
    }

    private void C() {
        AppMethodBeat.i(98349);
        if (this.C != null) {
            this.C.a();
            this.C = null;
        }
        if (this.B != null) {
            this.B.a();
            this.B = null;
        }
        if (this.z != null) {
            this.z.a();
            this.z = null;
        }
        if (this.y != null) {
            this.y.a();
            this.y = null;
        }
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        if (this.w != null) {
            this.w.a();
            this.w = null;
        }
        if (this.D != null) {
            this.D.a();
            this.D = null;
        }
        if (this.A != null) {
            this.A.a();
            this.A = null;
        }
        if (this.E != null) {
            this.E.a();
            this.E = null;
        }
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        if (this.t != null) {
            this.t.a();
            this.t = null;
        }
        AppMethodBeat.o(98349);
    }

    public final void a(p pVar, Config config) {
        AppMethodBeat.i(98350);
        if (this.v != null) {
            this.v.a(pVar, config);
        }
        AppMethodBeat.o(98350);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(98351);
        a(pVar, Config.ARGB_8888);
        AppMethodBeat.o(98351);
    }

    @Deprecated
    public final void a(dn dnVar) {
        AppMethodBeat.i(98352);
        b(dnVar);
        AppMethodBeat.o(98352);
    }

    public final void b(dn dnVar) {
        AppMethodBeat.i(98353);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98353);
            return;
        }
        this.v.a(dnVar);
        AppMethodBeat.o(98353);
    }

    public final void c(dn dnVar) {
        AppMethodBeat.i(98354);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98354);
            return;
        }
        this.v.b(dnVar);
        AppMethodBeat.o(98354);
    }

    public final void a(float f, float f2, boolean z) {
        AppMethodBeat.i(98355);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98355);
            return;
        }
        this.v.a(f, f2, z);
        AppMethodBeat.o(98355);
    }

    public final String t() {
        AppMethodBeat.i(98356);
        String str;
        if (this.F || this.v == null) {
            str = "";
            AppMethodBeat.o(98356);
            return str;
        }
        str = this.v.m();
        AppMethodBeat.o(98356);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void d(boolean z) {
        AppMethodBeat.i(98357);
        if (this.F || this.i == null) {
            AppMethodBeat.o(98357);
            return;
        }
        this.i.c(z);
        AppMethodBeat.o(98357);
    }

    public final void e(boolean z) {
        AppMethodBeat.i(98358);
        if (this.F || this.i == null) {
            AppMethodBeat.o(98358);
            return;
        }
        this.i.a(z, false);
        AppMethodBeat.o(98358);
    }

    public final void a(l lVar) {
        AppMethodBeat.i(98359);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98359);
            return;
        }
        this.v.a(lVar);
        AppMethodBeat.o(98359);
    }

    public final void a(m mVar) {
        AppMethodBeat.i(98360);
        if (this.F || this.z == null) {
            AppMethodBeat.o(98360);
            return;
        }
        this.z.a(mVar);
        AppMethodBeat.o(98360);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(98361);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98361);
            return;
        }
        this.v.a(gVar);
        AppMethodBeat.o(98361);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(98362);
        if (this.F || this.z == null) {
            AppMethodBeat.o(98362);
            return;
        }
        this.z.a(bVar);
        AppMethodBeat.o(98362);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(98363);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98363);
            return;
        }
        this.v.a(fVar);
        AppMethodBeat.o(98363);
    }

    public final void f(boolean z) {
        AppMethodBeat.i(98364);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98364);
            return;
        }
        this.v.c(z);
        AppMethodBeat.o(98364);
    }

    public final void c(int i) {
        AppMethodBeat.i(98365);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98365);
            return;
        }
        this.v.b(i);
        AppMethodBeat.o(98365);
    }

    public final int u() {
        AppMethodBeat.i(98366);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98366);
            return -1;
        }
        int n = this.v.n();
        AppMethodBeat.o(98366);
        return n;
    }

    public final String[] v() {
        AppMethodBeat.i(98367);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98367);
            return null;
        }
        String[] o = this.v.o();
        AppMethodBeat.o(98367);
        return o;
    }

    public final String a(db dbVar) {
        AppMethodBeat.i(98368);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98368);
            return null;
        }
        String a = this.v.a(dbVar);
        AppMethodBeat.o(98368);
        return a;
    }

    public final void a(k kVar) {
        AppMethodBeat.i(98369);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98369);
            return;
        }
        this.v.a(kVar);
        AppMethodBeat.o(98369);
    }

    public final void g(boolean z) {
        AppMethodBeat.i(98370);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98370);
            return;
        }
        this.v.d(z);
        AppMethodBeat.o(98370);
    }

    public final boolean w() {
        AppMethodBeat.i(98371);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98371);
            return false;
        }
        boolean p = this.v.p();
        AppMethodBeat.o(98371);
        return p;
    }

    public final void a(String str, String str2) {
        AppMethodBeat.i(98372);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98372);
            return;
        }
        this.v.a(str, str2);
        AppMethodBeat.o(98372);
    }

    public final void h(boolean z) {
        AppMethodBeat.i(98373);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98373);
            return;
        }
        this.v.e(z);
        AppMethodBeat.o(98373);
    }

    public final int x() {
        AppMethodBeat.i(98374);
        if (this.I == null) {
            AppMethodBeat.o(98374);
            return 0;
        }
        int width = this.I.getWidth();
        AppMethodBeat.o(98374);
        return width;
    }

    public final int y() {
        AppMethodBeat.i(98375);
        if (this.I == null) {
            AppMethodBeat.o(98375);
            return 0;
        }
        int height = this.I.getHeight();
        AppMethodBeat.o(98375);
        return height;
    }

    public final void a(da daVar) {
        AppMethodBeat.i(98376);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98376);
            return;
        }
        this.v.a(daVar);
        AppMethodBeat.o(98376);
    }

    public final String z() {
        AppMethodBeat.i(98377);
        if (this.F || this.v == null) {
            AppMethodBeat.o(98377);
            return null;
        }
        String r = this.v.r();
        AppMethodBeat.o(98377);
        return r;
    }
}
