package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.c;

public final class u {
    private static SparseArray<a> oqA = new SparseArray();
    private static c<t> oqB;

    static class a<T extends com.tencent.mm.bt.a> extends com.tencent.mm.ci.a<s<T>> implements s<T> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void f(final T t) {
            AppMethodBeat.i(60009);
            a(new com.tencent.mm.ci.a.a<s<T>>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(60007);
                    ((s) obj).f(t);
                    AppMethodBeat.o(60007);
                }
            });
            AppMethodBeat.o(60009);
        }

        public final void e(final T t) {
            AppMethodBeat.i(60010);
            a(new com.tencent.mm.ci.a.a<s<T>>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(60008);
                    ((s) obj).e(t);
                    AppMethodBeat.o(60008);
                }
            });
            AppMethodBeat.o(60010);
        }
    }

    static {
        AppMethodBeat.i(60015);
        AppMethodBeat.o(60015);
    }

    public static synchronized <T extends com.tencent.mm.bt.a> void a(int i, s<T> sVar) {
        synchronized (u.class) {
            AppMethodBeat.i(60011);
            a aVar = (a) oqA.get(i);
            if (aVar == null) {
                aVar = new a();
                oqA.put(i, aVar);
            }
            aVar.aD(sVar);
            AppMethodBeat.o(60011);
        }
    }

    public static synchronized void a(s sVar) {
        synchronized (u.class) {
            AppMethodBeat.i(60012);
            a aVar = (a) oqA.get(5);
            if (aVar != null) {
                aVar.remove(sVar);
                if (aVar.size() == 0) {
                    oqA.remove(5);
                }
            }
            AppMethodBeat.o(60012);
        }
    }

    public static synchronized <T extends com.tencent.mm.bt.a> void h(T t) {
        synchronized (u.class) {
            AppMethodBeat.i(60013);
            a aVar = (a) oqA.get(5);
            if (aVar != null) {
                aVar.f(t);
            }
            AppMethodBeat.o(60013);
        }
    }

    public static synchronized <T extends com.tencent.mm.bt.a> void b(int i, T t) {
        synchronized (u.class) {
            AppMethodBeat.i(60014);
            a aVar = (a) oqA.get(i);
            if (aVar != null) {
                aVar.e(t);
            }
            AppMethodBeat.o(60014);
        }
    }

    public static final c<t> bOt() {
        return oqB;
    }

    public static final void b(c<t> cVar) {
        oqB = cVar;
    }
}
