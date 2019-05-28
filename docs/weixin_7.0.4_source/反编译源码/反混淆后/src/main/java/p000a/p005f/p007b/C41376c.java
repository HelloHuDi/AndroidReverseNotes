package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import p000a.p005f.C25055b;
import p000a.p010i.C44858a;
import p000a.p010i.C44935d;

/* renamed from: a.f.b.c */
public abstract class C41376c implements C44858a, Serializable {
    public static final Object AVy = C41375a.AVz;
    private transient C44858a AVw;
    protected final Object AVx;

    /* renamed from: a.f.b.c$a */
    static class C41375a implements Serializable {
        private static final C41375a AVz = new C41375a();

        private C41375a() {
        }

        static {
            AppMethodBeat.m2504i(55898);
            AppMethodBeat.m2505o(55898);
        }

        private Object readResolve() {
            return AVz;
        }
    }

    public abstract C44858a dWB();

    public C41376c() {
        this(AVy);
    }

    protected C41376c(Object obj) {
        this.AVx = obj;
    }

    public final Object dWC() {
        return this.AVx;
    }

    public final C44858a dWD() {
        C44858a c44858a = this.AVw;
        if (c44858a != null) {
            return c44858a;
        }
        c44858a = dWB();
        this.AVw = c44858a;
        return c44858a;
    }

    /* Access modifiers changed, original: protected */
    public C44858a dWE() {
        C41376c dWD = dWD();
        if (dWD != this) {
            return dWD;
        }
        throw new C25055b();
    }

    public C44935d dWF() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String due() {
        throw new AbstractMethodError();
    }

    /* renamed from: W */
    public final Object mo66046W(Object... objArr) {
        return dWE().mo66046W(objArr);
    }
}
