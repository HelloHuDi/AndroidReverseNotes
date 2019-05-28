package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class o extends e {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public o(h hVar) {
        super(hVar);
        AppMethodBeat.i(11826);
        a(bOy(), "bizchatmessage");
        a(new b(16, "bizchatmessage", b.a(2500001, 3000000, 99000001, 102000000)));
        AppMethodBeat.o(11826);
    }

    public final String aog(String str) {
        AppMethodBeat.i(11827);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (f.kq(str)) {
            String str2 = "bizchatmessage";
            AppMethodBeat.o(11827);
            return str2;
        }
        AppMethodBeat.o(11827);
        return null;
    }

    private static String aL(String str, long j) {
        AppMethodBeat.i(11828);
        String str2 = " bizChatId= " + j + " AND talker= '" + str + "'";
        AppMethodBeat.o(11828);
        return str2;
    }

    public final bi aM(String str, long j) {
        AppMethodBeat.i(11829);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11829);
            return null;
        }
        bi biVar = new bi();
        Cursor a = bOy().a("select * from " + Rr(str) + " where" + aL(str, j) + "order by createTime DESC limit 1", null, 0);
        if (a.getCount() != 0) {
            a.moveToFirst();
            biVar.d(a);
        }
        a.close();
        AppMethodBeat.o(11829);
        return biVar;
    }

    public final List<bi> o(String str, long j, int i) {
        AppMethodBeat.i(11830);
        ArrayList arrayList = new ArrayList();
        Cursor a = bOy().a("SELECT * FROM " + Rr(str) + " WHERE" + aL(str, j) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                bi biVar = new bi();
                biVar.d(a);
                a.moveToNext();
                if (biVar.isText()) {
                    arrayList.add(biVar);
                }
            }
        }
        a.close();
        AppMethodBeat.o(11830);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(bi biVar, bf.b bVar) {
        AppMethodBeat.i(11831);
        if (biVar == null) {
            ab.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            AppMethodBeat.o(11831);
            return false;
        }
        biVar.eK(-1);
        if (bVar != null) {
            if (f.kq(biVar.field_talker)) {
                if (bo.isNullOrNil(bVar.fmz)) {
                    ab.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", biVar.dqJ);
                    AppMethodBeat.o(11831);
                    return false;
                }
                c cVar = new c();
                cVar.field_bizChatServId = bVar.fmz;
                cVar.field_brandUserName = biVar.field_talker;
                if (!bo.isNullOrNil(bVar.fmA)) {
                    cVar.field_chatVersion = bo.getInt(bVar.fmA, -1);
                }
                if (!bo.isNullOrNil(bVar.fmy)) {
                    cVar.field_chatType = bo.getInt(bVar.fmy, -1);
                }
                ab.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", bVar.fmz, bVar.userId);
                cVar = e.e(cVar);
                if (cVar != null) {
                    biVar.eK(cVar.field_bizChatLocalId);
                    biVar.field_bizChatUserId = bo.nullAsNil(bVar.userId);
                    biVar.dJo = true;
                    if (bVar.fmC.equals("1")) {
                        biVar.hO(1);
                    }
                    if (!(biVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(z.aeV().cI(biVar.field_talker))) {
                            biVar.hO(1);
                        }
                    }
                    if (!bo.isNullOrNil(bVar.userId)) {
                        j jVar = new j();
                        jVar.field_userId = bVar.userId;
                        jVar.field_userName = bVar.fmB;
                        jVar.field_brandUserName = biVar.field_talker;
                        z.aeV().c(jVar);
                    }
                } else {
                    ab.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    AppMethodBeat.o(11831);
                    return false;
                }
            } else if (!bo.isNullOrNil(bVar.fmz)) {
                ab.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                AppMethodBeat.o(11831);
                return false;
            }
        }
        AppMethodBeat.o(11831);
        return true;
    }

    public final List<bi> b(String str, long j, long j2, boolean z) {
        AppMethodBeat.i(11832);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
            AppMethodBeat.o(11832);
            return null;
        }
        long Z = this.xHO.Z(str, j2);
        if (Z == 0) {
            ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            AppMethodBeat.o(11832);
            return null;
        }
        String str2;
        ArrayList arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + Rr(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime > " + Z + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + Rr(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime < " + Z + "  order by createTime DESC limit 10";
        }
        Cursor a = bOy().a(str2, null, 0);
        if (a.moveToFirst()) {
            while (!a.isAfterLast()) {
                bi biVar = new bi();
                biVar.d(a);
                a.moveToNext();
                if (z) {
                    arrayList.add(biVar);
                } else {
                    arrayList.add(0, biVar);
                }
            }
        }
        a.close();
        ab.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(11832);
        return arrayList;
    }

    public final Cursor aN(String str, long j) {
        AppMethodBeat.i(11833);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(11833);
            return null;
        }
        Cursor a = bOy().a("select * from " + Rr(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aL(str, j) + "AND " + this.xHO.bOG() + "  order by createTime", null, 0);
        ab.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), r1);
        AppMethodBeat.o(11833);
        return a;
    }

    public final Cursor b(String str, long j, int i, int i2) {
        AppMethodBeat.i(11834);
        System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(11834);
            return null;
        }
        Cursor a = bOy().a("select * from ( select * from " + Rr(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aL(str, j) + "AND " + this.xHO.bOF() + " order by createTime DESC limit " + i2 + " OFFSET " + i + ") order by createTime ASC ", null, 0);
        AppMethodBeat.o(11834);
        return a;
    }

    public final Cursor c(String str, long j, long j2, long j3) {
        AppMethodBeat.i(11835);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(11835);
            return null;
        }
        Cursor a = bOy().a("select * from " + Rr(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 0);
        AppMethodBeat.o(11835);
        return a;
    }

    public final int aO(String str, long j) {
        AppMethodBeat.i(11836);
        ab.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", str, an.doR());
        hZ(Rr(str), aL(str, j));
        int delete = bOy().delete(Rr(str), aL(str, j), null);
        if (delete != 0) {
            this.xHO.anF("delete_talker ".concat(String.valueOf(str)));
            h.c cVar = new h.c(str, "delete", null, delete, (byte) 0);
            cVar.oqO = -1;
            a(cVar);
        }
        AppMethodBeat.o(11836);
        return delete;
    }

    public final int Rh(String str) {
        AppMethodBeat.i(11837);
        ab.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", str, an.doR());
        String str2 = "talker= '" + str + "'";
        hZ(Rr(str), str2);
        int delete = bOy().delete(Rr(str), str2, null);
        if (delete != 0) {
            this.xHO.anF("delete_talker ".concat(String.valueOf(str)));
            h.c cVar = new h.c(str, "delete", null, delete, (byte) 0);
            cVar.oqO = -1;
            a(cVar);
        }
        AppMethodBeat.o(11837);
        return delete;
    }

    public final Cursor aP(String str, long j) {
        AppMethodBeat.i(11838);
        Cursor query = bOy().query(Rr(str), null, aL(str, j), null, null, null, "createTime ASC ");
        AppMethodBeat.o(11838);
        return query;
    }

    public final Cursor p(String str, long j, int i) {
        AppMethodBeat.i(11839);
        ab.d("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", str, Long.valueOf(j), Integer.valueOf(i), "SELECT * FROM ( SELECT * FROM " + Rr(str) + " WHERE" + aL(str, j) + "ORDER BY createTime DESC LIMIT " + i + ") ORDER BY createTime ASC");
        Cursor a = bOy().a(r0, null, 0);
        AppMethodBeat.o(11839);
        return a;
    }

    public final int aQ(String str, long j) {
        AppMethodBeat.i(11840);
        if (str == null) {
            ab.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", str, Long.valueOf(j));
            AppMethodBeat.o(11840);
            return -1;
        }
        a fv = z.aeU().fv(j);
        int i;
        if (fv.field_msgCount != 0) {
            i = fv.field_msgCount;
            AppMethodBeat.o(11840);
            return i;
        }
        ab.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", str);
        i = aR(str, j);
        AppMethodBeat.o(11840);
        return i;
    }

    public final int aR(String str, long j) {
        int i = 0;
        AppMethodBeat.i(11841);
        ab.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", "SELECT COUNT(*) FROM " + Rr(str) + " WHERE " + aL(str, j));
        Cursor a = bOy().a(r1, null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(11841);
        return i;
    }

    public final int aS(String str, long j) {
        int i = 0;
        AppMethodBeat.i(11842);
        Cursor a = bOy().a("SELECT COUNT(*) FROM " + this.xHO.Rr(str) + " WHERE " + aL(str, j) + "AND " + this.xHO.bOF(), null, 0);
        if (a.moveToLast()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(11842);
        return i;
    }

    public final int z(String str, long j, long j2) {
        int i = 0;
        AppMethodBeat.i(11843);
        bi jf = this.xHO.jf(j2);
        if (jf.field_msgId == 0) {
            ab.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.o(11843);
        } else {
            Cursor a = bOy().a("SELECT COUNT(*) FROM " + Rr(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + aL(str, j) + "AND " + this.xHO.bOF() + " AND createTime < " + jf.field_createTime, null, 0);
            if (a.moveToLast()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(11843);
        }
        return i;
    }
}
