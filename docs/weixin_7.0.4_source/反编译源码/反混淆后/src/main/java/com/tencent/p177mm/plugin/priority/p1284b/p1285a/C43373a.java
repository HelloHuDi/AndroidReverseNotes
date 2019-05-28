package com.tencent.p177mm.plugin.priority.p1284b.p1285a;

import android.net.TrafficStats;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18322me;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.priority.PluginPriority;
import com.tencent.p177mm.plugin.priority.p1284b.p1497b.C34675a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.C43370a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.p1409a.C28669b;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.p1409a.C39485a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.C23390gi;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Calendar;

/* renamed from: com.tencent.mm.plugin.priority.b.a.a */
public final class C43373a implements C9017a, C28669b {
    public C4884c fDh = new C346741();
    public long pgt = 0;
    int pgu = 0;
    int pgv = 0;
    boolean pgw = false;
    long pgx = 0;
    long pgy = 0;
    String talker = "";
    int uid = Process.myUid();

    /* renamed from: com.tencent.mm.plugin.priority.b.a.a$b */
    class C21433b extends C34675a {
        private C21433b() {
        }

        /* synthetic */ C21433b(C43373a c43373a, byte b) {
            this();
        }

        public final String getName() {
            return "Priority.CheckNetworkNetStatTask";
        }

        public final void run() {
            AppMethodBeat.m2504i(54906);
            long uidRxBytes = TrafficStats.getUidRxBytes(C43373a.this.uid);
            long uidTxBytes = TrafficStats.getUidTxBytes(C43373a.this.uid);
            if ((uidRxBytes - C43373a.this.pgx) + (uidTxBytes - C43373a.this.pgy) <= 20480) {
                C43373a.this.pgw = false;
                C43373a.this.start();
                AppMethodBeat.m2505o(54906);
                return;
            }
            C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "byteDelta %d", Long.valueOf((uidRxBytes - C43373a.this.pgx) + (uidTxBytes - C43373a.this.pgy)));
            C43373a.this.pgx = uidRxBytes;
            C43373a.this.pgy = uidTxBytes;
            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46811b(new C21433b());
            AppMethodBeat.m2505o(54906);
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.b.a.a$1 */
    class C346741 extends C4884c<C18322me> {
        C346741() {
            AppMethodBeat.m2504i(54903);
            this.xxI = C18322me.class.getName().hashCode();
            AppMethodBeat.m2505o(54903);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i;
            String str;
            AppMethodBeat.m2504i(54904);
            C18322me c18322me = (C18322me) c4883b;
            C43373a c43373a = C43373a.this;
            int i2 = C43373a.this.pgv;
            if (c18322me.cHX.cHY) {
                i = 1;
            } else {
                i = -1;
            }
            c43373a.pgv = i + i2;
            if (C43373a.this.pgv < 0) {
                C43373a.this.pgv = 0;
                C4990ab.m7412e("MicroMsg.Priority.C2CImgAutoDownloader", "pauseCnt < 0");
            }
            if (C43373a.this.pgv == 0) {
                c43373a = C43373a.this;
                str = "";
            } else {
                c43373a = C43373a.this;
                if (c18322me.cHX.cHY) {
                    str = C5046bo.m7532bc(c18322me.cHX.talker, C43373a.this.talker);
                } else {
                    str = C43373a.this.talker;
                }
            }
            c43373a.talker = str;
            C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "req pause: %b count: %d talker %s", Boolean.valueOf(c18322me.cHX.cHY), Integer.valueOf(C43373a.this.pgv), C43373a.this.talker);
            C43373a.this.start();
            AppMethodBeat.m2505o(54904);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.b.a.a$a */
    class C43374a extends C34675a {
        private C43374a() {
        }

        /* synthetic */ C43374a(C43373a c43373a, byte b) {
            this();
        }

        public final String getName() {
            return "Priority.C2CImgAutoDownloaderTask";
        }

