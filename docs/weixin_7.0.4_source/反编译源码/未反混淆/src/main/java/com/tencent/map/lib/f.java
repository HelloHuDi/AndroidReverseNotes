package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.element.c;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.gl.JNICallback;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.listener.a;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.fl;
import com.tencent.tencentmap.mapsdk.maps.a.fq;
import com.tencent.tencentmap.mapsdk.maps.a.fr;
import com.tencent.tencentmap.mapsdk.maps.a.ft;
import com.tencent.tencentmap.mapsdk.maps.a.fv;
import com.tencent.tencentmap.mapsdk.maps.a.fw;
import com.tencent.tencentmap.mapsdk.maps.a.fx;
import com.tencent.tencentmap.mapsdk.maps.a.gj;
import com.tencent.tencentmap.mapsdk.maps.a.gk;
import com.tencent.tencentmap.mapsdk.maps.a.gm;
import com.tencent.tencentmap.mapsdk.maps.a.gs;
import com.tencent.tencentmap.mapsdk.maps.a.gt;
import com.tencent.tencentmap.mapsdk.maps.a.gv;
import java.util.ArrayList;
import java.util.List;

public class f {
    private boolean a = false;
    private gm b;
    private int c = 20;
    private int d = 3;
    private GeoPoint e = new GeoPoint();
    private int f = 0;

    public f(gm gmVar) {
        AppMethodBeat.i(97903);
        this.b = gmVar;
        AppMethodBeat.o(97903);
    }

    public void a() {
        AppMethodBeat.i(97904);
        this.b.w();
        AppMethodBeat.o(97904);
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        AppMethodBeat.i(97905);
        int n = this.b.e().n();
        AppMethodBeat.o(97905);
        return n;
    }

    public int e() {
        AppMethodBeat.i(97906);
        int u = this.b.a().u();
        AppMethodBeat.o(97906);
        return u;
    }

    public void a(int i) {
        AppMethodBeat.i(97907);
        this.b.a().b(i);
        AppMethodBeat.o(97907);
    }

    public GeoPoint f() {
        AppMethodBeat.i(97908);
        GeoPoint n = this.b.a().n();
        AppMethodBeat.o(97908);
        return n;
    }

    public String a(GeoPoint geoPoint) {
        AppMethodBeat.i(97909);
        String a = this.b.a(geoPoint);
        AppMethodBeat.o(97909);
        return a;
    }

    public void b(int i) {
        AppMethodBeat.i(97910);
        this.b.a().a(i);
        AppMethodBeat.o(97910);
    }

    public void a(j jVar) {
        AppMethodBeat.i(97911);
        this.b.c().a(jVar);
        this.b.q();
        AppMethodBeat.o(97911);
    }

    public void b(j jVar) {
        AppMethodBeat.i(97912);
        this.b.c().b(jVar);
        this.b.q();
        AppMethodBeat.o(97912);
    }

    public void a(fq fqVar) {
        AppMethodBeat.i(97913);
        this.b.a().a(fqVar);
        AppMethodBeat.o(97913);
    }

    public void b(fq fqVar) {
        AppMethodBeat.i(97914);
        this.b.a().b(fqVar);
        AppMethodBeat.o(97914);
    }

    public void a(fv fvVar) {
        AppMethodBeat.i(97915);
        this.b.a().a(fvVar);
        AppMethodBeat.o(97915);
    }

    public void b(fv fvVar) {
        AppMethodBeat.i(97916);
        this.b.a().b(fvVar);
        AppMethodBeat.o(97916);
    }

    public void b(GeoPoint geoPoint) {
        AppMethodBeat.i(97917);
        this.b.a().a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        AppMethodBeat.o(97917);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(97918);
        this.b.a().a(i, i2);
        AppMethodBeat.o(97918);
    }

    public void a(float f) {
        AppMethodBeat.i(97919);
        this.b.a().c(f);
        AppMethodBeat.o(97919);
    }

    public void b(float f) {
        AppMethodBeat.i(97920);
        this.b.a().b(f);
        AppMethodBeat.o(97920);
    }

    public boolean g() {
        AppMethodBeat.i(97921);
        boolean u = this.b.u();
        AppMethodBeat.o(97921);
        return u;
    }

    public void a(boolean z) {
        AppMethodBeat.i(97922);
        this.b.a(z);
        AppMethodBeat.o(97922);
    }

    public int h() {
        AppMethodBeat.i(97923);
        int m = this.b.a().m();
        AppMethodBeat.o(97923);
        return m;
    }

    public float i() {
        AppMethodBeat.i(97924);
        float l = this.b.a().l();
        AppMethodBeat.o(97924);
        return l;
    }

    public float j() {
        AppMethodBeat.i(97925);
        float h = (float) (((double) ((float) h())) + (Math.log((double) k()) / Math.log(2.0d)));
        AppMethodBeat.o(97925);
        return h;
    }

