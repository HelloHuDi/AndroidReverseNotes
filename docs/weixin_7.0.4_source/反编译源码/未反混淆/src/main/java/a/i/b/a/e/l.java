package a.i.b.a.e;

import a.a.m;
import a.i.b.a.c.d.a.e.a;
import a.i.b.a.c.d.a.e.i;
import a.i.b.a.c.d.a.e.j;
import a.i.b.a.c.f.b;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/Collection;", "classifier", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifier;", "getClassifier", "()Lorg/jetbrains/kotlin/load/java/structure/JavaClassifier;", "classifierQualifiedName", "", "getClassifierQualifiedName", "()Ljava/lang/String;", "isDeprecatedInJavaDoc", "", "()Z", "isRaw", "presentableText", "getPresentableText", "getReflectType", "()Ljava/lang/reflect/Type;", "typeArguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "getTypeArguments", "()Ljava/util/List;", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"})
public final class l extends w implements j {
    final Type BNU;
    private final i BOd;

    public l(Type type) {
        i jVar;
        a.f.b.j.p(type, "reflectType");
        AppMethodBeat.i(123088);
        this.BNU = type;
        Type type2 = this.BNU;
        if (type2 instanceof Class) {
            jVar = new j((Class) type2);
        } else if (type2 instanceof TypeVariable) {
            jVar = new x((TypeVariable) type2);
        } else if (type2 instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type2).getRawType();
            if (type2 == null) {
                v vVar = new v("null cannot be cast to non-null type java.lang.Class<*>");
                AppMethodBeat.o(123088);
                throw vVar;
            }
            jVar = new j((Class) type2);
        } else {
            Throwable illegalStateException = new IllegalStateException("Not a classifier type (" + type2.getClass() + "): " + type2);
            AppMethodBeat.o(123088);
            throw illegalStateException;
        }
        this.BOd = jVar;
        AppMethodBeat.o(123088);
    }

    public final Type ekI() {
        return this.BNU;
    }

    public final i ebL() {
        return this.BOd;
    }

    public final String ebO() {
        AppMethodBeat.i(123083);
        Throwable unsupportedOperationException = new UnsupportedOperationException("Type not found: " + this.BNU);
        AppMethodBeat.o(123083);
        throw unsupportedOperationException;
    }

    public final a m(b bVar) {
        AppMethodBeat.i(123087);
        a.f.b.j.p(bVar, "fqName");
        AppMethodBeat.o(123087);
        return null;
    }

    public final String ebP() {
        AppMethodBeat.i(123084);
        String obj = this.BNU.toString();
        AppMethodBeat.o(123084);
        return obj;
    }

    public final boolean ebN() {
        AppMethodBeat.i(123085);
        Type type = this.BNU;
        if (type instanceof Class) {
            TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
            a.f.b.j.o(typeParameters, "getTypeParameters()");
            if (((typeParameters.length == 0 ? 1 : null) == null ? 1 : null) != null) {
                AppMethodBeat.o(123085);
                return true;
            }
        }
        AppMethodBeat.o(123085);
        return false;
    }

    public final List<a.i.b.a.c.d.a.e.v> ebM() {
        AppMethodBeat.i(123086);
        Iterable<Type> a = b.a(this.BNU);
        Collection arrayList = new ArrayList(m.d(a));
        for (Type b : a) {
            arrayList.add(w.a.b(b));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(123086);
        return list;
    }

    public final Collection<a> ebC() {
        return a.a.v.AUP;
    }
}
