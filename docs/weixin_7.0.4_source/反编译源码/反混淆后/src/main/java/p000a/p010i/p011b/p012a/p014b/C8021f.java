package p000a.p010i.p011b.p012a.p014b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p014b.C16483e.C8020a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C25129m;
import p000a.p010i.p011b.p012a.p015c.p023d.p031b.C8143n;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findBuiltInsData", "Ljava/io/InputStream;", "packageFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "findKotlinClass", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass;", "fqName", "", "javaClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findMetadata", "hasMetadataPackage", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.b.f */
public final class C8021f implements C25129m {
    private final ClassLoader AZr;

    public C8021f(ClassLoader classLoader) {
        C25052j.m39376p(classLoader, "classLoader");
        AppMethodBeat.m2504i(119044);
        this.AZr = classLoader;
        AppMethodBeat.m2505o(119044);
    }

    private final C8143n avz(String str) {
        C16483e aV;
        AppMethodBeat.m2504i(119041);
        Class a = C8019d.m14203a(this.AZr, str);
        if (a != null) {
            C8020a c8020a = C16483e.AZu;
            aV = C8020a.m14204aV(a);
        } else {
            aV = null;
        }
        C8143n c8143n = aV;
        AppMethodBeat.m2505o(119041);
        return c8143n;
    }

    /* renamed from: a */
    public final C8143n mo17819a(C44635g c44635g) {
        AppMethodBeat.m2504i(119043);
        C25052j.m39376p(c44635g, "javaClass");
        C8174b dZF = c44635g.dZF();
        if (dZF != null) {
            String str = dZF.ByQ.ByV;
            if (str != null) {
                C8143n avz = avz(str);
                AppMethodBeat.m2505o(119043);
                return avz;
            }
        }
        AppMethodBeat.m2505o(119043);
        return null;
    }

    /* renamed from: b */
    public final C8143n mo17820b(C8173a c8173a) {
        AppMethodBeat.m2504i(119042);
        C25052j.m39376p(c8173a, "classId");
        String str = c8173a.ByN.ByQ.ByV;
        C25052j.m39375o(str, "relativeClassName.asString()");
        str = C6163u.m9834a(str, '.', '$');
        C8174b c8174b = c8173a.BcW;
        C25052j.m39375o(c8174b, "packageFqName");
        if (!c8174b.ByQ.ByV.isEmpty()) {
            str = c8173a.BcW + '.' + str;
        }
        C8143n avz = avz(str);
        AppMethodBeat.m2505o(119042);
        return avz;
    }
}
