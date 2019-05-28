package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.location.Location;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16287jk;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24414lq;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24415ls;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36520ic;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46801ln;
import com.tencent.tencentmap.mapsdk.p666a.C36463bi.C16187a;

/* renamed from: com.tencent.tencentmap.mapsdk.a.aj */
public final class C30982aj {
    /* renamed from: J */
    private static int f13924J = 1;
    /* renamed from: a */
    public static final int f13925a = (C16203q.f3120a + 0);
    /* renamed from: b */
    public static final int f13926b = (C16203q.f3120a + 9);
    /* renamed from: c */
    public static final int f13927c = (C16203q.f3120a + 10);
    @Deprecated
    /* renamed from: d */
    public static final int f13928d = (C16203q.f3120a + 11);
    /* renamed from: e */
    public static final int f13929e = (C16203q.f3120a + 13);
    /* renamed from: f */
    public static final int f13930f = (C16203q.f3120a + 12);
    @Deprecated
    /* renamed from: g */
    public static final int f13931g = f13926b;
    @Deprecated
    /* renamed from: h */
    public static final int f13932h = f13929e;
    /* renamed from: A */
    private C46750au f13933A;
    /* renamed from: B */
    private C30999ci f13934B;
    /* renamed from: C */
    private C36460bh f13935C;
    /* renamed from: D */
    private C30994bm f13936D;
    /* renamed from: E */
    private C16183ax f13937E;
    /* renamed from: F */
    private boolean f13938F;
    /* renamed from: G */
    private C24328ap f13939G;
    /* renamed from: H */
    private C41007am f13940H;
    /* renamed from: I */
    private C36456ac f13941I;
    /* renamed from: K */
    private final C16187a f13942K;
    /* renamed from: i */
    private C25001ar f13943i;
    /* renamed from: j */
    private C16287jk f13944j;
    /* renamed from: k */
    private C30995bs f13945k;
    /* renamed from: l */
    private C44485bq f13946l;
    /* renamed from: m */
    private C16186bd f13947m;
    /* renamed from: n */
    private C16184bb f13948n;
    /* renamed from: o */
    private C46940aw f13949o;
    /* renamed from: p */
    private C41009av f13950p;
    /* renamed from: q */
    private C41016cj f13951q;
    /* renamed from: r */
    private C24337bn f13952r;
    /* renamed from: s */
    private C24336ay f13953s;
    /* renamed from: t */
    private C16188bk f13954t;
    /* renamed from: u */
    private C30980ai f13955u;
    /* renamed from: v */
    private C41012br f13956v;
    /* renamed from: w */
    private C41011bp f13957w;
    /* renamed from: x */
    private C16185bc f13958x;
    /* renamed from: y */
    private C46753ba f13959y;
    /* renamed from: z */
    private C44481at f13960z;

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$p */
    public interface C5835p {
        /* renamed from: a */
        void mo12295a(Bitmap bitmap);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$d */
    public interface C16179d {
        /* renamed from: a */
        void mo29055a();
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$m */
    public interface C16180m {
        /* renamed from: a */
        void mo29056a(C44490de c44490de);

        /* renamed from: b */
        void mo29057b(C44490de c44490de);

        /* renamed from: c */
        void mo29058c(C44490de c44490de);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$1 */
    class C243251 implements C16187a {
        C243251() {
        }

