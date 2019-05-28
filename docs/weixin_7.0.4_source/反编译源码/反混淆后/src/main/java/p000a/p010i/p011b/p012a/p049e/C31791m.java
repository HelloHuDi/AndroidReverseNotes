package p000a.p010i.p011b.p012a.p049e;

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
import p000a.C0220l;
import p000a.p001a.C17115v;
import p000a.p001a.C36646h;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C31674y;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8115k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0010"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaConstructor;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaConstructor;", "member", "Ljava/lang/reflect/Constructor;", "(Ljava/lang/reflect/Constructor;)V", "getMember", "()Ljava/lang/reflect/Constructor;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.m */
public final class C31791m extends C17334r implements C8115k {
    public final Constructor<?> BOe;

    public C31791m(Constructor<?> constructor) {
        C25052j.m39376p(constructor, "member");
        AppMethodBeat.m2504i(123091);
        this.BOe = constructor;
        AppMethodBeat.m2505o(123091);
    }

    public final List<C31674y> dYV() {
        int i;
        AppMethodBeat.m2504i(123089);
        Object genericParameterTypes = this.BOe.getGenericParameterTypes();
        C25052j.m39375o(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            List list = C17115v.AUP;
            AppMethodBeat.m2505o(123089);
            return list;
        }
        Object obj;
        Class declaringClass = this.BOe.getDeclaringClass();
        C25052j.m39375o(declaringClass, "klass");
        if (declaringClass.getDeclaringClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
            obj = genericParameterTypes;
        } else {
            obj = (Type[]) C36646h.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Object parameterAnnotations = this.BOe.getParameterAnnotations();
        if (((Object[]) parameterAnnotations).length < obj.length) {
            Throwable illegalStateException = new IllegalStateException("Illegal generic signature: " + this.BOe);
            AppMethodBeat.m2505o(123089);
            throw illegalStateException;
        }
        if (((Object[]) parameterAnnotations).length > obj.length) {
            C25052j.m39375o(parameterAnnotations, "annotations");
            genericParameterTypes = (Annotation[][]) C36646h.copyOfRange((Object[]) parameterAnnotations, ((Object[]) parameterAnnotations).length - obj.length, ((Object[]) parameterAnnotations).length);
        } else {
            genericParameterTypes = parameterAnnotations;
        }
        C25052j.m39375o(obj, "realTypes");
        C25052j.m39375o(genericParameterTypes, "realAnnotations");
        List<C31674y> a = mo31405a(obj, genericParameterTypes, this.BOe.isVarArgs());
        AppMethodBeat.m2505o(123089);
        return a;
    }

    public final List<C25257x> dYS() {
        AppMethodBeat.m2504i(123090);
        TypeVariable[] typeParameters = this.BOe.getTypeParameters();
        C25052j.m39375o(typeParameters, "member.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable c25257x : typeParameters) {
            arrayList.add(new C25257x(c25257x));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(123090);
        return list;
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return this.BOe;
    }
}
