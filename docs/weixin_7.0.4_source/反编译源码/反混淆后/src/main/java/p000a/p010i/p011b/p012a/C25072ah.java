package p000a.p010i.p011b.p012a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004¨\u0006\u0017"}, dWq = {"Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "", "classLoader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "identityHashCode", "", "getIdentityHashCode", "()I", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "temporaryStrongRef", "getTemporaryStrongRef", "()Ljava/lang/ClassLoader;", "setTemporaryStrongRef", "equals", "", "other", "hashCode", "toString", "", "kotlin-reflect-api"})
/* renamed from: a.i.b.a.ah */
final class C25072ah {
    private final int AYF;
    ClassLoader AYG;
    private final WeakReference<ClassLoader> iuM;

    public C25072ah(ClassLoader classLoader) {
        C25052j.m39376p(classLoader, "classLoader");
        AppMethodBeat.m2504i(118949);
        this.iuM = new WeakReference(classLoader);
        this.AYF = System.identityHashCode(classLoader);
        this.AYG = classLoader;
        AppMethodBeat.m2505o(118949);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(118947);
        if ((obj instanceof C25072ah) && ((ClassLoader) this.iuM.get()) == ((ClassLoader) ((C25072ah) obj).iuM.get())) {
            AppMethodBeat.m2505o(118947);
            return true;
        }
        AppMethodBeat.m2505o(118947);
        return false;
    }

    public final int hashCode() {
        return this.AYF;
    }

    /* JADX WARNING: Missing block: B:3:0x0014, code skipped:
            if (r0 == null) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String toString() {
        String classLoader;
        AppMethodBeat.m2504i(118948);
        ClassLoader classLoader2 = (ClassLoader) this.iuM.get();
        if (classLoader2 != null) {
            classLoader = classLoader2.toString();
        }
        classLoader = "<null>";
        AppMethodBeat.m2505o(118948);
        return classLoader;
    }
}