        /* renamed from: a */
        public void mo29103a() {
            AppMethodBeat.m2504i(98311);
            C30982aj.this.mo50135c(true);
            Location k = C30982aj.this.mo50148k();
            if (k != null) {
                C30982aj.this.mo50129b(C46747ae.m88614a(new C24343db(k.getLatitude(), k.getLongitude())));
            }
            AppMethodBeat.m2505o(98311);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$f */
    public interface C24326f {
        boolean onIndoorBuildingDeactivated();

        boolean onIndoorBuildingFocused();

        boolean onIndoorLevelActivated(C31000cw c31000cw);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$o */
    public interface C24327o {
        /* renamed from: a */
        void mo40414a(C31003dl c31003dl, C24343db c24343db);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$g */
    public interface C30981g {
        /* renamed from: a */
        void mo29181a(int i, int i2, int i3, int i4);

        /* renamed from: a */
        void mo29182a(C44490de c44490de);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$e */
    public interface C30983e {
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$n */
    public interface C30984n {
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$h */
    public interface C30985h {
        /* renamed from: a */
        void mo50164a(C24343db c24343db);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$j */
    public interface C30986j {
        /* renamed from: a */
        void mo50165a(C24343db c24343db);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$k */
    public interface C30987k {
        /* renamed from: a */
        void mo29183a(C24346dd c24346dd);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$a */
    public interface C30988a {
        /* renamed from: a */
        void mo50166a();

        /* renamed from: b */
        void mo50167b();
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$b */
    public interface C30989b {
        /* renamed from: a */
        View mo29179a(C44490de c44490de);

        /* renamed from: b */
        View mo29180b(C44490de c44490de);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$c */
    public interface C30990c {
        void onCameraChange(C5841cp c5841cp);

        void onCameraChangeFinished(C5841cp c5841cp);
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$i */
    public interface C30991i {
        /* renamed from: a */
        void mo50170a();
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.a.aj$l */
    public interface C30992l {
        /* renamed from: a */
        boolean mo50171a(C44490de c44490de);
    }

    protected C30982aj(C36456ac c36456ac, Context context, C44480ak c44480ak) {
        AppMethodBeat.m2504i(98312);
        this.f13943i = null;
        this.f13944j = null;
        this.f13945k = null;
        this.f13946l = null;
        this.f13947m = null;
        this.f13948n = null;
        this.f13949o = null;
        this.f13950p = null;
        this.f13951q = null;
        this.f13954t = null;
        this.f13955u = null;
        this.f13956v = null;
        this.f13957w = null;
        this.f13958x = null;
        this.f13959y = null;
        this.f13960z = null;
        this.f13933A = null;
        this.f13934B = null;
        this.f13935C = null;
        this.f13938F = false;
        this.f13939G = null;
        this.f13941I = null;
        this.f13942K = new C243251();
        C36520ic.m60486b(context);
        C36520ic.m60478a(context);
        this.f13941I = c36456ac;
        C46801ln.m88998a().mo75516a(context);
        C24414lq.m37989a(context);
        this.f13943i = new C25001ar(c36456ac.getMapViewType(), c36456ac, c44480ak);
        this.f13954t = new C16188bk(this.f13943i);
        this.f13939G = new C24328ap(this.f13943i, mo50127b());
        this.f13956v = new C41012br(this.f13943i);
        this.f13949o = new C46940aw(this.f13941I, this.f13954t.mo29105b());
        this.f13960z = new C44481at(this.f13949o);
        this.f13947m = new C16186bd(this.f13954t.mo29105b());
        this.f13958x = new C16185bc(this.f13947m);
        this.f13948n = new C16184bb(this.f13954t.mo29105b());
        this.f13959y = new C46753ba(this.f13948n);
        this.f13946l = new C44485bq(this.f13954t.mo29105b());
        this.f13957w = new C41011bp(this.f13946l);
        this.f13935C = new C36460bh(this.f13943i.mo41898a());
        this.f13943i.mo41900a(this.f13942K);
        this.f13943i.mo41901a(this.f13960z, c44480ak);
        this.f13944j = new C16287jk(this.f13943i, c44480ak);
        this.f13944j.mo29531a(this.f13960z, c44480ak);
        this.f13944j.mo29530a();
        C24415ls.m37998a(0, C31016w.m49806a(context));
        AppMethodBeat.m2505o(98312);
    }

    protected C30982aj() {
        AppMethodBeat.m2504i(98313);
        this.f13943i = null;
        this.f13944j = null;
        this.f13945k = null;
        this.f13946l = null;
        this.f13947m = null;
        this.f13948n = null;
        this.f13949o = null;
        this.f13950p = null;
        this.f13951q = null;
        this.f13954t = null;
        this.f13955u = null;
        this.f13956v = null;
        this.f13957w = null;
        this.f13958x = null;
        this.f13959y = null;
        this.f13960z = null;
        this.f13933A = null;
        this.f13934B = null;
        this.f13935C = null;
        this.f13938F = false;
        this.f13939G = null;
        this.f13941I = null;
        this.f13942K = new C243251();
        this.f13943i = new C25001ar(0, null, null);
        this.f13939G = new C24328ap(this.f13943i, mo50127b());
        AppMethodBeat.m2505o(98313);
    }

    /* renamed from: a */
    public static int m49609a() {
        return f13924J;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final C16188bk mo50127b() {
        return this.f13954t;
    }

    /* renamed from: c */
    public final C25001ar mo50132c() {
        return this.f13943i;
    }

    /* renamed from: d */
    public final C5841cp mo50136d() {
        AppMethodBeat.m2504i(98314);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98314);
            return null;
        }
        C5841cp b = this.f13956v.mo65023b();
        AppMethodBeat.m2505o(98314);
        return b;
    }

    /* renamed from: e */
    public final float mo50138e() {
        AppMethodBeat.m2504i(98315);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98315);
            return 0.0f;
        }
        float c = this.f13956v.mo65027c();
        AppMethodBeat.m2505o(98315);
        return c;
    }

    /* renamed from: f */
    public final float mo50140f() {
        AppMethodBeat.m2504i(98316);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98316);
            return 0.0f;
        }
        float d = this.f13956v.mo65029d();
        AppMethodBeat.m2505o(98316);
        return d;
    }

    /* renamed from: a */
    public final void mo50108a(C41004ad c41004ad) {
        AppMethodBeat.m2504i(98317);
        if (this.f13938F || this.f13956v == null || this.f13956v.mo65044q()) {
            AppMethodBeat.m2505o(98317);
            return;
        }
        this.f13956v.mo65004a(c41004ad);
        AppMethodBeat.m2505o(98317);
    }

    /* renamed from: b */
    public final void mo50129b(C41004ad c41004ad) {
        AppMethodBeat.m2504i(98318);
        if (this.f13938F || this.f13956v == null || this.f13956v.mo65044q()) {
            AppMethodBeat.m2505o(98318);
            return;
        }
        this.f13956v.mo65005a(c41004ad, 500, null);
        AppMethodBeat.m2505o(98318);
    }

    /* renamed from: a */
    public final void mo50110a(C41004ad c41004ad, C30988a c30988a) {
        AppMethodBeat.m2504i(98319);
        if (this.f13938F || this.f13956v == null || this.f13956v.mo65044q()) {
            AppMethodBeat.m2505o(98319);
            return;
        }
        this.f13956v.mo65005a(c41004ad, 500, c30988a);
        AppMethodBeat.m2505o(98319);
    }

    /* renamed from: a */
    public final void mo50109a(C41004ad c41004ad, long j, C30988a c30988a) {
        AppMethodBeat.m2504i(98320);
        if (this.f13938F || this.f13956v == null || this.f13956v.mo65044q()) {
            AppMethodBeat.m2505o(98320);
            return;
        }
        this.f13956v.mo65005a(c41004ad, j, c30988a);
        AppMethodBeat.m2505o(98320);
    }

    /* renamed from: g */
    public final void mo50142g() {
        AppMethodBeat.m2504i(98321);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98321);
            return;
        }
        this.f13956v.mo65031e();
        AppMethodBeat.m2505o(98321);
    }

    /* renamed from: a */
    public final C31003dl mo50104a(C31004dm c31004dm) {
        AppMethodBeat.m2504i(98322);
        if (this.f13938F || this.f13958x == null || c31004dm == null) {
            AppMethodBeat.m2505o(98322);
            return null;
        }
        C31003dl a = this.f13958x.mo29074a(c31004dm);
        AppMethodBeat.m2505o(98322);
        return a;
    }

    /* renamed from: a */
    public final C31002dj mo50103a(C16192dk c16192dk) {
        AppMethodBeat.m2504i(98323);
        if (this.f13938F || this.f13959y == null || c16192dk == null) {
            AppMethodBeat.m2505o(98323);
            return null;
        }
        C31002dj a = this.f13959y.mo75295a(c16192dk);
        AppMethodBeat.m2505o(98323);
        return a;
    }

    /* renamed from: a */
    public final C5843cq mo50101a(C5844cr c5844cr) {
        AppMethodBeat.m2504i(98324);
        if (this.f13938F || this.f13957w == null || c5844cr == null) {
            AppMethodBeat.m2505o(98324);
            return null;
        }
        C5843cq a = this.f13957w.mo64991a(c5844cr);
        AppMethodBeat.m2505o(98324);
        return a;
    }

    /* renamed from: a */
    public final C44490de mo50102a(C44491df c44491df) {
        AppMethodBeat.m2504i(98325);
        if (this.f13938F || this.f13960z == null || c44491df == null) {
            AppMethodBeat.m2505o(98325);
            return null;
        }
        C44490de a = this.f13960z.mo70669a(c44491df, this.f13960z);
        AppMethodBeat.m2505o(98325);
        return a;
    }

    /* renamed from: h */
    public final void mo50144h() {
        AppMethodBeat.m2504i(98326);
        if (this.f13958x != null) {
            this.f13958x.mo29084b();
        }
        if (this.f13959y != null) {
            this.f13959y.mo75303b();
        }
        if (this.f13957w != null) {
            this.f13957w.mo65000b();
        }
        if (this.f13960z != null) {
            this.f13960z.mo70683b();
        }
        if (this.f13936D != null) {
            this.f13936D.mo50180b();
        }
        AppMethodBeat.m2505o(98326);
    }

    @Deprecated
    /* renamed from: a */
    public final void mo50107a(int i) {
        AppMethodBeat.m2504i(98327);
        mo50128b(i);
        AppMethodBeat.m2505o(98327);
    }

    /* renamed from: b */
    public final void mo50128b(int i) {
        AppMethodBeat.m2504i(98328);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98328);
            return;
        }
        this.f13956v.mo65009a(i);
        AppMethodBeat.m2505o(98328);
    }

    /* renamed from: i */
    public final boolean mo50146i() {
        AppMethodBeat.m2504i(98329);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98329);
            return false;
        }
        boolean f = this.f13956v.mo65033f();
        AppMethodBeat.m2505o(98329);
        return f;
    }

    /* renamed from: a */
    public final void mo50126a(boolean z) {
        AppMethodBeat.m2504i(98330);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98330);
            return;
        }
        this.f13956v.mo65022a(z);
        AppMethodBeat.m2505o(98330);
    }

