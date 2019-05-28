package p000a.p010i.p011b.p012a.p015c.p016a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

/* renamed from: a.i.b.a.c.a.a */
public final class C8029a<T extends C31619g> {
    private volatile T AZH;
    private volatile boolean AZI;
    private Throwable AZJ;
    private final C31214a<T> AZK;

    public C8029a(C31214a<? extends T> c31214a) {
        C25052j.m39376p(c31214a, "constructor");
        AppMethodBeat.m2504i(119068);
        this.AZK = c31214a;
        AppMethodBeat.m2505o(119068);
    }

    private final synchronized void initialize() {
        AppMethodBeat.m2504i(119066);
        Throwable illegalStateException;
        if (this.AZH != null) {
            AppMethodBeat.m2505o(119066);
        } else if (this.AZJ != null) {
            StringBuilder stringBuilder = new StringBuilder("Built-in library initialization failed previously: ");
            Throwable th = this.AZJ;
            if (th == null) {
                C25052j.dWJ();
            }
            illegalStateException = new IllegalStateException(stringBuilder.append(th).toString(), this.AZJ);
            AppMethodBeat.m2505o(119066);
            throw illegalStateException;
        } else if (this.AZI) {
            illegalStateException = new IllegalStateException("Built-in library initialization loop");
            AppMethodBeat.m2505o(119066);
            throw illegalStateException;
        } else {
            this.AZI = true;
            boolean z;
            try {
                z = (C31619g) this.AZK.invoke();
                this.AZH = z;
                this.AZI = z;
                AppMethodBeat.m2505o(119066);
            } catch (Throwable illegalStateException2) {
                Throwable th2 = illegalStateException2;
                this.AZJ = th2;
                z = new IllegalStateException("Built-in library initialization failed. Please ensure you have kotlin-stdlib.jar in the classpath: ".concat(String.valueOf(th2)), th2);
            } finally {
                this.AZI = false;
                AppMethodBeat.m2505o(119066);
            }
        }
    }

    public final T dXD() {
        T t;
        AppMethodBeat.m2504i(119067);
        if (this.AZI) {
            synchronized (this) {
                try {
                    t = this.AZH;
                    if (t == null) {
                        Throwable assertionError = new AssertionError("Built-ins are not initialized (note: We are under the same lock as initializing and instance)");
                        throw assertionError;
                    }
                } finally {
                    AppMethodBeat.m2505o(119067);
                }
            }
            AppMethodBeat.m2505o(119067);
        } else {
            if (this.AZH == null) {
                initialize();
            }
            t = this.AZH;
            if (t == null) {
                C25052j.dWJ();
            }
            AppMethodBeat.m2505o(119067);
        }
        return t;
    }
}
