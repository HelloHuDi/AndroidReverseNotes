package com.tencent.p177mm.plugin.zero.tasks;

import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.MMProtocalJni;

/* renamed from: com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask */
public class LoadProtocolJNITask extends C42148a {

    /* renamed from: com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask$1 */
    class C148231 implements Runnable {
        C148231() {
        }

        public void run() {
            AppMethodBeat.m2504i(58781);
            MMProtocalJni.setClientPackVersion(C7243d.vxo);
            AppMethodBeat.m2505o(58781);
        }
    }

    /* renamed from: com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask$2 */
    class C232302 implements Runnable {
        C232302() {
        }

        public void run() {
            AppMethodBeat.m2504i(58782);
            MMProtocalJni.setProtocalJniLogLevel(new Xlog().getLogLevel());
            AppMethodBeat.m2505o(58782);
        }
    }

    /* renamed from: com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask$3 */
    class C232313 implements Runnable {
        C232313() {
        }

        public void run() {
            AppMethodBeat.m2504i(58783);
            MMProtocalJni.setIsLite(false);
            AppMethodBeat.m2505o(58783);
        }
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(58784);
        C1449k.m3079a("MMProtocalJni", getClass().getClassLoader());
        retryOnce(new C148231());
        retryOnce(new C232302());
        retryOnce(new C232313());
        AppMethodBeat.m2505o(58784);
    }

    private void retryOnce(Runnable runnable) {
        AppMethodBeat.m2504i(58785);
        try {
            runnable.run();
            AppMethodBeat.m2505o(58785);
        } catch (Throwable th) {
            runnable.run();
            AppMethodBeat.m2505o(58785);
        }
    }

    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
