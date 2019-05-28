package a.i.b.a.b;

import a.f.b.j;
import a.i.b.a.b.e.a;
import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.d.b.m;
import a.i.b.a.c.d.b.n;
import a.i.b.a.c.f.b;
import a.k.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, dWq = {"Lkotlin/reflect/jvm/internal/components/ReflectKotlinClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findBuiltInsData", "Ljava/io/InputStream;", "packageFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "findKotlinClass", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass;", "fqName", "", "javaClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findMetadata", "hasMetadataPackage", "", "descriptors.runtime"})
public final class f implements m {
    private final ClassLoader AZr;

    public f(ClassLoader classLoader) {
        j.p(classLoader, "classLoader");
        AppMethodBeat.i(119044);
        this.AZr = classLoader;
        AppMethodBeat.o(119044);
    }

    private final n avz(String str) {
        e aV;
        AppMethodBeat.i(119041);
        Class a = d.a(this.AZr, str);
        if (a != null) {
            a aVar = e.AZu;
            aV = a.aV(a);
        } else {
            aV = null;
        }
        n nVar = aV;
        AppMethodBeat.o(119041);
        return nVar;
    }

    public final n a(g gVar) {
        AppMethodBeat.i(119043);
        j.p(gVar, "javaClass");
        b dZF = gVar.dZF();
        if (dZF != null) {
            String str = dZF.ByQ.ByV;
            if (str != null) {
                n avz = avz(str);
                AppMethodBeat.o(119043);
                return avz;
            }
        }
        AppMethodBeat.o(119043);
        return null;
    }

    public final n b(a.i.b.a.c.f.a aVar) {
        AppMethodBeat.i(119042);
        j.p(aVar, "classId");
        String str = aVar.ByN.ByQ.ByV;
        j.o(str, "relativeClassName.asString()");
        str = u.a(str, '.', '$');
        b bVar = aVar.BcW;
        j.o(bVar, "packageFqName");
        if (!bVar.ByQ.ByV.isEmpty()) {
            str = aVar.BcW + '.' + str;
        }
        n avz = avz(str);
        AppMethodBeat.o(119042);
        return avz;
    }
}
