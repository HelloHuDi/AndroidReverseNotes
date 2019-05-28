package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.C1674f;
import com.tencent.p177mm.kernel.api.C1676h;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.kernel.p241b.C6617c;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.model.q */
public class C7485q implements C1669a, C1671c, C1674f, C1676h, C6617c {
    private static ConcurrentHashMap<String, C7485q> fkM = new ConcurrentHashMap();
    private volatile C1852a fkI;
    private volatile Class<? extends C1816at> fkJ;
    private volatile C1816at fkK;
    private volatile boolean fkL = false;

    /* renamed from: com.tencent.mm.model.q$a */
    public interface C1852a {
        C1816at createSubCore();
    }

    public C7485q(Class<? extends C1816at> cls) {
        AppMethodBeat.m2504i(59723);
        this.fkJ = cls;
        C7485q.m12927a(this.fkJ.getName(), this);
        AppMethodBeat.m2505o(59723);
    }

    public C7485q(C1852a c1852a) {
        this.fkI = c1852a;
    }

    /* renamed from: Yw */
    public final synchronized C1816at mo16670Yw() {
        C1816at c1816at;
        AppMethodBeat.m2504i(59724);
        if (this.fkK == null) {
            mo16671a(createSubCore());
        }
        c1816at = this.fkK;
        AppMethodBeat.m2505o(59724);
        return c1816at;
    }

    /* renamed from: a */
    public final void mo16671a(C1816at c1816at) {
        AppMethodBeat.m2504i(59725);
        synchronized (this) {
            try {
                this.fkK = c1816at;
                if (this.fkJ == null && this.fkK != null) {
                    this.fkJ = this.fkK.getClass();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(59725);
            }
        }
    }

    private C1816at createSubCore() {
        IllegalAccessError illegalAccessError;
        AppMethodBeat.m2504i(59726);
        try {
            C1816at createSubCore;
            C4990ab.m7417i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", this.fkJ, this.fkI);
            if (this.fkI != null) {
                createSubCore = this.fkI.createSubCore();
                AppMethodBeat.m2505o(59726);
            } else {
                createSubCore = (C1816at) this.fkJ.newInstance();
                AppMethodBeat.m2505o(59726);
            }
            return createSubCore;
        } catch (InstantiationException e) {
            C4990ab.printErrStackTrace("MicroMsg.CompatSubCore", e, "", new Object[0]);
            illegalAccessError = new IllegalAccessError(e.getMessage());
            AppMethodBeat.m2505o(59726);
            throw illegalAccessError;
        } catch (IllegalAccessException e2) {
            C4990ab.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
            illegalAccessError = new IllegalAccessError(e2.getMessage());
            AppMethodBeat.m2505o(59726);
            throw illegalAccessError;
        }
    }

    private synchronized void reset() {
        this.fkK = null;
        this.fkL = false;
    }

    /* renamed from: a */
    public static C7485q m12927a(String str, C7485q c7485q) {
        AppMethodBeat.m2504i(59727);
        C7485q c7485q2 = (C7485q) fkM.putIfAbsent(str, c7485q);
        if (c7485q2 == null) {
            C6610c.m10890Sa().mo14824aC(c7485q);
        } else {
            c7485q = c7485q2;
        }
        C4990ab.m7417i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", str, c7485q);
        AppMethodBeat.m2505o(59727);
        return c7485q;
    }

    /* renamed from: mF */
    public static C7485q m12929mF(String str) {
        AppMethodBeat.m2504i(59728);
        C7485q c7485q = (C7485q) fkM.get(str);
        if (c7485q == null) {
            C4990ab.m7417i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", str);
        } else {
            C6610c.m10890Sa().mo14823aB(c7485q);
        }
        AppMethodBeat.m2505o(59728);
        return c7485q;
    }

    /* renamed from: Yx */
    public static void m12926Yx() {
        AppMethodBeat.m2504i(59729);
        for (C7485q reset : fkM.values()) {
            reset.reset();
        }
        AppMethodBeat.m2505o(59729);
    }

    /* renamed from: kt */
    public static void m12928kt(int i) {
        AppMethodBeat.m2504i(59730);
        for (C7485q Yw : fkM.values()) {
            C1816at Yw2 = Yw.mo16670Yw();
            if (Yw2 != null) {
                Yw2.mo5394iy(i);
            }
        }
        AppMethodBeat.m2505o(59730);
    }

    static {
        AppMethodBeat.m2504i(59738);
        AppMethodBeat.m2505o(59738);
    }

    public HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(59732);
        C1816at Yw = mo16670Yw();
        if (Yw == null) {
            AppMethodBeat.m2505o(59732);
            return null;
        }
        HashMap<Integer, C1366d> Jx = Yw.mo5391Jx();
        AppMethodBeat.m2505o(59732);
        return Jx;
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(59733);
        C1816at Yw = mo16670Yw();
        if (Yw == null) {
            AppMethodBeat.m2505o(59733);
            return;
        }
        Yw.mo5393bz(c1705c.eKe);
        this.fkL = true;
        AppMethodBeat.m2505o(59733);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(59734);
        C1816at Yw = mo16670Yw();
        if (Yw == null) {
            AppMethodBeat.m2505o(59734);
            return;
        }
        Yw.onAccountRelease();
        AppMethodBeat.m2505o(59734);
    }

    /* renamed from: RV */
    public final void mo5174RV() {
        AppMethodBeat.m2504i(59735);
        C1816at Yw = mo16670Yw();
        if (Yw == null) {
            AppMethodBeat.m2505o(59735);
        } else if (this.fkL) {
            Yw.mo5392bA(C1445f.m3070Mn());
            AppMethodBeat.m2505o(59735);
        } else {
            AppMethodBeat.m2505o(59735);
        }
    }

    /* renamed from: lM */
    public void mo5175lM(String str) {
    }

    /* renamed from: RW */
    public final void mo5178RW() {
        AppMethodBeat.m2504i(59736);
        mo16670Yw();
        AppMethodBeat.m2505o(59736);
    }

    public String toString() {
        AppMethodBeat.m2504i(59737);
        String str = super.toString() + " " + this.fkJ + " " + this.fkI + " " + this.fkK;
        AppMethodBeat.m2505o(59737);
        return str;
    }

    /* renamed from: Y */
    public static <T extends C1816at> T m12925Y(Class<T> cls) {
        AppMethodBeat.m2504i(59731);
        C7485q mF = C7485q.m12929mF(cls.getName());
        if (mF == null) {
            mF = new C7485q((Class) cls);
            C7485q.m12927a(cls.getName(), mF);
        }
        C1816at Yw = mF.mo16670Yw();
        AppMethodBeat.m2505o(59731);
        return Yw;
    }
}
