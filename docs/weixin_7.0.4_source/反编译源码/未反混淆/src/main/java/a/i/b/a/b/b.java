package a.i.b.a.b;

import a.a.i;
import a.f.a;
import a.f.b.j;
import a.i.b.a.c.a.g;
import a.i.b.a.c.a.h;
import a.i.b.a.c.d.b.n;
import a.i.b.a.c.d.b.n.c;
import a.i.b.a.c.d.b.n.d;
import a.i.b.a.c.f.f;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@l(dWo = {1, 1, 13}, dWp = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\f\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0002J$\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u001a\u0010\u0018\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a*\u0006\u0012\u0002\b\u00030\u0006H\u0002¨\u0006\u001b"}, dWq = {"Lkotlin/reflect/jvm/internal/components/ReflectClassStructure;", "", "()V", "loadClassAnnotations", "", "klass", "Ljava/lang/Class;", "visitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationVisitor;", "loadConstructorAnnotations", "memberVisitor", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$MemberVisitor;", "loadFieldAnnotations", "loadMethodAnnotations", "processAnnotation", "annotation", "", "processAnnotationArgumentValue", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$AnnotationArgumentVisitor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "processAnnotationArguments", "annotationType", "visitMembers", "classLiteralId", "Lkotlin/reflect/jvm/internal/impl/load/kotlin/KotlinJvmBinaryClass$ClassLiteralId;", "descriptors.runtime"})
final class b {
    public static final b AZq = new b();

    static {
        AppMethodBeat.i(119026);
        AppMethodBeat.o(119026);
    }

    private b() {
    }

