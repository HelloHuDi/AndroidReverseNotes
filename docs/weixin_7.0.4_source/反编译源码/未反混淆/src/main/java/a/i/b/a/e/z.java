package a.i.b.a.e;

import a.a.i;
import a.f.b.j;
import a.i.b.a.c.d.a.e.v;
import a.i.b.a.e.w.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaWildcardType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaWildcardType;", "reflectType", "Ljava/lang/reflect/WildcardType;", "(Ljava/lang/reflect/WildcardType;)V", "bound", "getBound", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "isExtends", "", "()Z", "getReflectType", "()Ljava/lang/reflect/WildcardType;", "descriptors.runtime"})
public final class z extends w implements a.i.b.a.c.d.a.e.z {
    private final WildcardType BOp;

    public z(WildcardType wildcardType) {
        j.p(wildcardType, "reflectType");
        AppMethodBeat.i(123132);
        this.BOp = wildcardType;
        AppMethodBeat.o(123132);
    }

    public final /* synthetic */ v ecd() {
        AppMethodBeat.i(123130);
        Type[] upperBounds = this.BOp.getUpperBounds();
        Type[] lowerBounds = this.BOp.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            Throwable unsupportedOperationException = new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + this.BOp);
            AppMethodBeat.o(123130);
            throw unsupportedOperationException;
        }
        w b;
        if (lowerBounds.length == 1) {
            j.o(lowerBounds, "lowerBounds");
            Object O = i.O(lowerBounds);
            j.o(O, "lowerBounds.single()");
            b = a.b((Type) O);
        } else if (upperBounds.length == 1) {
            j.o(upperBounds, "upperBounds");
            Type type = (Type) i.O(upperBounds);
            if ((j.j(type, Object.class) ^ 1) != 0) {
                j.o(type, "ub");
                b = a.b(type);
            } else {
                b = null;
            }
        } else {
            b = null;
        }
        v vVar = b;
        AppMethodBeat.o(123130);
        return vVar;
    }

    public final boolean ece() {
        AppMethodBeat.i(123131);
        Type[] upperBounds = this.BOp.getUpperBounds();
        j.o(upperBounds, "reflectType.upperBounds");
        int j = j.j((Type) i.M(upperBounds), Object.class) ^ 1;
        AppMethodBeat.o(123131);
        return j;
    }

    public final /* bridge */ /* synthetic */ Type ekI() {
        return this.BOp;
    }
}
