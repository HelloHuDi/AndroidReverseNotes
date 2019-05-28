package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C0497w;
import android.support.p057v4.view.C6203y;
import android.support.p069v7.widget.C31895y;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C31879f.C17477a;
import android.support.p069v7.widget.RecyclerView.C31879f.C17479c;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.AppBrandLauncherRecentsList.C10878e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p */
final class C38536p extends C31895y {
    boolean iOM = false;
    boolean iON = true;
    private final C17477a iOO = new C247101();
    final Set<C17477a> iOP = new HashSet();
    private final Interpolator iOQ = new AccelerateDecelerateInterpolator();
    private final ArrayList<C38539b> iOR = new ArrayList();
    final ArrayList<C41531v> iOS = new ArrayList();
    private final ArrayList<C10916d> iOT = new ArrayList();
    final ArrayList<C41531v> iOU = new ArrayList();
    private final ArrayList<C10878e> iOV = new ArrayList();
    final ArrayList<C10878e> iOW = new ArrayList();
    private final ArrayList<C10878e> iOX = new ArrayList();
    final ArrayList<C10878e> iOY = new ArrayList();
    private final ArrayList<C19797f> iOZ = new ArrayList();
    final ArrayList<C10878e> iPa = new ArrayList();
    private final ArrayList<C41531v> iPb = new ArrayList();
    private final ArrayList<C10878e> iPc = new ArrayList();
    final ArrayList<C10878e> iPd = new ArrayList();
    final ArrayList<C10878e> iPe = new ArrayList();
    boolean iPf = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$8 */
    class C109158 extends C6203y {
        final /* synthetic */ C0497w iPh;
        final /* synthetic */ C10878e iPi;

        C109158(C10878e c10878e, C0497w c0497w) {
            this.iPi = c10878e;
            this.iPh = c0497w;
        }

        /* renamed from: az */
        public final void mo1166az(View view) {
        }

        /* renamed from: aB */
        public final void mo1165aB(View view) {
            AppMethodBeat.m2504i(133516);
            if (view == null) {
                AppMethodBeat.m2505o(133516);
                return;
            }
            C0477s.m938d(view, 0.0f);
            C0477s.m941e(view, 1.0f);
            AppMethodBeat.m2505o(133516);
        }

