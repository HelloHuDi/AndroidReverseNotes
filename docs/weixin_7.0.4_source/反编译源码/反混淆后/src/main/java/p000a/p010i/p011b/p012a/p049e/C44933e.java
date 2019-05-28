package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C17186c;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationAsAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationAsAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "annotation", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/annotation/Annotation;)V", "getAnnotation", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.e */
public final class C44933e extends C41187d implements C17186c {
    private final Annotation AZp;

    public C44933e(C37022f c37022f, Annotation annotation) {
        C25052j.m39376p(annotation, "annotation");
        super(c37022f);
        AppMethodBeat.m2504i(123032);
        this.AZp = annotation;
        AppMethodBeat.m2505o(123032);
    }

    public final C41408a ebB() {
        AppMethodBeat.m2504i(123031);
        C41408a c44932c = new C44932c(this.AZp);
        AppMethodBeat.m2505o(123031);
        return c44932c;
    }
}
