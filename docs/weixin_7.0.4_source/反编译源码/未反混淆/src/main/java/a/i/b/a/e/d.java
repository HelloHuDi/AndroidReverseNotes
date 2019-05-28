package a.i.b.a.e;

import a.f.b.j;
import a.i.b.a.c.d.a.e.b;
import a.i.b.a.c.f.f;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "(Lorg/jetbrains/kotlin/name/Name;)V", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "Factory", "descriptors.runtime"})
public abstract class d implements b {
    public static final a BNS = new a();
    private final f BgZ;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "value", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "descriptors.runtime"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static d a(Object obj, f fVar) {
            AppMethodBeat.i(123030);
            j.p(obj, "value");
            d oVar;
            if (b.aY(obj.getClass())) {
                oVar = new o(fVar, (Enum) obj);
                AppMethodBeat.o(123030);
                return oVar;
            } else if (obj instanceof Annotation) {
                oVar = new e(fVar, (Annotation) obj);
                AppMethodBeat.o(123030);
                return oVar;
            } else if (obj instanceof Object[]) {
                oVar = new h(fVar, (Object[]) obj);
                AppMethodBeat.o(123030);
                return oVar;
            } else if (obj instanceof Class) {
                oVar = new k(fVar, (Class) obj);
                AppMethodBeat.o(123030);
                return oVar;
            } else {
                oVar = new q(fVar, obj);
                AppMethodBeat.o(123030);
                return oVar;
            }
        }
    }

    public d(f fVar) {
        this.BgZ = fVar;
    }

    public final f dZg() {
        return this.BgZ;
    }
}
