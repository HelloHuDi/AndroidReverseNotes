package p000a.p010i.p011b.p012a.p049e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p023d.p024a.p029e.C36983b;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "Lkotlin/reflect/jvm/internal/impl/load/java/structure/JavaAnnotationArgument;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "(Lorg/jetbrains/kotlin/name/Name;)V", "getName", "()Lorg/jetbrains/kotlin/name/Name;", "Factory", "descriptors.runtime"})
/* renamed from: a.i.b.a.e.d */
public abstract class C41187d implements C36983b {
    public static final C37078a BNS = new C37078a();
    private final C37022f BgZ;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, dWq = {"Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument$Factory;", "", "()V", "create", "Lkotlin/reflect/jvm/internal/structure/ReflectJavaAnnotationArgument;", "value", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "descriptors.runtime"})
    /* renamed from: a.i.b.a.e.d$a */
    public static final class C37078a {
        private C37078a() {
        }

        public /* synthetic */ C37078a(byte b) {
            this();
        }

        /* renamed from: a */
        public static C41187d m62040a(Object obj, C37022f c37022f) {
            AppMethodBeat.m2504i(123030);
            C25052j.m39376p(obj, "value");
            C41187d c0176o;
            if (C37076b.m62033aY(obj.getClass())) {
                c0176o = new C0176o(c37022f, (Enum) obj);
                AppMethodBeat.m2505o(123030);
                return c0176o;
            } else if (obj instanceof Annotation) {
                c0176o = new C44933e(c37022f, (Annotation) obj);
                AppMethodBeat.m2505o(123030);
                return c0176o;
            } else if (obj instanceof Object[]) {
                c0176o = new C25249h(c37022f, (Object[]) obj);
                AppMethodBeat.m2505o(123030);
                return c0176o;
            } else if (obj instanceof Class) {
                c0176o = new C41362k(c37022f, (Class) obj);
                AppMethodBeat.m2505o(123030);
                return c0176o;
            } else {
                c0176o = new C0178q(c37022f, obj);
                AppMethodBeat.m2505o(123030);
                return c0176o;
            }
        }
    }

    public C41187d(C37022f c37022f) {
        this.BgZ = c37022f;
    }

    public final C37022f dZg() {
        return this.BgZ;
    }
}
