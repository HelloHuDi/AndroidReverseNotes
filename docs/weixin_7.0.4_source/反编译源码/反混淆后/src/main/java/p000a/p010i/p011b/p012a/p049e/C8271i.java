package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C25114f;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p049e.C31793w.C25256a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayType;", "reflectType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "componentType", "getComponentType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "getReflectType", "()Ljava/lang/reflect/Type;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.i */
public final class C8271i extends C31793w implements C25114f {
    private final C31793w BNT;
    private final Type BNU;

    public C8271i(Type type) {
        C31793w b;
        C25052j.m39376p(type, "reflectType");
        AppMethodBeat.m2504i(123039);
        this.BNU = type;
        Type type2 = this.BNU;
        if (type2 instanceof GenericArrayType) {
            type2 = ((GenericArrayType) type2).getGenericComponentType();
            C25052j.m39375o(type2, "genericComponentType");
            b = C25256a.m39831b(type2);
        } else if ((type2 instanceof Class) && ((Class) type2).isArray()) {
            Class componentType = ((Class) type2).getComponentType();
            C25052j.m39375o(componentType, "getComponentType()");
            b = C25256a.m39831b(componentType);
        } else {
            Throwable illegalArgumentException = new IllegalArgumentException("Not an array type (" + this.BNU.getClass() + "): " + this.BNU);
            AppMethodBeat.m2505o(123039);
            throw illegalArgumentException;
        }
        this.BNT = b;
        AppMethodBeat.m2505o(123039);
    }

    /* Access modifiers changed, original: protected|final */
    public final Type ekI() {
        return this.BNU;
    }

    public final /* bridge */ /* synthetic */ C8118v ebE() {
        return this.BNT;
    }
}
