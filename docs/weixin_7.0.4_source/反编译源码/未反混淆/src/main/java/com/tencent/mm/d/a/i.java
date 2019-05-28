package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.eclipsesource.v8.MultiContextNodeJS.IGetTmpFileDirectory;
import com.eclipsesource.v8.MultiContextV8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;

public final class i extends a {
    private MultiContextNodeJS chC;
    public volatile l chD;

    private i(String str, byte[] bArr) {
        super(str, bArr);
    }

    private i() {
    }

    static i j(String str, byte[] bArr) {
        AppMethodBeat.i(113817);
        i iVar = new i(str, bArr);
        AppMethodBeat.o(113817);
        return iVar;
    }

    static {
        AppMethodBeat.i(113821);
        MultiContextNodeJS.setGetTmpFileDirectoryDelegate(new IGetTmpFileDirectory() {
            public final File getDirectory() {
                AppMethodBeat.i(113812);
                String str = ah.getContext().getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/tmp/";
                j.aih(str);
                ab.i("MicroMsg.NodeJSRuntime", "tmpDir:%s", str);
                File file = new File(str);
                AppMethodBeat.o(113812);
                return file;
            }
        });
        AppMethodBeat.o(113821);
    }

    /* Access modifiers changed, original: final */
    public final MultiContextV8 Co() {
        AppMethodBeat.i(113818);
        this.chC = MultiContextNodeJS.createMultiContextNodeJS(1, this.chs, this.cht);
        this.cht = null;
        MultiContextV8 runtime = this.chC.getRuntime();
        AppMethodBeat.o(113818);
        return runtime;
    }

    /* Access modifiers changed, original: final */
    public final d Cp() {
        AppMethodBeat.i(113819);
        j a = j.a(new a() {
            public final boolean Cw() {
                AppMethodBeat.i(113813);
                boolean handleMessage = i.this.chC.handleMessage();
                AppMethodBeat.o(113813);
                return handleMessage;
            }

            public final void wakeUpUVLoop() {
                AppMethodBeat.i(113814);
                if (i.this.chC != null) {
                    i.this.chC.wakeUpUVLoop();
                }
                AppMethodBeat.o(113814);
            }

            public final void closeUVLoop() {
                AppMethodBeat.i(113815);
                if (i.this.chC != null) {
                    i.this.chC.closeUVLoop();
                }
                AppMethodBeat.o(113815);
            }
        });
        AppMethodBeat.o(113819);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final void Cq() {
        AppMethodBeat.i(113820);
        ab.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
        try {
            this.chC.release();
            ab.i("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
            AppMethodBeat.o(113820);
        } catch (Exception e) {
            ab.e("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", e);
            AppMethodBeat.o(113820);
        }
    }
}
