package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.a;
import a.i.b.a.c.d.a.e.c;
import a.i.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationAsAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationAsAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "annotation", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/annotation/Annotation;)V", "getAnnotation", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "descriptors.runtime"})
public final class e extends d implements c {
    private final Annotation AZp;

    public e(f fVar, Annotation annotation) {
        j.p(annotation, "annotation");
        super(fVar);
        AppMethodBeat.i(123032);
        this.AZp = annotation;
        AppMethodBeat.o(123032);
    }

    public final a ebB() {
        AppMethodBeat.i(123031);
        a cVar = new c(this.AZp);
        AppMethodBeat.o(123031);
        return cVar;
    }
}
