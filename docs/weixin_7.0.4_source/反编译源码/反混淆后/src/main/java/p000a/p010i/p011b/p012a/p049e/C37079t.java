package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C8051ay;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.C36989n;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C41411r;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaModifierListOwner;", "isAbstract", "", "()Z", "isFinal", "isStatic", "modifiers", "", "getModifiers", "()I", "visibility", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "getVisibility", "()Lorg/jetbrains/kotlin/descriptors/Visibility;", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.t */
public interface C37079t extends C41411r {

    @C0220l(dWo = {1, 1, 13})
    /* renamed from: a.i.b.a.e.t$a */
    public static final class C0179a {
        /* renamed from: a */
        public static boolean m296a(C37079t c37079t) {
            AppMethodBeat.m2504i(123104);
            boolean isAbstract = Modifier.isAbstract(c37079t.getModifiers());
            AppMethodBeat.m2505o(123104);
            return isAbstract;
        }

        /* renamed from: b */
        public static boolean m297b(C37079t c37079t) {
            AppMethodBeat.m2504i(123105);
            boolean isStatic = Modifier.isStatic(c37079t.getModifiers());
            AppMethodBeat.m2505o(123105);
            return isStatic;
        }

        /* renamed from: c */
        public static boolean m298c(C37079t c37079t) {
            AppMethodBeat.m2504i(123106);
            boolean isFinal = Modifier.isFinal(c37079t.getModifiers());
            AppMethodBeat.m2505o(123106);
            return isFinal;
        }

        /* renamed from: d */
        public static C25082az m299d(C37079t c37079t) {
            AppMethodBeat.m2504i(123107);
            int modifiers = c37079t.getModifiers();
            C25082az c25082az;
            if (Modifier.isPublic(modifiers)) {
                c25082az = C8051ay.Bfa;
                C25052j.m39375o(c25082az, "Visibilities.PUBLIC");
                AppMethodBeat.m2505o(123107);
                return c25082az;
            } else if (Modifier.isPrivate(modifiers)) {
                c25082az = C8051ay.BeW;
                C25052j.m39375o(c25082az, "Visibilities.PRIVATE");
                AppMethodBeat.m2505o(123107);
                return c25082az;
            } else if (Modifier.isProtected(modifiers)) {
                if (Modifier.isStatic(modifiers)) {
                    c25082az = C36989n.Blh;
                } else {
                    c25082az = C36989n.Bli;
                }
                C25052j.m39375o(c25082az, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
                AppMethodBeat.m2505o(123107);
                return c25082az;
            } else {
                c25082az = C36989n.Blg;
                C25052j.m39375o(c25082az, "JavaVisibilities.PACKAGE_VISIBILITY");
                AppMethodBeat.m2505o(123107);
                return c25082az;
            }
        }
    }

    int getModifiers();
}
