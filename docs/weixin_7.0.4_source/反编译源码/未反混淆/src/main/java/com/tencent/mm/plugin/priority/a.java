package com.tencent.mm.plugin.priority;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.lang.ref.WeakReference;

public final class a implements com.tencent.mm.plugin.comm.a.b {

    class a extends com.tencent.mm.plugin.priority.b.b.a {
        private long cvx;
        private boolean cxT;
        private boolean eVT;

        public a(long j, boolean z, boolean z2) {
            this.cvx = j;
            this.cxT = z;
            this.eVT = z2;
        }

        public final String getName() {
            return "Priority.onC2CImgDownloadedTask";
        }

        public final void run() {
            AppMethodBeat.i(54875);
            bi jf = ((j) g.K(j.class)).bOr().jf(this.cvx);
            if (jf.field_createTime <= ((PluginPriority) g.M(PluginPriority.class)).getInstallPriorityTime()) {
                ab.i("MicroMsg.Priority.PriorityService", "onC2CImgDownloaded time condition not support %s", h.formatTime("yyyy-MM-dd HH:mm:ss", jf.field_createTime / 1000));
                AppMethodBeat.o(54875);
                return;
            }
            if (((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null) {
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
                boolean z = this.cxT;
                boolean z2 = this.eVT;
                if (z) {
                    gi jw = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().jw(jf.field_msgId);
                    if (jw == null) {
                        ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "sender img %d", Long.valueOf(jf.field_msgId));
                        AppMethodBeat.o(54875);
                        return;
                    } else if (jw.jBT == 3) {
                        ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "already auto download msgid %d", Long.valueOf(jf.field_msgId));
                        AppMethodBeat.o(54875);
                        return;
                    } else {
                        e.pXa.a(957, 20, 1, false);
                        if (jw != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            com.tencent.mm.at.e fI = o.ahl().fI(jw.vIy);
                            jw.vIz = fI.frO;
                            com.tencent.mm.plugin.priority.b.c.a(1, currentTimeMillis, 0, jw);
                            com.tencent.mm.plugin.priority.b.a.c c2CMsgAutoDownloadResStorage = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
                            long j = jw.vIs;
                            int i = fI.frO;
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(1, currentTimeMillis);
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(2, 3);
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(3, (long) i);
                            c2CMsgAutoDownloadResStorage.pgE.bindLong(4, j);
                            ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatusAndDownloadTime %d res %d %d %d", Integer.valueOf(c2CMsgAutoDownloadResStorage.pgE.executeUpdateDelete()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Integer.valueOf(3));
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 1)) {
                                e.pXa.a(957, 21, 1, false);
                                e.pXa.a(957, 22, (long) fI.frO, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 8)) {
                                e.pXa.a(957, 23, 1, false);
                                e.pXa.a(957, 24, (long) fI.frO, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 2) || com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 4)) {
                                e.pXa.a(957, 25, 1, false);
                                e.pXa.a(957, 26, (long) fI.frO, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 16)) {
                                e.pXa.a(957, 27, 1, false);
                                e.pXa.a(957, 28, (long) fI.frO, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 32)) {
                                e.pXa.a(957, 29, 1, false);
                                e.pXa.a(957, 30, (long) fI.frO, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 64)) {
                                e.pXa.a(957, 33, 1, false);
                                e.pXa.a(957, 34, (long) fI.frO, false);
                            }
                            if (com.tencent.mm.plugin.priority.a.a.a.eW(jw.vIw, 128)) {
                                e.pXa.a(957, 35, 1, false);
                                e.pXa.a(957, 36, (long) fI.frO, false);
                            }
                            AppMethodBeat.o(54875);
                            return;
                        }
                        e.pXa.a(957, 31, 1, false);
                        AppMethodBeat.o(54875);
                        return;
                    }
                }
                if (z2) {
                    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "updateStatus download cancel %d", Long.valueOf(jf.field_msgId));
                    ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(jf.field_msgId, 1);
                } else {
                    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "updateStatus download fail %d", Long.valueOf(jf.field_msgId));
                    ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().z(jf.field_msgId, 4);
                }
                e.pXa.a(957, 32, 1, false);
            }
            AppMethodBeat.o(54875);
        }
    }

    class d extends com.tencent.mm.plugin.priority.b.b.a {
        private bi cKd;
        private WeakReference<Runnable> pgj;

        d(bi biVar, WeakReference<Runnable> weakReference) {
            this.cKd = biVar;
            this.pgj = weakReference;
        }

        public final String getName() {
            return "Priority.onC2CImgScrollTask";
        }

        public final void run() {
            AppMethodBeat.i(54878);
            if (!com.tencent.mm.plugin.priority.a.a.a.bhI() || this.cKd.field_createTime > ((PluginPriority) g.M(PluginPriority.class)).getInstallPriorityTime()) {
                ab.i("MicroMsg.Priority.PriorityService", "C2CImgScrollTask Start To Auto Download %d MsgId %d", Integer.valueOf(32), Long.valueOf(this.cKd.field_msgId));
                if (this.pgj.get() != null) {
                    ((Runnable) this.pgj.get()).run();
                }
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
                bi biVar = this.cKd;
                gi jw = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().jw(biVar.field_msgId);
                if (jw == null) {
                    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "This Image Sender is Me");
                    AppMethodBeat.o(54878);
                    return;
                }
                if (jw.jBT == 1) {
                    ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().m(biVar.field_msgId, 32, 2);
                }
                AppMethodBeat.o(54878);
                return;
            }
            ab.i("MicroMsg.Priority.PriorityService", "onC2CImgScroll time condition not support %s", h.formatTime("yyyy-MM-dd HH:mm:ss", this.cKd.field_createTime / 1000));
            AppMethodBeat.o(54878);
        }
    }

    class c extends com.tencent.mm.plugin.priority.b.b.a {
        private bi cKd;

        public c(bi biVar) {
            this.cKd = biVar;
        }

        public final String getName() {
            return "Priority.onC2CImgReceiveTask";
        }

        /* JADX WARNING: Removed duplicated region for block: B:63:0x02ed  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x012f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.i(54877);
            if (this.cKd.field_createTime <= ((PluginPriority) g.M(PluginPriority.class)).getInstallPriorityTime()) {
                ab.i("MicroMsg.Priority.PriorityService", "onC2CImgReceive time condition not support %s", h.formatTime("yyyy-MM-dd HH:mm:ss", this.cKd.field_createTime / 1000));
                AppMethodBeat.o(54877);
            } else if (((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().jv(this.cKd.field_msgId)) {
                ab.i("MicroMsg.Priority.PriorityService", "already exist msg %d", Long.valueOf(this.cKd.field_msgId));
                AppMethodBeat.o(54877);
            } else {
                double[] fC;
                String bc;
                int a;
                Object obj;
                int i;
                int i2;
                int i3 = 1;
                if (t.kH(this.cKd.field_talker)) {
                    fC = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fC(this.cKd.field_talker, "@all");
                } else {
                    fC = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fC(this.cKd.field_talker, this.cKd.field_talker);
                }
                double d = a.d(fC);
                if (t.kH(this.cKd.field_talker)) {
                    bc = bo.bc(bf.oy(this.cKd.field_content), "");
                    if (!bo.isNullOrNil(bc)) {
                        double[] fC2 = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fC(this.cKd.field_talker, bc);
                        a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mmc2c_img_auto_download_talker_border_priority, 101);
                        if (a.d(fC2) > d && a.d(fC2) > ((double) a)) {
                            d = a.d(fC2);
                            i3 = 2;
                        }
                    }
                }
                Object obj2 = 1;
                a = 0;
                com.tencent.mm.model.bf.b oE = bf.oE(this.cKd.dqJ);
                if (oE == null) {
                    obj = null;
                } else {
                    String str = oE.fmD;
                    if (bo.isNullOrNil(str) || !com.tencent.mm.modelcontrol.b.rR(str)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                if (obj == null) {
                    a = 4;
                    obj2 = null;
                }
                if (!com.tencent.mm.plugin.priority.a.a.a.a.bZw()) {
                    a |= 2;
                    obj2 = null;
                }
                if (!com.tencent.mm.plugin.priority.a.a.a.a.bZx()) {
                    a |= 16;
                    obj2 = null;
                }
                if (com.tencent.mm.plugin.priority.a.a.a.a.UE(this.cKd.field_talker)) {
                    a |= 8;
                    if (com.tencent.mm.plugin.priority.a.a.a.bZu()) {
                        obj2 = null;
                        i = a;
                        if (com.tencent.mm.plugin.priority.a.a.a.bhI()) {
                            if (com.tencent.mm.plugin.priority.a.a.a.bZu()) {
                                if (obj2 != null) {
                                    a.a(this.cKd, i | 1, 2, d, i3);
                                    AppMethodBeat.o(54877);
                                    return;
                                }
                                i2 = i;
                            }
                            AppMethodBeat.o(54877);
                        } else if (d < ((double) ((PluginPriority) g.M(PluginPriority.class)).getBorderPriority())) {
                            if (!(obj2 == null || t.kH(this.cKd.field_talker))) {
                                com.tencent.mm.plugin.priority.b.a.d c2CMsgImgUsageStorage = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage();
                                bc = this.cKd.field_talker;
                                String str2 = this.cKd.field_talker;
                                long bZB = com.tencent.mm.plugin.priority.b.a.d.bZB();
                                String format = String.format("SELECT dayreceivecount FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[]{"C2CMsgImgUsage"});
                                a = 0;
                                Cursor rawQuery = c2CMsgImgUsageStorage.pga.rawQuery(format, new String[]{bc, str2, String.valueOf(bZB)});
                                if (rawQuery.moveToNext()) {
                                    a = rawQuery.getInt(0);
                                }
                                rawQuery.close();
                                if (a < 2) {
                                    ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i | 128), Long.valueOf(this.cKd.field_msgId), Integer.valueOf(a));
                                    a.a(this.cKd, i2, 1, d, i3);
                                    ((PluginPriority) g.M(PluginPriority.class)).getC2CImgAutoDownloader().start();
                                    AppMethodBeat.o(54877);
                                    return;
                                }
                            }
                            ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i), Long.valueOf(this.cKd.field_msgId));
                            i2 = i | 64;
                        } else if (obj2 != null) {
                            if (a.d(fC) < ((double) ((PluginPriority) g.M(PluginPriority.class)).getBorderPriority())) {
                                i |= 256;
                            }
                            ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i | 1), Long.valueOf(this.cKd.field_msgId));
                            a.a(this.cKd, i2, 1, d, i3);
                            ((PluginPriority) g.M(PluginPriority.class)).getC2CImgAutoDownloader().start();
                            AppMethodBeat.o(54877);
                            return;
                        } else {
                            ab.i("MicroMsg.Priority.PriorityService", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(d), Integer.valueOf(i3), Integer.valueOf(i), Long.valueOf(this.cKd.field_msgId));
                            i2 = i;
                        }
                        a.a(this.cKd, i2, 1, d, i3);
                        AppMethodBeat.o(54877);
                    }
                }
                i = a;
                if (com.tencent.mm.plugin.priority.a.a.a.bhI()) {
                }
                a.a(this.cKd, i2, 1, d, i3);
                AppMethodBeat.o(54877);
            }
        }
    }

    class b extends com.tencent.mm.plugin.priority.b.b.a {
        private bi cKd;

        public b(bi biVar) {
            this.cKd = biVar;
        }

        public final String getName() {
            return "Priority.onC2CImgOpenTask";
        }

        public final void run() {
            AppMethodBeat.i(54876);
            if (this.cKd.field_createTime <= ((PluginPriority) g.M(PluginPriority.class)).getInstallPriorityTime()) {
                ab.i("MicroMsg.Priority.PriorityService", "onC2CImgOpen time condition not support %s", h.formatTime("yyyy-MM-dd HH:mm:ss", this.cKd.field_createTime / 1000));
                AppMethodBeat.o(54876);
                return;
            }
            if (((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null) {
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
                bi biVar = this.cKd;
                e.pXa.a(957, 10, 1, false);
                gi jw = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().jw(biVar.field_msgId);
                if (jw == null) {
                    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "This Image Sender is Me");
                    e.pXa.a(957, 13, 1, false);
                    AppMethodBeat.o(54876);
                    return;
                } else if (jw.vIA > 0) {
                    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgOpen img already use %d", Long.valueOf(biVar.field_msgId));
                    AppMethodBeat.o(54876);
                    return;
                } else {
                    int i;
                    if (t.kH(biVar.field_talker)) {
                        ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fB(jw.ptA, "@all");
                    }
                    ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fB(jw.ptA, jw.vIt);
                    jw.vIA = System.currentTimeMillis();
                    com.tencent.mm.plugin.priority.b.a.c c2CMsgAutoDownloadResStorage = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
                    long j = biVar.field_msgId;
                    c2CMsgAutoDownloadResStorage.pgF.bindLong(1, jw.vIA);
                    c2CMsgAutoDownloadResStorage.pgF.bindLong(2, j);
                    ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateOpenTime %d res %d %d", Integer.valueOf(c2CMsgAutoDownloadResStorage.pgF.executeUpdateDelete()), Long.valueOf(j), Long.valueOf(r4));
                    if (jw.jBT == 3) {
                        i = 1;
                        e.pXa.a(957, 14, 1, false);
                    } else if (jw.jBT == 2) {
                        i = 3;
                        e.pXa.a(957, 16, 1, false);
                    } else if (jw.jBT == 4) {
                        i = 4;
                        e.pXa.a(957, 17, 1, false);
                    } else if (jw.jBT == 5) {
                        i = 5;
                        e.pXa.a(957, 18, 1, false);
                    } else {
                        i = 2;
                        e.pXa.a(957, 15, 1, false);
                    }
                    com.tencent.mm.plugin.priority.b.c.a(2, jw.vIA, i, jw);
                }
            }
            AppMethodBeat.o(54876);
        }
    }

    public final void b(long j, boolean z, boolean z2) {
        AppMethodBeat.i(54879);
        if (g.RK() && ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().a(new a(j, z, z2));
        }
        AppMethodBeat.o(54879);
    }

    public final void T(bi biVar) {
        AppMethodBeat.i(54880);
        if (g.RK() && ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().a(new b(biVar));
        }
        AppMethodBeat.o(54880);
    }

    public final void U(bi biVar) {
        AppMethodBeat.i(54881);
        if (g.RK() && ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().a(new c(biVar));
        }
        AppMethodBeat.o(54881);
    }

    public final void a(bi biVar, Runnable runnable) {
        AppMethodBeat.i(54882);
        if (g.RK() && ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner() != null) {
            ((PluginPriority) g.M(PluginPriority.class)).getPriorityTaskRunner().a(new d(biVar, new WeakReference(runnable)));
        }
        AppMethodBeat.o(54882);
    }

    public final boolean bhI() {
        AppMethodBeat.i(54883);
        boolean bhI = com.tencent.mm.plugin.priority.a.a.a.bhI();
        AppMethodBeat.o(54883);
        return bhI;
    }

    static /* synthetic */ double d(double[] dArr) {
        AppMethodBeat.i(54884);
        double max = Math.max(Math.max(dArr[0], dArr[1]), dArr[2]);
        AppMethodBeat.o(54884);
        return max;
    }

    static /* synthetic */ void a(bi biVar, int i, int i2, double d, int i3) {
        AppMethodBeat.i(54885);
        if (((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic() != null) {
            ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResLogic();
            if (((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().jv(biVar.field_msgId)) {
                ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgReceive %d %s Update Status %d", Long.valueOf(biVar.field_msgId), biVar.field_talker, Integer.valueOf(i2));
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage().m(biVar.field_msgId, i, i2);
            } else {
                e.pXa.a(957, 0, 1, false);
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 8)) {
                    e.pXa.a(957, 1, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 4)) {
                    e.pXa.a(957, 2, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 2)) {
                    e.pXa.a(957, 3, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 16)) {
                    e.pXa.a(957, 4, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 1)) {
                    e.pXa.a(957, 5, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 32)) {
                    e.pXa.a(957, 6, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 64)) {
                    e.pXa.a(957, 7, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 128)) {
                    e.pXa.a(957, 8, 1, false);
                }
                if (com.tencent.mm.plugin.priority.a.a.a.eW(i, 256)) {
                    e.pXa.a(957, 9, 1, false);
                }
                gi giVar = new gi();
                giVar.vIs = biVar.field_msgId;
                giVar.ptA = biVar.field_talker;
                if (t.kH(biVar.field_talker)) {
                    giVar.vIt = bo.bc(bf.oy(biVar.field_content), "");
                } else {
                    giVar.vIt = biVar.field_talker;
                }
                giVar.vIu = 1;
                giVar.vIv = biVar.field_createTime;
                giVar.vIw = i;
                giVar.jBT = i2;
                giVar.vIx = 0;
                giVar.vIy = biVar.field_msgSvrId;
                giVar.vIz = 0;
                giVar.vIB = d;
                giVar.vIC = i3;
                com.tencent.mm.plugin.priority.b.a.c c2CMsgAutoDownloadResStorage = ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgAutoDownloadResStorage();
                c2CMsgAutoDownloadResStorage.pgA.bindLong(1, giVar.vIs);
                c2CMsgAutoDownloadResStorage.pgA.bindString(2, giVar.ptA);
                c2CMsgAutoDownloadResStorage.pgA.bindString(3, giVar.vIt);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(4, (long) giVar.vIu);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(5, giVar.vIv);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(6, (long) giVar.vIw);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(7, (long) giVar.jBT);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(8, giVar.vIx);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(9, giVar.vIy);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(10, (long) giVar.vIz);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(11, giVar.vIA);
                c2CMsgAutoDownloadResStorage.pgA.bindDouble(12, giVar.vIB);
                c2CMsgAutoDownloadResStorage.pgA.bindLong(13, (long) giVar.vIC);
                c2CMsgAutoDownloadResStorage.pgA.execute();
                ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResLogic", "onImgReceive %d %s Insert Res %d %d %.2f %d", Long.valueOf(biVar.field_msgId), biVar.field_talker, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Integer.valueOf(i3));
                com.tencent.mm.plugin.priority.b.c.a(3, giVar.vIv, 0, giVar);
                if (t.kH(biVar.field_talker)) {
                    ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fA(giVar.ptA, "@all");
                }
                ((PluginPriority) g.M(PluginPriority.class)).getC2CMsgImgUsageStorage().fA(biVar.field_talker, giVar.vIt);
                AppMethodBeat.o(54885);
                return;
            }
        }
        AppMethodBeat.o(54885);
    }
}
