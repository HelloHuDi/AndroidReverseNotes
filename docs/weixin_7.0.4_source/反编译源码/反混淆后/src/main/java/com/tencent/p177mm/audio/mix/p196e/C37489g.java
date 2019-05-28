package com.tencent.p177mm.audio.mix.p196e;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* renamed from: com.tencent.mm.audio.mix.e.g */
public final class C37489g {
    private static Object cli = new Object();
    private static C37489g cnf;
    private boolean bZi = false;
    private String clf;
    private boolean cng = true;
    private FileOutputStream outputStream;

    static {
        AppMethodBeat.m2504i(137127);
        AppMethodBeat.m2505o(137127);
    }

    /* renamed from: Ee */
    private static C37489g m63272Ee() {
        AppMethodBeat.m2504i(137123);
        if (cnf == null) {
            synchronized (cli) {
                try {
                    if (cnf == null) {
                        cnf = new C37489g();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(137123);
                    }
                }
            }
        }
        C37489g c37489g = cnf;
        AppMethodBeat.m2505o(137123);
        return c37489g;
    }

    /* renamed from: Ef */
    private static String m63273Ef() {
        AppMethodBeat.m2504i(137124);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = file + File.separator + "mix_audio_pcm.pcm";
        AppMethodBeat.m2505o(137124);
        return str;
    }

    /* renamed from: Eg */
    public static void m63274Eg() {
        AppMethodBeat.m2504i(137125);
        new File(C37489g.m63273Ef()).delete();
        C37489g Ee = C37489g.m63272Ee();
        if (Ee.bZi) {
            C45174b.m83209i("MicroMsg.Mix.ExportMixAudioPcmFile", "finishProcess");
            try {
                if (Ee.outputStream != null) {
                    Ee.outputStream.flush();
                    Ee.outputStream.close();
                    Ee.outputStream = null;
                }
            } catch (Exception e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e, "finishProcess", new Object[0]);
            }
            Ee.bZi = false;
        }
        AppMethodBeat.m2505o(137125);
    }

    private C37489g() {
        AppMethodBeat.m2504i(137126);
        if (!this.bZi) {
            this.bZi = true;
            this.clf = C37489g.m63273Ef();
            C45174b.m83210i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", this.clf);
            new File(this.clf).delete();
            try {
                this.outputStream = new FileOutputStream(C41782a.m73754ei(this.clf));
                AppMethodBeat.m2505o(137126);
                return;
            } catch (FileNotFoundException e) {
                C45174b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e, "new FileOutputStream", new Object[0]);
                AppMethodBeat.m2505o(137126);
                return;
            } catch (Exception e2) {
                C45174b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e2, "new FileOutputStream", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(137126);
    }
}
