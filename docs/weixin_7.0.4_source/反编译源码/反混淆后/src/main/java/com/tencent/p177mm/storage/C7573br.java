package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C6398g;
import com.tencent.p177mm.p213cd.C6398g.C1361a;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6978k;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5140bq.C5139a;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.br */
public final class C7573br extends C7296k implements C1361a, C6978k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private C4927e bSd = null;

    public C7573br(C7480h c7480h) {
        this.bSd = c7480h;
    }

    /* renamed from: a */
    public final int mo4744a(C6398g c6398g) {
        this.bSd = c6398g;
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    /* renamed from: RA */
    public final C5140bq mo15356RA(String str) {
        C5140bq c5140bq = null;
        AppMethodBeat.m2504i(1451);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(1451);
        } else {
            C5140bq c5140bq2 = new C5140bq();
            Cursor a = this.bSd.mo10105a("role_info", null, "name LIKE ?", new String[]{"%".concat(String.valueOf(str))}, null, null, null, 2);
            if (a.moveToFirst()) {
                c5140bq2.mo10557d(a);
                c5140bq = c5140bq2;
            }
            a.close();
            AppMethodBeat.m2505o(1451);
        }
        return c5140bq;
    }

    private C5140bq apU(String str) {
        C5140bq c5140bq = null;
        AppMethodBeat.m2504i(1452);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        C5140bq c5140bq2 = new C5140bq();
        Cursor a = this.bSd.mo10105a("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            c5140bq2.mo10557d(a);
            c5140bq = c5140bq2;
        }
        a.close();
        AppMethodBeat.m2505o(1452);
        return c5140bq;
    }

    public final List<C5140bq> bOJ() {
        AppMethodBeat.m2504i(1453);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.mo10105a("role_info", null, "int_reserved1=1", null, null, null, null, 2);
        while (a.moveToNext()) {
            C5140bq c5140bq = new C5140bq();
            c5140bq.mo10557d(a);
            linkedList.add(c5140bq);
        }
        a.close();
        AppMethodBeat.m2505o(1453);
        return linkedList;
    }

    public final boolean has(String str) {
        AppMethodBeat.m2504i(1455);
        C5140bq RA = mo15356RA(new C5139a(str).apT(""));
        if (RA == null || !str.equals(RA.name)) {
            AppMethodBeat.m2505o(1455);
            return false;
        }
        AppMethodBeat.m2505o(1455);
        return true;
    }

    /* renamed from: cE */
    public final void mo15359cE(String str, int i) {
        AppMethodBeat.m2504i(1456);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.m2505o(1456);
            return;
        }
        if (apU(str) == null) {
            m13359a(new C5140bq(str, true, i));
            C4990ab.m7410d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(1456);
    }

    /* renamed from: aT */
    public final void mo15357aT(String str, boolean z) {
        AppMethodBeat.m2504i(1457);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.m2505o(1457);
            return;
        }
        C5140bq apU = apU(str);
        if (apU == null) {
            m13359a(new C5140bq(str, z, 2));
            C4990ab.m7410d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1457);
            return;
        }
        apU.setEnable(z);
        apU.bJt = 4;
        m13360b(apU);
        AppMethodBeat.m2505o(1457);
    }

    /* renamed from: e */
    public final void mo15361e(String str, boolean z, boolean z2) {
        int i = 2;
        AppMethodBeat.m2504i(1458);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            AppMethodBeat.m2505o(1458);
            return;
        }
        C5140bq apU = apU(str);
        if (apU == null) {
            m13359a(new C5140bq(str, z, 2));
            C4990ab.m7410d("MicroMsg.RoleStorage", "insert new role, user=".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(1458);
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
        m13360b(apU);
        AppMethodBeat.m2505o(1458);
    }

    /* renamed from: b */
    private void m13360b(C5140bq c5140bq) {
        AppMethodBeat.m2504i(1459);
        ContentValues Hl = c5140bq.mo10556Hl();
        if (Hl.size() > 0) {
            int update = this.bSd.update("role_info", Hl, "name like ?", new String[]{c5140bq.name});
            C4990ab.m7410d("MicroMsg.RoleStorage", "update role info, name=" + c5140bq.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
        AppMethodBeat.m2505o(1459);
    }

    public final void delete(String str) {
        AppMethodBeat.m2504i(1460);
        Assert.assertTrue(str.length() > 0);
        int delete = this.bSd.delete("role_info", "name=?", new String[]{String.valueOf(str)});
        C4990ab.m7410d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
        AppMethodBeat.m2505o(1460);
    }

    /* renamed from: a */
    private void m13359a(C5140bq c5140bq) {
        AppMethodBeat.m2504i(1454);
        c5140bq.bJt = C44697b.CTRL_INDEX;
        ContentValues Hl = c5140bq.mo10556Hl();
        if (Hl.size() > 0 && this.bSd.insert("role_info", "id", Hl) != 0) {
            doNotify();
        }
        AppMethodBeat.m2505o(1454);
    }
}
