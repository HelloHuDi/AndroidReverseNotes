package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0016R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.az */
final class C44613az extends C25030g {
    private final C17126b<Throwable, C37091y> BQu;

    /* renamed from: am */
    public final /* synthetic */ Object mo50am(Object obj) {
        AppMethodBeat.m2504i(118479);
        mo41930v((Throwable) obj);
        C37091y c37091y = C37091y.AUy;
        AppMethodBeat.m2505o(118479);
        return c37091y;
    }

    public C44613az(C17126b<? super Throwable, C37091y> c17126b) {
        C25052j.m39376p(c17126b, "handler");
        AppMethodBeat.m2504i(118481);
        this.BQu = c17126b;
        AppMethodBeat.m2505o(118481);
    }

    /* renamed from: v */
    public final void mo41930v(Throwable th) {
        AppMethodBeat.m2504i(118478);
        this.BQu.mo50am(th);
        AppMethodBeat.m2505o(118478);
    }

    public final String toString() {
        AppMethodBeat.m2504i(118480);
        String str = "InvokeOnCancel[" + C36623af.m60718ef(this.BQu) + '@' + C36623af.m60717ee(this) + ']';
        AppMethodBeat.m2505o(118480);
        return str;
    }
}
