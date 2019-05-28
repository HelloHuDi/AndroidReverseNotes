package com.tencent.p177mm.kernel.p238a.p240b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a.b.a */
public final class C1654a {
    private static ThreadLocal<Stack<C1653b>> eLD = new ThreadLocal();

    /* renamed from: com.tencent.mm.kernel.a.b.a$a */
    public static class C1652a {
        Object eLA;
        Class eLE;
        Set eLF = new HashSet();

        C1652a(Object obj, Class cls) {
            AppMethodBeat.m2504i(123299);
            this.eLA = obj;
            if (cls != null) {
                this.eLE = cls;
            }
            m3346aI(this.eLA);
            AppMethodBeat.m2505o(123299);
        }

        /* renamed from: aI */
        private void m3346aI(Object obj) {
            AppMethodBeat.m2504i(123300);
            Assert.assertNotNull(obj);
            Assert.assertNotNull(this.eLE);
            if (this.eLE.isInstance(obj)) {
                AppMethodBeat.m2505o(123300);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Your depend object " + obj + " must implement your type " + this.eLE);
            AppMethodBeat.m2505o(123300);
            throw illegalArgumentException;
        }

        /* renamed from: aJ */
        public final C1652a mo5129aJ(Object obj) {
            AppMethodBeat.m2504i(123301);
            this.eLF.add(obj);
            m3346aI(obj);
            AppMethodBeat.m2505o(123301);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.kernel.a.b.a$b */
    static class C1653b {
        /* renamed from: cS */
        public HashMap<Class, C1652a> f1232cS = null;

        C1653b() {
        }
    }

    static {
        AppMethodBeat.m2504i(123305);
        AppMethodBeat.m2505o(123305);
    }

    static void start() {
        AppMethodBeat.m2504i(123303);
        C1653b c1653b = new C1653b();
        Stack stack = (Stack) eLD.get();
        if (stack == null) {
            stack = new Stack();
            eLD.set(stack);
        }
        stack.push(c1653b);
        AppMethodBeat.m2505o(123303);
    }

    /* renamed from: a */
    public static C1652a m3349a(Object obj, Class cls) {
        AppMethodBeat.m2504i(123302);
        C1653b c1653b = (C1653b) ((Stack) eLD.get()).peek();
        Assert.assertNotNull(c1653b);
        if (c1653b.f1232cS == null) {
            c1653b.f1232cS = new HashMap();
        }
        C1652a c1652a = (C1652a) c1653b.f1232cS.get(cls);
        if (c1652a == null) {
            c1652a = new C1652a(obj, cls);
            c1653b.f1232cS.put(c1652a.eLE, c1652a);
        }
        AppMethodBeat.m2505o(123302);
        return c1652a;
    }

    /* renamed from: So */
    static C1653b m3348So() {
        AppMethodBeat.m2504i(123304);
        C1653b c1653b = (C1653b) ((Stack) eLD.get()).pop();
        AppMethodBeat.m2505o(123304);
        return c1653b;
    }
}
