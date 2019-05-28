package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.C37423c;
import com.tencent.map.lib.element.C41717j;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.listener.C41721a;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.p822gl.JNICallback.C25720d;
import com.tencent.map.lib.p822gl.JNICallback.C25721e;
import com.tencent.map.lib.p822gl.JNICallback.C32209c;
import com.tencent.map.lib.p822gl.JNICallback.C32210j;
import com.tencent.map.lib.p822gl.JNICallback.C32211b;
import com.tencent.map.lib.p822gl.JNICallback.C32212k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16263gj;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24374fw;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24382gs;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31044fv;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31045fx;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36508fl;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36515gv;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36894gk.C24378a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41049fr;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41050ft;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46785fq;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46789gm;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5884gt;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.map.lib.f */
public class C8889f {
    /* renamed from: a */
    private boolean f2810a = false;
    /* renamed from: b */
    private C46789gm f2811b;
    /* renamed from: c */
    private int f2812c = 20;
    /* renamed from: d */
    private int f2813d = 3;
    /* renamed from: e */
    private GeoPoint f2814e = new GeoPoint();
    /* renamed from: f */
    private int f2815f = 0;

    public C8889f(C46789gm c46789gm) {
        AppMethodBeat.m2504i(97903);
        this.f2811b = c46789gm;
        AppMethodBeat.m2505o(97903);
    }

    /* renamed from: a */
    public void mo20154a() {
        AppMethodBeat.m2504i(97904);
        this.f2811b.mo75472w();
        AppMethodBeat.m2505o(97904);
    }

    /* renamed from: b */
    public int mo20187b() {
        return this.f2813d;
    }

    /* renamed from: c */
    public int mo20203c() {
        return this.f2812c;
    }

    /* renamed from: d */
    public int mo20210d() {
        AppMethodBeat.m2504i(97905);
        int n = this.f2811b.mo12444e().mo40623n();
        AppMethodBeat.m2505o(97905);
        return n;
    }

    /* renamed from: e */
    public int mo20215e() {
        AppMethodBeat.m2504i(97906);
        int u = this.f2811b.mo12440a().mo58857u();
        AppMethodBeat.m2505o(97906);
        return u;
    }

    /* renamed from: a */
    public void mo20159a(int i) {
        AppMethodBeat.m2504i(97907);
        this.f2811b.mo12440a().mo58816b(i);
        AppMethodBeat.m2505o(97907);
    }

    /* renamed from: f */
    public GeoPoint mo20219f() {
        AppMethodBeat.m2504i(97908);
        GeoPoint n = this.f2811b.mo12440a().mo58850n();
        AppMethodBeat.m2505o(97908);
        return n;
    }

