package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.cd.g.a;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class br extends k implements a, com.tencent.mm.plugin.messenger.foundation.a.a.k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private e bSd = null;

    public br(h hVar) {
        this.bSd = hVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    public final bq RA(String str) {
        bq bqVar = null;
        AppMethodBeat.i(1451);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(1451);
        } else {
            bq bqVar2 = new bq();
            Cursor a = this.bSd.a("role_info", null, "name LIKE ?", new String[]{"%".concat(String.valueOf(str))}, null, null, null, 2);
            if (a.moveToFirst()) {
                bqVar2.d(a);
                bqVar = bqVar2;
            }
            a.close();
            AppMethodBeat.o(1451);
        }
        return bqVar;
    }

    private bq apU(String str) {
        bq bqVar = null;
        AppMethodBeat.i(1452);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        bq bqVar2 = new bq();
        Cursor a = this.bSd.a("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bqVar2.d(a);
            bqVar = bqVar2;
        }
        a.close();
        AppMethodBeat.o(1452);
        return bqVar;
    }

    public final List<bq> bOJ() {
        AppMethodBeat.i(1453);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
        while (a.moveToNext()) {
            bq bqVar = new bq();
            bqVar.d(a);
            linkedList.add(bqVar);
        }
        a.close();
        AppMethodBeat.o(1453);
        return linkedList;
    }

    public final boolean has(String str) {
        AppMethodBeat.i(1455);
        bq RA = RA(new bq.a(str).apT(""));
        if (RA == null || !str.equals(RA.name)) {
            AppMethodBeat.o(1455);
            return false;
        }
        AppMethodBeat.o(1455);
        return true;
    }

    public final void cE(String str, int i) {
        AppMethodBeat.i(1456);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.o(1456);
            return;
        }
        if (apU(str) == null) {
            a(new bq(str, true, i));
            ab.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(1456);
    }

    public final void aT(String str, boolean z) {
        AppMethodBeat.i(1457);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.o(1457);
            return;
        }
        bq apU = apU(str);
        if (apU == null) {
            a(new bq(str, z, 2));
            ab.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
            AppMethodBeat.o(1457);
            return;
        }
        apU.setEnable(z);
        apU.bJt = 4;
        b(apU);
        AppMethodBeat.o(1457);
    }

    public final void e(String str, boolean z, boolean z2) {
        int i = 2;
        AppMethodBeat.i(1458);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.o(1458);
            return;
        }
        bq apU = apU(str);
        if (apU == null) {
            a(new bq(str, z, 2));
            ab.d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
            AppMethodBeat.o(1458);
            return;
        }
        apU.setEnable(z);
        if (z2) {
            int i2 = apU.status;
            if (!z2) {
                i = 0;
            }
            apU.status = i | i2;
        } else {
            apU.status &= -3;
        }
        apU.bJt = 4;
        b(apU);
        AppMethodBeat.o(1458);
    }

    private void b(bq bqVar) {
        AppMethodBeat.i(1459);
        ContentValues Hl = bqVar.Hl();
        if (Hl.size() > 0) {
            int update = this.bSd.update("role_info", Hl, "name like ?", new String[]{bqVar.name});
            ab.d("MicroMsg.RoleStorage", "update role info, name=" + bqVar.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
        AppMethodBeat.o(1459);
    }

    public final void delete(String str) {
        AppMethodBeat.i(1460);
        Assert.assertTrue(str.length() > 0);
        int delete = this.bSd.delete("role_info", "name=?", new String[]{String.valueOf(str)});
        ab.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
        AppMethodBeat.o(1460);
    }

    private void a(bq bqVar) {
        AppMethodBeat.i(1454);
        bqVar.bJt = b.CTRL_INDEX;
        ContentValues Hl = bqVar.Hl();
        if (Hl.size() > 0 && this.bSd.insert("role_info", "id", Hl) != 0) {
            doNotify();
        }
        AppMethodBeat.o(1454);
    }
}
