package com.tencent.mm.audio.mix.c;

import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.h.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static final Long cln = Long.valueOf(2592000000L);
    public static final Long clo = Long.valueOf(604800000);
    public static final Long clp = Long.valueOf(259200000);
    public static final Long clq = Long.valueOf(172800000);
    public static final Long clr = Long.valueOf(86400000);
    public static final Long cls = Long.valueOf(43200000);
    public static final Long clt = Long.valueOf(240000);
    public static final Long clu = clr;
    public static final Long clv = Long.valueOf(60000);
    public static long clx = 0;
    private List<String> clw = new ArrayList(10);

    public class a extends i {
        public a(String str) {
            super(str);
        }

        public final void run() {
            AppMethodBeat.i(137026);
            e.a(e.this);
            h.b(this);
            AppMethodBeat.o(137026);
        }
    }

    static {
        AppMethodBeat.i(137031);
        AppMethodBeat.o(137031);
    }

    public e() {
        AppMethodBeat.i(137027);
        AppMethodBeat.o(137027);
    }

    private void dz(String str) {
        AppMethodBeat.i(137028);
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                b.i("MicroMsg.Mix.AudioScanConvertCacheController", "none files exist");
                AppMethodBeat.o(137028);
                return;
            }
            for (String str2 : list) {
                String str22;
                if (dA(str22)) {
                    b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is the block file, don't delete");
                } else {
                    str22 = str + File.separator + str22;
                    File file2 = new File(str22);
                    if (!file2.exists()) {
                        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file not exist");
                    } else if (file2.isDirectory()) {
                        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "file is directory, scan and delete");
                        dz(str22);
                    } else if (System.currentTimeMillis() - file2.lastModified() > clq.longValue()) {
                        b.e("MicroMsg.Mix.AudioScanConvertCacheController", "Clean 2 days file in mix convert file name=%s, path:%s", file2.getName(), file2.getAbsolutePath());
                        file2.delete();
                    }
                }
            }
            AppMethodBeat.o(137028);
            return;
        }
        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "%s is not exist or not Directory", str);
        AppMethodBeat.o(137028);
    }

    private boolean dA(String str) {
        AppMethodBeat.i(137029);
        for (String contains : this.clw) {
            if (str.contains(contains)) {
                AppMethodBeat.o(137029);
                return true;
            }
        }
        AppMethodBeat.o(137029);
        return false;
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(137030);
        b.i("MicroMsg.Mix.AudioScanConvertCacheController", "clean mix convert file");
        eVar.dz(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/MixAudio");
        AppMethodBeat.o(137030);
    }
}