    public float k() {
        AppMethodBeat.i(97926);
        float q = this.b.a().q();
        AppMethodBeat.o(97926);
        return q;
    }

    public void a(double d) {
        AppMethodBeat.i(97927);
        this.b.a().j(d);
        AppMethodBeat.o(97927);
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(97928);
        this.b.a().a(runnable);
        AppMethodBeat.o(97928);
    }

    public void b(Runnable runnable) {
        AppMethodBeat.i(97929);
        this.b.a().b(runnable);
        AppMethodBeat.o(97929);
    }

    public void l() {
        AppMethodBeat.i(97930);
        this.b.a().s();
        AppMethodBeat.o(97930);
    }

    public void m() {
        AppMethodBeat.i(97931);
        this.b.s();
        AppMethodBeat.o(97931);
    }

    public void n() {
        AppMethodBeat.i(97932);
        this.b.t();
        AppMethodBeat.o(97932);
    }

    public void o() {
        AppMethodBeat.i(97933);
        this.b.r();
        AppMethodBeat.o(97933);
    }

    public boolean a(String str, byte[] bArr) {
        AppMethodBeat.i(97934);
        gv o = this.b.o();
        if (o == null) {
            AppMethodBeat.o(97934);
            return false;
        }
        boolean a = o.a(str, bArr);
        AppMethodBeat.o(97934);
        return a;
    }

    public boolean b(String str, byte[] bArr) {
        AppMethodBeat.i(97935);
        gv o = this.b.o();
        if (o == null) {
            AppMethodBeat.o(97935);
            return false;
        }
        boolean b = o.b(str, bArr);
        AppMethodBeat.o(97935);
        return b;
    }

    public void p() {
        AppMethodBeat.i(97936);
        gv o = this.b.o();
        if (o == null) {
            AppMethodBeat.o(97936);
            return;
        }
        o.c();
        AppMethodBeat.o(97936);
    }

    public void a(fr frVar) {
        AppMethodBeat.i(97937);
        this.b.a().a(frVar);
        AppMethodBeat.o(97937);
    }

    public void a(ft ftVar) {
        AppMethodBeat.i(97938);
        this.b.a().a(ftVar);
        AppMethodBeat.o(97938);
    }

    public void b(ft ftVar) {
        AppMethodBeat.i(97939);
        this.b.a().b(ftVar);
        AppMethodBeat.o(97939);
    }

    public void a(a aVar) {
        AppMethodBeat.i(97940);
        this.b.c().a(aVar);
        AppMethodBeat.o(97940);
    }

    public boolean a(float f, float f2) {
        AppMethodBeat.i(97941);
        boolean a = this.b.c().a(f, f2);
        AppMethodBeat.o(97941);
        return a;
    }

    public float q() {
        AppMethodBeat.i(97942);
        float o = this.b.a().o();
        AppMethodBeat.o(97942);
        return o;
    }

    public float r() {
        AppMethodBeat.i(97943);
        float p = this.b.a().p();
        AppMethodBeat.o(97943);
        return p;
    }

    public int a(Polygon2D polygon2D) {
        AppMethodBeat.i(97944);
        int a = this.b.a(polygon2D);
        AppMethodBeat.o(97944);
        return a;
    }

    public void b(Polygon2D polygon2D) {
        AppMethodBeat.i(97945);
        this.b.b(polygon2D);
        AppMethodBeat.o(97945);
    }

    public void c(int i) {
        AppMethodBeat.i(97946);
        this.b.c(i);
        AppMethodBeat.o(97946);
    }

    public int a(CircleInfo circleInfo) {
        AppMethodBeat.i(97947);
        int a = this.b.a(circleInfo);
        AppMethodBeat.o(97947);
        return a;
    }

    public void a(int i, CircleInfo circleInfo) {
        AppMethodBeat.i(97948);
        this.b.a(i, circleInfo);
        AppMethodBeat.o(97948);
    }

    public void d(int i) {
        AppMethodBeat.i(97949);
        this.b.a(i);
        AppMethodBeat.o(97949);
    }

    public int a(int i, int i2, int i3, int i4, int i5, float f) {
        AppMethodBeat.i(97950);
        int a = this.b.a(i, i2, i3, i4, i5, f);
        AppMethodBeat.o(97950);
        return a;
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(97951);
        this.b.c(i, i2);
        AppMethodBeat.o(97951);
    }

    public void e(int i) {
        AppMethodBeat.i(97952);
        this.b.b(i);
        AppMethodBeat.o(97952);
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        AppMethodBeat.i(97953);
        this.b.a((List) list, (List) list2);
        AppMethodBeat.o(97953);
    }

    public void s() {
        AppMethodBeat.i(97954);
        this.b.v();
        AppMethodBeat.o(97954);
    }

