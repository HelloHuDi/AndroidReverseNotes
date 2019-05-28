package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class bu extends j<bt> implements l {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] fnj = new String[]{j.a(bt.ccO, "shakeverifymessage")};
    public e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(1471);
        boolean a = a((bt) cVar);
        AppMethodBeat.o(1471);
        return a;
    }

    static {
        AppMethodBeat.i(1472);
        AppMethodBeat.o(1472);
    }

    public bu(e eVar) {
        super(eVar, bt.ccO, "shakeverifymessage", diI);
        this.bSd = eVar;
    }

    public final int baS() {
        AppMethodBeat.i(1461);
        Cursor a = this.bSd.a("select count(*) from " + getTableName() + " where status != 4", null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                AppMethodBeat.o(1461);
                return i;
            }
            AppMethodBeat.o(1461);
            return 0;
        }
        a.close();
        AppMethodBeat.o(1461);
        return 0;
    }

    public final int getCount() {
        AppMethodBeat.i(1462);
        Cursor a = this.bSd.a("select count(*) from " + getTableName(), null, 2);
        if (a.moveToFirst()) {
            int i = a.getInt(0);
            a.close();
            if (i > 0) {
                AppMethodBeat.o(1462);
                return i;
            }
            AppMethodBeat.o(1462);
            return 0;
        }
        a.close();
        AppMethodBeat.o(1462);
        return 0;
    }

    public final bt duu() {
        AppMethodBeat.i(1463);
        Cursor a = this.bSd.a("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.o(1463);
            return null;
        } else if (a.moveToFirst()) {
            bt btVar = new bt();
            btVar.d(a);
            a.close();
            AppMethodBeat.o(1463);
            return btVar;
        } else {
            a.close();
            AppMethodBeat.o(1463);
            return null;
        }
    }

    public final Cursor xm(int i) {
        AppMethodBeat.i(1464);
        Cursor rawQuery = this.bSd.rawQuery("SELECT * FROM " + getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + i, null);
        AppMethodBeat.o(1464);
        return rawQuery;
    }

    public final void QT(String str) {
        AppMethodBeat.i(1465);
        int delete = this.bSd.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            doNotify();
        }
        ab.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = ".concat(String.valueOf(delete)));
        AppMethodBeat.o(1465);
    }

    public final void axQ() {
        AppMethodBeat.i(1466);
        this.bSd.delete(getTableName(), null, null);
        AppMethodBeat.o(1466);
    }

    public final boolean a(bt btVar) {
        AppMethodBeat.i(1467);
        if (btVar == null) {
            ab.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            AppMethodBeat.o(1467);
            return false;
        } else if (super.b((c) btVar)) {
            anF(btVar.xDa);
            AppMethodBeat.o(1467);
            return true;
        } else {
            AppMethodBeat.o(1467);
            return false;
        }
    }

    public final bt[] et(String str, int i) {
        AppMethodBeat.i(1468);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
            AppMethodBeat.o(1468);
            return null;
        }
        Cursor a = this.bSd.a("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + bo.vA(str) + "' order by createTime DESC limit " + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            bt btVar = new bt();
            btVar.d(a);
            arrayList.add(btVar);
        }
        a.close();
        if (arrayList.size() == 0) {
            AppMethodBeat.o(1468);
            return null;
        }
        bt[] btVarArr = (bt[]) arrayList.toArray(new bt[arrayList.size()]);
        AppMethodBeat.o(1468);
        return btVarArr;
    }

    public final bt[] apY(String str) {
        AppMethodBeat.i(1469);
        ab.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor a = this.bSd.a("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + bo.vA(str) + "' order by createtime DESC limit 3", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            bt btVar = new bt();
            btVar.d(a);
            arrayList.add(btVar);
        }
        a.close();
        if (arrayList.size() == 0) {
            AppMethodBeat.o(1469);
            return null;
        }
        bt[] btVarArr = (bt[]) arrayList.toArray(new bt[arrayList.size()]);
        AppMethodBeat.o(1469);
        return btVarArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long QV(String str) {
        long j;
        long anT;
        AppMethodBeat.i(1470);
        if (str != null) {
            bt duu = ((bu) ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOn()).duu();
            if (duu != null) {
                j = duu.field_createtime + 1;
                anT = bo.anT();
                if (j <= anT) {
                    AppMethodBeat.o(1470);
                    return j;
                }
                AppMethodBeat.o(1470);
                return anT;
            }
        }
        j = 0;
        anT = bo.anT();
        if (j <= anT) {
        }
    }
}
