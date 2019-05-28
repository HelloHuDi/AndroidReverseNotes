package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32520bg;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44051u;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4717a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C4716f.C4718d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.k */
final class C30040k extends C4716f<C14836a> {
    private final C4717a veJ = new C4717a(0, BaseClientBuilder.API_PRIORITY_OTHER, 60, TimeUnit.SECONDS, new SynchronousQueue(), new C44051u());

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.k$a */
    static final class C30041a extends C4718d<C14836a> {
        protected C30041a(C14836a c14836a) {
            super(c14836a);
        }

        public final void run() {
            AppMethodBeat.m2504i(79545);
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", ((C14836a) awh()).vdC);
            C14836a c14836a = (C14836a) awh();
            int i = c14836a.cut;
            int i2 = c14836a.cuu;
            int i3 = c14836a.cuv;
            try {
                C23238l c23238l;
                c14836a = (C14836a) awh();
                C23238l c23238l2 = new C23238l(c14836a.cut, c14836a.cuu, c14836a.filePath, c14836a.vdD, c14836a.vdE, c14836a.vdF, c14836a.vdG, c14836a.vdJ, c14836a.cuw, c14836a.vdH, c14836a.vdI, c14836a.vdL, c14836a.vdK, c14836a.url, c14836a.vdM, c14836a.vdN, c14836a.cuv);
                if (c23238l2.vei) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", c23238l2.vdC);
                    c23238l2.veM = c23238l2.filePath + ".decompressed";
                    c23238l2.state = 32;
                    if (c23238l2.din() != null) {
                        c23238l2.state = 16;
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", c23238l2.vdC);
                    }
                    c23238l = c23238l2;
                } else if (c23238l2.vej) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", c23238l2.vdC);
                    c23238l2.veM = c23238l2.filePath + ".decrypted";
                    c23238l2.state = 32;
                    if (c23238l2.din() != null) {
                        c23238l2.state = 16;
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", c23238l2.vdC);
                    }
                    c23238l = c23238l2;
                } else {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", c23238l2.vdC);
                    c23238l2.veM = c23238l2.filePath;
                    c23238l2.state = 32;
                    if (c23238l2.din() != null) {
                        c23238l2.state = 16;
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", c23238l2.vdC);
                    }
                    c23238l = c23238l2;
                }
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + c23238l.dip(), c23238l.vdC);
                if (16 != c23238l.state) {
                    if (c23238l.vej) {
                        c23238l.veM = c23238l.filePath;
                        c23238l.veN = c23238l.filePath + ".decrypted";
                        c23238l.state = 1;
                    } else if (c23238l.vei) {
                        c23238l.veM = c23238l.filePath;
                        c23238l.veN = c23238l.filePath + ".decompressed";
                        c23238l.state = 2;
                    } else {
                        c23238l.veM = c23238l.filePath;
                        c23238l.state = 4;
                    }
                }
                String din = c23238l.dil().dim().din();
                if (C5046bo.isNullOrNil(din)) {
                    C40433a.ajj(((C14836a) awh()).filePath + ".decrypted");
                    C40433a.ajj(((C14836a) awh()).filePath + ".decompressed");
                    if (Thread.interrupted()) {
                        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((C14836a) awh()).vdC);
                        C40433a.ajj(((C14836a) awh()).filePath);
                        C40433a.ajj(((C14836a) awh()).filePath + ".decrypted");
                        C40433a.ajj(((C14836a) awh()).filePath + ".decompressed");
                    }
                    c14836a = (C14836a) awh();
                    C14857a.vfA.handler.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(79544);
                            C32520bg c32520bg = new C32520bg();
                            c32520bg.cux.cut = c14836a.cut;
                            c32520bg.cux.cuu = c14836a.cuu;
                            c32520bg.cux.cuA = c14836a.vdJ;
                            c32520bg.cux.cuy = 1;
                            c32520bg.cux.cuz = false;
                            C4879a.xxA.mo10055m(c32520bg);
                            AppMethodBeat.m2505o(79544);
                        }
                    });
                    AppMethodBeat.m2505o(79545);
                    return;
                }
                C14845c.veg.mo27151e(i, i2, din, i3);
                if (Thread.interrupted()) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((C14836a) awh()).vdC);
                    C40433a.ajj(((C14836a) awh()).filePath);
                    C40433a.ajj(((C14836a) awh()).filePath + ".decrypted");
                    C40433a.ajj(((C14836a) awh()).filePath + ".decompressed");
                }
                AppMethodBeat.m2505o(79545);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (Thread.interrupted()) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((C14836a) awh()).vdC);
                    C40433a.ajj(((C14836a) awh()).filePath);
                    C40433a.ajj(((C14836a) awh()).filePath + ".decrypted");
                    C40433a.ajj(((C14836a) awh()).filePath + ".decompressed");
                }
                AppMethodBeat.m2505o(79545);
            }
        }
    }

    C30040k() {
        AppMethodBeat.m2504i(79546);
        AppMethodBeat.m2505o(79546);
    }

    /* renamed from: g */
    static void m47550g(C44049s c44049s) {
        AppMethodBeat.m2504i(79547);
        new C30041a(C14836a.m23093a(c44049s)).run();
        AppMethodBeat.m2505o(79547);
    }

    public final C4717a dik() {
        return this.veJ;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo48267a(C14836a c14836a) {
        AppMethodBeat.m2504i(79548);
        if (ajd(c14836a.vdC)) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", c14836a.vdC);
            AppMethodBeat.m2505o(79548);
            return;
        }
        int i;
        if (!(c14836a.vdD && c14836a.cuv == c14836a.vdG && c14836a.vdG >= 0) && (c14836a.vdD || !c14836a.vdE)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(79548);
            return;
        }
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", c14836a.vdC);
        super.mo9848b(c14836a);
        AppMethodBeat.m2505o(79548);
    }
}
