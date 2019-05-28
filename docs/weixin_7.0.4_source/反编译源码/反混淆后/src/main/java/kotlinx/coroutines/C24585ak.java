package kotlinx.coroutines;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, dWq = {"Lkotlinx/coroutines/DispatchException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.ak */
public final class C24585ak extends RuntimeException {
    public C24585ak(String str, Throwable th) {
        C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        C25052j.m39376p(th, "cause");
        super(str, th);
        AppMethodBeat.m2504i(118561);
        AppMethodBeat.m2505o(118561);
    }
}
