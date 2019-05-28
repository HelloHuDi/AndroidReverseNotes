package a.i.b.a.a;

import a.a.i;
import a.a.m;
import a.a.t;
import a.f;
import a.f.b.j;
import a.f.b.r;
import a.f.b.v;
import a.i.b.a.x;
import a.i.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u0002"}, dWq = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflect-api", "hashCode", "toString"})
public final class b {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new r(v.f(b.class, "kotlin-reflect-api"), "hashCode", "<v#0>")), v.a(new r(v.f(b.class, "kotlin-reflect-api"), "toString", "<v#1>"))};

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"equals", "", "T", "", "other", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.b<Object, Boolean> {
        final /* synthetic */ Class AYS;
        final /* synthetic */ List AYT;
        final /* synthetic */ Map AYU;

        a(Class cls, List list, Map map) {
            this.AYS = cls;
            this.AYT = list;
            this.AYU = map;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(118959);
            Boolean valueOf = Boolean.valueOf(dy(obj));
            AppMethodBeat.o(118959);
            return valueOf;
        }

        public final boolean dy(Object obj) {
            Object obj2;
            Object obj3 = null;
            AppMethodBeat.i(118960);
            if (obj instanceof Annotation) {
                obj2 = obj;
            } else {
                obj2 = null;
            }
            Annotation annotation = (Annotation) obj2;
            if (annotation != null) {
                a.i.b a = a.f.a.a(annotation);
                if (a != null) {
                    obj3 = a.f.a.a(a);
                }
            }
            if (j.j(obj3, this.AYS)) {
                int i;
                Iterable<Method> iterable = this.AYT;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (Method method : iterable) {
                        boolean equals;
                        obj3 = this.AYU.get(method.getName());
                        Object invoke = method.invoke(obj, new Object[0]);
                        a.v vVar;
                        if (obj3 instanceof boolean[]) {
                            boolean[] zArr = (boolean[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.BooleanArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(zArr, (boolean[]) invoke);
                            continue;
                        } else if (obj3 instanceof char[]) {
                            char[] cArr = (char[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.CharArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(cArr, (char[]) invoke);
                            continue;
                        } else if (obj3 instanceof byte[]) {
                            byte[] bArr = (byte[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.ByteArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(bArr, (byte[]) invoke);
                            continue;
                        } else if (obj3 instanceof short[]) {
                            short[] sArr = (short[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.ShortArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(sArr, (short[]) invoke);
                            continue;
                        } else if (obj3 instanceof int[]) {
                            int[] iArr = (int[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.IntArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(iArr, (int[]) invoke);
                            continue;
                        } else if (obj3 instanceof float[]) {
                            float[] fArr = (float[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.FloatArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(fArr, (float[]) invoke);
                            continue;
                        } else if (obj3 instanceof long[]) {
                            long[] jArr = (long[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.LongArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(jArr, (long[]) invoke);
                            continue;
                        } else if (obj3 instanceof double[]) {
                            double[] dArr = (double[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.DoubleArray");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(dArr, (double[]) invoke);
                            continue;
                        } else if (obj3 instanceof Object[]) {
                            Object[] objArr = (Object[]) obj3;
                            if (invoke == null) {
                                vVar = new a.v("null cannot be cast to non-null type kotlin.Array<*>");
                                AppMethodBeat.o(118960);
                                throw vVar;
                            }
                            equals = Arrays.equals(objArr, (Object[]) invoke);
                            continue;
                        } else {
                            equals = j.j(obj3, invoke);
                            continue;
                        }
                        if (!equals) {
                            i = 0;
                            break;
                        }
                    }
                }
                i = 1;
                if (i != 0) {
                    AppMethodBeat.o(118960);
                    return true;
                }
            }
            AppMethodBeat.o(118960);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ Map AYU;

        b(Map map) {
            this.AYU = map;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118961);
            int i = 0;
            for (Entry entry : this.AYU.entrySet()) {
                int hashCode;
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) value);
                } else if (value instanceof Object[]) {
                    hashCode = Arrays.hashCode((Object[]) value);
                } else {
                    hashCode = value.hashCode();
                }
                i = (hashCode ^ (str.hashCode() * com.tencent.view.d.MIC_SketchMark)) + i;
            }
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.o(118961);
            return valueOf;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, dWq = {"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class c implements InvocationHandler {
        final /* synthetic */ Class AYS;
        final /* synthetic */ Map AYU;
        final /* synthetic */ f AYV;
        final /* synthetic */ k AYW;
        final /* synthetic */ f AYX;
        final /* synthetic */ k AYY;
        final /* synthetic */ a AYZ;

        c(Class cls, f fVar, k kVar, f fVar2, k kVar2, a aVar, Map map) {
            this.AYS = cls;
            this.AYV = fVar;
            this.AYW = kVar;
            this.AYX = fVar2;
            this.AYY = kVar2;
            this.AYZ = aVar;
            this.AYU = map;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object value;
            AppMethodBeat.i(118962);
            j.o(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
            String name = method.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1776922004:
                        if (name.equals("toString")) {
                            value = this.AYV.getValue();
                            AppMethodBeat.o(118962);
                            return value;
                        }
                        break;
                    case 147696667:
                        if (name.equals("hashCode")) {
                            value = this.AYX.getValue();
                            AppMethodBeat.o(118962);
                            return value;
                        }
                        break;
                    case 1444986633:
                        if (name.equals("annotationType")) {
                            value = this.AYS;
                            AppMethodBeat.o(118962);
                            return value;
                        }
                        break;
                }
            }
            if (j.j(name, "equals") && objArr != null && objArr.length == 1) {
                Boolean valueOf = Boolean.valueOf(this.AYZ.dy(i.O(objArr)));
                AppMethodBeat.o(118962);
                return valueOf;
            } else if (this.AYU.containsKey(name)) {
                value = this.AYU.get(name);
                AppMethodBeat.o(118962);
                return value;
            } else {
                StringBuilder append = new StringBuilder("Method is not supported: ").append(method).append(" (args: ");
                if (objArr == null) {
                    objArr = new Object[0];
                }
                Throwable xVar = new x(append.append(i.Q(objArr)).append(')').toString());
                AppMethodBeat.o(118962);
                throw xVar;
            }
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
    static final class d extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ Class AYS;
        final /* synthetic */ Map AYU;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "T", "", "entry", "", "invoke"})
        static final class a extends a.f.b.k implements a.f.a.b<Entry<? extends String, ? extends Object>, String> {
            public static final a AZa = new a();

            static {
                AppMethodBeat.i(118964);
                AppMethodBeat.o(118964);
            }

            a() {
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                String arrays;
                AppMethodBeat.i(118963);
                Entry entry = (Entry) obj;
                j.p(entry, "entry");
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    arrays = Arrays.toString((boolean[]) value);
                } else if (value instanceof char[]) {
                    arrays = Arrays.toString((char[]) value);
                } else if (value instanceof byte[]) {
                    arrays = Arrays.toString((byte[]) value);
                } else if (value instanceof short[]) {
                    arrays = Arrays.toString((short[]) value);
                } else if (value instanceof int[]) {
                    arrays = Arrays.toString((int[]) value);
                } else if (value instanceof float[]) {
                    arrays = Arrays.toString((float[]) value);
                } else if (value instanceof long[]) {
                    arrays = Arrays.toString((long[]) value);
                } else if (value instanceof double[]) {
                    arrays = Arrays.toString((double[]) value);
                } else if (value instanceof Object[]) {
                    arrays = Arrays.toString((Object[]) value);
                } else {
                    arrays = value.toString();
                }
                str = str + '=' + arrays;
                AppMethodBeat.o(118963);
                return str;
            }
        }

        d(Class cls, Map map) {
            this.AYS = cls;
            this.AYU = map;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118965);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('@');
            stringBuilder.append(this.AYS.getCanonicalName());
            t.a(this.AYU.entrySet(), stringBuilder, ", ", "(", ")", 0, null, a.AZa, 48);
            String stringBuilder2 = stringBuilder.toString();
            j.o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
            AppMethodBeat.o(118965);
            return stringBuilder2;
        }
    }

    static {
        AppMethodBeat.i(118966);
        AppMethodBeat.o(118966);
    }

    public static /* synthetic */ Object a(Class cls, Map map) {
        AppMethodBeat.i(118968);
        Iterable<String> keySet = map.keySet();
        Collection arrayList = new ArrayList(m.d(keySet));
        for (String declaredMethod : keySet) {
            arrayList.add(cls.getDeclaredMethod(declaredMethod, new Class[0]));
        }
        Object a = a(cls, map, (List) arrayList);
        AppMethodBeat.o(118968);
        return a;
    }

    public static final <T> T a(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        AppMethodBeat.i(118967);
        j.p(cls, "annotationClass");
        j.p(map, "values");
        j.p(list, "methods");
        a aVar = new a(cls, list, map);
        f g = a.i.g(new b(map));
        k kVar = eQB[0];
        f g2 = a.i.g(new d(cls, map));
        k kVar2 = eQB[1];
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new c(cls, g2, kVar2, g, kVar, aVar, map));
        if (newProxyInstance == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type T");
            AppMethodBeat.o(118967);
            throw vVar;
        }
        AppMethodBeat.o(118967);
        return newProxyInstance;
    }

    public static final /* synthetic */ Object d(Object obj, Class cls) {
        AppMethodBeat.i(118969);
        if (!(obj instanceof Class)) {
            if (obj instanceof a.i.b) {
                obj = a.f.a.a((a.i.b) obj);
            } else if (obj instanceof Object[]) {
                if (!(((Object[]) obj) instanceof Class[])) {
                    a.v vVar;
                    if (!(((Object[]) obj) instanceof a.i.b[])) {
                        Object[] obj2 = (Object[]) obj2;
                    } else if (obj2 == null) {
                        vVar = new a.v("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                        AppMethodBeat.o(118969);
                        throw vVar;
                    } else {
                        a.i.b[] bVarArr = (a.i.b[]) obj2;
                        Collection arrayList = new ArrayList(bVarArr.length);
                        for (a.i.b a : bVarArr) {
                            arrayList.add(a.f.a.a(a));
                        }
                        obj2 = ((List) arrayList).toArray(new Class[0]);
                        if (obj2 == null) {
                            vVar = new a.v("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.o(118969);
                            throw vVar;
                        }
                    }
                }
            }
            if (cls.isInstance(obj2)) {
                AppMethodBeat.o(118969);
                return obj2;
            }
        }
        AppMethodBeat.o(118969);
        return null;
    }
}
