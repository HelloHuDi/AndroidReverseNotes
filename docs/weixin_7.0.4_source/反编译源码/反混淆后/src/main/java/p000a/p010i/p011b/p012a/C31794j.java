package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C31824m;
import p000a.C44941v;
import p000a.p001a.C25034m;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C17132h;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C41376c;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31813j;
import p000a.p010i.C31815k;
import p000a.p010i.C8295e;
import p000a.p010i.p011b.p012a.C25262z.C25266a;
import p000a.p010i.p011b.p012a.C44930c.C17143e;
import p000a.p010i.p011b.p012a.C44930c.C41383a;
import p000a.p010i.p011b.p012a.C44930c.C41385b;
import p000a.p010i.p011b.p012a.C44930c.C41386c;
import p000a.p010i.p011b.p012a.C44930c.C44931d;
import p000a.p010i.p011b.p012a.C8275i.C8278d;
import p000a.p010i.p011b.p012a.p013a.C17141h;
import p000a.p010i.p011b.p012a.p013a.C25058e;
import p000a.p010i.p011b.p012a.p013a.C25058e.C8009f;
import p000a.p010i.p011b.p012a.p013a.C25058e.C8009f.C8011f;
import p000a.p010i.p011b.p012a.p013a.C25058e.C8009f.C8012b;
import p000a.p010i.p011b.p012a.p013a.C25058e.C8009f.C8013c;
import p000a.p010i.p011b.p012a.p013a.C25058e.C8009f.C8015e;
import p000a.p010i.p011b.p012a.p013a.C25069f;
import p000a.p010i.p011b.p012a.p013a.C36943d;
import p000a.p010i.p011b.p012a.p013a.C44859a;
import p000a.p010i.p011b.p012a.p013a.C44859a.C25057b;
import p000a.p010i.p011b.p012a.p013a.C44859a.C36940a;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C46865e;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0011J\u001e\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000/2\n\u00101\u001a\u0006\u0012\u0002\b\u000300H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00101\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002032\u0006\u00101\u001a\u000204H\u0002J\u0010\u00106\u001a\u0002032\u0006\u00101\u001a\u000204H\u0002J\u0013\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u00109\u001a\u00020\u0013H\u0016J\b\u0010:\u001a\u00020\tH\u0016R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00178VX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR!\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00178VX\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010\r\u001a\u00020\u000e8VX\u0002¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010&R\u0014\u0010'\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020%8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, dWq = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.j */
public final class C31794j extends C46869e<Object> implements C17132h<Object>, C44632b, C8295e<Object> {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C31794j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31794j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C31794j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    private final C25266a AWG;
    private final C25266a AXq;
    private final C25266a AXr;
    final C8275i AXs;
    private final Object AXt;
    private final String signature;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
    /* renamed from: a.i.b.a.j$b */
    static final class C17335b extends C25053k implements C31214a<C36943d<? extends Member>> {
        final /* synthetic */ C31794j AXu;

