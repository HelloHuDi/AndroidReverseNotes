package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8116m;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8173a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaEnumValueAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaEnumValueAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "value", "", "(Lorg/jetbrains/kotlin/name/Name;Ljava/lang/Enum;)V", "entryName", "getEntryName", "()Lorg/jetbrains/kotlin/name/Name;", "enumClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getEnumClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.o */
public final class C0176o extends C41187d implements C8116m {
    private final Enum<?> BOf;

    public C0176o(C37022f c37022f, Enum<?> enumR) {
        C25052j.m39376p(enumR, "value");
        super(c37022f);
        AppMethodBeat.m2504i(123094);
        this.BOf = enumR;
        AppMethodBeat.m2505o(123094);
    }

    public final C8173a ebQ() {
        AppMethodBeat.m2504i(123092);
        Object obj = this.BOf.getClass();
        if (!obj.isEnum()) {
            obj = obj.getEnclosingClass();
        }
        C25052j.m39375o(obj, "enumClass");
        C8173a bb = C37076b.m62036bb(obj);
        AppMethodBeat.m2505o(123092);
        return bb;
    }

    public final C37022f ebR() {
        AppMethodBeat.m2504i(123093);
        C37022f avX = C37022f.avX(this.BOf.name());
        AppMethodBeat.m2505o(123093);
        return avX;
    }
}
