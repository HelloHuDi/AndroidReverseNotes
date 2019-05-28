package p000a.p010i.p011b.p012a.p015c.p048n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.n.c */
public final class C0171c {
    /* renamed from: r */
    public static final boolean m295r(Throwable th) {
        AppMethodBeat.m2504i(122927);
        C25052j.m39376p(th, "receiver$0");
        Class cls = th.getClass();
        while (!C25052j.m39373j(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                AppMethodBeat.m2505o(122927);
                return false;
            }
        }
        AppMethodBeat.m2505o(122927);
        return true;
    }
}
