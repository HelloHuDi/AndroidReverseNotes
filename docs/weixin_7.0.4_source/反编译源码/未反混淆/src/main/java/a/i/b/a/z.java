package a.i.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.SoftReference;

public final class z {

    public static class b<T> extends c<T> {
        private final a.f.a.a<T> AUr;
        private Object value = null;

        public b(a.f.a.a<T> aVar) {
            this.AUr = aVar;
        }

        public final T invoke() {
            AppMethodBeat.i(118899);
            Object obj = this.value;
            if (obj != null) {
                obj = c.dv(obj);
                AppMethodBeat.o(118899);
                return obj;
            }
            T invoke = this.AUr.invoke();
            this.value = c.du(invoke);
            AppMethodBeat.o(118899);
            return invoke;
        }
    }

    public static abstract class c<T> {
        private static final Object AYw = new Object() {
        };

        public abstract T invoke();

        protected static Object du(T t) {
            return t == null ? AYw : t;
        }

        protected static T dv(Object obj) {
            return obj == AYw ? null : obj;
        }
    }

    public static class a<T> extends c<T> {
        private final a.f.a.a<T> AUr;
        private SoftReference<Object> AYv = null;

        public a(T t, a.f.a.a<T> aVar) {
            AppMethodBeat.i(118897);
            this.AUr = aVar;
            if (t != null) {
                this.AYv = new SoftReference(c.du(t));
            }
            AppMethodBeat.o(118897);
        }

        public final T invoke() {
            AppMethodBeat.i(118898);
            SoftReference softReference = this.AYv;
            if (softReference != null) {
                Object obj = softReference.get();
                if (obj != null) {
                    obj = c.dv(obj);
                    AppMethodBeat.o(118898);
                    return obj;
                }
            }
            T invoke = this.AUr.invoke();
            this.AYv = new SoftReference(c.du(invoke));
            AppMethodBeat.o(118898);
            return invoke;
        }
    }

    public static <T> b<T> h(a.f.a.a<T> aVar) {
        AppMethodBeat.i(118900);
        b bVar = new b(aVar);
        AppMethodBeat.o(118900);
        return bVar;
    }

    public static <T> a<T> a(T t, a.f.a.a<T> aVar) {
        AppMethodBeat.i(118901);
        a aVar2 = new a(t, aVar);
        AppMethodBeat.o(118901);
        return aVar2;
    }
}
