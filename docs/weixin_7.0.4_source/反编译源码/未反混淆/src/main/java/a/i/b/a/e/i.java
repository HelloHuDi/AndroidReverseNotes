package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.f;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.e.w.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "componentType", "getComponentType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReflectType", "()Ljava/lang/reflect/Type;", "descriptors.runtime"})
public final class i extends w implements f {
    private final w BNT;
    private final Type BNU;

    public i(Type type) {
        w b;
        j.p(type, "reflectType");
        AppMethodBeat.i(123039);
        this.BNU = type;
        Type type2 = this.BNU;
        if (type2 instanceof GenericArrayType) {
            type2 = ((GenericArrayType) type2).getGenericComponentType();
            j.o(type2, "genericComponentType");
            b = a.b(type2);
        } else if ((type2 instanceof Class) && ((Class) type2).isArray()) {
            Class componentType = ((Class) type2).getComponentType();
            j.o(componentType, "getComponentType()");
            b = a.b(componentType);
        } else {
            Throwable illegalArgumentException = new IllegalArgumentException("Not an array type (" + this.BNU.getClass() + "): " + this.BNU);
            AppMethodBeat.o(123039);
            throw illegalArgumentException;
        }
        this.BNT = b;
        AppMethodBeat.o(123039);
    }

    /* Access modifiers changed, original: protected|final */
    public final Type ekI() {
        return this.BNU;
    }

    public final /* bridge */ /* synthetic */ v ebE() {
        return this.BNT;
    }
}
