package com.tencent.mm.pluginsdk.g.a.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.f;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.c.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k extends f<a> {
    private final com.tencent.mm.pluginsdk.g.a.c.f.a veJ = new com.tencent.mm.pluginsdk.g.a.c.f.a(0, BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), new u());

    static final class a extends d<a> {
        protected a(a aVar) {
            super(aVar);
        }

        public final void run() {
            AppMethodBeat.i(79545);
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", ((a) awh()).vdC);
            a aVar = (a) awh();
            int i = aVar.cut;
            int i2 = aVar.cuu;
            int i3 = aVar.cuv;
            try {
                l lVar;
                aVar = (a) awh();
                l lVar2 = new l(aVar.cut, aVar.cuu, aVar.filePath, aVar.vdD, aVar.vdE, aVar.vdF, aVar.vdG, aVar.vdJ, aVar.cuw, aVar.vdH, aVar.vdI, aVar.vdL, aVar.vdK, aVar.url, aVar.vdM, aVar.vdN, aVar.cuv);
                if (lVar2.vei) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", lVar2.vdC);
                    lVar2.veM = lVar2.filePath + ".decompressed";
                    lVar2.state = 32;
                    if (lVar2.din() != null) {
                        lVar2.state = 16;
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.vdC);
                    }
                    lVar = lVar2;
                } else if (lVar2.vej) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", lVar2.vdC);
                    lVar2.veM = lVar2.filePath + ".decrypted";
                    lVar2.state = 32;
                    if (lVar2.din() != null) {
                        lVar2.state = 16;
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.vdC);
                    }
                    lVar = lVar2;
                } else {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", lVar2.vdC);
                    lVar2.veM = lVar2.filePath;
                    lVar2.state = 32;
                    if (lVar2.din() != null) {
                        lVar2.state = 16;
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.vdC);
                    }
                    lVar = lVar2;
                }
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.dip(), lVar.vdC);
                if (16 != lVar.state) {
                    if (lVar.vej) {
                        lVar.veM = lVar.filePath;
                        lVar.veN = lVar.filePath + ".decrypted";
                        lVar.state = 1;
                    } else if (lVar.vei) {
                        lVar.veM = lVar.filePath;
                        lVar.veN = lVar.filePath + ".decompressed";
                        lVar.state = 2;
                    } else {
                        lVar.veM = lVar.filePath;
                        lVar.state = 4;
                    }
                }
                String din = lVar.dil().dim().din();
                if (bo.isNullOrNil(din)) {
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decompressed");
                    if (Thread.interrupted()) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) awh()).vdC);
                        com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath);
                        com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decrypted");
                        com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decompressed");
                    }
                    aVar = (a) awh();
                    com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(79544);
                            bg bgVar = new bg();
                            bgVar.cux.cut = aVar.cut;
                            bgVar.cux.cuu = aVar.cuu;
                            bgVar.cux.cuA = aVar.vdJ;
                            bgVar.cux.cuy = 1;
                            bgVar.cux.cuz = false;
                            com.tencent.mm.sdk.b.a.xxA.m(bgVar);
                            AppMethodBeat.o(79544);
                        }
                    });
                    AppMethodBeat.o(79545);
                    return;
                }
                c.veg.e(i, i2, din, i3);
                if (Thread.interrupted()) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) awh()).vdC);
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath);
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decompressed");
                }
                AppMethodBeat.o(79545);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (Thread.interrupted()) {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) awh()).vdC);
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath);
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.g.a.d.a.ajj(((a) awh()).filePath + ".decompressed");
                }
                AppMethodBeat.o(79545);
            }
        }
    }

    k() {
        AppMethodBeat.i(79546);
        AppMethodBeat.o(79546);
    }

    static void g(s sVar) {
        AppMethodBeat.i(79547);
        new a(a.a(sVar)).run();
        AppMethodBeat.o(79547);
    }

    public final com.tencent.mm.pluginsdk.g.a.c.f.a dik() {
        return this.veJ;
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        AppMethodBeat.i(79548);
        if (ajd(aVar.vdC)) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", aVar.vdC);
            AppMethodBeat.o(79548);
            return;
        }
        int i;
        if (!(aVar.vdD && aVar.cuv == aVar.vdG && aVar.vdG >= 0) && (aVar.vdD || !aVar.vdE)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.o(79548);
            return;
        }
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", aVar.vdC);
        super.b(aVar);
        AppMethodBeat.o(79548);
    }
}