    /* renamed from: b */
    public final void mo50131b(boolean z) {
        AppMethodBeat.m2504i(98331);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98331);
            return;
        }
        this.f13956v.mo65026b(z);
        AppMethodBeat.m2505o(98331);
    }

    /* renamed from: j */
    public final boolean mo50147j() {
        AppMethodBeat.m2504i(98332);
        if (this.f13938F) {
            AppMethodBeat.m2505o(98332);
            return false;
        }
        m49606A();
        boolean e = this.f13934B.mo50189e();
        AppMethodBeat.m2505o(98332);
        return e;
    }

    /* renamed from: A */
    private void m49606A() {
        AppMethodBeat.m2504i(98333);
        if (this.f13951q == null) {
            this.f13951q = new C41016cj(this.f13960z, this.f13957w, this.f13956v);
        }
        if (this.f13934B == null) {
            this.f13934B = new C30999ci(this.f13951q);
        }
        AppMethodBeat.m2505o(98333);
    }

    /* renamed from: c */
    public final void mo50135c(boolean z) {
        AppMethodBeat.m2504i(98334);
        if (this.f13938F) {
            AppMethodBeat.m2505o(98334);
            return;
        }
        m49606A();
        if (!z) {
            this.f13934B.mo50188d();
            AppMethodBeat.m2505o(98334);
        } else if (mo50147j()) {
            AppMethodBeat.m2505o(98334);
        } else {
            this.f13934B.mo50187c();
            AppMethodBeat.m2505o(98334);
        }
    }

