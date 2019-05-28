package p000a.p1142d.p1143a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p1142d.C41368a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, dWq = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "kotlin-stdlib-jdk7"})
/* renamed from: a.d.a.a */
public class C17125a extends C41368a {
    /* renamed from: a */
    public final void mo31243a(Throwable th, Throwable th2) {
        AppMethodBeat.m2504i(123227);
        C25052j.m39376p(th, "cause");
        C25052j.m39376p(th2, "exception");
        th.addSuppressed(th2);
        AppMethodBeat.m2505o(123227);
    }
}
