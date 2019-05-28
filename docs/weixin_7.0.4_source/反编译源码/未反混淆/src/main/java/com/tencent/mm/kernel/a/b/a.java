package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a {
    private static ThreadLocal<Stack<b>> eLD = new ThreadLocal();

    public static class a {
        Object eLA;
        Class eLE;
        Set eLF = new HashSet();

        a(Object obj, Class cls) {
            AppMethodBeat.i(123299);
            this.eLA = obj;
            if (cls != null) {
                this.eLE = cls;
            }
            aI(this.eLA);
            AppMethodBeat.o(123299);
        }

        private void aI(Object obj) {
            AppMethodBeat.i(123300);
            Assert.assertNotNull(obj);
            Assert.assertNotNull(this.eLE);
            if (this.eLE.isInstance(obj)) {
                AppMethodBeat.o(123300);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Your depend object " + obj + " must implement your type " + this.eLE);
            AppMethodBeat.o(123300);
            throw illegalArgumentException;
        }

        public final a aJ(Object obj) {
            AppMethodBeat.i(123301);
            this.eLF.add(obj);
            aI(obj);
            AppMethodBeat.o(123301);
            return this;
        }
    }

    static class b {
        public HashMap<Class, a> cS = null;

        b() {
        }
    }

    static {
        AppMethodBeat.i(123305);
        AppMethodBeat.o(123305);
    }

    static void start() {
        AppMethodBeat.i(123303);
        b bVar = new b();
        Stack stack = (Stack) eLD.get();
        if (stack == null) {
            stack = new Stack();
            eLD.set(stack);
        }
        stack.push(bVar);
        AppMethodBeat.o(123303);
    }

    public static a a(Object obj, Class cls) {
        AppMethodBeat.i(123302);
        b bVar = (b) ((Stack) eLD.get()).peek();
        Assert.assertNotNull(bVar);
        if (bVar.cS == null) {
            bVar.cS = new HashMap();
        }
        a aVar = (a) bVar.cS.get(cls);
        if (aVar == null) {
            aVar = new a(obj, cls);
            bVar.cS.put(aVar.eLE, aVar);
        }
        AppMethodBeat.o(123302);
        return aVar;
    }

    static b So() {
        AppMethodBeat.i(123304);
        b bVar = (b) ((Stack) eLD.get()).pop();
        AppMethodBeat.o(123304);
        return bVar;
    }
}
