package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.BuildConfig;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C6664ak;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3457a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3459b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.p177mm.storage.C7620bi.C5137c;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.bj */
public final class C7572bj extends C7296k implements C6977h {
    public static final String[] fnj;
    private final C7480h fni;
    private C7309bd jyn;
    private C7310be jyp;
    private final C4934l<C3457a, C3460c> xHV = new C73111();
    private final long xXI = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    private boolean xZB = false;
    private final List<C5142e> xZC = new CopyOnWriteArrayList();
    private List<C3459b> xZD;
    private final C1177f<Integer, C5137c> xZE = new C7598c(100);
    private final C1177f<Integer, C5138d> xZF = new C7598c(100);
    private final C1177f<Integer, C5135a> xZG = new C7598c(100);
    private final C1177f<Integer, C5136b> xZH = new C7598c(100);
    private final C1177f<Integer, Object> xZI = new C7598c(100);
    private final C1177f<String, Long> xZJ = new C7598c(100);
    private C5129an xZK = new C5129an();
    private Map<String, C3460c> xZL = new HashMap();
    private boolean xZM = false;
    private String xZN = "";
    private long xZO = 0;

    /* renamed from: com.tencent.mm.storage.bj$1 */
    class C73111 extends C4934l<C3457a, C3460c> {
        C73111() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(1320);
            ((C3457a) obj).mo7913a(C7572bj.this, (C3460c) obj2);
            AppMethodBeat.m2505o(1320);
        }