        C17335b(C31794j c31794j) {
            this.AXu = c31794j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Member dXw;
            C36943d c44859a;
            C25058e a;
            boolean z = false;
            AppMethodBeat.m2504i(118757);
            C36944ad c36944ad = C36944ad.AYC;
            C44930c c = C36944ad.m61722c(this.AXu.dXf());
            C8275i c8275i;
            String str;
            if (c instanceof C17143e) {
                c8275i = this.AXu.AXs;
                str = ((C17143e) c).AWk.name;
                String str2 = ((C17143e) c).AWk.desc;
                dXw = this.AXu.dWU().dXw();
                if (dXw == null) {
                    C25052j.dWJ();
                }
                dXw = c8275i.mo18067d(str, str2, !Modifier.isStatic(dXw.getModifiers()), C8017af.m14200c(this.AXu.dXf()));
            } else if (c instanceof C44931d) {
                if (this.AXu.dWW()) {
                    Class dWH = this.AXu.AXs.dWH();
                    Iterable<C31813j> parameters = this.AXu.getParameters();
                    Collection arrayList = new ArrayList(C25034m.m39318d(parameters));
                    for (C31813j name : parameters) {
                        String name2 = name.getName();
                        if (name2 == null) {
                            C25052j.dWJ();
                        }
                        arrayList.add(name2);
                    }
                    c44859a = new C44859a(dWH, (List) arrayList, C36940a.CALL_BY_NAME, C25057b.KOTLIN);
                    AppMethodBeat.m2505o(118757);
                    return c44859a;
                }
                c8275i = this.AXu.AXs;
                str = ((C44931d) c).AWk.desc;
                boolean c2 = C8017af.m14200c(this.AXu.dXf());
                C25052j.m39376p(str, "desc");
                ArrayList arrayList2 = new ArrayList();
                c8275i.mo18065c(arrayList2, str, true);
                Class dWH2 = c8275i.dWH();
                List list = arrayList2;
                if (!c2) {
                    z = true;
                }
                dXw = C8275i.m14600a(dWH2, list, z);
            } else if (c instanceof C41383a) {
                List list2 = ((C41383a) c).AWf;
                Class dWH3 = this.AXu.AXs.dWH();
                Iterable<Method> iterable = list2;
                Collection arrayList3 = new ArrayList(C25034m.m39318d(iterable));
                for (Method method : iterable) {
                    C25052j.m39375o(method, "it");
                    arrayList3.add(method.getName());
                }
                c44859a = new C44859a(dWH3, (List) arrayList3, C36940a.CALL_BY_NAME, C25057b.JAVA, list2);
                AppMethodBeat.m2505o(118757);
                return c44859a;
            } else {
                dXw = null;
            }
            if (dXw instanceof Constructor) {
                a = C31794j.m51492a(this.AXu, (Constructor) dXw);
            } else if (dXw instanceof Method) {
                C8009f b;
                if (this.AXu.dXf().dYn().mo53i(C8017af.dXv()) != null) {
                    C31642l dXW = this.AXu.dXf().dXW();
                    if (dXW == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        AppMethodBeat.m2505o(118757);
                        throw c44941v;
                    } else if (!((C46865e) dXW).dYg()) {
                        b = C31794j.m51494b(this.AXu, (Method) dXw);
                        a = b;
                    }
                }
                b = C31794j.m51495c(this.AXu, (Method) dXw);
                a = b;
            } else {
                a = null;
            }
            if (a != null) {
                c44859a = C17141h.m26514a(a, this.AXu.dXf(), true);
                AppMethodBeat.m2505o(118757);
                return c44859a;
            }
            AppMethodBeat.m2505o(118757);
            return null;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
    /* renamed from: a.i.b.a.j$c */
    static final class C17336c extends C25053k implements C31214a<C8083t> {
        final /* synthetic */ C31794j AXu;
        final /* synthetic */ String AXv;

        C17336c(C31794j c31794j, String str) {
            this.AXu = c31794j;
            this.AXv = str;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Collection m;
            C8083t c8083t;
            int i = 0;
            AppMethodBeat.m2504i(118758);
            C8275i c8275i = this.AXu.AXs;
            String str = this.AXv;
            String a = this.AXu.signature;
            C25052j.m39376p(str, "name");
            C25052j.m39376p(a, "signature");
            if (C25052j.m39373j(str, "<init>")) {
                m = C25035t.m39352m(c8275i.dWR());
            } else {
                C37022f avX = C37022f.avX(str);
                C25052j.m39375o(avX, "Name.identifier(name)");
                m = c8275i.mo18064b(avX);
            }
            Collection arrayList = new ArrayList();
            for (Object next : m) {
                c8083t = (C8083t) next;
                C36944ad c36944ad = C36944ad.AYC;
                if (C25052j.m39373j(C36944ad.m61722c(c8083t).mo31248pq(), a)) {
                    arrayList.add(next);
                }
            }
            List list = (List) arrayList;
            if (list.size() != 1) {
                String a2 = C25035t.m39322a((Iterable) m, (CharSequence) IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, (C17126b) C8278d.AXn, 30);
                StringBuilder append = new StringBuilder("Function '").append(str).append("' (JVM signature: ").append(a).append(") not resolved in ").append(c8275i).append(':');
                if (a2.length() == 0) {
                    i = 1;
                }
                Throwable c25261x = new C25261x(append.append(i != 0 ? " no members found" : IOUtils.LINE_SEPARATOR_UNIX.concat(String.valueOf(a2))).toString());
                AppMethodBeat.m2505o(118758);
                throw c25261x;
            }
            c8083t = (C8083t) C25035t.m39341fN(list);
            AppMethodBeat.m2505o(118758);
            return c8083t;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
    /* renamed from: a.i.b.a.j$a */
    static final class C31551a extends C25053k implements C31214a<C36943d<? extends Member>> {
        final /* synthetic */ C31794j AXu;

        C31551a(C31794j c31794j) {
            this.AXu = c31794j;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Object cu;
            C25058e a;
            AppMethodBeat.m2504i(118756);
            C36944ad c36944ad = C36944ad.AYC;
            C44930c c = C36944ad.m61722c(this.AXu.dXf());
            C36943d c44859a;
            Member cu2;
            if (c instanceof C44931d) {
                if (this.AXu.dWW()) {
                    Class dWH = this.AXu.AXs.dWH();
                    Iterable<C31813j> parameters = this.AXu.getParameters();
                    Collection arrayList = new ArrayList(C25034m.m39318d(parameters));
                    for (C31813j name : parameters) {
                        String name2 = name.getName();
                        if (name2 == null) {
                            C25052j.dWJ();
                        }
                        arrayList.add(name2);
                    }
                    c44859a = new C44859a(dWH, (List) arrayList, C36940a.POSITIONAL_CALL, C25057b.KOTLIN);
                    AppMethodBeat.m2505o(118756);
                    return c44859a;
                }
                cu2 = this.AXu.AXs.mo18066cu(((C44931d) c).AWk.desc, C8017af.m14200c(this.AXu.dXf()));
            } else if (c instanceof C17143e) {
                cu2 = this.AXu.AXs.mo18060H(((C17143e) c).AWk.name, ((C17143e) c).AWk.desc, C8017af.m14200c(this.AXu.dXf()));
            } else if (c instanceof C41386c) {
                cu2 = ((C41386c) c).method;
            } else if (c instanceof C41385b) {
                cu2 = ((C41385b) c).AWh;
            } else if (c instanceof C41383a) {
                List list = ((C41383a) c).AWf;
                Class dWH2 = this.AXu.AXs.dWH();
                Iterable<Method> iterable = list;
                Collection arrayList2 = new ArrayList(C25034m.m39318d(iterable));
                for (Method method : iterable) {
                    C25052j.m39375o(method, "it");
                    arrayList2.add(method.getName());
                }
                c44859a = new C44859a(dWH2, (List) arrayList2, C36940a.POSITIONAL_CALL, C25057b.JAVA, list);
                AppMethodBeat.m2505o(118756);
                return c44859a;
            } else {
                C31824m c31824m = new C31824m();
                AppMethodBeat.m2505o(118756);
                throw c31824m;
            }
            if (cu2 instanceof Constructor) {
                a = C31794j.m51492a(this.AXu, (Constructor) cu2);
            } else if (cu2 instanceof Method) {
                C8009f a2;
                if (!Modifier.isStatic(((Method) cu2).getModifiers())) {
                    a2 = C31794j.m51491a(this.AXu, (Method) cu2);
                } else if (this.AXu.dXf().dYn().mo53i(C8017af.dXv()) != null) {
                    a2 = C31794j.m51494b(this.AXu, (Method) cu2);
                } else {
                    a2 = C31794j.m51495c(this.AXu, (Method) cu2);
                }
                a = a2;
            } else {
                Throwable c25261x = new C25261x("Could not compute caller for function: " + this.AXu.dXf() + " (member = " + cu2 + ')');
                AppMethodBeat.m2505o(118756);
                throw c25261x;
            }
            cu2 = C17141h.m26513a(a, this.AXu.dXf());
            AppMethodBeat.m2505o(118756);
            return cu2;
        }
    }

    static {
        AppMethodBeat.m2504i(118759);
        AppMethodBeat.m2505o(118759);
    }

    private C31794j(C8275i c8275i, String str, String str2, C8083t c8083t, Object obj) {
        AppMethodBeat.m2504i(118769);
        this.AXs = c8275i;
        this.signature = str2;
        this.AXt = obj;
        this.AWG = C25262z.m39833a(c8083t, new C17336c(this, str));
        this.AXq = C25262z.m39833a(null, new C31551a(this));
        this.AXr = C25262z.m39833a(null, new C17335b(this));
        AppMethodBeat.m2505o(118769);
    }

    public final /* synthetic */ C25085b dWT() {
        AppMethodBeat.m2504i(118762);
        C25085b dXf = dXf();
        AppMethodBeat.m2505o(118762);
        return dXf;
    }

    public final C8275i dWV() {
        return this.AXs;
    }

    public C31794j(C8275i c8275i, String str, String str2, Object obj) {
        C25052j.m39376p(c8275i, "container");
        C25052j.m39376p(str, "name");
        C25052j.m39376p(str2, "signature");
        this(c8275i, str, str2, null, obj);
        AppMethodBeat.m2504i(118771);
        AppMethodBeat.m2505o(118771);
    }

    public C31794j(C8275i c8275i, C8083t c8083t) {
        C25052j.m39376p(c8275i, "container");
        C25052j.m39376p(c8083t, "descriptor");
        String str = c8083t.dZg().name;
        C25052j.m39375o(str, "descriptor.name.asString()");
        C36944ad c36944ad = C36944ad.AYC;
        this(c8275i, str, C36944ad.m61722c(c8083t).mo31248pq(), c8083t);
        AppMethodBeat.m2504i(118772);
        AppMethodBeat.m2505o(118772);
    }

    public final boolean isBound() {
        AppMethodBeat.m2504i(118760);
        int j = C25052j.m39373j(this.AXt, C41376c.AVy) ^ 1;
        AppMethodBeat.m2505o(118760);
        return j;
    }

    public final String getName() {
        AppMethodBeat.m2504i(118763);
        String str = dXf().dZg().name;
        C25052j.m39375o(str, "descriptor.name.asString()");
        AppMethodBeat.m2505o(118763);
        return str;
    }

    public final int dWz() {
        AppMethodBeat.m2504i(118765);
        int a = C25069f.m39387a(dWU());
        AppMethodBeat.m2505o(118765);
        return a;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(118766);
        C31794j dw = C8017af.m14201dw(obj);
        if (dw == null) {
            AppMethodBeat.m2505o(118766);
            return false;
        } else if (C25052j.m39373j(this.AXs, dw.AXs) && C25052j.m39373j(getName(), dw.getName()) && C25052j.m39373j(this.signature, dw.signature) && C25052j.m39373j(this.AXt, dw.AXt)) {
            AppMethodBeat.m2505o(118766);
            return true;
        } else {
            AppMethodBeat.m2505o(118766);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(118768);
        C41382ab c41382ab = C41382ab.AYy;
        String a = C41382ab.m72160a(dXf());
        AppMethodBeat.m2505o(118768);
        return a;
    }

    public final C8083t dXf() {
        AppMethodBeat.m2504i(118761);
        C8083t c8083t = (C8083t) this.AWG.invoke();
        AppMethodBeat.m2505o(118761);
        return c8083t;
    }

    public final C36943d<?> dWU() {
        AppMethodBeat.m2504i(118764);
        C36943d c36943d = (C36943d) this.AXq.invoke();
        AppMethodBeat.m2505o(118764);
        return c36943d;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(118767);
        int hashCode = (((this.AXs.hashCode() * 31) + getName().hashCode()) * 31) + this.signature.hashCode();
        AppMethodBeat.m2505o(118767);
        return hashCode;
    }

    public final Object invoke() {
        AppMethodBeat.m2504i(118773);
        Object W = mo66046W(new Object[0]);
        AppMethodBeat.m2505o(118773);
        return W;
    }

    /* renamed from: am */
    public final Object mo50am(Object obj) {
        AppMethodBeat.m2504i(118774);
        Object W = mo66046W(obj);
        AppMethodBeat.m2505o(118774);
        return W;
    }

    /* renamed from: m */
    public final Object mo212m(Object obj, Object obj2) {
        AppMethodBeat.m2504i(118775);
        Object W = mo66046W(obj, obj2);
        AppMethodBeat.m2505o(118775);
        return W;
    }

    /* renamed from: g */
    public final Object mo9028g(Object obj, Object obj2, Object obj3) {
        AppMethodBeat.m2504i(118776);
        Object W = mo66046W(obj, obj2, obj3);
        AppMethodBeat.m2505o(118776);
        return W;
    }

    /* renamed from: a */
    public final Object mo47a(Object obj, Object obj2, Object obj3, Object obj4) {
        AppMethodBeat.m2504i(118777);
        Object W = mo66046W(obj, obj2, obj3, obj4);
        AppMethodBeat.m2505o(118777);
        return W;
    }

    /* renamed from: b */
    public static final /* synthetic */ C8009f m51494b(C31794j c31794j, Method method) {
        AppMethodBeat.m2504i(118780);
        C8009f c8012b;
        if (c31794j.isBound()) {
            c8012b = new C8012b(method);
            AppMethodBeat.m2505o(118780);
            return c8012b;
        }
        c8012b = new C8015e(method);
        AppMethodBeat.m2505o(118780);
        return c8012b;
    }

    /* renamed from: c */
    public static final /* synthetic */ C8009f m51495c(C31794j c31794j, Method method) {
        AppMethodBeat.m2504i(118781);
        C8009f c8013c;
        if (c31794j.isBound()) {
            c8013c = new C8013c(method, c31794j.AXt);
            AppMethodBeat.m2505o(118781);
            return c8013c;
        }
        c8013c = new C8011f(method);
        AppMethodBeat.m2505o(118781);
        return c8013c;
    }
}
