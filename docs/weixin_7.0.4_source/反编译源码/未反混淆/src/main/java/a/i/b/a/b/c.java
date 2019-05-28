package a.i.b.a.b;

import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.d.a.e.t;
import a.i.b.a.c.d.a.j;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.b;
import a.i.b.a.e.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, dWq = {"Lkotlin/reflect/jvm/internal/components/ReflectJavaClassFinder;", "Lkotlin/reflect/jvm/internal/impl/load/java/JavaClassFinder;", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "findClass", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "findPackage", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "knownClassNamesInPackage", "", "", "packageFqName", "descriptors.runtime"})
public final class c implements j {
    private final ClassLoader AZr;

    public c(ClassLoader classLoader) {
        a.f.b.j.p(classLoader, "classLoader");
        AppMethodBeat.i(119030);
        this.AZr = classLoader;
        AppMethodBeat.o(119030);
    }

    public final t a(b bVar) {
        AppMethodBeat.i(119028);
        a.f.b.j.p(bVar, "fqName");
        t uVar = new u(bVar);
        AppMethodBeat.o(119028);
        return uVar;
    }

    public final Set<String> b(b bVar) {
        AppMethodBeat.i(119029);
        a.f.b.j.p(bVar, "packageFqName");
        AppMethodBeat.o(119029);
        return null;
    }

    public final g a(a aVar) {
        AppMethodBeat.i(119027);
        a.f.b.j.p(aVar, "classId");
        b bVar = aVar.BcW;
        a.f.b.j.o(bVar, "classId.packageFqName");
        String str = aVar.ByN.ByQ.ByV;
        a.f.b.j.o(str, "classId.relativeClassName.asString()");
        str = a.k.u.a(str, '.', '$');
        if (!bVar.ByQ.ByV.isEmpty()) {
            str = bVar.ByQ.ByV + "." + str;
        }
        Class a = d.a(this.AZr, str);
        if (a != null) {
            g jVar = new a.i.b.a.e.j(a);
            AppMethodBeat.o(119027);
            return jVar;
        }
        AppMethodBeat.o(119027);
        return null;
    }
}