        /* renamed from: el */
        public final void mo10128el(List<C3460c> list) {
            AppMethodBeat.m2504i(1319);
            if (!(isLocked() || C7572bj.this.jyp == null)) {
                for (C3460c c3460c : list) {
                    if (c3460c != null) {
                        C7572bj.this.jyp.mo15802b(C7572bj.this, c3460c);
                    }
                }
            }
            AppMethodBeat.m2505o(1319);
        }
    }

    /* renamed from: a */
    public final void mo15290a(C5142e c5142e) {
        AppMethodBeat.m2504i(1321);
        if (!this.xZC.contains(c5142e)) {
            C4990ab.m7417i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", c5142e);
            this.xZC.add(c5142e);
        }
        AppMethodBeat.m2505o(1321);
    }

    public final C7480h bOy() {
        return this.fni;
    }

    static {
        AppMethodBeat.m2504i(1450);
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + ShareConstants.WEB_DIALOG_PARAM_MESSAGE + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT) ";
        fnj = strArr;
        AppMethodBeat.m2505o(1450);
    }

    /* renamed from: a */
    public final void mo15289a(C3460c c3460c) {
        AppMethodBeat.m2504i(1322);
        if (this.xHV.mo10126cF(c3460c)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.m2505o(1322);
    }

    /* renamed from: a */
    public final void mo15287a(C3457a c3457a, Looper looper) {
        AppMethodBeat.m2504i(1323);
        this.xHV.mo10125a(c3457a, looper);
        AppMethodBeat.m2505o(1323);
    }

    /* renamed from: a */
    public final void mo15286a(C3457a c3457a) {
        AppMethodBeat.m2504i(1324);
        this.xHV.remove(c3457a);
        AppMethodBeat.m2505o(1324);
    }

    public final void lock() {
        AppMethodBeat.m2504i(1325);
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
        AppMethodBeat.m2505o(1325);
    }

    public final void unlock() {
        AppMethodBeat.m2504i(1326);
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
        AppMethodBeat.m2505o(1326);
    }

    /* renamed from: QW */
    public final void mo15242QW(String str) {
        AppMethodBeat.m2504i(1327);
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xZM), Integer.valueOf(this.xDf.xDi), Integer.valueOf(this.xHV.xDi), Integer.valueOf(this.xZL.size()), this.xZN, Long.valueOf(C5046bo.m7566gb(this.xZO)));
        if (C5046bo.isNullOrNil(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.xZM) {
            C4990ab.m7421w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.xZN, Long.valueOf(C5046bo.m7566gb(this.xZO)));
            AppMethodBeat.m2505o(1327);
            return;
        }
        this.xZN = str;
        this.xZO = C5046bo.anU();
        this.xZM = true;
        super.lock();
        this.xHV.lock();
        AppMethodBeat.m2505o(1327);
    }

    /* renamed from: QX */
    public final void mo15243QX(String str) {
        AppMethodBeat.m2504i(1328);
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xZM), Integer.valueOf(this.xDf.xDi), Integer.valueOf(this.xHV.xDi), Integer.valueOf(this.xZL.size()), this.xZN, Long.valueOf(C5046bo.m7566gb(this.xZO)));
        if (C5046bo.isNullOrNil(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.xZM) {
            C4990ab.m7421w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, C5046bo.dpG());
            AppMethodBeat.m2505o(1328);
        } else if (str.equals(this.xZN)) {
            this.xZM = false;
            this.xZO = 0;
            this.xZN = "";
            for (String str2 : this.xZL.keySet()) {
                mo15289a((C3460c) this.xZL.get(str2));
            }
            this.xZL.clear();
            super.unlock();
            this.xHV.unlock();
            doNotify();
            AppMethodBeat.m2505o(1328);
        } else {
            C4990ab.m7421w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.xZN, Long.valueOf(C5046bo.m7566gb(this.xZO)), str);
            AppMethodBeat.m2505o(1328);
        }
    }

    /* renamed from: QY */
    public final void mo15244QY(String str) {
        AppMethodBeat.m2504i(1329);
        if (this.xZM) {
            C3460c c3460c = null;
            if (this.xZL.containsKey(str)) {
                c3460c = (C3460c) this.xZL.get(str);
            }
            if (c3460c == null) {
                C4990ab.m7421w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", str, C5046bo.dpG());
                AppMethodBeat.m2505o(1329);
                return;
            }
            if (c3460c.oqJ != null && c3460c.oqJ.equals("insert") && c3460c.oqL > 0) {
                C4990ab.m7417i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", str, Integer.valueOf(c3460c.oqL));
                c3460c.oqL = 0;
            }
            AppMethodBeat.m2505o(1329);
            return;
        }
        AppMethodBeat.m2505o(1329);
    }

    /* renamed from: a */
    public final void mo15285a(C7480h c7480h, String str) {
        AppMethodBeat.m2504i(1330);
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Cursor a = c7480h.mo10104a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    obj = 1;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    obj3 = 1;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    obj4 = 1;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    obj5 = 1;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    obj6 = 1;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    obj7 = 1;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    obj8 = 1;
                } else if ("flag".equalsIgnoreCase(string)) {
                    obj9 = 1;
                }
            }
        }
        a.close();
        long iV = c7480h.mo15639iV(Thread.currentThread().getId());
        if (obj == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj2 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj3 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj4 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj6 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj7 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj8 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj9 == null) {
            c7480h.mo10108hY(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        c7480h.mo15640mB(iV);
        AppMethodBeat.m2505o(1330);
    }

    /* renamed from: P */
    public final void mo15240P(String str, long j) {
        AppMethodBeat.m2504i(1331);
        C3459b apM = apM(str);
        long j2 = apM.fDH;
        Random random = new Random();
        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "BEGIN;");
        C7620bi c7620bi = new C7620bi(str);
        for (int i = 0; ((long) i) < j; i++) {
            c7620bi.mo14775eJ(System.currentTimeMillis());
            c7620bi.setType(1);
            c7620bi.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + C5046bo.dpF());
            c7620bi.setMsgId(j2);
            c7620bi.setStatus(random.nextInt(4));
            c7620bi.mo14781hO(random.nextInt(1));
            j2++;
            apM.fDH++;
            c7620bi.mo14774eI(System.currentTimeMillis() + ((long) C5046bo.dpF()));
            this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "INSERT INTO " + mo15264Rr(c7620bi.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + c7620bi.field_msgId + "," + c7620bi.field_msgSvrId + "," + c7620bi.getType() + "," + c7620bi.field_status + "," + c7620bi.field_createTime + ",'" + c7620bi.field_talker + "','" + c7620bi.field_content + "'," + apH(str) + ");");
            if (i % Downloads.MIN_WAIT_FOR_NETWORK == 0) {
                this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "COMMIT;");
                this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "BEGIN;");
            }
        }
        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "COMMIT;");
        this.jyp.apa(str);
        c7620bi.setMsgId(1 + j2);
        mo15281Z(c7620bi);
        AppMethodBeat.m2505o(1331);
    }

    private void dug() {
        AppMethodBeat.m2504i(1332);
        long currentTimeMillis = System.currentTimeMillis();
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        String str = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
        String[] strArr = new String[]{"CREATE INDEX IF NOT EXISTS " + str + "IdIndex ON message ( msgId )", "CREATE INDEX IF NOT EXISTS " + str + "SvrIdIndex ON message ( msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "SendCreateTimeIndex ON message ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "CreateTimeIndex ON message ( createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TaklerIdTypeCreateTimeIndex ON message ( talkerId,type,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdStatusIndex ON message ( talkerId,status )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId,isSend,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdCreateTimeIndex ON message ( talkerId,createTime )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdSvrIdIndex ON message ( talkerId,msgSvrId )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerIdTypeIndex ON message ( talkerId,type )", "CREATE INDEX IF NOT EXISTS " + str + "TalkerTypeIndex ON message ( talker,type )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerMsgSeqIndex ON message ( talker,msgSeq )", "CREATE INDEX IF NOT EXISTS " + str + "messageTalkerFlagMsgSeqIndex ON message ( talker,flag,msgSeq )"};
        if (!this.xZB) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, (String) arrayList.get(i2));
                i = i2 + 1;
            } else {
                C4990ab.m7417i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                this.fni.mo15640mB(iV);
                C4990ab.m7417i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(1332);
                return;
            }
        }
    }

    public C7572bj(C7480h c7480h, C7309bd c7309bd, C7310be c7310be) {
        AppMethodBeat.m2504i(1334);
        this.fni = c7480h;
        this.jyn = c7309bd;
        this.jyp = c7310be;
        C1720g.m3537RQ();
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.fni.delete(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "msgId> ? ", new String[]{"80000000"});
            C4990ab.m7417i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(348169, Integer.valueOf(1));
        }
        mo15285a(c7480h, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        dug();
        if (this.xZD == null) {
            this.xZD = new LinkedList();
        }
        this.xZD.clear();
        mo15288a(new C3459b(1, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, C3459b.m5743a(1, 1000000, 10000000, 90000000)));
        AppMethodBeat.m2505o(1334);
    }

    /* renamed from: a */
    public final void mo15288a(C3459b c3459b) {
        AppMethodBeat.m2504i(1335);
        synchronized (this.xZD) {
            try {
                this.xZD.add(c3459b);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(1335);
            }
        }
        m13249b(c3459b);
    }

    public final void bOA() {
        AppMethodBeat.m2504i(1336);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.xZD.size()) {
                m13249b((C3459b) this.xZD.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(1336);
                return;
            }
        }
    }

    /* renamed from: b */
    private void m13249b(C3459b c3459b) {
        AppMethodBeat.m2504i(1337);
        Cursor a = this.fni.mo10104a("select max(msgid) from " + c3459b.name, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            C4990ab.m7417i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", Integer.valueOf(i), Long.valueOf(c3459b.fDH));
            if (((long) i) >= c3459b.fDH) {
                c3459b.mo7916yx(i);
            }
        }
        a.close();
        C4990ab.m7420w("MicroMsg.MsgInfoStorage", "loading new msg id:" + c3459b.fDH);
        AppMethodBeat.m2505o(1337);
    }

    public final void bOB() {
        AppMethodBeat.m2504i(1338);
        if (this.xZB) {
            String str = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
            Cursor a = this.fni.mo10104a("select count(*) from " + str + " where talkerId ISNULL ", null, 2);
            if (a != null) {
                int i;
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    i = 0;
                }
                a.close();
                if (i > 0) {
                    C4990ab.m7417i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    C4990ab.m7417i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.fni.mo10108hY(str, "update " + str + " set talkerId=(select rowid from rcontact where rcontact.username = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.fni.mo10108hY(str, "update " + str + " set talkerId=(select rowid from rcontact where rcontact.username = " + str + ".talker)") && this.xZB) {
                        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.fni.mo10108hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        C4990ab.m7416i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
            AppMethodBeat.m2505o(1338);
            return;
        }
        AppMethodBeat.m2505o(1338);
    }

    /* renamed from: jf */
    public final C7620bi mo15340jf(long j) {
        AppMethodBeat.m2504i(1339);
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10105a(m13250mT(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1339);
        return c7620bi;
    }

    /* renamed from: Q */
    public final C7620bi mo15241Q(String str, long j) {
        AppMethodBeat.m2504i(1340);
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10105a(mo15264Rr(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1340);
        return c7620bi;
    }

    /* renamed from: R */
    public final C7620bi mo15246R(String str, long j) {
        AppMethodBeat.m2504i(1341);
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10105a(mo15264Rr(str), null, apG(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1341);
        return c7620bi;
    }

    /* renamed from: S */
    public final C7620bi mo15273S(String str, long j) {
        AppMethodBeat.m2504i(1342);
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10105a(mo15264Rr(str), null, "createTime=? AND" + apG(str), new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1342);
        return c7620bi;
    }

    /* renamed from: QZ */
    public final Cursor mo15245QZ(String str) {
        AppMethodBeat.m2504i(1343);
        Cursor query = this.fni.query(mo15264Rr(str), new String[]{"createTime", "msgId"}, apG(str), null, "createTime", null, "createTime ASC");
        AppMethodBeat.m2505o(1343);
        return query;
    }

    /* renamed from: T */
    public final List<C7620bi> mo15274T(String str, long j) {
        AppMethodBeat.m2504i(1344);
        ArrayList arrayList = new ArrayList();
        String str2 = "Select * From " + mo15264Rr(str) + " Where " + apG(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
        Cursor a = this.fni.mo10104a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            arrayList.add(c7620bi);
        }
        a.close();
        AppMethodBeat.m2505o(1344);
        return arrayList;
    }

    /* renamed from: U */
    public final List<C7620bi> mo15275U(String str, long j) {
        AppMethodBeat.m2504i(1345);
        ArrayList arrayList = new ArrayList();
        String str2 = "Select * From " + mo15264Rr(str) + " Where " + apG(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
        Cursor a = this.fni.mo10104a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            arrayList.add(c7620bi);
        }
        a.close();
        AppMethodBeat.m2505o(1345);
        return arrayList;
    }

    /* renamed from: V */
    public final C7620bi mo15276V(String str, long j) {
        AppMethodBeat.m2504i(1346);
        C7620bi c7620bi = new C7620bi();
        String str2 = "Select * From " + mo15264Rr(str) + " Where " + apG(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
        Cursor a = this.fni.mo10104a(str2, new String[]{String.valueOf(j)}, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1346);
        return c7620bi;
    }

    /* renamed from: W */
    public final C7620bi mo15277W(String str, long j) {
        AppMethodBeat.m2504i(1347);
        C7620bi c7620bi = new C7620bi();
        String str2 = "Select * From " + mo15264Rr(str) + " Where " + apG(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
        Cursor a = this.fni.mo10104a(str2, new String[]{String.valueOf(j)}, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1347);
        return c7620bi;
    }

    private String apG(String str) {
        AppMethodBeat.m2504i(1348);
        String Rr = mo15264Rr(str);
        if (this.xZB && Rr.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            Rr = " talkerId=" + apH(str) + " ";
            AppMethodBeat.m2505o(1348);
            return Rr;
        }
        Rr = " talker= '" + C5046bo.m7586vA(str) + "' ";
        AppMethodBeat.m2505o(1348);
        return Rr;
    }

    private long apH(String str) {
        AppMethodBeat.m2504i(1349);
        long aoP = this.jyn.aoP(str);
        if (aoP < 0) {
            C7616ad c7616ad = new C7616ad(str);
            c7616ad.setType(2);
            this.jyn.mo15702Z(c7616ad);
            aoP = this.jyn.aoP(str);
        }
        if (!C4872b.dnQ()) {
            C4990ab.m7417i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(aoP), Boolean.valueOf(r2), C5046bo.dpG());
        }
        AppMethodBeat.m2505o(1349);
        return aoP;
    }

    public final ArrayList<C7620bi> bOC() {
        AppMethodBeat.m2504i(1350);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.mo10105a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            int i;
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            if (c7620bi.dtK()) {
                i = 0;
            } else {
                i = 1;
            }
            if (!((i & 1) == 0 || C7616ad.aou(c7620bi.field_talker) || C7616ad.aow(c7620bi.field_talker) || C7616ad.m13548mR(c7620bi.field_talker))) {
                arrayList.add(c7620bi);
            }
        }
        a.close();
        AppMethodBeat.m2505o(1350);
        return arrayList;
    }

    /* renamed from: K */
    public final void mo15239K(ArrayList<Long> arrayList) {
        AppMethodBeat.m2504i(1351);
        long iV = this.fni.mo15639iV(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                C7620bi jf = mo15340jf(longValue);
                jf.mo14785ht(jf.dqI | 32);
                C4990ab.m7411d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                mo15284a(longValue, jf);
            }
        } finally {
            this.fni.mo15640mB(iV);
            AppMethodBeat.m2505o(1351);
        }
    }

    /* renamed from: X */
    public final boolean mo15278X(String str, long j) {
        AppMethodBeat.m2504i(1352);
        if (mo15273S(str, j).field_msgId > 0) {
            AppMethodBeat.m2505o(1352);
            return true;
        }
        AppMethodBeat.m2505o(1352);
        return false;
    }

    /* renamed from: e */
    public final int mo15329e(String str, long j, int i) {
        AppMethodBeat.m2504i(1353);
        String str2 = "SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor a = this.fni.mo10104a(str2, null, 0);
        int count = a.getCount();
        a.close();
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        AppMethodBeat.m2505o(1353);
        return count;
    }

    /* renamed from: Ra */
    public final C7620bi mo15247Ra(String str) {
        AppMethodBeat.m2504i(1354);
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10105a(mo15264Rr(str), null, apG(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1354);
        return c7620bi;
    }

    /* renamed from: Rb */
    public final C7620bi mo15248Rb(String str) {
        AppMethodBeat.m2504i(1355);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1355);
            return null;
        }
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + "order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1355);
        return c7620bi;
    }

    /* renamed from: Y */
    public final C7620bi mo15280Y(String str, long j) {
        AppMethodBeat.m2504i(1356);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1356);
            return null;
        }
        C7620bi c7620bi = new C7620bi();
        String str2 = "select * from " + mo15264Rr(str) + " where" + apG(str) + "AND msgSeq<" + j + " order by msgSeq DESC limit 1";
        Cursor a = this.fni.mo10104a(str2, null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(str2)));
        AppMethodBeat.m2505o(1356);
        return c7620bi;
    }

    /* renamed from: fa */
    public final C7620bi mo15331fa(String str, String str2) {
        AppMethodBeat.m2504i(1357);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            AppMethodBeat.m2505o(1357);
            return null;
        }
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(c7620bi.field_msgId));
        AppMethodBeat.m2505o(1357);
        return c7620bi;
    }

    /* renamed from: Rc */
    public final C7620bi mo15249Rc(String str) {
        AppMethodBeat.m2504i(1358);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1358);
            return null;
        }
        C7620bi c7620bi = new C7620bi();
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + "and isSend = 0  order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(1358);
        return c7620bi;
    }

    /* renamed from: cs */
    public final List<C7620bi> mo15320cs(String str, int i) {
        AppMethodBeat.m2504i(1359);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.xZD != null);
        Cursor a = this.fni.mo10104a("SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            arrayList.add(c7620bi);
        }
        a.close();
        AppMethodBeat.m2505o(1359);
        return arrayList;
    }

    /* renamed from: yw */
    public final C7620bi mo15355yw(int i) {
        AppMethodBeat.m2504i(1360);
        if (this.xZD == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            AppMethodBeat.m2505o(1360);
            return null;
        }
        C7620bi c7620bi = new C7620bi();
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.xZD.size()) {
                if ((((C3459b) this.xZD.get(i3)).oqG & i) != 0) {
                    Cursor a = this.fni.mo10104a("select * from " + ((C3459b) this.xZD.get(i3)).name + "  order by createTime DESC limit 1", null, 2);
                    if (a.moveToFirst()) {
                        long j2 = a.getLong(a.getColumnIndex("createTime"));
                        if (j < j2) {
                            c7620bi.mo8995d(a);
                            j = j2;
                        }
                    }
                    a.close();
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(1360);
                return c7620bi;
            }
        }
    }

    /* renamed from: Rd */
    public final C7620bi mo15250Rd(String str) {
        AppMethodBeat.m2504i(1361);
        if (this.xZD == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            AppMethodBeat.m2505o(1361);
            return null;
        }
        String str2;
        C7620bi c7620bi = new C7620bi();
        long j = 0;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.xZD.size()) {
                if ((((C3459b) this.xZD.get(i2)).oqG & 8) != 0) {
                    Cursor a = this.fni.mo10104a("select * from " + ((C3459b) this.xZD.get(i2)).name + str2 + "  order by createTime DESC limit 1", null, 2);
                    if (a.moveToFirst()) {
                        long j2 = a.getLong(a.getColumnIndex("createTime"));
                        if (j < j2) {
                            c7620bi.mo8995d(a);
                            j = j2;
                        }
                    }
                    a.close();
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(1361);
                return c7620bi;
            }
        }
    }

    public final List<C7620bi> bOD() {
        AppMethodBeat.m2504i(1362);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.xZD != null);
        ArrayList<C7620bi> arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.xZD.size()) {
                break;
            }
            Cursor a = this.fni.mo10105a(((C3459b) this.xZD.get(i2)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
            while (a.moveToNext()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(a);
                if (c7620bi.isText() || c7620bi.dtw() || c7620bi.bAC() || c7620bi.dtE()) {
                    if (C1829bf.aaa() - c7620bi.field_createTime > 86400000) {
                        arrayList2.add(c7620bi);
                    } else {
                        arrayList.add(c7620bi);
                    }
                }
            }
            a.close();
            i = i2 + 1;
        }
        if (arrayList2.size() > 0) {
            long iV = this.fni.mo15639iV(-1);
            for (C7620bi c7620bi2 : arrayList2) {
                C4990ab.m7417i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(c7620bi2.field_msgId), Long.valueOf(c7620bi2.field_createTime), c7620bi2.field_talker, C5046bo.anv(c7620bi2.field_content));
                c7620bi2.setStatus(5);
                mo15284a(c7620bi2.field_msgId, c7620bi2);
            }
            this.fni.mo15640mB(iV);
        }
        AppMethodBeat.m2505o(1362);
        return arrayList;
    }

    /* renamed from: ct */
    public final List<C7620bi> mo15321ct(String str, int i) {
        AppMethodBeat.m2504i(1363);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.xZD != null);
        Cursor a = this.fni.mo10104a("SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            if (c7620bi.isText()) {
                arrayList.add(c7620bi);
            }
        }
        a.close();
        AppMethodBeat.m2505o(1363);
        return arrayList;
    }

    /* renamed from: aa */
    public final List<C7620bi> mo15292aa(String str, int i, int i2) {
        AppMethodBeat.m2504i(1364);
        ArrayList arrayList = new ArrayList();
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + mo15264Rr(str) + " WHERE type = 49 ORDER BY createTime DESC LIMIT " + i + " , " + i2);
        Cursor a = this.fni.mo10104a(r1, null, 2);
        while (a.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            if (c7620bi.bAA()) {
                arrayList.add(c7620bi);
            }
        }
        a.close();
        AppMethodBeat.m2505o(1364);
        return arrayList;
    }

    /* renamed from: Y */
    public final int mo15279Y(C7620bi c7620bi) {
        int i = 0;
        AppMethodBeat.m2504i(1365);
        if (c7620bi == null || C5046bo.isNullOrNil(c7620bi.field_talker)) {
            AppMethodBeat.m2505o(1365);
        } else {
            Cursor a = this.fni.mo10104a("SELECT count(msgId) FROM " + mo15264Rr(c7620bi.field_talker) + " WHERE" + apG(c7620bi.field_talker) + "AND isSend = 0 AND msgId >= " + c7620bi.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(1365);
        }
        return i;
    }

    private static String apI(String str) {
        AppMethodBeat.m2504i(1366);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1366);
            return null;
        }
        try {
            Map z = C5049br.m7595z(str, "msgsource");
            if (z == null || z.isEmpty()) {
                AppMethodBeat.m2505o(1366);
                return null;
            }
            String str2 = (String) z.get(".msgsource.bizmsg.msgcluster");
            AppMethodBeat.m2505o(1366);
            return str2;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MsgInfoStorage", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7413e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            AppMethodBeat.m2505o(1366);
            return null;
        }
    }

    /* renamed from: as */
    private static void m13248as(C7620bi c7620bi) {
        AppMethodBeat.m2504i(1367);
        if (c7620bi == null || !c7620bi.bAA()) {
            AppMethodBeat.m2505o(1367);
            return;
        }
        try {
            String str = c7620bi.field_content;
            int indexOf = str.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str.length()) {
                str = str.substring(indexOf).trim();
            }
            Map z = C5049br.m7595z(str, "msg");
            if (z != null && z.size() > 0) {
                c7620bi.mo14796jw(C5035be.m7492aS(z));
            }
            AppMethodBeat.m2505o(1367);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", e.getMessage());
            AppMethodBeat.m2505o(1367);
        }
    }

    /* renamed from: Z */
    public final long mo15281Z(C7620bi c7620bi) {
        AppMethodBeat.m2504i(1368);
        long c = mo15314c(c7620bi, false);
        AppMethodBeat.m2505o(1368);
        return c;
    }

    /* renamed from: c */
    public final long mo15314c(C7620bi c7620bi, boolean z) {
        AppMethodBeat.m2504i(1369);
        String str;
        String str2;
        if (c7620bi == null || C5046bo.isNullOrNil(c7620bi.field_talker)) {
            C7053e.pXa.mo8378a(111, 250, 1, false);
            str = "MicroMsg.MsgInfoStorage";
            String str3 = "Error insert message msg:%s talker:%s";
            Object[] objArr = new Object[2];
            objArr[0] = c7620bi;
            if (c7620bi == null) {
                str2 = "-1";
            } else {
                str2 = c7620bi.field_talker;
            }
            objArr[1] = str2;
            C4990ab.m7413e(str, str3, objArr);
            AppMethodBeat.m2505o(1369);
            return -1;
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.xZM), Long.valueOf(c7620bi.field_msgSeq));
        str2 = null;
        C1828b oE = C1829bf.m3758oE(c7620bi.dqJ);
        if (oE != null) {
            str2 = oE.fmp;
        }
        if (C1855t.m3919nE(str2)) {
            C4990ab.m7411d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str2);
            if (c7620bi.getType() == 436207665) {
                C4990ab.m7420w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                AppMethodBeat.m2505o(1369);
                return -1;
            }
            c7620bi.mo14794ju("notifymessage");
        }
        C3459b apM = apM(c7620bi.field_talker);
        if (apM == null) {
            C7053e.pXa.mo8378a(111, 249, 1, false);
            C4990ab.m7413e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", c7620bi.field_talker);
            AppMethodBeat.m2505o(1369);
            return -1;
        }
        apM.mo7914ac(c7620bi);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[]{Long.valueOf(c7620bi.field_msgId), apM, m13250mT(c7620bi.field_msgId)}), apM.name.equals(m13250mT(c7620bi.field_msgId)));
        if (c7620bi.field_msgSvrId != 0) {
            c7620bi.mo14772HH();
        }
        for (C5142e a : this.xZC) {
            if (!a.mo10568a(c7620bi, oE)) {
                C4990ab.m7413e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", c7620bi.field_talker, c7620bi.dqJ);
                AppMethodBeat.m2505o(1369);
                return -1;
            }
        }
        C7572bj.m13248as(c7620bi);
        if (apM.name.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            c7620bi.mo14782hX((int) apH(c7620bi.field_talker));
        }
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(this.fni.mo16656a(apM.name, "msgId", c7620bi.mo10098Hl(), z)), c7620bi.field_talker, Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.getType()), Integer.valueOf(c7620bi.field_status), Long.valueOf(c7620bi.field_msgSvrId), Long.valueOf(c7620bi.field_msgSeq), Integer.valueOf(c7620bi.field_flag), Long.valueOf(c7620bi.field_createTime), Integer.valueOf(c7620bi.field_isSend), this.xZN, Long.valueOf(C5046bo.m7566gb(this.xZO)));
        if (this.fni.mo16656a(apM.name, "msgId", c7620bi.mo10098Hl(), z) == -1) {
            C7053e.pXa.mo8378a(111, 248, 1, false);
            C4990ab.m7413e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(c7620bi.field_msgSvrId), Long.valueOf(r10));
            AppMethodBeat.m2505o(1369);
            return -1;
        }
        if (this.xZM && C5046bo.m7566gb(this.xZO) > FaceGestureDetGLThread.BRIGHTNESS_DURATION && c7620bi.field_isSend == 1 && c7620bi.field_status == 1) {
            C4990ab.m7421w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.xZN, Long.valueOf(C5046bo.m7566gb(this.xZO)));
            mo15243QX(this.xZN);
        }
        C3460c c3460c;
        if (this.xZM) {
            Object obj;
            str2 = null;
            if (C5142e.xHP != null) {
                str2 = C5142e.xHP.mo7931N(c7620bi);
            }
            if (C5046bo.isNullOrNil(str2)) {
                obj = c7620bi.field_talker;
            } else {
                str = str2;
            }
            c3460c = null;
            if (this.xZL.containsKey(obj)) {
                c3460c = (C3460c) this.xZL.get(obj);
            }
            if (c3460c == null) {
                c3460c = new C3460c(c7620bi.field_talker, "insert", c7620bi);
            } else {
                c3460c.oqK.add(c7620bi);
            }
            if (C3460c.m5747ad(c7620bi)) {
                c3460c.oqL++;
            }
            c3460c.oqM++;
            this.xZL.put(obj, c3460c);
        } else {
            c3460c = new C3460c(c7620bi.field_talker, "insert", c7620bi);
            if (C3460c.m5747ad(c7620bi)) {
                c3460c.oqL = 1;
            }
            c3460c.oqM = 1;
            doNotify();
            mo15289a(c3460c);
        }
        long j = c7620bi.field_msgId;
        AppMethodBeat.m2505o(1369);
        return j;
    }

    /* renamed from: jg */
    public final int mo15341jg(long j) {
        AppMethodBeat.m2504i(1370);
        C7620bi jf = mo15340jf(j);
        String str = jf.field_talker;
        this.xZK.mo10526m((int) (C5046bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC), jf.field_msgSvrId, jf.field_createTime / 1000);
        int delete = this.fni.delete(m13250mT(j), "msgId=?", new String[]{String.valueOf(j)});
        ((C6664ak) C1720g.m3528K(C6664ak.class)).mo14893fk(j);
        if (delete != 0) {
            anF("delete_id ".concat(String.valueOf(j)));
            C3460c c3460c = new C3460c(str, "delete", jf, 1, (byte) 0);
            c3460c.oqO = j;
            c3460c.jMj = jf.field_bizChatId;
            mo15289a(c3460c);
        } else {
            C7053e.pXa.mo8378a(111, 245, 1, false);
        }
        AppMethodBeat.m2505o(1370);
        return delete;
    }

    /* renamed from: Re */
    public final List<C7620bi> mo15251Re(String str) {
        List<C7620bi> list = null;
        AppMethodBeat.m2504i(1371);
        Cursor a = this.fni.mo10104a("select * from ".concat(String.valueOf(str)), null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(1371);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo8995d(a);
                    list.add(c7620bi);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(1371);
        }
        return list;
    }

    /* renamed from: Z */
    public final long mo15282Z(String str, long j) {
        AppMethodBeat.m2504i(1372);
        String str2 = "select createTime from " + mo15264Rr(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor a = this.fni.mo10104a(str2, null, 2);
        if (a.moveToFirst()) {
            j2 = a.getLong(0);
        }
        a.close();
        AppMethodBeat.m2505o(1372);
        return j2;
    }

    /* renamed from: g */
    public final List<C7620bi> mo15336g(String str, long j, boolean z) {
        AppMethodBeat.m2504i(1373);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
            AppMethodBeat.m2505o(1373);
            return null;
        }
        long Z = mo15282Z(str, j);
        if (Z == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            AppMethodBeat.m2505o(1373);
            return null;
        }
        String str2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + mo15264Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime > " + Z + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + mo15264Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + Z + "  order by createTime DESC limit 10";
        }
        Cursor a = this.fni.mo10104a(str2, null, 2);
        while (a.moveToNext()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            arrayList.add(c7620bi);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        a.close();
        AppMethodBeat.m2505o(1373);
        return arrayList;
    }

    /* renamed from: ab */
    public final Cursor mo15296ab(String str, int i, int i2) {
        AppMethodBeat.m2504i(1374);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1374);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from ( select * from " + mo15264Rr(str) + " where" + apG(str) + " AND type IN (3,39,13,43,62,44,268435505)  order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 2);
        AppMethodBeat.m2505o(1374);
        return a;
    }

    /* renamed from: p */
    public final Cursor mo15347p(String str, long j, long j2) {
        AppMethodBeat.m2504i(1375);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1375);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
        AppMethodBeat.m2505o(1375);
        return a;
    }

    /* renamed from: cw */
    public final Cursor mo15324cw(String str, int i) {
        AppMethodBeat.m2504i(1376);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1376);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from ( select * from " + mo15264Rr(str) + " where" + apG(str) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + i + ") order by createTime ASC ", null, 2);
        AppMethodBeat.m2505o(1376);
        return a;
    }

    /* renamed from: q */
    public final Cursor mo15348q(String str, long j, long j2) {
        AppMethodBeat.m2504i(1377);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1377);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
        AppMethodBeat.m2505o(1377);
        return a;
    }

    /* renamed from: Rf */
    public final Cursor mo15252Rf(String str) {
        AppMethodBeat.m2504i(1378);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1378);
            return null;
        }
        String Rr = mo15264Rr(str);
        Cursor a = this.fni.mo10104a("select * from " + Rr + " " + apJ(Rr) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime", null, 0);
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Rr);
        AppMethodBeat.m2505o(1378);
        return a;
    }

    /* renamed from: cu */
    public final Cursor mo15322cu(String str, int i) {
        AppMethodBeat.m2504i(1379);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1379);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + " AND type = 49  order by createTime DESC limit " + i + " OFFSET 0", null, 0);
        AppMethodBeat.m2505o(1379);
        return a;
    }

    /* renamed from: cv */
    public final Cursor mo15323cv(String str, int i) {
        AppMethodBeat.m2504i(1380);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1380);
            return null;
        }
        StringBuilder append = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append(mo15264Rr(str)).append(" where").append(apG(str)).append(" AND ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" (type = 49");
        stringBuilder.append(" or type = 587202609");
        stringBuilder.append(" or type = 553648177) ");
        Cursor a = this.fni.mo10104a(append.append(stringBuilder.toString()).append("  order by createTime DESC limit 100 OFFSET ").append(i).toString(), null, 0);
        AppMethodBeat.m2505o(1380);
        return a;
    }

    /* renamed from: b */
    public final void mo15303b(String str, String str2, String[] strArr) {
        AppMethodBeat.m2504i(1381);
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((C5046bo.anT() - 172800) * 1000);
        if (!C5046bo.isNullOrNil(str2)) {
            str3 = str3 + " AND " + str2;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor a = this.fni.mo10104a(str3, strArr, 2);
        if (a.moveToFirst()) {
            do {
                long j = a.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(a.getInt(0)));
                arrayList2.add(Long.valueOf(j));
            } while (a.moveToNext());
            this.xZK.mo10528p(arrayList, arrayList2);
        }
        a.close();
        AppMethodBeat.m2505o(1381);
    }

    /* renamed from: jh */
    public final boolean mo15342jh(long j) {
        AppMethodBeat.m2504i(1382);
        boolean mR = this.xZK.mo10527mR(j);
        AppMethodBeat.m2505o(1382);
        return mR;
    }

    /* renamed from: Rg */
    public final void mo15253Rg(String str) {
        AppMethodBeat.m2504i(1383);
        mo15303b(str, "", null);
        if (this.fni.mo10108hY(str, "delete from ".concat(String.valueOf(str)))) {
            anF("delete_all ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1383);
            return;
        }
        C7053e.pXa.mo8378a(111, 247, 1, false);
        AppMethodBeat.m2505o(1383);
    }

    /* renamed from: aa */
    public final int mo15291aa(String str, long j) {
        AppMethodBeat.m2504i(1384);
        C7620bi Q = mo15241Q(str, j);
        this.xZK.mo10526m((int) (C5046bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC), Q.field_msgSvrId, Q.field_createTime / 1000);
        int delete = this.fni.delete(mo15264Rr(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            doNotify();
            mo15289a(new C3460c(str, "delete", null, 1, (byte) 0));
        } else {
            C7053e.pXa.mo8378a(111, 246, 1, false);
        }
        AppMethodBeat.m2505o(1384);
        return delete;
    }

    /* renamed from: Rh */
    public final int mo15254Rh(String str) {
        AppMethodBeat.m2504i(1385);
        C4990ab.m7421w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, C5007an.doR());
        mo15303b(mo15264Rr(str), apG(str), null);
        int delete = this.fni.delete(mo15264Rr(str), apG(str), null);
        if (delete != 0) {
            anF("delete_talker ".concat(String.valueOf(str)));
            C3460c c3460c = new C3460c(str, "delete", null, delete, (byte) 0);
            c3460c.oqO = -1;
            mo15289a(c3460c);
        }
        AppMethodBeat.m2505o(1385);
        return delete;
    }

    /* renamed from: ab */
    public final int mo15295ab(String str, long j) {
        AppMethodBeat.m2504i(1386);
        String str2 = apG(str) + " and createTime <= " + j;
        mo15303b(mo15264Rr(str), str2, null);
        int delete = this.fni.delete(mo15264Rr(str), str2, null);
        if (delete != 0) {
            anF("delete_talker ".concat(String.valueOf(str)));
            C3460c c3460c = new C3460c(str, "delete", null, delete, (byte) 0);
            c3460c.oqO = -1;
            mo15289a(c3460c);
        }
        AppMethodBeat.m2505o(1386);
        return delete;
    }

    /* renamed from: cx */
    public final int mo15325cx(String str, int i) {
        AppMethodBeat.m2504i(1387);
        C4990ab.m7421w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), C5007an.doR());
        Assert.assertTrue(str.equals(mo15241Q(str, (long) i).field_talker));
        mo15303b(mo15264Rr(str), "createTime<=? AND" + apG(str), new String[]{r0.field_createTime});
        int delete = this.fni.delete(mo15264Rr(str), "createTime<=? AND" + apG(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            doNotify();
            mo15289a(new C3460c(str, "delete", null, delete, (byte) 0));
        }
        AppMethodBeat.m2505o(1387);
        return delete;
    }

    /* renamed from: cy */
    public final Cursor mo15326cy(String str, int i) {
        AppMethodBeat.m2504i(1388);
        Assert.assertTrue(str.equals(mo15241Q(str, (long) i).field_talker));
        Cursor query = this.fni.query(mo15264Rr(str), null, "createTime<=? AND" + apG(str), new String[]{r5.field_createTime}, null, null, null);
        AppMethodBeat.m2505o(1388);
        return query;
    }

    /* renamed from: a */
    public final void mo15284a(long j, C7620bi c7620bi) {
        AppMethodBeat.m2504i(1389);
        if (c7620bi.dtu()) {
            if (C1855t.m3919nE(C7572bj.apI(c7620bi.dqJ))) {
                C4990ab.m7411d("MicroMsg.MsgInfoStorage", "msgCluster = %s", C7572bj.apI(c7620bi.dqJ));
                c7620bi.mo14794ju("notifymessage");
            }
        }
        C7572bj.m13248as(c7620bi);
        if (this.fni.update(m13250mT(j), c7620bi.mo10098Hl(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            mo15289a(new C3460c(c7620bi.field_talker, "update", c7620bi));
            AppMethodBeat.m2505o(1389);
            return;
        }
        C7053e.pXa.mo8378a(111, 244, 1, false);
        AppMethodBeat.m2505o(1389);
    }

    /* renamed from: aa */
    public final void mo15293aa(C7620bi c7620bi) {
        AppMethodBeat.m2504i(1390);
        if (c7620bi == null || c7620bi.field_status == 4) {
            AppMethodBeat.m2505o(1390);
            return;
        }
        c7620bi.setStatus(4);
        String mT = m13250mT(c7620bi.field_msgId);
        if (mT != null && mT.length() > 0) {
            if (this.fni.update(mT, c7620bi.mo10098Hl(), "msgId=?", new String[]{c7620bi.field_msgId}) != 0) {
                doNotify();
                mo15289a(new C3460c(c7620bi.field_talker, "update", c7620bi, -1));
            }
        }
        AppMethodBeat.m2505o(1390);
    }

    /* renamed from: b */
    public final void mo15302b(long j, C7620bi c7620bi) {
        AppMethodBeat.m2504i(1391);
        Assert.assertTrue("no talker set when update by svrid", C5046bo.nullAsNil(c7620bi.field_talker).length() > 0);
        if (c7620bi.dtu()) {
            if (C1855t.m3919nE(C7572bj.apI(c7620bi.dqJ))) {
                C4990ab.m7411d("MicroMsg.MsgInfoStorage", "msgCluster = %s", C7572bj.apI(c7620bi.dqJ));
                c7620bi.mo14794ju("notifymessage");
            }
        }
        C7572bj.m13248as(c7620bi);
        if (this.fni.update(mo15264Rr(c7620bi.field_talker), c7620bi.mo10098Hl(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            mo15289a(new C3460c(c7620bi.field_talker, "update", c7620bi));
            AppMethodBeat.m2505o(1391);
            return;
        }
        C7053e.pXa.mo8378a(111, 243, 1, false);
        AppMethodBeat.m2505o(1391);
    }

    /* renamed from: Ri */
    public final int mo15255Ri(String str) {
        AppMethodBeat.m2504i(1392);
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        int update = this.fni.update(mo15264Rr(str), contentValues, apG(str) + "AND isSend=? AND status!=? ", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"});
        if (update != 0) {
            doNotify();
            mo15289a(new C3460c(str, "update", null));
        }
        AppMethodBeat.m2505o(1392);
        return update;
    }

    /* renamed from: ab */
    public final int mo15294ab(C7620bi c7620bi) {
        int i = 0;
        AppMethodBeat.m2504i(1393);
        if (c7620bi != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C8741b.CONTENT, c7620bi.field_content);
            contentValues.put("status", Integer.valueOf(c7620bi.field_status));
            i = this.fni.update(m13250mT(c7620bi.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(c7620bi.field_msgId)});
            if (i != 0) {
                doNotify();
                mo15289a(new C3460c(c7620bi.field_talker, "update", c7620bi));
            }
        }
        AppMethodBeat.m2505o(1393);
        return i;
    }

    /* renamed from: Rj */
    public final Cursor mo15256Rj(String str) {
        AppMethodBeat.m2504i(1394);
        Cursor query = this.fni.query(mo15264Rr(str), null, apG(str), null, null, null, "createTime ASC ");
        AppMethodBeat.m2505o(1394);
        return query;
    }

    /* renamed from: h */
    public final Cursor mo15337h(String str, int i, long j) {
        AppMethodBeat.m2504i(1395);
        Cursor a = this.fni.mo10104a("SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null, 0);
        AppMethodBeat.m2505o(1395);
        return a;
    }

    /* renamed from: fb */
    public final Cursor mo15332fb(String str, String str2) {
        AppMethodBeat.m2504i(1396);
        Cursor a = this.fni.mo10104a(("SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null, 0);
        AppMethodBeat.m2505o(1396);
        return a;
    }

    /* renamed from: i */
    public final Cursor mo15339i(String str, int i, long j) {
        AppMethodBeat.m2504i(1397);
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + (j > 0 ? " AND createTime > ".concat(String.valueOf(j)) : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        Cursor a = this.fni.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(1397);
        return a;
    }

    /* renamed from: Rk */
    public final Cursor mo15257Rk(String str) {
        AppMethodBeat.m2504i(1398);
        Cursor query = this.fni.query(mo15264Rr(str), null, "isSend=? AND" + apG(str) + "AND status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, null, null, null);
        AppMethodBeat.m2505o(1398);
        return query;
    }

    /* renamed from: cz */
    public final Cursor mo15327cz(String str, int i) {
        AppMethodBeat.m2504i(1399);
        Cursor query = this.fni.query(mo15264Rr(str), null, "isSend=? AND" + apG(str) + "AND status!=?  order by msgId DESC limit " + i, new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, null, null, null);
        AppMethodBeat.m2505o(1399);
        return query;
    }

    public final Cursor bOE() {
        AppMethodBeat.m2504i(1400);
        Cursor query = this.fni.query(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, "talker", null, null);
        AppMethodBeat.m2505o(1400);
        return query;
    }

    /* renamed from: Rl */
    public final C5137c mo15258Rl(String str) {
        AppMethodBeat.m2504i(1401);
        C5137c c5137c = (C5137c) this.xZE.get(Integer.valueOf(str.hashCode()));
        if (c5137c == null) {
            c5137c = C5137c.apE(str);
            this.xZE.mo4412k(Integer.valueOf(str.hashCode()), c5137c);
        }
        AppMethodBeat.m2505o(1401);
        return c5137c;
    }

    /* renamed from: Rm */
    public final C5138d mo15259Rm(String str) {
        AppMethodBeat.m2504i(1402);
        C5138d c5138d = (C5138d) this.xZF.get(Integer.valueOf(str.hashCode()));
        if (c5138d == null) {
            c5138d = C5138d.apF(str);
            this.xZF.mo4412k(Integer.valueOf(str.hashCode()), c5138d);
        }
        AppMethodBeat.m2505o(1402);
        return c5138d;
    }

    /* renamed from: Rn */
    public final C5135a mo15260Rn(String str) {
        AppMethodBeat.m2504i(1403);
        C5135a c5135a = null;
        if (C5046bo.isNullOrNil(str) || this.xZG == null) {
            C4990ab.m7413e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(C5046bo.isNullOrNil(str)));
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            c5135a = (C5135a) this.xZG.get(Integer.valueOf(str.hashCode()));
        }
        if (c5135a == null) {
            c5135a = C5135a.apC(str);
            if (this.xZG != null) {
                this.xZG.mo4412k(Integer.valueOf(C5046bo.m7532bc(str, "").hashCode()), c5135a);
            }
        }
        AppMethodBeat.m2505o(1403);
        return c5135a;
    }

    /* renamed from: Ro */
    public final C5136b mo15261Ro(String str) {
        AppMethodBeat.m2504i(1404);
        C5136b c5136b = (C5136b) this.xZH.get(Integer.valueOf(str.hashCode()));
        if (c5136b == null) {
            c5136b = C5136b.apD(str);
            this.xZH.mo4412k(Integer.valueOf(str.hashCode()), c5136b);
        }
        AppMethodBeat.m2505o(1404);
        return c5136b;
    }

    /* renamed from: Rp */
    public final int mo15262Rp(String str) {
        int i = 0;
        AppMethodBeat.m2504i(1405);
        if (mo15346oB(str)) {
            int apr = this.jyp.apr(str);
            if (apr > 0) {
                C4990ab.m7417i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(apr));
                AppMethodBeat.m2505o(1405);
                return apr;
            }
            C4990ab.m7417i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            Cursor a;
            if ("appbrandmessage".equals(mo15264Rr(str))) {
                a = this.fni.mo10104a("SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str), null, 0);
                if (a.moveToLast()) {
                    i = a.getInt(0);
                }
                a.close();
                AppMethodBeat.m2505o(1405);
                return i;
            }
            if ("bottlemessage".equals(mo15264Rr(str))) {
                a = this.fni.mo10104a("SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str), null, 2);
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                }
                a.close();
                AppMethodBeat.m2505o(1405);
                return i;
            }
        }
        i = mo15345oA(str);
        AppMethodBeat.m2505o(1405);
        return i;
    }

    /* renamed from: oB */
    public final boolean mo15346oB(String str) {
        AppMethodBeat.m2504i(1406);
        boolean equals = ShareConstants.WEB_DIALOG_PARAM_MESSAGE.equals(mo15264Rr(str));
        AppMethodBeat.m2505o(1406);
        return equals;
    }

    /* renamed from: oA */
    public final int mo15345oA(String str) {
        int i = 0;
        AppMethodBeat.m2504i(1407);
        Cursor a = this.fni.mo10104a("SELECT COUNT(*) FROM " + mo15264Rr(str) + " " + duh() + " WHERE" + apG(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(1407);
        return i;
    }

    private String duh() {
        if (this.xZB) {
            return "INDEXED BY messageTalkerIdStatusIndex";
        }
        return "INDEXED BY messageTalkerStatusIndex";
    }

    private String apJ(String str) {
        AppMethodBeat.m2504i(1408);
        String str2;
        if (str == null || !str.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            str2 = "";
            AppMethodBeat.m2505o(1408);
            return str2;
        } else if (this.xZB) {
            str2 = "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
            AppMethodBeat.m2505o(1408);
            return str2;
        } else {
            str2 = "INDEXED BY messageCreateTaklerTypeTimeIndex";
            AppMethodBeat.m2505o(1408);
            return str2;
        }
    }

    /* renamed from: cA */
    public final int mo15316cA(String str, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(1409);
        Cursor a = this.fni.mo10104a("SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND type = " + i, null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(1409);
        return i2;
    }

    /* renamed from: r */
    public final int mo15349r(String str, long j, long j2) {
        int i = 0;
        AppMethodBeat.m2504i(1410);
        Cursor a = this.fni.mo10104a("SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND type = 50 AND createTime >= " + j + " AND createTime <= " + j2 + " LIMIT 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(1410);
        return i;
    }

    /* renamed from: Rq */
    public final int mo15263Rq(String str) {
        int i = 0;
        AppMethodBeat.m2504i(1411);
        if (str == null) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
            AppMethodBeat.m2505o(1411);
        } else {
            StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
            String str2 = "username == null";
            boolean z = str != null && str.length() > 0;
            Assert.assertTrue(str2, z);
            String str3 = apM(str).name;
            Cursor a = this.fni.mo10104a(stringBuilder.append(str3 + "  indexed by  " + str3 + "TalkerTypeIndex ").append(" WHERE talker= '").append(C5046bo.m7586vA(str)).append("' AND type IN (3,39,13,43,62,44,268435505)").toString(), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(1411);
        }
        return i;
    }

    /* renamed from: ac */
    public final int mo15297ac(String str, long j) {
        int i = 0;
        AppMethodBeat.m2504i(1412);
        C7620bi jf = mo15340jf(j);
        if (jf.field_msgId == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.m2505o(1412);
        } else {
            String Rr = mo15264Rr(str);
            Cursor a = this.fni.mo10104a("SELECT COUNT(*) FROM " + Rr + " " + apJ(Rr) + " WHERE " + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + jf.field_createTime, null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(1412);
        }
        return i;
    }

    /* renamed from: ad */
    public final String mo15298ad(String str, long j) {
        String str2 = null;
        int i = 0;
        AppMethodBeat.m2504i(1413);
        C7620bi jf = mo15340jf(j);
        if (jf.field_msgId == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.m2505o(1413);
        } else {
            String Rr = mo15264Rr(str);
            Cursor a = this.fni.mo10104a("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + Rr + " " + apJ(Rr) + " WHERE" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + jf.field_createTime, null, 0);
            str2 = "";
            if (a.moveToFirst()) {
                while (i < a.getColumnCount()) {
                    str2 = str2 + a.getString(i) + " ";
                    i++;
                }
            }
            a.close();
            AppMethodBeat.m2505o(1413);
        }
        return str2;
    }

    public final String bOF() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    public final String bOG() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    /* renamed from: Rr */
    public final String mo15264Rr(String str) {
        AppMethodBeat.m2504i(1414);
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = apM(str).name;
        AppMethodBeat.m2505o(1414);
        return str3;
    }

    private C3459b apK(String str) {
        AppMethodBeat.m2504i(1415);
        String str2 = "tableName == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        for (int i = 0; i < this.xZD.size(); i++) {
            if (str.equals(((C3459b) this.xZD.get(i)).name)) {
                C3459b c3459b = (C3459b) this.xZD.get(i);
                AppMethodBeat.m2505o(1415);
                return c3459b;
            }
        }
        Assert.assertTrue("no table match", false);
        AppMethodBeat.m2505o(1415);
        return null;
    }

    private String apL(String str) {
        String aog;
        AppMethodBeat.m2504i(1416);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        for (C5142e aog2 : this.xZC) {
            aog = aog2.aog(str);
            if (!C5046bo.isNullOrNil(aog)) {
                AppMethodBeat.m2505o(1416);
                return aog;
            }
        }
        aog = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
        AppMethodBeat.m2505o(1416);
        return aog;
    }

    private C3459b apM(String str) {
        AppMethodBeat.m2504i(1417);
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        C3459b apK = apK(apL(str));
        AppMethodBeat.m2505o(1417);
        return apK;
    }

    /* renamed from: ji */
    public final boolean mo15343ji(long j) {
        AppMethodBeat.m2504i(1418);
        for (int i = 0; i < this.xZD.size(); i++) {
            if (((C3459b) this.xZD.get(i)).mo7915jk(j)) {
                AppMethodBeat.m2505o(1418);
                return true;
            }
        }
        AppMethodBeat.m2505o(1418);
        return false;
    }

    /* renamed from: mT */
    private String m13250mT(long j) {
        AppMethodBeat.m2504i(1419);
        if (j == 0 || j == -1) {
            AppMethodBeat.m2505o(1419);
            return null;
        }
        C7620bi.m13570mS(j);
        for (int i = 0; i < this.xZD.size(); i++) {
            if (((C3459b) this.xZD.get(i)).mo7915jk(j)) {
                String str = ((C3459b) this.xZD.get(i)).name;
                AppMethodBeat.m2505o(1419);
                return str;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        AppMethodBeat.m2505o(1419);
        return null;
    }

    /* renamed from: Rs */
    public final long mo15265Rs(String str) {
        AppMethodBeat.m2504i(BuildConfig.VERSION_CODE);
        String str2 = "select createTime from message where" + apG(str) + "order by createTime LIMIT 1 OFFSET 0";
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(BuildConfig.VERSION_CODE);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(BuildConfig.VERSION_CODE);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(BuildConfig.VERSION_CODE);
            return -1;
        }
    }

    /* renamed from: Rt */
    public final long mo15266Rt(String str) {
        AppMethodBeat.m2504i(1421);
        String str2 = "select createTime from message where" + apG(str) + "order by createTime DESC LIMIT 1 ";
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1421);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(1421);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(1421);
            return -1;
        }
    }

    /* renamed from: Ru */
    public final long mo15267Ru(String str) {
        AppMethodBeat.m2504i(1422);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1422);
            return 0;
        }
        String str2 = "select msgSeq from message where" + apG(str) + "order by msgSeq DESC LIMIT 1 ";
        C4990ab.m7416i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1422);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.m2505o(1422);
            return j;
        } else {
            a.close();
            AppMethodBeat.m2505o(1422);
            return 0;
        }
    }

    /* renamed from: ae */
    public final C7620bi mo15299ae(String str, long j) {
        AppMethodBeat.m2504i(1423);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1423);
            return null;
        }
        String str2 = "select * from message where" + apG(str) + " and msgSeq < " + j + " order by msgSeq DESC LIMIT 1 ";
        C4990ab.m7416i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 0);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1423);
            return null;
        } else if (a.moveToFirst()) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(1423);
            return c7620bi;
        } else {
            a.close();
            AppMethodBeat.m2505o(1423);
            return null;
        }
    }

    /* renamed from: Rv */
    public final C7620bi mo15268Rv(String str) {
        AppMethodBeat.m2504i(1424);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1424);
            return null;
        }
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.FALSE);
        Long l = (Long) this.xZJ.get(str);
        C7620bi c7620bi;
        if (l == null || l.longValue() <= 0) {
            C4990ab.m7416i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            c7620bi = new C7620bi();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = this.fni.mo10104a("SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ", null, 2);
            C4990ab.m7411d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (a == null) {
                C4990ab.m7412e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(1424);
                return c7620bi;
            }
            if (a.moveToFirst()) {
                c7620bi.mo8995d(a);
            }
            a.close();
            this.xZJ.mo4412k(str, Long.valueOf(c7620bi.field_msgId));
            AppMethodBeat.m2505o(1424);
            return c7620bi;
        }
        C4990ab.m7417i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        c7620bi = mo15340jf(l.longValue());
        if ((c7620bi.field_flag & 1) != 0) {
            AppMethodBeat.m2505o(1424);
            return c7620bi;
        }
        this.xZJ.remove(str);
        AppMethodBeat.m2505o(1424);
        return null;
    }

    /* renamed from: s */
    public final int mo15350s(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(1425);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j4), Long.valueOf(j3));
        String str2 = "SELECT COUNT(msgId) FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3;
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 2);
        if (a == null) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            AppMethodBeat.m2505o(1425);
            return 0;
        } else if (a.moveToFirst()) {
            C4990ab.m7411d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            AppMethodBeat.m2505o(1425);
            return a.getInt(0);
        } else {
            a.close();
            AppMethodBeat.m2505o(1425);
            return 0;
        }
    }

    /* renamed from: a */
    public final Cursor mo15283a(String str, long j, long j2, boolean z) {
        long j3;
        long j4;
        int i;
        AppMethodBeat.m2504i(1426);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        StringBuilder append = new StringBuilder("SELECT * FROM ").append(mo15264Rr(str)).append(" WHERE").append(apG(str)).append("AND createTime >= ").append(j4).append(" AND createTime <= ").append(j3).append(" AND isSend=");
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        String stringBuilder = append.append(i).append(" LIMIT 1").toString();
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(stringBuilder)));
        Cursor a = this.fni.mo10104a(stringBuilder, null, 0);
        AppMethodBeat.m2505o(1426);
        return a;
    }

    /* renamed from: t */
    public final Cursor mo15351t(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(1427);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3 + " ORDER BY createTime ASC ";
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 0);
        AppMethodBeat.m2505o(1427);
        return a;
    }

    /* renamed from: d */
    public final Cursor mo15328d(String str, long j, long j2, int i) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(1428);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM (SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3 + " ORDER BY createTime DESC LIMIT " + i + " ) ORDER BY createTime ASC";
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 0);
        AppMethodBeat.m2505o(1428);
        return a;
    }

    /* renamed from: b */
    public final Cursor mo15301b(String str, long j, long j2, int i) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(1429);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + (j4 > 0 ? " AND createTime >= ".concat(String.valueOf(j4)) : "") + (j3 > 0 ? " AND createTime <= ".concat(String.valueOf(j3)) : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        Cursor a = this.fni.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(1429);
        return a;
    }

    /* renamed from: u */
    public final int mo15352u(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(1430);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", str, "SELECT COUNT(*) FROM ( SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + (j4 > 0 ? " AND createTime >= ".concat(String.valueOf(j4)) : "") + (j3 > 0 ? " AND createTime <= ".concat(String.valueOf(j3)) : "") + " ORDER BY createTime)");
        Cursor a = this.fni.mo10104a(r0, null, 2);
        int i = 0;
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.m2505o(1430);
        }
        AppMethodBeat.m2505o(1430);
        return i;
    }

    /* renamed from: c */
    public final Cursor mo15315c(String str, long j, long j2, int i) {
        AppMethodBeat.m2504i(1431);
        String str2;
        Cursor a;
        if (j2 == 0) {
            str2 = "SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i;
            C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
            a = this.fni.mo10104a(str2, null, 0);
            AppMethodBeat.m2505o(1431);
            return a;
        }
        long j3;
        long j4;
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        str2 = "SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j4 + " AND createTime < " + j3 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i;
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        a = this.fni.mo10104a(str2, null, 0);
        AppMethodBeat.m2505o(1431);
        return a;
    }

    /* renamed from: v */
    public final int mo15353v(String str, long j, long j2) {
        long j3;
        long j4;
        int i;
        AppMethodBeat.m2504i(1432);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        Cursor a = this.fni.mo10104a("SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j4 + " AND createTime < " + j3, null, 2);
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
            i = 0;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.m2505o(1432);
        }
        AppMethodBeat.m2505o(1432);
        return i;
    }

    /* renamed from: w */
    public final Cursor mo15354w(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(1433);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3;
        C4990ab.m7410d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.mo10104a(str2, null, 0);
        AppMethodBeat.m2505o(1433);
        return a;
    }

    /* renamed from: G */
    public final Cursor mo15238G(String str, String str2, int i) {
        AppMethodBeat.m2504i(1434);
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        Cursor a = this.fni.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(1434);
        return a;
    }

    /* renamed from: cB */
    public final Cursor mo15317cB(String str, int i) {
        AppMethodBeat.m2504i(1435);
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + i);
        Cursor a = this.fni.mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(1435);
        return a;
    }

    /* renamed from: fc */
    public final int mo15333fc(String str, String str2) {
        int i;
        AppMethodBeat.m2504i(1436);
        Cursor a = this.fni.mo10104a(" SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND content LIKE '" + str2 + "%' ", null, 2);
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
            i = 0;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.m2505o(1436);
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", str, str2, Integer.valueOf(i), r2);
        AppMethodBeat.m2505o(1436);
        return i;
    }

    /* renamed from: Rw */
    public final int mo15269Rw(String str) {
        int i;
        AppMethodBeat.m2504i(1437);
        Cursor a = this.fni.mo10104a(" SELECT COUNT(*) FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND isSend=1", null, 2);
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
            i = 0;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.m2505o(1437);
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", str, Integer.valueOf(i), r2);
        AppMethodBeat.m2505o(1437);
        return i;
    }

    /* renamed from: f */
    public final long mo15330f(String str, long j, int i) {
        AppMethodBeat.m2504i(1438);
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(i));
        if (i <= 0) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "error target inc count");
            AppMethodBeat.m2505o(1438);
            return j;
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT " + i);
        Cursor a = this.fni.mo10104a(r0, null, 0);
        if (a == null) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            AppMethodBeat.m2505o(1438);
            return j;
        } else if (a.moveToLast()) {
            C4990ab.m7411d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            AppMethodBeat.m2505o(1438);
            return a.getLong(0);
        } else {
            a.close();
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.m2505o(1438);
            return j;
        }
    }

    /* renamed from: af */
    public final C7620bi mo15300af(String str, long j) {
        AppMethodBeat.m2504i(1439);
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(1));
        C7620bi c7620bi = new C7620bi();
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT * FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime < " + j + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1");
        Cursor a = this.fni.mo10104a(r1, null, 0);
        if (a == null) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            AppMethodBeat.m2505o(1439);
        } else if (a.moveToLast()) {
            c7620bi.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(1439);
        } else {
            a.close();
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.m2505o(1439);
        }
        return c7620bi;
    }

    /* renamed from: g */
    public final long mo15335g(String str, long j, int i) {
        AppMethodBeat.m2504i(1440);
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(i));
        if (i <= 0) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "error target inc count");
            AppMethodBeat.m2505o(1440);
            return j;
        }
        C4990ab.m7411d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + mo15264Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT " + i);
        Cursor a = this.fni.mo10104a(r0, null, 0);
        if (a == null) {
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            AppMethodBeat.m2505o(1440);
            return j;
        } else if (a.moveToLast()) {
            C4990ab.m7411d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            AppMethodBeat.m2505o(1440);
            return a.getLong(0);
        } else {
            a.close();
            C4990ab.m7420w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.m2505o(1440);
            return j;
        }
    }

    /* renamed from: cC */
    public final C7620bi[] mo15318cC(String str, int i) {
        AppMethodBeat.m2504i(1441);
        if (str == null || str.length() == 0 || i <= 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
            AppMethodBeat.m2505o(1441);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + "order by createTime DESC limit " + i, null, 2);
        if (a.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(a);
                arrayList.add(c7620bi);
            } while (a.moveToNext());
            a.close();
            C4990ab.m7410d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            C7620bi[] c7620biArr = (C7620bi[]) arrayList.toArray(new C7620bi[arrayList.size()]);
            AppMethodBeat.m2505o(1441);
            return c7620biArr;
        }
        C4990ab.m7420w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        a.close();
        AppMethodBeat.m2505o(1441);
        return null;
    }

    /* renamed from: fd */
    public final LinkedList<C7620bi> mo15334fd(String str, String str2) {
        LinkedList<C7620bi> linkedList = null;
        AppMethodBeat.m2504i(1442);
        Cursor a = this.fni.mo10105a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null || !a.moveToFirst()) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
            AppMethodBeat.m2505o(1442);
        } else {
            linkedList = new LinkedList();
            do {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(a);
                linkedList.add(c7620bi);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.m2505o(1442);
        }
        return linkedList;
    }

    /* renamed from: jj */
    public final void mo15344jj(long j) {
        AppMethodBeat.m2504i(1443);
        this.xZK.mo10525b(0, j, 0, false);
        AppMethodBeat.m2505o(1443);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Rx */
    public final List<C7620bi> mo15270Rx(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(1444);
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.fni.mo10105a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "talker=? AND createTime>=? AND type IN (436207665,419430449)", new String[]{C5046bo.m7586vA(str), String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo8995d(a);
                    arrayList.add(c7620bi);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(1444);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        AppMethodBeat.m2505o(1444);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(1444);
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(1444);
            throw th;
        }
    }

    /* renamed from: Rz */
    public final Cursor mo15272Rz(String str) {
        AppMethodBeat.m2504i(1445);
        try {
            Cursor a = this.fni.mo10105a(mo15264Rr(str), null, apG(str) + " AND createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            AppMethodBeat.m2505o(1445);
            return a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
            AppMethodBeat.m2505o(1445);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<C7620bi> bOH() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(1446);
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.fni.mo10105a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo8995d(a);
                    arrayList.add(c7620bi);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(1446);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.m2505o(1446);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(1446);
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.m2505o(1446);
            throw th;
        }
    }

    /* renamed from: Ry */
    public final long mo15271Ry(String str) {
        AppMethodBeat.m2504i(1447);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(1447);
            return 0;
        }
        C3459b apK = apK(str);
        if (apK == null) {
            AppMethodBeat.m2505o(1447);
            return 0;
        }
        long j = apK.fDH;
        AppMethodBeat.m2505o(1447);
        return j;
    }

    /* renamed from: h */
    public final Cursor mo15338h(String str, long j, int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(1448);
        try {
            cursor = this.fni.mo10104a("select * from " + str + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + j + "  order by msgId ASC  limit " + i, null, 0);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(1448);
        return cursor;
    }

    /* renamed from: cD */
    public final Cursor mo15319cD(String str, int i) {
        AppMethodBeat.m2504i(1449);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(1449);
            return null;
        }
        Cursor a = this.fni.mo10104a("select * from " + mo15264Rr(str) + " where" + apG(str) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + i + " OFFSET 0", null, 0);
        AppMethodBeat.m2505o(1449);
        return a;
    }

    public final void bOz() {
        AppMethodBeat.m2504i(1333);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(348167, Integer.valueOf(1));
        AppMethodBeat.m2505o(1333);
    }
}
