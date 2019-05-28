package a.i.b.a.e;

import a.a.t;
import a.a.v;
import a.f.b.j;
import a.i.b.a.c.d.a.e.a;
import a.i.b.a.c.d.a.e.w;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "typeVariable", "Ljava/lang/reflect/TypeVariable;", "(Ljava/lang/reflect/TypeVariable;)V", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "getTypeVariable", "()Ljava/lang/reflect/TypeVariable;", "upperBounds", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "getUpperBounds", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "", "descriptors.runtime"})
public final class x extends n implements w, f {
    private final TypeVariable<?> BOk;

    public final /* synthetic */ a m(b bVar) {
        AppMethodBeat.i(123124);
        j.p(bVar, "fqName");
        a a = f.a.a(this, bVar);
        AppMethodBeat.o(123124);
        return a;
    }

    public x(TypeVariable<?> typeVariable) {
        j.p(typeVariable, "typeVariable");
        AppMethodBeat.i(123122);
        this.BOk = typeVariable;
        AppMethodBeat.o(123122);
    }

    public final AnnotatedElement ekH() {
        TypeVariable typeVariable = this.BOk;
        if (!(typeVariable instanceof AnnotatedElement)) {
            typeVariable = null;
        }
        return (AnnotatedElement) typeVariable;
    }

    public final f dZg() {
        AppMethodBeat.i(123118);
        f avX = f.avX(this.BOk.getName());
        j.o(avX, "Name.identifier(typeVariable.name)");
        AppMethodBeat.o(123118);
        return avX;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(123119);
        if ((obj instanceof x) && j.j(this.BOk, ((x) obj).BOk)) {
            AppMethodBeat.o(123119);
            return true;
        }
        AppMethodBeat.o(123119);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(123120);
        int hashCode = this.BOk.hashCode();
        AppMethodBeat.o(123120);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(123121);
        String str = getClass().getName() + ": " + this.BOk;
        AppMethodBeat.o(123121);
        return str;
    }

    public final /* synthetic */ Collection ecb() {
        Object obj;
        AppMethodBeat.i(123117);
        Type[] bounds = this.BOk.getBounds();
        j.o(bounds, "typeVariable.bounds");
        Collection arrayList = new ArrayList(bounds.length);
        for (Type lVar : bounds) {
            arrayList.add(new l(lVar));
        }
        List list = (List) arrayList;
        l lVar2 = (l) t.fO(list);
        if (lVar2 != null) {
            obj = lVar2.BNU;
        } else {
            obj = null;
        }
        if (j.j(obj, Object.class)) {
            list = v.AUP;
        }
        arrayList = list;
        AppMethodBeat.o(123117);
        return arrayList;
    }

    public final /* synthetic */ Collection ebC() {
        AppMethodBeat.i(123123);
        Collection a = f.a.a(this);
        AppMethodBeat.o(123123);
        return a;
    }
}
