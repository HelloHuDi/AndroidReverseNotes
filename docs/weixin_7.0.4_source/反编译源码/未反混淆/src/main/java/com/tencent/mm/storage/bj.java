package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi.d;
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

public final class bj extends k implements h {
    public static final String[] fnj;
    private final com.tencent.mm.cd.h fni;
    private bd jyn;
    private be jyp;
    private final l<a, c> xHV = new l<a, c>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(1320);
            ((a) obj).a(bj.this, (c) obj2);
            AppMethodBeat.o(1320);
        }

        public final void el(List<c> list) {
            AppMethodBeat.i(1319);
            if (!(isLocked() || bj.this.jyp == null)) {
                for (c cVar : list) {
                    if (cVar != null) {
                        bj.this.jyp.b(bj.this, cVar);
                    }
                }
            }
            AppMethodBeat.o(1319);
        }
    };
    private final long xXI = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
    private boolean xZB = false;
    private final List<e> xZC = new CopyOnWriteArrayList();
    private List<b> xZD;
    private final f<Integer, bi.c> xZE = new com.tencent.mm.memory.a.c(100);
    private final f<Integer, d> xZF = new com.tencent.mm.memory.a.c(100);
    private final f<Integer, bi.a> xZG = new com.tencent.mm.memory.a.c(100);
    private final f<Integer, bi.b> xZH = new com.tencent.mm.memory.a.c(100);
    private final f<Integer, Object> xZI = new com.tencent.mm.memory.a.c(100);
    private final f<String, Long> xZJ = new com.tencent.mm.memory.a.c(100);
    private an xZK = new an();
    private Map<String, c> xZL = new HashMap();
    private boolean xZM = false;
    private String xZN = "";
    private long xZO = 0;

    public final void a(e eVar) {
        AppMethodBeat.i(1321);
        if (!this.xZC.contains(eVar)) {
            ab.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", eVar);
            this.xZC.add(eVar);
        }
        AppMethodBeat.o(1321);
    }

    public final com.tencent.mm.cd.h bOy() {
        return this.fni;
    }

    static {
        AppMethodBeat.i(1450);
        String[] strArr = new String[1];
        strArr[0] = "CREATE TABLE IF NOT EXISTS " + ShareConstants.WEB_DIALOG_PARAM_MESSAGE + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag INT) ";
        fnj = strArr;
        AppMethodBeat.o(1450);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(1322);
        if (this.xHV.cF(cVar)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.o(1322);
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(1323);
        this.xHV.a(aVar, looper);
        AppMethodBeat.o(1323);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(1324);
        this.xHV.remove(aVar);
        AppMethodBeat.o(1324);
    }

    public final void lock() {
        AppMethodBeat.i(1325);
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
        AppMethodBeat.o(1325);
    }

    public final void unlock() {
        AppMethodBeat.i(1326);
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
        AppMethodBeat.o(1326);
    }

    public final void QW(String str) {
        AppMethodBeat.i(1327);
        ab.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xZM), Integer.valueOf(this.xDf.xDi), Integer.valueOf(this.xHV.xDi), Integer.valueOf(this.xZL.size()), this.xZN, Long.valueOf(bo.gb(this.xZO)));
        if (bo.isNullOrNil(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.xZM) {
            ab.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.xZN, Long.valueOf(bo.gb(this.xZO)));
            AppMethodBeat.o(1327);
            return;
        }
        this.xZN = str;
        this.xZO = bo.anU();
        this.xZM = true;
        super.lock();
        this.xHV.lock();
        AppMethodBeat.o(1327);
    }

    public final void QX(String str) {
        AppMethodBeat.i(1328);
        ab.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.xZM), Integer.valueOf(this.xDf.xDi), Integer.valueOf(this.xHV.xDi), Integer.valueOf(this.xZL.size()), this.xZN, Long.valueOf(bo.gb(this.xZO)));
        if (bo.isNullOrNil(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.xZM) {
            ab.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, bo.dpG());
            AppMethodBeat.o(1328);
        } else if (str.equals(this.xZN)) {
            this.xZM = false;
            this.xZO = 0;
            this.xZN = "";
            for (String str2 : this.xZL.keySet()) {
                a((c) this.xZL.get(str2));
            }
            this.xZL.clear();
            super.unlock();
            this.xHV.unlock();
            doNotify();
            AppMethodBeat.o(1328);
        } else {
            ab.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.xZN, Long.valueOf(bo.gb(this.xZO)), str);
            AppMethodBeat.o(1328);
        }
    }

    public final void QY(String str) {
        AppMethodBeat.i(1329);
        if (this.xZM) {
            c cVar = null;
            if (this.xZL.containsKey(str)) {
                cVar = (c) this.xZL.get(str);
            }
            if (cVar == null) {
                ab.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", str, bo.dpG());
                AppMethodBeat.o(1329);
                return;
            }
            if (cVar.oqJ != null && cVar.oqJ.equals("insert") && cVar.oqL > 0) {
                ab.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", str, Integer.valueOf(cVar.oqL));
                cVar.oqL = 0;
            }
            AppMethodBeat.o(1329);
            return;
        }
        AppMethodBeat.o(1329);
    }

    public final void a(com.tencent.mm.cd.h hVar, String str) {
        AppMethodBeat.i(1330);
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj9 = null;
        Cursor a = hVar.a("PRAGMA table_info( " + str + " )", null, 2);
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
        long iV = hVar.iV(Thread.currentThread().getId());
        if (obj == null) {
            hVar.hY(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (obj2 == null) {
            hVar.hY(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (obj3 == null) {
            hVar.hY(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (obj4 == null) {
            hVar.hY(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (obj5 == null) {
            hVar.hY(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (obj6 == null) {
            hVar.hY(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (obj7 == null) {
            hVar.hY(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (obj8 == null) {
            hVar.hY(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (obj9 == null) {
            hVar.hY(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        hVar.mB(iV);
        AppMethodBeat.o(1330);
    }

    public final void P(String str, long j) {
        AppMethodBeat.i(1331);
        b apM = apM(str);
        long j2 = apM.fDH;
        Random random = new Random();
        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "BEGIN;");
        bi biVar = new bi(str);
        for (int i = 0; ((long) i) < j; i++) {
            biVar.eJ(System.currentTimeMillis());
            biVar.setType(1);
            biVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + bo.dpF());
            biVar.setMsgId(j2);
            biVar.setStatus(random.nextInt(4));
            biVar.hO(random.nextInt(1));
            j2++;
            apM.fDH++;
            biVar.eI(System.currentTimeMillis() + ((long) bo.dpF()));
            this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "INSERT INTO " + Rr(biVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + biVar.field_msgId + "," + biVar.field_msgSvrId + "," + biVar.getType() + "," + biVar.field_status + "," + biVar.field_createTime + ",'" + biVar.field_talker + "','" + biVar.field_content + "'," + apH(str) + ");");
            if (i % Downloads.MIN_WAIT_FOR_NETWORK == 0) {
                this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "COMMIT;");
                this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "BEGIN;");
            }
        }
        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "COMMIT;");
        this.jyp.apa(str);
        biVar.setMsgId(1 + j2);
        Z(biVar);
        AppMethodBeat.o(1331);
    }

    private void dug() {
        AppMethodBeat.i(1332);
        long currentTimeMillis = System.currentTimeMillis();
        long iV = this.fni.iV(Thread.currentThread().getId());
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
                this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, (String) arrayList.get(i2));
                i = i2 + 1;
            } else {
                ab.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                this.fni.mB(iV);
                ab.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(1332);
                return;
            }
        }
    }

    public bj(com.tencent.mm.cd.h hVar, bd bdVar, be beVar) {
        AppMethodBeat.i(1334);
        this.fni = hVar;
        this.jyn = bdVar;
        this.jyp = beVar;
        g.RQ();
        if (((Integer) g.RP().Ry().get(348169, Integer.valueOf(0))).intValue() == 0) {
            int delete = this.fni.delete(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "msgId> ? ", new String[]{"80000000"});
            ab.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(delete));
            g.RQ();
            g.RP().Ry().set(348169, Integer.valueOf(1));
        }
        a(hVar, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        dug();
        if (this.xZD == null) {
            this.xZD = new LinkedList();
        }
        this.xZD.clear();
        a(new b(1, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, b.a(1, 1000000, 10000000, 90000000)));
        AppMethodBeat.o(1334);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(1335);
        synchronized (this.xZD) {
            try {
                this.xZD.add(bVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(1335);
            }
        }
        b(bVar);
    }

    public final void bOA() {
        AppMethodBeat.i(1336);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.xZD.size()) {
                b((b) this.xZD.get(i2));
                i = i2 + 1;
            } else {
                AppMethodBeat.o(1336);
                return;
            }
        }
    }

    private void b(b bVar) {
        AppMethodBeat.i(1337);
        Cursor a = this.fni.a("select max(msgid) from " + bVar.name, null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            ab.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d", Integer.valueOf(i), Long.valueOf(bVar.fDH));
            if (((long) i) >= bVar.fDH) {
                bVar.yx(i);
            }
        }
        a.close();
        ab.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.fDH);
        AppMethodBeat.o(1337);
    }

    public final void bOB() {
        AppMethodBeat.i(1338);
        if (this.xZB) {
            String str = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
            Cursor a = this.fni.a("select count(*) from " + str + " where talkerId ISNULL ", null, 2);
            if (a != null) {
                int i;
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    i = 0;
                }
                a.close();
                if (i > 0) {
                    ab.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", str);
                    long currentTimeMillis = System.currentTimeMillis();
                    ab.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(this.fni.hY(str, "update " + str + " set talkerId=(select rowid from rcontact where rcontact.username = " + str + ".talker)")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (this.fni.hY(str, "update " + str + " set talkerId=(select rowid from rcontact where rcontact.username = " + str + ".talker)") && this.xZB) {
                        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                        this.fni.hY(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                        ab.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                    }
                }
            }
            AppMethodBeat.o(1338);
            return;
        }
        AppMethodBeat.o(1338);
    }

    public final bi jf(long j) {
        AppMethodBeat.i(1339);
        bi biVar = new bi();
        Cursor a = this.fni.a(mT(j), null, "msgId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1339);
        return biVar;
    }

    public final bi Q(String str, long j) {
        AppMethodBeat.i(1340);
        bi biVar = new bi();
        Cursor a = this.fni.a(Rr(str), null, "msgSvrId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1340);
        return biVar;
    }

    public final bi R(String str, long j) {
        AppMethodBeat.i(1341);
        bi biVar = new bi();
        Cursor a = this.fni.a(Rr(str), null, apG(str) + " AND msgSeq=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1341);
        return biVar;
    }

    public final bi S(String str, long j) {
        AppMethodBeat.i(1342);
        bi biVar = new bi();
        Cursor a = this.fni.a(Rr(str), null, "createTime=? AND" + apG(str), new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1342);
        return biVar;
    }

    public final Cursor QZ(String str) {
        AppMethodBeat.i(1343);
        Cursor query = this.fni.query(Rr(str), new String[]{"createTime", "msgId"}, apG(str), null, "createTime", null, "createTime ASC");
        AppMethodBeat.o(1343);
        return query;
    }

    public final List<bi> T(String str, long j) {
        AppMethodBeat.i(1344);
        ArrayList arrayList = new ArrayList();
        String str2 = "Select * From " + Rr(str) + " Where " + apG(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11";
        Cursor a = this.fni.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            bi biVar = new bi();
            biVar.d(a);
            arrayList.add(biVar);
        }
        a.close();
        AppMethodBeat.o(1344);
        return arrayList;
    }

    public final List<bi> U(String str, long j) {
        AppMethodBeat.i(1345);
        ArrayList arrayList = new ArrayList();
        String str2 = "Select * From " + Rr(str) + " Where " + apG(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 11;";
        Cursor a = this.fni.a(str2, new String[]{String.valueOf(j)}, 2);
        while (a.moveToNext()) {
            bi biVar = new bi();
            biVar.d(a);
            arrayList.add(biVar);
        }
        a.close();
        AppMethodBeat.o(1345);
        return arrayList;
    }

    public final bi V(String str, long j) {
        AppMethodBeat.i(1346);
        bi biVar = new bi();
        String str2 = "Select * From " + Rr(str) + " Where " + apG(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;";
        Cursor a = this.fni.a(str2, new String[]{String.valueOf(j)}, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1346);
        return biVar;
    }

    public final bi W(String str, long j) {
        AppMethodBeat.i(1347);
        bi biVar = new bi();
        String str2 = "Select * From " + Rr(str) + " Where " + apG(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;";
        Cursor a = this.fni.a(str2, new String[]{String.valueOf(j)}, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1347);
        return biVar;
    }

    private String apG(String str) {
        AppMethodBeat.i(1348);
        String Rr = Rr(str);
        if (this.xZB && Rr.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            Rr = " talkerId=" + apH(str) + " ";
            AppMethodBeat.o(1348);
            return Rr;
        }
        Rr = " talker= '" + bo.vA(str) + "' ";
        AppMethodBeat.o(1348);
        return Rr;
    }

    private long apH(String str) {
        AppMethodBeat.i(1349);
        long aoP = this.jyn.aoP(str);
        if (aoP < 0) {
            ad adVar = new ad(str);
            adVar.setType(2);
            this.jyn.Z(adVar);
            aoP = this.jyn.aoP(str);
        }
        if (!com.tencent.mm.sdk.a.b.dnQ()) {
            ab.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(aoP), Boolean.valueOf(r2), bo.dpG());
        }
        AppMethodBeat.o(1349);
        return aoP;
    }

    public final ArrayList<bi> bOC() {
        AppMethodBeat.i(1350);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.fni.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            int i;
            bi biVar = new bi();
            biVar.d(a);
            if (biVar.dtK()) {
                i = 0;
            } else {
                i = 1;
            }
            if (!((i & 1) == 0 || ad.aou(biVar.field_talker) || ad.aow(biVar.field_talker) || ad.mR(biVar.field_talker))) {
                arrayList.add(biVar);
            }
        }
        a.close();
        AppMethodBeat.o(1350);
        return arrayList;
    }

    public final void K(ArrayList<Long> arrayList) {
        AppMethodBeat.i(1351);
        long iV = this.fni.iV(-1);
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                bi jf = jf(longValue);
                jf.ht(jf.dqI | 32);
                ab.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                a(longValue, jf);
            }
        } finally {
            this.fni.mB(iV);
            AppMethodBeat.o(1351);
        }
    }

    public final boolean X(String str, long j) {
        AppMethodBeat.i(1352);
        if (S(str, j).field_msgId > 0) {
            AppMethodBeat.o(1352);
            return true;
        }
        AppMethodBeat.o(1352);
        return false;
    }

    public final int e(String str, long j, int i) {
        AppMethodBeat.i(1353);
        String str2 = "SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime < " + j + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i;
        Cursor a = this.fni.a(str2, null, 0);
        int count = a.getCount();
        a.close();
        ab.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j + " count " + count + " [" + str2 + "]");
        AppMethodBeat.o(1353);
        return count;
    }

    public final bi Ra(String str) {
        AppMethodBeat.i(1354);
        bi biVar = new bi();
        Cursor a = this.fni.a(Rr(str), null, apG(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1354);
        return biVar;
    }

    public final bi Rb(String str) {
        AppMethodBeat.i(1355);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1355);
            return null;
        }
        bi biVar = new bi();
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + "order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1355);
        return biVar;
    }

    public final bi Y(String str, long j) {
        AppMethodBeat.i(1356);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1356);
            return null;
        }
        bi biVar = new bi();
        String str2 = "select * from " + Rr(str) + " where" + apG(str) + "AND msgSeq<" + j + " order by msgSeq DESC limit 1";
        Cursor a = this.fni.a(str2, null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        ab.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(str2)));
        AppMethodBeat.o(1356);
        return biVar;
    }

    public final bi fa(String str, String str2) {
        AppMethodBeat.i(1357);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            AppMethodBeat.o(1357);
            return null;
        }
        bi biVar = new bi();
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        ab.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(biVar.field_msgId));
        AppMethodBeat.o(1357);
        return biVar;
    }

    public final bi Rc(String str) {
        AppMethodBeat.i(1358);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1358);
            return null;
        }
        bi biVar = new bi();
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + "and isSend = 0  order by createTime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(1358);
        return biVar;
    }

    public final List<bi> cs(String str, int i) {
        AppMethodBeat.i(1359);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.xZD != null);
        Cursor a = this.fni.a("SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND status = 3 AND type <> 10000 ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            bi biVar = new bi();
            biVar.d(a);
            arrayList.add(biVar);
        }
        a.close();
        AppMethodBeat.o(1359);
        return arrayList;
    }

    public final bi yw(int i) {
        AppMethodBeat.i(1360);
        if (this.xZD == null) {
            ab.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            AppMethodBeat.o(1360);
            return null;
        }
        bi biVar = new bi();
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.xZD.size()) {
                if ((((b) this.xZD.get(i3)).oqG & i) != 0) {
                    Cursor a = this.fni.a("select * from " + ((b) this.xZD.get(i3)).name + "  order by createTime DESC limit 1", null, 2);
                    if (a.moveToFirst()) {
                        long j2 = a.getLong(a.getColumnIndex("createTime"));
                        if (j < j2) {
                            biVar.d(a);
                            j = j2;
                        }
                    }
                    a.close();
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(1360);
                return biVar;
            }
        }
    }

    public final bi Rd(String str) {
        AppMethodBeat.i(1361);
        if (this.xZD == null) {
            ab.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            AppMethodBeat.o(1361);
            return null;
        }
        String str2;
        bi biVar = new bi();
        long j = 0;
        if (bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            str2 = str.replaceFirst("and", "where");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.xZD.size()) {
                if ((((b) this.xZD.get(i2)).oqG & 8) != 0) {
                    Cursor a = this.fni.a("select * from " + ((b) this.xZD.get(i2)).name + str2 + "  order by createTime DESC limit 1", null, 2);
                    if (a.moveToFirst()) {
                        long j2 = a.getLong(a.getColumnIndex("createTime"));
                        if (j < j2) {
                            biVar.d(a);
                            j = j2;
                        }
                    }
                    a.close();
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(1361);
                return biVar;
            }
        }
    }

    public final List<bi> bOD() {
        AppMethodBeat.i(1362);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.xZD != null);
        ArrayList<bi> arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.xZD.size()) {
                break;
            }
            Cursor a = this.fni.a(((b) this.xZD.get(i2)).name, null, "status=1 and isSend=1", null, null, null, "createTime DESC ", 2);
            while (a.moveToNext()) {
                bi biVar = new bi();
                biVar.d(a);
                if (biVar.isText() || biVar.dtw() || biVar.bAC() || biVar.dtE()) {
                    if (bf.aaa() - biVar.field_createTime > 86400000) {
                        arrayList2.add(biVar);
                    } else {
                        arrayList.add(biVar);
                    }
                }
            }
            a.close();
            i = i2 + 1;
        }
        if (arrayList2.size() > 0) {
            long iV = this.fni.iV(-1);
            for (bi biVar2 : arrayList2) {
                ab.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d talker:%s content:%s", Long.valueOf(biVar2.field_msgId), Long.valueOf(biVar2.field_createTime), biVar2.field_talker, bo.anv(biVar2.field_content));
                biVar2.setStatus(5);
                a(biVar2.field_msgId, biVar2);
            }
            this.fni.mB(iV);
        }
        AppMethodBeat.o(1362);
        return arrayList;
    }

    public final List<bi> ct(String str, int i) {
        AppMethodBeat.i(1363);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.xZD != null);
        Cursor a = this.fni.a("SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i, null, 2);
        while (a.moveToNext()) {
            bi biVar = new bi();
            biVar.d(a);
            if (biVar.isText()) {
                arrayList.add(biVar);
            }
        }
        a.close();
        AppMethodBeat.o(1363);
        return arrayList;
    }

    public final List<bi> aa(String str, int i, int i2) {
        AppMethodBeat.i(1364);
        ArrayList arrayList = new ArrayList();
        ab.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", "SELECT * FROM " + Rr(str) + " WHERE type = 49 ORDER BY createTime DESC LIMIT " + i + " , " + i2);
        Cursor a = this.fni.a(r1, null, 2);
        while (a.moveToNext()) {
            bi biVar = new bi();
            biVar.d(a);
            if (biVar.bAA()) {
                arrayList.add(biVar);
            }
        }
        a.close();
        AppMethodBeat.o(1364);
        return arrayList;
    }

    public final int Y(bi biVar) {
        int i = 0;
        AppMethodBeat.i(1365);
        if (biVar == null || bo.isNullOrNil(biVar.field_talker)) {
            AppMethodBeat.o(1365);
        } else {
            Cursor a = this.fni.a("SELECT count(msgId) FROM " + Rr(biVar.field_talker) + " WHERE" + apG(biVar.field_talker) + "AND isSend = 0 AND msgId >= " + biVar.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(1365);
        }
        return i;
    }

    private static String apI(String str) {
        AppMethodBeat.i(1366);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1366);
            return null;
        }
        try {
            Map z = br.z(str, "msgsource");
            if (z == null || z.isEmpty()) {
                AppMethodBeat.o(1366);
                return null;
            }
            String str2 = (String) z.get(".msgsource.bizmsg.msgcluster");
            AppMethodBeat.o(1366);
            return str2;
        } catch (Exception e) {
            ab.e("MicroMsg.MsgInfoStorage", "exception:%s", bo.l(e));
            ab.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e.getMessage());
            AppMethodBeat.o(1366);
            return null;
        }
    }

    private static void as(bi biVar) {
        AppMethodBeat.i(1367);
        if (biVar == null || !biVar.bAA()) {
            AppMethodBeat.o(1367);
            return;
        }
        try {
            String str = biVar.field_content;
            int indexOf = str.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str.length()) {
                str = str.substring(indexOf).trim();
            }
            Map z = br.z(str, "msg");
            if (z != null && z.size() > 0) {
                biVar.jw(be.aS(z));
            }
            AppMethodBeat.o(1367);
        } catch (Exception e) {
            ab.e("MicroMsg.MsgInfoStorage", e.getMessage());
            AppMethodBeat.o(1367);
        }
    }

    public final long Z(bi biVar) {
        AppMethodBeat.i(1368);
        long c = c(biVar, false);
        AppMethodBeat.o(1368);
        return c;
    }

    public final long c(bi biVar, boolean z) {
        AppMethodBeat.i(1369);
        String str;
        String str2;
        if (biVar == null || bo.isNullOrNil(biVar.field_talker)) {
            e.pXa.a(111, 250, 1, false);
            str = "MicroMsg.MsgInfoStorage";
            String str3 = "Error insert message msg:%s talker:%s";
            Object[] objArr = new Object[2];
            objArr[0] = biVar;
            if (biVar == null) {
                str2 = "-1";
            } else {
                str2 = biVar.field_talker;
            }
            objArr[1] = str2;
            ab.e(str, str3, objArr);
            AppMethodBeat.o(1369);
            return -1;
        }
        ab.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.xZM), Long.valueOf(biVar.field_msgSeq));
        str2 = null;
        bf.b oE = bf.oE(biVar.dqJ);
        if (oE != null) {
            str2 = oE.fmp;
        }
        if (t.nE(str2)) {
            ab.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str2);
            if (biVar.getType() == 436207665) {
                ab.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                AppMethodBeat.o(1369);
                return -1;
            }
            biVar.ju("notifymessage");
        }
        b apM = apM(biVar.field_talker);
        if (apM == null) {
            e.pXa.a(111, 249, 1, false);
            ab.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", biVar.field_talker);
            AppMethodBeat.o(1369);
            return -1;
        }
        apM.ac(biVar);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", new Object[]{Long.valueOf(biVar.field_msgId), apM, mT(biVar.field_msgId)}), apM.name.equals(mT(biVar.field_msgId)));
        if (biVar.field_msgSvrId != 0) {
            biVar.HH();
        }
        for (e a : this.xZC) {
            if (!a.a(biVar, oE)) {
                ab.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", biVar.field_talker, biVar.dqJ);
                AppMethodBeat.o(1369);
                return -1;
            }
        }
        as(biVar);
        if (apM.name.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            biVar.hX((int) apH(biVar.field_talker));
        }
        ab.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(this.fni.a(apM.name, "msgId", biVar.Hl(), z)), biVar.field_talker, Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.getType()), Integer.valueOf(biVar.field_status), Long.valueOf(biVar.field_msgSvrId), Long.valueOf(biVar.field_msgSeq), Integer.valueOf(biVar.field_flag), Long.valueOf(biVar.field_createTime), Integer.valueOf(biVar.field_isSend), this.xZN, Long.valueOf(bo.gb(this.xZO)));
        if (this.fni.a(apM.name, "msgId", biVar.Hl(), z) == -1) {
            e.pXa.a(111, 248, 1, false);
            ab.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(biVar.field_msgSvrId), Long.valueOf(r10));
            AppMethodBeat.o(1369);
            return -1;
        }
        if (this.xZM && bo.gb(this.xZO) > FaceGestureDetGLThread.BRIGHTNESS_DURATION && biVar.field_isSend == 1 && biVar.field_status == 1) {
            ab.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.xZN, Long.valueOf(bo.gb(this.xZO)));
            QX(this.xZN);
        }
        c cVar;
        if (this.xZM) {
            Object obj;
            str2 = null;
            if (e.xHP != null) {
                str2 = e.xHP.N(biVar);
            }
            if (bo.isNullOrNil(str2)) {
                obj = biVar.field_talker;
            } else {
                str = str2;
            }
            cVar = null;
            if (this.xZL.containsKey(obj)) {
                cVar = (c) this.xZL.get(obj);
            }
            if (cVar == null) {
                cVar = new c(biVar.field_talker, "insert", biVar);
            } else {
                cVar.oqK.add(biVar);
            }
            if (c.ad(biVar)) {
                cVar.oqL++;
            }
            cVar.oqM++;
            this.xZL.put(obj, cVar);
        } else {
            cVar = new c(biVar.field_talker, "insert", biVar);
            if (c.ad(biVar)) {
                cVar.oqL = 1;
            }
            cVar.oqM = 1;
            doNotify();
            a(cVar);
        }
        long j = biVar.field_msgId;
        AppMethodBeat.o(1369);
        return j;
    }

    public final int jg(long j) {
        AppMethodBeat.i(1370);
        bi jf = jf(j);
        String str = jf.field_talker;
        this.xZK.m((int) (bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC), jf.field_msgSvrId, jf.field_createTime / 1000);
        int delete = this.fni.delete(mT(j), "msgId=?", new String[]{String.valueOf(j)});
        ((ak) g.K(ak.class)).fk(j);
        if (delete != 0) {
            anF("delete_id ".concat(String.valueOf(j)));
            c cVar = new c(str, "delete", jf, 1, (byte) 0);
            cVar.oqO = j;
            cVar.jMj = jf.field_bizChatId;
            a(cVar);
        } else {
            e.pXa.a(111, 245, 1, false);
        }
        AppMethodBeat.o(1370);
        return delete;
    }

    public final List<bi> Re(String str) {
        List<bi> list = null;
        AppMethodBeat.i(1371);
        Cursor a = this.fni.a("select * from ".concat(String.valueOf(str)), null, 2);
        if (a == null) {
            AppMethodBeat.o(1371);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    bi biVar = new bi();
                    biVar.d(a);
                    list.add(biVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(1371);
        }
        return list;
    }

    public final long Z(String str, long j) {
        AppMethodBeat.i(1372);
        String str2 = "select createTime from " + Rr(str) + " where msgId = " + j;
        long j2 = 0;
        Cursor a = this.fni.a(str2, null, 2);
        if (a.moveToFirst()) {
            j2 = a.getLong(0);
        }
        a.close();
        AppMethodBeat.o(1372);
        return j2;
    }

    public final List<bi> g(String str, long j, boolean z) {
        AppMethodBeat.i(1373);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
            AppMethodBeat.o(1373);
            return null;
        }
        long Z = Z(str, j);
        if (Z == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            AppMethodBeat.o(1373);
            return null;
        }
        String str2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime > " + Z + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + Z + "  order by createTime DESC limit 10";
        }
        Cursor a = this.fni.a(str2, null, 2);
        while (a.moveToNext()) {
            bi biVar = new bi();
            biVar.d(a);
            arrayList.add(biVar);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        a.close();
        AppMethodBeat.o(1373);
        return arrayList;
    }

    public final Cursor ab(String str, int i, int i2) {
        AppMethodBeat.i(1374);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(1374);
            return null;
        }
        Cursor a = this.fni.a("select * from ( select * from " + Rr(str) + " where" + apG(str) + " AND type IN (3,39,13,43,62,44,268435505)  order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 2);
        AppMethodBeat.o(1374);
        return a;
    }

    public final Cursor p(String str, long j, long j2) {
        AppMethodBeat.i(1375);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(1375);
            return null;
        }
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
        AppMethodBeat.o(1375);
        return a;
    }

    public final Cursor cw(String str, int i) {
        AppMethodBeat.i(1376);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
            AppMethodBeat.o(1376);
            return null;
        }
        Cursor a = this.fni.a("select * from ( select * from " + Rr(str) + " where" + apG(str) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + i + ") order by createTime ASC ", null, 2);
        AppMethodBeat.o(1376);
        return a;
    }

    public final Cursor q(String str, long j, long j2) {
        AppMethodBeat.i(1377);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
            AppMethodBeat.o(1377);
            return null;
        }
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + j + " AND createTime< " + j2 + " order by createTime ASC", null, 2);
        AppMethodBeat.o(1377);
        return a;
    }

    public final Cursor Rf(String str) {
        AppMethodBeat.i(1378);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(1378);
            return null;
        }
        String Rr = Rr(str);
        Cursor a = this.fni.a("select * from " + Rr + " " + apJ(Rr) + " where" + apG(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime", null, 0);
        ab.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Rr);
        AppMethodBeat.o(1378);
        return a;
    }

    public final Cursor cu(String str, int i) {
        AppMethodBeat.i(1379);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(1379);
            return null;
        }
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + " AND type = 49  order by createTime DESC limit " + i + " OFFSET 0", null, 0);
        AppMethodBeat.o(1379);
        return a;
    }

    public final Cursor cv(String str, int i) {
        AppMethodBeat.i(1380);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(1380);
            return null;
        }
        StringBuilder append = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append(Rr(str)).append(" where").append(apG(str)).append(" AND ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" (type = 49");
        stringBuilder.append(" or type = 587202609");
        stringBuilder.append(" or type = 553648177) ");
        Cursor a = this.fni.a(append.append(stringBuilder.toString()).append("  order by createTime DESC limit 100 OFFSET ").append(i).toString(), null, 0);
        AppMethodBeat.o(1380);
        return a;
    }

    public final void b(String str, String str2, String[] strArr) {
        AppMethodBeat.i(1381);
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((bo.anT() - 172800) * 1000);
        if (!bo.isNullOrNil(str2)) {
            str3 = str3 + " AND " + str2;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor a = this.fni.a(str3, strArr, 2);
        if (a.moveToFirst()) {
            do {
                long j = a.getLong(1) / 1000;
                arrayList.add(Integer.valueOf(a.getInt(0)));
                arrayList2.add(Long.valueOf(j));
            } while (a.moveToNext());
            this.xZK.p(arrayList, arrayList2);
        }
        a.close();
        AppMethodBeat.o(1381);
    }

    public final boolean jh(long j) {
        AppMethodBeat.i(1382);
        boolean mR = this.xZK.mR(j);
        AppMethodBeat.o(1382);
        return mR;
    }

    public final void Rg(String str) {
        AppMethodBeat.i(1383);
        b(str, "", null);
        if (this.fni.hY(str, "delete from ".concat(String.valueOf(str)))) {
            anF("delete_all ".concat(String.valueOf(str)));
            AppMethodBeat.o(1383);
            return;
        }
        e.pXa.a(111, 247, 1, false);
        AppMethodBeat.o(1383);
    }

    public final int aa(String str, long j) {
        AppMethodBeat.i(1384);
        bi Q = Q(str, j);
        this.xZK.m((int) (bo.anT() / TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC), Q.field_msgSvrId, Q.field_createTime / 1000);
        int delete = this.fni.delete(Rr(str), "msgSvrId=?", new String[]{String.valueOf(j)});
        if (delete != 0) {
            doNotify();
            a(new c(str, "delete", null, 1, (byte) 0));
        } else {
            e.pXa.a(111, 246, 1, false);
        }
        AppMethodBeat.o(1384);
        return delete;
    }

    public final int Rh(String str) {
        AppMethodBeat.i(1385);
        ab.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, an.doR());
        b(Rr(str), apG(str), null);
        int delete = this.fni.delete(Rr(str), apG(str), null);
        if (delete != 0) {
            anF("delete_talker ".concat(String.valueOf(str)));
            c cVar = new c(str, "delete", null, delete, (byte) 0);
            cVar.oqO = -1;
            a(cVar);
        }
        AppMethodBeat.o(1385);
        return delete;
    }

    public final int ab(String str, long j) {
        AppMethodBeat.i(1386);
        String str2 = apG(str) + " and createTime <= " + j;
        b(Rr(str), str2, null);
        int delete = this.fni.delete(Rr(str), str2, null);
        if (delete != 0) {
            anF("delete_talker ".concat(String.valueOf(str)));
            c cVar = new c(str, "delete", null, delete, (byte) 0);
            cVar.oqO = -1;
            a(cVar);
        }
        AppMethodBeat.o(1386);
        return delete;
    }

    public final int cx(String str, int i) {
        AppMethodBeat.i(1387);
        ab.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i), an.doR());
        Assert.assertTrue(str.equals(Q(str, (long) i).field_talker));
        b(Rr(str), "createTime<=? AND" + apG(str), new String[]{r0.field_createTime});
        int delete = this.fni.delete(Rr(str), "createTime<=? AND" + apG(str), new String[]{r0.field_createTime});
        if (delete != 0) {
            doNotify();
            a(new c(str, "delete", null, delete, (byte) 0));
        }
        AppMethodBeat.o(1387);
        return delete;
    }

    public final Cursor cy(String str, int i) {
        AppMethodBeat.i(1388);
        Assert.assertTrue(str.equals(Q(str, (long) i).field_talker));
        Cursor query = this.fni.query(Rr(str), null, "createTime<=? AND" + apG(str), new String[]{r5.field_createTime}, null, null, null);
        AppMethodBeat.o(1388);
        return query;
    }

    public final void a(long j, bi biVar) {
        AppMethodBeat.i(1389);
        if (biVar.dtu()) {
            if (t.nE(apI(biVar.dqJ))) {
                ab.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", apI(biVar.dqJ));
                biVar.ju("notifymessage");
            }
        }
        as(biVar);
        if (this.fni.update(mT(j), biVar.Hl(), "msgId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c(biVar.field_talker, "update", biVar));
            AppMethodBeat.o(1389);
            return;
        }
        e.pXa.a(111, 244, 1, false);
        AppMethodBeat.o(1389);
    }

    public final void aa(bi biVar) {
        AppMethodBeat.i(1390);
        if (biVar == null || biVar.field_status == 4) {
            AppMethodBeat.o(1390);
            return;
        }
        biVar.setStatus(4);
        String mT = mT(biVar.field_msgId);
        if (mT != null && mT.length() > 0) {
            if (this.fni.update(mT, biVar.Hl(), "msgId=?", new String[]{biVar.field_msgId}) != 0) {
                doNotify();
                a(new c(biVar.field_talker, "update", biVar, -1));
            }
        }
        AppMethodBeat.o(1390);
    }

    public final void b(long j, bi biVar) {
        AppMethodBeat.i(1391);
        Assert.assertTrue("no talker set when update by svrid", bo.nullAsNil(biVar.field_talker).length() > 0);
        if (biVar.dtu()) {
            if (t.nE(apI(biVar.dqJ))) {
                ab.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", apI(biVar.dqJ));
                biVar.ju("notifymessage");
            }
        }
        as(biVar);
        if (this.fni.update(Rr(biVar.field_talker), biVar.Hl(), "msgSvrId=?", new String[]{String.valueOf(j)}) != 0) {
            doNotify();
            a(new c(biVar.field_talker, "update", biVar));
            AppMethodBeat.o(1391);
            return;
        }
        e.pXa.a(111, 243, 1, false);
        AppMethodBeat.o(1391);
    }

    public final int Ri(String str) {
        AppMethodBeat.i(1392);
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        int update = this.fni.update(Rr(str), contentValues, apG(str) + "AND isSend=? AND status!=? ", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"});
        if (update != 0) {
            doNotify();
            a(new c(str, "update", null));
        }
        AppMethodBeat.o(1392);
        return update;
    }

    public final int ab(bi biVar) {
        int i = 0;
        AppMethodBeat.i(1393);
        if (biVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(FirebaseAnalytics.b.CONTENT, biVar.field_content);
            contentValues.put("status", Integer.valueOf(biVar.field_status));
            i = this.fni.update(mT(biVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(biVar.field_msgId)});
            if (i != 0) {
                doNotify();
                a(new c(biVar.field_talker, "update", biVar));
            }
        }
        AppMethodBeat.o(1393);
        return i;
    }

    public final Cursor Rj(String str) {
        AppMethodBeat.i(1394);
        Cursor query = this.fni.query(Rr(str), null, apG(str), null, null, null, "createTime ASC ");
        AppMethodBeat.o(1394);
        return query;
    }

    public final Cursor h(String str, int i, long j) {
        AppMethodBeat.i(1395);
        Cursor a = this.fni.a("SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + " AND createTime <= " + j + " order by createTime ASC limit " + i, null, 0);
        AppMethodBeat.o(1395);
        return a;
    }

    public final Cursor fb(String str, String str2) {
        AppMethodBeat.i(1396);
        Cursor a = this.fni.a(("SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null, 0);
        AppMethodBeat.o(1396);
        return a;
    }

    public final Cursor i(String str, int i, long j) {
        AppMethodBeat.i(1397);
        ab.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + (j > 0 ? " AND createTime > ".concat(String.valueOf(j)) : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        Cursor a = this.fni.a(r0, null, 0);
        AppMethodBeat.o(1397);
        return a;
    }

    public final Cursor Rk(String str) {
        AppMethodBeat.i(1398);
        Cursor query = this.fni.query(Rr(str), null, "isSend=? AND" + apG(str) + "AND status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, null, null, null);
        AppMethodBeat.o(1398);
        return query;
    }

    public final Cursor cz(String str, int i) {
        AppMethodBeat.i(1399);
        Cursor query = this.fni.query(Rr(str), null, "isSend=? AND" + apG(str) + "AND status!=?  order by msgId DESC limit " + i, new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, null, null, null);
        AppMethodBeat.o(1399);
        return query;
    }

    public final Cursor bOE() {
        AppMethodBeat.i(1400);
        Cursor query = this.fni.query(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, "talker", null, null);
        AppMethodBeat.o(1400);
        return query;
    }

    public final bi.c Rl(String str) {
        AppMethodBeat.i(1401);
        bi.c cVar = (bi.c) this.xZE.get(Integer.valueOf(str.hashCode()));
        if (cVar == null) {
            cVar = bi.c.apE(str);
            this.xZE.k(Integer.valueOf(str.hashCode()), cVar);
        }
        AppMethodBeat.o(1401);
        return cVar;
    }

    public final d Rm(String str) {
        AppMethodBeat.i(1402);
        d dVar = (d) this.xZF.get(Integer.valueOf(str.hashCode()));
        if (dVar == null) {
            dVar = d.apF(str);
            this.xZF.k(Integer.valueOf(str.hashCode()), dVar);
        }
        AppMethodBeat.o(1402);
        return dVar;
    }

    public final bi.a Rn(String str) {
        AppMethodBeat.i(1403);
        bi.a aVar = null;
        if (bo.isNullOrNil(str) || this.xZG == null) {
            ab.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(bo.isNullOrNil(str)));
            ab.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = (bi.a) this.xZG.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = bi.a.apC(str);
            if (this.xZG != null) {
                this.xZG.k(Integer.valueOf(bo.bc(str, "").hashCode()), aVar);
            }
        }
        AppMethodBeat.o(1403);
        return aVar;
    }

    public final bi.b Ro(String str) {
        AppMethodBeat.i(1404);
        bi.b bVar = (bi.b) this.xZH.get(Integer.valueOf(str.hashCode()));
        if (bVar == null) {
            bVar = bi.b.apD(str);
            this.xZH.k(Integer.valueOf(str.hashCode()), bVar);
        }
        AppMethodBeat.o(1404);
        return bVar;
    }

    public final int Rp(String str) {
        int i = 0;
        AppMethodBeat.i(1405);
        if (oB(str)) {
            int apr = this.jyp.apr(str);
            if (apr > 0) {
                ab.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(apr));
                AppMethodBeat.o(1405);
                return apr;
            }
            ab.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else {
            Cursor a;
            if ("appbrandmessage".equals(Rr(str))) {
                a = this.fni.a("SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str), null, 0);
                if (a.moveToLast()) {
                    i = a.getInt(0);
                }
                a.close();
                AppMethodBeat.o(1405);
                return i;
            }
            if ("bottlemessage".equals(Rr(str))) {
                a = this.fni.a("SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str), null, 2);
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                }
                a.close();
                AppMethodBeat.o(1405);
                return i;
            }
        }
        i = oA(str);
        AppMethodBeat.o(1405);
        return i;
    }

    public final boolean oB(String str) {
        AppMethodBeat.i(1406);
        boolean equals = ShareConstants.WEB_DIALOG_PARAM_MESSAGE.equals(Rr(str));
        AppMethodBeat.o(1406);
        return equals;
    }

    public final int oA(String str) {
        int i = 0;
        AppMethodBeat.i(1407);
        Cursor a = this.fni.a("SELECT COUNT(*) FROM " + Rr(str) + " " + duh() + " WHERE" + apG(str), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(1407);
        return i;
    }

    private String duh() {
        if (this.xZB) {
            return "INDEXED BY messageTalkerIdStatusIndex";
        }
        return "INDEXED BY messageTalkerStatusIndex";
    }

    private String apJ(String str) {
        AppMethodBeat.i(1408);
        String str2;
        if (str == null || !str.equals(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
            str2 = "";
            AppMethodBeat.o(1408);
            return str2;
        } else if (this.xZB) {
            str2 = "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
            AppMethodBeat.o(1408);
            return str2;
        } else {
            str2 = "INDEXED BY messageCreateTaklerTypeTimeIndex";
            AppMethodBeat.o(1408);
            return str2;
        }
    }

    public final int cA(String str, int i) {
        int i2 = 0;
        AppMethodBeat.i(1409);
        Cursor a = this.fni.a("SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str) + "AND type = " + i, null, 2);
        if (a.moveToFirst()) {
            i2 = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(1409);
        return i2;
    }

    public final int r(String str, long j, long j2) {
        int i = 0;
        AppMethodBeat.i(1410);
        Cursor a = this.fni.a("SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str) + "AND type = 50 AND createTime >= " + j + " AND createTime <= " + j2 + " LIMIT 1", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(1410);
        return i;
    }

    public final int Rq(String str) {
        int i = 0;
        AppMethodBeat.i(1411);
        if (str == null) {
            ab.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
            AppMethodBeat.o(1411);
        } else {
            StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
            String str2 = "username == null";
            boolean z = str != null && str.length() > 0;
            Assert.assertTrue(str2, z);
            String str3 = apM(str).name;
            Cursor a = this.fni.a(stringBuilder.append(str3 + "  indexed by  " + str3 + "TalkerTypeIndex ").append(" WHERE talker= '").append(bo.vA(str)).append("' AND type IN (3,39,13,43,62,44,268435505)").toString(), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(1411);
        }
        return i;
    }

    public final int ac(String str, long j) {
        int i = 0;
        AppMethodBeat.i(1412);
        bi jf = jf(j);
        if (jf.field_msgId == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.o(1412);
        } else {
            String Rr = Rr(str);
            Cursor a = this.fni.a("SELECT COUNT(*) FROM " + Rr + " " + apJ(Rr) + " WHERE " + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + jf.field_createTime, null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(1412);
        }
        return i;
    }

    public final String ad(String str, long j) {
        String str2 = null;
        int i = 0;
        AppMethodBeat.i(1413);
        bi jf = jf(j);
        if (jf.field_msgId == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.o(1413);
        } else {
            String Rr = Rr(str);
            Cursor a = this.fni.a("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + Rr + " " + apJ(Rr) + " WHERE" + apG(str) + "AND type IN (3,39,13,43,62,44,268435505) AND createTime < " + jf.field_createTime, null, 0);
            str2 = "";
            if (a.moveToFirst()) {
                while (i < a.getColumnCount()) {
                    str2 = str2 + a.getString(i) + " ";
                    i++;
                }
            }
            a.close();
            AppMethodBeat.o(1413);
        }
        return str2;
    }

    public final String bOF() {
        return "type IN (3,39,13,43,62,44,268435505)";
    }

    public final String bOG() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    public final String Rr(String str) {
        AppMethodBeat.i(1414);
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        String str3 = apM(str).name;
        AppMethodBeat.o(1414);
        return str3;
    }

    private b apK(String str) {
        AppMethodBeat.i(1415);
        String str2 = "tableName == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        for (int i = 0; i < this.xZD.size(); i++) {
            if (str.equals(((b) this.xZD.get(i)).name)) {
                b bVar = (b) this.xZD.get(i);
                AppMethodBeat.o(1415);
                return bVar;
            }
        }
        Assert.assertTrue("no table match", false);
        AppMethodBeat.o(1415);
        return null;
    }

    private String apL(String str) {
        String aog;
        AppMethodBeat.i(1416);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        for (e aog2 : this.xZC) {
            aog = aog2.aog(str);
            if (!bo.isNullOrNil(aog)) {
                AppMethodBeat.o(1416);
                return aog;
            }
        }
        aog = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
        AppMethodBeat.o(1416);
        return aog;
    }

    private b apM(String str) {
        AppMethodBeat.i(1417);
        String str2 = "username == null";
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(str2, z);
        b apK = apK(apL(str));
        AppMethodBeat.o(1417);
        return apK;
    }

    public final boolean ji(long j) {
        AppMethodBeat.i(1418);
        for (int i = 0; i < this.xZD.size(); i++) {
            if (((b) this.xZD.get(i)).jk(j)) {
                AppMethodBeat.o(1418);
                return true;
            }
        }
        AppMethodBeat.o(1418);
        return false;
    }

    private String mT(long j) {
        AppMethodBeat.i(1419);
        if (j == 0 || j == -1) {
            AppMethodBeat.o(1419);
            return null;
        }
        bi.mS(j);
        for (int i = 0; i < this.xZD.size(); i++) {
            if (((b) this.xZD.get(i)).jk(j)) {
                String str = ((b) this.xZD.get(i)).name;
                AppMethodBeat.o(1419);
                return str;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", new Object[]{Long.valueOf(j)}), false);
        AppMethodBeat.o(1419);
        return null;
    }

    public final long Rs(String str) {
        AppMethodBeat.i(BuildConfig.VERSION_CODE);
        String str2 = "select createTime from message where" + apG(str) + "order by createTime LIMIT 1 OFFSET 0";
        ab.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 2);
        if (a == null) {
            ab.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(str)));
            AppMethodBeat.o(BuildConfig.VERSION_CODE);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(BuildConfig.VERSION_CODE);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(BuildConfig.VERSION_CODE);
            return -1;
        }
    }

    public final long Rt(String str) {
        AppMethodBeat.i(1421);
        String str2 = "select createTime from message where" + apG(str) + "order by createTime DESC LIMIT 1 ";
        ab.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 2);
        if (a == null) {
            ab.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(1421);
            return -1;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(1421);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(1421);
            return -1;
        }
    }

    public final long Ru(String str) {
        AppMethodBeat.i(1422);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1422);
            return 0;
        }
        String str2 = "select msgSeq from message where" + apG(str) + "order by msgSeq DESC LIMIT 1 ";
        ab.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 2);
        if (a == null) {
            ab.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(1422);
            return 0;
        } else if (a.moveToFirst()) {
            long j = a.getLong(0);
            a.close();
            AppMethodBeat.o(1422);
            return j;
        } else {
            a.close();
            AppMethodBeat.o(1422);
            return 0;
        }
    }

    public final bi ae(String str, long j) {
        AppMethodBeat.i(1423);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1423);
            return null;
        }
        String str2 = "select * from message where" + apG(str) + " and msgSeq < " + j + " order by msgSeq DESC LIMIT 1 ";
        ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 0);
        if (a == null) {
            ab.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(1423);
            return null;
        } else if (a.moveToFirst()) {
            bi biVar = new bi();
            biVar.d(a);
            a.close();
            AppMethodBeat.o(1423);
            return biVar;
        } else {
            a.close();
            AppMethodBeat.o(1423);
            return null;
        }
    }

    public final bi Rv(String str) {
        AppMethodBeat.i(1424);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1424);
            return null;
        }
        ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.FALSE);
        Long l = (Long) this.xZJ.get(str);
        bi biVar;
        if (l == null || l.longValue() <= 0) {
            ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            biVar = new bi();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor a = this.fni.a("SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ", null, 2);
            ab.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (a == null) {
                ab.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(str)));
                AppMethodBeat.o(1424);
                return biVar;
            }
            if (a.moveToFirst()) {
                biVar.d(a);
            }
            a.close();
            this.xZJ.k(str, Long.valueOf(biVar.field_msgId));
            AppMethodBeat.o(1424);
            return biVar;
        }
        ab.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        biVar = jf(l.longValue());
        if ((biVar.field_flag & 1) != 0) {
            AppMethodBeat.o(1424);
            return biVar;
        }
        this.xZJ.remove(str);
        AppMethodBeat.o(1424);
        return null;
    }

    public final int s(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.i(1425);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        ab.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j4), Long.valueOf(j3));
        String str2 = "SELECT COUNT(msgId) FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3;
        ab.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 2);
        if (a == null) {
            ab.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            AppMethodBeat.o(1425);
            return 0;
        } else if (a.moveToFirst()) {
            ab.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(a.getInt(0)));
            a.close();
            AppMethodBeat.o(1425);
            return a.getInt(0);
        } else {
            a.close();
            AppMethodBeat.o(1425);
            return 0;
        }
    }

    public final Cursor a(String str, long j, long j2, boolean z) {
        long j3;
        long j4;
        int i;
        AppMethodBeat.i(1426);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        StringBuilder append = new StringBuilder("SELECT * FROM ").append(Rr(str)).append(" WHERE").append(apG(str)).append("AND createTime >= ").append(j4).append(" AND createTime <= ").append(j3).append(" AND isSend=");
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        String stringBuilder = append.append(i).append(" LIMIT 1").toString();
        ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(stringBuilder)));
        Cursor a = this.fni.a(stringBuilder, null, 0);
        AppMethodBeat.o(1426);
        return a;
    }

    public final Cursor t(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.i(1427);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3 + " ORDER BY createTime ASC ";
        ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 0);
        AppMethodBeat.o(1427);
        return a;
    }

    public final Cursor d(String str, long j, long j2, int i) {
        long j3;
        long j4;
        AppMethodBeat.i(1428);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM (SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3 + " ORDER BY createTime DESC LIMIT " + i + " ) ORDER BY createTime ASC";
        ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 0);
        AppMethodBeat.o(1428);
        return a;
    }

    public final Cursor b(String str, long j, long j2, int i) {
        long j3;
        long j4;
        AppMethodBeat.i(1429);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        ab.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", str, Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + (j4 > 0 ? " AND createTime >= ".concat(String.valueOf(j4)) : "") + (j3 > 0 ? " AND createTime <= ".concat(String.valueOf(j3)) : "") + " ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        Cursor a = this.fni.a(r0, null, 0);
        AppMethodBeat.o(1429);
        return a;
    }

    public final int u(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.i(1430);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        ab.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", str, "SELECT COUNT(*) FROM ( SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + (j4 > 0 ? " AND createTime >= ".concat(String.valueOf(j4)) : "") + (j3 > 0 ? " AND createTime <= ".concat(String.valueOf(j3)) : "") + " ORDER BY createTime)");
        Cursor a = this.fni.a(r0, null, 2);
        int i = 0;
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.o(1430);
        }
        AppMethodBeat.o(1430);
        return i;
    }

    public final Cursor c(String str, long j, long j2, int i) {
        AppMethodBeat.i(1431);
        String str2;
        Cursor a;
        if (j2 == 0) {
            str2 = "SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i;
            ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
            a = this.fni.a(str2, null, 0);
            AppMethodBeat.o(1431);
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
        str2 = "SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j4 + " AND createTime < " + j3 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i;
        ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        a = this.fni.a(str2, null, 0);
        AppMethodBeat.o(1431);
        return a;
    }

    public final int v(String str, long j, long j2) {
        long j3;
        long j4;
        int i;
        AppMethodBeat.i(1432);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        Cursor a = this.fni.a("SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j4 + " AND createTime < " + j3, null, 2);
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
            i = 0;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.o(1432);
        }
        AppMethodBeat.o(1432);
        return i;
    }

    public final Cursor w(String str, long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.i(1433);
        if (j2 < j) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        String str2 = "SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime >= " + j4 + " AND createTime <= " + j3;
        ab.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor a = this.fni.a(str2, null, 0);
        AppMethodBeat.o(1433);
        return a;
    }

    public final Cursor G(String str, String str2, int i) {
        AppMethodBeat.i(1434);
        ab.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i), " SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i);
        Cursor a = this.fni.a(r0, null, 0);
        AppMethodBeat.o(1434);
        return a;
    }

    public final Cursor cB(String str, int i) {
        AppMethodBeat.i(1435);
        ab.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i), " SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + i);
        Cursor a = this.fni.a(r0, null, 0);
        AppMethodBeat.o(1435);
        return a;
    }

    public final int fc(String str, String str2) {
        int i;
        AppMethodBeat.i(1436);
        Cursor a = this.fni.a(" SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str) + "AND content LIKE '" + str2 + "%' ", null, 2);
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
            i = 0;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.o(1436);
        }
        ab.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", str, str2, Integer.valueOf(i), r2);
        AppMethodBeat.o(1436);
        return i;
    }

    public final int Rw(String str) {
        int i;
        AppMethodBeat.i(1437);
        Cursor a = this.fni.a(" SELECT COUNT(*) FROM " + Rr(str) + " WHERE" + apG(str) + "AND isSend=1", null, 2);
        try {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "", new Object[0]);
            a.close();
            i = 0;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.o(1437);
        }
        ab.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", str, Integer.valueOf(i), r2);
        AppMethodBeat.o(1437);
        return i;
    }

    public final long f(String str, long j, int i) {
        AppMethodBeat.i(1438);
        ab.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(i));
        if (i <= 0) {
            ab.w("MicroMsg.MsgInfoStorage", "error target inc count");
            AppMethodBeat.o(1438);
            return j;
        }
        ab.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT createTime FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime < " + j + " ORDER BY createTime DESC  LIMIT " + i);
        Cursor a = this.fni.a(r0, null, 0);
        if (a == null) {
            ab.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            AppMethodBeat.o(1438);
            return j;
        } else if (a.moveToLast()) {
            ab.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            AppMethodBeat.o(1438);
            return a.getLong(0);
        } else {
            a.close();
            ab.w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.o(1438);
            return j;
        }
    }

    public final bi af(String str, long j) {
        AppMethodBeat.i(1439);
        ab.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(1));
        bi biVar = new bi();
        ab.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", "SELECT * FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime < " + j + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1");
        Cursor a = this.fni.a(r1, null, 0);
        if (a == null) {
            ab.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            AppMethodBeat.o(1439);
        } else if (a.moveToLast()) {
            biVar.d(a);
            a.close();
            AppMethodBeat.o(1439);
        } else {
            a.close();
            ab.w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.o(1439);
        }
        return biVar;
    }

    public final long g(String str, long j, int i) {
        AppMethodBeat.i(1440);
        ab.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j), Integer.valueOf(i));
        if (i <= 0) {
            ab.w("MicroMsg.MsgInfoStorage", "error target inc count");
            AppMethodBeat.o(1440);
            return j;
        }
        ab.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", "SELECT createTime FROM " + Rr(str) + " WHERE" + apG(str) + "AND createTime > " + j + " ORDER BY createTime ASC  LIMIT " + i);
        Cursor a = this.fni.a(r0, null, 0);
        if (a == null) {
            ab.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            AppMethodBeat.o(1440);
            return j;
        } else if (a.moveToLast()) {
            ab.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(a.getLong(0)));
            a.close();
            AppMethodBeat.o(1440);
            return a.getLong(0);
        } else {
            a.close();
            ab.w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.o(1440);
            return j;
        }
    }

    public final bi[] cC(String str, int i) {
        AppMethodBeat.i(1441);
        if (str == null || str.length() == 0 || i <= 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i);
            AppMethodBeat.o(1441);
            return null;
        }
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + "order by createTime DESC limit " + i, null, 2);
        if (a.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                bi biVar = new bi();
                biVar.d(a);
                arrayList.add(biVar);
            } while (a.moveToNext());
            a.close();
            ab.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            bi[] biVarArr = (bi[]) arrayList.toArray(new bi[arrayList.size()]);
            AppMethodBeat.o(1441);
            return biVarArr;
        }
        ab.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        a.close();
        AppMethodBeat.o(1441);
        return null;
    }

    public final LinkedList<bi> fd(String str, String str2) {
        LinkedList<bi> linkedList = null;
        AppMethodBeat.i(1442);
        Cursor a = this.fni.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (a == null || !a.moveToFirst()) {
            ab.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
            AppMethodBeat.o(1442);
        } else {
            linkedList = new LinkedList();
            do {
                bi biVar = new bi();
                biVar.d(a);
                linkedList.add(biVar);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.o(1442);
        }
        return linkedList;
    }

    public final void jj(long j) {
        AppMethodBeat.i(1443);
        this.xZK.b(0, j, 0, false);
        AppMethodBeat.o(1443);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<bi> Rx(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.i(1444);
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.fni.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "talker=? AND createTime>=? AND type IN (436207665,419430449)", new String[]{bo.vA(str), String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    bi biVar = new bi();
                    biVar.d(a);
                    arrayList.add(biVar);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(1444);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        AppMethodBeat.o(1444);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(1444);
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
            AppMethodBeat.o(1444);
            throw th;
        }
    }

    public final Cursor Rz(String str) {
        AppMethodBeat.i(1445);
        try {
            Cursor a = this.fni.a(Rr(str), null, apG(str) + " AND createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            AppMethodBeat.o(1445);
            return a;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
            AppMethodBeat.o(1445);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<bi> bOH() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(1446);
        Cursor a;
        try {
            ArrayList arrayList = new ArrayList();
            a = this.fni.a(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, null, "createTime>=? AND type IN (436207665,419430449)", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)}, null, null, "createTime ASC", 2);
            while (a.moveToNext()) {
                try {
                    bi biVar = new bi();
                    biVar.d(a);
                    arrayList.add(biVar);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.MsgInfoStorage", e, "getLastDayC2CMsgByTalker error: %s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(1446);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        AppMethodBeat.o(1446);
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            AppMethodBeat.o(1446);
            return arrayList;
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
            }
            AppMethodBeat.o(1446);
            throw th;
        }
    }

    public final long Ry(String str) {
        AppMethodBeat.i(1447);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(1447);
            return 0;
        }
        b apK = apK(str);
        if (apK == null) {
            AppMethodBeat.o(1447);
            return 0;
        }
        long j = apK.fDH;
        AppMethodBeat.o(1447);
        return j;
    }

    public final Cursor h(String str, long j, int i) {
        Cursor cursor = null;
        AppMethodBeat.i(1448);
        try {
            cursor = this.fni.a("select * from " + str + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + j + "  order by msgId ASC  limit " + i, null, 0);
        } catch (Exception e) {
        }
        AppMethodBeat.o(1448);
        return cursor;
    }

    public final Cursor cD(String str, int i) {
        AppMethodBeat.i(1449);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(1449);
            return null;
        }
        Cursor a = this.fni.a("select * from " + Rr(str) + " where" + apG(str) + " AND type IN (436207665,419430449)  order by createTime DESC limit " + i + " OFFSET 0", null, 0);
        AppMethodBeat.o(1449);
        return a;
    }

    public final void bOz() {
        AppMethodBeat.i(1333);
        g.RQ();
        g.RP().Ry().set(348167, Integer.valueOf(1));
        AppMethodBeat.o(1333);
    }
}
