package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p000a.C0220l;
import p000a.C25046c;
import p000a.C44941v;
import p000a.C8312u;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C31586ag;
import p000a.p001a.C36913i;
import p000a.p001a.C7987l;
import p000a.p005f.C25047a;
import p000a.p005f.p006a.C0011r;
import p000a.p005f.p006a.C0012s;
import p000a.p005f.p006a.C0013t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C17127l;
import p000a.p005f.p006a.C17128u;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31215d;
import p000a.p005f.p006a.C31216k;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C31592o;
import p000a.p005f.p006a.C31593p;
import p000a.p005f.p006a.C31594w;
import p000a.p005f.p006a.C36930e;
import p000a.p005f.p006a.C36931g;
import p000a.p005f.p006a.C36932n;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p006a.C41373h;
import p000a.p005f.p006a.C44851f;
import p000a.p005f.p006a.C44852v;
import p000a.p005f.p006a.C7997c;
import p000a.p005f.p006a.C7998i;
import p000a.p005f.p006a.C7999j;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C36663b;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p050j.C16496l;
import p000a.p050j.C17348n;
import p000a.p050j.C44937h;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010#\u001a\u0006\u0012\u0002\b\u00030\u0002*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010$\u001a\u00020%*\u0006\u0012\u0002\b\u00030\u0002\"&\u0010\u0000\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\",\u0010\t\u001a \u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\",\u0010\n\u001a \u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0002\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u001f\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0019\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001f\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001c¨\u0006&"}, dWq = {"FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "PRIMITIVE_CLASSES", "", "Lkotlin/reflect/KClass;", "", "PRIMITIVE_TO_WRAPPER", "WRAPPER_TO_PRIMITIVE", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/name/ClassId;", "desc", "", "getDesc", "(Ljava/lang/Class;)Ljava/lang/String;", "functionClassArity", "getFunctionClassArity", "(Ljava/lang/Class;)Ljava/lang/Integer;", "parameterizedTypeArguments", "Ljava/lang/reflect/Type;", "getParameterizedTypeArguments", "(Ljava/lang/reflect/Type;)Ljava/util/List;", "primitiveByWrapper", "getPrimitiveByWrapper", "(Ljava/lang/Class;)Ljava/lang/Class;", "safeClassLoader", "Ljava/lang/ClassLoader;", "getSafeClassLoader", "(Ljava/lang/Class;)Ljava/lang/ClassLoader;", "wrapperByPrimitive", "getWrapperByPrimitive", "createArrayType", "isEnumClassOrSpecializedEnumEntryClass", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.b */
public final class C37076b {
    private static final List<C36663b<? extends Object>> BNM;
    private static final Map<Class<? extends Object>, Class<? extends Object>> BNN;
    private static final Map<Class<? extends Object>, Class<? extends Object>> BNO;
    private static final Map<Class<? extends C25046c<?>>, Integer> BNP;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Ljava/lang/reflect/ParameterizedType;", "it", "invoke"})
    /* renamed from: a.i.b.a.e.b$a */
    static final class C24627a extends C25053k implements C17126b<ParameterizedType, ParameterizedType> {
        public static final C24627a BNQ = new C24627a();

        static {
            AppMethodBeat.m2504i(123011);
            AppMethodBeat.m2505o(123011);
        }

        C24627a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(123010);
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            C25052j.m39376p(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (!(ownerType instanceof ParameterizedType)) {
                ownerType = null;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            AppMethodBeat.m2505o(123010);
            return parameterizedType2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "Lkotlin/sequences/Sequence;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "it", "Ljava/lang/reflect/ParameterizedType;", "invoke"})
    /* renamed from: a.i.b.a.e.b$b */
    static final class C37077b extends C25053k implements C17126b<ParameterizedType, C44937h<? extends Type>> {
        public static final C37077b BNR = new C37077b();

        static {
            AppMethodBeat.m2504i(123013);
            AppMethodBeat.m2505o(123013);
        }

        C37077b() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(123012);
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            C25052j.m39376p(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            C25052j.m39375o(actualTypeArguments, "it.actualTypeArguments");
            C44937h T = C36913i.m61687T(actualTypeArguments);
            AppMethodBeat.m2505o(123012);
            return T;
        }
    }

    /* renamed from: aX */
    public static final ClassLoader m62032aX(Class<?> cls) {
        AppMethodBeat.m2504i(123014);
        C25052j.m39376p(cls, "receiver$0");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
            C25052j.m39375o(classLoader, "ClassLoader.getSystemClassLoader()");
        }
        AppMethodBeat.m2505o(123014);
        return classLoader;
    }

    /* renamed from: aY */
    public static final boolean m62033aY(Class<?> cls) {
        AppMethodBeat.m2504i(123015);
        C25052j.m39376p(cls, "receiver$0");
        boolean isAssignableFrom = Enum.class.isAssignableFrom(cls);
        AppMethodBeat.m2505o(123015);
        return isAssignableFrom;
    }

    static {
        int i = 0;
        AppMethodBeat.m2504i(123022);
        List listOf = C7987l.listOf(C44855v.m82055aN(Boolean.TYPE), C44855v.m82055aN(Byte.TYPE), C44855v.m82055aN(Character.TYPE), C44855v.m82055aN(Double.TYPE), C44855v.m82055aN(Float.TYPE), C44855v.m82055aN(Integer.TYPE), C44855v.m82055aN(Long.TYPE), C44855v.m82055aN(Short.TYPE));
        BNM = listOf;
        Iterable<C36663b> iterable = listOf;
        Collection arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C36663b c36663b : iterable) {
            arrayList.add(C8312u.m14628I(C25047a.m39371c(c36663b), C25047a.m39370b(c36663b)));
        }
        BNN = C31586ag.m51052v((List) arrayList);
        iterable = BNM;
        arrayList = new ArrayList(C25034m.m39318d(iterable));
        for (C36663b c36663b2 : iterable) {
            arrayList.add(C8312u.m14628I(C25047a.m39370b(c36663b2), C25047a.m39371c(c36663b2)));
        }
        BNO = C31586ag.m51052v((List) arrayList);
        Iterable listOf2 = C7987l.listOf(C31214a.class, C17126b.class, C31591m.class, C36933q.class, C0011r.class, C0012s.class, C0013t.class, C17128u.class, C44852v.class, C31594w.class, C7997c.class, C31215d.class, C36930e.class, C44851f.class, C36931g.class, C41373h.class, C7998i.class, C7999j.class, C31216k.class, C17127l.class, C36932n.class, C31592o.class, C31593p.class);
        arrayList = new ArrayList(C25034m.m39318d(listOf2));
        for (Object next : listOf2) {
            int i2 = i + 1;
            if (i < 0) {
                C7987l.dWs();
            }
            arrayList.add(C8312u.m14628I((Class) next, Integer.valueOf(i)));
            i = i2;
        }
        BNP = C31586ag.m51052v((List) arrayList);
        AppMethodBeat.m2505o(123022);
    }

