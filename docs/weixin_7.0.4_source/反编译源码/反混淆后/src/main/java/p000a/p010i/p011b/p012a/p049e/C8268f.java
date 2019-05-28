package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C17115v;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C17187d;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0011"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationOwner;", "annotations", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "isDeprecatedInJavaDoc", "", "()Z", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.f */
public interface C8268f extends C17187d {

    @C0220l(dWo = {1, 1, 13})
    /* renamed from: a.i.b.a.e.f$a */
    public static final class C8269a {
        /* renamed from: a */
        public static List<C44932c> m14593a(C8268f c8268f) {
            AppMethodBeat.m2504i(123033);
            AnnotatedElement ekH = c8268f.ekH();
            if (ekH != null) {
                Annotation[] declaredAnnotations = ekH.getDeclaredAnnotations();
                if (declaredAnnotations != null) {
                    List a = C8270g.m14595a(declaredAnnotations);
                    AppMethodBeat.m2505o(123033);
                    return a;
                }
            }
            List<C44932c> list = C17115v.AUP;
            AppMethodBeat.m2505o(123033);
            return list;
        }

        /* renamed from: a */
        public static C44932c m14592a(C8268f c8268f, C8174b c8174b) {
            AppMethodBeat.m2504i(123034);
            C25052j.m39376p(c8174b, "fqName");
            AnnotatedElement ekH = c8268f.ekH();
            if (ekH != null) {
                Annotation[] declaredAnnotations = ekH.getDeclaredAnnotations();
                if (declaredAnnotations != null) {
                    C44932c a = C8270g.m14594a(declaredAnnotations, c8174b);
                    AppMethodBeat.m2505o(123034);
                    return a;
                }
            }
            AppMethodBeat.m2505o(123034);
            return null;
        }
    }

    AnnotatedElement ekH();
}
