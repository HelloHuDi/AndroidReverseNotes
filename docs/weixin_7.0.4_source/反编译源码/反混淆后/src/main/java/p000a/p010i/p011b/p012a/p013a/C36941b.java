package p000a.p010i.p011b.p012a.p013a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
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
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p001a.C36913i;
import p000a.p005f.C25047a;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C17085r;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.C36663b;
import p000a.p010i.p011b.p012a.C25261x;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u0002"}, dWq = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflect-api", "hashCode", "toString"})
/* renamed from: a.i.b.a.a.b */
public final class C36941b {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82051a(new C17085r(C44855v.m82056f(C36941b.class, "kotlin-reflect-api"), "hashCode", "<v#0>")), C44855v.m82051a(new C17085r(C44855v.m82056f(C36941b.class, "kotlin-reflect-api"), "toString", "<v#1>"))};

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"equals", "", "T", "", "other", "invoke"})
    /* renamed from: a.i.b.a.a.b$a */
    static final class C0017a extends C25053k implements C17126b<Object, Boolean> {
        final /* synthetic */ Class AYS;
        final /* synthetic */ List AYT;
        final /* synthetic */ Map AYU;

        C0017a(Class cls, List list, Map map) {
            this.AYS = cls;
            this.AYT = list;
            this.AYU = map;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(118959);
            Boolean valueOf = Boolean.valueOf(mo51dy(obj));
            AppMethodBeat.m2505o(118959);
            return valueOf;
        }

        /* renamed from: dy */
        public final boolean mo51dy(Object obj) {
            Object obj2;
            Object obj3 = null;
            AppMethodBeat.m2504i(118960);
            if (obj instanceof Annotation) {
                obj2 = obj;
            } else {
                obj2 = null;
            }
            Annotation annotation = (Annotation) obj2;
            if (annotation != null) {
                C36663b a = C25047a.m39367a(annotation);
                if (a != null) {
                    obj3 = C25047a.m39368a(a);
                }
            }
            if (C25052j.m39373j(obj3, this.AYS)) {
                int i;
                Iterable<Method> iterable = this.AYT;
                if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
                    for (Method method : iterable) {
                        boolean equals;
                        obj3 = this.AYU.get(method.getName());
                        Object invoke = method.invoke(obj, new Object[0]);
                        C44941v c44941v;
                        if (obj3 instanceof boolean[]) {
                            boolean[] zArr = (boolean[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.BooleanArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(zArr, (boolean[]) invoke);
                            continue;
                        } else if (obj3 instanceof char[]) {
                            char[] cArr = (char[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.CharArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(cArr, (char[]) invoke);
                            continue;
                        } else if (obj3 instanceof byte[]) {
                            byte[] bArr = (byte[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.ByteArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(bArr, (byte[]) invoke);
                            continue;
                        } else if (obj3 instanceof short[]) {
                            short[] sArr = (short[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.ShortArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(sArr, (short[]) invoke);
                            continue;
                        } else if (obj3 instanceof int[]) {
                            int[] iArr = (int[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.IntArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(iArr, (int[]) invoke);
                            continue;
                        } else if (obj3 instanceof float[]) {
                            float[] fArr = (float[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.FloatArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(fArr, (float[]) invoke);
                            continue;
                        } else if (obj3 instanceof long[]) {
                            long[] jArr = (long[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.LongArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(jArr, (long[]) invoke);
                            continue;
                        } else if (obj3 instanceof double[]) {
                            double[] dArr = (double[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.DoubleArray");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(dArr, (double[]) invoke);
                            continue;
                        } else if (obj3 instanceof Object[]) {
                            Object[] objArr = (Object[]) obj3;
                            if (invoke == null) {
                                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<*>");
                                AppMethodBeat.m2505o(118960);
                                throw c44941v;
                            }
                            equals = Arrays.equals(objArr, (Object[]) invoke);
                            continue;
                        } else {
                            equals = C25052j.m39373j(obj3, invoke);
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
                    AppMethodBeat.m2505o(118960);
                    return true;
                }
            }
            AppMethodBeat.m2505o(118960);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
    /* renamed from: a.i.b.a.a.b$b */
    static final class C0018b extends C25053k implements C31214a<Integer> {
        final /* synthetic */ Map AYU;

        C0018b(Map map) {
            this.AYU = map;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118961);
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
                i = (hashCode ^ (str.hashCode() * C31128d.MIC_SketchMark)) + i;
            }
            Integer valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(118961);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, dWq = {"<anonymous>", "", "T", "<anonymous parameter 0>", "kotlin.jvm.PlatformType", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"})
    /* renamed from: a.i.b.a.a.b$c */
    static final class C8005c implements InvocationHandler {
        final /* synthetic */ Class AYS;
        final /* synthetic */ Map AYU;
        final /* synthetic */ C44856f AYV;
        final /* synthetic */ C31815k AYW;
        final /* synthetic */ C44856f AYX;
        final /* synthetic */ C31815k AYY;
        final /* synthetic */ C0017a AYZ;

        C8005c(Class cls, C44856f c44856f, C31815k c31815k, C44856f c44856f2, C31815k c31815k2, C0017a c0017a, Map map) {
            this.AYS = cls;
            this.AYV = c44856f;
            this.AYW = c31815k;
            this.AYX = c44856f2;
            this.AYY = c31815k2;
            this.AYZ = c0017a;
            this.AYU = map;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object value;
            AppMethodBeat.m2504i(118962);
            C25052j.m39375o(method, C8741b.METHOD);
            String name = method.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1776922004:
                        if (name.equals("toString")) {
                            value = this.AYV.getValue();
                            AppMethodBeat.m2505o(118962);
                            return value;
                        }
                        break;
                    case 147696667:
                        if (name.equals("hashCode")) {
                            value = this.AYX.getValue();
                            AppMethodBeat.m2505o(118962);
                            return value;
                        }
                        break;
                    case 1444986633:
                        if (name.equals("annotationType")) {
                            value = this.AYS;
                            AppMethodBeat.m2505o(118962);
                            return value;
                        }
                        break;
                }
            }
            if (C25052j.m39373j(name, "equals") && objArr != null && objArr.length == 1) {
                Boolean valueOf = Boolean.valueOf(this.AYZ.mo51dy(C36913i.m61682O(objArr)));
                AppMethodBeat.m2505o(118962);
                return valueOf;
            } else if (this.AYU.containsKey(name)) {
                value = this.AYU.get(name);
                AppMethodBeat.m2505o(118962);
                return value;
            } else {
                StringBuilder append = new StringBuilder("Method is not supported: ").append(method).append(" (args: ");
                if (objArr == null) {
                    objArr = new Object[0];
                }
                Throwable c25261x = new C25261x(append.append(C36913i.m61684Q(objArr)).append(')').toString());
                AppMethodBeat.m2505o(118962);
                throw c25261x;
            }
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "", "invoke"})
    /* renamed from: a.i.b.a.a.b$d */
    static final class C8006d extends C25053k implements C31214a<String> {
        final /* synthetic */ Class AYS;
        final /* synthetic */ Map AYU;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "T", "", "entry", "", "invoke"})
        /* renamed from: a.i.b.a.a.b$d$a */
        static final class C8007a extends C25053k implements C17126b<Entry<? extends String, ? extends Object>, String> {
            public static final C8007a AZa = new C8007a();

            static {
                AppMethodBeat.m2504i(118964);
                AppMethodBeat.m2505o(118964);
            }

            C8007a() {
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                String arrays;
                AppMethodBeat.m2504i(118963);
                Entry entry = (Entry) obj;
                C25052j.m39376p(entry, "entry");
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
                AppMethodBeat.m2505o(118963);
                return str;
            }
        }

        C8006d(Class cls, Map map) {
            this.AYS = cls;
            this.AYU = map;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118965);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('@');
            stringBuilder.append(this.AYS.getCanonicalName());
            C25035t.m39320a(this.AYU.entrySet(), stringBuilder, ", ", "(", ")", 0, null, C8007a.AZa, 48);
            String stringBuilder2 = stringBuilder.toString();
            C25052j.m39375o(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
            AppMethodBeat.m2505o(118965);
            return stringBuilder2;
        }
    }

    static {
        AppMethodBeat.m2504i(118966);
        AppMethodBeat.m2505o(118966);
    }

    /* renamed from: a */
    public static /* synthetic */ Object m61714a(Class cls, Map map) {
        AppMethodBeat.m2504i(118968);
        Iterable<String> keySet = map.keySet();
        Collection arrayList = new ArrayList(C25034m.m39318d(keySet));
        for (String declaredMethod : keySet) {
            arrayList.add(cls.getDeclaredMethod(declaredMethod, new Class[0]));
        }
        Object a = C36941b.m61715a(cls, map, (List) arrayList);
        AppMethodBeat.m2505o(118968);
        return a;
    }

    /* renamed from: a */
    public static final <T> T m61715a(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        AppMethodBeat.m2504i(118967);
        C25052j.m39376p(cls, "annotationClass");
        C25052j.m39376p(map, "values");
        C25052j.m39376p(list, "methods");
        C0017a c0017a = new C0017a(cls, list, map);
        C44856f g = C17344i.m26854g(new C0018b(map));
        C31815k c31815k = eQB[0];
        C44856f g2 = C17344i.m26854g(new C8006d(cls, map));
        C31815k c31815k2 = eQB[1];
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C8005c(cls, g2, c31815k2, g, c31815k, c0017a, map));
        if (newProxyInstance == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type T");
            AppMethodBeat.m2505o(118967);
            throw c44941v;
        }
        AppMethodBeat.m2505o(118967);
        return newProxyInstance;
    }

    /* renamed from: d */
    public static final /* synthetic */ Object m61717d(Object obj, Class cls) {
        AppMethodBeat.m2504i(118969);
        if (!(obj instanceof Class)) {
            if (obj instanceof C36663b) {
                obj = C25047a.m39368a((C36663b) obj);
            } else if (obj instanceof Object[]) {
                if (!(((Object[]) obj) instanceof Class[])) {
                    C44941v c44941v;
                    if (!(((Object[]) obj) instanceof C36663b[])) {
                        Object[] obj2 = (Object[]) obj2;
                    } else if (obj2 == null) {
                        c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                        AppMethodBeat.m2505o(118969);
                        throw c44941v;
                    } else {
                        C36663b[] c36663bArr = (C36663b[]) obj2;
                        Collection arrayList = new ArrayList(c36663bArr.length);
                        for (C36663b a : c36663bArr) {
                            arrayList.add(C25047a.m39368a(a));
                        }
                        obj2 = ((List) arrayList).toArray(new Class[0]);
                        if (obj2 == null) {
                            c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                            AppMethodBeat.m2505o(118969);
                            throw c44941v;
                        }
                    }
                }
            }
            if (cls.isInstance(obj2)) {
                AppMethodBeat.m2505o(118969);
                return obj2;
            }
        }
        AppMethodBeat.m2505o(118969);
        return null;
    }
}
