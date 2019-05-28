package com.tencent.mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.priority.b.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Calendar;

public class PluginPriority extends f implements b, c, com.tencent.mm.plugin.priority.a.a {
    private long pfZ;
    private com.tencent.mm.plugin.priority.b.b pga;
    private com.tencent.mm.plugin.priority.b.a.c pgb;
    private d pgc;
    private com.tencent.mm.plugin.priority.b.d pgd;
    private com.tencent.mm.plugin.priority.b.a.b pge;
    private com.tencent.mm.plugin.priority.b.a.a pgf;
    private com.tencent.mm.plugin.messenger.foundation.a.a.h.a pgg = new com.tencent.mm.plugin.messenger.foundation.a.a.h.a() {
        public final void a(h hVar, h.c cVar) {
            AppMethodBeat.i(54866);
            if (cVar.oqJ.equals("insert")) {
                for (int i = 0; i < cVar.oqK.size(); i++) {
                    Object obj;
                    bi biVar = (bi) cVar.oqK.get(i);
                    if (biVar.field_isSend == 1 || !biVar.drE()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).U(biVar);
                    }
                }
            }
            AppMethodBeat.o(54866);
        }
    };

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(PluginPriority pluginPriority, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(54867);
            long currentTimeMillis = System.currentTimeMillis();
            if (g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_PRIORITY_DB_VERSION_INT, 0) != 6) {
                ab.i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", Integer.valueOf(g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_PRIORITY_DB_VERSION_INT, 0)), Integer.valueOf(6));
                g.RQ();
                e.deleteFile(new File(g.RP().cachePath, "MicroMsgPriority.db").getAbsolutePath());
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_PRIORITY_DB_VERSION_INT, Integer.valueOf(6));
            }
            PluginPriority pluginPriority = PluginPriority.this;
            g.RQ();
            pluginPriority.pga = new com.tencent.mm.plugin.priority.b.b(g.RP().cachePath);
            PluginPriority.this.pfZ = PluginPriority.this.pga.R(16777217, 0);
            if (PluginPriority.this.pfZ == 0) {
                PluginPriority.this.pfZ = System.currentTimeMillis();
                PluginPriority.this.pga.S(16777217, PluginPriority.this.pfZ);
            }
            ab.i("MicroMsg.Priority.PluginPriority", "install priority time %s", com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.pfZ / 1000));
            PluginPriority.this.pgb = new com.tencent.mm.plugin.priority.b.a.c(PluginPriority.this.pga);
            PluginPriority.this.pgc = new d(PluginPriority.this.pga);
            PluginPriority.this.pgd = new com.tencent.mm.plugin.priority.b.d();
            PluginPriority.this.pge = new com.tencent.mm.plugin.priority.b.a.b();
            PluginPriority.this.pgf = new com.tencent.mm.plugin.priority.b.a.a();
            com.tencent.mm.plugin.priority.b.d access$500 = PluginPriority.this.pgd;
            ab.i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
            access$500.ju(0);
            long j = (long) Calendar.getInstance().get(5);
            if (j != PluginPriority.this.pga.R(16777218, -1)) {
                long j2 = (long) bo.getInt(((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("ChatImgAutoDownloadMax"), 0);
                ab.i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", String.format("%d,%d", new Object[]{Long.valueOf(bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0)), Long.valueOf(j2)}));
                com.tencent.mm.plugin.report.e.pXa.X(16341, r0);
                PluginPriority.this.pga.S(16777218, j);
            }
            ((j) g.K(j.class)).bOr().a(PluginPriority.this.pgg, null);
            ab.i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(54867);
        }
    }

    public PluginPriority() {
        AppMethodBeat.i(54868);
        AppMethodBeat.o(54868);
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        AppMethodBeat.i(54869);
        com.tencent.mm.sdk.g.d.post(new a(this, (byte) 0), "Priority.InitPriorityTask");
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.priority.b.a(), "//priority");
        AppMethodBeat.o(54869);
    }

    public com.tencent.mm.plugin.priority.b.a.a getC2CImgAutoDownloader() {
        return this.pgf;
    }

    public com.tencent.mm.plugin.priority.b.d getPriorityTaskRunner() {
        return this.pgd;
    }

    public com.tencent.mm.plugin.priority.b.a.b getC2CMsgAutoDownloadResLogic() {
        return this.pge;
    }

    public com.tencent.mm.plugin.priority.b.a.c getC2CMsgAutoDownloadResStorage() {
        return this.pgb;
    }

    public d getC2CMsgImgUsageStorage() {
        return this.pgc;
    }

    public void onAccountRelease() {
        AppMethodBeat.i(54870);
        ((j) g.K(j.class)).bOr().a(this.pgg);
        if (this.pgf != null) {
            com.tencent.mm.at.d.a aVar = this.pgf;
            aVar.pgt = 0;
            o.ahm().a(aVar);
            aVar.fDh.dead();
            this.pgf = null;
        }
        if (this.pge != null) {
            this.pge = null;
        }
        if (this.pgd != null) {
            com.tencent.mm.plugin.priority.b.d dVar = this.pgd;
            dVar.pgp.clear();
            dVar.pgr.removeCallbacksAndMessages(null);
            dVar.pgq.oAl.quit();
            dVar.pgr = null;
            dVar.pgq = null;
            this.pgd = null;
        }
        if (this.pgb != null) {
            com.tencent.mm.plugin.priority.b.a.c cVar = this.pgb;
            cVar.pgA.close();
            cVar.pgB.close();
            cVar.pgC.close();
            cVar.pgD.close();
            cVar.pgE.close();
            cVar.pgF.close();
            this.pgb = null;
        }
        if (this.pgc != null) {
            d dVar2 = this.pgc;
            dVar2.pgG.close();
            dVar2.pgH.close();
            dVar2.pgI.close();
        }
        if (this.pga != null) {
            boolean z;
            com.tencent.mm.plugin.priority.b.b bVar = this.pga;
            String str = "MicroMsg.Priority.PriorityDB";
            String str2 = "close db:%s isOpen:%b ";
            Object[] objArr = new Object[2];
            objArr[0] = bVar.pgl;
            if (bVar.pgl == null) {
                z = false;
            } else {
                z = bVar.pgl.isOpen();
            }
            objArr[1] = Boolean.valueOf(z);
            ab.w(str, str2, objArr);
            if (bVar.pgl != null && bVar.pgl.isOpen()) {
                ab.w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", Boolean.valueOf(bVar.pgl.inTransaction()));
                while (bVar.pgl.inTransaction()) {
                    bVar.pgl.endTransaction();
                }
                bVar.pgm.close();
                bVar.pgn.close();
                bVar.pgo.close();
                bVar.pgl.close();
                bVar.pgl = null;
            }
            this.pga = null;
        }
        AppMethodBeat.o(54870);
    }

    public void parallelsDependency() {
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(54871);
        if (gVar.SG()) {
            g.a(com.tencent.mm.plugin.comm.a.b.class, new a());
        }
        AppMethodBeat.o(54871);
    }

    public long getInstallPriorityTime() {
        return this.pfZ;
    }

    public float getBorderPriority() {
        AppMethodBeat.i(54872);
        try {
            float a = ((float) ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mmc2c_img_auto_download_border_priority, 30)) / 100.0f;
            AppMethodBeat.o(54872);
            return a;
        } catch (Exception e) {
            AppMethodBeat.o(54872);
            return 0.5f;
        }
    }

    public float getBgBorderPriority() {
        AppMethodBeat.i(54873);
        try {
            float a = ((float) ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mmc2c_img_auto_download_bg_border_priority, 10)) / 100.0f;
            AppMethodBeat.o(54873);
            return a;
        } catch (Exception e) {
            AppMethodBeat.o(54873);
            return 0.1f;
        }
    }
}
