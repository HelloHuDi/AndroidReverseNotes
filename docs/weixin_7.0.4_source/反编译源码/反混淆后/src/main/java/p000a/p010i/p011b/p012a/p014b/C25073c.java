package p000a.p010i.p011b.p012a.p014b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C8127j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0060t;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p049e.C25250j;
import p000a.p010i.p011b.p012a.p049e.C36661u;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lkotlin/reflect/jvm/internal/components/ReflectJavaClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/java/JavaClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findPackage", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "knownClassNamesInPackage", "", "", "packageFqName", "descriptors.runtime"})
/* renamed from: a.i.b.a.b.c */
public final class C25073c implements C8127j {
    private final ClassLoader AZr;

    public C25073c(ClassLoader classLoader) {
        C25052j.m39376p(classLoader, "classLoader");
        AppMethodBeat.m2504i(119030);
        this.AZr = classLoader;
        AppMethodBeat.m2505o(119030);
    }

    /* renamed from: a */
    public final C0060t mo17928a(C8174b c8174b) {
        AppMethodBeat.m2504i(119028);
        C25052j.m39376p(c8174b, "fqName");
        C0060t c36661u = new C36661u(c8174b);
        AppMethodBeat.m2505o(119028);
        return c36661u;
    }

    /* renamed from: b */
    public final Set<String> mo17929b(C8174b c8174b) {
        AppMethodBeat.m2504i(119029);
        C25052j.m39376p(c8174b, "packageFqName");
        AppMethodBeat.m2505o(119029);
        return null;
    }

    /* renamed from: a */
    public final C44635g mo17927a(C8173a c8173a) {
        AppMethodBeat.m2504i(119027);
        C25052j.m39376p(c8173a, "classId");
        C8174b c8174b = c8173a.BcW;
        C25052j.m39375o(c8174b, "classId.packageFqName");
        String str = c8173a.ByN.ByQ.ByV;
        C25052j.m39375o(str, "classId.relativeClassName.asString()");
        str = C6163u.m9834a(str, '.', '$');
        if (!c8174b.ByQ.ByV.isEmpty()) {
            str = c8174b.ByQ.ByV + "." + str;
        }
        Class a = C8019d.m14203a(this.AZr, str);
        if (a != null) {
            C44635g c25250j = new C25250j(a);
            AppMethodBeat.m2505o(119027);
            return c25250j;
        }
        AppMethodBeat.m2505o(119027);
        return null;
    }
}
