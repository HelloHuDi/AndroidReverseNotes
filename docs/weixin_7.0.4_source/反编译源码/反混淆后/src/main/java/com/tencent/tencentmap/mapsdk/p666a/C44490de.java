package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.map.lib.element.C41717j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C16180m;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.a.de */
public final class C44490de implements C36472cv {
    /* renamed from: a */
    private int f17349a = -1;
    /* renamed from: b */
    private boolean f17350b = false;
    /* renamed from: c */
    private C44491df f17351c = null;
    /* renamed from: d */
    private String f17352d = "";
    /* renamed from: e */
    private boolean f17353e = false;
    /* renamed from: f */
    private C44481at f17354f = null;
    /* renamed from: g */
    private boolean f17355g = false;
    /* renamed from: h */
    private int f17356h = 0;
    /* renamed from: i */
    private boolean f17357i = false;
    /* renamed from: j */
    private C16180m f17358j;
    /* renamed from: k */
    private Object f17359k;

    public C44490de(C44491df c44491df, C44481at c44481at, String str) {
        AppMethodBeat.m2504i(100998);
        this.f17352d = str;
        this.f17351c = c44491df;
        this.f17354f = c44481at;
        this.f17357i = c44491df.mo70799q();
        this.f17356h = c44491df.mo70798p();
        this.f17359k = this.f17351c.mo70803u();
        AppMethodBeat.m2505o(100998);
    }

