package com.tencent.mm.plugin.priority.b.a;

import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.al.f;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.me;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Calendar;

public final class a implements com.tencent.mm.at.d.a, com.tencent.mm.plugin.priority.a.a.a.b {
    public c fDh = new c<me>() {
        {
            AppMethodBeat.i(54903);
            this.xxI = me.class.getName().hashCode();
            AppMethodBeat.o(54903);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i;
            String str;
            AppMethodBeat.i(54904);
            me meVar = (me) bVar;
            a aVar = a.this;
            int i2 = a.this.pgv;
            if (meVar.cHX.cHY) {
                i = 1;
            } else {
                i = -1;
            }
            aVar.pgv = i + i2;
            if (a.this.pgv < 0) {
                a.this.pgv = 0;
                ab.e("MicroMsg.Priority.C2CImgAutoDownloader", "pauseCnt < 0");
            }
            if (a.this.pgv == 0) {
                aVar = a.this;
                str = "";
            } else {
                aVar = a.this;
                if (meVar.cHX.cHY) {
                    str = bo.bc(meVar.cHX.talker, a.this.talker);
                } else {
                    str = a.this.talker;
                }
            }
            aVar.talker = str;
            ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "req pause: %b count: %d talker %s", Boolean.valueOf(meVar.cHX.cHY), Integer.valueOf(a.this.pgv), a.this.talker);
            a.this.start();
            AppMethodBeat.o(54904);
            return false;
        }
    };
    public long pgt = 0;
    int pgu = 0;
    int pgv = 0;
    boolean pgw = false;
    long pgx = 0;
    long pgy = 0;
    String talker = "";
    int uid = Process.myUid();

    class b extends com.tencent.mm.plugin.priority.b.b.a {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final String getName() {
            return "Priority.CheckNetworkNetStatTask";
        }

        public final void run() {
            AppMethodBeat.i(54906);
            long uidRxBytes = TrafficStats.getUidRxBytes(a.this.uid);
            long uidTxBytes = TrafficStats.getUidTxBytes(a.this.uid);
            if ((uidRxBytes - a.this.pgx) + (uidTxBytes - a.this.pgy) <= 20480) {
                a.this.pgw = false;
                a.this.start();
                AppMethodBeat.o(54906);
                return;
            }
            ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", Long.valueOf((uidRxBytes - a.this.pgx) + (uidTxBytes - a.this.pgy)));
            a.this.pgx = uidRxBytes;
            a.this.pgy = uidTxBytes;
            ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().b(new b());
            AppMethodBeat.o(54906);
        }
    }

    class a extends com.tencent.mm.plugin.priority.b.b.a {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final String getName() {
            return "Priority.C2CImgAutoDownloaderTask";
        }

        public final void run() {
            AppMethodBeat.i(54905);
            if (!com.tencent.mm.plugin.priority.a.a.a.bhI()) {
                AppMethodBeat.o(54905);
            } else if (!com.tencent.mm.plugin.priority.a.a.a.a.bZv()) {
                ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
                AppMethodBeat.o(54905);
            } else if (a.this.pgt != 0 || a.this.pgw) {
                ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", Long.valueOf(a.this.pgt), Boolean.valueOf(a.this.pgw));
                AppMethodBeat.o(54905);
            } else {
                int i;
                float borderPriority = ((PluginPriority) g.M(PluginPriority.class)).getBorderPriority();
                float bgBorderPriority = ((PluginPriority) g.M(PluginPriority.class)).getBgBorderPriority();
                int i2 = 0;
                gi giVar = null;
                if (!bo.isNullOrNil(a.this.talker)) {
                    giVar = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().h(a.this.talker, borderPriority);
                    i2 = 1;
                }
                if (giVar == null) {
                    giVar = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().aR(borderPriority);
                    i2 = 2;
                }
                if (giVar == null) {
                    giVar = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().bZA();
                    i2 = 4;
                }
                if (giVar == null && a.bZz()) {
                    giVar = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().aQ(bgBorderPriority);
                    ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download");
                    i = 3;
                } else {
                    i = i2;
                }
                if (giVar == null) {
                    a.this.pgt = 0;
                    ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
                    AppMethodBeat.o(54905);
                    return;
                }
                a.this.pgt = giVar.vIs;
                ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", Long.valueOf(a.this.pgt), Double.valueOf(giVar.vIB), Integer.valueOf(giVar.vIC), Integer.valueOf(i), Float.valueOf(borderPriority), Float.valueOf(bgBorderPriority));
                bi jf = ((j) g.K(j.class)).bOr().jf(a.this.pgt);
                e fI = o.ahl().fI(jf.field_msgSvrId);
                if (fI.dJA == 1) {
                    ab.i("MicroMsg.Priority.C2CImgAutoDownloader", a.this.pgt + " already has hd thumb");
                    ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(a.this.pgt, 5);
                    a.this.pgt = 0;
                    a.this.start();
                    AppMethodBeat.o(54905);
                    return;
                }
                int a;
                f.afx().fyQ.add("image_" + jf.field_msgId);
                if (bo.isNullOrNil(a.this.talker) || !a.this.talker.equals(jf.field_talker)) {
                    a = o.ahm().a(fI.fDy, jf.field_msgId, 0, Long.valueOf(a.this.pgt), a.this.pgu, a.this, 60000, false);
                    ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", Long.valueOf(a.this.pgt), "image_" + jf.field_msgId, Integer.valueOf(a));
                } else {
                    a = o.ahm().a(fI.fDy, jf.field_msgId, 0, Long.valueOf(a.this.pgt), a.this.pgu, a.this, 60000, true);
                    ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", Long.valueOf(a.this.pgt), "image_" + jf.field_msgId, a.this.talker, Integer.valueOf(a));
                }
                switch (a) {
                    case -4:
                    case -3:
                    case 0:
                        ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(a.this.pgt, 2);
                        if (i == 3) {
                            com.tencent.mm.plugin.report.e.pXa.a(957, 52, 1, false);
                            AppMethodBeat.o(54905);
                            return;
                        } else if (i == 1) {
                            com.tencent.mm.plugin.report.e.pXa.a(957, 50, 1, false);
                            AppMethodBeat.o(54905);
                            return;
                        } else if (i == 4) {
                            com.tencent.mm.plugin.report.e.pXa.a(957, 57, 1, false);
                            AppMethodBeat.o(54905);
                            return;
                        } else {
                            com.tencent.mm.plugin.report.e.pXa.a(957, 51, 1, false);
                            AppMethodBeat.o(54905);
                            return;
                        }
                    case -2:
                        ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(a.this.pgt, 3);
                        if (i == 3) {
                            com.tencent.mm.plugin.report.e.pXa.a(957, 55, 1, false);
                        }
                        a.this.pgt = 0;
                        a.this.start();
                        AppMethodBeat.o(54905);
                        return;
                    case -1:
                        ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(a.this.pgt, 4);
                        if (i == 3) {
                            com.tencent.mm.plugin.report.e.pXa.a(957, 56, 1, false);
                        }
                        a.this.pgt = 0;
                        a.this.start();
                        break;
                }
                AppMethodBeat.o(54905);
            }
        }
    }

    public a() {
        AppMethodBeat.i(54907);
        if (com.tencent.mm.plugin.priority.a.a.a.bhI()) {
            this.fDh.dnU();
        }
        this.pgu = R.drawable.b0p;
        AppMethodBeat.o(54907);
    }

    public final void start() {
        AppMethodBeat.i(54908);
        if (this.pgt != 0) {
            e fJ = o.ahl().fJ(this.pgt);
            if (o.ahm().a(fJ.fDy, this.pgt, fJ.fDC)) {
                ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", Long.valueOf(this.pgt));
                AppMethodBeat.o(54908);
                return;
            }
            this.pgt = 0;
            if (fJ.dJA == 1) {
                ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", Long.valueOf(this.pgt));
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(this.pgt, 5);
            } else {
                ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", Long.valueOf(this.pgt));
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(this.pgt, 1);
            }
        }
        ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().a(new a(this, (byte) 0));
        AppMethodBeat.o(54908);
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, m mVar) {
    }

    public final void b(long j, long j2, boolean z) {
        AppMethodBeat.i(54909);
        if (!z) {
            ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + j + " msglocalid " + j2 + " false");
            AppMethodBeat.o(54909);
        } else if (at.isWifi(ah.getContext())) {
            ab.v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
            AppMethodBeat.o(54909);
        } else {
            long a = bo.a((Long) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long anl = bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
            ab.d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(anl));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
            AppMethodBeat.o(54909);
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, m mVar) {
        AppMethodBeat.i(54910);
        if (i3 == 0 && i4 == 0) {
            b(j, j2, true);
            ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, true, false);
            com.tencent.mm.plugin.report.e.pXa.a(957, 54, 1, false);
        } else {
            ab.e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + j + "msgLocalId " + j2 + " download failed");
            ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, false, false);
            com.tencent.mm.plugin.report.e.pXa.a(957, 53, 1, false);
        }
        this.pgt = 0;
        ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
        this.pgw = true;
        this.pgx = TrafficStats.getUidRxBytes(this.uid);
        this.pgy = TrafficStats.getUidTxBytes(this.uid);
        ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().b(new b(this, (byte) 0));
        AppMethodBeat.o(54910);
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.i(54911);
        ab.i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", Long.valueOf(j2));
        this.pgt = 0;
        ((com.tencent.mm.plugin.comm.a.b) g.K(com.tencent.mm.plugin.comm.a.b.class)).b(j2, false, true);
        com.tencent.mm.plugin.report.e.pXa.a(957, 57, 1, false);
        AppMethodBeat.o(54911);
    }

    public static boolean bZz() {
        AppMethodBeat.i(54912);
        if (at.isWifi(ah.getContext())) {
            Calendar instance = Calendar.getInstance();
            int i = instance.get(11);
            int i2 = instance.get(12);
            if (i == 1) {
                g.RN();
                if (i2 >= Math.abs(com.tencent.mm.kernel.a.QF()) % 30) {
                    AppMethodBeat.o(54912);
                    return true;
                }
                AppMethodBeat.o(54912);
                return false;
            } else if (i < 2 || i > 6) {
                AppMethodBeat.o(54912);
                return false;
            } else {
                AppMethodBeat.o(54912);
                return true;
            }
        }
        AppMethodBeat.o(54912);
        return false;
    }
}
