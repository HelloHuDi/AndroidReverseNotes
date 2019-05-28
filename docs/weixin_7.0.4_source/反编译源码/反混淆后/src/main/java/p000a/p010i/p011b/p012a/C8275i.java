package p000a.p010i.p011b.p012a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42477i;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C41377d;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p010i.p011b.p012a.C25262z.C25266a;
import p000a.p010i.p011b.p012a.p014b.C36946i;
import p000a.p010i.p011b.p012a.p015c.p018b.C0037k;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.p020c.C25088l;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C25177j.C8205a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p049e.C37076b;
import p000a.p051k.C25274k;
import p000a.p051k.C31820v;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0005\b \u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u001c\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J(\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J \u0010#\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u0012\u0010'\u001a\u0004\u0018\u00010\u00172\u0006\u0010(\u001a\u00020)H&J\"\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0004J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u001e\u001a\u00020&H&J\u001a\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u00103\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u00104\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020)H\u0002J@\u00107\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J0\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\t2\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t022\u0006\u0010;\u001a\u00020\u0013H\u0002JE\u0010<\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u001e\u001a\u00020\u00112\u0010\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0=2\n\u00109\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010;\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010>R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t8TX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006B"}, dWq = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "()V", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "addParametersAndMasks", "", "result", "", "desc", "", "isConstructor", "", "createProperty", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "findConstructorBySignature", "Ljava/lang/reflect/Constructor;", "isPublic", "findDefaultConstructor", "findDefaultMethod", "Ljava/lang/reflect/Method;", "name", "isMember", "findFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "signature", "findMethodBySignature", "findPropertyDescriptor", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "scope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "getProperties", "loadParameterTypes", "", "loadReturnType", "parseType", "begin", "end", "lookupMethod", "parameterTypes", "returnType", "tryGetConstructor", "declared", "tryGetMethod", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "Companion", "Data", "MemberBelonginess", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.i */
public abstract class C8275i implements C41377d {
    private static final Class<?> AXe = Class.forName("a.f.b.g");
    static final C25274k AXf = new C25274k("<v#(\\d+)>");
    public static final C8280a AXg = new C8280a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, dWq = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.i$c */
    protected enum C8274c {
        DECLARED,
        INHERITED;

        static {
            AppMethodBeat.m2505o(118743);
        }

        /* renamed from: a */
        public final boolean mo18059a(C25085b c25085b) {
            AppMethodBeat.m2504i(118744);
            C25052j.m39376p(c25085b, "member");
            C8063a dYZ = c25085b.dYZ();
            C25052j.m39375o(dYZ, "member.kind");
            if (dYZ.dZa() == (((C8274c) this) == DECLARED)) {
                AppMethodBeat.m2505o(118744);
                return true;
            }
            AppMethodBeat.m2505o(118744);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "invoke"})
    /* renamed from: a.i.b.a.i$e */
    static final class C8276e extends C25053k implements C17126b<C31220ah, String> {
        public static final C8276e AXo = new C8276e();

        static {
            AppMethodBeat.m2504i(118750);
            AppMethodBeat.m2505o(118750);
        }

        C8276e() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(118749);
            C31220ah c31220ah = (C31220ah) obj;
            C25052j.m39376p(c31220ah, "descriptor");
            StringBuilder append = new StringBuilder().append(C31724c.BBN.mo13667k(c31220ah)).append(" | ");
            C36944ad c36944ad = C36944ad.AYC;
            String stringBuilder = append.append(C36944ad.m61723c(c31220ah)).toString();
            AppMethodBeat.m2505o(118749);
            return stringBuilder;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "first", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "kotlin.jvm.PlatformType", "second", "compare"})
    /* renamed from: a.i.b.a.i$f */
    static final class C8277f<T> implements Comparator<C25082az> {
        public static final C8277f AXp = new C8277f();

        static {
            AppMethodBeat.m2504i(118752);
            AppMethodBeat.m2505o(118752);
        }

        C8277f() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118751);
            Integer b = C8051ay.m14225b((C25082az) obj, (C25082az) obj2);
            if (b != null) {
                int intValue = b.intValue();
                AppMethodBeat.m2505o(118751);
                return intValue;
            }
            AppMethodBeat.m2505o(118751);
            return 0;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
    /* renamed from: a.i.b.a.i$d */
    static final class C8278d extends C25053k implements C17126b<C8083t, String> {
        public static final C8278d AXn = new C8278d();

        static {
            AppMethodBeat.m2504i(118748);
            AppMethodBeat.m2505o(118748);
        }

        C8278d() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(118747);
            C8083t c8083t = (C8083t) obj;
            C25052j.m39376p(c8083t, "descriptor");
            StringBuilder append = new StringBuilder().append(C31724c.BBN.mo13667k(c8083t)).append(" | ");
            C36944ad c36944ad = C36944ad.AYC;
            String stringBuilder = append.append(C36944ad.m61722c(c8083t)).toString();
            AppMethodBeat.m2505o(118747);
            return stringBuilder;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001J!\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, dWq = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$getMembers$visitor$1", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "visitConstructorDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.i$g */
    public static final class C8279g extends C25088l<C46869e<?>, C37091y> {
        final /* synthetic */ C8275i AXi;

        C8279g(C8275i c8275i) {
            this.AXi = c8275i;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflect_api", "()Lkotlin/text/Regex;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.i$a */
    public static final class C8280a {
        private C8280a() {
        }

        public /* synthetic */ C8280a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, dWq = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "getModuleData", "()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflect-api"})
    /* renamed from: a.i.b.a.i$b */
    public abstract class C8281b {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C8281b.class), "moduleData", "getModuleData()Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;"))};
        private final C25266a AXh = C25262z.m39833a(null, new C8282a(this));

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/components/RuntimeModuleData;", "invoke"})
        /* renamed from: a.i.b.a.i$b$a */
        static final class C8282a extends C25053k implements C31214a<C36946i> {
            final /* synthetic */ C8281b AXj;

            C8282a(C8281b c8281b) {
                this.AXj = c8281b;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(118742);
                C36946i aQ = C8293y.m14621aQ(C8275i.this.dWH());
                AppMethodBeat.m2505o(118742);
                return aQ;
            }
        }

        public final C36946i dXe() {
            return (C36946i) this.AXh.invoke();
        }
    }

    /* renamed from: SJ */
    public abstract C31220ah mo18061SJ(int i);

    /* renamed from: a */
    public abstract Collection<C31220ah> mo18062a(C37022f c37022f);

    /* renamed from: b */
    public abstract Collection<C8083t> mo18064b(C37022f c37022f);

    public abstract Collection<C0037k> dWR();

    /* Access modifiers changed, original: protected */
    public Class<?> dXc() {
        Class<?> ba = C37076b.m62035ba(dWH());
        return ba == null ? dWH() : ba;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final Collection<C46869e<?>> mo18063a(C31746h c31746h, C8274c c8274c) {
        C25052j.m39376p(c31746h, "scope");
        C25052j.m39376p(c8274c, "belonginess");
        C8279g c8279g = new C8279g(this);
        Collection arrayList = new ArrayList();
        for (C31642l c31642l : C8205a.m14503a(c31746h, null, null, 3)) {
            Object obj;
            if ((c31642l instanceof C25085b) && (C25052j.m39373j(((C25085b) c31642l).dYf(), C8051ay.Bfd) ^ 1) != 0 && c8274c.mo18059a((C25085b) c31642l)) {
                obj = (C46869e) c31642l.mo245a(c8279g, C37091y.AUy);
            } else {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return C25035t.m39352m((List) arrayList);
    }

    /* renamed from: a */
    private final Method m14601a(Class<?> cls, String str, List<? extends Class<?>> list, Class<?> cls2, boolean z) {
        Collection collection = list;
        if (collection == null) {
            throw new C44941v("null cannot be cast to non-null type java.util.Collection<T>");
        }
        Object[] toArray = collection.toArray(new Class[0]);
        if (toArray == null) {
            throw new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Method a;
        Class[] clsArr = (Class[]) toArray;
        if (z) {
            a = C8275i.m14602a((Class) cls, str, clsArr, (Class) cls2, false);
            if (a != null) {
                return a;
            }
            if (cls.isInterface()) {
                a = m14601a(Object.class, str, (List) list, (Class) cls2, z);
                if (a != null) {
                    return a;
                }
            }
        }
        Class cls3;
        while (cls3 != null) {
            a = C8275i.m14602a(cls3, str, clsArr, (Class) cls2, true);
            if (a != null) {
                return a;
            }
            cls3 = cls3.getSuperclass();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x001f A:{SYNTHETIC, EDGE_INSN: B:29:0x001f->B:6:0x001f ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A:{LOOP_END, Catch:{ NoSuchMethodException -> 0x007a }, LOOP:0: B:11:0x003c->B:23:0x006c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static Method m14602a(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Method declaredMethod;
        if (z) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException e) {
                return null;
            }
        }
        declaredMethod = cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        C25052j.m39375o(declaredMethod, "result");
        if (!C25052j.m39373j(declaredMethod.getReturnType(), cls2)) {
            Object declaredMethods = z ? cls.getDeclaredMethods() : cls.getMethods();
            C25052j.m39375o(declaredMethods, "allMethods");
            int length = declaredMethods.length;
            int i = 0;
            while (i < length) {
                Object obj;
                declaredMethod = declaredMethods[i];
                C25052j.m39375o(declaredMethod, C8741b.METHOD);
                if (C25052j.m39373j(declaredMethod.getName(), str) && C25052j.m39373j(declaredMethod.getReturnType(), cls2)) {
                    Class[] parameterTypes = declaredMethod.getParameterTypes();
                    if (parameterTypes == null) {
                        C25052j.dWJ();
                    }
                    if (Arrays.equals(parameterTypes, clsArr)) {
                        obj = 1;
                        if (obj == null) {
                            break;
                        }
                        i++;
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            declaredMethod = null;
        }
        return declaredMethod;
    }

    /* renamed from: a */
    static Constructor<?> m14600a(Class<?> cls, List<? extends Class<?>> list, boolean z) {
        Collection collection;
        Object[] toArray;
        Class[] clsArr;
        if (z) {
            try {
                collection = list;
                if (collection == null) {
                    throw new C44941v("null cannot be cast to non-null type java.util.Collection<T>");
                }
                toArray = collection.toArray(new Class[0]);
                if (toArray == null) {
                    throw new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                }
                clsArr = (Class[]) toArray;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException e) {
                return null;
            }
        }
        collection = list;
        if (collection == null) {
            throw new C44941v("null cannot be cast to non-null type java.util.Collection<T>");
        }
        toArray = collection.toArray(new Class[0]);
        if (toArray == null) {
            throw new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
        }
        clsArr = (Class[]) toArray;
        return cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
    }

    /* renamed from: H */
    public final Method mo18060H(String str, String str2, boolean z) {
        C25052j.m39376p(str, "name");
        C25052j.m39376p(str2, "desc");
        if (C25052j.m39373j(str, "<init>")) {
            return null;
        }
        return m14601a(dXc(), str, avx(str2), avy(str2), z);
    }

    /* renamed from: d */
    public final Method mo18067d(String str, String str2, boolean z, boolean z2) {
        C25052j.m39376p(str, "name");
        C25052j.m39376p(str2, "desc");
        if (C25052j.m39373j(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(dWH());
        }
        mo18065c(arrayList, str2, false);
        return m14601a(dXc(), str + "$default", (List) arrayList, avy(str2), z2);
    }

    /* renamed from: cu */
    public final Constructor<?> mo18066cu(String str, boolean z) {
        C25052j.m39376p(str, "desc");
        return C8275i.m14600a(dWH(), avx(str), !z);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo18065c(List<Class<?>> list, String str, boolean z) {
        List avx = avx(str);
        list.addAll(avx);
        int size = ((avx.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class cls = Integer.TYPE;
            C25052j.m39375o(cls, "Integer.TYPE");
            list.add(cls);
        }
        Object obj = z ? AXe : Object.class;
        C25052j.m39375o(obj, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(obj);
    }

    private final List<Class<?>> avx(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (true) {
            int i2 = i;
            if (str.charAt(i2) == ')') {
                return arrayList;
            }
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            if (C31820v.m51537c((CharSequence) "VZCBSIFJD", charAt)) {
                i = i3 + 1;
            } else if (charAt == 'L') {
                i = C31820v.m51514a((CharSequence) str, ';', i2, 4) + 1;
            } else {
                throw new C25261x("Unknown type prefix in the method signature: ".concat(String.valueOf(str)));
            }
            arrayList.add(m14603aA(str, i2, i));
        }
    }

    /* renamed from: aA */
    private final Class<?> m14603aA(String str, int i, int i2) {
        switch (str.charAt(i)) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case C42477i.CTRL_INDEX /*68*/:
                return Double.TYPE;
            case 'F':
                return Float.TYPE;
            case C27077c.CTRL_INDEX /*73*/:
                return Integer.TYPE;
            case 'J':
                return Long.TYPE;
            case 'L':
                ClassLoader aX = C37076b.m62032aX(dWH());
                int i3 = i + 1;
                int i4 = i2 - 1;
                if (str == null) {
                    throw new C44941v("null cannot be cast to non-null type java.lang.String");
                }
                String substring = str.substring(i3, i4);
                C25052j.m39375o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Class loadClass = aX.loadClass(C6163u.m9834a(substring, IOUtils.DIR_SEPARATOR_UNIX, '.'));
                C25052j.m39375o(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return loadClass;
            case 'S':
                return Short.TYPE;
            case 'V':
                Class<?> cls = Void.TYPE;
                C25052j.m39375o(cls, "Void.TYPE");
                return cls;
            case 'Z':
                return Boolean.TYPE;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                return C37076b.m62038bd(m14603aA(str, i + 1, i2));
            default:
                throw new C25261x("Unknown type prefix in the method signature: ".concat(String.valueOf(str)));
        }
    }

    private final Class<?> avy(String str) {
        return m14603aA(str, C31820v.m51514a((CharSequence) str, ')', 0, 6) + 1, str.length());
    }
}
