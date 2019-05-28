package com.tencent.p177mm.model;

import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p230g.p231a.C6466ch;
import com.tencent.p177mm.p230g.p231a.C6503jz;
import com.tencent.p177mm.p230g.p711c.C6575cy;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.view.C31128d;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.model.bf */
public final class C1829bf {

    /* renamed from: com.tencent.mm.model.bf$1 */
    public static class C18201 implements Runnable {
        final int fmj = 200;
        final int fmk = 30;
        final int fml = 5;
        int fmm = 100;
        final /* synthetic */ List fmn;

        public C18201(List list) {
            this.fmn = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(59888);
            C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.fmn.size()));
            for (String str : this.fmn) {
                ((C6664ak) C1720g.m3528K(C6664ak.class)).mo14895oq(str);
                long QQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(str);
                if (QQ > 0) {
                    long anU = C5046bo.anU();
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
                        long anU2 = C5046bo.anU();
                        Cursor h = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15337h(str, this.fmm, QQ);
                        long j3 = 0;
                        j = 0;
                        while (true) {
                            j2 = j;
                            if (!h.moveToNext()) {
                                break;
                            }
                            C6575cy c7620bi = new C7620bi();
                            c7620bi.mo8995d(h);
                            if (j3 < c7620bi.field_createTime) {
                                j3 = c7620bi.field_createTime;
                            }
                            j = 1 + j2;
                            C1829bf.m3753m(c7620bi);
                        }
                        h.close();
                        long anU3 = C5046bo.anU();
                        if (j3 > 0 && j2 > 0) {
                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15295ab(str, j3);
                            ((C6664ak) C1720g.m3528K(C6664ak.class)).mo14894o(str, j3);
                        }
                        i = (int) (((long) i2) + j2);
                        j = C5046bo.anU() - anU2;
                        C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel checkUnfinishedDeleteMsgTask:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", C5046bo.anv(str), Integer.valueOf(i), Long.valueOf(j2), Long.valueOf(QQ - j3), Long.valueOf(QQ), Long.valueOf(r20 - anU3), Long.valueOf(r20 - anU2), Long.valueOf(C5046bo.anU() - anU), Integer.valueOf(this.fmm));
                        if (j2 <= 0) {
                            break;
                        }
                    }
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7906O(str, 0);
                }
            }
            AppMethodBeat.m2505o(59888);
        }
    }

    /* renamed from: com.tencent.mm.model.bf$6 */
    public static class C18266 implements Runnable {
        final /* synthetic */ List fmn;

        public C18266(List list) {
            this.fmn = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(59895);
            C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] talkers size:%s", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(this.fmn.size()));
            for (String str : this.fmn) {
                long j;
                C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(str);
                if (Rb == null) {
                    j = Long.MAX_VALUE;
                } else {
                    j = Rb.field_createTime;
                }
                if (Rb != null && Rb.field_createTime > 0) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7906O(str, j);
                }
                C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker talker[%s] lastMsg[%s] lastMsgCreateTime[%s]", str, Rb, Long.valueOf(j));
                Cursor Rj = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15256Rj(str);
                if (Rj != null) {
                    if (Rj.moveToFirst()) {
                        while (!Rj.isAfterLast()) {
                            C7620bi c7620bi = new C7620bi();
                            c7620bi.mo8995d(Rj);
                            C1829bf.m3753m(c7620bi);
                            Rj.moveToNext();
                        }
                    }
                    Rj.close();
                    int Rh = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15254Rh(str);
                    C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "delete msgs %s, %d", str, Integer.valueOf(Rh));
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7906O(str, 0);
                }
            }
            AppMethodBeat.m2505o(59895);
        }
    }

    /* renamed from: com.tencent.mm.model.bf$a */
    public interface C1827a {
        /* renamed from: JU */
        boolean mo5405JU();

        /* renamed from: JV */
        void mo5406JV();
    }

    /* renamed from: com.tencent.mm.model.bf$b */
    public static class C1828b {
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

    /* renamed from: al */
    public static String m3744al(String str, String str2) {
        AppMethodBeat.m2504i(59897);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59897);
            return null;
        } else if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(59897);
            return str;
        } else {
            str = str2 + ": " + str;
            AppMethodBeat.m2505o(59897);
            return str;
        }
    }

    /* renamed from: ox */
    public static int m3761ox(String str) {
        AppMethodBeat.m2504i(59898);
        if (str == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos text is null]");
            AppMethodBeat.m2505o(59898);
            return -1;
        } else if (str.length() <= 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos length < 0]");
            AppMethodBeat.m2505o(59898);
            return -1;
        } else if (str.startsWith("~SEMI_XML~")) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorageLogic", "dz[getGroupChatMsgTalkerPos startsWith(SemiXml.MAGIC_HEAD)]");
            AppMethodBeat.m2505o(59898);
            return -1;
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
                AppMethodBeat.m2505o(59898);
                return indexOf;
            }
            C4990ab.m7412e("MicroMsg.MsgInfoStorageLogic", "dz[reject illegal character]");
            AppMethodBeat.m2505o(59898);
            return -1;
        }
    }

    /* renamed from: oy */
    public static String m3762oy(String str) {
        AppMethodBeat.m2504i(59899);
        int ox = C1829bf.m3761ox(str);
        if (ox == -1) {
            AppMethodBeat.m2505o(59899);
            return null;
        }
        String substring = str.substring(0, ox);
        AppMethodBeat.m2505o(59899);
        return substring;
    }

    /* renamed from: oz */
    public static String m3763oz(String str) {
        AppMethodBeat.m2504i(59900);
        int ox = C1829bf.m3761ox(str);
        if (ox == -1) {
            AppMethodBeat.m2505o(59900);
            return str;
        } else if (ox + 2 >= str.length()) {
            AppMethodBeat.m2505o(59900);
            return str;
        } else {
            str = str.substring(ox + 2);
            AppMethodBeat.m2505o(59900);
            return str;
        }
    }

    /* renamed from: l */
    public static long m3752l(C7620bi c7620bi) {
        AppMethodBeat.m2504i(59901);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c7620bi.field_talker);
        if (aoO == null || ((int) aoO.ewQ) == 0) {
            C7616ad c7616ad = new C7616ad(c7620bi.field_talker);
            c7616ad.setType(2);
            C6503jz c6503jz = new C6503jz();
            c6503jz.cFm.cFn = c7616ad;
            C4879a.xxA.mo10055m(c6503jz);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().mo15702Z(c7616ad);
        }
        long Z = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        AppMethodBeat.m2505o(59901);
        return Z;
    }

    /* renamed from: oA */
    public static int m3754oA(String str) {
        AppMethodBeat.m2504i(59902);
        int oA = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15345oA(str);
        AppMethodBeat.m2505o(59902);
        return oA;
    }

    /* renamed from: oB */
    public static boolean m3755oB(String str) {
        AppMethodBeat.m2504i(59903);
        boolean oB = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15346oB(str);
        AppMethodBeat.m2505o(59903);
        return oB;
    }

    /* renamed from: kE */
    public static boolean m3750kE(int i) {
        switch (i) {
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
            case 29:
                return true;
            default:
                return false;
        }
    }

    public static long aaa() {
        AppMethodBeat.m2504i(59904);
        long currentTimeMillis = System.currentTimeMillis();
        long aaE = C1839cb.aaE();
        if (Math.abs(currentTimeMillis - aaE) > 300000) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorageLogic", "[getFixTime] nowServer:" + aaE + " now:" + currentTimeMillis);
        }
        AppMethodBeat.m2505o(59904);
        return aaE;
    }

    /* renamed from: oC */
    public static long m3756oC(String str) {
        AppMethodBeat.m2504i(59905);
        long aaa = C1829bf.aaa();
        C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, after fix, now is :%s", Long.valueOf(aaa));
        if (str != null) {
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(str);
            if (Rb != null) {
                C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "[oneliang] fix send msg create time, before return, msg id:%s, now is :%s", Long.valueOf(Rb.field_msgId), Long.valueOf(aaa));
                if (Rb.field_createTime + 1 > aaa) {
                    long j = Rb.field_createTime + 1;
                    AppMethodBeat.m2505o(59905);
                    return j;
                }
            }
        }
        AppMethodBeat.m2505o(59905);
        return aaa;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: q */
    public static long m3764q(String str, long j) {
        long j2;
        AppMethodBeat.m2504i(59906);
        if (str != null) {
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(str);
            if (Rb != null) {
                j2 = Rb.field_createTime + 1;
                if (j2 <= j * 1000) {
                    AppMethodBeat.m2505o(59906);
                    return j2;
                }
                j2 = j * 1000;
                AppMethodBeat.m2505o(59906);
                return j2;
            }
        }
        j2 = 0;
        if (j2 <= j * 1000) {
        }
    }

    /* renamed from: kF */
    private static int m3751kF(int i) {
        switch (i) {
            case -1879048191:
            case -1879048190:
            case -1879048189:
                return 49;
            default:
                return i;
        }
    }

    /* renamed from: m */
    public static void m3753m(C7620bi c7620bi) {
        AppMethodBeat.m2504i(59907);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(59907);
            return;
        }
        C1201e bg = C1200d.m2638bg(Integer.valueOf(C1829bf.m3751kF(c7620bi.getType())));
        if (bg != null) {
            bg.mo4452a(new C1199c(c7620bi));
        }
        C6466ch c6466ch = new C6466ch();
        c6466ch.cvw.cvx = c7620bi.field_msgId;
        c6466ch.cvw.talker = c7620bi.field_talker;
        c6466ch.cvw.msgType = c7620bi.getType();
        C4879a.xxA.mo10055m(c6466ch);
        AppMethodBeat.m2505o(59907);
    }

    /* renamed from: X */
    public static void m3740X(List<Long> list) {
        AppMethodBeat.m2504i(59908);
        if (list.size() == 0) {
            AppMethodBeat.m2505o(59908);
            return;
        }
        for (Long longValue : list) {
            C1829bf.m3748fm(longValue.longValue());
        }
        AppMethodBeat.m2505o(59908);
    }

    /* renamed from: fm */
    public static int m3748fm(long j) {
        AppMethodBeat.m2504i(59909);
        C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
        if (jf.field_msgId != j) {
            AppMethodBeat.m2505o(59909);
            return 0;
        }
        C1829bf.m3753m(jf);
        int jg = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15341jg(j);
        AppMethodBeat.m2505o(59909);
        return jg;
    }

    /* renamed from: r */
    public static int m3765r(String str, long j) {
        AppMethodBeat.m2504i(59910);
        C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(str, j);
        if (Q.field_msgSvrId != j) {
            AppMethodBeat.m2505o(59910);
            return 0;
        }
        C1829bf.m3753m(Q);
        int aa = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15291aa(str, j);
        AppMethodBeat.m2505o(59910);
        return aa;
    }

    /* renamed from: oD */
    public static int m3757oD(String str) {
        AppMethodBeat.m2504i(59911);
        int Rh = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15254Rh(str);
        AppMethodBeat.m2505o(59911);
        return Rh;
    }

    /* renamed from: a */
    public static int m3741a(final String str, final C1827a c1827a) {
        AppMethodBeat.m2504i(59912);
        C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] stack[%s]", str, C5046bo.dpG());
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker[%s] is null", str);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(59889);
                    if (c1827a != null) {
                        c1827a.mo5406JV();
                    }
                    AppMethodBeat.m2505o(59889);
                }
            });
            AppMethodBeat.m2505o(59912);
        } else {
            C7305d.post(new Runnable() {
                final int fmj = 200;
                final int fmk = 30;
                final int fml = 5;
                int fmm = 100;

                public final void run() {
                    AppMethodBeat.m2504i(59890);
                    try {
                        long j;
                        C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(str);
                        if (Rb == null) {
                            j = Long.MAX_VALUE;
                        } else {
                            j = Rb.field_createTime;
                        }
                        ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7906O(str, j);
                        C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker run currentThread[%s, %d] lastMsg[%s] lastMsgCreateTime[%s]", Thread.currentThread().getName(), Long.valueOf(Thread.currentThread().getId()), Rb, Long.valueOf(j));
                        ((C6664ak) C1720g.m3528K(C6664ak.class)).mo14895oq(str);
                        long anU = C5046bo.anU();
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
                            long anU2 = C5046bo.anU();
                            Cursor h = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15337h(str, this.fmm, j);
                            long j4 = 0;
                            j3 = 0;
                            while (h.moveToNext()) {
                                C6575cy c7620bi = new C7620bi();
                                c7620bi.mo8995d(h);
                                if (j4 < c7620bi.field_createTime) {
                                    j2 = c7620bi.field_createTime;
                                } else {
                                    j2 = j4;
                                }
                                j3++;
                                C1829bf.m3753m(c7620bi);
                                j4 = j2;
                            }
                            h.close();
                            long anU3 = C5046bo.anU();
                            if (j4 > 0 && j3 > 0) {
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15295ab(str, j4);
                                ((C6664ak) C1720g.m3528K(C6664ak.class)).mo14894o(str, j4);
                            }
                            i = (int) (((long) i) + j3);
                            j2 = C5046bo.anU() - anU2;
                            C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerdel deleteMsgByTalker:%s delCnt:%d curCnt:%d msgTimeDiff:%d(%d) run:[%d,%d,%d](%d)", C5046bo.anv(str), Integer.valueOf(i), Long.valueOf(j3), Long.valueOf(j - j4), Long.valueOf(j), Long.valueOf(r18 - anU3), Long.valueOf(r18 - anU2), Long.valueOf(C5046bo.anU() - anU), Integer.valueOf(this.fmm));
                        } while (j3 > 0);
                        AppMethodBeat.m2505o(59890);
                    } catch (C1819b e) {
                        C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorageLogic", e, "", new Object[0]);
                        AppMethodBeat.m2505o(59890);
                    }
                }
            }, "deleteMsgByTalker");
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(59891);
                    if (c1827a != null) {
                        c1827a.mo5406JV();
                    }
                    AppMethodBeat.m2505o(59891);
                }
            });
            AppMethodBeat.m2505o(59912);
        }
        return 0;
    }

    /* renamed from: a */
    public static void m3742a(final C1827a c1827a) {
        AppMethodBeat.m2504i(59913);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.model.bf$5$1 */
            class C18241 implements Runnable {
                C18241() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(59892);
                    c1827a.mo5406JV();
                    AppMethodBeat.m2505o(59892);
                }
            }

            public final void run() {
                int i = 0;
                AppMethodBeat.m2504i(59893);
                if (c1827a == null || !c1827a.mo5405JU()) {
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().dsJ();
                    if (c1827a == null || !c1827a.mo5405JU()) {
                        C1829bf.aab();
                        if (c1827a == null || !c1827a.mo5405JU()) {
                            C1829bf.aac();
                            if (c1827a == null || !c1827a.mo5405JU()) {
                                List Re = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15251Re("bottlemessage");
                                if (Re != null) {
                                    for (int i2 = 0; i2 < Re.size(); i2++) {
                                        C1829bf.m3753m((C7620bi) Re.get(i2));
                                    }
                                }
                                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15253Rg("bottlemessage");
                                if (c1827a == null || !c1827a.mo5405JU()) {
                                    List Re2 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15251Re(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                    if (Re2 != null) {
                                        while (i < Re2.size()) {
                                            C1829bf.m3753m((C7620bi) Re2.get(i));
                                            i++;
                                        }
                                    }
                                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15253Rg(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                                }
                            }
                        }
                    }
                }
                if (c1827a != null) {
                    C5004al.m7441d(new C18241());
                }
                AppMethodBeat.m2505o(59893);
            }

            public final String toString() {
                AppMethodBeat.m2504i(59894);
                String str = super.toString() + "|deleteAllMsg";
                AppMethodBeat.m2505o(59894);
                return str;
            }
        });
        AppMethodBeat.m2505o(59913);
    }

    public static void aab() {
        AppMethodBeat.m2504i(59914);
        List Re = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15251Re("qmessage");
        if (Re != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Re.size()) {
                    break;
                }
                C1829bf.m3753m((C7620bi) Re.get(i2));
                i = i2 + 1;
            }
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15253Rg("qmessage");
        AppMethodBeat.m2505o(59914);
    }

    public static void aac() {
        AppMethodBeat.m2504i(59915);
        List Re = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15251Re("tmessage");
        if (Re != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= Re.size()) {
                    break;
                }
                C1829bf.m3753m((C7620bi) Re.get(i2));
                i = i2 + 1;
            }
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15253Rg("tmessage");
        AppMethodBeat.m2505o(59915);
    }

    /* renamed from: oE */
    public static C1828b m3758oE(String str) {
        AppMethodBeat.m2504i(59916);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59916);
            return null;
        }
        try {
            Map z = C5049br.m7595z(str, "msgsource");
            if (z == null || z.isEmpty()) {
                AppMethodBeat.m2505o(59916);
                return null;
            }
            C1828b c1828b = new C1828b();
            c1828b.fmp = (String) z.get(".msgsource.bizmsg.msgcluster");
            c1828b.fmu = (String) z.get(".msgsource.kf.kf_worker");
            c1828b.fmt = C5046bo.nullAsNil((String) z.get(".msgsource.bizmsg.bizclientmsgid"));
            c1828b.fmy = C5046bo.nullAsNil((String) z.get(".msgsource.enterprise_info.qy_msg_type"));
            c1828b.fmz = C5046bo.nullAsNil((String) z.get(".msgsource.enterprise_info.bizchat_id"));
            c1828b.fmA = C5046bo.nullAsNil((String) z.get(".msgsource.enterprise_info.bizchat_ver"));
            c1828b.userId = C5046bo.nullAsNil((String) z.get(".msgsource.enterprise_info.user_id"));
            c1828b.fmB = C5046bo.nullAsNil((String) z.get(".msgsource.enterprise_info.user_nickname"));
            c1828b.fmC = C5046bo.nullAsNil((String) z.get(".msgsource.enterprise_info.sync_from_qy_im"));
            c1828b.fmx = (String) z.get(".msgsource.strangerantispamticket.$ticket");
            c1828b.scene = C5046bo.getInt((String) z.get(".msgsource.strangerantispamticket.$scene"), 0);
            c1828b.fmD = (String) z.get(".msgsource.NotAutoDownloadRange");
            c1828b.fmE = C5046bo.getInt((String) z.get(".msgsource.DownloadLimitKbps"), 0);
            c1828b.fmF = C5046bo.getInt((String) z.get(".msgsource.videopreloadlen"), 0);
            c1828b.fmG = C5046bo.getInt((String) z.get(".msgsource.PreDownload"), 0);
            c1828b.fmH = C5046bo.getInt((String) z.get(".msgsource.PreDownloadNetType"), 0);
            c1828b.fmI = (String) z.get(".msgsource.NoPreDownloadRange");
            c1828b.fmq = C5046bo.getInt((String) z.get(".msgsource.msg_cluster_type"), -1);
            c1828b.fmr = C5046bo.getInt((String) z.get(".msgsource.service_type"), -1);
            c1828b.fms = C5046bo.getInt((String) z.get(".msgsource.scene"), -1);
            c1828b.fmv = C5046bo.getInt((String) z.get(".msgsource.bizmsg.msg_predict"), 0);
            c1828b.fmw = C5046bo.getLong((String) z.get(".msgsource.bizflag"), 0);
            AppMethodBeat.m2505o(59916);
            return c1828b;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MsgInfoStorageLogic", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.MsgInfoStorageLogic", "Exception in getMsgSourceValue, %s", e.getMessage());
            AppMethodBeat.m2505o(59916);
            return null;
        }
    }

    /* renamed from: oF */
    public static String m3759oF(String str) {
        AppMethodBeat.m2504i(59917);
        C1828b oE = C1829bf.m3758oE(str);
        if (oE == null) {
            AppMethodBeat.m2505o(59917);
            return null;
        }
        String str2 = oE.fmu;
        AppMethodBeat.m2505o(59917);
        return str2;
    }

    /* renamed from: a */
    public static void m3743a(C7620bi c7620bi, C1197a c1197a) {
        AppMethodBeat.m2504i(59918);
        if (c7620bi == null || c1197a == null || c1197a.eAB == null) {
            C4990ab.m7413e("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgWithAddMsgInfo error input is null, stack[%s]", C5046bo.dpG());
            AppMethodBeat.m2505o(59918);
        } else if (c7620bi.field_msgSvrId != c1197a.eAB.ptF) {
            AppMethodBeat.m2505o(59918);
        } else {
            C7254cm c7254cm = c1197a.eAB;
            if (c7620bi.field_isSend == 0 || c7254cm.vEI != 0) {
                if (c7620bi.field_msgSeq == 0 && c7254cm.vEI != 0) {
                    c7620bi.mo14777eL((long) c7254cm.vEI);
                }
                int i = c7620bi.field_flag;
                if (c1197a.fsU) {
                    i |= 2;
                } else {
                    i &= -3;
                }
                if (c1197a.fsV) {
                    i |= 1;
                } else {
                    i &= -2;
                }
                if (c1197a.fsW) {
                    i |= 4;
                } else {
                    i &= -5;
                }
                c7620bi.mo14783hY(i);
                if (c7620bi.field_msgId == 0 && c1197a.fsU) {
                    c7620bi.mo14775eJ(c1197a.fsX);
                }
                AppMethodBeat.m2505o(59918);
                return;
            }
            AppMethodBeat.m2505o(59918);
        }
    }

    /* renamed from: c */
    public static boolean m3746c(C1197a c1197a) {
        AppMethodBeat.m2504i(59919);
        if (c1197a == null || c1197a.eAB == null) {
            AppMethodBeat.m2505o(59919);
            return false;
        }
        C7254cm c7254cm = c1197a.eAB;
        C7620bi Q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15241Q(C1946aa.m4148a(c7254cm.vEB), c7254cm.ptF);
        if (Q.field_msgId == 0) {
            AppMethodBeat.m2505o(59919);
            return false;
        } else if (Q.field_isSend == 0 || c7254cm.vEI != 0) {
            int i = Q.field_flag;
            if (c1197a.fsU) {
                i |= 2;
            } else {
                i &= -3;
            }
            if (c1197a.fsV) {
                i |= 1;
            } else {
                i &= -2;
            }
            if (c1197a.fsW) {
                i |= 4;
            } else {
                i &= -5;
            }
            if (i != Q.field_flag) {
                C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", Integer.valueOf(c7254cm.nao), Integer.valueOf(i), Integer.valueOf(Q.field_flag));
                Q.mo14783hY(i);
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15302b(Q.field_msgSvrId, Q);
                AppMethodBeat.m2505o(59919);
                return true;
            }
            AppMethodBeat.m2505o(59919);
            return false;
        } else {
            AppMethodBeat.m2505o(59919);
            return false;
        }
    }

    /* renamed from: d */
    public static int m3747d(C1197a c1197a) {
        int i = 0;
        if (c1197a.fsU) {
            i = 2;
        }
        if (c1197a.fsV) {
            i |= 1;
        }
        if (c1197a.fsW) {
            return i | 4;
        }
        return i;
    }

    /* renamed from: b */
    public static String m3745b(boolean z, String str, int i) {
        AppMethodBeat.m2504i(59920);
        if (z && str != null && i == 0) {
            str = C1829bf.m3763oz(str);
        }
        AppMethodBeat.m2505o(59920);
        return str;
    }

    /* renamed from: g */
    public static long m3749g(String str, long j, long j2) {
        AppMethodBeat.m2504i(59921);
        long j3 = j * 1000;
        long j4 = 0;
        long j5 = -1;
        if (str != null) {
            C7620bi Rb = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15248Rb(str);
            if (Rb != null) {
                j4 = Rb.field_createTime;
            }
            j5 = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15265Rs(str);
        }
        if (j5 == j4) {
            if (j3 == j4) {
                j3++;
                AppMethodBeat.m2505o(59921);
                return j3;
            }
            AppMethodBeat.m2505o(59921);
            return j3;
        } else if (j5 >= j4) {
            C4990ab.m7421w("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvMsgCreateTime first > last [%d > %d], ret serverMillTime:%d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3));
            AppMethodBeat.m2505o(59921);
            return j3;
        } else if (j3 == j5) {
            j3--;
            AppMethodBeat.m2505o(59921);
            return j3;
        } else if (j3 == j4) {
            j3++;
            AppMethodBeat.m2505o(59921);
            return j3;
        } else if (j2 == 0 || j3 > j4) {
            AppMethodBeat.m2505o(59921);
            return j3;
        } else {
            C7620bi S = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15273S(str, j3);
            if (!(S.field_msgSeq == 0 || S.field_msgSeq == j2)) {
                C6575cy W;
                C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] need fix serverMillTime[%d, %d]", Long.valueOf(S.field_msgSeq), Long.valueOf(j2), Long.valueOf(S.field_createTime), Long.valueOf(j3));
                if (j2 < S.field_msgSeq) {
                    W = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15277W(str, j3 - 1000);
                } else {
                    W = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15276V(str, 1000 + j3);
                }
                if (W.field_msgSeq == 0 || W.field_msgSeq == j2) {
                    C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d] no need fix serverMillTime[%d, %d]", Long.valueOf(S.field_msgSeq), Long.valueOf(j2), Long.valueOf(S.field_createTime), Long.valueOf(j3));
                } else {
                    j4 = W.field_msgSeq < j2 ? W.field_createTime + 1 : W.field_createTime - 1;
                    C4990ab.m7417i("MicroMsg.MsgInfoStorageLogic", "summerbadcr fixRecvGetMsgCreateTime seq[%d, %d, %d] need fix serverMillTime[%d, %d, %d] done", Long.valueOf(S.field_msgSeq), Long.valueOf(W.field_msgSeq), Long.valueOf(j2), Long.valueOf(S.field_createTime), Long.valueOf(W.field_createTime), Long.valueOf(j4));
                    AppMethodBeat.m2505o(59921);
                    return j4;
                }
            }
            j4 = j3;
            AppMethodBeat.m2505o(59921);
            return j4;
        }
    }

    /* renamed from: ow */
    public static String m3760ow(String str) {
        AppMethodBeat.m2504i(59896);
        int ox = C1829bf.m3761ox(str);
        if (ox != -1) {
            str = str.substring(ox + 1).trim();
            AppMethodBeat.m2505o(59896);
            return str;
        }
        AppMethodBeat.m2505o(59896);
        return str;
    }
}
