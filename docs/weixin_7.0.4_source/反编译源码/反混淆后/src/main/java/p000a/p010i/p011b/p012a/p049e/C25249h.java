package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C17188e;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p049e.C41187d.C37078a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0016R\u0014\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaArrayAnnotationArgument;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaArrayAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "values", "", "(Lorg/jetbrains/kotlin/name/Name;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getElements", "", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.h */
public final class C25249h extends C41187d implements C17188e {
    private final Object[] akP;

    public C25249h(C37022f c37022f, Object[] objArr) {
        C25052j.m39376p(objArr, "values");
        super(c37022f);
        AppMethodBeat.m2504i(123038);
        this.akP = objArr;
        AppMethodBeat.m2505o(123038);
    }

    public final List<C41187d> ebD() {
        AppMethodBeat.m2504i(123037);
        Object[] objArr = this.akP;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj == null) {
                C25052j.dWJ();
            }
            arrayList.add(C37078a.m62040a(obj, null));
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(123037);
        return list;
    }
}
