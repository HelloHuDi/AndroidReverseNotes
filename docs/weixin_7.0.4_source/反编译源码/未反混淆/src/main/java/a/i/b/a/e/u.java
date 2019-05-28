package a.i.b.a.e;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.d.a.e.a;
import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.d.a.e.t;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@l(dWo = {1, 1, 13}, dWp = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000e0\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPackage;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPackage;", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "(Lorg/jetbrains/kotlin/name/FqName;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "isDeprecatedInJavaDoc", "", "()Z", "subPackages", "", "getSubPackages", "()Ljava/util/Collection;", "equals", "other", "", "findAnnotation", "", "getClasses", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClass;", "nameFilter", "Lkotlin/Function1;", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "hashCode", "", "toString", "", "descriptors.runtime"})
public final class u extends n implements t {
    private final b BfP;

    public u(b bVar) {
        j.p(bVar, "fqName");
        AppMethodBeat.i(123113);
        this.BfP = bVar;
        AppMethodBeat.o(123113);
    }

    public final b dZF() {
        return this.BfP;
    }

    public final /* synthetic */ a m(b bVar) {
        AppMethodBeat.i(123109);
        j.p(bVar, "fqName");
        AppMethodBeat.o(123109);
        return null;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(123110);
        if ((obj instanceof u) && j.j(this.BfP, ((u) obj).BfP)) {
            AppMethodBeat.o(123110);
            return true;
        }
        AppMethodBeat.o(123110);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(123112);
        String str = getClass().getName() + ": " + this.BfP;
        AppMethodBeat.o(123112);
        return str;
    }

    public final Collection<g> d(a.f.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(123108);
        j.p(bVar, "nameFilter");
        Collection collection = v.AUP;
        AppMethodBeat.o(123108);
        return collection;
    }

    public final Collection<t> ebZ() {
        return v.AUP;
    }

    public final /* bridge */ /* synthetic */ Collection ebC() {
        return v.AUP;
    }

    public final int hashCode() {
        AppMethodBeat.i(123111);
        int hashCode = this.BfP.hashCode();
        AppMethodBeat.o(123111);
        return hashCode;
    }
}
