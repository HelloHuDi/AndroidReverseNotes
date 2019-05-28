package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p016a.C31622h;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C0061u;
import p000a.p010i.p011b.p012a.p015c.p037i.p1366d.C25176c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaPrimitiveType;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaPrimitiveType;", "reflectType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getReflectType", "()Ljava/lang/Class;", "type", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "getType", "()Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.v */
public final class C36662v extends C31793w implements C0061u {
    private final Class<?> BOi;

    public C36662v(Class<?> cls) {
        C25052j.m39376p(cls, "reflectType");
        AppMethodBeat.m2504i(123115);
        this.BOi = cls;
        AppMethodBeat.m2505o(123115);
    }

    public final C31622h eca() {
        AppMethodBeat.m2504i(123114);
        if (C25052j.m39373j(this.BOi, Void.TYPE)) {
            AppMethodBeat.m2505o(123114);
            return null;
        }
        C25176c awk = C25176c.awk(this.BOi.getName());
        C25052j.m39375o(awk, "JvmPrimitiveType.get(reflectType.name)");
        C31622h c31622h = awk.BFq;
        AppMethodBeat.m2505o(123114);
        return c31622h;
    }

    public final /* bridge */ /* synthetic */ Type ekI() {
        return this.BOi;
    }
}
