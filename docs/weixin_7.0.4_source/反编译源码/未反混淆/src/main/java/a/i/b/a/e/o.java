package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.m;
import a.i.b.a.c.f.a;
import a.i.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaEnumValueAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaEnumValueAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/Enum;)V", "entryName", "getEntryName", "()Lorg/jetbrains/kotlin/name/Name;", "enumClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getEnumClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "descriptors.runtime"})
public final class o extends d implements m {
    private final Enum<?> BOf;

    public o(f fVar, Enum<?> enumR) {
        j.p(enumR, "value");
        super(fVar);
        AppMethodBeat.i(123094);
        this.BOf = enumR;
        AppMethodBeat.o(123094);
    }

    public final a ebQ() {
        AppMethodBeat.i(123092);
        Object obj = this.BOf.getClass();
        if (!obj.isEnum()) {
            obj = obj.getEnclosingClass();
        }
        j.o(obj, "enumClass");
        a bb = b.bb(obj);
        AppMethodBeat.o(123092);
        return bb;
    }

    public final f ebR() {
        AppMethodBeat.i(123093);
        f avX = f.avX(this.BOf.name());
        AppMethodBeat.o(123093);
        return avX;
    }
}
