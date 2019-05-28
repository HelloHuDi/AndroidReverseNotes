package a.f.b;

import a.i.b;
import a.i.d;
import a.i.e;
import a.i.h;
import a.i.l;
import a.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v {
    private static final w AVF;
    private static final b[] AVG = new b[0];

    static {
        w wVar;
        AppMethodBeat.i(55882);
        try {
            wVar = (w) Class.forName("a.i.b.a.aa").newInstance();
        } catch (ClassCastException e) {
            wVar = null;
        } catch (ClassNotFoundException e2) {
            wVar = null;
        } catch (InstantiationException e3) {
            wVar = null;
        } catch (IllegalAccessException e4) {
            wVar = null;
        }
        if (wVar == null) {
            wVar = new w();
        }
        AVF = wVar;
        AppMethodBeat.o(55882);
    }

    public static d f(Class cls, String str) {
        AppMethodBeat.i(55874);
        d f = AVF.f(cls, str);
        AppMethodBeat.o(55874);
        return f;
    }

    public static b aN(Class cls) {
        AppMethodBeat.i(55875);
        b aN = AVF.aN(cls);
        AppMethodBeat.o(55875);
        return aN;
    }

    public static String a(k kVar) {
        AppMethodBeat.i(55876);
        String a = AVF.a(kVar);
        AppMethodBeat.o(55876);
        return a;
    }

    public static String a(h hVar) {
        AppMethodBeat.i(55877);
        String a = AVF.a(hVar);
        AppMethodBeat.o(55877);
        return a;
    }

    public static e a(i iVar) {
        AppMethodBeat.i(55878);
        e a = AVF.a(iVar);
        AppMethodBeat.o(55878);
        return a;
    }

    public static l a(q qVar) {
        AppMethodBeat.i(55879);
        l a = AVF.a(qVar);
        AppMethodBeat.o(55879);
        return a;
    }

    public static m a(s sVar) {
        AppMethodBeat.i(55880);
        m a = AVF.a(sVar);
        AppMethodBeat.o(55880);
        return a;
    }

    public static h a(m mVar) {
        AppMethodBeat.i(55881);
        h a = AVF.a(mVar);
        AppMethodBeat.o(55881);
        return a;
    }
}
