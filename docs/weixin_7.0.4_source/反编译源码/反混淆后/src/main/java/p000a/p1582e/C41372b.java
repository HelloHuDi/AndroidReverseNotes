package p000a.p1582e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import p000a.C0220l;
import p000a.C7993b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001a;\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\b\n\u0006\b\u0011(\n0\u0001¨\u0006\f"}, dWq = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
/* renamed from: a.e.b */
public final class C41372b {
    /* renamed from: a */
    public static final void m72155a(Closeable closeable, Throwable th) {
        AppMethodBeat.m2504i(56259);
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                AppMethodBeat.m2505o(56259);
                return;
            }
            try {
                closeable.close();
                AppMethodBeat.m2505o(56259);
                return;
            } catch (Throwable th2) {
                C7993b.m14177a(th, th2);
            }
        }
        AppMethodBeat.m2505o(56259);
    }
}
