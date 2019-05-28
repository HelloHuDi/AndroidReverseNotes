package a.f.b;

import a.f.b;
import a.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public abstract class c implements a.i.a, Serializable {
    public static final Object AVy = a.AVz;
    private transient a.i.a AVw;
    protected final Object AVx;

    static class a implements Serializable {
        private static final a AVz = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(55898);
            AppMethodBeat.o(55898);
        }

        private Object readResolve() {
            return AVz;
        }
    }

    public abstract a.i.a dWB();

    public c() {
        this(AVy);
    }

    protected c(Object obj) {
        this.AVx = obj;
    }

    public final Object dWC() {
        return this.AVx;
    }

    public final a.i.a dWD() {
        a.i.a aVar = this.AVw;
        if (aVar != null) {
            return aVar;
        }
        aVar = dWB();
        this.AVw = aVar;
        return aVar;
    }

    /* Access modifiers changed, original: protected */
    public a.i.a dWE() {
        c dWD = dWD();
        if (dWD != this) {
            return dWD;
        }
        throw new b();
    }

    public d dWF() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String due() {
        throw new AbstractMethodError();
    }

    public final Object W(Object... objArr) {
        return dWE().W(objArr);
    }
}