    /* renamed from: aZ */
    public static final Class<?> m62034aZ(Class<?> cls) {
        AppMethodBeat.m2504i(123016);
        C25052j.m39376p(cls, "receiver$0");
        Class cls2 = (Class) BNN.get(cls);
        AppMethodBeat.m2505o(123016);
        return cls2;
    }

    /* renamed from: ba */
    public static final Class<?> m62035ba(Class<?> cls) {
        AppMethodBeat.m2504i(123017);
        C25052j.m39376p(cls, "receiver$0");
        Class cls2 = (Class) BNO.get(cls);
        AppMethodBeat.m2505o(123017);
        return cls2;
    }

    /* renamed from: bb */
    public static final C8173a m62036bb(Class<?> cls) {
        AppMethodBeat.m2504i(123018);
        C25052j.m39376p(cls, "receiver$0");
        Throwable illegalArgumentException;
        if (cls.isPrimitive()) {
            illegalArgumentException = new IllegalArgumentException("Can't compute ClassId for primitive type: ".concat(String.valueOf(cls)));
            AppMethodBeat.m2505o(123018);
            throw illegalArgumentException;
        } else if (cls.isArray()) {
            illegalArgumentException = new IllegalArgumentException("Can't compute ClassId for array type: ".concat(String.valueOf(cls)));
            AppMethodBeat.m2505o(123018);
            throw illegalArgumentException;
        } else {
            C8173a bb;
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                C25052j.m39375o(simpleName, "simpleName");
                if (!(((CharSequence) simpleName).length() == 0)) {
                    Class declaringClass = cls.getDeclaringClass();
                    if (declaringClass != null) {
                        bb = C37076b.m62036bb(declaringClass);
                        if (bb != null) {
                            bb = bb.mo17969p(C37022f.avX(cls.getSimpleName()));
                            AppMethodBeat.m2505o(123018);
                            return bb;
                        }
                    }
                    bb = C8173a.m14427n(new C8174b(cls.getName()));
                    C25052j.m39375o(bb, "ClassId.topLevel(FqName(name))");
                    AppMethodBeat.m2505o(123018);
                    return bb;
                }
            }
            C8174b c8174b = new C8174b(cls.getName());
            bb = new C8173a(c8174b.ehG(), C8174b.m14430s(c8174b.ByQ.ehK()), true);
            AppMethodBeat.m2505o(123018);
            return bb;
        }
    }

    /* renamed from: bc */
    public static final String m62037bc(Class<?> cls) {
        AppMethodBeat.m2504i(123019);
        C25052j.m39376p(cls, "receiver$0");
        String str;
        if (C25052j.m39373j(cls, Void.TYPE)) {
            str = "V";
            AppMethodBeat.m2505o(123019);
            return str;
        }
        str = C37076b.m62038bd(cls).getName();
        C25052j.m39375o(str, "createArrayType().name");
        if (str == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.m2505o(123019);
            throw c44941v;
        }
        str = str.substring(1);
        C25052j.m39375o(str, "(this as java.lang.String).substring(startIndex)");
        str = C6163u.m9834a(str, '.', IOUtils.DIR_SEPARATOR_UNIX);
        AppMethodBeat.m2505o(123019);
        return str;
    }

    /* renamed from: bd */
    public static final Class<?> m62038bd(Class<?> cls) {
        AppMethodBeat.m2504i(123020);
        C25052j.m39376p(cls, "receiver$0");
        Class cls2 = Array.newInstance(cls, 0).getClass();
        AppMethodBeat.m2505o(123020);
        return cls2;
    }

    /* renamed from: a */
    public static final List<Type> m62031a(Type type) {
        AppMethodBeat.m2504i(123021);
        C25052j.m39376p(type, "receiver$0");
        List<Type> Q;
        if (!(type instanceof ParameterizedType)) {
            List list = C17115v.AUP;
            AppMethodBeat.m2505o(123021);
            return list;
        } else if (((ParameterizedType) type).getOwnerType() == null) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            C25052j.m39375o(actualTypeArguments, "actualTypeArguments");
            Q = C36913i.m61684Q(actualTypeArguments);
            AppMethodBeat.m2505o(123021);
            return Q;
        } else {
            Q = C17348n.m26862c(C17348n.m26861c(C16496l.m25325a(type, C24627a.BNQ), C37077b.BNR));
            AppMethodBeat.m2505o(123021);
            return Q;
        }
    }
}
