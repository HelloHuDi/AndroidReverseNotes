package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.C25047a;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b*\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, dWq = {"findAnnotation", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "", "", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "([Ljava/lang/annotation/Annotation;Lorg/jetbrains/kotlin/name/FqName;)Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "", "([Ljava/lang/annotation/Annotation;)Ljava/util/List;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.g */
public final class C8270g {
    /* renamed from: a */
    public static final List<C44932c> m14595a(Annotation[] annotationArr) {
        AppMethodBeat.m2504i(123035);
        C25052j.m39376p(annotationArr, "receiver$0");
        Collection arrayList = new ArrayList(annotationArr.length);
        for (Annotation c44932c : annotationArr) {
            arrayList.add(new C44932c(c44932c));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(123035);
        return list;
    }

    /* renamed from: a */
    public static final C44932c m14594a(Annotation[] annotationArr, C8174b c8174b) {
        AppMethodBeat.m2504i(123036);
        C25052j.m39376p(annotationArr, "receiver$0");
        C25052j.m39376p(c8174b, "fqName");
        for (Annotation annotation : annotationArr) {
            if (C25052j.m39373j(C37076b.m62036bb(C25047a.m39368a(C25047a.m39367a(annotation))).ehE(), c8174b)) {
                break;
            }
        }
        Annotation annotation2 = null;
        if (annotation2 != null) {
            C44932c c44932c = new C44932c(annotation2);
            AppMethodBeat.m2505o(123036);
            return c44932c;
        }
        AppMethodBeat.m2505o(123036);
        return null;
    }
}
