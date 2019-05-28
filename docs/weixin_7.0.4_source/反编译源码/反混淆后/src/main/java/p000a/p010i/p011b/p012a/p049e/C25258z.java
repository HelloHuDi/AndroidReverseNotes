package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C44889z;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p049e.C31793w.C25256a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaWildcardType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaWildcardType;", "reflectType", "Ljava/lang/reflect/WildcardType;", "(Ljava/lang/reflect/WildcardType;)V", "bound", "getBound", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "isExtends", "", "()Z", "getReflectType", "()Ljava/lang/reflect/WildcardType;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.z */
public final class C25258z extends C31793w implements C44889z {
    private final WildcardType BOp;

    public C25258z(WildcardType wildcardType) {
        C25052j.m39376p(wildcardType, "reflectType");
        AppMethodBeat.m2504i(123132);
        this.BOp = wildcardType;
        AppMethodBeat.m2505o(123132);
    }

    public final /* synthetic */ C8118v ecd() {
        AppMethodBeat.m2504i(123130);
        Type[] upperBounds = this.BOp.getUpperBounds();
        Type[] lowerBounds = this.BOp.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            Throwable unsupportedOperationException = new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + this.BOp);
            AppMethodBeat.m2505o(123130);
            throw unsupportedOperationException;
        }
        C31793w b;
        if (lowerBounds.length == 1) {
            C25052j.m39375o(lowerBounds, "lowerBounds");
            Object O = C36913i.m61682O(lowerBounds);
            C25052j.m39375o(O, "lowerBounds.single()");
            b = C25256a.m39831b((Type) O);
        } else if (upperBounds.length == 1) {
            C25052j.m39375o(upperBounds, "upperBounds");
            Type type = (Type) C36913i.m61682O(upperBounds);
            if ((C25052j.m39373j(type, Object.class) ^ 1) != 0) {
                C25052j.m39375o(type, "ub");
                b = C25256a.m39831b(type);
            } else {
                b = null;
            }
        } else {
            b = null;
        }
        C8118v c8118v = b;
        AppMethodBeat.m2505o(123130);
        return c8118v;
    }

    public final boolean ece() {
        AppMethodBeat.m2504i(123131);
        Type[] upperBounds = this.BOp.getUpperBounds();
        C25052j.m39375o(upperBounds, "reflectType.upperBounds");
        int j = C25052j.m39373j((Type) C36913i.m61680M(upperBounds), Object.class) ^ 1;
        AppMethodBeat.m2505o(123131);
        return j;
    }

    public final /* bridge */ /* synthetic */ Type ekI() {
        return this.BOp;
    }
}
