package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "(Ljava/lang/Throwable;)V", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.q */
public class C31195q {
    public final Throwable cause;

    public C31195q(Throwable th) {
        C25052j.m39376p(th, "cause");
        AppMethodBeat.m2504i(118475);
        this.cause = th;
        AppMethodBeat.m2505o(118475);
    }

    public String toString() {
        AppMethodBeat.m2504i(118474);
        String str = C36623af.m60718ef(this) + '[' + this.cause + ']';
        AppMethodBeat.m2505o(118474);
        return str;
    }
}
