package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25034m;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36984i;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44886j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p049e.C31793w.C25256a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifierType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "annotations", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotation;", "getAnnotations", "()Ljava/util/Collection;", "classifier", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaClassifier;", "getClassifier", "()Lorg/jetbrains/kotlin/load/java/structure/JavaClassifier;", "classifierQualifiedName", "", "getClassifierQualifiedName", "()Ljava/lang/String;", "isDeprecatedInJavaDoc", "", "()Z", "isRaw", "presentableText", "getPresentableText", "getReflectType", "()Ljava/lang/reflect/Type;", "typeArguments", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaType;", "getTypeArguments", "()Ljava/util/List;", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.l */
public final class C36660l extends C31793w implements C44886j {
    final Type BNU;
    private final C36984i BOd;

    public C36660l(Type type) {
        C36984i c25250j;
        C25052j.m39376p(type, "reflectType");
        AppMethodBeat.m2504i(123088);
        this.BNU = type;
        Type type2 = this.BNU;
        if (type2 instanceof Class) {
            c25250j = new C25250j((Class) type2);
        } else if (type2 instanceof TypeVariable) {
            c25250j = new C25257x((TypeVariable) type2);
        } else if (type2 instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type2).getRawType();
            if (type2 == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type java.lang.Class<*>");
                AppMethodBeat.m2505o(123088);
                throw c44941v;
            }
            c25250j = new C25250j((Class) type2);
        } else {
            Throwable illegalStateException = new IllegalStateException("Not a classifier type (" + type2.getClass() + "): " + type2);
            AppMethodBeat.m2505o(123088);
            throw illegalStateException;
        }
        this.BOd = c25250j;
        AppMethodBeat.m2505o(123088);
    }

    public final Type ekI() {
        return this.BNU;
    }

    public final C36984i ebL() {
        return this.BOd;
    }

    public final String ebO() {
        AppMethodBeat.m2504i(123083);
        Throwable unsupportedOperationException = new UnsupportedOperationException("Type not found: " + this.BNU);
        AppMethodBeat.m2505o(123083);
        throw unsupportedOperationException;
    }

    /* renamed from: m */
    public final C41408a mo18057m(C8174b c8174b) {
        AppMethodBeat.m2504i(123087);
        C25052j.m39376p(c8174b, "fqName");
        AppMethodBeat.m2505o(123087);
        return null;
    }

    public final String ebP() {
        AppMethodBeat.m2504i(123084);
        String obj = this.BNU.toString();
        AppMethodBeat.m2505o(123084);
        return obj;
    }

    public final boolean ebN() {
        AppMethodBeat.m2504i(123085);
        Type type = this.BNU;
        if (type instanceof Class) {
            TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
            C25052j.m39375o(typeParameters, "getTypeParameters()");
            if (((typeParameters.length == 0 ? 1 : null) == null ? 1 : null) != null) {
                AppMethodBeat.m2505o(123085);
                return true;
            }
        }
        AppMethodBeat.m2505o(123085);
        return false;
    }

    public final List<C8118v> ebM() {
        AppMethodBeat.m2504i(123086);
        Iterable<Type> a = C37076b.m62031a(this.BNU);
        Collection arrayList = new ArrayList(C25034m.m39318d(a));
        for (Type b : a) {
            arrayList.add(C25256a.m39831b(b));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(123086);
        return list;
    }

    public final Collection<C41408a> ebC() {
        return C17115v.AUP;
    }
}
