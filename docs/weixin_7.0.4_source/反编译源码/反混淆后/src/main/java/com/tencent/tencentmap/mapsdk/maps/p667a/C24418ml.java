package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ml */
public class C24418ml {
    /* renamed from: a */
    static final C41078mi f4872a = new C163071();
    /* renamed from: b */
    private static final C24418ml f4873b = new C24418ml();
    /* renamed from: c */
    private final AtomicReference<C41078mi> f4874c = new AtomicReference();
    /* renamed from: d */
    private final AtomicReference<C46806mj> f4875d = new AtomicReference();
    /* renamed from: e */
    private final AtomicReference<Object> f4876e = new AtomicReference();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ml$1 */
    static class C163071 extends C41078mi {
        C163071() {
        }
    }

    static {
        AppMethodBeat.m2504i(100518);
        AppMethodBeat.m2505o(100518);
    }

    /* renamed from: a */
    public static C24418ml m38014a() {
        return f4873b;
    }

    C24418ml() {
        AppMethodBeat.m2504i(100514);
        AppMethodBeat.m2505o(100514);
    }

    /* renamed from: b */
    public C41078mi mo40747b() {
        AppMethodBeat.m2504i(100515);
        if (this.f4874c.get() == null) {
            Object a = C24418ml.m38015a(C41078mi.class);
            if (a == null) {
                this.f4874c.compareAndSet(null, f4872a);
            } else {
                this.f4874c.compareAndSet(null, (C41078mi) a);
            }
        }
        C41078mi c41078mi = (C41078mi) this.f4874c.get();
        AppMethodBeat.m2505o(100515);
        return c41078mi;
    }

    /* renamed from: c */
    public C46806mj mo40748c() {
        AppMethodBeat.m2504i(100516);
        if (this.f4875d.get() == null) {
            Object a = C24418ml.m38015a(C46806mj.class);
            if (a == null) {
                this.f4875d.compareAndSet(null, C41079mk.m71481a());
            } else {
                this.f4875d.compareAndSet(null, (C46806mj) a);
            }
        }
        C46806mj c46806mj = (C46806mj) this.f4875d.get();
        AppMethodBeat.m2505o(100516);
        return c46806mj;
    }

    /* renamed from: a */
    private static Object m38015a(Class<?> cls) {
        RuntimeException runtimeException;
        AppMethodBeat.m2504i(100517);
        String simpleName = cls.getSimpleName();
        String property = System.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property != null) {
            try {
                Object newInstance = Class.forName(property).asSubclass(cls).newInstance();
                AppMethodBeat.m2505o(100517);
                return newInstance;
            } catch (ClassCastException e) {
                RuntimeException runtimeException2 = new RuntimeException(simpleName + " implementation is not an instance of " + simpleName + ": " + property);
                AppMethodBeat.m2505o(100517);
                throw runtimeException2;
            } catch (ClassNotFoundException e2) {
                runtimeException = new RuntimeException(simpleName + " implementation class not found: " + property, e2);
                AppMethodBeat.m2505o(100517);
                throw runtimeException;
            } catch (InstantiationException e3) {
                runtimeException = new RuntimeException(simpleName + " implementation not able to be instantiated: " + property, e3);
                AppMethodBeat.m2505o(100517);
                throw runtimeException;
            } catch (IllegalAccessException e4) {
                runtimeException = new RuntimeException(simpleName + " implementation not able to be accessed: " + property, e4);
                AppMethodBeat.m2505o(100517);
                throw runtimeException;
            }
        }
        AppMethodBeat.m2505o(100517);
        return null;
    }
}
