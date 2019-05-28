package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;
import p000a.p005f.p006a.C31214a;

/* renamed from: a.i.b.a.z */
public final class C25262z {

    /* renamed from: a.i.b.a.z$b */
    public static class C25263b<T> extends C25264c<T> {
        private final C31214a<T> AUr;
        private Object value = null;

        public C25263b(C31214a<T> c31214a) {
            this.AUr = c31214a;
        }

        public final T invoke() {
            AppMethodBeat.m2504i(118899);
            Object obj = this.value;
            if (obj != null) {
                obj = C25264c.m39836dv(obj);
                AppMethodBeat.m2505o(118899);
                return obj;
            }
            T invoke = this.AUr.invoke();
            this.value = C25264c.m39835du(invoke);
            AppMethodBeat.m2505o(118899);
            return invoke;
        }
    }

    /* renamed from: a.i.b.a.z$c */
    public static abstract class C25264c<T> {
        private static final Object AYw = new C252651();

        /* renamed from: a.i.b.a.z$c$1 */
        static class C252651 {
            C252651() {
            }
        }

        public abstract T invoke();

        /* renamed from: du */
        protected static Object m39835du(T t) {
            return t == null ? AYw : t;
        }

        /* renamed from: dv */
        protected static T m39836dv(Object obj) {
            return obj == AYw ? null : obj;
        }
    }

    /* renamed from: a.i.b.a.z$a */
    public static class C25266a<T> extends C25264c<T> {
        private final C31214a<T> AUr;
        private SoftReference<Object> AYv = null;

        public C25266a(T t, C31214a<T> c31214a) {
            AppMethodBeat.m2504i(118897);
            this.AUr = c31214a;
            if (t != null) {
                this.AYv = new SoftReference(C25264c.m39835du(t));
            }
            AppMethodBeat.m2505o(118897);
        }

        public final T invoke() {
            AppMethodBeat.m2504i(118898);
            SoftReference softReference = this.AYv;
            if (softReference != null) {
                Object obj = softReference.get();
                if (obj != null) {
                    obj = C25264c.m39836dv(obj);
                    AppMethodBeat.m2505o(118898);
                    return obj;
                }
            }
            T invoke = this.AUr.invoke();
            this.AYv = new SoftReference(C25264c.m39835du(invoke));
            AppMethodBeat.m2505o(118898);
            return invoke;
        }
    }

    /* renamed from: h */
    public static <T> C25263b<T> m39834h(C31214a<T> c31214a) {
        AppMethodBeat.m2504i(118900);
        C25263b c25263b = new C25263b(c31214a);
        AppMethodBeat.m2505o(118900);
        return c25263b;
    }

    /* renamed from: a */
    public static <T> C25266a<T> m39833a(T t, C31214a<T> c31214a) {
        AppMethodBeat.m2504i(118901);
        C25266a c25266a = new C25266a(t, c31214a);
        AppMethodBeat.m2505o(118901);
        return c25266a;
    }
}
