package com.tencent.p177mm.plugin.messenger.foundation.p454a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.a.u */
public final class C21281u {
    private static SparseArray<C21282a> oqA = new SparseArray();
    private static C32467c<C21280t> oqB;

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.u$a */
    static class C21282a<T extends C1331a> extends C6454a<C28495s<T>> implements C28495s<T> {
        private C21282a() {
        }

        /* synthetic */ C21282a(byte b) {
            this();
        }

        /* renamed from: f */
        public final void mo35244f(final T t) {
            AppMethodBeat.m2504i(60009);
            mo14669a(new C1387a<C28495s<T>>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(60007);
                    ((C28495s) obj).mo35244f(t);
                    AppMethodBeat.m2505o(60007);
                }
            });
            AppMethodBeat.m2505o(60009);
        }

        /* renamed from: e */
        public final void mo35243e(final T t) {
            AppMethodBeat.m2504i(60010);
            mo14669a(new C1387a<C28495s<T>>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(60008);
                    ((C28495s) obj).mo35243e(t);
                    AppMethodBeat.m2505o(60008);
                }
            });
            AppMethodBeat.m2505o(60010);
        }
    }

    static {
        AppMethodBeat.m2504i(60015);
        AppMethodBeat.m2505o(60015);
    }

    /* renamed from: a */
    public static synchronized <T extends C1331a> void m32651a(int i, C28495s<T> c28495s) {
        synchronized (C21281u.class) {
            AppMethodBeat.m2504i(60011);
            C21282a c21282a = (C21282a) oqA.get(i);
            if (c21282a == null) {
                c21282a = new C21282a();
                oqA.put(i, c21282a);
            }
            c21282a.mo14670aD(c28495s);
            AppMethodBeat.m2505o(60011);
        }
    }

    /* renamed from: a */
    public static synchronized void m32652a(C28495s c28495s) {
        synchronized (C21281u.class) {
            AppMethodBeat.m2504i(60012);
            C21282a c21282a = (C21282a) oqA.get(5);
            if (c21282a != null) {
                c21282a.remove(c28495s);
                if (c21282a.size() == 0) {
                    oqA.remove(5);
                }
            }
            AppMethodBeat.m2505o(60012);
        }
    }

    /* renamed from: h */
    public static synchronized <T extends C1331a> void m32655h(T t) {
        synchronized (C21281u.class) {
            AppMethodBeat.m2504i(60013);
            C21282a c21282a = (C21282a) oqA.get(5);
            if (c21282a != null) {
                c21282a.mo35244f(t);
            }
            AppMethodBeat.m2505o(60013);
        }
    }

    /* renamed from: b */
    public static synchronized <T extends C1331a> void m32653b(int i, T t) {
        synchronized (C21281u.class) {
            AppMethodBeat.m2504i(60014);
            C21282a c21282a = (C21282a) oqA.get(i);
            if (c21282a != null) {
                c21282a.mo35243e(t);
            }
            AppMethodBeat.m2505o(60014);
        }
    }

    public static final C32467c<C21280t> bOt() {
        return oqB;
    }

    /* renamed from: b */
    public static final void m32654b(C32467c<C21280t> c32467c) {
        oqB = c32467c;
    }
}