    /* renamed from: b */
    public final void mo70737b() {
        AppMethodBeat.m2504i(100999);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(100999);
            return;
        }
        this.f17354f.mo70673a(this.f17352d);
        AppMethodBeat.m2505o(100999);
    }

    /* renamed from: c */
    public final String mo70741c() {
        return this.f17352d;
    }

    /* renamed from: a */
    public final void mo70732a(C24343db c24343db) {
        AppMethodBeat.m2504i(101000);
        if (this.f17354f == null || c24343db == null) {
            AppMethodBeat.m2505o(101000);
            return;
        }
        this.f17354f.mo70679a(this.f17352d, c24343db);
        this.f17351c.mo70771a(c24343db);
        AppMethodBeat.m2505o(101000);
    }

    /* renamed from: d */
    public final boolean mo70744d() {
        AppMethodBeat.m2504i(101001);
        boolean j = this.f17351c.mo70792j();
        AppMethodBeat.m2505o(101001);
        return j;
    }

    /* renamed from: e */
    public final C24343db mo70745e() {
        AppMethodBeat.m2504i(101002);
        C24343db b = this.f17354f.mo70682b(this.f17352d);
        if (b == null) {
            b = this.f17351c.mo70776b();
        }
        AppMethodBeat.m2505o(101002);
        return b;
    }

    /* renamed from: a */
    public final void mo70734a(String str) {
        AppMethodBeat.m2504i(101003);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101003);
            return;
        }
        this.f17351c.mo70773a(str);
        this.f17354f.mo70685b(this.f17352d, str);
        AppMethodBeat.m2505o(101003);
    }

    /* renamed from: f */
    public final String mo70747f() {
        AppMethodBeat.m2504i(101004);
        String c = this.f17351c.mo70783c();
        AppMethodBeat.m2505o(101004);
        return c;
    }

    /* renamed from: b */
    public final void mo70739b(String str) {
        AppMethodBeat.m2504i(101005);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101005);
            return;
        }
        this.f17351c.mo70778b(str);
        this.f17354f.mo70680a(this.f17352d, str);
        AppMethodBeat.m2505o(101005);
    }

    /* renamed from: g */
    public final String mo70748g() {
        AppMethodBeat.m2504i(101006);
        String d = this.f17351c.mo70785d();
        AppMethodBeat.m2505o(101006);
        return d;
    }

    /* renamed from: h */
    public final float mo70749h() {
        AppMethodBeat.m2504i(101007);
        float k = this.f17351c.mo70793k();
        AppMethodBeat.m2505o(101007);
        return k;
    }

    /* renamed from: a */
    public final void mo70735a(boolean z) {
        AppMethodBeat.m2504i(101008);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101008);
            return;
        }
        this.f17354f.mo70681a(this.f17352d, z);
        C44481at c44481at = this.f17354f;
        String str = this.f17352d;
        boolean z2 = !z && mo70757o();
        c44481at.mo70689c(str, z2);
        this.f17351c.mo70774a(z);
        AppMethodBeat.m2505o(101008);
    }

    /* renamed from: i */
    public final boolean mo70751i() {
        AppMethodBeat.m2504i(101009);
        boolean h = this.f17351c.mo70790h();
        AppMethodBeat.m2505o(101009);
        return h;
    }

    /* renamed from: j */
    public final void mo70752j() {
        AppMethodBeat.m2504i(101010);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101010);
            return;
        }
        this.f17354f.mo70687c(this.f17352d);
        AppMethodBeat.m2505o(101010);
    }

    /* renamed from: k */
    public final void mo70753k() {
        AppMethodBeat.m2504i(101011);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101011);
            return;
        }
        this.f17354f.mo70690d(this.f17352d);
        AppMethodBeat.m2505o(101011);
    }

    /* renamed from: l */
    public final boolean mo70754l() {
        AppMethodBeat.m2504i(101012);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101012);
            return false;
        }
        boolean e = this.f17354f.mo70691e(this.f17352d);
        AppMethodBeat.m2505o(101012);
        return e;
    }

    /* renamed from: a */
    public final void mo70728a(float f, float f2) {
        AppMethodBeat.m2504i(101013);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101013);
            return;
        }
        this.f17354f.mo70675a(this.f17352d, f, f2);
        this.f17351c.mo70766a(f, f2);
        AppMethodBeat.m2505o(101013);
    }

    /* renamed from: b */
    public final void mo70740b(boolean z) {
        AppMethodBeat.m2504i(101014);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101014);
            return;
        }
        this.f17354f.mo70686b(this.f17352d, z);
        this.f17351c.mo70779b(z);
        AppMethodBeat.m2505o(101014);
    }

    /* renamed from: a */
    public final void mo70731a(C41018cm c41018cm) {
        AppMethodBeat.m2504i(101015);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101015);
            return;
        }
        this.f17354f.mo70678a(this.f17352d, c41018cm);
        this.f17351c.mo70769a(c41018cm);
        AppMethodBeat.m2505o(101015);
    }

    /* renamed from: a */
    public final void mo70727a(float f) {
        AppMethodBeat.m2504i(101016);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101016);
            return;
        }
        this.f17354f.mo70674a(this.f17352d, f);
        this.f17351c.mo70765a(f);
        AppMethodBeat.m2505o(101016);
    }

    /* renamed from: m */
    public final float mo70755m() {
        AppMethodBeat.m2504i(101017);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101017);
            return 0.0f;
        }
        float f = this.f17354f.mo70692f(this.f17352d);
        AppMethodBeat.m2505o(101017);
        return f;
    }

    /* renamed from: n */
    public final boolean mo70756n() {
        AppMethodBeat.m2504i(101018);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101018);
            return false;
        }
        boolean i = this.f17351c.mo70791i();
        AppMethodBeat.m2505o(101018);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(101019);
        if (obj instanceof C44490de) {
            boolean equals = this.f17352d.equals(((C44490de) obj).f17352d);
            AppMethodBeat.m2505o(101019);
            return equals;
        }
        AppMethodBeat.m2505o(101019);
        return false;
    }

    /* renamed from: b */
    public final void mo70738b(float f) {
        AppMethodBeat.m2504i(101020);
        if (this.f17354f == null) {
            AppMethodBeat.m2505o(101020);
            return;
        }
        this.f17354f.mo70684b(this.f17352d, f);
        this.f17351c.mo70777b(f);
        AppMethodBeat.m2505o(101020);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final boolean mo70757o() {
        AppMethodBeat.m2504i(101021);
        boolean g = this.f17354f.mo70693g(this.f17352d);
        AppMethodBeat.m2505o(101021);
        return g;
    }

    /* renamed from: a */
    public final void mo70730a(int i, int i2) {
        AppMethodBeat.m2504i(101022);
        this.f17354f.mo70677a(this.f17352d, i, i2);
        this.f17354f.mo70681a(this.f17352d, false);
        this.f17351c.mo70774a(false);
        AppMethodBeat.m2505o(101022);
    }

    /* renamed from: c */
    public final void mo70742c(float f) {
        AppMethodBeat.m2504i(101023);
        this.f17354f.mo70688c(this.f17352d, f);
        this.f17351c.mo70780c(f);
        AppMethodBeat.m2505o(101023);
    }

    /* renamed from: p */
    public final float mo70758p() {
        AppMethodBeat.m2504i(101024);
        if (this.f17351c != null) {
            float l = this.f17351c.mo70794l();
            AppMethodBeat.m2505o(101024);
            return l;
        }
        AppMethodBeat.m2505o(101024);
        return 0.0f;
    }

    /* renamed from: a */
    public final int mo70726a(Context context) {
        AppMethodBeat.m2504i(101025);
        C41018cm e = this.f17351c.mo70786e();
        if (e == null) {
            AppMethodBeat.m2505o(101025);
            return 0;
        }
        Bitmap a = e.mo65065a().mo12311a(context);
        if (a == null) {
            AppMethodBeat.m2505o(101025);
            return 0;
        }
        int width = a.getWidth();
        AppMethodBeat.m2505o(101025);
        return width;
    }

    /* renamed from: b */
    public final int mo70736b(Context context) {
        AppMethodBeat.m2504i(101026);
        C41018cm e = this.f17351c.mo70786e();
        if (e == null) {
            AppMethodBeat.m2505o(101026);
            return 0;
        }
        Bitmap a = e.mo65065a().mo12311a(context);
        if (a == null) {
            AppMethodBeat.m2505o(101026);
            return 0;
        }
        int height = a.getHeight();
        AppMethodBeat.m2505o(101026);
        return height;
    }

    /* renamed from: q */
    public final float mo70759q() {
        AppMethodBeat.m2504i(101027);
        float f = this.f17351c.mo70788f();
        AppMethodBeat.m2505o(101027);
        return f;
    }

    /* renamed from: r */
    public final float mo70760r() {
        AppMethodBeat.m2504i(101028);
        float g = this.f17351c.mo70789g();
        AppMethodBeat.m2505o(101028);
        return g;
    }

    /* renamed from: s */
    public final C16180m mo70761s() {
        return this.f17358j;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(101029);
        int hashCode = this.f17352d.hashCode();
        AppMethodBeat.m2505o(101029);
        return hashCode;
    }

    /* renamed from: a */
    public final List<C41717j> mo12330a() {
        AppMethodBeat.m2504i(101030);
        List h = this.f17354f.mo70694h(this.f17352d);
        AppMethodBeat.m2505o(101030);
        return h;
    }

    /* renamed from: a */
    public final void mo70733a(Object obj) {
        this.f17359k = obj;
    }

    /* renamed from: t */
    public final Object mo70762t() {
        return this.f17359k;
    }

    /* renamed from: c */
    public final void mo70743c(String str) {
        AppMethodBeat.m2504i(101031);
        if (this.f17351c != null) {
            this.f17351c.mo70781c(str);
        }
        AppMethodBeat.m2505o(101031);
    }

    /* renamed from: u */
    public final String mo70763u() {
        AppMethodBeat.m2504i(101032);
        if (this.f17351c != null) {
            String w = this.f17351c.mo70805w();
            AppMethodBeat.m2505o(101032);
            return w;
        }
        AppMethodBeat.m2505o(101032);
        return null;
    }

    /* renamed from: v */
    public final int mo70764v() {
        AppMethodBeat.m2504i(101033);
        int x = this.f17351c.mo70806x();
        AppMethodBeat.m2505o(101033);
        return x;
    }

    /* renamed from: a */
    public final void mo70729a(int i) {
        AppMethodBeat.m2504i(101034);
        if (i < C24347di.f4621a || i > C24347di.f4623c) {
            AppMethodBeat.m2505o(101034);
            return;
        }
        this.f17354f.mo70676a(this.f17352d, i);
        this.f17351c.mo70767a(i);
        AppMethodBeat.m2505o(101034);
    }
}
