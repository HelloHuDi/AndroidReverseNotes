package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0062w;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;
import p000a.p010i.p011b.p012a.p049e.C8268f.C8269a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaTypeParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "typeVariable", "Ljava/lang/reflect/TypeVariable;", "(Ljava/lang/reflect/TypeVariable;)V", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "getTypeVariable", "()Ljava/lang/reflect/TypeVariable;", "upperBounds", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClassifierType;", "getUpperBounds", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "toString", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.x */
public final class C25257x extends C31792n implements C0062w, C8268f {
    private final TypeVariable<?> BOk;

    /* renamed from: m */
    public final /* synthetic */ C41408a mo18057m(C8174b c8174b) {
        AppMethodBeat.m2504i(123124);
        C25052j.m39376p(c8174b, "fqName");
        C41408a a = C8269a.m14592a(this, c8174b);
        AppMethodBeat.m2505o(123124);
        return a;
    }

    public C25257x(TypeVariable<?> typeVariable) {
        C25052j.m39376p(typeVariable, "typeVariable");
        AppMethodBeat.m2504i(123122);
        this.BOk = typeVariable;
        AppMethodBeat.m2505o(123122);
    }

    public final AnnotatedElement ekH() {
        TypeVariable typeVariable = this.BOk;
        if (!(typeVariable instanceof AnnotatedElement)) {
            typeVariable = null;
        }
        return (AnnotatedElement) typeVariable;
    }

    public final C37022f dZg() {
        AppMethodBeat.m2504i(123118);
        C37022f avX = C37022f.avX(this.BOk.getName());
        C25052j.m39375o(avX, "Name.identifier(typeVariable.name)");
        AppMethodBeat.m2505o(123118);
        return avX;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(123119);
        if ((obj instanceof C25257x) && C25052j.m39373j(this.BOk, ((C25257x) obj).BOk)) {
            AppMethodBeat.m2505o(123119);
            return true;
        }
        AppMethodBeat.m2505o(123119);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(123120);
        int hashCode = this.BOk.hashCode();
        AppMethodBeat.m2505o(123120);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(123121);
        String str = getClass().getName() + ": " + this.BOk;
        AppMethodBeat.m2505o(123121);
        return str;
    }

    public final /* synthetic */ Collection ecb() {
        Object obj;
        AppMethodBeat.m2504i(123117);
        Type[] bounds = this.BOk.getBounds();
        C25052j.m39375o(bounds, "typeVariable.bounds");
        Collection arrayList = new ArrayList(bounds.length);
        for (Type c36660l : bounds) {
            arrayList.add(new C36660l(c36660l));
        }
        List list = (List) arrayList;
        C36660l c36660l2 = (C36660l) C25035t.m39342fO(list);
        if (c36660l2 != null) {
            obj = c36660l2.BNU;
        } else {
            obj = null;
        }
        if (C25052j.m39373j(obj, Object.class)) {
            list = C17115v.AUP;
        }
        arrayList = list;
        AppMethodBeat.m2505o(123117);
        return arrayList;
    }

    public final /* synthetic */ Collection ebC() {
        AppMethodBeat.m2504i(123123);
        Collection a = C8269a.m14593a(this);
        AppMethodBeat.m2505o(123123);
        return a;
    }
}
