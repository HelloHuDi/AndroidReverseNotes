package p000a.p010i.p011b.p012a.p049e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p001a.C36913i;
import p000a.p001a.C7987l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25051i;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C31598x;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C36663b;
import p000a.p010i.C44935d;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44886j;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p049e.C37079t.C0179a;
import p000a.p010i.p011b.p012a.p049e.C8268f.C8269a;
import p000a.p050j.C17348n;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0013\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00002\u0006\u0010*\u001a\u00020\u0018H\u0016J\b\u0010<\u001a\u00020'H\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\b\u0012\u0004\u0012\u000202018VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\t8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\f¨\u0006B"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "constructors", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "getConstructors", "()Ljava/util/List;", "element", "getElement", "()Ljava/lang/Class;", "fields", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "getFields", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "innerClassNames", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getInnerClassNames", "isAnnotationType", "", "()Z", "isEnum", "isInterface", "lightClassOriginKind", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/LightClassOriginKind;", "getLightClassOriginKind", "()Lorg/jetbrains/kotlin/load/java/structure/LightClassOriginKind;", "methods", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "getMethods", "modifiers", "", "getModifiers", "()I", "name", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "outerClass", "getOuterClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "supertypes", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "getSupertypes", "()Ljava/util/Collection;", "typeParameters", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "equals", "other", "", "findInnerClass", "hashCode", "isEnumValuesOrValueOf", "method", "Ljava/lang/reflect/Method;", "toString", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.j */
public final class C25250j extends C31792n implements C44635g, C8268f, C37079t {
    public final Class<?> AZs;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "constructor", "Ljava/lang/reflect/Constructor;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: a.i.b.a.e.j$a */
    static final class C8272a extends C25053k implements C17126b<Constructor<?>, Boolean> {
        public static final C8272a BNV = new C8272a();

        static {
            AppMethodBeat.m2504i(123041);
            AppMethodBeat.m2505o(123041);
        }

