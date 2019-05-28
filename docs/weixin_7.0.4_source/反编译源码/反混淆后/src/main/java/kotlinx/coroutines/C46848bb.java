package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012'\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R/\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, dWq = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bb */
final class C46848bb extends C31189bf<C41157bc> {
    private final C17126b<Throwable, C37091y> BQu;

    /* renamed from: am */
    public final /* synthetic */ Object mo50am(Object obj) {
        AppMethodBeat.m2504i(118379);
        mo30347v((Throwable) obj);
        C37091y c37091y = C37091y.AUy;
        AppMethodBeat.m2505o(118379);
        return c37091y;
    }

    public C46848bb(C41157bc c41157bc, C17126b<? super Throwable, C37091y> c17126b) {
        C25052j.m39376p(c41157bc, "job");
        C25052j.m39376p(c17126b, "handler");
        super(c41157bc);
        AppMethodBeat.m2504i(118381);
        this.BQu = c17126b;
        AppMethodBeat.m2505o(118381);
    }

    /* renamed from: v */
    public final void mo30347v(Throwable th) {
        AppMethodBeat.m2504i(118378);
        this.BQu.mo50am(th);
        AppMethodBeat.m2505o(118378);
    }

    public final String toString() {
        AppMethodBeat.m2504i(118380);
        String str = "InvokeOnCompletion[" + C36623af.m60718ef(this) + '@' + C36623af.m60717ee(this) + ']';
        AppMethodBeat.m2505o(118380);
        return str;
    }
}