    public static void a(Class<?> cls, c cVar) {
        AppMethodBeat.i(119021);
        j.p(cls, "klass");
        j.p(cVar, "visitor");
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            j.o(annotation, "annotation");
            a(cVar, annotation);
        }
        cVar.zn();
        AppMethodBeat.o(119021);
    }

    static void a(c cVar, Annotation annotation) {
        AppMethodBeat.i(119022);
        Class a = a.a(a.a(annotation));
        n.a a2 = cVar.a(a.i.b.a.e.b.bb(a), new a(annotation));
        if (a2 != null) {
            AZq.a(a2, annotation, a);
            AppMethodBeat.o(119022);
            return;
        }
        AppMethodBeat.o(119022);
    }

    /* Access modifiers changed, original: final */
    public final void a(n.a aVar, Annotation annotation, Class<?> cls) {
        AppMethodBeat.i(119023);
        for (Method method : cls.getDeclaredMethods()) {
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                if (invoke == null) {
                    j.dWJ();
                }
                j.o(method, com.google.firebase.analytics.FirebaseAnalytics.b.METHOD);
                f avX = f.avX(method.getName());
                j.o(avX, "Name.identifier(method.name)");
                a(aVar, avX, invoke);
            } catch (IllegalAccessException e) {
            }
        }
        aVar.zn();
        AppMethodBeat.o(119023);
    }

    private static d aU(Class<?> cls) {
        Class cls2;
        a.i.b.a.c.f.a n;
        AppMethodBeat.i(119024);
        int i = 0;
        while (cls2.isArray()) {
            i++;
            cls2 = cls2.getComponentType();
            j.o(cls2, "currentClass.componentType");
        }
        if (cls2.isPrimitive()) {
            a.i.b.a.c.f.b bVar;
            a.i.b.a.c.i.d.c awk = a.i.b.a.c.i.d.c.awk(cls2.getName());
            j.o(awk, "JvmPrimitiveType.get(currentClass.name)");
            h hVar = awk.BFq;
            j.o(hVar, "JvmPrimitiveType.get(cur…Class.name).primitiveType");
            if (hVar.Bcb != null) {
                bVar = hVar.Bcb;
            } else {
                hVar.Bcb = g.AZV.q(hVar.BbZ);
                bVar = hVar.Bcb;
            }
            n = a.i.b.a.c.f.a.n(bVar);
            j.o(n, "ClassId.topLevel(JvmPrim…primitiveType.typeFqName)");
        } else {
            n = a.i.b.a.e.b.bb(cls2);
        }
        d dVar = new d(n, i);
        AppMethodBeat.o(119024);
        return dVar;
    }

    private final void a(n.a aVar, f fVar, Object obj) {
        int i = 0;
        AppMethodBeat.i(119025);
        Class cls = obj.getClass();
        v vVar;
        Object enclosingClass;
        if (j.j(cls, Class.class)) {
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type java.lang.Class<*>");
                AppMethodBeat.o(119025);
                throw vVar;
            }
            aVar.a(fVar, aU((Class) obj));
            AppMethodBeat.o(119025);
        } else if (g.AZv.contains(cls)) {
            aVar.a(fVar, obj);
            AppMethodBeat.o(119025);
        } else if (a.i.b.a.e.b.aY(cls)) {
            enclosingClass = cls.isEnum() ? cls : cls.getEnclosingClass();
            j.o(enclosingClass, "(if (clazz.isEnum) clazz…lse clazz.enclosingClass)");
            a.i.b.a.c.f.a bb = a.i.b.a.e.b.bb(enclosingClass);
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.Enum<*>");
                AppMethodBeat.o(119025);
                throw vVar;
            }
            f avX = f.avX(((Enum) obj).name());
            j.o(avX, "Name.identifier((value as Enum<*>).name)");
            aVar.a(fVar, bb, avX);
            AppMethodBeat.o(119025);
        } else if (Annotation.class.isAssignableFrom(cls)) {
            Class[] interfaces = cls.getInterfaces();
            j.o(interfaces, "clazz.interfaces");
            Class cls2 = (Class) i.O(interfaces);
            j.o(cls2, "annotationClass");
            n.a a = aVar.a(fVar, a.i.b.a.e.b.bb(cls2));
            if (a == null) {
                AppMethodBeat.o(119025);
            } else if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.Annotation");
                AppMethodBeat.o(119025);
                throw vVar;
            } else {
                a(a, (Annotation) obj, cls2);
                AppMethodBeat.o(119025);
            }
        } else if (cls.isArray()) {
            a.i.b.a.c.d.b.n.b o = aVar.o(fVar);
            if (o == null) {
                AppMethodBeat.o(119025);
                return;
            }
            cls = cls.getComponentType();
            j.o(cls, "componentType");
            int length;
            if (cls.isEnum()) {
                a.i.b.a.c.f.a bb2 = a.i.b.a.e.b.bb(cls);
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type kotlin.Array<*>");
                    AppMethodBeat.o(119025);
                    throw vVar;
                }
                for (Object enclosingClass2 : (Object[]) obj) {
                    if (enclosingClass2 == null) {
                        vVar = new v("null cannot be cast to non-null type kotlin.Enum<*>");
                        AppMethodBeat.o(119025);
                        throw vVar;
                    }
                    f avX2 = f.avX(((Enum) enclosingClass2).name());
                    j.o(avX2, "Name.identifier((element as Enum<*>).name)");
                    o.a(bb2, avX2);
                }
            } else if (j.j(cls, Class.class)) {
                if (obj == null) {
                    vVar = new v("null cannot be cast to non-null type kotlin.Array<*>");
                    AppMethodBeat.o(119025);
                    throw vVar;
                }
                for (Object enclosingClass22 : (Object[]) obj) {
                    if (enclosingClass22 == null) {
                        vVar = new v("null cannot be cast to non-null type java.lang.Class<*>");
                        AppMethodBeat.o(119025);
                        throw vVar;
                    }
                    o.a(aU((Class) enclosingClass22));
                }
            } else if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.Array<*>");
                AppMethodBeat.o(119025);
                throw vVar;
            } else {
                Object[] objArr = (Object[]) obj;
                length = objArr.length;
                while (i < length) {
                    o.dG(objArr[i]);
                    i++;
                }
            }
            o.zn();
            AppMethodBeat.o(119025);
        } else {
            Throwable unsupportedOperationException = new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            AppMethodBeat.o(119025);
            throw unsupportedOperationException;
        }
    }
}
