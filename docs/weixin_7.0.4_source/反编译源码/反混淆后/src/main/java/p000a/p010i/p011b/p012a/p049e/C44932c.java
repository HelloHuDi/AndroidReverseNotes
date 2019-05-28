package p000a.p010i.p011b.p012a.p049e;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.C25047a;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36983b;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44635g;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;
import p000a.p010i.p011b.p012a.p049e.C41187d.C37078a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "annotation", "", "(Ljava/lang/annotation/Annotation;)V", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "arguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "getArguments", "()Ljava/util/Collection;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "equals", "", "other", "", "hashCode", "", "resolve", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "toString", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.c */
public final class C44932c extends C31792n implements C41408a {
    public final Annotation AZp;

    public C44932c(Annotation annotation) {
        C25052j.m39376p(annotation, "annotation");
        AppMethodBeat.m2504i(123029);
        this.AZp = annotation;
        AppMethodBeat.m2505o(123029);
    }

    public final Collection<C36983b> ebz() {
        AppMethodBeat.m2504i(123023);
        Method[] declaredMethods = C25047a.m39368a(C25047a.m39367a(this.AZp)).getDeclaredMethods();
        C25052j.m39375o(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        Collection arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            C37078a c37078a = C41187d.BNS;
            Object invoke = method.invoke(this.AZp, new Object[0]);
            C25052j.m39375o(invoke, "method.invoke(annotation)");
            C25052j.m39375o(method, C8741b.METHOD);
            arrayList.add(C37078a.m62040a(invoke, C37022f.avX(method.getName())));
        }
        arrayList = (List) arrayList;
        AppMethodBeat.m2505o(123023);
        return arrayList;
    }

    public final C8173a dWY() {
        AppMethodBeat.m2504i(123024);
        C8173a bb = C37076b.m62036bb(C25047a.m39368a(C25047a.m39367a(this.AZp)));
        AppMethodBeat.m2505o(123024);
        return bb;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(123026);
        if ((obj instanceof C44932c) && C25052j.m39373j(this.AZp, ((C44932c) obj).AZp)) {
            AppMethodBeat.m2505o(123026);
            return true;
        }
        AppMethodBeat.m2505o(123026);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(123027);
        int hashCode = this.AZp.hashCode();
        AppMethodBeat.m2505o(123027);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(123028);
        String str = getClass().getName() + ": " + this.AZp;
        AppMethodBeat.m2505o(123028);
        return str;
    }

    public final /* synthetic */ C44635g ebA() {
        AppMethodBeat.m2504i(123025);
        C44635g c25250j = new C25250j(C25047a.m39368a(C25047a.m39367a(this.AZp)));
        AppMethodBeat.m2505o(123025);
        return c25250j;
    }
}
