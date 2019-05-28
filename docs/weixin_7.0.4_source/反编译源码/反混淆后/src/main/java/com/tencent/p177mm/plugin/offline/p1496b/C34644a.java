package com.tencent.p177mm.plugin.offline.p1496b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.offline.p478a.C21404r;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.offline.b.a */
public final class C34644a extends C7563j<C21404r> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C21404r.ccO, "OfflineOrderStatus")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(43442);
        AppMethodBeat.m2505o(43442);
    }

    public C34644a(C4927e c4927e) {
        super(c4927e, C21404r.ccO, "OfflineOrderStatus", null);
        this.bSd = c4927e;
    }

    public final C21404r bXo() {
        int i = 1;
        C21404r c21404r = null;
        AppMethodBeat.m2504i(43435);
        C4990ab.m7417i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", Integer.valueOf(bXq()), bXp());
        Cursor a = this.bSd.mo10104a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(43435);
        } else {
            a.moveToFirst();
            if (a.isAfterLast()) {
                i = 0;
            }
            if (i != 0) {
                c21404r = new C21404r();
                c21404r.mo8995d(a);
            }
            a.close();
            if (c21404r != null) {
                C4990ab.m7416i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + c21404r.field_status);
            } else {
                C4990ab.m7416i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
            }
            AppMethodBeat.m2505o(43435);
        }
        return c21404r;
    }

    /* renamed from: b */
    private boolean m56840b(C21404r c21404r) {
        boolean z = true;
        AppMethodBeat.m2504i(43436);
        Cursor a = this.bSd.mo10104a("select * from OfflineOrderStatus where reqkey=?", new String[]{c21404r.field_reqkey}, 2);
        if (a == null) {
            AppMethodBeat.m2505o(43436);
            return false;
        }
        a.moveToFirst();
        if (a.isAfterLast()) {
            z = false;
        }
        a.close();
        AppMethodBeat.m2505o(43436);
        return z;
    }

    /* renamed from: TY */
    public final C21404r mo55234TY(String str) {
        C21404r c21404r = null;
        AppMethodBeat.m2504i(43437);
        Cursor a = this.bSd.mo10104a("select * from OfflineOrderStatus where reqkey=?", new String[]{str}, 2);
        if (a == null) {
            AppMethodBeat.m2505o(43437);
        } else {
            a.moveToFirst();
            C4990ab.m7416i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + a.isAfterLast());
            if (!a.isAfterLast()) {
                c21404r = new C21404r();
                c21404r.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(43437);
        }
        return c21404r;
    }

    /* renamed from: c */
    public final void mo55239c(C21404r c21404r) {
        AppMethodBeat.m2504i(43438);
        if (c21404r.field_reqkey == null) {
            C4990ab.m7412e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
            AppMethodBeat.m2505o(43438);
        } else if (m56840b(c21404r)) {
            C4990ab.m7417i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", c21404r.field_reqkey, Integer.valueOf(c21404r.field_status));
            mo10103c(c21404r, new String[0]);
            AppMethodBeat.m2505o(43438);
        } else {
            C4990ab.m7417i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", c21404r.field_reqkey, Integer.valueOf(c21404r.field_status));
            mo10101b((C4925c) c21404r);
            AppMethodBeat.m2505o(43438);
        }
    }

    /* renamed from: TZ */
    public final void mo55235TZ(String str) {
        AppMethodBeat.m2504i(43439);
        C21404r TY = mo55234TY(str);
        if (TY != null) {
            TY.field_status = -1;
        } else {
            TY = new C21404r();
            TY.field_reqkey = str;
            TY.field_status = -1;
        }
        mo55239c(TY);
        AppMethodBeat.m2505o(43439);
    }

    public final String bXp() {
        AppMethodBeat.m2504i(43440);
        Cursor a = this.bSd.mo10104a(String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[]{"OfflineOrderStatus", "rowid", Integer.valueOf(3)}), null, 2);
        String str = "";
        if (a == null) {
            C4990ab.m7412e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
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
        AppMethodBeat.m2505o(43440);
        return str;
    }

    public final int bXq() {
        int i = 0;
        AppMethodBeat.m2504i(43441);
        Cursor a = this.bSd.mo10104a(String.format("SELECT COUNT(*) FROM %s;", new Object[]{"OfflineOrderStatus"}), null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
        } else {
            if (a.moveToNext() && a.getColumnCount() > 0) {
                i = a.getInt(0);
            }
            a.close();
        }
        AppMethodBeat.m2505o(43441);
        return i;
    }
}
