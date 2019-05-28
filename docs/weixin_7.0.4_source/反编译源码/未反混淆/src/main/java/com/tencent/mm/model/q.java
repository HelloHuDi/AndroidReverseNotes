package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class q implements com.tencent.mm.kernel.api.a, c, f, h, com.tencent.mm.kernel.b.c {
    private static ConcurrentHashMap<String, q> fkM = new ConcurrentHashMap();
    private volatile a fkI;
    private volatile Class<? extends at> fkJ;
    private volatile at fkK;
    private volatile boolean fkL = false;

    public interface a {
        at createSubCore();
    }

    public q(Class<? extends at> cls) {
        AppMethodBeat.i(59723);
        this.fkJ = cls;
        a(this.fkJ.getName(), this);
        AppMethodBeat.o(59723);
    }

    public q(a aVar) {
        this.fkI = aVar;
    }

    public final synchronized at Yw() {
        at atVar;
        AppMethodBeat.i(59724);
        if (this.fkK == null) {
            a(createSubCore());
        }
        atVar = this.fkK;
        AppMethodBeat.o(59724);
        return atVar;
    }

    public final void a(at atVar) {
        AppMethodBeat.i(59725);
        synchronized (this) {
            try {
                this.fkK = atVar;
                if (this.fkJ == null && this.fkK != null) {
                    this.fkJ = this.fkK.getClass();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(59725);
            }
        }
    }

    private at createSubCore() {
        IllegalAccessError illegalAccessError;
        AppMethodBeat.i(59726);
        try {
            at createSubCore;
            ab.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", this.fkJ, this.fkI);
            if (this.fkI != null) {
                createSubCore = this.fkI.createSubCore();
                AppMethodBeat.o(59726);
            } else {
                createSubCore = (at) this.fkJ.newInstance();
                AppMethodBeat.o(59726);
            }
            return createSubCore;
        } catch (InstantiationException e) {
            ab.printErrStackTrace("MicroMsg.CompatSubCore", e, "", new Object[0]);
            illegalAccessError = new IllegalAccessError(e.getMessage());
            AppMethodBeat.o(59726);
            throw illegalAccessError;
        } catch (IllegalAccessException e2) {
            ab.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
            illegalAccessError = new IllegalAccessError(e2.getMessage());
            AppMethodBeat.o(59726);
            throw illegalAccessError;
        }
    }

    private synchronized void reset() {
        this.fkK = null;
        this.fkL = false;
    }

    public static q a(String str, q qVar) {
        AppMethodBeat.i(59727);
        q qVar2 = (q) fkM.putIfAbsent(str, qVar);
        if (qVar2 == null) {
            com.tencent.mm.kernel.a.c.Sa().aC(qVar);
        } else {
            qVar = qVar2;
        }
        ab.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", str, qVar);
        AppMethodBeat.o(59727);
        return qVar;
    }

    public static q mF(String str) {
        AppMethodBeat.i(59728);
        q qVar = (q) fkM.get(str);
        if (qVar == null) {
            ab.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", str);
        } else {
            com.tencent.mm.kernel.a.c.Sa().aB(qVar);
        }
        AppMethodBeat.o(59728);
        return qVar;
    }

    public static void Yx() {
        AppMethodBeat.i(59729);
        for (q reset : fkM.values()) {
            reset.reset();
        }
        AppMethodBeat.o(59729);
    }

    public static void kt(int i) {
        AppMethodBeat.i(59730);
        for (q Yw : fkM.values()) {
            at Yw2 = Yw.Yw();
            if (Yw2 != null) {
                Yw2.iy(i);
            }
        }
        AppMethodBeat.o(59730);
    }

    static {
        AppMethodBeat.i(59738);
        AppMethodBeat.o(59738);
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        AppMethodBeat.i(59732);
        at Yw = Yw();
        if (Yw == null) {
            AppMethodBeat.o(59732);
            return null;
        }
        HashMap<Integer, d> Jx = Yw.Jx();
        AppMethodBeat.o(59732);
        return Jx;
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(59733);
        at Yw = Yw();
        if (Yw == null) {
            AppMethodBeat.o(59733);
            return;
        }
        Yw.bz(cVar.eKe);
        this.fkL = true;
        AppMethodBeat.o(59733);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(59734);
        at Yw = Yw();
        if (Yw == null) {
            AppMethodBeat.o(59734);
            return;
        }
        Yw.onAccountRelease();
        AppMethodBeat.o(59734);
    }

    public final void RV() {
        AppMethodBeat.i(59735);
        at Yw = Yw();
        if (Yw == null) {
            AppMethodBeat.o(59735);
        } else if (this.fkL) {
            Yw.bA(com.tencent.mm.compatible.util.f.Mn());
            AppMethodBeat.o(59735);
        } else {
            AppMethodBeat.o(59735);
        }
    }

    public void lM(String str) {
    }

    public final void RW() {
        AppMethodBeat.i(59736);
        Yw();
        AppMethodBeat.o(59736);
    }

    public String toString() {
        AppMethodBeat.i(59737);
        String str = super.toString() + " " + this.fkJ + " " + this.fkI + " " + this.fkK;
        AppMethodBeat.o(59737);
        return str;
    }

    public static <T extends at> T Y(Class<T> cls) {
        AppMethodBeat.i(59731);
        q mF = mF(cls.getName());
        if (mF == null) {
            mF = new q((Class) cls);
            a(cls.getName(), mF);
        }
        at Yw = mF.Yw();
        AppMethodBeat.o(59731);
        return Yw;
    }
}
