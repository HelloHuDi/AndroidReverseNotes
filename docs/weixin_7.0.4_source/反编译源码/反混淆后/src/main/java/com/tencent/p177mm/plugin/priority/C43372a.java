package com.tencent.p177mm.plugin.priority;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelcontrol.C45448b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.comm.p1247a.C20286b;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.priority.p1284b.C21437c;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C21434c;
import com.tencent.p177mm.plugin.priority.p1284b.p1285a.C21435d;
import com.tencent.p177mm.plugin.priority.p1284b.p1497b.C34675a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.C43370a;
import com.tencent.p177mm.plugin.priority.p1407a.p1408a.p1409a.C39485a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.C23390gi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.priority.a */
public final class C43372a implements C20286b {

    /* renamed from: com.tencent.mm.plugin.priority.a$a */
    class C3593a extends C34675a {
        private long cvx;
        private boolean cxT;
        private boolean eVT;

        public C3593a(long j, boolean z, boolean z2) {
            this.cvx = j;
            this.cxT = z;
            this.eVT = z2;
        }

        public final String getName() {
            return "Priority.onC2CImgDownloadedTask";
        }

        public final void run() {
            AppMethodBeat.m2504i(54875);
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cvx);
            if (jf.field_createTime <= ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getInstallPriorityTime()) {
                C4990ab.m7417i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", jf.field_createTime / 1000));
                AppMethodBeat.m2505o(54875);
                return;
            }
            if (((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null) {
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
                boolean z = this.cxT;
                boolean z2 = this.eVT;
                if (z) {
                    C23390gi jw = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36895jw(jf.field_msgId);
                    if (jw == null) {
                        C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "sender img %d", Long.valueOf(jf.field_msgId));
                        AppMethodBeat.m2505o(54875);
                        return;
                    } else if (jw.jBT == 3) {
                        C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "already auto download msgid %d", Long.valueOf(jf.field_msgId));
                        AppMethodBeat.m2505o(54875);
                        return;
                    } else {
                        C7053e.pXa.mo8378a(957, 20, 1, false);
                        if (jw != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            C25822e fI = C32291o.ahl().mo73112fI(jw.vIy);
                            jw.vIz = fI.frO;
                            C21437c.m32874a(1, currentTimeMillis, 0, jw);
                            C21434c c2CMsgAutoDownloadResStorage = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
                            long j = jw.vIs;
                            int i = fI.frO;
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(1, currentTimeMillis);
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(2, 3);
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(3, (long) i);
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(4, j);
                            C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatusAndDownloadTime %d res %d %d %d", Integer.valueOf(c2CMsgAutoDownloadResStorage.pgE.executeUpdateDelete()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Integer.valueOf(3));
                            if (C43370a.m77394eW(jw.vIw, 1)) {
                                C7053e.pXa.mo8378a(957, 21, 1, false);
                                C7053e.pXa.mo8378a(957, 22, (long) fI.frO, false);
                            }
                            if (C43370a.m77394eW(jw.vIw, 8)) {
                                C7053e.pXa.mo8378a(957, 23, 1, false);
                                C7053e.pXa.mo8378a(957, 24, (long) fI.frO, false);
                            }
                            if (C43370a.m77394eW(jw.vIw, 2) || C43370a.m77394eW(jw.vIw, 4)) {
                                C7053e.pXa.mo8378a(957, 25, 1, false);
                                C7053e.pXa.mo8378a(957, 26, (long) fI.frO, false);
                            }
                            if (C43370a.m77394eW(jw.vIw, 16)) {
                                C7053e.pXa.mo8378a(957, 27, 1, false);
                                C7053e.pXa.mo8378a(957, 28, (long) fI.frO, false);
                            }
                            if (C43370a.m77394eW(jw.vIw, 32)) {
                                C7053e.pXa.mo8378a(957, 29, 1, false);
                                C7053e.pXa.mo8378a(957, 30, (long) fI.frO, false);
                            }
                            if (C43370a.m77394eW(jw.vIw, 64)) {
                                C7053e.pXa.mo8378a(957, 33, 1, false);
                                C7053e.pXa.mo8378a(957, 34, (long) fI.frO, false);
                            }
                            if (C43370a.m77394eW(jw.vIw, 128)) {
                                C7053e.pXa.mo8378a(957, 35, 1, false);
                                C7053e.pXa.mo8378a(957, 36, (long) fI.frO, false);
                            }
                            AppMethodBeat.m2505o(54875);
                            return;
                        }
                        C7053e.pXa.mo8378a(957, 31, 1, false);
                        AppMethodBeat.m2505o(54875);
                        return;
                    }
                }
                if (z2) {
                    C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "updateStatus download cancel %d", Long.valueOf(jf.field_msgId));
                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(jf.field_msgId, 1);
                } else {
                    C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "updateStatus download fail %d", Long.valueOf(jf.field_msgId));
                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36897z(jf.field_msgId, 4);
                }
                C7053e.pXa.mo8378a(957, 32, 1, false);
            }
            AppMethodBeat.m2505o(54875);
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.a$d */
    class C3594d extends C34675a {
        private C7620bi cKd;
        private WeakReference<Runnable> pgj;

        C3594d(C7620bi c7620bi, WeakReference<Runnable> weakReference) {
            this.cKd = c7620bi;
            this.pgj = weakReference;
        }

        public final String getName() {
            return "Priority.onC2CImgScrollTask";
        }

        public final void run() {
            AppMethodBeat.m2504i(54878);
            if (!C43370a.bhI() || this.cKd.field_createTime > ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getInstallPriorityTime()) {
                C4990ab.m7417i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", Integer.valueOf(32), Long.valueOf(this.cKd.field_msgId));
                if (this.pgj.get() != null) {
                    ((Runnable) this.pgj.get()).run();
                }
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
                C7620bi c7620bi = this.cKd;
                C23390gi jw = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36895jw(c7620bi.field_msgId);
                if (jw == null) {
                    C4990ab.m7416i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "This Image Sender is Me");
                    AppMethodBeat.m2505o(54878);
                    return;
                }
                if (jw.jBT == 1) {
                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36896m(c7620bi.field_msgId, 32, 2);
                }
                AppMethodBeat.m2505o(54878);
                return;
            }
            C4990ab.m7417i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", this.cKd.field_createTime / 1000));
            AppMethodBeat.m2505o(54878);
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.a$c */
    class C21432c extends C34675a {
        private C7620bi cKd;

        public C21432c(C7620bi c7620bi) {
            this.cKd = c7620bi;
        }

        public final String getName() {
            return "Priority.onC2CImgReceiveTask";
        }

        /* JADX WARNING: Removed duplicated region for block: B:63:0x02ed  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x012f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(54877);
            if (this.cKd.field_createTime <= ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getInstallPriorityTime()) {
                C4990ab.m7417i("MicroMsg.Priority.PriorityService", "onC2CImgReceive time condition not support %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", this.cKd.field_createTime / 1000));
                AppMethodBeat.m2505o(54877);
            } else if (((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36894jv(this.cKd.field_msgId)) {
                C4990ab.m7417i("MicroMsg.Priority.PriorityService", "already exist msg %d", Long.valueOf(this.cKd.field_msgId));
                AppMethodBeat.m2505o(54877);
            } else {
                double[] fC;
                String bc;
                int a;
                Object obj;
                int i;
                int i2;
                int i3 = 1;
                if (C1855t.m3896kH(this.cKd.field_talker)) {
                    fC = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36901fC(this.cKd.field_talker, "@all");
                } else {
                    fC = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36901fC(this.cKd.field_talker, this.cKd.field_talker);
                }
                double d = C43372a.m77396d(fC);
                if (C1855t.m3896kH(this.cKd.field_talker)) {
                    bc = C5046bo.m7532bc(C1829bf.m3762oy(this.cKd.field_content), "");
                    if (!C5046bo.isNullOrNil(bc)) {
                        double[] fC2 = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36901fC(this.cKd.field_talker, bc);
                        a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mmc2c_img_auto_download_talker_border_priority, 101);
                        if (C43372a.m77396d(fC2) > d && C43372a.m77396d(fC2) > ((double) a)) {
                            d = C43372a.m77396d(fC2);
                            i3 = 2;
                        }
                    }
                }
                Object obj2 = 1;
                a = 0;
                C1828b oE = C1829bf.m3758oE(this.cKd.dqJ);
                if (oE == null) {
                    obj = null;
                } else {
                    String str = oE.fmD;
                    if (C5046bo.isNullOrNil(str) || !C45448b.m83719rR(str)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    a = 4;
                    obj2 = null;
                }
                if (!C39485a.bZw()) {
                    a |= 2;
                    obj2 = null;
                }
                if (!C39485a.bZx()) {
                    a |= 16;
                    obj2 = null;
                }
                if (C39485a.m67464UE(this.cKd.field_talker)) {
                    a |= 8;
                    if (C43370a.bZu()) {
                        obj2 = null;
                        i = a;
                        if (C43370a.bhI()) {
                            if (C43370a.bZu()) {
                                if (obj2 != null) {
                                    C43372a.m77395a(this.cKd, i | 1, 2, d, i3);
                                    AppMethodBeat.m2505o(54877);
                                    return;
                                }
                                i2 = i;
                            }
                            AppMethodBeat.m2505o(54877);
                        } else if (d < ((double) ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getBorderPriority())) {
                            if (!(obj2 == null || C1855t.m3896kH(this.cKd.field_talker))) {
                                C21435d c2CMsgImgUsageStorage = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage();
                                bc = this.cKd.field_talker;
                                String str2 = this.cKd.field_talker;
                                long bZB = C21435d.bZB();
                                String format = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[]{"C2CMsgImgUsage"});
                                a = 0;
                                Cursor rawQuery = c2CMsgImgUsageStorage.pga.rawQuery(format, new String[]{bc, str2, String.valueOf(bZB)});
                                if (rawQuery.moveToNext()) {
                                    a = rawQuery.getInt(0);
                                }
                                rawQuery.close();
                                if (a < 2) {
                                    C4990ab.m7417i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i | 128), Long.valueOf(this.cKd.field_msgId), Integer.valueOf(a));
                                    C43372a.m77395a(this.cKd, i2, 1, d, i3);
                                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CImgAutoDownloader().start();
                                    AppMethodBeat.m2505o(54877);
                                    return;
                                }
                            }
                            C4990ab.m7417i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i), Long.valueOf(this.cKd.field_msgId));
                            i2 = i | 64;
                        } else if (obj2 != null) {
                            if (C43372a.m77396d(fC) < ((double) ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getBorderPriority())) {
                                i |= 256;
                            }
                            C4990ab.m7417i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i | 1), Long.valueOf(this.cKd.field_msgId));
                            C43372a.m77395a(this.cKd, i2, 1, d, i3);
                            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CImgAutoDownloader().start();
                            AppMethodBeat.m2505o(54877);
                            return;
                        } else {
                            C4990ab.m7417i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i), Long.valueOf(this.cKd.field_msgId));
                            i2 = i;
                        }
                        C43372a.m77395a(this.cKd, i2, 1, d, i3);
                        AppMethodBeat.m2505o(54877);
                    }
                }
                i = a;
                if (C43370a.bhI()) {
                }
                C43372a.m77395a(this.cKd, i2, 1, d, i3);
                AppMethodBeat.m2505o(54877);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.priority.a$b */
    class C28668b extends C34675a {
        private C7620bi cKd;

        public C28668b(C7620bi c7620bi) {
            this.cKd = c7620bi;
        }

        public final String getName() {
            return "Priority.onC2CImgOpenTask";
        }

        public final void run() {
            AppMethodBeat.m2504i(54876);
            if (this.cKd.field_createTime <= ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getInstallPriorityTime()) {
                C4990ab.m7417i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", C14835h.formatTime("yyyy-MM-dd HH:mm:ss", this.cKd.field_createTime / 1000));
                AppMethodBeat.m2505o(54876);
                return;
            }
            if (((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null) {
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
                C7620bi c7620bi = this.cKd;
                C7053e.pXa.mo8378a(957, 10, 1, false);
                C23390gi jw = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36895jw(c7620bi.field_msgId);
                if (jw == null) {
                    C4990ab.m7416i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "This Image Sender is Me");
                    C7053e.pXa.mo8378a(957, 13, 1, false);
                    AppMethodBeat.m2505o(54876);
                    return;
                } else if (jw.vIA > 0) {
                    C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgOpen img already use %d", Long.valueOf(c7620bi.field_msgId));
                    AppMethodBeat.m2505o(54876);
                    return;
                } else {
                    int i;
                    if (C1855t.m3896kH(c7620bi.field_talker)) {
                        ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36900fB(jw.ptA, "@all");
                    }
                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36900fB(jw.ptA, jw.vIt);
                    jw.vIA = System.currentTimeMillis();
                    C21434c c2CMsgAutoDownloadResStorage = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
                    long j = c7620bi.field_msgId;
                    c2CMsgAutoDownloadResStorage.pgF.bindLong(1, jw.vIA);
                    c2CMsgAutoDownloadResStorage.pgF.bindLong(2, j);
                    C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateOpenTime %d res %d %d", Integer.valueOf(c2CMsgAutoDownloadResStorage.pgF.executeUpdateDelete()), Long.valueOf(j), Long.valueOf(r4));
                    if (jw.jBT == 3) {
                        i = 1;
                        C7053e.pXa.mo8378a(957, 14, 1, false);
                    } else if (jw.jBT == 2) {
                        i = 3;
                        C7053e.pXa.mo8378a(957, 16, 1, false);
                    } else if (jw.jBT == 4) {
                        i = 4;
                        C7053e.pXa.mo8378a(957, 17, 1, false);
                    } else if (jw.jBT == 5) {
                        i = 5;
                        C7053e.pXa.mo8378a(957, 18, 1, false);
                    } else {
                        i = 2;
                        C7053e.pXa.mo8378a(957, 15, 1, false);
                    }
                    C21437c.m32874a(2, jw.vIA, i, jw);
                }
            }
            AppMethodBeat.m2505o(54876);
        }
    }

    /* renamed from: b */
    public final void mo35525b(long j, boolean z, boolean z2) {
        AppMethodBeat.m2504i(54879);
        if (C1720g.m3531RK() && ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46810a(new C3593a(j, z, z2));
        }
        AppMethodBeat.m2505o(54879);
    }

    /* renamed from: T */
    public final void mo35522T(C7620bi c7620bi) {
        AppMethodBeat.m2504i(54880);
        if (C1720g.m3531RK() && ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46810a(new C28668b(c7620bi));
        }
        AppMethodBeat.m2505o(54880);
    }

    /* renamed from: U */
    public final void mo35523U(C7620bi c7620bi) {
        AppMethodBeat.m2504i(54881);
        if (C1720g.m3531RK() && ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46810a(new C21432c(c7620bi));
        }
        AppMethodBeat.m2505o(54881);
    }

    /* renamed from: a */
    public final void mo35524a(C7620bi c7620bi, Runnable runnable) {
        AppMethodBeat.m2504i(54882);
        if (C1720g.m3531RK() && ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getPriorityTaskRunner().mo46810a(new C3594d(c7620bi, new WeakReference(runnable)));
        }
        AppMethodBeat.m2505o(54882);
    }

    public final boolean bhI() {
        AppMethodBeat.m2504i(54883);
        boolean bhI = C43370a.bhI();
        AppMethodBeat.m2505o(54883);
        return bhI;
    }

    /* renamed from: d */
    static /* synthetic */ double m77396d(double[] dArr) {
        AppMethodBeat.m2504i(54884);
        double max = Math.max(Math.max(dArr[0], dArr[1]), dArr[2]);
        AppMethodBeat.m2505o(54884);
        return max;
    }

    /* renamed from: a */
    static /* synthetic */ void m77395a(C7620bi c7620bi, int i, int i2, double d, int i3) {
        AppMethodBeat.m2504i(54885);
        if (((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null) {
            ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
            if (((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36894jv(c7620bi.field_msgId)) {
                C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgReceive %d %s Update Status %d", Long.valueOf(c7620bi.field_msgId), c7620bi.field_talker, Integer.valueOf(i2));
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().mo36896m(c7620bi.field_msgId, i, i2);
            } else {
                C7053e.pXa.mo8378a(957, 0, 1, false);
                if (C43370a.m77394eW(i, 8)) {
                    C7053e.pXa.mo8378a(957, 1, 1, false);
                }
                if (C43370a.m77394eW(i, 4)) {
                    C7053e.pXa.mo8378a(957, 2, 1, false);
                }
                if (C43370a.m77394eW(i, 2)) {
                    C7053e.pXa.mo8378a(957, 3, 1, false);
                }
                if (C43370a.m77394eW(i, 16)) {
                    C7053e.pXa.mo8378a(957, 4, 1, false);
                }
                if (C43370a.m77394eW(i, 1)) {
                    C7053e.pXa.mo8378a(957, 5, 1, false);
                }
                if (C43370a.m77394eW(i, 32)) {
                    C7053e.pXa.mo8378a(957, 6, 1, false);
                }
                if (C43370a.m77394eW(i, 64)) {
                    C7053e.pXa.mo8378a(957, 7, 1, false);
                }
                if (C43370a.m77394eW(i, 128)) {
                    C7053e.pXa.mo8378a(957, 8, 1, false);
                }
                if (C43370a.m77394eW(i, 256)) {
                    C7053e.pXa.mo8378a(957, 9, 1, false);
                }
                C23390gi c23390gi = new C23390gi();
                c23390gi.vIs = c7620bi.field_msgId;
                c23390gi.ptA = c7620bi.field_talker;
                if (C1855t.m3896kH(c7620bi.field_talker)) {
                    c23390gi.vIt = C5046bo.m7532bc(C1829bf.m3762oy(c7620bi.field_content), "");
                } else {
                    c23390gi.vIt = c7620bi.field_talker;
                }
                c23390gi.vIu = 1;
                c23390gi.vIv = c7620bi.field_createTime;
                c23390gi.vIw = i;
                c23390gi.jBT = i2;
                c23390gi.vIx = 0;
                c23390gi.vIy = c7620bi.field_msgSvrId;
                c23390gi.vIz = 0;
                c23390gi.vIB = d;
                c23390gi.vIC = i3;
                C21434c c2CMsgAutoDownloadResStorage = ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
                c2CMsgAutoDownloadResStorage.pgA.bindLong(1, c23390gi.vIs);
                c2CMsgAutoDownloadResStorage.pgA.bindString(2, c23390gi.ptA);
                c2CMsgAutoDownloadResStorage.pgA.bindString(3, c23390gi.vIt);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(4, (long) c23390gi.vIu);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(5, c23390gi.vIv);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(6, (long) c23390gi.vIw);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(7, (long) c23390gi.jBT);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(8, c23390gi.vIx);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(9, c23390gi.vIy);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(10, (long) c23390gi.vIz);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(11, c23390gi.vIA);
                c2CMsgAutoDownloadResStorage.pgA.bindDouble(12, c23390gi.vIB);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(13, (long) c23390gi.vIC);
                c2CMsgAutoDownloadResStorage.pgA.execute();
                C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", Long.valueOf(c7620bi.field_msgId), c7620bi.field_talker, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Integer.valueOf(i3));
                C21437c.m32874a(3, c23390gi.vIv, 0, c23390gi);
                if (C1855t.m3896kH(c7620bi.field_talker)) {
                    ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36899fA(c23390gi.ptA, "@all");
                }
                ((PluginPriority) C1720g.m3530M(PluginPriority.class)).getC2CMsgImgUsageStorage().mo36899fA(c7620bi.field_talker, c23390gi.vIt);
                AppMethodBeat.m2505o(54885);
                return;
            }
        }
        AppMethodBeat.m2505o(54885);
    }
}
