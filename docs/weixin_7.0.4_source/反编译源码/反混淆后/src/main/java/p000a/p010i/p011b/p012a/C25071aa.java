package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C16482q;
import p000a.p005f.p007b.C17132h;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C31597w;
import p000a.p005f.p007b.C41376c;
import p000a.p005f.p007b.C44853m;
import p000a.p005f.p007b.C6133s;
import p000a.p010i.C0210m;
import p000a.p010i.C36663b;
import p000a.p010i.C36666l;
import p000a.p010i.C44935d;
import p000a.p010i.C6161h;
import p000a.p010i.C8295e;
import p000a.p010i.p011b.C25267b;

/* renamed from: a.i.b.a.aa */
public class C25071aa extends C31597w {
    /* renamed from: f */
    public final C44935d mo41953f(Class cls, String str) {
        AppMethodBeat.m2504i(118902);
        C31803n c31803n = new C31803n(cls, str);
        AppMethodBeat.m2505o(118902);
        return c31803n;
    }

    /* renamed from: aN */
    public final C36663b mo41952aN(Class cls) {
        AppMethodBeat.m2504i(118903);
        C16493g aO = C41463f.m72345aO(cls);
        AppMethodBeat.m2505o(118903);
        return aO;
    }

    /* renamed from: a */
    public final String mo41951a(C25053k c25053k) {
        AppMethodBeat.m2504i(118904);
        String a = mo41950a((C17132h) c25053k);
        AppMethodBeat.m2505o(118904);
        return a;
    }

    /* renamed from: a */
    public final String mo41950a(C17132h c17132h) {
        String b;
        AppMethodBeat.m2504i(118905);
        C8295e a = C25267b.m39837a(c17132h);
        if (a != null) {
            C31794j dw = C8017af.m14201dw(a);
            if (dw != null) {
                C41382ab c41382ab = C41382ab.AYy;
                b = C41382ab.m72164b(dw.dXf());
                AppMethodBeat.m2505o(118905);
                return b;
            }
        }
        b = super.mo41950a(c17132h);
        AppMethodBeat.m2505o(118905);
        return b;
    }

    /* renamed from: a */
    public final C8295e mo41946a(C25051i c25051i) {
        AppMethodBeat.m2504i(118906);
        C31794j c31794j = new C31794j(C25071aa.m39391a((C41376c) c25051i), c25051i.getName(), c25051i.due(), c25051i.dWC());
        AppMethodBeat.m2505o(118906);
        return c31794j;
    }

    /* renamed from: a */
    public final C36666l mo41948a(C16482q c16482q) {
        AppMethodBeat.m2504i(118907);
        C0203p c0203p = new C0203p(C25071aa.m39391a((C41376c) c16482q), c16482q.getName(), c16482q.due(), c16482q.dWC());
        AppMethodBeat.m2505o(118907);
        return c0203p;
    }

    /* renamed from: a */
    public final C0210m mo41949a(C6133s c6133s) {
        AppMethodBeat.m2504i(118908);
        C6157q c6157q = new C6157q(C25071aa.m39391a((C41376c) c6133s), c6133s.getName(), c6133s.due(), c6133s.dWC());
        AppMethodBeat.m2505o(118908);
        return c6157q;
    }

    /* renamed from: a */
    public final C6161h mo41947a(C44853m c44853m) {
        AppMethodBeat.m2504i(118909);
        C31796l c31796l = new C31796l(C25071aa.m39391a((C41376c) c44853m), c44853m.getName(), c44853m.due(), c44853m.dWC());
        AppMethodBeat.m2505o(118909);
        return c31796l;
    }

    /* renamed from: a */
    private static C8275i m39391a(C41376c c41376c) {
        AppMethodBeat.m2504i(118910);
        C44935d dWF = c41376c.dWF();
        C8275i c8275i;
        if (dWF instanceof C8275i) {
            c8275i = (C8275i) dWF;
            AppMethodBeat.m2505o(118910);
            return c8275i;
        }
        c8275i = C25070a.AWe;
        AppMethodBeat.m2505o(118910);
        return c8275i;
    }
}
