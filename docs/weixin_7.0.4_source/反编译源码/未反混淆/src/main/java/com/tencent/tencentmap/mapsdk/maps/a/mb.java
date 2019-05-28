package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class mb {
    public static void a(Throwable th) {
        AppMethodBeat.i(100501);
        if (th instanceof md) {
            md mdVar = (md) th;
            AppMethodBeat.o(100501);
            throw mdVar;
        } else if (th instanceof mc) {
            Throwable cause = ((mc) th).getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(100501);
                throw runtimeException;
            }
            mc mcVar = (mc) th;
            AppMethodBeat.o(100501);
            throw mcVar;
        } else if (th instanceof StackOverflowError) {
            StackOverflowError stackOverflowError = (StackOverflowError) th;
            AppMethodBeat.o(100501);
            throw stackOverflowError;
        } else if (th instanceof VirtualMachineError) {
            VirtualMachineError virtualMachineError = (VirtualMachineError) th;
            AppMethodBeat.o(100501);
            throw virtualMachineError;
        } else if (th instanceof ThreadDeath) {
            ThreadDeath threadDeath = (ThreadDeath) th;
            AppMethodBeat.o(100501);
            throw threadDeath;
        } else if (th instanceof LinkageError) {
            LinkageError linkageError = (LinkageError) th;
            AppMethodBeat.o(100501);
            throw linkageError;
        } else {
            AppMethodBeat.o(100501);
        }
    }

    public static void a(List<? extends Throwable> list) {
        AppMethodBeat.i(100502);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(100502);
        } else if (list.size() == 1) {
            Throwable th = (Throwable) list.get(0);
            if (th instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) th;
                AppMethodBeat.o(100502);
                throw runtimeException;
            } else if (th instanceof Error) {
                Error error = (Error) th;
                AppMethodBeat.o(100502);
                throw error;
            } else {
                RuntimeException runtimeException2 = new RuntimeException(th);
                AppMethodBeat.o(100502);
                throw runtimeException2;
            }
        } else {
            ma maVar = new ma("Multiple exceptions", list);
            AppMethodBeat.o(100502);
            throw maVar;
        }
    }
}