        public final void run() {
            AppMethodBeat.m2504i(54905);
            if (!C43370a.bhI()) {
                AppMethodBeat.m2505o(54905);
            } else if (!C39485a.bZv()) {
                C4990ab.m7416i("MicroMsg.Priority.C2CImgAutoDownloader", "not auto download condition");
                AppMethodBeat.m2505o(54905);
            } else if (C43373a.this.pgt != 0 || C43373a.this.pgw) {
                C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d pauseOnMonitor %b", Long.valueOf(C43373a.this.pgt), Boolean.valueOf(C43373a.this.pgw));
                AppMethodBeat.m2505o(54905);
            } else {
                int i;
                float borderPriority = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getBorderPriority();
                float bgBorderPriority = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getBgBorderPriority();
                int i2 = 0;
                C23390gi c23390gi = null;
                if (!C5046bo.isNullOrNil(C43373a.this.talker)) {
                    c23390gi = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36893h(C43373a.this.talker, borderPriority);
                    i2 = 1;
                }
                if (c23390gi == null) {
                    c23390gi = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36891aR(borderPriority);
                    i2 = 2;
                }
                if (c23390gi == null) {
                    c23390gi = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().bZA();
                    i2 = 4;
                }
                if (c23390gi == null && C43373a.bZz()) {
                    c23390gi = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36890aQ(bgBorderPriority);
                    C4990ab.m7416i("MicroMsg.Priority.C2CImgAutoDownloader", "bg normal download");
                    i = 3;
                } else {
                    i = i2;
                }
                if (c23390gi == null) {
                    C43373a.this.pgt = 0;
                    C4990ab.m7416i("MicroMsg.Priority.C2CImgAutoDownloader", "autoDownloadRes is null");
                    AppMethodBeat.m2505o(54905);
                    return;
                }
                C43373a.this.pgt = c23390gi.vIs;
                C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "curMsgId %d priority %.2f prioritytype %d way %d borderPriority %.2f bgBorderPriority %.2f", Long.valueOf(C43373a.this.pgt), Double.valueOf(c23390gi.vIB), Integer.valueOf(c23390gi.vIC), Integer.valueOf(i), Float.valueOf(borderPriority), Float.valueOf(bgBorderPriority));
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(C43373a.this.pgt);
                C25822e fI = C32291o.ahl().mo73112fI(jf.field_msgSvrId);
                if (fI.dJA == 1) {
                    C4990ab.m7416i("MicroMsg.Priority.C2CImgAutoDownloader", C43373a.this.pgt + " already has hd thumb");
                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(C43373a.this.pgt, 5);
                    C43373a.this.pgt = 0;
                    C43373a.this.start();
                    AppMethodBeat.m2505o(54905);
                    return;
                }
                int a;
                C37461f.afx().fyQ.add("image_" + jf.field_msgId);
                if (C5046bo.isNullOrNil(C43373a.this.talker) || !C43373a.this.talker.equals(jf.field_talker)) {
                    a = C32291o.ahm().mo33463a(fI.fDy, jf.field_msgId, 0, Long.valueOf(C43373a.this.pgt), C43373a.this.pgu, C43373a.this, 60000, false);
                    C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s result=%d", Long.valueOf(C43373a.this.pgt), "image_" + jf.field_msgId, Integer.valueOf(a));
                } else {
                    a = C32291o.ahm().mo33463a(fI.fDy, jf.field_msgId, 0, Long.valueOf(C43373a.this.pgt), C43373a.this.pgu, C43373a.this, 60000, true);
                    C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "start download cdnautostart %d %s %s result=%d", Long.valueOf(C43373a.this.pgt), "image_" + jf.field_msgId, C43373a.this.talker, Integer.valueOf(a));
                }
                switch (a) {
                    case -4:
                    case -3:
                    case 0:
                        ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(C43373a.this.pgt, 2);
                        if (i == 3) {
                            C7053e.pXa.mo8378a(957, 52, 1, false);
                            AppMethodBeat.m2505o(54905);
                            return;
                        } else if (i == 1) {
                            C7053e.pXa.mo8378a(957, 50, 1, false);
                            AppMethodBeat.m2505o(54905);
                            return;
                        } else if (i == 4) {
                            C7053e.pXa.mo8378a(957, 57, 1, false);
                            AppMethodBeat.m2505o(54905);
                            return;
                        } else {
                            C7053e.pXa.mo8378a(957, 51, 1, false);
                            AppMethodBeat.m2505o(54905);
                            return;
                        }
                    case -2:
                        ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(C43373a.this.pgt, 3);
                        if (i == 3) {
                            C7053e.pXa.mo8378a(957, 55, 1, false);
                        }
                        C43373a.this.pgt = 0;
                        C43373a.this.start();
                        AppMethodBeat.m2505o(54905);
                        return;
                    case -1:
                        ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(C43373a.this.pgt, 4);
                        if (i == 3) {
                            C7053e.pXa.mo8378a(957, 56, 1, false);
                        }
                        C43373a.this.pgt = 0;
                        C43373a.this.start();
                        break;
                }
                AppMethodBeat.m2505o(54905);
            }
        }
    }