        /* renamed from: aA */
        public final void mo1164aA(View view) {
            AppMethodBeat.m2504i(133517);
            this.iPh.mo1153a(null);
            C38536p.this.mo51947m(this.iPi);
            C38536p.this.iPe.remove(this.iPi);
            C38536p.m65263a(C38536p.this);
            AppMethodBeat.m2505o(133517);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$d */
    static final class C10916d extends C27339g {
        C10916d(C10878e c10878e, int i, int i2) {
            super(c10878e, i, i2);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$f */
    static class C19797f {
        int ahN;
        int ahO;
        C10878e iPj;

        /* synthetic */ C19797f(C10878e c10878e, int i, int i2, byte b) {
            this(c10878e, i, i2);
        }

        private C19797f(C10878e c10878e, int i, int i2) {
            this.iPj = c10878e;
            this.ahN = i;
            this.ahO = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$1 */
    class C247101 implements C17477a {
        C247101() {
        }

        /* renamed from: jT */
        public final void mo22448jT() {
            AppMethodBeat.m2504i(133503);
            for (C17477a jT : C38536p.this.iOP) {
                jT.mo22448jT();
            }
            C38536p.this.iPf = false;
            AppMethodBeat.m2505o(133503);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$e */
    static final class C27338e extends C38538a {
        private C27338e() {
            super();
        }

        /* synthetic */ C27338e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$g */
    static class C27339g {
        int ahN;
        int ahO;
        C10878e iPj;

        C27339g(C10878e c10878e, int i, int i2) {
            this.iPj = c10878e;
            this.ahN = i;
            this.ahO = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$a */
    static class C38538a extends C17479c {
        private C38538a() {
        }

        /* synthetic */ C38538a(byte b) {
            this();
        }

        /* renamed from: c */
        public final C17479c mo31823c(C41531v c41531v, int i) {
            AppMethodBeat.m2504i(133518);
            super.mo31823c(c41531v, i);
            this.aox = i;
            AppMethodBeat.m2505o(133518);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final boolean aNz() {
            return (this.aox & 2048) > 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$b */
    static final class C38539b extends C27339g {
        C38539b(C10878e c10878e, int i, int i2) {
            super(c10878e, i, i2);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$7 */
    class C385417 implements Runnable {
        C385417() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133515);
            Iterator it = C38536p.this.iPd.iterator();
            while (it.hasNext()) {
                C10878e c10878e = (C10878e) it.next();
                C38536p c38536p = C38536p.this;
                C0497w ab = C0477s.m910ab(c10878e.apJ);
                c38536p.iPe.add(c10878e);
                ab.mo1162u(0.0f).mo1158l(c38536p.aov).mo1153a(new C109158(c10878e, ab)).start();
            }
            C38536p.this.iPd.clear();
            AppMethodBeat.m2505o(133515);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.p$c */
    static final class C38542c extends C38538a {
        private C38542c() {
            super();
        }

        /* synthetic */ C38542c(byte b) {
            this();
        }
    }

    C38536p() {
        AppMethodBeat.m2504i(133519);
        AppMethodBeat.m2505o(133519);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo61269b(C17477a c17477a) {
        AppMethodBeat.m2504i(133520);
        if (c17477a != null) {
            this.iOP.add(c17477a);
        }
        AppMethodBeat.m2505o(133520);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo61270c(C17477a c17477a) {
        AppMethodBeat.m2504i(133521);
        if (c17477a != null) {
            this.iOP.remove(c17477a);
        }
        AppMethodBeat.m2505o(133521);
    }

    /* renamed from: e */
    private void m65264e(C41531v c41531v) {
        AppMethodBeat.m2504i(133522);
        c41531v.apJ.animate().setInterpolator(new ValueAnimator().getInterpolator());
        mo22570d(c41531v);
        C0477s.m938d(c41531v.apJ, 0.0f);
        C0477s.m941e(c41531v.apJ, 1.0f);
        AppMethodBeat.m2505o(133522);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(133523);
        if (this.iOR.isEmpty() && this.iOS.isEmpty() && this.iOT.isEmpty() && this.iOU.isEmpty() && this.iOV.isEmpty() && this.iOW.isEmpty() && this.iOX.isEmpty() && this.iOY.isEmpty() && this.iOZ.isEmpty() && this.iPa.isEmpty() && this.iPc.isEmpty() && this.iPd.isEmpty() && this.iPe.isEmpty() && !super.isRunning()) {
            AppMethodBeat.m2505o(133523);
            return false;
        }
        AppMethodBeat.m2505o(133523);
        return true;
    }

    /* renamed from: hX */
    public final void mo22571hX() {
        Iterator it;
        final C0497w ab;
        final C10878e c10878e;
        final C0497w ab2;
        AppMethodBeat.m2504i(133524);
        mo51945a(this.iOO);
        if (!this.iOR.isEmpty()) {
            it = this.iOR.iterator();
            while (it.hasNext()) {
                C38539b c38539b = (C38539b) it.next();
                this.iOS.add(c38539b.iPj);
                final C10878e c10878e2 = c38539b.iPj;
                View view = c38539b.iPj.apJ;
                c38539b.iPj.iNs.setVisibility(0);
                C0477s.m938d(view, 0.0f);
                ab = C0477s.m910ab(view);
                ab.mo1158l(Math.max(this.aov, Math.min(Math.round((((double) c38539b.ahO) / ((double) c38539b.iPj.apJ.getHeight())) * ((double) this.aov)) + this.aov, 400)));
                ab.mo1155c(this.iOQ);
                ab.mo1153a(new C6203y() {
                    /* renamed from: az */
                    public final void mo1166az(View view) {
                        AppMethodBeat.m2504i(133504);
                        ((RecentsRecyclerView) view.getParent()).mo35023cy(view);
                        C38536p.this.mo31914D(c10878e2);
                        AppMethodBeat.m2505o(133504);
                    }

                    /* renamed from: aA */
                    public final void mo1164aA(View view) {
                        AppMethodBeat.m2504i(133505);
                        if (view == null) {
                            AppMethodBeat.m2505o(133505);
                            return;
                        }
                        ((RecentsRecyclerView) view.getParent()).mo35024cz(view);
                        ab.mo1153a(null);
                        C0477s.m938d(view, 0.0f);
                        C38536p.this.mo31912B(c10878e2);
                        C38536p.this.iOS.remove(c10878e2);
                        C38536p.m65263a(C38536p.this);
                        AppMethodBeat.m2505o(133505);
                    }

                    /* renamed from: aB */
                    public final void mo1165aB(View view) {
                        AppMethodBeat.m2504i(133506);
                        if (view == null) {
                            AppMethodBeat.m2505o(133506);
                            return;
                        }
                        C0477s.m938d(view, 0.0f);
                        C0477s.m941e(view, 1.0f);
                        AppMethodBeat.m2505o(133506);
                    }
                });
                ab.mo1162u((float) ((-c38539b.ahO) - view.getHeight())).start();
            }
            this.iOR.clear();
        }
        if (!this.iOT.isEmpty()) {
            Iterator it2 = this.iOT.iterator();
            while (it2.hasNext()) {
                C10916d c10916d = (C10916d) it2.next();
                this.iOU.add(c10916d.iPj);
                final C10878e c10878e3 = c10916d.iPj;
                View view2 = c10916d.iPj.apJ;
                RecentsRecyclerView recentsRecyclerView = (RecentsRecyclerView) view2.getParent();
                c10916d.iPj.iNs.setVisibility(8);
                C0477s.m938d(view2, 0.0f);
                ab = C0477s.m910ab(view2);
                ab.mo1158l(this.aov);
                ab.mo1153a(new C6203y() {
                    /* renamed from: az */
                    public final void mo1166az(View view) {
                        AppMethodBeat.m2504i(133507);
                        ((RecentsRecyclerView) view.getParent()).mo35023cy(view);
                        C38536p.this.mo31914D(c10878e3);
                        AppMethodBeat.m2505o(133507);
                    }

                    /* renamed from: aA */
                    public final void mo1164aA(View view) {
                        AppMethodBeat.m2504i(133508);
                        if (view == null) {
                            AppMethodBeat.m2505o(133508);
                            return;
                        }
                        ((RecentsRecyclerView) view.getParent()).mo35024cz(view);
                        ab.mo1153a(null);
                        C0477s.m938d(view, 0.0f);
                        C38536p.this.mo31912B(c10878e3);
                        C38536p.this.iOU.remove(c10878e3);
                        C38536p.m65263a(C38536p.this);
                        AppMethodBeat.m2505o(133508);
                    }

                    /* renamed from: aB */
                    public final void mo1165aB(View view) {
                        AppMethodBeat.m2504i(133509);
                        if (view == null) {
                            AppMethodBeat.m2505o(133509);
                            return;
                        }
                        C0477s.m938d(view, 0.0f);
                        C0477s.m941e(view, 1.0f);
                        AppMethodBeat.m2505o(133509);
                    }
                });
                ab.mo1162u((float) (recentsRecyclerView.getHeight() - c10916d.ahO)).start();
            }
            this.iOT.clear();
        }
        if (!this.iOV.isEmpty()) {
            it = this.iOV.iterator();
            while (it.hasNext()) {
                c10878e = (C10878e) it.next();
                this.iOW.add(c10878e);
                C0477s.m943f(c10878e.iNs, 0.1f);
                C0477s.m944g(c10878e.iNs, 0.1f);
                C0477s.m941e(c10878e.iNs, 0.0f);
                c10878e.iNs.setVisibility(0);
                ab2 = C0477s.m910ab(c10878e.iNs);
                ab2.mo1158l(this.aow);
                ab2.mo1153a(new C6203y() {
                    /* renamed from: az */
                    public final void mo1166az(View view) {
                    }

                    /* renamed from: aA */
                    public final void mo1164aA(View view) {
                        AppMethodBeat.m2504i(133510);
                        ab2.mo1153a(null);
                        C38536p.this.mo51947m(c10878e);
                        C38536p.this.iOW.remove(c10878e);
                        C38536p.m65263a(C38536p.this);
                        AppMethodBeat.m2505o(133510);
                    }

                    /* renamed from: aB */
                    public final void mo1165aB(View view) {
                        AppMethodBeat.m2504i(133511);
                        if (view == null) {
                            AppMethodBeat.m2505o(133511);
                            return;
                        }
                        C0477s.m938d(view, 0.0f);
                        C0477s.m941e(view, 1.0f);
                        AppMethodBeat.m2505o(133511);
                    }
                });
                ab2.mo1161t(1.0f).mo1163v(1.0f).mo1152A(1.0f).start();
            }
            this.iOV.clear();
        }
        if (!this.iOX.isEmpty()) {
            it = this.iOX.iterator();
            while (it.hasNext()) {
                c10878e = (C10878e) it.next();
                this.iOY.add(c10878e);
                C0477s.m943f(c10878e.iNs, 1.0f);
                C0477s.m944g(c10878e.iNs, 1.0f);
                C0477s.m941e(c10878e.iNs, 1.0f);
                c10878e.iNs.setVisibility(0);
                ab2 = C0477s.m910ab(c10878e.iNs);
                ab2.mo1158l(this.aow);
                ab2.mo1153a(new C6203y() {
                    /* renamed from: az */
                    public final void mo1166az(View view) {
                    }

                    /* renamed from: aA */
                    public final void mo1164aA(View view) {
                        AppMethodBeat.m2504i(133512);
                        C0477s.m943f(c10878e.iNs, 1.0f);
                        C0477s.m944g(c10878e.iNs, 1.0f);
                        C0477s.m941e(c10878e.iNs, 1.0f);
                        c10878e.iNs.setVisibility(8);
                        C38536p.this.mo51947m(c10878e);
                        C38536p.this.iOY.remove(c10878e);
                        C38536p.m65263a(C38536p.this);
                        AppMethodBeat.m2505o(133512);
                    }
                });
                ab2.mo1161t(0.0f).mo1163v(0.1f).mo1152A(0.1f).start();
            }
            this.iOX.clear();
        }
        if (!this.iOZ.isEmpty()) {
            it = this.iOZ.iterator();
            while (it.hasNext()) {
                C19797f c19797f = (C19797f) it.next();
                this.iPa.add(c19797f.iPj);
                View view3 = c19797f.iPj.apJ;
                C0477s.m938d(view3, 0.0f);
                C0477s.m941e(view3, 1.0f);
                c10878e = c19797f.iPj;
                C0497w ab3 = C0477s.m910ab(view3);
                ab3.mo1158l(this.aov);
                ab3.mo1153a(new C6203y() {
                    /* renamed from: az */
                    public final void mo1166az(View view) {
                        AppMethodBeat.m2504i(133513);
                        C38536p.this.mo31914D(c10878e);
                        AppMethodBeat.m2505o(133513);
                    }

                    /* renamed from: aA */
                    public final void mo1164aA(View view) {
                        AppMethodBeat.m2504i(133514);
                        C0477s.m938d(view, 0.0f);
                        C0477s.m941e(view, 1.0f);
                        C38536p.this.mo31912B(c10878e);
                        C38536p.this.iPa.remove(c10878e);
                        C38536p.m65263a(C38536p.this);
                        AppMethodBeat.m2505o(133514);
                    }
                });
                ab3.mo1161t(0.0f).mo1162u((float) (-view3.getHeight())).start();
            }
            this.iOZ.clear();
        }
        super.mo22571hX();
        if (!this.iPc.isEmpty()) {
            this.iPd.addAll(this.iPc);
            C385417 c385417 = new C385417();
            this.iPc.clear();
            if (this.iPf) {
                C0477s.m908a(((C10878e) this.iPd.get(0)).apJ, c385417, this.aou);
                AppMethodBeat.m2505o(133524);
                return;
            }
            c385417.run();
        }
        AppMethodBeat.m2505o(133524);
    }

    /* renamed from: D */
    public final void mo31914D(C41531v c41531v) {
        AppMethodBeat.m2504i(133525);
        super.mo31914D(c41531v);
        if (!this.iPa.contains(c41531v)) {
            this.iPf = true;
        }
        AppMethodBeat.m2505o(133525);
    }

    /* renamed from: a */
    public final boolean mo22565a(C41531v c41531v, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133526);
        if ((c41531v instanceof C10878e) && this.iON) {
            boolean a = super.mo22565a(c41531v, i, i2, i3, i4);
            AppMethodBeat.m2505o(133526);
            return a;
        }
        m65264e(c41531v);
        mo31913C(c41531v);
        AppMethodBeat.m2505o(133526);
        return false;
    }

    /* renamed from: c */
    public final boolean mo22569c(C41531v c41531v) {
        AppMethodBeat.m2504i(133527);
        m65264e(c41531v);
        mo51947m(c41531v);
        AppMethodBeat.m2505o(133527);
        return false;
    }

    /* renamed from: d */
    public final void mo22570d(C41531v c41531v) {
        AppMethodBeat.m2504i(133528);
        if ((c41531v instanceof C10878e) && this.iPc.remove(c41531v)) {
            C0477s.m938d(c41531v.apJ, 0.0f);
            mo51947m(c41531v);
        }
        super.mo22570d(c41531v);
        AppMethodBeat.m2505o(133528);
    }

    /* renamed from: e */
    public final boolean mo31919e(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
        AppMethodBeat.m2504i(133529);
        boolean c;
        if (!this.iON) {
            c = mo22569c(c41531v);
            AppMethodBeat.m2505o(133529);
            return c;
        } else if (c17479c == null || (c17479c.left == c17479c2.left && c17479c.top == c17479c2.top)) {
            if (this.iOM && (c41531v.apJ.getParent() instanceof RecyclerView) && (c41531v instanceof C10878e)) {
                RecyclerView recyclerView = (RecyclerView) c41531v.apJ.getParent();
                if (recyclerView.getHeight() > 0) {
                    C10878e c10878e;
                    if (c17479c2.bottom >= recyclerView.getHeight()) {
                        c10878e = (C10878e) c41531v;
                        C0477s.m938d(c10878e.apJ, (float) c10878e.apJ.getHeight());
                        this.iPc.add(c10878e);
                        AppMethodBeat.m2505o(133529);
                        return true;
                    } else if (c17479c2.top <= 0) {
                        c10878e = (C10878e) c41531v;
                        C0477s.m938d(c10878e.apJ, (float) (-c10878e.apJ.getHeight()));
                        this.iPc.add(c10878e);
                        AppMethodBeat.m2505o(133529);
                        return true;
                    }
                }
            }
            c = mo22569c(c41531v);
            AppMethodBeat.m2505o(133529);
            return c;
        } else {
            c = super.mo22565a(c41531v, c17479c.left, c17479c.top, c17479c2.left, c17479c2.top);
            AppMethodBeat.m2505o(133529);
            return c;
        }
    }

    /* renamed from: d */
    public final boolean mo31918d(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
        AppMethodBeat.m2504i(133530);
        if (!this.iON) {
            m65264e(c41531v);
            mo31912B(c41531v);
            AppMethodBeat.m2505o(133530);
            return false;
        } else if (c17479c instanceof C38542c) {
            m65264e(c41531v);
            this.iOR.add(new C38539b((C10878e) c41531v, c17479c.left, c17479c.top));
            AppMethodBeat.m2505o(133530);
            return true;
        } else if (c17479c instanceof C27338e) {
            m65264e(c41531v);
            this.iOT.add(new C10916d((C10878e) c41531v, c17479c.left, c17479c.top));
            AppMethodBeat.m2505o(133530);
            return true;
        } else {
            boolean z;
            if ((c17479c.aox & 2048) > 0 && (c41531v instanceof C10878e) && c17479c2 == null) {
                try {
                    z = ((C10878e) c41531v).aNq().had;
                } catch (Exception e) {
                    z = false;
                }
                if (!z) {
                    m65264e(c41531v);
                    this.iOZ.add(new C19797f((C10878e) c41531v, c17479c.left, c17479c.top, (byte) 0));
                    AppMethodBeat.m2505o(133530);
                    return true;
                }
            }
            z = super.mo31918d(c41531v, c17479c, c17479c2);
            AppMethodBeat.m2505o(133530);
            return z;
        }
    }

    /* renamed from: b */
    public final boolean mo22568b(C41531v c41531v) {
        AppMethodBeat.m2504i(133531);
        if (this.iON) {
            boolean b = super.mo22568b(c41531v);
            AppMethodBeat.m2505o(133531);
            return b;
        }
        m65264e(c41531v);
        mo31912B(c41531v);
        AppMethodBeat.m2505o(133531);
        return false;
    }

    /* renamed from: a */
    public final boolean mo22566a(C41531v c41531v, C41531v c41531v2, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(133532);
        if (C0477s.m910ab(c41531v.apJ) == null) {
            C0477s.m941e(c41531v.apJ, 1.0f);
            C0477s.m938d(c41531v.apJ, 0.0f);
        }
        if (C0477s.m910ab(c41531v2.apJ) == null) {
            C0477s.m941e(c41531v2.apJ, 1.0f);
            C0477s.m938d(c41531v2.apJ, 0.0f);
        }
        mo51947m(c41531v);
        mo51947m(c41531v2);
        AppMethodBeat.m2505o(133532);
        return false;
    }

    /* renamed from: f */
    public final boolean mo31920f(C41531v c41531v, C17479c c17479c, C17479c c17479c2) {
        AppMethodBeat.m2504i(133533);
        if (this.iON) {
            boolean f = super.mo31920f(c41531v, c17479c, c17479c2);
            AppMethodBeat.m2505o(133533);
            return f;
        }
        m65264e(c41531v);
        mo31913C(c41531v);
        AppMethodBeat.m2505o(133533);
        return false;
    }

    /* renamed from: n */
    public final void mo51948n(C41531v c41531v) {
        AppMethodBeat.m2504i(133534);
        super.mo51948n(c41531v);
        ViewParent parent = c41531v.apJ.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).mo35024cz(c41531v.apJ);
        }
        AppMethodBeat.m2505o(133534);
    }

    /* renamed from: F */
    public final void mo31915F(C41531v c41531v) {
        AppMethodBeat.m2504i(133535);
        super.mo31915F(c41531v);
        if (this.iPb.contains(c41531v)) {
            ((RecentsRecyclerView) c41531v.apJ.getParent()).mo35023cy(c41531v.apJ);
        }
        AppMethodBeat.m2505o(133535);
    }

    /* renamed from: G */
    public final void mo31916G(C41531v c41531v) {
        AppMethodBeat.m2504i(133536);
        super.mo31916G(c41531v);
        if (this.iPb.contains(c41531v)) {
            this.iPb.remove(c41531v);
            ((RecentsRecyclerView) c41531v.apJ.getParent()).mo35024cz(c41531v.apJ);
        }
        AppMethodBeat.m2505o(133536);
    }

    /* renamed from: a */
    public final C17479c mo51944a(C31880s c31880s, C41531v c41531v, int i, List<Object> list) {
        C17479c c;
        AppMethodBeat.m2504i(133537);
        if ((i & 2) > 0) {
            for (Object next : list) {
                if (next instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) next).get("star");
                    if (bool != null && bool.booleanValue()) {
                        c = new C38542c().mo31823c(c41531v, i);
                        AppMethodBeat.m2505o(133537);
                        return c;
                    } else if (!(bool == null || bool.booleanValue())) {
                        c = new C27338e().mo31823c(c41531v, i);
                        AppMethodBeat.m2505o(133537);
                        return c;
                    }
                }
            }
        }
        c = super.mo51944a(c31880s, c41531v, i, (List) list);
        c.aox = i;
        AppMethodBeat.m2505o(133537);
        return c;
    }

    /* renamed from: a */
    public final boolean mo31917a(C41531v c41531v, C41531v c41531v2, C17479c c17479c, C17479c c17479c2) {
        AppMethodBeat.m2504i(133538);
        boolean a;
        if (!this.iON) {
            mo51947m(c41531v);
            mo51947m(c41531v2);
            AppMethodBeat.m2505o(133538);
            return false;
        } else if (c17479c instanceof C38542c) {
            if (((C38542c) c17479c).aNz()) {
                ((C10878e) c41531v2).iNs.setVisibility(0);
                ((C10878e) c41531v2).iNs.invalidate();
                ((RecentsRecyclerView) c41531v2.apJ.getParent()).mo35023cy(c41531v2.apJ);
                this.iPb.add(c41531v2);
                a = super.mo22565a(c41531v2, c17479c.left, c17479c.top, c17479c2.left, c17479c2.top);
                AppMethodBeat.m2505o(133538);
                return a;
            }
            m65264e(c41531v2);
            this.iOV.add((C10878e) c41531v2);
            AppMethodBeat.m2505o(133538);
            return true;
        } else if (!(c17479c instanceof C27338e)) {
            a = super.mo31917a(c41531v, c41531v2, c17479c, c17479c2);
            AppMethodBeat.m2505o(133538);
            return a;
        } else if (((C27338e) c17479c).aNz()) {
            ((C10878e) c41531v2).iNs.setVisibility(8);
            a = super.mo22565a(c41531v2, c17479c.left, c17479c.top, c17479c2.left, c17479c2.top);
            AppMethodBeat.m2505o(133538);
            return a;
        } else {
            m65264e(c41531v2);
            this.iOX.add((C10878e) c41531v2);
            AppMethodBeat.m2505o(133538);
            return true;
        }
    }

    /* renamed from: a */
    public final boolean mo22567a(C41531v c41531v, List<Object> list) {
        AppMethodBeat.m2504i(133539);
        boolean a = super.mo22567a(c41531v, (List) list);
        if ((c41531v instanceof C10878e) || a) {
            AppMethodBeat.m2505o(133539);
            return true;
        }
        AppMethodBeat.m2505o(133539);
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m65263a(C38536p c38536p) {
        AppMethodBeat.m2504i(133540);
        if (!c38536p.isRunning()) {
            c38536p.mo51946jS();
        }
        AppMethodBeat.m2505o(133540);
    }
}