        C8272a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(123040);
            Constructor constructor = (Constructor) obj;
            C25052j.m39375o(constructor, "constructor");
            if (constructor.isSynthetic()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(123040);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "field", "Ljava/lang/reflect/Field;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: a.i.b.a.e.j$c */
    static final class C24628c extends C25053k implements C17126b<Field, Boolean> {
        public static final C24628c BNX = new C24628c();

        static {
            AppMethodBeat.m2504i(123046);
            AppMethodBeat.m2505o(123046);
        }

        C24628c() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(123045);
            Field field = (Field) obj;
            C25052j.m39375o(field, "field");
            if (field.isSynthetic()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(123045);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "p1", "Ljava/lang/reflect/Method;", "Lkotlin/ParameterName;", "name", "member", "invoke"})
    /* renamed from: a.i.b.a.e.j$h */
    static final class C24629h extends C25051i implements C17126b<Method, C46868s> {
        public static final C24629h BOc = new C24629h();

        static {
            AppMethodBeat.m2504i(123057);
            AppMethodBeat.m2505o(123057);
        }

        C24629h() {
            super(1);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(123056);
            C36663b aN = C44855v.m82055aN(C46868s.class);
            AppMethodBeat.m2505o(123056);
            return aN;
        }

        public final String due() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        public final String getName() {
            return "<init>";
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(123055);
            Method method = (Method) obj;
            C25052j.m39376p(method, "p1");
            C46868s c46868s = new C46868s(method);
            AppMethodBeat.m2505o(123055);
            return c46868s;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0019\u0010\u0002\u001a\u0015\u0012\u0002\b\u00030\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "p1", "Ljava/lang/reflect/Constructor;", "Lkotlin/ParameterName;", "name", "member", "invoke"})
    /* renamed from: a.i.b.a.e.j$b */
    static final class C25251b extends C25051i implements C17126b<Constructor<?>, C31791m> {
        public static final C25251b BNW = new C25251b();

        static {
            AppMethodBeat.m2504i(123044);
            AppMethodBeat.m2505o(123044);
        }

        C25251b() {
            super(1);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(123043);
            C36663b aN = C44855v.m82055aN(C31791m.class);
            AppMethodBeat.m2505o(123043);
            return aN;
        }

        public final String due() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        public final String getName() {
            return "<init>";
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(123042);
            Constructor constructor = (Constructor) obj;
            C25052j.m39376p(constructor, "p1");
            C31791m c31791m = new C31791m(constructor);
            AppMethodBeat.m2505o(123042);
            return c31791m;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: a.i.b.a.e.j$e */
    static final class C25252e extends C25053k implements C17126b<Class<?>, Boolean> {
        public static final C25252e BNZ = new C25252e();

        static {
            AppMethodBeat.m2504i(123051);
            AppMethodBeat.m2505o(123051);
        }

        C25252e() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            AppMethodBeat.m2504i(123050);
            Class cls = (Class) obj;
            C25052j.m39375o(cls, "it");
            String simpleName = cls.getSimpleName();
            C25052j.m39375o(simpleName, "it.simpleName");
            if (simpleName.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(123050);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "it", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: a.i.b.a.e.j$f */
    static final class C25253f extends C25053k implements C17126b<Class<?>, C37022f> {
        public static final C25253f BOa = new C25253f();

        static {
            AppMethodBeat.m2504i(123053);
            AppMethodBeat.m2505o(123053);
        }

        C25253f() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(123052);
            Class cls = (Class) obj;
            C25052j.m39375o(cls, "it");
            String simpleName = cls.getSimpleName();
            if (!C37022f.avY(simpleName)) {
                simpleName = null;
            }
            if (simpleName != null) {
                C37022f avX = C37022f.avX(simpleName);
                AppMethodBeat.m2505o(123052);
                return avX;
            }
            AppMethodBeat.m2505o(123052);
            return null;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "method", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: a.i.b.a.e.j$g */
    static final class C25254g extends C25053k implements C17126b<Method, Boolean> {
        final /* synthetic */ C25250j BOb;

        C25254g(C25250j c25250j) {
            this.BOb = c25250j;
            super(1);
        }

        /* JADX WARNING: Missing block: B:9:0x002f, code skipped:
            if (r2 == false) goto L_0x0031;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z = false;
            AppMethodBeat.m2504i(123054);
            Method method = (Method) obj;
            C25052j.m39375o(method, C8741b.METHOD);
            if (!method.isSynthetic()) {
                if (this.BOb.AZs.isEnum()) {
                    boolean z2;
                    String name = method.getName();
                    if (name != null) {
                        switch (name.hashCode()) {
                            case -823812830:
                                if (name.equals("values")) {
                                    Class[] parameterTypes = method.getParameterTypes();
                                    C25052j.m39375o(parameterTypes, "method.parameterTypes");
                                    if (parameterTypes.length != 0) {
                                        z2 = false;
                                        break;
                                    }
                                    z2 = true;
                                    break;
                                }
                            case 231605032:
                                if (name.equals("valueOf")) {
                                    z2 = Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
                                    break;
                                }
                        }
                    }
                    z2 = false;
                }
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.m2505o(123054);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaField;", "p1", "Ljava/lang/reflect/Field;", "Lkotlin/ParameterName;", "name", "member", "invoke"})
    /* renamed from: a.i.b.a.e.j$d */
    static final class C25255d extends C25051i implements C17126b<Field, C0177p> {
        public static final C25255d BNY = new C25255d();

        static {
            AppMethodBeat.m2504i(123049);
            AppMethodBeat.m2505o(123049);
        }

        C25255d() {
            super(1);
        }

        public final C44935d dWF() {
            AppMethodBeat.m2504i(123048);
            C36663b aN = C44855v.m82055aN(C0177p.class);
            AppMethodBeat.m2505o(123048);
            return aN;
        }

        public final String due() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        public final String getName() {
            return "<init>";
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(123047);
            Field field = (Field) obj;
            C25052j.m39376p(field, "p1");
            C0177p c0177p = new C0177p(field);
            AppMethodBeat.m2505o(123047);
            return c0177p;
        }
    }

    public final C25082az dYf() {
        AppMethodBeat.m2504i(123080);
        C25082az d = C0179a.m299d(this);
        AppMethodBeat.m2505o(123080);
        return d;
    }

    public final boolean ebX() {
        AppMethodBeat.m2504i(123077);
        boolean a = C0179a.m296a(this);
        AppMethodBeat.m2505o(123077);
        return a;
    }

    public final boolean ebY() {
        AppMethodBeat.m2504i(123079);
        boolean c = C0179a.m298c(this);
        AppMethodBeat.m2505o(123079);
        return c;
    }

    public final boolean isStatic() {
        AppMethodBeat.m2504i(123078);
        boolean b = C0179a.m297b(this);
        AppMethodBeat.m2505o(123078);
        return b;
    }

    /* renamed from: m */
    public final /* synthetic */ C41408a mo18057m(C8174b c8174b) {
        AppMethodBeat.m2504i(123076);
        C25052j.m39376p(c8174b, "fqName");
        C41408a a = C8269a.m14592a(this, c8174b);
        AppMethodBeat.m2505o(123076);
        return a;
    }

    public C25250j(Class<?> cls) {
        C25052j.m39376p(cls, "klass");
        AppMethodBeat.m2504i(123074);
        this.AZs = cls;
        AppMethodBeat.m2505o(123074);
    }

    public final int getModifiers() {
        AppMethodBeat.m2504i(123058);
        int modifiers = this.AZs.getModifiers();
        AppMethodBeat.m2505o(123058);
        return modifiers;
    }

    public final C8174b dZF() {
        AppMethodBeat.m2504i(123060);
        C8174b ehE = C37076b.m62036bb(this.AZs).ehE();
        C25052j.m39375o(ehE, "klass.classId.asSingleFqName()");
        AppMethodBeat.m2505o(123060);
        return ehE;
    }

    public final Collection<C44886j> eap() {
        AppMethodBeat.m2504i(123062);
        if (C25052j.m39373j(this.AZs, Object.class)) {
            Collection collection = C17115v.AUP;
            AppMethodBeat.m2505o(123062);
            return collection;
        }
        C31598x c31598x = new C31598x(2);
        Object genericSuperclass = this.AZs.getGenericSuperclass();
        if (genericSuperclass == null) {
            genericSuperclass = Object.class;
        }
        c31598x.add(genericSuperclass);
        Type[] genericInterfaces = this.AZs.getGenericInterfaces();
        C25052j.m39375o(genericInterfaces, "klass.genericInterfaces");
        c31598x.mo51593do(genericInterfaces);
        Iterable<Type> listOf = C7987l.listOf((Type[]) c31598x.toArray(new Type[c31598x.ckx.size()]));
        Collection arrayList = new ArrayList(C25034m.m39318d(listOf));
        for (Type c36660l : listOf) {
            arrayList.add(new C36660l(c36660l));
        }
        Collection<C44886j> collection2 = (List) arrayList;
        AppMethodBeat.m2505o(123062);
        return collection2;
    }

    public final C37022f dZg() {
        AppMethodBeat.m2504i(123066);
        C37022f avX = C37022f.avX(this.AZs.getSimpleName());
        C25052j.m39375o(avX, "Name.identifier(klass.simpleName)");
        AppMethodBeat.m2505o(123066);
        return avX;
    }

    public final List<C25257x> dYS() {
        AppMethodBeat.m2504i(123067);
        TypeVariable[] typeParameters = this.AZs.getTypeParameters();
        C25052j.m39375o(typeParameters, "klass.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable c25257x : typeParameters) {
            arrayList.add(new C25257x(c25257x));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(123067);
        return list;
    }

    public final boolean isInterface() {
        AppMethodBeat.m2504i(123068);
        boolean isInterface = this.AZs.isInterface();
        AppMethodBeat.m2505o(123068);
        return isInterface;
    }

    public final boolean ebH() {
        AppMethodBeat.m2504i(139066);
        boolean isAnnotation = this.AZs.isAnnotation();
        AppMethodBeat.m2505o(139066);
        return isAnnotation;
    }

    public final boolean isEnum() {
        AppMethodBeat.m2504i(123070);
        boolean isEnum = this.AZs.isEnum();
        AppMethodBeat.m2505o(123070);
        return isEnum;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(123071);
        if ((obj instanceof C25250j) && C25052j.m39373j(this.AZs, ((C25250j) obj).AZs)) {
            AppMethodBeat.m2505o(123071);
            return true;
        }
        AppMethodBeat.m2505o(123071);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(123072);
        int hashCode = this.AZs.hashCode();
        AppMethodBeat.m2505o(123072);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(123073);
        String str = getClass().getName() + ": " + this.AZs;
        AppMethodBeat.m2505o(123073);
        return str;
    }

    public final /* bridge */ /* synthetic */ AnnotatedElement ekH() {
        return this.AZs;
    }

    public final /* synthetic */ Collection ebF() {
        AppMethodBeat.m2504i(123059);
        Class[] declaredClasses = this.AZs.getDeclaredClasses();
        C25052j.m39375o(declaredClasses, "klass.declaredClasses");
        Collection c = C17348n.m26862c(C17348n.m26866e(C17348n.m26860b(C36913i.m61687T(declaredClasses), C25252e.BNZ), C25253f.BOa));
        AppMethodBeat.m2505o(123059);
        return c;
    }

    public final /* synthetic */ C44635g ebG() {
        C25250j c25250j;
        AppMethodBeat.m2504i(123061);
        Class declaringClass = this.AZs.getDeclaringClass();
        if (declaringClass != null) {
            c25250j = new C25250j(declaringClass);
        } else {
            c25250j = null;
        }
        C44635g c44635g = c25250j;
        AppMethodBeat.m2505o(123061);
        return c44635g;
    }

    public final /* synthetic */ Collection ebI() {
        AppMethodBeat.m2504i(123063);
        Method[] declaredMethods = this.AZs.getDeclaredMethods();
        C25052j.m39375o(declaredMethods, "klass.declaredMethods");
        Collection c = C17348n.m26862c(C17348n.m26863d(C17348n.m26855a(C36913i.m61687T(declaredMethods), (C17126b) new C25254g(this)), C24629h.BOc));
        AppMethodBeat.m2505o(123063);
        return c;
    }

    public final /* synthetic */ Collection ebJ() {
        AppMethodBeat.m2504i(123064);
        Field[] declaredFields = this.AZs.getDeclaredFields();
        C25052j.m39375o(declaredFields, "klass.declaredFields");
        Collection c = C17348n.m26862c(C17348n.m26863d(C17348n.m26855a(C36913i.m61687T(declaredFields), (C17126b) C24628c.BNX), C25255d.BNY));
        AppMethodBeat.m2505o(123064);
        return c;
    }

    public final /* synthetic */ Collection dYb() {
        AppMethodBeat.m2504i(123065);
        Constructor[] declaredConstructors = this.AZs.getDeclaredConstructors();
        C25052j.m39375o(declaredConstructors, "klass.declaredConstructors");
        Collection c = C17348n.m26862c(C17348n.m26863d(C17348n.m26855a(C36913i.m61687T(declaredConstructors), (C17126b) C8272a.BNV), C25251b.BNW));
        AppMethodBeat.m2505o(123065);
        return c;
    }

    public final /* synthetic */ Collection ebC() {
        AppMethodBeat.m2504i(123075);
        Collection a = C8269a.m14593a(this);
        AppMethodBeat.m2505o(123075);
        return a;
    }
}
