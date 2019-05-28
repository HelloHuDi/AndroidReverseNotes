package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p010i.C0210m;
import p000a.p010i.C36663b;
import p000a.p010i.C36666l;
import p000a.p010i.C44935d;
import p000a.p010i.C6161h;
import p000a.p010i.C8295e;

/* renamed from: a.f.b.w */
public class C31597w {
    /* renamed from: f */
    public C44935d mo41953f(Class cls, String str) {
        AppMethodBeat.m2504i(55888);
        C44854o c44854o = new C44854o(cls, str);
        AppMethodBeat.m2505o(55888);
        return c44854o;
    }

    /* renamed from: aN */
    public C36663b mo41952aN(Class cls) {
        AppMethodBeat.m2504i(55889);
        C44631e c44631e = new C44631e(cls);
        AppMethodBeat.m2505o(55889);
        return c44631e;
    }

    /* renamed from: a */
    public String mo41951a(C25053k c25053k) {
        AppMethodBeat.m2504i(55890);
        String a = mo41950a((C17132h) c25053k);
        AppMethodBeat.m2505o(55890);
        return a;
    }

    /* renamed from: a */
    public String mo41950a(C17132h c17132h) {
        AppMethodBeat.m2504i(55891);
        String obj = c17132h.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
            AppMethodBeat.m2505o(55891);
            return obj;
        }
        AppMethodBeat.m2505o(55891);
        return obj;
    }

    /* renamed from: a */
    public C8295e mo41946a(C25051i c25051i) {
        return c25051i;
    }

    /* renamed from: a */
    public C36666l mo41948a(C16482q c16482q) {
        return c16482q;
    }

    /* renamed from: a */
    public C0210m mo41949a(C6133s c6133s) {
        return c6133s;
    }

    /* renamed from: a */
    public C6161h mo41947a(C44853m c44853m) {
        return c44853m;
    }
}
