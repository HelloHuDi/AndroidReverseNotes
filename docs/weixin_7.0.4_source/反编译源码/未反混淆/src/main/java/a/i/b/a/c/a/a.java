package a.i.b.a.c.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<T extends g> {
    private volatile T AZH;
    private volatile boolean AZI;
    private Throwable AZJ;
    private final a.f.a.a<T> AZK;

    public a(a.f.a.a<? extends T> aVar) {
        j.p(aVar, "constructor");
        AppMethodBeat.i(119068);
        this.AZK = aVar;
        AppMethodBeat.o(119068);
    }

    private final synchronized void initialize() {
        AppMethodBeat.i(119066);
        Throwable illegalStateException;
        if (this.AZH != null) {
            AppMethodBeat.o(119066);
        } else if (this.AZJ != null) {
            StringBuilder stringBuilder = new StringBuilder("Built-in library initialization failed previously: ");
            Throwable th = this.AZJ;
            if (th == null) {
                j.dWJ();
            }
            illegalStateException = new IllegalStateException(stringBuilder.append(th).toString(), this.AZJ);
            AppMethodBeat.o(119066);
            throw illegalStateException;
        } else if (this.AZI) {
            illegalStateException = new IllegalStateException("Built-in library initialization loop");
            AppMethodBeat.o(119066);
            throw illegalStateException;
        } else {
            this.AZI = true;
            boolean z;
            try {
                z = (g) this.AZK.invoke();
                this.AZH = z;
                this.AZI = z;
                AppMethodBeat.o(119066);
            } catch (Throwable illegalStateException2) {
                Throwable th2 = illegalStateException2;
                this.AZJ = th2;
                z = new IllegalStateException("Built-in library initialization failed. Please ensure you have kotlin-stdlib.jar in the classpath: ".concat(String.valueOf(th2)), th2);
            } finally {
                this.AZI = false;
                AppMethodBeat.o(119066);
            }
        }
    }

    public final T dXD() {
        T t;
        AppMethodBeat.i(119067);
        if (this.AZI) {
            synchronized (this) {
                try {
                    t = this.AZH;
                    if (t == null) {
                        Throwable assertionError = new AssertionError("Built-ins are not initialized (note: We are under the same lock as initializing and instance)");
                        throw assertionError;
                    }
                } finally {
                    AppMethodBeat.o(119067);
                }
            }
            AppMethodBeat.o(119067);
        } else {
            if (this.AZH == null) {
                initialize();
            }
            t = this.AZH;
            if (t == null) {
                j.dWJ();
            }
            AppMethodBeat.o(119067);
        }
        return t;
    }
}
