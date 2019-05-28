package com.tencent.mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;

public class LoadProtocolJNITask extends a {
    public void execute(g gVar) {
        AppMethodBeat.i(58784);
        k.a("MMProtocalJni", getClass().getClassLoader());
        retryOnce(new Runnable() {
            public void run() {
                AppMethodBeat.i(58781);
                MMProtocalJni.setClientPackVersion(d.vxo);
                AppMethodBeat.o(58781);
            }
        });
        retryOnce(new Runnable() {
            public void run() {
                AppMethodBeat.i(58782);
                MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
                AppMethodBeat.o(58782);
            }
        });
        retryOnce(new Runnable() {
            public void run() {
                AppMethodBeat.i(58783);
                MMProtocalJni.setIsLite(false);
                AppMethodBeat.o(58783);
            }
        });
        AppMethodBeat.o(58784);
    }

    private void retryOnce(Runnable runnable) {
        AppMethodBeat.i(58785);
        try {
            runnable.run();
            AppMethodBeat.o(58785);
        } catch (Throwable th) {
            runnable.run();
            AppMethodBeat.o(58785);
        }
    }

    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
