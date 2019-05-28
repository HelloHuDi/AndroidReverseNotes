package a.i.b.a.e;

import a.f.a;
import a.f.b.j;
import a.i.b.a.c.f.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"findAnnotation", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "", "", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "([Ljava/lang/annotation/Annotation;Lorg/jetbrains/kotlin/name/FqName;)Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "", "([Ljava/lang/annotation/Annotation;)Ljava/util/List;", "descriptors.runtime"})
public final class g {
    public static final List<c> a(Annotation[] annotationArr) {
        AppMethodBeat.i(123035);
        j.p(annotationArr, "receiver$0");
        Collection arrayList = new ArrayList(annotationArr.length);
        for (Annotation cVar : annotationArr) {
            arrayList.add(new c(cVar));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(123035);
        return list;
    }

    public static final c a(Annotation[] annotationArr, b bVar) {
        AppMethodBeat.i(123036);
        j.p(annotationArr, "receiver$0");
        j.p(bVar, "fqName");
        for (Annotation annotation : annotationArr) {
            if (j.j(b.bb(a.a(a.a(annotation))).ehE(), bVar)) {
                break;
            }
        }
        Annotation annotation2 = null;
        if (annotation2 != null) {
            c cVar = new c(annotation2);
            AppMethodBeat.o(123036);
            return cVar;
        }
        AppMethodBeat.o(123036);
        return null;
    }
}