    /* renamed from: k */
    public final Location mo50148k() {
        AppMethodBeat.m2504i(98335);
        if (this.f13938F) {
            AppMethodBeat.m2505o(98335);
            return null;
        }
        m49606A();
        Location b = this.f13934B.mo50186b();
        AppMethodBeat.m2505o(98335);
        return b;
    }

    /* renamed from: l */
    public final C41007am mo50149l() {
        AppMethodBeat.m2504i(98336);
        if (this.f13938F) {
            AppMethodBeat.m2505o(98336);
            return null;
        }
        if (this.f13940H == null) {
            this.f13940H = new C41007am(this.f13935C);
        }
        C41007am c41007am = this.f13940H;
        AppMethodBeat.m2505o(98336);
        return c41007am;
    }

    /* renamed from: m */
    public final C30980ai mo50150m() {
        AppMethodBeat.m2504i(98337);
        if (this.f13938F || this.f13943i == null) {
            AppMethodBeat.m2505o(98337);
            return null;
        }
        if (this.f13955u == null) {
            this.f13955u = new C30980ai(this.f13943i);
        }
        C30980ai c30980ai = this.f13955u;
        AppMethodBeat.m2505o(98337);
        return c30980ai;
    }

    /* renamed from: a */
    public final void mo50112a(C30990c c30990c) {
        AppMethodBeat.m2504i(98338);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98338);
            return;
        }
        this.f13956v.mo65010a(c30990c);
        AppMethodBeat.m2505o(98338);
    }

