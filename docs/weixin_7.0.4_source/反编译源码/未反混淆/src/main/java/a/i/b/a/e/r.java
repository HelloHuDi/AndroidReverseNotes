package a.i.b.a.e;

import a.a.i;
import a.a.t;
import a.f.b.j;
import a.i.b.a.c.b.az;
import a.i.b.a.c.d.a.e.g;
import a.i.b.a.c.d.a.e.p;
import a.i.b.a.c.d.a.e.y;
import a.i.b.a.c.f.b;
import a.i.b.a.c.f.f;
import a.i.b.a.c.f.h;
import a.i.b.a.e.t.a;
import a.l;
import a.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J=\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\"0\"2\u0006\u0010&\u001a\u00020\u001bH\u0004¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006+"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaMember;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationOwner;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaMember;", "()V", "containingClass", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "getContainingClass", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaClass;", "element", "Ljava/lang/reflect/AnnotatedElement;", "getElement", "()Ljava/lang/reflect/AnnotatedElement;", "member", "Ljava/lang/reflect/Member;", "getMember", "()Ljava/lang/reflect/Member;", "modifiers", "", "getModifiers", "()I", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "equals", "", "other", "", "getValueParameters", "", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "isVararg", "([Ljava/lang/reflect/Type;[[Ljava/lang/annotation/Annotation;Z)Ljava/util/List;", "hashCode", "toString", "", "descriptors.runtime"})
public abstract class r extends n implements p, f, t {
    public abstract Member dXw();

    public final az dYf() {
        return a.d(this);
    }

    public final boolean ebX() {
        return a.a(this);
    }

    public final boolean ebY() {
        return a.c(this);
    }

    public final boolean isStatic() {
        return a.b(this);
    }

    public final /* synthetic */ a.i.b.a.c.d.a.e.a m(b bVar) {
        j.p(bVar, "fqName");
        return f.a.a(this, bVar);
    }

    public final AnnotatedElement ekH() {
        Member dXw = dXw();
        if (dXw != null) {
            return (AnnotatedElement) dXw;
        }
        throw new v("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }

    public final int getModifiers() {
        return dXw().getModifiers();
    }

    public final f dZg() {
        String name = dXw().getName();
        if (name != null) {
            return f.avX(name);
        }
        f fVar = h.Bzc;
        j.o(fVar, "SpecialNames.NO_NAME_PROVIDED");
        return fVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<y> a(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        j.p(typeArr, "parameterTypes");
        j.p(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        a aVar = a.BNJ;
        List b = a.b(dXw());
        int size = b != null ? b.size() - typeArr.length : 0;
        int length = typeArr.length;
        int i = 0;
        while (i < length) {
            String str;
            boolean z2;
            w.a aVar2 = w.BOj;
            w b2 = w.a.b(typeArr[i]);
            if (b != null) {
                String str2 = (String) t.x(b, i + size);
                if (str2 == null) {
                    throw new IllegalStateException(("No parameter with index " + i + '+' + size + " (name=" + dZg() + " type=" + b2 + ") in " + b + "@ReflectJavaMember").toString());
                }
                str = str2;
            } else {
                str = null;
            }
            if (z && i == i.P(typeArr)) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new y(b2, annotationArr[i], str, z2));
            i++;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && j.j(dXw(), ((r) obj).dXw());
    }

    public int hashCode() {
        return dXw().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + dXw();
    }

    public final /* synthetic */ g ebU() {
        Class declaringClass = dXw().getDeclaringClass();
        j.o(declaringClass, "member.declaringClass");
        return new j(declaringClass);
    }

    public final /* synthetic */ Collection ebC() {
        return f.a.a(this);
    }
}
