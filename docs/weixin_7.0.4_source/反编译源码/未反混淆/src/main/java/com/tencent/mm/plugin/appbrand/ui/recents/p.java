package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.s;
import android.support.v4.view.w;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.y;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class p extends y {
    boolean iOM = false;
    boolean iON = true;
    private final android.support.v7.widget.RecyclerView.f.a iOO = new android.support.v7.widget.RecyclerView.f.a() {
        public final void jT() {
            AppMethodBeat.i(133503);
            for (android.support.v7.widget.RecyclerView.f.a jT : p.this.iOP) {
                jT.jT();
            }
            p.this.iPf = false;
            AppMethodBeat.o(133503);
        }
    };
    final Set<android.support.v7.widget.RecyclerView.f.a> iOP = new HashSet();
    private final Interpolator iOQ = new AccelerateDecelerateInterpolator();
    private final ArrayList<b> iOR = new ArrayList();
    final ArrayList<v> iOS = new ArrayList();
    private final ArrayList<d> iOT = new ArrayList();
    final ArrayList<v> iOU = new ArrayList();
    private final ArrayList<e> iOV = new ArrayList();
    final ArrayList<e> iOW = new ArrayList();
    private final ArrayList<e> iOX = new ArrayList();
    final ArrayList<e> iOY = new ArrayList();
    private final ArrayList<f> iOZ = new ArrayList();
    final ArrayList<e> iPa = new ArrayList();
    private final ArrayList<v> iPb = new ArrayList();
    private final ArrayList<e> iPc = new ArrayList();
    final ArrayList<e> iPd = new ArrayList();
    final ArrayList<e> iPe = new ArrayList();
    boolean iPf = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$8 */
    class AnonymousClass8 extends android.support.v4.view.y {
        final /* synthetic */ w iPh;
        final /* synthetic */ e iPi;

        AnonymousClass8(e eVar, w wVar) {
            this.iPi = eVar;
            this.iPh = wVar;
        }

        public final void az(View view) {
        }

        public final void aB(View view) {
            AppMethodBeat.i(133516);
            if (view == null) {
                AppMethodBeat.o(133516);
                return;
            }
            s.d(view, 0.0f);
            s.e(view, 1.0f);
            AppMethodBeat.o(133516);
        }

        public final void aA(View view) {
            AppMethodBeat.i(133517);
            this.iPh.a(null);
            p.this.m(this.iPi);
            p.this.iPe.remove(this.iPi);
            p.a(p.this);
            AppMethodBeat.o(133517);
        }
    }

    static final class d extends g {
        d(e eVar, int i, int i2) {
            super(eVar, i, i2);
        }
    }

    static class f {
        int ahN;
        int ahO;
        e iPj;

        /* synthetic */ f(e eVar, int i, int i2, byte b) {
            this(eVar, i, i2);
        }

        private f(e eVar, int i, int i2) {
            this.iPj = eVar;
            this.ahN = i;
            this.ahO = i2;
        }
    }

    static final class e extends a {
        private e() {
            super();
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    static class g {
        int ahN;
        int ahO;
        e iPj;

        g(e eVar, int i, int i2) {
            this.iPj = eVar;
            this.ahN = i;
            this.ahO = i2;
        }
    }

    static class a extends android.support.v7.widget.RecyclerView.f.c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final android.support.v7.widget.RecyclerView.f.c c(v vVar, int i) {
            AppMethodBeat.i(133518);
            super.c(vVar, i);
            this.aox = i;
            AppMethodBeat.o(133518);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final boolean aNz() {
            return (this.aox & 2048) > 0;
        }
    }

    static final class b extends g {
        b(e eVar, int i, int i2) {
            super(eVar, i, i2);
        }
    }

    static final class c extends a {
        private c() {
            super();
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    p() {
        AppMethodBeat.i(133519);
        AppMethodBeat.o(133519);
    }

    /* Access modifiers changed, original: final */
    public final void b(android.support.v7.widget.RecyclerView.f.a aVar) {
        AppMethodBeat.i(133520);
        if (aVar != null) {
            this.iOP.add(aVar);
        }
        AppMethodBeat.o(133520);
    }

    /* Access modifiers changed, original: final */
    public final void c(android.support.v7.widget.RecyclerView.f.a aVar) {
        AppMethodBeat.i(133521);
        if (aVar != null) {
            this.iOP.remove(aVar);
        }
        AppMethodBeat.o(133521);
    }

    private void e(v vVar) {
        AppMethodBeat.i(133522);
        vVar.apJ.animate().setInterpolator(new ValueAnimator().getInterpolator());
        d(vVar);
        s.d(vVar.apJ, 0.0f);
        s.e(vVar.apJ, 1.0f);
        AppMethodBeat.o(133522);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(133523);
        if (this.iOR.isEmpty() && this.iOS.isEmpty() && this.iOT.isEmpty() && this.iOU.isEmpty() && this.iOV.isEmpty() && this.iOW.isEmpty() && this.iOX.isEmpty() && this.iOY.isEmpty() && this.iOZ.isEmpty() && this.iPa.isEmpty() && this.iPc.isEmpty() && this.iPd.isEmpty() && this.iPe.isEmpty() && !super.isRunning()) {
            AppMethodBeat.o(133523);
            return false;
        }
        AppMethodBeat.o(133523);
        return true;
    }

    public final void hX() {
        Iterator it;
        final w ab;
        final e eVar;
        final w ab2;
        AppMethodBeat.i(133524);
        a(this.iOO);
        if (!this.iOR.isEmpty()) {
            it = this.iOR.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                this.iOS.add(bVar.iPj);
                final e eVar2 = bVar.iPj;
                View view = bVar.iPj.apJ;
                bVar.iPj.iNs.setVisibility(0);
                s.d(view, 0.0f);
                ab = s.ab(view);
                ab.l(Math.max(this.aov, Math.min(Math.round((((double) bVar.ahO) / ((double) bVar.iPj.apJ.getHeight())) * ((double) this.aov)) + this.aov, 400)));
                ab.c(this.iOQ);
                ab.a(new android.support.v4.view.y() {
                    public final void az(View view) {
                        AppMethodBeat.i(133504);
                        ((RecentsRecyclerView) view.getParent()).cy(view);
                        p.this.D(eVar2);
                        AppMethodBeat.o(133504);
                    }

                    public final void aA(View view) {
                        AppMethodBeat.i(133505);
                        if (view == null) {
                            AppMethodBeat.o(133505);
                            return;
                        }
                        ((RecentsRecyclerView) view.getParent()).cz(view);
                        ab.a(null);
                        s.d(view, 0.0f);
                        p.this.B(eVar2);
                        p.this.iOS.remove(eVar2);
                        p.a(p.this);
                        AppMethodBeat.o(133505);
                    }

                    public final void aB(View view) {
                        AppMethodBeat.i(133506);
                        if (view == null) {
                            AppMethodBeat.o(133506);
                            return;
                        }
                        s.d(view, 0.0f);
                        s.e(view, 1.0f);
                        AppMethodBeat.o(133506);
                    }
                });
                ab.u((float) ((-bVar.ahO) - view.getHeight())).start();
            }
            this.iOR.clear();
        }
        if (!this.iOT.isEmpty()) {
            Iterator it2 = this.iOT.iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                this.iOU.add(dVar.iPj);
                final e eVar3 = dVar.iPj;
                View view2 = dVar.iPj.apJ;
                RecentsRecyclerView recentsRecyclerView = (RecentsRecyclerView) view2.getParent();
                dVar.iPj.iNs.setVisibility(8);
                s.d(view2, 0.0f);
                ab = s.ab(view2);
                ab.l(this.aov);
                ab.a(new android.support.v4.view.y() {
                    public final void az(View view) {
                        AppMethodBeat.i(133507);
                        ((RecentsRecyclerView) view.getParent()).cy(view);
                        p.this.D(eVar3);
                        AppMethodBeat.o(133507);
                    }

                    public final void aA(View view) {
                        AppMethodBeat.i(133508);
                        if (view == null) {
                            AppMethodBeat.o(133508);
                            return;
                        }
                        ((RecentsRecyclerView) view.getParent()).cz(view);
                        ab.a(null);
                        s.d(view, 0.0f);
                        p.this.B(eVar3);
                        p.this.iOU.remove(eVar3);
                        p.a(p.this);
                        AppMethodBeat.o(133508);
                    }

                    public final void aB(View view) {
                        AppMethodBeat.i(133509);
                        if (view == null) {
                            AppMethodBeat.o(133509);
                            return;
                        }
                        s.d(view, 0.0f);
                        s.e(view, 1.0f);
                        AppMethodBeat.o(133509);
                    }
                });
                ab.u((float) (recentsRecyclerView.getHeight() - dVar.ahO)).start();
            }
            this.iOT.clear();
        }
        if (!this.iOV.isEmpty()) {
            it = this.iOV.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                this.iOW.add(eVar);
                s.f(eVar.iNs, 0.1f);
                s.g(eVar.iNs, 0.1f);
                s.e(eVar.iNs, 0.0f);
                eVar.iNs.setVisibility(0);
                ab2 = s.ab(eVar.iNs);
                ab2.l(this.aow);
                ab2.a(new android.support.v4.view.y() {
                    public final void az(View view) {
                    }

                    public final void aA(View view) {
                        AppMethodBeat.i(133510);
                        ab2.a(null);
                        p.this.m(eVar);
                        p.this.iOW.remove(eVar);
                        p.a(p.this);
                        AppMethodBeat.o(133510);
                    }

                    public final void aB(View view) {
                        AppMethodBeat.i(133511);
                        if (view == null) {
                            AppMethodBeat.o(133511);
                            return;
                        }
                        s.d(view, 0.0f);
                        s.e(view, 1.0f);
                        AppMethodBeat.o(133511);
                    }
                });
                ab2.t(1.0f).v(1.0f).A(1.0f).start();
            }
            this.iOV.clear();
        }
        if (!this.iOX.isEmpty()) {
            it = this.iOX.iterator();
            while (it.hasNext()) {
                eVar = (e) it.next();
                this.iOY.add(eVar);
                s.f(eVar.iNs, 1.0f);
                s.g(eVar.iNs, 1.0f);
                s.e(eVar.iNs, 1.0f);
                eVar.iNs.setVisibility(0);
                ab2 = s.ab(eVar.iNs);
                ab2.l(this.aow);
                ab2.a(new android.support.v4.view.y() {
                    public final void az(View view) {
                    }

                    public final void aA(View view) {
                        AppMethodBeat.i(133512);
                        s.f(eVar.iNs, 1.0f);
                        s.g(eVar.iNs, 1.0f);
                        s.e(eVar.iNs, 1.0f);
                        eVar.iNs.setVisibility(8);
                        p.this.m(eVar);
                        p.this.iOY.remove(eVar);
                        p.a(p.this);
                        AppMethodBeat.o(133512);
                    }
                });
                ab2.t(0.0f).v(0.1f).A(0.1f).start();
            }
            this.iOX.clear();
        }
        if (!this.iOZ.isEmpty()) {
            it = this.iOZ.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                this.iPa.add(fVar.iPj);
                View view3 = fVar.iPj.apJ;
                s.d(view3, 0.0f);
                s.e(view3, 1.0f);
                eVar = fVar.iPj;
                w ab3 = s.ab(view3);
                ab3.l(this.aov);
                ab3.a(new android.support.v4.view.y() {
                    public final void az(View view) {
                        AppMethodBeat.i(133513);
                        p.this.D(eVar);
                        AppMethodBeat.o(133513);
                    }

                    public final void aA(View view) {
                        AppMethodBeat.i(133514);
                        s.d(view, 0.0f);
                        s.e(view, 1.0f);
                        p.this.B(eVar);
                        p.this.iPa.remove(eVar);
                        p.a(p.this);
                        AppMethodBeat.o(133514);
                    }
                });
                ab3.t(0.0f).u((float) (-view3.getHeight())).start();
            }
            this.iOZ.clear();
        }
        super.hX();
        if (!this.iPc.isEmpty()) {
            this.iPd.addAll(this.iPc);
            AnonymousClass7 anonymousClass7 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133515);
                    Iterator it = p.this.iPd.iterator();
                    while (it.hasNext()) {
                        e eVar = (e) it.next();
                        p pVar = p.this;
                        w ab = s.ab(eVar.apJ);
                        pVar.iPe.add(eVar);
                        ab.u(0.0f).l(pVar.aov).a(new AnonymousClass8(eVar, ab)).start();
                    }
                    p.this.iPd.clear();
                    AppMethodBeat.o(133515);
                }
            };
            this.iPc.clear();
            if (this.iPf) {
                s.a(((e) this.iPd.get(0)).apJ, anonymousClass7, this.aou);
                AppMethodBeat.o(133524);
                return;
            }
            anonymousClass7.run();
        }
        AppMethodBeat.o(133524);
    }

    public final void D(v vVar) {
        AppMethodBeat.i(133525);
        super.D(vVar);
        if (!this.iPa.contains(vVar)) {
            this.iPf = true;
        }
        AppMethodBeat.o(133525);
    }

    public final boolean a(v vVar, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133526);
        if ((vVar instanceof e) && this.iON) {
            boolean a = super.a(vVar, i, i2, i3, i4);
            AppMethodBeat.o(133526);
            return a;
        }
        e(vVar);
        C(vVar);
        AppMethodBeat.o(133526);
        return false;
    }

    public final boolean c(v vVar) {
        AppMethodBeat.i(133527);
        e(vVar);
        m(vVar);
        AppMethodBeat.o(133527);
        return false;
    }

    public final void d(v vVar) {
        AppMethodBeat.i(133528);
        if ((vVar instanceof e) && this.iPc.remove(vVar)) {
            s.d(vVar.apJ, 0.0f);
            m(vVar);
        }
        super.d(vVar);
        AppMethodBeat.o(133528);
    }

    public final boolean e(v vVar, android.support.v7.widget.RecyclerView.f.c cVar, android.support.v7.widget.RecyclerView.f.c cVar2) {
        AppMethodBeat.i(133529);
        boolean c;
        if (!this.iON) {
            c = c(vVar);
            AppMethodBeat.o(133529);
            return c;
        } else if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            if (this.iOM && (vVar.apJ.getParent() instanceof RecyclerView) && (vVar instanceof e)) {
                RecyclerView recyclerView = (RecyclerView) vVar.apJ.getParent();
                if (recyclerView.getHeight() > 0) {
                    e eVar;
                    if (cVar2.bottom >= recyclerView.getHeight()) {
                        eVar = (e) vVar;
                        s.d(eVar.apJ, (float) eVar.apJ.getHeight());
                        this.iPc.add(eVar);
                        AppMethodBeat.o(133529);
                        return true;
                    } else if (cVar2.top <= 0) {
                        eVar = (e) vVar;
                        s.d(eVar.apJ, (float) (-eVar.apJ.getHeight()));
                        this.iPc.add(eVar);
                        AppMethodBeat.o(133529);
                        return true;
                    }
                }
            }
            c = c(vVar);
            AppMethodBeat.o(133529);
            return c;
        } else {
            c = super.a(vVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
            AppMethodBeat.o(133529);
            return c;
        }
    }

    public final boolean d(v vVar, android.support.v7.widget.RecyclerView.f.c cVar, android.support.v7.widget.RecyclerView.f.c cVar2) {
        AppMethodBeat.i(133530);
        if (!this.iON) {
            e(vVar);
            B(vVar);
            AppMethodBeat.o(133530);
            return false;
        } else if (cVar instanceof c) {
            e(vVar);
            this.iOR.add(new b((e) vVar, cVar.left, cVar.top));
            AppMethodBeat.o(133530);
            return true;
        } else if (cVar instanceof e) {
            e(vVar);
            this.iOT.add(new d((e) vVar, cVar.left, cVar.top));
            AppMethodBeat.o(133530);
            return true;
        } else {
            boolean z;
            if ((cVar.aox & 2048) > 0 && (vVar instanceof e) && cVar2 == null) {
                try {
                    z = ((e) vVar).aNq().had;
                } catch (Exception e) {
                    z = false;
                }
                if (!z) {
                    e(vVar);
                    this.iOZ.add(new f((e) vVar, cVar.left, cVar.top, (byte) 0));
                    AppMethodBeat.o(133530);
                    return true;
                }
            }
            z = super.d(vVar, cVar, cVar2);
            AppMethodBeat.o(133530);
            return z;
        }
    }

    public final boolean b(v vVar) {
        AppMethodBeat.i(133531);
        if (this.iON) {
            boolean b = super.b(vVar);
            AppMethodBeat.o(133531);
            return b;
        }
        e(vVar);
        B(vVar);
        AppMethodBeat.o(133531);
        return false;
    }

    public final boolean a(v vVar, v vVar2, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(133532);
        if (s.ab(vVar.apJ) == null) {
            s.e(vVar.apJ, 1.0f);
            s.d(vVar.apJ, 0.0f);
        }
        if (s.ab(vVar2.apJ) == null) {
            s.e(vVar2.apJ, 1.0f);
            s.d(vVar2.apJ, 0.0f);
        }
        m(vVar);
        m(vVar2);
        AppMethodBeat.o(133532);
        return false;
    }

    public final boolean f(v vVar, android.support.v7.widget.RecyclerView.f.c cVar, android.support.v7.widget.RecyclerView.f.c cVar2) {
        AppMethodBeat.i(133533);
        if (this.iON) {
            boolean f = super.f(vVar, cVar, cVar2);
            AppMethodBeat.o(133533);
            return f;
        }
        e(vVar);
        C(vVar);
        AppMethodBeat.o(133533);
        return false;
    }

    public final void n(v vVar) {
        AppMethodBeat.i(133534);
        super.n(vVar);
        ViewParent parent = vVar.apJ.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).cz(vVar.apJ);
        }
        AppMethodBeat.o(133534);
    }

    public final void F(v vVar) {
        AppMethodBeat.i(133535);
        super.F(vVar);
        if (this.iPb.contains(vVar)) {
            ((RecentsRecyclerView) vVar.apJ.getParent()).cy(vVar.apJ);
        }
        AppMethodBeat.o(133535);
    }

    public final void G(v vVar) {
        AppMethodBeat.i(133536);
        super.G(vVar);
        if (this.iPb.contains(vVar)) {
            this.iPb.remove(vVar);
            ((RecentsRecyclerView) vVar.apJ.getParent()).cz(vVar.apJ);
        }
        AppMethodBeat.o(133536);
    }

    public final android.support.v7.widget.RecyclerView.f.c a(RecyclerView.s sVar, v vVar, int i, List<Object> list) {
        android.support.v7.widget.RecyclerView.f.c c;
        AppMethodBeat.i(133537);
        if ((i & 2) > 0) {
            for (Object next : list) {
                if (next instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) next).get("star");
                    if (bool != null && bool.booleanValue()) {
                        c = new c().c(vVar, i);
                        AppMethodBeat.o(133537);
                        return c;
                    } else if (!(bool == null || bool.booleanValue())) {
                        c = new e().c(vVar, i);
                        AppMethodBeat.o(133537);
                        return c;
                    }
                }
            }
        }
        c = super.a(sVar, vVar, i, (List) list);
        c.aox = i;
        AppMethodBeat.o(133537);
        return c;
    }

    public final boolean a(v vVar, v vVar2, android.support.v7.widget.RecyclerView.f.c cVar, android.support.v7.widget.RecyclerView.f.c cVar2) {
        AppMethodBeat.i(133538);
        boolean a;
        if (!this.iON) {
            m(vVar);
            m(vVar2);
            AppMethodBeat.o(133538);
            return false;
        } else if (cVar instanceof c) {
            if (((c) cVar).aNz()) {
                ((e) vVar2).iNs.setVisibility(0);
                ((e) vVar2).iNs.invalidate();
                ((RecentsRecyclerView) vVar2.apJ.getParent()).cy(vVar2.apJ);
                this.iPb.add(vVar2);
                a = super.a(vVar2, cVar.left, cVar.top, cVar2.left, cVar2.top);
                AppMethodBeat.o(133538);
                return a;
            }
            e(vVar2);
            this.iOV.add((e) vVar2);
            AppMethodBeat.o(133538);
            return true;
        } else if (!(cVar instanceof e)) {
            a = super.a(vVar, vVar2, cVar, cVar2);
            AppMethodBeat.o(133538);
            return a;
        } else if (((e) cVar).aNz()) {
            ((e) vVar2).iNs.setVisibility(8);
            a = super.a(vVar2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            AppMethodBeat.o(133538);
            return a;
        } else {
            e(vVar2);
            this.iOX.add((e) vVar2);
            AppMethodBeat.o(133538);
            return true;
        }
    }

    public final boolean a(v vVar, List<Object> list) {
        AppMethodBeat.i(133539);
        boolean a = super.a(vVar, (List) list);
        if ((vVar instanceof e) || a) {
            AppMethodBeat.o(133539);
            return true;
        }
        AppMethodBeat.o(133539);
        return false;
    }

    static /* synthetic */ void a(p pVar) {
        AppMethodBeat.i(133540);
        if (!pVar.isRunning()) {
            pVar.jS();
        }
        AppMethodBeat.o(133540);
    }
}
