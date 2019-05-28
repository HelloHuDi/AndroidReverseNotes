package com.bumptech.glide.p095h.p1136a;

import android.support.p057v4.p065f.C37122k.C16505b;
import android.support.p057v4.p065f.C37122k.C25335c;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.h.a.a */
public final class C37193a {
    private static final C17560d<Object> aIi = new C246491();

    /* renamed from: com.bumptech.glide.h.a.a$b */
    static final class C16508b<T> implements C8387a<T> {
        private final C8387a<T> aAr;
        private final C37194a<T> aIj;
        private final C17560d<T> aIk;

        C16508b(C8387a<T> c8387a, C37194a<T> c37194a, C17560d<T> c17560d) {
            this.aAr = c8387a;
            this.aIj = c37194a;
            this.aIk = c17560d;
        }

        /* renamed from: aA */
        public final T mo6364aA() {
            AppMethodBeat.m2504i(92618);
            T aA = this.aAr.mo6364aA();
            if (aA == null) {
                aA = this.aIj.mo18632mG();
                if (Log.isLoggable("FactoryPools", 2)) {
                    new StringBuilder("Created new ").append(aA.getClass());
                }
            }
            if (aA instanceof C31972c) {
                ((C31972c) aA).mo18630my().mo31992ay(false);
            }
            AppMethodBeat.m2505o(92618);
            return aA;
        }

        public final boolean release(T t) {
            AppMethodBeat.m2504i(92619);
            if (t instanceof C31972c) {
                ((C31972c) t).mo18630my().mo31992ay(true);
            }
            this.aIk.reset(t);
            boolean release = this.aAr.release(t);
            AppMethodBeat.m2505o(92619);
            return release;
        }
    }

    /* renamed from: com.bumptech.glide.h.a.a$2 */
    class C175592 implements C37194a<List<T>> {
        C175592() {
        }

        /* renamed from: mG */
        public final /* synthetic */ Object mo18632mG() {
            AppMethodBeat.m2504i(92616);
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(92616);
            return arrayList;
        }
    }

    /* renamed from: com.bumptech.glide.h.a.a$d */
    public interface C17560d<T> {
        void reset(T t);
    }

    /* renamed from: com.bumptech.glide.h.a.a$1 */
    class C246491 implements C17560d<Object> {
        C246491() {
        }

        public final void reset(Object obj) {
        }
    }

    /* renamed from: com.bumptech.glide.h.a.a$c */
    public interface C31972c {
        /* renamed from: my */
        C41574b mo18630my();
    }

    /* renamed from: com.bumptech.glide.h.a.a$a */
    public interface C37194a<T> {
        /* renamed from: mG */
        T mo18632mG();
    }

    /* renamed from: com.bumptech.glide.h.a.a$3 */
    class C371953 implements C17560d<List<T>> {
        C371953() {
        }

        public final /* synthetic */ void reset(Object obj) {
            AppMethodBeat.m2504i(92617);
            ((List) obj).clear();
            AppMethodBeat.m2505o(92617);
        }
    }

    static {
        AppMethodBeat.m2504i(92625);
        AppMethodBeat.m2505o(92625);
    }

    /* renamed from: a */
    public static <T extends C31972c> C8387a<T> m62344a(C37194a<T> c37194a) {
        AppMethodBeat.m2504i(92620);
        C8387a a = C37193a.m62342a(new C16505b(150), (C37194a) c37194a);
        AppMethodBeat.m2505o(92620);
        return a;
    }

    /* renamed from: a */
    public static <T extends C31972c> C8387a<T> m62341a(int i, C37194a<T> c37194a) {
        AppMethodBeat.m2504i(92621);
        C8387a a = C37193a.m62342a(new C25335c(i), (C37194a) c37194a);
        AppMethodBeat.m2505o(92621);
        return a;
    }

    /* renamed from: a */
    private static <T> C8387a<T> m62343a(C8387a<T> c8387a, C37194a<T> c37194a, C17560d<T> c17560d) {
        AppMethodBeat.m2504i(92624);
        C16508b c16508b = new C16508b(c8387a, c37194a, c17560d);
        AppMethodBeat.m2505o(92624);
        return c16508b;
    }

    /* renamed from: op */
    public static <T> C8387a<List<T>> m62345op() {
        AppMethodBeat.m2504i(92622);
        C8387a a = C37193a.m62343a(new C25335c(20), new C175592(), new C371953());
        AppMethodBeat.m2505o(92622);
        return a;
    }

    /* renamed from: a */
    private static <T extends C31972c> C8387a<T> m62342a(C8387a<T> c8387a, C37194a<T> c37194a) {
        AppMethodBeat.m2504i(92623);
        C8387a a = C37193a.m62343a(c8387a, c37194a, aIi);
        AppMethodBeat.m2505o(92623);
        return a;
    }
}
