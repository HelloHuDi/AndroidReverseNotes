package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.a;
import a.i.b.a.c.d.a.e.b;
import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.f.f;
import a.l;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "annotation", "", "(Ljava/lang/annotation/Annotation;)V", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "arguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "getArguments", "()Ljava/util/Collection;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "equals", "", "other", "", "hashCode", "", "resolve", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "toString", "", "descriptors.runtime"})
public final class c extends n implements a {
    public final Annotation AZp;

    public c(Annotation annotation) {
        j.p(annotation, "annotation");
        AppMethodBeat.i(123029);
        this.AZp = annotation;
        AppMethodBeat.o(123029);
    }

    public final Collection<b> ebz() {
        AppMethodBeat.i(123023);
        Method[] declaredMethods = a.f.a.a(a.f.a.a(this.AZp)).getDeclaredMethods();
        j.o(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        Collection arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            d.a aVar = d.BNS;
            Object invoke = method.invoke(this.AZp, new Object[0]);
            j.o(invoke, "method.invoke(annotation)");
            j.o(method, FirebaseAnalytics.b.METHOD);
            arrayList.add(d.a.a(invoke, f.avX(method.getName())));
        }
        arrayList = (List) arrayList;
        AppMethodBeat.o(123023);
        return arrayList;
    }

    public final a.i.b.a.c.f.a dWY() {
        AppMethodBeat.i(123024);
        a.i.b.a.c.f.a bb = b.bb(a.f.a.a(a.f.a.a(this.AZp)));
        AppMethodBeat.o(123024);
        return bb;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(123026);
        if ((obj instanceof c) && j.j(this.AZp, ((c) obj).AZp)) {
            AppMethodBeat.o(123026);
            return true;
        }
        AppMethodBeat.o(123026);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(123027);
        int hashCode = this.AZp.hashCode();
        AppMethodBeat.o(123027);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(123028);
        String str = getClass().getName() + ": " + this.AZp;
        AppMethodBeat.o(123028);
        return str;
    }

    public final /* synthetic */ g ebA() {
        AppMethodBeat.i(123025);
        g jVar = new j(a.f.a.a(a.f.a.a(this.AZp)));
        AppMethodBeat.o(123025);
        return jVar;
    }
}