    public void b(boolean z) {
        AppMethodBeat.i(97955);
        if (this.b != null) {
            this.b.d(z);
        }
        AppMethodBeat.o(97955);
    }

    public void c(boolean z) {
        AppMethodBeat.i(97956);
        if (this.b != null) {
            this.b.e(z);
        }
        AppMethodBeat.o(97956);
    }

    public fw t() {
        AppMethodBeat.i(97957);
        fw d = this.b.d();
        AppMethodBeat.o(97957);
        return d;
    }

    @Deprecated
    public fw u() {
        AppMethodBeat.i(97958);
        fl flVar = new fl(this.b);
        AppMethodBeat.o(97958);
        return flVar;
    }

    public void a(fx fxVar) {
        AppMethodBeat.i(97959);
        this.b.a().c(fxVar);
        AppMethodBeat.o(97959);
    }

    public void v() {
        AppMethodBeat.i(97960);
        this.b.a().A();
        AppMethodBeat.o(97960);
    }

    public int a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(97961);
        int a = this.b.a().a(i, i2, i3, i4);
        AppMethodBeat.o(97961);
        return a;
    }

    public Rect w() {
        AppMethodBeat.i(97962);
        Rect b = this.b.a().b();
        AppMethodBeat.o(97962);
        return b;
    }

    public void a(e eVar) {
        AppMethodBeat.i(97963);
        this.b.a().a(eVar);
        AppMethodBeat.o(97963);
    }

    public void d(boolean z) {
        AppMethodBeat.i(97964);
        this.b.f(z);
        AppMethodBeat.o(97964);
    }

    public void f(int i) {
        AppMethodBeat.i(97965);
        this.b.d(i);
        AppMethodBeat.o(97965);
    }

    public int x() {
        AppMethodBeat.i(97966);
        int o = this.b.i().o();
        AppMethodBeat.o(97966);
        return o;
    }

    public String[] y() {
        AppMethodBeat.i(97967);
        String[] x = this.b.x();
        AppMethodBeat.o(97967);
        return x;
    }

    public String c(GeoPoint geoPoint) {
        AppMethodBeat.i(97968);
        String b = this.b.b(geoPoint);
        AppMethodBeat.o(97968);
        return b;
    }

    public c d(GeoPoint geoPoint) {
        AppMethodBeat.i(97969);
        c b = this.b.i().b(geoPoint);
        AppMethodBeat.o(97969);
        return b;
    }

    public void a(String[] strArr) {
        AppMethodBeat.i(97970);
        this.b.a(strArr);
        AppMethodBeat.o(97970);
    }

    public void g(int i) {
        AppMethodBeat.i(97971);
        this.c = i;
        this.b.i().d(i);
        this.b.e().c(i);
        AppMethodBeat.o(97971);
    }

    public void h(int i) {
        AppMethodBeat.i(97972);
        this.d = i;
        this.b.i().e(i);
        AppMethodBeat.o(97972);
    }

    public void a(e eVar) {
        AppMethodBeat.i(97973);
        this.b.a(eVar);
        AppMethodBeat.o(97973);
    }

    public void a(gk.a aVar) {
        AppMethodBeat.i(97974);
        this.b.a().a(aVar);
        AppMethodBeat.o(97974);
    }

    public void c(int i, int i2) {
        AppMethodBeat.i(97975);
        this.b.a().b(i, i2);
        AppMethodBeat.o(97975);
    }

    public void c(float f) {
        AppMethodBeat.i(97976);
        this.b.a().a(f);
        AppMethodBeat.o(97976);
    }

    public void a(float f, float f2, int i, boolean z) {
        AppMethodBeat.i(97977);
        this.b.a().a(f, f2, z);
        AppMethodBeat.o(97977);
    }

    public void b(double d) {
        AppMethodBeat.i(97978);
        this.b.a().h(d);
        AppMethodBeat.o(97978);
    }

    public void a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        AppMethodBeat.i(97979);
        this.b.a().a(d, d2, d3, d4, d5, runnable);
        AppMethodBeat.o(97979);
    }

    public void a(gt gtVar) {
        AppMethodBeat.i(97980);
        this.b.a().a(gtVar);
        AppMethodBeat.o(97980);
    }

    public gj z() {
        AppMethodBeat.i(97981);
        gj z = this.b.z();
        AppMethodBeat.o(97981);
        return z;
    }

    public gs A() {
        AppMethodBeat.i(97982);
        gs e = this.b.e();
        AppMethodBeat.o(97982);
        return e;
    }

    public int B() {
        AppMethodBeat.i(97983);
        int a = this.b.a(3, true);
        AppMethodBeat.o(97983);
        return a;
    }

    public int C() {
        AppMethodBeat.i(97984);
        int a = this.b.a(2, true);
        AppMethodBeat.o(97984);
        return a;
    }

    public int e(boolean z) {
        AppMethodBeat.i(97985);
        int a = this.b.a(1, z);
        AppMethodBeat.o(97985);
        return a;
    }

    public void i(int i) {
        AppMethodBeat.i(97986);
        this.b.e(i);
        AppMethodBeat.o(97986);
    }

    public void j(int i) {
        AppMethodBeat.i(97987);
        this.b.f(i);
        AppMethodBeat.o(97987);
    }

    public void a(int i, int i2, int i3) {
        AppMethodBeat.i(97988);
        this.b.a(i, i2, i3);
        AppMethodBeat.o(97988);
    }

    public void a(d dVar) {
        AppMethodBeat.i(97989);
        this.b.a(dVar);
        AppMethodBeat.o(97989);
    }

    public void a(JNICallback.j jVar) {
        AppMethodBeat.i(97990);
        this.b.a(jVar);
        AppMethodBeat.o(97990);
    }

    public void a(b bVar) {
        AppMethodBeat.i(97991);
        this.b.a(bVar);
        AppMethodBeat.o(97991);
    }

    public void a(JNICallback.c cVar) {
        AppMethodBeat.i(97992);
        this.b.a(cVar);
        AppMethodBeat.o(97992);
    }

    public void a(k kVar) {
        AppMethodBeat.i(97993);
        this.b.a(kVar);
        AppMethodBeat.o(97993);
    }

    public void d(int i, int i2) {
        AppMethodBeat.i(97994);
        this.b.d(i, i2);
        AppMethodBeat.o(97994);
    }

    public void f(boolean z) {
        AppMethodBeat.i(97995);
        this.b.g(z);
        AppMethodBeat.o(97995);
    }

    public void e(int i, int i2) {
        AppMethodBeat.i(97996);
        this.b.e(i, i2);
        AppMethodBeat.o(97996);
    }

    public void a(String str) {
        AppMethodBeat.i(97997);
        this.b.b(str);
        AppMethodBeat.o(97997);
    }

    public MapLanguage D() {
        AppMethodBeat.i(97998);
        MapLanguage y = this.b.y();
        AppMethodBeat.o(97998);
        return y;
    }

    public void b(String str) {
        AppMethodBeat.i(97999);
        this.b.a(str);
        AppMethodBeat.o(97999);
    }

    public TappedElement b(float f, float f2) {
        AppMethodBeat.i(98000);
        TappedElement a = this.b.a(f, f2);
        AppMethodBeat.o(98000);
        return a;
    }

    public void g(boolean z) {
        AppMethodBeat.i(98001);
        this.b.i(z);
        AppMethodBeat.o(98001);
    }

    public void h(boolean z) {
        AppMethodBeat.i(98002);
        this.b.j(z);
        AppMethodBeat.o(98002);
    }

    public void c(String str) {
        AppMethodBeat.i(98003);
        this.b.c(str);
        AppMethodBeat.o(98003);
    }

    public void i(boolean z) {
        AppMethodBeat.i(98004);
        this.b.h(z);
        AppMethodBeat.o(98004);
    }

    public boolean E() {
        AppMethodBeat.i(98005);
        boolean B = this.b.B();
        AppMethodBeat.o(98005);
        return B;
    }

    public void F() {
        AppMethodBeat.i(98006);
        this.b.C();
        AppMethodBeat.o(98006);
    }

    public void j(boolean z) {
        AppMethodBeat.i(98007);
        if (this.b != null) {
            this.b.k(z);
        }
        AppMethodBeat.o(98007);
    }

    public String G() {
        AppMethodBeat.i(98008);
        String str = null;
        if (this.b != null) {
            str = this.b.E();
        }
        AppMethodBeat.o(98008);
        return str;
    }

    public void a(String str, String str2) {
        AppMethodBeat.i(98009);
        if (this.b != null) {
            this.b.a(str, str2);
        }
        AppMethodBeat.o(98009);
    }

    public boolean H() {
        return this.a;
    }

    public void k(boolean z) {
        this.a = z;
    }

    public ArrayList<MapPoi> I() {
        AppMethodBeat.i(98010);
        if (this.b == null) {
            AppMethodBeat.o(98010);
            return null;
        }
        ArrayList<MapPoi> G = this.b.G();
        AppMethodBeat.o(98010);
        return G;
    }

    public String J() {
        AppMethodBeat.i(98011);
        if (this.b == null) {
            AppMethodBeat.o(98011);
            return null;
        }
        String H = this.b.H();
        AppMethodBeat.o(98011);
        return H;
    }

    public String K() {
        AppMethodBeat.i(98012);
        if (this.b == null) {
            AppMethodBeat.o(98012);
            return null;
        }
        String I = this.b.I();
        AppMethodBeat.o(98012);
        return I;
    }
}
