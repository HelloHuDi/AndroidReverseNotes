package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends j<r> {
    public static final String[] fnj = new String[]{j.a(r.ccO, "OfflineOrderStatus")};
    public e bSd;

    static {
        AppMethodBeat.i(43442);
        AppMethodBeat.o(43442);
    }

    public a(e eVar) {
        super(eVar, r.ccO, "OfflineOrderStatus", null);
        this.bSd = eVar;
    }

    public final r bXo() {
        int i = 1;
        r rVar = null;
        AppMethodBeat.i(43435);
        ab.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", Integer.valueOf(bXq()), bXp());
        Cursor a = this.bSd.a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.o(43435);
        } else {
            a.moveToFirst();
            if (a.isAfterLast()) {
                i = 0;
            }
            if (i != 0) {
                rVar = new r();
                rVar.d(a);
            }
            a.close();
            if (rVar != null) {
                ab.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + rVar.field_status);
            } else {
                ab.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
            }
            AppMethodBeat.o(43435);
        }
        return rVar;
    }

    private boolean b(r rVar) {
        boolean z = true;
        AppMethodBeat.i(43436);
        Cursor a = this.bSd.a("select * from OfflineOrderStatus where reqkey=?", new String[]{rVar.field_reqkey}, 2);
        if (a == null) {
            AppMethodBeat.o(43436);
            return false;
        }
        a.moveToFirst();
        if (a.isAfterLast()) {
            z = false;
        }
        a.close();
        AppMethodBeat.o(43436);
        return z;
    }

    public final r TY(String str) {
        r rVar = null;
        AppMethodBeat.i(43437);
        Cursor a = this.bSd.a("select * from OfflineOrderStatus where reqkey=?", new String[]{str}, 2);
        if (a == null) {
            AppMethodBeat.o(43437);
        } else {
            a.moveToFirst();
            ab.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + a.isAfterLast());
            if (!a.isAfterLast()) {
                rVar = new r();
                rVar.d(a);
            }
            a.close();
            AppMethodBeat.o(43437);
        }
        return rVar;
    }

    public final void c(r rVar) {
        AppMethodBeat.i(43438);
        if (rVar.field_reqkey == null) {
            ab.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
            AppMethodBeat.o(43438);
        } else if (b(rVar)) {
            ab.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", rVar.field_reqkey, Integer.valueOf(rVar.field_status));
            c(rVar, new String[0]);
            AppMethodBeat.o(43438);
        } else {
            ab.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", rVar.field_reqkey, Integer.valueOf(rVar.field_status));
            b((c) rVar);
            AppMethodBeat.o(43438);
        }
    }

    public final void TZ(String str) {
        AppMethodBeat.i(43439);
        r TY = TY(str);
        if (TY != null) {
            TY.field_status = -1;
        } else {
            TY = new r();
            TY.field_reqkey = str;
            TY.field_status = -1;
        }
        c(TY);
        AppMethodBeat.o(43439);
    }

    public final String bXp() {
        AppMethodBeat.i(43440);
        Cursor a = this.bSd.a(String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[]{"OfflineOrderStatus", "rowid", Integer.valueOf(3)}), null, 2);
        String str = "";
        if (a == null) {
            ab.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
        } else {
            int i = 0;
            while (a.moveToNext()) {
                int i2 = i + 1;
                if (i2 > 3) {
                    break;
                }
                for (i = 0; i < a.getColumnCount(); i++) {
                    str = str + a.getColumnName(i) + ": " + a.getString(i) + ", ";
                }
                str = str + ";";
                i = i2;
            }
            a.close();
        }
        AppMethodBeat.o(43440);
        return str;
    }

    public final int bXq() {
        int i = 0;
        AppMethodBeat.i(43441);
        Cursor a = this.bSd.a(String.format("SELECT COUNT(*) FROM %s;", new Object[]{"OfflineOrderStatus"}), null, 2);
        if (a == null) {
            ab.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
        } else {
            if (a.moveToNext() && a.getColumnCount() > 0) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.o(43441);
        return i;
    }
}
