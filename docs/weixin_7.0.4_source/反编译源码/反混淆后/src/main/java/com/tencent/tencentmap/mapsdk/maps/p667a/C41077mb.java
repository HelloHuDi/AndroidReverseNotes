package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.mb */
public final class C41077mb {
    /* renamed from: a */
    public static void m71478a(Throwable th) {
        AppMethodBeat.m2504i(100501);
        if (th instanceof C16306md) {
            C16306md c16306md = (C16306md) th;
            AppMethodBeat.m2505o(100501);
            throw c16306md;
        } else if (th instanceof C36539mc) {
            Throwable cause = ((C36539mc) th).getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(100501);
                throw runtimeException;
            }
            C36539mc c36539mc = (C36539mc) th;
            AppMethodBeat.m2505o(100501);
            throw c36539mc;
        } else if (th instanceof StackOverflowError) {
            StackOverflowError stackOverflowError = (StackOverflowError) th;
            AppMethodBeat.m2505o(100501);
            throw stackOverflowError;
        } else if (th instanceof VirtualMachineError) {
            VirtualMachineError virtualMachineError = (VirtualMachineError) th;
            AppMethodBeat.m2505o(100501);
            throw virtualMachineError;
        } else if (th instanceof ThreadDeath) {
            ThreadDeath threadDeath = (ThreadDeath) th;
            AppMethodBeat.m2505o(100501);
            throw threadDeath;
        } else if (th instanceof LinkageError) {
            LinkageError linkageError = (LinkageError) th;
            AppMethodBeat.m2505o(100501);
            throw linkageError;
        } else {
            AppMethodBeat.m2505o(100501);
        }
    }

    /* renamed from: a */
    public static void m71479a(List<? extends Throwable> list) {
        AppMethodBeat.m2504i(100502);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(100502);
        } else if (list.size() == 1) {
            Throwable th = (Throwable) list.get(0);
            if (th instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) th;
                AppMethodBeat.m2505o(100502);
                throw runtimeException;
            } else if (th instanceof Error) {
                Error error = (Error) th;
                AppMethodBeat.m2505o(100502);
                throw error;
            } else {
                RuntimeException runtimeException2 = new RuntimeException(th);
                AppMethodBeat.m2505o(100502);
                throw runtimeException2;
            }
        } else {
            C46805ma c46805ma = new C46805ma("Multiple exceptions", list);
            AppMethodBeat.m2505o(100502);
            throw c46805ma;
        }
    }
}
