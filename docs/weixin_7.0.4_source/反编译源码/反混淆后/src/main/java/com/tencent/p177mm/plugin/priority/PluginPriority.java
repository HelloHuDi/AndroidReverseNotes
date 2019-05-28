package com.tencent.p177mm.plugin.priority;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p238a.p240b.C1655b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.priority.p1284b.C28670d;
import com.tencent.p177mm.plugin.priority.p1284b.C39486b;
import com.tencent.p177mm.plugin.priority.p1284b.C46130a;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C21434c;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C21435d;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C43373a;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C43375b;
import com.tencent.p177mm.plugin.priority.p1407a.C43371a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.Calendar;

/* renamed from: com.tencent.mm.plugin.priority.PluginPriority */
public class PluginPriority extends C7597f implements C1655b, C9562c, C43371a {
    private long pfZ;
    private C39486b pga;
    private C21434c pgb;
    private C21435d pgc;
    private C28670d pgd;
    private C43375b pge;
    private C43373a pgf;
    private C3457a pgg = new C128061();

    /* renamed from: com.tencent.mm.plugin.priority.PluginPriority$1 */
    class C128061 implements C3457a {
        C128061() {
        }

        /* renamed from: a */
        public final void mo7913a(C6977h c6977h, C3460c c3460c) {
            AppMethodBeat.m2504i(54866);
            if (c3460c.oqJ.equals("insert")) {
                for (int i = 0; i < c3460c.oqK.size(); i++) {
                    Object obj;
                    C7620bi c7620bi = (C7620bi) c3460c.oqK.get(i);
                    if (c7620bi.field_isSend == 1 || !c7620bi.drE()) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        ((C20286b) C1720g.m3528K(C20286b.class)).mo35523U(c7620bi);
                    }
                }
            }
            AppMethodBeat.m2505o(54866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.PluginPriority$a */
    class C21431a implements Runnable {
        private C21431a() {
        }

        /* synthetic */ C21431a(PluginPriority pluginPriority, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(54867);
            long currentTimeMillis = System.currentTimeMillis();
            if (C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_PRIORITY_DB_VERSION_INT, 0) != 6) {
                C4990ab.m7417i("MicroMsg.Priority.PluginPriority", "New DB FILE %d %d", Integer.valueOf(C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_PRIORITY_DB_VERSION_INT, 0)), Integer.valueOf(6));
                C1720g.m3537RQ();
                C5730e.deleteFile(new File(C1720g.m3536RP().cachePath, "MicroMsgPriority.db").getAbsolutePath());
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PRIORITY_DB_VERSION_INT, Integer.valueOf(6));
            }
            PluginPriority pluginPriority = PluginPriority.this;
            C1720g.m3537RQ();
            pluginPriority.pga = new C39486b(C1720g.m3536RP().cachePath);
            PluginPriority.this.pfZ = PluginPriority.this.pga.mo62441R(16777217, 0);
            if (PluginPriority.this.pfZ == 0) {
                PluginPriority.this.pfZ = System.currentTimeMillis();
                PluginPriority.this.pga.mo62442S(16777217, PluginPriority.this.pfZ);
            }
            C4990ab.m7417i("MicroMsg.Priority.PluginPriority", "install priority time %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", PluginPriority.this.pfZ / 1000));
            PluginPriority.this.pgb = new C21434c(PluginPriority.this.pga);
            PluginPriority.this.pgc = new C21435d(PluginPriority.this.pga);
            PluginPriority.this.pgd = new C28670d();
            PluginPriority.this.pge = new C43375b();
            PluginPriority.this.pgf = new C43373a();
            C28670d access$500 = PluginPriority.this.pgd;
            C4990ab.m7416i("MicroMsg.Priority.PriorityTaskRunner", "start tick");
            access$500.mo46812ju(0);
            long j = (long) Calendar.getInstance().get(5);
            if (j != PluginPriority.this.pga.mo62441R(16777218, -1)) {
                long j2 = (long) C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("ChatImgAutoDownloadMax"), 0);
                C4990ab.m7417i("MicroMsg.Priority.PriorityReportLogic", "report16341 %s", String.format("%d,%d", new Object[]{Long.valueOf(C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0)), Long.valueOf(j2)}));
                C7053e.pXa.mo8374X(16341, r0);
                PluginPriority.this.pga.mo62442S(16777218, j);
            }
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15287a(PluginPriority.this.pgg, null);
            C4990ab.m7417i("MicroMsg.Priority.PluginPriority", "Init Priority Use Time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(54867);
        }
    }

    public PluginPriority() {
        AppMethodBeat.m2504i(54868);
        AppMethodBeat.m2505o(54868);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(54869);
        C7305d.post(new C21431a(this, (byte) 0), "Priority.InitPriorityTask");
        C44042b.m79163a(new C46130a(), "//priority");
        AppMethodBeat.m2505o(54869);
    }

    public C43373a getC2CImgAutoDownloader() {
        return this.pgf;
    }

    public C28670d getPriorityTaskRunner() {
        return this.pgd;
    }

    public C43375b getC2CMsgAutoDownloadResLogic() {
        return this.pge;
    }

    public C21434c getC2CMsgAutoDownloadResStorage() {
        return this.pgb;
    }

    public C21435d getC2CMsgImgUsageStorage() {
        return this.pgc;
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(54870);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15286a(this.pgg);
        if (this.pgf != null) {
            C9017a c9017a = this.pgf;
            c9017a.pgt = 0;
            C32291o.ahm().mo33465a(c9017a);
            c9017a.fDh.dead();
            this.pgf = null;
        }
        if (this.pge != null) {
            this.pge = null;
        }
        if (this.pgd != null) {
            C28670d c28670d = this.pgd;
            c28670d.pgp.clear();
            c28670d.pgr.removeCallbacksAndMessages(null);
            c28670d.pgq.oAl.quit();
            c28670d.pgr = null;
            c28670d.pgq = null;
            this.pgd = null;
        }
        if (this.pgb != null) {
            C21434c c21434c = this.pgb;
            c21434c.pgA.close();
            c21434c.pgB.close();
            c21434c.pgC.close();
            c21434c.pgD.close();
            c21434c.pgE.close();
            c21434c.pgF.close();
            this.pgb = null;
        }
        if (this.pgc != null) {
            C21435d c21435d = this.pgc;
            c21435d.pgG.close();
            c21435d.pgH.close();
            c21435d.pgI.close();
        }
        if (this.pga != null) {
            boolean z;
            C39486b c39486b = this.pga;
            String str = "MicroMsg.Priority.PriorityDB";
            String str2 = "close db:%s isOpen:%b ";
            Object[] objArr = new Object[2];
            objArr[0] = c39486b.pgl;
            if (c39486b.pgl == null) {
                z = false;
            } else {
                z = c39486b.pgl.isOpen();
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7421w(str, str2, objArr);
            if (c39486b.pgl != null && c39486b.pgl.isOpen()) {
                C4990ab.m7421w("MicroMsg.Priority.PriorityDB", "close in trans :%b ", Boolean.valueOf(c39486b.pgl.inTransaction()));
                while (c39486b.pgl.inTransaction()) {
                    c39486b.pgl.endTransaction();
                }
                c39486b.pgm.close();
                c39486b.pgn.close();
                c39486b.pgo.close();
                c39486b.pgl.close();
                c39486b.pgl = null;
            }
            this.pga = null;
        }
        AppMethodBeat.m2505o(54870);
    }

    public void parallelsDependency() {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(54871);
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C20286b.class, new C43372a());
        }
        AppMethodBeat.m2505o(54871);
    }

    public long getInstallPriorityTime() {
        return this.pfZ;
    }

    public float getBorderPriority() {
        AppMethodBeat.m2504i(54872);
        try {
            float a = ((float) ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mmc2c_img_auto_download_border_priority, 30)) / 100.0f;
            AppMethodBeat.m2505o(54872);
            return a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(54872);
            return 0.5f;
        }
    }

    public float getBgBorderPriority() {
        AppMethodBeat.m2504i(54873);
        try {
            float a = ((float) ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mmc2c_img_auto_download_bg_border_priority, 10)) / 100.0f;
            AppMethodBeat.m2505o(54873);
            return a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(54873);
            return 0.1f;
        }
    }
}
