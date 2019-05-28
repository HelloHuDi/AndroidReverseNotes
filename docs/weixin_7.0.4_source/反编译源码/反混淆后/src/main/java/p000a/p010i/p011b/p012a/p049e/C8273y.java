package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.Collection;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C31674y;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41408a;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C8118v;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;
import p000a.p010i.p011b.p012a.p015c.p778f.C8174b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaValueParameter;", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaElement;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaValueParameter;", "type", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "reflectAnnotations", "", "", "reflectName", "", "isVararg", "", "(Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;[Ljava/lang/annotation/Annotation;Ljava/lang/String;Z)V", "annotations", "", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotation;", "getAnnotations", "()Ljava/util/List;", "isDeprecatedInJavaDoc", "()Z", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "[Ljava/lang/annotation/Annotation;", "getType", "()Lkotlin/reflect/jvm/internal/structure/ReflectJavaType;", "findAnnotation", "fqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "toString", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.y */
public final class C8273y extends C31792n implements C31674y {
    private final C31793w BOl;
    private final Annotation[] BOm;
    private final String BOn;
    private final boolean BOo;

    /* renamed from: m */
    public final /* synthetic */ C41408a mo18057m(C8174b c8174b) {
        AppMethodBeat.m2504i(123126);
        C25052j.m39376p(c8174b, "fqName");
        C41408a a = C8270g.m14594a(this.BOm, c8174b);
        AppMethodBeat.m2505o(123126);
        return a;
    }

    public final boolean ecc() {
        return this.BOo;
    }

    public C8273y(C31793w c31793w, Annotation[] annotationArr, String str, boolean z) {
        C25052j.m39376p(c31793w, "type");
        C25052j.m39376p(annotationArr, "reflectAnnotations");
        AppMethodBeat.m2504i(123129);
        this.BOl = c31793w;
        this.BOm = annotationArr;
        this.BOn = str;
        this.BOo = z;
        AppMethodBeat.m2505o(123129);
    }

    public final C37022f dZg() {
        AppMethodBeat.m2504i(123127);
        String str = this.BOn;
        if (str != null) {
            C37022f awa = C37022f.awa(str);
            AppMethodBeat.m2505o(123127);
            return awa;
        }
        AppMethodBeat.m2505o(123127);
        return null;
    }

    public final String toString() {
        String str;
        AppMethodBeat.m2504i(123128);
        StringBuilder append = new StringBuilder().append(getClass().getName()).append(": ");
        if (this.BOo) {
            str = "vararg ";
        } else {
            str = "";
        }
        str = append.append(str).append(dZg()).append(": ").append(this.BOl).toString();
        AppMethodBeat.m2505o(123128);
        return str;
    }

    public final /* synthetic */ Collection ebC() {
        AppMethodBeat.m2504i(123125);
        Collection a = C8270g.m14595a(this.BOm);
        AppMethodBeat.m2505o(123125);
        return a;
    }

    public final /* bridge */ /* synthetic */ C8118v ebT() {
        return this.BOl;
    }
}
