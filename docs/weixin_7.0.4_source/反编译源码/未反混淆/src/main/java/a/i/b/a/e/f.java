package a.i.b.a.e;

import a.a.v;
import a.f.b.j;
import a.i.b.a.c.d.a.e.d;
import a.i.b.a.c.f.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0011"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationOwner;", "annotations", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "isDeprecatedInJavaDoc", "", "()Z", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"})
public interface f extends d {

    @l(dWo = {1, 1, 13})
    public static final class a {
        public static List<c> a(f fVar) {
            AppMethodBeat.i(123033);
            AnnotatedElement ekH = fVar.ekH();
            if (ekH != null) {
                Annotation[] declaredAnnotations = ekH.getDeclaredAnnotations();
                if (declaredAnnotations != null) {
                    List a = g.a(declaredAnnotations);
                    AppMethodBeat.o(123033);
                    return a;
                }
            }
            List<c> list = v.AUP;
            AppMethodBeat.o(123033);
            return list;
        }

        public static c a(f fVar, b bVar) {
            AppMethodBeat.i(123034);
            j.p(bVar, "fqName");
            AnnotatedElement ekH = fVar.ekH();
            if (ekH != null) {
                Annotation[] declaredAnnotations = ekH.getDeclaredAnnotations();
                if (declaredAnnotations != null) {
                    c a = g.a(declaredAnnotations, bVar);
                    AppMethodBeat.o(123034);
                    return a;
                }
            }
            AppMethodBeat.o(123034);
            return null;
        }
    }

    AnnotatedElement ekH();
}
