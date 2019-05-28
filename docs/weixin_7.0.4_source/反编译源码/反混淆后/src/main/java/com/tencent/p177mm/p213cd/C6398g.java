package com.tencent.p177mm.p213cd;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C1369i.C1368a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.cd.g */
public final class C6398g implements C4927e {
    private static String ybL = "";
    public int field_MARK_CURSOR_CHECK_IGNORE;
    public boolean vcA;
    public C7480h ybK;
    public Map<String, C1369i> ybM;
    public Queue<C1361a> ybN;
    public C6395f ybk;

    /* renamed from: com.tencent.mm.cd.g$a */
    public interface C1361a {
        /* renamed from: a */
        int mo4744a(C6398g c6398g);

        String getTableName();
    }

    public final void closeDB() {
        AppMethodBeat.m2504i(59088);
        ybL = C5046bo.dpG().toString();
        if (this.ybk != null) {
            this.ybk.close();
            this.ybk = null;
        }
        AppMethodBeat.m2505o(59088);
    }

    public final boolean dpU() {
        AppMethodBeat.m2504i(59089);
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7413e("MicroMsg.MemoryStorage", "memory db is close [%s]", ybL);
            AppMethodBeat.m2505o(59089);
            return true;
        }
        AppMethodBeat.m2505o(59089);
        return false;
    }

    public final int aqv(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(59090);
        if (!this.vcA) {
            AppMethodBeat.m2505o(59090);
            return -4;
        } else if (this.ybK == null || this.ybK.inTransaction()) {
            C4990ab.m7410d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
            AppMethodBeat.m2505o(59090);
            return -3;
        } else {
            try {
                if (C6395f.m10547a(this.ybk, str)) {
                    this.ybk.execSQL("drop table ".concat(String.valueOf(str)));
                    C4990ab.m7417i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", str);
                }
                Cursor a = this.ybK.mo10104a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
                if (a != null) {
                    if (a.getCount() == 1) {
                        a.moveToFirst();
                        str2 = a.getString(0);
                    }
                    a.close();
                }
                if (str2 == null) {
                    C4990ab.m7420w("MicroMsg.MemoryStorage", "diskDB has not this table !");
                    AppMethodBeat.m2505o(59090);
                    return -1;
                }
                this.ybk.execSQL(str2);
                this.ybk.execSQL("insert into " + str + " select * from old." + str);
                C4990ab.m7411d("MicroMsg.MemoryStorage", "copy table %s success", str);
                AppMethodBeat.m2505o(59090);
                return 0;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MemoryStorage", e, "copy table failed with exception.\n", new Object[0]);
                AppMethodBeat.m2505o(59090);
                return -2;
            }
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        AppMethodBeat.m2504i(59091);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        int delete;
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.m2505o(59091);
                return -1;
            }
            delete = this.ybK.delete(str, str2, strArr);
            AppMethodBeat.m2505o(59091);
            return delete;
        }
        C1369i c1369i = (C1369i) this.ybM.get(str);
        C1368a c1368a = new C1368a();
        c1368a.xBj = 5;
        c1368a.ycf = str2;
        c1368a.mo4752T(strArr);
        c1369i.mo4753b(c1368a);
        delete = this.ybk.delete(str, str2, strArr);
        AppMethodBeat.m2505o(59091);
        return delete;
    }

    /* renamed from: hY */
    public final boolean mo10108hY(String str, String str2) {
        AppMethodBeat.m2504i(59092);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.m2505o(59092);
                return false;
            }
            this.ybK.mo10108hY(str2, str);
            AppMethodBeat.m2505o(59092);
            return true;
        }
        C1369i c1369i = (C1369i) this.ybM.get(str);
        C1368a c1368a = new C1368a();
        c1368a.xBj = 1;
        c1368a.sql = str2;
        c1369i.mo4753b(c1368a);
        this.ybk.execSQL(str2);
        AppMethodBeat.m2505o(59092);
        return true;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.m2504i(59093);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        long insert;
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.m2505o(59093);
                return -1;
            }
            insert = this.ybK.insert(str, str2, contentValues);
            AppMethodBeat.m2505o(59093);
            return insert;
        }
        C1369i c1369i = (C1369i) this.ybM.get(str);
        C1368a c1368a = new C1368a();
        c1368a.xBj = 2;
        c1368a.xDc = str2;
        c1368a.values = new ContentValues(contentValues);
        c1369i.mo4753b(c1368a);
        insert = this.ybk.insert(str, str2, contentValues);
        AppMethodBeat.m2505o(59093);
        return insert;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.m2504i(59094);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        long replace;
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.m2505o(59094);
                return -1;
            }
            replace = this.ybK.replace(str, str2, contentValues);
            AppMethodBeat.m2505o(59094);
            return replace;
        }
        C1369i c1369i = (C1369i) this.ybM.get(str);
        C1368a c1368a = new C1368a();
        c1368a.xBj = 4;
        c1368a.xDc = str2;
        c1368a.values = new ContentValues(contentValues);
        c1369i.mo4753b(c1368a);
        replace = this.ybk.replace(str, str2, contentValues);
        AppMethodBeat.m2505o(59094);
        return replace;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.m2504i(59095);
        Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(str)), this.ybM.containsKey(str));
        int update;
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", str, ybL);
            if (this.ybK == null || !this.ybK.isOpen()) {
                AppMethodBeat.m2505o(59095);
                return -1;
            }
            update = this.ybK.update(str, contentValues, str2, strArr);
            AppMethodBeat.m2505o(59095);
            return update;
        }
        C1369i c1369i = (C1369i) this.ybM.get(str);
        C1368a c1368a = new C1368a();
        c1368a.xBj = 3;
        c1368a.ycf = str2;
        c1368a.values = new ContentValues(contentValues);
        c1368a.mo4752T(strArr);
        c1369i.mo4753b(c1368a);
        update = this.ybk.update(str, contentValues, str2, strArr);
        AppMethodBeat.m2505o(59095);
        return update;
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(59096);
        Cursor dvo;
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", str, ybL);
            dvo = C6394d.dvo();
            AppMethodBeat.m2505o(59096);
            return dvo;
        }
        dvo = this.ybk.mo14613a(str, strArr, str2, strArr2, str3, str4, str5, 0);
        AppMethodBeat.m2505o(59096);
        return dvo;
    }

    /* renamed from: a */
    public final Cursor mo10105a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        AppMethodBeat.m2504i(59097);
        Cursor query = query(str, strArr, str2, strArr2, str3, str4, str5);
        AppMethodBeat.m2505o(59097);
        return query;
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.m2504i(59098);
        Cursor dvo;
        if (this.ybk == null || !this.ybk.isOpen()) {
            C4990ab.m7421w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", str, ybL);
            dvo = C6394d.dvo();
            AppMethodBeat.m2505o(59098);
            return dvo;
        }
        dvo = this.ybk.mo14612a(str, strArr, 0);
        AppMethodBeat.m2505o(59098);
        return dvo;
    }

    /* renamed from: a */
    public final Cursor mo10104a(String str, String[] strArr, int i) {
        AppMethodBeat.m2504i(59099);
        Cursor rawQuery = rawQuery(str, strArr);
        AppMethodBeat.m2505o(59099);
        return rawQuery;
    }
}
