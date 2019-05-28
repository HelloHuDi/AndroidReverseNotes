package a.i.b.a.e;

import a.a.h;
import a.a.v;
import a.f.b.j;
import a.i.b.a.c.d.a.e.k;
import a.i.b.a.c.d.a.e.y;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaConstructor;", "member", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getMember", "()Ljava/lang/reflect/Constructor;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
public final class m extends r implements k {
    public final Constructor<?> BOe;

    public m(Constructor<?> constructor) {
        j.p(constructor, "member");
        AppMethodBeat.i(123091);
        this.BOe = constructor;
        AppMethodBeat.o(123091);
    }

    public final List<y> dYV() {
        int i;
        AppMethodBeat.i(123089);
        Object genericParameterTypes = this.BOe.getGenericParameterTypes();
        j.o(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            List list = v.AUP;
            AppMethodBeat.o(123089);
            return list;
        }
        Object obj;
        Class declaringClass = this.BOe.getDeclaringClass();
        j.o(declaringClass, "klass");
        if (declaringClass.getDeclaringClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
            obj = genericParameterTypes;
        } else {
            obj = (Type[]) h.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Object parameterAnnotations = this.BOe.getParameterAnnotations();
        if (((Object[]) parameterAnnotations).length < obj.length) {
            Throwable illegalStateException = new IllegalStateException("Illegal generic signature: " + this.BOe);
            AppMethodBeat.o(123089);
            throw illegalStateException;
        }
        if (((Object[]) parameterAnnotations).length > obj.length) {
            j.o(parameterAnnotations, "annotations");
            genericParameterTypes = (Annotation[][]) h.copyOfRange((Object[]) parameterAnnotations, ((Object[]) parameterAnnotations).length - obj.length, ((Object[]) parameterAnnotations).length);
        } else {
            genericParameterTypes = parameterAnnotations;
        }
        j.o(obj, "realTypes");
        j.o(genericParameterTypes, "realAnnotations");
        List<y> a = a(obj, genericParameterTypes, this.BOe.isVarArgs());
        AppMethodBeat.o(123089);
        return a;
    }

    public final List<x> dYS() {
        AppMethodBeat.i(123090);
        TypeVariable[] typeParameters = this.BOe.getTypeParameters();
        j.o(typeParameters, "member.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable xVar : typeParameters) {
            arrayList.add(new x(xVar));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(123090);
        return list;
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return this.BOe;
    }
}
