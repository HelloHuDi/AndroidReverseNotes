package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;

public class d extends RuntimeException implements b {
    protected c BYB = new c(this);
    private Throwable cause = null;

    public d(Throwable th) {
        AppMethodBeat.i(116948);
        this.cause = th;
        AppMethodBeat.o(116948);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        AppMethodBeat.i(116949);
        String message;
        if (super.getMessage() != null) {
            message = super.getMessage();
            AppMethodBeat.o(116949);
            return message;
        } else if (this.cause != null) {
            message = this.cause.toString();
            AppMethodBeat.o(116949);
            return message;
        } else {
            AppMethodBeat.o(116949);
            return null;
        }
    }

    public void printStackTrace() {
        AppMethodBeat.i(116950);
        this.BYB.printStackTrace(System.err);
        AppMethodBeat.o(116950);
    }

    public void printStackTrace(PrintStream printStream) {
        AppMethodBeat.i(116951);
        this.BYB.printStackTrace(printStream);
        AppMethodBeat.o(116951);
    }

    public void printStackTrace(PrintWriter printWriter) {
        AppMethodBeat.i(116952);
        this.BYB.printStackTrace(printWriter);
        AppMethodBeat.o(116952);
    }

    public final void b(PrintWriter printWriter) {
        AppMethodBeat.i(116953);
        super.printStackTrace(printWriter);
        AppMethodBeat.o(116953);
    }
}
