package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, dWq = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "Key", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.x */
public interface C31196x extends C41367b {
    public static final C31197a BPJ = C31197a.BPK;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.x$a */
    public static final class C31197a implements C36928c<C31196x> {
        static final /* synthetic */ C31197a BPK = new C31197a();

        static {
            AppMethodBeat.m2504i(118372);
            AppMethodBeat.m2505o(118372);
        }

        private C31197a() {
        }
    }

    void handleException(C41366e c41366e, Throwable th);
}
