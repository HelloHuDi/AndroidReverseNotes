package org.apache.commons.p703b.p704a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: org.apache.commons.b.a.d */
public class C6122d extends RuntimeException implements C16468b {
    protected C16469c BYB = new C16469c(this);
    private Throwable cause = null;

    public C6122d(Throwable th) {
        AppMethodBeat.m2504i(116948);
        this.cause = th;
        AppMethodBeat.m2505o(116948);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        AppMethodBeat.m2504i(116949);
        String message;
        if (super.getMessage() != null) {
            message = super.getMessage();
            AppMethodBeat.m2505o(116949);
            return message;
        } else if (this.cause != null) {
            message = this.cause.toString();
            AppMethodBeat.m2505o(116949);
            return message;
        } else {
            AppMethodBeat.m2505o(116949);
            return null;
        }
    }

    public void printStackTrace() {
        AppMethodBeat.m2504i(116950);
        this.BYB.printStackTrace(System.err);
        AppMethodBeat.m2505o(116950);
    }

    public void printStackTrace(PrintStream printStream) {
        AppMethodBeat.m2504i(116951);
        this.BYB.printStackTrace(printStream);
        AppMethodBeat.m2505o(116951);
    }

    public void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.m2504i(116952);
        this.BYB.printStackTrace(printWriter);
        AppMethodBeat.m2505o(116952);
    }

    /* renamed from: b */
    public final void mo13556b(PrintWriter printWriter) {
        AppMethodBeat.m2504i(116953);
        super.printStackTrace(printWriter);
        AppMethodBeat.m2505o(116953);
    }
}