    /* renamed from: a */
    public final void mo50115a(C30985h c30985h) {
        AppMethodBeat.m2504i(98339);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98339);
            return;
        }
        this.f13956v.mo65013a(c30985h);
        AppMethodBeat.m2505o(98339);
    }

    /* renamed from: a */
    public final void mo50117a(C30986j c30986j) {
        AppMethodBeat.m2504i(98340);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98340);
            return;
        }
        this.f13956v.mo65015a(c30986j);
        AppMethodBeat.m2505o(98340);
    }

    /* renamed from: a */
    public final void mo50116a(C30991i c30991i) {
        AppMethodBeat.m2504i(98341);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98341);
            return;
        }
        this.f13956v.mo65014a(c30991i);
        AppMethodBeat.m2505o(98341);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: n */
    public final void mo50151n() {
        AppMethodBeat.m2504i(98342);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98342);
            return;
        }
        this.f13956v.mo65034g();
        AppMethodBeat.m2505o(98342);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: o */
    public final void mo50152o() {
        AppMethodBeat.m2504i(98343);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98343);
            return;
        }
        this.f13956v.mo65035h();
        AppMethodBeat.m2505o(98343);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: p */
    public final void mo50153p() {
        AppMethodBeat.m2504i(98344);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98344);
            return;
        }
        this.f13956v.mo65036i();
        AppMethodBeat.m2505o(98344);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: q */
    public final void mo50154q() {
        AppMethodBeat.m2504i(98345);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98345);
            return;
        }
        this.f13956v.mo65037j();
        AppMethodBeat.m2505o(98345);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final void mo50155r() {
        AppMethodBeat.m2504i(98346);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98346);
            return;
        }
        this.f13956v.mo65038k();
        AppMethodBeat.m2505o(98346);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: s */
    public final void mo50156s() {
        AppMethodBeat.m2504i(98347);
        if (this.f13938F) {
            AppMethodBeat.m2505o(98347);
            return;
        }
        if (this.f13956v != null) {
            this.f13956v.mo65039l();
        }
        if (this.f13944j != null) {
            this.f13944j.mo29534b();
        }
        m49608C();
        m49607B();
        this.f13938F = true;
        AppMethodBeat.m2505o(98347);
    }

    /* renamed from: B */
    private void m49607B() {
        AppMethodBeat.m2504i(98348);
        if (this.f13951q != null) {
            this.f13951q.mo65063e();
            this.f13951q = null;
        }
        if (this.f13949o != null) {
            this.f13949o.mo76205a();
            this.f13949o = null;
        }
        if (this.f13948n != null) {
            this.f13948n.mo29063a();
            this.f13948n = null;
        }
        if (this.f13947m != null) {
            this.f13947m.mo29089a();
            this.f13947m = null;
        }
        if (this.f13946l != null) {
            this.f13946l.mo70700a();
            this.f13946l = null;
        }
        if (this.f13943i != null) {
            this.f13943i.mo41907d();
            this.f13943i = null;
        }
        if (this.f13952r != null) {
            this.f13952r.mo40427a();
            this.f13952r = null;
        }
        if (this.f13950p != null) {
            this.f13950p.mo64990a();
            this.f13950p = null;
        }
        if (this.f13953s != null) {
            this.f13953s.mo40426a();
        }
        AppMethodBeat.m2505o(98348);
    }

    /* renamed from: C */
    private void m49608C() {
        AppMethodBeat.m2504i(98349);
        if (this.f13935C != null) {
            this.f13935C.mo57663a();
            this.f13935C = null;
        }
        if (this.f13934B != null) {
            this.f13934B.mo50185a();
            this.f13934B = null;
        }
        if (this.f13960z != null) {
            this.f13960z.mo70670a();
            this.f13960z = null;
        }
        if (this.f13959y != null) {
            this.f13959y.mo75296a();
            this.f13959y = null;
        }
        if (this.f13958x != null) {
            this.f13958x.mo29075a();
            this.f13958x = null;
        }
        if (this.f13957w != null) {
            this.f13957w.mo64992a();
            this.f13957w = null;
        }
        if (this.f13936D != null) {
            this.f13936D.mo50179a();
            this.f13936D = null;
        }
        if (this.f13933A != null) {
            this.f13933A.mo75294a();
            this.f13933A = null;
        }
        if (this.f13937E != null) {
            this.f13937E.mo29061a();
            this.f13937E = null;
        }
        if (this.f13956v != null) {
            this.f13956v.mo65007a();
            this.f13956v = null;
        }
        if (this.f13955u != null) {
            this.f13955u.mo50099a();
            this.f13955u = null;
        }
        if (this.f13954t != null) {
            this.f13954t.mo29104a();
            this.f13954t = null;
        }
        AppMethodBeat.m2505o(98349);
    }

    /* renamed from: a */
    public final void mo50122a(C5835p c5835p, Config config) {
        AppMethodBeat.m2504i(98350);
        if (this.f13956v != null) {
            this.f13956v.mo65018a(c5835p, config);
        }
        AppMethodBeat.m2505o(98350);
    }

    /* renamed from: a */
    public final void mo50121a(C5835p c5835p) {
        AppMethodBeat.m2504i(98351);
        mo50122a(c5835p, Config.ARGB_8888);
        AppMethodBeat.m2505o(98351);
    }

    @Deprecated
    /* renamed from: a */
    public final void mo50124a(C44494dn c44494dn) {
        AppMethodBeat.m2504i(98352);
        mo50130b(c44494dn);
        AppMethodBeat.m2505o(98352);
    }

    /* renamed from: b */
    public final void mo50130b(C44494dn c44494dn) {
        AppMethodBeat.m2504i(98353);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98353);
            return;
        }
        this.f13956v.mo65020a(c44494dn);
        AppMethodBeat.m2505o(98353);
    }

    /* renamed from: c */
    public final void mo50134c(C44494dn c44494dn) {
        AppMethodBeat.m2504i(98354);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98354);
            return;
        }
        this.f13956v.mo65025b(c44494dn);
        AppMethodBeat.m2505o(98354);
    }

    /* renamed from: a */
    public final void mo50106a(float f, float f2, boolean z) {
        AppMethodBeat.m2504i(98355);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98355);
            return;
        }
        this.f13956v.mo65008a(f, f2, z);
        AppMethodBeat.m2505o(98355);
    }

    /* renamed from: t */
    public final String mo50157t() {
        AppMethodBeat.m2504i(98356);
        String str;
        if (this.f13938F || this.f13956v == null) {
            str = "";
            AppMethodBeat.m2505o(98356);
            return str;
        }
        str = this.f13956v.mo65040m();
        AppMethodBeat.m2505o(98356);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final void mo50137d(boolean z) {
        AppMethodBeat.m2504i(98357);
        if (this.f13938F || this.f13943i == null) {
            AppMethodBeat.m2505o(98357);
            return;
        }
        this.f13943i.mo41906c(z);
        AppMethodBeat.m2505o(98357);
    }

    /* renamed from: e */
    public final void mo50139e(boolean z) {
        AppMethodBeat.m2504i(98358);
        if (this.f13938F || this.f13943i == null) {
            AppMethodBeat.m2505o(98358);
            return;
        }
        this.f13943i.mo41902a(z, false);
        AppMethodBeat.m2505o(98358);
    }

    /* renamed from: a */
    public final void mo50119a(C30992l c30992l) {
        AppMethodBeat.m2504i(98359);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98359);
            return;
        }
        this.f13956v.mo65017a(c30992l);
        AppMethodBeat.m2505o(98359);
    }

    /* renamed from: a */
    public final void mo50120a(C16180m c16180m) {
        AppMethodBeat.m2504i(98360);
        if (this.f13938F || this.f13960z == null) {
            AppMethodBeat.m2505o(98360);
            return;
        }
        this.f13960z.mo70672a(c16180m);
        AppMethodBeat.m2505o(98360);
    }

    /* renamed from: a */
    public final void mo50114a(C30981g c30981g) {
        AppMethodBeat.m2504i(98361);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98361);
            return;
        }
        this.f13956v.mo65012a(c30981g);
        AppMethodBeat.m2505o(98361);
    }

    /* renamed from: a */
    public final void mo50111a(C30989b c30989b) {
        AppMethodBeat.m2504i(98362);
        if (this.f13938F || this.f13960z == null) {
            AppMethodBeat.m2505o(98362);
            return;
        }
        this.f13960z.mo70671a(c30989b);
        AppMethodBeat.m2505o(98362);
    }

    /* renamed from: a */
    public final void mo50113a(C24326f c24326f) {
        AppMethodBeat.m2504i(98363);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98363);
            return;
        }
        this.f13956v.mo65011a(c24326f);
        AppMethodBeat.m2505o(98363);
    }

    /* renamed from: f */
    public final void mo50141f(boolean z) {
        AppMethodBeat.m2504i(98364);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98364);
            return;
        }
        this.f13956v.mo65028c(z);
        AppMethodBeat.m2505o(98364);
    }

    /* renamed from: c */
    public final void mo50133c(int i) {
        AppMethodBeat.m2504i(98365);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98365);
            return;
        }
        this.f13956v.mo65024b(i);
        AppMethodBeat.m2505o(98365);
    }

    /* renamed from: u */
    public final int mo50158u() {
        AppMethodBeat.m2504i(98366);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98366);
            return -1;
        }
        int n = this.f13956v.mo65041n();
        AppMethodBeat.m2505o(98366);
        return n;
    }

    /* renamed from: v */
    public final String[] mo50159v() {
        AppMethodBeat.m2504i(98367);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98367);
            return null;
        }
        String[] o = this.f13956v.mo65042o();
        AppMethodBeat.m2505o(98367);
        return o;
    }

    /* renamed from: a */
    public final String mo50105a(C24343db c24343db) {
        AppMethodBeat.m2504i(98368);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98368);
            return null;
        }
        String a = this.f13956v.mo65006a(c24343db);
        AppMethodBeat.m2505o(98368);
        return a;
    }

    /* renamed from: a */
    public final void mo50118a(C30987k c30987k) {
        AppMethodBeat.m2504i(98369);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98369);
            return;
        }
        this.f13956v.mo65016a(c30987k);
        AppMethodBeat.m2505o(98369);
    }

    /* renamed from: g */
    public final void mo50143g(boolean z) {
        AppMethodBeat.m2504i(98370);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98370);
            return;
        }
        this.f13956v.mo65030d(z);
        AppMethodBeat.m2505o(98370);
    }

    /* renamed from: w */
    public final boolean mo50160w() {
        AppMethodBeat.m2504i(98371);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98371);
            return false;
        }
        boolean p = this.f13956v.mo65043p();
        AppMethodBeat.m2505o(98371);
        return p;
    }

    /* renamed from: a */
    public final void mo50125a(String str, String str2) {
        AppMethodBeat.m2504i(98372);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98372);
            return;
        }
        this.f13956v.mo65021a(str, str2);
        AppMethodBeat.m2505o(98372);
    }

    /* renamed from: h */
    public final void mo50145h(boolean z) {
        AppMethodBeat.m2504i(98373);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98373);
            return;
        }
        this.f13956v.mo65032e(z);
        AppMethodBeat.m2505o(98373);
    }

    /* renamed from: x */
    public final int mo50161x() {
        AppMethodBeat.m2504i(98374);
        if (this.f13941I == null) {
            AppMethodBeat.m2505o(98374);
            return 0;
        }
        int width = this.f13941I.getWidth();
        AppMethodBeat.m2505o(98374);
        return width;
    }

    /* renamed from: y */
    public final int mo50162y() {
        AppMethodBeat.m2504i(98375);
        if (this.f13941I == null) {
            AppMethodBeat.m2505o(98375);
            return 0;
        }
        int height = this.f13941I.getHeight();
        AppMethodBeat.m2505o(98375);
        return height;
    }

    /* renamed from: a */
    public final void mo50123a(C31001da c31001da) {
        AppMethodBeat.m2504i(98376);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98376);
            return;
        }
        this.f13956v.mo65019a(c31001da);
        AppMethodBeat.m2505o(98376);
    }

    /* renamed from: z */
    public final String mo50163z() {
        AppMethodBeat.m2504i(98377);
        if (this.f13938F || this.f13956v == null) {
            AppMethodBeat.m2505o(98377);
            return null;
        }
        String r = this.f13956v.mo65045r();
        AppMethodBeat.m2505o(98377);
        return r;
    }
}
