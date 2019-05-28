package com.tencent.mm.audio.mix.e;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.a;
import com.tencent.mm.audio.mix.h.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class g {
    private static Object cli = new Object();
    private static g cnf;
    private boolean bZi = false;
    private String clf;
    private boolean cng = true;
    private FileOutputStream outputStream;

    static {
        AppMethodBeat.i(137127);
        AppMethodBeat.o(137127);
    }

    private static g Ee() {
        AppMethodBeat.i(137123);
        if (cnf == null) {
            synchronized (cli) {
                try {
                    if (cnf == null) {
                        cnf = new g();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(137123);
                    }
                }
            }
        }
        g gVar = cnf;
        AppMethodBeat.o(137123);
        return gVar;
    }

    private static String Ef() {
        AppMethodBeat.i(137124);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = file + File.separator + "mix_audio_pcm.pcm";
        AppMethodBeat.o(137124);
        return str;
    }

    public static void Eg() {
        AppMethodBeat.i(137125);
        new File(Ef()).delete();
        g Ee = Ee();
        if (Ee.bZi) {
            b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "finishProcess");
            try {
                if (Ee.outputStream != null) {
                    Ee.outputStream.flush();
                    Ee.outputStream.close();
                    Ee.outputStream = null;
                }
            } catch (Exception e) {
                b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e, "finishProcess", new Object[0]);
            }
            Ee.bZi = false;
        }
        AppMethodBeat.o(137125);
    }

    private g() {
        AppMethodBeat.i(137126);
        if (!this.bZi) {
            this.bZi = true;
            this.clf = Ef();
            b.i("MicroMsg.Mix.ExportMixAudioPcmFile", "outFile:%s", this.clf);
            new File(this.clf).delete();
            try {
                this.outputStream = new FileOutputStream(a.ei(this.clf));
                AppMethodBeat.o(137126);
                return;
            } catch (FileNotFoundException e) {
                b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e, "new FileOutputStream", new Object[0]);
                AppMethodBeat.o(137126);
                return;
            } catch (Exception e2) {
                b.printErrStackTrace("MicroMsg.Mix.ExportMixAudioPcmFile", e2, "new FileOutputStream", new Object[0]);
            }
        }
        AppMethodBeat.o(137126);
    }
}
