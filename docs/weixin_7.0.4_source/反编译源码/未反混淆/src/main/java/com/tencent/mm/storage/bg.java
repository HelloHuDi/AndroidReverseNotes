package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class bg extends j<bf> implements f {
    public static final String[] fnj = new String[]{j.a(bf.ccO, "LBSVerifyMessage")};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(1317);
        boolean a = a((bf) cVar);
        AppMethodBeat.o(1317);
        return a;
    }

    static {
        AppMethodBeat.i(1318);
        AppMethodBeat.o(1318);
    }

    public bg(e eVar) {
        super(eVar, bf.ccO, "LBSVerifyMessage", cp.diI);
        this.bSd = eVar;
    }

    public final int baS() {
        AppMethodBeat.i(1304);
        Cursor a = this.bSd.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            AppMethodBeat.o(1304);
            return i;
        }
        a.close();
        AppMethodBeat.o(1304);
        return 0;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.i(1305);
        Cursor a = this.bSd.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.o(1305);
        return i;
    }

    public final bf bOx() {
        AppMethodBeat.i(1306);
        Cursor a = this.bSd.a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.o(1306);
            return null;
        } else if (a.moveToFirst()) {
            bf bfVar = new bf();
            bfVar.d(a);
            a.close();
            AppMethodBeat.o(1306);
            return bfVar;
        } else {
            a.close();
            AppMethodBeat.o(1306);
            return null;
        }
    }

    public final Cursor xm(int i) {
        AppMethodBeat.i(1307);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i, null);
        AppMethodBeat.o(1307);
        return rawQuery;
    }

    public final Cursor Mq(int i) {
        AppMethodBeat.i(1308);
        Cursor rawQuery = this.bSd.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null);
        AppMethodBeat.o(1308);
        return rawQuery;
    }

    public final void QT(String str) {
        AppMethodBeat.i(1309);
        int delete = this.bSd.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        ab.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(delete)));
        AppMethodBeat.o(1309);
    }

    public final void QU(String str) {
        AppMethodBeat.i(1310);
        int delete = this.bSd.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        ab.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(delete)));
        AppMethodBeat.o(1310);
    }

    public final void axQ() {
        AppMethodBeat.i(1311);
        this.bSd.delete(getTableName(), null, null);
        AppMethodBeat.o(1311);
    }

    public final boolean a(bf bfVar) {
        AppMethodBeat.i(1312);
        if (bfVar == null) {
            ab.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            AppMethodBeat.o(1312);
            return false;
        } else if (super.b((c) bfVar)) {
            anF(bfVar.xDa);
            AppMethodBeat.o(1312);
            return true;
        } else {
            AppMethodBeat.o(1312);
            return false;
        }
    }

    public final bf[] apz(String str) {
        AppMethodBeat.i(1313);
        ab.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor a = this.bSd.a("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + bo.vA(str) + "' or sayhiencryptuser = '" + bo.vA(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            bf bfVar = new bf();
            bfVar.d(a);
            arrayList.add(bfVar);
        }
        a.close();
        bf[] bfVarArr = (bf[]) arrayList.toArray(new bf[arrayList.size()]);
        AppMethodBeat.o(1313);
        return bfVarArr;
    }

    public final bf apA(String str) {
        bf bfVar = null;
        AppMethodBeat.i(1314);
        ab.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor a = this.bSd.a("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + bo.vA(str) + "' or sayhiencryptuser = '" + bo.vA(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            bfVar = new bf();
            bfVar.d(a);
        } else {
            ab.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        a.close();
        AppMethodBeat.o(1314);
        return bfVar;
    }

    public final bf[] er(String str, int i) {
        AppMethodBeat.i(1315);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            AppMethodBeat.o(1315);
            return null;
        }
        Cursor a = this.bSd.a("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + bo.vA(str) + "' or sayhiencryptuser = '" + bo.vA(str) + "') order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            bf bfVar = new bf();
            bfVar.d(a);
            arrayList.add(bfVar);
        }
        a.close();
        bf[] bfVarArr = (bf[]) arrayList.toArray(new bf[arrayList.size()]);
        AppMethodBeat.o(1315);
        return bfVarArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long QV(String str) {
        long j;
        long anT;
        AppMethodBeat.i(1316);
        if (str != null) {
            bf bfVar;
            bg bgVar = (bg) ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOo();
            Cursor a = bgVar.bSd.a("SELECT * FROM " + bgVar.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
            if (a == null) {
                bfVar = null;
            } else if (a.moveToFirst()) {
                bfVar = new bf();
                bfVar.d(a);
                a.close();
            } else {
                a.close();
                bfVar = null;
            }
            if (bfVar != null) {
                j = bfVar.field_createtime + 1;
                anT = bo.anT();
                if (j <= anT) {
                    AppMethodBeat.o(1316);
                    return j;
                }
                AppMethodBeat.o(1316);
                return anT;
            }
        }
        j = 0;
        anT = bo.anT();
        if (j <= anT) {
        }
    }
}
