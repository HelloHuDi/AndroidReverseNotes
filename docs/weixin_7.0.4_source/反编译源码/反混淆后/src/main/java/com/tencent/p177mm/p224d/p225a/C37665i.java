package com.tencent.p177mm.p224d.p225a;

import com.eclipsesource.p097v8.MultiContextNodeJS;
import com.eclipsesource.p097v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.eclipsesource.p097v8.MultiContextV8;
import com.eclipsesource.p097v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p224d.p225a.C32484j.C32483a;
import com.tencent.p177mm.p224d.p225a.C32488l.C32493a;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.File;

/* renamed from: com.tencent.mm.d.a.i */
public final class C37665i extends C46876a {
    private MultiContextNodeJS chC;
    public volatile C32488l chD;

    /* renamed from: com.tencent.mm.d.a.i$2 */
    class C92572 implements C32483a {
        C92572() {
        }

        /* renamed from: Cw */
        public final boolean mo20678Cw() {
            AppMethodBeat.m2504i(113813);
            boolean handleMessage = C37665i.this.chC.handleMessage();
            AppMethodBeat.m2505o(113813);
            return handleMessage;
        }

        public final void wakeUpUVLoop() {
            AppMethodBeat.m2504i(113814);
            if (C37665i.this.chC != null) {
                C37665i.this.chC.wakeUpUVLoop();
            }
            AppMethodBeat.m2505o(113814);
        }

        public final void closeUVLoop() {
            AppMethodBeat.m2504i(113815);
            if (C37665i.this.chC != null) {
                C37665i.this.chC.closeUVLoop();
            }
            AppMethodBeat.m2505o(113815);
        }
    }

    /* renamed from: com.tencent.mm.d.a.i$1 */
    static class C260601 implements IGetTmpFileDirectory {
        C260601() {
        }

        public final File getDirectory() {
            AppMethodBeat.m2504i(113812);
            String str = C4996ah.getContext().getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
            C15428j.aih(str);
            C4990ab.m7417i("MicroMsg.NodeJSRuntime", "tmpDir:%s", str);
            File file = new File(str);
            AppMethodBeat.m2505o(113812);
            return file;
        }
    }

    /* renamed from: com.tencent.mm.d.a.i$3 */
    public class C376663 implements C32493a {
        /* renamed from: Cu */
        public final V8Context mo53127Cu() {
            AppMethodBeat.m2504i(113816);
            if (C37665i.this.chC == null) {
                IllegalStateException illegalStateException = new IllegalStateException("getMainContext mNodeJS not ready!");
                AppMethodBeat.m2505o(113816);
                throw illegalStateException;
            }
            C4990ab.m7417i("MicroMsg.NodeJSRuntime", "getMainContext %s", Integer.valueOf(C37665i.this.chC.getMainContext().hashCode()));
            V8Context mainContext = C37665i.this.chC.getMainContext();
            AppMethodBeat.m2505o(113816);
            return mainContext;
        }
    }

    private C37665i(String str, byte[] bArr) {
        super(str, bArr);
    }

    private C37665i() {
    }

    /* renamed from: j */
    static C37665i m63696j(String str, byte[] bArr) {
        AppMethodBeat.m2504i(113817);
        C37665i c37665i = new C37665i(str, bArr);
        AppMethodBeat.m2505o(113817);
        return c37665i;
    }

    static {
        AppMethodBeat.m2504i(113821);
        MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new C260601());
        AppMethodBeat.m2505o(113821);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Co */
    public final MultiContextV8 mo43932Co() {
        AppMethodBeat.m2504i(113818);
        this.chC = MultiContextNodeJS.createMultiContextNodeJS(1, this.chs, this.cht);
        this.cht = null;
        MultiContextV8 runtime = this.chC.getRuntime();
        AppMethodBeat.m2505o(113818);
        return runtime;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Cp */
    public final C9254d mo43933Cp() {
        AppMethodBeat.m2504i(113819);
        C32484j a = C32484j.m53173a(new C92572());
        AppMethodBeat.m2505o(113819);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Cq */
    public final void mo43934Cq() {
        AppMethodBeat.m2504i(113820);
        C4990ab.m7416i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
        try {
            this.chC.release();
            C4990ab.m7416i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
            AppMethodBeat.m2505o(113820);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", e);
            AppMethodBeat.m2505o(113820);
        }
    }
}
