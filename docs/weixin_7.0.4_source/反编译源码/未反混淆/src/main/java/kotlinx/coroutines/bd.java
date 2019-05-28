package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "job", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "equals", "", "other", "", "fillInStackTrace", "hashCode", "", "toString", "kotlinx-coroutines-core"})
public final class bd extends CancellationException {
    public final bc BQz;

    public bd(String str, Throwable th, bc bcVar) {
        j.p(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        j.p(bcVar, "job");
        super(str);
        AppMethodBeat.i(118468);
        this.BQz = bcVar;
        if (th != null) {
            initCause(th);
        }
        AppMethodBeat.o(118468);
    }

    public final Throwable fillInStackTrace() {
        AppMethodBeat.i(118464);
        Throwable fillInStackTrace;
        if (af.ela()) {
            fillInStackTrace = super.fillInStackTrace();
            j.o(fillInStackTrace, "super.fillInStackTrace()");
            AppMethodBeat.o(118464);
            return fillInStackTrace;
        }
        fillInStackTrace = this;
        AppMethodBeat.o(118464);
        return fillInStackTrace;
    }

    public final String toString() {
        AppMethodBeat.i(118465);
        String str = super.toString() + "; job=" + this.BQz;
        AppMethodBeat.o(118465);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118466);
        if (obj == this || ((obj instanceof bd) && j.j(((bd) obj).getMessage(), getMessage()) && j.j(((bd) obj).BQz, this.BQz) && j.j(((bd) obj).getCause(), getCause()))) {
            AppMethodBeat.o(118466);
            return true;
        }
        AppMethodBeat.o(118466);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(118467);
        String message = getMessage();
        if (message == null) {
            j.dWJ();
        }
        int hashCode = ((message.hashCode() * 31) + this.BQz.hashCode()) * 31;
        Throwable cause = getCause();
        int hashCode2 = (cause != null ? cause.hashCode() : 0) + hashCode;
        AppMethodBeat.o(118467);
        return hashCode2;
    }
}
