package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p711c.C6571cp;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6975f;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.storage.bg */
public final class C35998bg extends C7563j<C7570bf> implements C6975f {
    public static final String[] fnj = new String[]{C7563j.m13217a(C7570bf.ccO, "LBSVerifyMessage")};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(1317);
        boolean a = mo56738a((C7570bf) c4925c);
        AppMethodBeat.m2505o(1317);
        return a;
    }

    static {
        AppMethodBeat.m2504i(1318);
        AppMethodBeat.m2505o(1318);
    }

    public C35998bg(C4927e c4927e) {
        super(c4927e, C7570bf.ccO, "LBSVerifyMessage", C6571cp.diI);
        this.bSd = c4927e;
    }

    public final int baS() {
        AppMethodBeat.m2504i(1304);
        Cursor a = this.bSd.mo10104a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            AppMethodBeat.m2505o(1304);
            return i;
        }
        a.close();
        AppMethodBeat.m2505o(1304);
        return 0;
    }

    public final int getCount() {
        int i = 0;
        AppMethodBeat.m2504i(1305);
        Cursor a = this.bSd.mo10104a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        AppMethodBeat.m2505o(1305);
        return i;
    }

    public final C7570bf bOx() {
        AppMethodBeat.m2504i(1306);
        Cursor a = this.bSd.mo10104a("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(1306);
            return null;
        } else if (a.moveToFirst()) {
            C7570bf c7570bf = new C7570bf();
            c7570bf.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(1306);
            return c7570bf;
        } else {
            a.close();
            AppMethodBeat.m2505o(1306);
            return null;
        }
    }

    /* renamed from: xm */
    public final Cursor mo56742xm(int i) {
        AppMethodBeat.m2504i(1307);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i, null);
        AppMethodBeat.m2505o(1307);
        return rawQuery;
    }

    /* renamed from: Mq */
    public final Cursor mo56737Mq(int i) {
        AppMethodBeat.m2504i(1308);
        Cursor rawQuery = this.bSd.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null);
        AppMethodBeat.m2505o(1308);
        return rawQuery;
    }

    /* renamed from: QT */
    public final void mo15229QT(String str) {
        AppMethodBeat.m2504i(1309);
        int delete = this.bSd.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        C4990ab.m7416i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(delete)));
        AppMethodBeat.m2505o(1309);
    }

    /* renamed from: QU */
    public final void mo15230QU(String str) {
        AppMethodBeat.m2504i(1310);
        int delete = this.bSd.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        C4990ab.m7416i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = ".concat(String.valueOf(delete)));
        AppMethodBeat.m2505o(1310);
    }

    public final void axQ() {
        AppMethodBeat.m2504i(1311);
        this.bSd.delete(getTableName(), null, null);
        AppMethodBeat.m2505o(1311);
    }

    /* renamed from: a */
    public final boolean mo56738a(C7570bf c7570bf) {
        AppMethodBeat.m2504i(1312);
        if (c7570bf == null) {
            C4990ab.m7412e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            AppMethodBeat.m2505o(1312);
            return false;
        } else if (super.mo10101b((C4925c) c7570bf)) {
            anF(c7570bf.xDa);
            AppMethodBeat.m2505o(1312);
            return true;
        } else {
            AppMethodBeat.m2505o(1312);
            return false;
        }
    }

    public final C7570bf[] apz(String str) {
        AppMethodBeat.m2504i(1313);
        C4990ab.m7410d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor a = this.bSd.mo10104a("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + C5046bo.m7586vA(str) + "' or sayhiencryptuser = '" + C5046bo.m7586vA(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C7570bf c7570bf = new C7570bf();
            c7570bf.mo8995d(a);
            arrayList.add(c7570bf);
        }
        a.close();
        C7570bf[] c7570bfArr = (C7570bf[]) arrayList.toArray(new C7570bf[arrayList.size()]);
        AppMethodBeat.m2505o(1313);
        return c7570bfArr;
    }

    public final C7570bf apA(String str) {
        C7570bf c7570bf = null;
        AppMethodBeat.m2504i(1314);
        C4990ab.m7410d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor a = this.bSd.mo10104a("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + C5046bo.m7586vA(str) + "' or sayhiencryptuser = '" + C5046bo.m7586vA(str) + "') and flag=1 order by createtime DESC limit 1", null, 2);
        if (a.moveToFirst()) {
            c7570bf = new C7570bf();
            c7570bf.mo8995d(a);
        } else {
            C4990ab.m7416i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        a.close();
        AppMethodBeat.m2505o(1314);
        return c7570bf;
    }

    /* renamed from: er */
    public final C7570bf[] mo56741er(String str, int i) {
        AppMethodBeat.m2504i(1315);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
            AppMethodBeat.m2505o(1315);
            return null;
        }
        Cursor a = this.bSd.mo10104a("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + C5046bo.m7586vA(str) + "' or sayhiencryptuser = '" + C5046bo.m7586vA(str) + "') order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C7570bf c7570bf = new C7570bf();
            c7570bf.mo8995d(a);
            arrayList.add(c7570bf);
        }
        a.close();
        C7570bf[] c7570bfArr = (C7570bf[]) arrayList.toArray(new C7570bf[arrayList.size()]);
        AppMethodBeat.m2505o(1315);
        return c7570bfArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: QV */
    public final long mo15231QV(String str) {
        long j;
        long anT;
        AppMethodBeat.m2504i(1316);
        if (str != null) {
            C7570bf c7570bf;
            C35998bg c35998bg = (C35998bg) ((C6982j) C1720g.m3528K(C6982j.class)).bOo();
            Cursor a = c35998bg.bSd.mo10104a("SELECT * FROM " + c35998bg.getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
            if (a == null) {
                c7570bf = null;
            } else if (a.moveToFirst()) {
                c7570bf = new C7570bf();
                c7570bf.mo8995d(a);
                a.close();
            } else {
                a.close();
                c7570bf = null;
            }
            if (c7570bf != null) {
                j = c7570bf.field_createtime + 1;
                anT = C5046bo.anT();
                if (j <= anT) {
                    AppMethodBeat.m2505o(1316);
                    return j;
                }
                AppMethodBeat.m2505o(1316);
                return anT;
            }
        }
        j = 0;
        anT = C5046bo.anT();
        if (j <= anT) {
        }
    }
}