    /* renamed from: a */
    public String mo20153a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(97909);
        String a = this.f2811b.mo75408a(geoPoint);
        AppMethodBeat.m2505o(97909);
        return a;
    }

    /* renamed from: b */
    public void mo20191b(int i) {
        AppMethodBeat.m2504i(97910);
        this.f2811b.mo12440a().mo58794a(i);
        AppMethodBeat.m2505o(97910);
    }

    /* renamed from: a */
    public void mo20164a(C41717j c41717j) {
        AppMethodBeat.m2504i(97911);
        this.f2811b.mo12442c().mo65140a(c41717j);
        this.f2811b.mo75465q();
        AppMethodBeat.m2505o(97911);
    }

    /* renamed from: b */
    public void mo20194b(C41717j c41717j) {
        AppMethodBeat.m2504i(97912);
        this.f2811b.mo12442c().mo65145b(c41717j);
        this.f2811b.mo75465q();
        AppMethodBeat.m2505o(97912);
    }

    /* renamed from: a */
    public void mo20172a(C46785fq c46785fq) {
        AppMethodBeat.m2504i(97913);
        this.f2811b.mo12440a().mo58802a(c46785fq);
        AppMethodBeat.m2505o(97913);
    }

    /* renamed from: b */
    public void mo20196b(C46785fq c46785fq) {
        AppMethodBeat.m2504i(97914);
        this.f2811b.mo12440a().mo58821b(c46785fq);
        AppMethodBeat.m2505o(97914);
    }

    /* renamed from: a */
    public void mo20175a(C31044fv c31044fv) {
        AppMethodBeat.m2504i(97915);
        this.f2811b.mo12440a().mo58806a(c31044fv);
        AppMethodBeat.m2505o(97915);
    }

    /* renamed from: b */
    public void mo20198b(C31044fv c31044fv) {
        AppMethodBeat.m2504i(97916);
        this.f2811b.mo12440a().mo58824b(c31044fv);
        AppMethodBeat.m2505o(97916);
    }

    /* renamed from: b */
    public void mo20193b(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(97917);
        this.f2811b.mo12440a().mo58795a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        AppMethodBeat.m2505o(97917);
    }

    /* renamed from: a */
    public void mo20160a(int i, int i2) {
        AppMethodBeat.m2504i(97918);
        this.f2811b.mo12440a().mo58795a(i, i2);
        AppMethodBeat.m2505o(97918);
    }

    /* renamed from: a */
    public void mo20157a(float f) {
        AppMethodBeat.m2504i(97919);
        this.f2811b.mo12440a().mo58830c(f);
        AppMethodBeat.m2505o(97919);
    }

    /* renamed from: b */
    public void mo20190b(float f) {
        AppMethodBeat.m2504i(97920);
        this.f2811b.mo12440a().mo58815b(f);
        AppMethodBeat.m2505o(97920);
    }

    /* renamed from: g */
    public boolean mo20224g() {
        AppMethodBeat.m2504i(97921);
        boolean u = this.f2811b.mo75470u();
        AppMethodBeat.m2505o(97921);
        return u;
    }

    /* renamed from: a */
    public void mo20183a(boolean z) {
        AppMethodBeat.m2504i(97922);
        this.f2811b.mo75429a(z);
        AppMethodBeat.m2505o(97922);
    }

    /* renamed from: h */
    public int mo20225h() {
        AppMethodBeat.m2504i(97923);
        int m = this.f2811b.mo12440a().mo58849m();
        AppMethodBeat.m2505o(97923);
        return m;
    }

    /* renamed from: i */
    public float mo20228i() {
        AppMethodBeat.m2504i(97924);
        float l = this.f2811b.mo12440a().mo58848l();
        AppMethodBeat.m2505o(97924);
        return l;
    }

    /* renamed from: j */
    public float mo20231j() {
        AppMethodBeat.m2504i(97925);
        float h = (float) (((double) ((float) mo20225h())) + (Math.log((double) mo20234k()) / Math.log(2.0d)));
        AppMethodBeat.m2505o(97925);
        return h;
    }

    /* renamed from: k */
    public float mo20234k() {
        AppMethodBeat.m2504i(97926);
        float q = this.f2811b.mo12440a().mo58853q();
        AppMethodBeat.m2505o(97926);
        return q;
    }

    /* renamed from: a */
    public void mo20155a(double d) {
        AppMethodBeat.m2504i(97927);
        this.f2811b.mo12440a().mo58846j(d);
        AppMethodBeat.m2505o(97927);
    }

    /* renamed from: a */
    public void mo20179a(Runnable runnable) {
        AppMethodBeat.m2504i(97928);
        this.f2811b.mo12440a().mo58810a(runnable);
        AppMethodBeat.m2505o(97928);
    }

    /* renamed from: b */
    public void mo20199b(Runnable runnable) {
        AppMethodBeat.m2504i(97929);
        this.f2811b.mo12440a().mo58826b(runnable);
        AppMethodBeat.m2505o(97929);
    }

    /* renamed from: l */
    public void mo20236l() {
        AppMethodBeat.m2504i(97930);
        this.f2811b.mo12440a().mo58855s();
        AppMethodBeat.m2505o(97930);
    }

    /* renamed from: m */
    public void mo20237m() {
        AppMethodBeat.m2504i(97931);
        this.f2811b.mo75467s();
        AppMethodBeat.m2505o(97931);
    }

    /* renamed from: n */
    public void mo20238n() {
        AppMethodBeat.m2504i(97932);
        this.f2811b.mo75468t();
        AppMethodBeat.m2505o(97932);
    }

    /* renamed from: o */
    public void mo20239o() {
        AppMethodBeat.m2504i(97933);
        this.f2811b.mo75466r();
        AppMethodBeat.m2505o(97933);
    }

    /* renamed from: a */
    public boolean mo20186a(String str, byte[] bArr) {
        AppMethodBeat.m2504i(97934);
        C36515gv o = this.f2811b.mo75463o();
        if (o == null) {
            AppMethodBeat.m2505o(97934);
            return false;
        }
        boolean a = o.mo57740a(str, bArr);
        AppMethodBeat.m2505o(97934);
        return a;
    }

    /* renamed from: b */
    public boolean mo20202b(String str, byte[] bArr) {
        AppMethodBeat.m2504i(97935);
        C36515gv o = this.f2811b.mo75463o();
        if (o == null) {
            AppMethodBeat.m2505o(97935);
            return false;
        }
        boolean b = o.mo57743b(str, bArr);
        AppMethodBeat.m2505o(97935);
        return b;
    }

    /* renamed from: p */
    public void mo20240p() {
        AppMethodBeat.m2504i(97936);
        C36515gv o = this.f2811b.mo75463o();
        if (o == null) {
            AppMethodBeat.m2505o(97936);
            return;
        }
        o.mo57744c();
        AppMethodBeat.m2505o(97936);
    }

    /* renamed from: a */
    public void mo20173a(C41049fr c41049fr) {
        AppMethodBeat.m2504i(97937);
        this.f2811b.mo12440a().mo58803a(c41049fr);
        AppMethodBeat.m2505o(97937);
    }

    /* renamed from: a */
    public void mo20174a(C41050ft c41050ft) {
        AppMethodBeat.m2504i(97938);
        this.f2811b.mo12440a().mo58804a(c41050ft);
        AppMethodBeat.m2505o(97938);
    }

    /* renamed from: b */
    public void mo20197b(C41050ft c41050ft) {
        AppMethodBeat.m2504i(97939);
        this.f2811b.mo12440a().mo58822b(c41050ft);
        AppMethodBeat.m2505o(97939);
    }

    /* renamed from: a */
    public void mo20171a(C41721a c41721a) {
        AppMethodBeat.m2504i(97940);
        this.f2811b.mo12442c().mo65141a(c41721a);
        AppMethodBeat.m2505o(97940);
    }

    /* renamed from: a */
    public boolean mo20185a(float f, float f2) {
        AppMethodBeat.m2504i(97941);
        boolean a = this.f2811b.mo12442c().mo65142a(f, f2);
        AppMethodBeat.m2505o(97941);
        return a;
    }

    /* renamed from: q */
    public float mo20241q() {
        AppMethodBeat.m2504i(97942);
        float o = this.f2811b.mo12440a().mo58851o();
        AppMethodBeat.m2505o(97942);
        return o;
    }

    /* renamed from: r */
    public float mo20242r() {
        AppMethodBeat.m2504i(97943);
        float p = this.f2811b.mo12440a().mo58852p();
        AppMethodBeat.m2505o(97943);
        return p;
    }

    /* renamed from: a */
    public int mo20152a(Polygon2D polygon2D) {
        AppMethodBeat.m2504i(97944);
        int a = this.f2811b.mo75406a(polygon2D);
        AppMethodBeat.m2505o(97944);
        return a;
    }

    /* renamed from: b */
    public void mo20195b(Polygon2D polygon2D) {
        AppMethodBeat.m2504i(97945);
        this.f2811b.mo75436b(polygon2D);
        AppMethodBeat.m2505o(97945);
    }

    /* renamed from: c */
    public void mo20206c(int i) {
        AppMethodBeat.m2504i(97946);
        this.f2811b.mo75440c(i);
        AppMethodBeat.m2505o(97946);
    }

    /* renamed from: a */
    public int mo20151a(CircleInfo circleInfo) {
        AppMethodBeat.m2504i(97947);
        int a = this.f2811b.mo75405a(circleInfo);
        AppMethodBeat.m2505o(97947);
        return a;
    }

    /* renamed from: a */
    public void mo20162a(int i, CircleInfo circleInfo) {
        AppMethodBeat.m2504i(97948);
        this.f2811b.mo75414a(i, circleInfo);
        AppMethodBeat.m2505o(97948);
    }

    /* renamed from: d */
    public void mo20212d(int i) {
        AppMethodBeat.m2504i(97949);
        this.f2811b.mo75411a(i);
        AppMethodBeat.m2505o(97949);
    }

    /* renamed from: a */
    public int mo20150a(int i, int i2, int i3, int i4, int i5, float f) {
        AppMethodBeat.m2504i(97950);
        int a = this.f2811b.mo75403a(i, i2, i3, i4, i5, f);
        AppMethodBeat.m2505o(97950);
        return a;
    }

    /* renamed from: b */
    public void mo20192b(int i, int i2) {
        AppMethodBeat.m2504i(97951);
        this.f2811b.mo75441c(i, i2);
        AppMethodBeat.m2505o(97951);
    }

    /* renamed from: e */
    public void mo20217e(int i) {
        AppMethodBeat.m2504i(97952);
        this.f2811b.mo75433b(i);
        AppMethodBeat.m2505o(97952);
    }

    /* renamed from: a */
    public void mo20182a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        AppMethodBeat.m2504i(97953);
        this.f2811b.mo75427a((List) list, (List) list2);
        AppMethodBeat.m2505o(97953);
    }

    /* renamed from: s */
    public void mo20243s() {
        AppMethodBeat.m2504i(97954);
        this.f2811b.mo75471v();
        AppMethodBeat.m2505o(97954);
    }

    /* renamed from: b */
    public void mo20201b(boolean z) {
        AppMethodBeat.m2504i(97955);
        if (this.f2811b != null) {
            this.f2811b.mo75446d(z);
        }
        AppMethodBeat.m2505o(97955);
    }

    /* renamed from: c */
    public void mo20209c(boolean z) {
        AppMethodBeat.m2504i(97956);
        if (this.f2811b != null) {
            this.f2811b.mo75449e(z);
        }
        AppMethodBeat.m2505o(97956);
    }

    /* renamed from: t */
    public C24374fw mo20244t() {
        AppMethodBeat.m2504i(97957);
        C24374fw d = this.f2811b.mo12443d();
        AppMethodBeat.m2505o(97957);
        return d;
    }

    @Deprecated
    /* renamed from: u */
    public C24374fw mo20245u() {
        AppMethodBeat.m2504i(97958);
        C36508fl c36508fl = new C36508fl(this.f2811b);
        AppMethodBeat.m2505o(97958);
        return c36508fl;
    }

    /* renamed from: a */
    public void mo20176a(C31045fx c31045fx) {
        AppMethodBeat.m2504i(97959);
        this.f2811b.mo12440a().mo58831c(c31045fx);
        AppMethodBeat.m2505o(97959);
    }

    /* renamed from: v */
    public void mo20246v() {
        AppMethodBeat.m2504i(97960);
        this.f2811b.mo12440a().mo58778A();
        AppMethodBeat.m2505o(97960);
    }

    /* renamed from: a */
    public int mo20149a(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(97961);
        int a = this.f2811b.mo12440a().mo58783a(i, i2, i3, i4);
        AppMethodBeat.m2505o(97961);
        return a;
    }

    /* renamed from: w */
    public Rect mo20247w() {
        AppMethodBeat.m2504i(97962);
        Rect b = this.f2811b.mo12440a().mo58813b();
        AppMethodBeat.m2505o(97962);
        return b;
    }

    /* renamed from: a */
    public void mo20163a(C1016e c1016e) {
        AppMethodBeat.m2504i(97963);
        this.f2811b.mo12440a().mo58800a(c1016e);
        AppMethodBeat.m2505o(97963);
    }

    /* renamed from: d */
    public void mo20214d(boolean z) {
        AppMethodBeat.m2504i(97964);
        this.f2811b.mo75451f(z);
        AppMethodBeat.m2505o(97964);
    }

    /* renamed from: f */
    public void mo20220f(int i) {
        AppMethodBeat.m2504i(97965);
        this.f2811b.mo75444d(i);
        AppMethodBeat.m2505o(97965);
    }

    /* renamed from: x */
    public int mo20248x() {
        AppMethodBeat.m2504i(97966);
        int o = this.f2811b.mo75454i().mo29402o();
        AppMethodBeat.m2505o(97966);
        return o;
    }

    /* renamed from: y */
    public String[] mo20249y() {
        AppMethodBeat.m2504i(97967);
        String[] x = this.f2811b.mo75473x();
        AppMethodBeat.m2505o(97967);
        return x;
    }

    /* renamed from: c */
    public String mo20204c(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(97968);
        String b = this.f2811b.mo75432b(geoPoint);
        AppMethodBeat.m2505o(97968);
        return b;
    }

    /* renamed from: d */
    public C37423c mo20211d(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(97969);
        C37423c b = this.f2811b.mo75454i().mo29349b(geoPoint);
        AppMethodBeat.m2505o(97969);
        return b;
    }

    /* renamed from: a */
    public void mo20184a(String[] strArr) {
        AppMethodBeat.m2504i(97970);
        this.f2811b.mo75430a(strArr);
        AppMethodBeat.m2505o(97970);
    }

    /* renamed from: g */
    public void mo20222g(int i) {
        AppMethodBeat.m2504i(97971);
        this.f2812c = i;
        this.f2811b.mo75454i().mo29371d(i);
        this.f2811b.mo12444e().mo40607c(i);
        AppMethodBeat.m2505o(97971);
    }

    /* renamed from: h */
    public void mo20226h(int i) {
        AppMethodBeat.m2504i(97972);
        this.f2813d = i;
        this.f2811b.mo75454i().mo29378e(i);
        AppMethodBeat.m2505o(97972);
    }

    /* renamed from: a */
    public void mo20168a(C25721e c25721e) {
        AppMethodBeat.m2504i(97973);
        this.f2811b.mo75419a(c25721e);
        AppMethodBeat.m2505o(97973);
    }

    /* renamed from: a */
    public void mo20177a(C24378a c24378a) {
        AppMethodBeat.m2504i(97974);
        this.f2811b.mo12440a().mo58807a(c24378a);
        AppMethodBeat.m2505o(97974);
    }

    /* renamed from: c */
    public void mo20207c(int i, int i2) {
        AppMethodBeat.m2504i(97975);
        this.f2811b.mo12440a().mo58817b(i, i2);
        AppMethodBeat.m2505o(97975);
    }

    /* renamed from: c */
    public void mo20205c(float f) {
        AppMethodBeat.m2504i(97976);
        this.f2811b.mo12440a().mo58788a(f);
        AppMethodBeat.m2505o(97976);
    }

    /* renamed from: a */
    public void mo20158a(float f, float f2, int i, boolean z) {
        AppMethodBeat.m2504i(97977);
        this.f2811b.mo12440a().mo58793a(f, f2, z);
        AppMethodBeat.m2505o(97977);
    }

    /* renamed from: b */
    public void mo20189b(double d) {
        AppMethodBeat.m2504i(97978);
        this.f2811b.mo12440a().mo58842h(d);
        AppMethodBeat.m2505o(97978);
    }

    /* renamed from: a */
    public void mo20156a(double d, double d2, double d3, double d4, double d5, Runnable runnable) {
        AppMethodBeat.m2504i(97979);
        this.f2811b.mo12440a().mo58787a(d, d2, d3, d4, d5, runnable);
        AppMethodBeat.m2505o(97979);
    }

    /* renamed from: a */
    public void mo20178a(C5884gt c5884gt) {
        AppMethodBeat.m2504i(97980);
        this.f2811b.mo12440a().mo58809a(c5884gt);
        AppMethodBeat.m2505o(97980);
    }

    /* renamed from: z */
    public C16263gj mo20250z() {
        AppMethodBeat.m2504i(97981);
        C16263gj z = this.f2811b.mo75475z();
        AppMethodBeat.m2505o(97981);
        return z;
    }

    /* renamed from: A */
    public C24382gs mo20138A() {
        AppMethodBeat.m2504i(97982);
        C24382gs e = this.f2811b.mo12444e();
        AppMethodBeat.m2505o(97982);
        return e;
    }

    /* renamed from: B */
    public int mo20139B() {
        AppMethodBeat.m2504i(97983);
        int a = this.f2811b.mo75404a(3, true);
        AppMethodBeat.m2505o(97983);
        return a;
    }

    /* renamed from: C */
    public int mo20140C() {
        AppMethodBeat.m2504i(97984);
        int a = this.f2811b.mo75404a(2, true);
        AppMethodBeat.m2505o(97984);
        return a;
    }

    /* renamed from: e */
    public int mo20216e(boolean z) {
        AppMethodBeat.m2504i(97985);
        int a = this.f2811b.mo75404a(1, z);
        AppMethodBeat.m2505o(97985);
        return a;
    }

    /* renamed from: i */
    public void mo20229i(int i) {
        AppMethodBeat.m2504i(97986);
        this.f2811b.mo75447e(i);
        AppMethodBeat.m2505o(97986);
    }

    /* renamed from: j */
    public void mo20232j(int i) {
        AppMethodBeat.m2504i(97987);
        this.f2811b.mo75450f(i);
        AppMethodBeat.m2505o(97987);
    }

    /* renamed from: a */
    public void mo20161a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(97988);
        this.f2811b.mo75413a(i, i2, i3);
        AppMethodBeat.m2505o(97988);
    }

    /* renamed from: a */
    public void mo20167a(C25720d c25720d) {
        AppMethodBeat.m2504i(97989);
        this.f2811b.mo75418a(c25720d);
        AppMethodBeat.m2505o(97989);
    }

    /* renamed from: a */
    public void mo20169a(C32210j c32210j) {
        AppMethodBeat.m2504i(97990);
        this.f2811b.mo75420a(c32210j);
        AppMethodBeat.m2505o(97990);
    }

    /* renamed from: a */
    public void mo20165a(C32211b c32211b) {
        AppMethodBeat.m2504i(97991);
        this.f2811b.mo75416a(c32211b);
        AppMethodBeat.m2505o(97991);
    }

    /* renamed from: a */
    public void mo20166a(C32209c c32209c) {
        AppMethodBeat.m2504i(97992);
        this.f2811b.mo75417a(c32209c);
        AppMethodBeat.m2505o(97992);
    }

    /* renamed from: a */
    public void mo20170a(C32212k c32212k) {
        AppMethodBeat.m2504i(97993);
        this.f2811b.mo75421a(c32212k);
        AppMethodBeat.m2505o(97993);
    }

    /* renamed from: d */
    public void mo20213d(int i, int i2) {
        AppMethodBeat.m2504i(97994);
        this.f2811b.mo75445d(i, i2);
        AppMethodBeat.m2505o(97994);
    }

    /* renamed from: f */
    public void mo20221f(boolean z) {
        AppMethodBeat.m2504i(97995);
        this.f2811b.mo75452g(z);
        AppMethodBeat.m2505o(97995);
    }

    /* renamed from: e */
    public void mo20218e(int i, int i2) {
        AppMethodBeat.m2504i(97996);
        this.f2811b.mo75448e(i, i2);
        AppMethodBeat.m2505o(97996);
    }

    /* renamed from: a */
    public void mo20180a(String str) {
        AppMethodBeat.m2504i(97997);
        this.f2811b.mo75437b(str);
        AppMethodBeat.m2505o(97997);
    }

    /* renamed from: D */
    public MapLanguage mo20141D() {
        AppMethodBeat.m2504i(97998);
        MapLanguage y = this.f2811b.mo75474y();
        AppMethodBeat.m2505o(97998);
        return y;
    }

    /* renamed from: b */
    public void mo20200b(String str) {
        AppMethodBeat.m2504i(97999);
        this.f2811b.mo75424a(str);
        AppMethodBeat.m2505o(97999);
    }

    /* renamed from: b */
    public TappedElement mo20188b(float f, float f2) {
        AppMethodBeat.m2504i(98000);
        TappedElement a = this.f2811b.mo75407a(f, f2);
        AppMethodBeat.m2505o(98000);
        return a;
    }

    /* renamed from: g */
    public void mo20223g(boolean z) {
        AppMethodBeat.m2504i(98001);
        this.f2811b.mo75455i(z);
        AppMethodBeat.m2505o(98001);
    }

    /* renamed from: h */
    public void mo20227h(boolean z) {
        AppMethodBeat.m2504i(98002);
        this.f2811b.mo75456j(z);
        AppMethodBeat.m2505o(98002);
    }

    /* renamed from: c */
    public void mo20208c(String str) {
        AppMethodBeat.m2504i(98003);
        this.f2811b.mo75442c(str);
        AppMethodBeat.m2505o(98003);
    }

    /* renamed from: i */
    public void mo20230i(boolean z) {
        AppMethodBeat.m2504i(98004);
        this.f2811b.mo75453h(z);
        AppMethodBeat.m2505o(98004);
    }

    /* renamed from: E */
    public boolean mo20142E() {
        AppMethodBeat.m2504i(98005);
        boolean B = this.f2811b.mo75395B();
        AppMethodBeat.m2505o(98005);
        return B;
    }

    /* renamed from: F */
    public void mo20143F() {
        AppMethodBeat.m2504i(98006);
        this.f2811b.mo75396C();
        AppMethodBeat.m2505o(98006);
    }

    /* renamed from: j */
    public void mo20233j(boolean z) {
        AppMethodBeat.m2504i(98007);
        if (this.f2811b != null) {
            this.f2811b.mo75459k(z);
        }
        AppMethodBeat.m2505o(98007);
    }

    /* renamed from: G */
    public String mo20144G() {
        AppMethodBeat.m2504i(98008);
        String str = null;
        if (this.f2811b != null) {
            str = this.f2811b.mo75398E();
        }
        AppMethodBeat.m2505o(98008);
        return str;
    }

    /* renamed from: a */
    public void mo20181a(String str, String str2) {
        AppMethodBeat.m2504i(98009);
        if (this.f2811b != null) {
            this.f2811b.mo75425a(str, str2);
        }
        AppMethodBeat.m2505o(98009);
    }

    /* renamed from: H */
    public boolean mo20145H() {
        return this.f2810a;
    }

    /* renamed from: k */
    public void mo20235k(boolean z) {
        this.f2810a = z;
    }

    /* renamed from: I */
    public ArrayList<MapPoi> mo20146I() {
        AppMethodBeat.m2504i(98010);
        if (this.f2811b == null) {
            AppMethodBeat.m2505o(98010);
            return null;
        }
        ArrayList<MapPoi> G = this.f2811b.mo75400G();
        AppMethodBeat.m2505o(98010);
        return G;
    }

    /* renamed from: J */
    public String mo20147J() {
        AppMethodBeat.m2504i(98011);
        if (this.f2811b == null) {
            AppMethodBeat.m2505o(98011);
            return null;
        }
        String H = this.f2811b.mo75401H();
        AppMethodBeat.m2505o(98011);
        return H;
    }

    /* renamed from: K */
    public String mo20148K() {
        AppMethodBeat.m2504i(98012);
        if (this.f2811b == null) {
            AppMethodBeat.m2505o(98012);
            return null;
        }
        String I = this.f2811b.mo75402I();
        AppMethodBeat.m2505o(98012);
        return I;
    }
}
