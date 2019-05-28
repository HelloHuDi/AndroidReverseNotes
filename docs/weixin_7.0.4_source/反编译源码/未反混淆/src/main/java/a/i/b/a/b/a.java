package a.i.b.a.b;

import a.f.b.j;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.an;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, dWq = {"Lkotlin/reflect/jvm/internal/components/ReflectAnnotationSource;", "Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;", "annotation", "", "(Ljava/lang/annotation/Annotation;)V", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "getContainingFile", "Lkotlin/reflect/jvm/internal/impl/descriptors/SourceFile;", "descriptors.runtime"})
public final class a implements am {
    public final Annotation AZp;

    public a(Annotation annotation) {
        j.p(annotation, "annotation");
        AppMethodBeat.i(119020);
        this.AZp = annotation;
        AppMethodBeat.o(119020);
    }

    public final an dXz() {
        AppMethodBeat.i(119019);
        an anVar = an.BeS;
        j.o(anVar, "SourceFile.NO_SOURCE_FILE");
        AppMethodBeat.o(119019);
        return anVar;
    }
}
