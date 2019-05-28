package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C31674y;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44887q;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p049e.C31793w.C25256a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMethod;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMethod;", "member", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "hasAnnotationParameterDefaultValue", "", "getHasAnnotationParameterDefaultValue", "()Z", "getMember", "()Ljava/lang/reflect/Method;", "returnType", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReturnType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "typeParameters", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "getTypeParameters", "()Ljava/util/List;", "valueParameters", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "getValueParameters", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.s */
public final class C46868s extends C17334r implements C44887q {
    public final Method BOh;

    public C46868s(Method method) {
        C25052j.m39376p(method, "member");
        AppMethodBeat.m2504i(123103);
        this.BOh = method;
        AppMethodBeat.m2505o(123103);
    }

    public final List<C31674y> dYV() {
        AppMethodBeat.m2504i(123099);
        Type[] genericParameterTypes = this.BOh.getGenericParameterTypes();
        C25052j.m39375o(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = this.BOh.getParameterAnnotations();
        C25052j.m39375o(parameterAnnotations, "member.parameterAnnotations");
        List a = mo31405a(genericParameterTypes, parameterAnnotations, this.BOh.isVarArgs());
        AppMethodBeat.m2505o(123099);
        return a;
    }

    public final /* synthetic */ C8118v ebV() {
        AppMethodBeat.m2504i(123100);
        C25256a c25256a = C31793w.BOj;
        Type genericReturnType = this.BOh.getGenericReturnType();
        C25052j.m39375o(genericReturnType, "member.genericReturnType");
        C8118v b = C25256a.m39831b(genericReturnType);
        AppMethodBeat.m2505o(123100);
        return b;
    }

    public final boolean ebW() {
        AppMethodBeat.m2504i(123101);
        if (this.BOh.getDefaultValue() != null) {
            AppMethodBeat.m2505o(123101);
            return true;
        }
        AppMethodBeat.m2505o(123101);
        return false;
    }

    public final List<C25257x> dYS() {
        AppMethodBeat.m2504i(123102);
        TypeVariable[] typeParameters = this.BOh.getTypeParameters();
        C25052j.m39375o(typeParameters, "member.typeParameters");
        Collection arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable c25257x : typeParameters) {
            arrayList.add(new C25257x(c25257x));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(123102);
        return list;
    }

    public final /* bridge */ /* synthetic */ Member dXw() {
        return this.BOh;
    }
}
