package kotlinx.coroutines;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bd */
public final class C44616bd extends CancellationException {
    public final C41157bc BQz;

    public C44616bd(String str, Throwable th, C41157bc c41157bc) {
        C25052j.m39376p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        C25052j.m39376p(c41157bc, "job");
        super(str);
        AppMethodBeat.m2504i(118468);
        this.BQz = c41157bc;
        if (th != null) {
            initCause(th);
        }
        AppMethodBeat.m2505o(118468);
    }

    public final Throwable fillInStackTrace() {
        AppMethodBeat.m2504i(118464);
        Throwable fillInStackTrace;
        if (C36623af.ela()) {
            fillInStackTrace = super.fillInStackTrace();
            C25052j.m39375o(fillInStackTrace, "super.fillInStackTrace()");
            AppMethodBeat.m2505o(118464);
            return fillInStackTrace;
        }
        fillInStackTrace = this;
        AppMethodBeat.m2505o(118464);
        return fillInStackTrace;
    }

    public final String toString() {
        AppMethodBeat.m2504i(118465);
        String str = super.toString() + "; job=" + this.BQz;
        AppMethodBeat.m2505o(118465);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(118466);
        if (obj == this || ((obj instanceof C44616bd) && C25052j.m39373j(((C44616bd) obj).getMessage(), getMessage()) && C25052j.m39373j(((C44616bd) obj).BQz, this.BQz) && C25052j.m39373j(((C44616bd) obj).getCause(), getCause()))) {
            AppMethodBeat.m2505o(118466);
            return true;
        }
        AppMethodBeat.m2505o(118466);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(118467);
        String message = getMessage();
        if (message == null) {
            C25052j.dWJ();
        }
        int hashCode = ((message.hashCode() * 31) + this.BQz.hashCode()) * 31;
        Throwable cause = getCause();
        int hashCode2 = (cause != null ? cause.hashCode() : 0) + hashCode;
        AppMethodBeat.m2505o(118467);
        return hashCode2;
    }
}
