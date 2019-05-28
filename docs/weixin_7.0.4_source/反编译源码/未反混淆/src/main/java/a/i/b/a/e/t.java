package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.d.a.e.r;
import a.i.b.a.c.d.a.n;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaModifierListOwner;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaModifierListOwner;", "isAbstract", "", "()Z", "isFinal", "isStatic", "modifiers", "", "getModifiers", "()I", "visibility", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "getVisibility", "()Lorg/jetbrains/kotlin/descriptors/Visibility;", "descriptors.runtime"})
public interface t extends r {

    @l(dWo = {1, 1, 13})
    public static final class a {
        public static boolean a(t tVar) {
            AppMethodBeat.i(123104);
            boolean isAbstract = Modifier.isAbstract(tVar.getModifiers());
            AppMethodBeat.o(123104);
            return isAbstract;
        }

        public static boolean b(t tVar) {
            AppMethodBeat.i(123105);
            boolean isStatic = Modifier.isStatic(tVar.getModifiers());
            AppMethodBeat.o(123105);
            return isStatic;
        }

        public static boolean c(t tVar) {
            AppMethodBeat.i(123106);
            boolean isFinal = Modifier.isFinal(tVar.getModifiers());
            AppMethodBeat.o(123106);
            return isFinal;
        }

        public static az d(t tVar) {
            AppMethodBeat.i(123107);
            int modifiers = tVar.getModifiers();
            az azVar;
            if (Modifier.isPublic(modifiers)) {
                azVar = ay.Bfa;
                j.o(azVar, "Visibilities.PUBLIC");
                AppMethodBeat.o(123107);
                return azVar;
            } else if (Modifier.isPrivate(modifiers)) {
                azVar = ay.BeW;
                j.o(azVar, "Visibilities.PRIVATE");
                AppMethodBeat.o(123107);
                return azVar;
            } else if (Modifier.isProtected(modifiers)) {
                if (Modifier.isStatic(modifiers)) {
                    azVar = n.Blh;
                } else {
                    azVar = n.Bli;
                }
                j.o(azVar, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
                AppMethodBeat.o(123107);
                return azVar;
            } else {
                azVar = n.Blg;
                j.o(azVar, "JavaVisibilities.PACKAGE_VISIBILITY");
                AppMethodBeat.o(123107);
                return azVar;
            }
        }
    }

    int getModifiers();
}
