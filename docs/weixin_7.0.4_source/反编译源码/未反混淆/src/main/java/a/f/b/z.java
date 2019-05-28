package a.f.b;

import a.c;
import a.f.a.d;
import a.f.a.e;
import a.f.a.g;
import a.f.a.h;
import a.f.a.i;
import a.f.a.j;
import a.f.a.k;
import a.f.a.l;
import a.f.a.m;
import a.f.a.n;
import a.f.a.o;
import a.f.a.p;
import a.f.a.q;
import a.f.a.r;
import a.f.a.s;
import a.f.a.t;
import a.f.a.u;
import a.f.a.v;
import a.f.a.w;
import a.f.b.a.a;
import a.f.b.a.b;
import a.f.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Collection;
import java.util.Set;

public class z {
    private static <T extends Throwable> T o(T t) {
        AppMethodBeat.i(55899);
        Throwable b = j.b(t, z.class.getName());
        AppMethodBeat.o(55899);
        return b;
    }

    private static void q(Object obj, String str) {
        AppMethodBeat.i(55900);
        ClassCastException classCastException = (ClassCastException) o(new ClassCastException((obj == null ? BuildConfig.COMMAND : obj.getClass().getName()) + " cannot be cast to " + str));
        AppMethodBeat.o(55900);
        throw classCastException;
    }

    public static Collection dp(Object obj) {
        AppMethodBeat.i(55901);
        if ((obj instanceof a) && !(obj instanceof b)) {
            q(obj, "kotlin.collections.MutableCollection");
        }
        Collection dq = dq(obj);
        AppMethodBeat.o(55901);
        return dq;
    }

    private static Collection dq(Object obj) {
        AppMethodBeat.i(55902);
        try {
            Collection collection = (Collection) obj;
            AppMethodBeat.o(55902);
            return collection;
        } catch (ClassCastException classCastException) {
            ClassCastException classCastException2 = (ClassCastException) o(classCastException2);
            AppMethodBeat.o(55902);
            throw classCastException2;
        }
    }

    public static Set dr(Object obj) {
        AppMethodBeat.i(55903);
        if ((obj instanceof a) && !(obj instanceof f)) {
            q(obj, "kotlin.collections.MutableSet");
        }
        Set ds = ds(obj);
        AppMethodBeat.o(55903);
        return ds;
    }

    private static Set ds(Object obj) {
        AppMethodBeat.i(55904);
        try {
            Set set = (Set) obj;
            AppMethodBeat.o(55904);
            return set;
        } catch (ClassCastException classCastException) {
            ClassCastException classCastException2 = (ClassCastException) o(classCastException2);
            AppMethodBeat.o(55904);
            throw classCastException2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object dt(Object obj) {
        AppMethodBeat.i(55905);
        if (obj != null) {
            Object obj2;
            if (obj instanceof c) {
                int dWz;
                if (obj instanceof h) {
                    dWz = ((h) obj).dWz();
                } else if (obj instanceof a.f.a.a) {
                    dWz = 0;
                } else if (obj instanceof a.f.a.b) {
                    dWz = 1;
                } else if (obj instanceof m) {
                    dWz = 2;
                } else if (obj instanceof q) {
                    dWz = 3;
                } else if (obj instanceof r) {
                    dWz = 4;
                } else if (obj instanceof s) {
                    dWz = 5;
                } else if (obj instanceof t) {
                    dWz = 6;
                } else if (obj instanceof u) {
                    dWz = 7;
                } else if (obj instanceof v) {
                    dWz = 8;
                } else if (obj instanceof w) {
                    dWz = 9;
                } else if (obj instanceof a.f.a.c) {
                    dWz = 10;
                } else if (obj instanceof d) {
                    dWz = 11;
                } else if (obj instanceof e) {
                    dWz = 12;
                } else if (obj instanceof a.f.a.f) {
                    dWz = 13;
                } else if (obj instanceof g) {
                    dWz = 14;
                } else if (obj instanceof h) {
                    dWz = 15;
                } else if (obj instanceof i) {
                    dWz = 16;
                } else if (obj instanceof j) {
                    dWz = 17;
                } else if (obj instanceof k) {
                    dWz = 18;
                } else if (obj instanceof l) {
                    dWz = 19;
                } else if (obj instanceof n) {
                    dWz = 20;
                } else if (obj instanceof o) {
                    dWz = 21;
                } else if (obj instanceof p) {
                    dWz = 22;
                } else {
                    dWz = -1;
                }
                if (dWz == 2) {
                    obj2 = 1;
                    if (obj2 == null) {
                        q(obj, "kotlin.jvm.functions.Function2");
                    }
                }
            }
            obj2 = null;
            if (obj2 == null) {
            }
        }
        AppMethodBeat.o(55905);
        return obj;
    }
}
