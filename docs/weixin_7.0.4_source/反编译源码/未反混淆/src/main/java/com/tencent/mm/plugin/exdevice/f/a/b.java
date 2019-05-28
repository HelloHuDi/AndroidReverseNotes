package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class b {

    static class a implements Runnable {
        private com.tencent.mm.vfs.b lvo;
        private String url;

        a(String str, com.tencent.mm.vfs.b bVar) {
            this.url = str;
            this.lvo = bVar;
        }

        public final void run() {
            AppMethodBeat.i(19432);
            byte[] ano = bo.ano(this.url);
            if (ano != null) {
                e.b(j.w(this.lvo.mUri), ano, ano.length);
            }
            AppMethodBeat.o(19432);
        }

        public final String toString() {
            AppMethodBeat.i(19433);
            String str = super.toString() + "|DownloadRunnable";
            AppMethodBeat.o(19433);
            return str;
        }
    }

    public static String Kl(String str) {
        AppMethodBeat.i(19434);
        String str2;
        if (bo.isNullOrNil(str) || "#".equals(str)) {
            str2 = "";
            AppMethodBeat.o(19434);
            return str2;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(d.bpj(), ag.ck(str));
        if (bVar.exists()) {
            str2 = j.w(bVar.dMD());
            AppMethodBeat.o(19434);
            return str2;
        }
        try {
            bVar.createNewFile();
        } catch (IOException e) {
            ab.d("MicroMsg.ExdevicePictureLocalizer", "hy: %s", e.toString());
        }
        aw.RS().aa(new a(str, bVar));
        str2 = "";
        AppMethodBeat.o(19434);
        return str2;
    }
}
