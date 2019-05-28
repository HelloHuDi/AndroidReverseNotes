package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.q;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.c.d.a.e.y;
import a.i.b.a.e.w.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMethod;", "member", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "hasAnnotationParameterDefaultValue", "", "getHasAnnotationParameterDefaultValue", "()Z", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReturnType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
public final class s extends r implements q {
    public final Method BOh;

    public s(Method method) {
        j.p(method, "member");
        AppMethodBeat.i(123103);
        this.BOh = method;
        AppMethodBeat.o(123103);
    }

    public final List<y> dYV() {
        AppMethodBeat.i(123099);
        Type[] genericParameterTypes = this.BOh.getGenericParameterTypes();
        j.o(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = this.BOh.getParameterAnnotations();
        j.o(parameterAnnotations, "member.parameterAnnotations");
        List a = a(genericParameterTypes, parameterAnnotations, this.BOh.isVarArgs());
        AppMethodBeat.o(123099);
        return a;
    }

    public final /* synthetic */ v ebV() {
        AppMethodBeat.i(123100);
        a aVar = w.BOj;
        Type genericReturnType = this.BOh.getGenericReturnType();
        j.o(genericReturnType, "member.genericReturnType");
        v b = a.b(genericReturnType);
        AppMethodBeat.o(123100);
        return b;
    }

    public final boolean ebW() {
        AppMethodBeat.i(123101);
        if (this.BOh.getDefaultValue() != null) {
            AppMethodBeat.o(123101);
            return true;
        }
        AppMethodBeat.o(123101);
        return false;
    }

    public final List<x> dYS() {
        AppMethodBeat.i(123102);
        TypeVariable[] typeParameters = this.BOh.getTypeParameters();
        j.o(typeParameters, "member.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable xVar : typeParameters) {
            arrayList.add(new x(xVar));
        }
        List list = (List) arrayList;
        AppMethodBeat.o(123102);
        return list;
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return this.BOh;
    }
}