    public C43373a() {
        AppMethodBeat.m2504i(54907);
        if (C43370a.bhI()) {
            this.fDh.dnU();
        }
        this.pgu = C25738R.drawable.b0p;
        AppMethodBeat.m2505o(54907);
    }

    public final void start() {
        AppMethodBeat.m2504i(54908);
        if (this.pgt != 0) {
            C25822e fJ = C32291o.ahl().mo73113fJ(this.pgt);
            if (C32291o.ahm().mo33466a(fJ.fDy, this.pgt, fJ.fDC)) {
                C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "Downloading %d", Long.valueOf(this.pgt));
                AppMethodBeat.m2505o(54908);
                return;
            }
            this.pgt = 0;
            if (fJ.dJA == 1) {
                C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Already Downloaded, Force Cancel curMsgId %d", Long.valueOf(this.pgt));
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(this.pgt, 5);
            } else {
                C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "Not In DownloadImgService Queue, Not Downloaded, Force Cancel curMsgId %d", Long.valueOf(this.pgt));
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(this.pgt, 1);
            }
        }
        ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46810a(new C43374a(this, (byte) 0));
        AppMethodBeat.m2505o(54908);
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
    }

    /* renamed from: b */
    public final void mo46809b(long j, long j2, boolean z) {
        AppMethodBeat.m2504i(54909);
        if (!z) {
            C4990ab.m7416i("MicroMsg.Priority.C2CImgAutoDownloader", "imglocalId " + j + " msglocalid " + j2 + " false");
            AppMethodBeat.m2505o(54909);
        } else if (C5023at.isWifi(C4996ah.getContext())) {
            C4990ab.m7418v("MicroMsg.Priority.C2CImgAutoDownloader", "is wifi pass count");
            AppMethodBeat.m2505o(54909);
        } else {
            long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long anl = C5046bo.anl((String) DateFormat.format("M", System.currentTimeMillis()));
            C4990ab.m7411d("MicroMsg.Priority.C2CImgAutoDownloader", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(anl));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(anl));
            AppMethodBeat.m2505o(54909);
        }
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(54910);
        if (i3 == 0 && i4 == 0) {
            mo46809b(j, j2, true);
            ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, true, false);
            C7053e.pXa.mo8378a(957, 54, 1, false);
        } else {
            C4990ab.m7412e("MicroMsg.Priority.C2CImgAutoDownloader", "img " + j + "msgLocalId " + j2 + " download failed");
            ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, false, false);
            C7053e.pXa.mo8378a(957, 53, 1, false);
        }
        this.pgt = 0;
        C4990ab.m7416i("MicroMsg.Priority.C2CImgAutoDownloader", "normal download mode check network stat");
        this.pgw = true;
        this.pgx = TrafficStats.getUidRxBytes(this.uid);
        this.pgy = TrafficStats.getUidTxBytes(this.uid);
        ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46811b(new C21433b(this, (byte) 0));
        AppMethodBeat.m2505o(54910);
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
        AppMethodBeat.m2504i(54911);
        C4990ab.m7417i("MicroMsg.Priority.C2CImgAutoDownloader", "onImgTaskCanceled %d", Long.valueOf(j2));
        this.pgt = 0;
        ((C20286b) C1720g.m3528K(C20286b.class)).mo35525b(j2, false, true);
        C7053e.pXa.mo8378a(957, 57, 1, false);
        AppMethodBeat.m2505o(54911);
    }

    public static boolean bZz() {
        AppMethodBeat.m2504i(54912);
        if (C5023at.isWifi(C4996ah.getContext())) {
            Calendar instance = Calendar.getInstance();
            int i = instance.get(11);
            int i2 = instance.get(12);
            if (i == 1) {
                C1720g.m3534RN();
                if (i2 >= Math.abs(C1668a.m3383QF()) % 30) {
                    AppMethodBeat.m2505o(54912);
                    return true;
                }
                AppMethodBeat.m2505o(54912);
                return false;
            } else if (i < 2 || i > 6) {
                AppMethodBeat.m2505o(54912);
                return false;
            } else {
                AppMethodBeat.m2505o(54912);
                return true;
            }
        }
        AppMethodBeat.m2505o(54912);
        return false;
    }
}
