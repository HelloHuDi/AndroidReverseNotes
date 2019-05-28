package a.i.b.a.c.n;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static final boolean r(Throwable th) {
        AppMethodBeat.i(122927);
        j.p(th, "receiver$0");
        Class cls = th.getClass();
        while (!j.j(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                AppMethodBeat.o(122927);
                return false;
            }
        }
        AppMethodBeat.o(122927);
        return true;
    }
}
