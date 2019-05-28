package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.a.h;
import a.i.b.a.c.d.a.e.u;
import a.i.b.a.c.i.d.c;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPrimitiveType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPrimitiveType;", "reflectType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getReflectType", "()Ljava/lang/Class;", "type", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getType", "()Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "descriptors.runtime"})
public final class v extends w implements u {
    private final Class<?> BOi;

    public v(Class<?> cls) {
        j.p(cls, "reflectType");
        AppMethodBeat.i(123115);
        this.BOi = cls;
        AppMethodBeat.o(123115);
    }

    public final h eca() {
        AppMethodBeat.i(123114);
        if (j.j(this.BOi, Void.TYPE)) {
            AppMethodBeat.o(123114);
            return null;
        }
        c awk = c.awk(this.BOi.getName());
        j.o(awk, "JvmPrimitiveType.get(reflectType.name)");
        h hVar = awk.BFq;
        AppMethodBeat.o(123114);
        return hVar;
    }

    public final /* bridge */ /* synthetic */ Type ekI() {
        return this.BOi;
    }
}
