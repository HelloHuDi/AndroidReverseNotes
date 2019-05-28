package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3459b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3460c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.o */
public final class C46626o extends C5142e {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public C46626o(C6977h c6977h) {
        super(c6977h);
        AppMethodBeat.m2504i(11826);
        mo10565a(bOy(), "bizchatmessage");
        mo10566a(new C3459b(16, "bizchatmessage", C3459b.m5743a(2500001, 3000000, 99000001, 102000000)));
        AppMethodBeat.m2505o(11826);
    }

    public final String aog(String str) {
        AppMethodBeat.m2504i(11827);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (C17903f.m28103kq(str)) {
            String str2 = "bizchatmessage";
            AppMethodBeat.m2505o(11827);
            return str2;
        }
        AppMethodBeat.m2505o(11827);
        return null;
    }

    /* renamed from: aL */
    private static String m88202aL(String str, long j) {
        AppMethodBeat.m2504i(11828);
        String str2 = " bizChatId= " + j + " AND talker= '" + str + "'";
        AppMethodBeat.m2505o(11828);
        return str2;
    }

    /* renamed from: aM */
    public final C7620bi mo74792aM(String str, long j) {
        AppMethodBeat.m2504i(11829);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11829);
            return null;
        }
        C7620bi c7620bi = new C7620bi();
        Cursor a = bOy().mo10104a("select * from " + mo10564Rr(str) + " where" + C46626o.m88202aL(str, j) + "order by createTime DESC limit 1", null, 0);
        if (a.getCount() != 0) {
            a.moveToFirst();
            c7620bi.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(11829);
        return c7620bi;
    }

    /* renamed from: o */
    public final List<C7620bi> mo74802o(String str, long j, int i) {
        AppMethodBeat.m2504i(11830);
        ArrayList arrayList = new ArrayList();
        Cursor a = bOy().mo10104a("SELECT * FROM " + mo10564Rr(str) + " WHERE" + C46626o.m88202aL(str, j) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(a);
                a.moveToNext();
                if (c7620bi.isText()) {
                    arrayList.add(c7620bi);
                }
            }
        }
        a.close();
        AppMethodBeat.m2505o(11830);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo10568a(C7620bi c7620bi, C1828b c1828b) {
        AppMethodBeat.m2504i(11831);
        if (c7620bi == null) {
            C4990ab.m7420w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            AppMethodBeat.m2505o(11831);
            return false;
        }
        c7620bi.mo14776eK(-1);
        if (c1828b != null) {
            if (C17903f.m28103kq(c7620bi.field_talker)) {
                if (C5046bo.isNullOrNil(c1828b.fmz)) {
                    C4990ab.m7421w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", c7620bi.dqJ);
                    AppMethodBeat.m2505o(11831);
                    return false;
                }
                C45142c c45142c = new C45142c();
                c45142c.field_bizChatServId = c1828b.fmz;
                c45142c.field_brandUserName = c7620bi.field_talker;
                if (!C5046bo.isNullOrNil(c1828b.fmA)) {
                    c45142c.field_chatVersion = C5046bo.getInt(c1828b.fmA, -1);
                }
                if (!C5046bo.isNullOrNil(c1828b.fmy)) {
                    c45142c.field_chatType = C5046bo.getInt(c1828b.fmy, -1);
                }
                C4990ab.m7411d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", c1828b.fmz, c1828b.userId);
                c45142c = C25754e.m40896e(c45142c);
                if (c45142c != null) {
                    c7620bi.mo14776eK(c45142c.field_bizChatLocalId);
                    c7620bi.field_bizChatUserId = C5046bo.nullAsNil(c1828b.userId);
                    c7620bi.dJo = true;
                    if (c1828b.fmC.equals("1")) {
                        c7620bi.mo14781hO(1);
                    }
                    if (!(c7620bi.field_isSend == 1 || c1828b.userId == null)) {
                        if (c1828b.userId.equals(C41747z.aeV().mo60357cI(c7620bi.field_talker))) {
                            c7620bi.mo14781hO(1);
                        }
                    }
                    if (!C5046bo.isNullOrNil(c1828b.userId)) {
                        C45143j c45143j = new C45143j();
                        c45143j.field_userId = c1828b.userId;
                        c45143j.field_userName = c1828b.fmB;
                        c45143j.field_brandUserName = c7620bi.field_talker;
                        C41747z.aeV().mo60355c(c45143j);
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    AppMethodBeat.m2505o(11831);
                    return false;
                }
            } else if (!C5046bo.isNullOrNil(c1828b.fmz)) {
                C4990ab.m7416i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                AppMethodBeat.m2505o(11831);
                return false;
            }
        }
        AppMethodBeat.m2505o(11831);
        return true;
    }

    /* renamed from: b */
    public final List<C7620bi> mo74800b(String str, long j, long j2, boolean z) {
        AppMethodBeat.m2504i(11832);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
            AppMethodBeat.m2505o(11832);
            return null;
        }
        long Z = this.xHO.mo15282Z(str, j2);
        if (Z == 0) {
            C4990ab.m7412e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            AppMethodBeat.m2505o(11832);
            return null;
        }
        String str2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + mo10564Rr(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime > " + Z + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + mo10564Rr(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime < " + Z + "  order by createTime DESC limit 10";
        }
        Cursor a = bOy().mo10104a(str2, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                C7620bi c7620bi = new C7620bi();
                c7620bi.mo8995d(a);
                a.moveToNext();
                if (z) {
                    arrayList.add(c7620bi);
                } else {
                    arrayList.add(0, c7620bi);
                }
            }
        }
        a.close();
        C4990ab.m7417i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(11832);
        return arrayList;
    }

    /* renamed from: aN */
    public final Cursor mo74793aN(String str, long j) {
        AppMethodBeat.m2504i(11833);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(11833);
            return null;
        }
        Cursor a = bOy().mo10104a("select * from " + mo10564Rr(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOG() + "  order by createTime", null, 0);
        C4990ab.m7411d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r1);
        AppMethodBeat.m2505o(11833);
        return a;
    }

    /* renamed from: b */
    public final Cursor mo74799b(String str, long j, int i, int i2) {
        AppMethodBeat.m2504i(11834);
        System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(11834);
            return null;
        }
        Cursor a = bOy().mo10104a("select * from ( select * from " + mo10564Rr(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOF() + " order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 0);
        AppMethodBeat.m2505o(11834);
        return a;
    }

    /* renamed from: c */
    public final Cursor mo74801c(String str, long j, long j2, long j3) {
        AppMethodBeat.m2504i(11835);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.m2505o(11835);
            return null;
        }
        Cursor a = bOy().mo10104a("select * from " + mo10564Rr(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 0);
        AppMethodBeat.m2505o(11835);
        return a;
    }

    /* renamed from: aO */
    public final int mo74794aO(String str, long j) {
        AppMethodBeat.m2504i(11836);
        C4990ab.m7421w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", str, C5007an.doR());
        mo10571hZ(mo10564Rr(str), C46626o.m88202aL(str, j));
        int delete = bOy().delete(mo10564Rr(str), C46626o.m88202aL(str, j), null);
        if (delete != 0) {
            this.xHO.anF("delete_talker ".concat(String.valueOf(str)));
            C3460c c3460c = new C3460c(str, "delete", null, delete, (byte) 0);
            c3460c.oqO = -1;
            mo10567a(c3460c);
        }
        AppMethodBeat.m2505o(11836);
        return delete;
    }

    /* renamed from: Rh */
    public final int mo74791Rh(String str) {
        AppMethodBeat.m2504i(11837);
        C4990ab.m7421w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", str, C5007an.doR());
        String str2 = "talker= '" + str + "'";
        mo10571hZ(mo10564Rr(str), str2);
        int delete = bOy().delete(mo10564Rr(str), str2, null);
        if (delete != 0) {
            this.xHO.anF("delete_talker ".concat(String.valueOf(str)));
            C3460c c3460c = new C3460c(str, "delete", null, delete, (byte) 0);
            c3460c.oqO = -1;
            mo10567a(c3460c);
        }
        AppMethodBeat.m2505o(11837);
        return delete;
    }

    /* renamed from: aP */
    public final Cursor mo74795aP(String str, long j) {
        AppMethodBeat.m2504i(11838);
        Cursor query = bOy().query(mo10564Rr(str), null, C46626o.m88202aL(str, j), null, null, null, "createTime ASC ");
        AppMethodBeat.m2505o(11838);
        return query;
    }

    /* renamed from: p */
    public final Cursor mo74803p(String str, long j, int i) {
        AppMethodBeat.m2504i(11839);
        C4990ab.m7411d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + mo10564Rr(str) + " WHERE" + C46626o.m88202aL(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        Cursor a = bOy().mo10104a(r0, null, 0);
        AppMethodBeat.m2505o(11839);
        return a;
    }

    /* renamed from: aQ */
    public final int mo74796aQ(String str, long j) {
        AppMethodBeat.m2504i(11840);
        if (str == null) {
            C4990ab.m7421w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", str, Long.valueOf(j));
            AppMethodBeat.m2505o(11840);
            return -1;
        }
        C32232a fv = C41747z.aeU().mo60340fv(j);
        int i;
        if (fv.field_msgCount != 0) {
            i = fv.field_msgCount;
            AppMethodBeat.m2505o(11840);
            return i;
        }
        C4990ab.m7417i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", str);
        i = mo74797aR(str, j);
        AppMethodBeat.m2505o(11840);
        return i;
    }

    /* renamed from: aR */
    public final int mo74797aR(String str, long j) {
        int i = 0;
        AppMethodBeat.m2504i(11841);
        C4990ab.m7419v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", "SELECT COUNT(*) FROM " + mo10564Rr(str) + " WHERE " + C46626o.m88202aL(str, j));
        Cursor a = bOy().mo10104a(r1, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(11841);
        return i;
    }

    /* renamed from: aS */
    public final int mo74798aS(String str, long j) {
        int i = 0;
        AppMethodBeat.m2504i(11842);
        Cursor a = bOy().mo10104a("SELECT COUNT(*) FROM " + this.xHO.mo15264Rr(str) + " WHERE " + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOF(), null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(11842);
        return i;
    }

    /* renamed from: z */
    public final int mo74804z(String str, long j, long j2) {
        int i = 0;
        AppMethodBeat.m2504i(11843);
        C7620bi jf = this.xHO.mo15340jf(j2);
        if (jf.field_msgId == 0) {
            C4990ab.m7412e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.m2505o(11843);
        } else {
            Cursor a = bOy().mo10104a("SELECT COUNT(*) FROM " + mo10564Rr(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + C46626o.m88202aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime < " + jf.field_createTime, null, 0);
            if (a.moveToLast()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(11843);
        }
        return i;
    }
}
