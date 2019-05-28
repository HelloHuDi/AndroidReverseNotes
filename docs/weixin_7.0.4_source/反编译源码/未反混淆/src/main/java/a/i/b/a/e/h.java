package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.e;
import a.i.b.a.c.f.f;
import a.i.b.a.e.d.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0016R\u0014\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "values", "", "(Lorg/jetbrains/kotlin/name/Name;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getElements", "", "descriptors.runtime"})
public final class h extends d implements e {
    private final Object[] akP;

    public h(f fVar, Object[] objArr) {
        j.p(objArr, "values");
        super(fVar);
        AppMethodBeat.i(123038);
        this.akP = objArr;
        AppMethodBeat.o(123038);
    }

    public final List<d> ebD() {
        AppMethodBeat.i(123037);
        Object[] objArr = this.akP;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null) {
                j.dWJ();
            }
            arrayList.add(a.a(obj, null));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(123037);
        return list;
    }
}
