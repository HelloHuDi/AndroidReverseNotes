package com.tencent.mm.model;

import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.view.d;
import java.util.List;
import java.util.Map;

public final class bf {

    /* renamed from: com.tencent.mm.model.bf$1 */
    public static class AnonymousClass1 implements Runnable {
        final int fmj = 200;
        final int fmk = 30;
        final int fml = 5;
        int fmm = 100;
        final /* synthetic */ List fmn;

        public AnonymousClass1(List list) {
            this.fmn = list;
        }

        public final void run() {
            AppMethodBeat.i(59888);
            ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.fmn.size()));
            for (String str : this.fmn) {
                ((ak) g.K(ak.class)).oq(str);
                long QQ = ((j) g.K(j.class)).Yo().QQ(str);
                if (QQ > 0) {
                    long anU = bo.anU();
                    int i = 0;
                    long j = 0;
                    while (true) {
                        long j2;
                        int i2 = i;
                        if (this.fmm < 200 && this.fmm > 30) {
                            if (j > 500) {
                                i = this.fmm - 5;
                            } else {
                                i = this.fmm + 5;
                            }
                            this.fmm = i;
                        }
                        long anU2 = bo.anU();
                        Cursor h = ((j) g.K(j.class)).bOr().h(str, this.fmm, QQ);
                        long j3 = 0;
                        j = 0;
                        while (true) {
                            j2 = j;
                            if (!h.moveToNext()) {
                                break;
                            }
                            cy biVar = new bi();
                            biVar.d(h);
                            if (j3 < biVar.field_createTime) {
                                j3 = biVar.field_createTime;
                            }
                            j = 1 + j2;
                            bf.m(biVar);
                        }
                        h.close();
                        long anU3 = bo.anU();
                        if (j3 > 0 && j2 > 0) {
                            ((j) g.K(j.class)).bOr().ab(str, j3);
                            ((ak) g.K(ak.class)).o(str, j3);
                        }
                        i = (int) (((long) i2) + j2);
                        j = bo.anU() - anU2;
                        ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bo.anv(str), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(QQ - j3), Long.valueOf(QQ), Long.valueOf(r20 - anU3), Long.valueOf(r20 - anU2), Long.valueOf(bo.anU() - anU), Integer.valueOf(this.fmm));
                        if (j2 <= 0) {
                            break;
                        }
                    }
                    ((j) g.K(j.class)).Yo().O(str, 0);
                }
            }
            AppMethodBeat.o(59888);
        }
    }

    /* renamed from: com.tencent.mm.model.bf$6 */
    public static class AnonymousClass6 implements Runnable {
        final /* synthetic */ List fmn;

        public AnonymousClass6(List list) {
            this.fmn = list;
        }

        public final void run() {
            AppMethodBeat.i(59895);
            ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.fmn.size()));
            for (String str : this.fmn) {
                long j;
                bi Rb = ((j) g.K(j.class)).bOr().Rb(str);
                if (Rb == null) {
                    j = Long.MAX_VALUE;
                } else {
                    j = Rb.field_createTime;
                }
                if (Rb != null && Rb.field_createTime > 0) {
                    ((j) g.K(j.class)).Yo().O(str, j);
                }
                ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", str, Rb, Long.valueOf(j));
                Cursor Rj = ((j) g.K(j.class)).bOr().Rj(str);
                if (Rj != null) {
                    if (Rj.moveToFirst()) {
                        while (!Rj.isAfterLast()) {
                            bi biVar = new bi();
                            biVar.d(Rj);
                            bf.m(biVar);
                            Rj.moveToNext();
                        }
                    }
                    Rj.close();
                    int Rh = ((j) g.K(j.class)).bOr().Rh(str);
                    ab.i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(Rh));
                    ((j) g.K(j.class)).Yo().O(str, 0);
                }
            }
            AppMethodBeat.o(59895);
        }
    }

    public interface a {
        boolean JU();

        void JV();
    }

    public static class b {
        public String fmA;
        public String fmB;
        public String fmC;
        public String fmD;
        public int fmE;
        public int fmF;
        public int fmG;
        public int fmH;
        public String fmI;
        public String fmp;
        public int fmq;
        public int fmr;
        public int fms;
        public String fmt;
        public String fmu;
        public int fmv;
        public long fmw;
        public String fmx;
        public String fmy;
        public String fmz;
        public int scene = 0;
        public String userId;
    }

    public static String al(String str, String str2) {
        AppMethodBeat.i(59897);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59897);
            return null;
        } else if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(59897);
            return str;
        } else {
            str = str2 + ": " + str;
            AppMethodBeat.o(59897);
            return str;
        }
    }

    public static int ox(String str) {
        AppMethodBeat.i(59898);
        if (str == null) {
            ab.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            AppMethodBeat.o(59898);
            return -1;
        } else if (str.length() <= 0) {
            ab.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            AppMethodBeat.o(59898);
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            ab.e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            AppMethodBeat.o(59898);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.o(59898);
                return indexOf;
            }
            ab.e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            AppMethodBeat.o(59898);
            return -1;
        }
    }

    public static String oy(String str) {
        AppMethodBeat.i(59899);
        int ox = ox(str);
        if (ox == -1) {
            AppMethodBeat.o(59899);
            return null;
        }
        String substring = str.substring(0, ox);
        AppMethodBeat.o(59899);
        return substring;
    }

    public static String oz(String str) {
        AppMethodBeat.i(59900);
        int ox = ox(str);
        if (ox == -1) {
            AppMethodBeat.o(59900);
            return str;
        } else if (ox + 2 >= str.length()) {
            AppMethodBeat.o(59900);
            return str;
        } else {
            str = str.substring(ox + 2);
            AppMethodBeat.o(59900);
            return str;
        }
    }

    public static long l(bi biVar) {
        AppMethodBeat.i(59901);
        ad aoO = ((j) g.K(j.class)).XM().aoO(biVar.field_talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            ad adVar = new ad(biVar.field_talker);
            adVar.setType(2);
            jz jzVar = new jz();
            jzVar.cFm.cFn = adVar;
            com.tencent.mm.sdk.b.a.xxA.m(jzVar);
            ((j) g.K(j.class)).XM().Z(adVar);
        }
        long Z = ((j) g.K(j.class)).bOr().Z(biVar);
        AppMethodBeat.o(59901);
        return Z;
    }

    public static int oA(String str) {
        AppMethodBeat.i(59902);
        int oA = ((j) g.K(j.class)).bOr().oA(str);
        AppMethodBeat.o(59902);
        return oA;
    }

    public static boolean oB(String str) {
        AppMethodBeat.i(59903);
        boolean oB = ((j) g.K(j.class)).bOr().oB(str);
        AppMethodBeat.o(59903);
        return oB;
    }

    public static boolean kE(int i) {
        switch (i) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                return true;
            default:
                return false;
        }
    }

    public static long aaa() {
        AppMethodBeat.i(59904);
        long currentTimeMillis = System.currentTimeMillis();
        long aaE = cb.aaE();
        if (Math.abs(currentTimeMillis - aaE) > 300000) {
            ab.w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + aaE + " now:" + currentTimeMillis);
        }
        AppMethodBeat.o(59904);
        return aaE;
    }

    public static long oC(String str) {
        AppMethodBeat.i(59905);
        long aaa = aaa();
        ab.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(aaa));
        if (str != null) {
            bi Rb = ((j) g.K(j.class)).bOr().Rb(str);
            if (Rb != null) {
                ab.i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(Rb.field_msgId), Long.valueOf(aaa));
                if (Rb.field_createTime + 1 > aaa) {
                    long j = Rb.field_createTime + 1;
                    AppMethodBeat.o(59905);
                    return j;
                }
            }
        }
        AppMethodBeat.o(59905);
        return aaa;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long q(String str, long j) {
        long j2;
        AppMethodBeat.i(59906);
        if (str != null) {
            bi Rb = ((j) g.K(j.class)).bOr().Rb(str);
            if (Rb != null) {
                j2 = Rb.field_createTime + 1;
                if (j2 <= j * 1000) {
                    AppMethodBeat.o(59906);
                    return j2;
                }
                j2 = j * 1000;
                AppMethodBeat.o(59906);
                return j2;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    private static int kF(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
                return 49;
            default:
                return i;
        }
    }

    public static void m(bi biVar) {
        AppMethodBeat.i(59907);
        if (biVar == null) {
            AppMethodBeat.o(59907);
            return;
        }
        e bg = e.d.bg(Integer.valueOf(kF(biVar.getType())));
        if (bg != null) {
            bg.a(new c(biVar));
        }
        ch chVar = new ch();
        chVar.cvw.cvx = biVar.field_msgId;
        chVar.cvw.talker = biVar.field_talker;
        chVar.cvw.msgType = biVar.getType();
        com.tencent.mm.sdk.b.a.xxA.m(chVar);
        AppMethodBeat.o(59907);
    }

    public static void X(List<Long> list) {
        AppMethodBeat.i(59908);
        if (list.size() == 0) {
            AppMethodBeat.o(59908);
            return;
        }
        for (Long longValue : list) {
            fm(longValue.longValue());
        }
        AppMethodBeat.o(59908);
    }

    public static int fm(long j) {
        AppMethodBeat.i(59909);
        bi jf = ((j) g.K(j.class)).bOr().jf(j);
        if (jf.field_msgId != j) {
            AppMethodBeat.o(59909);
            return 0;
        }
        m(jf);
        int jg = ((j) g.K(j.class)).bOr().jg(j);
        AppMethodBeat.o(59909);
        return jg;
    }

    public static int r(String str, long j) {
        AppMethodBeat.i(59910);
        bi Q = ((j) g.K(j.class)).bOr().Q(str, j);
        if (Q.field_msgSvrId != j) {
            AppMethodBeat.o(59910);
            return 0;
        }
        m(Q);
        int aa = ((j) g.K(j.class)).bOr().aa(str, j);
        AppMethodBeat.o(59910);
        return aa;
    }

    public static int oD(String str) {
        AppMethodBeat.i(59911);
        int Rh = ((j) g.K(j.class)).bOr().Rh(str);
        AppMethodBeat.o(59911);
        return Rh;
    }

    public static int a(final String str, final a aVar) {
        AppMethodBeat.i(59912);
        ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", str, bo.dpG());
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", str);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(59889);
                    if (aVar != null) {
                        aVar.JV();
                    }
                    AppMethodBeat.o(59889);
                }
            });
            AppMethodBeat.o(59912);
        } else {
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                final int fmj = 200;
                final int fmk = 30;
                final int fml = 5;
                int fmm = 100;

                public final void run() {
                    AppMethodBeat.i(59890);
                    try {
                        long j;
                        bi Rb = ((j) g.K(j.class)).bOr().Rb(str);
                        if (Rb == null) {
                            j = Long.MAX_VALUE;
                        } else {
                            j = Rb.field_createTime;
                        }
                        ((j) g.K(j.class)).Yo().O(str, j);
                        ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Rb, Long.valueOf(j));
                        ((ak) g.K(ak.class)).oq(str);
                        long anU = bo.anU();
                        long j2 = 0;
                        int i = 0;
                        long j3;
                        do {
                            if (this.fmm < 200 && this.fmm > 30) {
                                int i2;
                                if (j2 > 500) {
                                    i2 = this.fmm - 5;
                                } else {
                                    i2 = this.fmm + 5;
                                }
                                this.fmm = i2;
                            }
                            long anU2 = bo.anU();
                            Cursor h = ((j) g.K(j.class)).bOr().h(str, this.fmm, j);
                            long j4 = 0;
                            j3 = 0;
                            while (h.moveToNext()) {
                                cy biVar = new bi();
                                biVar.d(h);
                                if (j4 < biVar.field_createTime) {
                                    j2 = biVar.field_createTime;
                                } else {
                                    j2 = j4;
                                }
                                j3++;
                                bf.m(biVar);
                                j4 = j2;
                            }
                            h.close();
                            long anU3 = bo.anU();
                            if (j4 > 0 && j3 > 0) {
                                ((j) g.K(j.class)).bOr().ab(str, j4);
                                ((ak) g.K(ak.class)).o(str, j4);
                            }
                            i = (int) (((long) i) + j3);
                            j2 = bo.anU() - anU2;
                            ab.i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", bo.anv(str), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j - j4), Long.valueOf(j), Long.valueOf(r18 - anU3), Long.valueOf(r18 - anU2), Long.valueOf(bo.anU() - anU), Integer.valueOf(this.fmm));
                        } while (j3 > 0);
                        AppMethodBeat.o(59890);
                    } catch (b e) {
                        ab.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", e, "", new Object[0]);
                        AppMethodBeat.o(59890);
                    }
                }
            }, "deleteMsgByTalker");
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(59891);
                    if (aVar != null) {
                        aVar.JV();
                    }
                    AppMethodBeat.o(59891);
                }
            });
            AppMethodBeat.o(59912);
        }
        return 0;
    }

    public static void a(final a aVar) {
        AppMethodBeat.i(59913);
        g.RQ();
        g.RS().aa(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(59893);
                if (aVar == null || !aVar.JU()) {
                    ((j) g.K(j.class)).XR().dsJ();
                    if (aVar == null || !aVar.JU()) {
                        bf.aab();
                        if (aVar == null || !aVar.JU()) {
                            bf.aac();
                            if (aVar == null || !aVar.JU()) {
                                List Re = ((j) g.K(j.class)).bOr().Re("bottlemessage");
                                if (Re != null) {
                                    for (int i2 = 0; i2 < Re.size(); i2++) {
                                        bf.m((bi) Re.get(i2));
                                    }
                                }
                                ((j) g.K(j.class)).bOr().Rg("bottlemessage");
                                if (aVar == null || !aVar.JU()) {
                                    List Re2 = ((j) g.K(j.class)).bOr().Re(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                    if (Re2 != null) {
                                        while (i < Re2.size()) {
                                            bf.m((bi) Re2.get(i));
                                            i++;
                                        }
                                    }
                                    ((j) g.K(j.class)).bOr().Rg(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                }
                            }
                        }
                    }
                }
                if (aVar != null) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(59892);
                            aVar.JV();
                            AppMethodBeat.o(59892);
                        }
                    });
                }
                AppMethodBeat.o(59893);
            }

            public final String toString() {
                AppMethodBeat.i(59894);
                String str = super.toString() + "|deleteAllMsg";
                AppMethodBeat.o(59894);
                return str;
            }
        });
        AppMethodBeat.o(59913);
    }

    public static void aab() {
        AppMethodBeat.i(59914);
        List Re = ((j) g.K(j.class)).bOr().Re("qmessage");
        if (Re != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Re.size()) {
                    break;
                }
                m((bi) Re.get(i2));
                i = i2 + 1;
            }
        }
        ((j) g.K(j.class)).bOr().Rg("qmessage");
        AppMethodBeat.o(59914);
    }

    public static void aac() {
        AppMethodBeat.i(59915);
        List Re = ((j) g.K(j.class)).bOr().Re("tmessage");
        if (Re != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Re.size()) {
                    break;
                }
                m((bi) Re.get(i2));
                i = i2 + 1;
            }
        }
        ((j) g.K(j.class)).bOr().Rg("tmessage");
        AppMethodBeat.o(59915);
    }

    public static b oE(String str) {
        AppMethodBeat.i(59916);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59916);
            return null;
        }
        try {
            Map z = br.z(str, "msgsource");
            if (z == null || z.isEmpty()) {
                AppMethodBeat.o(59916);
                return null;
            }
            b bVar = new b();
            bVar.fmp = (String) z.get(".msgsource.bizmsg.msgcluster");
            bVar.fmu = (String) z.get(".msgsource.kf.kf_worker");
            bVar.fmt = bo.nullAsNil((String) z.get(".msgsource.bizmsg.bizclientmsgid"));
            bVar.fmy = bo.nullAsNil((String) z.get(".msgsource.enterprise_info.qy_msg_type"));
            bVar.fmz = bo.nullAsNil((String) z.get(".msgsource.enterprise_info.bizchat_id"));
            bVar.fmA = bo.nullAsNil((String) z.get(".msgsource.enterprise_info.bizchat_ver"));
            bVar.userId = bo.nullAsNil((String) z.get(".msgsource.enterprise_info.user_id"));
            bVar.fmB = bo.nullAsNil((String) z.get(".msgsource.enterprise_info.user_nickname"));
            bVar.fmC = bo.nullAsNil((String) z.get(".msgsource.enterprise_info.sync_from_qy_im"));
            bVar.fmx = (String) z.get(".msgsource.strangerantispamticket.$ticket");
            bVar.scene = bo.getInt((String) z.get(".msgsource.strangerantispamticket.$scene"), 0);
            bVar.fmD = (String) z.get(".msgsource.NotAutoDownloadRange");
            bVar.fmE = bo.getInt((String) z.get(".msgsource.DownloadLimitKbps"), 0);
            bVar.fmF = bo.getInt((String) z.get(".msgsource.videopreloadlen"), 0);
            bVar.fmG = bo.getInt((String) z.get(".msgsource.PreDownload"), 0);
            bVar.fmH = bo.getInt((String) z.get(".msgsource.PreDownloadNetType"), 0);
            bVar.fmI = (String) z.get(".msgsource.NoPreDownloadRange");
            bVar.fmq = bo.getInt((String) z.get(".msgsource.msg_cluster_type"), -1);
            bVar.fmr = bo.getInt((String) z.get(".msgsource.service_type"), -1);
            bVar.fms = bo.getInt((String) z.get(".msgsource.scene"), -1);
            bVar.fmv = bo.getInt((String) z.get(".msgsource.bizmsg.msg_predict"), 0);
            bVar.fmw = bo.getLong((String) z.get(".msgsource.bizflag"), 0);
            AppMethodBeat.o(59916);
            return bVar;
        } catch (Exception e) {
            ab.e("MicroMsg.MsgInfoStorageLogic", "exception:%s", bo.l(e));
            ab.e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            AppMethodBeat.o(59916);
            return null;
        }
    }

    public static String oF(String str) {
        AppMethodBeat.i(59917);
        b oE = oE(str);
        if (oE == null) {
            AppMethodBeat.o(59917);
            return null;
        }
        String str2 = oE.fmu;
        AppMethodBeat.o(59917);
        return str2;
    }

    public static void a(bi biVar, com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(59918);
        if (biVar == null || aVar == null || aVar.eAB == null) {
            ab.e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", bo.dpG());
            AppMethodBeat.o(59918);
        } else if (biVar.field_msgSvrId != aVar.eAB.ptF) {
            AppMethodBeat.o(59918);
        } else {
            cm cmVar = aVar.eAB;
            if (biVar.field_isSend == 0 || cmVar.vEI != 0) {
                if (biVar.field_msgSeq == 0 && cmVar.vEI != 0) {
                    biVar.eL((long) cmVar.vEI);
                }
                int i = biVar.field_flag;
                if (aVar.fsU) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (aVar.fsV) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (aVar.fsW) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                biVar.hY(i);
                if (biVar.field_msgId == 0 && aVar.fsU) {
                    biVar.eJ(aVar.fsX);
                }
                AppMethodBeat.o(59918);
                return;
            }
            AppMethodBeat.o(59918);
        }
    }

    public static boolean c(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(59919);
        if (aVar == null || aVar.eAB == null) {
            AppMethodBeat.o(59919);
            return false;
        }
        cm cmVar = aVar.eAB;
        bi Q = ((j) g.K(j.class)).bOr().Q(aa.a(cmVar.vEB), cmVar.ptF);
        if (Q.field_msgId == 0) {
            AppMethodBeat.o(59919);
            return false;
        } else if (Q.field_isSend == 0 || cmVar.vEI != 0) {
            int i = Q.field_flag;
            if (aVar.fsU) {
                i |= 2;
            } else {
                i &= -3;
            }
            if (aVar.fsV) {
                i |= 1;
            } else {
                i &= -2;
            }
            if (aVar.fsW) {
                i |= 4;
            } else {
                i &= -5;
            }
            if (i != Q.field_flag) {
                ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", Integer.valueOf(cmVar.nao), Integer.valueOf(i), Integer.valueOf(Q.field_flag));
                Q.hY(i);
                ((j) g.K(j.class)).bOr().b(Q.field_msgSvrId, Q);
                AppMethodBeat.o(59919);
                return true;
            }
            AppMethodBeat.o(59919);
            return false;
        } else {
            AppMethodBeat.o(59919);
            return false;
        }
    }

    public static int d(com.tencent.mm.ai.e.a aVar) {
        int i = 0;
        if (aVar.fsU) {
            i = 2;
        }
        if (aVar.fsV) {
            i |= 1;
        }
        if (aVar.fsW) {
            return i | 4;
        }
        return i;
    }

    public static String b(boolean z, String str, int i) {
        AppMethodBeat.i(59920);
        if (z && str != null && i == 0) {
            str = oz(str);
        }
        AppMethodBeat.o(59920);
        return str;
    }

    public static long g(String str, long j, long j2) {
        AppMethodBeat.i(59921);
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        if (str != null) {
            bi Rb = ((j) g.K(j.class)).bOr().Rb(str);
            if (Rb != null) {
                j4 = Rb.field_createTime;
            }
            j5 = ((j) g.K(j.class)).bOr().Rs(str);
        }
        if (j5 == j4) {
            if (j3 == j4) {
                j3++;
                AppMethodBeat.o(59921);
                return j3;
            }
            AppMethodBeat.o(59921);
            return j3;
        } else if (j5 >= j4) {
            ab.w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
            AppMethodBeat.o(59921);
            return j3;
        } else if (j3 == j5) {
            j3--;
            AppMethodBeat.o(59921);
            return j3;
        } else if (j3 == j4) {
            j3++;
            AppMethodBeat.o(59921);
            return j3;
        } else if (j2 == 0 || j3 > j4) {
            AppMethodBeat.o(59921);
            return j3;
        } else {
            bi S = ((j) g.K(j.class)).bOr().S(str, j3);
            if (!(S.field_msgSeq == 0 || S.field_msgSeq == j2)) {
                cy W;
                ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", Long.valueOf(S.field_msgSeq), Long.valueOf(j2), Long.valueOf(S.field_createTime), Long.valueOf(j3));
                if (j2 < S.field_msgSeq) {
                    W = ((j) g.K(j.class)).bOr().W(str, j3 - 1000);
                } else {
                    W = ((j) g.K(j.class)).bOr().V(str, 1000 + j3);
                }
                if (W.field_msgSeq == 0 || W.field_msgSeq == j2) {
                    ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", Long.valueOf(S.field_msgSeq), Long.valueOf(j2), Long.valueOf(S.field_createTime), Long.valueOf(j3));
                } else {
                    j4 = W.field_msgSeq < j2 ? W.field_createTime + 1 : W.field_createTime - 1;
                    ab.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", Long.valueOf(S.field_msgSeq), Long.valueOf(W.field_msgSeq), Long.valueOf(j2), Long.valueOf(S.field_createTime), Long.valueOf(W.field_createTime), Long.valueOf(j4));
                    AppMethodBeat.o(59921);
                    return j4;
                }
            }
            j4 = j3;
            AppMethodBeat.o(59921);
            return j4;
        }
    }

    public static String ow(String str) {
        AppMethodBeat.i(59896);
        int ox = ox(str);
        if (ox != -1) {
            str = str.substring(ox + 1).trim();
            AppMethodBeat.o(59896);
            return str;
        }
        AppMethodBeat.o(59896);
        return str;
    }
}
